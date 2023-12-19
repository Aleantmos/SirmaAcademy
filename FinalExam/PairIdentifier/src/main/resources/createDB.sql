create table employees (
    id serial primary key not null unique
);

create table projects (
    id serial PRIMARY KEY
);

create table employee_project (
    id serial primary key,
    employee_id int,
    project_id int,
    start_date DATE,
    end_date   DATE,

--     primary key (employee_id, project_id),
    foreign key (employee_id) references employees(id),
    foreign key (project_id) references projects(id)
);


