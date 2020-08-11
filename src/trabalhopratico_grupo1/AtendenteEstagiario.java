package trabalhopratico_grupo1;

import java.util.ArrayList;

public class AtendenteEstagiario extends Atendente {

    private ArrayList<Evento> filaEventosAtendendo;
    private boolean ocupado = false;
    private int delay;
    
    /**
     * Este método recebe o cliente e inicia o tratamento, isto é,
     * o atendente passa a estar ocupado,
     * pega todos os eventos do cliente (para tratá-los),
     * calcula quanto tempo que irá gastar todos os eventos,
     * adiciona o tempo de receber cliente e dispensar cliente e 
     * retorna o tempo total gasto.
     * O tempo de toda ação sofrerá o impacto do delay devido a este
     * funcionário ainda estar aprendendo a trabalhar.
     * Então para cada evento deverá ser somado o delay.
     * @param Cliente Um cliente.
     */
    //TODO
    public void atender(Cliente umCliente) {
        ocupado = true;
        cordialidades(umCliente);
        adicionarDelay();
        
    }

    /**
    * Verifica se o atendente está ocupado atendendo alguém.
    */
    public Boolean ocupado() {
        if (this.ocupado == true) {
            return true;
        } else {
            return false;
        }
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

    private void popularFila(Cliente umCliente) {
        for (int i=0; i < umCliente.tamanhoDaFila(); i++) {
            filaEventosAtendendo.add(umCliente.acessoAfila(i));
        }
    }

    private void adicionarDelay() {
        for (int i=0; i<filaEventosAtendendo.size(); i++) {
            int tempo = filaEventosAtendendo.get(i).getTempo();
            tempo = tempo + delay;
            Evento novoEvento = filaEventosAtendendo.get(i);
            novoEvento.setTempo(tempo);
            filaEventosAtendendo.set(i, novoEvento);
        }
    }

}
