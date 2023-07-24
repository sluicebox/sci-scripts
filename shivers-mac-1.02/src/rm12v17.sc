;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 12170)
(include sci.sh)
(use Main)
(use n951)
(use Actor)

(public
	rm12v17 0
)

(instance rm12v17 of ShiversRoom
	(properties
		picture 12170
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(if (IsFlag 10)
			((View new:) view: 12170 cel: 0 setPri: 25 1 init:)
		)
		(if (IsFlag 9)
			((View new:) view: 12170 cel: 1 setPri: 25 1 init:)
		)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (and (proc951_11 8 12000) (== newRoomNumber 12250)) ; rm12v25
			(gSounds fade: 21212 0 10 8 1 0)
			(proc951_7 21210)
			(gSounds play: 21210 -1 0 0)
			(gSounds fade: 21210 15 10 8 0 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 12210
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 12190
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 12250
	)

	(method (init)
		(self
			createPoly: 55 143 83 112 112 96 136 76 139 47 164 47 162 80 169 98 200 112 243 143
		)
		(super init: &rest)
	)
)

