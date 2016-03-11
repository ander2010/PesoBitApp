package hds.aplications.com.mycplight.common;

import hds.aplications.com.mycplight.models.Accommodation;
import hds.aplications.com.mycplight.models.User;

/**
 * Created by Miguel Gomez Leon on 12/8/15.
 * mgleonsc@gmail.com
 */
public class SAppData {
    private static SAppData ourInstance = new SAppData();

    private User user;
    private Accommodation accommodation;

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

    public Accommodation getAccommodation() {
        return accommodation;
    }

    public void setAccommodation(Accommodation accommodation) {
        this.accommodation = accommodation;
    }
}
