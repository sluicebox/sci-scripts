;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 385)
(include sci.sh)
(use Main)
(use Interface)
(use Feature)
(use LoadMany)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm385 0
)

(local
	talked
	looked
	lookDirection
	randRegister
)

(procedure (JetsOn)
	(chestBubbles init: cycleSpeed: global101 setCycle: Fwd)
	(leftRim init: cycleSpeed: global101 setCycle: Fwd)
	(bubble1 init: cycleSpeed: global101 setCycle: Fwd)
	(bubble2 init: cycleSpeed: global101 setCycle: Fwd)
	(bubble3 init: cycleSpeed: global101 setCycle: Fwd)
	(smallBubble init: cycleSpeed: global101 setCycle: Fwd)
)

(procedure (JetsOff)
	(chestBubbles dispose:)
	(leftRim dispose:)
	(bubble1 dispose:)
	(bubble2 dispose:)
	(bubble3 dispose:)
	(smallBubble dispose:)
)

(instance rm385 of Rm
	(properties
		picture 385
	)

	(method (init)
		(LoadMany rsVIEW 385 386 387)
		(herEyes init: cycleSpeed: (+ 1 global101))
		(eyeRight init: cycleSpeed: (+ 1 global101))
		(eyeLeft init: cycleSpeed: (+ 1 global101))
		(herMouth init: cycleSpeed: (+ 1 global101))
		(fEveHead init:)
		(fBoobs init:)
		(fEveArms init:)
		(fTowel init:)
		(gEgo init: normal: 0 z: 1000)
		(aSpaButton init: stopUpd:)
		(super init:)
		(gCurRoom setScript: sWanderEyes)
		(if (IsFlag 17)
			(JetsOff)
		else
			(JetsOn)
		)
		(gTheMusic send: 4 78 0 send: 9 78 0 send: 5 78 1)
	)

	(method (doit)
		(super doit: &rest)
		(if (>= randRegister 5)
			(= lookDirection 1)
		else
			(= lookDirection 0)
		)
		(cond
			((== (gCurRoom script:) 0)
				(gCurRoom setScript: sWanderEyes)
			)
			((gEgo mover:)
				(gCurRoom newRoom: 380)
			)
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(switch (++ looked)
					(1
						(Print 385 0 #at -1 20) ; "Wow! Just the way you like your women: nearby and naked! She has a beautiful face and a gorgeous body. You've waited a lifetime for this moment."
					)
					(2
						(Print 385 1 #at -1 20) ; "What a beautiful face! She's leaning back, relaxing in the spa with the water bubbling up around her. It's even possible you could become sexually aroused by this!"
					)
					(else
						(Print 385 2) ; "It's difficult to take your eyes off the beautiful woman with whom you share the hot tub."
						(Print 385 3) ; "And her eyes tell you she's interested in you, too, Larry!"
					)
				)
				(if (!= (gCurRoom script:) sEveHappy)
					(gCurRoom setScript: sEveHappy)
				)
				(return 1)
			)
			(3 ; Do
				(Print 385 4) ; "You feel certain she likes that."
				(if (!= (gCurRoom script:) sEveHappy)
					(gCurRoom setScript: sEveHappy)
				)
				(return 1)
			)
			(5 ; Talk
				(switch (++ talked)
					(1
						(Print 385 5 #at -1 20) ; "Who loves ya, baby?"
						(Print 385 6 #at -1 20) ; "She says nothing, but her smile tells you bushels."
					)
					(2
						(Print 385 7 #at -1 20) ; ""Have you ever tried it underwater?" you coyly ask."
						(Print 385 8 #at -1 20) ; "She doesn't say."
					)
					(3
						(Print 385 9 #at -1 20) ; ""What's your name, gorgeous?" you ask."
						(Print 385 10 #at -1 20) ; "She says nothing, but her smile speaks volumes."
					)
					(4
						(Print 385 11 #at -1 20) ; ""What's your sign, dollface?" you ask."
						(Print 385 12 #at -1 20) ; "At last she speaks. "Yield," she says simply."
					)
					(else
						(Print 385 13 #at -1 20) ; "Although she smiles, it appears she's a woman of few words. She's waiting for you to determine what it is she wants!"
					)
				)
				(if (!= (gCurRoom script:) sEveHappy)
					(gCurRoom setScript: sEveHappy)
				)
				(return 1)
			)
			(11 ; Taste/Smell
				(Print 385 14) ; "You smell so good, Baby," you tell her. "What is that perfume you're wearing?"
				(Print 385 15) ; ""`Apple Blossom,'" she smiles."
				(if (!= (gCurRoom script:) sEveHappy)
					(gCurRoom setScript: sEveHappy)
				)
				(return 1)
			)
			(10 ; Zipper
				(Print 385 16) ; "SLAP!!!"
				(Print 385 17 #at -1 140) ; "(Oops!)"
				(if (!= (gCurRoom script:) sEveAngry)
					(gCurRoom setScript: sEveAngry)
				)
				(return 1)
			)
			(4 ; Inventory
				(switch invItem
					(2 ; watch
						(Print 385 18) ; ""Now's the time, Larry!" she says."
						(gCurRoom setScript: sEveAngry)
					)
					(3 ; apple
						(HandsOff)
						(gCurRoom setScript: sEveEatsApple)
						(Points 59 15)
						(SetFlag 6)
					)
					(10 ; discoPass
						(Print 385 19) ; "Why, Larry," she smiles, "are you trying to throw a `pass' at me?"
						(gCurRoom setScript: sEveAngry)
					)
					(5 ; whiskey
						(if (!= (gCurRoom script:) sEveAngry)
							(gCurRoom setScript: sEveAngry)
						)
						(Print 385 20) ; ""How's about a shot of Lefty's cheap well whiskey?" you ask her."
						(Print 385 21) ; "She ignores you completely. Obviously this woman is used to the finer things in life."
					)
					(6 ; remoteControl
						(Print 385 22) ; "A few infrared rays won't help you here, Larry."
					)
					(8 ; lubber
						(if (!= (gCurRoom script:) sEveHappy)
							(gCurRoom setScript: sEveHappy)
						)
						(Print 385 23) ; ""That might be useful to you later," she says with a smile."
					)
					(14 ; hammer
						(Print 385 24) ; "That's not the proper "tool" to use with this lady, Larry!"
					)
					(11 ; pocketKnife
						(if (!= (gCurRoom script:) sEveAngry)
							(gCurRoom setScript: sEveAngry)
						)
						(Print 385 25) ; "Bad idea, Larry. Threatening her will do no good!"
					)
					(else
						(Print 385 26) ; "Eve is mostly interested in just one, sweet thing."
						(Print 385 27 #at -1 140) ; "(And that's not it!)"
					)
				)
				(return 1)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance sWanderEyes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= randRegister (Random 0 10))
				(herMouth stopUpd:)
				(= seconds (Random 4 10))
			)
			(1
				(cond
					((== lookDirection 0)
						(herEyes init: setLoop: 8 setCel: 0 setCycle: End)
					)
					((== lookDirection 1)
						(herEyes init: setLoop: 7 setCel: 0 setCycle: End)
					)
				)
				(= seconds (Random 2 6))
			)
			(2
				(= randRegister (Random 0 10))
				(herEyes setCycle: CT 0 -1)
				(= seconds (Random 2 6))
			)
			(3
				(cond
					((== lookDirection 1)
						(herEyes init: setLoop: 8 setCel: 0 setCycle: End)
					)
					((== lookDirection 0)
						(herEyes init: setLoop: 7 setCel: 0 setCycle: End)
					)
				)
				(= seconds (Random 2 6))
			)
			(4
				(herEyes setCycle: CT 0 -1)
				(= seconds (Random 2 6))
			)
			(5
				(self init:)
			)
		)
	)
)

(instance sEveAngry of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(herEyes setLoop: 2 setCel: 0 setCycle: End)
				(herMouth setLoop: 4 setCel: 0 setCycle: End)
				(= seconds (Random 4 9))
			)
			(1
				(herEyes setCycle: Beg self)
				(herMouth setCycle: Beg self)
			)
			(2 0)
			(3
				(self dispose:)
			)
		)
	)
)

(instance sWink_Pucker of Script ; UNUSED
	(properties
		name {sWink&Pucker}
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(eyeLeft setLoop: 1 setCel: 0 setCycle: End self)
			)
			(1
				(herMouth setLoop: 5 setCel: 0 setCycle: End)
				(eyeLeft setCycle: Beg)
				(= seconds 2)
			)
			(2
				(herMouth setCycle: Beg self)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance sEveHappy of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(herEyes init: setLoop: 1 setCel: 0 setCycle: Beg)
				(herMouth setLoop: 3 setCel: 0 setCycle: End)
				(= seconds (Random 4 9))
			)
			(1
				(herMouth setCycle: Beg self)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance sEveEatsApple of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gTheMusic send: 6 78 0)
				(herEyes dispose:)
				(herMouth setLoop: 3 setCel: 0 setCycle: End)
				(= seconds 3)
			)
			(1
				(Print 385 28) ; "Eve takes your apple, and with a sweet, innocent look, raises it to her mouth. She takes a small bite, then lowers her arm as a sexy smile comes across her face. She winks, then, almost imperceptibly, she lies back slightly, sliding deeper into the warm water, and chews delicately."
				(gEgo put: 3) ; apple
				(= seconds 3)
			)
			(2
				(Print 385 29) ; "Eve gently slips her sensuous tongue around and around the lucky apple. Tiny drops of the apple's juice glistening on her lips. She's really turning you on!"
				(Print 385 30 #at -1 140) ; "(You had no idea fruit could be so exciting.)"
				(= seconds 3)
			)
			(3
				(Print 385 31 #at -1 20) ; "After a few bites of your apple, Eve slowly slides out of the hot tub, her steamy, naked body glistening in the moonlight. Barely covering her tremendous assets with the towel, she tosses you a towel, smiles and motions for you to follow her."
				(gCurRoom newRoom: 380)
			)
		)
	)
)

(instance sButton of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(aSpaButton setCel: 0 setCycle: End self)
			)
			(1
				(if (IsFlag 17)
					(Print 385 32) ; "You slyly brush the spa bubbler control switch."
					(JetsOff)
				else
					(Print 385 33) ; "Because you are such a wimp, you turn the bubblers back on."
					(JetsOn)
				)
				(aSpaButton setCycle: Beg self)
			)
			(2
				(aSpaButton stopUpd:)
				(if (!= (gCurRoom script:) sEveHappy)
					(gCurRoom setScript: sEveHappy)
				)
				(self dispose:)
			)
		)
	)
)

(instance herEyes of Prop
	(properties
		x 159
		y 192
		z 144
		description {her eyes}
		sightAngle 180
		lookStr {Her eyes are a deep loamy brown.}
		view 385
		loop 8
		cycleSpeed 2
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 385 34) ; "You gently brush your fingertips across her lids."
			)
			(else
				(gCurRoom doVerb: theVerb invItem)
			)
		)
	)
)

(instance eyeLeft of Prop
	(properties
		x 159
		y 192
		z 144
		description {her eyes}
		sightAngle 180
		lookStr {Her eyes are a deep loamy brown.}
		view 385
		loop 1
	)

	(method (doVerb theVerb invItem)
		(herEyes doVerb: theVerb invItem)
	)
)

(instance eyeRight of Prop
	(properties
		x 159
		y 192
		z 144
		description {her eyes}
		sightAngle 180
		lookStr {Her eyes are a deep loamy brown.}
		view 385
		cycleSpeed 2
	)

	(method (doVerb theVerb invItem)
		(herEyes doVerb: theVerb invItem)
	)
)

(instance herMouth of Prop
	(properties
		x 156
		y 68
		description {her mouth}
		sightAngle 180
		lookStr {Her mouth drives you crazy.}
		view 385
		loop 3
	)

	(method (doVerb theVerb invItem)
		(gCurRoom doVerb: theVerb invItem)
	)
)

(instance aSpaButton of Prop
	(properties
		x 310
		y 189
		z 85
		description {the button}
		lookStr {There's a control button built into the surface of the spa's decking.}
		view 386
		loop 4
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(self setScript: sButton)
				(sButton init:)
				(ToggleFlag 17)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance chestBubbles of Prop
	(properties
		x 119
		y 154
		description {the bubbles}
		view 386
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 385 35) ; "How you wish there was a switch to turn off those bubbles!"
			)
			(3 ; Do
				(Print 385 36) ; "It feels good to run your hand through the bubbles."
			)
			(5 ; Talk
				(Print 385 37) ; ""Buubbbbbbffeffosss," you say, attempting to speak underwater."
			)
			(10 ; Zipper
				(Print 385 38) ; "Nah, do that when you're at home alone!"
			)
			(11 ; Taste/Smell
				(Print 385 39) ; "There's a whiff of chlorine in the air."
			)
			(4 ; Inventory
				(Print 385 40) ; "There's no need to rinse off any of your inventory in the water."
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance leftRim of Prop
	(properties
		x 40
		y 134
		description {the bubbles}
		view 386
		loop 3
		cel 1
	)

	(method (doVerb theVerb invItem)
		(chestBubbles doVerb: theVerb invItem)
	)
)

(instance smallBubble of Prop
	(properties
		x 264
		y 173
		description {the bubbles}
		view 386
		loop 1
		cel 2
	)

	(method (doVerb theVerb invItem)
		(chestBubbles doVerb: theVerb invItem)
	)
)

(instance bubble1 of Prop
	(properties
		x 243
		y 142
		description {the bubbles}
		view 386
		loop 5
	)

	(method (doVerb theVerb invItem)
		(chestBubbles doVerb: theVerb invItem)
	)
)

(instance bubble2 of Prop
	(properties
		x 285
		y 140
		description {the bubbles}
		view 386
		loop 6
		cel 1
	)

	(method (doVerb theVerb invItem)
		(chestBubbles doVerb: theVerb invItem)
	)
)

(instance bubble3 of Prop
	(properties
		x 256
		y 166
		description {the bubbles}
		view 386
		loop 7
		cel 2
	)

	(method (doVerb theVerb invItem)
		(chestBubbles doVerb: theVerb invItem)
	)
)

(instance fTowel of Feature
	(properties
		x 42
		y 70
		nsTop 51
		nsBottom 89
		nsRight 85
		description {her towel}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(SetFlag 18)
				(Print 385 41) ; "Her hand rests near a expensive fluffy bath towel, embroidered in a florid script with the name, "Eve.""
			)
			(11 ; Taste/Smell
				(Printf 385 42 (if (IsFlag 18) {Eve's} else {Her})) ; "%s towel has a clean, fresh aroma."
			)
			(3 ; Do
				(Print 385 43) ; "You can't reach her bath towel, and you have no desire to leave the water at a time like this!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance fEveHead of Feature
	(properties
		x 158
		y 190
		nsTop 32
		nsLeft 105
		nsBottom 110
		nsRight 211
		description {her face}
		sightAngle 180
		lookStr {What a fabulous face!}
	)

	(method (doVerb theVerb invItem)
		(gCurRoom doVerb: theVerb invItem &rest)
	)
)

(instance fEveArms of Feature
	(properties
		x 158
		y 116
		nsTop 96
		nsLeft 9
		nsBottom 137
		nsRight 292
		description {her body}
		sightAngle 180
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Printf 385 44 (if (IsFlag 18) {Eve's} else {her})) ; "You can picture %s gentle arms winding their way around you."
			)
			(3 ; Do
				(if (!= (gCurRoom script:) sEveHappy)
					(gCurRoom setScript: sEveHappy)
				)
				(gCurRoom doVerb: theVerb invItem &rest)
			)
			(else
				(gCurRoom doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance fBoobs of Feature
	(properties
		x 140
		y 185
		z 40
		nsTop 125
		nsLeft 80
		nsBottom 155
		nsRight 201
		description {her breasts}
		sightAngle 180
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if (IsFlag 17)
					(Print 385 45) ; "What a good idea to turn off those bubblers!"
				else
					(Printf 385 46 (if (IsFlag 18) {Eve's} else {her})) ; "Even through the bubbles, %s assets are outstanding."
				)
			)
			(3 ; Do
				(Print 385 47) ; "This is the part of the game that you've been waiting for, isn't it, Larry?"
				(if (!= (gCurRoom script:) sEveHappy)
					(gCurRoom setScript: sEveHappy)
				)
			)
			(10 ; Zipper
				(Print 385 48) ; ""Hey, don't rush things!" she says."
				(if (!= (gCurRoom script:) sEveAngry)
					(gCurRoom setScript: sEveAngry)
				)
			)
			(else
				(gCurRoom doVerb: theVerb invItem &rest)
			)
		)
	)
)

