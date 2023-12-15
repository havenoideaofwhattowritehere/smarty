package com.smarty.SmartyApp.daos.impl

import com.smarty.SmartyApp.daos.CommentDao
import com.smarty.SmartyApp.entities.Comment
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Example
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.repository.query.FluentQuery
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository

import java.util.function.Function

@Component
class CommentDaoImpl implements CommentDao
{
    @Autowired
    MongoTemplate mongoTemplate

    @Override
    def <S> S insert(S entity) {
        return null
    }

    @Override
    def <S> List<S> insert(Iterable<S> entities) {
        return null
    }

    @Override
    def <S> List<S> findAll(Example<S> example) {
        return null
    }

    @Override
    def <S> List<S> findAll(Example<S> example, Sort sort) {
        return null
    }

    @Override
    def <S> List<S> saveAll(Iterable<S> entities) {
        return null
    }

    @Override
    def <S> S save(S entity) {
        return null
    }

    @Override
    Optional<Comment> findById(Long aLong) {
        return null
    }

    @Override
    boolean existsById(Long aLong) {
        return false
    }

    @Override
    List<Comment> findAll() {
        return null
    }

    @Override
    List<Comment> findAllById(Iterable<Long> longs) {
        return null
    }

    @Override
    long count() {
        return 0
    }

    @Override
    void deleteById(Long aLong) {

    }

    @Override
    void delete(Comment entity) {

    }

    @Override
    void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    void deleteAll(Iterable<? extends Comment> entities) {

    }

    @Override
    void deleteAll() {

    }

    @Override
    List<Comment> findAll(Sort sort) {
        return null
    }

    @Override
    Page<Comment> findAll(Pageable pageable) {
        return null
    }

    @Override
    def <S> Optional<S> findOne(Example<S> example) {
        return null
    }

    @Override
    def <S> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null
    }

    @Override
    def <S> long count(Example<S> example) {
        return 0
    }

    @Override
    def <S> boolean exists(Example<S> example) {
        return false
    }

    @Override
    def <S, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null
    }
}
