CREATE TABLE IF NOT EXISTS todos (
    id serial PRIMARY KEY,
    taskTitle varchar(250) NOT NULL,
    'description' varchar(250) NOT NULL
);