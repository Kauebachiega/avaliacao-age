package br.com.sistema.soc.action;

import java.sql.ResultSet;

import com.opensymphony.xwork2.ActionSupport;

import br.com.sistema.soc.dao.Admin;

	public class UpdateAction extends ActionSupport {

		private static final long serialVersionUID = -1905974197186620917L;
		private String codigo = "", nome = "", funcao = "", codigohidden = "";
		private String msg = "";
		ResultSet rs = null;
		Admin dao = new Admin();
		String submitType;

		@Override
		public String execute() throws Exception {
			try {
				if (submitType.equals("updatedata")) {
					rs = dao.fetchUserDetails(nome.trim());
					if (rs != null) {
						while (rs.next()) {
							codigo = rs.getString("codigo");
							nome = rs.getString("nome");
							funcao = rs.getString("funcao");
							//udeg = rs.getString("UDEG");
						}
					}
				} else {
					int i = dao.updateUserDetails(codigo, nome, funcao, codigohidden);
					if (i > 0) {
						msg = "Alterado com sucesso!";
					} else {
						msg = "error";
					}
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			return "UPDATE";
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

		public void setnome(String nome) {
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

		public String getCodigohidden() {
			return codigohidden;
		}

		public void setCodigohidden(String codigohidden) {
			this.codigohidden = codigohidden;
		}

		public String getSubmitType() {
			return submitType;
		}

		public void setSubmitType(String submitType) {
			this.submitType = submitType;
		}
	}

