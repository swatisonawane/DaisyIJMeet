package com.testingshastra.stepdefinations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Parameterization {
	int x, y, result;
	String first, second;
	Double a,b, dresult;
	List<Integer> numbers;
	Map m;

	@Given("I have {int} and {int}")
	public void i_have_and(Integer int1, Integer int2) {
		x = int1;
		y = int2;
	}

	@When("I add them")
	public void i_add_them() {
		result = x + y;
	}

	@Then("Print result")
	public void print_result() {
		System.out.println("Addition of two no: " + result);
	}

	@Given("I have {string} and {string}")
	public void m1(String first, String second) {
		this.first=first;
		this.second=second;

	}

	@Then("Print them in alphabetic order")
	public void arrangeInAlphaBeticOrder() {
		if (first.compareTo(second) == 0) {
			System.out.println("Strings are identical");
		} else if (first.compareTo(second) > 0) {
			System.out.println(second + " " + first);
		} else {
			System.out.println(first + " " + second);
			
		}

	}
	
	@Given("I have two float numbers {double} and {double}")
	public void i_have_two_float_numbers(Double double1, Double double2) {
	    a=double1;
	    b=double2;
	    
	}

	@When("I add two float numbers")
	public void i_add_two_float_numbers() {
	    dresult = a+b;
	}

	@Then("Print result od addition")
	public void print_result_od_addition() {
	    System.out.println("Addition of two float numbers is "+dresult);
	}
	
	@Given("I have list of integer numbers")
	public void i_have_list_of_integer_numbers(io.cucumber.datatable.DataTable datatable) {
		numbers= datatable.asList(Integer.class);

	}
	@Then("Print the list of numbers")
	public void print_the_list_of_numbers() {
		for (Integer integer : numbers) {
			System.out.println(integer);
		}

	}
	
	@Given("I have following table")
	public void i_have_following_table(DataTable table) {
		m= table.asMap(String.class, List.class);

	}
	
	@Then("print them in row column format")
	public void print_them_in_row_column_format() {
		System.out.println("Map: "+m);

	}

	//Data Driven Testing in cucumber
	@Given("I have <num1> and <num2>")
	public void i_have_num1_and_num2(int a, int b) {
	  x=a;
	  y=b;
	   
	}

	@When("We add them")
	public void we_add_them() {
	  result=x+y;
	}

	@Then("Verify if the result is prime")
	public void verify_if_the_result_is_prime() {
	    int count=0;
	    for(int i=1;i<=result;i++) {
	    	if(result%i==0) {
	    		count++;
	    	}
	    }
	    if(count>2) {
	    	System.out.println("Result is NOT prime: "+result);
	    }else {
	    	System.out.println("Result is prime: "+result);
	    }
	}
	
	//read data from excel sheet
	@Given("I have two numbers from {int}")
	public void readDataFromExcelSheet(int rowNum) throws IOException {
		FileInputStream fis = new FileInputStream("src/test/resources/numbers.xlsx");
		XSSFWorkbook book = new XSSFWorkbook(fis);
		Sheet sheet = book.getSheetAt(0);
		x=(int) sheet.getRow(rowNum).getCell(1).getNumericCellValue();
		y=(int) sheet.getRow(rowNum).getCell(2).getNumericCellValue();
		

	}
	

	
}
