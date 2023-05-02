package main.java.com.xfherun.minecraft_redstone_music_generator.user_ui.comp.list;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;

public class BasicScrollBarUIStyle extends BasicScrollBarUI {
    @Override
    protected void configureScrollBarColors() {
        // thumbColor = Color.GRAY;
        // thumbHighlightColor = Color.BLUE;
        // thumbDarkShadowColor = Color.BLACK;
        // thumbLightShadowColor = Color.YELLOW;
        trackColor = Color.black;
        setThumbBounds(0, 0, 3, 10);
        // trackHighlightColor = Color.GREEN;
    }

    @Override
    public Dimension getPreferredSize(JComponent c) {
        c.setPreferredSize(new Dimension(8, 0));
        return super.getPreferredSize(c);
    }

    public void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
        Graphics2D g2 = (Graphics2D) g;
        GradientPaint gp = null;

        if (this.scrollbar.getOrientation() == JScrollBar.VERTICAL) {
            gp = new GradientPaint(0, 0, new Color(80, 80, 80, 255),
                    trackBounds.width, 0, new Color(80, 80, 80, 255));
        }

        if (this.scrollbar.getOrientation() == JScrollBar.HORIZONTAL) {
            gp = new GradientPaint(0, 0, new Color(80, 80, 80, 255),
                    trackBounds.height, 0, new Color(80, 80, 80, 255));
        }
        g2.setPaint(gp);
        g2.fillRect(trackBounds.x, trackBounds.y, 8, trackBounds.height);
        g2.setColor(new Color(108, 108, 108));
        g2.drawRect(trackBounds.x, trackBounds.y, trackBounds.width - 1,
                trackBounds.height - 1);
        if (trackHighlight == BasicScrollBarUI.DECREASE_HIGHLIGHT)
            this.paintDecreaseHighlight(g);
        if (trackHighlight == BasicScrollBarUI.INCREASE_HIGHLIGHT)
            this.paintIncreaseHighlight(g);
    }

    @Override
    protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
        g.translate(thumbBounds.x, thumbBounds.y);
        g.setColor(new Color(230, 230, 250));
        // g.drawRoundRect(0, 0, 5, thumbBounds.height - 1, 5, 5);
        Graphics2D g2 = (Graphics2D) g;
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.addRenderingHints(rh);
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));
        g2.setPaint(new GradientPaint(c.getWidth() / 2, 1, new Color(140, 140, 140, 255),
                c.getWidth() / 2, c.getHeight(), new Color(140, 140, 140, 255)));
        g2.fillRoundRect(0, 0, 8, thumbBounds.height - 1, 4, 4);
    }

    @Override
    protected JButton createIncreaseButton(int orientation) {
        JButton button = new JButton();
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setBorder(null);
        button.setOpaque(true);
        button.setBackground(new Color(138, 138, 138, 255));
        return button;
    }

    @Override
    protected JButton createDecreaseButton(int orientation) {
        JButton button = new JButton();
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setFocusable(false);
        button.setBorder(null);
        button.setOpaque(true);
        button.setBackground(new Color(107, 106, 106, 255));
        return button;
    }
}
