package trabalhopratico_grupo1;

import java.io.*;
import java.util.ArrayList;

public class AcessoDados {

    private ArrayList<Cliente> clientes;
    private ArrayList<Atendente> atendentes;
    
    
    public AcessoDados(){
        clientes = new ArrayList<Cliente>();
        atendentes = new ArrayList<Atendente>();        
    }
    
    /**
     * Esse método ler o arquivo de entrada e cria os vetores dos respectivos valores
     * @param arquivo 
     */
    
    public void lerArquivo(String arquivo) {

        try{
            BufferedReader arq = new BufferedReader(new FileReader(arquivo));
            String linha = arq.readLine();

            //Leitura e criação de Atendente
            String[] numAte = linha.split(",");
            
            /**
            * Adiciona um atendente no banco.
            * @param atendente
            */
            AtendenteEfetivado atendenteEfe = new AtendenteEfetivado();
            AtendenteEstagiario atendenteEst = new AtendenteEstagiario();

            for(int i=0;i<Integer.parseInt(numAte[0]);i++) {
                atendenteEfe = new AtendenteEfetivado();
                atendentes.add(atendenteEfe);
            }

            for(int i=0;i<Integer.parseInt(numAte[1]);i++) {
                atendenteEst = new AtendenteEstagiario();
                atendentes.add(atendenteEst); 
            }
            linha = arq.readLine();

            //Leitura do tipo de estrategia
            String[] strat = linha.split(",");

            if(strat[0].equals("FIFO")) {

                linha = arq.readLine();

                while(linha!=null){

                    /**
                    * Adiciona um cliente na fila de clientes do banco.
                    * @param cliente
                    */
                    String[] dados = linha.split(",");
                    if(dados[1].equals("p")){
                        Cliente cliente = new ClientePrioritario(Integer.parseInt(dados[0]));
                        clientes.add(cliente);
                    }else if(dados[1].equals("n")){
                        Cliente cliente = new ClienteNormal(Integer.parseInt(dados[0]));
                        clientes.add(cliente);
                    }else{
                        throw new RuntimeException("Tipo cliente Invalido");
                    }

                    linha = arq.readLine();
                }
                arq.close();
            }else{
                throw new RuntimeException("Estratégia de atendimento das filas não configurado");
            }

        }
        catch(FileNotFoundException e) {
            System.out.println("Impossivel abrir o arquivo " + arquivo);
        }
        catch(IOException e) {
            System.out.println("Problema na leitura do arquivo " + arquivo);
        }
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public ArrayList<Atendente> getAtendentes() {
        return atendentes;
    }
    
    /**
     * Esse método gera o arquivo texto com o relatório dos dados da simulação
     * @param nomeArquivo
     * @param tempoTotal
     * @param numEventos
     * @param tempoMedioEsperaNaFila
     * @param tamanhoMedioFilaAtendimento
     * @param tamanhoFilaMax
     * @param tempoMedioAtendimento 
     */
    public void escreverArquivo(String nomeArquivo, int tempoTotal, int numEventos, int tempoMedioEsperaNaFila, int tamanhoMedioFilaAtendimento, int tamanhoFilaMax, int tempoMedioAtendimentoClienteNormal, int tempoMedioAtendimentoClientePrioritario, int tempoMedioAtendimento) {
        Estatisticas est = new Estatisticas();
        try{
            FileWriter arq = new FileWriter(nomeArquivo);
            
    
            arq.write("Tempo total: " + tempoTotal +"\n");
            arq.write("Numero total de Eventos: " + numEventos +"\n");
            arq.write("Tempo médio de espera na fila de atendimento : " + tempoMedioAtendimento +"\n");
            arq.write("Tamanho médio da fila de atendimento: " + tamanhoMedioFilaAtendimento +"\n");
            arq.write("Tamanho máximo da fila de atendimento: " + tamanhoFilaMax +"\n");
            arq.write("Tempo médio de atendimento do cliente normal: " + tempoMedioAtendimentoClienteNormal +"\n");
            arq.write("Tempo médio de atendimento do cliente prioritario: " + tempoMedioAtendimentoClientePrioritario +"\n");
        
 
            arq.close();
        }catch(IOException e){
            System.out.println("Falaha ao salvar o arquivo " + nomeArquivo);
        }
    }

}
