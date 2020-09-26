package com.capgemini.drinkanddelight.dao;

import com.capgemini.drinkanddelight.entity.RawMaterialStockEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRawMaterialDao extends JpaRepository<RawMaterialStockEntity,String> {

    RawMaterialStockEntity findByOrderId(String orderId);
}
