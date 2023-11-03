package com.notahmed.catsfinder.security;

// configuration must be registered
// TODO read more about congiguration properties in spring booy
//@ConfigurationProperties(prefix = "rsaKeys")
public record RSAKeyProperties (
        String publicKey,
        String privateKey
){ }
