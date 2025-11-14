
package com.gym.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gym.entity.Policy;

@Repository
public interface PolicyDao extends JpaRepository<Policy, Long> {
	boolean existsByName(String name);
	List<Policy> findByCamountGreaterThan(int amt);
}
