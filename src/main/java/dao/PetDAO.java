package dao;

import java.util.List;
import dominio.Pet;

public interface PetDAO {
    void salvar(Pet pet);
    Pet buscarPorId(Long id);
    List<Pet> listarTodos();
    void atualizar(Pet pet);
    void remover(Pet pet);
}