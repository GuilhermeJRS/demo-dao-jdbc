package application;

import java.util.ArrayList;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("===== TEST 1: seller findById =====");
		System.out.println(sellerDao.findById(3));
		System.out.println(sellerDao.findById(4));	
		
		System.out.println("===== TEST 2: seller findByDepartment =====");
		List <Seller> sellers = sellerDao.findByDepartment(new Department (2, null));
		for (Seller seller : sellers) {
			System.out.println(seller);			
		}
		
		System.out.println("===== TEST 2: seller findAll =====");
		sellers = sellerDao.findAll();
		for (Seller seller : sellers) {
			System.out.println(seller);			
		}
	}
}
