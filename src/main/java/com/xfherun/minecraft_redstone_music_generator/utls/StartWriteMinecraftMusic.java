/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package main.java.com.xfherun.minecraft_redstone_music_generator.utls;

import com.xfherun.xflog.XFLog;
import main.java.com.xfherun.jmci.utils.WriteFile;
import main.java.com.xfherun.minecraft_redstone_music_generator.user_ui.MainWindow;

import javax.swing.*;
import java.io.File;

public class StartWriteMinecraftMusic
{
    private StartWriteMinecraftMusic()
    {
    }

    public static void write(String type, String projectName, String minecraftPath, String jmciPath, String mainTitle, String subTitle, String minecraftFunctionFileName)
    {
        XFLog.info("开始写入, 类型: " + type);
        if (!minecraftFunctionFileName.equals("NaN"))
        {
            XFLog.info("Minecraft function file name: " + minecraftFunctionFileName);
            XFLog.info("\n" +
                    "projectName: " + projectName + "\n" +
                    "minecraftPath: " + minecraftPath + "\n" +
                    "jmciPath: " + jmciPath + "\n" +
                    "mainTitle:" + mainTitle + "\n" +
                    "subTitle:" + subTitle + "\n" +
                    "minecraftFunctionFileName:" + minecraftFunctionFileName + "\n" +
                    "");
            if (type.equalsIgnoreCase("1"))
            {
                XFLog.info("写入类型为: 作为Minecraft存档");
                XFLog.info("校验数据可用性");
                if (projectName.equals(""))
                {
                    String message = "工程名不能为空";
                    XFLog.warn(message);
                    JOptionPane.showMessageDialog(MainWindow.getMainWindow(), message, "警告", 2);
                    return;
                }
                if (minecraftPath.equals(""))
                {
                    String message = ".minecraft路径不能为空";
                    XFLog.warn(message);
                    JOptionPane.showMessageDialog(MainWindow.getMainWindow(), message, "警告", 2);
                    return;
                }
                if (jmciPath.equals(""))
                {
                    String message = "JMCI文件路径不能为空";
                    XFLog.warn(message);
                    JOptionPane.showMessageDialog(MainWindow.getMainWindow(), message, "警告", 2);
                    return;
                }
                if (mainTitle.equals(""))
                {
                    String message = "主标题不能为空";
                    XFLog.warn(message);
                    JOptionPane.showMessageDialog(MainWindow.getMainWindow(), message, "警告", 2);
                    return;
                }
                if (subTitle.equals(""))
                {
                    String message = "副标题不能为空";
                    XFLog.warn(message);
                    JOptionPane.showMessageDialog(MainWindow.getMainWindow(), message, "警告", 2);
                    return;
                }
                if (!new File(minecraftPath).exists())
                {
                    String str = minecraftPath + "不存在";
                    XFLog.warn(str);
                    JOptionPane.showMessageDialog(MainWindow.getMainWindow(), str);
                    return;
                }
                if (!new File(jmciPath).exists())
                {
                    String str = jmciPath + "不存在";
                    XFLog.warn(str);
                    JOptionPane.showMessageDialog(MainWindow.getMainWindow(), str);
                    return;
                }
                XFLog.debug("文件名: " + new File(minecraftPath).getAbsoluteFile().getName());
                if (!new File(minecraftPath).getAbsoluteFile().getName().equalsIgnoreCase(".minecraft"))
                {
                    XFLog.debug("文件名: " + new File(minecraftPath).getAbsoluteFile().getName());
                    String str = "请选择.minecraft文件目录: " + minecraftPath;
                    XFLog.warn(str);
                    JOptionPane.showMessageDialog(MainWindow.getMainWindow(), str);
                    return;
                }
                String absolutePath = new File(jmciPath).getAbsolutePath();
                String fileType = absolutePath.substring(absolutePath.indexOf("."));
                XFLog.debug("文件名类型: " + fileType);
                if (!fileType.equalsIgnoreCase(".jmci"))
                {
                    XFLog.debug("文件名类型: " + fileType);
                    String str = "请选择JMCI文件: " + jmciPath;
                    XFLog.warn(str);
                    JOptionPane.showMessageDialog(MainWindow.getMainWindow(), str);
                    return;
                }

                String filename = ReplaceString.replaceString(projectName, "_", "\\/:*?\"<>|");
                // "CON", "PRN", "AUX", "CLOCK$", "NUL", "COM1", "COM2", "COM3", "COM4", "COM5", "COM6", "COM7", "COM8", "COM9", "LPT1"
                if (filename.equalsIgnoreCase("CON")) filename = "_" + filename + "_";
                if (filename.equalsIgnoreCase("PRN")) filename = "_" + filename + "_";
                if (filename.equalsIgnoreCase("AUX")) filename = "_" + filename + "_";
                if (filename.equalsIgnoreCase("CLOCK$")) filename = "_" + filename + "_";
                if (filename.equalsIgnoreCase("NUL")) filename = "_" + filename + "_";
                if (filename.equalsIgnoreCase("COM1")) filename = "_" + filename + "_";
                if (filename.equalsIgnoreCase("COM2")) filename = "_" + filename + "_";
                if (filename.equalsIgnoreCase("COM3")) filename = "_" + filename + "_";
                if (filename.equalsIgnoreCase("COM4")) filename = "_" + filename + "_";
                if (filename.equalsIgnoreCase("COM5")) filename = "_" + filename + "_";
                if (filename.equalsIgnoreCase("COM6")) filename = "_" + filename + "_";
                if (filename.equalsIgnoreCase("COM7")) filename = "_" + filename + "_";
                if (filename.equalsIgnoreCase("COM8")) filename = "_" + filename + "_";
                if (filename.equalsIgnoreCase("COM9")) filename = "_" + filename + "_";
                if (filename.equalsIgnoreCase("LPT1")) filename = "_" + filename + "_";
                try
                {
                    XFLog.info("清空之前的缓存");
                    JMCIFileToMinecraftFunctionFile.clearAll();

                    XFLog.info("申请缓存空间");
                    File file = new File("cache/space/" + filename + "/saves");
                    File file2 = new File("cache/space/" + filename + "/mods");
                    File file3 = new File("cache/space/" + filename + "/resourcePacks");
                    XFLog.info("准备: "+ file.getAbsolutePath());
                    XFLog.info("准备: "+ file2.getAbsolutePath());
                    XFLog.info("准备: "+ file3.getAbsolutePath());
                    file.mkdirs();
                    file2.mkdirs();
                    file3.mkdirs();
                    XFLog.info(file.getAbsolutePath() + " :: 创建完毕！");
                    XFLog.info(file2.getAbsolutePath() + " :: 创建完毕！");
                    XFLog.info(file3.getAbsolutePath() + " :: 创建完毕！");
                    XFLog.info("准备将JMCI生成Minecraft函数文件");
                    File fileRoot = new File(file.getAbsolutePath() + "/" + filename + "/data/functions");
                    /*XFLog.info("目标文件目录: " + fileRoot.getAbsolutePath());
                    XFLog.info("创建目录: " + fileRoot.getAbsolutePath());
                    fileRoot.mkdirs();*/
                    XFLog.info("开始将JMCI文件转化成mcfunction文件");
                    JMCIFileToMinecraftFunctionFile.startRead(new File(jmciPath).getAbsoluteFile(), fileRoot, projectName, minecraftPath, mainTitle, subTitle);
                }
                catch (Exception e)
                {
                    XFLog.err("申请缓存区失败！", e);
                    JOptionPane.showMessageDialog(MainWindow.getMainWindow(),
                            "申请缓存区失败！",
                            "错误", 0);
                }
            }
            else if (type.equalsIgnoreCase("2"))
            {
                XFLog.info("写入类型为: 作为Minecraft函数包");
                if (projectName.equals(""))
                {
                    String message = "工程名不能为空";
                    XFLog.warn(message);
                    JOptionPane.showMessageDialog(MainWindow.getMainWindow(), message, "警告", 2);
                    return;
                }
                if (minecraftPath.equals(""))
                {
                    String message = ".minecraft路径不能为空";
                    XFLog.warn(message);
                    JOptionPane.showMessageDialog(MainWindow.getMainWindow(), message, "警告", 2);
                    return;
                }
                if (jmciPath.equals(""))
                {
                    String message = "JMCI文件路径不能为空";
                    XFLog.warn(message);
                    JOptionPane.showMessageDialog(MainWindow.getMainWindow(), message, "警告", 2);
                    return;
                }
                String filename = ReplaceString.replaceString(projectName, "_", "\\/:*?\"<>|");
                // "CON", "PRN", "AUX", "CLOCK$", "NUL", "COM1", "COM2", "COM3", "COM4", "COM5", "COM6", "COM7", "COM8", "COM9", "LPT1"
                if (filename.equalsIgnoreCase("CON")) filename = "_" + filename + "_";
                if (filename.equalsIgnoreCase("PRN")) filename = "_" + filename + "_";
                if (filename.equalsIgnoreCase("AUX")) filename = "_" + filename + "_";
                if (filename.equalsIgnoreCase("CLOCK$")) filename = "_" + filename + "_";
                if (filename.equalsIgnoreCase("NUL")) filename = "_" + filename + "_";
                if (filename.equalsIgnoreCase("COM1")) filename = "_" + filename + "_";
                if (filename.equalsIgnoreCase("COM2")) filename = "_" + filename + "_";
                if (filename.equalsIgnoreCase("COM3")) filename = "_" + filename + "_";
                if (filename.equalsIgnoreCase("COM4")) filename = "_" + filename + "_";
                if (filename.equalsIgnoreCase("COM5")) filename = "_" + filename + "_";
                if (filename.equalsIgnoreCase("COM6")) filename = "_" + filename + "_";
                if (filename.equalsIgnoreCase("COM7")) filename = "_" + filename + "_";
                if (filename.equalsIgnoreCase("COM8")) filename = "_" + filename + "_";
                if (filename.equalsIgnoreCase("COM9")) filename = "_" + filename + "_";
                if (filename.equalsIgnoreCase("LPT1")) filename = "_" + filename + "_";
                try
                {
                    XFLog.info("清空之前的缓存");
                    JMCIFileToMinecraftFunctionFile.clearAll();

                    XFLog.info("申请缓存空间");
                    File file = new File("cache/space/" + filename + "/xfherun_redstone_music");
                    XFLog.info("准备: "+ file.getAbsolutePath());
                    file.mkdirs();
                    XFLog.info(file.getAbsolutePath() + " :: 创建完毕！");
                    XFLog.info("准备将JMCI生成Minecraft函数文件");
                    XFLog.info("开始将JMCI文件转化成mcfunction文件");
                    JMCIFileToMinecraftFunctionOnesFile.startRead(new File(jmciPath).getAbsoluteFile(), projectName, new File(minecraftPath).getAbsoluteFile());
                }
                catch (Exception e)
                {
                    XFLog.err("申请缓存区失败！", e);
                    JOptionPane.showMessageDialog(MainWindow.getMainWindow(),
                            "申请缓存区失败！",
                            "错误", 0);
                }
            }
            else if (type.equalsIgnoreCase("3"))
            {
                XFLog.info("写入类型为: 作为JMCS文件进行正整合");
                if (projectName.equals(""))
                {
                    String message = "工程名不能为空";
                    XFLog.warn(message);
                    JOptionPane.showMessageDialog(MainWindow.getMainWindow(), message, "警告", 2);
                    return;
                }
                if (jmciPath.equals(""))
                {
                    String message = "JMCI文件路径不能为空";
                    XFLog.warn(message);
                    JOptionPane.showMessageDialog(MainWindow.getMainWindow(), message, "警告", 2);
                    return;
                }
                if (mainTitle.equals(""))
                {
                    String message = "主标题不能为空";
                    XFLog.warn(message);
                    JOptionPane.showMessageDialog(MainWindow.getMainWindow(), message, "警告", 2);
                    return;
                }
                if (subTitle.equals(""))
                {
                    String message = "副标题不能为空";
                    XFLog.warn(message);
                    JOptionPane.showMessageDialog(MainWindow.getMainWindow(), message, "警告", 2);
                    return;
                }
                String filename = ReplaceString.replaceString(projectName, "_", "\\/:*?\"<>|");
                // "CON", "PRN", "AUX", "CLOCK$", "NUL", "COM1", "COM2", "COM3", "COM4", "COM5", "COM6", "COM7", "COM8", "COM9", "LPT1"
                if (filename.equalsIgnoreCase("CON")) filename = "_" + filename + "_";
                if (filename.equalsIgnoreCase("PRN")) filename = "_" + filename + "_";
                if (filename.equalsIgnoreCase("AUX")) filename = "_" + filename + "_";
                if (filename.equalsIgnoreCase("CLOCK$")) filename = "_" + filename + "_";
                if (filename.equalsIgnoreCase("NUL")) filename = "_" + filename + "_";
                if (filename.equalsIgnoreCase("COM1")) filename = "_" + filename + "_";
                if (filename.equalsIgnoreCase("COM2")) filename = "_" + filename + "_";
                if (filename.equalsIgnoreCase("COM3")) filename = "_" + filename + "_";
                if (filename.equalsIgnoreCase("COM4")) filename = "_" + filename + "_";
                if (filename.equalsIgnoreCase("COM5")) filename = "_" + filename + "_";
                if (filename.equalsIgnoreCase("COM6")) filename = "_" + filename + "_";
                if (filename.equalsIgnoreCase("COM7")) filename = "_" + filename + "_";
                if (filename.equalsIgnoreCase("COM8")) filename = "_" + filename + "_";
                if (filename.equalsIgnoreCase("COM9")) filename = "_" + filename + "_";
                if (filename.equalsIgnoreCase("LPT1")) filename = "_" + filename + "_";
                try
                {
                    XFLog.info("清空之前的缓存");
                    JMCIFileToMinecraftFunctionFile.clearAll();

                    XFLog.info("申请缓存空间");
                    File file = new File("cache/space/" + filename + "/saves");
                    File file2 = new File("cache/space/" + filename + "/mods");
                    File file3 = new File("cache/space/" + filename + "/resourcePacks");
                    File file4 = new File("cache/space/" + filename + "/options.txt");
                    File file5 = new File("cache/space/" + filename + "/optionsof.txt");
                    XFLog.info("准备: "+ file.getAbsolutePath());
                    XFLog.info("准备: "+ file2.getAbsolutePath());
                    XFLog.info("准备: "+ file3.getAbsolutePath());
                    XFLog.info("准备: "+ file4.getAbsolutePath());
                    file.mkdirs();
                    file2.mkdirs();
                    file3.mkdirs();
                    WriteFile.writeStringToFile(file4.getAbsolutePath(), "version:1343\n" +
                            "invertYMouse:false\n" +
                            "mouseSensitivity:0.5\n" +
                            "fov:0.0\n" +
                            "gamma:0.0\n" +
                            "saturation:0.0\n" +
                            "renderDistance:8\n" +
                            "guiScale:0\n" +
                            "particles:0\n" +
                            "bobView:true\n" +
                            "anaglyph3d:false\n" +
                            "maxFps:260\n" +
                            "fboEnable:true\n" +
                            "difficulty:0\n" +
                            "fancyGraphics:true\n" +
                            "ao:2\n" +
                            "renderClouds:true\n" +
                            "resourcePacks:[\"xfherun_piano_resources.zip\"]\n" +
                            "incompatibleResourcePacks:[]\n" +
                            "lastServer:\n" +
                            "lang:zh_cn\n" +
                            "chatVisibility:0\n" +
                            "chatColors:true\n" +
                            "chatLinks:true\n" +
                            "chatLinksPrompt:true\n" +
                            "chatOpacity:1.0\n" +
                            "snooperEnabled:true\n" +
                            "fullscreen:false\n" +
                            "enableVsync:false\n" +
                            "useVbo:true\n" +
                            "hideServerAddress:false\n" +
                            "advancedItemTooltips:true\n" +
                            "pauseOnLostFocus:true\n" +
                            "touchscreen:false\n" +
                            "overrideWidth:0\n" +
                            "overrideHeight:0\n" +
                            "heldItemTooltips:true\n" +
                            "chatHeightFocused:1.0\n" +
                            "chatHeightUnfocused:0.44366196\n" +
                            "chatScale:1.0\n" +
                            "chatWidth:1.0\n" +
                            "mipmapLevels:4\n" +
                            "forceUnicodeFont:true\n" +
                            "reducedDebugInfo:false\n" +
                            "useNativeTransport:true\n" +
                            "entityShadows:true\n" +
                            "mainHand:right\n" +
                            "attackIndicator:1\n" +
                            "showSubtitles:true\n" +
                            "realmsNotifications:true\n" +
                            "enableWeakAttacks:false\n" +
                            "autoJump:true\n" +
                            "narrator:0\n" +
                            "tutorialStep:none\n" +
                            "key_key.attack:-100\n" +
                            "key_key.use:-99\n" +
                            "key_key.forward:17\n" +
                            "key_key.left:30\n" +
                            "key_key.back:31\n" +
                            "key_key.right:32\n" +
                            "key_key.jump:57\n" +
                            "key_key.sneak:42\n" +
                            "key_key.sprint:29\n" +
                            "key_key.drop:16\n" +
                            "key_key.inventory:18\n" +
                            "key_key.chat:20\n" +
                            "key_key.playerlist:15\n" +
                            "key_key.pickItem:-98\n" +
                            "key_key.command:53\n" +
                            "key_key.screenshot:60\n" +
                            "key_key.togglePerspective:63\n" +
                            "key_key.smoothCamera:0\n" +
                            "key_key.fullscreen:87\n" +
                            "key_key.spectatorOutlines:0\n" +
                            "key_key.swapHands:33\n" +
                            "key_key.saveToolbarActivator:0\n" +
                            "key_key.loadToolbarActivator:45\n" +
                            "key_key.advancements:38\n" +
                            "key_key.hotbar.1:2\n" +
                            "key_key.hotbar.2:3\n" +
                            "key_key.hotbar.3:4\n" +
                            "key_key.hotbar.4:5\n" +
                            "key_key.hotbar.5:6\n" +
                            "key_key.hotbar.6:7\n" +
                            "key_key.hotbar.7:8\n" +
                            "key_key.hotbar.8:9\n" +
                            "key_key.hotbar.9:10\n" +
                            "key_of.key.zoom:46\n" +
                            "soundCategory_master:1.0\n" +
                            "soundCategory_music:0.0\n" +
                            "soundCategory_record:1.0\n" +
                            "soundCategory_weather:0.0\n" +
                            "soundCategory_block:1.0\n" +
                            "soundCategory_hostile:1.0\n" +
                            "soundCategory_neutral:1.0\n" +
                            "soundCategory_player:1.0\n" +
                            "soundCategory_ambient:1.0\n" +
                            "soundCategory_voice:1.0\n" +
                            "modelPart_cape:true\n" +
                            "modelPart_jacket:true\n" +
                            "modelPart_left_sleeve:true\n" +
                            "modelPart_right_sleeve:true\n" +
                            "modelPart_left_pants_leg:true\n" +
                            "modelPart_right_pants_leg:true\n" +
                            "modelPart_hat:true\n", "UTF-8");
                    WriteFile.writeStringToFile(file5.getAbsolutePath(), "ofFogType:1\n" +
                            "ofFogStart:0.8\n" +
                            "ofMipmapType:0\n" +
                            "ofOcclusionFancy:false\n" +
                            "ofSmoothFps:true\n" +
                            "ofSmoothWorld:true\n" +
                            "ofAoLevel:1.0\n" +
                            "ofClouds:0\n" +
                            "ofCloudsHeight:0.0\n" +
                            "ofTrees:0\n" +
                            "ofDroppedItems:0\n" +
                            "ofRain:0\n" +
                            "ofAnimatedWater:0\n" +
                            "ofAnimatedLava:0\n" +
                            "ofAnimatedFire:true\n" +
                            "ofAnimatedPortal:true\n" +
                            "ofAnimatedRedstone:true\n" +
                            "ofAnimatedExplosion:true\n" +
                            "ofAnimatedFlame:true\n" +
                            "ofAnimatedSmoke:true\n" +
                            "ofVoidParticles:true\n" +
                            "ofWaterParticles:true\n" +
                            "ofPortalParticles:true\n" +
                            "ofPotionParticles:true\n" +
                            "ofFireworkParticles:true\n" +
                            "ofDrippingWaterLava:true\n" +
                            "ofAnimatedTerrain:true\n" +
                            "ofAnimatedTextures:true\n" +
                            "ofRainSplash:true\n" +
                            "ofLagometer:true\n" +
                            "ofShowFps:true\n" +
                            "ofAutoSaveTicks:4000\n" +
                            "ofBetterGrass:3\n" +
                            "ofConnectedTextures:2\n" +
                            "ofWeather:false\n" +
                            "ofSky:true\n" +
                            "ofStars:true\n" +
                            "ofSunMoon:true\n" +
                            "ofVignette:0\n" +
                            "ofChunkUpdates:5\n" +
                            "ofChunkUpdatesDynamic:true\n" +
                            "ofTime:0\n" +
                            "ofClearWater:false\n" +
                            "ofAaLevel:0\n" +
                            "ofAfLevel:1\n" +
                            "ofProfiler:true\n" +
                            "ofBetterSnow:false\n" +
                            "ofSwampColors:true\n" +
                            "ofRandomEntities:true\n" +
                            "ofSmoothBiomes:true\n" +
                            "ofCustomFonts:true\n" +
                            "ofCustomColors:true\n" +
                            "ofCustomItems:true\n" +
                            "ofCustomSky:true\n" +
                            "ofShowCapes:true\n" +
                            "ofNaturalTextures:false\n" +
                            "ofEmissiveTextures:true\n" +
                            "ofLazyChunkLoading:true\n" +
                            "ofRenderRegions:true\n" +
                            "ofSmartAnimations:false\n" +
                            "ofDynamicFov:true\n" +
                            "ofAlternateBlocks:true\n" +
                            "ofDynamicLights:3\n" +
                            "ofScreenshotSize:1\n" +
                            "ofCustomEntityModels:true\n" +
                            "ofCustomGuis:true\n" +
                            "ofShowGlErrors:true\n" +
                            "ofFullscreenMode:Default\n" +
                            "ofFastMath:true\n" +
                            "ofFastRender:true\n" +
                            "ofTranslucentBlocks:0\n" +
                            "key_of.key.zoom:46\n", "UTF-8");
                    XFLog.info(file.getAbsolutePath() + " :: 创建完毕！");
                    XFLog.info(file2.getAbsolutePath() + " :: 创建完毕！");
                    XFLog.info(file3.getAbsolutePath() + " :: 创建完毕！");
                    XFLog.info(file4.getAbsolutePath() + " :: 创建完毕！");
                    XFLog.info(file5.getAbsolutePath() + " :: 创建完毕！");
                    XFLog.info("准备将JMCI生成Minecraft函数文件");
                    File fileRoot = new File(file.getAbsolutePath() + "/" + filename + "/data/functions/xfherun_redstone_music");
                    XFLog.info("开始将JMCI文件转化成mcfunction文件");
                    JMCIFileToMinecraftFunctionFile.startRead2(new File(jmciPath).getAbsoluteFile(), fileRoot, projectName, minecraftPath, mainTitle, subTitle);
                }
                catch (Exception e)
                {
                    XFLog.err("申请缓存区失败！", e);
                    JOptionPane.showMessageDialog(MainWindow.getMainWindow(),
                            "申请缓存区失败！",
                            "错误", 0);
                }
            }
            else
            {
                XFLog.warn("没有名为" + type + "的类型");
                JOptionPane.showMessageDialog(MainWindow.getMainWindow(),
                        "没有名为" + type + "的类型",
                        "警告", 2);
            }
        }
        else
        {
            XFLog.warn("意外的 Minecraft function file name: " + minecraftFunctionFileName, new RuntimeException("Error minecraftFunctionFileName: " + minecraftFunctionFileName));
            JOptionPane.showMessageDialog(MainWindow.getMainWindow(),
                    "意外的 Minecraft function file name: " + minecraftFunctionFileName,
                    "警告", 2);
        }
    }
}
