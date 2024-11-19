/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package glapp;

import javax.swing.JOptionPane;
import java.sql.Date;
/*
public class App {

    public static void main(String[] args) {
        boolean continueProgram = true;

        while (continueProgram) {
            // Main menu options
            String[] mainOptions = {"JefeCuadrilla", "Cuadrilla", "Personal", "Colonia", "Actividad", "Salir"};
            String selection = (String) JOptionPane.showInputDialog(null, 
                "-----------Menu de opciones--------------\n" +
                "Seleccione una opción:", 
                "Menú Principal", JOptionPane.PLAIN_MESSAGE, null, mainOptions, mainOptions[0]);

            if (selection == null || selection.equals("Salir")) {
                continueProgram = false;
            } else {
                switch (selection) {
                    case "JefeCuadrilla":
                        gestionarJefeCuadrilla();
                        break;
                    case "Cuadrilla":
                        gestionarCuadrilla();
                        break;
                    case "Personal":
                        gestionarPersonal();
                        break;
                    case "Colonia":
                        gestionarColonia();
                        break;
                    case "Actividad":
                        gestionarActividadLimpieza();
                        break;
                }
            }
        }
    }

    // metodos para manejar cada entidad
    private static void gestionarJefeCuadrilla() {
    String[] jefeOptions = {"Guardar", "Obtener por ID", "Actualizar", "Eliminar", "Regresar"};
    String jefeSelection = (String) JOptionPane.showInputDialog(null, 
            "Opciones de JefeCuadrilla", 
            "Gestión de JefeCuadrilla", JOptionPane.PLAIN_MESSAGE, null, jefeOptions, jefeOptions[0]);

    try {
        switch (jefeSelection) {
            case "Guardar":
                int jefeId = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del Jefe de Cuadrilla:"));
                String jefeNombre = JOptionPane.showInputDialog("Ingrese el nombre del Jefe de Cuadrilla:");
                String jefeEmail = JOptionPane.showInputDialog("Ingrese el email del Jefe de Cuadrilla:");
                String jefeTelefono = JOptionPane.showInputDialog("Ingrese el teléfono del Jefe de Cuadrilla:");

                JefeCuadrilla jefe = new JefeCuadrilla(jefeId, jefeNombre, jefeEmail, jefeTelefono);
                jefe.guardar();
                JOptionPane.showMessageDialog(null, "Jefe de Cuadrilla guardado exitosamente.");
                break;

            case "Obtener por ID":
                int buscarId = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del Jefe de Cuadrilla a buscar:"));
                JefeCuadrilla jefeEncontrado = JefeCuadrilla.obtenerPorId(buscarId);
                if (jefeEncontrado != null) {
                    JOptionPane.showMessageDialog(null, "Jefe de Cuadrilla encontrado:\n" +
                            "ID: " + jefeEncontrado.getJefeCuadrilla_id() + "\n" +
                            "Nombre: " + jefeEncontrado.getNombre() + "\n" +
                            "Email: " + jefeEncontrado.getEmail() + "\n" +
                            "Teléfono: " + jefeEncontrado.getTelefono());
                } else {
                    JOptionPane.showMessageDialog(null, "Jefe de Cuadrilla no encontrado.");
                }
                break;

            case "Actualizar":
            try {
                int cuadrillaId = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la Cuadrilla a actualizar:"));
                Cuadrilla cuadrillaActualizar = Cuadrilla.obtenerPorId(cuadrillaId);
                
                if (cuadrillaActualizar != null) {
                    // Nuevos datos de la cuadrilla
                    String nuevoNombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre de la Cuadrilla:");
                    String nuevaUbicacion = JOptionPane.showInputDialog("Ingrese la nueva ubicación de la Cuadrilla:");
                    
                    // Asignación del ID de jefe de cuadrilla
                    int nuevoJefeId;
                    String jefeInput = JOptionPane.showInputDialog("Ingrese el nuevo ID del Jefe de Cuadrilla (o deje en blanco para ninguno):");
                    if (jefeInput == null || jefeInput.isEmpty()) {
                        nuevoJefeId = 0; // Esto puede interpretarse como `null` en la actualización
                    } else {
                        nuevoJefeId = Integer.parseInt(jefeInput);
                    }
                    
                    // Setear los nuevos datos a la cuadrilla
                    cuadrillaActualizar.setNombre(nuevoNombre);
                    cuadrillaActualizar.setUbicacion(nuevaUbicacion);
                    cuadrillaActualizar.setJefeCuadrilla_id(nuevoJefeId);

                    // Llamada al método de actualización
                    cuadrillaActualizar.actualizar();
                    JOptionPane.showMessageDialog(null, "Cuadrilla actualizada exitosamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "Cuadrilla no encontrada.");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            }
            break;

            case "Eliminar":
                int eliminarId = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del Jefe de Cuadrilla a eliminar:"));
                JefeCuadrilla jefeEliminar = JefeCuadrilla.obtenerPorId(eliminarId);
                if (jefeEliminar != null) {
                    JefeCuadrilla.eliminar(eliminarId);
                    JOptionPane.showMessageDialog(null, "Jefe de Cuadrilla eliminado exitosamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "Jefe de Cuadrilla no encontrado.");
                }
                break;

            case "Regresar":
                // Regresa al menú anterior
                break;

            default:
                JOptionPane.showMessageDialog(null, "Opción no válida.");
                break;
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
    }
}

    private static void gestionarCuadrilla() {
    String[] cuadrillaOptions = {"Guardar", "Obtener por ID", "Actualizar", "Eliminar", "Regresar"};
    String cuadrillaSelection = (String) JOptionPane.showInputDialog(null, 
            "Opciones de Cuadrilla", 
            "Gestión de Cuadrilla", JOptionPane.PLAIN_MESSAGE, null, cuadrillaOptions, cuadrillaOptions[0]);

    switch (cuadrillaSelection) {
        case "Guardar":
            try {
                int cuadrillaId = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la Cuadrilla:"));
                String cuadrillaNombre = JOptionPane.showInputDialog("Ingrese el nombre de la Cuadrilla:");
                String cuadrillaUbicacion = JOptionPane.showInputDialog("Ingrese la ubicación de la Cuadrilla:");
                int jefeId = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del Jefe de Cuadrilla para esta Cuadrilla:"));

                Cuadrilla cuadrilla = new Cuadrilla(cuadrillaId, cuadrillaNombre, cuadrillaUbicacion, jefeId);
                cuadrilla.guardar();
                JOptionPane.showMessageDialog(null, "Cuadrilla guardada exitosamente.");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            }
            break;

        case "Obtener por ID":
            try {
                int obtenerId = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la Cuadrilla a obtener:"));
                Cuadrilla cuadrillaObtenida = Cuadrilla.obtenerPorId(obtenerId);
                if (cuadrillaObtenida != null) {
                    JOptionPane.showMessageDialog(null, "Cuadrilla encontrada:\n" +
                            "ID: " + cuadrillaObtenida.getCuadrilla_id() + "\n" +
                            "Nombre: " + cuadrillaObtenida.getNombre() + "\n" +
                            "Ubicación: " + cuadrillaObtenida.getUbicacion() + "\n" +
                            "Jefe ID: " + cuadrillaObtenida.getJefeCuadrilla_id());
                } else {
                    JOptionPane.showMessageDialog(null, "Cuadrilla no encontrada.");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            }
            break;

        case "Actualizar":
            try {
                int actualizarId = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la Cuadrilla a actualizar:"));
                Cuadrilla cuadrillaActualizar = Cuadrilla.obtenerPorId(actualizarId);
                if (cuadrillaActualizar != null) {
                    String nuevoNombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre de la Cuadrilla:", cuadrillaActualizar.getNombre());
                    String nuevaUbicacion = JOptionPane.showInputDialog("Ingrese la nueva ubicación de la Cuadrilla:", cuadrillaActualizar.getUbicacion());
                    int nuevoJefeId = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo ID del Jefe de Cuadrilla:", cuadrillaActualizar.getJefeCuadrilla_id()));
                    
                    cuadrillaActualizar.setNombre(nuevoNombre);
                    cuadrillaActualizar.setUbicacion(nuevaUbicacion);
                    cuadrillaActualizar.setJefeCuadrilla_id(nuevoJefeId);
                    cuadrillaActualizar.actualizar();
                    JOptionPane.showMessageDialog(null, "Cuadrilla actualizada exitosamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "Cuadrilla no encontrada.");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            }
            break;

        case "Eliminar":
            try {
                int eliminarId = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la Cuadrilla a eliminar:"));
                Cuadrilla cuadrillaEliminar = Cuadrilla.obtenerPorId(eliminarId);
                if (cuadrillaEliminar != null) {
                    cuadrillaEliminar.eliminar();
                    JOptionPane.showMessageDialog(null, "Cuadrilla eliminada exitosamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "Cuadrilla no encontrada.");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            }
            break;

        case "Regresar":
            // Salir de la gestión de Cuadrilla
            break;

        default:
            JOptionPane.showMessageDialog(null, "Opción no válida.");
            break;
    }
}


    private static void gestionarPersonal() {
        String[] personalOptions = {"Guardar", "Eliminar", "Actualizar", "Obtener por ID", "Regresar"};
        String personalSelection = (String) JOptionPane.showInputDialog(null, 
                "Opciones de Personal", 
                "Gestión de Personal", JOptionPane.PLAIN_MESSAGE, null, personalOptions, personalOptions[0]);

        switch (personalSelection) {
            case "Guardar":
                try {
                    int personalId = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del Personal:"));
                    String personalNombre = JOptionPane.showInputDialog("Ingrese el nombre del Personal:");
                    int cuadrillaId = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la Cuadrilla:"));

                    Personal personal = new Personal(personalId, personalNombre, cuadrillaId);
                    personal.guardar();
                    JOptionPane.showMessageDialog(null, "Personal guardado exitosamente.");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
                }
                break;

            case "Eliminar":
                try {
                    int idEliminar = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del Personal a eliminar:"));
                    Personal personalEliminar = Personal.obtenerPorId(idEliminar);
                    if (personalEliminar != null) {
                        personalEliminar.eliminar();
                        JOptionPane.showMessageDialog(null, "Personal eliminado exitosamente.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Personal no encontrado.");
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
                }
                break;

            case "Actualizar":
                try {
                    int idActualizar = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del Personal a actualizar:"));
                    Personal personalActualizar = Personal.obtenerPorId(idActualizar);
                    if (personalActualizar != null) {
                        String nuevoNombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre del Personal:", personalActualizar.getNombre());
                        int nuevoCuadrillaId = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo ID de la Cuadrilla:", personalActualizar.getCuadrillaId()));

                        personalActualizar.setNombre(nuevoNombre);
                        personalActualizar.setCuadrillaId(nuevoCuadrillaId);
                        personalActualizar.actualizar();
                        JOptionPane.showMessageDialog(null, "Personal actualizado exitosamente.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Personal no encontrado.");
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
                }
                break;

            case "Obtener por ID":
                try {
                    int idBuscar = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del Personal a buscar:"));
                    Personal personalEncontrado = Personal.obtenerPorId(idBuscar);
                    if (personalEncontrado != null) {
                        JOptionPane.showMessageDialog(null, "ID: " + personalEncontrado.getPersonal_id() +
                                "\nNombre: " + personalEncontrado.getNombre() +
                                "\nCuadrilla ID: " + personalEncontrado.getCuadrillaId());
                    } else {
                        JOptionPane.showMessageDialog(null, "Personal no encontrado.");
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
                }
                break;

            case "Regresar":
                break;
        }
    }
    
    private static void gestionarColonia() {
    String[] lugarOptions = {"Guardar", "Obtener por ID", "Actualizar Dirección", "Eliminar", "Regresar"};
    String lugarSelection = (String) JOptionPane.showInputDialog(null, 
            "Opciones de Lugar", 
            "Gestión de Lugar", JOptionPane.PLAIN_MESSAGE, null, lugarOptions, lugarOptions[0]);

    switch (lugarSelection) {
        case "Guardar":
            try {
                int lugarId = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la Colonia:"));
                String lugarNombre = JOptionPane.showInputDialog("Ingrese el nombre de la Colonia:");
                String lugarDireccion = JOptionPane.showInputDialog("Ingrese la dirección de la Colonia:");
                String codigoPostal = JOptionPane.showInputDialog("Ingrese el código postal de la Colonia:");

                // Crea la instancia de Colonias con el nuevo campo codigoPostal
                Colonias lugar = new Colonias(lugarId, lugarNombre, lugarDireccion, codigoPostal);
                lugar.guardar();
                JOptionPane.showMessageDialog(null, "Colonia guardada exitosamente.");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            }
            break;

        case "Obtener por ID":
            try {
                int idBuscar = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la Colonia a buscar:"));
                Colonias coloniaEncontrada = Colonias.obtenerPorId(idBuscar);
                if (coloniaEncontrada != null) {
                    JOptionPane.showMessageDialog(null, 
                        "Colonia ID: " + coloniaEncontrada.getColonia_id() +
                        "\nNombre: " + coloniaEncontrada.getNombre() +
                        "\nDirección: " + coloniaEncontrada.getDireccion() +
                        "\nCódigo Postal: " + coloniaEncontrada.getCodigoPostal());
                } else {
                    JOptionPane.showMessageDialog(null, "Colonia no encontrada.");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            }
            break;

        case "Actualizar Dirección":
            try {
                int idActualizar = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la Colonia a actualizar:"));
                Colonias coloniaActualizar = Colonias.obtenerPorId(idActualizar);
                if (coloniaActualizar != null) {
                    String nuevaDireccion = JOptionPane.showInputDialog("Ingrese la nueva dirección:");
                    String nuevoCodigoPostal = JOptionPane.showInputDialog("Ingrese el nuevo código postal:");
                    coloniaActualizar.actualizarDireccion(nuevaDireccion, nuevoCodigoPostal);
                    JOptionPane.showMessageDialog(null, "Dirección y código postal actualizados exitosamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "Colonia no encontrada.");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            }
            break;

        case "Eliminar":
            try {
                int idEliminar = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la Colonia a eliminar:"));
                Colonias coloniaEliminar = Colonias.obtenerPorId(idEliminar);
                if (coloniaEliminar != null) {
                    coloniaEliminar.eliminar();
                    JOptionPane.showMessageDialog(null, "Colonia eliminada exitosamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "Colonia no encontrada.");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            }
            break;

        case "Regresar":
            // Salir del menú de gestión de colonias
            break;

        default:
            JOptionPane.showMessageDialog(null, "Opción no válida.");
            break;
    }
}



    private static void gestionarActividadLimpieza() {
    String[] actividadOptions = {"Guardar", "Obtener por ID", "Actualizar", "Eliminar", "Regresar"};
    String actividadSelection = (String) JOptionPane.showInputDialog(null, 
            "Opciones de Actividad", 
            "Gestión de Actividad de Limpieza", JOptionPane.PLAIN_MESSAGE, null, actividadOptions, actividadOptions[0]);

    switch (actividadSelection) {
        case "Guardar":
            try {
                int actividadId = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la Actividad de Limpieza:"));
                String actividadDescripcion = JOptionPane.showInputDialog("Ingrese la descripción de la Actividad de Limpieza:");
                String fechaString = JOptionPane.showInputDialog("Ingrese la fecha de la Actividad (YYYY-MM-DD):");
                Date fechaActividad = Date.valueOf(fechaString);
                int lugarId = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del Lugar:"));
                int cuadrillaId = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la Cuadrilla:"));

                ActividadLimpieza actividad = new ActividadLimpieza(actividadId, actividadDescripcion, fechaActividad, lugarId, cuadrillaId);
                actividad.guardar();
                JOptionPane.showMessageDialog(null, "Actividad de Limpieza guardada exitosamente.");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            }
            break;

        case "Obtener por ID":
    try {
        int idBuscar = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la Actividad de Limpieza a buscar:"));
        ActividadLimpieza actividadEncontrada = ActividadLimpieza.obtenerPorId(idBuscar);
        if (actividadEncontrada != null) {
            JOptionPane.showMessageDialog(null, 
                "Actividad ID: " + actividadEncontrada.getActividadLimpieza_id() +
                "\nDescripción: " + actividadEncontrada.getDescripcion() +
                "\nFecha: " + actividadEncontrada.getFecha() +
                "\nLugar ID: " + actividadEncontrada.getColonia_id() +
                "\nCuadrilla ID: " + actividadEncontrada.getCuadrillaId());
        } else {
            JOptionPane.showMessageDialog(null, "Actividad de Limpieza no encontrada.");
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
    }
    break;


        case "Actualizar":
            try {
                int actualizarId = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la Actividad de Limpieza a actualizar:"));
                ActividadLimpieza actividadActualizar = ActividadLimpieza.obtenerPorId(actualizarId);

                if (actividadActualizar != null) {
                    String nuevaDescripcion = JOptionPane.showInputDialog("Ingrese la nueva descripción de la Actividad de Limpieza:", actividadActualizar.getDescripcion());
                    String nuevaFechaString = JOptionPane.showInputDialog("Ingrese la nueva fecha de la Actividad (YYYY-MM-DD):", actividadActualizar.getFecha().toString());
                    Date nuevaFecha = Date.valueOf(nuevaFechaString);
                    int nuevoLugarId = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo ID del Lugar:", actividadActualizar.getColonia_id()));
                    int nuevaCuadrillaId = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo ID de la Cuadrilla:", actividadActualizar.getCuadrillaId()));

                    actividadActualizar.setDescripcion(nuevaDescripcion);
                    actividadActualizar.setFecha(nuevaFecha);
                    actividadActualizar.setColonia_id(nuevoLugarId);
                    actividadActualizar.setCuadrillaId(nuevaCuadrillaId);
                    actividadActualizar.actualizar();

                    JOptionPane.showMessageDialog(null, "Actividad de Limpieza actualizada exitosamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "Actividad de Limpieza no encontrada.");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            }
            break;

        case "Eliminar":
            try {
                int eliminarId = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la Actividad de Limpieza a eliminar:"));
                ActividadLimpieza actividadEliminar = ActividadLimpieza.obtenerPorId(eliminarId);
                if (actividadEliminar != null) {
                    actividadEliminar.eliminar();
                    JOptionPane.showMessageDialog(null, "Actividad de Limpieza eliminada exitosamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "Actividad de Limpieza no encontrada.");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            }
            break;

        case "Regresar":
            // No se realiza ninguna acción y se regresa al menú anterior.
            break;

        default:
            JOptionPane.showMessageDialog(null, "Opción no válida.");
            break;
    }
}

}


*/

