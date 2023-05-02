package main.java.com.xfherun.jmci.utils;

import com.xfherun.xflog.XFLog;

import java.net.URL;
import java.nio.file.Path;

public class Resources {
    private Resources() {}

    public static URL getResources(Class<?> className, String path) {
        XFLog.info("获取资源文件: className -> " + className + " :: path -> " + path);
        return className.getClassLoader().getResource(path);
    }

    public static Path getResourcesToPath(Class<?> className, String path) {
        XFLog.info("获取资源文件: className -> " + className + " :: path -> " + path);
        return Path.of(className.getClassLoader().getResource(path).getFile());
    }
}
