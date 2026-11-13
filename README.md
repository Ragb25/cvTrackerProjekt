# CVTracker — Bewerbungstracker

Eine Webanwendung zur Verwaltung von Bewerbungen. Benutzer können ihre Bewerbungen erstellen, bearbeiten, löschen und den Status verfolgen. Zu jeder Bewerbung können Dokumente (Lebenslauf, Anschreiben, etc.) und Notizen hinzugefügt werden.

## Technologien

**Backend:**
- Java 21
- Spring Boot 4.1.2
- Spring Security
- Spring Data JPA / Hibernate
- PostgreSQL (Docker)

**Frontend:** *(in Entwicklung)*
- React

## Projektstruktur

```
src/main/java/de/cvTracker/cvTracker/
├── config/          # SecurityConfig (CORS, CSRF)
├── controller/      # REST-Controller (Benutzer, Bewerbung, Dokument, Notiz)
├── model/           # Entitäten (Benutzer, Bewerbung, Dokument, Notiz, Status)
├── repository/      # JPA-Repositories
└── service/         # Geschäftslogik
```

## API-Endpunkte

| Methode | URL | Beschreibung |
|---------|-----|-------------|
| POST | `/registrieren` | Benutzer registrieren |
| POST | `/bewerbungErstellen` | Neue Bewerbung erstellen |
| GET | `/bewerbungen` | Alle Bewerbungen abrufen |
| PUT | `/bewerbungen/{id}` | Bewerbung aktualisieren |
| DELETE | `/delete/{id}` | Bewerbung löschen |
| POST | `/dokumentHinzufuegen` | Dokument hinzufügen |
| GET | `/documents/{id}` | Dokumente einer Bewerbung abrufen |
| DELETE | `/dokumentLoeschen/{id}` | Dokument löschen |
| POST | `/notizHinzufuegen` | Notiz hinzufügen |
| PUT | `/notizAktualisieren/{id}` | Notiz aktualisieren |
| DELETE | `/notizLoeschen/{id}` | Notiz löschen |

## Datenbank einrichten

```bash
docker run --name cvtracker-db -e POSTGRES_DB=cvtracker -e POSTGRES_USER=ramane -e POSTGRES_PASSWORD=cvtracker123 -p 5432:5432 -d postgres
```

## Projekt starten

```bash
# Docker-Container starten
docker start cvtracker-db

# Projekt bauen
./mvnw clean install

# App starten
./mvnw spring-boot:run
```

Die App läuft auf `http://localhost:8080`.

## Autor

Ramane Gbatkom Mouliom Abdel
