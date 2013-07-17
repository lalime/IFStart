
<!--header.ftl-->
<!DOCTYPE html>
<html>
<head>
<title> Done by : ${message}</title>
</head>
<body> 
<#if container??>
  <div ="${container}">
<#else>
  <div ="default">
</#if>

<ul>
<#list systems as system>
<li>${system_index + 1}.${system.getName()}</li>
</#list>
</ul>

<h1>${exampleObject.getName()}</h1>

</div>

<!--footer.ftl-->
</body>
</html> 