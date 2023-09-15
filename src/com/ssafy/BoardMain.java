package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.board.model.BoardDto;
import com.ssafy.board.model.service.BoardServiceImpl;

public class BoardMain {

	private BufferedReader in;

	public BoardMain() {
		in = new BufferedReader(new InputStreamReader(System.in));
		menu();
	}

	private void menu() {
		while (true) {
			System.out.println("---------- 게시판 메뉴 ----------");
			System.out.println("1. 글등록");
			System.out.println("2. 글목록(전체)");
			System.out.println("3. 글검색(제목)");
			System.out.println("4. 글보기");
			System.out.println("5. 글수정");
			System.out.println("6. 글삭제");
			System.out.println("-------------------------------------");
			System.out.println("0. 프로그램 종료");
			System.out.println("-------------------------------------");
			System.out.print("메뉴 선택 : ");
			try {
				int num = Integer.parseInt(in.readLine());
				switch (num) {
				case 1:
					registerArticle();
					break;
				case 2:
					searchListAll();
					break;
				case 3:
					searchListBySubject();
					break;
				case 4:
					viewArticle();
					break;
				case 5:
					modifyArticle();
					break;
				case 6:
					deleteArticle();
					break;
				default:
					System.out.println("프로그램을 종료합니다!!!");
					System.exit(0);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void registerArticle() throws IOException {
		BoardDto board = new BoardDto();

		System.out.println("===== 글 등록 =====");
		System.out.print("제목 : ");
		board.setSubject(in.readLine());
		System.out.print("내용 : ");
		board.setContent(in.readLine());
		board.setUserId("ssafy");

		BoardServiceImpl.getInstance().registerArticle(board);

		System.out.println("글 등록 완료.");
	}

	private void searchListAll() {
		List<BoardDto> list = new ArrayList<BoardDto>();

		System.out.println("===== 글 검색(전체) =====");
		list = BoardServiceImpl.getInstance().searchListAll();

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

	private void searchListBySubject() throws IOException {
		List<BoardDto> list = new ArrayList<BoardDto>();

		System.out.println("===== 글 검색(제목) =====");
		System.out.print("검색할 제목 : ");
		String subject = in.readLine();
		list = BoardServiceImpl.getInstance().searchListBySubject(subject);

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

	private void viewArticle() throws IOException {
		System.out.println("===== 글 보기 =====");
		System.out.print("번호 : ");
		int no = Integer.parseInt(in.readLine());

		BoardDto board = BoardServiceImpl.getInstance().viewArticle(no);
		System.out.println(board);
	}

	private void modifyArticle() throws NumberFormatException, IOException {
		BoardDto board = new BoardDto();

		System.out.println("===== 글 수정 =====");
		System.out.print("번호 : ");
		board.setArticleNo(Integer.parseInt(in.readLine()));
		System.out.print("제목 : ");
		board.setSubject(in.readLine());
		System.out.print("내용 : ");
		board.setContent(in.readLine());

		BoardServiceImpl.getInstance().modifyArticle(board);

		System.out.println("글 수정 완료");
	}

	private void deleteArticle() throws IOException {
		System.out.println("===== 글 삭제 =====");
		System.out.print("번호 : ");
		int no = Integer.parseInt(in.readLine());

		BoardServiceImpl.getInstance().deleteArticle(no);

		System.out.println("글 삭제 완료");
	}

	public static void main(String[] args) {
		new BoardMain();
	}
}
