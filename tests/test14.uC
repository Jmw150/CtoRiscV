/* Test float comparisons: <, >, == */
float a;
float b;
string yes = "yes\n";
string no = "no\n";

int main() {
    a = 1.5;
    b = 2.5;

    if (a < b) {
        print(yes);
    } else {
        print(no);
    }

    if (a > b) {
        print(yes);
    } else {
        print(no);
    }

    a = 2.5;
    if (a == b) {
        print(yes);
    } else {
        print(no);
    }

    return 0;
}
