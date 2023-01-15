# GRAPHQL


![image](https://user-images.githubusercontent.com/56406481/212442391-eeacfc6d-a3b4-4afe-a284-8bc875281b0b.png)


Es un lenguaje de consulta y manipulacion de datos para apis, permitiendo gestionar los datos y hacer las consultas mas eficientes. Es my eficiente en cuanto a consultas ,permite variar la respuesta dependiendo de la request.

![image](https://user-images.githubusercontent.com/56406481/212442522-ad2f05ca-245f-421a-a6f4-1fc235c5671e.png)

Es posible que no todos los datos sean necesarios en una consulta, por lo que podemos variar estos haciendolo mas eficiente. 

+ Tiene un unico punto de acceso, por defecto "/graphql"
+ Todas las peticiones son de tipo POST
+ Queries de tipo JSON
+ Al tener un unico endpoint se puede 

En un api rest teniamos distintas versiones de endpoints "v1", "v2", etc. En GraphQL tenemos un solo endpoint, el cual podemos marcar propiedades y funciones obsoletas manteniendo ese mismo endpoint. 

**GRAPHQL** es autodocumentado, define automaticamente tipos, esquemas. No tiene almacenamiento en cache, es el usuario el encargado de almacenarlas.



## ESQUEMA

Es el primer paso y el mas importante, es el centro de implementacion, definiendo como los clientes ingresan a los datos. Se utiliza el lenguaje SDL (Schema definition language) se defina el esquema y luego el codigo. El schema es fuertemente tipado y para ser valido como minimo debe tener una consulta. 

Reglas: 
+ Tipos y directivas unicos
+ Tipos y derectivas no pueden iniciar __
+ Tipos no pueden tener nombres similares a los tipos integrados
+ Tipos, enumerados y directivas utilizan PascalCase
+ nombres de campos utilizan camelCase
+ valores enumerados utilizan ALL_CAPS

Se deben definir esquemas en torno a las necesidades del cliente y se deben evitar esquemas que no se vayan a utilizar.


## TIPOS DE GRAPHQL


+ Escalares
+ Objetos
+ Enumerados
+ Entrada

## MODIFICADORES DE TIPOS


+ ! Campo obligatorio
+ [] Lista de valores

Combinacion de ellas

+ []! : Lista no puede ser null, los valores dentro si
+ [!] : Los valores de la lista no pueden ser nulos, sin embargo puede no existir la lista
+ [!]!: Debe existir la lista y sus vaores no deben ser nulos.


## COMENTARIOS

Se los utiliza para la documentacion

+ Comentario simple " Comentario simple "
+ Comentario multilinea """ Comentario multilinea """



## TIPOS DE OPERACIONES

+ Query, es equivalente a GET en REST, sirve para hacer consultas

+ MUTATION, es equivalente a POST, PUT, PATCH y DELETE en REST y sirve para modificar datos

+ SUBSCRIPTION, Sirve para obtener informacion adicional avisando a los suscriptores.


































