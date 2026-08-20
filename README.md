# Actividad 2 - Administracion de archivos de texto

Aplicacion de consola desarrollada en Java para administrar textos guardados como archivos `.txt` mediante una lista enlazada y registrar los comandos utilizados mediante una pila.

## Contenido

- [App.java](src/App.java): punto de entrada y menu principal de la aplicacion.
- [LinkedList.java](src/LinkedList.java): implementacion generica de una lista enlazada.
- [Node.java](src/Node.java): nodo generico utilizado por las estructuras de datos.
- [OSManagement.java](src/OSManagement.java): administracion del historial de comandos mediante una pila.

## Funcionalidades

La aplicacion permite crear, consultar, listar y eliminar textos desde un menu interactivo.

| Comando | Funcion |
| --- | --- |
| `echo` | Solicita un titulo y un texto para guardarlo como archivo `.txt`. |
| `peek <nombre.txt>` | Muestra el contenido del archivo indicado. |
| `remove <nombre.txt>` | Elimina el archivo indicado de la lista. |
| `pop` | Elimina el ultimo texto agregado. |
| `dequeue` | Elimina el primer texto agregado. |
| `ls` | Lista los nombres de todos los archivos guardados. |
| `log` | Muestra el historial de comandos con fecha y hora. |
| `exit` | Termina la ejecucion del programa. |

Los archivos se almacenan en el formato `titulo.txt - texto`. El titulo solo puede contener letras y numeros; la extension `.txt` se agrega automaticamente cuando es necesario.

## Estructuras de datos

- **Lista enlazada:** almacena los textos y permite agregarlos al final, consultarlos por posicion y eliminarlos por nombre, al inicio, al final o por indice.
- **Pila:** guarda el historial de comandos, colocando el comando mas reciente en la parte superior.
- **Nodo generico:** contiene el dato almacenado y la referencia al siguiente nodo.

## Flujo de uso

1. Compila los archivos fuente.
2. Ejecuta la aplicacion.
3. Selecciona un comando desde el menu.
4. Captura el titulo y el texto cuando uses `echo`.
5. Consulta o elimina los textos con el comando correspondiente.
6. Usa `log` para revisar el historial y `exit` para salir.

## Compilacion y ejecucion

Desde la carpeta `Actividad2`, ejecuta:

```bash
javac -d out src/*.java
java -cp out App
```

Tambien puedes compilar usando la configuracion del proyecto Java de VS Code, que define `src` como carpeta de codigo fuente y `bin` como carpeta de salida.

## Validacion

La aplicacion contempla listas vacias, nombres de archivo ausentes, archivos inexistentes y titulos invalidos. Para comprobar que compile correctamente, ejecuta:

```bash
javac -d out src/*.java
```
