package tech.btzstudio.teamline.domain.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import tech.btzstudio.teamline.domain.Picture;

@Repository
public interface PictureRepository extends PagingAndSortingRepository<Picture, Long> {

}
