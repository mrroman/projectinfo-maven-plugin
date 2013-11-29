def proc = ('hg init '+basedir.getPath()).execute()
def b = new StringBuffer()
proc.consumeProcessOutput(b, b)
proc.waitFor()
print b

