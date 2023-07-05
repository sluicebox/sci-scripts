;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6111)
(include sci.sh)
(use Main)
(use n951)

(public
	rm6v111 0
)

(instance rm6v111 of ShiversRoom
	(properties
		picture 6111
	)

	(method (init)
		(gSounds play: 10618 0 40 0)
		(proc951_16 90)
		(efExitBack init: 8)
		(if (== gPrevRoomNum 6120) ; rm6v120
			(efExitBack nextRoom: 6120)
		)
		(super init: &rest)
	)

	(method (newRoom)
		(gSounds play: 10621 0 40 0)
		(super newRoom: &rest)
	)
)

(instance efExitBack of ExitFeature
	(properties
		nsLeft 0
		nsTop 0
		nsRight 263
		nsBottom 143
		nextRoom 6100
	)
)

