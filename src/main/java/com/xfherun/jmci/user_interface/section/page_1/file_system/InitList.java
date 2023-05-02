package main.java.com.xfherun.jmci.user_interface.section.page_1.file_system;

import main.java.com.xfherun.jmci.midi.StartReadJMCIFileContentData;
import main.java.com.xfherun.jmci.swing_util.button.i.ButtonClick;
import main.java.com.xfherun.jmci.swing_util.list.menu.XFMenuList;
import main.java.com.xfherun.jmci.user_interface.MainWindow;
import main.java.com.xfherun.jmci.user_interface.section.MainContainerPage_1;

import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;

public class InitList
{
    private static ArrayList<File> fileArray = new ArrayList<>();

    private InitList()
    {
    }

    public static void init()
    {
        XFMenuList xfMenuList = new XFMenuList(
                false, true,
                new int[]{},
                false, true,
                true, 400
        );
        xfMenuList.setBounds(new int[]{
                XFMenuList.getButtonPoint(MainWindow.getMainWindow(), MainContainerPage_1.getSelectLocalJMCIFileButton())[0],
                XFMenuList.getButtonPoint(MainWindow.getMainWindow(), MainContainerPage_1.getSelectLocalJMCIFileButton())[1],
                400, 200});

        File rootFilePath = new File("cache/jmci");
        File[] files = rootFilePath.listFiles();
        fileArray.clear();
        for (File file : files)
        {
            String fileType = file.toString().substring(file.toString().length() - 5, file.toString().length());
            if (fileType.equals(".jmci"))
            {
                fileArray.add(file);
            }
        }
        for (File file : fileArray)
        {
            xfMenuList.add(file.getName().substring(0, file.getName().length() - 5));
        }
        xfMenuList.addButtonClicked(new ButtonClick()
        {
            @Override
            public void clicked(MouseEvent event)
            {
                int currentSelectIndex = xfMenuList.getCurrentSelectIndex();
                File file = fileArray.get(currentSelectIndex).getAbsoluteFile();
                StartReadJMCIFileContentData.startRead(file);
            }
        });
        xfMenuList.show();
    }
}
