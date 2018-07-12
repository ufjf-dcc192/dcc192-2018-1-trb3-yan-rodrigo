package br.ufjf.dcc192.Classes;

public class Avaliacao {
    private int like;
    private int dislike;

    public Avaliacao(int like, int dislike) {
        this.like = like;
        this.dislike = dislike;
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
