;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 12140)
(include sci.sh)
(use Main)
(use n951)

(public
	rm12v14 0
)

(instance rm12v14 of ShiversRoom
	(properties
		picture 12140
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(efStatue init: 9)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (and (proc951_11 8 12000) (or (== newRoomNumber 12420) (== newRoomNumber 12150))) ; rm12v42, rm12v15
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
		nextRoom 12190
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 12210
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 12420
	)

	(method (init)
		(self
			createPoly: 109 14 109 47 71 92 36 142 140 142 140 104 162 48 162 11 109 11 109 14
		)
		(super init: &rest)
	)
)

(instance efStatue of ExitFeature
	(properties
		nextRoom 12150
	)

	(method (init)
		(self createPoly: 176 66 152 103 153 136 232 142 233 93 223 34 208 36)
		(super init: &rest)
	)
)

