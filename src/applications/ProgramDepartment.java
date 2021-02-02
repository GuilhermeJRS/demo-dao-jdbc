package applications;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ArrayBlockingQueue;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;
import model.entities.Seller;

public class ProgramDepartment {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

		System.out.println("\n===== TEST 1: department findById =====");
		Department department = null;
		department = departmentDao.findById(1);
		System.out.println(department);

		System.out.println("\n===== TEST 2: department findAll =====");
		for (Department dept : departmentDao.findAll()) {
			System.out.println(dept);
		}

		System.out.println("\n===== TEST 3: department insert =====");
		Department newDepartment = new Department(null, "Administrativo");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted Department Id = " + newDepartment.getId());								

		System.out.println("\n===== TEST 4: department update =====");
		department = departmentDao.findById(2);
		System.out.println("Before Update: " + department);
		department.setName("Suporte");
		departmentDao.update(department);
		System.out.println("After  Update: " + departmentDao.findById(2));

		System.out.println("===== TEST 5: department delete =====");
		departmentDao.deleteById(newDepartment.getId());
		System.out.println("Deleted! ");
	}

}
