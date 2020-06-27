package com.ncu.zsq.student_service.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.ncu.zsq.student_service.Pojo.Character;
import org.springframework.stereotype.Service;

@Service
public class TokenService {

    public String getToken(Character character) {
        String token = "";
        token = JWT.create().withAudience(character.getName())
                .sign(Algorithm.HMAC256(character.getPassword()));
        return token;
    }

    public int decodeToken(String token) {

        return Integer.parseInt(JWT.decode(token).getAudience().get(0));

    }
}
