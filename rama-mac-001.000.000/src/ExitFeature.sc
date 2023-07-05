;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 60)
(include sci.sh)
(use Main)
(use Feature)
(use Actor)

(public
	ExitFeature 0
)

(class ExitFeature of Feature
	(properties
		nsLeft 88
		nsTop 42
		nsRight 531
		nsBottom 282
		nextRoom 0
		exitCursor 0
		verb 2
		exitVMD 0
		detailLevel 1
		exitStyle 0
	)

	(method (init param1 param2 param3 param4)
		(if argc
			(= exitVMD param1)
		)
		(cond
			((> argc 1)
				(= exitCursor param2)
				(if (== argc 3)
					(if exitCursor
						(exitCursor dispose:)
					)
					((= exitCursor (View new:))
						view: param2
						loop: param3
						cel: param4
					)
				)
			)
			((not exitCursor)
				(= exitCursor defaultExitView)
			)
		)
		(= plane global116)
		(super init: &rest)
		(self setHotspot: 9)
		((plane extMH:) delete: self)
		((plane extMH:) addToEnd: self)
		((plane theFtrs:) delete: self)
		((plane theFtrs:) addToEnd: self)
	)

	(method (dispose)
		(super dispose:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(gTheCursor setDirCursor: exitCursor)
			)
			(else
				(if gVMDMovie
					(gVMDMovie mouseDownAction: 1)
				)
				(if (and exitVMD (<= (gGame _detailLevel:) detailLevel))
					(exitVMD play:)
				)
				(gCurRoom exitStyle: exitStyle newRoom: nextRoom)
			)
		)
	)

	(method (enable)
		(self setHotspot: 9)
	)

	(method (disable)
		(self deleteHotspot:)
	)
)

(instance defaultExitView of View
	(properties
		view 600
		cel 6
	)
)

