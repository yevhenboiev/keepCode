package org.keepcode.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.keepcode.entity.enums.Role;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@Table(name = "subscriber")
public class Subscriber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @JsonIgnore
    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "role", nullable = false)
    private Role role;

    @Column(name = "creationDate", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm")
    private Timestamp creationDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Subscriber that = (Subscriber) o;

        if (!id.equals(that.id)) return false;
        if (!email.equals(that.email)) return false;
        if (!password.equals(that.password)) return false;
        if (role != that.role) return false;
        return creationDate.equals(that.creationDate);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + role.hashCode();
        result = 31 * result + creationDate.hashCode();
        return result;
    }
}
