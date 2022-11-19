package com.masai.dao;

import com.masai.bean.product;
import com.masai.emutil.EMUtil;

public class ProductDaoImpl implements ProductDao {

	public product searchProduct(int productId) {
		// TODO Auto-generated method stub
		return EMUtil.provideEntityManage().find(product.class, productId);
	}

}
