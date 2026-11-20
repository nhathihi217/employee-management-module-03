# Employee Management — Module 3: Basic REST API

Mini project demonstrating basic Spring REST API operations with an in-memory employee list.

## Requirements

- JDK 17+
- Maven 3.9+

## Run

```bash
mvn spring-boot:run
```

The service starts at `http://localhost:8080`.

## Endpoints

| Method | URL | Description |
|---|---|---|
| GET | `/api/employees` | Get all employees |
| GET | `/api/employees?name=A` | Search employees by name (`RequestParam`) |
| GET | `/api/employees/{id}` | Get an employee by ID (`PathVariable`) |
| POST | `/api/employees` | Add an employee (`RequestBody`) |

### Get all employees

```bash
curl http://localhost:8080/api/employees
```

### Search by name

```bash
curl 'http://localhost:8080/api/employees?name=Nguyen'
```

### Get an employee by ID

```bash
curl -i http://localhost:8080/api/employees/1
```

### Create an employee

```bash
curl -i -X POST http://localhost:8080/api/employees \
  -H 'Content-Type: application/json' \
  -d '{"name":"Le Van C","email":"c@example.com"}'
```

## Tests

```bash
mvn test
```
