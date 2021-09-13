package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import lombok.Data;

@Data
public class Medico {
    private String cpfMedico;
    private String nomeMedico;
    private String sobrenomeMedico;
    private String numeroRegistro;
    private String especielidade;

    public Medico(String cpfMedico, String nomeMedico, String sobrenomeMedico, String numeroRegistro, String especielidade) {
        this.cpfMedico = cpfMedico;
        this.nomeMedico = nomeMedico;
        this.sobrenomeMedico = sobrenomeMedico;
        this.numeroRegistro = numeroRegistro;
        this.especielidade = especielidade;
    }

    public Medico(String cpfMedico) {
        this.cpfMedico = cpfMedico;
    }

    public void recebeMedico(Medico medico){
        Gson gson = new Gson();



        List<Medico> lista =  LerArquivoGson();
        lista.add(medico);
        // converte objetos Java para JSON e retorna JSON como String
        String json;
        if (lista.size()==0) {
            json = gson.toJson(medico);
        } else {
            json = gson.toJson(lista);
        }

        try {
            //Escreve Json convertido em arquivo chamado "file.json"
            FileWriter writer = new FileWriter("C:\\file.json");
            writer.write(json);
            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public List<Medico> LerArquivoGson(){


        Gson gson = new Gson();

        try {

            BufferedReader br = new BufferedReader(new FileReader("c:\\file.json"));

            //Converte String JSON para objeto Java

            Type collectionType = new TypeToken<Collection<Medico>>(){}.getType();
            Collection<Medico> listaMedico = gson.fromJson(br, collectionType);
            System.out.println(listaMedico);
            return (List<Medico>) listaMedico;


        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }



    @Override
    public String toString() {
        return cpfMedico + " " + nomeMedico + " " + sobrenomeMedico + " " + numeroRegistro + " " + especielidade;
    }
}

