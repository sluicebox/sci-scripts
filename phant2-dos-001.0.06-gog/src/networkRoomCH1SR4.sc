;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3141)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use P2Feature)
(use P2View)
(use System)

(public
	networkRoomCH1SR4 0
)

(local
	[local0 2] = [0 335]
	[local2 2] = [171 335]
	[local4 4] = [278 42 396 246]
	local8 = 1
)

(instance networkRoomCH1SR4 of P2Room
	(properties
		picture 160
		south 3131
	)

	(method (init)
		(= local8 (if (ClearFlag 1001) 1 else 0))
		(boxesHidingDoorView init: [local0 0] [local0 1])
		(super init: &rest)
		(gGame handsOn: 1)
	)

	(method (dispose)
		(if local8
			(SetFlag 1001)
		)
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
		(= whoDoit littleDoorCode)
		(super init: &rest)
		(self addVerb: 15)
	)
)

(instance littleDoorCode of Code
	(properties)

	(method (doit)
		(cond
			((== gVerb 15) ; screwdriverI
				(proc63002_7 6210)
			)
			((and (SetFlag 115) (not (SetFlag 31)))
				(proc63002_7 6160)
			)
			(else
				(proc63002_7 6150)
			)
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

