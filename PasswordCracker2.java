package Non_Uploaded_Git;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class PasswordCracker2 {
    // static boolean visited[];
     private static String[] passwords;
    private static HashSet<String> tried;
    public static String passwordCracker(String[] pass, String attempt) {
        passwords = pass;
        tried = new HashSet();
        ArrayList<Integer> result = getPasswordsCombinations(new ArrayList<Integer>(), new StringBuilder(), attempt);
        if (result == null) {
            return "WRONG PASSWORD";
        }
        return getStringResult(result);
    }

    public static ArrayList<Integer> getPasswordsCombinations(ArrayList<Integer> currentResult, StringBuilder currentAttempt, String attempt) {
        ArrayList<Integer> result;
        for (int i = 0; i < passwords.length; i++) {
            if ( passwords[i].length() + currentAttempt.length() <= attempt.length() &&
                    passwords[i].equals(attempt.substring(currentAttempt.length(), currentAttempt.length() + passwords[i].length()))) {
                currentAttempt.append(passwords[i]);
                currentResult.add(i);
                if (currentAttempt.length() == attempt.length()) {
                    return currentResult;
                }

                if (!tried.contains(currentAttempt.toString())) {
                    tried.add(currentAttempt.toString());
                    result = getPasswordsCombinations(currentResult, currentAttempt, attempt);
                    if (result != null) {
                        return result;
                    }
                }
                currentResult.remove(currentResult.size() - 1);
                currentAttempt.delete(currentAttempt.length() - passwords[i].length(), currentAttempt.length());
            }
        }
        return null;
    }

    private static String getStringResult(ArrayList<Integer> result) {
        StringBuilder stringResult = new StringBuilder();
        stringResult.append(passwords[result.get(0)]);
        for (int i = 1; i < result.size(); i++) {
            stringResult.append(" ");
            stringResult.append(passwords[result.get(i)]);
        }
        return stringResult.toString();
    }

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while(t-- !=0){
            int n = s.nextInt();
            s.nextLine();
            String str = s.nextLine();
            String str1 [] = str.split(" ");
            String pass = s.nextLine();
            
            
            System.out.println(passwordCracker(str1, pass));
        }

}
}
    