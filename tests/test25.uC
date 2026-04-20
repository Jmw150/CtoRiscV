/* Regression: mixed int/float multiplication promotes to float. */
float x;
int y;

int main() {
    x = 3.0;
    y = 4;
    print(x * y);
    return 0;
}
