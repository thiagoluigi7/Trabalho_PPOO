package trabalhoprincipal;

import org.jfree.chart.JFreeChart;
import java.util.ArrayList;

public class Simulacao {

    private static ArrayList<Cliente> clientes;
    private ArrayList<Atendente> atendentes;  

    public void simularAgencia() {
        AcessoDados acesso = new AcessoDados();
        acesso.lerArquivo("dadosEntrada.txt");
        System.out.println("oi");
    }
    
    public static void inserirCliente(Cliente cliente){
        clientes.add(cliente);
    }
        
    public int calcularTempoTotal() {
        return 0;
    }

    public double calcularTempoMedio() {
        return 0;
    }

    public double calcularTempoMedioAtendimento() {
        return 0;
    }

    public int calcularNumEventos() {
        return 0;
    }

    public double calcularTempoEsperaMedia() {
        return 0;
    }

    public double calcularTamanhoFilaMedia() {
        return 0;
    }

    public int calcularTamanhoFilaMaximo() {
        return 0;
    }

}
