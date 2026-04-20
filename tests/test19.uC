/* Test reading and printing floats with arithmetic */
float x;
float y;
string prompt = "Enter float: ";
string result = "Result: ";

int main() {
    print(prompt);
    read(x);
    y = x * x;
    print(result);
    print(y);
    return 0;
}
