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

@Table(name = "transfer", id = "_id")
public class Transfer extends Model {
    @Column(name = "id_ref")
    @SerializedName("transfer_id")
    private long idRef;

    @Column(name = "amount")
    @SerializedName("amount")
    private double amount;

    @Column(name = "created")
    @SerializedName("created")
    private Date created;

    @Column(name = "id_status", onDelete = Column.ForeignKeyAction.CASCADE)
    @SerializedName("id_status")
    private Status status;

    @Column(name = "id_sender", onDelete = Column.ForeignKeyAction.CASCADE)
    @SerializedName("id_sender")
    private Account sender;

    @Column(name = "id_receiver", onDelete = Column.ForeignKeyAction.CASCADE)
    @SerializedName("id_receiver")
    private Account receiver;

    @Column(name = "message")
    @SerializedName("message")
    private String message;

    public Transfer() {
    }

    public Transfer(long idRef, double amount, Date created, Status status, Account sender, Account receiver, String message) {
        this.idRef = idRef;
        this.amount = amount;
        this.created = created;
        this.status = status;
        this.sender = sender;
        this.receiver = receiver;
        this.message = message;
    }

    public long getIdRef() {
        return idRef;
    }

    public void setIdRef(long idRef) {
        this.idRef = idRef;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Account getSender() {
        return sender;
    }

    public void setSender(Account sender) {
        this.sender = sender;
    }

    public Account getReceiver() {
        return receiver;
    }

    public void setReceiver(Account receiver) {
        this.receiver = receiver;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
