package trabalhopratico_grupo1;

import java.util.ArrayList;

public class Simulacao {

    private static ArrayList<Cliente> clientes;
    private ArrayList<Atendente> atendentes;  

    public void simularAgencia() {
        AcessoDados acesso = new AcessoDados();
        acesso.lerArquivo("dadosEntrada.txt");
        //Debug
        System.out.println("oi");
    }
    
    public static void inserirCliente(Cliente cliente){
        clientes.add(cliente);
    }
    
    //TODO
    public int calcularTempoTotal() {
        return 0;
    }
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

}
