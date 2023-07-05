;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 240)
(include sci.sh)
(use Main)
(use GloryRm)
(use Teller)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	rm240 0
)

(local
	local0
	local1
)

(instance rm240 of GloryRm
	(properties
		picture 330
		style 1024
		south 320
	)

	(method (init)
		(= local0
			(cond
				((not (IsFlag 159)) 1)
				((gEgo has: 31) 4) ; theHumorbar
				((and (IsFlag 159) (not (IsFlag 160))) 2)
				((and (IsFlag 160) (not (IsFlag 130))) 3)
				((IsFlag 130) 5)
			)
		)
		(gEgo
			init:
			posn: 201 240
			normalize:
			setPri: 170
			setScaler: Scaler 150 85 163 112
		)
		(gWalkHandler addToFront: self)
		(if gNight
			(nightWin init:)
		)
		(if (not (IsFlag 428))
			(chicken init: approachVerbs: 4) ; Do
		)
		(foolsCap init:)
		(garlic1 init:)
		(garlic2 init:)
		(nightCap init:)
		(blanket init:)
		(rug init:)
		(chair init: approachVerbs: 4) ; Do
		(candle init:)
		(lamp init:)
		(theWindow init:)
		(bedTable init:)
		(gnome init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 145 144 79 130 54 143 130 163 130 189 0 189 0 0 319 0 319 189 239 189 235 163 274 163 274 149 265 149 248 140 248 130 209 124
					yourself:
				)
		)
		(super init: &rest)
		(gLongSong number: 240 setLoop: -1 play:)
		(self setScript: sEnterScr)
	)

	(method (handleEvent event)
		(if (and (== ((gTheIconBar getCursor:) view:) 940) (>= (event y:) 163))
			(gCurRoom setScript: sExitScript)
		else
			(super handleEvent: event &rest)
		)
	)

	(method (doit)
		(if (and (not script) (!= gTime local1))
			(= local1 gTime)
			(cond
				((>= gTime 4)
					(if (not (gCast contains: nightWin))
						(nightWin init: approachVerbs: 4) ; Do
					)
				)
				((gCast contains: nightWin)
					(nightWin dispose:)
				)
			)
		)
		(super doit: &rest)
	)

	(method (dispose)
		(gLongSong fade:)
		(gWalkHandler delete: self)
		(super dispose: &rest)
	)
)

(instance sEnterScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo setMotion: MoveTo 201 157 self)
			)
			(1
				(heroTeller
					init:
						gEgo
						240
						16
						128
						(switch local0
							(1 15)
							(2 19)
							(3 21)
							(4 22)
							(5 23)
						)
				)
				(switch local0
					(1
						(self setScript: sFirstVisit self)
					)
					(2
						(self setScript: sSecondVisit self)
					)
					(3
						(gMessager say: 13 6 (+ 49 (Random 0 4)) 0 self)
					)
					(4
						(self setScript: sGoodHumor self)
					)
					(5
						(gMessager say: 13 6 (+ 61 (Random 0 4)) 0 self)
					)
					(else
						(= cycles 1)
					)
				)
			)
			(2
				(gEgo setPri: -1)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sExitScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo setMotion: PolyPath 204 162 self)
			)
			(1
				(switch local0
					(1
						(gMessager say: 13 6 5 0 self) ; "So I asks ya, what da ya call a dinosaur crashing into a wall?"
					)
					(2
						(gMessager say: 13 6 22 0 self) ; "Did ya hear the one about the Vampire Architect?"
					)
					(3
						(gMessager say: 13 6 (+ 53 (Random 0 4)) 0 self)
					)
					(4
						(SetFlag 161)
						(gMessager say: 13 6 60 0 self) ; "Before ya blow, Joe, I figure Iowa. I'm going ta let ya in on a secret only we Gnomes know. I'm going ta tell ya the Ultimate Joke."
					)
					(else
						(gMessager say: 13 6 (+ 66 (Random 0 4)) 0 self)
					)
				)
			)
			(2
				(gEgo setPri: 170 setMotion: MoveTo 204 240 self)
			)
			(3
				(gGlory handsOn:)
				(gCurRoom newRoom: 320)
			)
		)
	)
)

(instance sFirstVisit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(SetFlag 159)
				(gMessager say: 13 6 1 0 self) ; "Halloo, howarya? Come in and have a sit, why doncha?"
			)
			(1
				(gnome setCycle: End self)
				(gEgo setMotion: PolyPath 257 140 self)
			)
			(2 0)
			(3
				(Face gEgo (foolsCap x:) (foolsCap y:) self)
			)
			(4
				(gEgo
					view: 54
					loop: 4
					cel: 0
					posn: 261 140
					setCycle: End self
				)
			)
			(5
				(= seconds 2)
			)
			(6
				(gMessager say: 14 6 2 0 self) ; "As you sit down, a rude noise comes from the chair seat."
			)
			(7
				(= seconds 1)
			)
			(8
				(gnome setLoop: 1 1 setCycle: End self)
				(gEgo cycleSpeed: 2 setCycle: Beg self)
			)
			(9 0)
			(10
				(gnome setLoop: 0 1 setCel: (gnome lastCel:) setCycle: Beg self)
			)
			(11
				(gMessager say: 13 6 4 0 self) ; "Ha, ha, ha! Gets ya every time! A million laughs!"
			)
			(12
				(gEgo
					normalize:
					setSpeed: global346
					setMotion: MoveTo 243 143 self
				)
			)
			(13
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sSecondVisit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(SetFlag 160)
				(gMessager say: 13 6 19 0 self) ; "Welcome back, it's good ta see ya again."
			)
			(1
				(gEgo setMotion: PolyPath 165 135 self)
			)
			(2
				(gnome view: 33 loop: 4 cel: 0 posn: 134 104 setCycle: End self)
			)
			(3
				(gMessager say: 14 6 20 0 self) ; "You know you will be sorry if you do, and sorry if you don't."
			)
			(4
				(gEgo view: 31 loop: 1 cel: 0 setCycle: CT 2 1 self)
			)
			(5
				(gnome
					view: 241
					loop: 0
					cel: 0
					posn: 134 104
					setCycle: End self
				)
				(gEgo setCycle: CT 0 -1 self)
			)
			(6 0)
			(7
				(gEgo normalize:)
				(Face gEgo (foolsCap x:) (foolsCap y:) self)
			)
			(8
				(gEgo
					view: 33
					loop: 1
					cel: 0
					posn: 160 135
					setCycle: End self
				)
			)
			(9
				(gnome loop: 1 setCycle: End self)
				(gEgo loop: 3 posn: 163 135 setCycle: End self)
			)
			(10 0)
			(11
				(gMessager say: 13 6 21 0 self) ; "Ha, ha, ha! That's my Auntie, always making me laugh when I'm blue. No, you're blue, that's right. Ha, ha, ha."
			)
			(12
				(gnome loop: 0 cel: 7 setCycle: Beg self)
			)
			(13
				(gEgo normalize: 5)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGoodHumor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(SetFlag 130)
				(gEgo use: 31 solvePuzzle: 433 15 addHonor: 500) ; theHumorbar
				(gMessager say: 13 6 58 0 self) ; "Did I tell you about the time there was this guy walking into an inn with this big Necrotaur following him?"
			)
			(1
				(gEgo setMotion: PolyPath 165 135 self)
			)
			(2
				(gEgo view: 31 loop: 1 cel: 0 setCycle: CT 2 1 self)
			)
			(3
				(gMessager say: 14 6 59 0 self) ; "You hand the gnome the Good Humor Bar."
			)
			(4
				(gEgo setCycle: CT 0 -1 self)
			)
			(5
				(gEgo normalize: 7)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sChokeChicken of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo solvePuzzle: 428 2 get: 36) ; theChicken
				(chicken hide:)
				(= cycles 2)
			)
			(1
				(gMessager say: 8 4 0 0 self) ; "The rubber chicken squeals as you pick it up and squeeze it."
			)
			(2
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance gnomeTeller of Teller
	(properties
		title 1
	)

	(method (init)
		(super init: &rest)
		(= talker (ScriptID 67 0)) ; gnomeTalker
	)

	(method (sayMessage)
		(if (== iconValue 12) ; Curse
			(SetFlag 150)
		)
		(super sayMessage: &rest)
	)
)

(instance heroTeller of Teller
	(properties)
)

(instance gnome of Prop
	(properties
		noun 13
		x 134
		y 104
		priority 53
		fixPriority 1
		view 241
		signal 16385
	)

	(method (init)
		(super init: &rest)
		(gnomeTeller
			init:
				self
				240
				16
				149
				(switch local0
					(1 15)
					(2 19)
					(3 21)
					(4 22)
					(5 23)
				)
		)
	)
)

(instance nightWin of View
	(properties
		sightAngle 180
		x 220
		y 52
		fixPriority 1
		view 240
		loop 1
		signal 16384
	)

	(method (doVerb theVerb)
		(theWindow doVerb: theVerb &rest)
	)
)

(instance foolsCap of View
	(properties
		noun 3
		x 136
		y 130
		priority 196
		fixPriority 1
		view 240
		signal 16384
	)
)

(instance garlic1 of View
	(properties
		noun 7
		x 164
		y 19
		fixPriority 1
		view 240
		cel 1
		signal 16384
	)
)

(instance garlic2 of View
	(properties
		noun 1
		x 273
		y 19
		fixPriority 1
		view 240
		cel 4
		signal 16384
	)
)

(instance chicken of View
	(properties
		noun 8
		approachX 167
		approachY 144
		x 161
		y 106
		fixPriority 1
		view 240
		cel 2
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: sChokeChicken)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance nightCap of View
	(properties
		noun 6
		x 72
		y 76
		fixPriority 1
		view 240
		cel 3
		signal 16384
	)
)

(instance blanket of View
	(properties
		noun 5
		x 195
		y 92
		fixPriority 1
		view 240
		cel 5
		signal 16384
	)
)

(instance rug of View
	(properties
		noun 2
		x 224
		y 127
		fixPriority 1
		view 240
		cel 6
		signal 16384
	)
)

(instance chair of View
	(properties
		noun 4
		approachX 256
		approachY 145
		x 285
		y 93
		fixPriority 1
		view 240
		cel 7
		signal 16384
	)
)

(instance candle of Feature
	(properties
		noun 9
		nsLeft 49
		nsTop 90
		nsRight 66
		nsBottom 108
		sightAngle 180
		x 57
		y 99
	)
)

(instance lamp of Feature
	(properties
		noun 10
		nsLeft 216
		nsTop 43
		nsRight 239
		nsBottom 62
		sightAngle 180
		x 227
		y 52
	)
)

(instance theWindow of Feature
	(properties
		noun 11
		nsLeft 215
		nsTop 49
		nsRight 283
		nsBottom 100
		sightAngle 180
		x 249
		y 74
	)
)

(instance bedTable of Feature
	(properties
		noun 12
		nsLeft 41
		nsTop 95
		nsRight 76
		nsBottom 122
		sightAngle 180
		x 58
		y 108
	)
)

