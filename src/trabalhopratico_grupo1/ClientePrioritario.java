package trabalhopratico_grupo1;

import java.util.ArrayList;
import java.util.Random;

public class ClientePrioritario extends Cliente {

    private int horaChegada;
    private ArrayList<Evento> filaEventos;

    public ClientePrioritario(int _horaChegada) {
        this.horaChegada = _horaChegada;
        filaEventos = new ArrayList<Evento>();
        geraEventos();
    }

    /**
     * Este método cria aleatoriamente o que o cliente irá fazer.
     */
    private void geraEventos() {
        try{
            Random r = new Random();
            int quantidade = ( int )( Math.random() * 10 )+1;
            for (int i = 0; i < quantidade; i++) {
                if (r.nextInt(2) == 0) {
                    filaEventos.add(new Deposito());
                } else {
                    filaEventos.add(new Saque());
                }
                
            }
        } catch (Exception e) {
            System.out.println("Erro ao gerar eventos aleatórios do cliente: " + e.getMessage());
        }
    }

    /**
     * Este método serve para acessar um evento específico
     * da lista de eventos do cliente.
     * @param int Um índice inteiro
     * @return Evento filaEventos.get(i)
     */
    public Evento acessoAfila(int i) {
        return filaEventos.get(i);
    }

    /**
     * Este método diz o tamanho da fila de eventos do cliente.
     * @return filaEventos.size()
     */
    public int tamanhoDaFila() {
        return filaEventos.size();
    }
    
    /**
     * Este método retorna a hora em que o cliente chegou.
     * @return horaChegada
     */
    public int getHoraChegada() {
        return this.horaChegada;
    }

}
