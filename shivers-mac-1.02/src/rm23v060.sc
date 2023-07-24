;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 23060)
(include sci.sh)
(use Main)
(use n951)

(public
	rm23v060 0
)

(instance rm23v060 of ShiversRoom
	(properties
		picture 23060
	)

	(method (init)
		(efExitForward init: 3)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitPlaque init: 3)
		(if (proc951_11 5 23000)
			(proc951_9 20702)
			(gSounds play: 20702 -1 32 0)
		)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (and (proc951_11 5 23000) (!= newRoomNumber 23160)) ; rm23v160
			(gSounds fade: 20702 0 5 16 1 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 23070
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 23050
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 23160
	)

	(method (init)
		(self
			createPoly: 158 1 177 1 205 24 205 33 200 34 200 142 140 142 141 37 135 36 134 27
		)
		(super init: &rest)
	)
)

(instance efExitPlaque of ExitFeature
	(properties
		nextRoom 23910
	)

	(method (init)
		(self createPoly: 79 92 103 92 101 103 74 103 78 92)
		(super init: &rest)
	)
)

