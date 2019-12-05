#include <stdio.h>

//Function declerations
int is_prime(int);
int check_primes(int, int, char[]);
void goldbach(int);
void godel_statement(int[]);
void print_statement(char[], int);

int main() {
	int number;
	int primes[] = { 3, 7, 21, 5, 19, 23, 11, 13 };
	while (1) {
		printf("Enter an even number:");
		scanf_s("%d", &number);
		if (number > 2 && number % 2 == 0) {
			goldbach(number);
		}
		else {
			printf("Incorrect number!\n");
			break;
		}
		printf("\n");
	}
	godel_statement(primes);
	return 0;
}

int is_prime(int n) {
	int flag = 1;
	for (int j = 2; j < n / 2; j++) {
		if ((n % j) == 0) {
			return flag - 1;
		}
	}
	return flag;
}

void goldbach(int g) {
	int i = 2;
	for (int j = g - i; j > 2; j--) {
		if (is_prime(i) == 1 && is_prime(j) == 1) {
			printf("%d = %d + %d\n", g, i, j);
			break;
		}
		i++;
	}
}

void godel_statement(int val[]) {
	int size = sizeof(val)*2;
	int count = 0;
	char godel_string[sizeof(val)*2];
	printf("Size = %d\n\n", size);
	for (int i = 0; i < size; ++i) {
		if (check_primes(val[i], count, godel_string)) count++;
		printf("Count = %d\n", count);
	}
	print_statement(godel_string, count);
}

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

void print_statement(char str[], int size) {
	for (int i = 0; i < size; ++i) {
		printf("%c ", str[i]);
	}
}
