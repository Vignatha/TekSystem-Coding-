package com.tek.interview.question;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class FooTest {
	Map<String, Order> o = null;
	
	@Before
	public void before() throws Exception{
		o = new HashMap<String, Order>();

		Order c = new Order();

		c.add(new OrderLine(new Item("book", (float) 12.49), 1));
		c.add(new OrderLine(new Item("music CD", (float) 14.99), 1));
		c.add(new OrderLine(new Item("chocolate bar", (float) 0.85), 1));

		o.put("Order 1", c);

		// Reuse cart for an other order
		c = new Order();

		c.add(new OrderLine(new Item("imported box of chocolate", 10), 1));
		c.add(new OrderLine(new Item("imported bottle of perfume", (float) 47.50), 1));

		o.put("Order 2", c);

		// Reuse cart for an other order
		c = new Order();

		c.add(new OrderLine(new Item("Imported bottle of perfume", (float) 27.99), 1));
		c.add(new OrderLine(new Item("bottle of perfume", (float) 18.99), 1));
		c.add(new OrderLine(new Item("packet of headache pills", (float) 9.75), 1));
		c.add(new OrderLine(new Item("box of importd chocolates", (float) 11.25), 1));

		o.put("Order 3", c);

		
	}

	@Test
	public void testRounding() {
		double roundedValue = calculator.rounding(4.56739);
		assertEquals(4.57, roundedValue,0.0);
	}
	
	@Test
	public void testGrandTotal(){
		double grandtotal = new calculator().calculate(o);
		assertEquals(153.81, grandtotal,0.0);
	}
	
	@Test
	public void testOrder(){
		Order order = o.get("Order 1");
		assertEquals(3, order.size());
		assertEquals( 12.49,order.get(0).getItem().getPrice(),0.0001);
		assertEquals( 1,order.get(0).getQuantity());	}

}
