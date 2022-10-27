package task2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Reader {

    private static Map<String, Document> map = new HashMap<>();

    public static void readSmallFile(String fileName) throws IOException {
        Path path = Paths.get(fileName);

        List<String> strings = Files.readAllLines(path);

        for (String s: strings) {
            String phoneNumber = Getter.getPhoneNumber(s);
            String mail = Getter.getMail(s);
            String docNumber = Getter.getDocNumber(s);
            if (phoneNumber.isEmpty() && mail.isEmpty() && docNumber.isEmpty()) {
                Directory.invalidFile++;
                map.put(fileName, new Document("", "", ""));
            } else if (!phoneNumber.isEmpty() && !mail.isEmpty() && !docNumber.isEmpty()) {
                map.put(fileName, new Document(phoneNumber, mail, docNumber));
            } else if (!phoneNumber.isEmpty() && !mail.isEmpty() && docNumber.isEmpty()){
                map.put(fileName, new Document(phoneNumber, mail, ""));
            } else if (!phoneNumber.isEmpty() && mail.isEmpty() && docNumber.isEmpty()){
                map.put(fileName, new Document(phoneNumber, "", ""));
            } else if (phoneNumber.isEmpty() && !mail.isEmpty() && !docNumber.isEmpty()){
                map.put(fileName, new Document("", mail, docNumber));
            } else if (phoneNumber.isEmpty() && mail.isEmpty() && !docNumber.isEmpty()){
                map.put(fileName, new Document("", "", docNumber));
            } else if (phoneNumber.isEmpty() && !mail.isEmpty() && docNumber.isEmpty()){
                map.put(fileName, new Document("", mail, ""));
            } else if (!phoneNumber.isEmpty() && mail.isEmpty() && !docNumber.isEmpty()){
                map.put(fileName, new Document(phoneNumber, "", docNumber));
            }
        }

    }

    public static void vyvod(){
        System.out.println(map);
    }
}
