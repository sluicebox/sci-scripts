;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 23310)
(include sci.sh)
(use Main)
(use n951)
(use Motion)

(public
	rm23v310 0
)

(local
	local0
)

(instance rm23v310 of ShiversRoom
	(properties
		picture 23312
	)

	(method (init)
		(if (== gPrevRoomNum 23311) ; rm23v311
			(pProp init: cel: 4)
			(= local0 0)
			(SetFlag 43)
			(efExitWriting init: 3)
		else
			(pProp init:)
			(= local0 1)
		)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitPlaque init: 3)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 23280
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 23300
	)
)

(instance efExitWriting of ExitFeature
	(properties
		nextRoom 23311
	)

	(method (init)
		(self createPoly: 99 69 129 69 135 94 95 94 99 70)
		(super init: &rest)
		(gMouseDownHandler delete: self)
		(gMouseDownHandler addToFront: self)
	)
)

(instance efExitPlaque of ExitFeature
	(properties
		nextRoom 23960
	)

	(method (init)
		(self createPoly: 66 93 49 94 55 101 71 100 67 93)
		(super init: &rest)
	)
)

(instance pProp of ShiversProp
	(properties
		priority 120
		fixPriority 1
		view 23310
		loop 1
	)

	(method (doVerb)
		(if (IsFlag 70)
			(proc951_16 162)
			(if local0
				(SetFlag 43)
				(gSounds stop: 12311)
				(gSounds play: 12310 0 90 0)
				(self setCycle: End)
				(= local0 0)
				(efExitWriting init: 3)
			else
				(ClearFlag 43)
				(gSounds stop: 12310)
				(gSounds play: 12311 0 90 0)
				(self setCycle: Beg)
				(= local0 1)
				(efExitWriting dispose:)
			)
		)
	)
)

