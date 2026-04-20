/* Pending invalid test: assigning to an undeclared variable should report a
   compiler error instead of triggering an internal exception. */
int main() {
    x = 3;
    return 0;
}
