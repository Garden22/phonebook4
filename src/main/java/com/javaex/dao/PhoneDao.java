package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.PersonVo;

@Repository
public class PhoneDao {

   @Autowired
   private SqlSession sqlSession;
   

   public List<PersonVo> getPersonList() {
      List<PersonVo> personList  = sqlSession.selectList("phonebook.selectList");
      System.out.println(personList);
      
      return personList;
   }
   
   
   public void personInsert(PersonVo personVo) {
	   sqlSession.insert("phonebook.personInsert", personVo);
   }


   public void personDelete(int personId) {
	   sqlSession.delete("phonebook.personDelete", personId);
   }


   public PersonVo getPerson(int personId) {
	  PersonVo personVo = sqlSession.selectOne("phonebook.getPerson", personId);
      
	  return personVo;
   }


   public void personUpdate(PersonVo personVo) {
      sqlSession.update("phonebook.personUpdate", personVo);
   }


}