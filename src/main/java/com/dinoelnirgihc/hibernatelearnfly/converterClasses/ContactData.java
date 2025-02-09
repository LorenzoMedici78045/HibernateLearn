package com.dinoelnirgihc.hibernatelearnfly.converterClasses;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
/** Класс отображает контактные данные, преобразующиеся в бд в json */
public class ContactData implements Serializable
{
    @Email
    @NotBlank
    private String email;

    @NotBlank
    @Pattern(regexp = "[+][7][9][1-8][1-8][1-8][1-8][1-8][-][1-9][1-9][-][1-9][1-9]", message = "Create correct number")
    private String phone;

    public String createInfo()
    {
        return "Email: " + email + ", Phone: " + phone;
    }
}
