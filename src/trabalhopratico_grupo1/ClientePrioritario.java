package trabalhopratico_grupo1;

import java.util.ArrayList;
import java.util.Random;

public class ClientePrioritario extends Cliente {

    private int horaChegada;
    private ArrayList<Evento> filaEventos;

    public ClientePrioritario(int _horaChegada) {
        this.horaChegada = _horaChegada;
        geraEventos();
    }

    /**
     * Este método cria aleatoriamente o que o cliente irá fazer.
     */
    private void geraEventos() {
        Random r = new Random();
        int quantidade = ( int )( Math.random() * 10 )+1;
        for (int i = 0; i < quantidade; i++) {
            if (r.nextInt(2) == 0) {
                filaEventos.add(new Deposito());
            } else {
                filaEventos.add(new Saque());
            }
            
        }
    }

    public Evento acessoAfila(int i) {
        return filaEventos.get(i);
    }

    public int tamanhoDaFila() {
        return filaEventos.size();
    }

}
