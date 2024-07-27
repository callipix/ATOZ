import Plugin from '@ckeditor/ckeditor5-core/src/plugin';
import CodeBlockEditing from '@ckeditor/ckeditor5-code-block/src/codeblockediting';
import CodeBlockUI from '@ckeditor/ckeditor5-code-block/src/codeblockui';
import hljs from '@ckeditor/ckeditor5-highlight/src/HighlightEditing';
import '@ckeditor/ckeditor5-highlight/theme/highlight.css'; // highlight.js의 기본 스타일을 로드합니다.

export default class HighlightedCodeBlock extends Plugin {
    static get requires() {
        return [ CodeBlockEditing, CodeBlockUI ];
    }

    init() {
        const editor = this.editor;

        // Add the highlight.js to your editor
        editor.model.schema.extend('$text', { allowAttributes: 'language' });

        editor.conversion.for('dataDowncast').add(dispatcher => {
            dispatcher.on('insert:codeBlock', (event, data, conversionApi) => {
                const { item } = data;

                if (item.is('$text') && item.getAttribute('language')) {
                    const codeBlockElement = conversionApi.mapper.toViewElement(item);
                    const code = codeBlockElement.getChild(0);

                    // Apply syntax highlighting
                    const language = item.getAttribute('language');
                    const highlightedCode = hljs.highlight(language, code.data).value;
                    code.data = highlightedCode;

                    // Set up the syntax highlighting in the editor
                    codeBlockElement.getChild(0).data = highlightedCode;
                }
            });
        });
    }
}
