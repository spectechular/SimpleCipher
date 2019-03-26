import java.util.Calendar;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String input;
        Scanner keyboardInput = new Scanner(System.in);
        boolean goodInput = false;
        do {
            try {
                System.out.println("Type ONLY letters and hit enter to cipher: ");
                input = keyboardInput.nextLine();
                goodInput = checkUserInputAllLetters(input);

                if (!goodInput) {
                    goodInput = false;
                    System.out.println("Bad input. Must be only letters and spaces");
                    break;
                } else {
                    String cipheredText;
                    cipheredText = cipher(input);
                    System.out.println("Ciphered Text: " + cipheredText);
                }


                System.out.println("Enter String to decipher");

                System.out.println("Type ONLY letters and hit enter to cipher: ");
                String inputDecipher;
                inputDecipher = keyboardInput.nextLine();
                goodInput = checkUserInputAllLetters(inputDecipher);

                if (!goodInput) {
                    goodInput = false;
                    System.out.println("Bad input. Must be only letters and spaces");
                    break;
                } else {
                    String decipheredText;
                    decipheredText = decipher(inputDecipher);
                    System.out.println("Deciphered Text: " + decipheredText);
                }

            } catch (Exception e) {
                System.out.println("Error getting string input");
            }
        } while (goodInput == false);


    }


    public static String cipher(String inputToCipher) {

        int baseShift = 7;
        Calendar calendar = Calendar.getInstance();
        int dayOfWeekShift = calendar.get(Calendar.DAY_OF_WEEK);

        int finalShift = baseShift + dayOfWeekShift;

        StringBuilder stringBuilder = new StringBuilder();

        char[] charArrayOfInputToCipher = inputToCipher.toCharArray();

        for (char letter : charArrayOfInputToCipher) {

            if (Character.isUpperCase(letter)) {
                int charInASCII = (int) letter;
                charInASCII = ((charInASCII + finalShift - 65) % 26) + 65;
                stringBuilder.append((char) charInASCII);
            } else if (Character.isLowerCase(letter)) {
                int charInASCII = (int) letter;
                charInASCII = ((charInASCII + finalShift - 97) % 26) + 97;
                stringBuilder.append((char) charInASCII);
            } else if (Character.isSpaceChar(letter))
                stringBuilder.append(" ");
        }

        return stringBuilder.toString();
    }

    public static String decipher(String stringToDecipher) {
        int baseShift = 7;
        Calendar calendar = Calendar.getInstance();
        int dayOfWeekShift = calendar.get(Calendar.DAY_OF_WEEK);

        int finalShift = baseShift + dayOfWeekShift;

        StringBuilder stringBuilder = new StringBuilder();

        char[] charArrayOfInputToCipher = stringToDecipher.toCharArray();

        for (char letter : charArrayOfInputToCipher) {

            if (Character.isUpperCase(letter)) {
                int charInASCII = (int) letter;
                charInASCII = ((charInASCII - finalShift - 65) % 26) + 65;
                stringBuilder.append((char) charInASCII);
            } else if (Character.isLowerCase(letter)) {
                int charInASCII = (int) letter;
                charInASCII = ((charInASCII - finalShift - 97) % 26) + 97;
                stringBuilder.append((char) charInASCII);
            } else if (Character.isSpaceChar(letter))
                stringBuilder.append(" ");
        }

        return stringBuilder.toString();
    }

    public static boolean checkUserInputAllLetters(String userInputString) {
        char[] chars = userInputString.toCharArray();
        for (char c : chars) {
            if (!Character.isLetter(c) && !Character.isSpaceChar(c)) {
                return false;
            }
        }
        return true;
    }
}
