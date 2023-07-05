;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 380)
(include sci.sh)
(use Main)
(use ExitFeature)
(use BalloonTalker)
(use ADRoom)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use MoveFwd)
(use Timer)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm380 0
	butlerT 2
	percyT 14
)

(local
	[local0 3]
	local3 = 1
)

(instance rm380 of ADRoom
	(properties
		noun 1
		picture 380
		north 400
		east 370
		west 390
		vanishingY 54
	)

	(method (init)
		((ScriptID 895 0) init: normalize: setScale: 160) ; pepper
		(gEgo state: (| (gEgo state:) $0002))
		(switch gPrevRoomNum
			(north
				(gEgo state: (& (gEgo state:) $fffd))
				(butler init:)
				(gCurRoom setScript: sExitMaze)
			)
			(east
				(pailInKitchen init:)
				(gEgo x: 218 y: 135)
				(butler init:)
				(gCurRoom setScript: sExitStudy)
			)
			(west
				(gEgo state: (& (gEgo state:) $fffd))
				(pailInKitchen init:)
				(gEgo x: 166 y: 120 setHeading: 180)
				(if (IsFlag 76)
					(gEgo view: 388)
				)
				(butler init:)
				(if (not (IsFlag 76))
					(butler
						view: 376
						loop: 4
						cel: 0
						x: 137
						y: 137
						setSpeed: 10
						setCycle: Fwd
					)
					(sFX number: 3814 loop: -1 play:)
					(gWalkHandler addToFront: gCurRoom)
					(gMouseDownHandler addToFront: gCurRoom)
					(gKeyDownHandler addToFront: gCurRoom)
					(gDirectionHandler addToFront: gCurRoom)
				)
				(gCurRoom setScript: sExitKitchen)
			)
			(else
				(pailInKitchen init:)
				(gGame handsOn:)
				(gEgo posn: 105 160)
			)
		)
		(super init: &rest)
		(self
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 316 51 252 51 243 44 265 39 235 39 214 38 233 51 107 51 102 54 233 54 260 66 276 107 261 140 219 161 154 174 143 161 147 151 235 131 229 127 181 127 174 107 126 97 125 101 162 111 162 128 107 128 69 131 24 163 27 179 24 189 241 189 302 153 315 123 298 81 260 54 312 54
					yourself:
				)
		)
		(chandelier init: setOnMeCheck: 1 16384)
		(closetDoor init:)
		(doorknob init:)
		(frontdoors init: addToPic:)
		(lamp init:)
		(pic1 init:)
		(pic2 init:)
		(pic3 init:)
		(pic4 init:)
		(bannister init: setOnMeCheck: 1 8192)
		(columns init: setOnMeCheck: 1 2048)
		(stairs init: setOnMeCheck: 1 4096)
		(northKitEFeature init:)
		(upstairsEFeature init:)
		(eastEFeature init:)
	)

	(method (doit &tmp temp0)
		(super doit:)
		(= temp0 (gEgo onControl: 1))
		(cond
			(script)
			((& temp0 $0002)
				(gCurRoom newRoom: 400 10) ; Maze
			)
			((& temp0 $0004)
				(gCurRoom setScript: sEnterKitchen)
			)
			((& temp0 $0008)
				(gCurRoom newRoom: east)
			)
			(
				(and
					(== gEgo (ScriptID 895 0)) ; pepper
					(& temp0 $1000)
					(gCast contains: butler)
					(or (IsFlag 76) (IsFlag 369))
				)
				(gCurRoom setScript: sNotDownTheStairs)
			)
			((and (& temp0 $1000) (< (gEgo y:) 82) (not local3))
				(= local3 1)
				(gCurRoom vanishingY: 81)
				(gEgo setScale: Scaler 102 75 79 52)
			)
			(
				(and
					(& temp0 $1000)
					(< (gEgo y:) 167)
					(> (gEgo y:) 82)
					local3
				)
				(= local3 0)
				(gEgo setScale: 0)
			)
			((and (& temp0 $1000) (> (gEgo y:) 167) (not local3))
				(gCurRoom vanishingY: 54)
				(= local3 1)
				(gEgo setScale: 160)
			)
		)
	)

	(method (handleEvent event &tmp temp0 temp1)
		(super handleEvent: event)
		(if (event claimed:)
			(return 1)
		)
		(= temp0 (event type:))
		(= temp1 (event message:))
		(if
			(and
				(== temp0 $0044) ; direction | evKEYBOARD
				(gCast contains: butler)
				(> (dressTimer seconds:) 0)
				(gUser controls:)
				(gUser input:)
			)
			(event claimed: 1)
			(gEgo setMotion: 0)
			(dressTimer cycleCnt: 3)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Walk
				(if (and (gCast contains: butler) (> (dressTimer seconds:) 0))
					(gEgo setMotion: 0)
					(dressTimer cycleCnt: 3)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(84 ; Trivia
				(= global215 8)
				(super doVerb: theVerb &rest)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (dispose)
		(gWalkHandler delete: gCurRoom)
		(gMouseDownHandler delete: gCurRoom)
		(gKeyDownHandler delete: gCurRoom)
		(gDirectionHandler delete: gCurRoom)
		(dressTimer dispose: delete:)
		(super dispose:)
	)
)

(instance sPepperImaUpStairs of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 20 0 7 0 self) ; "Hello, Miss Ima! Is there anything I can do for you, Miss?"
			)
			(1
				(gGame points: 371 4)
				(gEgo view: 388 setMotion: PolyPath 123 174 self)
			)
			(2
				(gEgo setMotion: PolyPath 236 170 self)
			)
			(3
				(gCurRoom vanishingY: 81)
				(gEgo
					setScale: Scaler 102 75 79 52
					setMotion: PolyPath 269 80 self
				)
			)
			(4
				(gEgo setMotion: PolyPath 249 50 self)
			)
			(5
				(gEgo loop: 8 cel: 2)
				(= cycles 1)
			)
			(6
				(gMessager say: 13 0 18 1 2 self 400) ; "Not one word from you! I don't wanna hear it! You'd better not laugh, either!"
			)
			(7
				(gEgo setMotion: PolyPath 263 40 self)
			)
			(8
				(gEgo normalize: 790 1)
				(= cycles 1)
			)
			(9
				(gEgo setMotion: PolyPath 248 53 self)
			)
			(10
				(gMessager say: 13 0 18 3 self 400) ; "That's better!"
			)
			(11
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sEnterKitchen of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gEgo setMotion: PolyPath 128 113 self)
			)
			(2
				(gCurRoom newRoom: 390 10)
			)
		)
	)
)

(instance sExitKitchen of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gEgo setMotion: MoveTo 166 136 self)
			)
			(2
				(cond
					((IsFlag 76)
						(sFX stop:)
						(butler setCycle: 0)
						(gCurRoom setScript: sPepperImaUpStairs)
					)
					((gEgo has: 23) ; Back_Scratcher
						(dressTimer setReal: dressTimer 30)
						(gMessager say: 20 0 36 0 self) ; "Wretched, awful, blasted FLEAS! DRAT that wretched dog!"
					)
					(else
						(sFX stop:)
						(butler setCycle: 0)
						(dressTimer setReal: dressTimer 1)
						(gMessager say: 20 0 36 0 self) ; "Wretched, awful, blasted FLEAS! DRAT that wretched dog!"
					)
				)
			)
			(3
				(sFX number: 3814 loop: -1 play:)
				(butler setSpeed: 10 setCycle: Fwd)
				(gEgo state: (& (gEgo state:) $fffd))
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sExitStudy of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gEgo setMotion: PolyPath 182 138 self)
			)
			(2
				(gEgo setMotion: MoveTo 166 136 self)
			)
			(3
				(if (or (IsFlag 153) (IsFlag 154))
					(self setScript: sSaltMines self)
				else
					(= cycles 1)
				)
			)
			(4
				(sFX number: 3816 loop: 1 play:)
				(butler setCycle: CT 6 1 self)
			)
			(5
				(gEgo hide:)
				(butler setCycle: End self)
			)
			(6
				(if (or (IsFlag 153) (IsFlag 154))
					(= global199 9)
					(gCurRoom newRoom: 610)
				else
					(client setScript: sKitchenDuty)
				)
			)
		)
	)
)

(instance sSaltMines of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 20 0 29 1 3 self) ; "Here now, hold on! Who are you?"
			)
			(1
				(percy
					init:
					setScale: 160
					setLoop: 1
					setCycle: Walk
					setMotion: MoveTo 207 130 self
				)
				(gMessager say: 20 0 29 4 self) ; "STOP! STOP, THIEF!"
			)
			(2 0)
			(3
				(percy loop: 4 cel: 1 stopUpd:)
				(percyT winX: 50 winY: 85)
				(gMessager say: 20 0 29 5 6 self) ; "Where? Where?"
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance sKitchenDuty of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 20 0 3 0 self) ; "Here now! Who are you?"
			)
			(1
				(gEgo setHeading: 0 setMotion: MoveFwd 10 self)
			)
			(2
				(gCurRoom newRoom: 390)
			)
		)
	)
)

(instance sExitMaze of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gCurRoom vanishingY: 81)
				(gEgo setScale: Scaler 102 75 79 52 posn: 239 54)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sNotDownTheStairs of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gMessager say: 20 0 30 0 self) ; "Why would Pepper want to go back down there? She wants to go find Lockjaw!"
			)
			(2
				(gEgo setHeading: 0 setMotion: MoveFwd 5 self)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sCaughtGoToKitchen of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: 0)
				(sFX stop:)
				(= cycles 1)
			)
			(1
				(sFX number: 3816 loop: 1 play:)
				(butler
					view: 380
					loop: 4
					cel: 0
					posn: 123 118
					setCycle: CT 6 1 self
				)
			)
			(2
				(gEgo hide:)
				(butler setCycle: End self)
			)
			(3
				(gMessager say: 20 0 5 0 self) ; "Oh, you're just trying to escape, that's what. Get back to the kitchen!"
			)
			(4
				(gEgo setHeading: 0 show: setMotion: MoveFwd 20 self)
				(sFX number: 3814 loop: -1 play:)
				(butler
					view: 376
					loop: 4
					cel: 0
					x: 137
					y: 137
					setSpeed: 10
					setCycle: Fwd
				)
			)
			(5
				(self dispose:)
			)
		)
	)
)

(instance sCaughtTalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(butler setCycle: 0)
				(gMessager say: 21 85 0 0 self) ; "Uh, hi! I was just wondering--"
			)
			(1
				(client setScript: sCaughtGoToKitchen)
			)
		)
	)
)

(instance sBackscratchButler of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(sFX stop:)
				(butler stopUpd:)
				(= cycles 1)
			)
			(1
				(dressTimer dispose:)
				(gGame points: 369 3)
				(= cycles 1)
			)
			(2
				(gMessager say: 21 60 4 1 self) ; "I, uh, I just came out to give you this! You looked like you could use it!"
			)
			(3
				(gEgo
					view: 380
					setLoop: 7
					cel: 0
					posn: 167 139
					setCycle: End self
				)
				(butler
					view: 380
					setLoop: 9
					cel: 0
					posn: 134 132
					setCycle: End self
				)
			)
			(4 0)
			(5
				(gMessager say: 21 60 4 2 self) ; "Why, thank you, lad! That's kind of you, it is!"
			)
			(6
				(sFX number: 3815 loop: -1 play:)
				(butler loop: 8 cel: 0 posn: 146 133 setCycle: Fwd)
				(gEgo normalize: 790 2)
				(= ticks 120)
			)
			(7
				(gMessager say: 21 60 4 3 self) ; "Aaaaaaaah!"
			)
			(8
				(gWalkHandler delete: gCurRoom)
				(gDirectionHandler delete: gCurRoom)
				(gMouseDownHandler delete: gCurRoom)
				(gKeyDownHandler delete: gCurRoom)
				(= cycles 1)
			)
			(9
				(gEgo setMotion: PolyPath 236 170 self)
			)
			(10
				(gCurRoom vanishingY: 81)
				(gEgo
					put: 23 ; Back_Scratcher
					setScale: Scaler 102 75 79 52
					setMotion: PolyPath 248 53 self
				)
			)
			(11
				(butler setCycle: 0 view: 380 loop: 4 cel: 0 posn: 123 118)
				(sFX stop:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance butler of Actor
	(properties
		x 123
		y 118
		noun 21
		view 380
		loop 4
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(60 ; Back_Scratcher
				(if (not (IsFlag 76))
					(gCurRoom setScript: sBackscratchButler)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(84 ; Trivia
				(gMessager say: 21 84) ; "|c1|TRUE. Butlers have been employed in the homes of wealthy people for centuries. A butler is the head servant of a household, coordinating and supervising all the other servants.|c|"
				(sFX number: 927 loop: 1 play:)
			)
			(85 ; Talk
				(if (or (IsFlag 76) (IsFlag 369))
					(gMessager say: 1 85) ; "Pepper doesn't want to call attention to herself by talking."
				else
					(gCurRoom setScript: sCaughtTalk)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance percy of Actor
	(properties
		x 236
		y 128
		view 819
		loop 4
		cel 1
		signal 16384
	)
)

(instance pailInKitchen of View
	(properties
		x 178
		y 81
		noun 9
		approachX 169
		approachY 126
		_approachVerbs 9
		view 380
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(84 ; Trivia
				(= global215 8)
				(super doVerb: theVerb &rest)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance chandelier of Feature
	(properties
		y 2
		noun 5
	)
)

(instance closetDoor of Feature
	(properties
		x 173
		y 26
		noun 22
		nsTop 1
		nsLeft 146
		nsBottom 51
		nsRight 201
		approachX 197
		approachY 53
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 7 6) ; Do, Look
	)
)

(instance doorknob of Feature
	(properties
		x 34
		y 149
		noun 3
		nsTop 116
		nsLeft 28
		nsBottom 122
		nsRight 41
		approachX 44
		approachY 144
		_approachVerbs 9
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Do
				(gMessager say: 3 7 17) ; "The door is locked and bolted."
			)
			(84 ; Trivia
				(= global215 8)
				(super doVerb: theVerb &rest)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance frontdoors of View
	(properties
		x 17
		y 147
		noun 2
		approachX 45
		approachY 144
		_approachVerbs 9
		view 380
		cel 2
		signal 16385
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Do
				(gMessager say: 2 85 17) ; "Hey! Is there anybody out there? Lemme out!"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance lamp of Feature
	(properties
		x 136
		y 84
		noun 6
		nsTop 75
		nsLeft 130
		nsBottom 93
		nsRight 142
		approachX 135
		approachY 126
		_approachVerbs 9
	)
)

(instance pic1 of Feature
	(properties
		x 131
		y 12
		noun 14
		nsTop 3
		nsLeft 122
		nsBottom 21
		nsRight 141
		approachX 141
		approachY 52
		_approachVerbs 9
	)
)

(instance pic2 of Feature
	(properties
		x 288
		y 18
		noun 15
		nsTop 4
		nsLeft 279
		nsBottom 32
		nsRight 298
		approachX 287
		approachY 52
		_approachVerbs 9
	)
)

(instance pic3 of Feature
	(properties
		x 315
		y 16
		noun 16
		nsTop 4
		nsLeft 312
		nsBottom 29
		nsRight 319
		approachX 315
		approachY 53
		_approachVerbs 9
	)
)

(instance pic4 of Feature
	(properties
		x 230
		y 87
		noun 17
		nsTop 75
		nsLeft 204
		nsBottom 100
		nsRight 256
		approachX 226
		approachY 126
		_approachVerbs 9
	)
)

(instance bannister of Feature
	(properties
		noun 8
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6 ; Look
				(= global215 61)
				(super doVerb: theVerb &rest)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance columns of Feature
	(properties
		noun 4
	)
)

(instance stairs of Feature
	(properties
		noun 7
	)
)

(instance northKitEFeature of ExitFeature
	(properties
		nsTop 70
		nsLeft 155
		nsBottom 122
		nsRight 188
		cursor 912
		exitDir 1
		noun 9
	)

	(method (doVerb theVerb)
		(pailInKitchen doVerb: theVerb &rest)
	)
)

(instance upstairsEFeature of ExitFeature
	(properties
		nsLeft 221
		nsBottom 51
		nsRight 262
		cursor 912
		exitDir 1
		noun 1
	)
)

(instance eastEFeature of ExitFeature
	(properties
		nsTop 68
		nsLeft 308
		nsBottom 189
		nsRight 319
		cursor 913
		exitDir 2
		noun 1
	)
)

(instance butlerT of BalloonTalker
	(properties
		x 133
		y 95
		talkWidth 160
	)
)

(instance percyT of BalloonTalker
	(properties
		x 73
		y 85
		talkWidth 160
		tailPosn 1
	)
)

(instance dressTimer of Timer
	(properties)

	(method (cue)
		(if (gCurRoom script:)
			((gCurRoom script:) next: sCaughtGoToKitchen)
		else
			(gEgo setMotion: 0)
			(gCurRoom setScript: sCaughtGoToKitchen)
		)
	)
)

(instance sFX of Sound
	(properties
		flags 1
	)
)

