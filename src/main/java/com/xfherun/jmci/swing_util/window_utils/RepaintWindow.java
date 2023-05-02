package main.java.com.xfherun.jmci.swing_util.window_utils;

import java.awt.*;

public class RepaintWindow {
    private RepaintWindow() {}

    public static void repaint(Container container) {
        container.revalidate();
    }
}
