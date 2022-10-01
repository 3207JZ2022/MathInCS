import static java.lang.Integer.parseInt;

public class Demo {
    public static void main(String[] args) {
        System.out.println(evenParityCheck("10111"));
        System.out.println(tripleRepetitionCode("1110"));
        System.out.println(hammingDistance("1110","01111"));
        System.out.println(nearestNeighborDecoding("0110","0000","1110","1011"));
        numErrorAndNumCorrect("0110","0000","1110","1011");
        System.out.println(weight("11010"));
    }


    public static String evenParityCheck(String a){
        int stringLength = a.length();
        int checkParity = 0;
        for (int i = 0; i < a.length(); i++) {
            checkParity+= a.charAt(i);
        }
        a += checkParity % 2;
        String bitString = a;
        System.out.println("evenParityCheck: ");
        return bitString;
    }
    public static String tripleRepetitionCode(String a){
        String tripleRep = "";
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < a.length(); j++) {
                tripleRep += a.charAt(j);
            }
        }
        String bitString = tripleRep;
        System.out.println("tripleRepetitionCode: ");
        return bitString;
    }
    public static int hammingDistance(String x, String y){

        int count = 0;
        if (x.length() == y.length()){
            System.out.println("HammingDistance:");
            for (int i = 0; i < x.length(); i++) {
                if (x.charAt(i) != y.charAt(i)){
                    count++;
                }
            }
        }
        else {
            System.out.println("Two bit strings have different lengths\nThe bit strings length different by:");
            return Math.abs(x.length()-y.length());
            }
        return count;
    }
    public static String nearestNeighborDecoding(String received, String a, String b, String c){
        int countMin = 0;
        String sent= "";
        if (received.length() == a.length()){
            int countA = 0;
            for (int i = 0; i < received.length(); i++) {
                if (received.charAt(i) != a.charAt(i)){
                    countA++;
                }
            }
            countMin = countA;
            sent = a;
        }
        if (received.length() == b.length()){
            int countB = 0;
            for (int i = 0; i < received.length(); i++) {
                if (received.charAt(i) != b.charAt(i)){
                    countB++;
                }
            }
            if (countB < countMin){
                countMin = countB;
                sent = b;
            }
        }
        if (received.length() == c.length()){
            int countC = 0;
            for (int i = 0; i < received.length(); i++) {
                if (received.charAt(i) != c.charAt(i)){
                    countC++;
                }
            }
            if (countC < countMin){
                sent = c;
            }
        }
        System.out.println("The codeword that sent was:");
        return sent;
    }
    /*
    1. Given a binary code, determine the number of errors that it can detect and
    the number of errors that it can correct.
    */
    public static void numErrorAndNumCorrect(String received, String a, String b, String c){
        int countMin = 0;
        if (received.length() == a.length()){
            int countA = 0;
            for (int i = 0; i < received.length(); i++) {
                if (received.charAt(i) != a.charAt(i)){
                    countA++;
                }
            }
            countMin = countA;
        }
        if (received.length() == b.length()){
            int countB = 0;
            for (int i = 0; i < received.length(); i++) {
                if (received.charAt(i) != b.charAt(i)){
                    countB++;
                }
            }
            if (countB < countMin){
                countMin = countB;
            }
        }
        if (received.length() == c.length()){
            int countC = 0;
            for (int i = 0; i < received.length(); i++) {
                if (received.charAt(i) != c.charAt(i)){
                    countC++;
                }
            }
            if (countC < countMin){
                countMin = countC;
            }
        }
        int canDetect = countMin -1;
        int canCorrect = (countMin-1)/2;
        System.out.println("The maximum number it can detect is: "+ canDetect);
        System.out.println("The maximum number it can correct is: "+ canCorrect);
    }
    public static int weight(String a){
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == '1'){
                count++;
            }
        }
        System.out.println("weight:");
        return count;
    }

    /*
    Given a binary code with minimum distance k, where k is a positive integer,
write a program that will detect errors in codewords in as many as k − 1
positions and correct errors in as many as floor((k − 1)/2) position
     */
    public static int numErrorCorrect(String a){
        int numCanCorrect = 0;
        return numCanCorrect;
    }
    public static String correctError(String received,String a, String b, String c, String d) {
        String reference = received;

        String correctString = "";
        String empty = "";

        int countMin = 0;
        if (received.length() == a.length()) {
            int countA = 0;
            for (int i = 0; i < received.length(); i++) {
                if (received.charAt(i) != a.charAt(i)) {
                    countA++;
                    empty += a.charAt(i);

                }
                countMin = countA;
                correctString = reference;
            }
            if (received.length() == b.length()) {
                int countB = 0;
                for (int i = 0; i < received.length(); i++) {
                    if (received.charAt(i) != b.charAt(i)) {
                        countB++;
                    }
                }
                if (countB < countMin) {
                    countMin = countB;
                    correctString = reference;

                }
            }
            if (received.length() == c.length()) {
                int countC = 0;
                for (int i = 0; i < received.length(); i++) {
                    if (received.charAt(i) != c.charAt(i)) {
                        countC++;
                    }
                }
                if (countC < countMin) {
                    countMin = countC;
                    correctString = reference;

                }
            }

        }
            return correctString;
    }
    public static String hammingCodes (String a,int order){
            int[][] parityCheckMatrix = new int[order][(int) (Math.pow(2, order) - 1)];


            int[][] generatorMatrix = new int[(int) (Math.pow(2, order) - 1 - order)][(int) (Math.pow(2, order) - 1)];

            String codewords = "";
            return codewords;
        }

}
