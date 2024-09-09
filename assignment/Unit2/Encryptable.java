//ref: https://blog.csdn.net/gitblog_01105/article/details/141410312

interface Encryptable {

    public void encrypt(String data);

    public void decrypt(String encryptedData);

}

class AES implements Encryptable {

    @Override
    public void encrypt(String data) {
    }

    @Override
    public void decrypt(String encryptedData) {
    }

}

class RSA implements Encryptable {

    @Override
    public void encrypt(String data) {
    }

    @Override
    public void decrypt(String encryptedData) {
    }

}