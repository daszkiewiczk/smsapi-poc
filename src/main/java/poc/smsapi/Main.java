package poc.smsapi;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        System.out.println(System.getenv("SMS_TOKEN"));

        System.out.println(System.getenv("SMS_RECIPIENT"));
    }

}