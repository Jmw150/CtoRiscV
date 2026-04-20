/* Regression: basic global array declaration and indexing. */
int a[4];

int main() {
    a[0] = 3;
    a[1] = 4;
    print(a[0]);
    print(a[1]);
    return 0;
}
