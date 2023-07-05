;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 18240)
(include sci.sh)
(use Main)
(use n951)
(use Motion)

(public
	rm18v24 0
)

(instance rm18v24 of ShiversRoom
	(properties
		picture 18240
	)

	(method (init)
		(ClearFlag 43)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(secretDoor init:)
		(super init: &rest)
	)

	(method (dispose)
		(super dispose: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 18170
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 18150
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 10460
	)

	(method (init)
		(self createPoly: 77 115 77 27 192 27 192 114)
		(super init: &rest)
	)
)

(instance secretDoor of ShiversProp
	(properties
		priority 255
		fixPriority 1
		view 18240
	)

	(method (init)
		(self createPoly: 54 43 54 30 66 30 66 43)
		(super init: &rest)
	)

	(method (handleEvent event)
		(event localize: gThePlane)
		(if
			(and
				(& (event type:) evMOUSEBUTTON)
				(self onMe: event)
				(gUser canControl:)
				(not (IsFlag 43))
			)
			(PrintDebug {playing door opening sfx})
			(gSounds play: 11804 0 82 0)
			(gSounds play: 11805 0 82 0)
			(self cycleSpeed: 8 setCycle: End)
			(efExitForward init: 9)
			(event claimed: 1)
			(SetFlag 43)
		)
	)
)

