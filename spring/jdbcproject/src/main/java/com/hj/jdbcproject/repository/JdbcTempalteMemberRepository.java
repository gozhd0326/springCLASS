package com.hj.jdbcproject.repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import com.hj.jdbcproject.model.Member;

@Repository //구현체임
public class JdbcTempalteMemberRepository implements MemberRepository{

	private final JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JdbcTempalteMemberRepository(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Member save(Member member) {
//		//1. 간단버전(But id를 얻어올 수 없음)
//		jdbcTemplate.update("insert into members(name) values(?)", member.getName());
//		return member;
		//2. SQL 이용한 솔루션
//		GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
//		jdbcTemplate.update((connection)->{
//		PreparedStatement ps = connection.prepareStatement(
//				"insert into members(name) values(?)",
//				Statement.RETURN_GENERATED_KEYS
//				);
//		ps.setString(1, member.getName());
//		return ps;
//		},keyHolder);
//		long id = keyHolder.getKey().longValue(); //longValue는 key의 값이 long형이 아닐 수도 있기 때문에 long형으로 바꾸기 위한 것
//		member.setId(id);
//		//3. SQL을 사용하지 않는 솔루션
//		SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
//		jdbcInsert.withTableName("members").usingGeneratedKeyColumns("id");
//		Map<String, Object> parameters = new HashMap<>();
//		parameters.put("name", member.getName());
//		Number key = jdbcInsert.executeAndReturnKey(
//				new MapSqlParameterSource(parameters));
//		member.setId(key.longValue());
		return member;
	}

	@Override
	public Optional<Member> findById(Long id) { //원래 같았으면 여기서 Member를 return 하는 것이 맞아보일 수 있지만 Optional 객체에 담아서 return 한다. 그 이유는 Member 객체가 null 일 수 있기 때문에)
		List<Member> result = jdbcTemplate.query("select from members where id = ?" , memberRowMapper(), id); //query라는 애는 list의 형태로 보내주기 때문에
		return result.stream().findAny(); // 함수형 프로그래밍을 사용하면 좋은 이유는 여러 줄의 내용을 한줄로 간단하게 끝낼 수 있기 때문이다.
		//Any는 걸리면 찾은 애를 리턴해 아니면 null이면 optional.empty를 리턴해
	}

	@Override
	public Optional<Member> findByName(String name) {
		List<Member> result = jdbcTemplate.query("select from members where name = ?", memberRowMapper(),name);
		return result. stream().findAny();
	}

	@Override
	public List<Member> findAll() {
		// TODO Auto-generated method stub
		System.out.println("findAll - Template");
		return jdbcTemplate.query("select * from members", memberRowMapper());
		}
	private RowMapper<Member> memberRowMapper(){
//		return CallbackFunction
		return (rs,rowNum) -> {
			Member member = new Member();
			member.setId(rs.getLong("id"));
			member.setName(rs.getString("name"));
			return member;
		};
	}

}
