package util;

import java.net.InetSocketAddress;
import java.net.Proxy;

public class Constants {
    public static  String ACCESS_TOKEN = "f6b93eb1f6b93eb1f6b93eb149f6e2c486ff6b9f6b93eb1afadd08681a777074e08db97";//тут поправить обязательно нужно
    /**
     * request to get last post
     * from the wall of selected user
     */
    public static final String LAST_WALL_POST =
            "https://api.vk.com/method/wall.get?owner_id=%1$s&access_token=%2$s&count=1";
    /**
     * proxy to gain access from ukraine
     */
    public static final Proxy PROXY = new Proxy(
            Proxy.Type.HTTP, new InetSocketAddress("45.77.140.180", 3128));
}