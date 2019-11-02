package com.pact.rentcar.repository;


import com.pact.rentcar.model.Comment;
import com.pact.rentcar.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

}