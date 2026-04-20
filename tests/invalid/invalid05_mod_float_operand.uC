/* Pending invalid test: modulus should reject float operands. */
float x;
float y;

int main() {
    x = 5.5;
    y = 2.0;
    print(x % y);
    return 0;
}
