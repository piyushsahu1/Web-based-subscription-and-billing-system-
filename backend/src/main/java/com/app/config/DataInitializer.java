package com.app.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.app.auth.entity.Role;
import com.app.auth.entity.User;
import com.app.auth.repository.RoleRepository;
import com.app.auth.repository.UserRepository;
import com.app.common.enums.RoleType;
import com.app.common.enums.UserStatus;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(DataInitializer.class);

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Value("${app.bootstrap.super-admin.enabled:true}")
    private boolean bootstrapSuperAdmin;

    @Value("${app.bootstrap.super-admin.email:superadmin@subscriptor.local}")
    private String superAdminEmail;

    @Value("${app.bootstrap.super-admin.password:SuperAdmin123!}")
    private String superAdminPassword;

    @Value("${app.bootstrap.super-admin.first-name:Super}")
    private String superAdminFirstName;

    @Value("${app.bootstrap.super-admin.last-name:Admin}")
    private String superAdminLastName;

    @Override
    @Transactional
    public void run(String... args) {
        log.info("Running data initializer...");

        ensureRoleExists(RoleType.SUPER_ADMIN, "Platform super administrator with full access");
        ensureRoleExists(RoleType.ORGANIZATION_ADMIN, "Organization administrator with organization-level access");
        ensureRoleExists(RoleType.CUSTOMER, "Customer role for end users");

        if (bootstrapSuperAdmin) {
            createSuperAdminIfMissing();
        }
    }

    private void ensureRoleExists(RoleType roleType, String description) {
        if (roleRepository.existsByName(roleType)) {
            return;
        }

        Role role = new Role();
        role.setName(roleType);
        role.setDescription(description);
        roleRepository.save(role);
        log.info("Seeded role: {}", roleType);
    }

    private void createSuperAdminIfMissing() {
        if (userRepository.findByEmail(superAdminEmail).isPresent()) {
            log.info("Super admin user already exists: {}", superAdminEmail);
            return;
        }

        Role superAdminRole = roleRepository.findByName(RoleType.SUPER_ADMIN)
                .orElseThrow(() -> new IllegalStateException("SUPER_ADMIN role must exist before seeding super admin user"));

        User superAdmin = new User();
        superAdmin.setFirstName(superAdminFirstName);
        superAdmin.setLastName(superAdminLastName);
        superAdmin.setEmail(superAdminEmail);
        superAdmin.setPasswordHash(passwordEncoder.encode(superAdminPassword));
        superAdmin.setStatus(UserStatus.ACTIVE);
        superAdmin.setEmailVerified(true);
        superAdmin.setRole(superAdminRole);

        userRepository.save(superAdmin);
        log.info("Created default super admin user: {}", superAdminEmail);
    }
}
