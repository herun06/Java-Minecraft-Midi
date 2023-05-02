/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package main.java.com.xfherun.minecraft_redstone_music_generator.utls;

public class MinecraftRedstoneMusicEffect
{
    private static int[] pos = new int[]{0, 4, 0};
    private static int[] pianoKeyPosIndex = new int[]{
            0, 1, 2, 3, 4, 6, 7, 8, 9,
            10, 11, 12, 14, 15, 16, 17,
            18, 20, 21, 22, 23, 24, 25,
            26, 28, 29, 30, 31, 32, 34,
            35, 36, 37, 38, 39, 40, 42,
            43, 44, 45, 46, 48, 49, 50,
            51, 52, 53, 54, 56, 57, 58,
            59, 60, 62, 63, 64, 65, 66,
            67, 68, 70, 71, 72, 73, 74,
            76, 77, 78, 79, 80, 81, 82,
            84, 85, 86, 87, 88, 90, 91,
            92, 93, 94, 95, 96, 98, 99,
            100, 101, 102, 104, 105, 106,
            107, 108, 109, 110, 112, 113,
            114, 115, 116, 118, 119, 120,
            121, 122, 123, 124, 126, 127,
            128, 129, 130, 132, 133, 134,
            135, 136, 137, 138, 140, 141,
            142, 143, 144, 146, 147, 148
    };

    private MinecraftRedstoneMusicEffect()
    {
    }

    public static String pianoKeyDownEffect(int channel, int pitch)
    {
        StringBuilder commandStringDown = new StringBuilder();
        if (pitch == 0 || pitch == 2 || pitch == 4 || pitch == 5 || pitch == 7 || pitch == 9 || pitch == 11 || pitch == 12 || pitch == 14 || pitch == 16 || pitch == 17 || pitch == 19 || pitch == 21 || pitch == 23 || pitch == 24 || pitch == 26 || pitch == 28 || pitch == 29 || pitch == 31 || pitch == 33 || pitch == 35 || pitch == 36 || pitch == 38 || pitch == 40 || pitch == 41 || pitch == 43 || pitch == 45 || pitch == 47 || pitch == 48 || pitch == 50 || pitch == 52 || pitch == 53 || pitch == 55 || pitch == 57 || pitch == 59 || pitch == 60 || pitch == 62 || pitch == 64 || pitch == 65 || pitch == 67 || pitch == 69 || pitch == 71 || pitch == 72 || pitch == 74 || pitch == 76 || pitch == 77 || pitch == 79 || pitch == 81 || pitch == 83 || pitch == 84 || pitch == 86 || pitch == 88 || pitch == 89 || pitch == 91 || pitch == 93 || pitch == 95 || pitch == 96 || pitch == 98 || pitch == 100 || pitch == 101 || pitch == 103 || pitch == 105 || pitch == 107 || pitch == 108 || pitch == 110 || pitch == 112 || pitch == 113 || pitch == 115 || pitch == 117 || pitch == 119 || pitch == 120 || pitch == 122 || pitch == 124 || pitch == 125 || pitch == 127)
            commandStringDown.append(StringFormat.stringFormat("execute @a {0} {1} {2} function build_piano_keys:key_down_white", new String[]{
                    String.valueOf(pos[0]), String.valueOf(pos[1] + 1), String.valueOf(pianoKeyPosIndex[pitch] + (pos[2] + 1))
            })).append("\n");
        else
            commandStringDown.append(StringFormat.stringFormat("execute @a {0} {1} {2} function build_piano_keys:key_down_black", new String[]{
                    String.valueOf(pos[0]), String.valueOf(pos[1] + 1), String.valueOf(pianoKeyPosIndex[pitch] + (pos[2] + 1))
            })).append("\n");
        commandStringDown.append(StringFormat.stringFormat("execute @a {0} {1} {2} function build_piano_keys:effect_" + channel, new String[]{
                String.valueOf(pos[0]), String.valueOf(pos[1] + 1), String.valueOf(pianoKeyPosIndex[pitch] + (pos[2] + 1))
        })).append("\n");

        return commandStringDown.toString();
    }

    public static String pianoKeyUPEffect(int pitch)
    {
        StringBuilder commandStringUp = new StringBuilder();
        if (pitch == 0 || pitch == 2 || pitch == 4 || pitch == 5 || pitch == 7 || pitch == 9 || pitch == 11 || pitch == 12 || pitch == 14 || pitch == 16 || pitch == 17 || pitch == 19 || pitch == 21 || pitch == 23 || pitch == 24 || pitch == 26 || pitch == 28 || pitch == 29 || pitch == 31 || pitch == 33 || pitch == 35 || pitch == 36 || pitch == 38 || pitch == 40 || pitch == 41 || pitch == 43 || pitch == 45 || pitch == 47 || pitch == 48 || pitch == 50 || pitch == 52 || pitch == 53 || pitch == 55 || pitch == 57 || pitch == 59 || pitch == 60 || pitch == 62 || pitch == 64 || pitch == 65 || pitch == 67 || pitch == 69 || pitch == 71 || pitch == 72 || pitch == 74 || pitch == 76 || pitch == 77 || pitch == 79 || pitch == 81 || pitch == 83 || pitch == 84 || pitch == 86 || pitch == 88 || pitch == 89 || pitch == 91 || pitch == 93 || pitch == 95 || pitch == 96 || pitch == 98 || pitch == 100 || pitch == 101 || pitch == 103 || pitch == 105 || pitch == 107 || pitch == 108 || pitch == 110 || pitch == 112 || pitch == 113 || pitch == 115 || pitch == 117 || pitch == 119 || pitch == 120 || pitch == 122 || pitch == 124 || pitch == 125 || pitch == 127)
            commandStringUp.append(StringFormat.stringFormat("execute @a {0} {1} {2} function build_piano_keys:key_up_white", new String[]{
                    String.valueOf(pos[0]), String.valueOf(pos[1] + 1), String.valueOf(pianoKeyPosIndex[pitch] + (pos[2] + 1))
            })).append("\n");
        else
            commandStringUp.append(StringFormat.stringFormat("execute @a {0} {1} {2} function build_piano_keys:key_up_black", new String[]{
                    String.valueOf(pos[0]), String.valueOf(pos[1] + 1), String.valueOf(pianoKeyPosIndex[pitch] + (pos[2] + 1))
            })).append("\n");
        return commandStringUp.toString();
    }
}
