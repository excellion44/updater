import javafx.application.Application;

import javax.swing.*;
import java.io.BufferedInputStream;
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
        try (BufferedInputStream inputStream = new BufferedInputStream(new URL("http://adm-sharya.ru/munpasport.pdf").openStream());
             FileOutputStream fileOS = new FileOutputStream("C:/munpasport.pdf"))
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
            System.out.print("Нет доступа к сайту - "+e.getMessage());
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
        int selectedOption = JOptionPane.showConfirmDialog(null, "Доступна новая версия программы \n Запустить обновление ?", "Выберите вариант", JOptionPane.YES_NO_OPTION);
        if (selectedOption == JOptionPane.YES_OPTION)
        {
            System.out.print("111");
        }

    }
}
