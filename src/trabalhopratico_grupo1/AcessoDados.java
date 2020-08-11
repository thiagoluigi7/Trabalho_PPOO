package trabalhopratico_grupo1;

import java.io.*;

public class AcessoDados {

	public void lerArquivo(String arquivo) {
            
            try{
                BufferedReader arq = new BufferedReader(new FileReader(arquivo));
                String linha = arq.readLine();
                
                //Leitura e criação de Atendente
                String[] numAte = linha.split(",");

                //AtendenteEfetivado[] atendenteEfe = new AtendenteEfetivado[Integer.parseInt(numAte[0])];
                //AtendenteEstagiario[] atendenteEst = new AtendenteEstagiario[Integer.parseInt(numAte[1])];
                
                AtendenteEfetivado atendenteEfe = new AtendenteEfetivado();
                AtendenteEstagiario atendenteEst = new AtendenteEstagiario();

                for(int i=0;i<Integer.parseInt(numAte[0]);i++){
                    atendenteEfe = new AtendenteEfetivado();
                    Simulacao.inserirAtendente(atendenteEfe);  
                }

                for(int i=0;i<Integer.parseInt(numAte[1]);i++){
                    atendenteEst = new AtendenteEstagiario();
                    Simulacao.inserirAtendente(atendenteEst); 
                }
                
                linha = arq.readLine();
                
                //Leitura do tipo de estrategia
                String[] strat = linha.split(",");
                
                if(strat[0].equals("FIFO")) {
                    
                    linha = arq.readLine();
                    
                    while(linha!=null){
                        
                        //Criação dos clientes
                        String[] dados = linha.split(",");
                        if(dados[1].equals("p")){
                            ClientePrioritario cliente = new ClientePrioritario(Integer.parseInt(dados[0]));
                            Simulacao.inserirCliente(cliente);
                        }else if(dados[1].equals("n")){
                            ClienteNormal cliente = new ClienteNormal(Integer.parseInt(dados[0]));
                            Simulacao.inserirCliente(cliente);
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
