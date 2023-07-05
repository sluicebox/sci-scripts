;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 42302)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use ExitFeature)
(use P2Fidget)

(public
	rm2302 0
)

(instance rm2302 of P2Room
	(properties
		picture 2302
	)

	(method (init)
		(super init: &rest)
		(if (!= (gP2SongPlyr number:) 10505)
			(gP2SongPlyr fadeIn: 10505)
			((ScriptID 0 6) start: 3 1) ; thunderTimer
		)
		(curtis init:)
		(humanF init: 466 209 532 246)
		(exitF init: 0 285 400 406)
		(if (not (IsFlag 767))
			(slime2 init:)
		)
		(gGame handsOn: 1)
	)
)

(instance curtis of P2Fidget
	(properties
		x 52
		y 338
		view 12291
	)
)

(instance humanF of ExitFeature
	(properties
		nextRoom 42305
	)
)

(instance exitF of ExitFeature
	(properties
		nextRoom 42301
		exitDir 5
	)
)

(instance slime2 of P2Fidget
	(properties
		x 471
		y 217
		view 2302
	)
)

