package trabalhopratico_grupo1;

import java.util.ArrayList;

public class Simulacao {

    private int tempoAtual;
    private int numMaxClientes;
    private ArrayList<Evento> eventos;
    private ArrayList<Cliente> clientes;
    private ArrayList<Atendente> atendentes;  

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
        //Recebe todos os dados do arquivo
        recebeDados();
        //Começa o atendimento
        atendimento(); //ERRO
        //Ao fim do dia o relatório é gerado
        gerarRelatorio();
    }

    /**
     * Este método retorna o tempo atual para se saber quanto
     * tempo já se passou desde a abertura do banco.
     * @return Simulação.tempoAtual
     */
    public int getTempoAtual() {
        return this.tempoAtual;
    }

    public void setTempoAtual(int _tempo) {
        this.tempoAtual = tempoAtual + _tempo;
    }

    public int getNumMaxClientes() {
        return this.numMaxClientes;
    }

    public void setNumMaxClientes(int _num) {
        this.numMaxClientes = _num;
    }

    public ArrayList<Cliente> getClientes() {
        return this.clientes;
    }

    public ArrayList<Atendente> getAtendentes() {
        return this.atendentes;
    }

    public ArrayList<Evento> getEventos() {
        return this.eventos;
    }



    /**
     * Este método lê o arquivo de entrada. Dele é retirado
     * quantos funcionários o banco tem, qual sua categoria,
     * mais os clientes e suas respectivas horas de entrada no 
     * banco. Os funcionários são então colocados no ArrayList
     * atendentes e o mesmo ocorre com os clientes que são 
     * colocados no ArrayList clientes.
     */
    private void recebeDados() {
        AcessoDados acesso = new AcessoDados();
        acesso.lerArquivo("dadosEntrada.txt");
        clientes = acesso.getClientes();
        atendentes = acesso.getAtendentes();
        setNumMaxClientes(clientes.size());
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
            for (int j=0; j < atendentes.size(); j++) {                     // Percorre os atendentes e aqueles livres atenderão
                if (atendentes.get(j).ocupado().equals(false)) {            // clientes e esses clientes que serão atendidos vão
                    atendentes.get(j).atender(clientes.get(0));
                    atualizarEventos(atendentes.get(j).registraEventos());   
                    clientes.remove(0);                                     // sair da fila.
                                                                            // Atendendo o cliente 0 e sempre remover ele faz com 
                }                                                           // que sempre o primeiro da fila seja atendido e saia
            }                                                               // da fila.
        }
    }

    private void atualizarEventos(ArrayList<Evento> _eventos) {
        for (int i=0; i<_eventos.size(); i++) {
            eventos.add(_eventos.get(i));
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
        relatorio.calcularNumEventos(getEventos());
        relatorio.calcularTempoMedioEsperaNaFila();
        relatorio.calcularTamanhoMedioFilaAtendimento();
        relatorio.calcularTamanhoFilaMax(getNumMaxClientes());
        relatorio.calcularTempoMedioAtendimento();
        relatorio.criarGrafico();
        relatorio.escreverRelatorio();
    }

}
