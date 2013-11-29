new File(basedir, ".hg").deleteDir()

File touchFile = new File( basedir, "target/touch.txt" );
assert touchFile.isFile()

