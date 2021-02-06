# Setup the mod with GitHub Desktop

This documentation will explain you how to setup the translation mod to test it.

## Prerequisites

You need to be a contributor of the mod.

Otherwise, you can do the installation for your fork of the mod.

## GitHub Desktop

[Download](https://desktop.github.com/) and install GitHub Desktop.

You will have something like the following image.

![GitHub Desktop at start](setup_1.jpg)

## Install the mod locally

Click on `ScribioTeam/OWB_French_Translation` at the right.
You will have the following window.

![Cloning window](setup_2.jpg)

You change the local path before OWB_French_Translation if you want but in general the default is a good choice.

Click on `Clone`. It will "clone" (download a copy) of the translation mod which can take some time as seen in the following image.

![Cloning loading](setup_3.jpg)

At the end of the cloning, you will see something like that

![GitHub Desktop after cloning](setup_4.jpg)

## Testing the mod

Open the cloned directory (the directory which was the local path in the cloning windows, by default Documents/GitHub/OWB_French_Translation).

Double-click on `create_symbolic_link` on Windows or `create_symbolic_link.sh` on Linux.

![File explorer on the cloned repository](setup_5.jpg)

If you have no error you will have something like this.

![Console on Windows when it succeed](setup_6.jpg)

If you see an error, open the create_symbolic_link file with a text editor.
Replace the part after `modDir=` by the path of your `Paradox Interactive\Hearts of Iron IV\mod`.
De not forget to put " to manage path with spaces if you want to avoid to put backslashs.

You will see the mod in the HoI4 launcher with an hardrive image or icon (instead of mod image or Steam icon for workshop mod) according your displaying mode.

![Mod in the playset launcher](setup_7.jpg)

![Mod in the playset launcher bis](setup_8.jpg)

## Edit the mod

You can now make changes in the cloned mod (the directory which was the local path in the cloning windows, by default Documents/GitHub/OWB_French_Translation).

> TODO complete this section