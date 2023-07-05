package com.app.bookstore.appointment;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer>{
	
	//@Query("SELECT app FROM appointment app JOIN app.exemplary ex WHERE (ex.id =:exemplaryId AND (app.startDate <= :endDate AND app.endDate >= :startDate AND (:startDate <app.startDate OR :endDate> app.endDate) )")
	@Query("SELECT app FROM appointment app JOIN app.exemplary ex WHERE (ex.id =:exemplaryId AND ((:startDate <= app.startDate AND app.startDate <= :endDate)"
			+ " OR (:startDate <= app.endDate AND app.endDate <= :endDate) "
			+ " OR (app.startDate > :startDate AND app.endDate < :endDate) "
			+ " OR (app.startDate < :startDate AND app.endDate > :endDate)) )")
	Appointment checkIfExemplaryAlreadyBooked(@Param("exemplaryId") Integer exemplaryId, @Param("startDate") LocalDate startDate,@Param("endDate") LocalDate endDate);

}
