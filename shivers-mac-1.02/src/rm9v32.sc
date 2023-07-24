;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9320)
(include sci.sh)
(use Main)
(use n951)
(use Motion)
(use Actor)

(public
	rm9v32 0
)

(instance rm9v32 of ShiversRoom
	(properties
		picture 9320
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(pFountain init:)
		(if (IsFlag 42)
			(if (< 9000 gPrevRoomNum 9300) ; rm9v30
				(proc951_7 10908)
				(proc951_9 10908)
				(gSounds play: 10908 -1 8 0)
			)
			((Prop new:)
				view: 9320
				setPri: 5 1
				loop: 1
				cycleSpeed: 12
				setCycle: Fwd
				init:
			)
		else
			((Prop new:) view: 9320 setPri: 5 1 loop: 0 init:)
		)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 9310
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 9331
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 9360
	)

	(method (init)
		(self
			createPoly: 76 143 97 101 60 101 22 99 28 84 44 85 44 41 92 41 92 61 157 61 160 94 181 98 170 110 190 117 190 136 196 143 76 143
		)
		(super init: &rest)
	)
)

(instance pFountain of ShiversProp
	(properties
		priority 3
		fixPriority 1
		view 9320
	)
)

