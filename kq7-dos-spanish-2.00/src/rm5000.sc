;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5000)
(include sci.sh)
(use Main)
(use ExitButton)
(use skipCartoon)
(use eastFeat)
(use Talker)
(use Scaler)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm5000 0
	mockTalker 1
)

(procedure (localproc_0)
	(cond
		((and (not (IsFlag 440)) (IsFlag 441) (IsFlag 439))
			(cond
				((and (IsFlag 280) (IsFlag 279))
					(shopOwner deleteHotVerb: 5 deleteHotVerb: 61) ; Golden_Comb, Magic_Statue
				)
				((IsFlag 280)
					(shopOwner deleteHotVerb: 5) ; Golden_Comb
				)
				((IsFlag 279)
					(shopOwner deleteHotVerb: 61) ; Magic_Statue
				)
				(else
					(shopOwner deleteHotVerb: 8) ; Do
				)
			)
		)
		((IsFlag 439)
			(cond
				((and (IsFlag 280) (IsFlag 279))
					(shopOwner deleteHotVerb: 5 deleteHotVerb: 61) ; Golden_Comb, Magic_Statue
				)
				((IsFlag 280)
					(shopOwner deleteHotVerb: 61) ; Magic_Statue
				)
				((IsFlag 279)
					(shopOwner deleteHotVerb: 5) ; Golden_Comb
				)
			)
		)
		((and (IsFlag 280) (IsFlag 279))
			(shopOwner deleteHotVerb: 5 deleteHotVerb: 61) ; Golden_Comb, Magic_Statue
		)
		((IsFlag 279)
			(shopOwner deleteHotVerb: 5) ; Golden_Comb
		)
		((IsFlag 280)
			(shopOwner deleteHotVerb: 61) ; Magic_Statue
		)
		(else 0)
	)
)

(instance rm5000 of KQRoom
	(properties
		picture 5000
	)

	(method (init)
		(Load rsSOUND 5000)
		(Load rsSOUND 801)
		(fauxSound number: 5000 loop: -1 play:)
		(super init:)
		(gEgo
			init:
			posn: 170 220
			setScaler: Scaler 125 100 134 101
			normalize: 3
		)
		(mySouthExit init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 97 120 71 136 231 136 215 105 157 105 139 113
					yourself:
				)
		)
		(Load rsMESSAGE 5000)
		(Load rsVIEW 5001)
		(shopOwner
			ignoreActors: 1
			signal: (| (shopOwner signal:) $1000)
			setCel: 9
			init:
		)
		(if (not (IsFlag 121))
			(rubberChicken setPri: 43 init:)
		)
		(switch gValOrRoz
			(-4 ; Val
				(if (== gChapter 3)
					(if (not (IsFlag 125))
						(books init:)
					)
					(masks init:)
					(catClock cycleSpeed: 30 init: setCycle: Fwd)
					(feet init:)
					(fakeFlower approachVerbs: 8 10 init:) ; Do, Exit
					(fakeOwl init:)
					(fakeNose init:)
					(leftCase init:)
					(rattleSnake init:)
				else
					(theCatClock cycleSpeed: 30 init: setCycle: Fwd)
				)
			)
			(else
				(theCatClock cycleSpeed: 30 init: setCycle: Fwd)
				(lavaLamp init:)
				(fishBowl init:)
				(fakeSpider init:)
				(fakeFlower approachVerbs: 8 10 init:) ; Do, Exit
				(duck init:)
				(artFlavorBox init:)
			)
		)
		(cond
			((and (not (IsFlag 443)) (== gValOrRoz -4)) ; Val
				(SetFlag 443)
				(gCurRoom setScript: sIntro)
			)
			((and (not (IsFlag 442)) (== gValOrRoz -3)) ; Roz
				(SetFlag 442)
				(gCurRoom setScript: sIntro)
			)
		)
		(if (not (gCurRoom script:))
			(gCurRoom setScript: sSecondIntro)
		)
	)

	(method (dispose)
		((ScriptID 7001 0) ; kingTalker
			clientCel: -1
			loop: -1
			view: -1
			mouth_x: -999
			mouth_y: -999
			hide_mouth: 0
			client: self
		)
		(super dispose:)
	)
)

(instance sToPlaza of Script
	(properties)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(Load rsSOUND 801)
					(gEgo setMotion: MoveTo (gEgo x:) 220 self)
				)
				(1
					(doorSound number: 801 loop: 1 play: self)
				)
				(2
					(gCurRoom newRoom: 5300)
				)
			)
		else
			(switch (= state newState)
				(0
					(ClearFlag 539)
					(gCurRoom newRoom: 5300)
				)
			)
		)
	)
)

(instance sIntro of Script
	(properties)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(doorSound number: 802 loop: 1 play:)
					(= seconds 2)
				)
				(1
					(gEgo setMotion: MoveTo 170 106 self)
				)
				(2
					(gEgo setHeading: 315 self)
				)
				(3
					(if (== gValOrRoz -4) ; Val
						(gMessager say: 0 0 1 0 self) ; "Oh, hello, madam. Let me know if I can help you with anything."
					else
						(gMessager say: 0 0 8 0 self) ; "Good day, my lady. Welcome to my shop. Let me know if I can help you."
					)
				)
				(4
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(ClearFlag 539)
					(shopOwner setCycle: 0)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance sSecondIntro of Script
	(properties)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(doorSound number: 802 loop: 1 play:)
					(= seconds 2)
				)
				(1
					(gEgo setMotion: MoveTo 170 106 self)
				)
				(2
					(gEgo setHeading: 315 self)
				)
				(3
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(ClearFlag 539)
					(shopOwner setCycle: 0)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance getTheChicken of Script
	(properties)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOff: 1)
					(SetFlag 121)
					(gMessager sayRange: 1 57 0 1 2 self) ; "Would you be interested in this lovely mask, Ersatz?"
				)
				(1
					(shopOwner
						setLoop: 3
						setCel: 0
						posn: 156 65
						setCycle: End self
					)
				)
				(2
					(rubberChicken dispose:)
					(shopOwner
						setLoop: 4
						setCel: 0
						posn: 40 73
						setCycle: CT 23 1 self
					)
					(Load rsVIEW 8075)
				)
				(3
					(shopOwner cel: 23 loop: 4 setCycle: End self)
				)
				(4
					(shopOwner setLoop: 0 posn: 168 61 setCel: 9 setCycle: 0)
					(gMessager say: 1 57 0 3 self) ; "Here, take this rubber chicken."
				)
				(5
					(gEgo
						view: 8075
						loop: 1
						cel: 0
						posn: 170 106
						setCycle: End self
					)
				)
				(6
					(gEgo put: 43 get: 46) ; Mask, Rubber_Chicken
					(gEgo loop: 1 cel: 5 setCycle: Beg self)
				)
				(7
					(gEgo normalize: 7)
					(gMessager say: 1 57 0 4 self) ; "Ah, thank you, I suppose."
				)
				(8
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(shopOwner setLoop: 0 posn: 162 65 setCel: 9 setCycle: 0)
					(if (gCast contains: rubberChicken)
						(rubberChicken dispose:)
					)
					(SetFlag 121)
					(gEgo normalize: 7 put: 43 get: 46) ; Mask, Rubber_Chicken
					(= cycles 1)
				)
				(1
					(ClearFlag 539)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance buyTheBook of Script
	(properties)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOff: 1)
					(if (IsFlag 444)
						(gMessager say: 1 59 7 1 self) ; "I'd like to purchase one of those books with wooden nickel, please."
					else
						(gMessager say: 1 59 6 1 self) ; "I found this wooden nickel, sir. What could I purchase with it?"
					)
				)
				(1
					(shopOwner
						setLoop: 1
						posn: 152 65
						setCel: 0
						setCycle: CT 6 1 self
					)
				)
				(2
					(shopOwner setLoop: 1 setCel: 13 setCycle: CT 28 1 self)
				)
				(3
					(shopOwner setLoop: 1 setCel: 28 setCycle: End self)
				)
				(4
					(shopOwner setLoop: 1 1 cel: 2 setCycle: CT 0 -1 self)
				)
				(5
					(books setHotspot: 0)
					(books dispose:)
					(shopOwner setLoop: 0 posn: 162 65 setCel: 9)
					(SetFlag 125)
					(= cycles 1)
				)
				(6
					(if (IsFlag 444)
						(gMessager say: 1 59 7 2 self) ; "(PLEASED)Here you are, madam. Enjoy."
					else
						(gMessager say: 1 59 6 2 self) ; "(PLEASED)Why, you can buy this wonderful book! 'The Wit and Wisdom of Faderal'! Here you are, madam."
					)
				)
				(7
					(gEgo
						view: 8075
						loop: 1
						cel: 0
						posn: 170 106
						setCycle: End self
					)
				)
				(8
					(gEgo put: 44 get: 45) ; Wooden_Nickel, Book
					(gEgo
						view: 8075
						loop: 1
						cel: (gEgo cel:)
						posn: 170 106
						setCycle: Beg self
					)
				)
				(9
					(gEgo normalize: 7)
					(= cycles 1)
				)
				(10
					(if (IsFlag 444)
						(= cycles 1)
					else
						(gMessager say: 1 59 6 3 self) ; "Thank you."
					)
				)
				(11
					(gEgo normalize: 7)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(shopOwner setLoop: 0 posn: 162 65 setCel: 9 setCycle: 0)
					(gEgo posn: 170 106 normalize: 7)
					(SetFlag 125)
					(books setHotspot: 0)
					(if (gCast contains: books)
						(books dispose:)
					)
					(if (gEgo has: 44) ; Wooden_Nickel
						(gEgo put: 44) ; Wooden_Nickel
					)
					(if (not (gEgo has: 45)) ; Book
						(gEgo get: 45) ; Book
					)
					(= cycles 1)
				)
				(1
					(ClearFlag 539)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance sComb of Script
	(properties)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(self cue:)
				)
				(1
					(gMessager say: 1 5 2 0 self) ; "(SADLY)Pardon me, sir. This is my daughter's comb. Her name is Rosella, and she has lovely blue eyes and long golden hair. Have you seen or heard of her?"
				)
				(2
					(shopOwner setLoop: 0 posn: 162 65 setCel: 9)
					(= cycles 1)
				)
				(3
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(ClearFlag 539)
					(shopOwner setLoop: 0 posn: 162 65 setCel: 9)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance sStatue of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gMessager say: 1 61 2 0 self) ; "Ersatz, do you know exactly what this is?"
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sChicken of Script
	(properties)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(Load rsSOUND 5001)
					(Load 140 5002) ; WAVE
					(Load rsSOUND 5003)
					(Load rsSOUND 2054)
					(= cycles 2)
				)
				(1
					(chickenSound number: 5001 loop: 1 play: self)
					(rubberChicken setCycle: CT 2 1)
				)
				(2
					(chickenSound number: 5003 loop: 1 play: self)
					(rubberChicken cel: 2 setPri: 120 setCycle: CT 4 1)
				)
				(3
					(chickenSound number: 2054 loop: 1 play:)
					(rubberChicken cel: 4 setCycle: CT 7 1 self)
				)
				(4
					(rubberChicken cel: 4 setCycle: CT 4 -1 self)
				)
				(5
					(gEgo setHeading: 315)
					(rubberChicken cel: 4 setCycle: CT 7 1 self)
				)
				(6
					(gMessager say: 4 8 2 0 self) ; "(ASTONISHED)Is that chicken made of rubber?"
				)
				(7
					(chickenSound number: 5002 loop: 1 play:)
					(rubberChicken cel: 4 setCycle: CT 0 -1 self)
				)
				(8
					(rubberChicken setPri: 43)
					(chickenSound stop:)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(chickenSound stop:)
					(ClearFlag 539)
					(if (not (IsFlag 145))
						(SetFlag 145)
					)
					(rubberChicken cel: 0 setCycle: 0 setPri: 43)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance sTaxJoke of Script
	(properties)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(Load 140 5004) ; WAVE
					(Load rsVIEW 8251)
					(gMessager sayRange: 5 8 2 1 2 self) ; "(TRYING NOT TO LAUGH)What are these spectacles for, good sir?"
				)
				(1
					(gEgo view: 8251 loop: 0 cel: 0 setCycle: Fwd)
					(laughSound number: 5004 loop: 1 play: self)
				)
				(2
					(gEgo setCycle: 0 normalize: 0)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(ClearFlag 539)
					(gEgo setCycle: 0 normalize: 0)
					(laughSound stop:)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance sFlowerJoke of Script
	(properties)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(Load 140 5005) ; WAVE
					(if (== gValOrRoz -4) ; Val
						(gMessager sayRange: 6 8 2 1 2 self) ; "(SURPRISED)Oh my goodness! This isn't real! What do people do with false plants?"
					else
						((ScriptID 13) mouth_x: 1) ; aEgoTalker
						(gMessager say: 16 8 9 0 self) ; "Why do you stock artificial flowers, good sir?"
					)
				)
				(1
					(if (== gValOrRoz -4) ; Val
						(gEgo view: 8251 loop: 1 cel: 0 setCycle: Fwd)
						(laughSound number: 5005 loop: 1 play: self)
					else
						((ScriptID 13) mouth_x: -999) ; aEgoTalker
						(self cue:)
					)
				)
				(2
					(gEgo setCycle: 0 normalize: 1)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(ClearFlag 539)
					(gEgo setCycle: 0 normalize: 1)
					(laughSound stop:)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance shopOwner of Actor
	(properties
		noun 1
		sightAngle 40
		approachX 170
		approachY 106
		x 162
		y 65
		view 5001
	)

	(method (init)
		(super init:)
		(self approachVerbs: 9998 setHotspot: 9998)
		(if (== gValOrRoz -4) ; Val
			(if (and (== gChapter 3) (not (IsFlag 439)))
				(self deleteHotVerb: 61) ; Magic_Statue
			)
			(localproc_0)
		)
		(self addRespondVerb: 59) ; Wooden_Nickel
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(cond
					((== gValOrRoz -3) ; Roz
						(cond
							((IsFlag 436)
								(gMessager say: noun theVerb 12 0) ; "(AS A SCARAB)Rosella! We must hurry and perform our task!"
							)
							((IsFlag 437)
								(gMessager say: noun theVerb 11 0) ; "I don't suppose you've run into another person like me recently?"
								(SetFlag 436)
							)
							((IsFlag 438)
								(gMessager say: noun theVerb 10 0) ; "Pardon my saying so, but isn't the Arch-Duke...just a bit silly?"
								(SetFlag 437)
							)
							(else
								(gMessager say: noun theVerb 9 0) ; "Sir, would you happen to know of a secret entrance to the Vulcanix Underground somewhere within the city walls?"
								(SetFlag 438)
							)
						)
					)
					((== gChapter 5)
						(cond
							((IsFlag 202)
								(if (IsFlag 440)
									(gMessager say: noun theVerb 17 0) ; "(THINKS TO HERSELF)Ersatz is a lovely fellow, but I MUST find Rosella!"
								else
									(gMessager say: noun theVerb 16 0) ; "(TACTFUL)Ersatz, pardon my frankness, but you seem to be too sensible to be living in Falderal."
									(SetFlag 440)
								)
							)
							((IsFlag 441)
								(self setHotspot: 59 58 60 5 57 61) ; Wooden_Nickel, Book, Rubber_Chicken, Golden_Comb, Mask, Magic_Statue
								(gMessager say: noun theVerb 15 0) ; "(WHISPERS)Valanice, if they come for you in the morning, I will hide you in my shop."
							)
							(else
								(gMessager say: noun theVerb 14 0) ; "Hello, Ersatz."
								(SetFlag 441)
							)
						)
					)
					((IsFlag 439)
						(gMessager say: noun theVerb 3 0) ; "(VERY FRIENDLY)Just let me know if you'd like to see anything, my lady."
					)
					(else
						(gMessager say: noun theVerb 2 0) ; "Good day, sir. I am Valanice of Daventry."
						(SetFlag 439)
						(shopOwner addRespondVerb: 61) ; Magic_Statue
					)
				)
			)
			(59 ; Wooden_Nickel
				(gCurRoom setScript: buyTheBook)
			)
			(57 ; Mask
				(gCurRoom setScript: getTheChicken)
			)
			(5 ; Golden_Comb
				(SetFlag 279)
				(localproc_0)
				(gCurRoom setScript: sComb)
			)
			(61 ; Magic_Statue
				(SetFlag 280)
				(localproc_0)
				(gCurRoom setScript: sStatue)
			)
			(60 ; Rubber_Chicken
				(gMessager say: 1 58 18 1) ; "You just bought that, I can't take it back."
			)
			(else
				(gMessager say: noun 0 4 0) ; "That's charming, madam, but far too genuine for my needs."
			)
		)
	)
)

(instance rubberChicken of Prop
	(properties
		noun 4
		approachX 110
		approachY 115
		x 35
		view 5001
		loop 2
	)

	(method (init)
		(super init:)
		(if (!= gChapter 4)
			(self approachVerbs: 8 10 setHotspot: 8 10) ; Do, Exit, Do, Exit
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(gCurRoom setScript: sChicken)
			)
		)
	)
)

(instance catClock of Prop
	(properties
		noun 10
		sightAngle 40
		approachX 170
		approachY 106
		x 151
		y 9
		view 5001
		loop 6
	)

	(method (init)
		(super init:)
		(if (not (IsFlag 297))
			(self approachVerbs: 8 10 setHotspot: 8 10) ; Do, Exit, Do, Exit
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(self setHotspot: 0)
				(SetFlag 297)
				(gMessager say: noun theVerb 2 0) ; "What an unusual timepiece."
			)
		)
	)
)

(instance theCatClock of Prop
	(properties
		noun 10
		approachX 208
		approachY 107
		x 151
		y 9
		view 5001
		loop 6
	)

	(method (init)
		(super init:)
		((ScriptID 7001 0) ; kingTalker
			clientCel: -1
			loop: -1
			view: -1
			mouth_x: -999
			mouth_y: -999
			hide_mouth: 1
			client: self
		)
	)
)

(instance books of Feature
	(properties
		noun 2
		approachX 170
		approachY 106
		x 130
		y 97
	)

	(method (init)
		(super init:)
		(if (not (IsFlag 125))
			(self approachVerbs: 8 10 setHotspot: 8 10) ; Do, Exit, Do, Exit
		)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 118 32 116 64 162 62 147 51 136 15 126 14
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(if (and (== gValOrRoz -4) (not (IsFlag 125))) ; Val
					(if (IsFlag 444)
						(gMessager say: 2 8 5 3) ; "The price is one wooden nickel."
					else
						(SetFlag 444)
						(gMessager sayRange: 2 8 5 1 2) ; "(INTERESTED)What charming little books. What are you asking for them?"
					)
				)
			)
		)
	)
)

(instance fakeNose of Feature
	(properties
		noun 5
		approachX 208
		approachY 107
		x 215
		y 106
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 223 37 226 46 238 43 240 35 227 33
					yourself:
				)
		)
		(if (not (IsFlag 296))
			(self approachVerbs: 8 10 setHotspot: 8 10) ; Do, Exit, Do, Exit
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(self setHotspot: 0)
				(SetFlag 296)
				(gCurRoom setScript: sTaxJoke)
			)
		)
	)
)

(instance fakeFlower of Feature
	(properties
		noun 6
		approachX 81
		approachY 133
		x 70
		y 135
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 136 13 136 19 127 26 0 3 1
					yourself:
				)
		)
		(if (not (IsFlag 295))
			(self approachVerbs: 8 10 setHotspot: 8 10) ; Do, Exit, Do, Exit
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(self setHotspot: 0)
				(SetFlag 295)
				(gCurRoom setScript: sFlowerJoke)
			)
		)
	)
)

(instance feet of Feature
	(properties
		noun 7
		approachX 222
		approachY 117
		x 230
		y 117
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 236 100 243 100 256 90 254 82 241 79 228 85 228 93
					yourself:
				)
		)
		(if (not (IsFlag 294))
			(self approachVerbs: 8 10 setHotspot: 8 10) ; Do, Exit, Do, Exit
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(gMessager say: noun theVerb 2 0) ; "(PERPLEXED)What does one do with false feet?"
				(self setHotspot: 0)
				(SetFlag 294)
			)
		)
	)
)

(instance artFlavorBox of Feature
	(properties
		noun 18
		nsLeft 270
		nsTop 75
		nsRight 282
		nsBottom 85
		approachX 222
		approachY 117
		x 230
		y 117
	)

	(method (init)
		(super init:)
		(if (not (IsFlag 293))
			(self approachVerbs: 8 10 setHotspot: 8 10) ; Do, Exit, Do, Exit
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(self setHotspot: 0)
				(SetFlag 293)
				(gMessager say: noun theVerb 9 0) ; "'Artificial Flavoring'? What does that mean?"
			)
		)
	)
)

(instance fakeOwl of Feature
	(properties
		noun 9
		approachX 208
		approachY 107
		x 215
		y 106
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 287 5 252 0 247 8 269 24 299 25 317 14
					yourself:
				)
		)
		(if (not (IsFlag 292))
			(self approachVerbs: 8 10 setHotspot: 8 10) ; Do, Exit, Do, Exit
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(SetFlag 292)
				(gMessager say: noun theVerb 2 0) ; "What a charming wooden owl. Is it a toy?"
				(self setHotspot: 0)
			)
		)
	)
)

(instance fakeSpider of Feature
	(properties
		noun 15
		nsLeft 132
		nsRight 152
		nsBottom 12
		approachX 208
		approachY 107
		x 206
		y 106
	)

	(method (init)
		(super init:)
		(if (not (IsFlag 291))
			(self approachVerbs: 8 10 setHotspot: 8 10) ; Do, Exit, Do, Exit
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(SetFlag 291)
				(gMessager say: noun theVerb 9 0) ; "What a horrid spider! Who would want that thing?"
				(self setHotspot: 0)
			)
		)
	)
)

(instance fishBowl of Feature
	(properties
		noun 13
		nsLeft 203
		nsTop 49
		nsRight 225
		nsBottom 63
		approachX 208
		approachY 107
		x 208
		y 100
	)

	(method (init)
		(super init:)
		(if (not (IsFlag 290))
			(self approachVerbs: 8 10 setHotspot: 8 10) ; Do, Exit, Do, Exit
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(SetFlag 290)
				(gMessager say: noun theVerb 9 0) ; "Are those real fish?"
				(self setHotspot: 0)
			)
		)
	)
)

(instance lavaLamp of Feature
	(properties
		noun 14
		nsLeft 150
		nsTop 70
		nsRight 161
		nsBottom 94
		approachX 169
		approachY 107
		x 140
		y 100
	)

	(method (init)
		(super init:)
		(if (not (IsFlag 289))
			(self approachVerbs: 8 10 setHotspot: 8 10) ; Do, Exit, Do, Exit
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(SetFlag 289)
				(gMessager say: noun theVerb 9 0) ; "What in the world is that thing?"
				(self setHotspot: 0)
			)
		)
	)
)

(instance leftCase of Feature
	(properties
		noun 11
		nsLeft 19
		nsTop 74
		nsRight 109
		nsBottom 107
		approachX 98
		approachY 117
		x 90
		y 117
	)

	(method (init)
		(super init:)
		(if (not (IsFlag 288))
			(self approachVerbs: 8 10 setHotspot: 8 10) ; Do, Exit, Do, Exit
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(SetFlag 288)
				(self setHotspot: 0)
				(gMessager say: noun theVerb 2 0) ; "Where in the world do you find all of these things?"
			)
		)
	)
)

(instance masks of Feature
	(properties
		noun 3
		nsLeft 168
		nsTop 3
		nsRight 225
		nsBottom 54
		approachX 208
		approachY 107
		x 208
		y 107
	)

	(method (init)
		(super init:)
		(if (not (IsFlag 287))
			(self approachVerbs: 8 10 setHotspot: 8 10) ; Do, Exit, Do, Exit
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(SetFlag 287)
				(gMessager say: 3 8 2 0) ; "It looks like you had quite a few mask sales."
				(self setHotspot: 0)
			)
		)
	)
)

(instance rattleSnake of Feature
	(properties
		noun 8
		approachX 222
		approachY 117
		x 240
		y 117
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 270 88 254 100 265 112 286 110 289 103
					yourself:
				)
		)
		(if (not (IsFlag 286))
			(self approachVerbs: 8 10 setHotspot: 8 10) ; Do, Exit, Do, Exit
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(SetFlag 286)
				(gMessager say: noun theVerb 2 0) ; "Do you have many customers for fierce-looking false serpents like that one?"
				(self setHotspot: 0)
			)
		)
	)
)

(instance duck of Feature
	(properties
		noun 12
		nsLeft 293
		nsTop 53
		nsRight 316
		nsBottom 76
		approachX 222
		approachY 117
		x 240
		y 117
	)

	(method (init)
		(super init:)
		(if (not (IsFlag 285))
			(self approachVerbs: 8 10 setHotspot: 8 10) ; Do, Exit, Do, Exit
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(SetFlag 285)
				(gMessager say: noun theVerb 9 0) ; "Is this a duck decoy, for hunters?"
				(self setHotspot: 0)
			)
		)
	)
)

(instance mySouthExit of ExitFeature
	(properties
		nsTop 130
		nsRight 319
		nsBottom 135
		approachX 152
		approachY 142
		x 152
		y 160
		exitDir 3
	)

	(method (doVerb theVerb)
		(if (== theVerb 8) ; Do
			(gCurRoom setScript: sToPlaza)
		)
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 8 10 approachVerbs: 8 10) ; Do, Exit, Do, Exit
	)
)

(instance chickenSound of Sound
	(properties)
)

(instance laughSound of Sound
	(properties)
)

(instance fauxSound of Sound
	(properties)
)

(instance doorSound of Sound
	(properties)
)

(instance mockTalker of KQTalker
	(properties
		clientCel -1
	)

	(method (init)
		(= client shopOwner)
		(super init: &rest)
	)
)

