package com.sandro.finder.repository;

import com.sandro.finder.domain.DataUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataUserRepository extends JpaRepository<DataUser, Integer> {
}
