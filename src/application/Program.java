package application;

import java.text.SimpleDateFormat;
import java.util.Date;

import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		Department dpto = new Department (1, "Books"); 
		System.out.println(dpto);

		Seller seller = new Seller (21, "Bob", "bob@gmail.com", new Date(), 1780.00, dpto); 
		System.out.println(seller);
		
	}

}
