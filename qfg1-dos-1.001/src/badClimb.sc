;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 291)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use User)
(use System)

(public
	badClimb 0
	goodClimb 1
	fallDown 2
	catchIt 3
)

(instance badClimb of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 291)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (not (IsFlag 190))
					(HighPrint 291 0) ; "It looks difficult. You look around for a good place to climb."
				)
				(gEgo setMotion: MoveTo (gEgo x:) 50)
				(= cycles 20)
			)
			(1
				(if (not (IsFlag 190))
					(SetFlag 190)
					(HighPrint 291 1) ; "This looks like a good place to you."
				)
				(gEgo
					view: 517
					setMotion: 0
					illegalBits: 0
					setLoop: 0
					x: (+ (gEgo x:) 6)
					cel: 0
				)
				(= cycles 2)
			)
			(2
				(gEgo setCycle: Fwd)
				(self cue:)
			)
			(3
				(Print 291 2 #at -1 140 #width 300 #dispose #time 6) ; "You valiantly scrabble against the cliff wall, but it looks like your climbing skill could stand some improvement."
				(= seconds 6)
			)
			(4
				(gEgo
					view: 0
					setCycle: Walk
					setLoop: 2
					x: (- (gEgo x:) 6)
				)
				(= cycles 2)
			)
			(5
				(gEgo setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 5) self)
			)
			(6
				(HandsOn)
				(NormalEgo)
				(HighPrint 291 3) ; "Perhaps there is some other way to get to your objective."
				(client setScript: 0)
			)
		)
	)
)

(instance goodClimb of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 291)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo illegalBits: 0 setMotion: MoveTo (gEgo x:) 150 self)
				(if (not (IsFlag 190))
					(HighPrint 291 4) ; "You look for an appropriate place to climb."
					(SetFlag 190)
				)
			)
			(1
				(if (gEgo inRect: 135 140 143 154)
					(gEgo posn: 139 150)
					(self changeState: 3)
				else
					(gEgo setMotion: MoveTo 139 150 self)
				)
			)
			(2
				(gEgo setMotion: MoveTo 139 137 self)
			)
			(3
				(gEgo
					view: 517
					setLoop: 1
					cel: 0
					ignoreActors:
					posn: 144 105
					cycleSpeed: 2
					setCycle: End self
				)
			)
			(4
				(= global326 1)
				(HandsOn)
				(User canControl: 0)
				(self dispose:)
			)
		)
	)
)

(instance fallDown of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 291)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= global326 0)
				(self cue:)
			)
			(1
				(gEgo
					view: 517
					setLoop: 2
					cel: 0
					posn: 158 99
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(2
				(if (not (TakeDamage 5))
					(EgoDead ; "Had you been healthier, you probably could have survived that fall. In your weakened condition, however, you succumbed to your injuries."
						291
						5
						82
						517
						2
						5
						80
						{Your figure remains still and silent.}
					)
				else
					(TimePrint 3 291 6) ; "Ohhhhhhh!"
					(= seconds 3)
				)
			)
			(3
				(Print 291 7) ; "You remain unconscious on the ground for an indeterminate amount of time. As you finally revive, you realize that you've caused yourself a fair amount of damage."
				(NormalEgo)
				(gEgo loop: 2 posn: 164 136)
				(HandsOn)
				(gEgo setScript: 0)
			)
		)
	)
)

(instance catchIt of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 291)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(NormalEgo)
				(HandsOff)
				(gEgo
					illegalBits: 0
					ignoreActors:
					posn: 148 96
					setLoop: 3
					setMotion: MoveTo 157 92 self
				)
			)
			(1
				(gEgo setLoop: 1 setPri: 4 setMotion: MoveTo 149 88 self)
			)
			(2
				(if (== global327 0)
					(= global327 (Random 1 3))
				)
				(= global326 3)
				(User canInput: 1)
				(gEgo
					view: 16
					setLoop: 5
					setCel: 0
					posn: 145 88
					setScript: 0
				)
			)
		)
	)
)

