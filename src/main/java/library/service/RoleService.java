package library.service;

import library.entity.UserRole;
import library.repository.RoleRepository;
import java.util.List;
import library.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    
    @Autowired
    RoleRepository roleRepo;
    

}
