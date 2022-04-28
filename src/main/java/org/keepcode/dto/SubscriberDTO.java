package org.keepcode.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.keepcode.entity.enums.Role;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubscriberDTO {

    private Long id;
    @NotNull
    private String email;
    @NotNull
    @JsonIgnore
    private String password;
    @NotNull
    private Role role;
    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm")
    private Timestamp creationDate;

}
