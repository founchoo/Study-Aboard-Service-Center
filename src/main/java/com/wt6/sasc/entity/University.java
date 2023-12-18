package com.wt6.sasc.entity;

import org.springframework.util.Base64Utils;

import java.util.List;

import static com.wt6.sasc.util.GetColor.getMainHEXString;
import static com.wt6.sasc.util.Image.*;

public class University {

    private int id;
    private String name;
    private int rank;

    private byte[] logoIn;

    private String logoOut;

    private String logoBase64;

    private String majorsIn;

    private List<String> majorsOut;

    private double ielts;

    private int toefl;

    private String bgColor;

    public University(int id, String name, int rank, byte[] logoIn, String majorsIn, double ielts, int toefl) throws Exception {

        this.id = id;
        this.name = name;
        this.rank = rank;
        this.logoIn = logoIn;
        this.logoBase64 = Base64Utils.encodeToString(logoIn);
        this.logoOut = "data:image/png;base64," + logoBase64;
        this.majorsIn = majorsIn;
        if (this.majorsIn.startsWith("[")) {
            this.majorsIn = this.majorsIn.substring(1);
        }
        if (this.majorsIn.endsWith("]")) {
            this.majorsIn = this.majorsIn.substring(0, this.majorsIn.length() - 1);
        }
        this.majorsOut = List.of(this.majorsIn.split(","));
        this.ielts = ielts;
        this.toefl = toefl;

        this.setBgColor();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getRank() {
        return rank;
    }

    public byte[] getLogoIn() {
        return logoIn;
    }

    public String getLogoOut() {
        return logoOut;
    }

    public List<String> getMajorsOut() {
        return majorsOut;
    }

    public double getIelts() {
        return ielts;
    }

    public int getToefl() {
        return toefl;
    }

    public void setIelts(double ielts) {
        this.ielts = ielts;
    }

    public void setToefl(int toefl) {
        this.toefl = toefl;
    }

    public String getBgColor() {
        return bgColor;
    }

    private void setBgColor() throws Exception {
        this.bgColor = getMainHEXString(base64ToBufferedImage(logoBase64));
    }
}
