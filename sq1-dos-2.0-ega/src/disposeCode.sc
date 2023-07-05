;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 801)
(include sci.sh)
(use LoadMany)
(use System)

(public
	disposeCode 0
)

(instance disposeCode of Code
	(properties)

	(method (doit param1)
		(LoadMany
			0
			939
			974
			969
			966
			965
			964
			956
			951
			942
			971
			940
			807
			818
			927
			930
			301
			302
			300
			819
		)
		(if
			(and
				(not (OneOf param1 54 55 57 58 59 60 61 62 63 64 65 66 67))
				(not (OneOf param1 3 4 5 6 7 8 9 10 11 12 13 103))
			)
			(DisposeScript 817)
		)
		(if (not (OneOf param1 54 55 57 58 59 60 61 62 63 64 65 66 67))
			(DisposeScript 928)
		)
		(DisposeScript 800)
		(DisposeScript 801)
	)
)

