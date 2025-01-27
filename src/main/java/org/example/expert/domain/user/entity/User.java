package org.example.expert.domain.user.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.expert.domain.common.dto.AuthUser;
import org.example.expert.domain.common.entity.Timestamped;
import org.example.expert.domain.user.enums.UserRole;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "users")
public class User extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String email;

    private String password;

    private String nickname; // 중복 가능하도록 설정

    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    public static User fromAuthUser(AuthUser authUser) {
        return User.builder()
                .id(Long.parseLong(authUser.getUsername()))
                .email(authUser.getEmail())
                .nickname(authUser.getNickname()) // AuthUser에서 닉네임 추가
                .userRole(authUser.getUserRole())
                .build();
    }

    public void changePassword(String password) {
        this.password = password;
    }

    public void updateRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public void updateNickname(String nickname) {
        this.nickname = nickname;
    }
}
