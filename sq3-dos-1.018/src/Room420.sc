;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 420)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Room420 0
)

(instance elevTop of View
	(properties)
)

(instance elevBottom of View
	(properties)
)

(instance cable1 of View
	(properties)
)

(instance cable2 of View
	(properties)
)

(instance cable3 of View
	(properties)
)

(instance cable4 of View
	(properties)
)

(instance Room420 of Rm
	(properties
		picture 420
	)

	(method (init)
		(= global104 0)
		(super init:)
		(gEgo init:)
		(switch gPrevRoomNum
			(42
				(NormalEgo)
				(gEgo posn: 93 156)
				(elevTop
					view: 83
					ignoreActors:
					posn: 164 112
					setPri: 12
					loop: 1
					cel: 1
					init:
					stopUpd:
				)
				(elevBottom
					view: 83
					ignoreActors:
					posn: 164 112
					setPri: 7
					loop: 1
					cel: 0
					init:
					stopUpd:
				)
				(cable1
					view: 83
					loop: 1
					cel: 3
					ignoreActors:
					posn: 164 80
					setPri: 10
					init:
					stopUpd:
				)
				(cable2
					view: 83
					loop: 1
					cel: 3
					ignoreActors:
					posn: 164 42
					setPri: 10
					init:
					stopUpd:
				)
				(cable3
					view: 83
					loop: 1
					cel: 3
					ignoreActors:
					posn: 164 12
					setPri: 10
					init:
					stopUpd:
				)
				(cable4
					view: 83
					loop: 1
					cel: 3
					ignoreActors:
					posn: 164 0
					setPri: 10
					init:
					stopUpd:
				)
			)
			(421
				(gEgo view: 83 setLoop: 1 setCel: 2 posn:)
				(cable1
					view: 777
					loop: 1
					cel: 3
					ignoreActors:
					posn: 164 80
					setPri: 10
					init:
					stopUpd:
				)
				(cable2
					view: 777
					loop: 1
					cel: 3
					ignoreActors:
					posn: 164 42
					setPri: 10
					init:
					stopUpd:
				)
				(cable3
					view: 777
					loop: 1
					cel: 3
					ignoreActors:
					posn: 164 12
					setPri: 10
					init:
					stopUpd:
				)
				(cable4
					view: 777
					loop: 1
					cel: 3
					ignoreActors:
					posn: 164 0
					setPri: 10
					init:
					stopUpd:
				)
				(gCurRoom setScript: lowerElevator)
			)
		)
		(gEgo init:)
	)

	(method (newRoom newRoomNumber)
		(if (!= newRoomNumber 421)
			(gLongSong owner: -1 number: 22 priority: 1 loop: -1 play:)
		)
		(super newRoom: newRoomNumber)
	)

	(method (doit)
		(super doit:)
		(if (!= gCurRoomNum gNewRoomNum)
			(return)
		)
		(if (& (gEgo onControl: 1) $0040)
			(gCurRoom newRoom: 42)
		)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return 1)
		)
		(if (== (event type:) evSAID)
			(cond
				((Said 'look>')
					(cond
						(
							(or
								(Said '/area')
								(Said '/around')
								(Said '[<around][/!*]')
							)
							(Print 420 0) ; "You are inside one of Mog's legs. There is an elevator shaft (complete with elevator) leading up into the interior."
						)
						((Said '/elevator')
							(Print 420 1) ; "The elevator is at the bottom of the shaft. You see the elevator buttons on the south side of the elevator"
						)
						((Said '/button,console,control')
							(Print 420 2) ; "Gee, one button says "Up" and one says "Down"."
						)
						((Said '<up')
							(Print 420 3) ; "You see the elevator shaft extending up into Mog's body."
						)
						((Said '/pit')
							(Print 420 4) ; "It's a pretty ordinary elevator shaft."
						)
						(else
							(Print 420 5) ; "Hey, just get on with it dude!"
							(event claimed: 1)
						)
					)
				)
				(
					(or
						(Said 'press/button')
						(Said 'use/elevator')
						(Said 'press<up/')
					)
					(if (gEgo inRect: 150 147 180 158)
						(gCurRoom setScript: raise)
					else
						(NotClose) ; "It's not quite within reach."
					)
				)
				((Said 'press<down')
					(Print 420 6) ; "The elevator is already down."
				)
				((Said 'climb')
					(Print 420 7) ; "Just take the elevator."
				)
			)
		)
	)
)

(instance raise of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (!= gCurRoomNum gNewRoomNum)
			(return)
		)
		(cond
			((< (Abs (- (gEgo y:) (cable1 y:))) 2)
				(cable1 dispose:)
			)
			((< (Abs (- (gEgo y:) (cable2 y:))) 2)
				(cable2 dispose:)
			)
			((< (Abs (- (gEgo y:) (cable3 y:))) 2)
				(cable3 dispose:)
			)
			((< (Abs (- (gEgo y:) (cable4 y:))) 2)
				(cable4 dispose:)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 164 153 self)
			)
			(1
				(gEgo view: 83 cel: 255 setLoop: 0 setCycle: End self)
			)
			(2
				(gEgo
					ignoreActors:
					illegalBits: 0
					setLoop: 1
					setCel: 2
					posn: 164 (elevTop y:)
					setPri: 11
					setMotion: MoveTo 164 -60 self
				)
				(elevTop dispose:)
				(elevBottom dispose:)
			)
			(3
				(gCurRoom newRoom: 421)
			)
		)
	)
)

(instance lowerElevator of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (!= gCurRoomNum gNewRoomNum)
			(return)
		)
		(cond
			((< (Abs (- (gEgo y:) (cable1 y:))) 2)
				(cable1 view: 83 loop: 1 cel: 3 forceUpd: stopUpd:)
			)
			((< (Abs (- (gEgo y:) (cable2 y:))) 2)
				(cable2 view: 83 loop: 1 cel: 3 forceUpd: stopUpd:)
			)
			((< (Abs (- (gEgo y:) (cable3 y:))) 2)
				(cable3 view: 83 loop: 1 cel: 3 forceUpd: stopUpd:)
			)
			((< (Abs (- (gEgo y:) (cable4 y:))) 2)
				(cable4 view: 83 loop: 1 cel: 3 forceUpd: stopUpd:)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: 83
					ignoreActors:
					illegalBits: 0
					setLoop: 1
					setCel: 2
					posn: 164 -60
					setPri: 11
					setMotion: MoveTo 164 112 self
				)
			)
			(1
				(elevTop
					view: 83
					ignoreActors:
					posn: 164 112
					setPri: 12
					loop: 1
					cel: 1
					init:
					stopUpd:
				)
				(elevBottom
					view: 83
					ignoreActors:
					posn: 164 112
					setPri: 7
					loop: 1
					cel: 0
					init:
					stopUpd:
				)
				(NormalEgo)
				(gEgo
					view: 0
					setLoop: -1
					setCel: -1
					setCycle: Walk
					illegalBits: -32768
					posn: 164 153
				)
				(HandsOn)
			)
		)
	)
)

