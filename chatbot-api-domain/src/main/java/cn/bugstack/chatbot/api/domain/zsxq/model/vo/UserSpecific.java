package cn.bugstack.chatbot.api.domain.zsxq.model.vo;

/**
 * @description 
 * @author：hgd
 * @date: 2023-01-31
 */
public class UserSpecific {

    private boolean liked;

    private boolean subscribed;

    public void setLiked(boolean liked){
        this.liked = liked;
    }
    public boolean getLiked(){
        return this.liked;
    }
    public void setSubscribed(boolean subscribed){
        this.subscribed = subscribed;
    }
    public boolean getSubscribed(){
        return this.subscribed;
    }

}
