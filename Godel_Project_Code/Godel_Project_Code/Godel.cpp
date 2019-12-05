// C++ program to implement Goldbach's conjecture 
#include <iostream>
#include <string>
#include <iostream>
#include <stdio.h>
using namespace std;

int checkPrime(int n);
int exerciseTwo(int val);
int evenValue(int val);
int oddValue(int val);
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
int evenValue(int val) {
	return val / 2;
}

// Function for odd values 
int oddValue(int val) {
	return (3 * val) + 1;
}