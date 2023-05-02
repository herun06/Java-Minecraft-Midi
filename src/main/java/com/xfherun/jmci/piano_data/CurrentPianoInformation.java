package main.java.com.xfherun.jmci.piano_data;

import main.java.com.xfherun.jmci.utils.AudioFilePlayer;
import main.java.com.xfherun.jmci.utils.PlaySound;

import java.io.File;

public class CurrentPianoInformation
{
    public static int currentMidiChannel = 0;
    public static int currentMidiDevice = 0;
    public static int currentMidiProgram = 0;
    public static int[] currentMidiControl = {0, 0};
    public static boolean isEnableNoteFallEffect = true;
    public static boolean isEnableNoteFallEffectBlock = true;
    public static double currentCompileFrame = 120.0;
    public static int currentSongMaxValue = 0;
    public static int currentSongProgress = 0;
    public static boolean isMidiOpen = true;
    public static boolean isPlay = false;
    public static String version = "1.0.0.1";
    public static boolean useWavePlaySound = true;
    public static double currentBPM = -119.119;
    public static int movePitch = 0;
    public static boolean isEnableSoundFontPlay = false;
    public static final AudioFilePlayer[] GLOBAL_SOUND_LIB_ARRAY = new AudioFilePlayer[128];
    public static File currentSoundFontFile = null;

    private CurrentPianoInformation()
    {
    }
}
