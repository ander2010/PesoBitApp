package hds.aplications.com.pesobit.common;

import hds.aplications.com.pesobit.models.User;

/**
 * Created by Miguel Gomez Leon on 12/8/15.
 * mgleonsc@gmail.com
 */
public class SAppData {
    private static SAppData ourInstance = new SAppData();

    private User user;

    public static SAppData getInstance() {
        return ourInstance;
    }

    private SAppData() {}

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
