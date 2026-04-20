/* Regression: logical not in conditions. */
int a;
string yes = "yes\n";
string no = "no\n";

int main() {
    a = 3;
    if (!(a == 4)) {
        print(yes);
    } else {
        print(no);
    }
    return 0;
}
