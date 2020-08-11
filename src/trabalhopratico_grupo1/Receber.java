package trabalhopratico_grupo1;

public class Receber extends Evento {
    
    private int tempo;

    public Receber(){
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