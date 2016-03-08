/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.prog202.aula03.model;

/**
 * Classe responsável por representar um produto.
 * @author Carlos Alberto Cipriano Korovsky <carlos.korovsky@gmail.com>
 */
public class Produto {


    
    private Integer id;
    private String nome;
    private Integer valor;

    /**
     * @return the nome
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the nome to set
     */
    public void setId(Integer id) {
        this.id = id;
    }
    
    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the valor
     */
    public Integer getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(Integer valor) {
        this.valor = valor;
    }
    
    
}
