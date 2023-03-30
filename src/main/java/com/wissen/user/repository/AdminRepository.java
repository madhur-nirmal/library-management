package com.wissen.user.repository;

import com.wissen.user.entity.AppUserRole;
import com.wissen.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminRepository extends JpaRepository<User, Long> {
}
