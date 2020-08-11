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
    //TODO
    public void atender(Cliente umCliente) {
        ocupado = true;
        cordialidades(umCliente);
    }

    /**
     * Este método adiciona o evento Receber que é o ato do
     * atentende do banco receber o cliente em sua mesa.
     * Pega todos os eventos do cliente para tratar e
     * após pegar todos os eventos do cliente ele adiciona o evento
     * despedir que é o ato dele dispensar o cliente.
     * @param umCliente
     */
    private void cordialidades(Cliente umCliente) {
        filaEventosAtendendo.add(new Receber());
        popularFila(umCliente);
        filaEventosAtendendo.add(new Despedir());
    }

    /**
     * Verifica se o atendente está ocupado atendendo alguém.
     */
    public boolean ocupado() {
        if (this.ocupado == true) {
            return true;
        } else {
            return false;
        }
    }

    private void popularFila(Cliente umCliente) {
        for (int i=0; i < umCliente.tamanhoDaFila(); i++) {
            filaEventosAtendendo.add(umCliente.acessoAfila(i));
        }
    }

     

}
