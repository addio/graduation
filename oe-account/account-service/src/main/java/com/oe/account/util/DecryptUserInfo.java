package com.oe.account.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.oe.account.entity.User;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Security;
import java.security.spec.InvalidParameterSpecException;
import java.util.Arrays;

/**
 * @author wangwj
 * @data 2018/12/22
 */
public class DecryptUserInfo {

    private static Logger log = LoggerFactory.getLogger(DecryptUserInfo.class);

    /**
     * 解密用户信息
     *
     * @param encryptedData 加密数据
     * @param iv            加密算法的初始向量
     * @param sessionKey    数据进行加密签名的密钥
     * @return 用户信息对象
     */
    public static User decryptUserInfo(String encryptedData, String iv, String sessionKey) {
        byte[] dataBytes = Base64.decode(encryptedData);
        byte[] ivBytes = Base64.decode(iv);
        byte[] keyBytes = Base64.decode(sessionKey);
        User entity = new User();

        int base = 16;
        try {
            if (keyBytes.length % base != 0) {
                int groups = keyBytes.length / base + (keyBytes.length % base != 0 ? 1 : 0);
                byte[] temp = new byte[groups * base];
                Arrays.fill(temp, (byte) 0);
                System.arraycopy(keyBytes, 0, temp, 0, keyBytes.length);
                keyBytes = temp;
            }
            Security.addProvider(new BouncyCastleProvider());
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding", "BC");
            SecretKeySpec spec = new SecretKeySpec(keyBytes, "AES");
            AlgorithmParameters parameters = AlgorithmParameters.getInstance("AES");
            parameters.init(new IvParameterSpec(ivBytes));
            // 初始化
            cipher.init(Cipher.DECRYPT_MODE, spec, parameters);
            byte[] resultByte = cipher.doFinal(dataBytes);
            if (null != resultByte && resultByte.length > 0) {
                String result = new String(resultByte, "UTF-8");
                JSONObject object = JSON.parseObject(result);
                entity.setNickName(object.getString("nickName"));
                entity.setGender(object.getInteger("gender"));
                entity.setAvatarUrl(object.getString("avatarUrl"));
                entity.setUserName(object.getString("openId"));
                return entity;
            }
        } catch (
                NoSuchAlgorithmException | NoSuchPaddingException | IllegalBlockSizeException e) {
            log.error(e.getMessage(), e);
        } catch (
                InvalidParameterSpecException e) {
            log.error(e.getMessage(), e);
        } catch (
                BadPaddingException e) {
            log.error(e.getMessage(), e);
        } catch (
                UnsupportedEncodingException e) {
            log.error(e.getMessage(), e);
        } catch (InvalidKeyException e) {
            log.error(e.getMessage(), e);
        } catch (
                InvalidAlgorithmParameterException e) {
            log.error(e.getMessage(), e);
        } catch (
                NoSuchProviderException e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }
}
