/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package main.java.com.xfherun.minecraft_redstone_music_generator.user_ui.comp.radiobutton;

import java.awt.*;
import java.util.ArrayList;

public class RadioButton
{
    private ArrayList<RadioButtonItem> list;
    private ArrayList<Boolean> radioButtonItemChecked;
    private String currentSelectFlag;
    private ArrayList<String> currentSelectFlagArray;
    private RadioButtonChecked radioButtonChecked;

    public RadioButton()
    {
        radioButtonChecked = null;
        list = new ArrayList<>();
        radioButtonItemChecked = new ArrayList<>();
        currentSelectFlagArray = new ArrayList<>();
    }

    public void addRadioButtonItem(RadioButtonItem radioButtonItem, String id)
    {
        list.add(radioButtonItem);
        radioButtonItemChecked.add(false);
        if (currentSelectFlagArray.size() <= 0) currentSelectFlagArray.add(id);
        else
        {
            String ss = "";
            for (int i = 0; i < currentSelectFlagArray.size(); i++)
            {
                String s = currentSelectFlagArray.get(i);
                ss = s;
                if (!s.equals(id))
                {
                    currentSelectFlagArray.add(id);
                    return;
                }
            }
            throw new RuntimeException("单选按钮发现ID发现冲突: 已有的ID: " + ss + " , 传进来的ID: " + id);
        }
    }

    public void addToWindow(Container window)
    {
        addAttr();
        setClicked();
        currentSelectFlag = currentSelectFlagArray.get(0);
        doPressed(currentSelectFlagArray.get(0));
        for (RadioButtonItem radioButtonItem : list)
        {
            Object[] source = radioButtonItem.getSource();
            window.add((Component) source[0]);
            window.add((Component) source[1]);
        }
    }

    private void addAttr()
    {
        for (int i = 0; i < list.size(); i++)
        {
            RadioButtonItem radioButtonItem = list.get(i);
            radioButtonItem.setId(i);
        }
    }

    public void doPressed(String id)
    {
        for (int i = 0; i < currentSelectFlagArray.size(); i++)
        {
            String s = currentSelectFlagArray.get(i);
            if (id.equals(s))
            {
                RadioButtonItem radioButtonItem = list.get(i);
                for (int yo = 0; yo < radioButtonItemChecked.size(); yo++)
                {
                    radioButtonItemChecked.set(yo, false);
                    list.get(yo).setChecked(radioButtonItemChecked.get(yo));
                }
                if (radioButtonItem.getId() == i)
                {
                    radioButtonItemChecked.set(i, true);
                    radioButtonItem.setChecked(true);
                    currentSelectFlag = s;
                }

                break;
            }
        }
    }

    public String getCurrentSelectID()
    {
        return currentSelectFlag;
    }

    public void addRadioButtonChecked(RadioButtonChecked radioButtonChecked)
    {
        this.radioButtonChecked = radioButtonChecked;
    }

    private void setClicked()
    {
        int id = 0;
        for (RadioButtonItem radioButtonItem : list)
        {
            int finalId = id;
            radioButtonItem.addRadioButtonChecked(new RadioButtonChecked()
            {
                @Override
                public void accept()
                {
                    for (int i = 0; i < radioButtonItemChecked.size(); i++)
                    {
                        radioButtonItemChecked.set(i, false);
                        list.get(i).setChecked(radioButtonItemChecked.get(i));
                    }
                    if (radioButtonItem.getId() == finalId)
                    {
                        radioButtonItemChecked.set(finalId, true);
                        radioButtonItem.setChecked(true);
                        currentSelectFlag = currentSelectFlagArray.get(finalId);
                    }
                    if (radioButtonChecked != null) radioButtonChecked.accept();
                }
            });
            id++;
        }
    }
}
