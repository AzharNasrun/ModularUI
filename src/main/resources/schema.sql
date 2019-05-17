create table USER
(
   id integer not null,
   groupID varchar(255) not null,
   primary key(id)
);

create table MODULE
(
   groupID varchar(255) not null,
   moduleName varchar(255) not null,
   moduleOrder integer  not null,
FOREIGN KEY (groupID)
    REFERENCES USER(groupID)
);