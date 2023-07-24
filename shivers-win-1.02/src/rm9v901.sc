;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9901)
(include sci.sh)
(use Main)

(public
	rm9v901 0
)

(instance rm9v901 of ShiversRoom
	(properties
		picture 9901
	)

	(method (init)
		(efBrochure init: 0)
		(efBack init: 8)
		(if (== gPrevRoomNum 9900) ; rm9v900
			(gSounds play: 10921 0 58 0)
		else
			(gSounds play: 10924 0 58 0)
		)
		(super init: &rest)
	)
)

(instance efBack of ExitFeature
	(properties
		nextRoom 9900
	)

	(method (init)
		(self
			createPoly: 0 143 91 135 91 10 170 10 170 135 91 135 0 143 263 143 263 0 0 0
		)
		(super init: &rest)
	)
)

(instance efBrochure of ExitFeature
	(properties
		nextRoom 9902
	)

	(method (init)
		(self createPoly: 91 135 91 10 170 10 170 135)
		(super init: &rest)
	)
)

