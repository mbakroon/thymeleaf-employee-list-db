# thymeleafdemo-employee-list-db

 
**Das ist ein Front-Backend Demo zur Verwaltung von Mitarbeiter verwendet werden**

- Standard Information von Mitarbeiter wie Vorname, Nachnahme und Foto eingeben und in Database speichern.

**Verfügbare Funktionen:**

- CRUD-Funktionen (Save, Update, Delete) für die oben genannten Daten *(sind über die Controller-Schnittstelle verfügbar)*.
- Schutzfunktionen zum Schutz von REST-Schnittstelle, damit die CRUD-Funktionen den Personen entsprechend ihrer Rollen zur Verfügung stehen *(kommt bald)*
- Verschlüsselungsfunktionen einiger sensibler Daten beim Speichern in Datenbanken *(kommt bald)*

**Verwendete Technologien:**

- Java
- Spring Boot
- MySQL-Datenbanken
- HTML
- Bootstrap

# Installation
1. Clonen das Projekt. 
2. Importieren Das Projekt als Marven Datei
3. Die Datenbank konfiguration muss angepasst werden 
   1. geh zu application.properties file
   2. muss folgene Block aktualisieren: 
   
   ```  
      spring.datasource.url=jdbc:mysql://localhost:3306/Employ_CustomerList?sessionVariables=sql_mode='NO_ENGINE_SUBSTITUTION'&jdbcCompliantTruncation=false&createDatabaseIfNotExist=true
      spring.datasource.username= your root
      spring.datasource.password= DB Password
      spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
      spring.jpa.hibernate.ddl-auto=update
      spring.jpa.database-platform=org.hibernate.dialect.MySQL57Dialect
      spring.jpa.generate-ddl=true
      spring.jpa.show-sql=true
      spring.servlet.multipart.max-file-size=15MB
      spring.servlet.multipart.max-request-size=15MB

4. Starten das Progaram als Java Application
5. gib in URL http://localhost:8080/




# English Version


 
**This is a front-backend demo to be used for managing employees**

- Enter standard employee information such as first name, last name and photo and save in database.

**Available features:**

- CRUD (Save, Update, Delete) functions for the above data *(are available via the controller interface)*.
- Protection features to protect REST interface to make CRUD features available to people according to their roles *(coming soon)*
- Encryption features of some sensitive data when stored in databases *(coming soon)*

**Technology used:**

- Java
- Jump boat
- MySQL databases
- HTML
- Bootstrap

# Installation
1. Clone the project.
2. Import the project as a Marven file
3. The database configuration must be adjusted
   1. go to application.properties file
   2. must update following block:
   
   ```
      spring.datasource.url=jdbc:mysql://localhost:3306/Employ_CustomerList?sessionVariables=sql_mode='NO_ENGINE_SUBSTITUTION'&jdbcCompliantTruncation=false&createDatabaseIfNotExist=true
      spring.datasource.username= your root
      spring.datasource.password= DB Password
      spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
      spring.jpa.hibernate.ddl-auto=update
      spring.jpa.database-platform=org.hibernate.dialect.MySQL57Dialect
      spring.jpa.generate-ddl=true
      spring.jpa.show-sql=true
      spring.servlet.multipart.max-file-size=15MB
      spring.servlet.multipart.max-request-size=15MB

4. Start the program as a Java application
5. type in URL http://localhost:8080/





# Autor
**Mohammed Bakroon**
