package trabalhopratico_grupo1;

import java.util.ArrayList;

public class Simulacao {

    private int tempoTotal;
    private int tempoAtual;
    private int numMaxClientes;
    private int tempoDeEsperaTotal;
    private int tempoDeEsperaClienteNormal;
    private int tempoDeEsperaClientePrioritario;
    private int contadorFilaEspera;
    private int contadorFilaClienteN;
    private int contadorFilaClienteP;
    private ArrayList<Evento> eventos;
    private ArrayList<Cliente> clientes;
    private ArrayList<Atendente> atendentes;  
    private ArrayList<Cliente> filaDeEspera;

    public Simulacao() {
        this.tempoTotal = 0;
        this.tempoAtual = 0;
        this.numMaxClientes = 0;
        this.tempoDeEsperaTotal = 0;
        this.contadorFilaEspera = 0;
        this.contadorFilaClienteN = 0;
        this.contadorFilaClienteP = 0;
        eventos = new ArrayList<Evento>();
        clientes = new ArrayList<Cliente>();
        atendentes = new ArrayList<Atendente>();
        filaDeEspera = new ArrayList<Cliente>();
    }
    
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
        //Recebe todos os dados do arquivo
        recebeDados();
        //Começa o atendimento
        atendimento();
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

    /**
     * Este método é responsável por atualizar o tempo atual da
     * simulação. É utilizado sempre que é preciso "mover a 
     * simulação pelo tempo".
     * @param _tempo
     */
    public void setTempoAtual(int _tempo) {
        this.tempoAtual = tempoAtual + _tempo;
    }

    /**
     * Este método retorna a quantidade máxima que a simulação
     * atendeu. Utilizado para se montar as estatísticas.
     * @return numMaxClientes
     */
    public int getNumMaxClientes() {
        return this.numMaxClientes;
    }

    /**
     * Este método é utilizado para se definir a quantidade máxima
     * de clientes atendidos pela simulação uma vez que a variável
     * é privada.
     * @param _num
     */
    public void setNumMaxClientes(int _num) {
        this.numMaxClientes = _num;
    }

    /**
     * Com este método é possível pegar a fila de clientes da 
     * simulação.
     * @return ArrayList<Cliente> clientes
     */
    public ArrayList<Cliente> getClientes() {
        return this.clientes;
    }

    /**
     * Com este método é possível pegar a fila de atendentes da
     * simulação.
     * @return ArrayList<Atendente> atendentes
     */
    public ArrayList<Atendente> getAtendentes() {
        return this.atendentes;
    }

    /**
     * Com este método é possível pegar a lista que contém todos
     * os eventos que passaram pela simulação. É utilizado para 
     * gerar as estatísticas e para manter um histórico.
     * @return ArrayList<Evento> eventos
     */
    public ArrayList<Evento> getEventos() {
        return this.eventos;
    }

    public int getTempoDeEsperaClienteNormal() {
        return tempoDeEsperaClienteNormal;
    }

    public int getTempoDeEsperaClientePrioritario() {
        return tempoDeEsperaClientePrioritario;
    }

    public int getContadorFilaEspera() {
        return contadorFilaEspera;
    }

    public int getContadorFilaClienteN() {
        return contadorFilaClienteN;
    }

    public int getContadorFilaClienteP() {
        return contadorFilaClienteP;
    }

    public int getTempoDeEsperaTotal() {
        return this.tempoDeEsperaTotal;
    }
    /*
    public void setTempoDeEsperaTotal(int _tempo) {
        this.tempoDeEsperaTotal = _tempo;
    }
    */
    /**
     * Este método lê o arquivo de entrada. Dele é retirado
     * quantos funcionários o banco tem, qual sua categoria,
     * mais os clientes e suas respectivas horas de entrada no 
     * banco. Os funcionários são então colocados no ArrayList
     * atendentes e o mesmo ocorre com os clientes que são 
     * colocados no ArrayList clientes.
     */
    private void recebeDados() {
        try {
            AcessoDados acesso = new AcessoDados();
            acesso.lerArquivo("dadosEntrada.txt");
            clientes = acesso.getClientes();
            atendentes = acesso.getAtendentes();
            setNumMaxClientes(clientes.size());
        } catch (Exception e) {
            System.out.println("Um erro ocorreu ao receber dados: " + e.getMessage());
        }
    }

    /**
     * Laço principal, executa enquanto ainda tem clientes na fila do banco.
     * A ideia é pegar um cliente pra cada atendente e tirar esses clientes 
     * da fila de clientes. Assim o atributo clientes só irá mostrar pessoas 
     * na fila. Percorre os atendentes e aqueles livres atenderão clientes e 
     * esses clientes que serão atendidos vão sair da fila. Atendendo o 
     * cliente 0 e sempre remover ele faz com que sempre o primeiro da fila 
     * seja atendido e saia da fila. Após atender o cliente o atendente fica
     * livre.
     */
    //TODO falta terminar
    private void atendimento() {
        int min;
        try {
            while (!clientes.isEmpty()) {     
                for (int j=0; j < atendentes.size(); j++) {
                    if (atendentes.get(j).ocupado().equals(false) && atendentes.get(j).getHoraLivre() < clientes.get(0).getHoraChegada()) {
                        atendentes.get(j).atender(clientes.get(0));
                        atualizarEventos(atendentes.get(j).registraEventos());
                        clientes.remove(0);
                        atendentes.get(j).desocupar();
                    } else { //Todos os atendentes estão ocupados
                        
                        filaDeEspera.add(clientes.get(0));
                        contadorFilaEspera++;
                        for (int k = 0; k < atendentes.size(); k++) {
                            System.out.println("oi");
                            min = menorHoraLivre(atendentes);
                            if(clientes.get(0) instanceof ClienteNormal ){
                                contadorFilaClienteN++;
                                tempoDeEsperaClienteNormal = tempoDeEsperaClienteNormal + filaDeEspera.get(0).getHoraChegada() - atendentes.get(j).getHoraLivre();
                            }else{
                                contadorFilaClienteP++;
                                tempoDeEsperaClientePrioritario = tempoDeEsperaClientePrioritario + filaDeEspera.get(0).getHoraChegada() - atendentes.get(j).getHoraLivre();
                            }
                            tempoDeEsperaTotal = tempoDeEsperaTotal + filaDeEspera.get(0).getHoraChegada() - atendentes.get(j).getHoraLivre();
                            atendentes.get(j).atender(clientes.get(0));
                            atualizarEventos(atendentes.get(j).registraEventos());
                            clientes.remove(0);
                            atendentes.get(j).desocupar();
                        }
                    }
                }
            }
            tempoTotal = maiorHoraLivre(atendentes);
        } catch (Exception e) {
            System.out.println("Um erro ocorreu no laço principal: " + e.getMessage());
        }
    }

    /**
     * Este método insere todos os eventos tratados pelo atendente na lista
     * com todos os eventos. É necessário para a estatística número de eventos.
     * @param _eventos
     */
    private void atualizarEventos(ArrayList<Evento> _eventos) {
        try {
            for (int i=0; i<_eventos.size(); i++) {
                eventos.add(_eventos.get(i));
            }
        } catch (Exception e) {
            System.out.println("Um erro ocorreu ao se atualizar os eventos: " + e.getMessage());
        }

    }

    /**
     * Este método irá gerar o relatório com suas estatísticas
     * e irá criar uma janela com o gráfico.
     */
    //TODO
    public void gerarRelatorio() {
        try {
            Estatisticas relatorio = new Estatisticas();
            relatorio.calcularTempoTotal(tempoTotal);
            relatorio.calcularNumEventos(eventos);
            relatorio.calcularTempoMedioAtendimento(tempoDeEsperaTotal,numMaxClientes);
            //relatorio.calcularTamanhoMedioFilaAtendimento();
            relatorio.calcularTamanhoFilaMax(getNumMaxClientes());
            relatorio.calcularTempoMedioAtendimentoClienteNormal(tempoDeEsperaClienteNormal, contadorFilaClienteN);
            relatorio.calcularTempoMedioAtendimentoClientePrioritario(tempoDeEsperaClientePrioritario, contadorFilaClienteP);
            relatorio.criarGrafico();
            relatorio.escreverRelatorio();
        } catch (Exception e) {
            System.out.println("Erro ao gerar o relatório: " + e.getMessage());
        }
    }

    /**
     * Este método percorre a lista de atendentes e retorna o momento mais
     * próximo em que que haverá um atendente livre.
     * @param ArrayList<Atendente> atendentes
     * @return int menor
     */
    public int menorHoraLivre(ArrayList<Atendente> _atendentes) {
        int menor = 1000000;
        for (int i=0; i < _atendentes.size(); i++) {
            if (_atendentes.get(i).getHoraLivre() < menor) {
                menor = _atendentes.get(i).getHoraLivre();
            }
        }
        return menor;
    }

        /**
     * Este método percorre a lista de atendentes e retorna o maior horario
     * @param ArrayList<Atendente> atendentes
     * @return int menor
     */
    public int maiorHoraLivre(ArrayList<Atendente> _atendentes) {
        int maior = 0;
        for (int i=0; i < _atendentes.size(); i++) {
            if (_atendentes.get(i).getHoraLivre() > maior) {
                maior = _atendentes.get(i).getHoraLivre();
            }
        }
        return maior;
    }
}
