/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package main.java.com.xfherun.jmci.utils;

public class StringMethod
{
    private StringMethod()
    {
    }

    public static String countString(String str, int count)
    {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < count; i++) stringBuilder.append(str);
        return stringBuilder.toString();
    }
}
