package task2;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String name = new Scanner(System.in).nextLine();

        Directory.findFile(new File(name));

        Directory.info();

    }
}
