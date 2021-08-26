package com.capg.bookmydoctor.services;

/*****************************************************************
 *         @author          Soumita Deb 
 *         Description      It is a service class for Appointment
 *                          @Service 
 *         Version          1.0
 *         Created On       26-July-2021
 ******************************************************************/

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.bookmydoctor.entities.Appointment;
import com.capg.bookmydoctor.exceptions.AppointmentException;
import com.capg.bookmydoctor.repositories.IAppointmentRepository;

@Service
public class AppointmentServiceImpl implements IAppointmentService {

	@Autowired
	private IAppointmentRepository appointmentRepo;

	@Override
	public Appointment addAppointment(Appointment appointment) {
		return appointmentRepo.save(appointment);
	}

	@Override
	public List<Appointment> getAllAppointments() {
		List<Appointment> list = appointmentRepo.findAll(); 
		if (list.isEmpty()) 	throw new AppointmentException("Nothing to show in Appointment");
		else 					return list;
	}

	@Override
	public Appointment getAppointment(int id) {
		Optional<Appointment> appointList = appointmentRepo.findById(id);
		if(appointList.isEmpty()) 	throw new AppointmentException("Appointment with id : " + id + " is not found");
		else 						return appointList.get();
	}

	@Override
	public void deleteAppointment(int id) {
		if (appointmentRepo.findById(id) != null)
			appointmentRepo.deleteById(id);
		else 
			throw new AppointmentException("Appointment with id : " + id + " is not found");
	}

	@Override
	public Appointment updateAppointment(Appointment appointment) {
		Appointment appointList = appointmentRepo.findById(appointment.getAppointmentId()).get();
		if (appointList == null) {
			throw new AppointmentException("Appointment with id : " + appointment + " is not found");
		} else {
			appointList.setAppointmentId(appointment.getAppointmentId());
			appointList.setPatientId(appointment.getPatientId());
			appointList.setDoctorId(appointment.getDoctorId());
			appointList.setAppointmentDate(appointment.getAppointmentDate());
			appointList.setAppointmentStatus(appointment.getAppointmentStatus());
			appointList.setRemark(appointment.getRemark());
			return appointmentRepo.save(appointList);
		}
	}

	@Override
	public List<Appointment> getAppointmentsByDoctor(int doctorId) {
		List<Appointment> list = appointmentRepo.findAll();
		List<Appointment> temp = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getDoctorId().getDoctorId() == doctorId) 	temp.add(list.get(i));
		}
		if (temp.isEmpty()) throw new AppointmentException("No Appointments commited with doctorId : " + doctorId);
		else 				return temp;
	}

	@Override
	public List<Appointment> getAppointmentsByDate(String date) {
		LocalDate localDate = LocalDate.parse(date);
		List<Appointment> list = appointmentRepo.findAll();
		List<Appointment> temp = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getAppointmentDate().equals(localDate))    temp.add(list.get(i));
		}
		if (temp.isEmpty()) throw new AppointmentException("No Appointments commited with date : " + date);
		else 				return temp;
	}

	@Override
	public List<Appointment> getAppointmentsByPatient(int patientId) {
		List<Appointment> list = appointmentRepo.findAll();
		List<Appointment> temp = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getPatientId().getPatientId() == patientId) temp.add(list.get(i));
		}
		if (temp.isEmpty()) throw new AppointmentException("No Appointments commited with patientId : " + patientId);
		else 				return temp;
	}

	@Override
	public List<Appointment> getAppointmentsByStatus(String status) {
		List<Appointment> list = appointmentRepo.findAll();
		List<Appointment> temp = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getAppointmentStatus().equalsIgnoreCase(status)) temp.add(list.get(i));

		}
		if (temp.isEmpty()) throw new AppointmentException("No Appointments commited with status : " + status);
		else 				return temp;
	}

	@Override
	public List<Appointment> getAppointmentsByRemarks(String remark) {
		List<Appointment> list = appointmentRepo.findAll();
		List<Appointment> temp = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getRemark().equalsIgnoreCase(remark)) temp.add(list.get(i));
		}
		if (temp.isEmpty()) throw new AppointmentException("No Appointments commited with remark : " + remark);
		else 				return temp;
	}
	
	@Override
	public List<Appointment> getPatientsHistory(int doctorId) {
		List<Appointment> list = getAppointmentsByDoctor(doctorId);
		List<Appointment> l1 = new ArrayList<Appointment>();
		for (int i = 0; i < list.size(); i++) {
			if (!list.get(i).getAppointmentStatus().equalsIgnoreCase("Ongoing")) l1.add(list.get(i));

		}
		if (l1.isEmpty()) 	throw new AppointmentException("No Patients history details available");
		else 				return l1;
	}
	
	@Override
	public List<Appointment> getLatestAppointments(int doctorId){
		List<Appointment> list=getAppointmentsByDoctor(doctorId);
		List<Appointment> l1=new ArrayList<Appointment>();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getAppointmentStatus().equalsIgnoreCase("Ongoing")) l1.add(list.get(i));

		}
		if (l1.isEmpty()) throw new AppointmentException("No Appointments available");
		else 				return l1;
	}

}
