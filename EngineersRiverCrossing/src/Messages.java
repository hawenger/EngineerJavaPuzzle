
public class Messages {
	
	
	public static void printMessage(String message) {
		
		System.out.println(message);
	}
	
	public static String findMessage(String[] messageArray, int errorReference) {
		
		return messageArray[errorReference];
	}
	
	public static String[] createMessageArr() {

		String m1 = ("Error");
		String m2 = ("Your test failed");
		
		return new String[] {m1, m2};
	}
}
