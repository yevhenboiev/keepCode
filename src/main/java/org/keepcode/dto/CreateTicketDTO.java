package org.keepcode.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateTicketDTO {

    @NotBlank(message = "name is mandatory")
    @Size(min = 4, max = 32, message = "Email must have between 6 and 32 characters")
    private String name;

    @NotNull
    private Long value;
}
