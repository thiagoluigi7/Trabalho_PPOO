package trabalhopratico_grupo1;

import org.jfree.chart.JFreeChart;

public abstract class Evento {

    private int tempo;
    /*
    public Evento(){
        
    }
    */
    
    public Evento(int tempo) {
        this.tempo = ( int )( Math.random() * 5 )+1;
    }
    
    
    public int getTempo() {
        return this.tempo;
    }


}
