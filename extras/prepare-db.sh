#!/bin/bash

# This creates a docker container with postgres, creates a table and adds some mock data

docker pull postgres
docker run -d \
  --name postgres-db \
  -e POSTGRES_USER=testusername \
  -e POSTGRES_PASSWORD=testpassword \
  -e POSTGRES_DB=studentdb \
  -p 5432:5432 \
  postgres

sleep 5

echo "Docker container setup complete. Now setting up database."

DB_HOST=localhost
DB_PORT=5432
DB_USERNAME=testusername
DB_PASSWORD=testpassword
DB_NAME=studentdb
POSTGRES_CONTAINER_NAME=postgres-db

docker exec -i $POSTGRES_CONTAINER_NAME psql -U $DB_USERNAME -d $DB_NAME <<-EOSQL
-- Create the students table if not exists
CREATE TABLE IF NOT EXISTS students (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    age INT NOT NULL,
    grade VARCHAR(10) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL
);

-- Insert mock data if the table is empty
DO \$\$
BEGIN
    IF NOT EXISTS (SELECT 1 FROM students LIMIT 1) THEN
        INSERT INTO students (name, age, grade, email) VALUES
        ('John Doe', 20, 'A', 'john.doe@example.com'),
        ('Jane Smith', 22, 'B', 'jane.smith@example.com'),
        ('Alice Johnson', 21, 'A', 'alice.johnson@example.com'),
        ('Bob Brown', 23, 'C', 'bob.brown@example.com');
    END IF;
END;
\$\$;
EOSQL

echo "Database setup completed."
