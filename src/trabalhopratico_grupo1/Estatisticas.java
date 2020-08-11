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
        return 0;
    }

    //TODO
    public int calcularNumEventos() {
        return 0;
    }

    /**
     * Este método retorna o tempo médio que se gasta atendento 
     * um cliente. O tempo médio é obtido pegando o calcularTempoTotal() 
     * e dividindo pelo número de clientes que foram atendidos no total.
     * @return tempoMedioAtendimento
     */
    //TODO
    public double calcularTempoMedioEsperaNaFila() {
        return 0;
    }
    
    /**
     * 
     * @return
     */
    //TODO
    public double calcularTamanhoMedioFilaAtendimento() {
        return 0;
    }

    //TODO
    public double calcularTamanhoFilaMax() {
        return 0;
    }
    //TODO
    public double calcularTempoMedioAtendimento() {
        return 0;
    }

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
