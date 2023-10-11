package miu.edu.myelibray.elibrayapp.repository;

import miu.edu.myelibray.elibrayapp.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher,String> {
}
