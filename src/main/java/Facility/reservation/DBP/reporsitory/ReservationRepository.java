package Facility.reservation.DBP.reporsitory;

import Facility.reservation.DBP.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.time.LocalDate;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, String> {

    // 특정 시설 ID와 날짜를 기준으로 예약 수를 세는 메서드
    int countByFacility_FacilityIdAndReservationDateAndStartTime(Long facilityId, LocalDate date, Integer timeSlot);


    // 특정 학생 ID를 기준으로 예약 목록을 조회하는 메서드
    List<Reservation> findByStudentId(Long studentId);

    int countByFacility_Location(String location);
    @Query("SELECT r FROM Reservation r WHERE r.facility.facilityId = :facilityId AND r.reservationDate = :date AND " +
            "((r.startTime >= :startTime AND r.startTime < :endTime) OR (r.endTime > :startTime AND r.endTime <= :endTime))")
    List<Reservation> findReservationsWithinTimeRange(@Param("facilityId") Long facilityId,
                                                      @Param("date") LocalDate date,
                                                      @Param("startTime") Integer startTime,
                                                      @Param("endTime") Integer endTime);



}
