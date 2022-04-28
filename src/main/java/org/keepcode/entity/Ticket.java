package org.keepcode.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@Table(name = "ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client", nullable = false)
    private Client client;

    @Column(name = "value", nullable = false)
    private Long value;

    @Column(name = "date_creation", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm")
    private Timestamp creationDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ticket ticket = (Ticket) o;

        if (!id.equals(ticket.id)) return false;
        if (!client.equals(ticket.client)) return false;
        if (!value.equals(ticket.value)) return false;
        return creationDate.equals(ticket.creationDate);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + client.hashCode();
        result = 31 * result + value.hashCode();
        result = 31 * result + creationDate.hashCode();
        return result;
    }
}
