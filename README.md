# CtoRiscV

`CtoRiscV` is a small compiler for a MicroC-style subset of C that targets
RISC-V assembly.

The project is written in Java, uses ANTLR to generate the parser from
[MicroC.g4](/home/jmw150/backup/code/projects/c_compiler/MicroC.g4:1), and
includes a bundled RISC-V simulator so generated programs can be executed and
compared against reference outputs.

This is best understood as a teaching compiler: compact enough to read end to
end, but complete enough to show the full path from grammar to AST to code
generation.

## What The Project Does

The compiler takes a MicroC source file and emits RISC-V-style assembly with:

- a `.text` section containing generated code
- a `.strings` section for string literals stored in the global symbol table

The overall pipeline is:

1. Lex and parse MicroC using ANTLR
2. Build an AST during parsing
3. Record declarations in a symbol table with storage locations
4. Walk the AST to generate assembly instructions
5. Run the output in the bundled simulator if desired

The main compiler entry point is
[src/compiler/Compiler.java](/home/jmw150/backup/code/projects/c_compiler/src/compiler/Compiler.java:1).

## Supported Language Fragment

The grammar currently supports a deliberately small but now fairly usable
subset of C:

- global `int` and `float` variables
- fixed-size array declarations such as `int a[4];`
- global `string` declarations with string literals
- local `int` and `float` declarations inside function and nested block scopes
- local declaration initializers such as `int x = 3;`
- assignments to variables and array elements
- arithmetic expressions with `+`, `-`, `*`, `/`, `%`
- unary negation
- integer and float literals
- mixed `int`/`float` arithmetic with implicit promotion to `float`
- mixed `int`/`float` comparisons
- `if` / `else`
- `while`
- `for (init; cond; step)` loops, lowered internally to existing loop machinery
- nested block statements `{ ... }`
- boolean conditions with `&&`, `||`, `!`
- comparisons: `<`, `<=`, `>`, `>=`, `==`, `!=`
- `read(...)`
- `print(...)`
- `return expr`
- `int main()` as the runtime entry point
- small helper functions with one parameter and an expression-bodied `return`,
  implemented through inline expansion

This is still not a full C compiler. In particular, it does not yet implement
a general runtime calling convention, pointers, structs, preprocessing, or the
broader semantics of full ISO C.

## Current Semantics Notes

A few choices are worth calling out explicitly:

- helper functions are intentionally small-core and instructional: they are
  parsed before `main` and expanded inline rather than compiled as general
  callable procedures
- arrays currently cover basic fixed-size declarations and indexed element
  access, which is enough for simple programs and regression tests
- local variables are currently allocated through a simple compiler-managed
  storage model rather than a polished stack-frame implementation
- `return` still behaves as program termination from `main`

## Repository Layout

The most important directories are:

- [src/compiler](/home/jmw150/backup/code/projects/c_compiler/src/compiler)
  for the compiler driver, scopes, and symbol-table logic
- [src/ast](/home/jmw150/backup/code/projects/c_compiler/src/ast)
  for AST node definitions
- [src/assembly](/home/jmw150/backup/code/projects/c_compiler/src/assembly)
  for code generation and assembly data structures
- [src/assembly/instructions](/home/jmw150/backup/code/projects/c_compiler/src/assembly/instructions)
  for the emitted instruction classes
- [RiscSim](/home/jmw150/backup/code/projects/c_compiler/RiscSim)
  for the RISC-V simulator used by the regression scripts
- [tests](/home/jmw150/backup/code/projects/c_compiler/tests)
  for MicroC input programs
- [outputs](/home/jmw150/backup/code/projects/c_compiler/outputs)
  for reference assembly output

Generated parser code is placed in `build/compiler`, and compiled `.class`
files are placed in `classes`.

## Build

The project expects Java plus the bundled ANTLR jar at
`lib/antlr-4.8-complete.jar`.

To build the compiler:

```bash
make
```

That does two things:

1. runs ANTLR on `MicroC.g4`
2. compiles the Java sources and generated parser classes

To clean generated build artifacts:

```bash
make clean
```

## Test

There is now a simple project-level test entry point:

```bash
make test
```

This runs two layers of validation:

1. `make test-syntax`
   Compiles every `tests/test*.uC` program and checks that the compiler emits
   non-empty assembly.
2. `make test-semantics`
   Runs the generated assembly through the bundled simulator and compares the
   observable output against:
   - reference assembly in `outputs/` for `test0` through `test10`
   - checked-in expected stdout files in
     [tests/expected](/home/jmw150/backup/code/projects/c_compiler/tests/expected)
     for the newer semantic regression programs

The semantic checker normalizes away simulator banner lines and execution-cycle
counts, so harmless timing differences do not cause false failures.

At the moment, `make test` passes for all active regression programs in
`tests/`, including the newer coverage for:

- float literal and mixed numeric behavior
- local declarations and nested scopes
- `%`, `&&`, `||`, and `!`
- `for` loops
- helper functions with one argument
- basic array reads and writes

## Compile A Program

Use the helper script:

```bash
./runme tests/test0.uC testout.out
```

This runs:

```bash
java -cp classes:lib/antlr-4.8-complete.jar compiler.Compiler <input>
```

and writes the emitted assembly to the output file you specify.

`runme` now validates its arguments and will build the compiler automatically if
the compiled classes are missing.

## Run The Generated Assembly

You can execute emitted assembly with the bundled simulator:

```bash
python3 RiscSim/driver.py testout.out < input_test_asm
```

The simulator is also used by the semantic regression script.

## Regression Scripts

Two helper scripts are included:

- [trysyntax](/home/jmw150/backup/code/projects/c_compiler/trysyntax:1)
  builds the compiler and performs a compile smoke test across all sample
  programs in `tests/`
- [trysemantics](/home/jmw150/backup/code/projects/c_compiler/trysemantics:1)
  builds the compiler, compiles every sample program, runs the results through
  the simulator, and compares normalized observable output against semantic
  expectations

The older exact-assembly diff workflow was useful for a compiler class, but it
is too brittle for regular development because register allocation details and
label naming can change without changing program behavior.

## Example MicroC Program

Here is the kind of program this compiler is built for:

```c
int x;
float y;
string msg = "done";

int main() {
    x = 3;
    y = 4.5;
    if (x < 10) {
        print(x);
    } else {
        print(y);
    }
    print(msg);
    return x;
}
```

Here is a second example using newer features:

```c
int a[4];

int square(int x) {
    return x * x;
}

int main() {
    int i = 0;
    for (i = 0; i < 4; i = i + 1) {
        a[i] = square(i);
        print(a[i]);
    }
    return 0;
}
```

## Current Character Of The Project

This codebase has the feel of a compiler course project that grew into a
nicely inspectable end-to-end system:

- the grammar is readable
- the AST is explicit
- the symbol-table logic is separate from parsing
- code generation is organized by node type
- the RISC-V simulator makes semantic comparison easy

That makes it a good project for learning how a small compiler is structured.

## Limitations

A few important limitations are worth stating directly:

- the source language is a MicroC subset, not full C
- `main` is still the only true runtime entry point
- helper functions are inline-expanded rather than compiled with a full calling
  convention
- arrays are currently limited to basic fixed-size indexed access
- the current tests and helper scripts are somewhat course-project flavored
- exact assembly text is not a stable correctness signal
- generated parser output and compiled classes are not treated as a polished
  packaging story

If this project is extended further, the most natural directions would be:

- fuller function support
- better error reporting
- a cleaner CLI
- broader regression coverage
- clearer documentation of the target assembly conventions

A more concrete feature-by-feature expansion roadmap now lives in
[TODO.md](/home/jmw150/backup/code/projects/c_compiler/TODO.md:1), including
proposed tests for each planned language feature.
