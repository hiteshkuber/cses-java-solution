import java.io.*;
import java.util.*;

public class Towers {

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();

        int n = fs.nextInt();

        int[] cubes = new int[n];

        for (int i = 0; i < n; i++) {
            int start = fs.nextInt();

            cubes[i] = start;
        }

        TreeMap<Integer, Integer> towers = new TreeMap<>();
        for (int cube : cubes) {
            Integer key = towers.higherKey(cube);
            if (key == null) {
                towers.put(cube, towers.getOrDefault(cube, 0) + 1);
            } else {
                int count = towers.get(key);
                if (count == 1) {
                    towers.remove(key);
                } else {
                    towers.put(key, count - 1);
                }
                towers.put(cube, towers.getOrDefault(cube, 0) + 1);
            }
        }

        int result = 0;
        for (int count : towers.values()) {
            result += count;
        }

        System.out.print(result);

    }

    // Very fast input reader
    static class FastScanner {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c;
            while ((c = read()) <= ' ') if (c == -1) return -1;
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            int val = c - '0';
            while ((c = read()) > ' ') val = val * 10 + (c - '0');
            return val * sign;
        }
    }
}
