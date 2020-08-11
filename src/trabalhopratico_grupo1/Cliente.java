package trabalhopratico_grupo1;

import org.jfree.chart.JFreeChart;
import java.util.ArrayList;

public abstract class Cliente {

    private int horaChegada;
    private ArrayList<Evento> filaEventos;

    public Cliente(int horaChegada) {
        this.horaChegada = horaChegada;
    }

}
