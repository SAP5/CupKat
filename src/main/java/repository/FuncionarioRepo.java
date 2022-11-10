package repository;

import com.example.cupcat.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FuncionarioRepo extends JpaRepository<Funcionario, Integer> {
    List<Funcionario> findByEmailContaining(String email);
}