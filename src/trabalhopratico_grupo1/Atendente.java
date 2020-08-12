package trabalhopratico_grupo1;

import java.util.ArrayList;

public abstract class Atendente {

    public abstract void atender(Cliente umCliente);
    public abstract ArrayList<Evento> registraEventos();
    public abstract Boolean ocupado();
    public abstract void desocupar();


}
