package com.souvenirs.repository;

import com.souvenirs.model.Manufacturer;
import com.souvenirs.model.Souvenir;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class SouvenirRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Souvenir> getSouvenirsByCountry(String country) {
        TypedQuery<Souvenir> query = entityManager.createQuery(
                "SELECT DISTINCT s FROM Souvenir s " +
                        "JOIN FETCH s.manufacturer m " +
                        "WHERE m.country = :country",
                Souvenir.class
        );
        query.setParameter("country", country);
        return query.getResultList();
    }

    public List<Manufacturer> getManufacturersByPrice(double price) {
        return entityManager.createQuery(
                        "SELECT DISTINCT m FROM Manufacturer m " +
                                "LEFT JOIN FETCH m.souvenirs s " +
                                "WHERE NOT EXISTS (" +
                                "SELECT 1 FROM Souvenir s2 " +
                                "WHERE s2.manufacturer = m AND s2.price >= :price" +
                                ")",
                        Manufacturer.class
                )
                .setParameter("price", price)
                .getResultList();
    }
}