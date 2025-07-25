package br.com.bassi.smartstock.controller;

import br.com.bassi.smartstock.controller.dto.StartDto;
import br.com.bassi.smartstock.service.SmartStockService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
public class StartController {

    private final SmartStockService smartStockService;

    public StartController(SmartStockService smartStockService) {
        this.smartStockService = smartStockService;
    }

    @PostMapping("/start")
    public ResponseEntity<Void> start(@RequestBody StartDto dto){

        CompletableFuture.runAsync(()->{ //utilizando threadh
            smartStockService.process(dto.reportPath());
        });

        return ResponseEntity.accepted().build();
    }
}
