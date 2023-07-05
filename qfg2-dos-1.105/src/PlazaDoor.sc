;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 90)
(include sci.sh)
(use Main)
(use n001)
(use n002)
(use HandsOffScript)
(use TargActor)
(use Motion)
(use System)

(class PlazaDoor of TargActor
	(properties
		entranceTo 0
		exitDir 0
		openSnd 0
		closeSnd 0
		doorControl 16
		state 0
		xOut 0
		yOut 0
		xIn 0
		yIn 0
		savePri 0
		barred 0
	)

	(method (init)
		(if (not (<= 0 gTimeODay 4))
			(= palette 2)
		)
		(if (== gPrevRoomNum entranceTo)
			(= state 2)
			(= cel (self lastCel:))
		else
			(= cel (= state 0))
		)
		(super init:)
		(self ignoreActors:)
		(if (== gPrevRoomNum entranceTo)
			(self enter:)
		)
	)

	(method (isLocked)
		(return gNight)
	)

	(method (openMe)
		(if (TrySkill 19 75) ; openSpell
			(if (not barred)
				(self open:)
				(return 1)
			else
				(HighPrint 90 0) ; "The door is barred and your magic has no effect."
			)
		else
			(HighPrint 90 1) ; "The door's lock is too strong for your magic."
		)
	)

	(method (enter)
		(self setScript: (enterDoor new:) gCurRoom)
	)

	(method (doit)
		(super doit:)
		(if
			(and
				(& (gEgo onControl: 1) doorControl)
				(or (!= cel 0) (not (self isLocked:)))
				(not script)
				(not (gEgo script:))
				(not (gCurRoom script:))
			)
			(self setScript: (exitDoor new:))
		)
	)

	(method (closeEnough)
		(return (< (gEgo distanceTo: self) 50))
	)

	(method (open caller &tmp theCaller)
		(= gPlazaDoorOpen 1)
		(= theCaller (if argc caller else self))
		(if (and (!= state 3) (!= state 2))
			(= state 3)
			(self setCycle: End theCaller)
			(if openSnd
				(openSnd doit:)
			)
		else
			(theCaller cue:)
		)
	)

	(method (close caller &tmp theCaller)
		(= gPlazaDoorOpen 0)
		(= theCaller (if argc caller else self))
		(if (and (!= state 1) (!= state 0))
			(= state 1)
			(self setCycle: Beg theCaller)
			(if closeSnd
				(closeSnd doit:)
			)
		else
			(theCaller cue:)
		)
	)

	(method (cue)
		(super cue:)
		(self stopUpd:)
		(= state (if (== state 1) 0 else 2))
	)

	(method (handleEvent event)
		(cond
			((Said 'close,close[/door]')
				(HighPrint 90 2) ; "Don't worry about closing the door."
			)
			((Said 'open,open[/door]')
				(cond
					((or (== state 3) (== state 2))
						(HighPrint 90 3) ; "The door is already open."
					)
					((self isLocked:)
						(HighPrint 90 4) ; "The door is locked."
					)
					(else
						(HighPrint 90 5) ; "Just walk over to the door."
					)
				)
			)
			(
				(or
					(Said 'lockpick[/lock]')
					(Said 'use/(lockpick[<lock]),lockpick')
					(Said 'unlock')
				)
				(cond
					((not (self isLocked:))
						(HighPrint 90 6) ; "The door is not locked."
					)
					((not (CanPickLocks 1)))
					((<= 0 gTimeODay 4)
						(HighPrint 90 7) ; "You daren't try to pick the lock in broad daylight!"
					)
					((not (self closeEnough:))
						(HighPrint 90 8) ; "You aren't close enough."
					)
					(else
						(self setScript: pickLock)
					)
				)
			)
			(else
				(super handleEvent: event)
			)
		)
	)
)

(instance enterDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gCurRoom inOut: 1)
				(client savePri: (client priority:))
				(client setPri: 2)
				(gEgo
					setPri: 3
					illegalBits: 0
					posn: (client xOut:) (client yOut:)
					setMotion: MoveTo (client xIn:) (client yIn:) self
				)
			)
			(1
				(gEgo setPri: -1)
				(client setPri: (client savePri:) close:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance exitDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(client open:)
			)
			(1
				(client setPri: 2)
				(gEgo
					setPri: 3
					illegalBits: 0
					setMotion: MoveTo (client xOut:) (client yOut:) self
				)
			)
			(2
				(= gRoomExitDir (client exitDir:))
				(gCurRoom newRoom: (client entranceTo:))
				(HandsOn)
			)
		)
	)
)

(instance pickLock of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					setMotion:
						MoveTo
						(+
							(client xIn:)
							(* (if (< (client x:) 160) -1 else 1) 10)
						)
						(+ (client yIn:) 3)
						self
				)
			)
			(1
				(gEgo
					view: 47
					loop: (+ 4 (< (client x:) 160))
					cel: 0
					setCycle: End self
				)
				(SetFlag 117)
			)
			(2
				(= cycles 20)
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(= cycles 10)
			)
			(5
				(NormalEgo)
				(gEgo loop: (if (< (client x:) 160) 7 else 6))
				(ClearFlag 117)
				(if (PickLock 100 1 1)
					(if (client barred:)
						(HighPrint 90 9) ; "This door appears to be barred from the inside. Picking the lock will not help you enter."
						(self dispose:)
					else
						(client open: self)
					)
				else
					(self dispose:)
				)
			)
			(6
				(= cycles 10)
			)
			(7
				(client setScript: exitDoor)
			)
		)
	)
)

