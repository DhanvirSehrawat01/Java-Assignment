public class StringFundamentals {
    static boolean hasText(String value) {
        if (value == null) {
            return false;
        }

        if (value.length() == 0) {
            return false;
        }

        for (int i = 0; i < value.length(); i++) {
            if (value.charAt(i) != ' ') {
                return true;
            }
        }

        return false;
    }

    static String normalizeCourseCode(String code) {
        if (code == null) {
            return null;
        }

        return code.trim().toUpperCase();
    }

    static int countOccurrences(String text, char target) {
        if (text == null) {
            return 0;
        }

        int count = 0;

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == target) {
                count++;
            }
        }

        return count;
    }

    static int lengthOfLastWord(String text) {
        if (text == null || text.length() == 0) {
            return 0;
        }

        int i = text.length() - 1;

        while (i >= 0 && text.charAt(i) == ' ') {
            i--;
        }

        int length = 0;

        while (i >= 0 && text.charAt(i) != ' ') {
            length++;
            i--;
        }

        return length;
    }


    static void reverseString(char[] characters) {
        if (characters == null) {
            return;
        }

        int left = 0;
        int right = characters.length - 1;

        while (left < right) {
            char temp = characters[left];
            characters[left] = characters[right];
            characters[right] = temp;

            left++;
            right--;
        }
    }


    public static void main(String[] args) {
        System.out.println("hasText tests:");
        System.out.println(hasText(null));
        System.out.println(hasText(""));
        System.out.println(hasText("   "));
        System.out.println(hasText("Hello"));
        System.out.println(hasText("A"));

        System.out.println("\nnormalizeCourseCode tests:");
        System.out.println(normalizeCourseCode("  cse101  "));
        System.out.println(normalizeCourseCode("java200"));
        System.out.println(normalizeCourseCode(""));
        System.out.println(normalizeCourseCode(null));


        System.out.println("\ncountOccurrences tests:");
        System.out.println(countOccurrences("banana", 'a'));
        System.out.println(countOccurrences("hello", 'l'));
        System.out.println(countOccurrences("", 'a'));
        System.out.println(countOccurrences("A", 'A'));
        System.out.println(countOccurrences(null, 'a'));
        System.out.println("\nlengthOfLastWord tests:");
        System.out.println(lengthOfLastWord("Hello World"));
        System.out.println(lengthOfLastWord("Hello World   "));
        System.out.println(lengthOfLastWord("Java"));
        System.out.println(lengthOfLastWord(""));
        System.out.println(lengthOfLastWord(null));


        System.out.println("\nreverseString tests:");

        char[] characters1 = {'h', 'e', 'l', 'l', 'o'};
        reverseString(characters1);
        System.out.println(characters1);

        char[] characters2 = {'A'};
        reverseString(characters2);
        System.out.println(characters2);

        char[] characters3 = {};
        reverseString(characters3);
        System.out.println(characters3);
    }
}