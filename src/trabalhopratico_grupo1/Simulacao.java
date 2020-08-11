package trabalhopratico_grupo1;

import java.util.ArrayList;

public class Simulacao {

    private int tempoAtual;
    private static ArrayList<Cliente> clientes;
    private ArrayList<Atendente> atendentes;  

    public void simularAgencia() {
        //Abre a agencia
        tempoAtual = 0;
        //Recebe os clientes
        recebeClientes();
        //Começa o atendimento
        atendimento();
        //Ao fim do dia o relatório é gerado
        gerarRelatorio();
    }
    
    public static void inserirCliente(Cliente cliente){
        clientes.add(cliente);
    }
    
    public int getTempoAtual() {
        return this.tempoAtual;
    }

    private void recebeClientes() {
        AcessoDados acesso = new AcessoDados();
        acesso.lerArquivo("dadosEntrada.txt");
    }

    /**Laço principal, executa enquanto ainda tem clientes na fila do banco.
     * O primeiro for simula os clientes na fila. O primeiro cliente da uma passo
     * a frente e procura um atendente livre. Então quando ele encontra ele dá um passo
     * a frente e começa o atendimento.
     */
    //TODO falta terminar
    private void atendimento() {
        while (!clientes.isEmpty()) {
            for (int i=0; i < clientes.size(); i++) {                //O primeiro cliente da fila 
                for (int j=0; j < atendentes.size(); j++) {          //procura um atendente que 
                    if (atendentes.get(j).ocupado().equals(false)) { //não está ocupado
                        atendentes.get(j).atender(clientes.get(i));  //e é então atendido
                    }
                }
            }
        }
    }

    /**Este método irá gerar o relatório com suas estatísticas
     * e o gráfico.
     */
    //TODO
    public gerarRelatorio() {
        Estatisticas relatorio = new Estatisticas();
        calcularTempoTotal();
        calcularTempoMedio();
        calcularTempoMedioAtendimento();
        calcularNumEventos();
        calcularTempoEsperaMedia();
        calcularTamanhoFilaMedia();
        calcularTamanhoFilaMaximo();
    }

    /**O tempo total é obtido a partir do tempo final. Uma vez que as
     * operações se iniciam no tempo 0 o momento em que elas acabam é
     * o tanto que demorou.
     */
    //TODO
    private int calcularTempoTotal() {
        return 0;
    }

    /**O tempo médio é obtido pegando o calcularTempoTotal() e dividindo 
     * pelo número de clientes que foram atendidos no total
     */
    //TODO
    private double calcularTempoMedio() {
        return 0;
    }
    //TODO
    private double calcularTempoMedioAtendimento() {
        return 0;
    }
    //TODO
    private int calcularNumEventos() {
        return 0;
    }
    //TODO
    private double calcularTempoEsperaMedia() {
        return 0;
    }
    //TODO
    private double calcularTamanhoFilaMedia() {
        return 0;
    }
    //TODO
    private int calcularTamanhoFilaMaximo() {
        return 0;
    }


}
