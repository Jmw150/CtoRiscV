/* Pending invalid test: returning a value from a void function should be
   rejected. */
void helper() {
    return 3;
}

int main() {
    helper();
    return 0;
}
