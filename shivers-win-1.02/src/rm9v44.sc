;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9440)
(include sci.sh)
(use Main)
(use n951)
(use Motion)
(use Actor)

(public
	rm9v44 0
)

(instance rm9v44 of ShiversRoom
	(properties
		picture 9440
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(pFountain init:)
		(if (IsFlag 42)
			(if (or (== gPrevRoomNum 9750) (< 9000 gPrevRoomNum 9200)) ; rm9v75, rm9v20
				(proc951_7 10908)
				(proc951_9 10908)
				(gSounds play: 10908 -1 8 0)
			)
			((Prop new:)
				view: 9440
				setPri: 5 1
				loop: 1
				cycleSpeed: 12
				setCycle: Fwd
				init:
			)
		else
			((Prop new:) view: 9440 setPri: 5 1 loop: 0 init:)
		)
		(if (IsFlag 43)
			(gSounds play: 10904 0 40 0)
			(ClearFlag 43)
		)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 9470
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 9450
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 9410
	)

	(method (init)
		(self createPoly: 86 143 86 52 185 52 185 122 203 140)
		(super init: &rest)
	)
)

(instance pFountain of ShiversProp
	(properties
		priority 3
		fixPriority 1
		view 9440
	)
)

