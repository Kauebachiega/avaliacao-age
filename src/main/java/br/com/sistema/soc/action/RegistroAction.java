package br.com.sistema.soc.action;

import com.opensymphony.xwork2.ActionSupport;

import br.com.sistema.soc.dao.Admin;

public class RegistroAction extends ActionSupport {
	
	
	private String codigo, nome, funcao;
	private String msg = "";
	Admin admin = null;
	int ctr = 0;
	
	@Override
	public String execute() throws Exception {
		admin = new Admin();
	
		try {
			ctr = admin.registerUser(codigo, nome, funcao);
			if (ctr > 0) {
				msg = "Registrado com sucesso!";
			} else {
				msg = ""
						+ "Erro";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "REGISTRADO";
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getCtr() {
		return ctr;
	}

	public void setCtr(int ctr) {
		this.ctr = ctr;
	}
}

