/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufjf.dcc192.Classes;

import java.util.Date;

/**
 *
 * @author rodri
 */
public class Comentario {
    private Usuario usuario;
    private String texto;
    private Date dataCriacao;
    private Date dataAtualizacao; 
    private Item item;
    private int id;
    private Avaliacao avaliacao;

    public Comentario(Usuario usuario,String texto, Date dataCriacao, Date dataAtualizacao,Item item, int id) {
        this.usuario = usuario;
        this.texto = texto;
        this.dataCriacao = dataCriacao;
        this.dataAtualizacao = dataAtualizacao;
        this.item = item;
        this.id = id;
        this.avaliacao = new Avaliacao();
        this.avaliacao.setIdComentario(id);
    }

    public Comentario() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Avaliacao getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Avaliacao avaliacao) {
        this.avaliacao = avaliacao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Date dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
    
    
    
    
}
