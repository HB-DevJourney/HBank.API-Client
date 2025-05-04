package com.hbank.cliente.util;

import br.com.caelum.stella.validation.InvalidStateException;
import br.com.caelum.stella.validation.Validator;
import br.com.caelum.stella.validation.ie.*;

import java.util.Map;

public class ValidadorInscricaoEstadual {

    public static void validarIE(String ie, String uf) {
        Validator<String> validador = VALIDADORES.get(uf.toUpperCase());

        if (validador == null) {
            throw new IllegalArgumentException("UF não suportada: " + uf);
        }

        try {
            validador.assertValid(ie);
        } catch (InvalidStateException e) {
        }
    }

    private static final Map<String, Validator<String>> VALIDADORES = Map.ofEntries(
            Map.entry("AC", new IEAcreValidator(false)),
            Map.entry("AL", new IEAlagoasValidator(false)),
            Map.entry("AM", new IEAmazonasValidator(false)),
            Map.entry("AP", new IEAmapaValidator(false)),
            Map.entry("BA", new IEBahiaValidator(false)),
            Map.entry("CE", new IECearaValidator(false)),
            Map.entry("DF", new IEDistritoFederalValidator(false)),
            Map.entry("ES", new IEEspiritoSantoValidator(false)),
            Map.entry("GO", new IEGoiasValidator(false)),
            Map.entry("MA", new IEMaranhaoValidator(false)),
            Map.entry("MG", new IEMinasGeraisValidator(false)),
            Map.entry("MS", new IEMatoGrossoDoSulValidator(false)),
            Map.entry("MT", new IEMatoGrossoValidator(false)),
            Map.entry("PA", new IEParaValidator(false)),
            Map.entry("PB", new IEParaibaValidator(false)),
            Map.entry("PE", new IEPernambucoValidator(false)),
            Map.entry("PI", new IEPiauiValidator(false)),
            Map.entry("PR", new IEParanaValidator(false)),
            Map.entry("RJ", new IERioDeJaneiroValidator(false)),
            Map.entry("RN", new IERioGrandeDoNorteValidator(false)),
            Map.entry("RO", new IERondoniaValidator(false)),
            Map.entry("RR", new IERoraimaValidator(false)),
            Map.entry("RS", new IERioGrandeDoSulValidator(false)),
            Map.entry("SC", new IESantaCatarinaValidator(false)),
            Map.entry("SE", new IESergipeValidator(false)),
            Map.entry("SP", new IESaoPauloValidator(false)),
            Map.entry("TO", new IETocantinsValidator(false))
    );

}
