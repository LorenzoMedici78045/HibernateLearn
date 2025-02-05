package com.dinoelnirgihc.hibernatelearnfly.json;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
/** Класс отображает контактные данные, преобразующиеся в бд в json */
public class ContactData implements Serializable
{
    @Email
    @NotBlank
    private String email;

    @NotBlank
    @Pattern(regexp = "[+][7][9][1-8][1-8][1-8][1-8][1-8][-][1-9][1-9][-][1-9][1-9]", message = "Create correct number")
    private String phone;
}
