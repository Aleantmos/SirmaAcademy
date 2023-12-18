create table employees (
    id         serial primary key not null unique,
    start_date DATE,
    end_date   DATE
);

create table projects (
    id serial PRIMARY KEY
);

create table employee_project (
    employee_id int,
    project_id int,

    primary key (employee_id, project_id),
    foreign key (employee_id) references employees(id),
    foreign key (project_id) references projects(id)
);



