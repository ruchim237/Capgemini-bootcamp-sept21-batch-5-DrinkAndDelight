package com.capgemini.drinkanddelight.service;

import com.capgemini.drinkanddelight.dao.IRawMaterialDao;
import com.capgemini.drinkanddelight.entity.RawMaterialStockEntity;
import com.capgemini.drinkanddelight.exception.InvalidArgumentException;
import com.capgemini.drinkanddelight.exception.StockNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class RawMaterialServiceImpl implements IRawMaterialService {

    @Autowired
    private IRawMaterialDao dao;

    //This method will be used to add RawMaterailStock.
    @Override
    public RawMaterialStockEntity addStock(RawMaterialStockEntity stock) {
        stock = dao.save(stock);
        return stock;
    }

    //This method will track RawMaterialStock details on the basis of orderId.
    @Override
    public RawMaterialStockEntity trackRawMaterialOrder(String orderId) {
        if(orderId.isEmpty() || orderId.equals(null)) {
            throw new InvalidArgumentException("Invalid Id");
        }
        RawMaterialStockEntity stock = dao.findByOrderId(orderId);
        if(stock==null) {
            throw new StockNotFoundException(" Stock Not Found");
        }
        return stock;
    }

    //This method will validate the manufacturing date according to required conditions.
    //Date should not be less then current date and not greater than date after 3 months of current date.
    @Override
    public boolean validateManufacturingDate(Date manuDate) {
        Calendar currentDateAfter3Months = Calendar.getInstance();
        currentDateAfter3Months.add(Calendar.MONTH, 3);
        Calendar currentDate = Calendar.getInstance();
        return(manuDate.before(currentDateAfter3Months.getTime()) && manuDate.after(currentDate.getTime()));

	/*	LocalDate currentDate = LocalDate.now();
		LocalDate startDate = LocalDate.of(manuDate.getYear(),manuDate.getMonth(), manuDate.getDay());
		LocalDate endDate = currentDate.plusMonths(3);
		return(startDate.isAfter(currentDate) && startDate.isBefore(endDate));*/
    }


    //This method will validate the expiry date according to required conditions.
    //Date should not be less then current date and not greater than date after 3 months of current date.
    @Override
    public boolean validateExpiryDate(Date expiryDate) {
        Calendar currentDateAfter3Months = Calendar.getInstance();
        currentDateAfter3Months.add(Calendar.MONTH, 3);
        Calendar currentDate = Calendar.getInstance();
        return(expiryDate.before(currentDateAfter3Months.getTime()) && expiryDate.after(currentDate.getTime()));

		/*LocalDate currentDate = LocalDate.now();
		LocalDate startDate = LocalDate.of(expiryDate.getYear(),expiryDate.getMonth(), expiryDate.getDay());
		LocalDate endDate = currentDate.plusMonths(3);
		return(startDate.isAfter(currentDate) && startDate.isBefore(endDate));*/

    }

    //This method will update RawMaterialStock on basis of its processDate.
    @Override
    public String updateRawMaterialStock( String orderId, Date date) {
        String msg = " ";
        RawMaterialStockEntity updatedStock = trackRawMaterialOrder(orderId);

        Calendar currentDateAfter3Months = Calendar.getInstance();
        currentDateAfter3Months.add(Calendar.MONTH, 3);
        Calendar currentDate = Calendar.getInstance();

        //LocalDate currentDate = LocalDate.now();
        //	LocalDate startDate = LocalDate.of(date.getYear(),date.getMonth(), date.getDay());
        //LocalDate endDate = currentDate.plusMonths(3);
        if(date.before(currentDateAfter3Months.getTime()) && date.after(currentDate.getTime())) {
            updatedStock.setProcessDate(date);
            dao.save(updatedStock);
            //addStock(updatedStock);
            msg = "Date Updated";
        }
        else
            msg = "Error in data updation";

        return msg;

    }

    //This method will be used to fetch all RawMaterialStock present in a list.
    @Override
    public List<RawMaterialStockEntity> fetchAllStock() {
        List<RawMaterialStockEntity>stockList = dao.findAll();
        return stockList;
    }

}

