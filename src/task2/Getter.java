package task2;


import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Getter {


    public static String getPhoneNumber(String file){

        Pattern phoneNumberPattern = Pattern.compile("\\+?\\(?33\\)?[0-9]{7}");
        Matcher matcher = phoneNumberPattern.matcher(file);
        String phoneNumber = null;

        while(matcher.find()){
            phoneNumber = getInfo(matcher.group());
        }


        return phoneNumber;
    }

    public static String getMail(String file){
        Pattern pattern = Pattern.compile("\\w+\\d+@mail.ru");
        Matcher matcher = pattern.matcher(file);

        String mail = null;

        while(matcher.find()){
            mail = getInfo(matcher.group());
        }


        return mail;
    }

    public static String getDocNumber(String file){
        Pattern pattern = Pattern.compile("[0-9][0-9][0-9][0-9]-([a-z][a-z][a-z][a-z]|[A-Z][A-Z][A-Z][A-Z])-[0-9][0-9][0-9][0-9]-([0-9][a-z][0-9][a-z]|[0-9][A-Z][0-9][A-Z])");
        Matcher matcher = pattern.matcher(file);

        String docNumber = null;

        while(matcher.find()) {
            docNumber = getInfo(matcher.group());
        }

        return docNumber;
    }

    public static String getInfo(String e){
        String info = null;
        List <String> list = new ArrayList<>();
        list.add(e);

        for (String s:list) {
            if(s.isEmpty()){
                continue;
            }else{
                info = s;
            }
        }

        return info;
    }
}
