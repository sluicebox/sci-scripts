;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 21200)
(include sci.sh)
(use Main)
(use n951)

(public
	rm21v200 0
)

(instance rm21v200 of ShiversRoom
	(properties
		picture 21200
	)

	(method (init)
		(if (IsFlag 83)
			(= picture 21201)
		)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 3)
		(super init: &rest)
		(if (proc951_11 2 21000)
			(proc951_9 22102)
			(gSounds play: 22102 -1 50 0)
			(gSounds fade: 22101 0 5 16 1 0)
		)
	)

	(method (newRoom newRoomNumber)
		(if (and (proc951_11 2 21000) (<= 21140 newRoomNumber 21150)) ; rm21v140, rm21v150
			(proc951_9 22101)
			(gSounds play: 22101 -1 0 0)
			(gSounds fade: 22101 98 5 16 0 0)
			(gSounds fade: 22102 0 5 16 1 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 21450
	)

	(method (init)
		(self
			createPoly: 46 37 87 37 87 119 82 126 82 132 85 135 98 135 114 135 119 131 119 124 115 120 111 38 156 38 156 115 166 144 49 143 49 37
		)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 21140
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 21150
	)
)

