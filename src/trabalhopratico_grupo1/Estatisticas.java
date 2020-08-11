package trabalhopratico_grupo1;

import org.jfree.chart.JFreeChart;

public class Estatisticas {

    private int tempoTotal;
    private int numEventos;
    private double tempoMedioEsperaNaFila;
    private double tamanhoMedioFilaAtendimento;
    private int tamanhoFilaMax;
    private double tempoMedioAtendimento;
    

    /**
     * Este método retornará o tempo total gasto na simulção. Lembrando
     * sempre que se trata de tempo simulado e não real. O tempo total 
     * é obtido a partir do tempo final. Uma vez que as operações se 
     * iniciam no tempo 0 o momento em que elas acabam é o tanto que demorou.
     * @return tempoTotal 
     */
    //TODO
    public int calcularTempoTotal() {
        return tempoTotal;
    }

    /**
     * Este método calcular quantos eventos foram tratados no total por 
     * todos os atendentes.
     * @return numEventos
     */
    //TODO
    public int calcularNumEventos() {
        return numEventos;
    }

    /**
     * Este método retorna o tempo médio que se gasta esperando na fila.
     * 
     * @return tempoMedioEsperaNaFila
     */
    //TODO
    public double calcularTempoMedioEsperaNaFila() {
        return tempoMedioEsperaNaFila;
    }
    
    /**
     * Este método calcula o tamanho médio que a fila de atendimento 
     * costuma ter.
     * @return tamanhoMedioFilaAtendimento
     */
    //TODO
    public double calcularTamanhoMedioFilaAtendimento() {
        return tamanhoMedioFilaAtendimento;
    }

    /**
     * Este método calcula o tamanho máximo que a fila de clientes chegou.
     * Uma vez que todos os clientes são adicionados na fila no início da
     * simulação esse valor pode ser obtido através do tamanho do vetor 
     * clientes antes de acontecer o primeiro atendimento.
     * @return tamanhoFilaMax
     */
    //TODO
    public double calcularTamanhoFilaMax() {
        return tamanhoFilaMax;
    }

    /**
     * Este método calcula quanto tempo demora cada atendimento em média.
     * @return tempoMedioAtendimento
     */
    //TODO
    public double calcularTempoMedioAtendimento() {
        return tempoMedioAtendimento;
    }

    /**
     * Este método criará uma janela com um gráfico nela.
     */
    //TODO
    public void criarGrafico() {

    }

    /**
     * Este método irá criar um arquivo txt com o nome
     * relatório e vai escrever neste arquivo todos os 
     * cálculos realizados pela classe Estatisticas. 
     * Além disto irá criar uma janela com um gráfico.
     */
    public void escreverRelatorio() {
        AcessoDados saida = new AcessoDados();
        saida.escreverArquivo("relatório.txt");
    }

}
