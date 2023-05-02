package main.java.com.xfherun.jmci.user_interface.section;

import main.java.com.xfherun.jmci.frame_file.ReadFrameFile;
import main.java.com.xfherun.jmci.swing_util.button.XFButton;
import main.java.com.xfherun.jmci.swing_util.button.i.ButtonClick;
import main.java.com.xfherun.jmci.user_interface.MainWindow;
import main.java.com.xfherun.jmci.user_interface.section.page_1.file_system.InitList;
import main.java.com.xfherun.jmci.user_interface.section.page_1.file_system.RightMenu;
import main.java.com.xfherun.jmci.utils.ReadTextFile;
import main.java.com.xfherun.jmci.write_to_minecraft.WriteMinecraftToJMCI;
import main.java.com.xfherun.jmci.write_to_minecraft.WriteToMinecraft;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.io.File;

public class MainContainerPage_3
{
    private static JPanel mainContainerPanel;
    private static JPanel mainContainerPanelLeft;
    private static JPanel mainContainerPanelRight;
    private static JPanel mainContainerPanelLeftTop;
    private static JPanel mainContainerPanelLeftTCenter;
    private static JPanel mainContainerPanelLeftTFooter;
    private static JPanel mainContainerPanelRightTop;
    private static JPanel mainContainerPanelRightFooter;
    private static JTextArea mainContainerPanelRightTopTextArea;
    private static JTextArea mainContainerPanelRightFooterTextArea;
    private static JScrollPane mainContainerPanelRightTopTextAreaScrollPane;
    private static JScrollPane mainContainerPanelRightFooterTextAreaScrollPane;
    private static XFButton mainContainerPanelLeftTopFileButton;
    private static XFButton mainContainerPanelLeftFooterBackButton;
    private static XFButton mainContainerPanelLeftFooterGeneratorButton;
    private static JLabel mainContainerPanelLeftTCenterInputMinecraftPathLabel;
    private static JLabel mainContainerPanelLeftTCenterInputMidiPathLabel;
    private static JLabel mainContainerPanelLeftTCenterInputTitleLabel;
    private static JLabel mainContainerPanelLeftTCenterInputSubtitleLabel;
    private static JTextField mainContainerPanelLeftTCenterInputMinecraftPathTextField;
    private static JTextField mainContainerPanelLeftTCenterInputMidiPathTextField;
    private static JTextField mainContainerPanelLeftTCenterInputTitleTextField;
    private static JTextField mainContainerPanelLeftTCenterInputSubtitleTextField;

    private MainContainerPage_3()
    {
    }

    public static void init()
    {
        mainContainerPanel = new JPanel();
        mainContainerPanel.setBounds(0, 0, MainWindow.getMainContainer().getWidth(),
                MainWindow.getMainContainer().getHeight());
        mainContainerPanel.setLayout(null);
        mainContainerPanel.setBackground(new Color(29, 115, 27, 255));
        mainContainerPanel.setLayout(null);
        addItems();
        mainContainerPanel.setVisible(false);
        MainWindow.getMainContainer().add(mainContainerPanel);
    }

    private static void addItems()
    {
        mainContainerPanelLeft = new JPanel();
        mainContainerPanelRight = new JPanel();
        mainContainerPanelLeft.setBounds(0, 0, 250, mainContainerPanel.getHeight());
        mainContainerPanelLeft.setOpaque(true);
        mainContainerPanelLeft.setLayout(null);
        mainContainerPanelLeft.setBackground(new Color(0, 0, 0, 0));
        mainContainerPanelLeft.setBorder(new LineBorder(new Color(190, 190, 190, 255)));
        mainContainerPanel.add(mainContainerPanelLeft);
        mainContainerPanelRight.setBounds(250, 0, mainContainerPanel.getWidth() - 250, mainContainerPanel.getHeight());
        mainContainerPanelRight.setOpaque(true);
        mainContainerPanelRight.setLayout(null);
        mainContainerPanelRight.setBackground(new Color(0, 0, 0, 0));
        mainContainerPanelRight.setBorder(new LineBorder(new Color(190, 190, 190, 255)));
        mainContainerPanel.add(mainContainerPanelRight);
        mainContainerPanelLeftTop = new JPanel();
        mainContainerPanelLeftTop.setBounds(0, 0, 250, 35);
        mainContainerPanelLeftTop.setOpaque(true);
        mainContainerPanelLeftTop.setLayout(null);
        mainContainerPanelLeftTop.setBackground(new Color(0, 0, 0, 0));
        mainContainerPanelLeftTop.setBorder(new LineBorder(new Color(190, 190, 190, 255)));
        mainContainerPanelLeft.add(mainContainerPanelLeftTop);
        mainContainerPanelLeftTCenter = new JPanel();
        mainContainerPanelLeftTCenter.setBounds(0, 35, 250, mainContainerPanelLeft.getHeight() - (35 * 2));
        mainContainerPanelLeftTCenter.setOpaque(true);
        mainContainerPanelLeftTCenter.setLayout(null);
        mainContainerPanelLeftTCenter.setBackground(new Color(0, 0, 0, 0));
        mainContainerPanelLeftTCenter.setBorder(new LineBorder(new Color(190, 190, 190, 255)));
        mainContainerPanelLeft.add(mainContainerPanelLeftTCenter);
        mainContainerPanelLeftTFooter = new JPanel();
        mainContainerPanelLeftTFooter.setBounds(0, mainContainerPanelLeft.getHeight() - 35, 250, 35);
        mainContainerPanelLeftTFooter.setOpaque(true);
        mainContainerPanelLeftTFooter.setLayout(null);
        mainContainerPanelLeftTFooter.setBackground(new Color(0, 0, 0, 0));
        mainContainerPanelLeftTFooter.setBorder(new LineBorder(new Color(190, 190, 190, 255)));
        mainContainerPanelLeft.add(mainContainerPanelLeftTFooter);
        mainContainerPanelRightTop = new JPanel();
        mainContainerPanelRightTop.setBounds(0, 0, mainContainerPanelRight.getWidth(), mainContainerPanelRight.getHeight() - 119);
        mainContainerPanelRightTop.setOpaque(true);
        mainContainerPanelRightTop.setLayout(null);
        mainContainerPanelRightTop.setBackground(new Color(0, 0, 0, 0));
        mainContainerPanelRightTop.setBorder(new LineBorder(new Color(190, 190, 190, 255)));
        mainContainerPanelRight.add(mainContainerPanelRightTop);
        mainContainerPanelRightFooter = new JPanel();
        mainContainerPanelRightFooter.setBounds(0, mainContainerPanelRight.getHeight() - 119, mainContainerPanelRight.getWidth(), 119);
        mainContainerPanelRightFooter.setOpaque(true);
        mainContainerPanelRightFooter.setLayout(null);
        mainContainerPanelRightFooter.setBackground(new Color(0, 0, 0, 0));
        mainContainerPanelRightFooter.setBorder(new LineBorder(new Color(190, 190, 190, 255)));
        mainContainerPanelRight.add(mainContainerPanelRightFooter);
        addTextArea();
        addButtons();
        addAttr();
        addAttrBox();
    }

    private static void addAttrBox()
    {
        mainContainerPanelLeftTCenterInputMinecraftPathTextField = new JTextField();
        mainContainerPanelLeftTCenterInputMinecraftPathTextField.setBounds(0,
                mainContainerPanelLeftTCenterInputMinecraftPathLabel.getY() +
                        mainContainerPanelLeftTCenterInputMinecraftPathLabel.getHeight(),
                mainContainerPanelLeftTCenter.getWidth(),
                35);
        mainContainerPanelLeftTCenterInputMinecraftPathTextField.setOpaque(true);
        mainContainerPanelLeftTCenterInputMinecraftPathTextField.setBackground(new Color(0, 0, 0, 0));
        mainContainerPanelLeftTCenterInputMinecraftPathTextField.setBorder(new LineBorder(Color.decode("#eeeeee")));
        mainContainerPanelLeftTCenterInputMinecraftPathTextField.setForeground(Color.decode("#eeeeee"));
        mainContainerPanelLeftTCenterInputMinecraftPathTextField.setSelectedTextColor(Color.WHITE);
        mainContainerPanelLeftTCenterInputMinecraftPathTextField.setSelectionColor(Color.BLUE);
        mainContainerPanelLeftTCenterInputMinecraftPathTextField.setCaretColor(Color.decode("#eeeeee"));
        mainContainerPanelLeftTCenter.add(mainContainerPanelLeftTCenterInputMinecraftPathTextField);

        mainContainerPanelLeftTCenterInputMidiPathTextField = new JTextField();
        mainContainerPanelLeftTCenterInputMidiPathTextField.setBounds(0,
                mainContainerPanelLeftTCenterInputMidiPathLabel.getY() +
                        mainContainerPanelLeftTCenterInputMidiPathLabel.getHeight(),
                mainContainerPanelLeftTCenter.getWidth(),
                35);
        mainContainerPanelLeftTCenterInputMidiPathTextField.setOpaque(true);
        mainContainerPanelLeftTCenterInputMidiPathTextField.setBackground(new Color(0, 0, 0, 0));
        mainContainerPanelLeftTCenterInputMidiPathTextField.setBorder(new LineBorder(Color.decode("#eeeeee")));
        mainContainerPanelLeftTCenterInputMidiPathTextField.setForeground(Color.decode("#eeeeee"));
        mainContainerPanelLeftTCenterInputMidiPathTextField.setSelectedTextColor(Color.WHITE);
        mainContainerPanelLeftTCenterInputMidiPathTextField.setSelectionColor(Color.BLUE);
        mainContainerPanelLeftTCenterInputMidiPathTextField.setCaretColor(Color.decode("#eeeeee"));
        mainContainerPanelLeftTCenter.add(mainContainerPanelLeftTCenterInputMidiPathTextField);

        mainContainerPanelLeftTCenterInputTitleTextField = new JTextField();
        mainContainerPanelLeftTCenterInputTitleTextField.setBounds(0,
                mainContainerPanelLeftTCenterInputTitleLabel.getY() +
                        mainContainerPanelLeftTCenterInputTitleLabel.getHeight(),
                mainContainerPanelLeftTCenter.getWidth(),
                35);
        mainContainerPanelLeftTCenterInputTitleTextField.setOpaque(true);
        mainContainerPanelLeftTCenterInputTitleTextField.setBackground(new Color(0, 0, 0, 0));
        mainContainerPanelLeftTCenterInputTitleTextField.setBorder(new LineBorder(Color.decode("#eeeeee")));
        mainContainerPanelLeftTCenterInputTitleTextField.setForeground(Color.decode("#eeeeee"));
        mainContainerPanelLeftTCenterInputTitleTextField.setSelectedTextColor(Color.WHITE);
        mainContainerPanelLeftTCenterInputTitleTextField.setSelectionColor(Color.BLUE);
        mainContainerPanelLeftTCenterInputTitleTextField.setCaretColor(Color.decode("#eeeeee"));
        mainContainerPanelLeftTCenter.add(mainContainerPanelLeftTCenterInputTitleTextField);

        mainContainerPanelLeftTCenterInputSubtitleTextField = new JTextField();
        mainContainerPanelLeftTCenterInputSubtitleTextField.setBounds(0,
                mainContainerPanelLeftTCenterInputSubtitleLabel.getY() +
                        mainContainerPanelLeftTCenterInputSubtitleLabel.getHeight(),
                mainContainerPanelLeftTCenter.getWidth(),
                35);
        mainContainerPanelLeftTCenterInputSubtitleTextField.setOpaque(true);
        mainContainerPanelLeftTCenterInputSubtitleTextField.setBackground(new Color(0, 0, 0, 0));
        mainContainerPanelLeftTCenterInputSubtitleTextField.setBorder(new LineBorder(Color.decode("#eeeeee")));
        mainContainerPanelLeftTCenterInputSubtitleTextField.setForeground(Color.decode("#eeeeee"));
        mainContainerPanelLeftTCenterInputSubtitleTextField.setSelectedTextColor(Color.WHITE);
        mainContainerPanelLeftTCenterInputSubtitleTextField.setSelectionColor(Color.BLUE);
        mainContainerPanelLeftTCenterInputSubtitleTextField.setCaretColor(Color.decode("#eeeeee"));
        mainContainerPanelLeftTCenter.add(mainContainerPanelLeftTCenterInputSubtitleTextField);
    }

    private static void addAttr()
    {
        mainContainerPanelLeftTCenterInputMinecraftPathLabel = new JLabel(".minecraft路径: ↓", JLabel.LEFT);
        mainContainerPanelLeftTCenterInputMinecraftPathLabel.setBounds(0, 0, 100, 35);
        mainContainerPanelLeftTCenterInputMinecraftPathLabel.setOpaque(true);
        mainContainerPanelLeftTCenterInputMinecraftPathLabel.setBorder(new LineBorder(new Color(0, 0, 0, 0)));
        mainContainerPanelLeftTCenterInputMinecraftPathLabel.setBackground(new Color(0, 0, 0, 0));
        mainContainerPanelLeftTCenterInputMinecraftPathLabel.setForeground(Color.decode("#eeeeee"));
        mainContainerPanelLeftTCenter.add(mainContainerPanelLeftTCenterInputMinecraftPathLabel);

        mainContainerPanelLeftTCenterInputMidiPathLabel = new JLabel("midi路径: ↓", JLabel.LEFT);
        mainContainerPanelLeftTCenterInputMidiPathLabel.setBounds(0, (35 * 2), 100, 35);
        mainContainerPanelLeftTCenterInputMidiPathLabel.setOpaque(true);
        mainContainerPanelLeftTCenterInputMidiPathLabel.setBorder(new LineBorder(new Color(0, 0, 0, 0)));
        mainContainerPanelLeftTCenterInputMidiPathLabel.setBackground(new Color(0, 0, 0, 0));
        mainContainerPanelLeftTCenterInputMidiPathLabel.setForeground(Color.decode("#eeeeee"));
        mainContainerPanelLeftTCenter.add(mainContainerPanelLeftTCenterInputMidiPathLabel);

        mainContainerPanelLeftTCenterInputTitleLabel = new JLabel("主标题: ↓", JLabel.LEFT);
        mainContainerPanelLeftTCenterInputTitleLabel.setBounds(0, (35 * 4), 100, 35);
        mainContainerPanelLeftTCenterInputTitleLabel.setOpaque(true);
        mainContainerPanelLeftTCenterInputTitleLabel.setBorder(new LineBorder(new Color(0, 0, 0, 0)));
        mainContainerPanelLeftTCenterInputTitleLabel.setBackground(new Color(0, 0, 0, 0));
        mainContainerPanelLeftTCenterInputTitleLabel.setForeground(Color.decode("#eeeeee"));
        mainContainerPanelLeftTCenter.add(mainContainerPanelLeftTCenterInputTitleLabel);

        mainContainerPanelLeftTCenterInputSubtitleLabel = new JLabel("副标题: ↓", JLabel.LEFT);
        mainContainerPanelLeftTCenterInputSubtitleLabel.setBounds(0, (35 * 6), 100, 35);
        mainContainerPanelLeftTCenterInputSubtitleLabel.setOpaque(true);
        mainContainerPanelLeftTCenterInputSubtitleLabel.setBorder(new LineBorder(new Color(0, 0, 0, 0)));
        mainContainerPanelLeftTCenterInputSubtitleLabel.setBackground(new Color(0, 0, 0, 0));
        mainContainerPanelLeftTCenterInputSubtitleLabel.setForeground(Color.decode("#eeeeee"));
        mainContainerPanelLeftTCenter.add(mainContainerPanelLeftTCenterInputSubtitleLabel);
    }

    private static void addButtons()
    {
        mainContainerPanelLeftTopFileButton = new XFButton("选择jmci文件进行写入");
        mainContainerPanelLeftTopFileButton.setBounds(0, 0, mainContainerPanelLeftTop.getWidth(), mainContainerPanelLeftTop.getHeight());
        mainContainerPanelLeftTopFileButton.addMouseClicked(new ButtonClick()
        {
            @Override
            public void clicked(MouseEvent event)
            {
                main.java.com.xfherun.jmci.user_interface.section.page_3.file_system.InitList.init();
            }

            @Override
            public void mouseRightClicked(MouseEvent event)
            {
                main.java.com.xfherun.jmci.user_interface.section.page_3.file_system.RightMenu.init();
            }
        });
        mainContainerPanelLeftTopFileButton.addWindow(mainContainerPanelLeftTop);

        mainContainerPanelLeftFooterBackButton = new XFButton("返回主页");
        mainContainerPanelLeftFooterGeneratorButton = new XFButton("开始生成");
        mainContainerPanelLeftFooterBackButton.setBounds(0, 0, mainContainerPanelLeftTFooter.getWidth() / 2, mainContainerPanelLeftTFooter.getHeight());
        mainContainerPanelLeftFooterGeneratorButton.setBounds(mainContainerPanelLeftTFooter.getWidth() / 2, 0, mainContainerPanelLeftTFooter.getWidth() / 2, mainContainerPanelLeftTFooter.getHeight());
        mainContainerPanelLeftFooterBackButton.addMouseClicked(new ButtonClick()
        {
            @Override
            public void clicked(MouseEvent event)
            {
                MainContainerPageHome.setPageToCurrent(0);
            }
        });
        mainContainerPanelLeftFooterBackButton.addWindow(mainContainerPanelLeftTFooter);
        mainContainerPanelLeftFooterGeneratorButton.addMouseClicked(new ButtonClick()
        {
            @Override
            public void clicked(MouseEvent event)
            {
                WriteToMinecraft.write(
                        mainContainerPanelLeftTCenterInputMinecraftPathTextField.getText(),
                        mainContainerPanelLeftTCenterInputMidiPathTextField.getText(),
                        mainContainerPanelLeftTCenterInputTitleTextField.getText(),
                        mainContainerPanelLeftTCenterInputSubtitleTextField.getText(),
                        WriteMinecraftToJMCI.jmciFile
                );
            }
        });
        mainContainerPanelLeftFooterGeneratorButton.addWindow(mainContainerPanelLeftTFooter);
    }

    private static void addTextArea()
    {
        mainContainerPanelRightTopTextArea = new JTextArea();
        mainContainerPanelRightTopTextArea.setEditable(true);
        mainContainerPanelRightTopTextArea.setLineWrap(false);
        mainContainerPanelRightTopTextArea.setEditable(false);
        mainContainerPanelRightTopTextArea.setFont(new Font("新宋体", 0, 15));
        mainContainerPanelRightTopTextArea.setOpaque(true);
        mainContainerPanelRightTopTextArea.setTabSize(0);
        mainContainerPanelRightTopTextArea.setSelectedTextColor(Color.WHITE);
        mainContainerPanelRightTopTextArea.setSelectionColor(Color.BLUE);
        mainContainerPanelRightTopTextArea.setBackground(new Color(25, 86, 4, 255));
        mainContainerPanelRightTopTextArea.setForeground(new Color(255, 255, 255, 255));
        mainContainerPanelRightTopTextArea.addKeyListener(new KeyListener()
        {
            @Override
            public void keyTyped(KeyEvent e)
            {

            }

            @Override
            public void keyPressed(KeyEvent e)
            {
                if (e.getKeyCode() == 9)
                {
                    int caretPosition = mainContainerPanelRightTopTextArea.getCaretPosition();
                    mainContainerPanelRightTopTextArea.insert("    ", caretPosition);
                }
            }

            @Override
            public void keyReleased(KeyEvent e)
            {

            }
        });
        mainContainerPanelRightTopTextAreaScrollPane = new JScrollPane(mainContainerPanelRightTopTextArea);
        mainContainerPanelRightTopTextAreaScrollPane.setBounds(0, 0, mainContainerPanelRightTop.getWidth(), mainContainerPanelRightTop.getHeight());
        mainContainerPanelRightTopTextAreaScrollPane.setOpaque(true);
        mainContainerPanelRightTopTextAreaScrollPane.setBackground(new Color(0, 0, 0, 0));
        mainContainerPanelRightTop.add(mainContainerPanelRightTopTextAreaScrollPane);
        mainContainerPanelRightFooterTextArea = new JTextArea();
        mainContainerPanelRightFooterTextArea.setEditable(false);
        mainContainerPanelRightFooterTextArea.setLineWrap(false);
        mainContainerPanelRightFooterTextArea.setOpaque(true);
        mainContainerPanelRightFooterTextArea.setTabSize(0);
        mainContainerPanelRightFooterTextArea.setSelectedTextColor(Color.WHITE);
        mainContainerPanelRightFooterTextArea.setSelectionColor(Color.BLUE);
        mainContainerPanelRightFooterTextArea.setBackground(new Color(25, 86, 4, 255));
        mainContainerPanelRightFooterTextArea.setForeground(new Color(255, 255, 255, 255));
        mainContainerPanelRightFooterTextAreaScrollPane = new JScrollPane(mainContainerPanelRightFooterTextArea);
        mainContainerPanelRightFooterTextAreaScrollPane.setBounds(0, 0, mainContainerPanelRightFooter.getWidth(), mainContainerPanelRightFooter.getHeight());
        mainContainerPanelRightFooterTextAreaScrollPane.setOpaque(true);
        mainContainerPanelRightFooterTextAreaScrollPane.setBackground(new Color(0, 0, 0, 0));
        mainContainerPanelRightFooter.add(mainContainerPanelRightFooterTextAreaScrollPane);
    }

    public static void setPageToCurrent(int index)
    {
        if (index < 0 || index > 5) throw new IndexOutOfBoundsException("Index: " + index + " out of range 0 ~ 5.");
        else
        {
            MainContainerPageHome.getMainContainerPanel().setVisible(false);
            MainContainerPage_1.getMainContainerPanel().setVisible(false);
            MainContainerPage_2.getMainContainerPanel().setVisible(false);
            MainContainerPage_3.getMainContainerPanel().setVisible(false);
            MainContainerPage_4.getMainContainerPanel().setVisible(false);
            MainContainerPage_5.getMainContainerPanel().setVisible(false);
            if (index == 0) MainContainerPageHome.getMainContainerPanel().setVisible(true);
            else if (index == 1) MainContainerPage_1.getMainContainerPanel().setVisible(true);
            else if (index == 2) MainContainerPage_2.getMainContainerPanel().setVisible(true);
            else if (index == 3) MainContainerPage_3.getMainContainerPanel().setVisible(true);
            else if (index == 4) MainContainerPage_4.getMainContainerPanel().setVisible(true);
            else MainContainerPage_5.getMainContainerPanel().setVisible(true);
        }
    }

    public static JPanel getMainContainerPanel()
    {
        return mainContainerPanel;
    }

    public static JPanel getMainContainerPanelLeft()
    {
        return mainContainerPanelLeft;
    }

    public static JPanel getMainContainerPanelRight()
    {
        return mainContainerPanelRight;
    }

    public static JPanel getMainContainerPanelLeftTop()
    {
        return mainContainerPanelLeftTop;
    }

    public static JPanel getMainContainerPanelLeftTCenter()
    {
        return mainContainerPanelLeftTCenter;
    }

    public static JPanel getMainContainerPanelLeftTFooter()
    {
        return mainContainerPanelLeftTFooter;
    }

    public static JPanel getMainContainerPanelRightTop()
    {
        return mainContainerPanelRightTop;
    }

    public static JPanel getMainContainerPanelRightFooter()
    {
        return mainContainerPanelRightFooter;
    }

    public static JTextArea getMainContainerPanelRightTopTextArea()
    {
        return mainContainerPanelRightTopTextArea;
    }

    public static JTextArea getMainContainerPanelRightFooterTextArea()
    {
        return mainContainerPanelRightFooterTextArea;
    }

    public static JScrollPane getMainContainerPanelRightTopTextAreaScrollPane()
    {
        return mainContainerPanelRightTopTextAreaScrollPane;
    }

    public static JScrollPane getMainContainerPanelRightFooterTextAreaScrollPane()
    {
        return mainContainerPanelRightFooterTextAreaScrollPane;
    }

    public static XFButton getMainContainerPanelLeftTopFileButton()
    {
        return mainContainerPanelLeftTopFileButton;
    }

    public static XFButton getMainContainerPanelLeftFooterBackButton()
    {
        return mainContainerPanelLeftFooterBackButton;
    }

    public static XFButton getMainContainerPanelLeftFooterGeneratorButton()
    {
        return mainContainerPanelLeftFooterGeneratorButton;
    }

    public static JLabel getMainContainerPanelLeftTCenterInputMinecraftPathLabel()
    {
        return mainContainerPanelLeftTCenterInputMinecraftPathLabel;
    }

    public static JLabel getMainContainerPanelLeftTCenterInputMidiPathLabel()
    {
        return mainContainerPanelLeftTCenterInputMidiPathLabel;
    }

    public static JLabel getMainContainerPanelLeftTCenterInputTitleLabel()
    {
        return mainContainerPanelLeftTCenterInputTitleLabel;
    }

    public static JLabel getMainContainerPanelLeftTCenterInputSubtitleLabel()
    {
        return mainContainerPanelLeftTCenterInputSubtitleLabel;
    }

    public static JTextField getMainContainerPanelLeftTCenterInputMinecraftPathTextField()
    {
        return mainContainerPanelLeftTCenterInputMinecraftPathTextField;
    }

    public static JTextField getMainContainerPanelLeftTCenterInputMidiPathTextField()
    {
        return mainContainerPanelLeftTCenterInputMidiPathTextField;
    }

    public static JTextField getMainContainerPanelLeftTCenterInputTitleTextField()
    {
        return mainContainerPanelLeftTCenterInputTitleTextField;
    }

    public static JTextField getMainContainerPanelLeftTCenterInputSubtitleTextField()
    {
        return mainContainerPanelLeftTCenterInputSubtitleTextField;
    }
}
