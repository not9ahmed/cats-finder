-- DROP TABLES
-- DROP TABLE IF EXISTS "User" CASCADE;
-- DROP TABLE IF EXISTS "Cat" CASCADE;
-- DROP TABLE IF EXISTS "Breed" CASCADE;
-- DROP TABLE IF EXISTS "Comment" CASCADE;
-- ALTER TABLE "Cat" DROP CONSTRAINT cat_owner_id_fk
-- ALTER TABLE "Cat" DROP CONSTRAINT cat_breed_id_fk
-- ALTER TABLE "Comment" DROP CONSTRAINT comment_cat_fk

-- Create User Table --
CREATE TABLE IF NOT EXISTS "User" (
    id SERIAL PRIMARY KEY,
    username VARCHAR(20) UNIQUE,
    password VARCHAR(50),
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    mobile VARCHAR(50),
    gender CHAR(1) CHECK(gender IN ('F', 'M')),
    birth_date DATE,
    details_updated TIMESTAMP,
    user_role CHAR(1) CHECK(user_role IN('A', 'U')),
    profile_image VARCHAR(200)
);


-- Create Cat Table --
CREATE TABLE IF NOT EXISTS "Cat" (
    id SERIAL PRIMARY KEY,
    name VARCHAR(20) NOT NULL,
    breed_id INTEGER NOT NULL,
    owner_id INTEGER NOT NULL,
    birth_date DATE,
    images VARCHAR(200)[],
    toys VARCHAR(30)[]
);


-- Create Breed Table --
CREATE TABLE IF NOT EXISTS "Breed" (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50),
    description TEXT,
    images VARCHAR(200)[]
);




--Create Comment Table--
CREATE TABLE IF NOT EXISTS "Comment" (
    id SERIAL PRIMARY KEY,
    cat INTEGER NOT NULL,
    name VARCHAR(30) NOT NULL,
    content TEXT NOT NULL,
    published_on TIMESTAMP NOT NULL,
    updated_on TIMESTAMP
);




-- Create Post Table





-- Adding the foreign keys
-- ALTER TABLE "Cat"
--     ADD CONSTRAINT cat_owner_id_fk
--         FOREIGN KEY (owner_id)
--             REFERENCES "User"(id);
--
--
--
-- ALTER TABLE "Cat"
--     ADD CONSTRAINT cat_breed_id_fk
--         FOREIGN KEY (breed_id)
--             REFERENCES "Breed"(id);
--
--
--
-- ALTER TABLE "Comment"
--     ADD CONSTRAINT comment_cat_fk
--         FOREIGN KEY (cat)
--             REFERENCES "Cat"(id);




-- TODO: Create the new tables and complete the ERD
-- DROP TABLES
-- DROP TABLE IF EXISTS "User" CASCADE;
-- DROP TABLE IF EXISTS "Cat" CASCADE;
-- DROP TABLE IF EXISTS "Breed" CASCADE;
-- DROP TABLE IF EXISTS "Comment" CASCADE;
-- ALTER TABLE "Cat" DROP CONSTRAINT cat_owner_id_fk
-- ALTER TABLE "Cat" DROP CONSTRAINT cat_breed_id_fk
-- ALTER TABLE "Comment" DROP CONSTRAINT comment_cat_fk



-- Should Match Spring Security --
-- Create User Table --
CREATE TABLE IF NOT EXISTS "User" (
    id SERIAL PRIMARY KEY,
    username VARCHAR(20) UNIQUE,
    password VARCHAR(50),
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    mobile VARCHAR(50),
    gender CHAR(1) CHECK(gender IN ('F', 'M')),
    birth_date DATE,
    details_updated TIMESTAMP,
    user_role CHAR(1) CHECK(user_role IN('A', 'U')),
    profile_image VARCHAR(200)
);






-- Create Cat Table --
CREATE TABLE IF NOT EXISTS "Cat" (
     id SERIAL PRIMARY KEY,
     name VARCHAR(20) NOT NULL,
     breed_id INTEGER NOT NULL,
     owner_id INTEGER NOT NULL,
     birth_date DATE,
     images VARCHAR(200)[],
     toys VARCHAR(30)[]
);


-- Create Breed Table --
CREATE TABLE IF NOT EXISTS "Breed" (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50),
    description TEXT,
    images VARCHAR(200)[]
);




--Create Comment Table--
CREATE TABLE IF NOT EXISTS "Comment" (
     id SERIAL PRIMARY KEY,
     cat INTEGER NOT NULL,
     name VARCHAR(30) NOT NULL,
     content TEXT NOT NULL,
     published_on TIMESTAMP NOT NULL,
     updated_on TIMESTAMP
);




-- Create Post Table
CREATE TABLE IF NOT EXISTS "Post" (
      id SERIAL PRIMARY KEY,
      title VARCHAR(50),
      content TEXT,
      created_on TIMESTAMP NOT NULL,
      updated_on TIMESTAMP
);




-- Adding the foreign keys
-- ALTER TABLE "Cat"
--     ADD CONSTRAINT cat_owner_id_fk
--         FOREIGN KEY (owner_id)
--             REFERENCES "User"(id);
--
--
--
-- ALTER TABLE "Cat"
--     ADD CONSTRAINT cat_breed_id_fk
--         FOREIGN KEY (breed_id)
--             REFERENCES "Breed"(id);
--
--
--
-- ALTER TABLE "Comment"
--     ADD CONSTRAINT comment_cat_fk
--         FOREIGN KEY (cat)
--             REFERENCES "Cat"(id);

