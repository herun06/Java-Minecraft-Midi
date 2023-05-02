/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package main.java.com.xfherun.minecraft_redstone_music_generator.user_ui;

import com.xfherun.xflog.XFLog;
import main.java.com.xfherun.jmci.user_interface.events.ChangePage;
import main.java.com.xfherun.jmci.utils.Resources;
import main.java.com.xfherun.jmci.utils.Sleep;
import main.java.com.xfherun.jmci.utils.StringMethod;
import main.java.com.xfherun.jmci.utils.WriteFile;
import main.java.com.xfherun.minecraft_redstone_music_generator.Main;
import main.java.com.xfherun.minecraft_redstone_music_generator.thread.UpdateWindow;
import main.java.com.xfherun.minecraft_redstone_music_generator.user_ui.comp.button.ClickedConnect;
import main.java.com.xfherun.minecraft_redstone_music_generator.user_ui.comp.button.PushButton;
import main.java.com.xfherun.minecraft_redstone_music_generator.user_ui.comp.list.BasicScrollBarUIStyle;
import main.java.com.xfherun.minecraft_redstone_music_generator.user_ui.comp.list.List;
import main.java.com.xfherun.minecraft_redstone_music_generator.user_ui.comp.list.ListAction;
import main.java.com.xfherun.minecraft_redstone_music_generator.user_ui.comp.radiobutton.RadioButton;
import main.java.com.xfherun.minecraft_redstone_music_generator.user_ui.comp.radiobutton.RadioButtonChecked;
import main.java.com.xfherun.minecraft_redstone_music_generator.user_ui.comp.radiobutton.RadioButtonItem;
import main.java.com.xfherun.minecraft_redstone_music_generator.user_ui.comp.textbox.InputBox;
import main.java.com.xfherun.minecraft_redstone_music_generator.utls.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;

public class MainWindow extends JFrame
{
    private static JFrame mainWindow;
    private static JPanel mainContainer;
    private static JPanel leftContainer;
    private static JPanel rightContainer1;
    private static JPanel rightContainer2;
    private static JPanel rightContainer3;
    private static JLabel logoImage;
    private static JPanel buttonArea;
    private static PushButton pushButton;
    private static PushButton pushButton_2;
    private static PushButton pushButton_3;
    private static JScrollPane listArea;
    private static List list;
    private static JScrollPane newProjectMainBox;
    private static JPanel newProjectMainBoxPanel;
    private static JPanel panel_title_bar;
    private static JTextField title;
    private static JScrollPane textSp;
    private static JPanel panel_title_bar_2;
    private static JTextField title_2;
    private static JPanel mainPanel;
    private static InputBox inputBox_1;
    private static InputBox inputBox_2;
    private static InputBox inputBox_3;
    private static InputBox inputBox_4;
    private static InputBox inputBox_5;
    private static PushButton inputBox_1Button;
    private static PushButton inputBox_2Button;
    private static PushButton inputBox_3Button;
    private static PushButton inputBox_4Button;
    private static PushButton inputBox_5Button;
    private static PushButton inputBox_6Button;
    private static String minecraftFunctionFileName = "NaN";
    private static JLabel aboutAppTitle;
    private static JLabel aboutAppImage;
    private static JLabel aboutAppImageTitle;
    private static JLabel aboutAppImageSubtitle;
    private static JScrollPane aboutAppDescriptionTextBox;
    private static boolean isRunJMCSFile;

    private MainWindow()
    {
    }

    public static void setupUi()
    {
        isRunJMCSFile = true;
        minecraftFunctionFileName = "xfherun_redstone_music";
        XFLog.info("初始化窗口..");
        addComp();
        setText();
        mainWindow.setIconImage(new ImageIcon(Resources.getResources(MainWindow.class, "main/resources/images/comp/icon/logo.png")).getImage());
        mainWindow.setVisible(true);
        mainWindow.getContentPane().revalidate();
        new UpdateWindow().start();
        Sleep.sleep(new Random().nextInt(500, 600));
        Dimension size = mainWindow.getSize();
        mainWindow.setSize(size.width + 1, size.height + 1);
        Sleep.sleep(119);
        mainWindow.setSize(size);
        XFLog.info("窗口初始化完毕！");
    }

    private static Point getWindowSize()
    {
        return new Point(mainWindow.getWidth() - 16, mainWindow.getHeight() - 39);
    }

    private static ImageIcon getImageIconForComponentSize(Component component, String imagePath)
    {
        ImageIcon imageIcon = new ImageIcon(Resources.getResources(MainWindow.class, "main/resources/" + imagePath));
        imageIcon.setImage(imageIcon.getImage().getScaledInstance(component.getWidth(), component.getHeight(), Image.SCALE_DEFAULT));
        return imageIcon;
    }

    private static ImageIcon getImageIconForComponentSizeHeight(Component component, String imagePath)
    {
        ImageIcon imageIcon = new ImageIcon(Resources.getResources(MainWindow.class, "main/resources/" + imagePath));
        imageIcon.setImage(imageIcon.getImage().getScaledInstance(component.getHeight(), component.getHeight(), Image.SCALE_DEFAULT));
        return imageIcon;
    }

    private static ImageIcon getImageIconForComponentSizeWidth(Component component, String imagePath)
    {
        ImageIcon imageIcon = new ImageIcon(Resources.getResources(MainWindow.class, "main/resources/" + imagePath));
        imageIcon.setImage(imageIcon.getImage().getScaledInstance(component.getWidth(), component.getWidth(), Image.SCALE_DEFAULT));
        return imageIcon;
    }

    private static ImageIcon getImageIconForComponentSizeAuto(String imagePath, int width, int height)
    {
        ImageIcon imageIcon = new ImageIcon(Resources.getResources(MainWindow.class, "main/resources/" + imagePath));
        imageIcon.setImage(imageIcon.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
        return imageIcon;
    }

    private static void resize()
    {
        try
        {
            mainContainer.setBounds(0, 0, getWindowSize().x, getWindowSize().y);
            leftContainer.setBounds(0, 0, 250, mainContainer.getHeight());
            logoImage.setBounds(0, 0, leftContainer.getWidth(), 119);
            buttonArea.setBounds(0, (((leftContainer.getHeight() + 119) - 449) / 2) + 119, leftContainer.getWidth(), 449);
            pushButton.getPushButton().setBounds(0, 0, buttonArea.getWidth(), 41);
            pushButton_2.getPushButton().setBounds(0, 41, buttonArea.getWidth(), 41);
            pushButton_3.getPushButton().setBounds(0, (41 * 2), buttonArea.getWidth(), 41);
            rightContainer1.setBounds(250, 0, mainContainer.getWidth() - 250, mainContainer.getHeight());
            rightContainer2.setBounds(250, 0, mainContainer.getWidth() - 250, mainContainer.getHeight());
            rightContainer3.setBounds(250, 0, mainContainer.getWidth() - 250, mainContainer.getHeight());
            listArea.setBounds(0, 0, rightContainer2.getWidth(), rightContainer2.getHeight());
            list.updateSize(rightContainer2.getWidth() - 200);
            newProjectMainBox.setBounds(41, 0, rightContainer1.getWidth() - 41, rightContainer1.getHeight());
            panel_title_bar.setSize(new Dimension(newProjectMainBoxPanel.getWidth(), 41 + 200));
            title.setSize(newProjectMainBoxPanel.getWidth(), 41);
            textSp.setBounds(0, 41, newProjectMainBoxPanel.getWidth(), 200);
            panel_title_bar_2.setSize(new Dimension(newProjectMainBoxPanel.getWidth(), 41 + 266));
            title_2.setSize(newProjectMainBoxPanel.getWidth(), 41);
            mainPanel.setBounds(0, 41, newProjectMainBoxPanel.getWidth(), 296);
            inputBox_1.getSource().setBounds(10 + 169, 10, mainPanel.getWidth() - (20 + 200 + 102), 41);
            inputBox_1Button.getPushButton().setBounds(10 + 169 + (mainPanel.getWidth() - (20 + 200 + 102)) + 10, 10, 123, 41);
            inputBox_2.getSource().setBounds(10 + 169, 10 + (41 + 10), mainPanel.getWidth() - (20 + 200 + 102), 41);
            inputBox_2Button.getPushButton().setBounds(10 + 169 + (mainPanel.getWidth() - (20 + 200 + 102)) + 10, 10 + (41 + 10), 123, 41);
            inputBox_3.getSource().setBounds(10 + 169, 10 + ((41 + 10) * 2), mainPanel.getWidth() - (20 + 200 + 102), 41);
            inputBox_3Button.getPushButton().setBounds(10 + 169 + (mainPanel.getWidth() - (20 + 200 + 102)) + 10, 10 + ((41 + 10) * 2), 123, 41);
            inputBox_4.getSource().setBounds(10 + 169, 10 + ((41 + 10) * 3), mainPanel.getWidth() - (20 + 200 + 102), 41);
            inputBox_4Button.getPushButton().setBounds(10 + 169 + (mainPanel.getWidth() - (20 + 200 + 102)) + 10, 10 + ((41 + 10) * 3), 123, 41);
            inputBox_5.getSource().setBounds(10 + 169, 10 + ((41 + 10) * 4), mainPanel.getWidth() - (20 + 200 + 102), 41);
            inputBox_5Button.getPushButton().setBounds(10 + 169 + (mainPanel.getWidth() - (20 + 200 + 102)) + 10, 10 + ((41 + 10) * 4), 123, 41);
            inputBox_6Button.getPushButton().setBounds(mainPanel.getWidth() - (272 + 10), 10 + ((41 + 10) * 6) + 28, 272, 41);
            area3Resize();
        }
        catch (NullPointerException e)
        {
            XFLog.warn("", e);
        }
    }

    private static JLabel addAirBlock(int height)
    {
        JLabel label = new JLabel();
        Dimension dimension = new Dimension(height, height);
        label.setSize(dimension);
        label.setPreferredSize(dimension);
        label.setMinimumSize(dimension);
        label.setMinimumSize(dimension);
        label.setOpaque(true);
        label.setBackground(new Color(0, 0, 0, 0));
        label.setForeground(new Color(0, 0, 0, 0));
        label.setBorder(null);
        return label;
    }

    private static void area1()
    {
        newProjectMainBoxPanel = new JPanel();
        newProjectMainBoxPanel.setOpaque(true);
        newProjectMainBoxPanel.setBackground(new Color(45, 45, 45, 255));
        newProjectMainBoxPanel.setLayout(new BoxLayout(newProjectMainBoxPanel, BoxLayout.Y_AXIS));
        // newProjectMainBoxPanel.setLayout(new FlowLayout());
        Box box_V = Box.createVerticalBox();
        //box_V.add(addAirBlock(10));
        panel_title_bar = new JPanel();
        panel_title_bar.setOpaque(true);
        panel_title_bar.setLayout(null);
        panel_title_bar.setBackground(new Color(45, 45, 45, 255));
        panel_title_bar.setBorder(new LineBorder(new Color(107, 107, 107, 255)));
        panel_title_bar.setPreferredSize(new Dimension(41 + 200, 41 + 200));
        panel_title_bar.setMinimumSize(new Dimension(0, 41 + 200));
        panel_title_bar.setMaximumSize(new Dimension(999999999, 41 + 200));
        title = new JTextField(" 前言");
        title.setOpaque(true);
        title.setBorder(new LineBorder(new Color(107, 107, 107, 255)));
        title.setBackground(new Color(0, 0, 0, 0));
        title.setForeground(Color.decode("#eeeeee"));
        title.setFont(new Font("新宋体", 0, 15));
        title.setEditable(false);
        title.setSelectedTextColor(Color.decode("#eeeeee"));
        title.setSelectionColor(new Color(0, 0, 0, 0));
        title.setCaretColor(new Color(0, 0, 0, 0));
        title.setLocation(0, 0);
        title.setHorizontalAlignment(SwingConstants.LEFT);
        panel_title_bar.add(title);
        JTextArea textArea = new JTextArea("    随着Minecraft的不断更新, 最终还是停留在了Minecraft-1.12.2-Forge, 这是为什么？\n" +
                "\n" +
                "    这是因为在1.12.2更新后到1.13.2, 指令进行了大更新, 包括(语法, 关键字......), 甚至还移除了像execute指令的语法, 移除了testfor等指令......为什么红石音乐要选1.12.2, 而不选1.18.2以上？\n" +
                "\n" +
                "    这是因为MidiOut模组, 因为它只支持1.12.2, 所有我会选择1.12.2; 如果我选择材质包playsound指令发声; 你想, 我有128种虚拟乐器, 包括长鸣乐器(长鸣乐器: 像小提琴、 笛子、 管风琴......这样的乐器, 声音随着音符长度而变化, 也就是说我按下某个音符, 直到我松开某个音符后, 那个声音才停止; 不像钢琴, 钢琴的音长是有限制的, 而刚刚说的乐器没有音长限制, 这就是长鸣乐器), 那我就得准备128×128×128......的音频; 当然, 如果是长鸣乐器, 那音频到底多长, 那就不好说; 如果短, 显得不真实; 说太长, 垃圾电脑带不动, 甚至播放一个音频就得卡, 别说那么多了! 而MidiOut模组可以解决, 它的工作原理就是利用mc的指令来控制自己电脑系统的midi设备, 它的发声不是直接在mc里发声, 而是自己的电脑的midi在发声, 好比在自己的电脑上双击midi文件播放; 这样可以节省电脑性能, 可以让低配电脑使用。 ");
        textArea.setBackground(new Color(45, 45, 45, 255));
        textArea.setBorder(null);
        textArea.setForeground(Color.decode("#eeeeee"));
        textArea.setFont(new Font("新宋体", 0, 15));
        textArea.setEditable(false);
        textArea.setCaretColor(Color.decode("#eeeeee"));
        textArea.setLineWrap(true);
        textArea.setSelectedTextColor(Color.WHITE);
        textArea.setSelectionColor(Color.BLUE);
        textSp = new JScrollPane(textArea);
        textSp.setBorder(new LineBorder(new Color(107, 107, 107, 255)));
        textSp.setBackground(new Color(45, 45, 45, 255));
        textSp.setForeground(new Color(0, 0, 0, 0));
        textSp.setMinimumSize(new Dimension(0, 200));
        textSp.setMaximumSize(new Dimension(999999999, 200));
        textSp.getVerticalScrollBar().setUI(new BasicScrollBarUIStyle());
        textSp.getHorizontalScrollBar().setUI(new BasicScrollBarUIStyle());
        panel_title_bar.add(textSp);
        box_V.add(panel_title_bar);
        // box_V.add(addAirBlock(10));
        panel_title_bar_2 = new JPanel();
        panel_title_bar_2.setOpaque(true);
        panel_title_bar_2.setLayout(null);
        panel_title_bar_2.setBackground(new Color(45, 45, 45, 255));
        panel_title_bar_2.setBorder(new LineBorder(new Color(107, 107, 107, 255)));
        panel_title_bar_2.setPreferredSize(new Dimension(41 + 600, 41 + 350));
        panel_title_bar_2.setMinimumSize(new Dimension(0, 41 + 350));
        panel_title_bar_2.setMaximumSize(new Dimension(999999999, 41 + 350));
        title_2 = new JTextField(" 属性设置");
        title_2.setOpaque(true);
        title_2.setBorder(new LineBorder(new Color(107, 107, 107, 255)));
        title_2.setBackground(new Color(0, 0, 0, 0));
        title_2.setForeground(Color.decode("#eeeeee"));
        title_2.setFont(new Font("新宋体", 0, 15));
        title_2.setEditable(false);
        title_2.setSelectedTextColor(Color.decode("#eeeeee"));
        title_2.setSelectionColor(new Color(0, 0, 0, 0));
        title_2.setCaretColor(new Color(0, 0, 0, 0));
        title_2.setLocation(0, 0);
        title_2.setHorizontalAlignment(SwingConstants.LEFT);
        panel_title_bar_2.add(title_2);
        mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setOpaque(true);
        mainPanel.setBackground(new Color(0, 0, 0, 0));
        mainPanel.setForeground(new Color(0, 0, 0, 0));
        mainPanel.setBorder(new LineBorder(new Color(107, 107, 107, 255)));
        mainPanel.setPreferredSize(new Dimension(296, 296));
        mainPanel.setMinimumSize(new Dimension(0, 296));
        mainPanel.setMaximumSize(new Dimension(999999999, 296));

        JLabel title_1 = new JLabel("工程名: ");
        title_1.setBounds(10, 10, 169, 41);
        title_1.setOpaque(true);
        title_1.setBackground(new Color(0, 0, 0, 0));
        title_1.setForeground(Color.decode("#eeeeee"));
        title_1.setFont(new Font("新宋体", 0, 15));
        title_1.setHorizontalAlignment(SwingConstants.RIGHT);
        title_1.setVerticalAlignment(SwingConstants.CENTER);
        mainPanel.add(title_1);
        inputBox_1 = new InputBox();
        inputBox_1.getSource().setPreferredSize(new Dimension(41, 41));
        inputBox_1.getSource().setMinimumSize(new Dimension(41, 41));
        inputBox_1.getSource().setMaximumSize(new Dimension(41, 41));
        mainPanel.add(inputBox_1.getSource());
        inputBox_1Button = new PushButton("保存工程");
        inputBox_1Button.getPushButton().setHorizontalAlignment(SwingConstants.CENTER);
        inputBox_1Button.getPushButton().setVerticalAlignment(SwingConstants.CENTER);
        inputBox_1Button.getPushButton().setFont(new Font("新宋体", 0, 15));
        mainPanel.add(inputBox_1Button.getPushButton());

        JLabel title_2 = new JLabel(".minecraft路径: ");
        title_2.setBounds(10, 10 + (41 + 10), 169, 41);
        title_2.setOpaque(true);
        title_2.setBackground(new Color(0, 0, 0, 0));
        title_2.setForeground(Color.decode("#eeeeee"));
        title_2.setFont(new Font("新宋体", 0, 15));
        title_2.setHorizontalAlignment(SwingConstants.RIGHT);
        title_2.setVerticalAlignment(SwingConstants.CENTER);
        mainPanel.add(title_2);
        inputBox_2 = new InputBox();
        inputBox_2.getSource().setPreferredSize(new Dimension(41, 41));
        inputBox_2.getSource().setMinimumSize(new Dimension(41, 41));
        inputBox_2.getSource().setMaximumSize(new Dimension(41, 41));
        mainPanel.add(inputBox_2.getSource());
        inputBox_2Button = new PushButton("浏览文件");
        inputBox_2Button.getPushButton().setHorizontalAlignment(SwingConstants.CENTER);
        inputBox_2Button.getPushButton().setVerticalAlignment(SwingConstants.CENTER);
        inputBox_2Button.getPushButton().setFont(new Font("新宋体", 0, 15));
        mainPanel.add(inputBox_2Button.getPushButton());

        JLabel title_3 = new JLabel("jmci路径: ");
        title_3.setBounds(10, 10 + ((41 + 10) * 2), 169, 41);
        title_3.setOpaque(true);
        title_3.setBackground(new Color(0, 0, 0, 0));
        title_3.setForeground(Color.decode("#eeeeee"));
        title_3.setFont(new Font("新宋体", 0, 15));
        title_3.setHorizontalAlignment(SwingConstants.RIGHT);
        title_3.setVerticalAlignment(SwingConstants.CENTER);
        mainPanel.add(title_3);
        inputBox_3 = new InputBox();
        inputBox_3.getSource().setPreferredSize(new Dimension(41, 41));
        inputBox_3.getSource().setMinimumSize(new Dimension(41, 41));
        inputBox_3.getSource().setMaximumSize(new Dimension(41, 41));
        mainPanel.add(inputBox_3.getSource());
        inputBox_3Button = new PushButton("浏览文件");
        inputBox_3Button.getPushButton().setHorizontalAlignment(SwingConstants.CENTER);
        inputBox_3Button.getPushButton().setVerticalAlignment(SwingConstants.CENTER);
        inputBox_3Button.getPushButton().setFont(new Font("新宋体", 0, 15));
        mainPanel.add(inputBox_3Button.getPushButton());

        JLabel title_4 = new JLabel("主标题: ");
        title_4.setBounds(10, 10 + ((41 + 10) * 3), 169, 41);
        title_4.setOpaque(true);
        title_4.setBackground(new Color(0, 0, 0, 0));
        title_4.setForeground(Color.decode("#eeeeee"));
        title_4.setFont(new Font("新宋体", 0, 15));
        title_4.setHorizontalAlignment(SwingConstants.RIGHT);
        title_4.setVerticalAlignment(SwingConstants.CENTER);
        mainPanel.add(title_4);
        inputBox_4 = new InputBox();
        inputBox_4.getSource().setPreferredSize(new Dimension(41, 41));
        inputBox_4.getSource().setMinimumSize(new Dimension(41, 41));
        inputBox_4.getSource().setMaximumSize(new Dimension(41, 41));
        mainPanel.add(inputBox_4.getSource());
        inputBox_4Button = new PushButton("默认选择");
        inputBox_4Button.getPushButton().setHorizontalAlignment(SwingConstants.CENTER);
        inputBox_4Button.getPushButton().setVerticalAlignment(SwingConstants.CENTER);
        inputBox_4Button.getPushButton().setFont(new Font("新宋体", 0, 15));
        mainPanel.add(inputBox_4Button.getPushButton());

        JLabel title_5 = new JLabel("副标题: ");
        title_5.setBounds(10, 10 + ((41 + 10) * 4), 169, 41);
        title_5.setOpaque(true);
        title_5.setBackground(new Color(0, 0, 0, 0));
        title_5.setForeground(Color.decode("#eeeeee"));
        title_5.setFont(new Font("新宋体", 0, 15));
        title_5.setHorizontalAlignment(SwingConstants.RIGHT);
        title_5.setVerticalAlignment(SwingConstants.CENTER);
        mainPanel.add(title_5);
        inputBox_5 = new InputBox();
        inputBox_5.getSource().setPreferredSize(new Dimension(41, 41));
        inputBox_5.getSource().setMinimumSize(new Dimension(41, 41));
        inputBox_5.getSource().setMaximumSize(new Dimension(41, 41));
        mainPanel.add(inputBox_5.getSource());
        inputBox_5Button = new PushButton("默认选择");
        inputBox_5Button.getPushButton().setHorizontalAlignment(SwingConstants.CENTER);
        inputBox_5Button.getPushButton().setVerticalAlignment(SwingConstants.CENTER);
        inputBox_5Button.getPushButton().setFont(new Font("新宋体", 0, 15));
        mainPanel.add(inputBox_5Button.getPushButton());

        panel_title_bar_2.add(mainPanel);
        inputBox_6Button = new PushButton("开始生成Minecraft红石音乐");
        inputBox_6Button.getPushButton().setHorizontalAlignment(SwingConstants.CENTER);
        inputBox_6Button.getPushButton().setVerticalAlignment(SwingConstants.CENTER);
        inputBox_6Button.getPushButton().setFont(new Font("新宋体", 0, 15));
        panel_title_bar_2.add(inputBox_6Button.getPushButton());

        box_V.add(panel_title_bar_2);
        // box_V.add(addAirBlock(10));
        newProjectMainBoxPanel.add(box_V);
        newProjectMainBox = new JScrollPane(newProjectMainBoxPanel);
        newProjectMainBox.setOpaque(true);
        newProjectMainBox.setBackground(new Color(43, 43, 43, 255));
        newProjectMainBox.setForeground(new Color(43, 43, 43, 255));
        newProjectMainBox.setBorder(null);
        newProjectMainBox.getHorizontalScrollBar().setUI(new BasicScrollBarUIStyle());
        newProjectMainBox.getVerticalScrollBar().setUI(new BasicScrollBarUIStyle());
        rightContainer1.add(newProjectMainBox);
        clickedConnect();
    }

    private static void clickedConnect()
    {
        inputBox_1Button.addClickedConnect(new ClickedConnect()
        {
            @Override
            public void accept(MouseEvent mouseEvent, String eventType)
            {
                if (mouseEvent.getClickCount() == 1 && mouseEvent.getButton() == 1 && eventType.equals("mouseClicked"))
                {
                    XFLog.info("开始保存工程...");
                    String projectName = inputBox_1.getSource().getText();
                    if (projectName.equals(""))
                    {
                        XFLog.info("工程名不能为空: " + projectName);
                        JOptionPane.showMessageDialog(mainWindow,
                                "工程名不能为空: " + projectName,
                                "警告", 2);
                        return;
                    }

                    if (!Regex.regex(projectName, "=;\\/:\"'|~<>*?"))
                    {
                        XFLog.info("工程名不能有这些字符: = ; \\ / : \" ' | ~ < > * ?  :: " + projectName);
                        JOptionPane.showMessageDialog(mainWindow,
                                "工程名不能有这些字符: = ; \\ / : \" ' | ~ < > * ?  :: " + projectName,
                                "警告", 2);
                        return;
                    }

                    String writeFileStringSrc = "@project_name={0};\n" +
                            "@file_name={7};\n" +
                            "@create_time={1};\n" +
                            "@update_time={2};\n" +
                            "@minecraft_path={3};\n" +
                            "@jmci_path={4};\n" +
                            "@jmci_title={5};\n" +
                            "@jmci_subtitle={6};\n" +
                            "@minecraft_function_name=xfherun_redstone_music;";
                    String writeFileString = StringFormat.stringFormat(writeFileStringSrc, new String[]{
                            projectName,
                            Time.getTime(),
                            Time.getTime(),
                            inputBox_2.getSource().getText(),
                            inputBox_3.getSource().getText(),
                            inputBox_4.getSource().getText(),
                            inputBox_5.getSource().getText(),
                            "jmcp_" + projectName
                    });
                    File file = new File("run/saves/jmcp_" + projectName + ".jmcp");
                    if (!file.exists())
                    {
                        boolean b = WriteFile.writeStringToFile(file.getAbsolutePath(), writeFileString, "UTF-8");
                        if (b)
                        {
                            XFLog.info("工程: " + projectName + " 保存成功");
                            updateJMCP();
                            JOptionPane.showMessageDialog(mainWindow,
                                    "工程: " + projectName + " 保存成功",
                                    "提示 ", 1);
                        }
                        else
                        {
                            XFLog.info("工程: " + projectName + " 保存失败");
                            JOptionPane.showMessageDialog(mainWindow,
                                    "工程: " + projectName + " 保存失败",
                                    "警告 ", 2);
                        }
                    }
                    else
                    {
                        XFLog.warn("文件: " + file.getAbsolutePath() + " 已存在... :: 是否要替换？");
                        int option = JOptionPane.showConfirmDialog(mainWindow,
                                "文件: " + file.getAbsolutePath() + " 已存在！ :: 是否要替换？",
                                "警告 ", 0);
                        if (option == 0)
                        {
                            XFLog.warn("开始替换工程: " + file.getAbsolutePath());
                            boolean b = WriteFile.writeStringToFile(file.getAbsolutePath(), writeFileString, "UTF-8");
                            if (b)
                            {
                                XFLog.info("工程: " + projectName + " 保存成功");
                                updateJMCP();
                                JOptionPane.showMessageDialog(mainWindow,
                                        "工程: " + projectName + " 保存成功",
                                        "提示 ", 1);
                            }
                            else
                            {
                                XFLog.info("工程: " + projectName + " 保存失败");
                                JOptionPane.showMessageDialog(mainWindow,
                                        "工程: " + projectName + " 保存失败",
                                        "警告 ", 2);
                            }
                        }
                        else XFLog.info("用户取消了替换工程: " + file.getAbsolutePath());
                    }
                }
            }
        });
        inputBox_2Button.addClickedConnect(new ClickedConnect()
        {
            @Override
            public void accept(MouseEvent mouseEvent, String eventType)
            {
                if (mouseEvent.getClickCount() == 1 && mouseEvent.getButton() == 1 && eventType.equals("mouseClicked"))
                {
                    XFLog.info("开始准备文件选择器来选择.minecraft文件路径...");
                    JFileChooser fileChooser = new JFileChooser("./");
                    fileChooser.setDialogTitle("选择.minecraft文件目录");
                    fileChooser.setMultiSelectionEnabled(false);
                    fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                    int option = fileChooser.showOpenDialog(mainWindow);
                    File selectedFile = fileChooser.getSelectedFile();
                    if (option == 0)
                    {
                        if (selectedFile != null)
                        {
                            String s = selectedFile.toString();
                            String o = ".minecraft";
                            if (s.substring(s.length() - o.length()).equalsIgnoreCase(o))
                            {
                                inputBox_2.getSource().setText(s);
                                XFLog.info("成功选择.minecraft文件目录: " + s);
                            }
                            else
                            {
                                XFLog.info("无效的.minecraft文件目录: " + s + ", 请选择文件.minecraft文件目录");
                                JOptionPane.showMessageDialog(mainWindow,
                                        "无效的.minecraft文件目录: " + s + ", 请选择文件.minecraft文件目录",
                                        "警告", 2);
                            }
                        }
                    }
                }
            }
        });
        inputBox_3Button.addClickedConnect(new ClickedConnect()
        {
            @Override
            public void accept(MouseEvent mouseEvent, String eventType)
            {
                if (mouseEvent.getClickCount() == 1 && mouseEvent.getButton() == 1 && eventType.equals("mouseClicked"))
                {
                    XFLog.info("开始准备文件选择器来选择jmci文件路径...");
                    JFileChooser fileChooser = new JFileChooser("./");
                    fileChooser.setDialogTitle("选择JMCi文件");
                    fileChooser.setMultiSelectionEnabled(false);
                    fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                    fileChooser.setFileFilter(new FileFilter()
                    {

                        @Override
                        public String getDescription()
                        {
                            return "Java Minecraft Midi 文件(*.jmci)";
                        }

                        @Override
                        public boolean accept(File f)
                        {
                            if (f.getName().toLowerCase().endsWith(".jmci")) return true;
                            return false;
                        }
                    });
                    int option = fileChooser.showOpenDialog(mainWindow);
                    File selectedFile = fileChooser.getSelectedFile();
                    if (option == 0)
                    {
                        if (selectedFile != null)
                        {
                            String s = selectedFile.toString();
                            String o = ".jmci";
                            if (s.substring(s.length() - o.length()).equalsIgnoreCase(o))
                            {
                                inputBox_3.getSource().setText(s);
                                XFLog.info("成功选择JMCI文件: " + s);
                            }
                            else
                            {
                                XFLog.info("无效的JMCI文件: " + s + ", 请选择JMCI文件");
                                JOptionPane.showMessageDialog(mainWindow,
                                        "无效的JMCI文件: " + s + ", 请选择JMCI文件",
                                        "警告", 2);
                            }
                        }
                    }
                }
            }
        });
        inputBox_4Button.addClickedConnect(new ClickedConnect()
        {
            @Override
            public void accept(MouseEvent mouseEvent, String eventType)
            {
                if (mouseEvent.getClickCount() == 1 && mouseEvent.getButton() == 1 && eventType.equals("mouseClicked"))
                {
                    XFLog.info("默认主标题: Untitled");
                    inputBox_4.getSource().setText("Untitled");
                }
            }
        });
        inputBox_5Button.addClickedConnect(new ClickedConnect()
        {
            @Override
            public void accept(MouseEvent mouseEvent, String eventType)
            {
                if (mouseEvent.getClickCount() == 1 && mouseEvent.getButton() == 1 && eventType.equals("mouseClicked"))
                {
                    XFLog.info("默认副标题: Subtitled to xfherun");
                    inputBox_5.getSource().setText("Subtitled to xfherun");
                }
            }
        });
        inputBox_6Button.addClickedConnect(new ClickedConnect()
        {
            @Override
            public void accept(MouseEvent mouseEvent, String eventType)
            {
                if (mouseEvent.getClickCount() == 1 && mouseEvent.getButton() == 1 && eventType.equals("mouseClicked"))
                {
                    XFLog.info("准备生成...");
                    new Thread(() ->
                    {
                        JDialog d = new JDialog();
                        d.setTitle("选择生成类型");
                        d.setSize(400, 210);
                        d.setLocationRelativeTo(mainWindow);
                        d.setIconImage(new ImageIcon(Resources.getResources(MainWindow.class, "main/resources/images/comp/icon/logo.png")).getImage());
                        d.setResizable(false);
                        d.setLayout(null);

                        JPanel panel = new JPanel();
                        panel.setBounds(0, 0, d.getWidth() - 16, d.getHeight() - 39);
                        panel.setLayout(null);
                        panel.setOpaque(true);
                        panel.setBackground(new Color(45, 45, 45, 255));

                        RadioButtonItem radioButtonItem = new RadioButtonItem("作为Minecraft存档", new int[]{10, 10, 200, 35});
                        RadioButtonItem radioButtonItem2 = new RadioButtonItem("作为Minecraft函数包", new int[]{10, 10 + 35 + 2, 200, 35});
                        RadioButtonItem radioButtonItem3 = new RadioButtonItem("作为JMCS文件进行正整合", new int[]{10, 10 + (35 * 2) + 4, 200, 35});
                        RadioButton radioButton = new RadioButton();
                        radioButton.addRadioButtonItem(radioButtonItem, "1");
                        radioButton.addRadioButtonItem(radioButtonItem2, "2");
                        radioButton.addRadioButtonItem(radioButtonItem3, "3");
                        radioButton.addToWindow(d);

                        PushButton pushButton1 = new PushButton("取消");
                        PushButton pushButton2 = new PushButton("完成");
                        pushButton1.getPushButton().setHorizontalAlignment(SwingConstants.CENTER);
                        pushButton1.getPushButton().setVerticalAlignment(SwingConstants.CENTER);
                        pushButton2.getPushButton().setHorizontalAlignment(SwingConstants.CENTER);
                        pushButton2.getPushButton().setVerticalAlignment(SwingConstants.CENTER);
                        pushButton2.getPushButton().setBounds((d.getWidth() - 16) - 119 - 4, (d.getHeight() - 39) - 41 - 4, 119, 41);
                        pushButton1.getPushButton().setBounds((d.getWidth() - 16) - (119 * 2) - 8, (d.getHeight() - 39) - 41 - 4, 119, 41);
                        d.getContentPane().add(pushButton2.getPushButton());
                        d.getContentPane().add(pushButton1.getPushButton());

                        pushButton1.addClickedConnect(new ClickedConnect()
                        {
                            @Override
                            public void accept(MouseEvent mouseEvent, String eventType)
                            {
                                if (eventType.equals("mouseClicked")) d.setVisible(false);
                            }
                        });

                        pushButton2.addClickedConnect(new ClickedConnect()
                        {
                            @Override
                            public void accept(MouseEvent mouseEvent, String eventType)
                            {
                                if (eventType.equals("mouseClicked"))
                                {
                                    String currentSelectID = radioButton.getCurrentSelectID();
                                    XFLog.debug("获取的ID: " + currentSelectID);
                                    d.setVisible(false);
                                    StartWriteMinecraftMusic.write(currentSelectID, inputBox_1.getSource().getText(), inputBox_2.getSource().getText(), inputBox_3.getSource().getText(), inputBox_4.getSource().getText(), inputBox_5.getSource().getText(), minecraftFunctionFileName);
                                }
                            }
                        });

                        d.getContentPane().add(panel);
                        d.setModal(true);
                        d.setVisible(true);
                    }).start();
                }
            }
        });
    }

    private static void area2()
    {
        list = new List();
        listArea = new JScrollPane(list.getMainContainer());
        listArea.setOpaque(true);
        listArea.setBackground(new Color(0, 0, 0, 0));
        listArea.setBorder(null);
        listArea.getVerticalScrollBar().setUI(new BasicScrollBarUIStyle());
        listArea.getHorizontalScrollBar().setUI(new BasicScrollBarUIStyle());
        rightContainer2.add(listArea);
    }

    public static void updateSaveLists()
    {
        list.clear();
        XFLog.info("初始化工程");
        File[] files = new File("run/saves").listFiles();
        for (File file : files)
        {
            XFLog.info("校验文件类型是否为*.jmcp");
            String filename = file.getAbsolutePath();
            String filetype = filename.substring(filename.length() - 5, filename.length());
            if (filetype.equalsIgnoreCase(".jmcp"))
            {
                XFLog.info("成功扫描到文件: " + file + ", 准备开始读取...");
                ReadJMCPFile.read(file);
                XFLog.info("文件: " + file + "读取结束！");
            }
            else XFLog.info("未知的文件: " + file);
        }
        list.repaint();
        //resize();
    }

    public static void updateSaveList(Object[] datas, String title, String subtitle, String ct, String ut, ListAction listAction)
    {
        XFLog.info("将项添加至列表: " + datas + ", title: " + title + ", subtitle: " + subtitle + ", createtime: " + ct + ", updatetime: " + ut + ", interface: " + listAction);
        list.add(Resources.getResources(MainWindow.class, "main/resources/images/comp/icon/java.png"), datas,
                title,
                subtitle,
                ct,
                ut,
                listAction
        );
        XFLog.info("添加完成！！！");
    }

    private static void flushStart()
    {
        for (int i = 0; i < 24; i++) setImageToLogoImage("frame_" + fillZero(2, i));
    }

    private static void flushEnd()
    {
        for (int i = 24; i > 0; i--) setImageToLogoImage("frame_" + fillZero(2, i));
        setImageToLogoImage("normal");
    }

    private static String fillZero(int length, int number)
    {
        StringBuilder stringBuilder = new StringBuilder();
        int size = String.valueOf(number).length();
        if (size > length) throw new RuntimeException("传进来的数字: " + number + " > 总长度: " + length);
        int loopCount = length - size;
        for (int i = 0; i < loopCount; i++) stringBuilder.append("0");
        stringBuilder.append(number);
        return stringBuilder.toString();
    }

    private static void setImageToLogoImage(String pngFileName)
    {
        logoImage.setIcon(getImageIconForComponentSizeAuto("images/comp/icon/dh/" + pngFileName + ".png", 64, 64));
    }

    private static void area3()
    {
        aboutAppTitle = new JLabel("关于软件");
        aboutAppTitle.setOpaque(true);
        aboutAppTitle.setFont(new Font("微软雅黑", 1, 45));
        aboutAppTitle.setBackground(new Color(0, 0, 0, 0));
        aboutAppTitle.setForeground(Color.decode("#eeeeee"));
        aboutAppTitle.setHorizontalAlignment(SwingConstants.CENTER);
        aboutAppTitle.setVerticalAlignment(SwingConstants.CENTER);
        rightContainer3.add(aboutAppTitle);

        aboutAppImage = new JLabel();
        aboutAppImage.setOpaque(true);
        aboutAppImage.setFont(new Font("微软雅黑", 1, 45));
        aboutAppImage.setBackground(new Color(0, 0, 0, 0));
        aboutAppImage.setForeground(Color.decode("#eeeeee"));
        aboutAppImage.setHorizontalAlignment(SwingConstants.CENTER);
        aboutAppImage.setVerticalAlignment(SwingConstants.CENTER);
        aboutAppImage.setIcon(getImageIconForComponentSizeAuto("images/comp/icon/logo.png", 64, 64));
        rightContainer3.add(aboutAppImage);

        aboutAppImageTitle = new JLabel("  Minecraft 红石音乐生成器");
        aboutAppImageTitle.setOpaque(true);
        aboutAppImageTitle.setFont(new Font("新宋体", 0, 15));
        aboutAppImageTitle.setBackground(new Color(0, 0, 0, 0));
        aboutAppImageTitle.setForeground(Color.decode("#eeeeee"));
        aboutAppImageTitle.setHorizontalAlignment(SwingConstants.LEFT);
        aboutAppImageTitle.setVerticalAlignment(SwingConstants.CENTER);
        rightContainer3.add(aboutAppImageTitle);

        aboutAppImageSubtitle = new JLabel("  Windows 64位 多线程");
        aboutAppImageSubtitle.setOpaque(true);
        aboutAppImageSubtitle.setFont(new Font("新宋体", 0, 11));
        aboutAppImageSubtitle.setBackground(new Color(0, 0, 0, 0));
        aboutAppImageSubtitle.setForeground(new Color(197, 197, 197, 255));
        aboutAppImageSubtitle.setHorizontalAlignment(SwingConstants.LEFT);
        aboutAppImageSubtitle.setVerticalAlignment(SwingConstants.CENTER);
        rightContainer3.add(aboutAppImageSubtitle);

        String text = "\n 软件名:          Minecraft红石音乐生成器\n" +
                " 版本:            1.0.0.567535\n" +
                " 软件用库:        Java Swing | Java AWT\n" +
                " 软件编写语言:    JavaSE JDK-17.0.4 | JavaSE JRE 1.8.0_90\n" +
                " 使用平台:        Windows7以上\n" +
                " 软件开发:        何润\n" +
                " 软件设计:        何润\n" +
                " 软件测试:        何润";

        JTextArea textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setEditable(false);
        textArea.setOpaque(true);
        textArea.setFont(new Font("新宋体", 0, 15));
        textArea.setBackground(new Color(0, 0, 0, 0));
        textArea.setForeground(Color.decode("#eeeeee"));
        textArea.setCaretColor(new Color(255, 255, 255, 255));
        textArea.setSelectionColor(new Color(0, 0, 0, 0));
        textArea.setSelectedTextColor(Color.decode("#eeeeee"));
        aboutAppDescriptionTextBox = new JScrollPane(textArea);
        aboutAppDescriptionTextBox.setOpaque(true);
        aboutAppDescriptionTextBox.setBackground(new Color(0, 0, 0, 0));
        aboutAppDescriptionTextBox.setBorder(new LineBorder(new Color(176, 176, 176, 255)));
        textArea.setText(text);
        rightContainer3.add(aboutAppDescriptionTextBox);
    }

    private static void area3Resize()
    {
        aboutAppTitle.setBounds(0, 10, rightContainer3.getWidth(), 50);
        aboutAppImage.setBounds(10, 10 + 50 + 25, 64, 64);
        aboutAppImageTitle.setBounds(10 + 64 + 5, 10 + 50 + 25, rightContainer3.getWidth() - (10 + 64 + 5), 64 / 2);
        aboutAppImageSubtitle.setBounds(10 + 64 + 5, 10 + 50 + 25 + (64 / 2), rightContainer3.getWidth() - (10 + 64 + 5), 64 / 2);
        aboutAppDescriptionTextBox.setBounds(10, 10 + 50 + 25 + ((64 / 2) * 2) + 10, rightContainer3.getWidth() - 20, (rightContainer3.getHeight() - 10 + 50 + 25 + ((64 / 2) * 2)) - (10 * 40) + 95);
    }

    private static void addComp()
    {
        createWindow();
        mainContainer = new JPanel();
        mainContainer.setLayout(null);
        mainContainer.setOpaque(true);
        mainContainer.setBackground(new Color(45, 45, 45, 255));

        leftContainer = new JPanel();
        leftContainer.setLayout(null);
        leftContainer.setOpaque(true);
        leftContainer.setBackground(new Color(33, 33, 33, 255));
        logoImage = new JLabel("", JLabel.CENTER);
        logoImage.setOpaque(true);
        logoImage.setBackground(new Color(0, 0, 0, 0));
        logoImage.setForeground(new Color(0, 0, 0, 0));
        logoImage.setIcon(getImageIconForComponentSizeAuto("images/comp/icon/logo.png", 64, 64));
        logoImage.addMouseListener(new MouseListener()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                if (e.getButton() == 1)
                {
                    XFLog.info("执行JMCS文件");
                    if (isRunJMCSFile)
                    {
                        new Thread(() ->
                        {
                            XFLog.info("开始JMCS文件");
                            flushEnd();
                            ExecuteJavaMinecraftSaveFile.execute();
                        }).start();
                        isRunJMCSFile = false;
                    }
                    else XFLog.info("不可以重复执行JMCS文件");
                }
                else if (e.getButton() == 3)
                {
                    XFLog.info("执行JMCS文件");
                    if (isRunJMCSFile)
                    {
                        new Thread(() ->
                        {
                            XFLog.info("提取所有的模组");
                            flushEnd();
                            // ArrayList<String> arrayList = ForJarResources.for_("run/close_the_mods");
                            ArrayList<String> arrayList = new ArrayList<>();
                            String path = "/main/resources/run/close_the_mods/";
                            arrayList.add(path + "aperture-1.7-devHexA-1.12.2.jar");
                            arrayList.add(path + "BetterFps-1.4.8.jar");
                            arrayList.add(path + "BiomesOPlenty-1.12.2-7.0.1.2445-universal.jar");
                            arrayList.add(path + "chameleon-1.1.1-devHexA.jar");
                            arrayList.add(path + "ChickenChunks-1.12.2.jar");
                            arrayList.add(path + "chiselsandbits-14.17.jar");
                            arrayList.add(path + "CodeChickenLib-1.12.2.jar");
                            arrayList.add(path + "commander-1.1-1.12.2.jar");
                            arrayList.add(path + "CubicChunks-1.12.2-0.0.1208.0-SNAPSHOT-all.jar");
                            arrayList.add(path + "CubicWorldGen-1.12.2-0.0.152.0-SNAPSHOT-all.jar");
                            arrayList.add(path + "decorative-1.0.0.jar");
                            arrayList.add(path + "DrZharks+MoCreatures+Mod-12.0.5.jar");
                            arrayList.add(path + "emoticons-1.0.2-1.12.2-dist.jar");
                            arrayList.add(path + "extendedreach-1.1-1.12.2.jar");
                            arrayList.add(path + "ExtendPolyphonyLimit-1.3-for1.8-1.12.2.jar");
                            arrayList.add(path + "furniture-6.3.1-1.12.2.jar");
                            arrayList.add(path + "horror_untitled_map-1.0.0.jar");
                            arrayList.add(path + "Keystrokes-7.0 (1.12.2).jar");
                            arrayList.add(path + "Logger-1.2.1.jar");
                            arrayList.add(path + "malisiscore-1.12.2-6.5.1.jar");
                            arrayList.add(path + "malisisdoors-1.12.2-7.3.0.jar");
                            arrayList.add(path + "mcdl-1.0.0.jar");
                            arrayList.add(path + "mclib-2.3.6-devHexA-1.12.2.jar");
                            arrayList.add(path + "mdxlib-3.0.0.20.jar");
                            arrayList.add(path + "metamorph-1.2.12-devHexA-1.12.2.jar");
                            arrayList.add(path + "Midi Out.jar");
                            arrayList.add(path + "midic-1.0.0.jar");
                            arrayList.add(path + "OpenEye.jar");
                            arrayList.add(path + "OptiFine_1.12.2_HD_U_F5.jar");
                            arrayList.add(path + "pianoblock1.0.0-1.12.2.jar");
                            arrayList.add(path + "replaymod-1.12.2-2.5.2.jar");
                            arrayList.add(path + "thutcore-1.12.2-5.16.3.jar");
                            arrayList.add(path + "thuttech-1.12.2-6.0.16.jar");
                            arrayList.add(path + "TickrateChanger-Mod-1.12.2.jar");
                            arrayList.add(path + "UprightPianoModelsMod-Java-Forge-1.12.2.jar");
                            arrayList.add(path + "worldedit-forge-mc1.12-6.1.8-dist.jar");
                            if (arrayList != null)
                            {
                                JFileChooser jFileChooser = new JFileChooser("./");
                                jFileChooser.setDialogTitle("选择要保存模组的文件位置 :: 是zip格式的");
                                jFileChooser.setMultiSelectionEnabled(false);
                                jFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                                int status = jFileChooser.showOpenDialog(MainWindow.getMainWindow());
                                if (status == 0)
                                {
                                    File selectedFile = jFileChooser.getSelectedFile();
                                    if (selectedFile != null)
                                    {
                                        String fileName = JOptionPane.showInputDialog(MainWindow.getMainWindow(), "输入文件名, 不加后缀: ",
                                                "保存的文件", 1);
                                        try
                                        {
                                            boolean regex = Regex.regex(fileName, "\\/:*?\"<>|");
                                            if (regex)
                                            {
                                                boolean word = CompareMultipleStrings.compareMultipleStrings(fileName,
                                                        "CON",
                                                        "PRN",
                                                        "AUX",
                                                        "CLOCK$",
                                                        "NUL",
                                                        "COM1",
                                                        "COM2",
                                                        "COM3",
                                                        "COM4",
                                                        "COM5",
                                                        "COM6",
                                                        "COM7",
                                                        "COM8",
                                                        "COM9",
                                                        "LPT1");
                                                if (word)
                                                {
                                                    if (!fileName.equalsIgnoreCase(""))
                                                    {
                                                        File resultFileName = new File(selectedFile + "/" + fileName + ".zip").getAbsoluteFile();
                                                        if (!resultFileName.exists())
                                                        {
                                                            XFLog.info("选中的目录::文件: " + resultFileName);
                                                            GetMods.getAll(arrayList, resultFileName);
                                                            XFLog.info("保存完毕!");
                                                            MainWindow.setIsRunJMCSFile(true);
                                                        }
                                                        else
                                                        {
                                                            XFLog.warn("已存在文件: " + resultFileName);
                                                            JOptionPane.showMessageDialog(MainWindow.getMainWindow(),
                                                                    "文件已存在, 请输入别的文件名:\n" + resultFileName,
                                                                    "警告", 2);
                                                            MainWindow.setIsRunJMCSFile(true);
                                                        }
                                                    }
                                                    else
                                                    {
                                                        XFLog.warn("文件名不能为空");
                                                        JOptionPane.showMessageDialog(MainWindow.getMainWindow(),
                                                                "文件名不能为空",
                                                                "警告", 2);
                                                        MainWindow.setIsRunJMCSFile(true);
                                                    }
                                                }
                                                else
                                                {
                                                    XFLog.warn("无效的文件名: " + fileName);
                                                    JOptionPane.showMessageDialog(MainWindow.getMainWindow(),
                                                            "无效的文件名: " + fileName,
                                                            "警告", 2);
                                                    MainWindow.setIsRunJMCSFile(true);
                                                }
                                            }
                                            else
                                            {
                                                XFLog.warn("无效的文件名: " + fileName);
                                                JOptionPane.showMessageDialog(MainWindow.getMainWindow(),
                                                        "无效的文件名: " + fileName,
                                                        "警告", 2);
                                                MainWindow.setIsRunJMCSFile(true);
                                            }
                                            MainWindow.setIsRunJMCSFile(true);
                                        }
                                        catch (Exception ex)
                                        {
                                            XFLog.warn("这个异常可以忽略", ex);
                                            MainWindow.setIsRunJMCSFile(true);
                                        }
                                    }
                                    else
                                    {
                                        XFLog.info("选择的目录为: null");
                                        MainWindow.setIsRunJMCSFile(true);
                                    }
                                }
                                else
                                {
                                    XFLog.info("用户已退出");
                                    MainWindow.setIsRunJMCSFile(true);
                                }
                                MainWindow.setIsRunJMCSFile(true);
                            }
                            else
                            {
                                XFLog.warn("无法提取模组, 应为里面没有可提取的模组");
                                JOptionPane.showMessageDialog(MainWindow.getMainWindow(),
                                        "无法提取模组, 应为里面没有可提取的模组", "警告", 0);
                                MainWindow.setIsRunJMCSFile(true);
                            }
                        }).start();
                        isRunJMCSFile = false;
                    }
                    else XFLog.info("不可以重复执行JMCS文件");
                }
            }

            @Override
            public void mousePressed(MouseEvent e)
            {

            }

            @Override
            public void mouseReleased(MouseEvent e)
            {

            }

            @Override
            public void mouseEntered(MouseEvent e)
            {
                mainWindow.setTitle("Minecraft红石音乐生成器 :: 点击运行jmcs文件 :: 右键提取所有模组");
                new Thread(MainWindow::flushStart).start();
            }

            @Override
            public void mouseExited(MouseEvent e)
            {
                mainWindow.setTitle("Minecraft红石音乐生成器");
                new Thread(MainWindow::flushEnd).start();
            }
        });
        leftContainer.add(logoImage);

        rightContainer1 = new JPanel();
        rightContainer1.setOpaque(true);
        rightContainer1.setBackground(new Color(0, 0, 0, 0));
        rightContainer1.setForeground(new Color(0, 0, 0, 0));
        rightContainer1.setBorder(null);
        rightContainer1.setLayout(null);
        rightContainer2 = new JPanel();
        rightContainer2.setOpaque(true);
        rightContainer2.setBackground(new Color(0, 0, 0, 0));
        rightContainer2.setForeground(new Color(0, 0, 0, 0));
        rightContainer2.setBorder(null);
        rightContainer2.setLayout(null);
        rightContainer3 = new JPanel();
        rightContainer3.setOpaque(true);
        rightContainer3.setBackground(new Color(0, 0, 0, 0));
        rightContainer3.setForeground(new Color(0, 0, 0, 0));
        rightContainer3.setBorder(null);
        rightContainer3.setLayout(null);
        area1();
        area2();
        area3();
        mainContainer.add(rightContainer1);
        mainContainer.add(rightContainer2);
        mainContainer.add(rightContainer3);

        buttonArea = new JPanel();
        buttonArea.setOpaque(true);
        buttonArea.setLayout(null);
        buttonArea.setBackground(new Color(0, 0, 0, 0));
        buttonArea.setForeground(new Color(0, 0, 0, 0));

        pushButton = new PushButton("新建工程");
        pushButton.getPushButton().setHorizontalAlignment(SwingConstants.CENTER);
        pushButton.getPushButton().setFont(new Font("新宋体", 0, 15));
        buttonArea.add(pushButton.getPushButton());

        pushButton_2 = new PushButton("本地工程");
        pushButton_2.getPushButton().setHorizontalAlignment(SwingConstants.CENTER);
        pushButton_2.getPushButton().setFont(new Font("新宋体", 0, 15));
        buttonArea.add(pushButton_2.getPushButton());

        pushButton_3 = new PushButton("关于软件");
        pushButton_3.getPushButton().setHorizontalAlignment(SwingConstants.CENTER);
        pushButton_3.getPushButton().setFont(new Font("新宋体", 0, 15));
        buttonArea.add(pushButton_3.getPushButton());

        setCurrentSelectPage(0);
        pushButton.addClickedConnect(new ClickedConnect()
        {
            @Override
            public void accept(MouseEvent mouseEvent, String eventType)
            {
                if (eventType.equals("mouseClicked"))
                {
                    if (mouseEvent.getButton() == 1 && mouseEvent.getClickCount() == 1)
                    {
                        setCurrentSelectPage(0);
                    }
                }
            }
        });
        pushButton_2.addClickedConnect(new ClickedConnect()
        {
            @Override
            public void accept(MouseEvent mouseEvent, String eventType)
            {
                if (eventType.equals("mouseClicked"))
                {
                    if (mouseEvent.getButton() == 1 && mouseEvent.getClickCount() == 1)
                    {
                        setCurrentSelectPage(1);
                        updateJMCP();
                    }
                }
            }
        });
        pushButton_3.addClickedConnect(new ClickedConnect()
        {
            @Override
            public void accept(MouseEvent mouseEvent, String eventType)
            {
                if (eventType.equals("mouseClicked"))
                {
                    if (mouseEvent.getButton() == 1 && mouseEvent.getClickCount() == 1)
                    {
                        setCurrentSelectPage(2);
                    }
                }
            }
        });

        leftContainer.add(buttonArea);


        mainContainer.add(leftContainer);

        mainWindow.getContentPane().add(mainContainer);
    }

    public static void updateJMCP()
    {
        rightContainer2.remove(list.getMainContainer());
        list = new List();
        listArea.setViewportView(list.getMainContainer());
        updateSaveLists();
        list.rep();
        // new Thread(MainWindow::updateSaveLists).start();
    }

    public static void setCurrentSelectPage(int page)
    {
        pushButton.setEnabled(true);
        pushButton_2.setEnabled(true);
        pushButton_3.setEnabled(true);
        rightContainer1.setVisible(false);
        rightContainer2.setVisible(false);
        rightContainer3.setVisible(false);
        switch (page)
        {
            case 0 ->
            {
                pushButton.setEnabled(false);
                rightContainer1.setVisible(true);
            }
            case 1 ->
            {
                pushButton_2.setEnabled(false);
                rightContainer2.setVisible(true);
            }
            case 2 ->
            {
                pushButton_3.setEnabled(false);
                rightContainer3.setVisible(true);
            }
        }
    }

    private static void setText()
    {
        mainWindow.setTitle("Minecraft红石音乐生成器");
    }

    private static void createWindow()
    {
        mainWindow = new JFrame();
        mainWindow.setSize(973, 572);
        mainWindow.setMinimumSize(new Dimension(920 + 41, 570));
        mainWindow.setLayout(null);
        mainWindow.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        mainWindow.setLocationRelativeTo(null);
        mainWindow.setResizable(true);
        /*mainWindow.setUndecorated(true);
        mainWindow.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);*/
        mainWindow.addWindowListener(new WindowListener()
        {
            @Override
            public void windowOpened(WindowEvent e)
            {

            }

            @Override
            public void windowClosing(WindowEvent e)
            {
                exit();
            }

            @Override
            public void windowClosed(WindowEvent e)
            {

            }

            @Override
            public void windowIconified(WindowEvent e)
            {

            }

            @Override
            public void windowDeiconified(WindowEvent e)
            {

            }

            @Override
            public void windowActivated(WindowEvent e)
            {

            }

            @Override
            public void windowDeactivated(WindowEvent e)
            {

            }
        });
        mainWindow.addComponentListener(new ComponentListener()
        {
            @Override
            public void componentResized(ComponentEvent e)
            {
                resize();
            }

            @Override
            public void componentMoved(ComponentEvent e)
            {

            }

            @Override
            public void componentShown(ComponentEvent e)
            {

            }

            @Override
            public void componentHidden(ComponentEvent e)
            {

            }
        });
        MainWindow.getMainWindow().setExtendedState(Frame.MAXIMIZED_BOTH);
    }

    private static void exit()
    {
        XFLog.info("退出中...");
        mainWindow.removeAll();
        mainWindow.revalidate();
        mainWindow.repaint();
        Thread runnable = new Thread()
        {
            public void run()
            {
                Sleep.sleep(new Random().nextInt(1000, 2345));
                XFLog.info("关闭服务...");
                XFLog.info("Stopping...");
                ChangePage.isOpen = true;
                mainWindow.setVisible(false);
            }
        };
        runnable.start();
    }

    public static JFrame getMainWindow()
    {
        return mainWindow;
    }

    public static JPanel getMainContainer()
    {
        return mainContainer;
    }

    public static JPanel getLeftContainer()
    {
        return leftContainer;
    }

    public static JPanel getRightContainer1()
    {
        return rightContainer1;
    }

    public static JPanel getRightContainer2()
    {
        return rightContainer2;
    }

    public static JPanel getRightContainer3()
    {
        return rightContainer3;
    }

    public static JPanel getButtonArea()
    {
        return buttonArea;
    }

    public static PushButton getPushButton()
    {
        return pushButton;
    }

    public static PushButton getPushButton_2()
    {
        return pushButton_2;
    }

    public static PushButton getPushButton_3()
    {
        return pushButton_3;
    }

    public static JLabel getLogoImage()
    {
        return logoImage;
    }

    public static JScrollPane getListArea()
    {
        return listArea;
    }

    public static List getList()
    {
        return list;
    }

    public static JScrollPane getNewProjectMainBox()
    {
        return newProjectMainBox;
    }

    public static JPanel getNewProjectMainBoxPanel()
    {
        return newProjectMainBoxPanel;
    }

    public static JPanel getPanel_title_bar()
    {
        return panel_title_bar;
    }

    public static JScrollPane getTextSp()
    {
        return textSp;
    }

    public static JPanel getPanel_title_bar_2()
    {
        return panel_title_bar_2;
    }

    public static JTextField getTitle_2()
    {
        return title_2;
    }

    public static JPanel getMainPanel()
    {
        return mainPanel;
    }

    public static InputBox getInputBox_1()
    {
        return inputBox_1;
    }

    public static InputBox getInputBox_2()
    {
        return inputBox_2;
    }

    public static InputBox getInputBox_3()
    {
        return inputBox_3;
    }

    public static InputBox getInputBox_4()
    {
        return inputBox_4;
    }

    public static InputBox getInputBox_5()
    {
        return inputBox_5;
    }

    public static PushButton getInputBox_1Button()
    {
        return inputBox_1Button;
    }

    public static PushButton getInputBox_2Button()
    {
        return inputBox_2Button;
    }

    public static PushButton getInputBox_3Button()
    {
        return inputBox_3Button;
    }

    public static PushButton getInputBox_4Button()
    {
        return inputBox_4Button;
    }

    public static PushButton getInputBox_5Button()
    {
        return inputBox_5Button;
    }

    public static PushButton getInputBox_6Button()
    {
        return inputBox_6Button;
    }

    public static String getMinecraftFunctionFileName()
    {
        return minecraftFunctionFileName;
    }

    public static JLabel getAboutAppTitle()
    {
        return aboutAppTitle;
    }

    public static JLabel getAboutAppImage()
    {
        return aboutAppImage;
    }

    public static JLabel getAboutAppImageTitle()
    {
        return aboutAppImageTitle;
    }

    public static JLabel getAboutAppImageSubtitle()
    {
        return aboutAppImageSubtitle;
    }

    public static JScrollPane getAboutAppDescriptionTextBox()
    {
        return aboutAppDescriptionTextBox;
    }

    public static boolean isIsRunJMCSFile()
    {
        return isRunJMCSFile;
    }

    public static void setIsRunJMCSFile(boolean isRunJMCSFile)
    {
        MainWindow.isRunJMCSFile = isRunJMCSFile;
    }
}
