package com.company;

import lombok.Data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
public class Consulta {
    private Medico medico;
    private String dataHora;
    private String motivo;
    private String diagnostico;
    private String tratamento;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    LocalDate ld = LocalDate.parse("08/08/2016", formatter);

    public Consulta(String dataHora, String motivo, String diagnostico, String tratamento, Medico medico) {
        this.dataHora = dataHora;
        this.motivo = motivo;
        this.diagnostico = diagnostico;
        this.tratamento = tratamento;
        this.medico = medico;
    }

    @Override
    public String toString() {
        return  dataHora + " " + motivo + " " + diagnostico + " " + tratamento;
    }
}
