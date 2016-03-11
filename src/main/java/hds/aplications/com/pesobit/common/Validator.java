package hds.aplications.com.pesobit.common;


public class Validator {

    public static boolean isEmailValid(String email)
    {
        if(email != null && email != "")
        {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
        }

        return false;
    }
}
