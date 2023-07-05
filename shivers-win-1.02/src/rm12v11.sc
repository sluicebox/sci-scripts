;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 12110)
(include sci.sh)
(use Main)
(use n951)
(use Actor)

(public
	rm12v11 0
)

(instance rm12v11 of ShiversRoom
	(properties
		picture 12110
	)

	(method (init)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(efStatue init: 2)
		(efExitPlaque init: 3)
		(if (IsFlag 10)
			((View new:) view: 12110 cel: 0 setPri: 25 1 init:)
		)
		(if (IsFlag 9)
			((View new:) view: 12110 cel: 1 setPri: 25 1 init:)
		)
		(if (proc951_11 8 12000)
			(proc951_7 21212)
			(gSounds play: 21212 -1 50 0)
			(gSounds fade: 21210 0 10 8 1 0)
		)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (and (proc951_11 8 12000) (!= newRoomNumber 12170)) ; rm12v17
			(proc951_7 21210)
			(gSounds play: 21210 -1 0 0)
			(gSounds fade: 21210 15 10 8 0 0)
			(gSounds fade: 21212 0 10 8 1 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 12420
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 12170
	)

	(method (init)
		(self
			createPoly: 87 142 87 99 80 44 133 16 188 40 183 97 215 142 88 142
		)
		(super init: &rest)
	)
)

(instance efStatue of ExitFeature
	(properties
		nextRoom 12150
	)

	(method (init)
		(self createPoly: 0 110 77 110 77 0 0 0 0 109)
		(super init: &rest)
	)
)

(instance efExitPlaque of ExitFeature
	(properties
		nextRoom 12550
	)

	(method (init)
		(self createPoly: 85 141 61 109 10 117 24 142 85 143 85 142)
		(super init: &rest)
	)
)

