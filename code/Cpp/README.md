# C++ Samples - Samples

[C++ Samples](http://cppsamples.com/) is a repository of code samples
illustrating a modern
and idiomatic approach to writing C++. The aim is to provide
beginner to intermediate C++ developers a reference for solving common
problems in C++. As the C++ language and library evolve, which they
have been doing rapidly since the release of C++11, these samples
will be updated to match the current state-of-the-art in idiomatic C++
development.

This repository contains the source for the samples themselves, which
is used when building the C++ Samples web front-end. For the front-end
source, see [sftrabbit/CppSamples-Web](https://github.com/sftrabbit/CppSamples-Web).

## Contributing

To contribute new samples or edit existing ones, please fork this
repository and submit pull requests for your changes. Please read
the following guidelines before contributing.

### TODO list

For sample ideas, please see the
[issues page](https://github.com/sftrabbit/CppSamples-Samples/issues)
for suggestions. If you don't feel like writing samples yourself,
feel free to add suggestions to this page.

## Guidelines

### What makes a good sample?

A good sample:

- uses only modern C++ language and standard library features.
- is generic and therefore widely applicable.
- is understandable for C++ beginners.
- acts as a starting point for learning about C++ features.

### File names

Each sample is a `.cpp` file that exists within a category and a
section. In the repository, these files have the following path:

    <category>/<section>/<sample>.cpp

The categories are very broad and it is not expected that new
categories will be added any time soon. If your sample does not
fit into an existing section, feel free to create a new section.
Every category and section contains a `TITLE` file, giving the
name of that category or section.

When the web front-end is built, numeric prefixes are stripped from
category names and the section is removed. For example, the following
sample source:

    1-common-tasks/classes/pimpl.cpp

is given the following page in the web front-end:

    common-tasks/pimpl.html

The purpose of removing the section directory is to ensure URLs do
not change when moving samples between sections. For this reason,
all sample file names within a category must be unique.

Even if the title of a sample changes, please avoid changing the
file name. If the sample changes significantly enough for the
file name to change, then it should be a new sample.

### File format

Every sample `.cpp` file must be structured as follows:

    // Title
    // Tag1, Tag2

    Sample code

    // Intent paragraph
    //
    // Description paragraph #1
    //
    // Description paragraph #2

    Hidden code

The title comment and tags comment must each be a single line. The
tags comment is optional. The tags line should be a comma separated
list of tags.

The intent and description are processed as an extended form of
[Markdown](http://daringfireball.net/projects/markdown/), which means
that they support formatting such as italics, bold text, links, lists,
and line references.

The sample code section is displayed on the sample page and should
contain everything required to understand the sample. The hidden code
section should contain any additional code that is required in order
for the file to compile and is not shown on the sample page.

Please keep to a width of approximately 70 characters for those who
might view the source without wrapping.

### Markdown extensions

The sample description is processed as a form of Markdown with the
following extensions:

1.  Line references are added with the `[XX-YY]` syntax. The `-YY` is
    optional and used to denote a range of lines. An exclamation mark
    after the opening bracket causes the output to be capitalized.

    The numbers provided should denote line numbers in the original
    `.cpp` file. They will be offset automatically when building the
    web front-end.

    For example, `[10]` may expand to `line 8`, `[10-14]` may expand
    to `lines 8-12`, and `[!15]` may expand to `Line 13` (note the
    capital L).

2.  To simplify links to [cppreference.com](http://en.cppreference.com/w/),
    any link whose URL begins with `c/` or `cpp/` will automatically link
    to the appropriate page on cppreference.com.

### Code style

The only strict requirement on code style is that it should be
idiomatic and modern C++. The exact formatting of code is not too
important - in fact, variations in style can be useful.

There are a few simple guidelines:

-   Avoid using `auto` for two reasons: firstly, the samples are
    intended to be used as a reference for beginner C++ developers,
    and the types involved are important to help with their
    understanding; secondly, a concensus has not been reached on when
    it is appropriate to use `auto`.

-   Use the uniform initialisation syntax where possible.

-   Name entities with generic names (`foo`, `bar`, `func`, `x`, etc.).

-   Keep the sample code as simple as possible. Give the bare minimum
    required to understand the sample.

-   Do not use inline comments for explaining the sample - that's what
    the sample description should do. Use inline comments only as a
    placeholder for omitted code.

### Writing style

The writing style for the intent and description are also not strict.
However, there are a few guidelines that should be kept in mind:

-   Use the personal pronoun "we" when describing the sample, as
    though you and the reader wrote this code together. It helps
    to make the description more personable.

-   Use line references whenever appropriate. It allows the reader
    cross-reference between the code and the description.

-   The intent should be a simple sentence or two describing what
    the purpose of the sample is.
