/* Regression: logical and with short-circuit semantics. */
int a;
int b;
int c;
string yes = "yes\n";
string no = "no\n";

int main() {
    a = 1;
    b = 2;
    c = 3;
    if (a < b && b < c) {
        print(yes);
    } else {
        print(no);
    }
    return 0;
}
