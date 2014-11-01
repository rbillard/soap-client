soap-client
===========

#### problème rencontré

Impossible de générer les classes depuis les fichiers WSDL avec le plugin cxf-codegen-plugin.

Cause : répertoire .m2 dans un répertoire parent contenant un caractère accentué : "Raphaël".

Solution : déplacement du répertoire m2.

