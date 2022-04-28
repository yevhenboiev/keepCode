package org.keepcode.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.keepcode.entity.Client;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TicketDTO {

    private Long id;
    @NotNull
    private Client client;
    @NotNull
    private Long value;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm")
    private Timestamp creationDate;
}
