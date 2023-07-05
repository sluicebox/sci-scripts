;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 277)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rudypet 0
)

(synonyms
	(rudolph person man)
)

(local
	local0
	local1
	local2
)

(instance Dog of Prop
	(properties
		y 147
		x 108
		view 520
		loop 3
	)

	(method (handleEvent event)
		(cond
			(
				(or
					(Said 'feed,give/*/beauregard>')
					(Said 'feed,give/*<beauregard>')
				)
				(cond
					((and (gEgo has: 12) (Said '/bone')) ; soup_bone
						(Print 277 0) ; "Beauregard isn't interested in the bone right now."
					)
					((and global219 global224)
						(Print 277 1) ; "The dog doesn't seem to be hungry."
					)
					(else
						(DontHave) ; "You don't have it."
					)
				)
				(event claimed: 1)
			)
			(
				(or
					(Said 'give,show/*/beauregard')
					(Said 'give,show/*<beauregard')
				)
				(if (and global219 global224)
					(Print 277 2) ; "Beauregard barely looks at it."
				else
					(DontHave) ; "You don't have it."
				)
			)
			((Said 'throw/bone')
				(Print 277 3) ; "That wouldn't work. Beauregard's not interested in the bone right now."
			)
			((Said '/beauregard>')
				(cond
					((Said 'look')
						(Print 277 4) ; "Beauregard has joined Rudy as he sits on the steps outside Colonel Dijon's study."
					)
					((Said 'get,move,pull,get')
						(Print 277 5) ; "Beauregard's with Rudy right now!"
					)
					((Said 'pat')
						(Print 277 6) ; "Rudy is already petting the dog."
					)
					((Said 'talk')
						(Print 277 7) ; "You speak to the dog who pricks up his ears only slightly."
					)
					((Said 'kill')
						(Print 277 8) ; "That's not a nice thought, Laura!"
					)
					((Said 'kiss')
						(Print 277 9) ; "Don't kiss a dog!"
					)
				)
			)
		)
	)
)

(instance rudypet of Rgn
	(properties)

	(method (init)
		(super init:)
		(Load rsFONT 4)
		(= global195 256)
		(if (not (& gMustDos $0004))
			(Load rsFONT 41)
			(Load rsVIEW 642)
			(LoadMany rsSOUND 29 94 95 96)
			(Load rsSCRIPT 406)
		)
		(Dog init:)
		(Rudy init:)
		(self setScript: petDog)
	)

	(method (doit)
		(super doit:)
	)

	(method (dispose)
		(super dispose:)
	)

	(method (handleEvent event &tmp temp0)
		(super handleEvent: event)
		(if (event claimed:)
			(return 1)
		)
		(if (== (event type:) evSAID)
			(cond
				((Said 'look/rudolph')
					(Print 277 10) ; "Rudy sits sullenly on the steps outside the Colonel's study with old Beauregard accompanying him."
				)
				((Said 'feed/food')
					(Print 277 1) ; "The dog doesn't seem to be hungry."
				)
			)
		)
		(super handleEvent: event)
	)
)

(instance petDog of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if
					(and
						(== gPrevRoomNum 31)
						(or (!= (gEgo x:) 118) (!= (gEgo y:) 144))
					)
					(= state -1)
				)
				(= cycles 1)
			)
			(1
				(cond
					((not global216)
						(= state 0)
					)
					((not (& gMustDos $0004))
						(|= gMustDos $0004)
						(self setScript: (ScriptID 406 0)) ; Clock
						(= state 0)
					)
					((self script:)
						(= state 0)
					)
				)
				(= cycles 1)
			)
			(2
				(Rudy cycleSpeed: 1 loop: 1 cel: 2 setCycle: Beg self)
			)
			(3
				(Rudy loop: 0 setCycle: Fwd)
				(Dog setCycle: Fwd)
				(= seconds (Random 3 5))
			)
			(4
				(Dog setCycle: 0)
				(Rudy loop: 1 cel: 0 setCycle: End)
				(= state 1)
				(= seconds (Random 6 12))
			)
		)
	)
)

(instance Rudy of Prop
	(properties
		y 147
		x 133
		view 390
		loop 1
	)

	(method (handleEvent event)
		(= global213 9)
		(cond
			((Said 'ask//*<about')
				(switch local1
					(0
						(Say 1 277 11) ; "I don't wanna talk about nothin' right now. I got some thinkin' to do."
						(++ local1)
					)
					(1
						(Print 277 12) ; "You're getting on Rudy's nerves, Laura. You should probably go."
					)
				)
			)
			((Said 'tell//*<about')
				(switch local2
					(0
						(Say 1 277 13) ; "I ain't interested!"
						(++ local2)
					)
					(1
						(Print 277 14) ; "Rudy doesn't care."
					)
				)
			)
			((or (Said 'give/*[/rudolph]') (Said 'give/*[<rudolph]'))
				(event claimed: 1)
				(if (and global219 global224)
					(Print 277 15) ; "It's obvious that Rudy isn't interested in it."
				else
					(DontHave) ; "You don't have it."
				)
			)
			((or (Said 'show/*/[rudolph]') (Said 'show/*[<rudolph]'))
				(event claimed: 1)
				(if (and global219 global224)
					(Print 277 16) ; "Rudy doesn't even acknowledge it."
				else
					(DontHave) ; "You don't have it."
				)
			)
			((Said '/rudolph>')
				(cond
					((Said 'listen')
						(Print 277 17) ; "He's not talking to you."
					)
					((Said 'get')
						(Print 277 18) ; "You can't get Rudy!"
					)
					((Said 'kill')
						(Print 277 19) ; "Now, now! There's no need for that!"
					)
					((Said 'kiss')
						(Print 277 20) ; "Even though he IS attractive, you'll pass."
					)
					((Said 'embrace')
						(Print 277 20) ; "Even though he IS attractive, you'll pass."
					)
					((Said 'talk')
						(= global213 9)
						(switch local0
							(0
								(Say 1 277 21) ; "Ah, it's you again, is it? You should be up sleepin' like everybody else."
							)
							(1
								(Say 1 277 22) ; "I got a lot on my mind right now. I ain't in the mood to gab."
							)
							(2
								(Say 1 277 23) ; "I said I don't wanna talk to you right now! Got it?!"
							)
							(3
								(Say 1 277 24) ; "Did you hear me?! Bug off!!"
							)
							(else
								(Print 277 25) ; "Angrily, Rudy refuses to answer you anymore. It might be best to leave him alone right now."
							)
						)
						(++ local0)
					)
				)
			)
			((Said 'flirt//rudolph')
				(Print 277 26) ; "It's tempting, but it's not you."
			)
		)
	)
)

