public class StringBuilderToolkit {
    static String reverse(String text) {
        if (text == null) {
            return null;
        }

        StringBuilder builder = new StringBuilder(text);
        builder.reverse();

        return builder.toString();
    }

    static String repeat(String text, int count) {
        if (text == null) {
            return null;
        }

        if (count < 0) {
            return "";
        }

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < count; i++) {
            builder.append(text);
        }

        return builder.toString();
    }

    static String joinWords(String[] words, String separator) {
        if (words == null) {
            return null;
        }

        if (separator == null) {
            separator = "";
        }

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < words.length; i++) {

            if (words[i] != null) {
                builder.append(words[i]);
            }

            if (i < words.length - 1) {
                builder.append(separator);
            }
        }

        return builder.toString();
    }

    static String removeCharacterAt(String text, int index) {
        if (text == null) {
            return null;
        }

        if (index < 0 || index >= text.length()) {
            return text;
        }

        StringBuilder builder = new StringBuilder(text);
        builder.deleteCharAt(index);

        return builder.toString();
    }
    static String replaceCharacterAt(
            String text, int index, char replacement) {

        if (text == null) {
            return null;
        }

        if (index < 0 || index >= text.length()) {
            return text;
        }

        StringBuilder builder = new StringBuilder(text);
        builder.setCharAt(index, replacement);

        return builder.toString();
    }
    static String buildNumberedList(String[] items) {
        if (items == null) {
            return null;
        }

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < items.length; i++) {
            builder.append(i + 1);
            builder.append(". ");

            if (items[i] != null) {
                builder.append(items[i]);
            }

            if (i < items.length - 1) {
                builder.append("\n");
            }
        }

        return builder.toString();
    }
    public static void main(String[] args) {
        System.out.println("Reverse:");
        System.out.println(reverse("Hello"));
        System.out.println(reverse(""));
        System.out.println(reverse("A"));
        System.out.println(reverse(null));

        System.out.println("\nRepeat:");
        System.out.println(repeat("Hi", 3));
        System.out.println(repeat("A", 1));
        System.out.println(repeat("Hello", 0));
        System.out.println(repeat("Hello", -1));
        System.out.println(repeat(null, 3));

        System.out.println("\nJoin Words:");

        String[] words = {"Java", "Python", "C++"};

        System.out.println(joinWords(words, ", "));
        System.out.println(joinWords(new String[]{}, ", "));
        System.out.println(joinWords(words, null));
        System.out.println(joinWords(null, ", "));

        System.out.println("\nRemove Character:");
        System.out.println(removeCharacterAt("Hello", 1));
        System.out.println(removeCharacterAt("A", 0));
        System.out.println(removeCharacterAt("", 0));
        System.out.println(removeCharacterAt("Hello", 10));
        System.out.println(removeCharacterAt(null, 1));

        System.out.println("\nReplace Character:");
        System.out.println(replaceCharacterAt("Hello", 1, 'a'));
        System.out.println(replaceCharacterAt("A", 0, 'B'));
        System.out.println(replaceCharacterAt("", 0, 'X'));
        System.out.println(replaceCharacterAt("Hello", 10, 'X'));
        System.out.println(replaceCharacterAt(null, 1, 'X'));

        System.out.println("\nNumbered List:");

        String[] items = {
            "Learn Java",
            "Practice OOP",
            "Solve Problems"
        };
        System.out.println(buildNumberedList(items));
        System.out.println("\nStringBuilder and String:");
        StringBuilder builder = new StringBuilder("Hello");
        String result = builder.toString();
        builder.append(" World");
        System.out.println("String result: " + result);
        System.out.println("Builder after change: " + builder);
    }
}