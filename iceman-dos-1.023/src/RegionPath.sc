;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 809)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)

(class RegionPath of MoveTo
	(properties
		completed 1
		currentRoom 0
		value -1
		endType 1
		intermediate 0
		initialized 0
		theRegion 0
		theOldBits 0
	)

	(method (init param1 param2 param3 param4 &tmp temp0)
		(if completed
			(if argc
				(= client param1)
				(if (>= argc 2)
					(= caller param2)
					(if (>= argc 3)
						(= intermediate param3)
						(if (>= argc 4)
							(= endType param4)
						)
					)
				)
			)
			(if (not initialized)
				(self nextRoom: initialized: 1)
				(= theOldBits (client illegalBits:))
			)
			(= completed 0)
			(self next:)
			(super init:)
		)
		(= temp0 (client z:))
		(cond
			((== currentRoom gCurRoomNum)
				(if (>= temp0 1000)
					(client
						z: (- temp0 1000)
						illegalBits: theOldBits
						ignoreActors: 0
					)
				)
			)
			((< temp0 1000)
				(client z: (+ temp0 1000) illegalBits: 0 ignoreActors: 1)
			)
		)
	)

	(method (next)
		(= x (self at: (++ value)))
		(= y (self at: (++ value)))
	)

	(method (nextRoom)
		(self currentRoom: (self at: (+= value 2)) next:)
		(client posn: x y)
	)

	(method (moveDone)
		(= completed 1)
		(if (self atEnd:)
			(self value: -1 initialized: 0)
			(if endType
				(self init:)
			else
				(super moveDone:)
			)
		else
			(if intermediate
				(intermediate cue: (/ value 2))
			)
			(if (== (self at: (+ value 1)) 32767)
				(self nextRoom:)
			)
			(self init:)
		)
	)

	(method (atEnd)
		(return
			(or
				(== (self at: (+ value 1)) -32768)
				(== (self at: (+ value 2)) -32768)
			)
		)
	)

	(method (at)
		(Printf 809 0 name) ; "%s needs an 'at:' method."
		(return 0)
	)

	(method (dispose)
		(if theRegion
			(if (not ((ScriptID theRegion) keep:))
				(super dispose:)
			)
		else
			(Print 809 1 name) ; "%s theRegion: not defined."
		)
	)
)

