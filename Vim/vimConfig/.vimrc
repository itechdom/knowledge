execute pathogen#infect()

set background=light
colorscheme scheakur

"colorscheme badwolf         " awesome colorscheme

syntax on

set showcmd
set cursorline
filetype plugin indent on "turns file indentation

set showmatch "highlight matching

set incsearch           " search as characters are entered
set hlsearch            " highlight matches

set foldenable          " enable folding
set foldlevelstart=10   " open most folds by default

" CtrlP settings
 let g:ctrlp_match_window = 'bottom,order:ttb'
 let g:ctrlp_switch_buffer = 0
 let g:ctrlp_working_path_mode = 0
