# androidtestrappi
App for rappi testing

# Capas de la aplicación
* Inteface de usuario
    * activities
        * MainActivity
        * DetailActivity
    * fragments
        * MovieFragment
        * PopularFragment
        * TopRatedFragment
        * UpcomingFragment
    * adapters
        * MovieListViewAdapter
        * SectionsPagerAdapter
* View Model (usando LiveData)
    * FactoryViewModel
    * MovieViewModel
* Repositorio    
    * MovieRepository
* Origen de datos
    * MovieService (consumo de API con Retrofit)
    * MovieDatabase (SQLLite con Room)
        * MovieDao        
        * MovieListInfo
        * Movie
* Clases transversales
    * App (aplicación global)
    * Inyección de dependencias (Dagger)
        * AppComponent        
        * ViewModelKey        
        * ActivityModule
        * AppModule
        * FragmentModule
        * VieModelModule

# Responsabilidad de cada clase
Clase    | Responsabilidad
-|-
MainActivity.java| Activity inicial que carga los tabs, list views y adaptadores
DetailActivity.java| Activity que muestra el detalle de cada película
MovieFragment | Fragment que contiene los métodos comunes para cargar las películas por categorias
PopularFragment | Clase que hereda de MovieFragment, carga los views para la categía "Popular"
TopRatedFragment| Clase que hereda de MovieFragment, carga los views para la categía "Top Rated"
UpcomingFragment| Clase que hereda de MovieFragment, carga los views para la categía "Upcoming"
MovieListViewAdapter| Adaptador para mostrar cada fila de la lista de películas de las diferentes categorias
SectionsPagerAdapter| Adaptador para manejar los tabs
FactoryViewModel| Provee un Factory para instanciar ViewModels de forma dinámica
MovieViewModel  | Inicializa las listas de películas y brinda un LiveData para actualizar los datos en pantalla
MovieRepository| Brinda acceso al servicio de películas, o a la base de datos en caso de no haber respuesta
MovieService | Expone el servicio para obtener las listas de películas en forma de método
MovieDatabase | Para conectarse y crear estructuras en base de datos
MovieDao| Accede hasta la tabla de películas para ingresar nuevos registros y consultarlos
MovieListInfo| Encapsula la información de la lista y las películas
Movie| Encapsula la información de una película

# En qué consiste el principio de responsabilidad única? Cuál es su propósito?
Cada clase se debe dedicar a hacer solo una cosa dentro de la aplicación y de forma aislada. En una buena arquitectura, la clase que atiende los eventos que se disparan desde la UI no accede a las reglas del negocio, ni mucho menos accede hasta la base de datos. Las ventajas de mantener una única responsabilidad son:
- Los componentes son más sencillos, lo que los hace más reutilizables.
- Las pruebas unitarias son más sencillas de aplicar.
- Al realizar un cambio en el código, las demás funcionalidades no deberían verse afectadas.
- No cuesta mucho trabajo agregarle funciones nuevas, porque no está muy involucrada con otras clases.

# Qué características tiene, según su opinión, un “buen” código o código limpio?
- Se usan nombres de clases, propiedades y métodos claros y coherentes a los que hacen. No se ahorran palabras al momento de nombre entidades. Al momento de leer el código no cuesta trabajo entenderlo.
- Se tiene un estándar claro y bien definido para nombrar, identar y organizar el código.
- Siempre que un procedimiento se tiene que reutilizar, se vuelve una función.
- Las funciones no llevan más de 2 parámetros de atributos relacionados entre sí, es mejor encapsularlos todos en un objeto.
- No está lleno de comentarios, un par de líneas que describan el "qué hace" y no el "cómo lo hace" es suficiente si cada cosa va en su lugar (principio de responsabilidad única) y el código es fácil de leer (buen uso de nombres)