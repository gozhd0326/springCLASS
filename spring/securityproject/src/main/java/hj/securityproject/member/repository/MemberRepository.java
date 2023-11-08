package hj.securityproject.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hj.securityproject.member.model.Member;

public interface MemberRepository extends JpaRepository<Member,Long> {

	Member findByLoginId(String loginId); //jpa의 유도리, findBy는 일종의 명령어 LoginId는 column에서 대소문자 무시하고 찾음
	
	//400에러는 아예 서버와 연결도 되지 않은 상태로 입구컷 당한 것. 클라이언트 쪽의 문제.
	//500에러는 서버 문제
	
	
}
