package main.java.com.xfherun.jmci.user_interface.section.page_1.falling_block;

import main.java.com.xfherun.jmci.piano_data.CurrentPianoInformation;
import main.java.com.xfherun.jmci.piano_data.GetPianoKeyColor;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class PianoNoteBlockForFallingBlock extends JLabel
{
    private int width;
    private int start;
    private int end;
    private int x;
    private int y;
    private int temp_y;
    private int channel;
    private JLabel noteBlock;
    private Color borderColor = new Color(23, 23, 23, 255);
    private Thread thread;
    private String pitch;
    private boolean isEnd;
    private int defaultHeight = 2;
    private int temp_height = defaultHeight;
    private Container container;

    public PianoNoteBlockForFallingBlock
            (
                    Container container,
                    int width,
                    int start,
                    int end,
                    int x,
                    int y,
                    int channel,
                    String pitch_
            )
    {
        this.container = container;
        this.width = width;
        this.start = start;
        this.end = end;
        this.x = x;
        this.y = y;
        this.pitch = pitch_;
        this.temp_y = this.y;
        this.channel = channel;
        if (CurrentPianoInformation.isEnableNoteFallEffectBlock) this.defaultHeight = this.width;
        createNoteBlockAndSetStyle();
        createThread();
        AllNoteBlockData.list.add(noteBlock);
    }

    private void createNoteBlockAndSetStyle()
    {
        noteBlock = new JLabel("");
        noteBlock.setName(pitch);
        noteBlock.setLocation(x, y - defaultHeight);
        noteBlock.setSize(width, defaultHeight);
        noteBlock.setOpaque(true);
        noteBlock.setBorder(new LineBorder(borderColor));
        noteBlock.setBackground(GetPianoKeyColor.getPianoKeyColor(channel));
        container.add(noteBlock);
    }

    private void createThread()
    {
        if (!CurrentPianoInformation.isEnableNoteFallEffectBlock)
            thread = new Thread(() -> {
                while (true)
                {
                    if (isEnd)
                    {
                        noteBlock.setLocation(x, (temp_y - defaultHeight));
                        noteBlock.setSize(width, noteBlock.getHeight());
                        temp_y--;
                        if ((temp_y + noteBlock.getHeight()) < end)
                        {
                            setVisible(false);
                            container.remove(noteBlock);
                            isEnd = false;
                            break;
                        }
                    }
                    else
                    {
                        if (noteBlock.getY() > end)
                        {
                            noteBlock.setLocation(x, (temp_y - defaultHeight));
                            noteBlock.setSize(width, temp_height);
                            temp_height++;
                            temp_y--;
                        }
                        else
                        {
                            noteBlock.setLocation(x, (temp_y - defaultHeight));
                            noteBlock.setSize(width, noteBlock.getHeight());
                        }
                    }
                    try
                    {
                        Thread.sleep(1);
                    }
                    catch (InterruptedException e)
                    {
                        throw new RuntimeException(e);
                    }
                }
            });
        else
            thread = new Thread(() -> {
                while (true)
                {
                    if ((temp_y + noteBlock.getHeight()) < end)
                    {
                        setVisible(false);
                        container.remove(noteBlock);
                        isEnd = false;
                        break;
                    }
                    noteBlock.setLocation(x, (temp_y - defaultHeight));
                    temp_y--;

                    try
                    {
                        Thread.sleep(1);
                    }
                    catch (InterruptedException e)
                    {
                        throw new RuntimeException(e);
                    }
                }
            });
    }

    public void start()
    {
        if (!CurrentPianoInformation.isEnableNoteFallEffectBlock) isEnd = false;
        thread.start();
    }

    public void stop()
    {
        if (!CurrentPianoInformation.isEnableNoteFallEffectBlock) isEnd = true;
    }
}
