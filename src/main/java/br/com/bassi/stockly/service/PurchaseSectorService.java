package br.com.bassi.stockly.service;

import br.com.bassi.stockly.domain.CsvStockItem;
import org.springframework.stereotype.Service;

@Service
public class PurchaseSectorService {

    private final AuthService authService;

    public PurchaseSectorService(AuthService authService) {
        this.authService = authService;
    }

    public boolean sendPurchaseRequest(CsvStockItem item,
                                       Integer purchaseQuantity){

        //1 - autenticacao na api para recuparar o token
        var token = authService.getToken();
        //2 - solicitacao de compra com o token da chamada anterior

        //3 - validar se a reposta foi um sucesso
        return false;
    }
}
