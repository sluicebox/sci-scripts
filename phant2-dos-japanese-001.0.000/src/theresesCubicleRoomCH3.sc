;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4203)
(include sci.sh)
(use Main)
(use eggAMatic)
(use nExit)
(use n63002)
(use P2Feature)
(use P2Fidget)
(use Feature)
(use System)

(public
	theresesCubicleRoomCH3 0
)

(local
	local0 = 3
)

(instance theresesCubicleRoomCH3 of P2Room
	(properties
		picture 250
		south 3343
	)

	(method (init)
		(= local0 3)
		((if (gRoboGary isPlaying:) gRoboGary else gP2SongPlyr) fadeTo: 80)
		(= global241 60)
		(if (not (IsFlag 405))
			(thereseProp init: setPri: 1)
			(therese init: whoDoit: thereseCode)
		else
			(= picture 251)
			(seaLion init:)
		)
		(super init: &rest)
		(gGame handsOn: 1)
	)
)

(instance thereseProp of P2Fidget
	(properties
		x 226
		y 338
		view 12501
		initStart 0
		initFinish 0
		cycleStart 7
	)

	(method (handleEvent)
		(therese handleEvent: &rest)
	)
)

(instance therese of P2Feature
	(properties
		priority 2
	)

	(method (init)
		(super init: &rest)
		(if (IsFlag 399)
			(self delVerb: 4)
		)
	)

	(method (onMe)
		(return (thereseProp onMe: &rest))
	)
)

(instance thereseCode of Code
	(properties)

	(method (doit)
		(if (not (SetFlag 398))
			(proc63002_7 4600)
		else
			(SetFlag 399)
			(SetFlag 405)
			(= global211 1)
			(= global212 1)
			(proc63002_7 4620)
			(gCurRoom drawPic: 251)
			(therese dispose:)
			(thereseProp dispose:)
			(seaLion init:)
		)
	)
)

(instance seaLion of Feature
	(properties)

	(method (init)
		(if (not (IsFlag 406))
			(super init: gThePlane 1 315 146 325 156)
		)
	)

	(method (handleEvent event)
		(if (and (& (event type:) evMOUSEBUTTON) (not (-- local0)))
			(eggAMatic add: 4203 1 38)
			(gP2SoundFX play: 4203)
			(SetFlag 406)
			(SetFlag 407)
			(self dispose:)
		)
	)
)

