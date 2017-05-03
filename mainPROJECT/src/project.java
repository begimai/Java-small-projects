import java.util.*;

public class project {

	public static void main(String[] args) {

		display();
		game();

	}

	public static void display() {
		for (int d = 0; d < 60; ++d) {
			System.out.print("*");
		}
		System.out
				.println("\n* Game <Bulls and Cows>:                                   *");
		System.out
				.println("* Description: http://en.wikipedia.org/wiki/Bulls_and_cows *");
		for (int d = 0; d < 60; ++d) {
			System.out.print("*");
			if (d == 59)
				System.out.print("\n\n");
		}

	}

	public static int creatingNewRandomNumber(int x) {
		Random rand = new Random();
		x = rand.nextInt(9999 - 1000) + 1000;
		while (containsRepeatingDigits(x)) {
			x = rand.nextInt(9999 - 1000) + 1000;
		}
		return x;

	}

	public static boolean containsRepeatingDigits(int x) {
		int array[] = new int[4];
		int m = x;
		for (int d = 0; d < array.length; ++d) {
			array[d] = m % 10;
			m /= 10;
		}
		if (array[3] == array[2] || array[3] == array[1]
				|| array[3] == array[0] || array[2] == array[1]
				|| array[2] == array[0] || array[1] == array[0]) {
			return true;
		}

		return false;
	}

	public static void game() {
		int x = 0;
		int secretNumber = creatingNewRandomNumber(x);
		Scanner scan = new Scanner(System.in);
		int number, cows, bulls;
		while (true) {
			System.out.print("Do you want to play (y/n)? ");
			String respond = scan.next();
			while (respond.equals("y")) {
				System.out.print("Your guess: ");
				while (!scan.hasNextInt()) {
					System.out.println("Your number has a wrong format");
					System.out.println("Try again");
					System.out.print("Your guess: ");
					scan.next();
					
				}
				number = scan.nextInt();

				if (number > 9999 || number < 1000) {
					System.out
							.println("Your number is out of range [1000, 9999]");
					System.out.println("Try again");
					

				}  else if (number == secretNumber) {
					System.out.println("You are winner!!!");
					secretNumber = creatingNewRandomNumber(x);
					System.out.print("Do you want to play (y/n)? ");
					 respond = scan.next();
				}

				else if (containsRepeatingDigits(number)) {
					System.out.println("Your number has equal digits");
					System.out.println("Try again");
				} else {
					cows = checkingForCows(number, secretNumber);
					bulls = checkingForBulls(number, secretNumber);
					System.out.println("Cows: " + cows);
					System.out.println("Bulls: " + bulls);
					cows = 0;
					bulls = 0;

				}
			}
			if (respond.equalsIgnoreCase("n"))
			{
				System.out.println("Good bye!" );
				return;
			}
			else
				System.out.println("Use answers 'y' or 'n'. Try again" );
		}
		
	}

	public static int checkingForBulls(int x, int y) {
		int k=0;
		int m = x;
		int n =y;
		int array1 []= new int [4];
		int array2 []= new int [4];
		for(int d =0; d<4;++d)
		{
			array1[d]= m%10;
			m/=10;
			array2[d]= n%10;
			n/=10;
			if (array1[d] == array2[d])
				k++;
		}
		
		return k;
	}

	public static int checkingForCows(int x, int y) {
		int k = 0;
		int m = x;
		int n =y;
		int array1 []= new int [4];
		int array2 []= new int [4];
		for(int d =0; d<4; ++d)
		{
			array1[d]= m%10;
			m/=10;
			array2[d]= n%10;
			n/=10;
		}
		for(int d =0; d<4; ++d)
		{
			for(int t=0; t<4; ++t)
			{
				if(array1[t]==array2[d])
					k++;
			}
		}

	

		return k;
	}

}
