[[ -s "$HOME/local/bin/ssh-color-term" ]] && alias ssh=$HOME/local/bin/ssh-color-term

## fix-agent - from Joe's https://gist.github.com/joegallo/84df64e178a5ba25899b
function agent-path
{
    case $(uname) in
        Darwin)
            echo "*launch*/Listeners"
            ;;
        *)
            echo "*ssh*/agent\.*"
            ;;
    esac
}

function agent-sockets
{
    find -L /tmp -uid $UID -path $(agent-path) -type s 2> /dev/null
}

function find-agent
{
    if [ -z "$(agent-sockets)" ]; then
        echo "no agent found"
        return 1
    else
        /bin/ls -t1 $(agent-sockets) | head -1
    fi
}

function fix-agent
{
    export SSH_AUTH_SOCK="$(find-agent)"
    ssh-add -l > /dev/null
}
