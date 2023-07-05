;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Actor)

(class Door of Prop
	(properties
		cycleSpeed 1
		entranceTo -1
		locked 0
		openSnd 0
		closeSnd 0
		doorState 0
		doorCtrl 2
		doorBlock 16384
		roomCtrl 4
		code 0
		illegalBits 0
		force 0
		notify 0
		msgLook {Yep; it's a door.}
		msgLookLock {And... it's locked.}
		msgLocked {This door is locked.}
		msgExcept {...except it's locked!}
		msgFunny {Funny. No response.}
		msgCloser {Just walk near it.}
	)

	(method (init)
		(if (== gPrevRoomNum entranceTo)
			(= doorState 2)
		)
		(if (== doorState 0)
			(= cel 0)
			(gEgo observeControl: doorBlock)
		else
			(= cel (- (NumCels self) 1))
			(= locked 0)
			(gEgo ignoreControl: doorBlock)
		)
		(super init:)
		(self stopUpd: ignoreActors:)
	)

	(method (doit)
		(super doit:)
		(if (and (> roomCtrl 0) (& (gEgo onControl:) roomCtrl))
			(gCurRoom newRoom: entranceTo)
		)
	)

	(method (handleEvent event)
		(if
			(or
				(!= (event type:) evSAID)
				(== gCurRoomNum 33)
				(== gCurRoomNum 15)
				(event claimed:)
			)
			(return)
		)
		(cond
			((Said 'open/door')
				(self open:)
			)
			((Said 'close/door')
				(self close:)
			)
			((Said 'look/door')
				(Print msgLook)
				(if locked
					(Print msgLookLock)
				)
			)
			((Said 'bang/door')
				(Print msgFunny)
			)
		)
	)

	(method (open)
		(cond
			((and (not force) (!= (gEgo onControl: 1) doorCtrl))
				(NotClose) ; "You're not close enough."
			)
			(locked
				(Print msgLocked)
			)
			((or (== doorState 1) (== doorState 2))
				(ItIs) ; "It is."
			)
			(else
				(= doorState 1)
				(self setCycle: End self)
				(if openSnd
					(openSnd doit:)
				)
			)
		)
	)

	(method (close)
		(cond
			((and (not force) (!= (gEgo onControl: 1) doorCtrl))
				(NotClose) ; "You're not close enough."
			)
			(locked
				(Print msgLocked)
			)
			((or (== doorState 3) (== doorState 0))
				(ItIs) ; "It is."
			)
			((& (gEgo onControl:) doorBlock)
				(if (> gFilthLevel 4)
					(Print 3 0) ; "Get your fat ass out of the doorway first."
				else
					(Print 3 1) ; "Please move out of the doorway first."
				)
			)
			(else
				(= doorState 3)
				(self setCycle: Beg self)
				(if closeSnd
					(closeSnd doit:)
				)
			)
		)
	)

	(method (cue)
		(= doorState (if (== doorState 3) 0 else 2))
		(if (== doorState 2)
			(gEgo ignoreControl: doorBlock)
		else
			(gEgo observeControl: doorBlock)
		)
		(self stopUpd:)
		(if notify
			(notify cue:)
			(= notify 0)
		)
	)
)

(class AutoDoor of Door
	(properties
		msgLook {Yep; it's a door.}
		msgLookLock {And... it's locked.}
		msgLocked {This door is locked.}
		msgExcept {...except it's locked!}
		msgFunny {Funny. No response.}
		msgCloser {Just walk near it.}
	)

	(method (init)
		(super init:)
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
			((& (gEgo onControl:) doorCtrl)
				(self open:)
			)
			(else
				(self close:)
			)
		)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(cond
			((Said 'open/door')
				(Print msgCloser)
				(if locked
					(Print msgExcept)
				)
			)
			((Said 'close/door')
				(Print msgCloser)
				(if locked
					(Print msgExcept)
				)
			)
			((Said 'look/door')
				(Print msgLook)
				(if locked
					(Print msgLookLock)
				)
			)
			((Said 'bang/door')
				(Print msgFunny)
			)
		)
	)

	(method (open)
		(if (and (not locked) (!= doorState 1) (!= doorState 2))
			(= doorState 1)
			(self setCycle: End self)
			(if openSnd
				(openSnd doit:)
			)
		)
	)

	(method (close)
		(if (and (!= doorState 3) (!= doorState 0))
			(= doorState 3)
			(self setCycle: Beg self)
			(if closeSnd
				(closeSnd doit:)
			)
		)
	)
)

