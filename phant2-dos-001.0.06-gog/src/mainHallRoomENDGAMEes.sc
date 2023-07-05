;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3008)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use ExitFeature)

(public
	mainHallRoomENDGAMEes 0
)

(local
	[local0 4] = [255 200 285 240]
)

(instance mainHallRoomENDGAMEes of P2Room
	(properties
		picture 701
		east 3006
		west 3006
	)

	(method (init)
		(if (not (IsFlag 1500))
			(= south 3007)
		)
		(super init: &rest)
		(sensorF
			init: [local0 0] [local0 1] [local0 2] [local0 3]
			delVerb: 4
			addVerb: 6
		)
		(gGame handsOn: 1)
	)
)

(instance sensorF of ExitFeature
	(properties
		sceneScored 1
		nextRoom 6406
	)

	(method (init)
		(= exitScene (if (== global207 0) 5000 else 5008))
		(super init: &rest)
	)

	(method (handleEvent)
		(if (super handleEvent: &rest)
			(= global241 100)
			(= global211 (not (= global212 0)))
			((ScriptID 30061 0) dispose:) ; zombiesTimer
			(Lock rsSCRIPT 30061 0)
			(DisposeScript 30061)
		)
	)
)

