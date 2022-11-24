SELECT * FROM pg_stat_activity
order by usename, application_name;

select usename, application_name, count(*)
from pg_catalog.pg_stat_activity 
group by usename, application_name
order by usename;

select usename, count(*)
from pg_catalog.pg_stat_activity 
group by usename
order by usename;

select count(*)
from pg_catalog.pg_stat_activity;
