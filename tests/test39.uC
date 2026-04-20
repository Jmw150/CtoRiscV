/* Regression: simple helper function inlined into main. */
int square(int x) {
    return x * x;
}

int main() {
    print(square(6));
    return 0;
}
