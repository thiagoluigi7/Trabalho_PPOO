package trabalhopratico_grupo1;

import org.jfree.chart.JFreeChart;
import java.io.*;

public class AcessoDados {

	public void lerArquivo(String arquivo) {
            
            try{
                BufferedReader arq = new BufferedReader(new FileReader(arquivo));
                String linha = arq.readLine();
                
                //Leitura e criação de Atendente
                String[] numAte = linha.split(",");

                AtendenteEfetivado[] atendenteEfe = new AtendenteEfetivado[Integer.parseInt(numAte[0])];
                AtendenteEstagiario[] atendenteEst = new AtendenteEstagiario[Integer.parseInt(numAte[1])];
                
                for(int i=0;i<Integer.parseInt(numAte[0]);i++){
                    atendenteEfe[i] = new AtendenteEfetivado(); 
                }

                for(int i=0;i<Integer.parseInt(numAte[1]);i++){
                    atendenteEst[i] = new AtendenteEstagiario(); 
                }
                
                linha = arq.readLine();
                
                //Leitura do tipo de estrategia
                String[] strat = linha.split(",");
                System.out.println(strat[0]);
                
                if(strat[0] == "FIFO"){
                    
                    linha = arq.readLine();
                    System.out.println("aquiss");
                    
                    while(linha!=null){
                        //Criação dos clientes
                        String horario = linha;
                        Cliente cliente = new ClienteNormal(Integer.parseInt(horario));
                        
                        Simulacao.inserirCliente(cliente);
                        
                        linha = arq.readLine();
                    }
                    arq.close();
                }else{
                    //throw new RuntimeException("Estratégia de atendimento das filas não configurado");
                }

            }
            catch(FileNotFoundException e){
                System.out.println("Impossivel abrir o arquivo " + arquivo);
            }
            catch(IOException e){
                System.out.println("Problema na leitura do arquivo " + arquivo);
            }
	}

	public void escreverArquivo() {

	}

}
