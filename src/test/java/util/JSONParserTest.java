package util;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.*;

public class JSONParserTest {

    InputStream inputStream;
    int postIdExpected;
    private String postTextExpected;

    @Before
    public void setUp() throws Exception {
        inputStream = new ByteArrayInputStream("{\"response\":[261,{\"id\":2048795,\"from_id\":1,\"to_id\":1,\"date\":1507669150,\"post_type\":\"post\",\"text\":\"Спасибо всем, кто поздравил с 33-летием. Во времена управления ВКонтакте я любил масштабно отметить 10 октября, так как этот день был еще и годовщиной основания компании.<br><br>После ухода из ВК большого повода собирать гостей уже нет, поэтому последние пару лет я ухожу от классического празднования дня рождения, фокусируясь на рабочих процессах. <br><br>Так было в прошлом году, когда мы с разработчиками уединились в бывшем мужском монастыре для продуктового марш-броска. Схожим образом вышло и в этом году. Cегодня мы запускали обновление Telegram – версию 4.4 с трансляцией геопозиции в реальном времени, новым музыкальным плеером и поддержкой нескольких новых языков.<br><br>В частности, интерфейс Telegram теперь доступен на русском и украинском. Это стало возможным благодаря нашей новой платформе translations.telegram.org, которая позволяет всем желающим совместно работать над переводом интерфейса Telegram на другие языки – и моментально применять изменения.<br><br>Таким образом, сегодня родился “русский” (а также украинский, французский, индонезийский и малайский) Telegram. Через год уже будет, что отметить.\",\"post_source\":{\"type\":\"vk\"},\"comments\":{\"count\":3369,\"groups_can_post\":true,\"can_post\":1},\"likes\":{\"count\":17225,\"user_likes\":0,\"can_like\":1,\"can_publish\":1},\"reposts\":{\"count\":542,\"user_reposted\":0},\"online\":0,\"reply_count\":0}]}".getBytes());
        postIdExpected = 2048795;
        postTextExpected = "Спасибо всем, кто поздравил с 33-летием. Во времена управления ВКонтакте я любил масштабно отметить 10 октября, так как этот день был еще и годовщиной основания компании.<br><br>После ухода из ВК большого повода собирать гостей уже нет, поэтому последние пару лет я ухожу от классического празднования дня рождения, фокусируясь на рабочих процессах. <br><br>Так было в прошлом году, когда мы с разработчиками уединились в бывшем мужском монастыре для продуктового марш-броска. Схожим образом вышло и в этом году. Cегодня мы запускали обновление Telegram – версию 4.4 с трансляцией геопозиции в реальном времени, новым музыкальным плеером и поддержкой нескольких новых языков.<br><br>В частности, интерфейс Telegram теперь доступен на русском и украинском. Это стало возможным благодаря нашей новой платформе translations.telegram.org, которая позволяет всем желающим совместно работать над переводом интерфейса Telegram на другие языки – и моментально применять изменения.<br><br>Таким образом, сегодня родился “русский” (а также украинский, французский, индонезийский и малайский) Telegram. Через год уже будет, что отметить.";
    }

    @Test
    public void getPostId() throws Exception {
        int postIdActual = JSONParser.getPostId(inputStream);
        Assert.assertEquals(postIdExpected, postIdActual);
    }

    @Test
    public void getPostText() throws Exception {
        String postTextActual = JSONParser.getPostText(inputStream);
        Assert.assertEquals(postTextExpected, postTextActual);
    }

}