package miu.edu.camsys.camsys614133.repository;

import miu.edu.camsys.camsys614133.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
