package com.wt6.sasc.controller;

import com.wt6.sasc.entity.University;
import com.wt6.sasc.service.UniversityService;
import com.wt6.sasc.util.Constants;
import org.json.JSONObject;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

import static com.wt6.sasc.util.Constants.*;
import static com.wt6.sasc.util.Http.getResponseBodyAsDocument;

@Controller
public class HomeController {

    private final int uniDataPageSize = 20;

    @Autowired
    private UniversityService universityService;

    @GetMapping(value = "/consultant/send", params = "msg")
    public void handleAIChat(HttpServletRequest req, HttpServletResponse res) throws IOException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://api.brainshop.ai/get?" +
                        "bid=174427&" +
                        "key=f0EEFyySVFke7ymA&" +
                        "uid=brainshop.ai.100149&" +
                        "msg=" + URLEncoder.encode(req.getParameter("msg"), StandardCharsets.UTF_8)))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        var writer = res.getWriter();
        writer.write(new JSONObject(response.body()).getString("cnt"));
        writer.flush();
        writer.close();
    }

    @GetMapping("/bug")
    public ModelAndView bugCompassEduWebData(HttpServletRequest request) throws IOException, InterruptedException, URISyntaxException {
        var md = new ModelAndView("index");
        List<University> universities = new ArrayList<>();
        AtomicInteger id = new AtomicInteger();

        for (int page = 1; page <= 9; page++) {

            Document pageDoc = getResponseBodyAsDocument(
                    "https://www.compassedu.hk/university_0_" + page);
            var list = pageDoc.getElementsByClass("result-list").get(0);
            list.children().forEach((universityItem)->{

                // get university info
                String englishName = universityItem.getElementsByClass("ename line-1").get(0).text();
                String rank = universityItem.getElementsByClass("sort").get(0).text();
                String logo = universityItem.getElementsByTag("img").get(0).attr("src");
                String detailUrl = "https://www.compassedu.hk/" + universityItem.attr("href");
                AtomicInteger ielts = new AtomicInteger(0);
                AtomicInteger toefl = new AtomicInteger(0);

                // get major list
                Document detailDoc;
                try {
                    detailDoc = getResponseBodyAsDocument(detailUrl);
                } catch (IOException | InterruptedException | URISyntaxException e) {
                    throw new RuntimeException(e);
                }
                Elements majors;
                ArrayList<String> majorList = new ArrayList<>();

                try {
                    majors = detailDoc.getElementsByClass("major-list").get(0).
                            getElementsByClass("ename line-1");
                    majors.forEach((major)->{
                        majorList.add(major.text());

                        // get language score
                        String majorUri = "https://www.compassedu.hk" + major.parentNode().attr("href");
                        Document majorDoc;
                        try {
                            majorDoc = getResponseBodyAsDocument(majorUri);
                        } catch (IOException | InterruptedException | URISyntaxException e) {
                            throw new RuntimeException(e);
                        }
                        var langList = majorDoc.getElementsByClass("lang-list").get(0).children();
                        langList.forEach((lang)->{
                            if (Objects.equals(lang.children().get(0).children().get(0).text(), "雅思")) {
                                try {
                                    int ieltsRead = Integer.parseInt(lang.children().get(1).children().get(0).text());
                                    if (ielts.get() == 0 || ieltsRead < ielts.get()) {
                                        ielts.set(ieltsRead);
                                    }
                                } catch (NumberFormatException e) {
                                    // System.out.println("No ielts");
                                }
                            }
                            if (Objects.equals(lang.children().get(0).children().get(0).text(), "托福")) {
                                try {
                                    int toeflRead = Integer.parseInt(lang.children().get(1).children().get(0).text());
                                    if (toefl.get() == 0 || toeflRead < toefl.get()) {
                                        toefl.set(toeflRead);
                                    }
                                } catch (NumberFormatException e) {
                                    // System.out.println("No toefl");
                                }
                            }
                        });
                    });
                } catch (IndexOutOfBoundsException e) {
                    // System.out.println("No major");
                }


                // change database
                University university;
                try {
                    var image = ImageIO.read(new URL(logo));
                    ByteArrayOutputStream bos = new ByteArrayOutputStream();
                    ImageIO.write(image, "png", bos);
                    byte [] data = bos.toByteArray();
                    university = new University(id.get(), englishName, Integer.parseInt(
                            rank.replace("QS排名：", "")), data, majorList.toString(), ielts.get(), toefl.get());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Current id: " + id);
                id.addAndGet(1);
                universities.add(university);
                System.out.println("Current ielts: " + ielts);
                System.out.println("Current toefl: " + toefl);
                universityService.updateUniversity(id.get(), ielts.get(), toefl.get());
                // universityService.addUniversity(university);
            });
        }

        md.addObject("list", universities);
        return md;
    }

    @ResponseBody
    @PostMapping("/getUniversity")
    public List<University> getUniversity(@RequestBody Map<String, Object> lookupRequestObject) {
        return universityService.getUniversityByPageIndex((Integer) lookupRequestObject.get("pageIndex"), uniDataPageSize);
    }

    @GetMapping("/")
    public ModelAndView getIndexPage(HttpServletRequest request) {
        var md = new ModelAndView("index");
        List<University> universities = universityService.getUniversityByPageIndex(0, uniDataPageSize);
        md.addObject("list", universities);
        return md;
    }

    @GetMapping(value = "/evaluation", params = {"type!=-1", "score!=-1"})
    public ModelAndView getEvaluationPage(HttpServletRequest request) {
        var mv = new ModelAndView("evaluation");
        String type = request.getParameter("type");
        if (type == null) {
            type = "Select";
        }
        String score = request.getParameter("score");
        mv.addObject("type", type);
        mv.addObject("score", score);
        return mv;
    }

    @GetMapping(value = "/detail", params = "id")
    public ModelAndView getDetailPage(HttpServletRequest request) {
        String id = request.getParameter("id");
        University university = universityService.getUniversityById(Integer.parseInt(id));
        var md = new ModelAndView("detail");
        md.addObject("university", university);
        return md;
    }

    @GetMapping("/consultant")
    public ModelAndView getConsultant(HttpServletRequest request) {
        return new ModelAndView("consultant");
    }

    @GetMapping("/about")
    public ModelAndView getAbout(HttpServletRequest request) {

        var mv =  new ModelAndView("about");
        mv.addObject("profiles", Constants.getProfiles());
        mv.addObject("techs", TECHS);
        return mv;
    }
}
