package main.java.com.xfherun.jmci.user_interface.function;

import main.java.com.xfherun.jmci.utils.RandomGeneratorImages;

import java.io.File;
import java.util.Objects;
import java.util.Random;

public class ChangeImage extends Thread
{
    @Override
    public void run()
    {
        while (true)
        {
            File file = new File("cache/home_title_image_flush").getAbsoluteFile();
            File[] files = file.listFiles();
            for (int i = 0; i < Objects.requireNonNull(files).length; i++)
            {
                File file1 = files[i];
                file1.delete();
            }
            RandomGeneratorImages.randomImage("cache/home_title_image_flush");
            try
            {
                Thread.sleep(new Random().nextInt(2500, 6000));
            }
            catch (InterruptedException e)
            {
                throw new RuntimeException(e);
            }
        }
    }
}
