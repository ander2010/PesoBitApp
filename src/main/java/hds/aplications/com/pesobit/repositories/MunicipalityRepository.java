package hds.aplications.com.pesobit.repositories;

import com.activeandroid.Model;
import com.activeandroid.query.Select;

import java.util.List;

import hds.aplications.com.pesobit.models.Municipality;
import hds.aplications.com.pesobit.models.Province;

/**
 * Created by Miguel Gomez Leon on 11/30/15.
 * mgleonsc@gmail.com
 */
public class MunicipalityRepository extends BaseRepository {

    public MunicipalityRepository() {
        this.cls = Municipality.class;
    }

    public List<Model> getByProvince(Province province) {
        return new Select().from((Class<? extends Model>) this.cls).where("id_province = ?", province.getIdRef()).orderBy("name ASC").execute();
    }
}
