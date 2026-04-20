/* Regression: helper function with one argument. */
int inc(int x) {
    return x + 1;
}

int main() {
    print(inc(9));
    return 0;
}
