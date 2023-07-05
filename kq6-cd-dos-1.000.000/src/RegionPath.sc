;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 918)
(include sci.sh)
(use Main)
(use Print)
(use Motion)

(class RegionPath of MoveTo
	(properties
		completed 1
		currentRoom 0
		value -1
		endType 1
		intermediate 0
		initialized 0
		savedOldStuff 0
		theRegion 0
		theOldBits 0
		theOldSignal 0
	)

	(method (init param1 param2 param3)
		(if (>= argc 4)
			(= value -1)
			(= initialized 0)
			(= completed 1)
		)
		(if completed
			(if argc
				(= client param1)
				(if (>= argc 2)
					(= caller param2)
					(if (>= argc 3)
						(= intermediate param3)
					)
				)
			)
			(if (not initialized)
				(if (not savedOldStuff)
					(= theOldBits (client illegalBits:))
					(= theOldSignal (client signal:))
					(= savedOldStuff 1)
				)
				(if (& endType $0002)
					(self findPathend: next:)
					(client posn: x y)
				else
					(self value: 0 nextRoom:)
				)
				(= initialized 1)
				(client illegalBits: 0 ignoreActors: ignoreHorizon:)
			)
			(= completed 0)
			(self next:)
		)
		(super init:)
		(self curRoomCheck:)
	)

	(method (curRoomCheck &tmp temp0)
		(= temp0 (client z:))
		(if (== currentRoom gCurRoomNum)
			(client
				z:
					(if (>= temp0 1000)
						(- temp0 1000)
					else
						temp0
					)
				illegalBits: theOldBits
				signal: theOldSignal
			)
		else
			(client
				z:
					(if (< temp0 1000)
						(+ temp0 1000)
					else
						temp0
					)
				illegalBits: 0
				ignoreActors: 1
				ignoreHorizon:
			)
		)
	)

	(method (next)
		(= x (self at: (self nextValue: 1)))
		(= y (self at: (+ value 1)))
	)

	(method (nextRoom)
		(if (& endType $0002)
			(self findPrevroom:)
		else
			(= currentRoom (self at: (+ value 1)))
		)
		(self next: curRoomCheck:)
		(client posn: x y)
	)

	(method (moveDone)
		(= completed 1)
		(if (self atEnd:)
			(self value: -1 initialized: 0)
			(if (& endType $0001)
				(self init:)
			else
				(super moveDone:)
			)
		else
			(if intermediate
				(intermediate cue: (/ value 2))
			)
			(if (== (self at: (self nextValue:)) 32767)
				(self next: nextRoom:)
			)
			(self init:)
		)
	)

	(method (atEnd)
		(return
			(or
				(and (& endType $0002) (<= (- value 2) 0))
				(== (self at: (+ value 2)) -32768)
			)
		)
	)

	(method (at)
		(Printf {%s needs an 'at:' method.} name)
		(return 0)
	)

	(method (dispose)
		(if theRegion
			(if (not ((ScriptID theRegion) keep:))
				(super dispose:)
			)
		else
			(Printf {%s theRegion: not defined.} name)
		)
	)

	(method (nextValue &tmp temp0)
		(= temp0 (- (* (not (& endType $0002)) 4) 2))
		(if argc
			(return (+= value temp0))
		else
			(return (+ value temp0))
		)
	)

	(method (findPathend)
		(for ((= value 0)) (!= (self at: value) -32768) ((++ value))
			(if (== (self at: value) 32767)
				(= currentRoom (self at: (+ value 1)))
			)
		)
	)

	(method (findPrevroom &tmp temp0)
		(for ((= temp0 0)) (< temp0 value) ((++ temp0))
			(if (== (self at: temp0) 32767)
				(= currentRoom (self at: (+ temp0 1)))
			)
		)
	)
)

