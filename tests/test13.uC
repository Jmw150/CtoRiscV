/* Test while loop with zero iterations (condition false on entry) */
int x;
string done = "done\n";

int main() {
    x = 10;
    while (x < 5) {
        x = x + 1;
    }
    print(done);
    print(x);
    return 0;
}
