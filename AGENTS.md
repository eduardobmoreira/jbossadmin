# AGENTS.md - Employment Contract for GitHub Copilot

Language: english.

## ✅ Stack and project context

DESKTOP INTERFACE with **Java 25 + Swing**.
Data base: SQLite.
Package manager: `maven`.

## ✅ Essencial commands

```bash
# Development
mvn clean              # It cleans the packages
mvn install            # It installs the packages
```

## ✅ Maven folder

```
C:\Users\casto\apache-maven-3.9.16
```

## ✅ Relevant folder structure

```
src/
  main/java/    ← Java source organized in packages
  test/java/    ← Unit tests
target/
  classes/      ← Bytecodes of all system classes.
```

## ✅ Absolute restrictions — never do

- **Never** commit `.env`, `.env.local` or any files inside `secrets/`

## ✅ Commits pattern

We use Conventional Commits. Mandatory format:

```
<type>(<scope>): <Description in english, imperative, max 72 chars>

Accepted types: feat, fix, chore, docs, refactor, test, perf
Scope: Module name or affected route (example: auth, jobs, prisma)
```

Valid examples:
```
feat(auth): add refresh token rotation
fix(jobs): prevent duplicate email dispatch on retry
refactor(repositories): extract pagination helper
```

## ✅ Tests

Framework: **JUnit + Mockito**. Tests ar located in `src/tests/java`.
File name: `<module>Test.java`.

Run before any Pull Request:
```bash
mvn test
```
For services, mock the repository.

