# ProyectoPOO
Este es el proyecto que se realizara durante el primer semestre de 2023 en el ramo de Programacion Orientada a Objetos (POO)

Cosas a tener en cuenta con el programa:

1) La base de datos esta ubicada en src/main/test/cboom.sql
2) Si quiere eliminar un tipo de rutina o dieta, tiene que asegurarse que ningun usuario tenga asignada la rutina o dieta ,esto debido a que en la base de datos tanto dieta como rutina estan señaladas como delete restrictivo con on delete restrict.
3) Si hay problemas en la clase de panel de usuario, se tiene que agregar la dependencia "jCalendar-1.3-3.jar" al programa para que funcione correctamente.
4) Hay ocaciones en que netbeans borra una parte de la interfaz de panel de usuario y hay que agregar nuevamente el try catch desde intelliJ, ya que netbeans no permite modificar esa seccion del codigo.
