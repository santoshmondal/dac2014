package com.dac.coupling;

import java.util.List;

public class Manager {
	private DbDao dbdao;
	
	public List<String> listUser() {
		return dbdao.listUser();
	}
	
	public String getUser(){
		return dbdao.getUser();
	}

	public DbDao getDbdao() {
		return dbdao;
	}

	public void setDbdao(DbDao dbdao) {
		this.dbdao = dbdao;
	}
	
	
	
}
