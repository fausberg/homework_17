package task2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Directory {

    public static int fileNumber = 0;
    public static int invalidFile = 0;

    static int filesNumber = new Scanner(System.in).nextInt();
    static int check = 0;
    public static void findFile(File dir) {


        try {


            File[] dirlist = dir.listFiles();

            for (int i = 0; i < dirlist.length; i++) {
                if (dirlist[i].isFile()) {
                    if (check < filesNumber) {
                        check++;
                    } else {
                        break;
                    }
                    fileNumber++;
                    System.out.println("Файл " + dirlist[i].getName() + " директории " + dir.getName());
                    if (dirlist[i].length() == 0) {
                        System.out.println("Файл пустой");
                        invalidFile++;
                    } else {
                        System.out.println("В файле есть данные");
                        Reader.readSmallFile(dirlist[i].getName(), dirlist[i].getAbsolutePath());
                    }
                }
                if (dirlist[i].isDirectory()) {
                    System.out.println("Директория " + dirlist[i].getName());
                    File[] dirlist1 = dirlist[i].listFiles();
                    if (dirlist1.length == 0) {
                        System.out.println("Директория пуста");
                    } else {
                        System.out.println("Файлы директории:");
                        findFile(dirlist[i]);
                    }
                }
            }

        } catch (NullPointerException e){
            String massage = "Такого файла нет";
            System.out.println(massage);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void info(){
        System.out.println("Файлов проверено " + fileNumber);
        System.out.println("Файлов не прошедших проверку " + invalidFile);
    }
}
