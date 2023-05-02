/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package test;

import javax.swing.*;

public class Main
{
    public static void main(String[] args)
    {
        if (UIManager.getLookAndFeel().isSupportedLookAndFeel())
        {
            final String platform = UIManager.getSystemLookAndFeelClassName();
            if (!UIManager.getLookAndFeel().getName().equals(platform))
            {
                try
                {
                    UIManager.setLookAndFeel(platform);
                }
                catch (Exception exception)
                {
                    exception.printStackTrace();
                }
            }
            JFileChooser fileChooser = new JFileChooser("./");
            fileChooser.showOpenDialog(null);
        }
    }
}
