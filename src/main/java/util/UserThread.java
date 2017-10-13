package util;

import dto.PostEntity;
import dto.UserEntity;

import java.io.IOException;

public class UserThread extends Thread{


    private UserEntity userEntity;
    private Integer newPostId;

    public UserThread(UserEntity userEntity){
        this.userEntity = userEntity;
    }

    public void run(){
        while(!isInterrupted()){
            newPostId = Requests.getLastPostId(userEntity.getId());
            if(userEntity.getLastPostId() != null && newPostId > userEntity.getLastPostId())
                rewrite();
            else if(newPostId != null && userEntity.getLastPostId() == null)
                rewrite();
            System.out.println(userEntity.getId());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void rewrite(){
        PostEntity postEntity = Requests.getLastPost(userEntity.getId());
        userEntity.setLastPostId(postEntity.getId());
        userEntity.update();
        postEntity.save();
    }
}
