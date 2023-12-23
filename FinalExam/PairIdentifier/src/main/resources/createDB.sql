create table employees (
    id int primary key not null unique
);

create table projects (
    id int primary key not null unique
);

create table files (
                       id serial primary key not null unique,
                       name varchar(255) not null
);

create table employee_project (
    id serial primary key not null unique,
    employee_id int,
    project_id int,
    file_id int,
    start_date DATE,
    end_date   DATE,

--    primary key (employee_id, project_id),
    foreign key (employee_id) references employees(id),
    foreign key (project_id) references projects(id),
    foreign key (file_id) references files(id)
);

create table date_formats (
    id serial primary key not null unique,
    format varchar(225) not null
);