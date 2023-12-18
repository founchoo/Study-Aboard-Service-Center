package com.wt6.sasc.util;

import com.wt6.sasc.entity.Profile;
import com.wt6.sasc.entity.Tech;

import java.util.ArrayList;
import java.util.List;

public class Constants {
    private static final List<Profile> PROFILES = new ArrayList<>();

    public static List<Profile> getProfiles() {
        if (PROFILES.isEmpty()) {
            for (int i = 1; i <= 4; i++) {
                PROFILES.add(new Profile(
                        "image/dev/founchoo.jpg",
                        String.format("Example Name %s", i),
                        String.format("example_name_%s@email.com", i),
                        String.format("Intro %s", i),
                        new ArrayList<>() {
                            {
                                add("Responsibility 1");
                                add("Responsibility 2");
                                add("Responsibility 3");
                            }
                        }));
            }
        }
        return PROFILES;
    }

    public static final List<Tech> TECHS = new ArrayList<>() {{
        add(new Tech("Bootstrap", "image/tech/Bootstrap.png", "https://getbootstrap.com/"));
        add(new Tech("Material Design Bootstrap", "image/tech/MDB.png", "https://mdbootstrap.com/"));
        add(new Tech("Spring Boot", "image/tech/SpringBoot.png", "https://spring.io/projects/spring-boot"));
        add(new Tech("MySQL", "image/tech/MySQL.png", "https://www.mysql.com/"));
        add(new Tech("Tomcat", "image/tech/Tomcat.png", "https://tomcat.apache.org/"));
        add(new Tech("HTML", "image/tech/HTML.png", "https://www.w3.org/html/"));
        add(new Tech("CSS", "image/tech/CSS.png", "https://www.w3.org/Style/CSS/Overview.en.html"));
        add(new Tech("JavaScript", "image/tech/JS.png", "https://www.javascript.com/"));
        add(new Tech("IDEA", "image/tech/IDEA.png", "https://www.jetbrains.com/idea/"));
        add(new Tech("Baota", "image/tech/Baota.png", "https://www.bt.cn/"));
        add(new Tech("HUAWEI", "image/tech/HUAWEI.png", "https://www.huawei.com/"));
        add(new Tech("Stackoverflow", "image/tech/StackOverflow.png", "https://stackoverflow.com/"));
    }};

    public static final String COLOR_STRING =
            "000 黑色," +
                    "011 黑色," +
                    "110 黑色," +
                    "001 黑色," +
                    "100 黑色," +
                    "111 黑色," +
                    "101 黑色," +
                    "010 黑色," +
                    "544 浅粉色," +
                    "533 粉色," +
                    "534 浅粉色," +
                    "523 粉色," +
                    "535 浅粉色," +
                    "524 粉色," +
                    "513 深粉色," +
                    "525 粉色," +
                    "514 深粉色," +
                    "503 深粉色," +
                    "515 深粉色," +
                    "504 深粉色," +
                    "554 白色," +
                    "555 白色," +
                    "545 白色," +
                    "222 灰色," +
                    "333 灰色," +
                    "444 灰色," +
                    "200 深红色," +
                    "310 深红色," +
                    "201 深红色," +
                    "300 深红色," +
                    "311 深红色," +
                    "410 红色," +
                    "520 浅红色," +
                    "202 深红色," +
                    "301 深红色," +
                    "400 红色," +
                    "411 红色," +
                    "510 红色," +
                    "312 浅红色," +
                    "521 浅红色," +
                    "401 红色," +
                    "500 红色," +
                    "511 红色," +
                    "302 浅红色," +
                    "412 浅红色," +
                    "522 浅红色," +
                    "501 红色," +
                    "402 浅红色," +
                    "512 浅红色," +
                    "502 浅红色," +
                    "440 浅橙色," +
                    "430 深橙色," +
                    "441 浅橙色," +
                    "420 深橙色," +
                    "431 深橙色," +
                    "530 橙色," +
                    "442 浅橙色," +
                    "421 深橙色," +
                    "432 深橙色," +
                    "531 橙色," +
                    "422 深橙色," +
                    "532 橙色," +
                    "550 黄色," +
                    "540 深黄色," +
                    "551 黄色," +
                    "541 深黄色," +
                    "552 浅黄色," +
                    "542 深黄色," +
                    "553 浅黄色," +
                    "543 浅黄色," +
                    "130 青色," +
                    "230 深青色," +
                    "054 青色," +
                    "131 青色," +
                    "033 深青色," +
                    "231 深青色," +
                    "055 青色," +
                    "132 青色," +
                    "154 浅青色," +
                    "133 深青色," +
                    "232 深青色," +
                    "155 浅青色," +
                    "233 深青色," +
                    "255 浅青色," +
                    "355 浅青色," +
                    "455 浅青色," +
                    "140 青色," +
                    "141 青色," +
                    "120 深青色," +
                    "043 青色," +
                    "142 青色," +
                    "044 深青色," +
                    "121 深青色," +
                    "143 深青色," +
                    "122 深青色," +
                    "144 深青色," +
                    "045 青色," +
                    "225 深青色," +
                    "050 绿色," +
                    "150 绿色," +
                    "051 绿色," +
                    "030 深绿色," +
                    "250 绿色," +
                    "151 绿色," +
                    "052 绿色," +
                    "031 深绿色," +
                    "251 绿色," +
                    "152 绿色," +
                    "053 绿色," +
                    "350 浅绿色," +
                    "032 深绿色," +
                    "252 绿色," +
                    "153 绿色," +
                    "450 浅绿色," +
                    "351 浅绿色," +
                    "253 绿色," +
                    "451 浅绿色," +
                    "352 浅绿色," +
                    "254 绿色," +
                    "452 浅绿色," +
                    "353 浅绿色," +
                    "453 浅绿色," +
                    "354 浅绿色," +
                    "454 浅绿色," +
                    "040 绿色," +
                    "041 绿色," +
                    "020 深绿色," +
                    "240 绿色," +
                    "042 绿色," +
                    "340 深绿色," +
                    "021 深绿色," +
                    "241 绿色," +
                    "341 深绿色," +
                    "022 深绿色," +
                    "242 绿色," +
                    "342 深绿色," +
                    "243 绿色," +
                    "343 深绿色," +
                    "012 深蓝色," +
                    "034 浅蓝色," +
                    "013 深蓝色," +
                    "112 深蓝色," +
                    "035 浅蓝色," +
                    "134 浅蓝色," +
                    "113 深蓝色," +
                    "014 蓝色," +
                    "135 浅蓝色," +
                    "234 浅蓝色," +
                    "015 蓝色," +
                    "114 蓝色," +
                    "235 浅蓝色," +
                    "115 蓝色," +
                    "023 深蓝色," +
                    "002 深蓝色," +
                    "024 蓝色," +
                    "123 蓝色," +
                    "244 浅蓝色," +
                    "145 浅蓝色," +
                    "003 深蓝色," +
                    "102 深蓝色," +
                    "025 蓝色," +
                    "124 蓝色," +
                    "344 浅蓝色," +
                    "245 浅蓝色," +
                    "223 浅蓝色," +
                    "103 深蓝色," +
                    "004 蓝色," +
                    "125 蓝色," +
                    "345 浅蓝色," +
                    "224 浅蓝色," +
                    "005 蓝色," +
                    "104 蓝色," +
                    "105 蓝色," +
                    "212 深紫色," +
                    "213 深紫色," +
                    "334 浅紫色," +
                    "214 深紫色," +
                    "313 紫色," +
                    "335 浅紫色," +
                    "434 浅紫色," +
                    "215 深紫色," +
                    "314 紫色," +
                    "413 紫色," +
                    "435 浅紫色," +
                    "315 紫色," +
                    "414 紫色," +
                    "415 紫色," +
                    "323 浅紫色," +
                    "203 深紫色," +
                    "324 浅紫色," +
                    "423 浅紫色," +
                    "445 浅紫色," +
                    "204 深紫色," +
                    "303 紫色," +
                    "325 浅紫色," +
                    "424 浅紫色," +
                    "205 深紫色," +
                    "304 紫色," +
                    "403 紫色," +
                    "425 浅紫色," +
                    "305 紫色," +
                    "404 紫色," +
                    "405 紫色," +
                    "505 紫色," +
                    "220 深棕色," +
                    "330 浅棕色," +
                    "210 深棕色," +
                    "221 深棕色," +
                    "320 棕色," +
                    "331 浅棕色," +
                    "211 深棕色," +
                    "321 棕色," +
                    "332 浅棕色," +
                    "322 棕色," +
                    "443 浅棕色," +
                    "433 浅棕色 ";
}
