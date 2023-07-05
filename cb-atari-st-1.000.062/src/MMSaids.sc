;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 407)
(include sci.sh)
(use Main)
(use Interface)
(use System)

(public
	MMSaids 0
)

(local
	[local0 144] = [407 0 407 1 407 2 407 3 407 4 407 5 407 6 407 7 407 8 407 9 407 10 407 11 407 12 407 13 407 14 407 15 407 16 407 17 407 18 407 18 407 18 407 19 407 20 407 21 407 22 407 23 407 24 407 25 407 26 407 27 407 28 407 28 407 28 407 29 407 29 407 29 407 30 407 31 407 32 407 33 407 34 407 35 407 36 407 37 407 38 407 22 407 23 407 24 407 39 407 39 407 39 407 40 407 41 407 42 407 18 407 18 407 18 407 43 407 44 407 45 407 46 407 47 407 48 407 49 407 50 407 51 407 52 407 53 407 54 407 55 407 56 407 57]
	local144
)

(procedure (localproc_0 &tmp temp0 temp1)
	(if global219
		(= temp0
			(+
				(= temp0
					(+ (= temp0 (* (- global213 1) 96)) (* (- global212 1) 24))
				)
				global171
			)
		)
		(= temp1 (<< $0001 (mod temp0 16)))
		(if (& [global302 (/= temp0 16)] temp1)
			(return 0)
		)
		(|= [global302 temp0] temp1)
	)
	(return 1)
)

(instance MMSaids of Script
	(properties)

	(method (handleEvent event &tmp temp0 [temp1 2])
		(= local144 (<< $0001 (- global213 1)))
		(if (and (gEgo has: 22) (Said '/diamond>')) ; pouch
			(cond
				((Said 'look')
					(Print 407 58) ; "You open the leather pouch and peer inside. It's full of precious jewels! Carefully, you close it again so as not to lose any."
				)
				((Said 'get,wear')
					(Print 407 59) ; "You might lose them. Better keep them safely inside the leather pouch."
				)
			)
		)
		(if (event claimed:)
			(client setScript: 0)
			(return)
		)
		(= temp0 -1)
		(cond
			((Said 'blow/nose')
				(if (gEgo has: 23) ; handkerchief
					(Ok) ; "Okay."
					(gGetItemMusic number: 116 loop: 1 priority: 10 play:)
					(gGetItemMusic number: 93 priority: 2 owner: -1)
				else
					(Print 407 60) ; "You don't have a handkerchief."
				)
			)
			((Said 'look/fingerprint')
				(if (gEgo has: 1) ; monocle
					(cond
						((and (gEgo has: 19) (gEgo has: 9)) ; diary, broken_record
							(Print 407 61) ; "Which ones would you like to examine? The ones on the record or diary?"
						)
						((gEgo has: 19) ; diary
							(Print 407 62 #icon 637 0 0) ; "Upon opening the diary you see a small inky fingerprint inside the front cover. You examine it more closely with Wilbur's monocle."
							(SetFlag 12)
						)
						((gEgo has: 9) ; broken_record
							(Print 407 63 #icon 636 0 0) ; "Squinting into the monocle you carefully examine the piece of broken record. Closely situated to each other, you notice two different fingerprints."
							(SetFlag 9)
						)
					)
				else
					(Print 407 64) ; "You don't have anything that will help you do that."
				)
			)
			((Said 'look/laura')
				(= global213 12)
				(Say 0 407 65) ; "You are a lovely girl of twenty with light red hair and dazzling green eyes. Though you appear somewhat naive, you are really a very resourceful girl. Unfortunately, before this night is over, your resourcefulness and courage will be sorely tested. Good luck... you're gonna need it!"
			)
			((Said 'look/bootprint')
				(Print 407 66) ; "You don't see any footprints around here."
			)
			((Said 'talk>')
				(Print 407 67) ; "You don't get any response."
				(event claimed: 1)
			)
			((Said 'shoot')
				(cond
					(global185
						(Print 407 68) ; "That is not a good use of your one bullet."
					)
					((gEgo has: 15) ; derringer
						(Print 407 69) ; "That is not a good use of your time. Besides, the gun isn't even loaded!"
					)
					(else
						(Print 407 70) ; "You have no gun."
					)
				)
			)
			((Said 'unbar/*')
				(if (or (gEgo has: 5) (gEgo has: 18)) ; skeleton_key, brass_key
					(Print 407 71) ; "You do not have the right key to unlock it."
				else
					(Print 407 72) ; "You don't have the key."
				)
			)
			((and (gEgo has: 2) (Said 'get/kerosene')) ; lantern
				(Print 407 73) ; "You don't want the kerosene by itself!"
			)
			((Said 'eat')
				(Print 407 74) ; "That wouldn't taste good."
			)
			((Said 'hop')
				(Print 407 75) ; "That wouldn't accomplish anything."
			)
			((Said 'kill')
				(Print 407 76) ; "You're too nice for that."
			)
			((Said 'rob')
				(Print 407 77) ; "You were taught better than that!"
			)
			((Said 'hit')
				(Print 407 78) ; "You don't have a violent nature."
			)
			((Said 'climb')
				(Print 407 79) ; "Climb what?"
			)
			((Said 'close/door')
				(Print 407 80) ; "You don't need to."
			)
			((Said 'listen')
				(Print 407 81) ; "You listen intently."
			)
			((Said 'talk')
				(Print 407 82) ; "Hello."
			)
			((Said 'bye')
				(Print 407 83) ; "Bye."
			)
			((Said 'sit')
				(Print 407 84) ; "You don't feel like sitting around."
			)
			((Said 'smell')
				(Print 407 85) ; "Sniff, sniff."
			)
			((Said 'get>')
				(cond
					((Said '/water')
						(Print 407 86) ; "You have no need of water."
					)
					((Said '[/!*]')
						(Print 407 87) ; "What do you want to get?"
					)
					(else
						(Print 407 88) ; "You can't get that."
					)
				)
				(event claimed: 1)
			)
			((or (Said 'ask/*<for') (Said 'ask//*<for'))
				(Print 407 89) ; "If you want it, just GET it."
			)
			((Said 'ask>')
				(if (Said '//*<about>')
					(if (and (& local144 global210) (!= local144 global211))
						(if (localproc_0)
							(= temp0 (* (Random 0 5) 3 2))
						else
							(= temp0 120)
						)
					else
						(Print 407 67) ; "You don't get any response."
						(event claimed: 1)
					)
				else
					(Print 407 90) ; "Please rephrase your question, making sure that it is in the form of a question."
				)
				(event claimed: 1)
			)
			((Said 'tell>')
				(if (Said '//*<about>')
					(if (and (& local144 global210) (!= local144 global211))
						(if (localproc_0)
							(= temp0 (* (+ (* (Random 0 5) 3) 18) 2))
						else
							(= temp0 126)
						)
					else
						(Print 407 67) ; "You don't get any response."
						(event claimed: 1)
					)
				else
					(Print 407 91) ; "Please be more specific."
				)
				(event claimed: 1)
			)
			((Said 'open,(look<in)>')
				(cond
					((Said '[/!*]')
						(Print 407 92) ; "What do you want to open?"
					)
					((Said '/door')
						(Print 407 93) ; "Just do that yourself."
					)
					(else
						(CantDo) ; "You can't do that."
					)
				)
				(event claimed: 1)
			)
			((Said 'look>')
				(if (Said '/person,man,woman')
					(Print 407 94) ; "You don't see anyone."
				else
					(SeeNothing) ; "You see nothing special."
				)
				(event claimed: 1)
			)
			((Said 'give>')
				(cond
					(global224
						(if (& local144 global210)
							(if (localproc_0)
								(= temp0 (* (+ (* (Random 0 3) 3) 36) 2))
							else
								(= temp0 132)
							)
						else
							(Print 407 95) ; "You get no reaction."
						)
					)
					((Said '[/!*]')
						(Print 407 96) ; "What do you want to give?"
					)
					(else
						(Print 407 97) ; "It's not yours to give."
					)
				)
				(event claimed: 1)
			)
			((Said 'show>')
				(cond
					(global224
						(if (& local144 global210)
							(if (localproc_0)
								(= temp0 (* (+ (* (Random 0 3) 3) 48) 2))
							else
								(= temp0 138)
							)
						else
							(Print 407 95) ; "You get no reaction."
						)
					)
					((Said '[/!*]')
						(Print 407 98) ; "What do you want to show?"
					)
					(else
						(DontHave) ; "You don't have it."
					)
				)
				(event claimed: 1)
			)
			((Said 'drop,throw,use')
				(DontHave) ; "You don't have it."
			)
			((Said 'who/game<program')
				(Print 407 99) ; "Chris Hoyt and Chris Iden"
			)
			((Said 'draw<who/game')
				(Print 407 100) ; "Doug "Og" Herring"
			)
			((Said 'write<who/music')
				(Print 407 101) ; "Ken Allen"
			)
			((Said 'is<who/lord<stump')
				(Print 407 102) ; "Bob Ballew"
			)
			((Said 'move,press,pull')
				(CantDo) ; "You can't do that."
			)
		)
		(if (!= temp0 -1)
			(switch global213
				(2
					(+= temp0 2)
				)
				(5
					(+= temp0 4)
				)
			)
			(Say 1 [local0 temp0] [local0 (+ temp0 1)])
			(event claimed: 1)
		)
		(client setScript: 0)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 407)
	)
)

