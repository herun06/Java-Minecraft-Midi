/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package main.java.com.xfherun.minecraft_redstone_music_generator.utls;

public class ReplaceString
{
    private ReplaceString()
    {
    }

    public static String replaceString(String srcString, String replaceString, String chars)
    {
        StringBuilder stringBuilder = new StringBuilder();
        loop: for (int i = 0; i < srcString.length(); i++)
        {
            char c = srcString.charAt(i);
            for (int j = 0; j < chars.length(); j++)
            {
                char c2 = chars.charAt(j);
                if (c == c2)
                {
                    stringBuilder.append(replaceString);
                    continue loop;
                }
            }
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }
}
