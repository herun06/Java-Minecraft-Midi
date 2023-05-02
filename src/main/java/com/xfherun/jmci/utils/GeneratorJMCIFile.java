/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package main.java.com.xfherun.jmci.utils;

import java.util.ArrayList;

public class GeneratorJMCIFile
{
    private GeneratorJMCIFile()
    {
    }

    public static String write(ArrayList<ArrayList<String[]>> mainArrayList)
    {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < mainArrayList.size(); i++)
        {
            stringBuilder.append("[");
            ArrayList<String[]> arrayList = mainArrayList.get(i);
            for (int j = 0; j < arrayList.size(); j++)
            {
                String[] strings = arrayList.get(j);
                StringBuilder builder = new StringBuilder();
                for (int l = 0; l < strings.length; l++)
                {
                    String cmdAndArgs = strings[l];
                    if (l < (strings.length - 1)) builder.append(cmdAndArgs).append(" ");
                    else builder.append(cmdAndArgs);
                }
                String commandAndArgs = builder.toString();
                if (!commandAndArgs.equals("")) stringBuilder.append(commandAndArgs).append("|");
            }
            stringBuilder.append("NONE");
            stringBuilder.append("]").append("\n");
        }



        return stringBuilder.toString().replace("NONE|NONE", "NONE");
    }
}
