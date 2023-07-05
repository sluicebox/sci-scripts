;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3212)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use ExitFeature)

(public
	hiddenStorageRoomCH2SR1 0
)

(local
	[local0 4] = [244 0 406 268]
	[local4 4] = [72 40 557 270]
)

(instance hiddenStorageRoomCH2SR1 of CloseupRoom
	(properties
		picture 390
		exitRoom 3202
	)

	(method (init)
		(super init: &rest)
		(drawerFeature init: [local0 0] [local0 1] [local0 2] [local0 3])
		(gGame handsOn: 1)
	)

	(method (dispose)
		(SetFlag 1001)
		(super dispose: &rest)
	)
)

(instance drawerFeature of ExitFeature
	(properties
		scene 6950
	)

	(method (handleEvent)
		(if (and (super handleEvent: &rest) (== scene 6950))
			(target setRect: [local4 0] [local4 1] [local4 2] [local4 3])
			(gCurRoom drawPic: 391)
			(= scene 0)
			(= exitScene 6960)
			(= nextRoom 3202)
			(= invItem 12)
			((ScriptID 63000 0) dispose:) ; nExit
			((ScriptID 63000 2) dispose:) ; eExit
			((ScriptID 63000 1) dispose:) ; sExit
			((ScriptID 63000 3) dispose:) ; wExit
			(SetFlag 250)
			(ClearFlag 1001)
		)
	)
)

