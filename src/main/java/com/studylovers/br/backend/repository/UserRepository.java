package com.studylovers.br.backend.repository;

import com.studylovers.br.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {}

