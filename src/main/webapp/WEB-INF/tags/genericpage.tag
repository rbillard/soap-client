<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>

	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
    <title>Soap-Client</title>
    
    <link href="/${ context }/img/soap-client.ico" rel="icon" />
	<link href="/${ context }/css/bootstrap.min.css" rel="stylesheet" /> 
	<link href="/${ context }/css/bootstrap-theme.min.css" rel="stylesheet" /> 
	<link href="/${ context }/css/soap-client.css" rel="stylesheet" /> 

</head>
<body>

	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <a class="navbar-brand" href="#">Soap-client</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li class="${ homeMenuCss }"><a href="/${ context }/">Home</a></li>
            <li class="${ actorMenuCss }"><a href="/${ context }/actor/actors">Actor</a></li>
            <li class="${ movieMenuCss }"><a href="/${ context }/movie/movies">Movie</a></li>
            <li class="${ roleMenuCss }"><a href="/${ context }/role/roles">Role</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>
    
    <div class="container">

      <div class="starter-template">
      	<div class="page-header">
        	<h1>${ title }</h1>
        </div>
      </div>

		<div id="body">
			<jsp:doBody />
		</div>
		
    </div><!-- /.container -->

	<div class="footer">
      <div class="container">
        <p class="text-muted">rbillard</p>
      </div>
    </div>

	<script type="text/javascript" src="/${ context }/js/bootstrap.min.js"></script>
	
</body>
</html>