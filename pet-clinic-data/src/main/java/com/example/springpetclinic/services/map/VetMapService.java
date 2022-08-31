package com.example.springpetclinic.services.map;

import com.example.springpetclinic.model.Specialty;
import com.example.springpetclinic.model.Vet;
import com.example.springpetclinic.services.SpecialitiesService;
import com.example.springpetclinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class VetMapService extends AbstractMapService<Vet,Long> implements VetService {

    private final SpecialitiesService specialitiesService;

    public VetMapService(SpecialitiesService specialitiesService) {
        this.specialitiesService = specialitiesService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public Vet save(Vet object) {

        if(object.getSpecialities().size()>0){
            object.getSpecialities().forEach(specialty -> {
                if (specialty.getId()==null){
                    Specialty savedSpecialty = specialitiesService.save(specialty);
                    specialty.setId(savedSpecialty.getId());

                }
            });
        }
        return super.save(object);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
