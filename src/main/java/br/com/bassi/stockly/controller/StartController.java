package br.com.bassi.stockly.controller;

import br.com.bassi.stockly.controller.dto.StartDto;
import br.com.bassi.stockly.service.StocklyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
public class StartController {

    private final StocklyService stocklyService;

    public StartController(StocklyService stocklyService) {
        this.stocklyService = stocklyService;
    }

    @PostMapping("/start")
    public ResponseEntity<Void> start(@RequestBody StartDto dto){

        CompletableFuture.runAsync(()->{ //utilizando threadh
            stocklyService.process(dto.reportPath());
        });

        return ResponseEntity.accepted().build();
    }
}
