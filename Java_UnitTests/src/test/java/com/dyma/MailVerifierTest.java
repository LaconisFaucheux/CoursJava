package com.dyma;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MailVerifierTest {

    @Test
    void isMail_should_return_true() {
        var mail = "test@test.com";
        var result = MailVerifier.isMail(mail);
        assertThat(result).isTrue();
    }

    @Test
    void isMail_should_return_false_when_double_at() {
        var mail = "test@@test.com";
        var result = MailVerifier.isMail(mail);
        assertThat(result).isFalse();
    }
}