package number_468;

import java.net.Inet6Address;
import java.net.InetAddress;

public class Solution {
    public String validIPAddress(String IP) {
        try {
            return (InetAddress.getByName(IP) instanceof Inet6Address) ? "IPv6" : "IPv4";
        } catch (Exception e) {
            return "Neither";
        }
    }

    public String validIPAddress2(String IP) {
        if (IP.split("\\.").length == 4) {
            return validateIPv4(IP);
        } else if (IP.split(":", -1).length == 8) {
            return isValidIPv6(IP);
        } else {
            return "Neither";
        }
    }

    public String validateIPv4(String IP) {
        String[] nums = IP.split("\\.", -1);
        for (String x : nums) {
            if (x.length() == 0 || x.length() > 3) {
                return "Neither";
            }
            if (x.charAt(0) == '0' && x.length() != 1) {
                return "Neither";
            }
            for (char ch : x.toCharArray()) {
                if (!Character.isDigit(ch)) {
                    return "Neither";
                }
            }
            if (Integer.parseInt(x) > 255) {
                return "Neither";
            }
        }
        return "IPv4";
    }

    public String isValidIPv6(String IP) {
        String[] nums = IP.split(":", -1);
        String hexdigits = "0123456789abcdefABCDEF";
        for (String x : nums) {
            if (x.length() == 0 || x.length() > 4) {
                return "Neither";
            }
            for (char ch : x.toCharArray()) {
                if (hexdigits.indexOf(ch) == -1) {
                    return "Neither";
                }
            }
        }
        return "IPv6";
    }



    public static void main(String[] args) {
        new Solution().validIPAddress2("2001:0db8:85a3:0:0:8A2E:0370:7334:");
    }


}
