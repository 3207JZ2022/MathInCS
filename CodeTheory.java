/*
Jian
November 5, 2021
Project 5: Coding Theory
 */
public class CodeTheory {
    public static void main(String[] args) {
        System.out.println(hammingDistance("1111", "0000"));
        System.out.println(minHammingDistance("001", "111", "110", "000"));
        numErrorAndNumCorrect("00000000", "11111000", "01010111", "10101111");

        System.out.println(nearestNeighborDecoding(5, "00000001","00000000", "11111000", "01010111", "10101111"));
    }
    /*
    1. Given a binary code, determine the number of errors that it can detect and
    the number of errors that it can correct.

    numErrorAndNumCorrect()

    It works only for C that has exactly four elements that have the same length(by the definition of Hamming distance).

    2. Given a binary code with minimum distance k, where k is a positive integer,
    write a program that will detect errors in codewords in as many as k − 1
    positions and correct errors in as many as floor((k − 1)/2) position

    nearestNeighborDecoding()

    The first parameter is minimum distance k.
    The second parameter is the codeword that received.
    The third to seventh parameter are the element of C.
    */
    public static int hammingDistance(String x, String y) {
        int count = 0;
        if (x.length() == y.length()) {
            for (int i = 0; i < x.length(); i++) {
                if (x.charAt(i) != y.charAt(i)) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int minHammingDistance(String a, String b, String c, String d) {
        int ham1 = hammingDistance(a, b);
        int ham2 = hammingDistance(a, c);
        int ham3 = hammingDistance(a, d);
        int ham4 = hammingDistance(b, c);
        int ham5 = hammingDistance(b, d);
        int ham6 = hammingDistance(c, d);
        int[] hammingD = {ham1, ham2, ham3, ham4, ham5, ham6};
        int min = ham1;

        for (int i = 1; i < hammingD.length; i++) {
            if (hammingD[i] < min) {
                min = hammingD[i];
            }
        }
        return min;
    }

    public static void numErrorAndNumCorrect(String a, String b, String c, String d) {
        int canDetect = minHammingDistance(a, b, c, d) - 1;
        int canCorrect = (int) Math.floor((minHammingDistance(a, b, c, d) - 1) / 2);
        System.out.println("The maximum number it can detect is: " + canDetect);
        System.out.println("The maximum number it can correct is: " + canCorrect);
    }

    public static String nearestNeighborDecoding(int minDistance, String received, String a, String b, String c, String d) {
        String sent = "";
        int canCorrect = (int) Math.floor((minDistance-1)/2);
        if (received.length() == a.length()) {
            int countA = 0;
            for (int i = 0; i < received.length(); i++) {
                if (received.charAt(i) != a.charAt(i)) {
                    countA++;
                }
            }
            if (countA <= canCorrect) {
                sent = a;
            }
            if (received.length() == b.length()) {
                int countB = 0;
                for (int i = 0; i < received.length(); i++) {
                    if (received.charAt(i) != b.charAt(i)) {
                        countB++;
                    }
                }
                if (countB <= canCorrect) {
                    sent = b;
                }
            }
            if (received.length() == c.length()) {
                int countC = 0;
                for (int i = 0; i < received.length(); i++) {
                    if (received.charAt(i) != c.charAt(i)) {
                        countC++;
                    }
                }
                if (countC <= canCorrect) {
                    sent = c;
                }
            }
            if (received.length() == d.length()) {
                int countC = 0;
                for (int i = 0; i < received.length(); i++) {
                    if (received.charAt(i) != d.charAt(i)) {
                        countC++;
                    }
                }
                if (countC <= canCorrect) {
                    sent = d;
                }
            }
        }
        if (sent.equals("")){
            System.out.println("This exceeds the maximum number of errors it can correct ");
        }
        return sent;
    }
}
