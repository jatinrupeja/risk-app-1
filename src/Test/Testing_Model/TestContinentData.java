package Test.Testing_Model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import Game.Model.ContinentData;

/**
 * This class will test the continent Data.
 * 
 * @author Vansh
 */
public class TestContinentData {

	private ContinentData continent;
	private String name;
	private int controlValue;

	@Before
	public void setUp() {
		name = "Asia";
		controlValue = 5;
		continent = new ContinentData(name, controlValue);
	}

	@Test
	public void Testgetname() {
		System.out.println("\nTesting for the name of \"Asia\" continent");
		assertEquals(name, continent.getName());

	}

	@Test
	public void Testcontrolvalue() {
		System.out.println("\nTesting for the name of \"5\" controlvalue");
		assertEquals(controlValue, continent.getControlValue());

	}
}
