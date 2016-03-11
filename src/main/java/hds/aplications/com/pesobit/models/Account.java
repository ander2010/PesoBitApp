package hds.aplications.com.pesobit.models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by Miguel Gomez Leon on 11/3/16.
 * mgleonsc@gmail.com
 */

@Table(name = "account", id = "_id")
public class Account extends Model {

    @Column(name = "id_ref")
    @SerializedName("account_id")
    private long idRef;

    @Column(name = "public_key")
    @SerializedName("public_key")
    private String publicKey;

    @Column(name = "private_key")
    @SerializedName("private_key")
    private String privateKey;

    @Column(name = "created")
    @SerializedName("created")
    private Date created;

    @Column(name = "amount")
    @SerializedName("amount")
    private double amount;

    @Column(name = "name")
    @SerializedName("name")
    private String name;

    @Column(name = "is_default")
    @SerializedName("is_default")
    private boolean isDefault;

    @Column(name = "id_user", onDelete = Column.ForeignKeyAction.CASCADE)
    @SerializedName("id_user")
    private User user;

    public Account() {}

    public Account(long idRef, String publicKey, String privateKey, Date created, double amount, String name, boolean isDefault, User user) {
        this.idRef = idRef;
        this.publicKey = publicKey;
        this.privateKey = privateKey;
        this.created = created;
        this.amount = amount;
        this.name = name;
        this.isDefault = isDefault;
        this.user = user;
    }

    public long getIdRef() {
        return idRef;
    }

    public void setIdRef(long idRef) {
        this.idRef = idRef;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public void setIsDefault(boolean isDefault) {
        this.isDefault = isDefault;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
