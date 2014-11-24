package com.dac.coupling;

import java.util.ArrayList;
import java.util.List;

public class DbDaoRohit  extends DbDao {

	@Override
	public List<String> listUser() {
		List<String> list = new ArrayList<String>();
		list.add("ROHIT");
		return list;
	}

	@Override
	public String getUser() {
		return "ROHIT SHARMA";
	}

}
