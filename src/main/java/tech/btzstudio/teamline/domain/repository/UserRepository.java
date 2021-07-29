package tech.btzstudio.teamline.domain.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import tech.btzstudio.teamline.domain.User;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

}
