<h1>Documentation</h1>
To connect the application with your database you need change <br>the resources/database.propertiess file.

<br>1. Change the file according to your neeed

<pre><code>jdbc.user= &lt;Your database username here&gt;

jdbc.pass= &lt;Your database password here&gt;

jdbc.url= &lt;your databse url here&gt; 
</code></pre>

<br>2. Migration required (resources/db/migration/V1.0_init.sql)
<pre>
create TABLE if not exists `flat` (
`id` int(11) not null,
`rooms` int(11) not null,
`square` double not null,
`address`varchar(255) not null,
`description` varchar(255) not null ,
`coordinates_id` int(11) not null
);

create table if not exists `photo` (
`id` int(11) not null,
`photo` longblob not null,
`flat_id` int(11) not null
);

create table if not exists `coordinates` (
`id` int(11) not null,
`latitude` varchar(255) not null,
`longitude` varchar(255) not null
)
</pre>
<h1>Usage</h1>
Run the project through the IDE and head out to http://localhost:8080

<h2>To add a new property, you need to click on the button "Add apartment", by clicking which will open the dialog for adding.</h2>

<h2>To see the full information, you need to click on the label on the map.</h2>
