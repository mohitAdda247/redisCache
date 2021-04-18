package com.mohitkumar.crud.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mohitkumar.crud.model.DaoCrud;

public interface CrudDao extends JpaRepository<DaoCrud, Integer> {
}
