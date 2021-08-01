package com.wallet.dto;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
public class UserDTO 
{
	private Long id;
	@Email(message="E-mail Inválido")
	private String email;
	@Length(min = 2, max = 60, message="O nome deve conter entre 2 e 60 caracteres.")
	private String name;
	@NotNull
	@Length(min = 6, message="A senha deve conter no mínimo 6 caracteres.")
	private String password;
}
