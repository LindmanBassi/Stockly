package br.com.bassi.stockly.service;

import br.com.bassi.stockly.domain.CsvStockItem;
import br.com.bassi.stockly.domain.PurchaseRequestEntity;
import br.com.bassi.stockly.repositories.PurchaseRequestRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;

@Service
public class StocklyService  {

    private final ReportService reportService;
    private final PurchaseSectorService purchaseSectorService;
    private final PurchaseRequestRepository purchaseRequestRepository;

    public StocklyService(ReportService reportService, PurchaseSectorService purchaseSectorService, PurchaseRequestRepository purchaseRequestRepository) {
        this.reportService = reportService;
        this.purchaseSectorService = purchaseSectorService;
        this.purchaseRequestRepository = purchaseRequestRepository;
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
                   var purchaseWithSuccess = purchaseSectorService.sendPurchaseRequest(item,reorderQuantity);
                    //3 - salvar no mysql os itens que foram recomprados
                    persist(item,reorderQuantity,purchaseWithSuccess);
                }
            });
        } catch (IOException e){
            throw new RuntimeException();
        }

    }

    private void persist(CsvStockItem item,
                         Integer reorderQuantity,
                         boolean purchaseWithSuccess) {

        var entity = new PurchaseRequestEntity();


        entity.setItemName(item.getItemName());
        entity.setQuantityOnStock(item.getQuantity());
        entity.setReorderThreshold(item.getReorderThreshold());
        entity.setSupplierName(item.getSupplierName());
        entity.setSupplierEmail(item.getSupplierEmail());
        entity.setLastStockUpdateTime(LocalDateTime.parse(item.getLastStockUpdateTime()));

        entity.setPurchaseQuantity(reorderQuantity);
        entity.setPurchasedWithSuccess(purchaseWithSuccess);
        entity.setPurchaseDateTime(LocalDateTime.now());

        purchaseRequestRepository.save(entity);
    }

    private Integer calculateReorderQuantity(CsvStockItem item) {

        return item.getReorderThreshold() + ((int)Math.ceil(item.getReorderThreshold() * 0.2));
    }
}
