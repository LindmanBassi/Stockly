package br.com.bassi.stockly.service;

import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class StocklyService  {

    private final ReportService reportService;

    public StocklyService(ReportService reportService) {
        this.reportService = reportService;
    }

    public void process(String reportPath){

        //1 - ler arquivo csv
        try {
            var items = reportService.readStockReport(reportPath);

        } catch (IOException e){
            throw new RuntimeException();
        }
        //2 - para cada item do csv chamar a api do setor de compras

        //3 - salvar no mysql os itens que foram recomprados
    }
}
