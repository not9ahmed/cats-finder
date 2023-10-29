package com.notahmed.catsfinder.security;

import org.springframework.boot.context.properties.ConfigurationProperties;

// configuration must be registered
//@ConfigurationProperties(prefix = "rsaKeys")
public record RSAKeyProperties (
        String publicKey,
        String privateKey
){ }
