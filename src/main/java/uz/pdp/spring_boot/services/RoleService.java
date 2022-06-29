package uz.pdp.spring_boot.services;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;
import uz.pdp.spring_boot.entity.auth.AuthRole;
import uz.pdp.spring_boot.reposiroty.auth.RoleRepository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;


@Service
public class RoleService implements RoleRepository {

    @Override
    public List<AuthRole> findAll() {
        return null;
    }

    @Override
    public List<AuthRole> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<AuthRole> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<AuthRole> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(AuthRole entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends AuthRole> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends AuthRole> S save(S entity) {
        return null;
    }

    @Override
    public <S extends AuthRole> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<AuthRole> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends AuthRole> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends AuthRole> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<AuthRole> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public AuthRole getOne(Long aLong) {
        return null;
    }

    @Override
    public AuthRole getById(Long aLong) {
        return null;
    }

    @Override
    public <S extends AuthRole> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends AuthRole> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends AuthRole> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends AuthRole> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends AuthRole> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends AuthRole> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends AuthRole, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
}
