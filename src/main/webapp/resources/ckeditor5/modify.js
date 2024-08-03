import {
    ClassicEditor,
    AccessibilityHelp,
    Alignment,
    Autoformat,
    AutoLink,
    Autosave,
    BalloonToolbar,
    BlockQuote,
    BlockToolbar,
    Bold,
    Code,
    CodeBlock,
    Essentials,
    FindAndReplace,
    FontBackgroundColor,
    FontColor,
    FontFamily,
    FontSize,
    GeneralHtmlSupport,
    Heading,
    Highlight,
    HorizontalLine,
    Indent,
    IndentBlock,
    Italic,
    Link,
    Paragraph,
    RemoveFormat,
    SelectAll,
    SpecialCharacters,
    SpecialCharactersArrows,
    SpecialCharactersCurrency,
    SpecialCharactersEssentials,
    SpecialCharactersLatin,
    SpecialCharactersMathematical,
    SpecialCharactersText,
    Strikethrough,
    Style,
    Subscript,
    Superscript,
    Table,
    TableCaption,
    TableCellProperties,
    TableColumnResize,
    TableProperties,
    TableToolbar,
    TextPartLanguage,
    TextTransformation,
    Underline,
    Undo,
    CKFinder,
    CKFinderUploadAdapter,
    Image,  // 추가
    ImageCaption,  // 추가
    ImageStyle,  // 추가
    ImageToolbar,  // 추가
    ImageUpload,
    CodeBlockEditing,
    CodeBlockUI  // 추가
} from 'ckeditor5';

import translations from 'ckeditor5/translations/ko.js';

const editorConfig = {
    toolbar: {
        items: [
            'undo',
            'redo',
            '|',
            'heading',
            'style',
            '|',
            'fontSize',
            'fontFamily',
            'fontColor',
            'fontBackgroundColor',
            '|',
            'bold',
            'italic',
            'underline',
            '|',
            'link',
            'insertTable',
            'highlight',
            'blockQuote',
            'codeBlock',
            '|',
            'alignment',
            '|',
            'ckfinder',
            'imageUpload'
        ],
        shouldNotGroupWhenFull: false
    },
    plugins: [
        AccessibilityHelp,
        Alignment,
        Autoformat,
        AutoLink,
        Autosave,
        BalloonToolbar,
        BlockQuote,
        BlockToolbar,
        Bold,
        Code,
        CodeBlock,
        Essentials,
        FindAndReplace,
        FontBackgroundColor,
        FontColor,
        FontFamily,
        FontSize,
        GeneralHtmlSupport,
        Heading,
        Highlight,
        HorizontalLine,
        Indent,
        IndentBlock,
        Italic,
        Link,
        Paragraph,
        RemoveFormat,
        SelectAll,
        SpecialCharacters,
        SpecialCharactersArrows,
        SpecialCharactersCurrency,
        SpecialCharactersEssentials,
        SpecialCharactersLatin,
        SpecialCharactersMathematical,
        SpecialCharactersText,
        Strikethrough,
        Style,
        Subscript,
        Superscript,
        Table,
        TableCaption,
        TableCellProperties,
        TableColumnResize,
        TableProperties,
        TableToolbar,
        TextPartLanguage,
        TextTransformation,
        Underline,
        Undo,
        CKFinder,
        CKFinderUploadAdapter,
        Image,  // 추가
        ImageCaption,  // 추가
        ImageStyle,  // 추가
        ImageToolbar,  // 추가
        ImageUpload,  // 추가
        CodeBlockEditing,
        CodeBlockUI
    ],
    image: {
        toolbar : [
            'imageStyle:inline',
            'imageStyle:wrapText',
            'imageStyle:breakText', '|',
            'toggleImageCaption',
            'imageTextAlternative'
        ]
    },
    balloonToolbar: ['bold', 'italic', '|', 'link'],
    blockToolbar: [
        'fontSize',
        'fontColor',
        'fontBackgroundColor',
        '|',
        'bold',
        'italic',
        '|',
        'link',
        'insertTable',
        '|',
        'outdent',
        'indent'
    ],
    fontFamily: {
        supportAllValues: true
    },
    fontSize: {
        options: [10, 12, 14, 'default', 18, 20, 22],
        supportAllValues: true
    },
    heading: {
        options: [
            {
                model: 'paragraph',
                title: 'Paragraph',
                class: 'ck-heading_paragraph'
            },
            {
                model: 'heading1',
                view: 'h1',
                title: 'Heading 1',
                class: 'ck-heading_heading1'
            },
            {
                model: 'heading2',
                view: 'h2',
                title: 'Heading 2',
                class: 'ck-heading_heading2'
            },
            {
                model: 'heading3',
                view: 'h3',
                title: 'Heading 3',
                class: 'ck-heading_heading3'
            },
            {
                model: 'heading4',
                view: 'h4',
                title: 'Heading 4',
                class: 'ck-heading_heading4'
            },
            {
                model: 'heading5',
                view: 'h5',
                title: 'Heading 5',
                class: 'ck-heading_heading5'
            },
            {
                model: 'heading6',
                view: 'h6',
                title: 'Heading 6',
                class: 'ck-heading_heading6'
            }
        ]
    },
    htmlSupport: {
        allow: [
            {
                name: /^.*$/,
                styles: true,
                attributes: true,
                classes: true
            }
        ]
    },
    language: 'ko',
    link: {
        addTargetToExternalLinks: true,
        defaultProtocol: 'https://',
        decorators: {
            toggleDownloadable: {
                mode: 'manual',
                label: 'Downloadable',
                attributes: {
                    download: 'file'
                }
            }
        }
    },
    // menuBar: {
    //     isVisible: true
    // },
    placeholder: 'Type or paste your content here!',
    style: {
        definitions: [
            {
                name: 'Article category',
                element: 'h3',
                classes: ['category']
            },
            {
                name: 'Title',
                element: 'h2',
                classes: ['document-title']
            },
            {
                name: 'Subtitle',
                element: 'h3',
                classes: ['document-subtitle']
            },
            {
                name: 'Info box',
                element: 'p',
                classes: ['info-box']
            },
            {
                name: 'Side quote',
                element: 'blockquote',
                classes: ['side-quote']
            },
            {
                name: 'Marker',
                element: 'span',
                classes: ['marker']
            },
            {
                name: 'Spoiler',
                element: 'span',
                classes: ['spoiler']
            },
            {
                name: 'Code (dark)',
                element: 'pre',
                classes: ['fancy-code', 'fancy-code-dark']
            },
            {
                name: 'Code (bright)',
                element: 'pre',
                classes: ['fancy-code', 'fancy-code-bright']
            }
        ]
    },
    table: {
        contentToolbar: ['tableColumn', 'tableRow', 'mergeTableCells', 'tableProperties', 'tableCellProperties']
    },
    translations: [translations],
    ckfinder :{
        uploadUrl:'/myApp/upload/uploadCK'
    },

};

ClassicEditor.create(document.querySelector('#modifyContent'), editorConfig)
    .then(editor => {
        window.editor = editor;
        editor.plugins.get('FileRepository').createUploadAdapter = loader => {
            return {
                upload() {
                    return loader.file
                        .then(file => {
                            const data = new FormData();
                            data.append('upload', file);
                            return fetch('/myApp/upload/uploadCK', {
                                method: 'POST',
                                body: data
                            })
                                .then(response => response.json())
                                .then(responseData => {
                                    beforeImgAddress.push(responseData.url);
                                    return {
                                        default: responseData.url
                                    };
                                });
                        });
                }
            };
        };
    })
    .catch(error => {
        console.error('There was a problem initializing CKEditor:', error);
    });