# Hibernate_Association_Mapping_Joins_Set_OneToMany_ManyToOne_Bi_Inner_Left_Right
We use join statements, to select the data from multiple tables of the database, when there exist relationship with joins, its possible to select data from multiple tables of the database by construction a single query Hibernate supports 4 types of joins..  Left Join Right  Join Full Join Inner Join the DEFAULT join in hibernate is Inner join  Left join means, the objects from both sides of the join are selected and more objects  from left side are selected, even though no equal objects are there at right side Right join means equal objects are selected from database and more objects are from right side of join are selected even though there is no equal objects are exist left side Full join means, both equal and un-equal objects from both sides of join are selected Inner join means only equal objects are selected  and the remaining are discarded At the time of construction the join statements, we need to use the properties created in pojo class to apply relationship between the objects To construct a join statement, we use either HQL, or NativeSql