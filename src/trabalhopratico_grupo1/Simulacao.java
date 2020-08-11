package trabalhopratico_grupo1;

import java.util.ArrayList;

public class Simulacao {

    private int tempoAtual;
    private static ArrayList<Cliente> clientes;
    private static ArrayList<Atendente> atendentes;  

    /**
     * Este método inicia a simulação como uma main.
     * Ele irá definir o tempo em que o banco inicia
     * (tempo em que a simulação começa), irá contratar
     * os funcionários e receber os clientes (ambos a 
     * partir do arquivo de entrada), irá iniciar o 
     * atendimento que é o laço principal do programa e
     * depois irá gerar os relatórios.
     */
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
    
    /**
     * Adiciona um cliente na fila de clientes do banco.
     * Método utilizado durante a leitura do arquivo.
     * @param cliente
     */
    public static void inserirCliente(Cliente cliente){
        clientes.add(cliente);
    }

    /**
     * Adiciona um atendente no banco. Método utilizado 
     * durante a leitura do arquivo.
     * @param atendente
     */
    public static void inserirAtendente(Atendente atendente){
        atendentes.add(atendente);
    }

    /**
     * Este método retorna o tempo atual para se saber quanto
     * tempo já se passou desde a abertura do banco.
     * @return Simulação.tempoAtual
     */
    public int getTempoAtual() {
        return this.tempoAtual;
    }

    /**
     * Este método lê o arquivo de entrada. Dele é retirado
     * quantos funcionários o banco tem, qual sua categoria,
     * mais os clientes e suas respectivas horas de entrada no 
     * banco. Os funcionários são então colocados no ArrayList
     * atendentes e o mesmo ocorre com os clientes que são 
     * colocados no ArrayList clientes.
     */
    private void recebeClientes() {
        AcessoDados acesso = new AcessoDados();
        acesso.lerArquivo("dadosEntrada.txt");
    }

    /**
     * Laço principal, executa enquanto ainda tem clientes na fila do banco.
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

    /**
     * Este método irá gerar o relatório com suas estatísticas
     * e irá criar uma janela com o gráfico.
     */
    //TODO
    public void gerarRelatorio() {
        Estatisticas relatorio = new Estatisticas();
        relatorio.calcularTempoTotal();
        relatorio.calcularNumEventos();
        relatorio.calcularTempoMedioEsperaNaFila();
        relatorio.calcularTamanhoMedioFilaAtendimento();
        relatorio.calcularTamanhoFilaMax();
        relatorio.calcularTempoMedioAtendimento();
        relatorio.criarGrafico();
    }

}
