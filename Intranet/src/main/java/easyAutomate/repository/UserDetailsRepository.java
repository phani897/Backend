package easyAutomate.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import easyAutomate.data.UserDetails;

@Repository("userDetailsRepository")
public interface UserDetailsRepository extends MongoRepository<UserDetails, String> {
	// You can add custom query methods if needed
}
