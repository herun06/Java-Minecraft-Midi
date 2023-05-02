/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package main.java.com.xfherun.jmci.utils;

import com.xfherun.xflog.XFLog;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class CreateUpdateLogFile
{
    private ArrayList<String> nodeList;
    private File saveFile;

    public CreateUpdateLogFile(File logFilePath)
    {
        saveFile = logFilePath;
        nodeList = new ArrayList<>();
    }

    private String appendStyle(Map<String, String> style)
    {
        StringBuilder stringBuilder = new StringBuilder();
        Set<String> strings = style.keySet();
        for (String string : strings)
        {
            String key = string;
            String value = style.get(string);
            stringBuilder.append(key).append(": ").append(value).append(";");
        }
        return stringBuilder.toString();
    }

    public String addTitle(int size, String text, StyleCSS styleCSS)
    {
        String style = styleCSS != null ? appendStyle(styleCSS.getStyle()) : "";
        StringBuilder stringBuilder = new StringBuilder();
        if (size < 1 || size > 6) throw new RuntimeException("非法参数: " + size);
        if (size == 1) stringBuilder.append("<h1 style=\"").append(style).append("\">").append(text).append("</h1>");
        if (size == 2) stringBuilder.append("<h2 style=\"").append(style).append("\">").append(text).append("</h2>");
        if (size == 3) stringBuilder.append("<h3 style=\"").append(style).append("\">").append(text).append("</h3>");
        if (size == 4) stringBuilder.append("<h4 style=\"").append(style).append("\">").append(text).append("</h4>");
        if (size == 5) stringBuilder.append("<h5 style=\"").append(style).append("\">").append(text).append("</h5>");
        if (size == 6) stringBuilder.append("<h6 style=\"").append(style).append("\">").append(text).append("</h6>");
        return stringBuilder.toString();
    }

    public String addSpan(String text, StyleCSS styleCSS)
    {
        String style = styleCSS != null ? appendStyle(styleCSS.getStyle()) : "";
        return "<span style=\"" + style + "\">" + text + "</span>";
    }

    public String addP(String text, StyleCSS styleCSS)
    {
        String style = styleCSS != null ? appendStyle(styleCSS.getStyle()) : "";
        return "<p style=\"" + style + "\">" + text + "</p>";
    }

    public String addOtherDoubleLabel(String labelName, String labelText, String otherAttr, StyleCSS styleCSS)
    {
        String style = styleCSS != null ? appendStyle(styleCSS.getStyle()) : "";
        return "<" + labelName + " style=\"" + style + "\" " + otherAttr + ">" + labelText + "</" + labelName + ">";
    }

    public String addOtherLineLabel(String labelName, String attr, StyleCSS styleCSS)
    {
        String style = styleCSS != null ? appendStyle(styleCSS.getStyle()) : "";
        return "<" + labelName + " style=\"" + style + "\" " + attr + ">";
    }

    public void addCodeToThis(String code)
    {
        nodeList.add(code);
    }

    public String buildHTMLText()
    {
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : nodeList) stringBuilder.append(s);
        return stringBuilder.toString();
    }

    public void writeFile()
    {
        WriteFile.writeStringToFile(saveFile.getAbsolutePath(), buildHTMLText(), "UTF-8");
        XFLog.info("成功将HTML文本写入文件: " + saveFile.getAbsolutePath() + " -> *** ↓\n" + buildHTMLText());
    }
}
