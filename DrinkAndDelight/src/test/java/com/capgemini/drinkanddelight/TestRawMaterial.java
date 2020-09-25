package com.capgemini.drinkanddelight;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import com.capgemini.drinkanddelight.entity.RawMaterialOrderEntity;
import com.capgemini.drinkanddelight.service.RawMaterialOrderServiceImpl;


@SpringBootTest
class Testing {

	@Mock
    RawMaterialOrderServiceImpl sdao;

	@Test
	void test() throws Exception
	{
		when(sdao.getRawMaterialOrder(0)).thenReturn(null);
		assertEquals(null, sdao.getRawMaterialOrder(0));
	}
	
	@Test
	  public void testAddRawMaterialOrder(){
		RawMaterialOrderEntity rMO = new RawMaterialOrderEntity();
		when(sdao.addRawMaterialOrder(rMO)).thenReturn(null);
		assertEquals(null,sdao.addRawMaterialOrder(rMO));
		
	}
}
