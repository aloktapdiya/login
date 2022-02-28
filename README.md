# login
 login
select * from user_roles_entity;
select * from user_details_entity;
delete from user_roles_entity where id ='1';



insert into user_roles_entity (name) values ('ROLE_USER');
create sequence user_id_seq;
alter table user_details_entity alter id set default nextval('user_id_seq');
$2a$05$mDQ1Ox.M6.olA2GnxqB58.rUOvB0MS/u6O.TQ7H7/QlaQtywVS0xW
select * from users_roles;
insert into user_details_entity (password,username) values ('{bcrypt}$2a$05$mDQ1Ox.M6.olA2GnxqB58.rUOvB0MS/u6O.TQ7H7/QlaQtywVS0xW','user3');
insert into users_roles(user_id,role_id) values (3,1);
select roles0_.user_id as user_id1_2_0_, roles0_.role_id as role_id2_2_0_, userrolese1_.id as id1_1_1_, userrolese1_.name as name2_1_1_ from users_roles roles0_ inner join user_roles_entity userrolese1_ on roles0_.role_id=userrolese1_.id where roles0_.user_id=1;
commit;
