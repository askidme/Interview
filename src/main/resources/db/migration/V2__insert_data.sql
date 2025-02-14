--------------------------------------------------------------------------------
-- 3) Insert Data
--------------------------------------------------------------------------------

--------------------------------------------------------------------------------
-- 3.1 Insert 5 Technologies
--------------------------------------------------------------------------------
INSERT INTO technologies (name, code, description)
VALUES ('Java', 'JAVA', 'Java platform and language.'),
       ('Spring', 'SPRING', 'Spring Framework ecosystem.');

--------------------------------------------------------------------------------
-- 3.2 Insert 25 Topics (5 per Technology)
-- NOTE: There's no FK to technologies, but we'll group them logically.
--------------------------------------------------------------------------------

-- Topics for Java
INSERT INTO topics (title, code, description, technology_id)
VALUES ('Java Basics', 'JAVA_BASICS', 'Basic syntax, structure, and environment',(SELECT id FROM technologies WHERE code = 'JAVA')),
       ('Java OOP', 'JAVA_OOP', 'Object-oriented principles in Java',(SELECT id FROM technologies WHERE code = 'JAVA')),
       ('Java Collections', 'JAVA_COLLECTIONS', 'Data structures and algorithms in Java',(SELECT id FROM technologies WHERE code = 'JAVA')),
       ('Java Streams', 'JAVA_STREAMS', 'Stream API for functional operations',(SELECT id FROM technologies WHERE code = 'JAVA')),
       ('Java JDBC', 'JAVA_JDBC', 'Stream API for functional operations',(SELECT id FROM technologies WHERE code = 'JAVA')),
       ('Java Concurrency', 'JAVA_CONCURRENCY', 'Threads, synchronization, and concurrency',(SELECT id FROM technologies WHERE code = 'JAVA'));

-- Topics for Spring
INSERT INTO topics (title, code, description, technology_id)
VALUES ('Spring Core', 'SPRING_CORE', 'Core IoC container and DI features',(SELECT id FROM technologies WHERE code = 'SPRING')),
       ('Spring Data JPA', 'SPRING_DATA_JPA', 'Data access and repositories with JPA',(SELECT id FROM technologies WHERE code = 'SPRING')),
       ('Spring Security', 'SPRING_SECURITY', 'Authentication and authorization',(SELECT id FROM technologies WHERE code = 'SPRING'));


--------------------------------------------------------------------------------
-- 3.3 Insert 5 Interview Questions per Topic (total 125).
-- We'll show them by selecting topic_id via the unique code.
--------------------------------------------------------------------------------


--------------------
-- Java OOP (JAVA_OOP)
--------------------

