package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class Main extends Application {
	
	// the project has two section: 1- valid equation. 2-invalid equation. so there well be two string represent two section
	private StringBuilder Section1 = new StringBuilder(); // store the valid equation section while reading the file
	private StringBuilder Section2 = new StringBuilder(); // store the invalid equation section while reading the file
//	private String string3 = "";
	private boolean flag;
		
	// Button object
	Button LoadButton = new Button("Load File");
	Button ValidButton = new Button("Vaild equation");
	Button InvalidButton = new Button("Invaild equation");
	Button FileButton = new Button("Sent File");
	Button ClearButton = new Button("Clear");
	
	// Separator object
	Separator hs = new Separator();
	Separator vs1 = new Separator(Orientation.VERTICAL);
	Separator vs2 = new Separator(Orientation.VERTICAL);
	
	// TextArea object
	TextArea ta = new TextArea();
	
	// Label object
	Label LoadSuccefullyLabel = new Label();
	
	//  TextField object
	TextField tf = new TextField();
	
	//////////////////////////   Begin Start Method     //////////////////////////
	@Override
	public void start(Stage stage) {
		
		// Button Format
		LoadButton.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(3), new BorderWidths(2))));
		LoadButton.setBackground(new Background(new BackgroundFill(Color.valueOf("#a29bfe"), new CornerRadii(3), Insets.EMPTY)));
		LoadButton.setTextFill(Color.valueOf("#ffffff"));
		LoadButton.setFont(new Font("Arial",14));
		
		ValidButton.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(3), new BorderWidths(2))));
		ValidButton.setBackground(new Background(new BackgroundFill(Color.valueOf("#ecf0f1"), new CornerRadii(3), Insets.EMPTY)));
		ValidButton.setTextFill(Color.valueOf("#2c3e50"));
		ValidButton.setFont(new Font("Arial",13));
		
		InvalidButton.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(3), new BorderWidths(2))));
		InvalidButton.setBackground(new Background(new BackgroundFill(Color.valueOf("#ecf0f1"), new CornerRadii(3), Insets.EMPTY)));
		InvalidButton.setTextFill(Color.valueOf("#2c3e50"));
		InvalidButton.setFont(new Font("Arial",13));
		
		FileButton.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(3), new BorderWidths(2))));
		FileButton.setBackground(new Background(new BackgroundFill(Color.valueOf("#ecf0f1"), new CornerRadii(3), Insets.EMPTY)));
		FileButton.setTextFill(Color.valueOf("#2c3e50"));
		FileButton.setFont(new Font("Arial",13));
		
		ClearButton.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(3), new BorderWidths(2))));
		ClearButton.setBackground(new Background(new BackgroundFill(Color.valueOf("#ecf0f1"), new CornerRadii(3), Insets.EMPTY)));
		ClearButton.setTextFill(Color.valueOf("#2c3e50"));
		ClearButton.setFont(new Font("Arial",13));
		
		// Button Size
		ValidButton.setMaxWidth(120);
		InvalidButton.setMaxWidth(120);
		FileButton.setPrefWidth(120);
		ClearButton.setMaxWidth(90);
		
		// Separator Fromat
		hs.setPrefHeight(12);
		
		// TextArea Size
		ta.setMaxWidth(400);
		
		// TextField Size
		tf.setMaxWidth(80);
		tf.setDisable(true);
	
		
		HBox hb1 = new HBox(10);
		hb1.getChildren().addAll(ValidButton, vs1, InvalidButton, vs2, FileButton, tf);
		
		VBox vb = new VBox(5);
		vb.getChildren().addAll(LoadButton, LoadSuccefullyLabel, hs, hb1, ta, ClearButton);
		LoadButton.setTranslateX(150);
		
		Group root = new Group();
		root.getChildren().addAll(vb);
		root.setTranslateX(20);
		
		Scene scene = new Scene(root,520,400);
		
		stage.setTitle("Project #2");
		stage.setScene(scene);
		stage.show();
		
		// Button Effect
		DropShadow shadow = new DropShadow(10, Color.valueOf("#6c5ce7"));
		
		ValidButton.addEventHandler(MouseEvent.MOUSE_ENTERED, e -> {
			ValidButton.setEffect(shadow);
			ValidButton.setTextFill(Color.valueOf("#6c5ce7"));
		});
		
		ValidButton.addEventHandler(MouseEvent.MOUSE_EXITED, e -> {
			ValidButton.setEffect(null);
			ValidButton.setTextFill(Color.valueOf("#2c3e50"));
		});
		
		// InvaildButton Effect
		InvalidButton.addEventHandler(MouseEvent.MOUSE_ENTERED, e -> {
			InvalidButton.setEffect(shadow);
			InvalidButton.setTextFill(Color.valueOf("#6c5ce7"));
		});
		
		InvalidButton.addEventHandler(MouseEvent.MOUSE_EXITED, e -> {
			InvalidButton.setEffect(null);
			InvalidButton.setTextFill(Color.valueOf("#2c3e50"));
		});
		
		// FileButton Effect
		FileButton.addEventHandler(MouseEvent.MOUSE_ENTERED, e -> {
			FileButton.setEffect(shadow);
			FileButton.setTextFill(Color.valueOf("#6c5ce7"));
		});
		
		FileButton.addEventHandler(MouseEvent.MOUSE_EXITED, e -> {
			FileButton.setEffect(null);
			FileButton.setTextFill(Color.valueOf("#2c3e50"));
		});
		
		ClearButton.addEventHandler(MouseEvent.MOUSE_ENTERED, e -> {
			ClearButton.setEffect(shadow);
			ClearButton.setTextFill(Color.valueOf("#6c5ce7"));
		});
		
		ClearButton.addEventHandler(MouseEvent.MOUSE_EXITED, e -> {
			ClearButton.setEffect(null);
			ClearButton.setTextFill(Color.valueOf("#2c3e50"));
		});
		
		 					////////   Button Actions     ////////
		
		LoadButton.setOnAction(e -> { // LoadButton action, call ReadFileContent() method to read the file
			try {
				if(flag == false) {
					ReadFileContent();
					flag = true;
				}
			}
			catch(Exception ex) {
				
			}
		});
		
		ValidButton.setOnAction(e -> { // ValidButton action
			if(flag == true) {
//				VaildEquation();
				ta.setText(Section1.toString());
			}
			else
				new Alert(AlertType.WARNING, "File not loading!!!").show();
//			ta.setText(string1);
		});
		
		InvalidButton.setOnAction(e -> {  // InvalidButton action 
			if(flag == true) {
				ta.setText(Section2.toString());
			}
			else
				new Alert(AlertType.WARNING, "File not loading!!!").show();
		});
		
		ClearButton.setOnAction(e -> { // ClearButton action
			if(!ta.getText().isEmpty())
				ta.setText(" ");
			else
				new Alert(AlertType.WARNING, "TextArea is Empty!!!").show();
		});
		
		FileButton.setOnAction(e -> { // FileButton action
			if(flag == true) {
				try {
					WriteToFile();
				}
				catch(Exception ex) {
					
				}
			}
			else
				new Alert(AlertType.WARNING, "File not loading!!!").show();
		});
		
		
	}
	//////////////////////////End Start Method     //////////////////////////
		
	private void WriteToFile() throws Exception{ // print all equation(valid and invalid) to the file by user
		String filename = tf.getText().trim();
		if(!filename.isEmpty()) {
			if(!filename.endsWith(".txt"))
				filename += ".txt";
			BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
			bw.write(Section1.toString());
			bw.write(Section2.toString());
			bw.close();
			Alert alert = new Alert(AlertType.INFORMATION, "Please Refresh your Project Explorer to see your ("+tf.getText()+") File");
			alert.setHeaderText("Equations Transfer Succefully");
			alert.show();
			tf.setText(" ");
		}
		else
			new Alert(AlertType.WARNING, "TextField is Empty!!!").show();
	} // end method
	
	private boolean areEqaul(double first, double seconed) { // return true if two valid equation result are equal else return false 
		return first == seconed;
	}
	
	
	private String infixToPostfix(String infix) { // turn the infix form to Postfix form
		String Postfix = ""; // string to store Postfix form
		Stack<Character> s = new Stack<>();
		String str = infix; // string represent the parameter string(infix), it's easier to get whole number digit by cut character in every round of loop 
		for(int i = 0 ; i < infix.length() ; i++) {
			char ch = infix.charAt(i);
			if(Character.isDigit(ch)) { // if this character is a (digit) then walk on it until reach character (!digit), to take whole number
				String st = str.substring(0, lastindex(str)); // store the whole number 
				Postfix += st+" ";
				str = str.substring(st.length()); // after take the whole number, cut the str string by that number length
				i += st.length()-1; // raise the counter to skip the number
			}
			else {
				switch(ch) {
					case '^' : s.push(ch);
						break;
					case '+' : case '-' : case '*' : case '/' :
						while(!s.isEmpty() && s.peek() != '(' && s.peek() != '{' && s.peek() != '[' && isHigher(ch) <= isHigher(s.peek()) )
							Postfix += s.pop()+" ";
						s.push(ch);
						str = str.substring(1);
						break;
					case '(': case '[' : case '{' :
						s.push(ch);
						str = str.substring(1);
						break;
					case ')': case ']': case '}':
						char top = s.pop();
						str = str.substring(1);
						while(top != close(ch)) {
							Postfix += top+" ";
							top = s.pop();
						}
						break;
					default : break;
				}
			}
		}
		while(!s.isEmpty()) {
			char top = s.pop();
			Postfix += top+" ";
		}
		return Postfix;
	} // end method
	
	private int lastindex(String str) { // return the last digit index of the whole number, if the number just one column return 1
		int index = 0; // if str(string) is number then return str.length. example str = 12 then return 2, to cut from 0-2
		for(int i = 0 ; i < str.length() ; i++) {
			index = i;
			if(!Character.isDigit(str.charAt(i)) )
					return i;
		}
		return index == str.length() - 1? index+1 : 1; // return one when the number is just one digit
	} // end method
	
	private char close(char ch) { // take the open brackets and return their perfect close perfect else return nothing
		switch(ch) {
			case ')' : return '(';
			case '}' : return '{';
			case ']' : return '[';
		}
		return ' ';
	} // end method
	
	private int isHigher(char ch) { // return the bracket priority
		switch(ch) {
			case '+': case '-': 
			return 1;
	
			case '*': case '/':
			return 2;
		}
		return -1;
	} // end method
	
	private boolean isOperator(char ch) { // return true if the parameter is operand else return false
		switch(ch) {
			case '*': case '/': case '^': case '-': case '+':
			return true;	
		}
		return false;
	} // end method
	
	private double SolvePostfix(String exp) {  // Solve the Postfix Expression
		String str = exp;
		Stack<Double> s = new Stack();
		for(int i = 0 ; i < exp.length() ; i++) {
			if(exp.charAt(i) == 32)
				continue;
			if(Character.isDigit(exp.charAt(i))) {
				String string = str.substring(0, str.indexOf(" ")).trim();
				s.push((double)Integer.parseInt(Integer.parseInt(string)+""));
				i += string.length();
				str = str.substring(string.length()).trim();
			}
			else {
				s.push(Value(s.pop(), exp.charAt(i), s.pop()));
				str = str.substring(1).trim();
			}
		} 
		return s.pop();
	}// end method
	
	private double Value(double first, char op, double second) { // return the result to solvePostfix
		switch(op) {
			case '+': return second + first;
			case '-': return second - first;
			case '/': return second / first;
			case '*': return second * first;
			case '^': return Math.pow(second, first);
		}
		return -1;
	} // end method
	
	private void ReadFileContent() throws Exception{ // Read File Content method
		File file = new File("ReadFile.txt");
		
		if(file.exists()) {
			System.out.println("yahooooooooooooooooooo!!!!");
			LoadSuccefullyLabel.setText("Load Succefully");
			LoadSuccefullyLabel.setFont(new Font("Arial", 11));
			LoadSuccefullyLabel.setTranslateX(150);
			LoadSuccefullyLabel.setTextFill(Color.BLUE);
			tf.setDisable(false);
			Scanner in = new Scanner(file);
			while(in.hasNext()) 
				WhichOne(in.nextLine());
		}
		else
			new Alert(AlertType.WARNING, "File not Found!!!").show();
	} // end method
	 
	private void WhichOne(String line) { // put every line in the file to his string section(string1 or string2)
		String [] str = line.split("=");
		String first = str[0].trim();
		String second = str[1].trim();
		boolean isFirstBalanced = isBalanced(first);
		boolean isSecondBalanced = isBalanced(second);
		if(isFirstBalanced && isSecondBalanced) {
			String postfix1 = infixToPostfix(first.replaceAll(" ", "").trim());
			String postfix2 = infixToPostfix(second.replaceAll(" ", "").trim());
			double postfixint1 = SolvePostfix(postfix1);
			double postfixint2 = SolvePostfix(postfix2);
			Section1.append("[ "+postfix1+" = "+postfixint1+" ] "+" =? "+ " [ "+postfix2+" = "+postfixint2+" ] -> "+areEqaul(postfixint1,postfixint2)+"\n");
		}
		else if(!isFirstBalanced && isSecondBalanced) {
			Section2.append(first+" -> Invalid"+"\n");
			Section2.append(second+" -> Valid -> "+SolvePostfix(infixToPostfix(second.replaceAll(" ", "")))+"\n");
		}
		else if(isFirstBalanced && !isSecondBalanced) {
			Section2.append(first+" -> Valid -> "+SolvePostfix(infixToPostfix(first.replaceAll(" ", "")))+"\n");
			Section2.append(second+" -> Invalid"+"\n");
		}
		else {
			Section2.append(first+" -> Invalid"+"\n");
			Section2.append(second+" -> Invalid"+"\n");
		}
	} // end method
	
	private boolean isBalanced(String exp) { // check if Delimiters Balanced  
		String [] c = exp.split(" ");
		for(int j = 0 ; j < c.length -2 ; j++) {
			if(Character.isDigit(c[j].charAt(0))) {
				if(Character.isDigit(c[j+1].charAt(0)))
						return false;
			}
		}
		exp = exp.replaceAll(" ", "");
		Stack<Character> s = new Stack<>();
		for(int i = 0 ; i < exp.length() ; i++) {
			if(exp.charAt(i) == '(' || exp.charAt(i) == '[' || exp.charAt(i) == '{')
				s.push(exp.charAt(i));
			else if (exp.charAt(i) == ')' || exp.charAt(i) == ']' || exp.charAt(i) == '}') {
				if(!s.isEmpty() && isEqual(s.peek(), exp.charAt(i)))
					s.pop();
				else
					return false;
			}
		}
		if(!s.isEmpty())
			return false;
		else {
			for(int i = 0 ; i < exp.length()-1 ; i++) {
				if(exp.charAt(i) == 32)
					continue; 
//				(!isOperator(exp.charAt(i+1)) || !isBrakets(exp.charAt(i+1), "close") || exp.charAt(i+1) != 32)
				if(Character.isDigit(exp.charAt(i)) && isBrakets(exp.charAt(i+1), "open"))
					return false;
//				(!isOperator(exp.charAt(i+1)) || !isBrakets(exp.charAt(i+1), "open") || exp.charAt(i+1) != 32)
				else if (isBrakets(exp.charAt(i), "open") && isOperator(exp.charAt(i+1)))
					return false;
//				(!isOperator(exp.charAt(i+1)) || !isBrakets(exp.charAt(i+1), "close") || exp.charAt(i+1) != 32)
				else if(isBrakets(exp.charAt(i), "close") && Character.isDigit(exp.charAt(i+1)))
					return false;
//				(!isBrakets(exp.charAt(i+1), "open") || !Character.isDigit(exp.charAt(i+1)) || exp.charAt(i+1) != 32)
				else if(isOperator(exp.charAt(i)) && (isBrakets(exp.charAt(i+1), "close") || (isOperator(exp.charAt(i+1)))) )
					return false;
			}
		}
		return true;
		
	} // end method
	
	private boolean isBrakets(char ch, String op) { // isBrakets return if the this character is a bracket
		if(op.equals("close")) {
			switch(ch) {
				case ')' :
				case ']' :
				case '}' :
				return true;
			}
		}
		else {
			switch(ch) {
				case '(' :
				case '[' :
				case '{' :
				return true;
			}
		}
		return false;
	} // end method
	
	private boolean isEqual(char open, char close) { // check if two delimiters are equal
		if(open == '[' && close == ']')
			return true;
		if(open == '(' && close == ')')
			return true;
		if(open == '{' && close == '}')
			return true;
		return false;
	} // end method
	
	public static void main(String[] args) {
		launch(args);
	}
}

