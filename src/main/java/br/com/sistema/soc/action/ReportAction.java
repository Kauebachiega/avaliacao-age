package br.com.sistema.soc.action;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import br.com.sistema.soc.dao.Admin;
import br.com.sistema.soc.parametro.Param;

public class ReportAction extends ActionSupport {

	
	ResultSet rs = null;
	Param bean = null;
	List<Param> beanList = null;
	Admin admin = new Admin();
	private boolean noData = false;
	
	@Override
	public String execute() throws Exception {
		try {
			beanList = new ArrayList<Param>();
			rs = admin.report();
			int i = 0;
			if (rs != null) {
				while (rs.next()) {
					i++;
					Param bean = new Param();
					bean.setSrNo(i);
					bean.setCodigo(rs.getString("codigo"));
					bean.setNome(rs.getString("nome"));
					//bean.setUpass(rs.getString("UPASS").replaceAll("(?s).", "*"));
					bean.setFuncao(rs.getString("funcao"));
					beanList.add(bean);
				}
			}
			if (i == 0) {
				noData = false;
			} else {
				noData = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "REPORT";
	}

	public boolean isNoData() {
		return noData;
	}

	public void setNoData(boolean noData) {
		this.noData = noData;
	}

	public List<Param> getBeanList() {
		return beanList;
	}

	public void setBeanList(List<Param> beanList) {
		this.beanList = beanList;
	}
}

