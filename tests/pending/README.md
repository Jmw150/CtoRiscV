# Pending Language Coverage

These tests are intentionally not part of the default `make test` workflow yet.

They are specification tests for language features listed in
[TODO.md](/home/jmw150/backup/code/projects/c_compiler/TODO.md:1). Some of them
currently fail to parse, some compile but fail at runtime, and some require new
error-reporting infrastructure.

When a feature is implemented, the intended promotion path is:

1. move the source into the active top-level `tests/` directory if it should
   become a passing regression
2. add a matching `tests/expected/*.out`
3. wire any rejection cases into a future invalid-test harness
