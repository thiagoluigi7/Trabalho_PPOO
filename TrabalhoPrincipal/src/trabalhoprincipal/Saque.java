package trabalhoprincipal;

import org.jfree.chart.JFreeChart;

public class Saque extends Evento {

    public Saque(int tempo) {
        super(tempo = ( int )( Math.random() * 10 )+1);
    }

}
