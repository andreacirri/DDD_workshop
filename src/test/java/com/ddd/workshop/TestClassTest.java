package com.ddd.workshop;

import org.junit.Assert;
import org.junit.Test;

public class TestClassTest {

	@Test
	public void Should_ReturnTrue(){
		TestClass testClass = new TestClass();
		Assert.assertTrue(testClass.returnTrue());
	}

}