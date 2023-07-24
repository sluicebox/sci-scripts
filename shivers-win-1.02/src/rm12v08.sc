;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 12080)
(include sci.sh)
(use Main)
(use n951)

(public
	rm12v08 0
)

(instance rm12v08 of ShiversRoom
	(properties
		picture 12080
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(if (proc951_11 6 12000)
			(proc951_7 20910)
			(gSounds play: 20910 -1 0 0)
			(gSounds fade: 20910 50 10 16 0 0)
		)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (and (proc951_11 6 12000) (!= newRoomNumber 12500)) ; rm12v50
			(gSounds fade: 20910 0 10 16 1 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 12090
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 12090
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 12500
	)

	(method (init)
		(self
			createPoly: 117 139 102 113 106 105 110 91 128 77 147 97 154 115 139 138
		)
		(super init: &rest)
	)
)

