package com.simple_payment_aot.accounts.web.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

public class CreateAccountDto {

    //Verificar mensagens de retorno
    @Pattern(regexp = "^[0-9]{9}$|^[0-9]{11}$", message = "Documento deve ser um CPF de 11 digitos ou RG de 9 digitos válido")
    private String documentNumber;

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }
}
