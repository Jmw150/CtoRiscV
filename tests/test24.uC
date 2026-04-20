/* Regression: mixed int/float addition promotes to float. */
float x;
int y;

int main() {
    x = 1.5;
    y = 2;
    print(x + y);
    return 0;
}
