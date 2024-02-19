package com.ohgiraffers.test.controller;

import com.ohgiraffers.test.model.dto.BookDTO;
import com.ohgiraffers.test.model.comparator.AscCategory;
import com.ohgiraffers.test.model.comparator.DescCategory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookManager {

    private ArrayList<BookDTO> br = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public BookManager() {
    }

    public BookManager(ArrayList<BookDTO> br) {
        this.br = br;
    }

    public void addBook(BookDTO book) {

        br.add(book);

    }

    public void deleteBook(int delNo) {

//        displayAll();
//
//        System.out.print("삭제할 도서 번호를 입력하세요.(숫자) : ");
//        int delNo = sc.nextInt(); sc.nextLine();

        br.remove(delNo);

    }

    public int searchBook(String title) {

        int result = 0;
        for(BookDTO book : br) {
            if(book.getTitle().contains(title)) {
//                System.out.println(book);
                result = book.getbNo();
            } else {
//                System.out.println("조회된 도서가 목록에 없습니다.");
                result = 0;
            }
        }
        return result;

    }

    public void printBook(int index) {
        if(index == 0 ) {
            System.out.println("조회된 도서가 목록에 없습니다.");
        } else {
            System.out.println(br.toString());
        }

    }

    public void displayAll() {

        for(BookDTO book : br) {
            System.out.println(book.toString());
        }

    }

    public ArrayList<BookDTO> sortedBookList(int select) {

        switch (select) {
            case 1 :
                br.sort(new AscCategory());
            break;
            case 2 :
                br.sort(new DescCategory());
            break;
        }
        return br;

    }

    public void printBookList(ArrayList<BookDTO> br) {

        for(BookDTO book : br) {
            System.out.println(book.toString());
        }

    }

}
