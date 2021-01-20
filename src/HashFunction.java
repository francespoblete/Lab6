public class HashFunction {
    private String word;
    private final int A = 13;
    private final int M = 31;

    public HashFunction(String input) {
        word = input;
    }

    public int hashCode() {
        int hash = 0;
        int exp = word.length();
        for (int i = 0; i < word.length(); i++) {
            if (Character.isUpperCase(word.charAt(i))) {
                int codeValue = (int) (((word.charAt(i) - 38) % M * Math.pow(53, --exp)) % M);
                hash += codeValue;
            } else if (Character.isLowerCase(word.charAt(i))) {
                int codeValue = (int) (((word.charAt(i) - 96) % M * Math.pow(53, --exp)) % M);
                hash += codeValue;
            }
        }
        return (A % M) * (hash % M) % M;
    }

    public static void main(String[] args) {
        String[] words = {"he", "is", "Art", "has", "Hat", "this"};
        for (String word:
                words) {
            System.out.print(word);
            HashFunction input = new HashFunction(word);
            System.out.print(" = " + input.hashCode() + "\n");
        }
    }
}