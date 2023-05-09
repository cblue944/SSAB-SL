package ax.lindblom.ssab.util;

public class StringFormater {

    private StringFormater(){
        throw new IllegalStateException("This is a utility class");
    }

    public static String cutWithEllipsis(String str, int maxLength){
        if(maxLength<=3) {
            throw new IllegalArgumentException(
                    String.format("Parameter maxLength must be a greater than 3. [%n]", maxLength));
        }
        if(str==null || str.length() <= maxLength) {
            return str;
        } else {
            return str.substring(0,maxLength-3)+"...";
        }
    }
}
