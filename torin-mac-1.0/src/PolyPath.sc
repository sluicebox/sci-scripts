;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64945)
(include sci.sh)
(use Main)
(use Array)
(use Motion)

(class PolyPath of Motion
	(properties
		value 2
		points 0
		finalX 0
		finalY 0
		obstacles 0
	)

	(method (init actor theX theY whoCares opt obstList &tmp [buffer 30] planeW planeH cp pathData)
		(if argc
			(= client actor)
			(if (> argc 1)
				(cond
					((>= argc 6)
						(= obstacles obstList)
					)
					((not obstacles)
						(= obstacles (gCurRoom obstacles:))
					)
				)
				(if points
					(points dispose:)
				)
				(= cp (client plane:))
				(= planeW (+ (- (cp right:) (cp left:)) 1))
				(= planeH (+ (- (cp bottom:) (cp top:)) 1))
				(= pathData
					(AvoidPath
						(actor x:)
						(actor y:)
						(= finalX theX)
						(= finalY theY)
						obstacles
						planeW
						planeH
						(if (>= argc 5) opt else 1)
					)
				)
				((= points (IntArray new:)) copy: pathData)
				(KArray 4 pathData) ; ArrayFree
				(if (> argc 3)
					(= caller whoCares)
				)
			)
			(self setTarget:)
		)
		(super init:)
	)

	(method (dispose)
		(if points
			(points dispose:)
		)
		(= points 0)
		(super dispose:)
	)

	(method (setTarget &tmp newPoints newX newY theSize planeW planeH cp)
		(if (!= (points at: value) 30583)
			(= x (points at: value))
			(= y (points at: (++ value)))
			(++ value)
			(= cp (client plane:))
			(= planeW (+ (- (cp right:) (cp left:)) 1))
			(= planeH (+ (- (cp bottom:) (cp top:)) 1))
			(if (and gAltPolyList (gAltPolyList size:))
				(= newPoints (IntArray new:))
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

	(method (moveDone)
		(if (== (points at: value) 30583)
			(super moveDone:)
		else
			(self setTarget: init:)
		)
	)
)

