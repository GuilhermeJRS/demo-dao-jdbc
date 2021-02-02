package applications;

import java.util.Date;
import java.util.List;
import java.util.Locale;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class ProgramSeller {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("===== TEST 1: seller findById =====");
		System.out.println(sellerDao.findById(3));
		System.out.println(sellerDao.findById(4));	
		
		System.out.println("===== TEST 2: seller findByDepartment =====");
		List <Seller> sellers = sellerDao.findByDepartment(new Department(2, null));
		for (Seller seller : sellers) {
			System.out.println(seller);			
		}
		
		System.out.println("===== TEST 3: seller findAll =====");
		sellers = sellerDao.findAll();
		for (Seller seller : sellers) {
			System.out.println(seller);			
		}
		
		System.out.println("===== TEST 4: seller insert =====");
		Seller newSeller = new Seller(null, "Greeeeeg", "greeeeeg@gmail.com", new Date(), 4000.0, new Department(3, null));
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New Id = " + newSeller.getId());
		
		System.out.println("===== TEST 5: seller update =====");
		Seller seller = sellerDao.findById(3); 
		System.out.println("Before Update: " + seller);
		seller.setName("GSouza");
		sellerDao.update(seller);
		System.out.println("After  Update: " + sellerDao.findById(3));
				
		System.out.println("===== TEST 6: seller delete =====");
		sellerDao.deleteById(newSeller.getId());
		System.out.println("Deleted! ");
	}
}
