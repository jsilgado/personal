package jsilgado.javaexamples.utils;

import java.util.regex.Pattern;

public class StringIsNumber {

	public static void main(String... args) {
	    // Prepare.
	    String[] strings = {
	        null, "foo", "123", "+123", "-123", "0", "--123", "12345678901234567890"
	    };
	    int iterations = 1000000;
	    boolean result = false;

	    // Let for each of the strings show the isNumber() results.
	    for (String string : strings) {
	        System.out.printf("String: %s isNumberWithParseLong: %s WithIsDigit:"
	            + " %s WithRegex: %s%n", string, isNumberWithParseLong(string),
	                isNumberWithIsDigit(string), isNumberWithRegex(string));
	    }

	    // JVM warmup.
	    System.out.print("Warming up JVM .. ");
	    for (int i = 0; i < iterations / 10; i++) {
	        for (String string : strings) {
	            result ^= isNumberWithParseLong(string);
	            result ^= isNumberWithIsDigit(string);
	            result ^= isNumberWithRegex(string);
	        }
	    }
	    System.out.println("Finished! Now the benchmarks ..");

	    // Benchmark isNumber() with Long#parseLong().
	    long st1 = System.nanoTime();
	    for (int i = 0; i < iterations; i++) {
	        for (String string : strings) {
	            result ^= isNumberWithParseLong(string);
	        }
	    }
	    long et1 = System.nanoTime();
	    System.out.printf("isNumberWithParseLong: %d ms%n", (et1 - st1) / 1000000);

	    // Benchmark isNumber() with Character#isDigit().
	    long st2 = System.nanoTime();
	    for (int i = 0; i < iterations; i++) {
	        for (String string : strings) {
	            result ^= isNumberWithIsDigit(string);
	        }
	    }
	    long et2 = System.nanoTime();
	    System.out.printf("isNumberWithIsDigit: %d ms%n", (et2 - st2) / 1000000);

	    // Benchmark isNumber() with regex.
	    long st3 = System.nanoTime();
	    for (int i = 0; i < iterations; i++) {
	        for (String string : strings) {
	            result ^= isNumberWithRegex(string);
	        }
	    }
	    long et3 = System.nanoTime();
	    System.out.printf("isNumberWithRegex: %d ms%n", (et3 - st3) / 1000000);

	    // Print the result. This way we let the JIT know that we're interested in the
	    // result so that it doesn't optimize the one or other away, for the case that.
	    System.out.println(result);
	}

	public static boolean isNumberWithParseLong(String string) {
	    try {
	        Long.parseLong(string);
	    } catch (Exception e) {
	        return false;
	    }
	    return true;
	}

	public static boolean isNumberWithIsDigit(String string) {
	    if (string == null || string.isEmpty()) {
	        return false;
	    }
	    int i = 0;
	    if (string.charAt(0) == '-') {
	        if (string.length() > 1) {
	            i++;
	        } else {
	            return false;
	        }
	    }
	    for (; i < string.length(); i++) {
	        if (!Character.isDigit(string.charAt(i))) {
	            return false;
	        }
	    }
	    return true;
	}

	private static final Pattern numberPattern = Pattern.compile("-?\\d+");

	public static boolean isNumberWithRegex(String string) {
	    return string != null && numberPattern.matcher(string).matches();
	}

	private static final int NUMBER_MAX_LENGTH = String.valueOf(Long.MAX_VALUE).length();

	public static boolean isNumber(String string) {
	    if (string == null || string.isEmpty()) {
	        return false;
	    }
	    if (string.length() >= NUMBER_MAX_LENGTH) {
	        try {
	            Long.parseLong(string);
	        } catch (Exception e) {
	            return false;
	        }
	    } else {
	        int i = 0;
	        if (string.charAt(0) == '-') {
	            if (string.length() > 1) {
	                i++;
	            } else {
	                return false;
	            }
	        }
	        for (; i < string.length(); i++) {
	            if (!Character.isDigit(string.charAt(i))) {
	                return false;
	            }
	        }
	    }
	    return true;
	}
	
}
