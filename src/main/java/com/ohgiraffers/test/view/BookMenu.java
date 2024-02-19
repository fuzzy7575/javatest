package com.ohgiraffers.test.view;

import com.ohgiraffers.test.controller.BookManager;
import com.ohgiraffers.test.model.dto.BookDTO;

import java.util.ArrayList;
import java.util.Scanner;

public class BookMenu {

    private BookManager bm = new BookManager();
    Scanner sc = new Scanner(System.in);

    public BookMenu() {

    }
    public BookMenu(BookManager bm) {
        this.bm = bm;
    }

    public void menu() {

        /*

        *** 도서관리 프로그램 ***
        1. 도서 추가
        2. 도서 삭제
        3. 도서 검색
        4. 도서 정렬 출력
        5. 도서 전체 출력
        6. 끝내기

        */

        boolean loop = true;

        while (loop) {

        System.out.println("*** 도서 관리 프로그램 ***");
        System.out.println("1. 도서 추가");
        System.out.println("2. 도서 삭제");
        System.out.println("3. 도서 검색");
        System.out.println("4. 도서 카테고리순 정렬 출력");
        System.out.println("5. 전체 출력");
        System.out.println("6. 끝내기");

        System.out.print("메뉴를 선택하세요.(메뉴 번호 숫자 입력) : ");
        int choiceMenu = sc.nextInt();sc.nextLine();


            switch (choiceMenu) {
                case 1:
                    bm.addBook(inputBook());
                    break;
                case 2:
                    bm.displayAll();

                    System.out.print("삭제할 도서 인덱스번호를 입력하세요.(숫자) : ");
                    int delNo = sc.nextInt();
                    sc.nextLine();

                    bm.deleteBook(delNo);
                    break;
                case 3:
                    bm.printBook(bm.searchBook(inputBookTitle()));
//                    int index = bm.searchBook(inputBookTitle());
//                    bm.printBook(index);
                    break;
                case 4:
                    System.out.println("정렬할 방식을 숫자로 입력하세요.(1:오름차순 / 2:내림차순) : ");
                    int category2 = sc.nextInt();
                    sc.nextLine();

                    bm.printBookList(bm.sortedBookList(category2));
                    break;
                case 5:
                    bm.displayAll();
                    break;
                case 6:
                    System.out.println("종료합니다.");
                    loop = false;
                    break;
                default:
                    System.out.println("잘못 입력 하였습니다.");
                    return;
            }
        }

    }

    public BookDTO inputBook() {

        System.out.print("도서 번호를 입력하세요.(숫자) : ");
        int bNo = sc.nextInt();sc.nextLine();
        System.out.print("도서 카테고리를 숫자로 입력하세요.(1:인문 / 2:자연과학 / 3:의료 / 4:기타) : ");
        int category = sc.nextInt();sc.nextLine();
        System.out.print("도서 제목을 입력하세요. : ");
        String title = sc.nextLine();
        System.out.print("도서 저자를 입력하세요. : ");
        String author = sc.nextLine();

        BookDTO ibArr = new BookDTO(bNo,category, title, author);
        return ibArr;

    }

    public String inputBookTitle() {

        System.out.print("도서 제목을 입력하세요. : ");
        String title = sc.nextLine();

        return title;

    }

}
