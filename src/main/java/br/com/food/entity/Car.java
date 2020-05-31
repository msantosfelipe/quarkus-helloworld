package br.com.food.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Car extends PanacheEntityBase {

    // Objeto Id pode ser omitido quando extende PanacheEntityBase
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String brand;
    private String name;
    @Column(name = "model_year")
    private LocalDate modelYear;
    @Column(name = "created_date_time")
    private LocalDateTime createdDateTime;
    @Column(name = "is_available_sale")
    private Boolean isAvailableSale;
    private BigDecimal price;
}
