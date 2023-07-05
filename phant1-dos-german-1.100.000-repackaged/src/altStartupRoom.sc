;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 911)
(include sci.sh)
(use Main)

(public
	altStartupRoom 0
)

(instance altStartupRoom of ScaryRoom
	(properties)

	(method (init)
		(super init:)
		(gCurRoom newRoom: global108)
	)
)

