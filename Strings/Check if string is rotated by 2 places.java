/* AntiClockwise rotation by k places -> substring(k,len) + substring(0,k)
   Clockwise rotation by k places -> substring(len-k,len) + substring(0,len-k)
*/

class Gfg {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String a = br.readLine().trim();
            String b = br.readLine().trim();

            // Clockwise rotation by 2 means string starts with last 2 elements and
            // remaining string is appended
            String clockwise = b.substring(b.length() - 2) + b.substring(0, b.length() - 2);
            // Anticlockwise rotation by 2 means first 2 elements are appended at end of
            // remaining string
            String anticlockwise = b.substring(2) + b.substring(0, 2);

            System.out.println(a.equals(clockwise) || a.equals(anticlockwise) ? 1 : 0);
        }
    }
}