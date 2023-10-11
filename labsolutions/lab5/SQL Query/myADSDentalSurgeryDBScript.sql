-- 1.Display the list of ALL Dentists registered in the system, sorted in ascending
-- order of their lastNames
select * from dentists d
order by d.last_name;

-- 2.Display the list of ALL Appointments for a given Dentist by their dentist_Id
-- number. Include in the result, the Patient information. 
select ap.appointment_id, ap.date, ap.dentist_id, de.first_name as dentist_firstname, 
pa.patient_id, pa.first_name as patient_firstName,pa.phone_number as patient_phone_number,pa.email as patient_email,
pa.dob as patient_dob 
from appointments ap
inner join dentists de
on ap.dentist_id = de.dentist_id
inner join patients pa
on ap.patient_id = pa.patient_id
where ap.dentist_id = 1;

-- 3.Display the list of ALL Appointments that have been scheduled at a Surgery
-- Location
select * from appointments as ap
where ap.surgery_id = 1;

-- 4.Display the list--  of the Appointments booked for a given Patient on a given Date.
select * from appointments ap
where ap.date = '2023-11-01 14:30:00' and ap.patient_id = 1
 

