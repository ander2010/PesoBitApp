package hds.aplications.com.pesobit.models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Miguel Gomez Leon on 11/21/15.
 * mgleonsc@gmail.com
 */

@Table(name = "user", id = "_id")
public class User extends Model{

    @Column(name = "id_ref")
    @SerializedName("user_id")
    private long idRef;

    @Column(name = "name")
    @SerializedName("user_name")
    private String name;

    @Column(name = "password")
    private String password;

    @Column(name = "first_name")
    @SerializedName("user_user_name")
    private String firstName;

    @Column(name = "last_name")
    @SerializedName("user_last_name")
    private String lastName;

    @Column(name = "email")
    @SerializedName("user_email")
    private String email;

    @Column(name = "phone")
    @SerializedName("user_phone")
    private String phone;

    @Column(name = "enabled")
    @SerializedName("user_enabled")
    private String enabled;

    public User() {
    }

    public User(String name, String firstName, String lastName, String email, String phone, String enabled) {
        this.name = name;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.enabled = enabled;
    }

    public long getIdRef() {
        return idRef;
    }

    public void setIdRef(long idRef) {
        this.idRef = idRef;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    public String getFullName(){
        return this.firstName + " " + this.lastName;
    }
}

//ch048 ---  123456
//ch002 --- 123456
