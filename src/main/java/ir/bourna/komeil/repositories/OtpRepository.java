package ir.bourna.komeil.repositories;

import ir.bourna.komeil.models.Enums.OtpStatus;
import ir.bourna.komeil.models.Otp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OtpRepository extends JpaRepository<Otp,Long> {
    Otp findByMobileAndStatus(String mobile , OtpStatus status);
}
