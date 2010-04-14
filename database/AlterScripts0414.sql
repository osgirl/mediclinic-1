alter table address add updated int default 1;

alter table address  add unique(personID);