;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 945)
(include sci.sh)
(use Main)
(use Motion)
(use System)

(class PolyPath of Motion
	(properties
		value 2
		points 0
		finalX 0
		finalY 0
		obstacles 0
	)

	(method (init actor theX theY whoCares opt obstList &tmp [buffer 30])
		(if argc
			(= client actor)
			(if (> argc 1)
				(cond
					((>= argc 6)
						(= obstacles obstList)
					)
					((not (IsObject obstacles))
						(= obstacles (gCurRoom obstacles:))
					)
				)
				(if points
					(Memory memFREE points)
				)
				(= points
					(AvoidPath
						(actor x:)
						(actor y:)
						(= finalX theX)
						(= finalY theY)
						(and obstacles (obstacles elements:))
						(and obstacles (obstacles size:))
						(if (>= argc 5) opt else 1)
					)
				)
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
			(Memory memFREE points)
		)
		(= points 0)
		(super dispose:)
	)

	(method (setTarget &tmp newPoints newX newY theSize [buffer 30])
		(if (!= (WordAt points value) 30583)
			(= x (WordAt points value))
			(= y (WordAt points (++ value)))
			(++ value)
			(if (and (IsObject global95) (= theSize (global95 size:)))
				(= newPoints
					(AvoidPath
						(client x:)
						(client y:)
						x
						y
						(global95 elements:)
						theSize
						0
					)
				)
				(= newX (WordAt newPoints 2))
				(= newY (WordAt newPoints 3))
				(if (or (!= x newX) (!= y newY))
					(= x newX)
					(= y newY)
					(Memory memPOKE (+ points value 2) 30583)
				)
				(Memory memFREE newPoints)
			)
		)
	)

	(method (moveDone)
		(if (== (WordAt points value) 30583)
			(super moveDone:)
		else
			(self setTarget: init:)
		)
	)
)

