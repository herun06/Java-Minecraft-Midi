package main.java.com.xfherun.jmci.init;

import com.xfherun.xflog.XFLog;
import main.java.com.xfherun.jmci.piano_data.CurrentPianoInformation;
import main.java.com.xfherun.jmci.user_interface.MainWindow;
import main.java.com.xfherun.jmci.utils.*;
import main.java.com.xfherun.minecraft_redstone_music_generator.utls.StringFormat;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

public class InitFile
{
    private InitFile()
    {
    }

    public static void init()
    {
        XFLog.info("创建文件目录");
        String[] files = new String[]{"cache/home_title_image_flush",
                "cache/jmci",
                "cache/compile_cache/main/resources/compile/python/io",
                "assets/package",
                "run/saves",
                "cache/space",
                "cache/resources_cache/main/resources/run/mods",
                "cache/resources_cache/main/resources/run/resourcepacks",
                "cache/resources_cache/main/resources/run/saves",
                "cache/resources_cache/main/resources/run/close_the_mods",
                "system/update/log/list",
                "soundfont/close_device",
                "cache/cache/main/resources/sound_package",
                "cache/minecraft/.minecraft"
        };

        for (String file : files)
        {
            if (!new File(file).exists())
            {
                File file1 = new File(file);
                boolean mkdirs = file1.mkdirs();
                if (mkdirs) XFLog.info("成功创建文件夹: " + file1.getAbsolutePath());
                else XFLog.info("成功文件夹: " + file1.getAbsolutePath() + " 失败");
            }
            else
            {
                File file1 = new File(file);
                XFLog.info("文件夹: " + file1.getAbsolutePath() + " 已存在, 不用再次创建");
            }
        }

        loadSoundFontFile();
        loadSoundPack();
        initUpdateLog();
    }

    private static void loadSoundFontFile()
    {
        File path = new File("soundfont").getAbsoluteFile();
        XFLog.info("开始加载 SoundFont 文件, 在: " + path + " 文件目录下, 只能加载一个文件, 如果有多个文件只会加载其中的一个, 想更改文件请重启软件");
        File[] paths2 = path.listFiles();
        ArrayList<File> filess = new ArrayList<>();
        for (File file : paths2)
            if (file.isFile())
                if (file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf(".")).equalsIgnoreCase(".sf2"))
                    filess.add(file);
        File[] paths = new File[filess.size()];
        for (int i = 0; i < filess.size(); i++) paths[i] = filess.get(i);
        int length = paths.length;
        if (length == 1) loadSoundFonts(paths[0]);
        else if (length > 1)
        {
            String s = StringFormat.stringFormat("警告: 在目录\"{0}\"下发现多个文件, 这些文件不会全部加载, 只会加载其中一个文件", new String[]{path.getAbsolutePath()});
            XFLog.warn(s);
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, s, "警告", 2);
            loadSoundFonts(paths[0]);
        }
        else XFLog.warn("没有SoundFont文件被加载!!!!!");
    }

    private static void loadSoundFonts(File file)
    {
        XFLog.info("开始加载SoundFont文件: " + file);
        CurrentPianoInformation.currentSoundFontFile = file;
        XFLog.info("文件: " + file + " 加载完毕！");
    }

    private static void initUpdateLog()
    {
        XFLog.info("开始初始化更新日志");
        st();
        XFLog.info("初始化更新日志完毕");
    }

    private static void st()
    {
        /*StyleCSS styleCSS_1 = new StyleCSS();
        StyleCSS styleCSS_2 = new StyleCSS();
        StyleCSS styleCSS_3 = new StyleCSS();

        styleCSS_1.addStyle("text-align", "center");
        styleCSS_1.addStyle("font-size", "50pt");
        styleCSS_2.addStyle("text-align", "center");
        styleCSS_3.addStyle("width", "100%");
        styleCSS_3.addStyle("height", "100%");
        styleCSS_3.addStyle("border", "1px solid gray");
        styleCSS_3.addStyle("text-align", "center");

        {
            CreateUpdateLogFile createUpdateLogFile = new CreateUpdateLogFile(new File("system/update/log/list/2023-4-24.updl").getAbsoluteFile());
            String html = createUpdateLogFile.addOtherDoubleLabel("html",
                    createUpdateLogFile.addOtherDoubleLabel("head", createUpdateLogFile.addOtherLineLabel("meta", "charset=\"UTF-8\"", null), "", null) +
                            createUpdateLogFile.addOtherDoubleLabel("head", createUpdateLogFile.addOtherDoubleLabel("body", createUpdateLogFile.addTitle(1, "更新日志", styleCSS_1) +
                                    createUpdateLogFile.addTitle(3, "时间: 2023-4-24", styleCSS_2) +
                                    createUpdateLogFile.addOtherDoubleLabel("div",
                                            createUpdateLogFile.addOtherLineLabel("br", "", null) +
                                                    createUpdateLogFile.addOtherLineLabel("br", "", null) +
                                                    createUpdateLogFile.addOtherLineLabel("br", "", null) +
                                                    "修复了一些已知的BUG" + createUpdateLogFile.addOtherLineLabel("br", "", null) +
                                                    "完善了Minecraft红石音乐功能" + createUpdateLogFile.addOtherLineLabel("br", "", null) +
                                                    "添加了提取模组的功能" + createUpdateLogFile.addOtherLineLabel("br", "", null) +
                                                    "修复了钢琴播放器的循环播放问题" + createUpdateLogFile.addOtherLineLabel("br", "", null) +
                                                    "新增了钢琴音符特效的问题" + createUpdateLogFile.addOtherLineLabel("br", "", null) +
                                                    "新增了贪吃蛇的游戏" + createUpdateLogFile.addOtherLineLabel("br", "", null) +
                                                    "修改了关于软件的界面" + createUpdateLogFile.addOtherLineLabel("br", "", null) +
                                                    "新增了启动Minecraft-forge-1.12.2" + createUpdateLogFile.addOtherLineLabel("br", "", null) +
                                                    createUpdateLogFile.addOtherLineLabel("br", "", null) +
                                                    createUpdateLogFile.addOtherLineLabel("br", "", null) +
                                                    createUpdateLogFile.addOtherLineLabel("br", "", null)
                                            , "align=\"center\"", styleCSS_3), "", null), "", null)
                    , "lang=\"en\"", null);
            createUpdateLogFile.addCodeToThis(html);
            createUpdateLogFile.writeFile();
        }

        {
            CreateUpdateLogFile createUpdateLogFile = new CreateUpdateLogFile(new File("system/update/log/list/2023-4-24.updl").getAbsoluteFile());
            String html = createUpdateLogFile.addOtherDoubleLabel("html",
                    createUpdateLogFile.addOtherDoubleLabel("head", createUpdateLogFile.addOtherLineLabel("meta", "charset=\"UTF-8\"", null), "", null) +
                            createUpdateLogFile.addOtherDoubleLabel("head", createUpdateLogFile.addOtherDoubleLabel("body", createUpdateLogFile.addTitle(1, "更新日志", styleCSS_1) +
                                    createUpdateLogFile.addTitle(3, "时间: 2023-4-24", styleCSS_2) +
                                    createUpdateLogFile.addOtherDoubleLabel("div",
                                            createUpdateLogFile.addOtherLineLabel("br", "", null) +
                                                    createUpdateLogFile.addOtherLineLabel("br", "", null) +
                                                    createUpdateLogFile.addOtherLineLabel("br", "", null) +
                                                    "新增了播放jmci文件是可以选择SoundFont音色库进行播放" + createUpdateLogFile.addOtherLineLabel("br", "", null) +
                                                    "更新了声音包加载引擎并且提供了声音包的模板" + createUpdateLogFile.addOtherLineLabel("br", "", null) +
                                                    "新增了更新日志的功能" + createUpdateLogFile.addOtherLineLabel("br", "", null) +
                                                    "修复了获取resources下的资源时为null, 造成不必要的麻烦" + createUpdateLogFile.addOtherLineLabel("br", "", null) +
                                                    createUpdateLogFile.addOtherLineLabel("br", "", null) +
                                                    createUpdateLogFile.addOtherLineLabel("br", "", null) +
                                                    createUpdateLogFile.addOtherLineLabel("br", "", null)
                                            , "align=\"center\"", styleCSS_3), "", null), "", null)
                    , "lang=\"en\"", null);
            createUpdateLogFile.addCodeToThis(html);
            createUpdateLogFile.writeFile();
        }

        {
            CreateUpdateLogFile createUpdateLogFile = new CreateUpdateLogFile(new File("system/update/log/list/2023-4-24.updl").getAbsoluteFile());
            String html = createUpdateLogFile.addOtherDoubleLabel("html",
                    createUpdateLogFile.addOtherDoubleLabel("head", createUpdateLogFile.addOtherLineLabel("meta", "charset=\"UTF-8\"", null), "", null) +
                            createUpdateLogFile.addOtherDoubleLabel("head", createUpdateLogFile.addOtherDoubleLabel("body", createUpdateLogFile.addTitle(1, "更新日志", styleCSS_1) +
                                    createUpdateLogFile.addTitle(3, "时间: 2023-4-24", styleCSS_2) +
                                    createUpdateLogFile.addOtherDoubleLabel("div",
                                            createUpdateLogFile.addOtherLineLabel("br", "", null) +
                                                    createUpdateLogFile.addOtherLineLabel("br", "", null) +
                                                    createUpdateLogFile.addOtherLineLabel("br", "", null) +
                                                    "修复了在上使用SoundFont播放时下方的歌曲名和时间不会回位的bug" + createUpdateLogFile.addOtherLineLabel("br", "", null) +
                                                    "修复了默认播放声音方式中添加了还原SoundFont" + createUpdateLogFile.addOtherLineLabel("br", "", null) +
                                                    "修复了更新日志显示时乱码" + createUpdateLogFile.addOtherLineLabel("br", "", null) +
                                                    createUpdateLogFile.addOtherLineLabel("br", "", null) +
                                                    createUpdateLogFile.addOtherLineLabel("br", "", null) +
                                                    createUpdateLogFile.addOtherLineLabel("br", "", null)
                                            , "align=\"center\"", styleCSS_3), "", null), "", null)
                    , "lang=\"en\"", null);
            createUpdateLogFile.addCodeToThis(html);
            createUpdateLogFile.writeFile();
        }*/

        XFLog.debug("删除更新日志下的所有文件");
        File updl = new File("system/update/log/list").getAbsoluteFile();
        File[] files = updl.listFiles();
        for (int i = 0; i < Objects.requireNonNull(files).length; i++)
        {
            File file = files[i];
            file.delete();
            XFLog.info("成功删除更新日志文件: " + file);
        }

        String[] updateLog = {"<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "    <head>\n" +
                "        <meta charset=\"UTF-8\">\n" +
                "        <title>更新日志</title>\n" +
                "    </head>\n" +
                "    <style>\n" +
                "        *\n" +
                "        {\n" +
                "            margin: 0;\n" +
                "            padding: 0;\n" +
                "            border: 0;\n" +
                "            user-select: none;\n" +
                "        }\n" +
                "\n" +
                "        body\n" +
                "        {\n" +
                "            background-color: #2f2f2f;\n" +
                "        }\n" +
                "\n" +
                "        #main\n" +
                "        {\n" +
                "            width: 90%;\n" +
                "            height: 100%;\n" +
                "            border: 2px solid #424242;\n" +
                "            margin: 119px auto;\n" +
                "            border-radius: 10px;\n" +
                "        }\n" +
                "\n" +
                "        h1\n" +
                "        {\n" +
                "            text-align: center;\n" +
                "            color: #eeeeee;\n" +
                "            font-size: 40pt;\n" +
                "        }\n" +
                "\n" +
                "        h3\n" +
                "        {\n" +
                "            text-align: center;\n" +
                "            color: #eeeeee;\n" +
                "            font-size: 10pt;\n" +
                "        }\n" +
                "\n" +
                "        #content\n" +
                "        {\n" +
                "            width: 90%;\n" +
                "            height: 100%;\n" +
                "            border: 2px solid #424242;\n" +
                "            margin: 50px auto;\n" +
                "            border-radius: 10px;\n" +
                "            color: #eeeeee;\n" +
                "        }\n" +
                "\n" +
                "    </style>\n" +
                "    <body>\n" +
                "        <div id=\"main\">\n" +
                "            <br>\n" +
                "            <br>\n" +
                "            <h1>更新日志</h1>\n" +
                "            <br>\n" +
                "            <h3>更新时间: 2023/4-22</h3>\n" +
                "            <div id=\"content\">\n" +
                "                <br>\n" +
                "                <p>&nbsp;&nbsp;&nbsp;修复了一些已知的BUG</p>\n" +
                "                <p>&nbsp;&nbsp;&nbsp;完善了Minecraft红石音乐功能</p>\n" +
                "                <p>&nbsp;&nbsp;&nbsp;添加了提取模组的功能</p>\n" +
                "                <p>&nbsp;&nbsp;&nbsp;修复了钢琴播放器的循环播放问题</p>\n" +
                "                <p>&nbsp;&nbsp;&nbsp;新增了钢琴音符特效的问题</p>\n" +
                "                <p>&nbsp;&nbsp;&nbsp;新增了贪吃蛇的游戏</p>\n" +
                "                <p>&nbsp;&nbsp;&nbsp;修改了关于软件的界面</p>\n" +
                "                <p>&nbsp;&nbsp;&nbsp;新增了启动Minecraft-forge-1.12.2</p>\n" +
                "                <br>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "    </body>\n" +
                "</html>",
                "<!DOCTYPE html>\n" +
                        "<html lang=\"en\">\n" +
                        "    <head>\n" +
                        "        <meta charset=\"UTF-8\">\n" +
                        "        <title>更新日志</title>\n" +
                        "    </head>\n" +
                        "    <style>\n" +
                        "        *\n" +
                        "        {\n" +
                        "            margin: 0;\n" +
                        "            padding: 0;\n" +
                        "            border: 0;\n" +
                        "            user-select: none;\n" +
                        "        }\n" +
                        "\n" +
                        "        body\n" +
                        "        {\n" +
                        "            background-color: #2f2f2f;\n" +
                        "        }\n" +
                        "\n" +
                        "        #main\n" +
                        "        {\n" +
                        "            width: 90%;\n" +
                        "            height: 100%;\n" +
                        "            border: 2px solid #424242;\n" +
                        "            margin: 119px auto;\n" +
                        "            border-radius: 10px;\n" +
                        "        }\n" +
                        "\n" +
                        "        h1\n" +
                        "        {\n" +
                        "            text-align: center;\n" +
                        "            color: #eeeeee;\n" +
                        "            font-size: 40pt;\n" +
                        "        }\n" +
                        "\n" +
                        "        h3\n" +
                        "        {\n" +
                        "            text-align: center;\n" +
                        "            color: #eeeeee;\n" +
                        "            font-size: 10pt;\n" +
                        "        }\n" +
                        "\n" +
                        "        #content\n" +
                        "        {\n" +
                        "            width: 90%;\n" +
                        "            height: 100%;\n" +
                        "            border: 2px solid #424242;\n" +
                        "            margin: 50px auto;\n" +
                        "            border-radius: 10px;\n" +
                        "            color: #eeeeee;\n" +
                        "        }\n" +
                        "\n" +
                        "    </style>\n" +
                        "    <body>\n" +
                        "        <div id=\"main\">\n" +
                        "            <br>\n" +
                        "            <br>\n" +
                        "            <h1>更新日志</h1>\n" +
                        "            <br>\n" +
                        "            <h3>更新时间: 2023/4-23</h3>\n" +
                        "            <div id=\"content\">\n" +
                        "                <br>\n" +
                        "                <p>&nbsp;&nbsp;&nbsp;新增了播放jmci文件是可以选择SoundFont音色库进行播放</p>\n" +
                        "                <p>&nbsp;&nbsp;&nbsp;更新了声音包加载引擎并且提供了声音包的模板</p>\n" +
                        "                <p>&nbsp;&nbsp;&nbsp;新增了更新日志的功能</p>\n" +
                        "                <p>&nbsp;&nbsp;&nbsp;修复了获取resources下的资源时为null, 造成不必要的麻烦</p>\n" +
                        "                <br>\n" +
                        "            </div>\n" +
                        "        </div>\n" +
                        "    </body>\n" +
                        "</html>",
                "<!DOCTYPE html>\n" +
                        "<html lang=\"en\">\n" +
                        "    <head>\n" +
                        "        <meta charset=\"UTF-8\">\n" +
                        "        <title>更新日志</title>\n" +
                        "    </head>\n" +
                        "    <style>\n" +
                        "        *\n" +
                        "        {\n" +
                        "            margin: 0;\n" +
                        "            padding: 0;\n" +
                        "            border: 0;\n" +
                        "            user-select: none;\n" +
                        "        }\n" +
                        "\n" +
                        "        body\n" +
                        "        {\n" +
                        "            background-color: #2f2f2f;\n" +
                        "        }\n" +
                        "\n" +
                        "        #main\n" +
                        "        {\n" +
                        "            width: 90%;\n" +
                        "            height: 100%;\n" +
                        "            border: 2px solid #424242;\n" +
                        "            margin: 119px auto;\n" +
                        "            border-radius: 10px;\n" +
                        "        }\n" +
                        "\n" +
                        "        h1\n" +
                        "        {\n" +
                        "            text-align: center;\n" +
                        "            color: #eeeeee;\n" +
                        "            font-size: 40pt;\n" +
                        "        }\n" +
                        "\n" +
                        "        h3\n" +
                        "        {\n" +
                        "            text-align: center;\n" +
                        "            color: #eeeeee;\n" +
                        "            font-size: 10pt;\n" +
                        "        }\n" +
                        "\n" +
                        "        #content\n" +
                        "        {\n" +
                        "            width: 90%;\n" +
                        "            height: 100%;\n" +
                        "            border: 2px solid #424242;\n" +
                        "            margin: 50px auto;\n" +
                        "            border-radius: 10px;\n" +
                        "            color: #eeeeee;\n" +
                        "        }\n" +
                        "\n" +
                        "    </style>\n" +
                        "    <body>\n" +
                        "        <div id=\"main\">\n" +
                        "            <br>\n" +
                        "            <br>\n" +
                        "            <h1>更新日志</h1>\n" +
                        "            <br>\n" +
                        "            <h3>更新时间: 2023/4-24</h3>\n" +
                        "            <div id=\"content\">\n" +
                        "                <br>\n" +
                        "                <p>&nbsp;&nbsp;&nbsp;修复了在上使用SoundFont播放时下方的歌曲名和时间不会回位的bug</p>\n" +
                        "                <p>&nbsp;&nbsp;&nbsp;修复了默认播放声音方式中添加了还原SoundFont</p>\n" +
                        "                <p>&nbsp;&nbsp;&nbsp;修复了更新日志显示时乱码</p>\n" +
                        "                <p>&nbsp;&nbsp;&nbsp;弃用了内置HTML预览, 使用新的html, 打开使用浏览器</p>\n" +
                        "                <br>\n" +
                        "            </div>\n" +
                        "        </div>\n" +
                        "    </body>\n" +
                        "</html>",
                "<!DOCTYPE html>\n" +
                        "<html lang=\"en\">\n" +
                        "    <head>\n" +
                        "        <meta charset=\"UTF-8\">\n" +
                        "        <title>更新日志</title>\n" +
                        "    </head>\n" +
                        "    <style>\n" +
                        "        *\n" +
                        "        {\n" +
                        "            margin: 0;\n" +
                        "            padding: 0;\n" +
                        "            border: 0;\n" +
                        "            user-select: none;\n" +
                        "        }\n" +
                        "\n" +
                        "        body\n" +
                        "        {\n" +
                        "            background-color: #2f2f2f;\n" +
                        "        }\n" +
                        "\n" +
                        "        #main\n" +
                        "        {\n" +
                        "            width: 90%;\n" +
                        "            height: 100%;\n" +
                        "            border: 2px solid #424242;\n" +
                        "            margin: 119px auto;\n" +
                        "            border-radius: 10px;\n" +
                        "        }\n" +
                        "\n" +
                        "        h1\n" +
                        "        {\n" +
                        "            text-align: center;\n" +
                        "            color: #eeeeee;\n" +
                        "            font-size: 40pt;\n" +
                        "        }\n" +
                        "\n" +
                        "        h3\n" +
                        "        {\n" +
                        "            text-align: center;\n" +
                        "            color: #eeeeee;\n" +
                        "            font-size: 10pt;\n" +
                        "        }\n" +
                        "\n" +
                        "        #content\n" +
                        "        {\n" +
                        "            width: 90%;\n" +
                        "            height: 100%;\n" +
                        "            border: 2px solid #424242;\n" +
                        "            margin: 50px auto;\n" +
                        "            border-radius: 10px;\n" +
                        "            color: #eeeeee;\n" +
                        "        }\n" +
                        "\n" +
                        "    </style>\n" +
                        "    <body>\n" +
                        "        <div id=\"main\">\n" +
                        "            <br>\n" +
                        "            <br>\n" +
                        "            <h1>更新日志</h1>\n" +
                        "            <br>\n" +
                        "            <h3>更新时间: 2023/4-27</h3>\n" +
                        "            <div id=\"content\">\n" +
                        "                <br>\n" +
                        "                <p>&nbsp;&nbsp;&nbsp;修复了软件不能读取更新日志问题</p>\n" +
                        "                <p>&nbsp;&nbsp;&nbsp;修复了移动音高时通道9也会跟着移动</p>\n" +
                        "                <p>&nbsp;&nbsp;&nbsp;修复了移动音高前终止所有声音</p>\n" +
                        "                <p>&nbsp;&nbsp;&nbsp;更新了midi曲库, 曲库路径为: " + new File("jmci_song").getAbsolutePath() + "</p>\n" +
                        "                <p>&nbsp;&nbsp;&nbsp;修复了主界面的标题旁边会动的文字时时抛出 < sun.awt.image.PNGImageDecoder$PNGException: bogus length: -1 > 异常</p>\n" +
                        "                <br>\n" +
                        "            </div>\n" +
                        "        </div>\n" +
                        "    </body>\n" +
                        "</html>",
                "<!DOCTYPE html>\n" +
                        "<html lang=\"en\">\n" +
                        "    <head>\n" +
                        "        <meta charset=\"UTF-8\">\n" +
                        "        <title>更新日志</title>\n" +
                        "    </head>\n" +
                        "    <style>\n" +
                        "        *\n" +
                        "        {\n" +
                        "            margin: 0;\n" +
                        "            padding: 0;\n" +
                        "            border: 0;\n" +
                        "            user-select: none;\n" +
                        "        }\n" +
                        "\n" +
                        "        body\n" +
                        "        {\n" +
                        "            background-color: #2f2f2f;\n" +
                        "        }\n" +
                        "\n" +
                        "        #main\n" +
                        "        {\n" +
                        "            width: 90%;\n" +
                        "            height: 100%;\n" +
                        "            border: 2px solid #424242;\n" +
                        "            margin: 119px auto;\n" +
                        "            border-radius: 10px;\n" +
                        "        }\n" +
                        "\n" +
                        "        h1\n" +
                        "        {\n" +
                        "            text-align: center;\n" +
                        "            color: #eeeeee;\n" +
                        "            font-size: 40pt;\n" +
                        "        }\n" +
                        "\n" +
                        "        h3\n" +
                        "        {\n" +
                        "            text-align: center;\n" +
                        "            color: #eeeeee;\n" +
                        "            font-size: 10pt;\n" +
                        "        }\n" +
                        "\n" +
                        "        #content\n" +
                        "        {\n" +
                        "            width: 90%;\n" +
                        "            height: 100%;\n" +
                        "            border: 2px solid #424242;\n" +
                        "            margin: 50px auto;\n" +
                        "            border-radius: 10px;\n" +
                        "            color: #eeeeee;\n" +
                        "        }\n" +
                        "\n" +
                        "    </style>\n" +
                        "    <body>\n" +
                        "        <div id=\"main\">\n" +
                        "            <br>\n" +
                        "            <br>\n" +
                        "            <h1>更新日志</h1>\n" +
                        "            <br>\n" +
                        "            <h3>更新时间: 2023/4-29</h3>\n" +
                        "            <div id=\"content\">\n" +
                        "                <br>\n" +
                        "                <p>&nbsp;&nbsp;&nbsp;修复了调试jmci音高左移时出现键盘不会移动</p>\n" +
                        "                <p>&nbsp;&nbsp;&nbsp;修复了移动音高时通道9不会被移动</p>\n" +
                        "                <p>&nbsp;&nbsp;&nbsp;更换了更新日志的写入方式</p>\n" +
                        "                <br>\n" +
                        "            </div>\n" +
                        "        </div>\n" +
                        "    </body>\n" +
                        "</html>"};

        int y = 2023;
        int m = 4;
        int[] dateArray = {
                22, 23, 24, 27, 29
        };

        int day = 0;
        for (String html : updateLog)
        {
            String fileName = "system/update/log/list/" + "2023-" + m + "-" + dateArray[day] + ".html";
            WriteFile.writeStringToFile(fileName, html, "UTF-8");
            day++;
        }
    }

    private static void loadSoundPack()
    {
        XFLog.info("加载声音包");
        LoadSounds.load();
        LoadSoundPackage.load();
    }
}
