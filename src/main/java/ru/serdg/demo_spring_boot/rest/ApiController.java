package ru.serdg.demo_spring_boot.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.serdg.demo_spring_boot.model.Visit;
import ru.serdg.demo_spring_boot.repository.VisitsRepository;

/**
 * Api controller
 *
 * @author Sergey Filippov (serdg1984@yandex.ru).
 * @version 1.0.
 * @since 2019-03-16
 *
 * Определяем "префикс" для всех методов контроллера использую базовый @RequestMapping
 */
@RestController
@RequestMapping("/api")
public class ApiController {

    private final VisitsRepository repository;

    public ApiController(VisitsRepository repository) {
        this.repository = repository;
    }

    /**
     * Метод теперь возвращает не имя шаблона, а модель.
     * Spring автоматически преобразует это в массив JSON объектов.
     *
     * Теперь при запросе http://localhost:8080/api/visits
     * (предварительно скомпилировав проект и дав DevTools обновить приложение)
     * мы получим JSON с нужными данными.
     * @return json object
     */
    @GetMapping("/visits")
    public Iterable<Visit> getVisits() {
        return repository.findAll();
    }
}
