;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2204)
(include sci.sh)
(use Main)
(use ExitButton)
(use skipCartoon)
(use eastFeat)
(use Scaler)
(use Polygon)
(use Timer)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm2204 0
)

(instance rm2204 of KQRoom
	(properties
		picture 2200
	)

	(method (init)
		(super init: &rest)
		(self
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 306 130 319 107 319 94 292 100 257 117 204 130 171 119 147 121 132 111 146 100 128 97 122 109 94 108 91 96 73 94 52 102 25 138 254 137
					yourself:
				)
		)
		(Load rsMESSAGE 2200)
		(= gValOrRoz -3) ; Roz
		(SetFlag 253)
		(fakeKing init:)
		(king init:)
		(gauge cel: (- (NumCels gauge) 1) init:)
		(gEgo
			posn: 78 103
			normalize: 4 2241
			setScaler: Scaler 90 90 145 101
			init:
		)
		(self setScript: chap6Open)
		(gWalkHandler add: self)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if (and (& (event type:) evMOVE) (== (fakeKing script:) kingFight))
			(event claimed: 1)
			(gGame pragmaFail:)
		)
	)

	(method (doit)
		(super doit:)
		(if
			(and
				(OneOf (kingFight state:) 1 2)
				(== (fakeKing script:) kingFight)
				(king isNotHidden:)
			)
			(if (not (king scratch:))
				(king setHotspot: 0 69) ; Magic_Wand
			)
			(if (not (fakeKing scratch:))
				(fakeKing setHotspot: 0 69) ; Magic_Wand
			)
		else
			(if (king scratch:)
				(king setHotspot: 0)
			)
			(if (fakeKing scratch:)
				(fakeKing setHotspot: 0)
			)
		)
	)

	(method (dispose)
		(gWalkHandler delete: self)
		(gKqSound1 setLoop: 1 stop:)
		(soundFX stop: dispose:)
		(fightTimer client: 0 delete: dispose:)
		(super dispose: &rest)
	)
)

(instance chap6Open of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(gGame handsOn:)
				(if (!= (gKqMusic1 number:) 2250)
					(gKqMusic1
						number: 2250
						setLoop: -1
						play:
						setVol: 0
						fade: 127 25 10 0
					)
				)
				(fakeKing setScript: kingFight)
				((ScriptID 7001 0) client: king) ; kingTalker
				((ScriptID 7001 1) client: malicia) ; maliciaTalker
				(Load 140 2251) ; WAVE
				(= ticks 30)
			)
			(2
				(gMessager say: 0 0 4 0 self 2200) ; "(WRESTLING WITH OTHER GUY)ROSELLA! Change the impostor back into his rightful form! It is our only chance!"
			)
			(3
				(fightTimer setReal: fightTimer 15)
			)
			(4
				(gGame handsOff:)
				(fakeKing setScript: 0)
				(kingFight dispose:)
				((ScriptID 7001 1) hide_mouth: 1) ; maliciaTalker
				(malicia
					init:
					view: 2248
					setLoop: 0
					setCel: 0
					posn: 208 127
					setPri: 190
					setCycle: End self
				)
				(gKqSound1 number: 816 setLoop: 1 play:)
				(gKqMusic1 number: 941 play:)
			)
			(5
				(gMessager say: 0 0 12 0 self 4550) ; "(NASTY, GLEEFUL)Nice try, sweetie."
			)
			(6
				((ScriptID 7001 1) hide_mouth: 0) ; maliciaTalker
				(malicia posn: 209 128 setLoop: 1 setCel: 0 setCycle: End self)
				(gKqSound1 number: 845 setLoop: 1 play:)
			)
			(7
				(gEgo
					setScale: 0
					posn: 212 128
					view: 2203
					setLoop: 2
					setCel: 0
					setPri: 190
					setCycle: CT 5 1 self
				)
				(malicia hide:)
			)
			(8
				(gKqSound1 stop:)
				(= cycles 1)
			)
			(9
				(EgoDead 43 self)
			)
			(10
				(malicia dispose:)
				(= ticks 10)
			)
			(11
				(gEgo
					posn: 78 103
					normalize: 4 2241
					setScaler: Scaler 90 90 145 101
				)
				(self changeState: 0)
			)
		)
	)
)

(instance transForm of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load 140 872) ; WAVE
				(gEgo view: 2202 setLoop: 2 setCel: 0 setCycle: CT 2 1 self)
			)
			(1
				(gEgo put: 53 setCycle: End self) ; Magic_Wand
				(soundFX number: 872 setLoop: 1 play:)
			)
			(2
				((ScriptID 7001 4) client: fakeKing view: 2205) ; edgerTalker
				(gEgo get: 53 1 setCycle: Beg) ; Magic_Wand
				(king setCycle: End self)
				(fakeKing
					posn: 130 111
					view: 2205
					setLoop: 0
					setCel: 0
					setPri: -1
					setScaler: Scaler 90 90 145 101
					setCycle: CT 26 1 self
				)
				(gKqSound1 number: 2253 setLoop: 1 play: self)
				(SetFlag 251)
			)
			(3
				(gKqMusic1 stop: number: 2254 setLoop: 1 play: setVol: 127)
			)
			(4
				(Load rsVIEW 2207)
				(gEgo normalize: 4 2241)
				(king
					posn: 104 142
					view: 2205
					cycleSpeed: 14
					setLoop: 1
					setCel: 0
					setCycle: End
				)
				((ScriptID 7001 0) hide_mouth: 1) ; kingTalker
			)
			(5
				(gEgo view: 2247 setLoop: 0 setCel: 0 setCycle: End self)
			)
			(6
				(gMessager say: 2 69 6 1 self 2200) ; "(TOTALLY ASTONISHED)...Edgar...?"
			)
			(7
				(gEgo setCycle: Beg self)
			)
			(8
				(gEgo normalize: 4 2241)
				(gMessager sayRange: 2 69 6 2 3 self 2200) ; "(TOTALLY ASTONISHED)You? The son of Oberon and Titania? What are you doing here?"
			)
			(9
				((ScriptID 7001 0) hide_mouth: 0) ; kingTalker
				(malicia
					init:
					view: 2203
					setLoop: 0
					setCel: 0
					posn: 208 127
					setPri: 190
					setCycle: End self
				)
				(gKqSound1 number: 816 setLoop: 1 play:)
				(gKqMusic1 number: 941 setLoop: -1 play:)
				(fakeKing setCel: 27)
				(gEgo view: 2247 setLoop: 0 setCel: 0 setCycle: End)
				(Load 140 838) ; WAVE
				(Load 140 2062) ; WAVE
			)
			(10
				(gEgo setCycle: Beg)
				(malicia view: 2207 setLoop: 0 setCel: 7 setCycle: Beg self)
				(king
					posn: 90 126
					view: 2206
					setLoop: 0
					setCel: 0
					cycleSpeed: 6
					setCycle: End self
				)
			)
			(11
				(malicia
					view: 2203
					posn: 227 129
					setLoop: 1
					setCel: 0
					setCycle: End
				)
			)
			(12
				(gEgo normalize: 4 2241)
				(gKqSound1 number: 845 setLoop: 1 play:)
				(king posn: 107 125 setLoop: 1 setCel: 0 setCycle: End self)
			)
			(13
				(malicia setCycle: CT 2 -1)
				(king posn: 141 124 setLoop: 2 setCel: 0 setCycle: CT 3 1 self)
			)
			(14
				(king setCycle: CT 10 1 self)
				(gKqSound1 number: 838 setLoop: 1 play:)
			)
			(15
				(king setCycle: End self)
				(gKqSound1 number: 2062 setLoop: 1 play:)
			)
			(16
				(malicia view: 2207 setLoop: 0 setCel: 7 setCycle: Beg self)
			)
			(17
				(gEgo
					setScale: 0
					posn: 43 124
					view: 2208
					setLoop: 0
					setCel: 0
					setCycle: End self
				)
				(king hide:)
			)
			(18
				(gKqSound1 number: 2001 setLoop: -1 play: setVol: 80)
				(malicia setCycle: End self)
			)
			(19
				(king show:)
				(gEgo posn: 95 99 setLoop: 4 setCel: 0 setCycle: End self)
				(malicia posn: 232 127 setLoop: 2 setCel: 0 setCycle: Fwd)
				(fakeKing
					posn: 135 106
					view: 2207
					setLoop: 3
					setCel: 0
					setScale: 0
					setCycle: End self
				)
			)
			(20
				(gEgo setLoop: 5 setCel: 0 setCycle: End)
			)
			(21
				(gKqSound1 fade:)
				(malicia setCycle: Beg self)
				(fakeKing dispose:)
				(SetFlag 250)
			)
			(22
				(malicia
					posn: 240 127
					view: 2208
					setLoop: 3
					setCel: 4
					setCycle: Beg self
				)
			)
			(23
				(gMessager say: 2 69 6 4 self 2200) ; "(FAKE SWEET)My dear princess! I have something so special in store for you. I hope you enjoy hot weather!"
			)
			(24
				(soundFX number: 2252 setLoop: 1 play: self)
			)
			(25
				(malicia
					posn: 240 127
					view: 2208
					setLoop: 3
					setCel: 0
					setCycle: End self
				)
			)
			(26
				(soundFX number: 845 setLoop: 1 play:)
				(king show:)
				(gEgo posn: 96 88 setLoop: 2 setCel: 0 setCycle: End self)
			)
			(27
				(gEgo posn: 1000 0)
				(malicia setCycle: Beg self)
				(gKqSound1 number: 2255 setLoop: 1 play: self)
			)
			(28 0)
			(29
				(gCurRoom newRoom: 2155)
			)
		)
	)
)

(instance kingFight of Script
	(properties)

	(method (dispose)
		(gKqSound1 setLoop: 1 stop:)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gKqSound1
					number: (if (Random 0 1) 2251 else 22510)
					setLoop: -1
					play:
				)
				(king hide:)
				(fakeKing
					posn: 146 128
					view: 2202
					setLoop: 0
					setCel: 0
					cycleSpeed: 14
					setCycle: CT 25 1 self
				)
			)
			(1
				(fakeKing setCycle: CT 39 1 self)
				(king
					show:
					posn: 146 129
					view: 2202
					setLoop: 1
					setCel: 0
					cycleSpeed: 14
					setCycle: End self
				)
			)
			(2
				(fakeKing setCel: 40)
				(king hide:)
				(= ticks 30)
			)
			(3
				(fakeKing setPri: -1 setCycle: End self)
			)
			(4
				(self changeState: 0)
			)
		)
	)
)

(instance shootKingTrollSide of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo view: 2202 setLoop: 2 setCel: 0 setCycle: End self)
				(soundFX number: 872 setLoop: 1 play:)
			)
			(1
				(gMessager say: 1 69 5 0 self 2200) ; "(VOICE GETS SMALLER AS HE TRANSFORMS INTO A SCARAB)Rosella, noooooooo!"
				(king
					view: 2204
					setLoop: 1
					setCel: 0
					cycleSpeed: 20
					setCycle: End self
				)
			)
			(2 0)
			(3
				(gEgo setCycle: Beg)
				((ScriptID 7001 1) hide_mouth: 1) ; maliciaTalker
				(malicia
					init:
					view: 2248
					setLoop: 0
					setCel: 0
					setPri: 190
					posn: 208 127
					setCycle: End self
				)
				(gKqSound1 number: 816 setLoop: 1 play:)
				(gKqMusic1 number: 941 play:)
			)
			(4
				(malicia posn: 209 128 setLoop: 1 setCel: 0 setCycle: End self)
				(gKqSound1 number: 845 setLoop: 1 play:)
				((ScriptID 7001 1) hide_mouth: 0) ; maliciaTalker
			)
			(5
				(gEgo
					setScale: 0
					posn: 212 128
					view: 2203
					setLoop: 2
					setCel: 0
					setPri: 129
					setCycle: CT 5 1 self
				)
				(malicia hide:)
			)
			(6
				(gKqSound1 stop:)
				(= cycles 1)
			)
			(7
				(EgoDead 71 self)
			)
			(8
				(malicia dispose:)
				(= ticks 10)
			)
			(9
				(gEgo
					posn: 78 103
					get: 62 ; Device
					setScaler: Scaler 90 90 145 101
					normalize: 4 2241
				)
				(king view: 2202 setLoop: 1 cycleSpeed: 14)
				(gCurRoom setScript: 0)
				(gCurRoom setScript: chap6Open)
				(fakeKing setScript: 0)
			)
		)
	)
)

(instance shootBlanks of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					setScale: 0
					view: 2202
					setLoop: 2
					setCel: 0
					cycleSpeed: 13
					setCycle: CT 3 1 self
				)
			)
			(1
				(gEgo setCycle: End self)
				(soundFX number: 872 setLoop: 1 play:)
			)
			(2
				(gEgo setCycle: Beg self)
			)
			(3
				(gEgo normalize: 4 2241 setScaler: Scaler 90 90 145 101)
				(= cycles 2)
			)
			(4
				(gMessager say: 3 8 3 0 self 2100) ; "Rats."
			)
			(5
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance king of Actor
	(properties
		x 146
		y 129
		view 2202
		loop 1
		cel 11
		signal 4129
	)

	(method (doVerb theVerb)
		(switch theVerb
			(69 ; Magic_Wand
				(if (not (IsFlag 283))
					(fightTimer client: 0 delete: dispose:)
					(kingFight dispose:)
					(fakeKing setPri: -1 setCycle: CT 39 1)
					(gEgo setScript: shootKingTrollSide)
				else
					(gEgo setScript: shootBlanks)
				)
			)
		)
	)
)

(instance fakeKing of Prop
	(properties
		x 146
		y 128
		view 2202
		cel 35
	)

	(method (doVerb theVerb)
		(switch theVerb
			(69 ; Magic_Wand
				(if (not (IsFlag 283))
					(gEgo setScript: shootBlanks)
				else
					(fightTimer client: 0 delete: dispose:)
					(kingFight dispose:)
					(gCurRoom setScript: transForm)
				)
			)
		)
	)
)

(instance malicia of Prop
	(properties
		x 208
		y 127
		view 2203
	)
)

(instance gauge of Prop
	(properties
		x 148
		y 72
		priority 97
		fixPriority 1
		view 2239
		loop 2
		cycleSpeed 22
	)
)

(instance myEastExit of ExitFeature ; UNUSED
	(properties
		nsLeft 310
		nsRight 320
		nsBottom 136
		sightAngle 360
		approachX 318
		approachY 103
		exitDir 2
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 8 10 approachVerbs: 8 10) ; Do, Exit, Do, Exit
	)

	(method (doVerb)
		(gCurRoom newRoom: 2350)
	)
)

(instance fightTimer of Timer
	(properties)

	(method (cue)
		(if (or (not (OneOf (kingFight state:) 1 2)) (gEgo script:))
			(self setReal: self 5)
		else
			(chap6Open cue:)
			(self client: 0 delete: dispose:)
		)
	)

	(method (doit)
		(if (gUser input:)
			(super doit: &rest)
		)
	)
)

(instance soundFX of Sound
	(properties)
)

