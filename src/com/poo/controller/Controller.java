package com.poo.controller;


import java.util.ArrayList;
import java.util.List;

import com.poo.dao.AlunoDAO;
import com.poo.model.Aluno;

public class Controller {
	
	public String create(Aluno aluno) {
		try {
			AlunoDAO dao = new AlunoDAO();
			dao.create(aluno);
			return "Fim da inserção!";
		} 
		catch (Exception e){
			return "Erro ao criar!!!!!!!!!!!!";
		}
	}
	public List<Aluno> readAll(){
		List<Aluno> alunos =new ArrayList<Aluno>();
		
		AlunoDAO dao = new AlunoDAO();
		alunos = dao.readAll();
		
		return alunos;
	}
	public String update(Aluno aluno) {
		try {
			AlunoDAO dao = new AlunoDAO();
			dao.update(aluno);
			return "Fim da Alteração!";
		}
		catch(Exception e) {
			return "Erro ao alterar!!!!!!!!!!!!";
		}
		
	}
	public String delete(Aluno aluno) {
		try {
			AlunoDAO dao = new AlunoDAO();
			dao.delete(aluno);
			return "Aluno deletado!";
		}
		catch(Exception e) {
			return "Erro deletar!!!!!!!!!!!!";
		}
	}

}
