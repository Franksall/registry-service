package com.example.registry_service; // (Asegúrate que el package sea el tuyo)

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

// --- ¡AÑADE ESTOS IMPORTS! ---
import org.springframework.boot.SpringApplication;
import org.mockito.MockedStatic;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.times;

@SpringBootTest
class RegistryServiceApplicationTests {

    @Test
    void contextLoads() {
        // Esta prueba ya la teníamos y pasa
    }

    // --- ¡AÑADE ESTA NUEVA PRUEBA! ---
    @Test
    void main() {
        // Esta prueba "cubre" el método main() para Jacoco

        // 1. Preparamos un mock para la llamada estática 'SpringApplication.run'
        try (MockedStatic<SpringApplication> mocked = mockStatic(SpringApplication.class)) {

            // 2. Llamamos al método main() real
            RegistryServiceApplication.main(new String[] {});

            // 3. Verificamos que 'SpringApplication.run' fue llamado 1 vez
            mocked.verify(() -> SpringApplication.run(RegistryServiceApplication.class, new String[] {}), times(1));
        }
    }

}