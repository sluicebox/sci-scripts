;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 127)
(include sci.sh)
(use Main)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	runningRats 0
)

(class runningRats of Rgn
	(properties
		rPath1 0
		rPath2 0
		rPath3 0
		curPath 0
		curRatNum 0
		numRats 0
		curRat 0
	)

	(method (init)
		(super init:)
		(ratObj init:)
		(= curRat ratObj)
		(= numRats
			(+ (if rPath1 1 else 0) (if rPath2 1 else 0) (if rPath3 1 else 0))
		)
		(self setScript: runAroundRats)
	)

	(method (dispose)
		(super dispose:)
		(= global136 0)
	)
)

(instance ratObj of Act
	(properties
		x -50
		yStep 6
		view 418
		signal 16384
		illegalBits 0
		xStep 6
	)
)

(instance runAroundRats of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(= global136 0)
	)

	(method (doit &tmp temp0)
		(super doit:)
		(if (client curRatNum:)
			(= temp0 (client curRat:))
			(cond
				((& (temp0 onControl:) $007c)
					(if (!= (temp0 priority:) 1)
						(temp0 setPri: 1)
					)
				)
				((== (temp0 priority:) 1)
					(temp0 setPri: -1)
				)
			)
		)
	)

	(method (changeState newState &tmp temp0)
		(= temp0 (client curRat:))
		(switch (= state newState)
			(0
				(= global136 0)
				(= seconds (Random 40 90))
			)
			(1
				(if (or (IsFlag 181) (gEgo script:))
					(= seconds 4)
					(-- state)
				else
					(= cycles 2)
				)
			)
			(2
				(= global136 1)
				(gRegMusic stop: number: 66 loop: -1 play:)
				(client curRatNum: (Random 1 (client numRats:)))
				(client
					curPath:
						(switch (client curRatNum:)
							(1
								(client rPath1:)
							)
							(2
								(client rPath2:)
							)
							(3
								(client rPath3:)
							)
						)
				)
				((client curPath:) index: -1)
				(temp0
					posn: ((client curPath:) at: 0) ((client curPath:) at: 1)
					setCycle: Walk
					setMotion: (client curPath:) self
				)
			)
			(3
				(client curRatNum: 0)
				(temp0 setCycle: 0 stopUpd:)
				(self changeState: 0)
			)
		)
	)
)

