package FirstChallengeJava;

// I IMPORT CLASS 'Scanner' TO BE ABLE TO ENTER DATA FROM THE KEYBOARD

import java.util.Scanner;

public class _02Chenllenge {

	public static void main(String[] args) {

		// I DECLARE THE VARIABLES OF THE CHALLENGE

		int numEnter, twentySuccessive;
		boolean validate;
		

		// I GET THE VALUE OF THE DATA ENTERED

		Scanner inNum = new Scanner(System.in);
		

		// I REPEAT UNTIL A WHOLE NUMBER IS ENTERED

		do {

			System.out.println("----------------------------------------------------------");
			System.out.println("ENTER A POSITIVE WHOLE NUMBER:");
			System.out.println("----------------------------------------------------------");


			// IF THE DATA TYPE IS AN INTEGER NUMBER

			if (inNum.hasNextInt()) {

				// ASSIGNS THE VALUE OF THE DIGIT ENTERED

				numEnter = inNum.nextInt();

				if (numEnter > 0) {
					
					System.out.println("----------------------------------------------------------");
					System.out.println("IT WILL SHOW THE 20 SUCCESSIVE NUMBERS:");
					System.out.println("----------------------------------------------------------");


					// I ADD THE 20 TO COURSE

					twentySuccessive = 20 + numEnter;

					// SUMO ON A WHILE UNTIL THE SUCCESSIVE 20 ARE SHOWN

					while (numEnter < twentySuccessive) {

						numEnter++;

						System.out.print(numEnter + " ");

					}

					validate = true;

				} else {

					System.out.println("----------------------------------------------------------");
					System.out.println("YOU HAVE ENTER A NEGATIVE NUMBER. RETRY.");
					System.out.println("----------------------------------------------------------");

					validate = false;
				}

			} else {

				System.out.println("----------------------------------------------------------");
				System.out.println("YOU HAVE NOT ENTER A WHOLE NUMBER. RETRY.");
				System.out.println("----------------------------------------------------------");

				// LIMPIO BUFFER

				inNum.nextLine();

				validate = false;

			}

		} while (!validate);
		

		// CLOSE SCANNER

		inNum.close();

	}

}
