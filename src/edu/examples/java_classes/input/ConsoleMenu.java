package edu.examples.java_classes.input;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import edu.examples.java_classes.dao.*;
import edu.examples.java_classes.entity.Note;
import edu.examples.java_classes.logic.NotebookLogic;

@SuppressWarnings("resource")
public class ConsoleMenu {

	public void print() {

		System.out.println("----- Notebook welcomes you !-----");
		System.out.println();
		System.out.println("To add a note print - 1    To find a note print - 2");
		System.out.print("> ");

		Scanner sc = new Scanner(System.in);
		int temp = sc.nextInt();

		switch (temp) {
		case 1:
			NotebookLogic logic = new NotebookLogic();
			create();
			break;
		case 2:
			System.out.println("Enter the text:");
			System.out.print("> ");
			Scanner tr = new Scanner(System.in);
			String text = tr.nextLine();
			find(text);
			break;
		default:
			System.out.println("Choose the correct option");
		}
	}

	public NotebookLogic create() {

		System.out.println("Create a title:");
		System.out.print("> ");
		Scanner sca = new Scanner(System.in);
		String title1 = sca.nextLine();

		System.out.println("Create a content:");
		System.out.print("> ");
		Scanner scan = new Scanner(System.in);
		String content1 = scan.nextLine();
		NotebookLogic logic = new NotebookLogic();
		logic.add(title1, content1);
		return logic;
	}

	public List<Note> find(String text1) {

		List<Note> result = new ArrayList<Note>();

		NoteBookDao dao = new NoteBookDao();
		List<Note> myNotes = dao.allNotes();

		for (Note n : myNotes) {
			if (isTextInNote(n, text1)) {
				result.add(n);
			}
		}

		System.out.println(result);
		return result;

	}

	private boolean isTextInNote(Note n, String text) {
		return n.getTitle().contains(text) || n.getContent().contains(text);
	}
}
