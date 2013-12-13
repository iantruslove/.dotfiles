# Clone .emacs.d
if [[ ! -d ~/.emacs.d ]]; then
    git clone --recursive git@github.com:iantruslove/.emacs.d.git ~/.emacs.d
fi

# Install cask
if [[ ! -e ~/.cask/bin/cask ]]; then
    curl -fsSkL https://raw.github.com/cask/cask/master/go | python
fi

cd ~/.emacs.d
~/.cask/bin/cask install
cd ~
