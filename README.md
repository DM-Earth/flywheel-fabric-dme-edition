<div align="center">
<img src="https://i.imgur.com/yVFgPpr.png" alt="Logo by @voxel_dani on Twitter" width="250">
<h1>Flywheel Fabric DM-Earth Edition</h1>
<h6>A modern engine for modded Minecraft.</h6>
<a href='https://jitpack.io/#DM-Earth/flywheel-fabric-dme-edition'><img src='https://jitpack.io/v/DM-Earth/flywheel-fabric-dme-edition.svg' alt="Jitpack"></a>
<a href="https://discord.gg/sHUtFBxVdj"><img src="https://img.shields.io/discord/841464837406195712?color=5865f2&label=Discord&style=flat" alt="Discord"></a>
<br>
</div>

### About

The goal of this project is to provide tools for mod developers so they no longer have to worry about performance, or
limitations of Minecraft's archaic rendering engine. That said, this is primarily an outlet for me to have fun with
graphics programming.

### Instancing

Flywheel provides an alternate, unified path for entity and block entity rendering that takes advantage of GPU
instancing. In doing so, Flywheel gives the developer the flexibility to define their own vertex and instance formats,
and write custom shaders to ingest that data.

### Shaders

To accomodate the developer and leave more in the hands of the engine, Flywheel provides a custom shader loading and
templating system to hide the details of the CPU/GPU interface. This system is a work in progress. There will be
breaking changes, and I make no guarantees of backwards compatibility.

### Plans

- Vanilla performance improvements
- Compute shader particles
- Deferred rendering
- Different renderers for differently aged hardware

### Getting Started (For Developers)

Add the following repo and dependency to your `build.gradle`:

```groovy
repositories {
    maven {
        url "https://jitpack.io"
    }
}

dependencies {
    modImplementation "com.github.DM-Earth:flywheel-fabric-dme-edition:${flywheel_version}"
}
```
`${flywheel_version}` gets replaced by the version of Flywheel you want to use, eg. `0.6.10-1.20.1`

For a list of available Flywheel versions, you can check [the maven](https://jitpack.io/#DM-Earth/flywheel-fabric-dme-edition).
