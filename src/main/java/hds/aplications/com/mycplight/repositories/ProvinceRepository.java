package hds.aplications.com.mycplight.repositories;

import hds.aplications.com.mycplight.models.Province;

/**
 * Created by Miguel Gomez Leon on 11/30/15.
 * mgleonsc@gmail.com
 */
public class ProvinceRepository extends BaseRepository {

    public ProvinceRepository() {
        this.cls = Province.class;
    }

    /*public Cursor getAll() {
        From query = new Select().from(Province.class).orderBy("name ASC");
        Cursor cursor = Cache.openDatabase().rawQuery(query.toSql(), query.getArguments());
        return cursor;
    }*/


    /*public List<Province> getAllList() {
        return new Select().from(Province.class).orderBy("name ASC").execute();
    }*/
}
