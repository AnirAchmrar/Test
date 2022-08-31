package com.example.springpetclinic.services.springdatajpa;

import com.example.springpetclinic.model.Specialty;
import com.example.springpetclinic.repositories.SpecialtyRepository;
import com.example.springpetclinic.services.SpecialitiesService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class SpecialtySDJpaService implements SpecialitiesService {

    private final SpecialtyRepository specialtyRepository;


    public SpecialtySDJpaService(SpecialtyRepository specialtyRepository) {
        this.specialtyRepository = specialtyRepository;
    }

    @Override
    public Set<Specialty> findAll() {
        Set<Specialty> specialties =  new HashSet<>();
        specialtyRepository.findAll().forEach(specialties::add);
        return specialties;
    }

    @Override
    public Specialty findById(Long id) {
        return specialtyRepository.findById(id).orElse(null);
    }

    @Override
    public Specialty save(Specialty object) {
        return specialtyRepository.save(object);
    }

    @Override
    public void delete(Specialty object) {
            specialtyRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
            specialtyRepository.deleteById(id);
    }
}
