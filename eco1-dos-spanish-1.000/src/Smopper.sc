;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 812)
(include sci.sh)
(use Main)
(use PRunAway)
(use PChase)
(use Motion)

(public
	Smopper 0
)

(class Smopper of Cycle
	(properties
		vInMotion 0
		vStopped 0
		vSlow 0
		vStart 0
		stopState 0
		useSlow 0
		cSpeed 0
		oldSpeed 0
		newCel 0
		tempMover 0
	)

	(method (init param1 param2 param3 param4 param5 param6)
		(= stopState 4)
		(= useSlow (= cycleCnt (= vSlow (= vStart (= vStopped (= caller 0))))))
		(= cSpeed ((= client param1) cycleSpeed:))
		(= oldSpeed ((= client param1) cycleSpeed:))
		(if argc
			(= vInMotion ((= client param1) view:))
			(if (>= argc 2)
				(= vStopped param2)
				(if (>= argc 3)
					(= vSlow param3)
					(if (>= argc 4)
						(if (== param4 0)
							(= useSlow 1)
							(= vStart vSlow)
						else
							(= vStart param4)
						)
						(if (>= argc 5)
							(if (!= param5 -1)
								(= cSpeed param5)
							)
							(if (>= argc 6)
								(= caller param6)
							)
						)
					else
						(= useSlow 1)
						(= vStart vSlow)
					)
				)
			)
		)
		(super init: client)
	)

	(method (dispose)
		(client cycleSpeed: oldSpeed)
		(if (!= (client view:) vInMotion)
			(client view: vInMotion)
		)
		(super dispose:)
	)

	(method (nextCel &tmp temp0)
		(= temp0 (client lastCel:))
		(if (< (Abs (- gGameTime cycleCnt)) (client cycleSpeed:))
			(return (client cel:))
		else
			(= cycleCnt gGameTime)
			(return (+ (client cel:) cycleDir))
		)
	)

	(method (doit &tmp temp0 temp1)
		(cond
			((client isStopped:)
				(if (== (client view:) vInMotion)
					(cond
						((and vSlow (!= (client view:) vSlow))
							(= stopState 1)
						)
						((and (not vSlow) (!= (client view:) vStopped))
							(= stopState 3)
						)
						(else
							(= stopState 4)
						)
					)
					(if
						(and
							(= temp1 (client mover:))
							(not (temp1 completed:))
							(not (temp1 isKindOf: PRunAway))
							(not (temp1 isKindOf: PFollow))
						)
						(client setMotion: 0)
					)
				)
			)
			((== (client view:) vStopped)
				(cond
					(vStart
						(= stopState 5)
					)
					((!= stopState 0)
						(= stopState 7)
					)
				)
			)
			((and (== (client view:) vSlow) (not useSlow))
				(= stopState 5)
			)
		)
		(switch stopState
			(0
				(= cycleDir 1)
				(= newCel (self nextCel:))
				(if (> newCel (client lastCel:))
					(= newCel 0)
				)
				(client setCel: newCel)
			)
			(1
				(= cycleDir 1)
				(if (not vSlow)
					(client view: vStopped)
					(= stopState 3)
				else
					(= stopState 2)
					(if (== (client view:) vInMotion)
						(= newCel 0)
						(client setCel: 0)
					)
					(client cycleSpeed: cSpeed view: vSlow)
				)
			)
			(2
				(client cycleSpeed: cSpeed)
				(client setCel: newCel forceUpd:)
				(= newCel (self nextCel:))
				(if (> newCel (client lastCel:))
					(= newCel 0)
					(= stopState 3)
				)
			)
			(3
				(client cycleSpeed: cSpeed)
				(= stopState 4)
				(= cycleDir 1)
				(client view: vStopped cel: 0)
				(if caller
					(caller cue: 0)
				)
			)
			(4
				(client cycleSpeed: cSpeed)
				(if (client lastCel:)
					(= newCel (self nextCel:))
					(if (> newCel (client lastCel:))
						(= newCel 0)
					)
					(client setCel: newCel)
				else
					0
				)
			)
			(5
				(if caller
					(caller cue: 1)
				)
				(if (not vStart)
					(client view: vInMotion)
					(= stopState 7)
				else
					(= stopState 6)
					(if useSlow
						(if (== (client view:) vStopped)
							(client setCel: (client lastCel:))
							(= newCel (client lastCel:))
						)
						(client cycleSpeed: cSpeed view: vSlow)
						(= cycleDir -1)
					else
						(if (== (client view:) vStopped)
							(client setCel: 0)
						)
						(client cycleSpeed: cSpeed view: vStart)
						(= cycleDir 1)
					)
				)
			)
			(6
				(client cycleSpeed: cSpeed)
				(if useSlow
					(if (not newCel)
						(= stopState 7)
					else
						(client setCel: newCel)
					)
					(= newCel (self nextCel:))
				else
					(= newCel (self nextCel:))
					(if (> newCel (client lastCel:))
						(= stopState 7)
					else
						(client setCel: newCel)
					)
				)
			)
			(7
				(= stopState 0)
				(= cycleDir 1)
				(client cycleSpeed: oldSpeed view: vInMotion cel: 0)
			)
		)
	)
)

