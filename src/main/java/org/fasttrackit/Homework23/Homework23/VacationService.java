package org.fasttrackit.Homework23.Homework23;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class VacationService {
    private final List<Vacation> vacations;

    public VacationService(List<Vacation> vacations) {
        this.vacations = new ArrayList<>();
    }

    public Vacation getById(int id) {
        return (Vacation) vacations.stream()
                .filter(v -> v.getId() == id)
                .map(Vacation::getLocation)
                .collect(Collectors.toList());
    }

    public List<Vacation> getAll(String location) {
        if (location == null) {
            return vacations;
        } else {
            return vacations.stream()
                    .filter(v -> v.getLocation().equals(location))
                    .collect(Collectors.toList());
        }
    }

    public Optional<Vacation> getMaxPrice(int price) {

        return vacations.stream()
                .filter(v -> v.getPrice() == price)
                .max(Comparator.comparing(Vacation::getPrice));
    }

    public Vacation addVacantion(Vacation vacation) {
        vacations.add(vacation.getId() - 1, vacation);
        return vacation;
    }

    public Vacation replaceVacantion(int id) {
        Vacation vacation = getOrThrow(id);
        Vacation newVacantion = new Vacation(id, vacation.getLocation(), vacation.getPrice(), vacation.getDuration());
        addVacantion(newVacantion);
        return newVacantion;
    }

    public Vacation deleteVacantion(int id) {
        Vacation vacation = getOrThrow(id);
        vacations.remove(vacation);
        return  vacation;
    }

    private Vacation getOrThrow(final int id) {
        return vacations.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("Could not find vacantion with id " + id));
    }

}