package main.java.com.xfherun.jmci.swing_util.utils;


import java.awt.Color;
import java.awt.Font;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;

public class SwingUtil {
    private static AffineTransform atf = new AffineTransform();

    private static FontRenderContext frc = new FontRenderContext(atf, true,
            true);

    public static int getStringHeight(String str, Font font) {
        if (str == null || str.isEmpty() || font == null) {
            return 0;
        }
        return (int) font.getStringBounds(str, frc).getWidth();

    }

    public static int getStringWidth(String str, Font font) {
        if (str == null || str.isEmpty() || font == null) {
            return 0;
        }
        return (int) font.getStringBounds(str, frc).getWidth() + 16;
    }

    public static Color getColorFromHex(String hex) {
        if (hex == null || hex.length() != 7) {
            try {
                throw new Exception("不能转换这种类型的颜色");
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        int r = Integer.valueOf(hex.substring(1, 3), 16);
        int g = Integer.valueOf(hex.substring(3, 5), 16);
        int b = Integer.valueOf(hex.substring(5), 16);
        return new Color(r, g, b);
    }

}