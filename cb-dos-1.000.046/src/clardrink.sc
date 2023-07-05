;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 272)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	clardrink 0
)

(synonyms
	(attorney person man)
)

(local
	local0
	local1
	local2
)

(instance clardrink of Rgn
	(properties)

	(method (init)
		(super init:)
		(Load rsFONT 41)
		(Load rsVIEW 642)
		(LoadMany rsSOUND 29 94 95 96)
		(LoadMany rsMESSAGE 243 297 406)
		(LoadMany rsSYNC 7 12)
		(= global208 64)
		(= [global377 6] 297)
		(ClarAss init: stopUpd:)
		(Clarence illegalBits: 0 setPri: 6 init:)
		(Smoke setPri: 6 init: hide:)
		(self setScript: clarActions)
	)

	(method (doit)
		(super doit:)
	)

	(method (dispose)
		(super dispose:)
	)

	(method (handleEvent event)
		(super handleEvent: event)
	)
)

(instance clarActions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond
					((not global216)
						(= state -1)
					)
					((not (& gMustDos $0008))
						(|= gMustDos $0008)
						(self setScript: (ScriptID 406 0)) ; Clock
						(= state -1)
					)
					((self script:)
						(= state -1)
					)
				)
				(= cycles 1)
			)
			(1
				(Clarence setLoop: 1 cel: 0 setCycle: End self)
				(= local1 (Random 1 3))
				(= local2 0)
			)
			(2
				(= seconds 2)
			)
			(3
				(Clarence setLoop: 4 cel: 1)
				(= cycles 1)
			)
			(4
				(Smoke cel: 0 setCycle: End self show:)
			)
			(5
				(if (< local2 local1)
					(++ local2)
					(Clarence cel: 0)
					(= cycles (= state 1))
				else
					(Smoke cel: 0 hide:)
					(Clarence setLoop: 5)
					(Clarence
						cel: (- (NumCels Clarence) 3)
						cycleSpeed: 2
						setCycle: Beg
					)
					(= seconds (Random 3 6))
				)
			)
			(6
				(Clarence setLoop: 2)
				(Clarence cel: (- (NumCels Clarence) 1))
				(= cycles 1)
			)
			(7
				(Clarence setCycle: Beg)
				(switch (Random 1 4)
					(1
						(= state 0)
					)
					(3
						(= state 8)
					)
				)
				(= seconds (Random 3 6))
			)
			(8
				(Clarence setCycle: End)
				(= state 6)
				(= seconds (Random 3 6))
			)
			(9
				(Clarence setLoop: 9 cel: 0 setCycle: End)
				(= seconds (Random 1 2))
			)
			(10
				(Clarence setCycle: Beg)
				(= seconds (Random 3 6))
				(if (< seconds 5)
					(= state 0)
				else
					(= state 5)
				)
			)
		)
	)
)

(instance Clarence of Act
	(properties
		y 74
		x 171
		view 401
		loop 1
	)

	(method (handleEvent event)
		(cond
			((Said 'look/glass,drink')
				(Print 272 0) ; "It's a glass of very fine, imported cognac."
			)
			((Said 'get/drink,glass,alcohol')
				(Print 272 1) ; "He wouldn't like that!"
			)
			((Said 'look/butt')
				(Print 272 2) ; "That's a big cigar!"
			)
			((Said 'get/butt')
				(Print 272 3) ; "He wouldn't give it to you!"
			)
			((Said 'drink/alcohol')
				(Print 272 4) ; "You don't like liquor...remember?"
			)
			((and (MousedOn self event 3) (not (& global207 $0040)))
				(event claimed: 1)
				(DoLook {clarence})
			)
			(
				(and
					(& global207 $0040)
					(or (MousedOn self event 3) (Said 'look/attorney'))
				)
				(event claimed: 1)
				(Print 272 5) ; "Clarence looks forlorn as he sits alone at the bar, having a drink."
			)
			((and (== (event type:) evSAID) (Said '*/attorney>'))
				(cond
					((Said 'talk')
						(= global213 7)
						(switch local0
							(0
								(Say 1 272 6) ; "Oh...hello, young lady, 'er, Laura."
							)
							(1
								(Say 1 272 7) ; "Would you like to sit down and have a drink with me?"
								(= global213 12)
								(Say 1 272 8) ; "I'm sorry. I don't drink."
							)
							(2
								(Say 1 272 9) ; "Everything's falling apart, Laura. I don't know what to do. I feel like I'm backed up against a wall and there's no way out!"
							)
							(3
								(Say 1 272 10) ; "I don't understand why you're here...why you would want to get involved with this mess?"
								(= global213 12)
								(Say 1 272 11) ; "I'm beginning to wonder that myself."
							)
							(4
								(Say 1 272 12) ; "Well, things can't go on like this much longer. I've got to do something about it!"
							)
							(5
								(Say 1 272 13) ; "You're sure you don't want a drink?"
								(= global213 12)
								(Say 1 272 14) ; "No, thanks."
							)
							(6
								(Say 1 272 15) ; "I've got a lot of thinking to do, Laura. Why don't you go on up to bed?"
							)
							(else
								(Print 272 16) ; "Clarence seems deep in thought as he slowly sips his drink. It might be best to leave him alone right now."
							)
						)
						(++ local0)
					)
					((Said 'listen')
						(Print 272 17) ; "He's waiting for you to say something."
					)
				)
			)
		)
	)
)

(instance ClarAss of Prop
	(properties
		y 102
		x 168
		view 401
		cel 2
	)
)

(instance Smoke of Prop
	(properties
		y 60
		x 167
		view 401
		loop 6
	)
)

