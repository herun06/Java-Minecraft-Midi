/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package main.java.com.xfherun.minecraft_redstone_music_generator.utls;

public class StringFormat
{
    private StringFormat()
    {
    }

    public static String stringFormat(String string, String[] args)
    {
        for (int i = 0; i < args.length; i++)
        {
            String res = "{" + i + "}";
            string = string.replace(res, args[i]);
        }
        return string;
    }
}
