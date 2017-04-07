package upsite.com.personalspace;

/**
 * Created by shneo on 15.03.2017.
 */

public class UserDataModel {
    String userCardAvatar;
    String userName;
    String userRate;
    String userHeart;
    //private UUID idUser;


    public UserDataModel(String userCardAvatar, String userName, String userRate, String userHeart) {
        //this.userCardAvatar = userCardAvatar;
        this.userName = userName;
        this.userRate = userRate;
        this.userHeart = userHeart;
        //UUID idUser = UUID.randomUUID();
    }

    public String getUserCardAvatar() {
        return userCardAvatar;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserRate() {
        return userRate;
    }

    public String getUserHeart() {
        return userHeart;
    }

    //public UUID getIdUser(){
    //    return idUser;
    //}
}
