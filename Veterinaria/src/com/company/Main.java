package com.company;


import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner teclado = new Scanner(System.in);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate ld = LocalDate.parse("08/08/2016", formatter);

        AnimalDomestico thor =new AnimalDomestico(123, "cachorro ", "fila", "preto", ld, "thor");
        AnimalDomestico aranha =new AnimalDomestico(456, "gato ", "siames", "cinza", ld, "aranha");
        AnimalDomestico jerry = new AnimalDomestico(789, "porquinho da india ", "peruano", "marron", ld, "jerry");
        AnimalDomestico florisbela = new AnimalDomestico(198, "coelho ", "mini lop", "cinza", ld, "florisbella");
        AnimalDomestico cascuda = new AnimalDomestico(765, "tartaruga ", "sulcata", "verde e branca", ld, "cascuda");
        ArrayList<AnimalDomestico> animalsDomestico = new ArrayList<>();


        AnimalFazenda gruth = new AnimalFazenda(432, "cavalo ", "alazão", "marrom", ld, "gruth");
        AnimalFazenda mimosa =new AnimalFazenda(102, "vaca ", "nelori", "branca", ld, "mimosa");
        AnimalFazenda magali = new AnimalFazenda(345, "ovelha  ", "dorper", "branca", ld, "magali");
        ArrayList<AnimalFazenda> animalFazenda = new ArrayList<>();


        boolean rodando = true;

        while (rodando) {

            System.out.println("[1] Cadastrar o médico pelo CPF:");
            System.out.println("[2] Ver a lista de todos os médicos cadastrados:");
            System.out.println("[3] Sair do programa:");
            System.out.println("Digite a opção desejada: ");

            String opcao = teclado.nextLine();

            switch (opcao) {
                case "1": {
                    System.out.println("========Cadastrar médico==============================");
                    System.out.println("Informe o CPF do médico: \n");
                    String cpfMedico = teclado.nextLine();
                    Medico cadastrarMedico = new Medico(cpfMedico);
                    cadastrarMedico.recebeMedico(cadastrarMedico);
                    System.out.println("\n");
                    break;
                }
                case "2": {
                    System.out.println("========Recuperar a lista do médico==============================");
                    Medico medico = new Medico("abc");
                    medico.LerArquivoGson();
                    System.out.println("\n");
                    break;
                }
                
                case "3": {
                    rodando = false;
                    System.out.println("Programa finalizado!!!");
                    break;
                }
            }
        }

        

    }
}
