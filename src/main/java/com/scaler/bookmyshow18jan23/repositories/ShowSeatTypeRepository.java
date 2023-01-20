package com.scaler.bookmyshow18jan23.repositories;

import com.scaler.bookmyshow18jan23.models.Show;
import com.scaler.bookmyshow18jan23.models.ShowSeatType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowSeatTypeRepository
extends JpaRepository<ShowSeatType, Long> {

    List<ShowSeatType> findAllByShowEquals(Show show);
}
