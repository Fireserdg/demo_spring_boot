package ru.serdg.demo_spring_boot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.serdg.demo_spring_boot.model.Visit;

/**
 * Repository for visits
 *
 * @author Sergey Filippov (serdg1984@yandex.ru).
 * @version 1.0.
 * @since 2019-03-16
 *
 * Увидев в зависимостях H2 (встраиваемая БД),
 * Boot автоматически конфигурит DataSource (это ключевой компонент для подключения к базе)
 * чтобы приложение работало с этой базой
 * Spring Data ищет всех наследников CrudRepository
 * и автоматически генерит для них дефолтные реализации,
 * которые включают базовые методы репозитория, типа findOne, findAll, save etc.
 * Spring автоматически конфигурит слой для доступа к данным — JPA
 * (точнее, его реализацию Hibernate)
 * Благодаря аннотации @Repository этот компонент становится доступным в нашем приложении
 * (и мы его используем через пару минут)
 *
 *
 */
@Repository
public interface VisitsRepository extends CrudRepository<Visit, Long> {
}
