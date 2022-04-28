package org.keepcode.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubscriberAuthDTO {

    @NotBlank(message = "Email is mandatory")
    @Size(min = 4, max = 32, message = "Email must have between 6 and 32 characters")
    private String email;

    @Size(min = 8, max = 20, message = "Password must have between 8 and 20 characters")
    private String password;
}
