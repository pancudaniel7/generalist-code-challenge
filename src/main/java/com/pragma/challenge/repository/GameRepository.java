package com.pragma.challenge.repository;

import org.springframework.data.jpa.repository.*;

import com.pragma.challenge.model.*;

public interface GameRepository  extends JpaRepository<Game, Integer>
{
}
