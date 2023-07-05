;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8250)
(include sci.sh)
(use Main)
(use n951)

(public
	rm8v250 0
)

(instance rm8v250 of ShiversRoom
	(properties
		picture 8250
	)

	(method (init)
		(ClearFlag 43)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 3)
		(super init: &rest)
		(cond
			((== gPrevRoomNum 10530) ; rm10v530
				(if (proc951_11 1 8000)
					(proc951_7 20802)
					(proc951_9 20802)
					(gSounds play: 20802 -1 50 0)
				else
					(proc951_7 20801)
					(proc951_9 20801)
					(gSounds play: 20801 -1 0 0)
					(gSounds fade: 20801 66 5 16 0 0)
				)
			)
			((proc951_11 1 8000)
				(proc951_7 20802)
				(proc951_9 20802)
				(gSounds play: 20802 -1 50 0)
				(gSounds fade: 20801 0 5 16 1 0)
			)
		)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 8280
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 8260
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 8140
	)

	(method (init)
		(self createPoly: 182 143 182 129 163 100 156 100 157 18 243 16 243 143)
		(super init: &rest)
	)
)

