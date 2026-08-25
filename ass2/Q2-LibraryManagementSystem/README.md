# Smart Library Resource Management System

## Package Structure
- `library.model` — `LibraryResource` (abstract), `Printable` (interface), `Book`, `DigitalResource`
- `library.service` — `LibraryService` (display logic + total fine calculation)
- `library.util` — `InputValidator` (resource ID and fine-days validation)
- `library.main` — `MainApp` (driver class)

## How to Compile & Run
```
cd src
javac library/model/*.java library/service/*.java library/util/*.java library/main/*.java
java library.main.MainApp
```

## Rules Implemented
| Resource Type | Fine per Day |
|---|---|
| Book | Rs. 5 |
| DigitalResource | Rs. 2 |
