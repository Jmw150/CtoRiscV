# Test Layout

The top-level `tests/test*.uC` files are the active regression suite exercised
by `make test`.

Additional coverage that is useful but not yet wired into the default test flow
lives in:

- `tests/pending/valid/`
  Programs for planned language features that should compile and run once the
  feature is implemented.
- `tests/invalid/`
  Programs that should eventually be rejected with clear diagnostics.

This split lets the project grow its test inventory without breaking the
current green baseline.
