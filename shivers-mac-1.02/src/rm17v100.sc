;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 17100)
(include sci.sh)
(use Main)
(use n951)

(public
	rm17v100 0
)

(instance rm17v100 of ShiversRoom
	(properties
		picture 17100
	)

	(method (init)
		(if (not (IsFlag 14))
			(= picture 17101)
		)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(if (proc951_11 9 17000)
			(proc951_7 21111)
			(gSounds play: 21111 -1 32 0)
		)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (and (proc951_11 9 17000) (!= newRoomNumber 17090)) ; rm17v090
			(gSounds fade: 21111 0 5 16 1 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 17090
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 17070
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 17120
	)

	(method (init)
		(self
			createPoly: 118 105 113 64 120 59 130 62 133 76 142 76 142 50 167 50 167 85 172 79 180 79 183 83 181 104 165 106
		)
		(super init: &rest)
	)
)

