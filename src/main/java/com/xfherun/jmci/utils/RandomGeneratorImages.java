package main.java.com.xfherun.jmci.utils;

import com.xfherun.xflog.XFLog;
import main.java.com.xfherun.jmci.swing_util.utils.SwingUtil;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class RandomGeneratorImages
{
    private static String[] chr = {
            "欢迎来到JMCI编辑器",
            "Hello World!",
            "我是21网络6班的何润",
            "我们是21级的",
            "你知道吗？这个软件是我一个人开发的！",
            "芜湖！！",
            "惊讶~_~！！",
            "这次的版本升级了！！！",
            "纯Java编写",
            "在学校如果看见我穿蓝色春季\n的消防体能训练符, 那就是我！！",
            "Java Swing 有没有了解过？",
            "耗时差不多1个月才打造。",
            "我的梦想是消防员。",
            "它支持将midi音乐文件写入Minecraft喔！？",
            "Hello!",
            ">_<",
            "支持启动Minecraft-forge-1.12.2喔！自带的",
            "O:>",
            "开发作者: xfherun",
            " \" 蓝 \" 朋友",
            "父亲",
            "大理",
            "是心动啊！",
            "花之舞我的最爱",
            "测试人员: oyc",
            "测试人名: 21网络6班 欧永潮",
            "开发人名: 21网络6班 何润",
            "这里还隐藏这一款贪吃蛇喔？！",
            "完善了Minecraft红石音乐生成器哦！！！！",
            "你好啊！！"
    };

    private RandomGeneratorImages()
    {
    }

    public static void randomImage(String outputPath)
    {
        String s = randomString();
        for (int i = 0; i < 10; i++)
        {
            Font font = new Font("微软雅黑", 0, 10);
            int randomX = new Random().nextInt(10, 20);
            int randomY = new Random().nextInt(0, 5);
            int rd = new Random().nextInt(50, 51);
            int width = SwingUtil.getStringWidth(s, font) + 40, height = SwingUtil.getStringHeight(s, font) + 20;
            BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            Graphics2D graphics = bufferedImage.createGraphics();
            graphics.setBackground(new Color(0, 0, 0, 0));
            graphics.setColor(new Color(255, 255, 255, 255));
            graphics.rotate(rd, randomX, (height / 2) + randomY);
            graphics.drawString(s, randomX, (height / 2) + randomY);
            try
            {
                ImageIO.write(bufferedImage, "png", new File(outputPath + "/title_" + i + ".png"));
            }
            catch (Exception e)
            {
                XFLog.warn("这个异常可以忽略", e);
            }
        }
    }

    private static String randomString()
    {
        int randomIndex = new Random().nextInt(0, chr.length);
        return chr[randomIndex];
    }
}
