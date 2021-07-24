package library.service;

import library.entity.UserRole;
import library.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleService {
    
    @Autowired
    UserRoleRepository urRepo;
    
}
