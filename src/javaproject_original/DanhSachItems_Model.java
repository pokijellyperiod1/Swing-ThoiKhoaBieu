package javaproject_original;

import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author TanKy
 */
public class DanhSachItems_Model {
    
    String id;
    long row;
    long colum;
    Object content;

    public DanhSachItems_Model() {
    }

    public DanhSachItems_Model(int row, int colum, Object content) {
        this.row = row;
        this.colum = colum;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public long getRow() {
        return row;
    }

    public void setRow(long row) {
        this.row = row;
    }

    public long getColum() {
        return colum;
    }

    public void setColum(long colum) {
        this.colum = colum;
    }
    
    public void nhap(){
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Nhap Id: ");
        this.id = sc.nextLine();
        System.out.println("Nhap Row: ");
        this.row = sc.nextInt();
        System.out.println("Nhap Column: ");
        this.colum = sc.nextInt();
        sc.nextLine();
        System.out.println("Nhap Noi Dung: ");
        this.content = sc.nextLine();
        
        
    }
    
    
    public void hienThi(){
        System.out.println("Id: " + id);
        System.out.println("Row: " + row);
        System.out.println("Column" + colum);
        System.out.println("Content: " + content);
    }
    
    
    
    
}
