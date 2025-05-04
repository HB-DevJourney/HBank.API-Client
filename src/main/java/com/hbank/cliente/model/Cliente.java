package com.hbank.cliente.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hbank.cliente.model.enums.StatusCliente;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.concurrent.ThreadLocalRandom;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "clientes")
public abstract class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "codigo_cliente", unique = true, nullable = false, updatable = false)
    private Long codigoCliente;

    @Column(nullable = false)
    @Email
    @NotNull
    private String email;

    @Column(nullable = false)
    @NotNull
    private String senha;

    @Column(nullable = false)
    @NotNull
    private String telefone;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    @NotNull
    private Endereco endereco;

    @Enumerated(EnumType.STRING)
    private StatusCliente statusCliente;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dataCadastro;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime ultimoAcesso;

    @PrePersist
    public void prePersist() {
        this.dataCadastro = LocalDateTime.now();
        this.statusCliente = StatusCliente.ATIVO;
        if (this.codigoCliente == null) {
            this.codigoCliente = gerarCodigoClienteUnico();
        }
    }

    public static Long gerarCodigoClienteUnico() {
        return ThreadLocalRandom.current().nextLong(1_000_000_000L, 1_999_999_999L);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(Long codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public StatusCliente getStatusCliente() {
        return statusCliente;
    }

    public void setStatusCliente(StatusCliente statusCliente) {
        this.statusCliente = statusCliente;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public LocalDateTime getUltimoAcesso() {
        return ultimoAcesso;
    }

    public void setUltimoAcesso(LocalDateTime ultimoAcesso) {
        this.ultimoAcesso = ultimoAcesso;
    }

}


