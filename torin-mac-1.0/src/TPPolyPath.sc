;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64026)
(include sci.sh)
(use Main)
(use Array)
(use Motion)

(class TPPolyPath of Motion
	(properties
		value 2
		points 0
		finalX 0
		finalY 0
		obstacles 0
	)

	(method (setDefault)
		(if points
			(points dispose:)
		)
		(= points 0)
		(= value 2)
		(= finalY (= finalX 0))
	)

	(method (newTarget)
		(PrintDebug {TPPolyPath newTarget method not overridden!})
	)

	(method (setArgs)
		(PrintDebug {TPPolyPath setArgs method not overridden!})
	)

	(method (init actor &tmp planeW planeH cp pathData)
		(if argc
			(= client actor)
			(if (>= argc 2)
				(self setDefault:)
				(self setArgs: actor &rest)
			)
			(self newTarget:)
			(= cp (client plane:))
			(= planeW (+ (- (cp right:) (cp left:)) 1))
			(= planeH (+ (- (cp bottom:) (cp top:)) 1))
			(= pathData
				(AvoidPath
					(client x:)
					(client y:)
					finalX
					finalY
					(if obstacles
						obstacles
					else
						(gCurRoom obstacles:)
					)
					planeW
					planeH
					1
				)
			)
			(= value 2)
			(if points
				(points dispose:)
			)
			((= points (IntArray new:)) name: {tpppath.init} copy: pathData)
			(KArray 4 pathData) ; ArrayFree
			(self setTarget:)
		)
		(super init:)
	)

	(method (setTarget &tmp newPoints newX newY theSize planeW planeH cp)
		(if (!= (points at: value) 30583)
			(= x (points at: value))
			(= y (points at: (++ value)))
			(++ value)
			(if (and gAltPolyList (gAltPolyList size:))
				(= cp (client plane:))
				(= planeW (+ (- (cp right:) (cp left:)) 1))
				(= planeH (+ (- (cp bottom:) (cp top:)) 1))
				(= newPoints (IntArray new:))
				(newPoints name: {tpppath.setTarget})
				(newPoints
					copy:
						(AvoidPath
							(client x:)
							(client y:)
							x
							y
							gAltPolyList
							planeW
							planeH
							0
						)
				)
				(= newX (newPoints at: 2))
				(= newY (newPoints at: 3))
				(if (or (!= x newX) (!= y newY))
					(= x newX)
					(= y newY)
					(points at: (+ value 2) 30583)
				)
				(newPoints dispose:)
			)
		)
	)

	(method (doit)
		(if (self onTarget:)
			(self moveDone:)
		else
			(super doit:)
		)
	)

	(method (moveDone)
		(if (!= (points at: value) 30583)
			(self setTarget: init:)
		else
			(super moveDone:)
		)
	)

	(method (dispose)
		(if points
			(points dispose:)
			(= points 0)
		)
		(if obstacles
			(= obstacles 0)
		)
		(super dispose:)
	)
)

