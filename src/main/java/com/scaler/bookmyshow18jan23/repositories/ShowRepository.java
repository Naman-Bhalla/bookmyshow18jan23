package com.scaler.bookmyshow18jan23.repositories;

import com.scaler.bookmyshow18jan23.models.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowRepository
        extends JpaRepository<Show, Long> {


    Show findByIdEquals(Long id);
    // select * from shows where id equals = {}
}
