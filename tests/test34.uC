/* Regression: logical or with short-circuit semantics. */
int a;
int b;
string yes = "yes\n";
string no = "no\n";

int main() {
    a = 0;
    b = 5;
    if (a != 0 || b == 5) {
        print(yes);
    } else {
        print(no);
    }
    return 0;
}
