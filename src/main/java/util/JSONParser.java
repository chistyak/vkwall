package util;

import javax.json.*;
import java.io.InputStream;

public class JSONParser {
    public static Integer getPostId(InputStream inputStream){
        try {
            JsonReader jsonReader = Json.createReader(inputStream);
            JsonObject object = jsonReader.readObject();
            JsonNumber postId = object.getJsonArray("response").getJsonObject(1).getJsonNumber("id");
            return postId.intValue();
        }
        catch (NullPointerException ex){
            return null;
        }
    }

    public static String getPostText(InputStream inputStream){
        JsonReader jsonReader = Json.createReader(inputStream);
        JsonObject object = jsonReader.readObject();
        JsonString postText = object.getJsonArray("response").getJsonObject(1).getJsonString("text");
        return postText.getString();
    }
}
