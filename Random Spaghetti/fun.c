#include <stdio.h>

int fact(int n) {
	if (n == 1) return 1;
	else return n * fact(n - 1);
}

void turnUp(int* ptr) {

}

void main() {
	int f = fact(5);
	printf("Factorial of 5 is %d", f);
	turnUp(&f);
	printf("The address is %p", &f);
}