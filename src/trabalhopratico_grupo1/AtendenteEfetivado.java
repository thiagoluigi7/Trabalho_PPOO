package trabalhopratico_grupo1;

import java.util.ArrayList;

public class AtendenteEfetivado extends Atendente {
    
    private ArrayList<Evento> filaEventosAtendendo;
    private boolean ocupado = false;


    /**
     * Este método recebe o cliente e inicia o tratamento, isto é,
     * o atendente passa a estar ocupado,
     * pega todos os eventos do cliente (para tratá-los),
     * calcula quanto tempo que irá gastar todos os eventos,
     * adiciona o tempo de receber cliente e dispensar cliente e 
     * retorna o tempo total gasto.
     * @param Cliente Um cliente.
     */
    public void atender(Cliente umCliente) {
        ocupado = true;
        System.out.println("oi"); 
    }

}
