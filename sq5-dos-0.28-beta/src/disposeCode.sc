;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 11)
(include sci.sh)
(use Main)
(use LoadMany)
(use System)

(public
	disposeCode 0
)

(instance disposeCode of Code
	(properties)

	(method (doit)
		(LoadMany
			0
			1880
			1881
			1882
			1883
			1884
			1885
			1886
			1887
			1888
			1889
			1890
			30
			954
			923
			993
			925
			934
			975
			927
			951
			939
			956
			942
			969
			964
			25
			22
			948
		)
		(gMouseDownHandler delete: (ScriptID 10)) ; debugHandler
		(if
			(not
				(OneOf
					gCurRoomNum
					110
					115
					117
					119
					121
					122
					123
					125
					127
					132
					133
					135
					137
					165
					166
					195
				)
			)
			(DisposeScript 77)
		)
		(DisposeScript 24)
		(DisposeScript 978)
		(DisposeScript 10)
		(DisposeScript 16)
		(DisposeScript 19)
		(DisposeScript 964)
		(DisposeScript 11)
	)
)

