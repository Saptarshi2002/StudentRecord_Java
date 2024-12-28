# StudentRecord_Java
Create an Object Relational Student Database with the following 2 table - StudentTB and MarksTB. Put the records in a list before storing them in the file. Create swing based GUI for implementing different CRUD operation on your database.

# Why Use `.dat` Files Instead of `.txt` Files?

In the given project, `.dat` files are used for storing data instead of `.txt` files due to the following reasons:

## 1. **Efficient Storage of Complex Data**
- `.dat` files store serialized objects directly, which simplifies handling complex data structures like `Student` and `Marks` objects.
- `.txt` files would require custom formatting and parsing, making the process more error-prone and time-consuming.

## 2. **Faster Read and Write Operations**
- Binary `.dat` files are faster for I/O operations as they avoid the overhead of encoding and decoding text.
- `.txt` files store data as plain text, which involves additional processing.

## 3. **Preservation of Data Types**
- In `.dat` files, data types are preserved during serialization. For example:
  - An integer remains an integer.
  - A string remains a string.
- In `.txt` files, all data is stored as plain text, requiring additional parsing to reconstruct the original data types.

## 4. **Compact File Size**
- `.dat` files, being binary, take up less storage space compared to `.txt` files, which include extra characters for formatting and encoding.

## 5. **Data Integrity**
- Binary `.dat` files are less prone to human error since they are not human-readable.
- `.txt` files are easily editable, which can lead to accidental corruption of data.

## 6. **Security**
- `.dat` files are harder to read or modify without specialized tools, providing an additional layer of security.
- `.txt` files are human-readable and can be easily viewed and altered.

## 7. **Support for Object-Oriented Design**
- The project uses Java's `ObjectOutputStream` and `ObjectInputStream` to serialize and deserialize objects.
- This approach aligns with the object-oriented nature of the project, making `.dat` files a natural fit.

## Conclusion
Using `.dat` files simplifies data handling, ensures efficient storage, and preserves the integrity and structure of the data. While `.txt` files are suitable for human-readable data, `.dat` files are the better choice for this project due to their ability to handle serialized objects efficiently.
