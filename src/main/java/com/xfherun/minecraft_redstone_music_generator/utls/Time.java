/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package main.java.com.xfherun.minecraft_redstone_music_generator.utls;

import java.util.Date;

public class Time
{
    private Time()
    {
    }

    public static String getTime()
    {
        StringBuilder stringBuilder = new StringBuilder();
        Date date = new Date();
        stringBuilder.append(date.getYear() + 1900).append("-");
        stringBuilder.append(date.getMonth() + 1).append("-");
        stringBuilder.append(date.getDate()).append(" ");
        stringBuilder.append(date.getHours()).append(":");
        stringBuilder.append(date.getMinutes()).append(":");
        stringBuilder.append(date.getSeconds());
        return stringBuilder.toString();
    }
}
