package com.poo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.poo.jdbc.ConnectionFactory;
import com.poo.model.Aluno;

public class AlunoDAO {
	public void create(Aluno aluno)
	{
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		String sql = "insert into aws(matricula, name) values (?, ?)";
		
		
		try {
			
			
			stmt = con.prepareStatement(sql);  //instancia uma instrucao sql
			stmt.setString(1, aluno.getMatricula()); //primeiro parametro da query
			stmt.setString(2, aluno.getNome()); //segundo parametro
			
			stmt.executeUpdate();
			System.out.println("[AlunoDAO] Aluno incluido com sucesso");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
		
		
		
		
	}
	
	public List<Aluno> readAll() {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select matricula, name from aws";
		
		List<Aluno> alunos = new ArrayList<Aluno>();

		
		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			if(rs != null) {
				
				while(rs.next()) {
					
					Aluno aluno = new Aluno();
					aluno.setMatricula(rs.getString("matricula"));
					aluno.setNome(rs.getString("name"));
					
					alunos.add(aluno);
					}
				}
			else {
				System.out.println("Veio vazio!");
				}
			} 
			catch(SQLException e) {
				System.out.println("!!!!!Erro ao tentar ler a tabela aws!!!!!!!!!!");
			} 
			finally {
				ConnectionFactory.closeConnection(con, stmt, rs);
			}
			return alunos;
		}

	public void update(Aluno aluno) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		String sql = "update aws set matricula = ?, name = ? where matricula = ? or name = ?";
		
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, aluno.getMatricula());
			stmt.setString(2, aluno.getNome());
			stmt.setString(3, aluno.getMatricula());
			stmt.setString(4, aluno.getNome());
			
			stmt.executeUpdate();
			
		}
		catch(SQLException e){
			System.out.println("!!!!!Erro ao tentar fazer update na tabela aws!!!!!!!!!!");
		}
		finally {
			ConnectionFactory.closeConnection(con);
		}
		
	}
	public void delete(Aluno aluno) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;

		String sql = "delete from aws where matricula = ? or name = ?";
		
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, aluno.getMatricula());
			stmt.setString(2, aluno.getNome());
			
			stmt.executeUpdate();
		}
		catch(SQLException e){
			System.out.println("!!!!!Erro ao tentar deletar na tabela aws!!!!!!!!!!");
		}
		finally {
			ConnectionFactory.closeConnection(con);
		}
	}

}
