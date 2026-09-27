# AGENTS.md - Contrato de Trabalho para GitHub Copilot

## ✅1. Stack and project context

DESKTOP INTERFACE with **Java 25 + Swing**.
Data base: SQLite.
Package manager: `maven`.

## ✅2. Comandos essenciais

```bash
# Development
mvn clean              # It cleans the packages
mvn install            # It installs the packages
```

## ✅3. Estrutura de pastas relevante

```
src/
  main/java/    ← Java source organized in packages
  test/java/    ← Unit tests
target/
  classes/      ← Bytecodes of all system classes.
```

## ✅4. Absolute restrictions — never do

- **Never** commit `.env`, `.env.local` or any files inside `secrets/`

## ✅5.  Padrão de commits

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

## ✅6. Tests

Framework: **JUnit + Mockito**. Tests ar located in `src/tests/java`.
File name: `<module>Test.java`.

Run before any Pull Request:
```bash
mvn test
```
For services, mock the repository.

