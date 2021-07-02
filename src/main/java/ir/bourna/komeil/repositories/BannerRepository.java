package ir.bourna.komeil.repositories;

import ir.bourna.komeil.models.Banner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BannerRepository extends JpaRepository<Banner , Long> {
    Banner findByBannerType(Banner.BannerType type);
}

