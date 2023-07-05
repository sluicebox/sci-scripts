;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10142)
(include sci.sh)
(use Main)
(use n951)

(public
	rm10v142 0
)

(instance rm10v142 of ShiversRoom
	(properties
		picture 10142
	)

	(method (init)
		(proc951_16 97)
		(gSounds play: 11013 0 82 0)
		(super init: &rest)
		(efExitBack init: 8)
	)
)

(instance efExitBack of ExitFeature
	(properties
		nextRoom 10140
	)

	(method (init)
		(if (== gPrevRoomNum 10480) ; rm10v480
			(= nextRoom 10480)
		)
		(if (== gPrevRoomNum 10410) ; rm10v410
			(= nextRoom 10410)
		)
		(self
			createPoly:
				0
				0
				20
				20
				240
				20
				240
				120
				20
				120
				20
				22
				0
				2
				0
				143
				263
				143
				263
				0
		)
		(super init: &rest)
	)
)

