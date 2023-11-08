package com.hj.jdbcproject.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hj.jdbcproject.model.Member;
import com.hj.jdbcproject.repository.MemberRepository;
import com.hj.jdbcproject.service.MemberService;

@Service //bean 만드는 annotation
public class MemberServiceImpl implements MemberService{

	private MemberRepository memberRepository;
	
	@Autowired
	public MemberServiceImpl(MemberRepository memberRepository) {
		super();
		this.memberRepository = memberRepository;
	}

	@Override //controller가 사용 Repository를 부름
	public Member saveMember(Member member) {
		// TODO Auto-generated method stub
		return memberRepository.save(member);
	}

	@Override
	public Member getMemberById(long id) {
		// TODO Auto-generated method stub
		return memberRepository.findById(id).orElseThrow(()->null);
	}

	@Override
	public Member getMemberByName(String name) {
		// TODO Auto-generated method stub
		return memberRepository.findByName(name).orElseThrow(()->null);
	}

	@Override
	public List<Member> getAllMembers() {
		// TODO Auto-generated method stub
		return memberRepository.findAll();
	}

//create table members ( id bigint(int long형) not null(빈칸을 허용하지 않겠다) auto_increment, name varchar(255)(이름이 255자까지) not null, primary key(id)(id중복은 허용하지 않는다) )

	
}
