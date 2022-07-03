package com.hln.int转byte;

public class IntChangeToByte {

    public static void main(String[] args) {
        int m = 2;
        byte[] bytes = new byte[4];
        bytes[3] = (byte) m;
        bytes[2]=(byte)((m >>8)&0xFF);
        bytes[1]=(byte)((m >>16)&0xFF);
        bytes[0]=(byte)((m >>24)&0xFF);

        for (int i = 0; i < bytes.length; i++) {
            System.out.println(bytes[i]);
        }
    }
}
