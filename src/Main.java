import javafx.application.Application;

import javax.swing.*;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args)
    {
        try
        {
            TimeUnit.SECONDS.sleep(10);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }


        //удаляем старое ядро
        File file = new File(System.getProperty("user.dir")+"\\lib\\spark-core.jar");
        File file2 = new File(System.getProperty("user.dir")+"\\lib\\spark-core-3.0.0-beta.jar");
        file2.delete();
        if(file.delete())
            System.out.println("файл удален");
        else
            System.out.println("не обнаружено");


        //Скачиваем новое ядро
        try (BufferedInputStream inputStream = new BufferedInputStream(new URL("http://adm-sharya.ru/ichat/spark-core.jar").openStream());
             FileOutputStream fileOS = new FileOutputStream(System.getProperty("user.dir")+"\\lib\\spark-core.jar"))
        {

            byte data[] = new byte[1024];
            int byteContent;
            while ((byteContent = inputStream.read(data, 0, 1024)) != -1)
            {
                fileOS.write(data, 0, byteContent);
            }
        }
        catch (IOException e)
        {
            System.out.print(e.getMessage());
            return;
        }

       /* Thread t = new Thread(new Runnable()
        {
            public void run()
            {
                JOptionPane.showMessageDialog(null, "Программа обновилась");
            }
        });
        t.start();*/

        //ShowMessage - c Вариантами кнопок YES - NO
        int selectedOption = JOptionPane.showConfirmDialog(null, "iChat Успешно обновлен \n Запустить чат ?", System.getProperty("user.dir"), JOptionPane.YES_NO_OPTION);
        if (selectedOption == JOptionPane.YES_OPTION)
        {
            try
            {
                Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\spark.exe");
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }

    }
}
