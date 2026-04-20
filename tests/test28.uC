/* Regression: local float declarations in function bodies. */
int main() {
    float x;
    x = 3.5;
    print(x);
    return 0;
}
