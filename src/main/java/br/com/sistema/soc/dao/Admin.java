package br.com.sistema.soc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Admin {

	
	public static Connection getConnection( )throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306", "root", "44266890");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	//metodo para salvar no bacno de dados
	public int registerUser(String codigo, String nome, String funcao) throws Exception {
		int i = 0;
		try {
			String sql = " INSERT INTO FUNCIONARIO VALUES(?,?,?)";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, codigo);
			ps.setString(2, nome);
			ps.setString(3, funcao);
			i = ps.executeUpdate();
			return i;
		}catch (Exception e) {
			e.printStackTrace();
			return i;
		} finally {
			if (getConnection() != null) {
				getConnection().close();
			}
		}
	}
	
	public ResultSet report() throws SQLException, Exception{
		ResultSet rs = null;
		try {
			String sql = "SELECT codigo, nome, funcao FROM funcionario";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			rs = ps.executeQuery();
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (getConnection() != null) {
				getConnection().close();
				
			}
		}
	}	
		public ResultSet fetchUserDetails(String nome) throws SQLException, Exception {
			ResultSet rs = null;
			try {
				String sql = "SELECT codigo,nome,funcao, FROM funcionario WHERE nome=?";
				PreparedStatement ps = getConnection().prepareStatement(sql);
				ps.setString(1, nome);
				rs = ps.executeQuery();
				return rs;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			} finally {
				if (getConnection() != null) {
					getConnection().close();
				}
			}
		}
			public int updateUserDetails(String codigo, String nome, String funcao, String codigohidden) throws SQLException, Exception {
				getConnection().setAutoCommit(false); 
				int i = 0;
				try {
					String sql = "UPDATE funcionario SET nome=?,funcao=? WHERE nome=?";
					PreparedStatement ps = getConnection().prepareStatement(sql);
					ps.setString(1, codigo);
					ps.setString(2, nome);
					ps.setString(3, funcao);
					ps.setString(4, codigohidden);
					i = ps.executeUpdate();
					return i;
				} catch (Exception e) {
					e.printStackTrace();
					getConnection().rollback();
					return 0;
				} finally {
					if (getConnection() != null) {
						getConnection().close();
					}
				}
			}
				public int deleteUserDetails(String codigo) throws SQLException, Exception {
					getConnection().setAutoCommit(false);
					int i = 0;
					try {
						String sql = "DELETE FROM funcionario WHERE codigo=?";
						PreparedStatement ps = getConnection().prepareStatement(sql);
						ps.setString(1, codigo);
						i = ps.executeUpdate();
						return i;
					} catch (Exception e) {
						e.printStackTrace();
						getConnection().rollback();
						return 0;
					} finally {
						if (getConnection() != null) {
							getConnection().close();
						}
					}
		
	}
	
}