package com.jchang.explorer.constant;

import java.math.BigInteger;

public class Constant {

    public static String COIN_MARKETCAP_API = "https://api.coinmarketcap.com/v1/ticker/";

    public static BigInteger GWeiFactor = BigInteger.valueOf(10).pow(9);

    public static String LatestBlockNumberKey = "latest";

    public static long TimestampFactor = 1000;

    public static long EightHourToSecond = 8 * 60 * 60;
}
