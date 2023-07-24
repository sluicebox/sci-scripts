;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9902)
(include sci.sh)
(use Main)
(use n951)

(public
	rm9v902 0
)

(instance rm9v902 of ShiversRoom
	(properties
		picture 9902
	)

	(method (init)
		(proc951_16 135)
		(SetFlag 48)
		(efBrochure init: 0)
		(efBack init: 8)
		(gSounds play: 10924 0 58 0)
		(super init: &rest)
	)
)

(instance efBack of ExitFeature
	(properties)

	(method (init)
		(self
			createPoly: 0 0 14 10 247 11 247 135 15 135 14 10 0 0 0 143 263 143 263 0
		)
		(if (IsFlag 45)
			(= nextRoom 991)
		else
			(= nextRoom 9900)
		)
		(super init: &rest)
	)
)

(instance efBrochure of ExitFeature
	(properties)

	(method (init)
		(self createPoly: 14 10 247 11 247 135 15 135)
		(if (IsFlag 45)
			(= nextRoom 991)
		else
			(= nextRoom 9901)
		)
		(super init: &rest)
	)
)

