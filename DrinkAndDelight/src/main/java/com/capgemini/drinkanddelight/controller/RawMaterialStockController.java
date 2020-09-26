package com.capgemini.drinkanddelight.controller;

import com.capgemini.drinkanddelight.dto.RawMaterialStockDto;
import com.capgemini.drinkanddelight.dto.SupplierDto;
import com.capgemini.drinkanddelight.entity.RawMaterialStockEntity;
import com.capgemini.drinkanddelight.entity.Supplier;
import com.capgemini.drinkanddelight.service.IRawMaterialService;
import com.capgemini.drinkanddelight.service.ISupplierService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/stocks")
@Validated
public class RawMaterialStockController {
    private static final Logger Log = LoggerFactory.getLogger(RawMaterialStockController.class);

    @Autowired
    private IRawMaterialService rawMaterialService;

    @Autowired
    private ISupplierService supplierService;

    @PostMapping("/add") // will add RawMaterialStock imp details.
    public ResponseEntity<RawMaterialStockEntity> addStock(@RequestBody @Valid RawMaterialStockDto dto) {
        RawMaterialStockEntity stock1 = convert(dto);
        stock1 = rawMaterialService.addStock(stock1);
        ResponseEntity<RawMaterialStockEntity> response = new ResponseEntity<>(stock1, HttpStatus.OK);
        return response;
    }

    public RawMaterialStockEntity convert(RawMaterialStockDto dto) {
        RawMaterialStockEntity stock = new RawMaterialStockEntity();
        stock.setStockId(dto.getStockId());
        stock.setOrderId(dto.getOrderId());
        stock.setName(dto.getName());
        stock.setPrice_per_unit(dto.getPrice_per_unit());
        stock.setPrice(dto.getPrice());
        stock.setQuantityUnit(dto.getQuantityUnit());
        stock.setWarehouseId(dto.getWarehouseId());
        stock.setDeliveryDate(dto.getDeliveryDate());
        stock.setQuantityValue(dto.getQuantityValue());

        Date manufacturingDate = dto.getManuDate();
        if (rawMaterialService.validateManufacturingDate(manufacturingDate)) {
            stock.setManuDate(dto.getManuDate());
        } else
            Log.error("Manufacturing Date not in range");
        Date expirydate = dto.getExpiryDate();
        if (rawMaterialService.validateExpiryDate(expirydate)) {
            stock.setExpiryDate(expirydate);
        } else
            Log.error("Expiry Date not in range");

        stock.setProcessDate(dto.getProcessDate());
        stock.setQualityCheck(dto.getQualityCheck());
        return stock;
    }

    @PostMapping("/addSupplier") // will add Supplier details.
    public ResponseEntity<Supplier> addSupplier(@RequestBody @Valid SupplierDto dto) {
        Supplier supplier = convertSupplier(dto);
        supplier = supplierService.addSupplier(supplier);
        ResponseEntity<Supplier> response = new ResponseEntity<>(supplier, HttpStatus.OK);
        return response;
    }

    public Supplier convertSupplier(SupplierDto dto) {
        Supplier supplier = new Supplier();
        // supplier.setSupplierId(dto.getSupplierId());
        supplier.setSupplierName(dto.getSupplierName());
        supplier.setSupplierAddress(dto.getSupplierAddress());
        supplier.setSupplierPhoneNo(dto.getSupplierPhoneNo());
        return supplier;
    }

    @GetMapping("/get/{id}") // will fetch RawMaterialStovck details through id.
    public ResponseEntity<RawMaterialStockEntity> fetchStock(@PathVariable("id") String id) {
        RawMaterialStockEntity stock = rawMaterialService.trackRawMaterialOrder(id);
        ResponseEntity<RawMaterialStockEntity> response = new ResponseEntity<RawMaterialStockEntity>(stock,
                HttpStatus.OK);
        return response;
    }

    //will fetch supplier details on the basis of id.
    @GetMapping("/getS/{supplierId}")
    public ResponseEntity<Supplier> fetchSupplier(@PathVariable("supplierId") @Min(1) int supplierId) {
        Supplier supplier = supplierService.fetchSupplierById(supplierId);
        ResponseEntity<Supplier> response = new ResponseEntity<Supplier>(supplier, HttpStatus.OK);
        return response;
    }

    // will fetch details of all RawMaterialStocks.
    @GetMapping("/getStocks")
    public ResponseEntity<List<RawMaterialStockEntity>> fetchAllRawMaterialStock() {
        List<RawMaterialStockEntity> stocks = rawMaterialService.fetchAllStock();
        ResponseEntity<List<RawMaterialStockEntity>> response = new ResponseEntity<>(stocks, HttpStatus.OK);
        return response;
    }

    // will fetch details of all Suppliers.
    @GetMapping("/getSuppliers")
    public ResponseEntity<List<Supplier>> fetchAllSuppliers() {
        List<Supplier> suppliers = supplierService.fetchAllSuppliers();
        ResponseEntity<List<Supplier>> response = new ResponseEntity<>(suppliers, HttpStatus.OK);
        return response;
    }

    /*	// will fetch details of supplier and RawMaterialStock
        @GetMapping
        public ResponseEntity<List<StockAndSupplierDto>> fetchAll() {
            List<RawMaterialStockEntity> stocks = rawMaterialService.fetchAllStock();
            List<Supplier> suppliers = supplierService.fetchAllSuppliers();
            List<StockAndSupplierDto> list = convertStockDetails(stocks, suppliers);
            ResponseEntity<List<StockAndSupplierDto>> response = new ResponseEntity<>(list, HttpStatus.OK);
            return response;
        }


        // for displayig details of supplier and RawMaterialStock.
        /*StockAndSupplierDto convertStockDetails(RawMaterialStockEntity stock, Supplier supplier) {
            StockAndSupplierDto dto = new StockAndSupplierDto();
            dto.setOrderId(stock.getOrderId());
            dto.setName(stock.getName());
            dto.setDeliveryDate(stock.getDeliveryDate());
            int id = supplier.getSupplierId();
            // SupplierDto supplier = fetchSupplier(id);
            dto.setSupplier(supplierService.fetchSupplierById(id));
            return dto;
        }

        public List<StockAndSupplierDto> convertStockDetails(List<RawMaterialStockEntity> stocks,
                List<Supplier> suppliers) {
            List<StockAndSupplierDto> list = new ArrayList<>();
            for (RawMaterialStockEntity stock : stocks) {
                for (Supplier supplier : suppliers) {
                    StockAndSupplierDto detailsDto = convertStockDetails(stock, supplier);

                    list.add(detailsDto);
                }
            }
            return list;
        }
    */
    //will update RawMaterialStock process date.
    @PutMapping("/update/{id}/{date}")
    public ResponseEntity<String> updateStock(@RequestBody Map<String,String> map)
            throws ParseException {
        // http://localhost:8086/stocks/update/S11/2020-05-20 404
        //System.out.println("Id=" + id + " " + "Date:" + date);
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String id = map.get("orderId");
        String date = map.get("processDate");
        Date requiredate = format.parse(date);
        String message = rawMaterialService.updateRawMaterialStock(id, requiredate);
        ResponseEntity<String> response = new ResponseEntity<>(message, HttpStatus.OK);
        return response;
    }
}

