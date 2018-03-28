package br.com.springjdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.springjdbc.conf.Database;
import br.com.springjdbc.model.Produto;

public class ProdutoDAO {

	public boolean salvar(Produto produto) {
		int count = 0;
		boolean sucess = false;
		try (Connection con = Database.getConnection()) {

			String sql = "insert into produto (nome, descricao) values (?, ?)";

			try (PreparedStatement stmt = con.prepareStatement(sql)) {
				stmt.setString(1, produto.getNome());
				stmt.setString(2, produto.getDescricao());

				stmt.execute();

				count = stmt.getUpdateCount();

				System.out.println(count);

				if (count > 0) {
					sucess = true;
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return sucess;
	}

	public Produto buscaPorId(Integer id) {
		Produto produto = new Produto();
		try(Connection con = Database.getConnection()) {
			
			String sql = "select * from produto where id = ?";
			
			try(PreparedStatement stmt = con.prepareStatement(sql)) {
				stmt.setInt(1, id);
				
				stmt.execute();
				
				try(ResultSet rs = stmt.getResultSet()) {
					rs.next();
					produto.setId(rs.getInt("id"));
					produto.setNome(rs.getString("nome"));
					produto.setDescricao(rs.getString("descricao"));
				}
				
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return produto;
	}
	
	public List<Produto> listarTodos() {
		List<Produto> produtos = new ArrayList<>();
		
		try(Connection con = Database.getConnection()) {
			
			String sql = "select * from produto";
			
			try(PreparedStatement stmt = con.prepareStatement(sql)) {
				stmt.execute();
				
				try(ResultSet rs = stmt.getResultSet()) {
					while(rs.next()) {
						Produto produto = new Produto(
							rs.getInt("id"),
							rs.getString("nome"),
							rs.getString("descricao")
						);
						
						produtos.add(produto);
					}
				}
				
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return produtos;
	}

	public void remove(Produto produto) {
		try(Connection con = Database.getConnection()) {
			
			String sql = "delete from produto where id = ?";
			
			try(PreparedStatement stmt = con.prepareStatement(sql)) {
				stmt.setInt(1, produto.getId());
				stmt.execute();
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void atualizar(Produto produto) {
		try (Connection con = Database.getConnection()) {

			String sql = "update produto set id= ?, nome = ?, descricao = ? where id = ?";

			try (PreparedStatement stmt = con.prepareStatement(sql)) {
				stmt.setInt(1, produto.getId());
				stmt.setString(2, produto.getNome());
				stmt.setString(3, produto.getDescricao());
				stmt.setInt(4, produto.getId());

				stmt.execute();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}













