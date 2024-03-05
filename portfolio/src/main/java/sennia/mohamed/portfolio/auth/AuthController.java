package sennia.mohamed.portfolio.auth;

import io.jsonwebtoken.Jwt;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import sennia.mohamed.portfolio.conifg.JwtService;
import sennia.mohamed.portfolio.user.User;
import sennia.mohamed.portfolio.user.UserRepository;
@CrossOrigin(
        origins = {
                "http://localhost:4200",

        },
        methods = {
                RequestMethod.OPTIONS,
                RequestMethod.GET,
                RequestMethod.PUT,
                RequestMethod.DELETE,
                RequestMethod.POST
        })
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor

public class AuthController {

private  final  AuthService authService;

        @PostMapping("/logIn")
        public ResponseEntity<CostumeResponse> logIn(@RequestBody LogInRequest logInRequest){

              try {
                  return   new ResponseEntity<>(this.authService.logIn(logInRequest),HttpStatus.OK);
              }catch (UsernameNotFoundException exception){
                      return  new ResponseEntity<>(HttpStatus.FORBIDDEN);
              }

        }
        @PostMapping("/signUp")
        public ResponseEntity<CostumeResponse> signUp(@RequestBody User user){
               return new ResponseEntity<>(this.authService.signUp(user), HttpStatus.OK);
        }




}
