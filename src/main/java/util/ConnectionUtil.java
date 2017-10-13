package util;

import java.io.IOException;
import java.net.*;

public class ConnectionUtil {


    public static HttpURLConnection getConnection(String request, Integer id){
        try {
            return (HttpURLConnection) new URL(
                    String.format(request, id, Constants.ACCESS_TOKEN))
                    .openConnection(Constants.PROXY);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
