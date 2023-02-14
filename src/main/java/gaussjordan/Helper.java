package gaussjordan;

import java.io.BufferedReader;

/**
 * Helper class
 */
public class Helper {

    /**
     * Buffered reader for reading input from console
     */
    private static BufferedReader reader;

    /**
     * Zero threshold value
     */
    private static final double ZERO = 0.000_000_1;

    /**
     * Check if number is zero
     * @param number number to check
     * @return true if number is zero
     */
    public static boolean isZero(double number) {
        return Math.abs(number) < ZERO;
    }

    /**
     * Check if number is not zero
     * @param number number to check
     * @return true if number is not zero
     */
    public static boolean isNotZero(double number) {
        return !Helper.isZero(number);
    }

    /**
     * read String from console
     * @return String read from console
     */
    public static String readString() {
        if (reader == null) {
            reader = new BufferedReader(new java.io.InputStreamReader(System.in));
        }

        try {
            return reader.readLine();
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * Format number
     * @param number number to format
     * @return formatted number
     */
    public static String formatNumber(double number) {
        final int PRECISION = 4;
        return String.format("%+05." + PRECISION + "f", number)
                .replaceAll("-0.", "+0.")
                .replaceAll(",", ".")
                .replaceAll("\\+", " ");
    }

    /**
     * Convert matrix to string
     * @param matrix matrix to print
     * @return string representation of matrix
     */
    public static String matrixToString(double[][] matrix) {
        StringBuilder s = new StringBuilder();
        for (double[] row : matrix) {
            for (double number : row) {
                s.append(Helper.formatNumber(number)).append("  ");
            }
            s.append("\n");
        }

        return s.toString();
    }
}
