package es.cifplalaboral.eduardol.tienda;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
public class Tienda {
    
    Scanner sc=new Scanner(System.in);
    private static ArrayList <Pedido> pedidos;
    private ArrayList <Articulo> articulos;
    private static ArrayList <Cliente> clientes;

    public Tienda() {
        pedidos = new ArrayList();
        articulos= new ArrayList();
        clientes = new ArrayList();
    }
    
    public static void main(String[] args) {
        Tienda t=new Tienda();
        t.cargadatos();
        t.menu();
    }
    
     public void cargadatos() {
       clientes.add(new Cliente("11111111A","ANA","658111111"));
       clientes.add(new Cliente("22222222B","LOLA","649222222"));
       clientes.add(new Cliente("33333333C","JUAN","652333333"));
       clientes.add(new Cliente("44444444D","LUIS","635444444"));
       clientes.add(new Cliente("55555555E","EVA","622555555"));
              
       articulos.add(new Articulo("1-001","RATON LOGITECH    ",14,15));
       articulos.add(new Articulo("1-002","TECLADO STANDARD  ",9,18));
       articulos.add(new Articulo("2-001","HDD SEAGATE 1TB   ", 16,80));
       articulos.add(new Articulo("2-002","SSD KINGSTOM 256GB",9,70));
       articulos.add(new Articulo("2-003","SSD KINGSTOM 512GB", 15,120));
       articulos.add(new Articulo("3-001","EPSON ET2800      ",25,200));
       articulos.add(new Articulo("3-002","EPSON XP200       ",15,80));
       articulos.add(new Articulo("4-001","ASUS LED 22       ",25,100));
       articulos.add(new Articulo("4-002","HP LED 28         ",35,180));
       articulos.add(new Articulo("4-003","SAMSUNG ODISSEY G5",22,580));
       
       LocalDate hoy = LocalDate.now();
       pedidos.add(new Pedido("11111111A-001/2023",clientes.get(0),hoy.minusDays(1), new ArrayList<>
        (List.of(new LineaPedido("1-001",1),new LineaPedido("2-001",1)))));                                                                                                                                                               //EDU
       pedidos.add(new Pedido("22222222B-001/2023",clientes.get(1),hoy.minusDays(2), new ArrayList<>
        (List.of(new LineaPedido("4-001",14),new LineaPedido("4-002",4),new LineaPedido("4-003",4)))));
       pedidos.add(new Pedido("22222222B-002/2023",clientes.get(1),hoy.minusDays(3), new ArrayList<>
        (List.of(new LineaPedido("3-001",3),new LineaPedido("3-002",3)))));
       pedidos.add(new Pedido("33333333C-001/2023",clientes.get(2),hoy.minusDays(5), new ArrayList<>
        (List.of(new LineaPedido("3-001",3),new LineaPedido("3-002",3)))));
       pedidos.add(new Pedido("22222222B-003/2023",clientes.get(1),hoy.minusDays(4), new ArrayList<>
        (List.of(new LineaPedido("2-001",2),new LineaPedido("2-002",2),new LineaPedido("2-003",2)))));
    }
    
    public void menu(){
      int opcion=0;
      do{
        System.out.println("\n\n\n\n\n\t\t\t\tMENU DE OPCIONES\n");
        System.out.println("\t\t\t\t1 - EXAMEN 1");
        System.out.println("\t\t\t\t2 - EXAMEN 2");
        System.out.println("\t\t\t\t3 - EXAMEN 3");
        System.out.println("\t\t\t\t4 - EXAMEN 4");
        System.out.println("\t\t\t\t5 - LISTAR PEDIDOS");
        System.out.println("\t\t\t\t6 - LISTAR ARTICULOS");
        System.out.println("\t\t\t\t7 - LISTAR CLIENTES");
        System.out.println("\t\t\t\t9 - SALIR");
        opcion=sc.nextInt();
        switch (opcion){
           case 1:{
             examen1();
             break;
           } 
           case 2:{
             examen2();
             break;
           }
           case 3:{
             examen3();
             break;
           } case 4:{
               examen4();
             break;
           } 
           case 5:{
             listaPedidos();
             break;
           } 
           case 6:{
             listaArticulos();
             break;
           }
           case 7:{
             listaClientes(); 
             break;
           }

        }
      }while (opcion != 9);
    }
    
    public void listaPedidos() {
        for (Pedido p:pedidos){
           System.out.println("PEDIDO "+ p.getIdPedido()+ "\tCLIENTE: " + p.getClientePedido().getNombre()
           + "\tFECHA: " + p.getFechaPedido());
        }
    }
    
    public void listaArticulos(){
        System.out.println("\n\n");
        for (Articulo a:articulos){
            System.out.println(a);
        }
    } 
    
    public void listaClientes(){
        System.out.println("\n\n");
        for (Cliente c:clientes){
            System.out.println(c);
        }
    } 
   
    
   //
   // MÉTODOS CORRESPONDIENTES AL EXAMEN AQUÍ
   //
   public String generaId(){
       String id=null;
       int opcion=0;
       int contador=0;
       do{
           System.out.println("\n\n\n\n\n\t\t\t\tINTRODUZCA LA SECCION\n");
           System.out.println("\t\t\t\t1 - PERIFÉRICOS");
           System.out.println("\t\t\t\t2 - ALMACENAMIENTO");
           System.out.println("\t\t\t\t3 - IMPRESORAS");
           System.out.println("\t\t\t\t4 - MONITORES");
           opcion=sc.nextInt();
           switch (opcion){
               case 1:{
                   id="1-";
                   break;
               }
               case 2:{
                   id="2-";
                   break;
               }
               case 3:{
                   id="3-";
                   break;
               }
               case 4:{
                   id="4-";
                   break;
               }
           }
       }while ( opcion <1 || opcion > 4);

       for (Articulo a:articulos){
           if (a.getIdArticulo().charAt(0)==id.charAt(0)){
               contador++;
           }
       }
       contador++;
       id=id+String.format("%03d", contador);
       return id;
   }
   public void examen1Eduardo() {
       String idT,descT,exT,pvpT; //TODAS LAS ENTRADAS COMO STRING FACILITA VALIDACION Y EVITA PROBLEMAS CON SCANNER

       System.out.println("ALTA DE NUEVO ARTICULO");

       //GENERAMOS EL ID TAL Y COMO SE PIDE EN EL EXAMEN
       idT=generaId();
       sc.nextLine();

       //ENTRADA DESCRIPCION (SIN NINGUN TIPO DE VALIDACION)
       System.out.println("DESCRIPCION:");
       descT=sc.nextLine();

       // EXISTENCIAS CON VALIDACION DE TIPO int
       boolean b=false;
       do {
           System.out.println("EXISTENCIAS:");
           exT=sc.next(); //Se lee la entrada de EXISTENCIAS como un String
           try {
               b=esInt(exT);
           }catch (UnidadesCero e){
               System.out.println(e.getMessage());
           }

       } while(!b); //Se sigue pidiendo entrada si no es int o salta excepcion UnidadesCero


       // PVP CON VALIDACION DE TIPO double
       b=false;
       do {
           System.out.println("PVP:");
           pvpT=sc.next(); //Se lee la entrada de EXISTENCIAS como un String
           try {
               b=esDouble(pvpT);
           }catch (PvpCero e){
               System.out.println(e.getMessage());
           }

       } while(!b);

       //AÑADO OBJETO ARTICULO A LA COLECCION PARSEANDO A int y double los datos de existencias y PVP
       articulos.add(new Articulo(idT,descT,Integer.parseInt(exT),Double.parseDouble(pvpT)));
   }

    private boolean esDouble(String s) throws PvpCero{
        double n;
        try {
            n = Double.parseDouble(s);
            if(n <= 0) throw new PvpCero("El numero introducido no puede ser un cero o un numero negativo");
            return true;
        }catch (InputMismatchException e){
            return false;

        }
    }
    private boolean esInt(String s) throws UnidadesCero{
        int n;
        try {
            n = Integer.parseInt(s);
            if(n <= 0) throw new UnidadesCero("El numero introducido no puede ser un cero o un numero negativo");
            return true;
        }catch (InputMismatchException e){
            return false;

    }
    }

    private void examen1(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce la sección del nuevo artículo:");
        System.out.println("1 - PERIFERICOS");
        System.out.println("2 - ALMACENAMIENTO");
        System.out.println("3 - IMPRESORAS");
        System.out.println("4 - MONITORES");
        int seccion = sc.nextInt();
        sc.nextLine();

        int numArticulosSeccion = contarArticulosSeccion(seccion);
        String idArticulo = generarIdArticulo(seccion, numArticulosSeccion);

        System.out.println("Introduce la descripción del artículo:");
        String descripcion = sc.nextLine();

        int existencias = 0;
        double precio = 0.0;

        boolean validInput = false;

        do {
            try {
                System.out.println("Introduce las existencias del artículo:");
                existencias = sc.nextInt();

                if (existencias <= 0) {
                    throw new IllegalArgumentException("Las existencias deben ser un número positivo.");
                }

                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Error: Debes ingresar un número entero válido para las existencias.");
                sc.nextLine(); // Limpiar el búfer del scanner
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
                sc.nextLine(); // Limpiar el búfer del scanner
            }
        } while (!validInput);

        validInput = false;

        do {
            try {
                System.out.println("Introduce el precio del artículo:");
                precio = sc.nextDouble();

                if (precio <= 0) {
                    throw new IllegalArgumentException("El precio debe ser un número positivo.");
                }

                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Error: Debes ingresar un número válido para el precio.");
                sc.nextLine(); // Limpiar el búfer del scanner
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
                sc.nextLine(); // Limpiar el búfer del scanner
            }
        } while (!validInput);

        Articulo nuevoArticulo = new Articulo(idArticulo, descripcion, existencias, precio);
        articulos.add(nuevoArticulo);

        System.out.println("¡Artículo dado de alta correctamente!");
    }

    private String generarIdArticulo(int seccion, int numArticulosSeccion) {
        String seccionStr = String.format("%02d", seccion);
        String numArticulosStr = String.format("%03d", numArticulosSeccion + 1);
        return seccionStr + "-" + numArticulosStr;
    }

    private int contarArticulosSeccion(int seccion) {
        int contador = 0;
        for (Articulo articulo : articulos) {
            if (obtenerSeccionArticulo(articulo) == seccion) {
                contador++;
            }
        }
        return contador;
    }

    private int obtenerSeccionArticulo(Articulo articulo) {
        String idArticulo = articulo.getIdArticulo();
        String[] partes = idArticulo.split("-");
        if (partes.length >= 1) {
            String seccionStr = partes[0];
            return Integer.parseInt(seccionStr);
        }
        return -1; // Si no se puede obtener la sección, devuelve un valor negativo como indicador de error
    }

    public static final void morado(){

    }


    private void examen2() {
        guardarClientesConPedido(clientes, pedidos);

        guardarClientesSinPedido(clientes, pedidos);
    }

    private void examen3() {
        int[] contadores = new int[articulos.size()];
        for(int i=0; i< articulos.size();i++){
            for(Pedido p:pedidos){
                for(LineaPedido l:p.getCestaCompra()){
                    if(l.getIdArticulo().equals(articulos.get(i).getIdArticulo())){
                        contadores[i]+= l.getUnidades();
                    }
                }
            }
        }
        int mayor=0;
        Articulo aMayor=null;
        for (int i=0;i<contadores.length; i++){
            mayor = contadores[i];
            aMayor= articulos.get(i);
            int posMayor = i;
            for (int j=i;j<contadores.length; j++)
            {
                if (contadores[j] > mayor)
                {
                    mayor = contadores[j];
                    posMayor = j;
                }
            }
            contadores[posMayor]=contadores[i];
            contadores[i]=mayor;
            Collections.swap(articulos, posMayor, i);
        }
        System.out.println("\nRANKING DE LOS 5 ARTICULOS MAS VENDIDOS:\n");
        for (int i=0;i<5; i++){
            System.out.println(i+1 + " - (" + articulos.get(i).getIdArticulo()+ ") " +
                    articulos.get(i).getDescripcion() + "con " + contadores[i] + " unidades");
        }
    }

    private void examen4() {
        TreeMap<Double,Pedido> pedidosCliente=new TreeMap();
        //CREAMOS UN TREEMAP ORDENADO CON KEY EL TOTAL DE CADA PEDIDO - YA ESTA ORDENADO POR TOTALES
        for (Pedido p:pedidos)
        {{

            double total=0;
            for (LineaPedido l :p.getCestaCompra()){
                total+=l.getUnidades()* articulos.get(buscarId(l.getIdArticulo())).getPvp();
            }
            pedidosCliente.put(total,p);
        }
        }
        //LISTAMOS LOS PEDIDOS DEL TREEMAP ORDENADOS CON SU TOTAL

        for (Double d: pedidosCliente.keySet())
        {
            System.out.println("PEDIDO "+ pedidosCliente.get(d).getIdPedido() + " DE " + pedidosCliente.get(d).getClientePedido().getNombre());
            for (LineaPedido l :  pedidosCliente.get(d).getCestaCompra()){
                System.out.println(articulos.get(buscarId(l.getIdArticulo())).getDescripcion()  + "\t- " + l.getUnidades());
            }
            System.out.println("TOTAL: " + d + "\t FECHA: " + pedidosCliente.get(d).getFechaPedido() + "\n");
        }
    }
    public int buscarId(String id) {
        int pos=-1;
        int i=0;
        for (Articulo a : articulos) {
            if (a.getIdArticulo().equals(id)){
                pos=i;
                break;
            }
            i++;
        }
        return pos;
    }
    public static void guardarClientesConPedido(ArrayList<Cliente> clientes, ArrayList<Pedido> pedidos) {
        try (FileWriter writer = new FileWriter("clientes_con_pedido.txt")) {
            for (Cliente cliente : clientes) {
                int numPedidos = obtenerNumeroPedidos(cliente, pedidos);
                if (numPedidos > 0) {
                    String clienteString = cliente.toString() + " - Número de pedidos: " + numPedidos;
                    writer.write(clienteString + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void guardarClientesSinPedido(ArrayList<Cliente> clientes, ArrayList<Pedido> pedidos) {
        try (FileWriter writer = new FileWriter("clientes_sin_pedido.txt")) {
            for (Cliente cliente : clientes) {
                if (!tienePedido(cliente, pedidos)) {
                    writer.write(cliente.toString() + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static boolean tienePedido(Cliente cliente, ArrayList<Pedido> pedidos) {
        for (Pedido pedido : pedidos) {
            if (pedido.getClientePedido().equals(cliente)) {
                return true;
            }
        }
        return false;
    }
    private static int obtenerNumeroPedidos(Cliente cliente, ArrayList<Pedido> pedidos) {
        int contador = 0;
        for (Pedido pedido : pedidos) {
            if (pedido.getClientePedido().equals(cliente)) {
                contador++;
            }
        }
        return contador;
    }
}  
    