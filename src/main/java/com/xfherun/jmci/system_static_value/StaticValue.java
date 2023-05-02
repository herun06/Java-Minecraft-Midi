/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package main.java.com.xfherun.jmci.system_static_value;

import java.io.File;
import java.util.ArrayList;

public class StaticValue
{
    public static ArrayList<Object[]> throwableList = new ArrayList<>();
    public static ArrayList<String> throwableListString = new ArrayList<>();
    public static String appVersion = "1.0.0.1";
    public static boolean isLoopPlay = false;
    public static ArrayList<File> soundPackageArrayList = new ArrayList<>();
    public static ArrayList<File> loadSoundPackageArrayList = new ArrayList<>();
    public static ArrayList<File> tempLoadSoundPackageArrayList = new ArrayList<>();

    private StaticValue()
    {
    }
}
