alter table ProviderPreference add column appointmentScreenFormNameDisplayLength int not null;

update ProviderPreference set appointmentScreenFormNameDisplayLength=3;