import { defineConfig } from 'vitepress'
import CodeRunPlugin from './theme/plugins/run-code'
import AutoNavPlugin from 'vitepress-auto-nav-sidebar'

const { nav, sidebar } = AutoNavPlugin({
  ignoreFolders: [
    'node_modules',
    'assets',
    'public',
    '.vitepress',
    'code',
    '.obsidian',
    'utils',
    'resource'
  ],
  ignoreFiles: ['index'],
  singleLayerNav: true
})


export default defineConfig({
  lang: 'zh-CN',
  title: 'Code More Create',
  // description: 'Vite & Vue powered static site generator.',
  markdown: {
    config: (md) => {
      md.use(CodeRunPlugin);
    }
  },
  themeConfig: {
    logo: '/logo.png',
    siteTitle: 'Code More Create',
    nav, sidebar,
    footer: {
      message: 'MIT Licensed | Copyright © 2021 - 2022',
      copyright: '粤ICP备2021165391号'
    },
    socialLinks: [
      {
        icon: 'github',
        link: 'https://github.com/Merlin218'
      }
    ],
    editLink: {
      pattern: 'https://github.com/Merlin218/learning-algorithm/edit/master/docs/:path',
      text: '更正错误'
    },
    lastUpdatedText: '更新时间'
  },
})
