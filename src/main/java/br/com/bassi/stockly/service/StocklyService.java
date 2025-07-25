package br.com.bassi.stockly.service;

import br.com.bassi.stockly.domain.CsvStockItem;
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

            items.forEach(item ->{
                if(item.getQuantity() < item.getReorderThreshold()){

                    //1 - calcular a quant a ser recomprada
                    var reorderQuantity = calculateReorderQuantity(item);

                    //2 - para cada item do csv chamar a api do setor de compras

                    //3 - salvar no mysql os itens que foram recomprados
                }
            });
        } catch (IOException e){
            throw new RuntimeException();
        }

    }

    private Integer calculateReorderQuantity(CsvStockItem item) {

        return item.getReorderThreshold() + ((int)Math.ceil(item.getReorderThreshold() * 0.2));
    }
}
