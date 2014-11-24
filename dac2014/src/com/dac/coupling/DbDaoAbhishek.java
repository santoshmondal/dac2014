package com.dac.coupling;

import java.util.ArrayList;
import java.util.List;

public class DbDaoAbhishek extends DbDao {

	@Override
	public List<String> listUser() {
		List<String> list = new ArrayList<String>();
		list.add("Abhishek");
		return list;
	}

	@Override
	public String getUser() {
		return "Abhishek Bachhan";
	}

}
