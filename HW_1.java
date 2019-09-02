html {
  /* Load this*/
  background: url(trianglify-lowres.png) repeat center center fixed;
  -webkit-background-size: cover;
  -moz-background-size: cover;
  -o-background-size: cover;
  background-size: cover;
  font-family: 'Roboto', sans-serif;

}

/* Responsive header + image */
.header {
  overflow: hidden;
  background: rgb(220, 220, 220); /* Fallback for older browsers without RGBA-support */
  background: rgba(220, 220, 220, 0.7);
  border: 6px solid whitesmoke;
  padding: 20px 10px;
  padding-left: 30px;
  width: 25em;
  margin: auto;
  /*
  margin-left: 10em;
  margin-right: 60em;
  */
}

.header a {
  float: left;
  color: black;
  text-align: center;
  padding: 12px;
  text-decoration: none;
  font-size: 18px;
  line-height: 25px;
  border-radius: 4px;
}

.header a.logo {
  font-size: 25px;
  font-weight: bold;
}

.header a:hover {
  background-color: #ddd;
  color: black;
}

.header a.active {
  background-color: dodgerblue;
  color: white;
}

.header-right {
  float: right;
}

@media screen and (max-width: 500px) {
  .header a {
    float: none;
    display: block;
    text-align: left;
  }

  .column {
    float: center;
    height: 450px;
    margin-left: 2em;
    margin-right: 4px;
    margin-top: 1em;
    width: 70%;
    padding: 30px;
    border-radius: 25px;
    border: 4px solid whitesmoke;
    background: rgb(220, 220, 220); /* Fallback for older browsers without RGBA-support */
    background: rgba(220, 220, 220, 0.7);
    /* Get rid of style tag in html and change color here*/
}
  
  .header-right {
    float: none;
  }
  .header {
      margin-right: 1em;
  }
}

a {
    text-decoration: none;
    color: black;
}

h2 {
}



h2:hover {
    color: darkmagenta;
}

#selfie {
    height: 8em;
    max-width: 100%;
    margin-left: 15em;
    margin-top: -18em;
    /*border-bottom-right-radius: 15px;*/
    border-radius: 25px;
    /*border-top-right-radius: 25px;*/
}

#move-bio-top {
  background: rgb(220, 220, 220); /* Fallback for older browsers without RGBA-support */
  background: rgba(220, 220, 220, 0.7);
  height: 10em;
  margin-left: 25em;
  margin-right: 32em;
}


.name {
    margin-top: -3em;
    margin-left: 2em;
    font-size: 3vw;
    padding-left: 4px;
    text-align: center;
}

.lil-bio {
    /* Having some trouble getting alignment right */
    margin-top: -1em;
    margin-left: 4em;
    text-align: center;
    color: black;
}

#move_down_boxes {
    margin-top: 5px;
}

.text-change {
    font-size: 1vw;
}

* {
  box-sizing: border-box;

}

/* Create three equal columns that floats next to each other */
.column {
  float: left;
  height: 450px;
  margin-left: 2em;
  margin-right: 4px;
  margin-top: 1em;
  width: 30%;
  padding: 30px;
  border-radius: 25px;
  border: 4px solid whitesmoke;
  background: rgb(220, 220, 220); /* Fallback for older browsers without RGBA-support */
  background: rgba(220, 220, 220, 0.7);
  /* Get rid of style tag in html and change color here*/
}

/* Responsive layout - makes the three columns stack on top of each other instead of next to each other */
@media screen and (max-width: 1000px) {

  .text-change {
    font-size: .7em
  }
  
  .column {
    width: 80%;
    font-size: 1.5em
  }
  
  #box-3 {
    margin-bottom: 4em;
  }
  
}
