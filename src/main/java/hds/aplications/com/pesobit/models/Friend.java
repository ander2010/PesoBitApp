package hds.aplications.com.pesobit.models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by Miguel Gomez Leon on 3/11/16.
 * mgleonsc@gmail.com
 */

@Table(name = "friend", id = "_id")
public class Friend extends Model {
    @Column(name = "id_ref")
    @SerializedName("friend_id")
    private long idRef;

    @Column(name = "date")
    @SerializedName("date")
    private Date date;

    @Column(name = "id_user", onDelete = Column.ForeignKeyAction.CASCADE)
    @SerializedName("id_user")
    private User user;

    @Column(name = "id_user_friend", onDelete = Column.ForeignKeyAction.CASCADE)
    @SerializedName("id_user_friend")
    private User userFriend;

    public Friend() {}

    public Friend(long idRef, Date date, User userFriend, User user) {
        this.idRef = idRef;
        this.date = date;
        this.userFriend = userFriend;
        this.user = user;
    }

    public long getIdRef() {
        return idRef;
    }

    public void setIdRef(long idRef) {
        this.idRef = idRef;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUserFriend() {
        return userFriend;
    }

    public void setUserFriend(User userFriend) {
        this.userFriend = userFriend;
    }
}
