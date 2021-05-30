package com.sdwproject.sdwbackend.repository;

import com.sdwproject.sdwbackend.model.Stock;
import com.sdwproject.sdwbackend.model.dto.StockDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {

    Optional<Stock> findByNameAndDate(String name, LocalDate date);
    //Select interpretado pelo Spring Data

    @Query("SELECT stock" + " FROM Stock stock" +
            " WHERE stock.name = :name AND stock.date = :date AND stock.id <> :id")
    Optional<Stock> findByStockUpdate(String name, LocalDate date, Long id);
    //Select montando a Query manualmente

    @Query("SELECT stock" + " FROM Stock stock" +
            " WHERE stock.date = :date ")
    Optional<List<Stock>> findByToday(LocalDate date);

}
