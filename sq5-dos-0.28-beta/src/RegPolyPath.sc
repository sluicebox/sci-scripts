;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 77)
(include sci.sh)
(use Main)
(use Print)
(use PAvoider)
(use PolyPath)
(use Motion)
(use System)

(class RegPolyPath of Code
	(properties
		index 0
		currentRoom 0
		caller 0
		endType 0
		client 0
		theRegion 0
		obstacles 0
		lastIndex 0
	)

	(method (cue &tmp temp0)
		(cond
			((== (= temp0 (self nextValue:)) 32767)
				(self changeRoom:)
			)
			((== temp0 -32768)
				(switch endType
					(0
						(if (IsObject caller)
							(caller cue:)
						)
						(self dispose:)
					)
					(1
						(= index 0)
						(self cue:)
					)
				)
			)
			(else
				(-- index)
				(self init:)
			)
		)
	)

	(method (changeRoom &tmp temp0)
		(= currentRoom (self nextValue:))
		(client x: (self nextValue:) y: (self nextValue:))
		(self init:)
	)

	(method (nextValue)
		(self at: (- (++ index) 1))
	)

	(method (init param1 param2)
		(if argc
			(= client param1)
			(if (> argc 1)
				(= caller param2)
			else
				(= caller 0)
			)
			(= index lastIndex)
			(self doit:)
			(self cue:)
		else
			(= lastIndex index)
			(if (not (OneOf (self at: lastIndex) 32767 -32768))
				(if (== currentRoom gCurRoomNum)
					(if obstacles
						(client
							setMotion:
								PolyPath
								(self nextValue:)
								(self nextValue:)
								self
								1
						)
					else
						(client
							setMotion:
								PolyPath
								(self nextValue:)
								(self nextValue:)
								self
						)
					)
				else
					(client
						setMotion:
							MoveTo
							(self nextValue:)
							(self nextValue:)
							self
					)
				)
			)
			(client setStep:)
		)
	)

	(method (at &tmp [temp0 30])
		(Printf @temp0 {%s needs an 'at:' method.} name)
		(return 0)
	)

	(method (doit)
		(cond
			(
				(and
					(& (client signal:) $0080)
					(== gCurRoomNum currentRoom)
					(== (gCurRoom curPic:) (gCurRoom picture:))
				)
				(client show: ignoreActors: 0 setAvoider: PAvoider setStep:)
			)
			((and (not (& (client signal:) $0080)) (!= gCurRoomNum currentRoom))
				(client hide: ignoreActors: 1 setAvoider: 0)
			)
		)
	)

	(method (dispose &tmp [temp0 20])
		(if theRegion
			(if (not ((ScriptID theRegion) keep:))
				((client mover:) dispose:)
			)
		else
			(Printf @temp0 {%s theRegion: not defined.} name)
		)
	)
)

