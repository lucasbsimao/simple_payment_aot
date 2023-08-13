package com.simple_payment_aot.accounts.web.dtos;

import jakarta.validation.constraints.Pattern;

public class CreateAccountRequestDto {

    public CreateAccountRequestDto(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    //Verificar mensagens de retorno
    @Pattern(regexp = "^[0-9]{9}$|^[0-9]{11}$", message = "Documento deve ser um CPF de 11 digitos ou RG de 9 digitos válido")
    private final String documentNumber;

    public String getDocumentNumber() {
        return documentNumber;
    }
}
