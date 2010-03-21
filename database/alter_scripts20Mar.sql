alter table person drop foreign key idAddress;
alter table person drop column idAddress;

alter table  address add column idPerson INT ;

alter table address add constraint fk_idPerson foreign key (idPerson) references person (idPerson);

alter table person drop column address1;
alter table person drop column address2;
alter table person drop column locality;
alter table person drop column city;
alter table person drop column state;
alter table person drop column country;
