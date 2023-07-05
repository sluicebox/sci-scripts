;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4045)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use P2View)
(use System)

(public
	curtisCubicleRoomCH5SR4 0
)

(instance curtisCubicleRoomCH5SR4 of P2Room
	(properties
		picture 233
	)

	(method (init)
		(ClearFlag 1001)
		(super init: &rest)
		(gP2SongPlyr fadeIn: 6060 70)
		(computerFeature init: whoDoit: hectCode)
		(gGame handsOn: 1)
	)
)

(instance computerFeature of P2View
	(properties
		x 321
		y 185
		view 233
		doneFlag 761
		nextRoom 4025
	)
)

(instance hectCode of Code
	(properties)

	(method (doit)
		(= global211 (not (= global212 0)))
		(= global209 6080)
		(SetFlag 1001)
	)
)

