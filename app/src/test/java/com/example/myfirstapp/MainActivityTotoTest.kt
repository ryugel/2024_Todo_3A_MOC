package com.example.myfirstapp

import org.junit.Test
import org.junit.Assert.*

class MainActivityTotoTest {
    @Test
    fun `Check Valid password`() {
        // Setup
        val password = "Password123!"
        // Test
        val errors = verifyPassword(password)

        // Resultat / Check / Assertion
        assertTrue(errors.isEmpty())
    }

    @Test
    fun `Check if password contains special characters`() {
        // Setup
        val caracteresSpeciaux = "~`!@#\\$%\\^&*\\(\\)-_+=<>?/\\[]\\{}|"
        val password = "!"
        // Test
        val errors = verifyPassword(password)

        // Resultat / Check / Assertion
        assertTrue(!errors.contains("Le mot de passe doit contenir au moins un caractère spécial parmi $caracteresSpeciaux."))
    }

    @Test
    fun `Check if password does not contains special characters`() {
        // Setup
        val caracteresSpeciaux = "~`!@#\\$%\\^&*\\(\\)-_+=<>?/\\[]\\{}|"
        val password = "Passw0rd123"
        // Test
        val errors = verifyPassword(password)

        // Resultat / Check / Assertion
        assertTrue(errors.contains("Le mot de passe doit contenir au moins un caractère spécial parmi $caracteresSpeciaux."))
    }
}