/* Test != with integer and while with equality check */
int a;
int target;
string found = "found\n";
string looking = "looking\n";

int main() {
    a = 1;
    target = 4;
    while (a != target) {
        print(looking);
        a = a + 1;
    }
    print(found);
    print(a);
    return 0;
}
