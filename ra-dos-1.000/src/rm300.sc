;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 300)
(include sci.sh)
(use Main)
(use Door)
(use eRS)
(use ExitFeature)
(use Print)
(use Talker)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm300 0
	Bouncer 17
)

(local
	local0
	local1
	local2
)

(instance rm300 of LBRoom
	(properties
		noun 20
		picture 300
		north 310
		south 260
		vanishingX 167
	)

	(method (init)
		(LoadMany rsVIEW 303 301 852 304 284)
		(LoadMany rsSOUND 94 40)
		(self setRegions: 91) ; streetRgn
		(gEgo
			init:
			normalize: (if (gEgo wearingGown:) 831 else 830)
			setScale: Scaler 90 110 167 125
		)
		(switch gPrevRoomNum
			(north
				(gEgo edgeHit: EDGE_NONE setHeading: 180)
				(gGameMusic1 fade:)
			)
			(south
				(gEgo x: 230 y: 200)
				(gCurRoom setScript: sOverControl)
			)
			(else
				(taxi setScale: 199 init: posn: 269 199)
				(gCurRoom setScript: sOutCab)
			)
		)
		(super init:)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 291 165 298 175 277 179 244 177 242 169
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 319 0 319 158 165 168 127 168 97 161 98 155 127 146 123 121 95 141 84 156 11 185 122 185 122 178 161 178 161 185 231 185 232 189 0 189
					yourself:
				)
		)
		(mugger init: setScript: sMugTimer)
		(frontDoor init: approachVerbs: 11 6 4) ; pressPass, Ask, Do
		(taxiSign approachVerbs: 4 addToPic:) ; Do
		(fireHydrant init:)
		(trash init:)
		(flowersDoor init:)
		(flowerWinL init:)
		(flowerWinR init:)
		(tinyWin init:)
		(moxieSign init:)
		(streetLight init:)
		(southExitFeature init:)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 310)
			(gGameMusic1 fade:)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance sOverControl of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath (gEgo x:) 170 self)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sOutCab of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo x: 241 y: 179)
				(= seconds 1)
			)
			(1
				(gGameMusic2 send: 2 224 2000)
				(taxi setLoop: 5 setMotion: MoveTo 157 275 self)
				(gGameMusic2 fade:)
			)
			(2
				(gGame handsOn:)
				(taxi dispose:)
				(self dispose:)
			)
		)
	)
)

(instance sMugTimer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (gEgo wearingGown:)
					(self dispose:)
				else
					(= seconds 240)
				)
			)
			(1
				(client setScript: sMuggerKills)
			)
		)
	)
)

(instance sMuggerKills of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 1)
			)
			(1
				(if (gCurRoom script:)
					(self dispose:)
				else
					(gGame handsOff:)
					(= cycles 1)
				)
			)
			(2
				(cond
					((StepOn gEgo 2)
						(gEgo setMotion: PolyPath 101 169 self)
					)
					((> (gEgo x:) 300)
						(gEgo setMotion: PolyPath 280 165 self)
					)
					(else
						(= cycles 1)
					)
				)
			)
			(3
				(Face gEgo mugger)
				(noise number: 163 loop: -1 flags: 1 play:)
				(= cycles 5)
			)
			(4
				(mugger
					view: 303
					setLoop: 0
					setPri: -1
					cycleSpeed: 4
					moveSpeed: 4
					setCycle: Walk
					setMotion: MoveTo 311 162 self
				)
			)
			(5
				(mugger
					setMotion:
						PolyPath
						(+ (gEgo x:) 22)
						(+ (gEgo y:) 3)
						self
				)
			)
			(6
				(mugger
					setLoop: 1
					cel: 0
					posn: (- (mugger x:) 5) (- (mugger y:) 1)
					cycleSpeed: 12
					moveSpeed: 12
					setCycle: End self
				)
				(noise stop:)
				(sFX number: 3 play:)
			)
			(7
				(= seconds 1)
			)
			(8
				(gEgo
					view: 303
					loop: 2
					posn: (gEgo x:) (- (gEgo y:) 3)
					cycleSpeed: 12
					moveSpeed: 12
					setCycle: End self
				)
			)
			(9
				(gMessager say: 1 0 0 0 self) ; "In the final moments of your life, you wonder what the world is coming to these days."
				(gEgo looper: 0)
			)
			(10
				(= global145 12) ; "In big cities, a person gets mugged every few minutes. Don't let that person be YOU."
				(gCurRoom newRoom: 99) ; deathRoom
			)
		)
	)
)

(instance sGivePass of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(= seconds 1)
			)
			(2
				(gEgo put: 6) ; pressPass
				(gEgo
					view: 301
					loop: 0
					posn: 88 160
					cycleSpeed: 10
					moveSpeed: 10
					setCycle: End self
				)
			)
			(3
				(gMessager say: 3 11 0 0 self) ; "A Press Pass? I'll keep it for you! Now, get lost! We don't want your kind around here!"
			)
			(4
				(gEgo
					posn: 79 159
					normalize: (if (gEgo wearingGown:) 831 else 830)
				)
				(= cycles 1)
			)
			(5
				(gGame handsOn:)
				(if (mugger script:)
					((mugger script:) dispose:)
				)
				(gGame handsOff:)
				(mugger setScript: sMuggerKills)
				(self dispose:)
			)
		)
	)
)

(instance sHailCab of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGameMusic2 number: 252 loop: -1 flags: 1 play: 20)
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(taxi init: setScale: 199 posn: 415 186)
				(gEgo setMotion: PolyPath 242 179 self)
			)
			(2
				(gEgo
					view: (if (gEgo wearingGown:) 304 else 852)
					setLoop: (if (gEgo wearingGown:) 2 else 0)
					posn: (- (gEgo x:) 2) (- (gEgo y:) 1)
					setScale: Scaler 105 0 190 0
					setCycle: End self
				)
				(gGameMusic1 number: 97 loop: 1 flags: 1 play:)
			)
			(3
				(gGameMusic2 send: 2 224 2000 fade: 127 5 5 0)
				(taxi
					setLoop: 5
					setMotion:
						MoveTo
						(+ (taxiSign x:) 10)
						(+ (taxiSign y:) 25)
						self
				)
			)
			(4
				(gGameMusic2 send: 2 224 1600)
				(= cycles 1)
			)
			(5
				(gGameMusic2 send: 2 224 1200)
				(= cycles 1)
			)
			(6
				(gGameMusic2 send: 2 224 800)
				(= cycles 1)
			)
			(7
				(gGameMusic2 send: 2 224 400)
				(= cycles 1)
			)
			(8
				(gGameMusic2 send: 2 224 0)
				(noise number: 40 flags: 5 play: self)
			)
			(9
				(gEgo normalize: 830 hide:)
				(= cycles 1)
			)
			(10
				(gCurRoom newRoom: 250)
			)
		)
	)
)

(instance sEnterBar of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local2 (gEgo moveSpeed:))
				(= cycles 1)
			)
			(1
				(gEgo
					view: 301
					loop: 0
					cel: 0
					posn: (+ (gEgo x:) 10) (gEgo y:)
					setSpeed: 6
					setCycle: CT 5 1 self
				)
			)
			(2
				(sFX number: 297 play:)
				(gEgo setCycle: CT 6 1 self)
			)
			(3
				(gEgo setCycle: CT 2 -1 self)
			)
			(4
				(gEgo setCycle: CT 5 1 self)
			)
			(5
				(gEgo setCycle: CT 6 1 self)
			)
			(6
				(gEgo
					loop: 6
					posn: (- (gEgo x:) 10) (gEgo y:)
					setSpeed: local2
					normalize: (if (gEgo wearingGown:) 831 else 830)
				)
				(= cycles 5)
			)
			(7
				(gMessager say: 3 4 0 1 self) ; "We're closed! No deliveries!"
			)
			(8
				(switch
					(Print
						addText: 2 0 0 0 ; "You respond to the man's remark."
						addButton: 1 14 0 0 1 5 20 ; "Sorry. My mistake."
						addButton: 2 14 0 0 2 5 38 ; "Let me in, or I'll scream."
						addButton: 3 14 0 0 3 5 56 ; "Wait! I know the secret word!"
						init:
					)
					(1
						(= cycles 1)
					)
					(2
						(gMessager say: 3 4 0 5 self) ; "Scream all you want, toots. You're not getting into this flower shop."
					)
					(3
						(= local0 1)
						(gMessager say: 3 4 0 6 self) ; "Secret word?"
					)
					(else
						(= cycles 1)
					)
				)
			)
			(9
				(= cycles 1)
			)
			(10
				(if local0
					(client setScript: sAskEnterBar)
				else
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance sAskEnterBar of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= register 0)
				(if local0
					(switch (gCurRoom setInset: (ScriptID 20 0)) ; inNotebook
						(1029
							(gMessager say: 3 4 0 7 self) ; "The password is CHARLESTON."
							(= register 1)
						)
						(else
							(gMessager say: 3 4 0 8 self) ; "Are you deaf, lady? We're closed! Go away!"
							(= local0 0)
						)
					)
				else
					(gMessager say: 3 4 0 8 self) ; "Are you deaf, lady? We're closed! Go away!"
					(= local0 0)
				)
			)
			(1
				(if (== register 1)
					(gMessager say: 3 4 0 9 self) ; "Well, why didn't you SAY so! Come on in!"
				else
					(= cycles 1)
				)
			)
			(2
				(if (== register 1)
					(= local1 1)
					(= global116 1024)
					(= global108 (= global109 1))
					(frontDoor doVerb: 4)
				else
					(gGame handsOn:)
				)
				(self dispose:)
			)
		)
	)
)

(instance mugger of Actor
	(properties
		x 330
		y 160
		noun 1
		view 303
	)
)

(instance frontDoor of Door
	(properties
		x 104
		y 155
		noun 3
		approachX 79
		approachY 159
		view 304
		entranceTo 310
		moveToX 121
		moveToY 143
		enterType 0
		exitType 0
	)

	(method (createPoly)
		(super createPoly: 77 146 109 148 109 157 77 154)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if local1
					(super doVerb: theVerb &rest)
				else
					(gCurRoom setScript: sEnterBar)
				)
			)
			(11 ; pressPass
				(gCurRoom setScript: sGivePass)
			)
			(6 ; Ask
				(if local0
					(gGame handsOff:)
					(gCurRoom setScript: sAskEnterBar)
				else
					(gCurRoom setScript: sEnterBar)
				)
			)
			(14 ; notebook
				(if local0
					(gGame handsOff:)
					(gCurRoom setScript: sAskEnterBar)
				else
					(gCurRoom setScript: sEnterBar)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (cue)
		(super cue: &rest)
		(if (gEgo wearingGown:)
			(gCurRoom setScript: sHailCab)
		)
	)
)

(instance taxi of Actor
	(properties
		x 415
		y 186
		noun 8
		view 852
		loop 5
		moveSpeed 4
	)
)

(instance taxiSign of View
	(properties
		x 259
		y 174
		noun 9
		sightAngle 40
		approachX 242
		approachY 179
		view 284
		cel 1
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: sHailCab)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance fireHydrant of Feature
	(properties
		x 142
		y 169
		noun 10
		nsTop 153
		nsLeft 136
		nsBottom 185
		nsRight 148
		sightAngle 40
	)
)

(instance trash of Feature
	(properties
		x 33
		y 143
		noun 11
		nsTop 133
		nsLeft 13
		nsBottom 154
		nsRight 54
		sightAngle 40
	)
)

(instance flowersDoor of Feature
	(properties
		x 185
		y 125
		noun 5
		nsTop 98
		nsLeft 171
		nsBottom 152
		nsRight 199
		sightAngle 40
	)
)

(instance flowerWinL of Feature
	(properties
		x 152
		y 122
		noun 6
		nsTop 98
		nsLeft 135
		nsBottom 147
		nsRight 169
		sightAngle 40
	)
)

(instance flowerWinR of Feature
	(properties
		x 225
		y 121
		noun 6
		nsTop 98
		nsLeft 200
		nsBottom 144
		nsRight 251
		sightAngle 40
	)
)

(instance tinyWin of Feature
	(properties
		x 91
		y 109
		noun 4
		nsTop 106
		nsLeft 88
		nsBottom 112
		nsRight 95
		sightAngle 40
	)
)

(instance moxieSign of Feature
	(properties
		x 34
		y 78
		noun 7
		nsTop 60
		nsBottom 97
		nsRight 69
		sightAngle 40
	)
)

(instance streetLight of Feature
	(properties
		x 275
		y 78
		noun 12
		onMeCheck 16384
	)
)

(instance southExitFeature of ExitFeature
	(properties
		nsTop 184
		nsLeft 219
		nsBottom 189
		nsRight 289
		cursor 11
		exitDir 3
		noun 15
	)
)

(instance Bouncer of Narrator
	(properties
		x 100
		y 50
		talkWidth 150
		back 15
	)

	(method (init)
		(= font gUserFont)
		(super init: &rest)
	)
)

(instance noise of Sound
	(properties
		flags 1
	)
)

(instance sFX of Sound
	(properties
		flags 1
	)
)

