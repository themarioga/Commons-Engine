## Codebase Overview

Commons-Engine is a shared Spring "backend commons" library (not a runnable app) providing the models, DAOs, services, security helpers, and i18n plumbing common to the "Cartas Contra la Humanidad" and "Secret Hitler" game-engine bots. It supplies concrete User/Room/Tag/Lang persistence and business logic, plus generic `Game`/`Player`/`GameDao`/`PlayerDao`/`GameService`/`PlayerService` scaffolding that each downstream engine implements with its own concrete subclasses.

**Stack**: Java, Spring (Boot-style `@Configuration`/`@Service`/`@Repository` component scanning), Hibernate/JPA (`jakarta.persistence`), Flyway migrations, Spring Security (programmatic context, no login form), Maven (inherits from parent `org.themarioga:parent:2.0.0`). Tests use JUnit 5 + Mockito 5.

**Structure**: `config/` (Spring properties), `models/` (JPA entities: Base, User, Room, Game, Player, Tag, Lang), `enums/`, `dao/` (`intf`/`impl` split, generic Hibernate base), `services/` (`intf`/`impl` split), `security/`, `util/`, `exceptions/` (error-code-driven hierarchy rooted at `ApplicationException`), `src/main/resources/db/migration/` (Flyway SQL).

⚠️ Two things worth knowing before extending it:

- **`username`/`roomname` are the identity; `name` is only what gets displayed.** Front-ends supply the identity (the Telegram one uses the `@alias`, or `tg:<id>`), look rows up by it, and are free to change `name` whenever the user renames themselves.
- **Nothing here knows what Telegram is**, on purpose — the games are meant to be multiplatform. Anything chat-shaped belongs in `Commons-Telegram`.

For detailed architecture, module-by-module breakdown, data flow diagrams, conventions, and known gotchas/bugs, see [docs/CODEBASE_MAP.md](docs/CODEBASE_MAP.md).
