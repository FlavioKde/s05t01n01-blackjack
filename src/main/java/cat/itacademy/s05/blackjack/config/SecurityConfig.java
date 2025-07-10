package  cat.itacademy.s05.blackjack.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.server.SecurityWebFilterChain;

/**
 * Configuración de seguridad para aplicaciones WebFlux (Reactivas).
 * Descomenta las secciones según necesites.
 */
@EnableWebFluxSecurity // Habilita seguridad reactiva
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        return http
                // --- Configuración CSRF (Protección contra ataques) ---
                .csrf(csrf -> csrf.disable()) // ⚠️ Descomenta si usas Postman/Insomnia. En producción, evalúa riesgos.
                // .csrf(csrf -> csrf.csrfTokenRepository(CookieServerCsrfTokenRepository.withHttpOnlyFalse())) // Alternativa para frontend

                // --- Reglas de autorización ---
                .authorizeExchange(exchanges -> exchanges
                        // Endpoints públicos (sin autenticación)
                        .pathMatchers(
                                "/swagger-ui.html",
                                "/v3/api-docs/**",
                                "/webjars/**"
                        ).permitAll() // Permite acceso a Swagger

                        // Endpoints protegidos por roles (ejemplo)
                        // .pathMatchers("/api/player/**").hasRole("PLAYER") // Solo jugadores
                        // .pathMatchers("/api/admin/**").hasRole("ADMIN")   // Solo administradores

                        // Todos los demás endpoints requieren autenticación
                        .anyExchange().permitAll() // ⚠️ Cambia a .authenticated() cuando definas tus endpoints
                )

                // --- Autenticación ---
                // .httpBasic(withDefaults()) // Autenticación básica (usuario/contraseña)
                // .formLogin(form -> form.disable()) // Desactiva login por formulario (sin frontend)

                .build();
    }

    /**
     * Usuario en memoria (SOLO para desarrollo/pruebas).
     * En producción, usa una base de datos con ReactiveUserDetailsService.
     */
    @Bean
    public MapReactiveUserDetailsService userDetailsService() {
        // ⚠️ Ejemplo de usuario. Cambia/elimina en producción.
        UserDetails player = User.withDefaultPasswordEncoder() // No usar in production!
                .username("player")
                .password("password")
                .roles("PLAYER")
                .build();

        // UserDetails admin = User.builder()
        //     .username("admin")
        //     .password("{bcrypt}$2a$10$...") // Contraseña encriptada
        //     .roles("ADMIN", "PLAYER")
        //     .build();

        return new MapReactiveUserDetailsService(player); // Añade más usuarios si es necesario
    }
}