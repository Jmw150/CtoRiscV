/* Regression: float-literal arithmetic should stay in float registers. */
float x;

int main() {
    x = 1.25 + 2.75;
    print(x);
    return 0;
}
