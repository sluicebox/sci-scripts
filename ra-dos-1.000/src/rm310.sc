;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 310)
(include sci.sh)
(use Main)
(use Door)
(use eRS)
(use ExitFeature)
(use Talker)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Motion)
(use Actor)
(use System)

(public
	rm310 0
	Bartender 22
	PianoPlayer 30
	Singer 31
)

(local
	local0 = 1
	local1 = 1
	local2 = 1
	local3 = 1
)

(procedure (localproc_0 &tmp temp0)
	(switch (= temp0 (gCurRoom setInset: (ScriptID 20 0))) ; inNotebook
		(1026
			(gMessager say: 1 6 28) ; "Since this year is almost over, how do you feel about 1926?"
		)
		(1027
			(gMessager say: 1 6 30) ; "All I know is dat de Egyptian pigsticker was heisted from de museum."
		)
		(259
			(gMessager say: 1 6 17) ; "Dat's da new President of da Leyendecker Museum."
		)
		(1029
			(gMessager say: 1 6 12) ; "Dat's today's password. And it's a great dance."
		)
		(261
			(gMessager say: 1 6 9) ; "Crodfoller? He's an old pal of mine. Whatcha want ta know?"
		)
		(780
			(gMessager say: 1 6 20) ; "Da pigsticker? Someone heisted it."
		)
		(516
			(gMessager say: 1 6 24) ; "Dem is da docks at da end of Twelfth Street."
		)
		(1028
			((ScriptID 21 0) doit: 268) ; addCluesCode, Rameses Najeer
			(gMessager say: 1 6 31) ; "Do you know anything about Egyptology?"
		)
		(262
			(gMessager say: 1 6 15) ; "Dat's da guy who does my laundry."
		)
		(518
			(gMessager say: 1 6 35) ; "You mean dis speakeasy? It's da best in town, and I know because I've been to all of 'em."
		)
		(517
			(gMessager say: 1 6 19) ; "I hoid somebody heisted dat Egyptian pigsticker from da museum. Rumor on da street is dat it was an inside job."
		)
		(519
			(gMessager say: 1 6 29) ; "I'm new here. What can you tell me about New York?"
		)
		(513
			(gMessager say: 1 6 23) ; "Dat's where my pal, Crodfoller, works."
		)
		(260
			(gMessager say: 1 6 13) ; "Uhhh, I t'ink he's a cop."
		)
		(258
			(gMessager say: 1 6 16) ; "Dat's da guy who found dat fancy pigsticker in Egypt."
		)
		(514
			(gMessager say: 1 6 22) ; "What makes ya t'ink I knows anything about police stations? Ya t'ink I'm a hood or something? I gots friends in high places, toots, so don'tcha mess with me!"
		)
		(268
			(gMessager say: 1 6 27) ; "Dat's da accountant from da museum. Spooky high-hat kinda guy."
		)
		(520
			(gMessager say: 1 6 35) ; "You mean dis speakeasy? It's da best in town, and I know because I've been to all of 'em."
		)
		(263
			(gMessager say: 1 6 14) ; "Dat name rings a bell. I t'ink he works on da docks."
		)
		(264
			(gMessager say: 1 6 3) ; "Dat's me. Wuz you wantin' to make sumpin' of it?"
		)
		(-1 0)
		(else
			(cond
				((<= 256 temp0 409)
					(gMessager say: 1 6 18) ; "Never heard dat name before, toots."
				)
				((<= 768 temp0 921)
					(gMessager say: 1 6 26) ; "Why you showin' me dat?"
				)
				(else
					(gMessager say: 1 6 21) ; "Do I look like an encyclopaedia? I don't know nuttin' about dat."
				)
			)
		)
	)
)

(instance rm310 of LBRoom
	(properties
		noun 13
		picture 310
		north 320
		south 300
		vanishingX 167
		vanishingY -20
	)

	(method (init &tmp [temp0 3] temp3 [temp4 30])
		(LoadMany rsVIEW 311 317 312 313 314 315 318 831 830)
		(LoadMany rsSOUND 310 311 312 314)
		(gEgo
			setScale: Scaler 137 0 190 -20
			init:
			normalize: (if (gEgo wearingGown:) 831 else 830)
		)
		(switch gPrevRoomNum
			(north
				(gEgo x: 236 y: 107 edgeHit: EDGE_NONE setHeading: 180)
				(gGameMusic1 setVol: 127)
				(gGameMusic2 stop:)
			)
			(south
				(gEgo x: 195)
				(= temp3 (if (== (DoSound sndGET_POLYPHONY) 32) 310 else 314))
			)
			(else
				(gEgo posn: 160 160)
				(gGame handsOn:)
			)
		)
		(super init:)
		(LoadMany rsVIEW 311 317 312 313 314 315 318 831 830)
		(LoadMany rsSOUND 310 311 312 314)
		(if (== gPrevRoomNum south)
			(switch (Random 0 2)
				(0
					(WrapMusic init: 1 temp3 311 1312)
				)
				(1
					(WrapMusic init: 1 311 temp3 1312)
				)
				(2
					(WrapMusic init: 1 1312 temp3 311)
				)
			)
		)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 26 189 0 189 0 0 319 0 319 189 287 189 238 172 201 118 245 111 245 97 274 92 258 69 219 108 193 112 174 115 168 127 119 122 85 152
					yourself:
				)
		)
		(bartender approachVerbs: 1 2 6 addToPic:) ; Look, Talk, Ask
		(barfly1 addToPic:)
		(barfly2 addToPic:)
		(ziggy approachVerbs: 1 2 6 init: setScript: sZiggySmokes) ; Look, Talk, Ask
		(woman2 addToPic:)
		(dancersA init: setScript: sRDancers)
		(dancersB init: setScript: sMDancers)
		(dancersC setCycle: Fwd init:)
		(flapper setCycle: Fwd init:)
		(pianoplayer init: setCycle: Fwd)
		(sleeper addToPic:)
		(woman1 addToPic:)
		(bathroomDoor init:)
		(endOfBar init:)
		(southExitFeature init:)
		((ScriptID 1881 2) x: 5 y: 95 textX: 120 textY: 20 talkWidth: 120) ; Laura
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 320)
			(gGameMusic1 fade: 80 10 12 0)
		else
			(WrapMusic dispose:)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance sRDancers of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(dancersA view: 313 loop: 0 setCycle: Fwd)
				(= seconds (Random 5 10))
			)
			(1
				(dancersA view: 313 loop: 1 setCycle: Fwd)
				(= seconds (Random 4 6))
			)
			(2
				(= state -1)
				(= cycles 1)
			)
		)
	)
)

(instance sMDancers of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(dancersB view: 313 loop: 2 setCycle: Fwd)
				(= seconds (Random 4 7))
			)
			(1
				(dancersB view: 314 loop: 2 setCycle: End self)
			)
			(2
				(dancersB view: 313 loop: 3 setCycle: Fwd)
				(= seconds (Random 4 8))
			)
			(3
				(dancersB view: 314 loop: 2 cel: 11 setCycle: Beg self)
			)
			(4
				(= state -1)
				(= cycles 1)
			)
		)
	)
)

(instance sBartender of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(bartender setLoop: 2)
				(= seconds (Random 9 19))
			)
			(1
				(switch (Random 0 1)
					(0
						(bartender setLoop: 1 setMotion: MoveTo 55 113 self)
					)
					(1
						(bartender setLoop: 0 setMotion: MoveTo 7 123 self)
					)
				)
			)
			(2
				(if (> (bartender x:) 10)
					(bartender setLoop: 0)
				else
					(bartender setLoop: 1)
				)
				(bartender setMotion: MoveTo 47 115 self)
			)
			(3
				(= state -1)
				(= cycles 1)
			)
		)
	)
)

(instance sZiggySmokes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ziggy setCycle: End self)
			)
			(1
				(= seconds (Random 1 6))
			)
			(2
				(switch (Random 0 2)
					(0
						(= cycles 1)
					)
					(else
						(ziggy cel: 3 setCycle: End self)
					)
				)
			)
			(3
				(ziggy cel: 3 setCycle: CT 0 -1 self)
			)
			(4
				(= seconds (Random 2 4))
			)
			(5
				(= state -1)
				(= cycles 1)
			)
		)
	)
)

(instance sNodder of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(woman2 setCycle: End self)
			)
			(1
				(= cycles (Random 1 10))
			)
			(2
				(woman2 setCycle: Beg self)
			)
			(3
				(= cycles (Random 10 20))
			)
			(4
				(= state -1)
				(= cycles 1)
			)
		)
	)
)

(instance sWhoSentYa of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gMessager say: 1 2 6 0 self) ; "Are you Ziggy?"
				(= local1 0)
				((ScriptID 22 0) doit: $0008) ; triggerAndClock
				(gGame points: 1 131)
			)
			(1
				(switch (= temp0 (gCurRoom setInset: (ScriptID 20 0))) ; inNotebook
					(261
						(gMessager say: 1 2 8 0 self) ; "Crodfoller? He's an old pal of mine. Whatcha want ta know?"
						(SetFlag 118)
					)
					(else
						(if (<= 256 temp0 409)
							(gMessager say: 1 2 7 0 self) ; "Never hoid of 'em, toots. Amscray."
						else
							(gMessager say: 1 6 21 0 self) ; "Do I look like an encyclopaedia? I don't know nuttin' about dat."
						)
						(ClearFlag 118)
					)
				)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance sLeaveSouth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gEgo setMotion: PolyPath gMouseX 190 self)
			)
			(2
				(gEgo setMotion: MoveTo (gEgo x:) 270 self)
			)
			(3
				(gCurRoom newRoom: 300)
			)
		)
	)
)

(instance bartender of View
	(properties
		x 47
		y 115
		noun 2
		approachX 113
		approachY 129
		view 312
		loop 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6 ; Ask
				(switch (gCurRoom setInset: (ScriptID 20 0)) ; inNotebook
					(264
						(gMessager say: 2 6 3 0) ; "He's sitting at one of the tables, miss."
					)
					(-1 0)
					(else
						(gMessager say: 2 6 4 0) ; "I'm sorry, miss. I'm too busy to talk right now."
					)
				)
			)
			(2 ; Talk
				(gMessager say: 2 2 0 0) ; "Ya wanna drink, miss?"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance barfly1 of View
	(properties
		x 59
		y 148
		noun 3
		view 312
		loop 3
		priority 10
		signal 16
	)
)

(instance barfly2 of View
	(properties
		x 81
		y 140
		noun 10
		view 312
		loop 4
		priority 10
		signal 16
	)
)

(instance ziggy of Prop
	(properties
		x 292
		y 124
		noun 1
		approachX 232
		approachY 157
		view 318
		cel 5
		priority 12
		signal 4112
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(6 ; Ask
				(cond
					((and (TimeCheck $0008 0) (IsFlag 118))
						(localproc_0)
					)
					(local1
						(gMessager say: 1 2 33 2) ; "I doesn't talk ta strangers, toots."
					)
					((IsFlag 118)
						(localproc_0)
					)
					(else
						(switch (gCurRoom setInset: (ScriptID 20 0)) ; inNotebook
							(261
								(gMessager say: 1 6 9 0) ; "Crodfoller? He's an old pal of mine. Whatcha want ta know?"
								(SetFlag 118)
							)
							(else
								(gMessager say: 1 6 21 0) ; "Do I look like an encyclopaedia? I don't know nuttin' about dat."
							)
						)
					)
				)
			)
			(2 ; Talk
				(cond
					((TimeCheck $0008 0)
						(gMessager say: 1 2 32) ; "Have you read that new novel by Ernest Hemingway?"
					)
					(local1
						(gCurRoom setScript: sWhoSentYa)
					)
					(local2
						(if (IsFlag 118)
							(gMessager say: 1 2 32) ; "Have you read that new novel by Ernest Hemingway?"
						else
							(gMessager say: 1 2 33) ; "You don't seem very talkative, sir. Is there anything I can say to loosen your lips?"
						)
						(= local2 0)
					)
					(local3
						(if (IsFlag 118)
							(gMessager say: 1 2 34) ; "Crodfoller gave me the impression you'd be much more helpful, Mr. Ziggy."
						else
							(gMessager say: 1 2 33) ; "You don't seem very talkative, sir. Is there anything I can say to loosen your lips?"
						)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance flapper of Prop
	(properties
		x 141
		y 87
		noun 4
		view 315
		cel 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6 ; Ask
				(switch (gCurRoom setInset: (ScriptID 20 0)) ; inNotebook
					(-1 0)
					(else
						(gMessager say: 4 6 5) ; "It would be very rude to interrupt her while she's performing."
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance pianoplayer of Prop
	(properties
		x 116
		y 83
		noun 5
		view 315
		loop 1
		cel 13
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6 ; Ask
				(switch (gCurRoom setInset: (ScriptID 20 0)) ; inNotebook
					(-1 0)
					(else
						(gMessager say: 5 6 5) ; "Don't bother Doctor Jazz while he's performing."
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sleeper of View
	(properties
		x 287
		y 117
		noun 6
		view 317
		loop 1
		cel 3
	)
)

(instance woman1 of View
	(properties
		x 261
		y 100
		noun 11
		view 317
		cel 3
		priority 8
		signal 16
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if local0
					(gMessager say: 11 1 1) ; "They're involved in a deep conversation about President Calvin Coolidge."
					(= local0 0)
				else
					(gMessager say: 11 1 2) ; "They're involved in a deep conversation about F. Scott Fitzgerald's novel, The Great Gatsby, published in 1925."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance woman2 of View
	(properties
		x 236
		y 101
		noun 11
		view 317
		loop 2
		priority 8
		signal 16400
	)

	(method (doVerb theVerb)
		(woman1 doVerb: theVerb)
	)
)

(instance dancersA of Prop
	(properties
		x 183
		y 111
		noun 8
		view 313
		cel 1
		signal 4096
	)
)

(instance dancersB of Prop
	(properties
		x 151
		y 121
		noun 8
		view 313
		loop 3
		cel 5
		signal 4096
	)
)

(instance dancersC of Prop
	(properties
		x 106
		y 114
		noun 8
		view 313
		loop 4
		cel 2
	)
)

(instance bathroomDoor of Door
	(properties
		x 215
		y 51
		noun 9
		approachX 228
		approachY 109
		view 311
		entranceTo 320
		moveToX 255
		moveToY 95
		enterType 0
		exitType 0
	)

	(method (createPoly)
		(super createPoly: 211 100 253 100 253 109 211 109)
	)
)

(instance endOfBar of Feature
	(properties
		y 136
		nsTop 99
		nsLeft 90
		nsBottom 131
		nsRight 110
	)
)

(instance southExitFeature of ExitFeature
	(properties
		nsTop 184
		nsBottom 189
		nsRight 319
		cursor 11
		exitDir 3
		noun 12
	)

	(method (handleEvent event)
		(cond
			((not (gUser input:)))
			((not (self onMe: gMouseX (- gMouseY 10))))
			(
				(or
					(and (== (event type:) evKEYBOARD) (!= (event message:) KEY_RETURN))
					(and (== (event type:) evMOUSEBUTTON) (event modifiers:))
					(not (OneOf (event type:) evMOUSEBUTTON evKEYBOARD))
				)
				(= lastCursor -1)
			)
			((== gTheCursor ((gTheIconBar at: 1) cursor:))
				(event claimed: 1)
				(gMessager say: noun 1) ; "This is the exit, leading back out onto the mean streets of Manhattan."
			)
			((!= gTheCursor cursor))
			(else
				(event claimed: 1)
				(gCurRoom setScript: sLeaveSouth)
			)
		)
	)
)

(instance Bartender of Narrator
	(properties
		x 100
		y 100
		talkWidth 150
		back 15
	)

	(method (init)
		(= font gUserFont)
		(super init: &rest)
	)
)

(instance Singer of Narrator
	(properties
		x 100
		y 100
		talkWidth 150
		back 15
	)

	(method (init)
		(= font gUserFont)
		(super init: &rest)
	)
)

(instance PianoPlayer of Narrator
	(properties
		x 100
		y 100
		talkWidth 150
		back 15
	)

	(method (init)
		(= font gUserFont)
		(super init: &rest)
	)
)

