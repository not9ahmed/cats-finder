package com.notahmed.catsfinder.newStructure.security;

// configuration must be registered
//@ConfigurationProperties(prefix = "rsaKeys")
public record RSAKeyProperties (
        String publicKey,
        String privateKey
){ }
