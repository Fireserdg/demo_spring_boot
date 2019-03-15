package ru.serdg.demo_spring_boot.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.serdg.demo_spring_boot.model.Visit;
import ru.serdg.demo_spring_boot.repository.VisitsRepository;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * Index controller
 *
 * @author Sergey Filippov (serdg1984@yandex.ru).
 * @version 1.0.
 * @since 2019-03-15
 *
 * Класс, помеченный как @Controller автоматически регистрируется
 * в MVC роутере, а используя аннотации @(Get|Post|Put|Patch)Mapping
 * можно регистрировать разные пути.
 */
@Controller
public class IndexController {

    private final VisitsRepository repository;

    /**
     * Чтобы использовать репозиторий в контроллере мы воспользуемся
     * механизмом внедрения зависимостей, предоставляемый Spring Framework.
     * Чтобы это сделать, как ни странно, нужно всего лишь объявить зависимость в нашем контроллере.
     * @param repository repository
     */
    public IndexController(VisitsRepository repository) {
        this.repository = repository;
    }

    /**
     * Метод возвращает ModelAndView — дальше Spring знает,
     * что нужно взять вью index.html из папки resources/templates
     * (это соглашение по умолчанию) и передать туда модель
     * Увидев в нашем конструкторе параметр типа VisitRepository,
     * Spring найдет созданный Spring Data-ой репозиторий и передаст его в конструктор.
     * @return model
     */
    @GetMapping("/")
    public ModelAndView index() {
        Map<String,String> model = new HashMap<>();
        model.put("name", "Sergey");

        Visit visit = new Visit();
        visit.setDescription(String.format("Visited at %s", LocalDateTime.now()));
        repository.save(visit);

        return new ModelAndView("index", model);
    }
}
