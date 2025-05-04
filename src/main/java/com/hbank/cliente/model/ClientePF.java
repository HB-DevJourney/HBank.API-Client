package com.hbank.cliente.model;

import br.com.caelum.stella.validation.CNPJValidator;
import br.com.caelum.stella.validation.CPFValidator;
import com.hbank.cliente.model.enums.StatusCliente;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDateTime;

@Entity
@Table(name = "clientes_pf")
public class ClientePF extends Cliente {

    @Column(nullable = false)
    @NotNull
    private String nome;

    @Column(nullable = false)
    @NotNull
    private String sobrenome;

    @Column(nullable = false, unique = true)
    @CPF
    @NotNull
    private String cpf;

    @Column(nullable = false)
    @NotNull
    private Character sexo;

    @Column(name = "data_nascimento", nullable = false)
    @NotNull
    private LocalDateTime dataNascimento;

    @Column(nullable = false)
    @NotNull
    private String nacionalidade;

    public ClientePF() {
    }

    public ClientePF(String nome, String sobrenome, String cpf, Character sexo,
                     LocalDateTime dataNascimento, String nacionalidade) {
        super();
        this.nome = nome;
        this.sobrenome = sobrenome;

        validarCPF(cpf);
        this.cpf = cpf;

        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
        this.nacionalidade = nacionalidade;
    }

    private void validarCPF(String cpf) {
        if (!new CPFValidator().invalidMessagesFor(cpf).isEmpty()) {
            throw new IllegalArgumentException("CPF inválido");
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    public LocalDateTime getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDateTime dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    @Override
    public String toString() {
        return "\nClientePF {" +
                "\n   id: " + getId() +
                "\n   codigoCliente: " + getCodigoCliente() +
                "\n   email: " + getEmail() +
                "\n   senha: " + getSenha() +
                "\n   telefone: " + getTelefone() +
                "\n   endereco: " + getEndereco() +
                "\n   statusCliente: " + getStatusCliente() +
                "\n   dataCadastro: " + getDataCadastro() +
                "\n   ultimoAcesso: " + getUltimoAcesso() +
                "\n   nome: " + nome +
                "\n   sobrenome: " + sobrenome +
                "\n   cpf: " + cpf +
                "\n   sexo: " + sexo +
                "\n   dataNascimento: " + dataNascimento +
                "\n   nacionalidade: " + nacionalidade +
                "\n}";
    }
}
