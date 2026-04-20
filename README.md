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

The grammar currently supports a deliberately small subset of C:

- global `int` and `float` variable declarations
- global `string` declarations with string literals
- a single `int main()` function
- assignments
- arithmetic expressions with `+`, `-`, `*`, `/`
- unary negation
- integer and float literals
- `if` / `else`
- `while`
- comparisons: `<`, `<=`, `>`, `>=`, `==`, `!=`
- `read(...)`
- `print(...)`
- `return expr`

This is not a full C compiler. In particular, the grammar and codebase are
centered on a single-function MicroC language rather than general C with
multiple functions, pointers, structs, arrays, or preprocessing.

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

## Run The Generated Assembly

You can execute emitted assembly with the bundled simulator:

```bash
python3 RiscSim/driver.py testout.out < input_test_asm
```

The simulator is also used by the semantic regression script.

## Regression Scripts

Two helper scripts are included:

- [trysyntax](/home/jmw150/backup/code/projects/c_compiler/trysyntax:1)
  builds the compiler, compiles a set of sample programs, and diffs the
  generated assembly against reference files in `outputs/`
- [trysemantics](/home/jmw150/backup/code/projects/c_compiler/trysemantics:1)
  builds the compiler, compiles sample programs, runs both the reference and
  generated assembly through the simulator, and diffs their observable output

Those scripts currently focus on `test0` through `test10`, even though the
`tests/` directory contains additional sample inputs.

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
- the grammar only accepts `int main()` as the function form
- the current tests and helper scripts are somewhat course-project flavored
- generated parser output and compiled classes are not treated as a polished
  packaging story

If this project is extended further, the most natural directions would be:

- fuller function support
- better error reporting
- a cleaner CLI
- broader regression coverage
- clearer documentation of the target assembly conventions
