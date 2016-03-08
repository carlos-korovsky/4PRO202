/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.prog202.aula03.controller;

import br.udesc.prog202.aula03.model.Produto;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável por manipular uma lista de produtos
 * @author Carlos Alberto Cipriano Korovsky <carlos.korovsky@gmail.com>
 */
public class Produtos {
    
    /*
     * Cria uma variável privada e final para armazenar a lista de produtos
     * pré cadastrados.
     */
    private final List<Produto> produtos;
    
    public Produtos() {
        this.produtos = new ArrayList(); //Cria uma lista de produtos vazia
        initProdutos();
    }
    
    /**
     * Inicializa a lista de produtos pré cadastrados
     */
    private void initProdutos() {       
        Produto produto = new Produto();
        produto.setNome("Produto 1");
        produto.setValor(10);
        this.addProduto(produto);
        
        produto = new Produto();
        produto.setNome("Produto 2");
        produto.setValor(15);
        this.addProduto(produto);
        
        produto = new Produto();
        produto.setNome("Produto 3");
        produto.setValor(30);
        this.addProduto(produto);
    }
    
    /**
     * Retorna a lista de todos os produtos cadastrados
     * @return Lista de produtos cadastrados
     */
    public List<Produto> getAllProdutos() {
        return this.produtos;
    }
    
    /**
     * Adiciona um novo produto a lista
     * @param produto 
     */
    public void addProduto(Produto produto) {
        this.produtos.add(produto);
        /*
         * Configura o identificador único do produto pela posição que ele 
         * foi adicionado na lista
         */
        produto.setId(this.produtos.indexOf(produto));
    }
}
