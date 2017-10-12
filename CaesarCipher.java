import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class CaesarCipher {
	/**
	  * Returns the character shifted by the given number of letters.
	  */
	public static char shiftLetter( char c, int n ) {
		int u = c;
		
		if ( ! Character.isLetter(c) )
			return c;
		
		u = u + n;
		if ( Character.isUpperCase(c) && u > 'Z'
		  || Character.isLowerCase(c) && u > 'z' ) {
		  	u -= 26;
		}
		if ( Character.isUpperCase(c) && u < 'A'
		  || Character.isLowerCase(c) && u < 'a' ) {
		  	u += 26;
		}
		
		return (char)u;
	}
	// Pulls message from a .txt file and then generates a new .txt file after shift
	public static void main( String[] args ) throws Exception {
		Scanner keyboard = new Scanner(System.in);
		int shift;
		String plaintext; 
		String cipher = "";
		PrintWriter fileout = new PrintWriter("NewSecretMessage.txt");
		
		Scanner fileIn = new Scanner(new File("SecretMessage.txt"));
			plaintext = fileIn.nextLine();
			fileIn.close();
		
		System.out.print("Shift (0-26): ");
		shift = keyboard.nextInt();
		
		for ( int i=0; i<plaintext.length(); i++ ) {
			cipher += shiftLetter( plaintext.charAt(i), shift );
			}
			
			fileout.println( "Message: " + cipher);
			fileout.close();
	}
}
		
