package hds.aplications.com.pesobit.models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Miguel Gomez Leon on 3/11/16.
 * mgleonsc@gmail.com
 */

@Table(name = "status", id = "_id")
public class Status extends Model {

    @Column(name = "id_ref")
    @SerializedName("status_id")
    private long idRef;

    @Column(name = "name")
    @SerializedName("status_name")
    private String name;

    @Column(name = "description")
    @SerializedName("description")
    private String description;

    public Status() {
    }

    public Status(long idRef, String name, String description) {
        this.idRef = idRef;
        this.name = name;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
