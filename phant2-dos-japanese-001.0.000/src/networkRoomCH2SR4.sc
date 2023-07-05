;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3142)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use P2Feature)
(use P2View)
(use System)

(public
	networkRoomCH2SR4 0
)

(local
	[local0 2] = [0 335]
	[local2 2] = [171 335]
	[local4 4] = [278 42 396 246]
)

(instance networkRoomCH2SR4 of P2Room
	(properties
		picture 160
		south 3132
	)

	(method (init)
		(ClearFlag 1001)
		(if (== gPrevRoomNum 3202) ; hiddenStorageRoomCH2
			(littleDoorFeature
				init: [local4 0] [local4 1] [local4 2] [local4 3]
			)
			(if (not (IsFlag 228))
				(gP2SongPlyr fadeIn: 3020)
			else
				(gRoboGary
					setScore: 4 (if (IsFlag 227) 3022 else 3021) 2 8 16 3
					start:
				)
			)
		else
			(boxesHidingDoorView init: [local0 0] [local0 1])
		)
		(super init: &rest)
		(if (== gPrevRoomNum 3202) ; hiddenStorageRoomCH2
			((ScriptID 63000 1) exitScene: 6130) ; sExit
		)
		(gGame handsOn: 1)
	)

	(method (dispose)
		(SetFlag 1001)
		(super dispose: &rest)
	)
)

(instance boxesHidingDoorView of P2View
	(properties
		view 160
		loop 1
		scene 6110
	)

	(method (init)
		(= whoDoit moveBoxesAsideCode)
		(super init: &rest)
	)
)

(instance compHidingDoorView of P2View
	(properties
		view 160
		scene 6120
	)

	(method (init)
		(= whoDoit moveCompAsideCode)
		(super init: &rest)
	)
)

(instance littleDoorFeature of P2Feature
	(properties)

	(method (init)
		(if (super init: &rest)
			(= whoDoit littleDoorCode)
			(self addVerb: 15 14)
		)
	)
)

(instance moveBoxesAsideCode of Code
	(properties)

	(method (doit)
		(compHidingDoorView init: [local2 0] [local2 1])
		(boxesHidingDoorView dispose:)
		((ScriptID 63000 1) exitScene: 6140) ; sExit
	)
)

(instance moveCompAsideCode of Code
	(properties)

	(method (doit)
		(compHidingDoorView dispose:)
		(littleDoorFeature init: [local4 0] [local4 1] [local4 2] [local4 3])
		((ScriptID 63000 1) exitScene: 6130) ; sExit
	)
)

(instance littleDoorCode of Code
	(properties)

	(method (doit)
		(switch gVerb
			(14 ; orderlyKeyI or paulKeyI
				(= global209 6161)
				(gCurRoom newRoom: 3202) ; hiddenStorageRoomCH2
			)
			(15 ; screwdriverI
				(proc63002_7 6210)
			)
			(else
				(if (and (SetFlag 115) (not (SetFlag 31)))
					(proc63002_7 6160)
				else
					(proc63002_7 6150)
				)
			)
		)
	)
)

