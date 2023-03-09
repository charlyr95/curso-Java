/*
ArgentinaPrograma 4.0
Curso Inicial Java
Alumno: Carlos Romero

Este código requiere la librería org.jsoup, la versión
usada es la 1.15.4

Aplico el ejercicio del monotributo para calcular
la categoría del monotributo según ingresos brutos,
superficie afectada y energía eléctrica, los otros
factores se descartan.

Para conocer los valores actuales del monotributo,
directamente hago webscraping sobre la página de
AFIP para registrar los valores actuales de ingresos
brutos, superficie y energía y los guardo en
diferentes arreglos.

Para comparar la categoría según los datos ingresado
por el usuario aplico un for para recorrer los arreglos
y comparo todos los arreglos a la vez, cuando esa comparación
es true devuelvo la categoría comparada y aplico un break
para salir del for ya que las categorías siguientes también
sería true para la comparación.
 */
package ejercicios.clase1;

 import java.io.IOException;
 import java.util.Scanner;
 
 import org.jsoup.Connection.Response;
 import org.jsoup.Jsoup;
 import org.jsoup.nodes.Document;
 import org.jsoup.nodes.Element;
 import org.jsoup.select.Elements;
 
 class c1ejercicio2 {
 
     public static final String url = "https://www.afip.gob.ar/monotributo/categorias.asp";
 
     public static void main (String[] args) {
 
         // Compruebo si me da un 200 al hacer la petición
         if (getStatusConnectionCode(url) == 200) {
 
             // Obtengo el HTML de la web en un objeto Document
             Document document = getHtmlDocument(url);
 
             // Busco todas las ocurrencia de la etiqueta "tr" y las almaceno en una lista (Elements):
             Elements filas = document.select("tr");
 
             // Defino los arreglos para hacer la comparación y establezco el máximo de categorías de monotributo
             String[] arrCategoria = new String[14];
             float[] arrIngresos = new float[14];
             float[] arrSuperficie = new float[14];
             float[] arrEnergia = new float[14];
             int i = 0;
 
             // Recorro los datos obtenidos, se corresponden a las filas de la tabla
             for (Element elemento : filas) {
 
                 //Obtengo los datos de los encabezados que necesito (Categoría, Ingresos Brutos, Energía Eléctrica)
                 Elements htmlCategoria = elemento.getElementsByAttributeValueContaining("headers", "th_cat_t14");
                 Elements htlmIngresos = elemento.getElementsByAttributeValueContaining("headers", "th_ing_br_t15");
                 Elements htlmSuperficie = elemento.getElementsByAttributeValueContaining("headers", "th_sup_af_t15");
                 Elements htlmEnergia = elemento.getElementsByAttributeValueContaining("headers", "th_energ_t15");
 
                 //Filtro los datos
                 String categoria = htmlCategoria.text();
                 String ingresos = htlmIngresos.text();
                 String superficie = htlmSuperficie.text();
                 String energia = htlmEnergia.text();
 
                 //Filtro los contenedores que no tiene datos o son nulos y saco las categorías "exento" que no aplican al ejercicio
                 if(categoria.length() > 0 && !(categoria.contains("exento"))){
 
                     // Descomentar si se desea ver los datos
                     System.out.println("Categoría: "+categoria);
                     System.out.println("Ingresos brutos: "+ingresos);
                     System.out.println("Superficie: "+superficie);
                     System.out.println("Energia: "+energia);
                     System.out.println(""); //Separador

 
                     //Agrego los datos a la lista
                     arrCategoria[i] = categoria;
                     arrIngresos[i] = parseToFloat(ingresos);
                     arrSuperficie[i] = parseToInt(superficie);
                     arrEnergia[i] = parseToInt(energia);
                     i++;
                 }
             }
 
             //Luego de hacer webscrapin ahora solicito al usuario los datos
             System.out.print("Calculadora categoría monotributo\n");
             Scanner sc = new Scanner(System.in);
             System.out.print("Ingresos brutos ($): ");
             float ingresoSc = parseToFloat(sc.nextLine());
             System.out.print("Superficie afectada (m2): ");
             int superficieSc = parseToInt(sc.nextLine());
             System.out.print("Energia eléctrica (Kw): ");
             int energiaSc = parseToInt(sc.nextLine());
             String cat = "";
 
             for(int index=0; index<arrCategoria.length; index++){
                 if(ingresoSc < arrIngresos[index] && superficieSc < arrSuperficie[index] && energiaSc < arrEnergia[index]){
                     cat = arrCategoria[index];
                     break;
                 }
             }
             if(cat != "") System.out.print("\nPertenece a la categoría " + cat);
             else System.out.print("\nNo se encuentra categoría");
 
         } else {
             System.out.println("El Status Code no es OK es: " + getStatusConnectionCode(url));
         }
     }
 
 
     /**
      * Con este método compruebo el Status code de la respuesta que recibo al hacer la petición
      * EJM:
      * 		200 OK					300 Multiple Choices
      * 		301 Moved Permanently	305 Use Proxy
      * 		400 Bad Request			403 Forbidden
      * 		404 Not Found			500 Internal Server Error
      * 		502 Bad Gateway			503 Service Unavailable
      * param url
      * return Status Code
      */
     public static int getStatusConnectionCode(String url) {
         Response response = null;
 
         try {
             response = Jsoup.connect(url).userAgent("Mozilla/5.0").timeout(100000).ignoreHttpErrors(true).execute();
         } catch (IOException ex) {
             System.out.println("Excepción al obtener el Status Code: " + ex.getMessage());
         }
         return response.statusCode();
     }
 
 
     /**
      * Con este método devuelvo un objeto de la clase Document con el contenido del
      * HTML de la web que me permitirá parsearlo con los métodos de la librelia JSoup
      * @param url
      * @return Documento con el HTML
      */
     public static Document getHtmlDocument(String url) {
 
         Document doc = null;
 
         try {
             doc = Jsoup.connect(url).userAgent("Mozilla/5.0").timeout(100000).get();
         } catch (IOException ex) {
             System.out.println("Excepción al obtener el HTML de la página" + ex.getMessage());
         }
 
         return doc;
 
     }
 
     public static float parseToFloat(String number){
         String[] arrAux = number.split(" ");
         String aux = "0.0";
 
         for(String texto: arrAux){
             aux = texto.replace(".","").replace(",",".").replace(" ","");
             if (aux.charAt(0) != '\0'){
                 boolean isNumeric = (Character.isDigit(aux.charAt(0)));
                 if (isNumeric) {
                     return Float.parseFloat(aux);
                 }
             }
         }
         return Float.parseFloat(aux);
     }
 
     public static int parseToInt(String number){
         String[] arrAux = number.split(" ");
         String aux = "0";
 
         for(String texto: arrAux){
             aux = texto.replace(".","").replace(",",".").replace(" ","");
             if (aux.charAt(0) != '\0'){
                 boolean isNumeric = (Character.isDigit(aux.charAt(0)));
                 if (isNumeric) {
                     return Integer.parseInt(aux);
                 }
             }
         }
         return Integer.parseInt(aux);
     }
 }
 