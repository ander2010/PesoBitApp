package hds.aplications.com.mycplight.models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by YANET on 26/11/2015.
 */

@Table(name = "reservationStatus", id = "_id")
public class ReservationStatus extends Model {

    public static final String STATUS_CANCELED = "cancelada";
    public static final String STATUS_RESERVED = "reservada";

    @Column(name = "name")
    public String name;

    public ReservationStatus() {
    }

    public ReservationStatus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
