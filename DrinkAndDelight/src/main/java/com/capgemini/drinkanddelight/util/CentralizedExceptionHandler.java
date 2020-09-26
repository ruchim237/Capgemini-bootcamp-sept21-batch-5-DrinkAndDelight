package com.capgemini.drinkanddelight.util;

import com.capgemini.drinkanddelight.exception.InvalidArgumentException;
import com.capgemini.drinkanddelight.exception.StockNotFoundException;
import com.capgemini.drinkanddelight.exception.SupplierNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CentralizedExceptionHandler {

    private static final Logger Log= LoggerFactory.getLogger(CentralizedExceptionHandler.class);

    @ExceptionHandler(StockNotFoundException.class)
    public ResponseEntity<String> handleStockNotFound(StockNotFoundException ex) {
        Log.error("Stock not found exception", ex);
        String msg = ex.getMessage();
        ResponseEntity<String> response = new ResponseEntity<>(msg, HttpStatus.NOT_FOUND);
        return response;
    }

    @ExceptionHandler(SupplierNotFoundException.class)
    public ResponseEntity<String> handleSupplierNotFound(SupplierNotFoundException ex) {
        Log.error("Supplier not found exception", ex);
        String msg = ex.getMessage();
        ResponseEntity<String> response = new ResponseEntity<>(msg, HttpStatus.NOT_FOUND);
        return response;
    }

    @ExceptionHandler(InvalidArgumentException.class)
    public ResponseEntity<String> handleInvalidArgument(InvalidArgumentException ex) {
        Log.error("Invalid Argument exception", ex);
        String msg = ex.getMessage();
        ResponseEntity<String> response = new ResponseEntity<>(msg, HttpStatus.NOT_FOUND);
        return response;
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<String> handleAll(Throwable ex) {
        Log.error("exception caught", ex);
        String msg = ex.getMessage();
        ResponseEntity<String> response = new ResponseEntity<>(msg, HttpStatus.INTERNAL_SERVER_ERROR);
        return response;
    }

}

