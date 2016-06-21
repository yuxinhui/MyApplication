package com.yuxinhui.text.myapplication.Utils;

import android.media.Image;

/**
 * Created by Administrator on 2016/6/17.
 */
public class TeachUtil {
    private Image teacherImg;
    private String teacherName;
    private String teacherContent;

    public TeachUtil() {
    }

    public Image getTeacherImg() {
        return teacherImg;
    }

    public void setTeacherImg(Image teacherImg) {
        this.teacherImg = teacherImg;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherContent() {
        return teacherContent;
    }

    public void setTeacherContent(String teacherContent) {
        this.teacherContent = teacherContent;
    }

    public TeachUtil(String teacherContent, Image teacherImg, String teacherName) {
        this.teacherContent = teacherContent;
        this.teacherImg = teacherImg;
        this.teacherName = teacherName;
    }

    @Override
    public String toString() {
        return "TeachUtil{" +
                "teacherName='" + teacherName + '\'' +
                ", teacherContent='" + teacherContent + '\'' +
                '}';
    }
}
