/* Regression: simple for loop lowering via existing while semantics. */
int i;

int main() {
    for (i = 0; i < 5; i = i + 1) {
        print(i);
    }
    return 0;
}
