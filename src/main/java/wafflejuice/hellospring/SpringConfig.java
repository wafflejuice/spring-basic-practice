package wafflejuice.hellospring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import wafflejuice.hellospring.repository.MemberRepository;
import wafflejuice.hellospring.repository.MemoryMemberRepository;
import wafflejuice.hellospring.service.MemberService;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
