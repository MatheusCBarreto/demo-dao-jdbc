package main;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("=== TEST 1: seller findById === ");
        Seller seller = sellerDao.findById(3);

        System.out.println(seller);

        System.out.println("\n === TEST 2: seller findByDepartment === ");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        for (Seller sel : list) {
            System.out.println(sel);
        }

        System.out.println("\n === TEST 3: seller findAll === ");
        List<Seller> otherList = sellerDao.findAll();
        for (Seller sel : otherList) {
            System.out.println(sel);
        }

        System.out.println("\n === TEST 4: seller insert === ");
        Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 1700.0, department);
        sellerDao.insert(newSeller);
        System.out.println("Inserido! Novo ID = " + newSeller.getId());

    }
}