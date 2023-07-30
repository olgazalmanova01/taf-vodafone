package by.itacademy.zalmanova.olga.api;
import java.util.HashMap;

public class Post {

    String endpoint = "https://login.vodafone.co.uk/api/authentication/password";
    String returnUrl = "/connect/authorize/callback?client_id=ecare-auth-prod1&scope=openid%20vf-profile%20vf-account%20vf-subscription%20vf-contact&response_type=code&redirect_uri=https%3A%2F%2Fmyaccount.vodafone.co.uk%2Fauth%2Flogin%2Fcallback&state=%7B%22successReturnUrl%22%3A%22%252Faccount%252Fsummary%253Ficmp%253Duk~1_consumer~topnav~useractions~1_login_to_my_vodafone%2526linkpos%253Dtopnav~1~1%22,%22errorReturnUrl%22%3A%22https%253A%252F%252Fwww.vodafone.co.uk%252F%22%7D&acr_values=LOA%3A3";
    String userIdentifier = "un";

    public HashMap<String, String> generateBody(String username, String password) {
        HashMap<String, String> body = new HashMap<>();
        body.put("username", username);
        body.put("password", password);
        body.put("returnUrl", returnUrl);
        body.put("userIdentifier", userIdentifier);
        return body;
    }
}


