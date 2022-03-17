# SocialServiceFinder
My first commit

#CORS Filter (Change the port number accordingly)
@Bean
public CorsFilter corsFilter() {
CorsConfiguration corsConfiguration = new CorsConfiguration();
corsConfiguration.setAllowCredentials(true);
corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4202"));
corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
"Accept", "Authorization", "Origin, Accept", "X-Requested-With",
"Access-Control-Request-Method", "Access-Control-Request-Headers"));
corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Authorization",
"Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
return new CorsFilter(urlBasedCorsConfigurationSource);
}