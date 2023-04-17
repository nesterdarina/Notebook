package edu.examples.java_classes.start;

import java.util.List;

import edu.examples.java_classes.entity.Note;
import edu.examples.java_classes.input.ConsoleMenu;
import edu.examples.java_classes.logic.NotebookLogic;
import edu.examples.java_classes.output.NotebookOutput;

public class Main {

	public static void main(String[] args) {
		NotebookLogic logic = new NotebookLogic();	
		logic.add("red", "blue");
		logic.add("green", "yellow");
		logic.add("white", "black");
								
		List<Note> myNotes = logic.allNotes();
		NotebookOutput output = new NotebookOutput();
		output.print("all notes", myNotes);
		
		ConsoleMenu menu = new ConsoleMenu();
		menu.print();
		
		output.print("all notes", myNotes);
		menu.print();
	}

}
