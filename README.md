# Presentation du fonctionnement de JWT 

je dispose de 3 entitées : 

![entités](https://user-images.githubusercontent.com/43670885/161421753-7d52c291-d68b-41b4-88a5-3f3298d9ab77.png)

 je dois appliquer JWT sur mes utilisateurs et mes roles, ainsi je permet a mes utilisateur d'acquerir des roles spécifiques comme admin ou super admin 
dans mon BackApplication, j'attribut mes username et mes password ainsi que mes roles
![image](https://user-images.githubusercontent.com/43670885/161421956-4d4f9fdc-5631-4c4f-9428-162d61a6c233.png)

dans le fichier filter/CustomAuthentificationFilter j'initialise mes token d'acces et de refresh 
![image](https://user-images.githubusercontent.com/43670885/161422060-23b00f80-1927-4679-94e3-e0b34bb67b13.png)


dans postman je rentre donc l'username et le password initialisé dans le BackApplication: 
![image](https://user-images.githubusercontent.com/43670885/161422161-69a4c619-6ce8-401a-b575-d0dfc701ef7a.png)

j'obtiens une reponse positive dans ma console 

![image](https://user-images.githubusercontent.com/43670885/161422175-b8626c35-0039-4550-8877-68e79dd8ae4e.png)


et j'obtiens dans postman les tokens initialisés dans CustomAuthentificationFilter 
![image](https://user-images.githubusercontent.com/43670885/161422279-a2983b97-6575-4297-9ed1-df8c166a3d51.png)
