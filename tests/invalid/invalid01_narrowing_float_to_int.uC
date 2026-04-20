/* Pending invalid test: narrowing float assignment to int should be rejected
   if implicit narrowing conversions are disallowed. */
int x;

int main() {
    x = 3.5;
    print(x);
    return 0;
}
