package main.java.com.xfherun.jmci.swing_util.button.i;

import java.awt.event.KeyListener;

public interface KeyEvent {
    default void inputData(java.awt.event.KeyEvent event) {}
    default void keyDown(java.awt.event.KeyEvent event) {}
    default void keyUp(java.awt.event.KeyEvent event) {}
}
