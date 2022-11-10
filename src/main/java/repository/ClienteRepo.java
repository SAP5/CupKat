package repository;

import com.example.cupcat.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteRepo extends JpaRepository<Cliente, Integer> {
    List<Cliente> findByEmailContaining(String email);
}
