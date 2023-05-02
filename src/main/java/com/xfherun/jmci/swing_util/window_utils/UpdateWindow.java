package main.java.com.xfherun.jmci.swing_util.window_utils;

import java.awt.*;

public class UpdateWindow extends Thread {
    private Container parentWindow;

    public UpdateWindow(Container parentWindow) {
        this.parentWindow = parentWindow;
    }

    @Override
    public void run() {
        while (true) {
            if (parentWindow == null || !parentWindow.isVisible()) break;
            parentWindow.repaint();
        }
    }
}
