package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Funcionarios;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		List<Funcionarios> list = new ArrayList<>();
		
		System.out.print("Quantos funcionario serão registrados? ");
		int n = sc.nextInt();
		
		for(int i = 0; i < n; i++) {
			System.out.println("Funcionario #" + (i+1) + ":");
			System.out.print("ID: ");
			int id = sc.nextInt();
			while(hasId(list, id)) {
				System.out.println("Esse ID ja existe. Coloque outro: ");
				id = sc.nextInt();
			}
			System.out.print("Nome: ");
			sc.nextLine();
			String nome = sc.nextLine();
			
			System.out.print("Salario: ");
			Double salario = sc.nextDouble();
			
			list.add(new Funcionarios(id, nome,salario));
		}
		
		System.out.println();
		
		System.out.print("Coloque o ID do funcionario que recebera aumento: ");
		int id = sc.nextInt();
		
		Funcionarios funcionario = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		if(funcionario == null) {
			System.out.println("ID não existe.");
		}
		else {
			System.out.print("Qual porcentagem do aumento: ");
			Double porcentagem = sc.nextDouble();
			funcionario.aumento(porcentagem);
		}
		
		System.out.println();
		System.out.println("Lista de funcionarios:");
		for(Funcionarios func : list) {
			System.out.println(func);
		}
		sc.close();
	}

	public static boolean hasId(List<Funcionarios> list, int id) {
		Funcionarios funcionario = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return funcionario != null;
	}

}
