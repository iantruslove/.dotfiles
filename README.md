# Dotfiles

My OS X / Ubuntu dotfiles.

## Installation

```sh
bash -c "$(curl -fsSL https://raw.github.com/iantruslove/.dotfiles/master/bin/dotfiles)" && source ~/.bashrc
```
or
```sh
bash -c "$(wget -qO - https://raw.github.com/iantruslove/.dotfiles/master/bin/dotfiles)" && source ~/.bashrc
```

## Rationale

Heavily inspired by (i.e. stolen from) Ben Alman's https://github.com/cowboy/dotfiles.

I finally decided that I wanted to be able to execute a single command
to "bootstrap" a new system to pull down all of my dotfiles and
configs, as well as install all the tools I commonly use. In addition,
I wanted to be able to re-execute that command at any time to
synchronize anything that might have changed. Finally, I wanted to
make it easy to re-integrate changes back in, so that other machines
could be updated.

That command is [dotfiles][dotfiles], and this is my "dotfiles" Git repo.

[dotfiles]: bin/dotfiles
[bin]: https://github.com/iantruslove/.dotfiles/tree/master/bin

## What, exactly, does the "dotfiles" command do?

It's really not very complicated. When [dotfiles][dotfiles] is run, it does a few things:

1. Git is installed if necessary, via APT or Homebrew (which is installed if necessary).
2. This repo is cloned into the `~/.dotfiles` directory (or updated if it already exists).
3. Files in `init` are executed (in alphanumeric order, hence the "50_" names).
4. Files in `copy` are copied into `~/`.
5. Files in `link` are linked into `~/`.

Note:

* The `backups` folder only gets created when necessary. Any files in
  `~/` that would have been overwritten by `copy` or `link` get backed
  up there.
* Files in `bin` are executable shell scripts
  (Eg. [~/.dotfiles/bin][bin] is added into the path).
* Files in `source` get sourced whenever a new shell is opened (in
  alphanumeric order, hence the "50_" names).
* Files in `conf` just sit there. If a config file doesn't _need_ to
  go in `~/`, put it in there.
* Files in `caches` are cached files, only used by some scripts. This
  folder will only be created if necessary.

## Prerequisites

### OS X Notes

* You need to be an administrator (for `sudo`).
* You need to have installed [XCode][] or, at the very minimum, the
  [XCode Command Line Tools][], which are available as a
  _much smaller_ download.

[XCode]: https://developer.apple.com/downloads/index.action?=xcode
[XCode Command Line Tools]: https://developer.apple.com/downloads/index.action?=command%20line%20tools
  
### Ubuntu Notes

* You need to be an administrator (for `sudo`).
* You might want to update/upgrade APT with `sudo apt-get update &&
  sudo apt-get upgrade` first.  Or not, live dangerously!

## Details

### The "init" step

A whole bunch of things will be installed, but _only_ if they aren't
already.  Check out the scripts in the [init](init/) directory.

### The ~/ "copy" step

Any file in the `copy` subdirectory will be copied into `~/`. Any file
that _needs_ to be modified with personal information (like
[.gitconfig](copy/.gitconfig) which contains an email address and
private key) should be _copied_ into `~/`. Because the file you'll be
editing is no longer in `~/.dotfiles`, it's less likely to be
accidentally committed into your public dotfiles repo.

### The ~/ "link" step

Any file in the `link` subdirectory gets symbolically linked with `ln
-s` into `~/`. Edit these, and you change the file in the repo. Don't
link files containing sensitive data, or you might accidentally commit
that data!

### Aliases and Functions

To keep things easy, the `~/.bashrc` and `~/.bash_profile` files are
extremely simple, and should never need to be modified. Instead, add
your aliases, functions, settings, etc into one of the files in the
`source` subdirectory, or add a new file. They're all automatically
sourced when a new shell is opened. Take a look, I have
[a lot of aliases and functions](https://github.com/iantruslove/.dotfiles/tree/master/source).
I even have a [fancy prompt](source/50_prompt.sh) that shows the
current directory, time and current git/svn repo status.

### Scripts

In addition to the aforementioned [dotfiles][dotfiles] script, there
are a few other [bash scripts][bin]. This includes
[ack](https://github.com/petdance/ack), which is a
[git submodule](https://github.com/iantruslove/.dotfiles/tree/master/libs).

* [dotfiles][dotfiles] - (re)initialize dotfiles. It might ask for your password (for `sudo`).
* [src](link/.bashrc#L6-15) - (re)source all files in `source` directory
* Look through the [bin][bin] subdirectory for a few more.

### Prompt

It shows git and svn repo status, a timestamp, error exit codes, and
even changes color depending on how you've logged in.

Git repos display as **[branch:flags]** where flags are:

**?** untracked files  
**!** changed (but unstaged) files  
**+** staged files

SVN repos display as **[rev1:rev2]** where rev1 and rev2 are:

**rev1** last changed revision  
**rev2** revision

## License

Licensed under the MIT license.
