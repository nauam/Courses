package model;

import java.util.Date;

public abstract class Alvo {

    private Date tempo;

    public Alvo(Date tempo) {
        this.tempo = tempo;
    }

    public Date getTempo() {
        return tempo;
    }

    public void setTempo(Date tempo) {
        this.tempo = tempo;
    }
}
