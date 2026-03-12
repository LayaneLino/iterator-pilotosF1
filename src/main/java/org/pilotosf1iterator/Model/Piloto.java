package org.pilotosf1iterator.Model;

public class Piloto implements Comparable<Piloto> {
    private final int matricula;
    private final String nome;
    private final String pais;
    private final int idade;
    private final String equipe;
    private final String motor;
    private final int pontos;

    public Piloto(int matricula, String nome, String pais, int idade, String equipe, String motor, int pontos) {
        this.matricula = matricula;
        this.nome = nome;
        this.pais = pais;
        this.idade = idade;
        this.equipe = equipe;
        this.motor = motor;
        this.pontos = pontos;
    }

    public Piloto(String linha) {
        String[] dados = linha.split(",");
        this.matricula = Integer.parseInt(dados[0].trim());
        this.nome = dados[1].trim();
        this.pais = dados[2].trim();
        this.idade = Integer.parseInt(dados[3].trim());
        this.equipe = dados[4].trim();
        this.motor = dados[5].trim();
        this.pontos = Integer.parseInt(dados[6].trim());
    }

    @Override
    public int compareTo(Piloto outro) {
        return this.nome.compareTo(outro.getNome());
    }

    public String getNome() {
        return nome;
    }

    public int getMatricula(){
        return matricula;
    }

    public String getPais() {
        return pais;
    }

    public int getIdade() {
        return idade;
    }

    public String getEquipe() {
        return equipe;
    }

    public String getMotor() {
        return motor;
    }

    public int getPontos() {
        return pontos;
    }


}
