# Cool

Translate the following code
```
{
	int i; float[100] a; float v;
	while (a[i] < v) {
		i = i + 1;
	}
}
```
to
```
L1:	t1 = i * 8
	t2 = a [ t1 ] 
	iffalse t2 < v goto L2
L3:	i = i + 1
	goto L1
L2:
```
