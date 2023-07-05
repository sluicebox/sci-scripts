;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5400)
(include sci.sh)
(use Main)
(use ExitButton)
(use skipCartoon)
(use eastFeat)
(use Talker)
(use Scaler)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	rm5400 0
	guardTalker 28
)

(procedure (localproc_0 param1)
	(gEgo
		view: 5405
		loop: 0
		cel: 0
		posn: 233 90
		setScale: 0
		setCycle: End param1
	)
)

(procedure (localproc_1 param1)
	(gKqSound1 number: 853 loop: 1 play:)
	(gEgo setLoop: 1 cel: 0 posn: 234 90 setCycle: End param1)
)

(procedure (localproc_2 param1)
	(gKqSound1 number: 853 loop: 1 play:)
	(gEgo
		view: 5407
		loop: 0
		cel: 0
		x: 212
		y: 91
		setScale: 0
		setCycle: End param1
	)
)

(instance rm5400 of KQRoom
	(properties
		picture 5400
	)

	(method (init)
		(super init:)
		(Load 140 849) ; WAVE
		(Load 140 850) ; WAVE
		(SetFlag 21)
		(SetFlag 55)
		(gEgo init: normalize: setScaler: Scaler 100 52 118 90)
		(switch gPrevRoomNum
			(5300
				(gEgo posn: 231 93 normalize: 4)
			)
			(else
				(gEgo posn: 322 111 normalize: 7)
			)
		)
		(gateGuard init:)
		(flag init: setCycle: Fwd)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 101 139 319 139 319 95 297 97 275 101 268 95 239 91 228 90 218 92 227 97 211 103 187 98 157 105 127 108 127 117 96 123 77 119 60 122
					yourself:
				)
		)
		(Load rsMESSAGE 5400)
		(switch gChapter
			(3
				(smallDoor init:)
				(if global306
					(smallDoor dispose:)
					(smallDoorExit init:)
				)
				(if (not (IsFlag 405))
					(gCurRoom setScript: openingScript)
				)
			)
			(4
				(smallDoor init:)
				(if (IsFlag 531)
					(smallDoor dispose:)
					(smallDoorExit init:)
				)
				(if (not (IsFlag 445))
					(gCurRoom setScript: openingScript)
				)
			)
			(5
				(smallDoorExit init:)
			)
		)
		(knocker init:)
		(spiderExit init:)
		(switch gPrevRoomNum
			(3300
				(if (not script)
					(gCurRoom setScript: enterRoom)
				)
			)
			(5300
				(gCurRoom setScript: enterFromPlaza)
			)
		)
		(if (!= script openingScript)
			(if (!= (gKqMusic1 number:) 5300)
				(gKqMusic1 number: 5300 loop: -1 play: 50 0)
			else
				(gKqMusic1 fade: 50 25 10 0)
			)
		)
		(if (not script)
			(gGame handsOn:)
		)
	)
)

(instance enterFromPlaza of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (== gValOrRoz -3) ; Roz
					(gEgo
						view: 5407
						loop: 0
						cel: 9
						x: 212
						y: 91
						setScale: 0
						setCycle: CT 5 -1 self
					)
				else
					(gEgo
						view: 5405
						setLoop: 1
						cel: 8
						posn: 234 90
						setScale: 0
						setCycle: Beg self
					)
				)
			)
			(1
				(gKqSound1 number: 802 loop: 1 play:)
				(if (gEgo cel:)
					(gEgo setCycle: Beg self)
				else
					(= cycles 1)
				)
			)
			(2
				(gEgo
					normalize: 1
					posn: (smallDoor approachX:) (smallDoor approachY:)
					setScaler: Scaler 100 52 118 90
					setHeading: 180 self
				)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance enterRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 294 111 self)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance openingScript of Script
	(properties)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(= cycles 1)
				)
				(1
					(gKqSound1 number: 5400 loop: 1 play: self)
					(gEgo setMotion: MoveTo 238 113 self)
				)
				(2 0)
				(3
					(gKqMusic1 number: 5300 loop: -1 play: setVol: 50)
					(if (== gValOrRoz -3) ; Roz
						(self setScript: rosGateOpening self)
						(SetFlag 445)
					else
						(self setScript: valGateOpening self)
						(SetFlag 405)
					)
					(gGame handsOff: 1)
				)
				(4
					(gKqSound1 number: 850 loop: 1 play:)
					(gateGuard setLoop: 1 cel: 0 setCycle: End self)
				)
				(5
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(self setScript: 0)
			(gateGuard view: 5401 loop: 1 cel: 5 x: 149 y: 23 setCycle: 0)
			(gEgo setCycle: 0 normalize: 7)
			(ClearFlag 539)
			(gGame handsOn:)
			(self dispose:)
		)
	)
)

(instance rosGateOpening of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gKqSound1 number: 849 loop: 1 play:)
				(gateGuard setCycle: Beg self)
			)
			(1
				(gateGuard setLoop: 0 cel: 0 setCycle: End self)
			)
			(2
				(gMessager say: 0 0 11 0 self) ; "(STRIDENTLY)HALT! Who goes there?"
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance valGateOpening of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gKqSound1 number: 849 loop: 1 play:)
				(gateGuard setCycle: Beg self)
			)
			(1
				(gateGuard setLoop: 0 cel: 0 setCycle: End self)
			)
			(2
				(gMessager say: 0 0 1 0 self) ; "(HUGE, BOOMING VOICE)HALT! Who goes there?"
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance valKnocksDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load 140 873) ; WAVE
				(= register 4)
				(= cycles 2)
			)
			(1
				(gEgo
					view: 5403
					loop: 0
					cel: 0
					posn: 176 103
					setScale: 0
					setCycle: End self
				)
			)
			(2
				(gKqSound1 number: 873 loop: 1 play:)
				(if (-- register)
					(-= state 2)
					(= cycles 10)
				else
					(= cycles 1)
				)
			)
			(3
				(gEgo
					normalize: 7
					posn: (knocker approachX:) (knocker approachY:)
					setScaler: Scaler 100 52 118 90
				)
				(if (not (IsFlag 202))
					(= cycles 10)
				else
					(gGame handsOn:)
					(self dispose:)
				)
			)
			(4
				(gKqSound1 number: 849 loop: 1 play:)
				(gateGuard setCycle: Beg self)
			)
			(5
				(gateGuard setLoop: 0 cel: 0 setCycle: End self)
			)
			(6
				(if (and (!= gChapter 5) (not (IsFlag 404)))
					(cond
						((IsFlag 406)
							(gMessager say: 1 0 5 0 self) ; "(FROM BEHIND THE CLOSED PEEPHOLE PANEL)I'm not listening! I'm plugging my ears! I'm singing so I can't hear you! La la la la la! Doo doo doo doo doo!"
						)
						((IsFlag 108)
							(SetFlag 406)
							(gMessager say: 1 0 4 0 self) ; "(REALLY CRANKY)Stop it, stop it, stop it! You're giving me a headache, you nasty pinkfaced creature!"
						)
						((IsFlag 107)
							(SetFlag 108)
							(gMessager say: 1 0 3 0 self) ; "(CRANKY)Would you stop that infernal banging? It's rattling my teeth."
						)
						(else
							(SetFlag 107)
							(gMessager say: 1 0 2 0 self) ; "Have you brought me the Holy One-Ton Tomato?"
						)
					)
				else
					(gMessager say: 1 0 6 0 self) ; "(PETULANTLY)Go away, you horrid creature. You have no respect for authority."
				)
			)
			(7
				(gKqSound1 number: 850 loop: 1 play:)
				(gateGuard setLoop: 1 cel: 0 setCycle: End self)
			)
			(8
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance valSmallDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(if (not (IsFlag 202))
					(gKqSound1 number: 849 loop: 1 play:)
					(gateGuard setCycle: Beg self)
				else
					(= cycles 1)
				)
			)
			(2
				(if (not (IsFlag 202))
					(switch (++ global306)
						(1
							(self setScript: valLilDoorOnce self)
						)
						(2
							(self setScript: valLilDoorTwice self)
						)
						(3
							(self setScript: valLilDoorThrice self)
						)
						(else
							(self setScript: valLilDoorFourth self)
						)
					)
				else
					(self setScript: valEnterTown self)
				)
			)
			(3
				(gCurRoom newRoom: 5300)
			)
		)
	)
)

(instance valLilDoorOnce of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Load 140 24530) ; WAVE
				(gMessager sayRange: 2 8 7 1 2 self) ; "(ALARMED)STOP! Don't touch that door! You can't go through there! There's...a giant rabid chicken on the other side! That's it! A giant rabid chicken!"
			)
			(1
				(localproc_0 self)
			)
			(2
				(localproc_1 self)
				(gMessager say: 2 8 7 3 self) ; "(ANGRY, UPSET)STOP! You can't do that!"
			)
			(3 0)
			(4
				((ScriptID 13 0) hide_mouth: 1) ; aEgoTalker
				(gMessager say: 2 8 7 4 self) ; "(VERY AMUSED)I just did, little fellow."
			)
			(5
				((ScriptID 13 0) hide_mouth: 0) ; aEgoTalker
				(gateGuard
					view: 5405
					loop: 2
					cycleSpeed: 3
					cel: 0
					posn: 147 23
					setCycle: End self
				)
			)
			(6
				(guardTalker clientCel: -2 view: 5405 loop: 22)
				(gMessager say: 2 8 7 5 self) ; "(ANGRY)Oooooh! The Arch-Duke will hear of this!"
			)
			(7
				(guardTalker clientCel: -2 hide_mouth: 1)
				(gKqSound1 number: 5402 loop: 1 play:)
				(gateGuard
					view: 5405
					loop: 3
					cel: 0
					cycleSpeed: 3
					posn: 154 23
					setCycle: CT 12 1 self
				)
			)
			(8
				(gKqSound1 number: 24530 loop: 1 play:)
				(gateGuard setCycle: CT 17 1 self)
			)
			(9
				(gKqSound1 number: 24530 loop: 1 play:)
				(gateGuard setCycle: End self)
			)
			(10
				(gMessager say: 2 8 7 6 self) ; "(LONG SUFFERING)Ow."
			)
			(11
				(guardTalker hide_mouth: 0)
				(gateGuard view: 5401 loop: 1 cel: 5 posn: 149 23)
				(UpdateScreenItem gateGuard)
				(FrameOut)
				(= cycles 1)
			)
			(12
				(self dispose:)
			)
		)
	)
)

(instance valLilDoorTwice of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager sayRange: 2 8 8 1 2 self) ; "HALT! You can't go though that door! There are...six hundred bad tempered weasels with crossbows on the other side! Yes, that's it! Weasels!"
			)
			(1
				(localproc_0 self)
			)
			(2
				(localproc_1 self)
				(gMessager say: 2 8 8 3 self) ; "Oh, big fat hairy rats."
			)
			(3 0)
			(4
				(self dispose:)
			)
		)
	)
)

(instance valLilDoorThrice of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager sayRange: 2 8 9 1 6 self) ; "HALT! There's a vicious, attack-trained...guinea pig behind that door. That's it! A guinea pig!"
			)
			(1
				(localproc_0 self)
			)
			(2
				(localproc_1 self)
			)
			(3
				(gMessager say: 2 8 9 7 self) ; "Darn. I should have said it was a berzerk possum."
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance valLilDoorFourth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 2 8 10 1 self) ; "(MIFFED)HMMPH!"
			)
			(1
				(localproc_0 self)
			)
			(2
				(localproc_1 self)
				((ScriptID 13 0) hide_mouth: 1) ; aEgoTalker
				(gMessager say: 2 8 10 2 self) ; "(CHUCKLING)Hee hee hee!"
			)
			(3 0)
			(4
				((ScriptID 13 0) hide_mouth: 0) ; aEgoTalker
				(self dispose:)
			)
		)
	)
)

(instance valEnterTown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_0 self)
			)
			(1
				(localproc_1 self)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance rosSmallDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsVIEW 5407)
				(gKqSound1 number: 849 loop: 1 play:)
				(gateGuard setCycle: Beg self)
			)
			(1
				(cond
					((IsFlag 529)
						(gMessager say: 2 8 16 0 self) ; "(SULKY, THEN BLOWS A RASPBERRY)Anarchist! PTHPTHPTHPTHPTH!"
					)
					((IsFlag 530)
						(gMessager say: 2 8 14 0 self) ; "(SARCASTIC)Oh, just ignore me. See if I care when you get swallowd by the Colossal Chicken of Cluckerville! You're just like that other hairless pink thing. No respect."
						(SetFlag 529)
					)
					((IsFlag 531)
						(gMessager say: 2 8 13 0 self) ; "HALT! There's a one-eyed, one-horned, flying hairless-pink-thing-eater on the other side of that door!"
						(SetFlag 530)
					)
					(else
						(gMessager say: 2 8 12 0 self) ; "STOP! You can't go through there! That door leads to...a pit of salivating snakes! That's right! Snakes!"
						(SetFlag 531)
					)
				)
			)
			(2
				(gateGuard view: 5401 loop: 1 cel: 5 posn: 149 23)
				(UpdateScreenItem gateGuard)
				(FrameOut)
				(localproc_2 self)
			)
			(3
				(gGame handsOn:)
				(gCurRoom newRoom: 5300)
			)
		)
	)
)

(instance rosKnocksDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo view: 5406 setLoop: 0 1 cel: 0 setCycle: CT 6 1 self)
			)
			(1
				(gKqSound1 number: 873 loop: 1 play:)
				(gEgo setCycle: CT 8 1 self)
			)
			(2
				(gKqSound1 number: 873 loop: 1 play:)
				(gEgo setCycle: End self)
			)
			(3
				(gEgo normalize: 7)
				(= cycles 1)
			)
			(4
				(gKqSound1 number: 849 loop: 1 play:)
				(gateGuard setCycle: Beg self)
			)
			(5
				(gateGuard setLoop: 0 cel: 0 setCycle: End self)
			)
			(6
				(cond
					((not (SetFlag 448))
						(gMessager say: 1 0 12 0 self) ; "Have you brought me the Levitating Warthog, you distasteful hairless thing?"
					)
					((not (SetFlag 447))
						(gMessager say: 1 0 13 0 self) ; "(SNOTTY)The levitating warthog is no longer enough. For your disrespect, you must also bring me the Flying Ferret of Mestellidon."
					)
					((not (SetFlag 446))
						(gMessager say: 1 0 14 0 self) ; "Go away! I wouldn't let you in if you were the last horrid hairless pink thing in Etheria! And I wish you were!"
					)
					(else
						(gMessager say: 1 0 15 0 self) ; "(BEING JOLTED BY THE LOUD KNOCKS)I--don't--hear--a thing!"
					)
				)
			)
			(7
				(gKqSound1 number: 850 loop: 1 play:)
				(gateGuard setLoop: 1 cel: 0 setCycle: End self)
			)
			(8
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance knocker of Feature
	(properties
		noun 1
		approachX 176
		approachY 102
		x 160
		y 103
	)

	(method (init)
		(super init:)
		(self
			setHotspot: 8 10 ; Do, Exit
			approachVerbs: 8 ; Do
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 109 104 120 102 157 102 178 94 187 93 191 89 184 57 187 34 194 16 184 10 177 12 180 2 165 4 156 3 142 5 132 13 117 9 102 15 102 19 124 26 121 30 123 35 119 40 119 49 123 65 117 85
					yourself:
				)
		)
		(if (== gValOrRoz -3) ; Roz
			(+= approachX 4)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(if (== gValOrRoz -3) ; Roz
					(gCurRoom setScript: rosKnocksDoor)
				else
					(gCurRoom setScript: valKnocksDoor)
				)
			)
		)
	)
)

(instance smallDoor of Feature
	(properties
		noun 2
		approachX 233
		approachY 90
		x 221
		y 87
	)

	(method (init)
		(super init:)
		(self
			setHotspot: 8 10 ; Do, Exit
			approachVerbs: 8 ; Do
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 216 87 227 87 230 73 226 69 218 68 212 74
					yourself:
				)
		)
		(if (== gValOrRoz -3) ; Roz
			(= approachX 236)
			(= approachY 89)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(if (== gValOrRoz -3) ; Roz
					(gCurRoom setScript: rosSmallDoor)
				else
					(Load rsVIEW 5405)
					(gCurRoom setScript: valSmallDoor)
				)
			)
		)
	)
)

(instance smallDoorExit of ExitFeature
	(properties
		exitDir 4
	)

	(method (init)
		(super init: &rest)
		(self
			approachX: (smallDoor approachX:)
			approachY: (smallDoor approachY:)
			x: (smallDoor x:)
			y: (smallDoor y:)
			setHotspot: 8 10 ; Do, Exit
			approachVerbs: 8 ; Do
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 216 87 227 87 230 73 226 69 218 68 212 74
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(smallDoor doVerb: theVerb)
	)
)

(instance gateGuard of Prop
	(properties
		x 149
		y 23
		view 5401
		loop 1
		cel 5
	)

	(method (init)
		(super init: &rest)
		(|= signal $1000)
	)
)

(instance spiderExit of ExitFeature
	(properties
		sightAngle 5000
		exitDir 2
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 10 10 ; Exit, Exit
			approachVerbs: 10 ; Exit
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 250 139 320 139 320 103 308 102 302 124 228 130
					yourself:
				)
		)
	)

	(method (onMe param1 &tmp temp0)
		(= temp0 (super onMe: param1))
		(= x (+ (= approachX (param1 x:)) 5))
		(= y (+ (= approachY (param1 y:)) 5))
		(return temp0)
	)

	(method (doVerb)
		(gCurRoom setScript: exitToSpider)
	)
)

(instance exitToSpider of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					setMotion: MoveTo (+ (gEgo x:) 20) (gEgo y:) self
				)
			)
			(1
				(gCurRoom newRoom: 3300)
			)
		)
	)
)

(instance flag of Prop
	(properties
		x 223
		y 5
		view 5400
	)
)

(instance guardTalker of KQTalker
	(properties
		view 5401
		loop 0
		clientCel 0
		mouth_x 0
		mouth_y 0
	)

	(method (init)
		(self client: gateGuard)
		(super init: &rest)
	)
)

