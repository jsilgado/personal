package jsilgado.javaexamples.utils;


public class ArrayIntConvert {

	public static void main(String[] args) {

		int[] obj = new int[] { 1, 2, 3 };
		Integer[] newObj = toObject(obj);

		System.out.println("Test toObject() - int -> Integer");
		for (Integer temp : newObj) {
			System.out.println(temp);
		}

		Integer[] obj2 = new Integer[] { 4, 5, 6 };
		int[] newObj2 = toPrimitive(obj2);

		System.out.println("Test toPrimitive() - Integer -> int");
		for (int temp : newObj2) {
			System.out.println(temp);
		}

	}

	// Convert int[] to Integer[]
	public static Integer[] toObject(int[] intArray) {

		Integer[] result = new Integer[intArray.length];
		for (int i = 0; i < intArray.length; i++) {
			result[i] = Integer.valueOf(intArray[i]);
		}
		return result;

	}

	// Convert Integer[] to int[]
	public static int[] toPrimitive(Integer[] IntegerArray) {

		int[] result = new int[IntegerArray.length];
		for (int i = 0; i < IntegerArray.length; i++) {
			result[i] = IntegerArray[i].intValue();
		}
		return result;
	}

}
