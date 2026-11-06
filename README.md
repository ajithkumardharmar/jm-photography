# JM Photography — Spring Boot + Thymeleaf

Premium photography business website with a secured admin area and PostgreSQL persistence.

## Requirements
- Java 17+
- Maven 3.8+
- PostgreSQL 14+

## 1. Create database
```sql
CREATE DATABASE jmphotography;
```

## 2. Configure environment
Defaults are for local development. Override these environment variables for your own database and admin credentials:

| Variable | Default | Purpose |
|---|---|---|
| `DB_URL` | `jdbc:postgresql://localhost:5432/jmphotography` | JDBC URL |
| `DB_USERNAME` | `postgres` | Database user |
| `DB_PASSWORD` | `postgres` | Database password |
| `ADMIN_USERNAME` | `admin` | Admin login username |
| `ADMIN_PASSWORD` | `ChangeMe123!` | Admin login password — change before deployment |
| `PORT` | `8080` | HTTP port |

For Neon PostgreSQL, use a JDBC URL, for example:
`jdbc:postgresql://YOUR-HOST.neon.tech/neondb?sslmode=require`
Do not paste a `postgresql://` URI directly into `DB_URL`; use the `jdbc:postgresql://` form. Set credentials separately.

## 3. Run
```bash
mvn spring-boot:run
```
Open `http://localhost:8080`. Admin: `http://localhost:8080/admin/login`.

## Admin features
- Dashboard counts and recent enquiries
- Product create, edit, delete and list (stored in PostgreSQL)
- Portfolio create, delete and list (stored in PostgreSQL)
- Customer enquiry inbox and status updates

## Notes before going live
- Set strong `ADMIN_USERNAME` and `ADMIN_PASSWORD` environment variables.
- Set `DB_URL`, `DB_USERNAME`, `DB_PASSWORD` in your hosting provider.
- Replace the sample phone number, WhatsApp number, email and service area in `contact.html` and `fragments/footer.html` with verified business details.
- Add only image URLs that you own or are licensed to use. For production, consider object storage and upload validation rather than public image URLs.
- Add a privacy notice and configure backups before collecting customer details.
- Drone work is subject to local aviation rules, permissions and safe operating conditions.

Hibernate `ddl-auto=update` creates/updates the tables automatically. Back up production data before schema changes.
