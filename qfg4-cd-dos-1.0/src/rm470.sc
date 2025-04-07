;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 470)
(include sci.sh)
(use Main)
(use GloryRm)
(use Teller)
(use GloryTalker)
(use Interface)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm470 0
	gTalker 1
	fTalker 2
)

(local
	local0
	local1
	local2
)

(instance rm470 of GloryRm
	(properties
		noun 20
		picture 470
	)

	(method (init)
		(gEgo posn: 1000 1000 init: hide:)
		(if gDebugging
			(= local0 (GetNumber {Event #?}))
		else
			(= local0
				(cond
					(
						(and
							(IsFlag 273)
							(IsFlag 272)
							(IsFlag 274)
							(IsFlag 275)
							(IsFlag 277)
							(IsFlag 110)
							(not (IsFlag 278))
							(== gPrevRoomNum 460)
						)
						13
					)
					(
						(and
							(IsFlag 273)
							(IsFlag 272)
							(IsFlag 274)
							(IsFlag 275)
							(IsFlag 277)
							(IsFlag 110)
							(== gPrevRoomNum 475)
						)
						12
					)
					(
						(and
							(IsFlag 273)
							(IsFlag 272)
							(IsFlag 274)
							(IsFlag 275)
							(IsFlag 110)
							(not (IsFlag 277))
							(not (IsFlag 278))
							(== gPrevRoomNum 460)
						)
						11
					)
					(
						(and
							(IsFlag 273)
							(IsFlag 272)
							(IsFlag 274)
							(IsFlag 275)
							(IsFlag 276)
							(== gPrevRoomNum 475)
						)
						10
					)
					(
						(and
							(IsFlag 273)
							(IsFlag 272)
							(IsFlag 274)
							(IsFlag 275)
							(not (IsFlag 110))
							(== gPrevRoomNum 460)
						)
						9
					)
					(
						(and
							(IsFlag 273)
							(IsFlag 272)
							(IsFlag 274)
							(IsFlag 275)
							(== gPrevRoomNum 475)
						)
						8
					)
					(
						(and
							(IsFlag 273)
							(IsFlag 272)
							(IsFlag 274)
							(not (IsFlag 275))
							(== gPrevRoomNum 460)
						)
						7
					)
					(
						(and
							(IsFlag 273)
							(IsFlag 272)
							(IsFlag 274)
							(== gPrevRoomNum 475)
						)
						6
					)
					(
						(and
							(IsFlag 273)
							(IsFlag 272)
							(not (IsFlag 115))
							(== gPrevRoomNum 460)
						)
						5
					)
					((and (IsFlag 273) (== gPrevRoomNum 475)) 4)
					((and (IsFlag 272) (not (IsFlag 273)) (== gPrevRoomNum 460)) 3)
					((and (IsFlag 272) (== gPrevRoomNum 475)) 2)
					((and (not (IsFlag 272)) (== gPrevRoomNum 460)) 1)
					(else 13)
				)
			)
		)
		(cond
			((== local0 7)
				(if (not (IsFlag 115))
					(= local0 5)
				)
			)
			((and (== local0 8) (not (IsFlag 115)))
				(= local0 6)
			)
		)
		(gWalkHandler addToFront: self)
		(pCandles2 init: cycleSpeed: 12 setCycle: Fwd)
		(pHands init:)
		(pBracelet init: cycleSpeed: 12 setCycle: Fwd)
		(pOHands init:)
		(pShirt2 init: cycleSpeed: 12 setCycle: Fwd)
		(pShirt init: cycleSpeed: 12 setCycle: Fwd)
		(pEarring2 init: cycleSpeed: 12 setCycle: Fwd)
		(pEarring init: cycleSpeed: 12 setCycle: Fwd)
		(pEyes init: setScript: sDoTheEyes)
		(pEyes2 init: setScript: sDoSecondEyes)
		(pReflect init: cycleSpeed: 12 setCycle: Fwd)
		(super init: &rest)
		(gLongSong number: 470 setLoop: -1 play:)
		(fGarlic1 init:)
		(fGarlic2 init:)
		(fDavy init:)
		(fFortuneTeller init:)
		(fRing init:)
		(fBracelet init:)
		(fCards init:)
		(fHero init:)
		(fCandle1 init:)
		(fCandle2 init:)
		(fCurtain1 init:)
		(fCurtain2 init:)
		(fPeppers init:)
		(fChair init:)
		(fPlant init:)
		(fPot init:)
		(fTable init:)
		(gCurRoom setScript: sInTheRoom)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Walk
				(gCurRoom setScript: sBackTo460)
				(return 1)
			)
			(80 ; openSpell
				(gMessager say: 20 80 0 0) ; "This isn't a good place to use that spell."
				(return 1)
			)
			(87 ; fetchSpell
				(gMessager say: 20 87 0 0) ; "This isn't a good place to use that spell."
				(return 1)
			)
			(1 ; Look
				(gMessager say: 20 1 0 0) ; "You are in the cramped interior of the gypsy fortuneteller's wagon. A large table with three chairs dominates this main section of the wagon. A deck of Tarot cards lies ready on the table."
				(return 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(gWalkHandler delete: self)
		(super dispose:)
	)
)

(instance sInTheRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(= seconds 4)
			)
			(1
				(switch local0
					(1
						(SetFlag 272)
						(davyTeller init: fDavy 470 2 139 4)
						(fortuneTeller init: fFortuneTeller 470 2 177 4)
						(egoTeller init: fHero 470 2 128 4)
						(gMessager say: 1 6 22 0 self) ; "So you are the one my son spoke of. You saved his life."
					)
					(2
						(davyTeller init: fDavy 470 2 139 4)
						(fortuneTeller init: fFortuneTeller 470 2 177 4)
						(egoTeller init: fHero 470 2 128 4)
						(gMessager say: 1 6 47 0 self) ; "Make what you will of your Fortune. I will speak no more of it."
					)
					(3
						(SetFlag 273)
						(davyTeller init: fDavy 470 2 139 9)
						(fortuneTeller init: fFortuneTeller 470 2 177 9)
						(egoTeller init: fHero 470 2 128 9)
						(self cue:)
					)
					(4
						(davyTeller init: fDavy 470 2 139 9)
						(fortuneTeller init: fFortuneTeller 470 2 177 9)
						(egoTeller init: fHero 470 2 128 9)
						(gMessager say: 1 6 80 0 self) ; "The cards have spoken, and that is all I will say about them now. If you wish to learn more, come another time."
					)
					(5
						(SetFlag 274)
						(davyTeller init: fDavy 470 2 139 10)
						(fortuneTeller init: fFortuneTeller 470 2 177 10)
						(egoTeller init: fHero 470 2 128 10)
						(self cue:)
					)
					(6
						(davyTeller init: fDavy 470 2 139 10)
						(fortuneTeller init: fFortuneTeller 470 2 177 10)
						(egoTeller init: fHero 470 2 128 10)
						(gMessager say: 1 6 96 0 self) ; "The cards have spoken, and so have I."
					)
					(7
						(SetFlag 275)
						(davyTeller init: fDavy 470 2 139 11)
						(fortuneTeller init: fFortuneTeller 470 2 177 11)
						(egoTeller init: fHero 470 2 128 11)
						(gMessager say: 1 6 102 0 self) ; "In my dreams last night I heard Erana's staff speak."
					)
					(8
						(davyTeller init: fDavy 470 2 139 11)
						(fortuneTeller init: fFortuneTeller 470 2 177 11)
						(egoTeller init: fHero 470 2 128 11)
						(gMessager say: 1 6 103 0 self) ; "These Readings get increasingly more difficult for me. They draw an incredible amount of power from me."
					)
					(9
						(SetFlag 276)
						(davyTeller init: fDavy 470 2 139 12)
						(fortuneTeller init: fFortuneTeller 470 2 177 12)
						(egoTeller init: fHero 470 2 128 12)
						(proc0_17 1 6 3 self 470)
					)
					(10
						(davyTeller init: fDavy 470 2 139 12)
						(fortuneTeller init: fFortuneTeller 470 2 177 12)
						(egoTeller init: fHero 470 2 128 12)
						(gMessager say: 1 6 111 0 self) ; "Make what you will of the cards' message. I will say no more."
					)
					(11
						(SetFlag 277)
						(davyTeller init: fDavy 470 2 139 13)
						(fortuneTeller init: fFortuneTeller 470 2 177 13)
						(egoTeller init: fHero 470 2 128 13)
						(gMessager say: 1 6 114 0 self) ; "Welcome. I know that you have been through much since last we saw you."
					)
					(12
						(davyTeller init: fDavy 470 2 139 13)
						(fortuneTeller init: fFortuneTeller 470 2 177 13)
						(egoTeller init: fHero 470 2 128 13)
						(gMessager say: 1 6 115 0 self) ; "That is all the cards can reveal. It took all my power to read this. May it serve you well."
					)
					(13
						(SetFlag 278)
						(davyTeller init: fDavy 470 2 139 14)
						(fortuneTeller init: fFortuneTeller 470 2 177 14)
						(egoTeller init: fHero 470 2 128 14)
						(proc0_17 1 6 3 self 470)
					)
					(else
						(proc0_17 1 6 3 self 470)
					)
				)
			)
			(2
				(if (== gPrevRoomNum 460)
					(if (OneOf local0 3 5)
						(cond
							(
								(and
									(not (IsFlag 279))
									(== gHeroType 2) ; Thief
									(not (IsFlag 513))
								)
								(SetFlag 279)
								(gMessager say: 1 6 4 0 self) ; "I hoped you would come today. I dreamed of you last night."
							)
							(
								(and
									(not (IsFlag 280))
									(IsFlag 135)
									(not (IsFlag 138))
								)
								(SetFlag 280)
								(gMessager say: 1 6 5 0 self) ; "You haunt my dreams at night. You are like one of my own children, that I see images of your life before me."
							)
							(
								(and
									(not (IsFlag 281))
									(== gHeroType 12)
									(not (IsFlag 269))
								)
								(SetFlag 281)
								(gMessager say: 1 6 6 0 self) ; "Dreams and dreams again. You haunt me at night. Things you have done and things you might do swirl around me."
							)
							(
								(and
									(not (IsFlag 282))
									(== gHeroType 3) ; Paladin
									(IsFlag 116)
									(not (IsFlag 228))
								)
								(SetFlag 282)
								(gMessager say: 1 6 7 0 self) ; "I had a vision of you again last night. I saw you walking by a lake. A woman rose from it and reached for you. I tried to yell to you, 'Beware! Rusalka!' but you could not hear."
							)
							(
								(and
									(not (IsFlag 283))
									(IsFlag 129)
									(not (IsFlag 130))
								)
								(SetFlag 283)
								(gMessager say: 1 6 8 0 self) ; "I have seen in a vision that you have a friend in need. A stranger to this land like yourself, you speak with him in his room at the Inn. This friendship will send you on a very strange quest."
							)
							(
								(and
									(not (IsFlag 284))
									(IsFlag 166)
									(IsFlag 179)
									(not (gEgo has: 30)) ; theBerries
								)
								(SetFlag 284)
								(if (== gHeroType 12)
									(gMessager say: 1 6 15 0 self) ; "I had a vision of you last night."
								else
									(gMessager say: 1 6 16 0 self) ; "Last night I had a most strange vision."
								)
							)
							(
								(and
									(not (IsFlag 285))
									(IsFlag 513)
									(not (IsFlag 514))
								)
								(SetFlag 285)
								(gMessager say: 1 6 17 0 self) ; "I had a dream of you again."
							)
							(
								(and
									(not (IsFlag 286))
									(IsFlag 117)
									(== gHeroType 3) ; Paladin
									(not (IsFlag 62))
								)
								(SetFlag 286)
								(gMessager say: 1 6 18 0 self) ; "I had a vision about you again."
							)
							(
								(and
									(not (IsFlag 287))
									(== gHeroType 12)
									(IsFlag 156)
									(not (IsFlag 270))
								)
								(SetFlag 287)
								(gMessager say: 1 6 19 0 self) ; "I had a vision last night again."
							)
							(
								(and
									(not (IsFlag 288))
									(IsFlag 139)
									(not (IsFlag 143))
								)
								(SetFlag 288)
								(gMessager say: 1 6 20 0 self) ; "I have had many dreams about you, but last night, I dreamed of a child."
							)
							(
								(and
									(not (IsFlag 289))
									(IsFlag 141)
									(not (IsFlag 143))
								)
								(SetFlag 289)
								(gMessager say: 1 6 21 0 self) ; "I had another dream last night."
							)
							(else
								(proc0_17 1 6 3 self 470)
							)
						)
					else
						(self cue:)
					)
				else
					(self cue:)
				)
			)
			(3
				(switch local0
					(1
						(if (> [gEgoStats 12] 0) ; magic
							(gEgo solvePuzzle: 495 6 2 2)
							(gEgo learn: 37 100) ; auraSpell
							(gMessager say: 1 6 23 0 self) ; "I will teach you a spell. It will protect you against the dead that rise again. I think you will find this most useful in your questings."
						else
							(gEgo get: 37) ; theAmulet
							(gMessager say: 1 6 24 0 self) ; "I will give you a gift for saving my son. I sense it will be most useful in your adventuring. Take this Amulet. It will protect you from the dead that will not die."
						)
					)
					(11
						(gEgo show:)
						(gCurRoom newRoom: 475)
					)
					(else
						(self cue:)
					)
				)
			)
			(4
				(if (== local0 1)
					(sndGets play:)
				)
				(self cue:)
			)
			(5
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sBackTo460 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gMessager say: 2 128 63 0 self) ; "You say goodbye."
			)
			(1
				(if (== local0 2)
					(gMessager say: 2 128 46 0 self) ; "Ah, you weary of talk? Good. You are a guest with us tonight. Let us join the others for food, drink, and dance."
				else
					(= ticks 1)
				)
			)
			(2
				(switch local0
					(1
						(gMessager say: 1 6 25 0 self) ; "Farewell, young hero. Perhaps sometime I can read your fortune in the cards for you."
					)
					(2
						(gMessager say: 1 6 48 0 self) ; "I hope you will enjoy the hospitality of my people."
					)
					(3
						(gMessager say: 1 6 79 0 self) ; "Farewell. Perhaps another time, I will read your Future for a coin."
					)
					(4
						(gMessager say: 1 6 81 0 self) ; "May the wind be in your face, and the hunting good."
					)
					(5
						(proc0_17 1 6 84 self 470)
					)
					(6
						(proc0_17 1 6 84 self 470)
					)
					(7
						(gMessager say: 1 6 85 0 self) ; "May your luck hold true. Be wary, for your enemies may soon act against you."
					)
					(8
						(gMessager say: 1 6 85 0 self) ; "May your luck hold true. Be wary, for your enemies may soon act against you."
					)
					(else
						(proc0_17 1 6 84 self 470)
					)
				)
			)
			(3
				(if (or (== local0 1) (== local0 2))
					(gMessager say: 8 6 49 0 self) ; "You spend the evening in the joyful company of the gypsies."
				else
					(= ticks 1)
				)
			)
			(4
				(gEgo show:)
				(gCurRoom newRoom: 460)
			)
		)
	)
)

(instance sDoTheEyes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 1 3))
			)
			(1
				(= local1 (Random 1 4))
				(if (OneOf local1 2 3)
					(pEyes setPri: 152 setCel: 0 setCycle: End self)
				else
					(self cue:)
				)
			)
			(2
				(if (OneOf local1 3 4)
					(pHands setCycle: End self)
				else
					(self cue:)
				)
			)
			(3
				(self changeState: 0)
			)
		)
	)
)

(instance sDoSecondEyes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 1 3))
			)
			(1
				(= local2 (Random 1 4))
				(if (OneOf local2 2 3)
					(pEyes2 setPri: 152 setCel: 0 setCycle: End self)
				else
					(self cue:)
				)
			)
			(2
				(if (OneOf local2 3 4)
					(pOHands setCycle: End self)
				else
					(self cue:)
				)
			)
			(3
				(self changeState: 0)
			)
		)
	)
)

(instance pCandle of Prop ; UNUSED
	(properties
		x 114
		y 130
		view 470
		signal 4097
		detailLevel 2
	)
)

(instance pReflect of Prop
	(properties
		x 197
		y 120
		view 470
		loop 1
		cel 3
		signal 4097
		detailLevel 2
	)

	(method (init)
		(super init:)
		(= actions egoTeller)
	)
)

(instance pEyes2 of Prop
	(properties
		x 159
		y 40
		view 471
		loop 1
		cel 3
		signal 4097
		detailLevel 2
	)

	(method (doVerb theVerb)
		(fortuneTeller doVerb: theVerb)
	)
)

(instance pEyes of Prop
	(properties
		x 92
		y 25
		view 471
		cel 3
		signal 4097
		detailLevel 2
	)

	(method (doVerb theVerb)
		(davyTeller doVerb: theVerb)
	)
)

(instance pEarring of Prop
	(properties
		x 147
		y 60
		view 471
		loop 2
		cel 2
		signal 4097
		detailLevel 2
	)

	(method (doVerb theVerb)
		(fortuneTeller doVerb: theVerb)
	)
)

(instance pEarring2 of Prop
	(properties
		x 170
		y 62
		view 471
		loop 3
		cel 2
		signal 4097
		detailLevel 2
	)

	(method (doVerb theVerb)
		(fortuneTeller doVerb: theVerb)
	)
)

(instance pShirt of Prop
	(properties
		x 85
		y 74
		view 471
		loop 4
		signal 4097
		detailLevel 2
	)

	(method (doVerb theVerb)
		(davyTeller doVerb: theVerb)
	)
)

(instance pShirt2 of Prop
	(properties
		x 89
		y 90
		view 471
		loop 5
		cel 3
		signal 4097
		detailLevel 2
	)

	(method (doVerb theVerb)
		(davyTeller doVerb: theVerb)
	)
)

(instance pOHands of Prop
	(properties
		x 92
		y 130
		view 471
		loop 6
		cel 3
		signal 4097
		detailLevel 2
	)

	(method (doVerb theVerb)
		(davyTeller doVerb: theVerb)
	)
)

(instance pBracelet of Prop
	(properties
		x 156
		y 115
		view 471
		loop 7
		cel 2
		signal 4097
		detailLevel 2
	)

	(method (doVerb theVerb)
		(fortuneTeller doVerb: theVerb)
	)
)

(instance pHands of Prop
	(properties
		x 156
		y 115
		view 471
		loop 8
		signal 20481
		detailLevel 2
	)

	(method (doVerb theVerb)
		(fortuneTeller doVerb: theVerb)
	)
)

(instance pCandles2 of Prop
	(properties
		x 78
		y 149
		view 471
		loop 10
		cel 2
		signal 4097
		detailLevel 2
	)
)

(instance fGarlic1 of Feature
	(properties
		noun 21
		nsLeft 22
		nsTop 1
		nsRight 40
		nsBottom 72
		sightAngle 40
		x 31
		y 36
	)
)

(instance fGarlic2 of Feature
	(properties
		noun 21
		nsLeft 241
		nsTop 51
		nsRight 263
		nsBottom 93
		sightAngle 40
		x 252
		y 72
	)
)

(instance fDavy of Feature
	(properties
		noun 22
		nsLeft 65
		nsTop 16
		nsRight 104
		nsBottom 125
		sightAngle 40
		x 84
		y 70
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(gMessager say: 22 1 0 0) ; "Gypsy Davy shifts his gaze between you and the fortuneteller from time to time. He obviously holds her in great respect."
		else
			(super doVerb: theVerb)
		)
	)
)

(instance fFortuneTeller of Feature
	(properties
		noun 1
		nsLeft 113
		nsTop 27
		nsRight 179
		nsBottom 108
		sightAngle 40
		x 146
		y 67
	)

	(method (doVerb theVerb &tmp temp0)
		(if (== theVerb 15) ; thePurse
			(cond
				((and (not ((gInventory at: 0) amount:)) (<= global395 99)) ; thePurse
					(gMessager say: 1 6 9) ; "I am sorry, but you must pay for a true Fortune Reading. It is in the Gypsy Union Rules. Perhaps you could return later when you have more money."
				)
				((and (!= gPrevRoomNum 475) (!= gDay global473))
					(if (not (IsFlag 278))
						(if (and (not (IsFlag 110)) (IsFlag 300))
							(gMessager say: 1 15 11) ; "Forgive me, but I cannot get a Reading from the cards right now. Each comes up as a Void Card, the Black one. I will let you know when the time is right to read again."
						else
							(= global473 gDay)
							(gEgo solvePuzzle: 443 2)
							(if (>= global395 100)
								(-= global395 100)
							else
								((gInventory at: 0) ; thePurse
									amount: (- ((gInventory at: 0) amount:) 1) ; thePurse
								)
							)
							(gEgo show:)
							(gCurRoom newRoom: 475)
						)
					else
						(gMessager say: 1 15 10) ; "I am sorry, but that is all the future that the Cards will show."
					)
				)
				(else
					(gMessager say: 1 6 82) ; "Forgive me. A Reading takes a good deal of magic from me. I can only do this once a day."
				)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance fRing of Feature
	(properties
		noun 23
		nsLeft 133
		nsTop 116
		nsRight 142
		nsBottom 120
		sightAngle 40
		x 137
		y 138
		z 20
	)
)

(instance fBracelet of Feature
	(properties
		noun 24
		nsLeft 156
		nsTop 102
		nsRight 173
		nsBottom 114
		sightAngle 40
		x 164
		y 128
		z 20
	)
)

(instance fCards of Feature
	(properties
		noun 25
		nsLeft 125
		nsTop 121
		nsRight 163
		nsBottom 127
		sightAngle 40
		x 144
		y 189
		z 65
	)
)

(instance fHero of Feature
	(properties
		noun 2
		modNum 28
		nsLeft 184
		nsTop 35
		nsRight 236
		nsBottom 137
		sightAngle 40
		x 210
		y 86
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(gMessager say: 34 1 0 0) ; "The flickering candlelight adds an air of mystery to your appearance."
			(return 1)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance fCandle1 of Feature
	(properties
		noun 26
		nsLeft 106
		nsTop 110
		nsRight 120
		nsBottom 128
		sightAngle 40
		x 113
		y 139
		z 20
	)
)

(instance fCandle2 of Feature
	(properties
		noun 26
		nsLeft 77
		nsTop 130
		nsRight 102
		nsBottom 149
		sightAngle 40
		x 89
		y 139
	)
)

(instance fCurtain1 of Feature
	(properties
		noun 27
		nsTop 38
		nsRight 21
		nsBottom 59
		sightAngle 40
		x 10
		y 48
	)
)

(instance fCurtain2 of Feature
	(properties
		noun 27
		nsLeft 43
		nsTop 1
		nsRight 138
		nsBottom 42
		sightAngle 40
		x 90
		y 21
	)
)

(instance fPeppers of Feature
	(properties
		noun 28
		nsLeft 220
		nsTop 1
		nsRight 319
		nsBottom 70
		sightAngle 40
		x 269
		y 35
	)
)

(instance fChair of Feature
	(properties
		noun 29
		nsLeft 225
		nsTop 101
		nsRight 308
		nsBottom 152
		sightAngle 40
		x 266
		y 126
	)
)

(instance fPlant of Feature
	(properties
		noun 30
		nsLeft 27
		nsTop 74
		nsRight 63
		nsBottom 123
		sightAngle 40
		x 45
		y 98
	)
)

(instance fPot of Feature
	(properties
		noun 31
		nsLeft 21
		nsTop 124
		nsRight 68
		nsBottom 154
		sightAngle 40
		x 44
		y 139
	)
)

(instance fTable of Feature
	(properties
		noun 32
		nsLeft 15
		nsTop 112
		nsRight 182
		nsBottom 140
		sightAngle 40
		x 98
		y 126
	)
)

(instance fortuneTeller of Teller
	(properties)

	(method (init)
		(super init: &rest)
		(= talker fTalker)
	)

	(method (showCases)
		(super
			showCases:
				1 ; Baba Yaga
				(and (IsFlag 150) (not (IsFlag 291)))
				2 ; Helping Rusalka
				(and (IsFlag 116) (not (IsFlag 228)) (not (IsFlag 292)))
				132
				(and (IsFlag 237) (not (IsFlag 312)) (not (IsFlag 314)))
		)
	)

	(method (sayMessage)
		(switch iconValue
			(131 ; Destiny Spell
				(SetFlag 144)
			)
			(1 ; Baba Yaga
				(SetFlag 291)
			)
			(2 ; Helping Rusalka
				(SetFlag 313)
			)
			(132
				(SetFlag 314)
			)
		)
		(super sayMessage: &rest)
	)
)

(instance davyTeller of Teller
	(properties)

	(method (init)
		(super init: &rest)
		(= talker gTalker)
	)

	(method (sayMessage)
		(if (== iconValue 78) ; Hunting
			(SetFlag 186)
		)
		(super sayMessage: &rest)
	)
)

(instance egoTeller of Teller
	(properties)

	(method (showCases)
		(super
			showCases:
				8 ; Tell About Gnome
				(and (IsFlag 159) global348 (not (IsFlag 293)))
				12 ; Tell About Scary Dream
				(and
					(> global345 0)
					(not (>= global345 10))
					(not (IsFlag 294))
				)
				13 ; Tell About the Erana Dream
				(and (IsFlag 153) (not (IsFlag 295)))
				14 ; Tell About Baba's Pie
				(and (IsFlag 166) (not (IsFlag 179)) (not (IsFlag 296)))
		)
	)

	(method (sayMessage)
		(switch iconValue
			(2
				(SetFlag 292)
				(super sayMessage:)
			)
			(8 ; Tell About Gnome
				(SetFlag 293)
				(super sayMessage:) ; You tell about the Gnome and his problems.
			)
			(12 ; Tell About Scary Dream
				(SetFlag 294)
				(super sayMessage:) ; You tell her about the frightening dream.
			)
			(13 ; Tell About the Erana Dream
				(SetFlag 295)
				(super sayMessage:) ; You tell about your dream of Erana.
			)
			(14 ; Tell About Baba's Pie
				(SetFlag 296)
				(super sayMessage:) ; You tell about Baba Yaga and your search for Elderbury Pie.
			)
			(46 ; Say Goodbye
				(self clean:)
				(gCurRoom setScript: sBackTo460)
			)
			(63 ; Say Goodbye
				(ClearFlag 51)
				(= gTeller 0)
				(gCurRoom setScript: sBackTo460)
			)
			(else
				(super sayMessage: &rest)
			)
		)
	)
)

(instance sndGets of Sound
	(properties
		number 934
	)
)

(instance gTalker of GloryTalker
	(properties
		x 0
		y 17
		talkWidth 250
		view 467
		textX 5
		textY 110
	)

	(method (init)
		(super init: gMouth 0 gEyes gFrame &rest)
	)
)

(instance gFrame of View
	(properties
		view 467
	)
)

(instance gMouth of Prop
	(properties
		x 78
		y 38
		view 467
		loop 1
	)
)

(instance gEyes of Prop
	(properties
		x 72
		y 25
		view 467
		loop 2
	)
)

(instance fTalker of GloryTalker
	(properties
		x 130
		y 0
		talkWidth 319
		view 468
		textX 100
		textY 130
	)

	(method (init)
		(super init: fMouth 0 fEyes fFrame &rest)
	)
)

(instance fFrame of View
	(properties
		view 468
	)
)

(instance fMouth of Prop
	(properties
		x 145
		y 52
		view 468
		loop 1
	)
)

(instance fEyes of Prop
	(properties
		x 136
		y 39
		view 468
		loop 2
	)
)

