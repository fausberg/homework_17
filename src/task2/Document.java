package task2;

public class Document {
    public String phoneNumber;

    public String docNumber;

    public String mail;

    public Document(String phoneNumber, String docNumber, String mail) {
        this.phoneNumber = phoneNumber;
        this.docNumber = docNumber;
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "Document{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", docNumber='" + docNumber + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }
}
