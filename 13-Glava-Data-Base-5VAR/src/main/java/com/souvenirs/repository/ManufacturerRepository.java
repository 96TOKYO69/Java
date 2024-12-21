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
public class ManufacturerRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public List<Souvenir> getSouvenirsByManufacturerId(int manufacturerId) {
        TypedQuery<Souvenir> query = entityManager.createQuery(
                "SELECT DISTINCT s FROM Souvenir s " +
                        "JOIN FETCH s.manufacturer m " +
                        "WHERE m.id = :manufacturerId",
                Souvenir.class
        );
        query.setParameter("manufacturerId", manufacturerId);
        return query.getResultList();
    }

    public Manufacturer getManufacturerById(int manufacturerId) {
        TypedQuery<Manufacturer> query = entityManager.createQuery(
                "SELECT DISTINCT m FROM Manufacturer m " +
                        "LEFT JOIN FETCH m.souvenirs " +
                        "WHERE m.id = :id",
                Manufacturer.class
        );
        query.setParameter("id", manufacturerId);
        List<Manufacturer> results = query.getResultList();
        return results.isEmpty() ? null : results.get(0);
    }

    public List<Manufacturer> getManufacturersBySouvenirAndYear(String souvenirName, int year) {
        TypedQuery<Manufacturer> query = entityManager.createQuery(
                "SELECT DISTINCT m FROM Manufacturer m " +
                        "JOIN FETCH m.souvenirs s " +
                        "WHERE s.name = :souvenirName AND YEAR(s.releaseDate) = :year",
                Manufacturer.class
        );
        query.setParameter("souvenirName", souvenirName);
        query.setParameter("year", year);
        return query.getResultList();
    }

    @Transactional
    public void deleteManufacturerAndSouvenirs(int manufacturerId) {
        Manufacturer manufacturer = getManufacturerById(manufacturerId);
        if (manufacturer != null) {
            entityManager.remove(manufacturer);
        }
    }
}