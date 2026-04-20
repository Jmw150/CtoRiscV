/* Test counting down with subtraction in while */
int n;
string sep = " ";

int main() {
    n = 5;
    while (n > 0) {
        print(n);
        n = n - 1;
    }
    return 0;
}
