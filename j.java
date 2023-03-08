
private static final byte[] DESKey = "netbankbank".getBytes();
private static final byte[] DESIV = "12345678".getBytes();
static AlgorithmParameterSpec iv = null;
private static Key key = null;
public NetBankPinModule() throws Exception {
    DESKeySpec keySpec = new DESKeySpec(DESKey)
    iv = new IvParameterSpec(DESIV);
    SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES&quot");
    key = keyFactory.generateSecret(keySpec);
}

public string GenerateSecurePassword()
    {
        var upper =
CreateRandomString(passwordSecurityPolicy.MinUppercase, charsUppercase);
        var num = CreateRandomString(passwordSecurityPolicy.MinNumbers,
charsNumbers);
        var nonAlpha =
CreateRandomString(passwordSecurityPolicy.MinNonAlphaCharacters,
charsSpecial);
        var lower =
CreateRandomString(passwordSecurityPolicy.MinLowercase, charsLowercase);
        var otherCount = passwordSecurityPolicy.PasswordMinLength -
passwordSecurityPolicy.MinUppercase - passwordSecurityPolicy.MinNumbers -
passwordSecurityPolicy.MinNonAlphaCharacters -
passwordSecurityPolicy.MinLowercase;
        var other = CreateRandomString(otherCount + 4, allCharacters);
        var s = upper + num + nonAlpha + lower + other;
        Random r = new Random();
        Pass = new string(s.ToCharArray().OrderBy(_ => (r.Next(2) % 2)
== 0).ToArray());
        log.debug("Password is "+ Pass);
        return Pass;
    }