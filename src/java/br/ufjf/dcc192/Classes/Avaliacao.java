package br.ufjf.dcc192.Classes;

public class Avaliacao {
    private int like;
    private int dislike;
    private int id;
    private int idUsuario;
    private int idItem;
    private int idComentario;
    public Avaliacao() {
    }

    public Avaliacao(int like, int dislike, int id, int idUsuario, int idItem, int idComentario) {
        this.like = like;
        this.dislike = dislike;
        this.id = id;
        this.idUsuario = idUsuario;
        this.idItem = idItem;
        this.idComentario = idComentario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public int getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(int idComentario) {
        this.idComentario = idComentario;
    }

    public int getLike() { 
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public int getDislike() {
        return dislike;
    }

    public void setDislike(int dislike) {
        this.dislike = dislike;
    }
    
    
}
