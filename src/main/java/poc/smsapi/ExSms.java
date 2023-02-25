package poc.smsapi;

import pl.smsapi.OAuthClient;
import pl.smsapi.api.SmsFactory;
import pl.smsapi.api.action.sms.SMSSend;
import pl.smsapi.exception.SmsapiException;
import pl.smsapi.proxy.ProxyNative;

public class ExSms {
    public static void send() {
        try {
            String oauthToken = System.getenv("SMS_TOKEN");
            OAuthClient client = new OAuthClient(oauthToken);
            ProxyNative proxy = new ProxyNative("https://api.smsapi.pl/");

            SmsFactory smsApi = new SmsFactory(client, proxy);

            SMSSend action = smsApi.actionSend()
                    .setTo(System.getenv("SMS_RECIPIENT"))
                    .setText("i HATE computers!");

            action.execute();
        } catch (SmsapiException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}