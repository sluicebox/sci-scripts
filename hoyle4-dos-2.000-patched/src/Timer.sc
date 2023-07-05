;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 973)
(include sci.sh)
(use Main)
(use System)

(class Timer of Obj
	(properties
		cycleCnt -1
		seconds -1
		ticks -1
		lastTime -1
		client 0
	)

	(procedure (CueClient &tmp who)
		(= who client)
		(= client 0)
		(if (IsObject who)
			(if (who respondsTo: #timer)
				(who timer: 0)
			)
			(if (who respondsTo: #cue)
				(who cue:)
			)
		)
	)

	(method (new)
		(return
			(if (== self Timer)
				(super new:)
			else
				self
			)
		)
	)

	(method (init caller)
		(= client caller)
		(gTimers add: self)
		(if (caller respondsTo: #timer)
			(if (IsObject (caller timer:))
				((caller timer:) dispose:)
			)
			(caller timer: self)
		)
	)

	(method (doit &tmp theTime)
		(cond
			((!= cycleCnt -1)
				(if (not (-- cycleCnt))
					(CueClient)
				)
			)
			((!= seconds -1)
				(if (!= lastTime (= theTime (GetTime 1))) ; SysTime12
					(= lastTime theTime)
					(if (not (-- seconds))
						(CueClient)
					)
				)
			)
			((> (- gGameTime ticks) 0)
				(CueClient)
			)
		)
	)

	(method (dispose)
		(if (and (IsObject client) (client respondsTo: #timer))
			(client timer: 0)
		)
		(= client 0)
	)

	(method (delete)
		(if (== client 0)
			(gTimers delete: self)
			(super dispose:)
		)
	)

	(method (setCycle caller cycles &tmp aTimer)
		(= aTimer
			(if (& -info- $8000)
				(self new:)
			else
				self
			)
		)
		(aTimer init: caller cycleCnt: cycles)
		(return aTimer)
	)

	(method (set caller sec min hr &tmp aTimer theTicks theSpeed)
		(if (== (= theSpeed 6) 0)
			(= theSpeed 1)
		)
		(= theTicks (/ (* sec 60) theSpeed))
		(if (> argc 2)
			(+= theTicks (/ (* min 3600) theSpeed))
		)
		(if (> argc 3)
			(+= theTicks (* (/ (* hr 3600) theSpeed) 60))
		)
		(= aTimer
			(if (& -info- $8000)
				(self new:)
			else
				self
			)
		)
		(aTimer init: caller cycleCnt: theTicks)
		(return aTimer)
	)

	(method (setReal caller sec min hr &tmp aTimer secs)
		(= secs sec)
		(if (> argc 2)
			(+= secs (* min 60))
		)
		(if (> argc 3)
			(+= secs (* hr 3600))
		)
		(= aTimer
			(if (& -info- $8000)
				(self new:)
			else
				self
			)
		)
		(aTimer init: caller seconds: secs)
		(return aTimer)
	)

	(method (setTicks theTicks caller &tmp aTimer)
		(= aTimer
			(if (& -info- $8000)
				(self new:)
			else
				self
			)
		)
		(aTimer ticks: (+ gGameTime theTicks) init: caller)
		(return aTimer)
	)
)

(class TO of Obj
	(properties
		timeLeft 0
	)

	(method (set cToCount)
		(= timeLeft cToCount)
	)

	(method (doit)
		(if timeLeft
			(-- timeLeft)
		)
	)
)

