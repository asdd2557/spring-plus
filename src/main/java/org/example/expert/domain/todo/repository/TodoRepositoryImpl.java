package org.example.expert.domain.todo.repository;


import com.querydsl.jpa.JPQLQueryFactory;
import lombok.RequiredArgsConstructor;
import org.example.expert.domain.todo.entity.QTodo;
import org.example.expert.domain.todo.entity.Todo;
import org.example.expert.domain.user.entity.QUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class TodoRepositoryImpl implements TodoRepositoryCustom{
    private final JPQLQueryFactory queryFactory;

    @Override
    public Page<Todo> findAllByFilters(String weather, LocalDateTime startDate, LocalDateTime endDate, Pageable pageable) {
        QTodo todo = QTodo.todo; // Todo 엔티티의 QueryDSL용 Q 클래스
        QUser user = QUser.user; // User 엔티티의 QueryDSL용 Q 클래스

        // QueryDSL로 조건부 동적 쿼리 작성
        List<Todo> todos = queryFactory.selectFrom(todo)
                .leftJoin(todo.user, user).fetchJoin() // LEFT JOIN FETCH t.user
                .where(
                        weather == null ? null : todo.weather.eq(weather),
                        startDate == null ? null : todo.modifiedAt.goe(startDate),
                        endDate == null ? null : todo.modifiedAt.loe(endDate)
                )
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(todo.modifiedAt.desc())
                .fetch();

        // 전체 데이터 개수 계산 (페이징에 필요)
        long total = queryFactory.selectFrom(todo)
                .leftJoin(todo.user, user)
                .where(
                        weather == null ? null : todo.weather.eq(weather),
                        startDate == null ? null : todo.modifiedAt.goe(startDate),
                        endDate == null ? null : todo.modifiedAt.loe(endDate)
                )
                .fetchCount(); // 총 데이터 개수 가져오기

        // Page 객체로 반환
        return new PageImpl<>(todos, pageable, total);
    }

}
