package sennia.mohamed.portfolio.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sennia.mohamed.portfolio.user.Role;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CostumeResponse {
    private String token;
    private Role role;

}
