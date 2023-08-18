# Task

Our system needs to read data from kafka events. The events are a series of events which reflects changes on an entity
such as: EmployeeCreated, EmployeeUpdated, EmployeeActivated, etc. Out of these events, we need to maintain the state
of the employee. The chosen place to store is a relational database.


TODO = Based in the existing code, you need to code the part to save the state in the database.


# Note:
Every time an employee is created/changed, we need to export this data to downstream systems.
For this, we raise an event (ExportEmployeeEvent) which will be later picked up by another component of our application and export it.
You don't need to worry about coding it, just be aware that this will happen. We push that data to other systems.


Also, there is another system which uses our data. It's a tool for statistics, and the only way to integrate with it
is providing database views. For this, we have created a `view_employee`, which has only the active employees:

CREATE OR REPLACE VIEW view_employee AS
    SELECT id, name, email, address, city, date_created
    FROM employee
    where active;

At any time, users of this system are reading our data.

