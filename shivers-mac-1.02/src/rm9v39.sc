;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9390)
(include sci.sh)
(use Main)
(use n951)
(use Motion)
(use Actor)
(use System)

(public
	rm9v39 0
)

(local
	local0
)

(instance rm9v39 of ShiversRoom
	(properties
		picture 9390
	)

	(method (init)
		(= local0 0)
		(ClearFlag 43)
		(hsFaucet init:)
		(efExitLeft init: 2)
		(efExitRight init: 6)
		(if (== gPrevRoomNum 9930) ; rm9v93
			(pProp setPri: 6 1 setCel: (pProp lastCel:) setCycle: Beg init:)
		else
			(pProp setPri: 6 1 init:)
		)
		(if (IsFlag 42)
			(efExitForward init: 9)
			(if (or (== gPrevRoomNum 9710) (== gPrevRoomNum 9360) (== gPrevRoomNum 9410)) ; rm9v710, rm9v36, rm9v41
				(gSounds fade: 10908 42 15 8 0 0)
			)
			(if (proc951_11 0 9000)
				(proc951_9 20909)
				(gSounds play: 20909 -1 34 0)
			)
			((Prop new:)
				view: 9390
				setPri: 5 1
				loop: 1
				cycleSpeed: 12
				setCycle: Fwd
				init:
			)
		else
			(self setScript: sWaterOff)
		)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(super newRoom: newRoomNumber &rest)
		(if
			(and
				(!= newRoomNumber 9930) ; rm9v93
				(!= newRoomNumber 9700) ; rm9v70
				(IsFlag 42)
				(proc951_11 0 9000)
			)
			(gSounds fade: 20909 0 10 16 1 0)
		)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 9850
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 9380
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 9700
	)

	(method (init)
		(self
			createPoly:
				64
				84
				76
				76
				77
				53
				113
				53
				113
				19
				129
				5
				158
				4
				175
				20
				175
				42
				164
				54
				195
				54
				204
				78
				209
				84
				187
				90
				126
				93
		)
		(super init: &rest)
	)
)

(instance hsFaucet of HotSpot
	(properties)

	(method (init)
		(self createPoly: 140 112 191 107 197 133 140 137)
		(super init: &rest)
	)

	(method (doVerb)
		((Prop new:)
			view: 9390
			loop: 2
			setPri: 11 1
			setCycle: End
			cycleSpeed: 10
			init:
		)
		(gSounds play: 10919 0 42 0)
		(= local0 1)
		(SetFlag 43)
		(efFaucet init: 3)
		(self dispose:)
	)
)

(instance efFaucet of ExitFeature
	(properties
		nextRoom 9930
	)

	(method (init)
		(self createPoly: 140 112 191 107 197 133 140 137)
		(super init: &rest)
		(gMouseDownHandler delete: self)
		(gMouseDownHandler addToFront: self)
	)
)

(instance pProp of ShiversProp
	(properties
		priority 6
		view 9390
		loop 2
	)
)

(instance sWaterOff of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((Prop new:) view: 9390 setPri: 5 1 loop: 0 init:)
				(self cue:)
			)
			(1
				(self dispose:)
			)
		)
	)
)

