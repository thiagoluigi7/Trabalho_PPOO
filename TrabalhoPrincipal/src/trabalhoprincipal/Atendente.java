package trabalhoprincipal;

import org.jfree.chart.JFreeChart;
import java.util.ArrayList;

public abstract class Atendente {

    private ArrayList<Evento> filaEventosAtendendo;
    private boolean ocupado;
    public abstract void atender(Cliente umCliente);

}
