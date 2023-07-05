;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 86)
(include sci.sh)
(use Main)
(use Interface)
(use Avoid)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Room86 0
)

(instance door of Prop
	(properties)
)

(instance Room86 of Rm
	(properties
		picture 86
	)

	(method (init)
		(super init:)
		(NormalEgo)
		(HandsOff)
		(door view: 125 loop: 0 cel: 0 posn: 161 136 init:)
		(switch gPrevRoomNum
			(90
				(gEgo view: 0 init: posn: 159 130)
				(gCurRoom setScript: inFromNinety)
			)
			(else
				(NormalEgo)
				(gEgo
					view: 123
					loop: 3
					posn: 159 155
					observeControl: 16384
					init:
				)
				(gCurRoom setScript: Actions)
			)
		)
		(if (gEgo has: 12) ; Coveralls
			(gEgo view: 113)
		)
	)

	(method (newRoom newRoomNumber)
		(if (not global597)
			(= global597 1)
			(gGame changeScore: 25)
		)
		(super newRoom: newRoomNumber)
	)

	(method (doit)
		(super doit:)
		(if (!= gCurRoomNum gNewRoomNum)
			(return)
		)
		(if (& (gEgo onControl: 0) $0040)
			(gCurRoom newRoom: 85)
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
							(Print 86 0) ; "You're within the outer fortifications of the ScumSoft headquarters. You see an elevator door and a button on the wall."
						)
						((Said '/door,elevator')
							(Print 86 1) ; "It looks like an elevator entrance."
						)
						((Said '/partition')
							(Print 86 2) ; "There is a button on the wall next to the elevator door"
						)
						((Said '/ramp,stair')
							(Print 86 3) ; "You nervously glance up to the top of the ramp knowing that the guards could come barreling down on you at any moment."
						)
						((Said '/button')
							(Print 86 4) ; "There is a button on the wall by the elevator."
						)
					)
				)
				((Said 'open/door')
					(Print 86 5) ; "The elevator door is tightly sealed."
				)
				((Said 'press/button')
					(gEgo setScript: pushButton)
				)
			)
		)
	)
)

(instance Actions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 2)
			)
			(1
				(HandsOff)
				(gEgo setMotion: 0 view: 134 setLoop: 4 setCycle: Fwd)
				(RedrawCast)
				(= seconds 2)
			)
			(2
				(gEgo setLoop: 3 cel: 0)
				(RedrawCast)
				(Print 86 6) ; "What's happening??!!"
				(= seconds 2)
			)
			(3
				(gEgo setLoop: 1)
				(= seconds 2)
			)
			(4
				(NormalEgo)
				(gEgo view: 0 loop: 2)
				(= global120 2)
				(= global105 0)
				(RedrawCast)
				(Print 86 7) ; "It looks like you've made it just in time, as your invisibility belt is now completely out of power."
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance inFromNinety of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(door ignoreActors: setCycle: End self)
			)
			(1
				(gEgo setMotion: MoveTo 159 155 self)
			)
			(2
				(door setCycle: Beg self)
				(NormalEgo)
				(gEgo observeControl: 16384)
				(HandsOn)
			)
		)
	)
)

(instance pushButton of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setAvoider: Avoid setMotion: MoveTo 134 143 self)
			)
			(1
				(= seconds 2)
			)
			(2
				(gEgo setAvoider: 0)
				(door setCycle: End self)
			)
			(3
				(door ignoreActors:)
				(gEgo ignoreControl: 16384 setMotion: MoveTo 159 141 self)
			)
			(4
				(gEgo setMotion: MoveTo 159 130 self)
			)
			(5
				(gEgo loop: 2)
				(door setCycle: Beg self)
			)
			(6
				(gCurRoom newRoom: 90)
			)
		)
	)
)

