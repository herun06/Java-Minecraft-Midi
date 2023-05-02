package main.java.com.xfherun.jmci.user_interface.section.page_1;

import main.java.com.xfherun.jmci.piano_data.CurrentPianoInformation;
import main.java.com.xfherun.jmci.piano_data.GetPianoKeyColor;
import main.java.com.xfherun.jmci.user_interface.section.page_1.falling_block.ConnectPianoAllKeys;
import main.java.com.xfherun.jmci.user_interface.section.page_1.sounds.PlaySound;
import main.java.com.xfherun.jmci.user_interface.section.page_1.sounds.StopSound;
import main.java.com.xfherun.jmci.utils.PlayWaveSound;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SetWhitePianoKeysAndBlackPianoKeysStyle
{
    private static Color blackNormalColor = new Color(45, 3, 3, 255);
    private static Color blackLightColor = new Color(82, 23, 23, 255);
    private static Color whiteNormalColor = new Color(204, 204, 204, 255);
    private static Color whiteLightColor = new Color(173, 143, 143, 255);
    private static Color hideColor = new Color(0, 0, 0, 0);
    private static Color blackBorderColor = new Color(140, 129, 129, 255);
    private static Color whiteBorderColor = new Color(38, 38, 38, 255);
    private static boolean isDown = false;

    private SetWhitePianoKeysAndBlackPianoKeysStyle()
    {
    }

    public static void addBlackPianoKeysStyle(JLabel pianoKeyItem)
    {
        pianoKeyItem.setOpaque(true);
        pianoKeyItem.setBackground(blackNormalColor);
        pianoKeyItem.setForeground(hideColor);
        pianoKeyItem.setBorder(new LineBorder(blackBorderColor));
        pianoKeyItem.addMouseListener(new MouseListener()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {

            }

            @Override
            public void mousePressed(MouseEvent e)
            {
                isDown = true;
                ConnectPianoAllKeys.black(e);
                if (!CurrentPianoInformation.useWavePlaySound)
                    try
                    {
                        PlaySound.playSound(e);
                        CurrentPianoInformation.isMidiOpen = true;
                    }
                    catch (Exception ex)
                    {
                        CurrentPianoInformation.isMidiOpen = false;
                    }
                else PlayWaveSound.play(e);
                pianoKeyItem.setBackground(GetPianoKeyColor.getPianoKeyColor(CurrentPianoInformation.currentMidiChannel));
            }

            @Override
            public void mouseReleased(MouseEvent e)
            {
                isDown = false;
                ConnectPianoAllKeys.blackDefault(e);
                if (!CurrentPianoInformation.useWavePlaySound)
                    try
                    {
                        StopSound.stopSound(e);
                        CurrentPianoInformation.isMidiOpen = true;
                    }
                    catch (Exception ex)
                    {
                        CurrentPianoInformation.isMidiOpen = false;
                    }
                pianoKeyItem.setBackground(blackNormalColor);
            }

            @Override
            public void mouseEntered(MouseEvent e)
            {
                if (isDown)
                {
                    ConnectPianoAllKeys.black(e);
                    if (!CurrentPianoInformation.useWavePlaySound)
                        try
                        {
                            PlaySound.playSound(e);
                            CurrentPianoInformation.isMidiOpen = true;
                        }
                        catch (Exception ex)
                        {
                            CurrentPianoInformation.isMidiOpen = false;
                        }
                    else PlayWaveSound.play(e);
                    pianoKeyItem.setBackground(GetPianoKeyColor.getPianoKeyColor(CurrentPianoInformation.currentMidiChannel));
                }
                else pianoKeyItem.setBackground(blackLightColor);
            }

            @Override
            public void mouseExited(MouseEvent e)
            {
                ConnectPianoAllKeys.blackDefault(e);
                if (!CurrentPianoInformation.useWavePlaySound)
                    try
                    {
                        StopSound.stopSound(e);
                        CurrentPianoInformation.isMidiOpen = true;
                    }
                    catch (Exception ex)
                    {
                        CurrentPianoInformation.isMidiOpen = false;
                    }
                pianoKeyItem.setBackground(blackNormalColor);
            }
        });
    }

    public static void addWhitePianoKeysStyle(JLabel pianoKeyItem)
    {
        pianoKeyItem.setOpaque(true);
        pianoKeyItem.setBackground(whiteNormalColor);
        pianoKeyItem.setForeground(hideColor);
        pianoKeyItem.setBorder(new LineBorder(whiteBorderColor));
        pianoKeyItem.addMouseListener(new MouseListener()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {

            }

            @Override
            public void mousePressed(MouseEvent e)
            {
                isDown = true;
                ConnectPianoAllKeys.white(e);
                if (!CurrentPianoInformation.useWavePlaySound)
                    try
                    {
                        PlaySound.playSound(e);
                        CurrentPianoInformation.isMidiOpen = true;
                    }
                    catch (Exception ex)
                    {
                        CurrentPianoInformation.isMidiOpen = false;
                    }
                else PlayWaveSound.play(e);
                pianoKeyItem.setBackground(GetPianoKeyColor.getPianoKeyColor(CurrentPianoInformation.currentMidiChannel));
            }

            @Override
            public void mouseReleased(MouseEvent e)
            {
                isDown = false;
                ConnectPianoAllKeys.whiteDefault(e);
                if (!CurrentPianoInformation.useWavePlaySound)
                    try
                    {
                        StopSound.stopSound(e);
                        CurrentPianoInformation.isMidiOpen = true;
                    }
                    catch (Exception ex)
                    {
                        CurrentPianoInformation.isMidiOpen = false;
                    }
                pianoKeyItem.setBackground(whiteNormalColor);
            }

            @Override
            public void mouseEntered(MouseEvent e)
            {
                if (isDown)
                {
                    ConnectPianoAllKeys.white(e);
                    if (!CurrentPianoInformation.useWavePlaySound)
                        try
                        {
                            PlaySound.playSound(e);
                            CurrentPianoInformation.isMidiOpen = true;
                        }
                        catch (Exception ex)
                        {
                            CurrentPianoInformation.isMidiOpen = false;
                        }
                    else PlayWaveSound.play(e);
                    pianoKeyItem.setBackground(GetPianoKeyColor.getPianoKeyColor(CurrentPianoInformation.currentMidiChannel));
                }
                else pianoKeyItem.setBackground(whiteLightColor);
            }

            @Override
            public void mouseExited(MouseEvent e)
            {
                ConnectPianoAllKeys.whiteDefault(e);
                if (!CurrentPianoInformation.useWavePlaySound)
                    try
                    {
                        StopSound.stopSound(e);
                        CurrentPianoInformation.isMidiOpen = true;
                    }
                    catch (Exception ex)
                    {
                        CurrentPianoInformation.isMidiOpen = false;
                    }
                pianoKeyItem.setBackground(whiteNormalColor);
            }
        });
    }

    public static Color getBlackNormalColor()
    {
        return blackNormalColor;
    }

    public static Color getBlackLightColor()
    {
        return blackLightColor;
    }

    public static Color getWhiteNormalColor()
    {
        return whiteNormalColor;
    }

    public static Color getWhiteLightColor()
    {
        return whiteLightColor;
    }

    public static Color getHideColor()
    {
        return hideColor;
    }

    public static Color getBlackBorderColor()
    {
        return blackBorderColor;
    }

    public static Color getWhiteBorderColor()
    {
        return whiteBorderColor;
    }

    public static boolean isIsDown()
    {
        return isDown;
    }
}
