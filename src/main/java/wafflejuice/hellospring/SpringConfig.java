package wafflejuice.hellospring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import wafflejuice.hellospring.aop.TimeTraceAop;
import wafflejuice.hellospring.repository.JpaMemberRepository;
import wafflejuice.hellospring.repository.MemberRepository;
import wafflejuice.hellospring.repository.MemoryMemberRepository;
import wafflejuice.hellospring.service.MemberService;

import javax.persistence.EntityManager;

@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /*
    private EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }
     */

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

    /*
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
        return new JpaMemberRepository(em);
    }
     */

    @Bean
    public TimeTraceAop timeTraceAop() {
        return new TimeTraceAop();
    }
}
