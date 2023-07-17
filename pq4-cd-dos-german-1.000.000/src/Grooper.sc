;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64977)
(include sci.sh)
(use Main)
(use Array)
(use Sight)
(use Motion)
(use System)

(class Grooper of Code
	(properties
		client 0
		oldCycler 0
		oldMover 0
		caller 0
		numLoops 4
		angles 0
		devAngles 0
		trans 0
		frontLoop 0
		backLoop 0
	)

	(method (init param1 &tmp temp0)
		(= angles (IntArray newWith: 8 90 270 180 0 115 245 60 300))
		(= devAngles (IntArray newWith: 8 10 10 50 40 15 15 20 20))
		(= trans (IntArray newWith: 8 0 1 2 3 4 5 6 7))
		(= frontLoop (IntArray newWith: 8 4 7 5 6 2 1 0 3))
		(= backLoop (IntArray newWith: 8 6 5 4 7 0 2 3 1))
		(= client param1)
		(= numLoops (if (> (- (NumLoops client) 1) 5) 8 else 4))
	)

	(method (doit c h whoCares dontGroop &tmp temp0 temp1 temp2)
		(if (>= argc 3)
			(= caller whoCares)
		)
		(if
			(or
				(& (client signal:) $0800)
				(and
					(client cycler:)
					(not ((client cycler:) isKindOf: StopWalk))
					(not ((client cycler:) isKindOf: Grycler))
				)
			)
			(if caller
				(caller cue:)
				(= caller 0)
			)
			(return)
		)
		(if (or (not (gCast contains: client)) (and (>= argc 4) dontGroop))
			(= temp2 (client heading:))
			(if (== numLoops 4)
				(= temp1
					(cond
						((< 44 temp2 135) 0)
						((< 225 temp2 315) 1)
						((< 134 temp2 226) 2)
						((or (> temp2 314) (< temp2 45)) 3)
					)
				)
			else
				(= temp1
					(cond
						((< 68 temp2 113) 0)
						((< 247 temp2 293) 1)
						((< 157 temp2 203) 2)
						((or (> temp2 337) (< temp2 23)) 3)
						((< 112 temp2 158) 4)
						((< 202 temp2 248) 5)
						((< 22 temp2 68) 6)
						((< 292 temp2 338) 7)
					)
				)
			)
			(client loop: (trans at: temp1))
			(if (= scratch (client cycler:))
				(scratch clientLastCel: (client lastCel:))
			)
			(if caller
				(caller cue:)
			)
			(= caller 0)
			(return)
		)
		(cond
			((not oldCycler)
				(= oldCycler (client cycler:))
				(client cycler: 0)
			)
			((and (client cycler:) ((client cycler:) isMemberOf: Grycler))
				(client setCycle: 0)
			)
		)
		(cond
			((not oldMover)
				(= oldMover (client mover:))
				(client mover: 0)
			)
			((client mover:)
				(oldMover dispose:)
				(= oldMover (client mover:))
				(client mover: 0)
			)
		)
		(if oldCycler
			(if
				(and
					(== (oldCycler vStopped:) -1)
					(== (client loop:) (- (NumLoops client) 1))
				)
				(= temp0 (client cel:))
			else
				(= temp0 (client loop:))
			)
		else
			(= temp0 (client loop:))
		)
		(client setCycle: Grycler self temp0 numLoops)
	)

	(method (cue &tmp oldCaller)
		(if (client cycler:)
			((client cycler:) dispose:)
			(client cycler: 0)
		)
		(if (not (client mover:))
			(client mover: oldMover)
		)
		(if oldCycler
			(client cycler: oldCycler)
		)
		(= oldCaller caller)
		(= caller (= oldMover (= oldCycler 0)))
		(if oldCaller
			(oldCaller cue: &rest)
		)
	)

	(method (dispose)
		(angles dispose:)
		(devAngles dispose:)
		(trans dispose:)
		(frontLoop dispose:)
		(backLoop dispose:)
		(if oldMover
			(oldMover dispose:)
			(= oldMover 0)
		)
		(if oldCycler
			(oldCycler dispose:)
			(= oldCycler 0)
		)
		(if client
			(client looper: 0)
		)
		(super dispose: &rest)
	)
)

(class Grycler of Cycle
	(properties
		loopIndex 0
		numLoops 0
	)

	(method (init param1 param2 param3 param4 &tmp [temp0 12])
		(= cycleCnt gGameTime)
		(= completed 0)
		(= client param1)
		(= caller param2)
		(= numLoops param4)
		(= clientLastCel (client lastCel:))
		(= cycleDir
			(sign
				(AngleDiff
					(param1 heading:)
					(((client looper:) angles:) at: param3)
				)
			)
		)
		(= loopIndex param3)
		(if (self loopIsCorrect:)
			(self cycleDone:)
		)
	)

	(method (doit)
		(self nextCel:)
		(if (self loopIsCorrect:)
			(self cycleDone:)
		)
	)

	(method (cycleDone)
		(caller cue:)
	)

	(method (loopIsCorrect &tmp temp0)
		(return
			(<=
				(Abs
					(AngleDiff
						(((client looper:) angles:) at: loopIndex)
						(client heading:)
					)
				)
				(((client looper:) devAngles:) at: loopIndex)
			)
		)
	)

	(method (nextCel &tmp temp0 temp1 temp2)
		(= temp1 (client loop:))
		(if (>= (Abs (- gGameTime cycleCnt)) (client cycleSpeed:))
			(= cycleCnt gGameTime)
			(client cel: 0)
			(if (< cycleDir 0)
				(= loopIndex (((client looper:) backLoop:) at: loopIndex))
			else
				(= loopIndex (((client looper:) frontLoop:) at: loopIndex))
			)
			(client loop: (((client looper:) trans:) at: loopIndex))
			(= clientLastCel (client lastCel:))
			(if (!= (client loop:) temp1)
				(client cel: 0)
			)
		)
	)
)

(class StopWalk of Fwd
	(properties
		vWalking 0
		vStopped -1
		oldView 0
		oldLoop 0
		numLoops 4
	)

	(method (init param1 param2 &tmp temp0)
		(if argc
			(= vWalking ((= client param1) view:))
			(if (>= argc 2)
				(= vStopped param2)
			)
		)
		(= numLoops (if (> (- (NumLoops client) 1) 5) 8 else 4))
		(if (!= vStopped -1)
			(Load rsVIEW vStopped)
		)
		(super init: client)
		(self doit:)
	)

	(method (dispose)
		(if (== (client view:) vStopped)
			(client view: vWalking)
		)
		(super dispose:)
	)

	(method (doit &tmp [temp0 3] temp3)
		(if (client isStopped:)
			(= temp3 (client loop:))
			(cond
				((== vStopped -1)
					(if (!= (client loop:) (- (NumLoops client) 1))
						(client loop: (- (NumLoops client) 1) cel: temp3)
					)
				)
				((!= (client view:) vStopped)
					(client view: vStopped loop: temp3 cel: 0)
				)
			)
			(= clientLastCel (client lastCel:))
		else
			(cond
				((== vStopped -1)
					(if (== (client loop:) (- (NumLoops client) 1))
						(client loop: (client cel:))
					)
				)
				((== (client view:) vStopped)
					(client view: vWalking)
				)
			)
			(= clientLastCel (client lastCel:))
			(super doit:)
		)
	)
)

