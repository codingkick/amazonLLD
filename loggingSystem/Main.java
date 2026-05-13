package questions.loggingSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LoggingSytem loggingSytem = LoggingSytem.getInstance();
        Scanner in = new Scanner(System.in);
        while(true){
            System.out.println("enter a new log please:");
            String input = in.nextLine();
            loggingSytem.log(input);
            if(input.equals("EXIT")){
                loggingSytem.shutdown();
                break;
            }
        }
    }
}
