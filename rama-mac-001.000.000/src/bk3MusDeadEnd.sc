;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4213)
(include sci.sh)
(use Main)
(use Location)

(public
	bk3MusDeadEnd 0
)

(instance bk3MusDeadEnd of CloseupLocation
	(properties)

	(method (init)
		(super init: 4258)
		(= plane global116)
		(self edgeN: 0 edgeW: 0 edgeE: 0)
	)

	(method (pitch)
		(self newRoom: 4212) ; bk3Museum
	)
)

