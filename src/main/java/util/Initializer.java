package util;

import dto.UserEntity;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class Initializer {

    public static List<Thread> initialize(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<UserEntity> list = session.createCriteria(UserEntity.class).list();
        List<Thread> threadList = new ArrayList<Thread>();
        for(UserEntity x : list){
            threadList.add(new UserThread(x));
        }
        return threadList;
    }
}
