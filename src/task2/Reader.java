package task2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Reader {

    private static Map<String, Document> documentsInfo = new HashMap<>();

    public static void readSmallFile(String fileName, String absolutePath) throws IOException {
        Path path = Paths.get(absolutePath);

        List<String> strings = Files.readAllLines(path);

        for (String s: strings) {
            String phoneNumber = Getter.getPhoneNumber(s);
            String mail = Getter.getMail(s);
            String docNumber = Getter.getDocNumber(s);
            if (phoneNumber == null && mail == null && docNumber == null) {
                Directory.invalidFile++;
            } else {
                documentsInfo.put(fileName, new Document(phoneNumber, docNumber, mail));
            }
        }
    }
}
