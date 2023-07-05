;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 370)
(include sci.sh)
(use Main)
(use AnimatePrint)
(use KQ6Room)
(use CartoonScript)
(use n913)
(use Conversation)
(use Scaler)
(use RandCycle)
(use Motion)
(use Actor)
(use System)

(public
	rm370 0
)

(instance myConv of Conversation
	(properties)
)

(instance rm370 of KQ6Room
	(properties
		picture 370
		horizon 0
	)

	(method (init)
		(super init: &rest)
		(gKeyDownHandler add: self)
		(gTheIconBar
			enable:
			disable: 0 1 2 3 4 5 6
			height: -100
			activateHeight: -100
		)
		(Cursor showCursor: 0)
		(gGlobalSound number: 370 setLoop: -1 play:)
		(egoLegs addToPic:)
		(lHand init: stopUpd:)
		(rHand init: stopUpd:)
		(myHead init:)
		(gEgo view: 374 normal: 0 loop: 0 cel: 0 posn: 155 147 init:)
		(kingarm init: stopUpd:)
		(queenHand init:)
		(candle1 init: setCycle: Fwd)
		(candle2 init: setCycle: Fwd)
		(cond
			((and (IsFlag 1) (not (IsFlag 3)))
				(if (== gMsgType 2)
					(gCurRoom setScript: savedCelesteCD)
				else
					(gCurRoom setScript: savedCelesteTXT)
				)
			)
			((== gMsgType 2)
				(gCurRoom setScript: caughtAtGateCD)
			)
			(else
				(gCurRoom setScript: caughtAtGateTXT)
			)
		)
	)

	(method (handleEvent event)
		(if (and (& (event type:) evKEYBOARD) (== (event message:) KEY_ESCAPE))
			(event message: KEY_r)
		)
		(return 0)
	)

	(method (dispose)
		(gTheIconBar height: 0 activateHeight: 0)
		(Cursor showCursor: 1)
		(gEgo setScale: 0)
		(gTheIconBar enable: 6)
		(gGame setCursor: gWaitCursor)
		(gKeyDownHandler delete: self)
		(DisposeScript 371)
		(super dispose:)
	)
)

(instance AlexPrint of AnimatePrint
	(properties)

	(method (init)
		(= myMouth alexHead)
		(= x -1)
		(= y 140)
		(super init:)
	)
)

(instance AzurePrint of AnimatePrint
	(properties)

	(method (init)
		(= myMouth azureMouth)
		(= myEyes azureEyes)
		(= x 10)
		(= y 110)
		(super init:)
	)
)

(instance AerielPrint of AnimatePrint
	(properties)

	(method (init)
		(= myMouth aerielMouth)
		(= myEyes aerielEyes)
		(= x 70)
		(= y 110)
		(super init:)
	)
)

(instance mouthScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCycle: RandCycle)
				(if (< (= seconds (+ register 1)) 1)
					(= seconds 1)
				)
			)
			(1
				(client dispose:)
			)
		)
	)
)

(instance alexHead of Prop
	(properties
		x 142
		y 50
		view 374
		loop 4
		priority 15
		signal 24592
		cycleSpeed 8
	)

	(method (init param1)
		(myHead hide:)
		(super init:)
		(self setScript: mouthScr 0 param1)
	)

	(method (dispose)
		(myHead show:)
		(super dispose:)
	)
)

(instance eyeScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 2 4))
			)
			(1
				(client show: setCycle: End self)
			)
			(2
				(= cycles 2)
			)
			(3
				(client setCycle: Beg self)
			)
			(4
				(= cycles 2)
			)
			(5
				(client hide:)
				(= state -1)
				(self cue:)
			)
		)
	)
)

(instance azureMouth of Prop
	(properties
		x 115
		y 41
		view 370
		loop 4
		priority 15
		signal 24592
	)

	(method (init param1)
		(super init:)
		(self setScript: mouthScr 0 param1)
	)
)

(instance azureEyes of Prop
	(properties
		x 108
		y 36
		view 370
		loop 6
		priority 15
		signal 24592
	)

	(method (init)
		(super init:)
		(self hide: setScript: eyeScr)
	)
)

(instance aerielMouth of Prop
	(properties
		x 207
		y 45
		view 370
		loop 5
		priority 15
		signal 24592
	)

	(method (init param1)
		(super init:)
		(self setScript: mouthScr 0 param1)
	)
)

(instance aerielEyes of Prop
	(properties
		x 201
		y 42
		view 370
		loop 7
		priority 15
		signal 24592
	)

	(method (init)
		(super init:)
		(self hide: setScript: eyeScr)
	)
)

(instance flyer of Actor
	(properties
		view 353
		signal 24576
	)
)

(instance caughtAtGateCD of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 2)
			)
			(1
				(myConv
					add: -1 1 0 1 1 ; "(DEMANDING) With what trickery did you master the Cliffs of Logic and reach the City of the Winged Ones?"
					add: -1 1 0 1 2 ; "(FIRM AND CALM) Only the magic of clear thought, my lord. I meant no harm."
					add: -1 1 0 1 3 ; "(WHISPERS TO HER HUSBAND) The Cliffs of Logic? It is the sacred Oracle's prophecy, Azure!"
					add: -1 1 0 1 4 ; "(RESTRAINED VIOLENCE) Yes, Aeriel. Hmmm. It is lucky for you, human, that climbing the Cliffs of Logic is part of a prophecy that I cannot ignore."
					add: -1 1 0 1 5 ; "We have just been ordered by Vizier Alhazred himself to 'dispose' of any strangers that might land on our fair Isle. But the prophecy would have a different fate befall you."
					add: -1 1 0 1 6 ; "(COLD, CONDESCENDING) The prophecy predicts that whosoever climbs the Cliffs of Logic will defeat the minotaur."
					add: -1 1 0 1 7 ; "The minotaur has violated our sacred catacombs and eats our young in sacrifice. Our own daughter, Lady Celeste, was taken there only this morning as his most recently demanded offering!"
					add: -1 1 0 1 8 ; "(FINDING HIMSELF CLEVER) A dilemma then--whom shall I obey in regards to your fate? The Oracle or the Crown? But since Alhazred did not dictate HOW I was to dispose of intruders, and since you cannot possibly survive the catacombs, your imprisonment there should serve both purposes quite admirably."
					add: -1 1 0 1 9 ; "(FIRM, CALM) I will not resist you in this, my lord. I shall do my best to save your daughter."
					add: -1 1 0 1 10 ; "(CONDESCENDING) Hmph. First I must tell you that the catacombs are a labyrinth of rooms, a place of exceeding danger. You will need many tools and clear wits to survive it."
					init: self
				)
			)
			(2
				(SetFlag 2)
				(cond
					(
						(and
							(gEgo has: 2) ; brick
							(gEgo has: 18) ; holeInTheWall
							(gEgo has: 48) ; tinderBox
							(gEgo has: 41) ; scarf
						)
						(gEgo setScript: toLabyrinth)
					)
					((== gMsgType 2)
						(gEgo setScript: toBeachCD)
					)
					(else
						(gEgo setScript: toBeachTXT)
					)
				)
			)
		)
	)
)

(instance caughtAtGateTXT of CartoonScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 2)
			)
			(1
				(kingarm setLoop: 2 setCycle: End)
				(AzurePrint addText: 1 0 1 1 init:) ; "(DEMANDING) With what trickery did you master the Cliffs of Logic and reach the City of the Winged Ones?"
			)
			(2
				(kingarm setCycle: Beg)
				(= cycles 2)
			)
			(3
				(AlexPrint addText: 1 0 1 2 init:) ; "(FIRM AND CALM) Only the magic of clear thought, my lord. I meant no harm."
			)
			(4
				(= cycles 2)
			)
			(5
				(AerielPrint addText: 1 0 1 3 init:) ; "(WHISPERS TO HER HUSBAND) The Cliffs of Logic? It is the sacred Oracle's prophecy, Azure!"
			)
			(6
				(= cycles 2)
			)
			(7
				(AzurePrint addText: 1 0 1 4 init:) ; "(RESTRAINED VIOLENCE) Yes, Aeriel. Hmmm. It is lucky for you, human, that climbing the Cliffs of Logic is part of a prophecy that I cannot ignore."
			)
			(8
				(= cycles 2)
			)
			(9
				(kingarm setLoop: 1 setCycle: End)
				(AzurePrint addText: 1 0 1 5 init:) ; "We have just been ordered by Vizier Alhazred himself to 'dispose' of any strangers that might land on our fair Isle. But the prophecy would have a different fate befall you."
			)
			(10
				(kingarm setCycle: Beg)
				(= cycles 2)
			)
			(11
				(queenHand cel: 1)
				(AerielPrint addText: 1 0 1 6 init:) ; "(COLD, CONDESCENDING) The prophecy predicts that whosoever climbs the Cliffs of Logic will defeat the minotaur."
			)
			(12
				(queenHand cel: 0)
				(= cycles 2)
			)
			(13
				(AerielPrint addText: 1 0 1 7 init:) ; "The minotaur has violated our sacred catacombs and eats our young in sacrifice. Our own daughter, Lady Celeste, was taken there only this morning as his most recently demanded offering!"
			)
			(14
				(= cycles 2)
			)
			(15
				(kingarm setLoop: 2 setCycle: End)
				(AzurePrint addText: 1 0 1 8 init:) ; "(FINDING HIMSELF CLEVER) A dilemma then--whom shall I obey in regards to your fate? The Oracle or the Crown? But since Alhazred did not dictate HOW I was to dispose of intruders, and since you cannot possibly survive the catacombs, your imprisonment there should serve both purposes quite admirably."
			)
			(16
				(kingarm setCycle: Beg)
				(= cycles 2)
			)
			(17
				(AlexPrint addText: 1 0 1 9 init:) ; "(FIRM, CALM) I will not resist you in this, my lord. I shall do my best to save your daughter."
			)
			(18
				(= cycles 2)
			)
			(19
				(kingarm setLoop: 2 setCycle: End)
				(AzurePrint addText: 1 0 1 10 init:) ; "(CONDESCENDING) Hmph. First I must tell you that the catacombs are a labyrinth of rooms, a place of exceeding danger. You will need many tools and clear wits to survive it."
			)
			(20
				(kingarm setCycle: Beg)
				(SetFlag 2)
				(cond
					(
						(and
							(gEgo has: 2) ; brick
							(gEgo has: 18) ; holeInTheWall
							(gEgo has: 48) ; tinderBox
							(gEgo has: 41) ; scarf
						)
						(gCurRoom setScript: toLabyrinth)
					)
					((== gMsgType 2)
						(gCurRoom setScript: toBeachCD)
					)
					(else
						(gCurRoom setScript: toBeachTXT)
					)
				)
			)
		)
	)
)

(instance toLabyrinth of CartoonScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(if (== gMsgType 2)
					(gMessager say: 1 0 2 1 self) ; "(SERIOUS & RESPECTFUL) I am ready."
				else
					(AlexPrint addText: 1 0 2 1 init:) ; "(SERIOUS & RESPECTFUL) I am ready."
				)
			)
			(2
				(= cycles 2)
			)
			(3
				(if (== gMsgType 2)
					(gMessager say: 1 0 2 2 self) ; "(DECISIVE) Very well. My guards will take you there now. You seem courageous enough, but the catacombs will determine how brave you really are."
				else
					(kingarm setLoop: 2 setCycle: End)
					(AzurePrint addText: 1 0 2 2 init:) ; "(DECISIVE) Very well. My guards will take you there now. You seem courageous enough, but the catacombs will determine how brave you really are."
				)
			)
			(4
				(gEgo hide:)
				(egoLegs dispose:)
				(lHand dispose:)
				(rHand dispose:)
				(myHead dispose:)
				(kingarm dispose:)
				(queenHand dispose:)
				(candle1 dispose:)
				(candle2 dispose:)
				(gCurRoom setScript: flyToCliff)
			)
		)
	)
)

(instance toBeachCD of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(myConv
					add: -1 1 0 3 1 ; "(COLD, LOGICAL) Azure, he must be allowed time to prepare for the task--if only in the slight chance that he could actually save our Celeste."
					add: -1 1 0 3 2 ; "(RELUCTANT, THREATENING) Hmmm. Very well. Intruder, my guards will take you to the beach. Prophesied hero or spy, any soldier must be granted time to prepare for battle."
					add: -1 1 0 3 3 ; "Be warned! If you have the courage to actually return to the Isle of the Sacred Mountain and face your destiny, my guards will have orders to take you to the catacombs on sight."
					add: -1 1 0 3 4 ; "(SERIOUS & RESPECTFUL) I understand, Lord Azure."
					add: -1 1 0 3 5 ; "If by some miracle you succeed, human, the prophecy grants you a visit with the sacred Oracle. Her powers are mighty, her vision all-seeing."
					add: -1 1 0 3 6 ; "Many of our own citizens would be willing to risk certain death in the catacombs for a chance at a meeting with the Oracle. May that thought give you the courage to return."
					add: -1 1 0 3 7 ; "Oh, I will return, Lady Aeriel. You have my word."
					init: self
				)
			)
			(1
				(gEgo hide:)
				(egoLegs dispose:)
				(lHand dispose:)
				(rHand dispose:)
				(myHead dispose:)
				(kingarm dispose:)
				(queenHand dispose:)
				(candle1 dispose:)
				(candle2 dispose:)
				(gCurRoom setScript: flyToBeach)
			)
		)
	)
)

(instance toBeachTXT of CartoonScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(queenHand cel: 2)
				(AerielPrint addText: 1 0 3 1 init:) ; "(COLD, LOGICAL) Azure, he must be allowed time to prepare for the task--if only in the slight chance that he could actually save our Celeste."
			)
			(1
				(queenHand cel: 0)
				(= cycles 2)
			)
			(2
				(kingarm setLoop: 2 setCycle: End)
				(AzurePrint addText: 1 0 3 2 init:) ; "(RELUCTANT, THREATENING) Hmmm. Very well. Intruder, my guards will take you to the beach. Prophesied hero or spy, any soldier must be granted time to prepare for battle."
			)
			(3
				(kingarm setCycle: Beg)
				(= cycles 2)
			)
			(4
				(kingarm setLoop: 1 setCycle: End)
				(AzurePrint addText: 1 0 3 3 init:) ; "Be warned! If you have the courage to actually return to the Isle of the Sacred Mountain and face your destiny, my guards will have orders to take you to the catacombs on sight."
			)
			(5
				(kingarm setCycle: Beg)
				(= cycles 2)
			)
			(6
				(AlexPrint addText: 1 0 3 4 init:) ; "(SERIOUS & RESPECTFUL) I understand, Lord Azure."
			)
			(7
				(= cycles 2)
			)
			(8
				(queenHand cel: 2)
				(AerielPrint addText: 1 0 3 5 init:) ; "If by some miracle you succeed, human, the prophecy grants you a visit with the sacred Oracle. Her powers are mighty, her vision all-seeing."
			)
			(9
				(= cycles 2)
			)
			(10
				(queenHand cel: 0)
				(AerielPrint addText: 1 0 3 6 init:) ; "Many of our own citizens would be willing to risk certain death in the catacombs for a chance at a meeting with the Oracle. May that thought give you the courage to return."
			)
			(11
				(= cycles 2)
			)
			(12
				(AlexPrint addText: 1 0 3 7 init:) ; "Oh, I will return, Lady Aeriel. You have my word."
			)
			(13
				(gEgo hide:)
				(egoLegs dispose:)
				(lHand dispose:)
				(rHand dispose:)
				(myHead dispose:)
				(kingarm dispose:)
				(queenHand dispose:)
				(candle1 dispose:)
				(candle2 dispose:)
				(gCurRoom setScript: flyToBeach)
			)
		)
	)
)

(instance savedCelesteCD of CartoonScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 2)
			)
			(1
				(myConv
					add: -1 1 0 4 1 ; "(COLD, RELUCTANTLY RESPECTFUL) I see you have proven yourself the 'hero' of the prophecy. Well, I am expected to thank you for saving my daughter's life, so I thank you."
					add: -1 1 0 4 2 ; "I am obliged to thank you for the restoration of our sacred catacombs. It means much to our people. We have already begun the process of clearing the deadly traps from its rooms."
					add: -1 1 0 4 3 ; "It is also my duty to grant you a visit with the Oracle, so this I do. I will grant you the freedom to leave here unharmed, despite my orders to the contrary from the Crown. But there my obligations to you end."
					add: -1 1 0 4 4 ; "I have no love for Alhazred, but he is my liege, and if Princess Cassima trusts him and wishes to wed him...."
					add: -1 1 0 4 5 ; "My guards will take you to the Oracle now. When your time with her is through, I want you to leave the City of the Winged Ones and never return."
					add: -1 1 0 4 6 ; "I don't know who you are or what you want here, but I will not disobey my Crown further."
					add: -1 1 0 4 7 ; "(BOWING, RESPECTFUL) I thank you, Lord Azure. I will respect your wishes."
					init: self
				)
			)
			(2
				(gCurRoom setScript: flyToOracle)
			)
		)
	)
)

(instance savedCelesteTXT of CartoonScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 2)
			)
			(1
				(kingarm setLoop: 1 setCycle: End)
				(AzurePrint addText: 1 0 4 1 init:) ; "(COLD, RELUCTANTLY RESPECTFUL) I see you have proven yourself the 'hero' of the prophecy. Well, I am expected to thank you for saving my daughter's life, so I thank you."
			)
			(2
				(kingarm setCycle: Beg)
				(= cycles 2)
			)
			(3
				(AzurePrint addText: 1 0 4 2 init:) ; "I am obliged to thank you for the restoration of our sacred catacombs. It means much to our people. We have already begun the process of clearing the deadly traps from its rooms."
			)
			(4
				(= cycles 2)
			)
			(5
				(AzurePrint addText: 1 0 4 3 init:) ; "It is also my duty to grant you a visit with the Oracle, so this I do. I will grant you the freedom to leave here unharmed, despite my orders to the contrary from the Crown. But there my obligations to you end."
			)
			(6
				(= cycles 2)
			)
			(7
				(kingarm setLoop: 1 setCycle: End)
				(AzurePrint addText: 1 0 4 4 init:) ; "I have no love for Alhazred, but he is my liege, and if Princess Cassima trusts him and wishes to wed him...."
			)
			(8
				(kingarm setCycle: Beg)
				(= cycles 2)
			)
			(9
				(AzurePrint addText: 1 0 4 5 init:) ; "My guards will take you to the Oracle now. When your time with her is through, I want you to leave the City of the Winged Ones and never return."
			)
			(10
				(= cycles 2)
			)
			(11
				(kingarm setLoop: 1 setCycle: End)
				(AzurePrint addText: 1 0 4 6 init:) ; "I don't know who you are or what you want here, but I will not disobey my Crown further."
			)
			(12
				(kingarm setCycle: Beg)
				(= cycles 2)
			)
			(13
				(AlexPrint addText: 1 0 4 7 init:) ; "(BOWING, RESPECTFUL) I thank you, Lord Azure. I will respect your wishes."
			)
			(14
				(gCurRoom setScript: flyToOracle)
			)
		)
	)
)

(instance flyToOracle of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo hide:)
				(egoLegs dispose:)
				(lHand dispose:)
				(rHand dispose:)
				(myHead dispose:)
				(kingarm dispose:)
				(queenHand dispose:)
				(candle1 dispose:)
				(candle2 dispose:)
				(gCurRoom drawPic: 350 10)
				(= seconds 3)
			)
			(1
				(flyer
					posn: 139 11
					setLoop: 1
					setScale: Scaler 50 49 190 0
					init:
					setCycle: Fwd
					setMotion: MoveTo 174 14 self
				)
			)
			(2
				(flyer dispose:)
				(= cycles 2)
			)
			(3
				(gCurRoom drawPic: 98)
				(= seconds 3)
			)
			(4
				(gGlobalSound fade: 0 15 15)
				(gCurRoom newRoom: 380)
			)
		)
	)
)

(instance flyToCliff of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCurRoom drawPic: 350 10)
				(flyer
					posn: 139 11
					setLoop: 1
					setScale: Scaler 50 49 190 0
					init:
					setCycle: Fwd
					setMotion: MoveTo 280 -15 self
				)
			)
			(1
				(gGlobalSound fade: 0 15 15)
				(gCurRoom newRoom: 340)
			)
		)
	)
)

(instance flyToBeach of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCurRoom drawPic: 350 10)
				(flyer
					posn: 139 11
					setLoop: 1
					setScale: Scaler 50 49 190 0
					init:
					setCycle: Fwd
					setMotion: MoveTo 280 -15 self
				)
			)
			(1
				(gGlobalSound fade: 0 15 15)
				(gCurRoom newRoom: 300)
			)
		)
	)
)

(instance egoLegs of View
	(properties
		x 152
		y 189
		view 374
		loop 1
		priority 14
		signal 16400
	)
)

(instance lHand of View
	(properties
		x 123
		y 137
		view 374
		loop 2
		priority 13
		signal 16400
	)
)

(instance rHand of View
	(properties
		x 183
		y 138
		view 374
		loop 3
		priority 13
		signal 16400
	)
)

(instance myHead of View
	(properties
		x 145
		y 50
		view 374
		loop 5
		cel 1
		priority 15
		signal 16400
	)
)

(instance candle1 of Prop
	(properties
		x 34
		y 68
		view 371
		cel 1
		signal 16384
	)
)

(instance candle2 of Prop
	(properties
		x 285
		y 69
		view 371
		loop 1
		cel 2
		signal 16384
	)
)

(instance kingarm of Actor
	(properties
		x 103
		y 56
		view 370
		signal 16384
		cycleSpeed 20
	)
)

(instance queenHand of Actor
	(properties
		x 173
		y 78
		view 370
		loop 3
		signal 16384
	)
)

