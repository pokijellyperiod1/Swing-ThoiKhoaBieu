package javaproject_original;

import java.util.Scanner;

public class NhanVien {

	private int id;
	private String name;
	private int age;
	
	public NhanVien() {
		// TODO Auto-generated constructor stub
	}
	
	

	public NhanVien(int id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}
	
	public void nhap() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Id: ");
		this.id = sc.nextInt();
		sc.nextLine();
		System.out.println("Name:");
		this.name = sc.nextLine();
		System.out.println("Age:");
		this.age = sc.nextInt();
		
	}
	
	public void hienThi() {
		System.out.println("Id: " + id + ", Name: " + name + ", Age: " + age);
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
	
}
