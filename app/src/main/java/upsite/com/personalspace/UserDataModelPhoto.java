package upsite.com.personalspace;

/**
 * Created by Ilik on 05.04.2017.
 */

public class UserDataModelPhoto {
    String userPhoto;
    int index;

    public UserDataModelPhoto(String userPhoto, int index) {
        this.userPhoto = userPhoto;
        this.index = index;
    }

    public String getUserPhoto() {
        return userPhoto;
    }

    public int getIndex(){
        return index;
    }


}
