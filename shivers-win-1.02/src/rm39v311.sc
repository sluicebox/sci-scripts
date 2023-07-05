;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 39311)
(include sci.sh)
(use Main)
(use n951)

(public
	rm39v311 0
)

(instance rm39v311 of ShiversRoom
	(properties
		picture 39311
	)

	(method (init)
		(SetFlag 72)
		(gSounds play: 13219 0 82 0)
		(efExitBack init: 8)
		(super init: &rest)
	)

	(method (newRoom)
		(gSounds stop: 13219)
		(gSounds play: 13219 0 82 0)
		(super newRoom: &rest)
	)
)

(instance efExitBack of ExitFeature
	(properties
		nextRoom 39310
	)

	(method (init)
		(self
			createPoly:
				0
				0
				262
				0
				262
				142
				175
				142
				211
				37
				208
				21
				146
				6
				123
				6
				114
				25
				111
				54
				116
				100
				160
				140
				0
				140
				0
				0
		)
		(super init: &rest)
	)
)

