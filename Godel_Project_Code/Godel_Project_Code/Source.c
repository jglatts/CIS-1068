#include <stdio.h>


/* Function prototypes */
void check_goldbach(),
     goldbach(int),
     godel_statement(int[]),
     print_statement(char[], int);
int is_prime(int),
    check_primes(int, int, char[]),
    exercise_two(int), 
    even_value_function(int),
    odd_value_function(int);

/* Main Driver Function */
int main() {
	int primes[] = {3, 7, 21, 5, 19, 23, 11, 13 , 11, 19, 17};
	check_goldbach();
	godel_statement(primes);
	printf("\n\nThe i^th index for exercise 22 is %d\n", exercise_two(22));
	printf("The i^th index for exercise 23 is %d\n\n", exercise_two(23));
	return 0;
}

/* Check Goldbach's conjecture for even integers */
void check_goldbach() {
	int number;
	char check;
	while (1) {
		printf("Enter an even number to prove Golbach's Conjecture: ");
		scanf_s("%d", &number);
		if (number > 2 && number % 2 == 0) {
			goldbach(number);
			printf("\nEnter Y to continue or N to move to next program.");
			scanf_s(" %c", &check);
			if (check == 'N' || check == 'n') break;
		}
		else {
			printf("Incorrect number! The value must be even.\n");
			break;
		}
		printf("\n");
	}
}

/*	Check if the given value is prime */
int is_prime(int n) {
	int flag = 1;
	for (int j = 2; j < n / 2; j++) {
		if ((n % j) == 0) {
			return flag - 1;
		}
	}
	return flag;
}

/* Take an integer parameter and display the Goldbach Conjecture */
void goldbach(int g) {
	int i = 2;
	for (int j = g - i; j > 2; j--) {
		if (is_prime(i) == 1 && is_prime(j) == 1) {
			printf("%d = %d + %d\n", g, i, j);
			break;
		}
		i++;
	}
	if (g == 4) printf("4 = 2 + 2\n");
}


/* Take an integer parameter and display the Goldbach Conjecture */
void godel_statement(int val[]) {
	// double check this on different compilers!!! may cause errors
	int size = sizeof(val)*2;
	int count = 0;
	char godel_string[sizeof(val)*2];

	printf("Size = %d\n\n", size);
	for (int i = 0; i < size; ++i) {
		if (check_primes(val[i], count, godel_string)) count++;
	}
	print_statement(godel_string, count);
}

/*  Check the given value for a prime corresponding to a Godel Number
	Add the correct Godel number to the string
*/
int check_primes(int i, int count, char godel_string[]) {
	switch (i) {
		case 1:
			godel_string[count] = '0';
			return 1;
		case 3:
			godel_string[count] = 'f';
			return 1;
		case 5:
			godel_string[count] = 'N';
			return 1;
		case 7:
			godel_string[count] = 'O';
			return 1;
		case 9:
			godel_string[count] = 'A';
			return 1;
		case 11:
			godel_string[count] = '(';
			return 1;
		case 13:
			godel_string[count] = ')';
			return 1;
		case 15:
			godel_string[count] = 'A';
			return 1;
		case 17:
			godel_string[count] = 'E';
			return 1;
		case 19:
			godel_string[count] = '=';
			return 1;
		case 21:
			godel_string[count] = 'x';
			return 1;
		case 23:
			godel_string[count] = 'y';
			return 1;
		default: 
			break;
	}
	return 0;
}

/* Print the Godel Number */
void print_statement(char str[], int size) {
	printf("\n The Godel Number is: ");
	for (int i = 0; i < size; ++i) {
		printf("%c ", str[i]);
	}
}

/**
*	Find the i^th value that makes f^i(x) = 1
*		- Excerise two in the project
*/
int exercise_two(int value) {
	int index = 0;
	while (value != 1) {
		index++;
		value = (value % 2 == 0) ? even_value_function(value) : odd_value_function(value);
	}
	return index;
}

/* Functions for even values */
int even_value_function(int val) {
	return val / 2;
}

/* Functions for odd values */
int odd_value_function(int val) {
	return (3 * val) + 1;
}
