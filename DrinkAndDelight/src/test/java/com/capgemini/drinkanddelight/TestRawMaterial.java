package com.capgemini.drinkanddelight;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.drinkanddelight.dao.IRawMaterialOrderDao;
import com.capgemini.drinkanddelight.service.RawMaterialOrderServiceImpl;

@SpringBootTest
class TestRawMaterial {
	
    @Mock
	private RawMaterialOrderServiceImpl sdao;

	/*@Test
  	public void testGetOrderID() {
    	
	 when(sdao.placeRawMaterialOrder()).thenReturn(null);
	 assertEquals(null, sdao.placeRawMaterialOrder());	
	}*/
}
