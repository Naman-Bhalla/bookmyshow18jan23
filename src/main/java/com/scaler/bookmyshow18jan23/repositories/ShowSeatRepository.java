package com.scaler.bookmyshow18jan23.repositories;

import com.scaler.bookmyshow18jan23.models.Show;
import com.scaler.bookmyshow18jan23.models.ShowSeat;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat, Long> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    List<ShowSeat> findAllByIdIn(List<Long> showSeatIds);

//    select * from show_seat show_id = {}
//
//    List<ShowSeat> findAllByShowEquals(Show show);

    // if the show seat passed in paramater doesn't have an id:
    //   create a new row
    // else it updates show seat with that id
    ShowSeat save(ShowSeat showSeat);
}
