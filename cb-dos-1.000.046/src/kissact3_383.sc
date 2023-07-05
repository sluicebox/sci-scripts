;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 383)
(include sci.sh)
(use Main)
(use Interface)
(use Avoid)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	kissact3 0
)

(synonyms
	(fifi woman)
	(butler man)
)

(local
	[local0 12] = [107 139 163 139 230 139 98 155 175 155 258 155]
	[local12 8] = [163 94 222 112 177 92 90 94]
	local20
	local21
	local22
	local23
)

(instance myMusic of Sound
	(properties)
)

(instance kissact3 of Rgn
	(properties)

	(method (init)
		(super init:)
		(SetFlag 22)
		(LoadMany rsVIEW 467 470 447 459)
		(Load rsFONT 4)
		(Load rsSCRIPT 985)
		(Load rsSOUND 51)
		(= gFifiState 1)
		(LoadMany rsMESSAGE 243 294 377)
		(LoadMany rsVIEW 470 904 910)
		(= global208 (| (|= global208 $0010) $0400))
		(= [global377 4] 294)
		(= [global377 10] 377)
		(myMusic number: 112 loop: 0)
		(Duster illegalBits: 0 ignoreActors: 1 init:)
		(Fifi setAvoider: (Avoid new:) init:)
		(self setScript: kiss)
	)

	(method (doit)
		(super doit:)
	)

	(method (dispose)
		(DisposeScript 985)
		(super dispose:)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if (event claimed:)
			(return)
		)
	)
)

(instance kiss of Script
	(properties)

	(method (doit)
		(if (and (== state 5) (== (Fifi cel:) 4))
			(Duster dispose:)
		)
		(if (and (== state 5) (== (Fifi cel:) 1))
			(Jeeves loop: 8 cel: 0 setCycle: End)
		)
		(if (and (== state 5) (== (Jeeves cel:) 1) (== (Jeeves loop:) 8))
			(Jeeves loop: 9 setCycle: Fwd)
		)
		(if (and (== state 1) (== (Fifi cel:) 1))
			(Duster
				setStep: 3 3
				setLoop: 1
				setCycle: Fwd
				setMotion: MoveTo 136 142
			)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 1)
			)
			(1
				(Fifi view: 475 loop: 0 cel: 0 cycleSpeed: 2 setCycle: End self)
			)
			(2
				(myMusic number: 51 loop: 1 play:)
				(Duster setCycle: 0 loop: 2 cel: 0)
				(Fifi loop: 3 cel: 0 setCycle: End self)
			)
			(3
				(Fifi loop: 4 cel: 0 setCycle: End self)
			)
			(4
				(Fifi cel: 0 loop: 5 setCycle: Fwd)
				(Jeeves setCycle: End setAvoider: (Avoid new:) init:)
				(= seconds 3)
			)
			(5
				(Fifi loop: 7 setCycle: End self)
			)
			(6
				(HandsOn)
				(Fifi cycleSpeed: 0 setScript: fifiActions)
				(Jeeves cycleSpeed: 0 setScript: jeevesActions)
				(client setScript: 0)
			)
		)
	)
)

(instance jeevesActions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local20 (Random 0 5))
				(Jeeves
					view: 447
					setCycle: Walk
					ignoreActors: 0
					setMotion:
						MoveTo
						[local0 (* local20 2)]
						[local0 (+ (* local20 2) 1)]
						self
				)
			)
			(1
				(Jeeves
					view: 459
					cel: 0
					loop: (if (< (Random 1 100) 50) 0 else 1)
					setCycle: End self
				)
			)
			(2
				(Jeeves loop: (if (== (Jeeves loop:) 0) 2 else 3) setCycle: Fwd)
				(= seconds 4)
			)
			(3
				(Jeeves
					cel: 2
					loop: (if (== (Jeeves loop:) 2) 0 else 1)
					setCycle: Beg self
				)
				(= state -1)
			)
		)
	)
)

(instance fifiActions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Fifi
					view: 464
					setCycle: Walk
					ignoreActors: 0
					setMotion: MoveTo 64 139 self
				)
			)
			(1
				(Fifi setMotion: MoveTo 56 103 self)
			)
			(2
				(= local21 (Random 0 3))
				(Fifi
					view: 464
					setCycle: Walk
					ignoreActors: 0
					setMotion:
						MoveTo
						[local12 (* local21 2)]
						[local12 (+ (* local21 2) 1)]
						self
				)
			)
			(3
				(Fifi
					view: 470
					cel: 0
					loop:
						(switch local21
							(0 1)
							(1 0)
							(2 1)
							(else 0)
						)
					setCycle: End self
				)
			)
			(4
				(Fifi
					loop:
						(switch local21
							(0 3)
							(1 2)
							(2 3)
							(else 2)
						)
					setCycle: Fwd
				)
				(= seconds 4)
			)
			(5
				(Fifi cel: 2 setCycle: Beg self)
				(= state 1)
			)
		)
	)
)

(instance Jeeves of Act
	(properties
		y 153
		x 169
		view 475
		loop 6
	)

	(method (handleEvent event)
		(cond
			(
				(and
					(not (& global207 $0400))
					(or (MousedOn self event 3) (Said 'look/butler'))
				)
				(= global213 11)
				(|= global207 $0400)
				(event claimed: 1)
				(Say 0 383 0) ; "Jeeves is the Colonel's imposing butler. Though you find him somewhat good-looking, he nevertheless gives off a disconcerting feeling of secretiveness. You have noticed that Jeeves generally keeps to himself and seems to talk in little more than monosyllables. You wonder about him."
			)
			(
				(and
					(& global207 $0400)
					(or (MousedOn self event 3) (Said 'look/butler'))
				)
				(event claimed: 1)
				(Print 383 1) ; "You notice Jeeves carpet-sweeping the rug."
			)
			((Said 'talk,look/person')
				(Print 383 2) ; "Which person are you referring to?"
			)
			((Said 'talk/people')
				(Print 383 3) ; "You can only talk to one person at a time."
			)
			((Said 'look/people')
				(Print 383 4) ; "Fifi is busily dusting away and Jeeves is sweeping the carpet."
			)
			((Said '/butler>')
				(cond
					((Said 'talk')
						(= global213 11)
						(switch local22
							(0
								(Say 1 383 5) ; "I'm busy, Miss Bow. No time for conversation."
							)
							(1
								(Say 1 383 6) ; "It's not up to me to entertain you with idle chitchat."
							)
							(2
								(Say 1 383 7) ; "For the last time, Miss Bow, permit me to finish my work."
							)
							(else
								(Print 383 8) ; "Jeeves completely ignores you."
							)
						)
						(++ local22)
					)
					((Said 'listen')
						(Print 383 9) ; "Jeeves is not a big talker."
					)
				)
			)
		)
	)
)

(instance Fifi of Act
	(properties
		y 153
		x 148
		view 475
	)

	(method (handleEvent event)
		(if (< (gEgo distanceTo: Fifi) (gEgo distanceTo: Jeeves))
			(= global214 16)
		else
			(= global214 1024)
		)
		(cond
			((and (MousedOn self event 3) (not (& global207 $0010)))
				(event claimed: 1)
				(DoLook {fifi})
			)
			(
				(and
					(& global207 $0010)
					(or (MousedOn self event 3) (Said 'look/fifi'))
				)
				(event claimed: 1)
				(Print 383 10) ; "Fifi is busily dusting away!"
			)
			((and (== (event type:) evSAID) (Said '*/fifi>'))
				(cond
					((Said 'talk')
						(= global213 5)
						(switch local23
							(0
								(Say 1 383 11) ; "I must hurry and finish zee dusting, Mademoiselle!"
							)
							(1
								(Say 1 383 12) ; "Mademoiselle, s'il vous plait, do not bother me now!"
							)
							(2
								(Say 1 383 13) ; "Eet does not appear good for me to talk with you, Mademoiselle."
							)
							(3
								(Say 1 383 14) ; "Please, Mademoiselle!"
							)
							(else
								(Say 1 383 15) ; "I must not talk to you now!"
							)
						)
						(++ local23)
					)
					((Said 'listen')
						(Print 383 16) ; "She's not talking; she's too busy dusting."
					)
				)
			)
		)
	)
)

(instance Duster of Act
	(properties
		y 124
		x 158
		view 475
		loop 1
	)
)

(instance Sweeper of Prop ; UNUSED
	(properties
		y 119
		x 158
		view 475
		loop 2
		cel 2
	)
)

