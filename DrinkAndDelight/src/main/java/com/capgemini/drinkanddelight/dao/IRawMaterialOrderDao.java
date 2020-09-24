package com.capgemini.drinkanddelight.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.capgemini.drinkanddelight.entity.RawMaterialOrderEntity;

@Repository
public interface IRawMaterialOrderDao  extends JpaRepository<RawMaterialOrderEntity, Integer> {


}
