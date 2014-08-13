# Move aside existing .emacs.d directory
[[ -d ~/.emacs.d ]] && mv ~/.emacs.d ~/.old_emacs.d

# Pull down emacs config
git clone --recursive https://github.com/iantruslove/emacs.d.git ~/.emacs.d
