package com.ventas.ventadepasajes.domain.model;

import com.ventas.ventadepasajes.domain.exceptions.ExceptionGeneral;
import com.ventas.ventadepasajes.domain.model.entity.User;
import com.ventas.ventadepasajes.domain.testdatabuilder.UserTestDataBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestUserModel {

    private UserTestDataBuilder dataBuilder = new UserTestDataBuilder();

    @Test
    public void validateNameMandatory() {
        dataBuilder.withoutName();
        assertThrows(ExceptionGeneral.class, () -> dataBuilder.build(), "Name is mandatory");
    }

    @Test
    public void validateLastNameMandatory() {
        dataBuilder.withoutLastName();
        assertThrows(ExceptionGeneral.class, () -> dataBuilder.build(), "Last name is mandatory");
    }

    @Test
    public void validateEmailMandatory() {
        dataBuilder.withoutEmail();
        assertThrows(ExceptionGeneral.class, () -> dataBuilder.build(), "Email is mandatory");
    }

    @Test
    public void validatePhoneMandatory() {
        dataBuilder.withoutPhone();
        assertThrows(ExceptionGeneral.class, () -> dataBuilder.build(), "Phone is mandatory");
    }

    @Test
    public void validateRoleMandatory() {
        dataBuilder.withoutRole();
        assertThrows(ExceptionGeneral.class, () -> dataBuilder.build(), "Role is mandatory");
    }

    @Test
    public void validatePasswordMandatory() {
        dataBuilder.withoutPassword();
        assertThrows(ExceptionGeneral.class, () -> dataBuilder.build(), "Password is mandatory");
    }

    @Test
    public void validateSmallName() {
        dataBuilder.smallName();
        assertThrows(ExceptionGeneral.class, () -> dataBuilder.build(), "Name must have min 3 characters");
    }

    @Test
    public void validateSmallLastName() {
        dataBuilder.smallLastName();
        assertThrows(ExceptionGeneral.class, () -> dataBuilder.build(), "Last name must have min 3 characters");
    }

    @Test
    public void validateLongName() {
        dataBuilder.longName();
        assertThrows(ExceptionGeneral.class, () -> dataBuilder.build(), "Name must have max 30 characters");
    }

    @Test
    public void validateLongLastName() {
        dataBuilder.longLastName();
        assertThrows(ExceptionGeneral.class, () -> dataBuilder.build(), "Last name must have max 30 characters");
    }

    @Test
    public void validateSmallPhone() {
        dataBuilder.smallPhone();
        assertThrows(ExceptionGeneral.class, () -> dataBuilder.build(), "Phone must have min 7 characters");
    }

    @Test
    public void validateLongPhone() {
        dataBuilder.longPhone();
        assertThrows(ExceptionGeneral.class, () -> dataBuilder.build(), "Phone must have max 14 characters");
    }

    @Test
    public void validateSmallPassword(){
        dataBuilder.smallPassword();
        assertThrows(ExceptionGeneral.class, () -> dataBuilder.build(), "Password must have min 8 characters");
    }

    @Test
    public void validateLongPassword(){
        dataBuilder.longPassword();
        assertThrows(ExceptionGeneral.class, () -> dataBuilder.build(), "Phone must have max 30 characters");
    }

    @Test
    public void testGetterMethods(){
        User user = dataBuilder.build();
        assertEquals("Brayan", user.getName());
        assertEquals("User", user.getLastName());
        assertEquals("brayan@ceiba.com.co", user.getEmail());
        assertEquals("3013439323", user.getPhone());
        assertEquals(1, user.getRole());
        assertEquals("passwordasd", user.getPassword());

    }
}