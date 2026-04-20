/* Pending invalid test: block-local variable should not be visible outside the
   block where it is declared. */
int main() {
    {
        int x;
        x = 1;
    }
    print(x);
    return 0;
}
