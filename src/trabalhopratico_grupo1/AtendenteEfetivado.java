package trabalhopratico_grupo1;

import java.util.ArrayList;

public class AtendenteEfetivado extends Atendente {
    
    private ArrayList<Evento> filaEventosAtendendo;
    private boolean ocupado = false;
    
    public AtendenteEfetivado() {
        filaEventosAtendendo = new ArrayList<Evento>();
    }

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
        Evento receber = new Receber();
        filaEventosAtendendo.add(receber);
        popularFila(umCliente);
        filaEventosAtendendo.add(new Despedir());
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

    private void popularFila(Cliente umCliente) {
        for (int i=0; i < umCliente.tamanhoDaFila(); i++) {
            filaEventosAtendendo.add(umCliente.acessoAfila(i));
        }
    }

     

}
