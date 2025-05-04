package com.hbank.cliente.model;

import br.com.caelum.stella.validation.CNPJValidator;
import br.com.caelum.stella.validation.InvalidStateException;
import com.hbank.cliente.util.ValidadorInscricaoEstadual;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CNPJ;

@Entity
@Table(name = "clientes_pj")
public class ClientePJ extends Cliente {

    @Column(nullable = false)
    @NotNull
    private String razaoSocial;

    @Column(nullable = false)
    @NotNull
    private String nomeFantasia;

    @Column(nullable = false)
    @NotNull
    @CNPJ
    private String cnpj;

    @Column(nullable = false)
    @NotNull
    private String inscricaoEstadual;

    @Column(nullable = false)
    @NotNull
    private String uf;

    public ClientePJ() {
    }

    public ClientePJ(String razaoSocial, String nomeFantasia, String cnpj, String inscricaoEstadual) {
        super();
        this.razaoSocial = razaoSocial;
        this.nomeFantasia = nomeFantasia;

        validarCNPJ(cnpj);
        this.cnpj = cnpj;

        validarIE(inscricaoEstadual, uf);
        this.inscricaoEstadual = inscricaoEstadual;
    }

    private void validarCNPJ(String cnpj) {
        if (!new CNPJValidator().invalidMessagesFor(cnpj).isEmpty()) {
            throw new IllegalArgumentException("CNPJ inválido");
        }
    }

    private void validarIE(String ie, String estado) {
        try {
            ValidadorInscricaoEstadual.validarIE(ie, estado);
        } catch (InvalidStateException e) {
            throw new IllegalArgumentException("Inscrição Estadual inválida para o estado " + estado);
        }
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    @Override
    public String toString() {
        return "\nClientePJ {" +
                "\n   id: " + getId() +
                "\n   codigoCliente: " + getCodigoCliente() +
                "\n   email: " + getEmail() +
                "\n   senha: " + getSenha() +
                "\n   telefone: " + getTelefone() +
                "\n   endereco: " + getEndereco() +
                "\n   statusCliente: " + getStatusCliente() +
                "\n   dataCadastro: " + getDataCadastro() +
                "\n   ultimoAcesso: " + getUltimoAcesso() +
                "\n   razaoSocial: " + razaoSocial +
                "\n   nomeFantasia: " + nomeFantasia +
                "\n   cnpj: " + cnpj +
                "\n   inscricaoEstadual: " + inscricaoEstadual +
                "\n   uf: " + uf +
                "\n}";
    }
}
