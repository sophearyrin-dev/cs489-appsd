package miu.edu.myelibray.elibrayapp.repository;

import miu.edu.myelibray.elibrayapp.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher,String> {
}
