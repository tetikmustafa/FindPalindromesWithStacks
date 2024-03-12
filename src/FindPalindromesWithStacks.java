import java.io.BufferedReader;
import java.io.FileReader;

public class FindPalindromesWithStacks {
    public static void main(String[] args) {
        printPalindromLinesinFile("odev.txt");
    }
    public static void printPalindromLinesinFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if(isPalindrome(line)) {
                    System.out.println("\""+line+"\""+" bir palindromdur.");
                }
            }
        } catch (Exception e) {
            System.out.println("File not found.");
        }
    }
    public static boolean isPalindrome(String input) {
        MyStack theStack = new MyStack(100);
        for (int j = 0; j < input.length(); j++) {
            char ch = input.charAt(j);
            if (Character.isLetter(ch)) {
                ch = Character.toLowerCase(ch);
                theStack.push(ch);
            }
        }
        String first = "";
        String last = "";
        while (!theStack.isEmpty()) {
            char ch = theStack.pop();
            last = last + ch;
            first = ch + first;
        }
        return first.equals(last);
    }
}
class MyStack {
    private int top;
    private int maxSize;
    private char[] stackArray;
    public MyStack(int s) {
        maxSize = s;
        stackArray = new char[maxSize];
        top = -1;
    }
    public void push(char j) {
        stackArray[++top] = j;
    }
    public char pop() {
        return stackArray[top--];
    }
    public char peek() {
        return stackArray[top];
    }
    public boolean isEmpty() {
        return (top == -1);
    }
}