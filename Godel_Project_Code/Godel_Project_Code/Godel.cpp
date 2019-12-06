// C/C++ program to implement Goldbach's conjecture 
#include <iostream>
#include <string>
#include <array>
#include <stdio.h>
#define size 11
using namespace std;

int checkPrime(int n);
int exerciseTwo(int);
int evenValue(int);
int oddValue(int);
int convertPrimes(int, int, char[]);
void godelStatement(int[]);
void printStatement(char[], int);
int main()
{
	int n, i, flag = 0;
	printf("Computer Project 1\nEnter a positive integer: ");
	scanf_s("%d", &n);
	for (i = 2; i <= n / 2; ++i)
	{
		// condition for i to be a prime number
		if (checkPrime(i) == 1)
		{
			// condition for n-i to be a prime number
			if (checkPrime(n - i) == 1)
			{
				// n = primeNumber1 + primeNumber2
				printf("%d = %d + %d\n", n, i, n - i);
				flag = 1;
			}
		}
	}
	if (flag == 0)
		printf("%d cannot be expressed as the sum of two prime numbers.", n);

	printf("\nComputer Project 2\nThe i^th index for 22 is %d\n", exerciseTwo(22));
	printf("The i^th index for 23 is %d\n\n", exerciseTwo(23));

	int primes[] = { 3, 7, 21, 5, 19, 23, 11, 13 , 11, 19, 17 };
	godelStatement(primes);

	return 0;
}

// Function to check prime number
int checkPrime(int n)
{
	int i, isPrime = 1;
	for (i = 2; i <= n / 2; ++i)
	{
		if (n % i == 0)
		{
			isPrime = 0;
			break;
		}
	}
	return isPrime;
}

// Implement the function in exercise 2
int exerciseTwo(int val) 
{
	int index = 0;
	while (val != 1) 
	{
		index++;
		val = (val % 2 == 0) ? evenValue(val) : oddValue(val);
	}
	return index;
}

// Function for even values 
int evenValue(int val) 
{
	return val / 2;
}

// Function for odd values 
int oddValue(int val) 
{
	return (3 * val) + 1;
}

// Take a list of primes at output the correct Godel number 
void godelStatement(int val[]) 
{
	int count = 0;
	char godel_string[size];
	for (int i = 0; i < size; ++i) 
	{
		if (convertPrimes(val[i], count, godel_string)) count++;
	}
	printStatement(godel_string, count);
}

/*  Check the given value for a prime corresponding to a Godel Number
	Add the correct Godel number to the string
*/
int convertPrimes(int i, int count, char godel_string[]) 
{
	switch (i) 
	{
		// have to change these to better symbols
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

// Print the Godel Number
void printStatement(char str[], int count) 
{
	printf("Computer Project 3\nThe Godel Number is: ");
	for (int i = 0; i < count; ++i) 
	{
		printf("%c ", str[i]);
	}
	printf("\n");
}
