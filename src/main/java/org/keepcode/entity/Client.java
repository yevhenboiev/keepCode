package org.keepcode.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Setter
@Getter
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "subscriber_id")
    private Subscriber subscriber;

    @Column(name = "client_name", nullable = false)
    private String clientName;

    @Column(name = "creationDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm")
    private Timestamp creationDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (!id.equals(client.id)) return false;
        if (!subscriber.equals(client.subscriber)) return false;
        if (!clientName.equals(client.clientName)) return false;
        return creationDate.equals(client.creationDate);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + subscriber.hashCode();
        result = 31 * result + clientName.hashCode();
        result = 31 * result + creationDate.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Client + " + id + "name : " + clientName;
    }
}
