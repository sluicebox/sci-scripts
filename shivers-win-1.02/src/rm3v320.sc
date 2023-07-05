;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3320)
(include sci.sh)
(use Main)

(public
	rm3v320 0
)

(instance rm3v320 of ShiversRoom
	(properties
		picture 3320
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 3360
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 3330
	)
)

(instance efExitForward of ExitFeature ; UNUSED
	(properties
		nextRoom 3310
	)

	(method (init)
		(self
			createPoly:
				203
				103
				177
				105
				160
				95
				150
				44
				168
				32
				263
				40
				263
				47
				257
				73
				256
				95
		)
		(super init: &rest)
	)
)

