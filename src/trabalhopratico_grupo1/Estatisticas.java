package trabalhopratico_grupo1;

import java.util.ArrayList;
import org.jfree.chart.JFreeChart;

public class Estatisticas {

    private int tempoTotal;
    private int numEventos;
    private int tempoMedioEsperaNaFila;
    private int tamanhoMedioFilaAtendimento;
    private int tamanhoFilaMax;
    private int tempoMedioAtendimento;
    private int tempoMedioAtendimentoClientePrioritario;
    private int tempoMedioAtendimentoClienteNormal;
    
    public Estatisticas() {
        this.tempoTotal = 0;
        this.numEventos = 0;
        this.tempoMedioEsperaNaFila = 0;
        this.tamanhoMedioFilaAtendimento = 0;
        this.tamanhoFilaMax = 0;
        this.tempoMedioAtendimento = 0;
        this.tempoMedioAtendimentoClientePrioritario = 0;
        this.tempoMedioAtendimentoClienteNormal = 0;
    }

    /**
     * Este método retornará o tempo total gasto na simulção. Lembrando
     * sempre que se trata de tempo simulado e não real. O tempo total 
     * é obtido a partir do tempo final. Uma vez que as operações se 
     * iniciam no tempo 0 o momento em que elas acabam é o tanto que demorou.
     * @param int
     * @return tempoTotal 
     */
    public int calcularTempoTotal(int tempoAtual) {
        tempoTotal = tempoAtual;
        return tempoTotal;
    }

    /**
     * Este método calcular quantos eventos foram tratados no total por 
     * todos os atendentes.
     * @param ArrayList<Evento>
     * @return numEventos
     */
    public int calcularNumEventos(ArrayList<Evento> _eventos) {
        this.numEventos = _eventos.size();
        return numEventos;
    }

    /**
     * Este método retorna o tempo médio que se gasta esperando na fila.
     * @param int
     * @return tempoMedioEsperaNaFila
     */
    public int calcularTempoMedioEsperaNaFila(int tempoDeEsperaTotal, int numMaxClientes) {
        tempoMedioAtendimento = tempoDeEsperaTotal/numMaxClientes;
        //return tempoMedioAtendimento;
        return tempoMedioEsperaNaFila;
    }
    
    /**
     * Este método calcula o tamanho médio que a fila de atendimento 
     * costuma ter.
     * @param int
     * @return tamanhoMedioFilaAtendimento
     */
    public int calcularTamanhoMedioFilaAtendimento(int contadorFilaEsperaVazia, int tamFilaDeEspera) {
        if(contadorFilaEsperaVazia > 0) {
            tamanhoMedioFilaAtendimento = tamFilaDeEspera/contadorFilaEsperaVazia;
            return tamanhoMedioFilaAtendimento;
        } else {
            return tamFilaDeEspera;
        }
    }

    /**
     * Este método calcula o tamanho máximo que a fila de clientes chegou.
     * Uma vez que todos os clientes são adicionados na fila no início da
     * simulação esse valor pode ser obtido através do tamanho do vetor 
     * clientes antes de acontecer o primeiro atendimento.
     * @param int
     * @return tamanhoFilaMax
     */
    public int calcularTamanhoFilaMax(int _numClientes) {
        this.tamanhoFilaMax = _numClientes;
        return tamanhoFilaMax;
    }

    /**
     * Este método calcula quanto tempo demora cada atendimento do cliente normal.
     * @param int
     * @return tempoMedioAtendimento
     */
    public int calcularTempoMedioAtendimentoClienteNormal(int tempoDeEsperaClienteNormal, int contadorFilaClienteN) {
        if(contadorFilaClienteN>0){
            tempoMedioAtendimentoClienteNormal = tempoDeEsperaClienteNormal/contadorFilaClienteN;
            return tempoMedioAtendimentoClienteNormal;
        }else{
            return 0;
        }
    }

    /**
     * Este método calcula quanto tempo demora cada atendimento em média.
     * @param int 
     * @return tempoMedioAtendimentoClientePrioritario
     */
    public int calcularTempoMedioAtendimentoClientePrioritario(int tempoDeEsperaClientePrioritario, int contadorFilaClienteP) {
        if(contadorFilaClienteP>0) {
            tempoMedioAtendimentoClientePrioritario = tempoDeEsperaClientePrioritario/contadorFilaClienteP;
            return tempoMedioAtendimentoClientePrioritario;
        }else{
            return 0;
        }
        
    }
    
    /**
     * Este método criará uma janela com um gráfico nela.
     */
    //TODO
    public void criarGrafico() {

    }

    public int getTempoTotal() {
        return tempoTotal;
    }

    public int getNumEventos() {
        return numEventos;
    }

    public int getTempoMedioEsperaNaFila() {
        return tempoMedioEsperaNaFila;
    }

    public int getTamanhoMedioFilaAtendimento() {
        return tamanhoMedioFilaAtendimento;
    }

    public int getTamanhoFilaMax() {
        return tamanhoFilaMax;
    }

    public int getTempoMedioAtendimento() {
        return tempoMedioAtendimento;
    }

    /**
     * Este método irá criar um arquivo txt com o nome
     * relatório e vai escrever neste arquivo todos os 
     * cálculos realizados pela classe Estatisticas. 
     * Além disto irá criar uma janela com um gráfico.
     */
    public void escreverRelatorio() {
        try {
            AcessoDados saida = new AcessoDados();
            saida.escreverArquivo("relatório.txt", tempoTotal, numEventos, tempoMedioEsperaNaFila, tamanhoMedioFilaAtendimento, tamanhoFilaMax, tempoMedioAtendimentoClienteNormal, tempoMedioAtendimentoClientePrioritario, tempoMedioAtendimento);
        } catch (Exception e) {
            System.out.println("Erro ao escrever arquivo txt relatório: " + e.getMessage());
        }
    }

}
