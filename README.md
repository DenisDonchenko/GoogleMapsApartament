<h1>Documentation</h1>
To connect the application with your database you need change <br>the resources/database.propertiess file.

<br>1. Change the file according to your neeed

<pre><code>jdbc.user= &lt;Your database username here&gt;

jdbc.pass= &lt;Your database password here&gt;

jdbc.url= &lt;your databse url here&gt; 
</code></pre>

<br>2. Migration required (resources/db/migration/V1.0_init.sql)
<pre>
CREATE TABLE IF NOT EXISTS flat
(
    id             INT(11)      NOT NULL,
    rooms          INT(11)      NOT NULL,
    square         DOUBLE       NOT NULL,
    address        VARCHAR(255) NOT NULL,
    description    VARCHAR(255) NOT NULL,
    coordinates_id INT(11)      NOT NULL
);

CREATE TABLE IF NOT EXISTS photo
(
    id      INT(11)  NOT NULL,
    photo   TINYBLOB NOT NULL,
    flat_id INT(11)  NOT NULL
);

CREATE TABLE IF NOT EXISTS coordinates
(
    id        INT(11)      NOT NULL,
    latitude  VARCHAR(255) NOT NULL,
    longitude VARCHAR(255) NOT NULL
)

</pre>
<h1>Usage</h1>
Run the project through the IDE and head out to http://localhost:8080

<h2>To add a new property, you need to click on the button "Add apartment", by clicking which will open the dialog for adding.</h2>

<h2>To see the full information, you need to click on the label on the map.</h2>

<h2>To hide full information, click on the same property</h2>
