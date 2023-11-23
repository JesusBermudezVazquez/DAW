package retos;

// I IMPORT CLASS 'Scanner' TO BE ABLE TO ENTER DATA FROM THE KEYBOARD

import java.util.Scanner;

public class _04Chalenge {

	public static void main(String[] args) {

		// I DECLARE THE VARIABLES OF THE CHALLENGE

		int num1, num2, num3;
		String numIntroducido;
		boolean validate;

		// I GET THE VALUE OF THE DATA ENTERED

		Scanner inNum = new Scanner(System.in);

		// I REPEAT UNTIL A WHOLE NUMBER IS ENTERED
		
		do {

			System.out.println("----------------------------------------------------------");
			System.out.println("ENTER A WHOLE NUMBER WITH A MAXIMUM OF 3 CHARACTERS:");
			System.out.println("----------------------------------------------------------");

			// IF THE DATA TYPE IS AN INTEGER NUMBER

			if (inNum.hasNextInt()) {

				// ASSIGNS THE VALUE OF THE DIGIT ENTERED

				numIntroducido = inNum.nextLine();
				

				// IT IS VALID THAT IT IS POSITIVE AND HAS 3 DIGITS

				if (numIntroducido.length() == 3) {

					// I SEPARATE THE 3 NUMBERS INTRODUCED

					num1 = Character.getNumericValue(numIntroducido.charAt(0));
					num2 = Character.getNumericValue(numIntroducido.charAt(1));
					num3 = Character.getNumericValue(numIntroducido.charAt(2));

					System.out.println("----------------------------------------------------------");
					System.out.println("THE NUMBERS WILL BE ORDERED FROM HIGHEST TO LOWEST");
					System.out.println("----------------------------------------------------------");

					// ORDER FROM HIGHEST TO LOWEST

					if (num1 > num2 && num2 > num3) {

						System.out.println(num1 + ", " + num2 + ", " + num3);

					} else if (num1 > num3 && num3 > num2) {

						System.out.println(num1 + ", " + num3 + ", " + num2);

					} else if (num2 > num1 && num1 > num3) {

						System.out.println(num2 + ", " + num1 + ", " + num3);

					} else if (num2 > num3 && num3 > num1) {

						System.out.println(num2 + ", " + num3 + ", " + num1);

					} else if (num3 > num1 && num1 > num2) {

						System.out.println(num3 + ", " + num1 + ", " + num2);

					} else if (num3 > num2 && num2 > num1) {

						System.out.println(num3 + ", " + num2 + ", " + num1);

					}

					validate = true;

				} else {

					System.out
							.println("------------------------------------------------------------------------------");
					System.out.println("YOU HAVE TO ENTER A 3-FIGURE NUMBER. RETRY.");
					System.out
							.println("------------------------------------------------------------------------------");
					System.out.println("///////////////////////////////////////////////////////////");

					validate = false;
				}

			} else {

				System.out.println("----------------------------------------------------------");
				System.out.println("YOU HAVE NOT ENTER A WHOLE NUMBER. RETRY.");
				System.out.println("----------------------------------------------------------");
				System.out.println("///////////////////////////////////////////////////////////");

				// LIMPIO BUFFER

				inNum.nextLine();

				validate = false;

			}

		} while (!validate);	
		

		// CLOSE SCANNER

		inNum.close();
	}

}
