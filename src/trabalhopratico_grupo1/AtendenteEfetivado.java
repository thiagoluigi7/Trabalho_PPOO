package trabalhopratico_grupo1;

import java.util.ArrayList;

public class AtendenteEfetivado extends Atendente {
    
    private ArrayList<Evento> filaEventosAtendendo;
    private boolean ocupado;
    private int horaLivre;

    public AtendenteEfetivado () {
        this.ocupado = false;
        filaEventosAtendendo = new ArrayList<Evento>();
        this.horaLivre = 0;
    }

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
        atualizaHoraLivre();
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
     * Retorna a fila de eventos que o atendente está trabalhando
     * para adicionar na fila de eventos que a simulação tratou.
     * É usado nas estatísticas e para "histórico".
     * @return ArrayList<Evento> filaEventosAtendendo
     */
    public ArrayList<Evento> registraEventos() {
        return filaEventosAtendendo;
    }

    /**
     * Este método atualiza a hora em que o atendente estará
     * livre com base no tempo que será gasto para resolver
     * todos os problemas.
     */
    private void atualizaHoraLivre() {
        for (int i=0; i<filaEventosAtendendo.size(); i++) {
            horaLivre = horaLivre + filaEventosAtendendo.get(i).getTempo();
        }
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
     * Libera o atendente após terminar com um cliente.
     */
    public void desocupar() {
        this.ocupado = false;
    }

    /**
     * Este método popula a fila de eventos do atendente com
     * os eventos que o cliente irá fazer.
     * @param umCliente
     */
    private void popularFila(Cliente umCliente) {
        for (int i=0; i < umCliente.tamanhoDaFila(); i++) {
            filaEventosAtendendo.add(umCliente.acessoAfila(i));
        }
    }

    /**
     * Este método retorna a hora em que o atendente estará livre
     * para atender outro cliente.
     * @return horaLivre
     */
    public int getHoraLivre() {
        return this.horaLivre;
    }

}
