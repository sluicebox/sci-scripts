;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2320)
(include sci.sh)
(use Main)
(use n951)

(public
	rm2v32 0
)

(local
	local0
)

(instance rm2v32 of ShiversRoom
	(properties
		picture 2100
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(= local0 0)
		(hsEasterEgg init:)
		(super init: &rest)
		(if (== gPrevRoomNum 3010) ; rm3v010
			(proc951_9 20204)
			(gSounds stop: 20204)
			(gSounds play: 20204 -1 122 0)
			(gSounds play: 10320 0 82 0)
		)
		(if (and (IsFlag 43) (== gPrevRoomNum 2330)) ; rm2v33
			(gSounds play: 10320 0 82 0)
			(ClearFlag 43)
		)
	)
)

(instance hsEasterEgg of HotSpot
	(properties)

	(method (init)
		(self createPoly: 134 35 134 42 137 45 141 46 145 41 145 35 134 35)
		(super init: &rest)
	)

	(method (doVerb)
		(if (> (++ local0) 1)
			(gSounds play: 35122 0 90 0)
		)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 2330
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 2330
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 2620
	)

	(method (init)
		(self
			createPoly: 49 143 97 97 100 71 119 47 146 47 157 60 159 90 222 142
		)
		(super init: &rest)
	)
)

