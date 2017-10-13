package util;

import dto.PostEntity;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;


public class Requests {

    public static Integer getLastPostId(Integer userId){
        HttpURLConnection connection = ConnectionUtil.getConnection(Constants.LAST_WALL_POST, userId);
        Integer lastPostId = 0;
        try {
            InputStream inputStream = connection.getInputStream();
            if (inputStream != null)
                lastPostId = JSONParser.getPostId(connection.getInputStream());
            return lastPostId;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getLastPostText(Integer userId){
        HttpURLConnection connection = ConnectionUtil.getConnection(Constants.LAST_WALL_POST, userId);
        String lastPostText = null;
        try {
            InputStream inputStream = connection.getInputStream();
            if (inputStream != null)
            lastPostText = JSONParser.getPostText(connection.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lastPostText;
    }

    public static PostEntity getLastPost(int id){
        PostEntity postEntity = new PostEntity();
        postEntity.setUser(id);
        postEntity.setId(getLastPostId(id));
        postEntity.setText(getLastPostText(id));
        return postEntity;
    }
}
