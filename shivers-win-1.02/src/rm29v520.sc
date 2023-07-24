;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 29520)
(include sci.sh)
(use Main)
(use n951)
(use Motion)

(public
	rm29v520 0
)

(instance rm29v520 of ShiversRoom
	(properties
		picture 29520
	)

	(method (init)
		(pPictureProp init:)
		(pButtonProp init:)
		(if (IsFlag 86)
			(pPictureProp cel: 2)
			(pButtonProp createPoly: 0 0 0 0 0 0 0 0 0 0)
			(pPictureProp createPoly: 0 0 0 0 0 0 0 0 0 0)
			(efExitPicture init: 0)
		)
		(efExitBack init: 8)
		(super init: &rest)
	)
)

(instance efExitBack of ExitFeature
	(properties
		nextRoom 29030
	)

	(method (init)
		(if (== gPrevRoomNum 29030) ; rm29v030
			(= nextRoom 29030)
		)
		(if (== gPrevRoomNum 29031) ; rm29v031
			(= nextRoom 29031)
		)
		(self
			createPoly: 1 1 126 1 115 32 67 67 120 126 189 94 262 60 262 141 1 141 1 1
		)
		(super init: &rest)
	)
)

(instance efExitPicture of ExitFeature
	(properties
		nextRoom 29521
	)

	(method (init)
		(self createPoly: 125 41 72 67 120 122 181 79 125 41)
		(super init: &rest)
	)
)

(instance pButtonProp of ShiversProp
	(properties
		priority 10
		fixPriority 1
		view 29520
	)

	(method (doVerb)
		(SetFlag 86)
		(proc951_16 154)
		(self createPoly: 0 0 0 0 0 0 0 0)
		(gSounds play: 12905 0 82 0)
		(self setCycle: End)
		(pPictureProp createPoly: 0 0 0 0 0 0 0 0)
		(pPictureProp setCycle: CT 2 1 0)
		(efExitPicture init: 0)
	)
)

(instance pPictureProp of ShiversProp
	(properties
		priority 10
		fixPriority 1
		view 29520
		loop 1
		cycleSpeed 18
	)

	(method (init)
		(if (IsFlag 86)
			(self cel: 2)
		else
			(self cel: 0)
		)
		(super init: &rest)
	)
)

