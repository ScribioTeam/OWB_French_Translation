modDir=$HOME/.local/share/Paradox\ Interactive/Hearts\ of\ Iron\ IV/mod
modName="OWBFrenchTranslationGit"
gitModDir="$(pwd)/OWB/"

# Check that the Paradox directory is found
if [ ! -d "$modDir" ]; then
    	echo "ERROR: HoI4 mod directory not found. Searched repertory : $modDir."
	exit
fi


# Create the symbolik link if necessary
if [ ! -d "$modDir/$modName" ]; then
	ln -s $gitModDir "$modDir/$modName"
else
	echo "WARNING: the symbolic link $modDir/$modName already exists"
fi

# Copy the .mod file
if [ ! -f "$modDir/$modName.mod" ]; then
	if [ -f "./$modName.mod" ]; then
		cp ./$modName.mod "$modDir/$modName.mod"
		echo "$modDir/modName.mod copied"
	else
		echo "ERROR: the file $modName.mod doesn't exists in the script directory"
	fi
else
	echo "WARNING: the file $modDir/modName.mod already exists. Check it has the good content."
fi
