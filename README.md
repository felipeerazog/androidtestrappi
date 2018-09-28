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