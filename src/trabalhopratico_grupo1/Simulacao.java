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
     * A ideia é pegar um cliente pra cada atendente e tirar esses clientes 
     * da fila de clientes. Assim o atributo clientes só irá mostrar pessoas 
     * na fila.
     */
    //TODO falta terminar
    private void atendimento() {
        while (!clientes.isEmpty()) {              
            for (int j=0; j < atendentes.size(); j++) {           // Percorre os atendentes e aqueles livres atenderão
                if (atendentes.get(j).ocupado().equals(false)) {  // clientes e esses clientes que serão atendidos vão
                    atendentes.get(j).atender(clientes.get(0));   // sair da fila.
                    clientes.remove(0);                           // Atendendo o cliente 0 e sempre remover ele faz com 
                }                                                 // que sempre o primeiro da fila seja atendido e saia
            }                                                     // da fila.
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
