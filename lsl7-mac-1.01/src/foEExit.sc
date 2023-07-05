;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64899)
(include sci.sh)
(use Main)
(use PolyPath)
(use Feature)

(public
	foEExit 0
	foWExit 1
	foNExit 2
	foSExit 3
)

(class ExitFeature of Feature
	(properties)

	(method (doVerb &tmp [temp0 2])
		(gEgo
			setMotion:
				PolyPath
				(- gMouseX (plane left:))
				(- gMouseY (plane top:))
				self
		)
	)
)

(class CUExitFeature of Feature
	(properties
		nsLeft 632
		nsTop 288
		nsRight 632
		nsBottom 288
		rExitTo 0
	)

	(method (init &tmp [temp0 4])
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 10)) ; oExitCUCursor
	)

	(method (onMe param1 param2 &tmp temp0 temp1)
		(if (== argc 1)
			(= temp0 (param1 x:))
			(= temp1 (param1 y:))
		else
			(= temp0 param1)
			(= temp1 param2)
		)
		(return
			(not
				(and
					(<= 30 temp0 (- (plane getWidth:) 30))
					(<= 30 temp1 (- (plane getHeight:) 30))
				)
			)
		)
	)

	(method (doVerb)
		(gCurRoom newRoom: rExitTo)
	)
)

(instance foNExit of ExitFeature
	(properties)

	(method (init)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 1)) ; oNorthCursor
		(= nsTop 0)
		(= nsBottom 30)
		(= nsRight (plane right:))
		(= nsLeft 0)
	)

	(method (doVerb)
		(gEgo setMotion: PolyPath (- gMouseX (plane left:)) -20 self)
	)

	(method (cue)
		(gCurRoom newRoom: (gCurRoom north:))
	)
)

(instance foSExit of ExitFeature
	(properties)

	(method (init)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 2)) ; oSouthCursor
		(= nsTop (- (plane bottom:) 30))
		(= nsBottom (plane bottom:))
		(= nsRight (plane right:))
		(= nsLeft 0)
	)

	(method (doVerb)
		(gEgo
			setMotion: PolyPath (- gMouseX (plane left:)) (+ nsBottom 120) self
		)
	)

	(method (cue)
		(gCurRoom newRoom: (gCurRoom south:))
	)
)

(instance foEExit of ExitFeature
	(properties)

	(method (init)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 3)) ; oEastCursor
		(= nsTop 0)
		(= nsBottom (plane bottom:))
		(= nsRight (plane right:))
		(= nsLeft (- (plane right:) 30))
	)

	(method (doVerb)
		(gEgo
			setMotion: PolyPath (+ nsRight 50) (- gMouseY (plane top:)) self
		)
	)

	(method (cue)
		(gCurRoom newRoom: (gCurRoom east:))
	)
)

(instance foWExit of ExitFeature
	(properties)

	(method (init)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 4)) ; oWestCursor
		(= nsTop 0)
		(= nsBottom (plane bottom:))
		(= nsRight 30)
		(= nsLeft 0)
	)

	(method (doVerb)
		(gEgo setMotion: PolyPath -50 (- gMouseY (plane top:)) self)
	)

	(method (cue)
		(gCurRoom newRoom: (gCurRoom west:))
	)
)

