/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package main.java.com.xfherun.jmci.write_to_minecraft;

import java.util.Random;

public class Sleep
{
    private Sleep()
    {
    }

    public static void sleep(int from, int to)
    {
        try
        {
            Thread.sleep(new Random().nextInt(from, to - 1));
        }
        catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }
    }
}
