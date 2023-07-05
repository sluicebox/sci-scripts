;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 12182)
(include sci.sh)
(use Main)
(use n951)
(use Actor)

(public
	rm12v182 0
)

(local
	local0
)

(instance rm12v182 of ShiversRoom
	(properties
		picture 12182
	)

	(method (init)
		(if (not (IsFlag 53))
			(SetFlag 53)
		)
		(proc951_16 137)
		(= local0 0)
		(efExitBack init: 8)
		(hsFrontPage init:)
		(gSounds play: 10618 0 40 0)
		(super init: &rest)
	)

	(method (newRoom)
		(gSounds play: 10621 0 40 0)
		(super newRoom: &rest)
	)
)

(instance efExitBack of ExitFeature
	(properties)

	(method (init)
		(self createPoly: 0 0 18 0 18 141 245 141 245 0 263 0 263 143 0 143 0 1)
		(if (IsFlag 45)
			(= nextRoom 991)
		else
			(= nextRoom 12181)
		)
		(super init: &rest)
	)
)

(instance hsFrontPage of HotSpot
	(properties)

	(method (init)
		(self createPoly: 21 2 21 140 242 140 242 2 21 2)
		(super init: &rest)
	)

	(method (doVerb)
		(cond
			((< (++ local0) 5)
				(gSounds stop: 10622)
				(gSounds play: 10622 0 40 0)
				(vBlueprint view: (+ 12182 local0) init:)
			)
			((IsFlag 45)
				(gCurRoom newRoom: 991) ; shiversFlashback
			)
			(else
				(gCurRoom newRoom: 12181) ; rm12v181
			)
		)
	)
)

(instance vBlueprint of View
	(properties
		view 12183
	)

	(method (init)
		(self setPri: 25 1)
		(super init: &rest)
	)
)

