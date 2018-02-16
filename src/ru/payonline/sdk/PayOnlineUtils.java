package ru.payonline.sdk;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.math.BigInteger;
import java.net.URL;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public final class PayOnlineUtils {

    public static String getMD5Hash(String str) throws PaymentClientException {
        MessageDigest m;
        try {
            m = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new PaymentClientException("Can't receive hash", e);
        }

        m.reset();
        m.update(str.getBytes());

        byte[] digest = m.digest();
        BigInteger bigInt = new BigInteger(1,digest);
        StringBuilder hash = new StringBuilder(bigInt.toString(16));

        while(hash.length() < 32 ){
            hash.insert(0, "0");
        }

        return hash.toString();
    }

    public static String callApi(String url, String query) throws IOException, PaymentClientException {
        URL obj = new URL(url);
        HttpsURLConnection conn = null;

        try{
            conn = (HttpsURLConnection) obj.openConnection();
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
        } catch(Exception e){
            throw new PaymentClientException("Can't open connection", e);
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }

        DataOutputStream wr = null;
        try {
            wr = new DataOutputStream(conn.getOutputStream());
            wr.writeBytes(query);
        } catch(Exception e) {
            throw new PaymentClientException("Can't get output stream", e);
        } finally {
            if (wr != null){
                wr.flush();
                wr.close();
            }
        }

        StringBuilder response = new StringBuilder();
        BufferedReader in = null;
        try {
            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
        } catch(Exception e){
            throw new PaymentClientException("Can't read input stream", e);
        } finally {
            if (in != null) {
                in.close();
            }
        }

        return response.toString();
    }

    public static Map<String, String> parseQueryString(String query) {
        String[] params = query.split("&");
        Map<String, String> map = new LinkedHashMap<>();
        for (String param : params)
        {
            int index = param.indexOf("=");
            String name = param.substring(0, index);
            String value = param.substring(index + 1);
            map.put(name, value);
        }
        return map;
    }

    public static String createQueryString(Map<?,?> map) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<?,?> entry : map.entrySet()) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(String.format("%s=%s",
                    entry.getKey().toString(),
                    entry.getValue().toString()
            ));
        }

        return sb.toString();
    }

    public static String toUTF8(String s) throws PaymentClientException {
        try {
            if (stringIsNullOrWhiteSpace(s)){
                return null;
            }

            return new String(s.getBytes("UTF-8"), "ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            throw new PaymentClientException("Can't convert string to UTF-8", e);
        }
    }

    public static String urlEncodeUTF8(String s) throws PaymentClientException {
        try {
            if (stringIsNullOrWhiteSpace(s)){
                return null;
            }

            return URLEncoder.encode(s, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new PaymentClientException("Can't make url encoding for string", e);
        }
    }

    public static boolean stringIsNullOrWhiteSpace(String s) {
        return isNullOrEmpty(s) || isNullOrWhitespace(s);
    }

    public static boolean isNullOrEmpty(String s) {
        return s == null || s.length() == 0;
    }

    public static boolean isNullOrWhitespace(String s) {
        return s == null || isWhitespace(s);
    }

    private static boolean isWhitespace(String s) {
        int length = s.length();
        if (length > 0) {
            for (int i = 0; i < length; i++) {
                if (!Character.isWhitespace(s.charAt(i))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
