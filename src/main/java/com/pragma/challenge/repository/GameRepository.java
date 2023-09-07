package com.pragma.challenge.repository;

import java.util.*;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

import com.pragma.challenge.model.*;

@Repository
public interface GameRepository  extends JpaRepository<Game, Integer>
{
}
