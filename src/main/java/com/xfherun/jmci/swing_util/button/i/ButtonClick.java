package main.java.com.xfherun.jmci.swing_util.button.i;

import java.awt.event.MouseEvent;

public interface ButtonClick {
    default void clicked(MouseEvent event) {}
    default void mouseDown(MouseEvent event) {}
    default void mouseUp(MouseEvent event) {}
    default void mouseOver(MouseEvent event) {}
    default void mouseOut(MouseEvent event) {}
    default void mouseDouble(MouseEvent event) {}
    default void mouseRightUp(MouseEvent event) {}
    default void mouseRightDown(MouseEvent event) {}
    default void mouseRightClicked(MouseEvent event) {}
    default void mouseRightDouble(MouseEvent event) {}
}
