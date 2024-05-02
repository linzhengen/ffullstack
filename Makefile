.DEFAULT_GOAL := all
.PHONY: all install-tools install-homebrew pre-commit-install

TOOLS := kubectl kustomize helm tfenv pre-commit

all: install-homebrew install-tools pre-commit-install

install-tools: $(TOOLS)

$(TOOLS):
	@echo "Checking if $@ is installed..."
	@command -v $@ >/dev/null || { echo "Installing $@..."; brew install $@; }

install-homebrew:
	@echo "Checking if Homebrew is installed..."
	@command -v brew >/dev/null || { echo "Installing Homebrew..."; /bin/bash -c "$$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"; }

pre-commit-install:
	@echo "Installing pre-commit hooks..."
	@pre-commit install
	@pre-commit install --hook-type commit-msg
