# COS 226 f25 - Precept 1: Find the bug in quick-find union()

## Test case that proves the bug

- Number of elements: `n = 3`
- Operations:
    1. `union(0, 1)`
    2. `union(0, 2)`
- Check: `i = 0`, `j = 1`

## Why it fails

In the buggy implementation:

```java
if (leader[i] == leader[p]) leader[i] = leader[q];
leader[p] is read inside the loop and can be overwritten when i == p. So later elements that belonged to the old component are compared against a new value of leader[p] and may be skipped.