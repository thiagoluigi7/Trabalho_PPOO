package trabalhopratico_grupo1;

import java.util.ArrayList;

public abstract class Atendente {

    private ArrayList<Evento> filaEventosAtendendo;
    private boolean ocupado;
    public abstract void atender(Cliente umCliente);

}
