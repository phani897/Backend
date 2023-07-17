package easyAutomate.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import easyAutomate.data.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
	User findByEmail(String email);
}