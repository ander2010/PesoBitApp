package hds.aplications.com.pesobit.models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by YANET on 26/11/2015.
 */

@Table(name = "language", id = "_id")
public class Language extends Model {


    @Column(name = "id_ref")
    private long idRef;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    public Language() {
    }

    public Language(long idRef, String name, String code) {

        this.idRef = idRef;
        this.name = name;
        this.code = code;
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

    public String getCode() {
        return code;
    }

    public void setCode(String name) {
        this.code = code;
    }
}
