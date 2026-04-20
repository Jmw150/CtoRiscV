# C99 Compliance Roadmap

This file tracks what would be required to evolve the current teaching-oriented
MicroC compiler into something approaching full C99 compliance.

That is a much larger goal than “add a few more C-like features.” It requires
changes at every layer:

- lexer and parser
- AST design
- name and type analysis
- storage layout and ABI decisions
- code generation
- runtime/library story
- diagnostics and conformance testing

The current compiler already supports a useful instructional subset, but it is
still structurally far from full C99. In particular:

- `main` is still the only true runtime entry point
- helper functions are currently implemented by inline expansion rather than a
  real calling convention
- the type system is very small
- arrays and locals use a simplified storage model
- there is no preprocessor
- there is no representation of many core C declaration forms

For that reason, this roadmap is split into:

1. foundational compiler work that must happen before broad language growth
2. feature groups required for meaningful C99 compatibility
3. conformance, diagnostics, and project-organization work needed to make the
   result believable

This is intentionally long and explicit. The main goal is to make the path to
“real C” understandable rather than magical.

## Reading The Goal Honestly

“Full C99 compliance” is not one feature. It means the compiler should accept
and correctly implement the language described by ISO C99, including tricky
corner cases and many interactions between features.

In practice, the biggest missing pillars today are:

- a real declaration/type system
- a real function model and calling convention
- pointer and memory semantics
- struct/union/enum support
- expression semantics close to C
- preprocessing
- diagnostics and a much larger test suite

Before aiming for strict compliance, it is worth deciding whether the target is:

- educational C99 coverage
- “large practical subset of C99”
- or actual standards-oriented conformance

This list assumes the long-term target is the strictest of those three.

## Phase 0: Compiler Foundation Rework

These are not glamorous language features, but without them the project will
accumulate hacks faster than it gains real C support.

### 0.1 Replace the current ad hoc function model

Must add:

- AST nodes for translation units, function definitions, declarations, and
  parameter lists
- real symbol-table entries for functions
- support for multiple functions as first-class compile targets
- a distinction between function calls, returns, and whole-program halt

Must decide:

- target calling convention
- argument passing strategy
- return value strategy
- caller-saved vs callee-saved register discipline
- recursion support

Tests:

- direct call
- repeated calls
- nested calls
- recursion
- mixed return types

### 0.2 Replace the simplified local-storage model with real stack frames

Must add:

- frame layout per function
- separate handling for locals, parameters, spills, temporaries, and return
  address storage
- block-scope storage rules that compose with function frames
- support for addressable locals

Tests:

- multiple locals of mixed sizes
- calls inside functions with locals
- recursive functions
- taking addresses of locals

### 0.3 Redesign the type system

Must add:

- first-class type objects instead of scattered enums
- qualifiers and storage information
- complete representation for scalar, aggregate, pointer, array, and function
  types
- type equality, compatibility, decay, promotions, and usual arithmetic
  conversions

Must support:

- declarator-driven types rather than “base type plus name” only
- incomplete vs complete types
- lvalue/rvalue distinctions consistent with C

Tests:

- type compatibility checks
- promotion rules
- invalid assignment diagnostics
- invalid redeclaration diagnostics

### 0.4 Introduce a clearer compilation pipeline

Must add:

- explicit parse phase
- AST or IR normalization phase
- semantic analysis phase
- lowering/codegen phase
- clear error accumulation and reporting

Why:

- full C needs more than parser-time AST construction and incidental checking

### 0.5 Add robust diagnostics infrastructure

Must add:

- source locations on tokens and AST nodes
- parse errors with line/column context
- semantic errors with related source spans
- warnings vs errors
- better unsupported-feature reporting during bring-up

Tests:

- malformed declarations
- incompatible pointer types
- invalid lvalues
- missing returns
- duplicate definitions

## Phase 1: Translation Units, Declarations, and Storage Classes

This phase makes the front end look like C instead of a custom teaching
language.

### 1.1 Full translation unit support

Must add:

- multiple declarations and definitions per file
- function prototypes
- tentative definitions
- external declarations
- interleaving of declarations and definitions

Tests:

- prototype before definition
- multiple globals
- tentative definition rules
- duplicate definition rejection

### 1.2 Storage classes

Must add:

- `auto`
- `register`
- `static`
- `extern`
- `typedef`

Must implement:

- scope rules
- linkage rules
- internal vs external linkage
- file-scope and block-scope behavior

Tests:

- internal linkage with `static`
- external declaration with `extern`
- typedef name reuse and shadowing

### 1.3 Qualified types

Must add:

- `const`
- `volatile`
- `restrict`
- combinations of qualifiers

Tests:

- const object assignment rejection
- qualified pointer conversions
- `restrict` parsing and representation

### 1.4 C declarator syntax

Must add:

- pointer declarators
- array declarators
- function declarators
- parenthesized declarators
- combinations such as pointer-to-function and array-of-pointer

Tests:

- `int *p;`
- `int (*fp)(int);`
- `int *a[4];`
- `int (*a)[4];`

## Phase 2: Real Function Semantics

### 2.1 Parameter lists and prototypes

Must add:

- zero-argument functions vs old-style declarations as policy choice
- typed parameter lists
- parameter scope and storage
- function type compatibility

Tests:

- one and many parameters
- prototype mismatch rejection
- call arity mismatch rejection

### 2.2 Returns and control flow

Must add:

- `return;`
- `return expr;`
- non-void/void checking
- function epilogues

Tests:

- `void` functions
- missing return paths
- returning wrong type

### 2.3 Recursion and mutual recursion

Must add:

- label generation and linking that supports recursive code
- correct frame behavior across nested calls

Tests:

- factorial
- mutually recursive predicates

### 2.4 Variadic functions

Must add:

- support for `...`
- ABI plan for variadic argument access
- handling of default argument promotions

Tests:

- parsing of variadic prototype
- minimal runtime example if `stdarg.h` support exists

Note:

- this is required for serious C99 coverage, but can come later than ordinary
  function calls

## Phase 3: Full Expression Semantics

This phase is where a “C-like” parser becomes a real C expression compiler.

### 3.1 Unary operators

Must add:

- unary `+`
- bitwise `~`
- logical `!` with proper scalar semantics
- address-of `&`
- dereference `*`
- prefix `++` and `--`
- `sizeof`

Tests:

- pointer dereference and store
- `sizeof(int)`
- `sizeof array`
- prefix increment on lvalues

### 3.2 Binary operators

Must add:

- shifts `<<`, `>>`
- bitwise `&`, `^`, `|`
- logical `&&`, `||` with correct scalar truth rules
- comma operator

Tests:

- bit operations
- precedence ladders
- comma expressions in `for`

### 3.3 Assignment-family operators

Must add:

- `=`
- `+=`, `-=`, `*=`, `/=`, `%=`
- `<<=`, `>>=`, `&=`, `^=`, `|=`

Tests:

- compound assignment to integers
- pointer plus integer via `+=`
- invalid compound assignments

### 3.4 Conditional operator

Must add:

- `cond ? a : b`
- type rules for result selection

Tests:

- scalar branches
- pointer branches
- nested conditional expressions

### 3.5 Casts and conversions

Must add:

- explicit cast syntax
- integer promotions
- usual arithmetic conversions
- pointer conversions allowed by C
- null pointer constant handling

Tests:

- `(float) x`
- `(int *) 0`
- invalid cast diagnostics

### 3.6 Lvalues, rvalues, and decay rules

Must add:

- array-to-pointer decay
- function-to-pointer decay
- modifiable lvalue checks
- proper behavior for assignment and increment

Tests:

- assigning to non-lvalue rejection
- array expression in call context
- function designator usage

## Phase 4: Scalar Types

### 4.1 Integer types

Must add:

- `char`
- `signed char`
- `unsigned char`
- `short`
- `unsigned short`
- `int`
- `unsigned int`
- `long`
- `unsigned long`
- `long long`
- `unsigned long long`
- `_Bool`

Must implement:

- integer rank
- signedness behavior
- promotions and overflow semantics as far as codegen target allows

Tests:

- cross-type arithmetic
- comparison edge cases
- signed vs unsigned conversions

### 4.2 Floating types

Must add:

- `float`
- `double`
- `long double` representation choice

Must implement:

- arithmetic conversions with integers
- return/argument passing for floating types

Tests:

- mixed numeric expressions
- function args/returns with float and double

### 4.3 Enumerations

Must add:

- `enum` definitions
- enumerator values
- use of enum constants in expressions

Tests:

- explicit and implicit enumerator values
- enum compatibility rules

## Phase 5: Pointers, Arrays, and Memory

### 5.1 Pointer semantics

Must add:

- typed pointers
- pointer arithmetic
- pointer comparison
- null pointer constants
- pointer difference where supported

Tests:

- walk an array with a pointer
- aliasing through pointers
- pointer comparisons

### 5.2 Arrays

Must add beyond the current basic implementation:

- local arrays
- parameter arrays
- multidimensional arrays
- initializer support
- correct decay in expression contexts
- string-literal initialization for char arrays

Tests:

- local stack array
- multidimensional indexing
- char array from string literal

### 5.3 Dynamic allocation story

Not required by the language core itself, but needed for realistic programs if
the goal includes hosted-style usability.

Must decide:

- whether to support library calls like `malloc`/`free`
- whether to provide a runtime shim

Tests:

- allocation call ABI
- pointer round-trip through heap

## Phase 6: Aggregates and User-Defined Types

### 6.1 Structs

Must add:

- `struct` definitions
- named and anonymous forms as chosen
- field access `.`
- pointer field access `->`
- layout and alignment rules
- assignment and copying behavior

Tests:

- simple struct object
- nested struct field access
- struct passed by value

### 6.2 Unions

Must add:

- `union` definitions
- shared storage layout
- field access semantics

Tests:

- write one field, read another
- union size and alignment

### 6.3 Bit-fields

Must add:

- parser support
- layout policy
- load/store masking rules

Tests:

- packed fields
- signed/unsigned bit-field reads

### 6.4 Typedef-heavy forms

Must add:

- typedef use throughout declarators
- struct/union/enum tags vs typedef names

Tests:

- typedef of pointer type
- tag namespace interactions

## Phase 7: Statements and Control Flow

### 7.1 Statement coverage

Must add:

- empty statement
- declaration statements anywhere allowed by C99
- expression statements beyond assignment-centric forms

Tests:

- standalone function call
- comma expression statement

### 7.2 Loop and branch control

Must add:

- `break`
- `continue`
- `do ... while`
- full `for` initializer/condition/step expression semantics

Tests:

- nested break/continue
- `do ... while`
- comma operator in `for`

### 7.3 Switch

Must add:

- `switch`
- `case`
- `default`
- integral constant expression handling for case labels
- fallthrough behavior

Tests:

- dense and sparse switch values
- default case
- fallthrough

### 7.4 Labels and goto

Must add:

- user labels
- `goto`

Tests:

- forward goto
- backward goto
- label-scope diagnostics

## Phase 8: Initializers and Constant Expressions

### 8.1 Object initialization

Must add:

- scalar initializers
- aggregate initializers
- nested brace initializers
- zero-initialization defaults

Tests:

- global scalar init
- local aggregate init
- partial initializer behavior

### 8.2 Designated initializers

Required for C99.

Must add:

- struct designators
- array designators

Tests:

- `.x = 1`
- `[3] = 7`

### 8.3 Constant expressions

Must add:

- compile-time evaluation needed for array sizes, enum values, case labels, and
  static initializers

Tests:

- enum constant arithmetic
- array size from constant expression
- invalid non-constant case label

## Phase 9: Preprocessing

Strict C99 compliance requires preprocessing support, whether integrated or as a
separate front-end phase.

### 9.1 Macro support

Must add:

- object-like macros
- function-like macros
- macro expansion rules
- recursion guards

Tests:

- simple macro constant
- function-like macro
- nested expansion

### 9.2 Includes

Must add:

- `#include`
- include search path handling
- header guards behavior through macro expansion

Tests:

- project header include
- nested includes

### 9.3 Conditional compilation

Must add:

- `#if`
- `#ifdef`
- `#ifndef`
- `#elif`
- `#else`
- `#endif`

Tests:

- feature toggles
- nested conditionals

### 9.4 Pragmatic minimum for compliance

If a full preprocessor is deferred, the project cannot honestly claim C99
compliance yet.

## Phase 10: Standard Library and Environment Decisions

Pure language support and practical C99 support are different things.

Must decide whether the compiler targets:

- freestanding C99
- or a hosted environment approximation

### 10.1 Freestanding minimum

Must consider:

- startup/runtime entry
- required headers and built-ins
- integer and floating behavior expectations

### 10.2 Hosted-style usability

Must consider:

- `stdio`
- `stdlib`
- string/memory functions
- variadic runtime conventions

Note:

- full hosted support is much larger than language parsing/codegen alone

## Phase 11: Backend and ABI Work

Even with a correct front end, C99 coverage will fail without a much stronger
backend.

### 11.1 Data layout

Must add:

- size/alignment rules per type
- struct/union layout
- array layout
- stack alignment rules

### 11.2 Calling convention

Must add:

- argument registers/stack slots
- return registers
- varargs behavior
- prologue/epilogue generation
- saved register rules

### 11.3 Addressing modes and memory operations

Must add:

- byte, halfword, word, and possibly wider loads/stores
- sign extension vs zero extension
- pointer-sized arithmetic

### 11.4 Backend correctness work

Must add:

- better temporary management
- possibly a lower-level IR before final emission
- backend tests independent of parser tests

## Phase 12: Diagnostics, Warnings, and Tooling

### 12.1 Semantic diagnostics

Must add:

- incompatible types
- invalid conversions
- unreachable code warnings as chosen
- unused entity warnings as chosen

### 12.2 Parser recovery

Must add:

- better recovery so one syntax error does not destroy all later diagnostics

### 12.3 Developer tooling

Must add:

- stable CLI
- mode flags
- dump options for AST/IR/symbol tables
- versioned documentation

## Phase 13: Conformance and Test Strategy

This phase matters if “compliance” is meant literally instead of aspirationally.

### 13.1 Reorganize the test suite

Recommended layout:

- `tests/valid/` for programs expected to compile and run
- `tests/invalid/` for programs expected to fail semantically
- `tests/parser/` for syntax acceptance and rejection
- `tests/runtime/` for observable execution behavior
- `tests/conformance/` for standard-focused cases
- `tests/preprocessor/` for macro/include behavior

### 13.2 Build targeted compliance suites

Need:

- declaration tests
- type-system tests
- conversion tests
- control-flow tests
- aggregate tests
- pointer aliasing tests
- initializer tests

### 13.3 Run external suites eventually

Long-term goal:

- test against small external C conformance collections
- compare behavior against a reference compiler for selected cases

Note:

- until this phase is underway, “full C99 compliance” should be treated as a
  roadmap item, not a project status claim

## Phase 14: Optional Extensions To Keep Separate

These may be valuable, but they are not part of strict C99 compliance and
should remain clearly marked as extensions.

Examples:

- current `string` teaching extension
- custom built-in `read` / `print`
- simulator-specific intrinsics
- nonstandard convenience syntax

If the project retains these, document them as extensions rather than blending
them into the compliance story.

## Recommended Implementation Order

If the actual goal is to move steadily toward C99 with the least wasted work,
the recommended order is:

1. foundation rework: function model, stack frames, richer types, diagnostics
2. translation units, declarators, storage classes, and prototypes
3. ordinary function calls and returns
4. pointers, casts, lvalue rules, and `sizeof`
5. full scalar operator semantics and promotions
6. structs, unions, enums, and layout
7. initializers and constant expressions
8. switch, goto, and remaining statement forms
9. preprocessor support
10. broader conformance and diagnostics polish

## Practical Milestones

If the project needs shorter milestones rather than one giant destination, a
useful ladder is:

### Milestone A: “Real Small C”

Target:

- multiple real functions
- stack frames
- prototypes
- pointer basics
- `char`, `int`, `float`, `void`
- `break`, `continue`, `do-while`

### Milestone B: “Systems Programming Subset”

Target:

- structs
- enums
- local/global arrays
- casts
- `sizeof`
- better initializer support

### Milestone C: “Pre-C99 Compliance Candidate”

Target:

- qualifiers
- unions
- designated initializers
- variadics
- switch/goto
- much stronger diagnostics

### Milestone D: “C99 Compliance Push”

Target:

- preprocessor
- constant-expression coverage
- conformance-driven bug fixing
- serious external test validation

## Notes From Current Codebase

Some high-level architectural observations that matter for this roadmap:

- the parser still reflects a teaching-language grammar, not general C
- the function story is still partly syntax-directed and not yet ABI-driven
- the backend currently assumes a very small type and storage model
- extension features like `string`, `read`, and `print` should eventually be
  separated from the standards story
- the existing active tests are useful regression anchors, but they are far too
  small to demonstrate anything close to compliance

## Bottom Line

To reach full C99 compliance, the project needs more than feature additions. It
needs a transition from a compact teaching compiler into a real front-end and
backend architecture for C.

That is absolutely a worthwhile project, but it should be approached as a
multi-phase compiler redesign with conformance testing, not as a sequence of
isolated syntax tweaks.
