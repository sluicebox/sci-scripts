;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 460)
(include sci.sh)
(use Main)
(use LarryRoom)

(public
	rm460 0
)

(instance rm460 of LarryRoom
	(properties
		noun 1
		picture 98
		style 15
		horizon 0
		autoLoad 0
	)

	(method (init)
		(super init:)
		(gCurRoom newRoom: 440)
	)
)

