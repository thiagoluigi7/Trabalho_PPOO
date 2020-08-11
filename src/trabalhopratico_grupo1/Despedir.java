package trabalhopratico_grupo1;

public class Despedir extends Evento {
    
    private int tempo;

    public Despedir(){
        setTempoInicial();
    }

    private void setTempoInicial() {
        this.tempo = ( int )( Math.random() * 5 )+1;
    }
    
    public int getTempo() {
        return this.tempo;
    }
    
    public void setTempo(int _tempo) {
        this.tempo = _tempo;
    }

}
