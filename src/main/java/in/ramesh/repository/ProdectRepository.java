package in.ramesh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ramesh.entity.ProductEntity;

public interface ProdectRepository extends JpaRepository<ProductEntity, Integer>{

}
