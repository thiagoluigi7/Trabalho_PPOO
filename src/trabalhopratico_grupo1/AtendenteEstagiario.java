package trabalhopratico_grupo1;

import java.util.ArrayList;

public class AtendenteEstagiario extends Atendente {

    private ArrayList<Evento> filaEventosAtendendo;
    private boolean ocupado;
    private int delay;
    private int horaLivre;
    
    public AtendenteEstagiario() {
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
     * O tempo de toda ação sofrerá o impacto do delay devido a este
     * funcionário ainda estar aprendendo a trabalhar.
     * Então para cada evento deverá ser somado o delay.
     * @param Cliente Um cliente.
     */
    //TODO
    public void atender(Cliente umCliente) {
        try {
            ocupado = true;
            cordialidades(umCliente);
            adicionarDelay();
            atualizaHoraLivre();
        } catch (Exception e) {
            System.out.println("Erro ao atender o cliente: " + e.getMessage());
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
        try {
            Evento receber = new Receber();
            filaEventosAtendendo.add(receber);
            popularFila(umCliente);
            filaEventosAtendendo.add(new Despedir());
        } catch (Exception e) {
            System.out.println("Erro ao realizar as cordialidades: " + e.getMessage());
        }
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
        try {
            for (int i=0; i<filaEventosAtendendo.size(); i++) {
                horaLivre = horaLivre + filaEventosAtendendo.get(i).getTempo();
            }
        } catch (Exception e) {
            System.out.println("Erro ao atualizar a hora que o atendente estará livre: " + e.getMessage());
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
        try{
            for (int i=0; i < umCliente.tamanhoDaFila(); i++) {
                filaEventosAtendendo.add(umCliente.acessoAfila(i));
            }
        } catch (Exception e) {
            System.out.println("Erro ao popular a fila de eventos do atendente: " + e.getMessage());
        }
    }

    /**
     * Este método adiciona um delay nas operações realizadas pelo 
     * atendente estagiário. Pois como é estagiário ele leva mais
     * tempo para realizar as tarefas do que um atendente efetivado.
     */
    private void adicionarDelay() {
        try{
            for (int i=0; i<filaEventosAtendendo.size(); i++) {
                int tempo = filaEventosAtendendo.get(i).getTempo();
                tempo = tempo + delay;
                Evento novoEvento = filaEventosAtendendo.get(i);
                novoEvento.setTempo(tempo);
                filaEventosAtendendo.set(i, novoEvento);
            }
        catch (Exception e) {
            System.out.println("Erro ao adicionar o delay oriundo da falta de experiência do atendente: " + e.getMessage());
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
