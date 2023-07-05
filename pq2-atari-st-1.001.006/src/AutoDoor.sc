;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 301)
(include sci.sh)
(use Main)
(use Motion)
(use Actor)

(class AutoDoor of Prop
	(properties
		doorControl 16384
		entranceTo 0
		facingLoop 0
		locked 0
		openSnd 0
		closeSnd 0
		doorState 0
		code 0
		illegalBits 0
	)

	(method (init)
		(= doorState (if (== gPrevRoomNum entranceTo) 2 else 0))
		(= cel
			(if (== doorState 0)
				0
			else
				(- (NumCels self) 1)
			)
		)
		(super init:)
		(self stopUpd: ignoreActors:)
	)

	(method (doit)
		(super doit:)
		(cond
			(code
				(if (code doit: self)
					(self open:)
				else
					(self close:)
				)
			)
			(
				(and
					(== (gEgo onControl: 1) doorControl)
					(or (== facingLoop -1) (== (gEgo loop:) facingLoop))
				)
				(self open:)
			)
			(else
				(self close:)
			)
		)
	)

	(method (open)
		(if (and (not locked) (!= doorState 3) (!= doorState 2))
			(= doorState 3)
			(self setCycle: End self startUpd:)
			(if openSnd
				(openSnd doit:)
			)
		)
	)

	(method (close)
		(if (and (!= doorState 1) (!= doorState 0))
			(= doorState 1)
			(self setCycle: Beg self startUpd:)
			(if closeSnd
				(closeSnd doit:)
			)
		)
	)

	(method (cue)
		(self stopUpd:)
		(= doorState (if (== doorState 1) 0 else 2))
	)
)

