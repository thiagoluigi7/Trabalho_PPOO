package trabalhopratico_grupo1;

import java.util.ArrayList;

public class AtendenteEstagiario extends Atendente {

    private ArrayList<Evento> filaEventosAtendendo;
    private boolean ocupado = false;
    private int delay;
    
    public void atender(Cliente umCliente) {
        ocupado = true;
        System.out.println("oi"); 
    }

}
