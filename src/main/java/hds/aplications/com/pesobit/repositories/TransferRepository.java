package hds.aplications.com.pesobit.repositories;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.Model;
import com.activeandroid.query.Select;

import java.util.List;

import hds.aplications.com.pesobit.models.Transfer;

public class TransferRepository extends BaseRepository {

    public TransferRepository() {
        this.cls = Transfer.class;
    }
}
