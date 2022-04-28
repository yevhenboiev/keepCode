package org.keepcode.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.keepcode.entity.Subscriber;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO {

    private Long id;
    @NotNull
    private String clientName;
    @NotNull
    private Subscriber subscriber;
    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm")
    private Timestamp creationDate;
}
