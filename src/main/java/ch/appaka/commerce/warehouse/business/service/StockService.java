package ch.appaka.commerce.warehouse.business.service;

import ch.appaka.commerce.warehouse.business.domain.RoomReservation;
import ch.appaka.commerce.warehouse.business.domain.StockResponse;
import ch.appaka.commerce.warehouse.data.entity.*;
import ch.appaka.commerce.warehouse.data.repository.GuestRepository;
import ch.appaka.commerce.warehouse.data.repository.ReservationRepository;
import ch.appaka.commerce.warehouse.data.repository.RoomRepository;
import ch.appaka.commerce.warehouse.data.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StockService {

    private final StockRepository stockRepository;

    @Autowired
    public StockService(StockRepository stockRepository){
        this.stockRepository = stockRepository;
    }

    public StockResponse getStockBySkuAndWarehouse(String sku, String warehouse){

        // TODO filter by sku and warehouse (optional)
        Iterable<Stock> stocks = this.stockRepository.findAll();

        Map<String, Map<String, Integer>> data = new HashMap<>();

        StockResponse stockResponse = new StockResponse();
        stockResponse.setSuccess(true);
        stockResponse.setKey("???");
        stockResponse.setData(data);

        stocks.forEach(stock -> {
            // get warehouse map
            Map<String, Integer> stockData = data.computeIfAbsent(stock.getWarehouse(), k -> new HashMap<String, Integer>());
            // add sku => quantity to the warehouse map
            stockData.put(stock.getSku(), stock.getQuantity());
        });

        return stockResponse;
    }
}
