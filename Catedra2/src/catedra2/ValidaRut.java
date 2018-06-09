
package catedra2;

public class ValidaRut {
    public static String getRutDV(String strRutParam) {
        String DV;
        int suma, resto;
        String strCeros = "00000000";
        
        strRutParam=strRutParam.trim();
        strRutParam = strCeros.substring(0, 8-strRutParam.length()) + strRutParam;
        
        
        suma = Integer.parseInt(strRutParam.substring(0, 1))*3 +  
               Integer.parseInt(strRutParam.substring(1, 2))*2 + 
               Integer.parseInt(strRutParam.substring(2, 3))*7 +
               Integer.parseInt(strRutParam.substring(3, 4))*6 +                 
               Integer.parseInt(strRutParam.substring(4, 5))*5 + 
               Integer.parseInt(strRutParam.substring(5, 6))*4 + 
               Integer.parseInt(strRutParam.substring(6, 7))*3 +
               Integer.parseInt(strRutParam.substring(7, 8))*2;
        
        resto = 11-(suma%11);
        DV = String.valueOf(resto);
                
        if (DV.equals("11")) {
            DV = "0";
        }    
            
        if (DV.equals("10")) {
            DV = "K";
        }                        
                    
        return DV;
    }
    
    public static boolean isInteger(String integerParam) {
        if (integerParam==null) {
            return false;
        }
        try {
            int l = Integer.parseInt(integerParam);
            return true;
        } catch(Exception e) {
            return false;
        }
    }
    public static boolean isValidRut(String rutParam, String dvParam) {
        //  Validar que rut sea numerico
        if (isInteger(rutParam)) {
            if (dvParam!=null && dvParam.trim().length()!=0) {
                if (getRutDV(rutParam) == null ? dvParam == null : getRutDV(rutParam).equals(dvParam)) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
