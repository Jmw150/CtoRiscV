/* Regression: assigning an int expression to a float variable promotes to float. */
float x;
int y;

int main() {
    y = 7;
    x = y;
    print(x);
    return 0;
}
