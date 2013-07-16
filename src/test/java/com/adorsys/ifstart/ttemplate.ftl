
<!--header.ftl-->
<!DOCTYPE html>
<title>FreeMarker hello world with a: ${message}</title>

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