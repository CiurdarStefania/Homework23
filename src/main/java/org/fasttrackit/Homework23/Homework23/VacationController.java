package org.fasttrackit.Homework23.Homework23;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("vacations")
public class VacationController {
    private final VacationService service;

    public VacationController(VacationService service) {
        this.service = service;
    }

    @GetMapping("{id}")
    public Vacation getById(@PathVariable int id) {
        return service.getById(id);
    }

    @GetMapping
    public List<Vacation> getAll(@RequestParam(required = false) String location) {
        return service.getAll(location);
    }

    @GetMapping
    public Optional<Vacation> getMaxPrice(@RequestParam int price) {
        return service.getMaxPrice(price);
    }
    @PostMapping
    public Vacation addVacation(@RequestBody Vacation vacation){
        return service.addVacantion(vacation);
    }
    @PutMapping("{id}")
    public Vacation replaceVacation(@PathVariable int id){
        return service.replaceVacantion(id);
    }
    @DeleteMapping("{id}")
    public Vacation deleteVacation(@PathVariable int id){
        return service.deleteVacantion(id);
    }
}
