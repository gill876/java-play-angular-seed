# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table todo (
  id                            integer auto_increment not null,
  title                         varchar(255),
  completed                     tinyint(1),
  constraint pk_todo primary key (id)
);


# --- !Downs

drop table if exists todo;

