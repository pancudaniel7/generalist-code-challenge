package com.pragma.challenge.repository;

import java.util.*;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

import com.pragma.challenge.model.*;

@Repository
public interface StudioRepository extends JpaRepository<Studio, Integer>
{
  Optional<Studio> findStudioByName(String name);
}
