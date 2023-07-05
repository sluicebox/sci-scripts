;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3007)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use ExitFeature)

(public
	egCardKeyCU 0
)

(instance egCardKeyCU of CloseupRoom
	(properties
		picture 703
		exitRoom 3006
	)

	(method (init)
		(super init: &rest)
		(cardKeyF init: (proc63002_10 250 109 433 153 424 277 225 239))
		(gGame handsOn: 1)
	)
)

(instance cardKeyF of ExitFeature
	(properties
		sceneScored 1
		doneFlag 1500
		invItem 2
		nextRoom 3006
		exitScene 4990
	)

	(method (handleEvent)
		(if (super handleEvent: &rest)
			((ScriptID 30061 0) restart:) ; zombiesTimer
			(= global211 (not (= global212 0)))
		)
	)
)

