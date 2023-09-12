# lobbyplugin

A plugin used for MC Frens lobby.

## Development
- Download Intellij
- Under Project Settings select Project Structure
- Go to Artifacts
- Create a new JAR artifact
- Select "From module with dependencies"
- Create
- Hit the + button under your new JAR config and copy the plugin.yml file 
- The plugin.yml is needed in the JAR because Minecraft reads it to figure out what the plugin can do
- This tells Intellij how to create a JAR file for your project
- To generate the JAR file, go to Build > Build artifacts
- The JAR file will be under the "out/artifacts" folder
- Put the JAR in the server plugins folder
- You can reload the server with your new changes with /reload confirm