# Documentation for the custom Unicode Bracketed Expression Engine (ubrex)

This engine uses a non-standard syntax based on specific symbols to define character sets, quantifiers, groups, alternatives, and classes.

These expressions are known as **unicode bracketed expressions** or **ubrex** for short. The documentation below details the current syntax design.

## Standard Characters

In **ubrex**, only a **small, well-defined set** of characters from the Unicode blocks `U+2200`, `U+2500`, and `U+3000` are used as special syntax elements. This results in a **clean and minimal syntax**, where:

- **All standard characters (letters, digits, punctuation)** are treated **literally** and do **not require escaping**.
- The **standard ASCII space character (`U+0020`) is ignored by the parser**, allowing you to use spaces freely to improve readability.

If you need to match specific characters that might otherwise be ignored or treated specially, the following conventions apply:

| Character          | Representation in ubrex | Purpose/Effect                                                                                 |
| ------------------ | ----------------------- | ---------------------------------------------------------------------------------------------- |
| Space (`U+0020`)   | `<SPACE>` (ignored)     | Insert freely for readability; does **not affect matching**.                                   |
| Literal space      | `∙`                     | Matches a **literal space** in the input string.                                               |
| Double quote (`"`) | `〃`                     | Serves as a **replacement for `"`**, avoiding the need for escaping in environments like Java. |

### Example

| Pattern                           | Matches Exactly                   | Explanation                                                                                                            |
| --------------------------------- | --------------------------------- | ---------------------------------------------------------------------------------------------------------------------- |
| `This∙is∙a∙dot∙(.)∙and∙2∙+∙3∙=∙4` | `This is a dot (.) and 2 + 3 = 4` | `∙` explicitly matches spaces; special characters (`.`, `(`, `)`, `+`, `=`) are treated literally, no escaping needed. |

### Key Notes

- **Spaces (`U+0020`) are ignored**: You can use them to format and align your patterns.
- **Literal space matching requires `∙`**.
- **The `〃` character avoids double quote escaping**, making patterns easier to integrate into source code (e.g., Java strings).

This design simplifies reading and writing expressions while preserving expressiveness and precision.

## Character Sets

Character sets allow you to specify, for a given position in a string, a defined set of characters that are either allowed or disallowed.

| Type             | Syntax          | Example       | Description                                                                                                            |
| ---------------- | --------------- | ------------- | ---------------------------------------------------------------------------------------------------------------------- |
| **Simple Set**   | `「…」`           | `「abced0123」` | All characters enclosed within `「` and `」` form the **allowed set** for that position.                                 |
| **Range**        | `「char1〜char2」` | `「a〜c」`       | The `〜` symbol defines a range. In this example, all characters from `a` to `c` (inclusive) are accepted.              |
| **Negative Set** | `「〤…」`          | `「〤a〜c」`      | The prefix `〤` denotes a **negative set**, meaning any character **except** those between `a` and `c` will be matched. |

### Combining Elements

Character sets can combine explicit characters, ranges, and negative sets:

| Example        | Description                                                                                                                              |
| -------------- | ---------------------------------------------------------------------------------------------------------------------------------------- |
| `「〤abcedf0〜9」` | This **negative set** excludes characters `a`, `b`, `c`, `e`, `d`, `f`, and all digits from `0` to `9`. Any other character is accepted. |
| `「a〜z〤fi〜k」`   | This set allows **all lowercase letters from `a` to `z`** except `f`, `i`, `j`, and `k`, which are explicitly excluded.                  |

## Predefined Classes

Predefined classes allow you to reference commonly used character sets using the symbol `〴` followed by an identifier. These provide shorthand representations for frequently used character groups.

Additionally, using **uppercase identifiers negates the class**, meaning it matches **everything except** the specified set.

| Class     | Description                                                                                                                                               |
| --------- | --------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **`〴w`**  | Matches **word characters**, including **letters, digits, and underscore (`_`)**, similar to `\w` in traditional regex.                                   |
| **`〴d`**  | Matches any **digit (`0-9`)**, equivalent to `\d` in traditional regex.                                                                                   |
| **`〴s`**  | Matches **whitespace characters**, including **spaces, tabs, and line breaks**, similar to `\s`.                                                          |
| **`〴le`** | Matches **any letter in Unicode**, covering **all alphabets and scripts worldwide**, including Latin (`A-Z`), Cyrillic, Greek, Chinese, Arabic, and more. |
| **`〴an`** | Matches **any alphanumeric character in Unicode**, including **letters (`〴le`) and digits** from all writing systems.                                     |
| **`〴g`**  | Matches **any double-quote character in Unicode**, including: **ASCII double quotes**: `"` and **Typographic quotes**: `""`                               |
| **`〴.`**  | Matches **any character in Unicode**, similar to `.` in traditional regex.                                                                                |

## Quantifiers

Quantifiers specify how many times a given pattern must occur. In **ubrex**, the quantifier symbol `〇` **precedes** the pattern it applies to.

Unlike traditional regular expressions, **ubrex quantifiers are [possessive](https://www.regular-expressions.info/possessive.html)**, meaning they do not allow backtracking.

| Quantifier | Example        | Description                                                                                             |
| ---------- | -------------- | ------------------------------------------------------------------------------------------------------- |
| `〇?`       | `〇?a`          | The pattern `a` is **optional**, meaning it may appear **0 or 1 time**.                                 |
| `〇*`       | `〇*a`          | The pattern `a` may appear **zero or more times**.                                                      |
| `〇+`       | `〇+a`          | The pattern `a` must appear **at least once** (one or more times).                                      |
| `〇{n}`     | `〇{2}a`        | The pattern `a` must appear **exactly** `n` times (in this case, **2 times**).                          |
| `〇{n+}`    | `〇{2+}a`       | The pattern `a` must appear **at least** `n` times (in this case, **at least 2 times**).                |
| `〇{m-n}`   | `〇{1-3}a`      | The pattern `a` must appear **between `m` and `n` times** (here, **between 1 and 3 times**).            |
| `〇{m;n}`   | `〇{2;4-6;8+}a` | The pattern `a` matches if it occurs **2 times**, or between **4 and 6 times**, or **8 or more times**. |

### Important Notes

- In **ubrex**, the **quantifier always comes before** the pattern it modifies.
- Quantifiers are [possessive](https://www.regular-expressions.info/possessive.html), meaning they do **not** allow backtracking.

## Groups

Groups allow you to combine patterns so that you can apply quantifiers collectively.

### Syntax

```
〘 … 〙
```

Enclosing a pattern within `〘 … 〙` creates a **group**, enabling **collective processing** of the enclosed pattern.

| Example     | Description                                                                                                                                                                                                  | Matching Strings             |
| ----------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ | ---------------------------- |
| `a 〇+〘bc〙z` | The grouped pattern `bc` is quantified by `〇+`, meaning the **sequence `bc` must appear one or more times**. The full pattern matches `a`, followed by **one or more occurrences of `bc`**, followed by `z`. | `abcz`, `abcbcz`, `abcbcbcz` |

### Important Notes

- **Grouping applies quantifiers to the entire enclosed pattern** rather than individual characters.
- **Quantifiers precede the group** and apply to the entire enclosed pattern.

## Logical Alternatives

Logical alternatives allow you to specify multiple possible patterns at a given position. This is useful for defining flexible matching conditions.

Alternatives are tested in sequence, so the **order matters**.

### Syntax

```
【 alternative1 ┇ alternative2 ┇ … 】
```

Each **alternative** inside the brackets is separated by `┇`, meaning **any one of the specified alternatives can match**.

| Example                       | Description                                                                                                              | Matching Strings      |
| ----------------------------- | ------------------------------------------------------------------------------------------------------------------------ | --------------------- |
| `a【<┇/┇.】c`                   | Between `a` and `c`, **one of the following must match**: `<`, `/`, or `.`                                               | `a<c`, `a/c`, `a.c`   |
| `a【〇{1-2}<┇〇{1-2}/┇〇{1-2}.】c` | Each alternative (`<`, `/`, `.`) **must appear between 1 and 2 times**. Each alternative is **quantified independently** | `a<c`, `a//c`, `a..c` |

## Capture

Capture allows you to assign a **name** to a pattern, enabling later reference and retrieval of its matched value. This is useful for extracting, reusing, or processing specific parts of a match.

### Syntax

```
〶$<name>=<pattern>
```

| Component | Description                                             |
| --------- | ------------------------------------------------------- |
| `〶$`      | Indicates the start of a capture.                       |
| `<name>`  | Assigns a **unique name** to the captured pattern.      |
| `=`       | Separates the name from the **pattern to be captured**. |

### Example

| Example       | Description                                                                                    | Input Example | Captured Value |
| ------------- | ---------------------------------------------------------------------------------------------- | ------------- | -------------- |
| `〶$NAME=〇+〴w` | Captures a **sequence of one or more word characters** (`〴w`) under the identifier **`NAME`**. | `hello123`    | `hello123`     |

### Key Notes

- **Captured values can be referenced later** within the same expression or during post-processing.
- **Naming ensures clarity** and avoids reliance on positional capture groups found in traditional regex.
- **Capture groups can be combined** with quantifiers, logical alternatives, and other patterns for advanced matching.

## Up-to Pattern

Since **repetitions in ubrex are [possessive](https://www.regular-expressions.info/possessive.html)**, they **do not allow backtracking**. This can sometimes lead to unintended behavior when searching for patterns within a sequence.

To solve this, **ubrex introduces the "up-to" pattern**, which allows matching **everything up to a specific endpoint** while maintaining control over the characters being consumed.

### Basic Syntax

```
〄>[PATTERN]
```

| Component   | Description                                                          |
| ----------- | -------------------------------------------------------------------- |
| `〄>`        | Consume all characters **until** the specified `[PATTERN]` is found. |
| `[PATTERN]` | Stopping condition—matching stops once this pattern is encountered.  |

#### Example

| Pattern | Input String       | Match Result     | Explanation                                                                            |
| ------- | ------------------ | ---------------- | -------------------------------------------------------------------------------------- |
| `a〄>1`  | `anything until 1` | `anything until` | Starts with `a`, consumes **everything until** `1`. Matching stops just **after** `1`. |

### Advanced Syntax

The basic syntax **accepts any character** until the stop pattern is reached. However, you can also **restrict which characters are consumed** before encountering the stop condition.

```
〄[REPETITION][PATTERN1] -> [PATTERN2]
```

| Component      | Description                                             |
| -------------- | ------------------------------------------------------- |
| `[REPETITION]` | Repetition pattern, could be `+`, `*`, `?`, `{...}`     |
| `[PATTERN1]`   | Characters allowed to be consumed.                      |
| `->`           | Pattern separator.                                      |
| `[PATTERN2]`   | Stop pattern—matching stops when this pattern is found. |

#### Example

| Pattern                | Input String | Captured Value | Explanation                                                                               |
| ---------------------- | ------------ | -------------- | ----------------------------------------------------------------------------------------- |
| `〶$NAME=〄+〴w ->〘zend〙` | `abcdzend`   | `abcd`         | Captures only **word characters** up to the sequence `zend`. Matching stops after `zend`. |

### Key Notes

- **"Up-to" patterns provide flexible, efficient searching** for delimiters or boundaries.
- **They can be refined to consume only specific types of characters**, ensuring more precise matching.
- Since quantifiers in ubrex are [possessive](https://www.regular-expressions.info/possessive.html), "up-to" patterns prevent overconsumption by clearly defining stop conditions.

## LookAround

LookAround assertions allow you to check whether a given pattern **exists (or does not exist)** at a certain position, **without consuming any characters** in the input. This is useful for conditional matching based on the surrounding context.

All lookaround assertions use the `〒` symbol followed by a **type specifier** in parentheses, then the pattern to assert.

### Syntax

```
〒(<type>)<pattern>
```

| Type                    | Syntax  | Name                  | Description                                                                                                                                                |
| ----------------------- | ------- | --------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **Positive LookAhead**  | `〒(=)`  | *LookAhead Positive*  | Succeeds if `<pattern>` **matches** immediately after the current position. Does **not** advance the position.                                             |
| **Negative LookAhead**  | `〒(!)`  | *LookAhead Negative*  | Succeeds if `<pattern>` **does not match** immediately after the current position. Does **not** advance the position.                                      |
| **Positive LookBehind** | `〒(<=)` | *LookBehind Positive* | Succeeds if `<pattern>` **matches** immediately before the current position (by examining characters already consumed). Does **not** advance the position. |
| **Negative LookBehind** | `〒(<!)` | *LookBehind Negative* | Succeeds if `<pattern>` **does not match** immediately before the current position. Does **not** advance the position.                                     |
| **End of Text**         | `〒($)`  | *End of Text*         | Succeeds only if the current position is at the **end of the input text**.                                                                                 |

### Key Concepts

- **Zero-width assertions**: LookAround patterns **do not consume characters**. They succeed or fail at the current position, and the matching cursor does not move.
- **LookAhead** inspects what comes **after** the current position.
- **LookBehind** inspects what comes **before** the current position (the already-consumed part of the string is examined in reverse).

### LookAhead Examples

| Pattern                | Input | Result       | Explanation                                                                                                                                                            |
| ---------------------- | ----- | ------------ | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `a 〒(=)b`              | `abc` | `a`          | Matches `a`, then asserts that `b` follows. It does, so the match succeeds. Only `a` is consumed.                                                                      |
| `a 〒(=)b`              | `a`   | *(no match)* | Matches `a`, then asserts that `b` follows. It does not, so the match fails.                                                                                           |
| `a 〒(=)b`              | `aa`  | *(no match)* | Matches `a`, then asserts that `b` follows. `a` is found instead, so the match fails.                                                                                  |
| `a 〒(!)b`              | `abc` | *(no match)* | Matches `a`, then asserts that `b` does **not** follow. But `b` is present, so the match fails.                                                                        |
| `a 〒(!)b`              | `a`   | `a`          | Matches `a`, then asserts that `b` does **not** follow. End of input means no `b`, so the match succeeds.                                                              |
| `a 〒(!)b`              | `aa`  | `a`          | Matches `a`, then asserts that `b` does **not** follow. `a` follows (not `b`), so the match succeeds.                                                                  |
| `a【 ; ┇ 〒(!)「〴w;:.」 】` | `a;`  | `a;`         | After `a`, tries `;` first—matches.                                                                                                                                    |
| `a【 ; ┇ 〒(!)「〴w;:.」 】` | `a,`  | `a`          | After `a`, tries `;`—fails. Then tries negative lookahead asserting next char is **not** in `「〴w;:.」`. `,` is not in that set, so the assertion succeeds (zero-width). |
| `a【 ; ┇ 〒(!)「〴w;:.」 】` | `a.`  | *(no match)* | After `a`, tries `;`—fails. Then tries negative lookahead—but `.` **is** in `「〴w;:.」`, so the assertion fails. No alternative matches.                                 |

### Summary of LookAround Symbols

| Symbol | Unicode Block | Usage                              |
| ------ | ------------- | ---------------------------------- |
| `〒`    | `U+3000`      | Introduces a LookAround assertion. |
| `(=)`  | ASCII         | Positive LookAhead specifier.      |
| `(!)`  | ASCII         | Negative LookAhead specifier.      |
| `(<=)` | ASCII         | Positive LookBehind specifier.     |
| `(<!)` | ASCII         | Negative LookBehind specifier.     |
| `($)`  | ASCII         | End of Text specifier.             |

## General considerations

### Use of Unicode U+3000 Separators

A key design choice in the ubrex syntax is the use of separator characters from the Unicode block [U+3000 CJK Symbols and Punctuation](https://en.wikipedia.org/wiki/CJK_Symbols_and_Punctuation). Two characters from the `U+2200` block (`∙`) and the `U+2500` block (`┇`) are also employed.

Although this approach may occasionally require **copying and pasting specific symbols**, it greatly enhances readability by reducing the need to escape common ASCII characters and minimizing visual clutter.

Moreover, in practice, **we tend to read regex and ubrex far more often than we write them**. This means that **optimizing for readability is more important than optimizing for ease of writing**. A syntax that is visually clear and easy to interpret reduces errors, improves maintainability, and enhances collaboration—making it a more efficient long-term choice despite a slightly higher initial input effort.

### Summary of Symbols and Delimiters

| Symbol/Delimiter | Unicode Block | Usage                                              |
| ---------------- | ------------- | -------------------------------------------------- |
| `∙`              | `U+2200`      | Represents a literal space character               |
| `<SPACE>`        | `ascii`       | Standard space are ignored, used for readability.  |
| `〃`              | `U+3000`      | Represents a standard *double quote* character `"` |
| `〴`              | `U+3000`      | Predefined class introducer.                       |
| `「 … 」`          | `U+3000`      | Delimits a set of characters or a range.           |
| `〤`              | `U+3000`      | Prefix indicating a negative set.                  |
| `〜`              | `U+3000`      | Separates the start and end of a range.            |
| `〇`              | `U+3000`      | Introduces a quantifier.                           |
| `〄`              | `U+3000`      | Introduces an *up-to* pattern.                     |
| `〒`              | `U+3000`      | Introduces a *LookAround* pattern.                 |
| `〶`              | `U+3000`      | Marks the beginning of a named capture.            |
| `〘 … 〙`          | `U+3000`      | Delimits a group.                                  |
| `【 … 】`          | `U+3000`      | Delimits a set of alternatives.                    |
| `┇`              | `U+2500`      | Separator for alternatives within a group.         |

- **Extensions and Evolution:** This documentation describes the syntax as currently implemented. Future adjustments or extensions may be introduced based on evolving requirements and user feedback.
