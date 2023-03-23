package br.com.sistema.soc.action;

import com.opensymphony.xwork2.ActionSupport;

import br.com.sistema.soc.dao.Admin;

public class DeleteAction extends ActionSupport {

	private static final long serialVersionUID = -146601914103585418L;
	String nome, msg;
	Admin dao = new Admin();

	@Override
	public String execute() throws Exception {
		try {
			int isDeleted = dao.deleteUserDetails(nome);
			if (isDeleted > 0) {
				msg = "Excluído com sucesso!";
			} else {
				msg = "error";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "DELETE";
	}

	public String getUemail() {
		return nome;
	}

	public void setUemail(String nome) {
		this.nome = nome;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
