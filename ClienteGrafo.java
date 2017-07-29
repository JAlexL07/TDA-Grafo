/**
 * Descripcion: Cliente de Prueba para las clase GrafoNoDirigido y Digrafo
 * @author Br. Diego Pedroza, CARNET: 12-11281
 * @author	Br. Jean Alexander, CARNET: 12-10848
 */

import java.util.*;
import java.io.*;

public class ClienteGrafo {
	
	
	public static void main(String [] args) {
		Scanner teclado = new Scanner(System.in);
		String opcion = "-1";
		
		while(true){
					System.out.print(" Por favor, ingrese alguna de las siguientes opciones:\n ");
		System.out.print("1. Probar la Implementacion del TAD Digrafo\n");
		System.out.print("2. Probar la Implementacion del TAD Grafo no Dirigido\n");
		System.out.print("3. Salir del Sistema\n");
		
		System.out.print("Introduzca su opción: ");
		opcion = teclado.next();
		switch(opcion){
			case "1":
				HashMap <String,Digrafo> todoGrafos = new HashMap <String,Digrafo>(2);
				Digrafo grafo;
				String grafo_nombre, id, nombre,nombre_arco,id_VI,id_VF,id_arco;
				double peso,peso_arco;
				Vertice vertice,vI,vF;
				Arco arco;
				while (true){
				
				System.out.print(" Por favor, ingrese alguna de las siguientes opciones:\n ");
				System.out.print("1. Crear un nuevo Grafo\n");
				System.out.print("2. Cargar un Grafo\n");
				System.out.print("3. Agregar Vertice\n");
				System.out.print("4. Insertar un Nuevo Arco\n");
				System.out.print("5. Obtener vertice\n");
				System.out.print("6. Esta Vertice\n");
				System.out.print("7. Lista de Vertices Adyacentes\n");
				System.out.print("8. Lista de Lados Incidentes\n");
				System.out.print("9. Grado de un Vértice\n");
				System.out.print("10. Eliminar Vertice\n");
				System.out.print("11. Eliminar Arco\n");
				System.out.print("12. Clonar un grafo\n");  //OJO    
				System.out.print("13. Mostrar id de Grafos\n");
				System.out.print("14. Mostrar Grafo\n");
				System.out.print("15. Salir del Sistema\n");
				System.out.print("16. Mostrar Numeros de Vertice\n");
				System.out.print("17. Mostrar Numeros de Lados\n");
				
				System.out.print("Introduzca su opción: ");
				String opcion2 = teclado.next();
				switch(opcion2){
					case "1" :
						System.out.print("Introduzca el nombre de su grafo: ");
						nombre = teclado.next();
						Digrafo G = new Digrafo();
						todoGrafos.put(nombre,G);
						break;
					case("2"):
						if(todoGrafos.size()==0){
						System.out.print("Introduzca el id del nuevo Grafo: ");
						grafo_nombre = teclado.next();
						try{
							Digrafo H = new Digrafo();
							System.out.print("Introduzca el nombre del archivo a cargar: ");
							String nombre_archivo = teclado.next();
							H.cargarGrafo(nombre_archivo);
							todoGrafos.put(grafo_nombre, H);
						
							}catch(IOException e){
								System.out.println("No existe el archivo indicado o no respeta el formato");
							}
						}else{
							try{
								System.out.print("Introduzca el id del Grafo: ");
								grafo_nombre = teclado.next();
								String nombre_archivo = teclado.next();
								try{
								todoGrafos.get(grafo_nombre).cargarGrafo(nombre_archivo);
							}catch(	InputMismatchException a){
								System.out.println("Introdujo un id del Grafo equivocado o no existente");
								break;
							};
							}catch(IOException e){
								System.out.println("No existe el archivo indicado o no respeta el formato");
							}
						}
						break;
					case("3"):
						System.out.print("Introduzca el id del Grafo: ");
						grafo_nombre = teclado.next();
						try{
							grafo = todoGrafos.get(grafo_nombre);}
						catch(InputMismatchException a){
							System.out.println("Introdujo un id del Grafo equivocado o no existente");
							break;
							};
						System.out.print("Introduzca el id del Vertice a insertar: ");
						id = teclado.next();
						System.out.print("Introduzca el peso del Vertice: ");
						try{
						peso = teclado.nextDouble();
						}catch(InputMismatchException e){
							System.out.println("Es necesario que introduzca un número");
							break;
						}
						vertice = new Vertice(id,peso);
						
						grafo.agregarVertice(vertice);
						
						break;
				case("4"):
						if(todoGrafos.size()>0){
							System.out.print("Introduzca el id del Grafo: ");
							grafo_nombre = teclado.next();
							try{
								grafo = todoGrafos.get(grafo_nombre);}
							catch(InputMismatchException a){
								System.out.println("Introdujo un id del Grafo equivocado o no existente");
								break;
							};
							System.out.print("Introduzca el id del Arco a insertar: ");
							nombre_arco = teclado.next();
							System.out.print("Introduzca el peso del Vertice: ");
							try{
							peso_arco = teclado.nextDouble();
							}catch(InputMismatchException e){
								System.out.println("Es necesario que introduzca un número");
								break;
							}
							System.out.print("Introduzca el id del vertice extremo inicial: ");
							id_VI = teclado.next();
							System.out.print("Introduzca el id del vertice extremo final: ");
							id_VF = teclado.next();
							if (grafo.estaVertice(id_VI) &&  grafo.estaVertice(id_VF))
							{
								vI = grafo.obtenerVertice(id_VI);
								vF = grafo.obtenerVertice(id_VF);
								arco = new Arco(nombre_arco,peso_arco,vI,vF);
								grafo.agregarArco(arco);
								break;
							}else{
								System.out.println("No existe esos vertices en el grafo");
								break;
							}
						}else{
							System.out.println("No existen grafos. Cree un nuevo grafo o Cargue uno");
							break;
						}
					case("5"):
						if(todoGrafos.size()>0){
							System.out.print("Introduzca el id del Grafo: ");
							grafo_nombre = teclado.next();
							try{
								grafo = todoGrafos.get(grafo_nombre);}
							catch(InputMismatchException a){
								System.out.println("Introdujo un id del Grafo equivocado o no existente");
								break;
							};
							System.out.print("Introduzca el id del Vertice a Obtener: ");
							id = teclado.next();
							try{
								System.out.println("El vertice obtenido es: "+grafo.obtenerVertice(id).toString());
								break;}
							catch(NoSuchElementException a){
								System.out.println("No existe ese vertice en el grafo seleccionado");
								break;
								}
						}else{
							System.out.println("No existen grafos. Cree un nuevo grafo o Cargue uno");
							break;
						}
						
					case("6"):
						if(todoGrafos.size()>0){
							System.out.print("Introduzca el id del Grafo: ");
							grafo_nombre = teclado.next();
							try{
								grafo = todoGrafos.get(grafo_nombre);}
							catch(InputMismatchException a){
								System.out.println("Introdujo un id del Grafo equivocado o no existente");
								break;
							};
							System.out.print("Introduzca el id del Vertice a Obtener: ");
							id = teclado.next();
							try{
								if (grafo.estaVertice(id)){
									System.out.println("El vertice con el id: "+id+"está en el grafo "+grafo_nombre);
								}else{System.out.println("El vertice con el id: "+id+"NO está en el grafo "+grafo_nombre);}
								break;}
							catch(NoSuchElementException a){
								System.out.println("No existe ese vertice en el grafo seleccionado");
								break;
								}
						}else{
							System.out.println("No existen grafos. Cree un nuevo grafo o Cargue uno");
							break;
						}
					case("7"):
						if(todoGrafos.size()>0){
							System.out.print("Introduzca el id del Grafo: ");
							grafo_nombre = teclado.next();
							try{
								grafo = todoGrafos.get(grafo_nombre);}
							catch(InputMismatchException a){
								System.out.println("Introdujo un id del Grafo equivocado o no existente");
								break;
							};
							System.out.print("Introduzca el id del Vertice para buscar la lista de Adyacentes: ");
							id = teclado.next();
							try{
								List<Vertice> adyacentes;
								adyacentes = grafo.adyacentes(id);
								System.out.println(adyacentes);
								break;}
							catch(NoSuchElementException a){
								System.out.println("No existe ese vertice en el grafo seleccionado");
								break;
								}
						}else{
							System.out.println("No existen grafos. Cree un nuevo grafo o Cargue uno");
							break;
						}
						
					case("8"):
						if(todoGrafos.size()>0){
							System.out.print("Introduzca el id del Grafo: ");
							grafo_nombre = teclado.next();
							try{
								grafo = todoGrafos.get(grafo_nombre);}
							catch(InputMismatchException a){
								System.out.println("Introdujo un id del Grafo equivocado o no existente");
								break;
							};
							System.out.print("Introduzca el id del Vertice para buscar la lista de Lados Incidentes: ");
							id = teclado.next();
							try{
								List<Lado>incidentes;
								incidentes = grafo.incidentes(id);
								System.out.println(incidentes);
								break;}
							catch(NoSuchElementException a){
								System.out.println("No existe ese vertice en el grafo seleccionado");
								break;
								}
						}else{
							System.out.println("No existen grafos. Cree un nuevo grafo o Cargue uno");
							break;
						}
					case("9"):
						if(todoGrafos.size()>0){
							System.out.print("Introduzca el id del Grafo: ");
							grafo_nombre = teclado.next();
							try{
								grafo = todoGrafos.get(grafo_nombre);}
							catch(InputMismatchException a){
								System.out.println("Introdujo un id del Grafo equivocado o no existente");
								break;
							};
							System.out.print("Introduzca el id del Vertice: ");
							id = teclado.next();
							try{
								int grado = grafo.grado(id);
								System.out.println("El grado del vertice "+id+"es: "+grado);
								break;}
							catch(NoSuchElementException a){
								System.out.println("No existe ese vertice en el grafo seleccionado");
								break;
								}
						}else{
							System.out.println("No existen grafos. Cree un nuevo grafo o Cargue uno");
							break;
						}
					case("10"):
						if(todoGrafos.size()>0){
							System.out.print("Introduzca el id del Grafo: ");
							grafo_nombre = teclado.next();
							try{
								grafo = todoGrafos.get(grafo_nombre);}
							catch(InputMismatchException a){
								System.out.println("Introdujo un id del Grafo equivocado o no existente");
								break;
							};
							System.out.print("Introduzca el id del Vertice a eliminar: ");
							id = teclado.next();
							try{
								if(grafo.eliminarVertice(id)){
									System.out.println("Se ha eliminado el vertice");
									}else{
									System.out.println("No se ha eliminado el vertice");
								}
								break;}
							catch(NoSuchElementException a){
								System.out.println("No existe ese vertice en el grafo seleccionado");
								break;
								}
						}else{
							System.out.println("No existen grafos. Cree un nuevo grafo o Cargue uno");
							break;
						}
					case("11"):
						if(todoGrafos.size()>0){
							System.out.print("Introduzca el id del Grafo: ");
							grafo_nombre = teclado.next();
							try{
								grafo = todoGrafos.get(grafo_nombre);}
							catch(InputMismatchException a){
								System.out.println("Introdujo un id del Grafo equivocado o no existente");
								break;
							};
							System.out.print("Introduzca el id del Arco a eliminar: ");
							id_arco = teclado.next();
							try{
								if(grafo.eliminarArco(id_arco)){
									System.out.println("Se ha eliminado el arco");
									}else{
									System.out.println("No se ha eliminado el arco");
								}
								break;}
							catch(NoSuchElementException a){
								System.out.println("No existe ese arco en el grafo seleccionado");
								break;
								}
						}else{
							System.out.println("No existen grafos. Cree un nuevo grafo o Cargue uno");
							break;
						}
					
					case("12"):
					
						if(todoGrafos.size()>0){
							System.out.print("Introduzca el id del Grafo: ");
							grafo_nombre = teclado.next();
							try{
								grafo = todoGrafos.get(grafo_nombre);}
							catch(InputMismatchException a){
								System.out.println("Introdujo un id del Grafo equivocado o no existente");
								break;
							};
							System.out.print("Introduzca el id del nuevo grafo: ");
							String grafo_name = teclado.next();
							Digrafo grafo2 = new Digrafo();;
							try{								
								grafo2 = grafo.clone();
								todoGrafos.put(grafo_name,grafo2);
								System.out.println("Ha sido clonado");
								break;}
							catch(NoSuchElementException a){
								System.out.println("No existe ese vertice en el grafo seleccionado");
								break;
								}
						}else{
							System.out.println("No existen grafos. Cree un nuevo grafo o Cargue uno");
							break;
						}
					
					case("13"):
						if(todoGrafos.size()>0){
							System.out.println(todoGrafos.keySet());
							break;
						}else{
							System.out.println("No existen grafos. Cree un nuevo grafo o Cargue uno");
							break;
						}
						
						
					case("14"):
						if(todoGrafos.size()>0){
							System.out.print("Introduzca el id del Grafo: ");
							grafo_nombre = teclado.next();
							try{
								grafo = todoGrafos.get(grafo_nombre);}
							catch(InputMismatchException a){
								System.out.println("Introdujo un id del Grafo equivocado o no existente");
								break;
							};
							System.out.println(grafo);
						}else{
							System.out.println("No existen grafos. Cree un nuevo grafo o Cargue uno");
							break;
						}
					case("15"):
						System.out.println("\nGracias por usar nuestra implementacion\n");
						System.exit(0);
						break;
					case("16"):
						if(todoGrafos.size()>0){
							System.out.print("Introduzca el id del Grafo: ");
							grafo_nombre = teclado.next();
							try{
								grafo = todoGrafos.get(grafo_nombre);}
								
							catch(InputMismatchException a){
								System.out.println("Introdujo un id del Grafo equivocado o no existente");
								break;
							};
							System.out.println(grafo.numeroDeVertices());
						}else{
							System.out.println("No existen grafos. Cree un nuevo grafo o Cargue uno");
							break;
						}
					case("17"):
						if(todoGrafos.size()>0){
							System.out.print("Introduzca el id del Grafo: ");
							grafo_nombre = teclado.next();
							try{
								grafo = todoGrafos.get(grafo_nombre);}
								
							catch(InputMismatchException a){
								System.out.println("Introdujo un id del Grafo equivocado o no existente");
								break;
							};
							System.out.println(grafo.numeroDeLados());
						}else{
							System.out.println("No existen grafos. Cree un nuevo grafo o Cargue uno");
							break;
						}
					default:
						System.out.println("Opción Inválida");
						break;
						
					}

				}
			
				
			case "2":
				HashMap <String,GrafoNoDirigido> todosGrafosND = new HashMap <String,GrafoNoDirigido>(2);
				GrafoNoDirigido grafo2;
				String grafo_nodirigido_nombre2, id_ND, nombre2,nombre2_arco,id_VIND,id_VFND,id_arcoND;
				double pesoND,pesoND_arcoND;
				Vertice verticeND,vIND,vFND;
				Arista arista;
				while (true){
				
				System.out.print(" Por favor, ingrese alguna de las siguientes opciones:\n ");
				System.out.print("1. Crear un nuevo Grafo\n");
				System.out.print("2. Cargar un Grafo\n");
				System.out.print("3. Agregar Vertice\n");
				System.out.print("4. Insertar un Nuevo Arista\n");
				System.out.print("5. Obtener verticeND\n");
				System.out.print("6. Esta Vertice\n");
				System.out.print("7. Lista de Vertices Adyacentes\n");
				System.out.print("8. Lista de Lados Incidentes\n");
				System.out.print("9. Grado de un Vértice\n");
				System.out.print("10. Eliminar Vertice\n");
				System.out.print("11. Eliminar Arista\n");
				System.out.print("12. Clonar un grafo\n");  //OJO    
				System.out.print("13. Mostrar id_ND de Grafos\n");
				System.out.print("14. Mostrar Grafo\n");
				System.out.print("15. Salir del Sistema\n");
				System.out.print("16. Mostrar Numeros de Vertices\n");
				System.out.print("17. Mostrar Numeros de Aristas\n");
				
				System.out.print("Introduzca su opción: ");
				String opcion2 = teclado.next();
				switch(opcion2){
					case "1" :
						System.out.print("Introduzca el nombre2 de su grafo2: ");
						nombre2 = teclado.next();
						GrafoNoDirigido GND = new GrafoNoDirigido();
						todosGrafosND.put(nombre2,GND);
						break;
					case("2"):
						if(todosGrafosND.size()==0){
						System.out.print("Introduzca el id_ND del nuevo Grafo: ");
						grafo_nodirigido_nombre2 = teclado.next();
						try{
							GrafoNoDirigido H = new GrafoNoDirigido();
							System.out.print("Introduzca el nombre2 del archivo a cargar: ");
							String nombre2_archivo = teclado.next();
							H.cargarGrafo(nombre2_archivo);
							todosGrafosND.put(grafo_nodirigido_nombre2, H);
						
							}catch(IOException e){
								System.out.println("No existe el archivo indicado o no respeta el formato");
							}
						}else{
							try{
								System.out.print("Introduzca el id_ND del Grafo: ");
								grafo_nodirigido_nombre2 = teclado.next();
								String nombre2_archivo = teclado.next();
								try{
								todosGrafosND.get(grafo_nodirigido_nombre2).cargarGrafo(nombre2_archivo);
							}catch(	InputMismatchException a){
								System.out.println("Introdujo un id_ND del Grafo equivocado o no existente");
								break;
							};
							}catch(IOException e){
								System.out.println("No existe el archivo indicado o no respeta el formato");
							}
						}
						break;
					case("3"):
						System.out.print("Introduzca el id_ND del Grafo: ");
						grafo_nodirigido_nombre2 = teclado.next();
						try{
							grafo2 = todosGrafosND.get(grafo_nodirigido_nombre2);}
						catch(InputMismatchException a){
							System.out.println("Introdujo un id_ND del Grafo equivocado o no existente");
							break;
							};
						System.out.print("Introduzca el id_ND del Vertice a insertar: ");
						id_ND = teclado.next();
						System.out.print("Introduzca el pesoND del Vertice: ");
						try{
						pesoND = teclado.nextDouble();
						}catch(InputMismatchException e){
							System.out.println("Es necesario que introduzca un número");
							break;
						}
						verticeND = new Vertice(id_ND,pesoND);
						
						grafo2.agregarVertice(verticeND);
						
						break;
				case("4"):
						if(todosGrafosND.size()>0){
							System.out.print("Introduzca el id_ND del Grafo: ");
							grafo_nodirigido_nombre2 = teclado.next();
							try{
								grafo2 = todosGrafosND.get(grafo_nodirigido_nombre2);}
							catch(InputMismatchException a){
								System.out.println("Introdujo un id_ND del Grafo equivocado o no existente");
								break;
							};
							System.out.print("Introduzca el id_ND del Arista a insertar: ");
							nombre2_arco = teclado.next();
							System.out.print("Introduzca el pesoND del Vertice: ");
							try{
							pesoND_arcoND = teclado.nextDouble();
							}catch(InputMismatchException e){
								System.out.println("Es necesario que introduzca un número");
								break;
							}
							System.out.print("Introduzca el id_ND del verticeND extremo inicial: ");
							id_VIND = teclado.next();
							System.out.print("Introduzca el id_ND del verticeND extremo final: ");
							id_VFND = teclado.next();
							if (grafo2.estaVertice(id_VIND) &&  grafo2.estaVertice(id_VFND))
							{
								vIND = grafo2.obtenerVertice(id_VIND);
								vFND = grafo2.obtenerVertice(id_VFND);
								arista = new Arista(nombre2_arco,pesoND_arcoND,vIND,vFND);
								grafo2.agregarArista(arista);
								break;
							}else{
								System.out.println("No existe esos verticeNDs en el grafo2");
								break;
							}
						}else{
							System.out.println("No existen grafos. Cree un nuevo grafo2 o Cargue uno");
							break;
						}
					case("5"):
						if(todosGrafosND.size()>0){
							System.out.print("Introduzca el id_ND del Grafo: ");
							grafo_nodirigido_nombre2 = teclado.next();
							try{
								grafo2 = todosGrafosND.get(grafo_nodirigido_nombre2);}
							catch(InputMismatchException a){
								System.out.println("Introdujo un id_ND del Grafo equivocado o no existente");
								break;
							};
							System.out.print("Introduzca el id_ND del Vertice a Obtener: ");
							id_ND = teclado.next();
							try{
								System.out.println("El verticeND obtenido es: "+grafo2.obtenerVertice(id_ND).toString());
								break;}
							catch(NoSuchElementException a){
								System.out.println("No existe ese verticeND en el grafo2 seleccionado");
								break;
								}
						}else{
							System.out.println("No existen grafos. Cree un nuevo grafo2 o Cargue uno");
							break;
						}
						
					case("6"):
						if(todosGrafosND.size()>0){
							System.out.print("Introduzca el id_ND del Grafo: ");
							grafo_nodirigido_nombre2 = teclado.next();
							try{
								grafo2 = todosGrafosND.get(grafo_nodirigido_nombre2);}
							catch(InputMismatchException a){
								System.out.println("Introdujo un id_ND del Grafo equivocado o no existente");
								break;
							};
							System.out.print("Introduzca el id_ND del Vertice a Obtener: ");
							id_ND = teclado.next();
							try{
								if (grafo2.estaVertice(id_ND)){
									System.out.println("El verticeND con el id_ND: "+id_ND+"está en el grafo2 "+grafo_nodirigido_nombre2);
								}else{System.out.println("El verticeND con el id_ND: "+id_ND+"NO está en el grafo2 "+grafo_nodirigido_nombre2);}
								break;}
							catch(NoSuchElementException a){
								System.out.println("No existe ese verticeND en el grafo2 seleccionado");
								break;
								}
						}else{
							System.out.println("No existen grafos. Cree un nuevo grafo2 o Cargue uno");
							break;
						}
					case("7"):
						if(todosGrafosND.size()>0){
							System.out.print("Introduzca el id_ND del Grafo: ");
							grafo_nodirigido_nombre2 = teclado.next();
							try{
								grafo2 = todosGrafosND.get(grafo_nodirigido_nombre2);}
							catch(InputMismatchException a){
								System.out.println("Introdujo un id_ND del Grafo equivocado o no existente");
								break;
							};
							System.out.print("Introduzca el id_ND del Vertice para buscar la lista de Adyacentes: ");
							id_ND = teclado.next();
							try{
								List<Vertice> adyacentes;
								adyacentes = grafo2.adyacentes(id_ND);
								System.out.println(adyacentes);
								break;}
							catch(NoSuchElementException a){
								System.out.println("No existe ese verticeND en el grafo2 seleccionado");
								break;
								}
						}else{
							System.out.println("No existen grafos. Cree un nuevo grafo2 o Cargue uno");
							break;
						}
						
					case("8"):
						if(todosGrafosND.size()>0){
							System.out.print("Introduzca el id_ND del Grafo: ");
							grafo_nodirigido_nombre2 = teclado.next();
							try{
								grafo2 = todosGrafosND.get(grafo_nodirigido_nombre2);}
							catch(InputMismatchException a){
								System.out.println("Introdujo un id_ND del Grafo equivocado o no existente");
								break;
							};
							System.out.print("Introduzca el id_ND del Vertice para buscar la lista de Lados Incidentes: ");
							id_ND = teclado.next();
							try{
								List<Lado>incidentes;
								incidentes = grafo2.incidentes(id_ND);
								System.out.println(incidentes);
								break;}
							catch(NoSuchElementException a){
								System.out.println("No existe ese verticeND en el grafo2 seleccionado");
								break;
								}
						}else{
							System.out.println("No existen grafos. Cree un nuevo grafo2 o Cargue uno");
							break;
						}
					case("9"):
						if(todosGrafosND.size()>0){
							System.out.print("Introduzca el id_ND del Grafo: ");
							grafo_nodirigido_nombre2 = teclado.next();
							try{
								grafo2 = todosGrafosND.get(grafo_nodirigido_nombre2);}
							catch(InputMismatchException a){
								System.out.println("Introdujo un id_ND del Grafo equivocado o no existente");
								break;
							};
							System.out.print("Introduzca el id_ND del Vertice: ");
							id_ND = teclado.next();
							try{
								int grado = grafo2.grado(id_ND);
								System.out.println("El grado del verticeND "+id_ND+"es: "+grado);
								break;}
							catch(NoSuchElementException a){
								System.out.println("No existe ese verticeND en el grafo2 seleccionado");
								break;
								}
						}else{
							System.out.println("No existen grafos. Cree un nuevo grafo2 o Cargue uno");
							break;
						}
					case("10"):
						if(todosGrafosND.size()>0){
							System.out.print("Introduzca el id_ND del Grafo: ");
							grafo_nodirigido_nombre2 = teclado.next();
							try{
								grafo2 = todosGrafosND.get(grafo_nodirigido_nombre2);}
							catch(InputMismatchException a){
								System.out.println("Introdujo un id_ND del Grafo equivocado o no existente");
								break;
							};
							System.out.print("Introduzca el id_ND del Vertice a eliminar: ");
							id_ND = teclado.next();
							try{
								if(grafo2.eliminarVertice(id_ND)){
									System.out.println("Se ha eliminado el verticeND");
									}else{
									System.out.println("No se ha eliminado el verticeND");
								}
								break;}
							catch(NoSuchElementException a){
								System.out.println("No existe ese verticeND en el grafo2 seleccionado");
								break;
								}
						}else{
							System.out.println("No existen grafos. Cree un nuevo grafo2 o Cargue uno");
							break;
						}
					case("11"):
						if(todosGrafosND.size()>0){
							System.out.print("Introduzca el id_ND del Grafo: ");
							grafo_nodirigido_nombre2 = teclado.next();
							try{
								grafo2 = todosGrafosND.get(grafo_nodirigido_nombre2);}
							catch(InputMismatchException a){
								System.out.println("Introdujo un id_ND del Grafo equivocado o no existente");
								break;
							};
							System.out.print("Introduzca el id_ND del Arista a eliminar: ");
							id_arcoND = teclado.next();
							try{
								if(grafo2.eliminarArista(id_arcoND)){
									System.out.println("Se ha eliminado el arista");
									}else{
									System.out.println("No se ha eliminado el arista");
								}
								break;}
							catch(NoSuchElementException a){
								System.out.println("No existe ese arista en el grafo2 seleccionado");
								break;
								}
						}else{
							System.out.println("No existen grafos. Cree un nuevo grafo2 o Cargue uno");
							break;
						}
					
					case("12"):
					
						if(todosGrafosND.size()>0){
							System.out.print("Introduzca el id_ND del Grafo: ");
							grafo_nodirigido_nombre2 = teclado.next();
							try{
								grafo2 = todosGrafosND.get(grafo_nodirigido_nombre2);}
							catch(InputMismatchException a){
								System.out.println("Introdujo un id_ND del Grafo equivocado o no existente");
								break;
							};
							System.out.print("Introduzca el id_ND del nuevo grafo2: ");
							String grafo_name = teclado.next();
							GrafoNoDirigido grafo_nodirigido2 = new GrafoNoDirigido();;
							try{								
								grafo_nodirigido2 = grafo2.clone();
								todosGrafosND.put(grafo_name,grafo_nodirigido2);
								System.out.println("Ha sido clonado");
								break;}
							catch(NoSuchElementException a){
								System.out.println("No existe ese verticeND en el grafo2 seleccionado");
								break;
								}
						}else{
							System.out.println("No existen grafos. Cree un nuevo grafo2 o Cargue uno");
							break;
						}
		
					case("13"):
						if(todosGrafosND.size()>0){
							System.out.println(todosGrafosND.keySet());
							break;
						}else{
							System.out.println("No existen grafos. Cree un nuevo grafo2 o Cargue uno");
							break;
						}
						
						
					case("14"):
						if(todosGrafosND.size()>0){
							System.out.print("Introduzca el id_ND del Grafo: ");
							grafo_nodirigido_nombre2 = teclado.next();
							try{
								grafo2 = todosGrafosND.get(grafo_nodirigido_nombre2);}
							catch(InputMismatchException a){
								System.out.println("Introdujo un id_ND del Grafo equivocado o no existente");
								break;
							};
							System.out.println(grafo2);
						}else{
							System.out.println("No existen grafos. Cree un nuevo grafo2 o Cargue uno");
							break;
						}
						
					case("15"):
						System.out.println("\nGracias por usar nuestra implementacion\n");
						System.exit(0);
						break;
					case("16"):
						if(todosGrafosND.size()>0){
							System.out.print("Introduzca el id_ND del Grafo: ");
							grafo_nodirigido_nombre2 = teclado.next();
							try{
								grafo2 = todosGrafosND.get(grafo_nodirigido_nombre2);
								System.out.println(grafo2.numeroDeVertices());}
							catch(InputMismatchException a){
								System.out.println("Introdujo un id_ND del Grafo equivocado o no existente");
								break;
							};
							System.out.println(grafo2);
						}else{
							System.out.println("No existen grafos. Cree un nuevo grafo2 o Cargue uno");
							break;
						}
					case("17"):
						if(todosGrafosND.size()>0){
							System.out.print("Introduzca el id_ND del Grafo: ");
							grafo_nodirigido_nombre2 = teclado.next();
							try{
								grafo2 = todosGrafosND.get(grafo_nodirigido_nombre2);
								System.out.println(grafo2.numeroDeLados());}
							catch(InputMismatchException a){
								System.out.println("Introdujo un id_ND del Grafo equivocado o no existente");
								break;
							};
							System.out.println(grafo2);
						}else{
							System.out.println("No existen grafos. Cree un nuevo grafo2 o Cargue uno");
							break;
						}
					
					default:
						System.out.println("Opción Inválida");
						break;
						
					}

				}



			case "3":
				System.out.println("Gracias por utilizar nuestra implementación ");
				System.exit(0);
				
		}
	}
}
}

