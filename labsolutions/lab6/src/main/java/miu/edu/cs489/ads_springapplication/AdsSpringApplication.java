package miu.edu.cs489.ads_springapplication;

import miu.edu.cs489.ads_springapplication.model.*;
import miu.edu.cs489.ads_springapplication.service.*;
import miu.edu.cs489.ads_springapplication.service.imp.AddressServiceImp;
import miu.edu.cs489.ads_springapplication.service.imp.PatientServiceImp;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class AdsSpringApplication implements CommandLineRunner {

    private AddressService addressService;

    private PatientService patientService;

    private DentistService dentistService;

    private SurgeryService surgeryService;

    private AppointmentService appointmentService;

    public AdsSpringApplication(AddressService addressService,
                                PatientService patientService,
                                DentistService dentistService,
                                SurgeryService surgeryService,
                                AppointmentService appointmentService) {
        this.addressService = addressService;
        this.patientService = patientService;
        this.dentistService = dentistService;
        this.surgeryService = surgeryService;
        this.appointmentService = appointmentService;
    }

    public static void main(String[] args) {
        SpringApplication.run(AdsSpringApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //1.insert data into address
        insertAddress();
        //2.get all addresses
        System.out.println(addressService.getAllAddresses());

        //3.Insert Patient
        insertPatient();
        //4.get All patient
        System.out.println(patientService.getAllPatients());

        //5.insert dentist data
        insertNewDentist();
        //6.get all dentists
        System.out.println(dentistService.getAllDentists());

        //7.insert surgery data
        insertSurgery();
        //8.get all surgeries
        System.out.println(surgeryService.getAllSurgeries());

        //9.insert appointment
        insertAppointment();
        System.out.println(appointmentService.getAllAppointments());
    }

    public void insertAddress(){
        Address addressToInsertData = new Address("1000N", "FairField","IA","78660");
        addressService.addNewAddress(addressToInsertData);
    }

    public void insertPatient(){
        Patient patientToInsertData =
                new Patient("Gillian","White","8754321435","gillina@gmail.com",
                        LocalDate.of(1998,1,1),
                        addressService.getAllAddresses().get(0));
        patientService.addNewPatient(patientToInsertData);
    }

    public void insertNewDentist(){
        Dentist dentist = new Dentist("Tony","Smith","234567890","tony@gmail.com",
                LocalDate.of(1997,2,2),
                "Head");
        dentistService.addNewDentist(dentist);
    }


    public void insertSurgery(){
        Surgery surgeryDataToInset = new Surgery("S15",
                "345678905678",
                addressService.getAllAddresses().get(0));
        surgeryService.addNewSurgery(surgeryDataToInset);
    }

    public void insertAppointment(){

        Appointment appointmentData = new Appointment(
                LocalDate.of(2012,9,13),
                surgeryService.getAllSurgeries().get(0),
                dentistService.getAllDentists().get(0),
                patientService.getAllPatients().get(0)
        );

        appointmentService.addNewAppointment(appointmentData);


    }





}
