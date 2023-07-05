;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 50)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Actor)

(class Door of Prop
	(properties
		cycleSpeed 1
		entranceTo 0
		locked 0
		openSnd 0
		closeSnd 0
		doorState 0
		doorCtrl 2
		roomCtrl 4
		doorBlock 16384
		code 0
		illegalBits 0
		force 0
		notify 0
	)

	(method (init)
		(if (and gPrevRoomNum (== gPrevRoomNum entranceTo))
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
		(if (!= doorState 2)
			(gEgo observeControl: doorBlock)
		else
			(gEgo ignoreControl: doorBlock)
		)
		(if (and roomCtrl entranceTo (& (gEgo onControl:) roomCtrl))
			(gCurRoom newRoom: entranceTo)
		)
	)

	(method (open)
		(cond
			((and (not force) (!= (gEgo onControl: 1) doorCtrl))
				(NotClose) ; "You're not close enough."
			)
			(locked
				(Print 50 0) ; "You can't. It's locked."
			)
			((or (== doorState 1) (== doorState 2))
				(ItIs) ; "It is."
			)
			(else
				(= doorState 1)
				(self setCycle: End self)
				(if openSnd
					(openSnd play:)
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
				(Print 50 0) ; "You can't. It's locked."
			)
			((or (== doorState 3) (== doorState 0))
				(ItIs) ; "It is."
			)
			((& (gEgo onControl:) doorBlock)
				(if (> gFilthLevel 1)
					(Print 50 1) ; "Get your fat ass out of the doorway first."
				else
					(Print 50 2) ; "Please move out of the doorway first."
				)
			)
			(else
				(= doorState 3)
				(self setCycle: Beg self)
				(if closeSnd
					(closeSnd play:)
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

