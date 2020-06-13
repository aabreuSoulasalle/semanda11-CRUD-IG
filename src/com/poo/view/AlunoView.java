package com.poo.view;

import java.sql.Connection;
import java.util.Scanner;

import com.poo.controller.Controller;
import com.poo.jdbc.ConnectionFactory;
import com.poo.model.Aluno;

public class AlunoView {
	public void create() {
		try {
			Scanner sc = new Scanner(System.in);
			
			Aluno aluno = new Aluno();
			Controller controller = new Controller();

			System.out.print("Entre com a nova matricula:");
			aluno.setMatricula(sc.nextLine());

			System.out.print("Entre com o novo Nome:");
			aluno.setNome(sc.nextLine());
			
			controller.create(aluno);
		} catch (Exception e){
			System.out.println("Erro na tela de incluir o aluno");
		}
	}
	
	public void readAll() {
		Controller controller = new Controller();
		
		System.out.println("Listagem de Alunos");
		System.out.println("___________________");
		
		for(Aluno aluno:controller.readAll()) {
			System.out.println("Matricula: " +aluno.getMatricula() +"  Nome: " +aluno.getNome());
			
		}
	}
	
	public void update() {
		try {
			Scanner sc = new Scanner(System.in);
			
			Aluno aluno = new Aluno();
			Controller controller = new Controller();
			
			System.out.print("Entre com a matricula que deseja alterar:");
			aluno.setMatricula(sc.nextLine());

			System.out.print("Entre com o Nome que deseja alterar:");
			aluno.setNome(sc.nextLine());
			controller.update(aluno);
		}
		catch(Exception e) {
			System.out.println("Erro na tela de alterar o aluno");
		}	
	}
	
	public void delete() {
		try {
			Scanner sc = new Scanner(System.in);
			
			Aluno aluno = new Aluno();
			Controller controller = new Controller();
			
			System.out.print("Entre com a matricula que deseja deletar:");
			aluno.setMatricula(sc.nextLine());

			System.out.print("Entre com o Nome que deseja deletar:");
			aluno.setNome(sc.nextLine());
			controller.delete(aluno);
		}
		catch(Exception e) {
			System.out.println("Erro na tela de alterar o aluno");
		}	
	}
	/*
	public static void main(String[] args) {
		/*
		AlunoView aluno = new AlunoView();
		aluno.create();
		aluno.readAll();
		aluno.update();
		aluno.readAll();
		aluno.delete();
		aluno.readAll();
		
		
		
		
		Tela janela = new Tela();
	}*/

}
