package ch.appaka.commerce.warehouse.web;

import ch.appaka.commerce.warehouse.business.domain.StockResponse;
import ch.appaka.commerce.warehouse.business.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/stock")
public class StockApiController {

    private final StockService stockService;

    @Autowired
    public StockApiController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping
    public String getReservations(
        @RequestParam(value = "sku", required = true) String sku,
        @RequestParam(value = "warehouse", required = false) String warehouse,
        Model model
    ) {
        StockResponse stockResponse = this.stockService.getStockBySkuAndWarehouse(sku, warehouse);
        model.addAttribute("stockResponse", stockResponse);
        return "stock";

    }

}