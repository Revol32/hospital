

## Hospital System PoC
Hospital management system prototype implemented in Java using Spring Boot and JSP.<br/>
The database is in the resources, as a dump. DB schema:
![](db.png)
<br/>
<br/>
The system is frozen on 02/03/2021 to avoid outdating the date variable base in the TimeHolder class<br/>
3 types of users are implemented:

### ADMIN
login:admin<br/>
password:admin<br/>
The ADMIN role is used for the receptionist, available functions:<br/>
Register a new doctor.<br/>
Create a schedule of doctors' work<br/>
View the archive of records<br/>
View patient reviews of doctors.

### DOCTOR
login:doctor<br/>
password:doctor<br/>
Роль DOCTOR используется для работы врача:<br/>
Opening an appointment and making a record of it, for today. Or marking a patient as absent<br/>
Viewing your appointment archive<br/>
Viewing future patient records

### PATIENT
login:patient<br/>
password:patient<br/>
The PATIENT role is used for visitors, available functions:<br/>
Make an appointment with a doctor<br/>
View your future appointments<br/>
Cancel an appointment with a doctor<br/>
Leave a feedback of a recent appointment<br/><br/><br/>
#### Warning: the project was designed only for Google Chrome, correct work in another browser is not guaranteed
