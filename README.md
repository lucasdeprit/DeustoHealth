# DeustoHealth
## Resumen/Contexto

Crear un programa que permita la gestión de citas de los pacientes para ir al médico, los usuarios deberán darse de alta para poder tener acceso. De estos usuarios se almacenará el DNI, una contraseña y el rol de este usuario (paciente o médico) estos datos se utilizarán en el login. Tras realizar este paso, accederemos a la ventana principal, donde se mostrará la información del usuario, el expediente médico, las citas reservadas y podremos solicitar una cita. En la siguiente ventana, deberán introducirse los siguientes datos; día, mes, año, hora, motivo de la cita, etc. Tras rellenar los datos necesarios se le asignará un médico@. Todos los procesos serán almacenados en bases de datos y en archivos de texto, es decir, se guardarán los médicos, los pacientes, los historiales, las citas … 

## Objetivos del proyecto y funcionalidad

El objetivo del proyecto es crear un programa cuya interfaz sea sencilla de utilizar, facilite a los usuarios el no tener que ir hasta su centro médico más cercano para pedir cita, los médicos podrán gestionar sus citas y observar el historial de sus pacientes. Además, nos ayudará a que no se olviden las citas al ser notificados de cuando es/son.
Este sistema nos ayudará también a tener cierta fluidez en los hospitales y a reducir los largos tiempos en las salas de espera.


### Installation

1. Clonar el repositorio
```sh
git clone https://github.com/lucasdeprit/DeustoHealth
```
2.Ejecutar .jar
Tenemos que abrir el cmd en la ruta : DeustoHealth/ProgIII.
 Luego aplicar siguiente comando: 

```sh
java App.jar
```



### Ideas de interfaz

#### Ventana 1: 
Ventana en la que el usuario podrá entrar con su cuenta. Si el usuario desea registrarse puede hacerlo pulsando en el botón
“Registro”, que lo llevará a la Ventana 2.

####  Ventana 2: 
Ventana en la que el usuario podrá registrarse en la base de datos introduciendo sus datos personales (Nombre, DNI,
Dirección, NSS,...).
Debemos comprobar cuál es el rol del usuario, es decir, si es médico o si es un paciente. Dependiendo de este rol se abrirá una
ventana u otra.

#### Ventana 3: 
Ventana Principal  del paciente, en la que se ejecutará el programa, el paciente podrá elegir “Pedir cita” se le redirige
a la Ventana 4, si elige “Próximas citas”, se le lleva a la Ventana 5.

#### Ventana 4: 
Ventana en la que se pedirá una cita, se deberán rellenar los campos,  En esta ventana podremos observar la disponibilidad de médicos en esta especialidad, para que el usuario pueda 
escoger a qué hora quiere la cita.

#### Ventana 5:
Aquí podremos observar las próximas citas que hemos solicitado y ver los detalles de cada una de ellas . 

##### Grupo:
P02-09.
##### Participantes:
<table align="center">
  <tr>
<td align="center"><a href="https://github.com/joeldelacalle">
 <img src="https://avatars2.githubusercontent.com/u/43130347?s=400&v=4" 
        width="150px;" alt="Joel De la Calle"/><br /><sub><b>Joel De la Calle </b></sub></a><br/></td>
<td align="center"><a href="https://github.com/lucasdeprit">
 <img src="https://avatars1.githubusercontent.com/u/33033880?s=400&v=4" 
        width="150px;" alt="Lucas Deprit"/><br /><sub><b>Lucas Deprit</b></sub></a><br/></td>
<td align="center"><a href="https://github.com/aitormorais">
  <img src="https://avatars3.githubusercontent.com/u/43671531?s=400&v=4" 
        width="150px;" alt="Aitor Morais"/><br /><sub><b>Aitor Morais</b></sub></a><br/></td>
  </tr>
</table>
