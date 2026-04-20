/* Regression: assigning a float literal into a float variable should work. */
float x;

int main() {
    x = 4.25;
    print(x);
    return 0;
}
