package service;

import domain.Member;
import repository.MemberRepository;

public class MemberService {
    private MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void addMember(Member member) {
        memberRepository.addMember(member);
    }
}