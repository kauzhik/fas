package com.fas.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class RiverRepositoryImpl implements CustomRiverRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Object> findAllWithStation() {
//        List<Object> objectList = entityManager
//                .createQuery("SELECT r.id as riverId, r.name as riverName, s.name as staionName FROM River r JOIN Station s ON r.id = s.river.id")
//                .getResultList();
        return null;
    }
}
