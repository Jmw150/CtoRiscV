# C Language Coverage TODO

This file tracks the most useful next steps for broadening the MicroC compiler
toward a larger and more C-like language.

The current compiler already supports:

- global `int` and `float` variables
- global `string` declarations
- a single `int main()`
- assignment
- arithmetic with `+`, `-`, `*`, `/`
- unary minus
- `if` / `else`
- `while`
- comparisons
- `read`, `print`, and `return`

The items below are ordered by implementation value, not by theoretical
importance. The early phases aim to improve coverage without requiring a total
compiler rewrite.

## Testing Plan

For each new language feature, add both:

- `tests/testNN.uC` style positive examples that compile and run
- negative parser/type/scope tests once an error-testing harness exists

Recommended test categories:

- parsing coverage
- code generation coverage
- runtime semantics coverage
- rejection/error coverage

Recommended future test layout:

- `tests/valid/` for compile-and-run programs
- `tests/invalid/` for programs that should fail
- `tests/expected/` for expected simulator output
- `tests/errors/` for expected compiler diagnostics

## Phase 0: Fix Core Correctness Gaps

These are not new C features, but they should be fixed before broader language
expansion.

### 0.1 Float literal typing bug

Why:

- [src/ast/FloatLitNode.java](src/ast/FloatLitNode.java:1) currently assigns
  `Scope.Type.INT` to float literals.

Feature work:

- fix `FloatLitNode` to use `Scope.Type.FLOAT`
- audit any code paths that accidentally relied on the wrong type

Tests:

- float literal assigned to float variable
- float literal printed directly
- float arithmetic using only literals
- mixed integer/float comparison involving a float literal

Suggested test names:

- `test21_float_literal_type.uC`
- `test22_float_literal_print.uC`
- `test23_float_literal_arith.uC`

### 0.2 Mixed int/float expression semantics

Why:

- the code generator currently chooses float ops if either side is float, but it
  does not yet have an explicit, documented conversion strategy

Feature work:

- define whether `int + float` and `float + int` are legal
- add explicit int-to-float conversion support if legal
- define assignment coercion rules

Tests:

- `int + float`
- `float - int`
- `int * float`
- assignment from `int` expression into `float`
- rejection of `float` into `int` assignment if narrowing is disallowed

Suggested test names:

- `test24_mixed_add.uC`
- `test25_mixed_mul.uC`
- `test26_float_assignment_from_int.uC`
- `invalid01_narrowing_float_to_int.uC`

### 0.3 Better compiler diagnostics

Why:

- current failure modes are still fairly course-project style
- language growth will make error handling much more important

Feature work:

- undefined-variable diagnostics
- clearer parse error messages with line/column
- unsupported-feature diagnostics where needed

Tests:

- undefined variable read
- undefined variable assignment
- malformed expression
- missing semicolon

Suggested test names:

- `invalid02_undefined_variable_assign.uC`
- `invalid03_parse_missing_semicolon.uC`

## Phase 1: Basic Statement and Expression Coverage

These features give the biggest improvement in C-like usability for the least
amount of machinery.

### 1.1 Local variable declarations

Status:

- implemented for `int` and `float` declarations inside function and nested
  block scope
- covered by active regressions `test27` and `test28`

Current gap:

- the grammar has `var_decls`, but function bodies do not actually admit local
  declarations yet

Feature work:

- allow local `int` / `float` declarations inside blocks
- wire local declarations into `LocalScope`
- generate stack or frame-relative access consistently

Tests:

- local variable declaration at function top
- local variable initialized via later assignment
- local shadows global
- multiple locals in same block

Suggested test names:

- `test27_local_int_decl.uC`
- `test28_local_float_decl.uC`
- `test29_local_shadows_global.uC`

### 1.2 Nested block scopes

Status:

- implemented for bare block statements with nested scope and shadowing
- covered by active regression `test29`

Current gap:

- `if` and `while` bodies exist, but explicit nested block scoping is still too
  limited for more realistic C code

Feature work:

- support bare blocks `{ ... }` as statements
- push/pop scopes for nested blocks
- preserve shadowing rules across blocks

Tests:

- variable declared in inner block only
- shadowed variable inside nested block
- use-after-block should fail

Suggested test names:

- `test30_nested_block_scope.uC`
- `invalid04_use_outside_block.uC`

### 1.3 Modulus operator `%`

Status:

- implemented for integer operands
- covered by active regression `test31`

Why:

- `%` is one of the most useful missing integer operators
- several existing arithmetic examples would become more natural

Feature work:

- parser support for `%`
- integer-only semantic restriction
- code generation with integer remainder instruction or equivalent lowering

Tests:

- simple `%`
- `%` in loop
- `%` precedence relative to `+` and `*`
- rejection on float operands

Suggested test names:

- `test31_mod_basic.uC`
- `test32_mod_loop.uC`
- `invalid05_mod_float_operand.uC`

### 1.4 Boolean connectives in conditions

Status:

- `&&`, `||`, and `!` are implemented
- covered by active regressions `test33`, `test34`, and `test35`

Feature work:

- `&&`
- `||`
- `!`
- short-circuit semantics

Tests:

- `if (a < b && b < c)`
- `if (a == 0 || b == 0)`
- `if (!(a < b))`
- short-circuit where right-hand side would be unsafe or unwanted

Suggested test names:

- `test33_logical_and.uC`
- `test34_logical_or.uC`
- `test35_logical_not.uC`
- `test36_short_circuit_and.uC`

### 1.5 `for` loops

Status:

- implemented by lowering `for (init; cond; step)` into an initializer plus an
  ordinary `while`
- covered by active regression `test37`

Feature work:

- parser support for `for (init; cond; step)`
- lowering to existing loop codegen machinery

Tests:

- counting loop
- empty init
- empty step
- loop-local declaration once local decls exist

Suggested test names:

- `test37_for_basic.uC`
- `test38_for_missing_step.uC`

## Phase 2: Function Coverage

This is the largest single jump from “MicroC” toward “real C”.

### 2.1 Multiple functions

Status:

- expression-bodied helper functions with one parameter are implemented via
  parser-level inline expansion
- covered by active regression `test39`

Current gap:

- `main` is still the only emitted runtime entry point
- `return` in `main` still lowers directly to `HALT`
- this is not yet a full calling-convention implementation

Feature work:

- parse a list of functions
- represent functions in the AST
- emit labels per function
- distinguish `return` from whole-program halt

Tests:

- helper function returning int
- helper function returning float
- function called multiple times

Suggested test names:

- `test39_one_helper_function.uC`
- `test40_float_return_function.uC`

### 2.2 Parameters and arguments

Status:

- one-argument helper functions are supported through the inline-expansion path
- covered by active regression `test41`

Feature work:

- typed parameter lists
- argument passing
- call expressions
- local scope binding for parameters

Tests:

- one-argument function
- two-argument function
- nested calls
- mixed int/float arguments

Suggested test names:

- `test41_function_one_arg.uC`
- `test42_function_two_args.uC`
- `test43_nested_calls.uC`

### 2.3 `void` functions and empty return

Feature work:

- `void` in grammar and type system
- `return;`
- calling functions for side effects only

Tests:

- `void print_twice(...)`
- `return;` in `void` function
- reject returning expression from `void`

Suggested test names:

- `test44_void_function.uC`
- `invalid06_void_returns_value.uC`

## Phase 3: Data and Memory Features

These move the compiler closer to recognizable C programming.

### 3.1 Arrays

Status:

- basic fixed-size array declarations and indexed element access are
  implemented
- covered by active regression `test45`

Feature work:

- declarations like `int a[10];`
- indexing `a[i]`
- address arithmetic

Tests:

- write/read array elements
- loop over array
- array index expression

Suggested test names:

- `test45_array_basic.uC`
- `test46_array_loop.uC`

### 3.2 Character type and character/string literals

Feature work:

- `char`
- character literals
- printing character values or treating chars as ints initially

Tests:

- char assignment
- char comparisons
- escape characters

Suggested test names:

- `test47_char_basic.uC`
- `test48_char_escape.uC`

### 3.3 Pointers

Feature work:

- address-of `&`
- dereference `*`
- pointer assignment

Tests:

- pointer to local int
- write through pointer
- pointer aliasing

Suggested test names:

- `test49_pointer_basic.uC`
- `test50_pointer_store.uC`

## Phase 4: Richer C Surface Syntax

These improve source compatibility and ergonomics.

### 4.1 Declaration initialization

Feature work:

- `int x = 3;`
- `float y = 2.5;`
- local declaration initialization

Tests:

- global initialized int
- local initialized float
- initialized declaration from expression

Suggested test names:

- `test51_decl_init_global.uC`
- `test52_decl_init_local.uC`

### 4.2 Increment/decrement and compound assignment

Feature work:

- `++x`, `x++`
- `--x`, `x--`
- `+=`, `-=`, `*=`, `/=`

Tests:

- prefix increment in loop
- postfix increment semantics
- compound assignment on int and float

Suggested test names:

- `test53_prefix_increment.uC`
- `test54_postfix_increment.uC`
- `test55_compound_assign.uC`

### 4.3 `break` and `continue`

Feature work:

- loop control flow extensions

Tests:

- break from `while`
- continue in `for`
- nested-loop break

Suggested test names:

- `test56_break_while.uC`
- `test57_continue_for.uC`

## Phase 5: True C-Like Front-End Growth

These are larger goals and should probably wait until functions and memory
features are stable.

### 5.1 Preprocessor-lite support

Feature work:

- possibly only `#define` constants at first

Tests:

- macro constant in arithmetic
- macro constant in condition

### 5.2 Structs

Feature work:

- `struct` declarations
- field access
- assignment and passing by value/reference policy

Tests:

- simple record with two fields
- nested field access

### 5.3 Better string model

Current gap:

- `string` is a project-level teaching convenience, not C `char*`

Feature work:

- decide whether to keep `string` as an extension
- or replace it with a more C-like string/pointer model

Tests:

- string literal assignment semantics
- printing string pointer-like values

## Priority Order

If the goal is steady improvement with the least rework, the recommended order
is:

1. Phase 0 correctness fixes
2. local declarations
3. nested blocks
4. modulus
5. logical operators
6. `for`
7. multiple functions
8. parameters and calls
9. arrays
10. declaration initialization

## Notes From Current Code

Some concrete observations from the current codebase that should guide feature
work:

- [MicroC.g4](MicroC.g4:31) only parses one function
- [MicroC.g4](MicroC.g4:57) hardcodes `int main()`
- [src/assembly/CodeGenerator.java](src/assembly/CodeGenerator.java:297) still
  has comments indicating pointer support is not ready
- [src/assembly/CodeGenerator.java](src/assembly/CodeGenerator.java:813)
  currently treats `return` as `HALT`
- [src/ast/FloatLitNode.java](src/ast/FloatLitNode.java:1) appears to tag float
  literals with `INT`, which should be corrected before deeper type work

This backlog should be updated whenever a feature lands or when a proposed test
turns out to require different runtime conventions than originally expected.
