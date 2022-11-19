package com.masai.usecases;

import java.util.Scanner;

import com.masai.bean.product;
import com.masai.dao.ProductDao;
import com.masai.dao.ProductDaoImpl;

public class GetProduct {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter productid to search");
		int pId = sc.nextInt();
		
		ProductDao dao = new ProductDaoImpl();
		
		product p = dao.searchProduct(pId);
		System.out.println(p);
	}
}
