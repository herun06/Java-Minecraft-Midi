package main.java.com.xfherun.jmci.user_interface;

import com.xfherun.xflog.XFLog;
import main.java.com.xfherun.jmci.swing_util.button.XFButton;
import main.java.com.xfherun.jmci.swing_util.button.i.ButtonClick;
import main.java.com.xfherun.jmci.swing_util.switch_button.XFSwitchButton;
import main.java.com.xfherun.jmci.swing_util.switch_button.action.SwitchListener;
import main.java.com.xfherun.jmci.swing_util.window_utils.UpdateWindow;
import main.java.com.xfherun.jmci.user_interface.events.MainWindowEvents;
import main.java.com.xfherun.jmci.user_interface.exception_window.ExceptionLeftBottomWindow;
import main.java.com.xfherun.jmci.user_interface.section.*;
import main.java.com.xfherun.jmci.user_interface.update_log.UpdateLogWindow;
import main.java.com.xfherun.jmci.utils.Resources;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.net.URL;

public class MainWindow extends JFrame
{
    private static JFrame mainWindow;
    private static JPanel mainContainer;
    private static XFSwitchButton exceptionSwitch;
    private static XFButton updateLogButton;
    private static JLabel stateBarBackground;

    private MainWindow()
    {
    }

    public static void init()
    {
        createWindow();
        MainWindowEvents.MainWindowEvents();
        mainWindow.setVisible(true);
        XFLog.info("窗口初始化完毕");
        XFLog.info("更新窗口");
        new UpdateWindow(mainWindow).start();
    }

    private static void addItems()
    {
        MainContainerPageHome.init();
        MainContainerPage_1.init();
        MainContainerPage_2.init();
        MainContainerPage_3.init();
        MainContainerPage_4.init();
        MainContainerPage_5.init();
        MainContainerPageHome.setPageToCurrent(0);

        drawStateBar();
    }

    private static void createWindow()
    {
        mainWindow = new JFrame();
        mainWindow.setTitle("Java minecraft midi 编辑器 for java");
        mainWindow.setSize(800, 480);
        mainWindow.setLocationRelativeTo(null);
        mainWindow.setLayout(null);
        mainWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainWindow.setResizable(true);
        URL imageUrl = Resources.getResources(ExceptionLeftBottomWindow.class, "" +
                "main/resources/images/window/logo/logo.png");
        Image image = new ImageIcon(imageUrl).getImage();
        mainWindow.setIconImage(image);
        mainWindow.setMinimumSize(new Dimension(800, 480));
        mainContainer = new JPanel();
        mainContainer.setBounds(0, 35, mainWindow.getWidth() - 16, mainWindow.getHeight() - (39 + 35));
        mainContainer.setLayout(null);
        mainContainer.setBackground(new Color(29, 115, 27, 255));
        addItems();
        mainWindow.getContentPane().add(mainContainer);
    }

    private static void drawStateBar()
    {
        exceptionSwitch = new XFSwitchButton("打开异常任务栏");
        exceptionSwitch.setBounds((mainWindow.getWidth() - 16) - 65, 2, 64, 32);
        exceptionSwitch.addActionListener(new SwitchListener()
        {
            @Override
            public void acc(boolean isOn)
            {
                if (isOn)
                {
                    Thread runnable = new Thread()
                    {
                        public void run()
                        {
                            ExceptionLeftBottomWindow.getMainWindow().setLocationRelativeTo(mainWindow);
                            ExceptionLeftBottomWindow.updateList();
                            ExceptionLeftBottomWindow.getMainWindow().setVisible(true);
                            new main.java.com.xfherun.jmci.user_interface.exception_window.UpdateWindow().start();
                        }
                    };
                    runnable.start();
                }
                else new Thread(() -> ExceptionLeftBottomWindow.getMainWindow().setVisible(false)).start();
            }
        });
        exceptionSwitch.addToWindow(mainWindow);
        addUpdateLogButtons();

        stateBarBackground = new JLabel();
        stateBarBackground.setBounds(0, 0, mainWindow.getWidth() - 16, 35);
        stateBarBackground.setOpaque(true);
        stateBarBackground.setBackground(new Color(29, 115, 27, 255));
        mainWindow.getContentPane().add(stateBarBackground);
    }

    private static void addUpdateLogButtons()
    {
        updateLogButton = new XFButton("更新日志");
        updateLogButton.setBounds(0, 2, 119, 32);
        updateLogButton.addMouseClicked(new ButtonClick()
        {
            @Override
            public void clicked(MouseEvent event)
            {
                XFLog.info("打开更新日志列表窗口");
                UpdateLogWindow.init();
            }
        });
        updateLogButton.addWindow(mainWindow);
    }

    public static JFrame getMainWindow()
    {
        return mainWindow;
    }

    public static JPanel getMainContainer()
    {
        return mainContainer;
    }

    public static XFSwitchButton getExceptionSwitch()
    {
        return exceptionSwitch;
    }

    public static JLabel getStateBarBackground()
    {
        return stateBarBackground;
    }
}
