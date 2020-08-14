/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhopratico_grupo1;

import java.awt.Dimension;
import java.util.ArrayList;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author vitor
 */

public class Grafico {
    public CategoryDataset createDataSet(ArrayList<Atendente> listaAtendente) {

        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        
        
        int cont=1;
        for (Atendente atendentes : listaAtendente) {
            dataSet.addValue(atendentes.getHoraLivre() ,"atendente"+cont , "");
            ++cont;
        }
        return dataSet;
    }

    public JFreeChart createBarChart(CategoryDataset dataSet) {
        JFreeChart graficoBarras = ChartFactory.createBarChart("Grafico", "", "Tempo Trabalhado", dataSet,
                PlotOrientation.VERTICAL, true, false, false);
        return graficoBarras;
    }

    public ChartPanel criarGrafico(ArrayList<Atendente> atendentes) {

        CategoryDataset dataSet = this.createDataSet(atendentes);

        JFreeChart grafico = this.createBarChart(dataSet);

        ChartPanel painelDoGrafico = new ChartPanel(grafico);

        painelDoGrafico.setPreferredSize(new Dimension(400, 400));

        return painelDoGrafico;
    }

}
