/* Regression: local integer declarations in function bodies. */
int main() {
    int x;
    x = 3;
    print(x);
    return 0;
}
