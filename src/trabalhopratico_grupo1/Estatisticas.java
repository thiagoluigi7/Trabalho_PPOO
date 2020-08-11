package trabalhopratico_grupo1;

import org.jfree.chart.JFreeChart;

public class Estatisticas {

    private int tempoTotal;
    private double tempoMedioAtendimento;
    private int numEventos;
    private double tempoEsperaMedia;
    private double tamanhoFilaMedia;
    private int tamanhoFilaMax;

    /**O tempo total é obtido a partir do tempo final. Uma vez que as
     * operações se iniciam no tempo 0 o momento em que elas acabam é
     * o tanto que demorou.
     */
    //TODO
    public int calcularTempoTotal() {
        return 0;
    }

    /**O tempo médio é obtido pegando o calcularTempoTotal() e dividindo 
     * pelo número de clientes que foram atendidos no total
     */
    //TODO
    public double calcularTempoMedio() {
        return 0;
    }
    //TODO
    public double calcularTempoMedioAtendimento() {
        return 0;
    }
    //TODO
    public int calcularNumEventos() {
        return 0;
    }
    //TODO
    public double calcularTempoEsperaMedia() {
        return 0;
    }
    //TODO
    public double calcularTamanhoFilaMedia() {
        return 0;
    }
    //TODO
    public int calcularTamanhoFilaMaximo() {
        return 0;
    }

    //TODO
    public void criarGrafico() {

    }

    public void escreverRelatorio() {
        AcessoDados saida = new AcessoDados();
        saida.escreverArquivo("relatório.txt");
    }

}
