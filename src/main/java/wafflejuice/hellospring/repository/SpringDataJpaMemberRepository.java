package wafflejuice.hellospring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wafflejuice.hellospring.domain.Member;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    // JPRL select m from Member m where m.name = ?
    // interface 이름으로 기능 제공
    @Override
    Optional<Member> findByName(String name);
}
