package org.rojoherrero.rivendel.repositories;

import org.rojoherrero.rivendel.entities.House;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseRepository extends JpaRepository<House, Long> {

}
