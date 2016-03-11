package hds.aplications.com.mycplight.models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by YANET on 26/11/2015.
 */

@Table(name = "facilityType", id = "_id")
public class FacilityType extends Model {

    @Column(name = "name")
    public String name;

    public FacilityType() {
    }

    public FacilityType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
