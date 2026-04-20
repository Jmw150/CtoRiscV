/* Regression: nested block scope and local shadowing. */
int x;

int main() {
    x = 1;
    {
        int x;
        x = 9;
        print(x);
    }
    print(x);
    return 0;
}
