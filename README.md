# Books API

A simple RESTful API for managing a collection of books, built using Spring Boot. This API allows you to create, retrieve, update, and delete book records stored in an in-memory repository.

## Features
- **GET** `/api/books`: Retrieve a list of all books.
- **GET** `/api/books/{isbn}`: Retrieve details of a specific book by ISBN.
- **POST** `/api/books`: Add a new book to the collection.
- **PUT** `/api/books/{isbn}`: Update the details of an existing book using its ISBN.
- **DELETE** `/api/books/{isbn}`: Remove a book from the collection by ISBN.

## Technologies Used
- **Java 21**
- **Spring Boot**
- **Spring Web**
- **Postman**

## Getting Started

### Prerequisites
- **Java Development Kit (JDK) 21** installed
- **Maven** for dependency management

### Setup Instructions
1. **Clone the repository:**
   ```bash
   git clone https://github.com/YuliiaBi1a/first-api.git
2. **Navigate to the project directory:**
    ```bash
   cd <your-project-directory>
3. **Build the project:**
    ```bash
   mvn clean install
4. **Run the application**
    ```bash
    mvn spring-boot:run

The API will start and be accessible at http://localhost:8080.
If you want you can use this link for create new project with Spring Boot: https://start.spring.io/

## Using Postman to Test the API
You can use [Postman](https://www.postman.com/) to test the API endpoints.

### Sample Requests

#### GET All Books
- **Endpoint:** `GET /api/books`
- **Description:** Retrieves all books in the collection.
- **Response:** List of books in JSON format.

---

#### GET Book by ISBN
- **Endpoint:** `GET /api/books/{isbn}`
- **Description:** Retrieves a book with the specified ISBN.
- **Example Request:** `GET /api/books/A123`
- **Response:** JSON representation of the book or `404 Not Found`.

---

#### POST Add a New Book
- **Endpoint:** `POST /api/books`
- **Description:** Adds a new book to the collection.
- **Request Body:**
  ```json
  {
    "isbn": "A125",
    "title": "New Title",
    "author": "New
  
- **Response:** 201 Created or 400 Bad Request if a book with the same ISBN already exists.

---

#### PUT Update a Book
- **Endpoint:** `PUT /api/books/{isbn}`
- **Description:** Updates the details of a book with the given ISBN.
- **Request Body:**
  ```json
  {
    "title": "Updated Title",
    "author": "Updated Author"
  }
- **Response:** 200 OK or 404 Not Found if the book does not exist.

---

#### DELETE Remove a Book

**Endpoint**: `DELETE /api/books/{isbn}`  
**Description**: Deletes the book with the specified ISBN.  
**Response**:
- `200 OK` if the book is successfully deleted.
- `404 Not Found` if the book does not exist.

## How the API Works

### Controllers
- **BookController**: Defines the API endpoints and handles requests.

### Repository
- **InMemoryBookRepository**: An in-memory implementation of `BookRepository` that stores books using an `ArrayList`.

### Models
- **Book**: Represents a book with attributes `isbn`, `title`, and `author`.

### Error Handling
- **404 Not Found**: Returned when a book with the specified ISBN is not found.
- **400 Bad Request**: Returned when attempting to add a book with a duplicate ISBN.
- **201 Created**: Indicates successful creation of a new book.
- **200 OK**: Indicates a successful update or deletion.

## Future Enhancements
- Add a persistent database like MySQL.
- Implement more sophisticated validation and error handling.
- Add support for pagination and filtering in the `GET` endpoint.
