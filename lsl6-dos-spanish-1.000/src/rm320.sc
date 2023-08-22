;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 320)
(include sci.sh)
(use Main)
(use n079)
(use LarryRoom)
(use Print)
(use PolyPath)
(use Polygon)
(use Feature)
(use Rev)
(use Timer)
(use Grooper)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm320 0
)

(local
	local0 = 900
	local1
	local2
	local3
	[local4 9] = [-1 41 63 83 188 246 46 302 241]
	[local13 9] = [-1 122 88 88 99 111 134 134 108]
	local22 = 5
)

(procedure (localproc_0)
	(rose
		view: 322
		ignoreActors: 0
		setLoop: roseGrooper
		setLoop: -1
		setCycle: Walk
		setStep: 4 2
		cycleSpeed: 6
		moveSpeed: 6
	)
)

(class cObj of Obj
	(properties)
)

(instance rm320 of LarryRoom
	(properties
		noun 11
		picture 320
		style 15
		horizon 0
		autoLoad 0
	)

	(method (init &tmp temp0)
		(gGlobalSound1 stop:)
		(if (!= gPrevRoomNum 390)
			(gGlobalSound2 number: 320 loop: -1 play:)
		)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 31 122 17 134 132 134 143 139 189 139 196 135 302 134 288 116 273 121 241 108 217 117 190 117 183 108 188 99 179 105 144 105 135 90 113 104 101 88 63 88 63 92 95 92 106 102 99 114 85 122
					yourself:
				)
		)
		(tank init: stopUpd:)
		(motor init: stopUpd:)
		(motorClock init: stopUpd:)
		(bag init: stopUpd:)
		(vacuum init: stopUpd:)
		(motorRope init: stopUpd:)
		(grease init: stopUpd: approachVerbs: 4 2 5 6 39) ; Do, Talk, Take, Zipper, lamp
		(hose init: stopUpd:)
		(fan init: stopUpd: approachVerbs: 4 2 5 6) ; Do, Talk, Take, Zipper
		(cond
			((and (== gPrevRoomNum 390) (IsFlag 67))
				(rose init:)
				(gEgo
					init:
					normalize: local0 1
					ignoreActors: 0
					x: 183
					y: 120
				)
				(self setScript: getEnemaScr)
			)
			((== gPrevRoomNum 390)
				(rose init: setScript: roseScr ignoreActors: 0)
				(gEgo
					init:
					normalize: local0 1
					ignoreActors: 0
					x: 183
					y: 120
				)
				(gGame handsOn:)
			)
			(else
				(= temp0 (Random 1 8))
				(rose
					init:
					x: [local4 temp0]
					y: [local13 temp0]
					setScript: roseScr
					ignoreActors: 0
				)
				(gEgo
					init:
					normalize: local0 3
					ignoreActors: 0
					x: 183
					y: 200
				)
				(self setScript: enterRoomScr)
			)
		)
		(stirrups init:)
		(fBedPan init:)
		(leftGrip init:)
		(rightGrip init:)
		(flowers1 init:)
		(flowers2 init:)
		(flowers3 init:)
		(rightPipe init:)
		(leftPipe init:)
		(painting init:)
		(smallGauge1 init:)
		(smallGauge2 init:)
		(theWindow init:)
		(super init: &rest)
		(gNarrator x: 20 y: 20)
	)

	(method (doit)
		(cond
			(script)
			((== (gEgo edgeHit:) EDGE_BOTTOM)
				(self setScript: exitRoomScr)
			)
		)
		(super doit: &rest)
	)

	(method (newRoom newRoomNumber)
		(stenchTimer dispose: delete:)
		(if (!= newRoomNumber 390)
			(gGlobalSound1 number: 0 stop:)
			(gGlobalSound2 number: 0 stop:)
		)
		(gNarrator x: -1 y: -1 modeless: 0)
		(ffTimer dispose: delete:)
		(ClearFlag 86)
		(super newRoom: newRoomNumber)
	)

	(method (cue &tmp [temp0 40] [temp40 40] temp80)
		(if gModelessDialog
			(gModelessDialog dispose:)
		)
		(Message msgGET 861 0 8 0 1 @temp0) ; "Do you really want to Fast Forward and miss all the disgusting parts?"
		(Message msgGET 861 0 8 0 2 @temp40) ; "I'm Feeling Nauseous!"
		(= temp80 gTheCursor)
		(gGame setCursor: gNormalCursor)
		(SetCursor 170 65)
		(if
			(= local3
				(Print
					font: gUserFont
					addTitle: @temp40
					addText: @temp0 0 0
					x: 30
					y: 20
					addButton: 1 1 8 0 1 115 35 861 ; "Yes"
					addButton: 0 2 8 0 1 0 35 861 ; "Oops"
					init:
				)
			)
			(Load rsSOUND 2)
			(self setScript: 0)
			(= global170 0)
			((ScriptID 0 8) disable:) ; icon5
			(gEgo put: 16) ; flowers
			(gEgo get: 28) ; orchid
			(gGame changeScore: 15 176)
			(ffTimer setReal: ffTimer 3)
		else
			(ffTimer setCycle: ffTimer 2)
		)
		(gGame setCursor: temp80)
	)
)

(instance sfx of Sound
	(properties
		flags 1
	)
)

(instance sfx2 of Sound
	(properties
		flags 1
		loop -1
	)
)

(instance motorSfx of Sound
	(properties
		flags 1
		loop -1
	)
)

(instance scream of Sound ; UNUSED
	(properties
		flags 1
		loop -1
	)
)

(instance rndScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client cycleSpeed: (Random 2 8) cel: 0 setCycle: End self)
			)
			(1
				(client cycleSpeed: (Random 2 8) setCycle: Beg self)
			)
			(2
				(switch (Random 1 4)
					(1
						(client cycleSpeed: (Random 2 8) setCycle: Rev)
						(= ticks (Random 120 240))
					)
					(2
						(client cycleSpeed: (Random 2 8) setCycle: Fwd)
						(= ticks (Random 120 240))
					)
					(else
						(self init:)
					)
				)
			)
			(3
				(self init:)
			)
		)
	)
)

(instance rose of Actor
	(properties
		x 154
		y 120
		heading 45
		noun 12
		sightAngle 10
		approachX 183
		approachY 120
		view 322
		loop 8
	)

	(method (cue)
		(super cue:)
		(= cel 0)
		(= loop 8)
		(talkToRoseScr cue:)
	)

	(method (init)
		(super init:)
		(localproc_0)
	)

	(method (doVerb theVerb)
		(switch theVerb
			((OneOf theVerb 1 4 2) ; Look, Do, Talk
				(gGame handsOff:)
				(rose
					setScript: 0
					ignoreActors: 1
					setLoop: -1
					setCycle: Walk
					setMotion: PolyPath 154 120 self
				)
				(gCurRoom setScript: talkToRoseScr)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance talkToRoseScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
			)
			(1
				(gEgo setMotion: PolyPath 183 120 self)
			)
			(2
				(gEgo setHeading: 270)
				(if (and (!= (rose loop:) 8) (!= (rose cel:) 0))
					(rose loop: 8 cel: 0)
				)
				(= ticks 60)
			)
			(3
				(if (not (IsFlag 89))
					(SetFlag 89)
					(gMessager say: 12 2 0 0 self) ; "Hello, Miss. My name is Larry, Larry Laffer."
				else
					(= cycles 2)
				)
				(gGlobalSound2 fade: 90 10 10 0)
			)
			(4
				(= ticks 60)
			)
			(5
				(gCurRoom newRoom: 390)
			)
		)
	)
)

(instance exitRoomScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gGlobalSound2 fade: 0 10 10 1)
				(gEgo setMotion: MoveTo (gEgo x:) 200 self)
			)
			(1
				(= ticks 90)
			)
			(2
				(gCurRoom newRoom: 310)
			)
		)
	)
)

(instance wirlpool of Actor
	(properties
		x 63
		y 93
		view 320
		loop 6
		cel 2
		priority 7
		signal 18448
	)
)

(instance tank of Prop
	(properties
		x 251
		y 44
		noun 14
		view 320
		loop 4
		signal 18448
		detailLevel 2
	)
)

(instance motor of Prop
	(properties
		x 278
		y 36
		noun 8
		sightAngle 10
		view 320
		cel 4
		signal 18448
		detailLevel 2
	)
)

(instance motorClock of Prop
	(properties
		x 264
		y 19
		noun 4
		sightAngle 10
		view 320
		loop 1
		cel 2
		signal 18448
		detailLevel 2
	)
)

(instance bag of Prop
	(properties
		x 216
		y 87
		noun 15
		sightAngle 10
		view 320
		loop 2
		cel 1
		signal 22544
		detailLevel 2
	)
)

(instance vacuum of Prop
	(properties
		x 209
		y 101
		noun 15
		sightAngle 10
		view 320
		loop 5
		priority 7
		signal 22544
		detailLevel 2
	)
)

(instance fan of Prop
	(properties
		x 150
		y 16
		noun 2
		sightAngle 10
		approachX 135
		approachY 91
		view 320
		loop 3
		cel 1
		signal 18448
		cycleSpeed 1
		detailLevel 2
	)

	(method (doVerb theVerb &tmp [temp0 40])
		(if (Message msgGET 320 2 theVerb 0 1 @temp0)
			(gMessager say: 2 theVerb)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance motorRope of View
	(properties
		x 292
		y 47
		view 320
		loop 9
		signal 18448
	)
)

(instance larryClothes of View
	(properties
		view 903
		loop 3
		signal 18448
	)
)

(instance grease of View
	(properties
		x 116
		y 40
		noun 7
		sightAngle 10
		approachX 101
		approachY 88
		view 320
		loop 8
		signal 18448
	)

	(method (doVerb theVerb)
		(switch theVerb
			(39 ; lamp
				(gCurRoom setScript: fillLampScr)
			)
			(2 ; Talk
				(if (not (-- local22))
					(SetFlag 99)
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance hose of View
	(properties
		x 106
		y 89
		noun 6
		sightAngle 10
		view 320
		loop 7
		signal 18448
	)
)

(instance stirrups of Feature
	(properties
		noun 13
		sightAngle 10
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 64 71 70 71 72 74 78 70 85 71 87 74 91 70 99 71 89 81 81 90 73 90 67 80
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance fBedPan of Feature
	(properties
		x 74
		y 102
		noun 1
		sightAngle 10
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 72 91 80 91 83 88 96 94 101 99 98 105 92 105 88 108 80 108 78 113 70 112 66 106 64 101 53 101 54 105 52 110 44 104 45 97 49 94 64 89 70 85
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance leftGrip of Feature
	(properties
		x 71
		y 60
		noun 5
		sightAngle 10
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:) type: PTotalAccess init: 64 50 78 50 78 70 67 69 yourself:)
		)
		(super init: &rest)
	)
)

(instance rightGrip of Feature
	(properties
		x 92
		y 60
		noun 5
		sightAngle 10
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:) type: PTotalAccess init: 86 48 99 49 97 71 85 69 yourself:)
		)
		(super init: &rest)
	)
)

(instance rightPipe of Feature
	(properties
		x 243
		y 83
		noun 10
		sightAngle 10
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 221 90 228 90 233 82 240 79 239 76 245 74 249 77 257 77 258 83 250 83 249 88 245 90 242 86 238 86 236 91 232 97 219 98 217 95
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance leftPipe of Feature
	(properties
		x 168
		y 35
		noun 10
		sightAngle 10
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 151 0 191 0 185 16 188 18 193 12 203 13 211 21 199 21 196 20 193 29 187 28 192 40 204 46 213 58 211 71 206 77 209 87 204 95 195 89 194 76 200 61 186 61 181 73 186 88 184 98 177 101 146 100 141 93 151 80 153 69 146 67 147 58 141 59 141 51 147 51 149 45 145 44 148 32 156 32
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance flowers1 of Feature
	(properties
		x 22
		y 81
		noun 3
		sightAngle 10
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 0 74 2 67 8 68 8 64 17 63 23 68 26 59 35 62 37 59 32 54 36 51 45 52 48 59 56 56 55 62 58 63 59 68 56 68 54 73 46 76 47 81 6 103 0 101
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance flowers2 of Feature
	(properties
		x 65
		y 145
		noun 3
		sightAngle 10
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 1 111 5 107 17 109 23 112 25 111 26 102 38 103 42 114 46 109 55 112 54 100 66 102 67 109 72 113 76 115 81 108 89 109 93 105 101 106 102 110 100 117 102 122 108 125 117 118 130 121 145 131 141 136 134 138 0 138
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance flowers3 of Feature
	(properties
		x 274
		y 145
		noun 3
		sightAngle 10
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 198 138 189 137 191 131 190 126 196 121 205 119 211 115 219 116 220 123 225 125 226 122 239 120 246 126 247 121 241 115 258 105 268 117 270 113 277 116 282 120 291 109 304 108 303 97 311 87 319 93 319 138
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance smallGauge2 of Feature
	(properties
		noun 4
		sightAngle 10
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 216 43 211 47 202 44 202 38 210 36
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance smallGauge1 of Feature
	(properties
		noun 4
		sightAngle 10
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 210 25 206 32 201 32 198 27 200 21 206 20
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance painting of Feature
	(properties
		x 80
		y 33
		noun 9
		sightAngle 10
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:) type: PTotalAccess init: 109 0 103 48 62 48 56 6 yourself:)
		)
		(super init: &rest)
	)
)

(instance theWindow of Feature
	(properties
		x 10
		y 53
		noun 16
		sightAngle 10
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:) type: PTotalAccess init: 0 21 30 16 38 59 0 68 yourself:)
		)
		(super init: &rest)
	)
)

(instance roseGrooper of Grooper
	(properties)

	(method (doit param1 param2 param3 param4)
		(if (OneOf (gEgo view:) 900 800)
			(super
				doit:
					param1
					param2
					(if (> argc 2) param3 else 0)
					(if (> argc 3) param4 else 0)
					&rest
			)
		else
			(super doit: param1 param2 (if (> argc 2) param3 else 0) 1)
		)
	)
)

(instance egoCue of cObj
	(properties)

	(method (cue)
		(gEgo view: 324 setLoop: 0 setCycle: 0 cel: 1)
	)
)

(instance musicCue of cObj
	(properties)

	(method (cue)
		(gGlobalSound1
			number: 337
			loop: -1
			play:
			mute: 1 4
			mute: 1 5
			mute: 1 6
			mute: 1 7
			mute: 1 8
			mute: 1 9
		)
		(getEnemaScr cue:)
	)
)

(instance ffTimer of Timer
	(properties)

	(method (cue)
		(if local3
			(ClearFlag 99)
			(ClearFlag 74)
			(gCurRoom newRoom: 310)
		else
			(= global170 gCurRoom)
			((ScriptID 0 8) enable:) ; icon5
		)
	)
)

(instance roseScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 10 20))
			)
			(1
				(switch (Random 1 8)
					(1
						(rose setMotion: PolyPath 41 122 self)
						(if (not (Random 0 1))
							(= register 7)
						else
							(= register 1)
						)
					)
					(2
						(rose setMotion: PolyPath 63 88 self)
						(= register 1)
					)
					(3
						(rose setMotion: PolyPath 83 88 self)
						(= register 3)
					)
					(4
						(rose setMotion: PolyPath 188 99 self)
						(switch (Random 1 3)
							(1
								(= register 3)
							)
							(2
								(= register 6)
							)
							(3
								(= register 7)
							)
						)
					)
					(5
						(rose setMotion: PolyPath 246 111 self)
						(= register 6)
					)
					(6
						(rose setMotion: PolyPath 135 90 self)
						(switch (Random 1 3)
							(1
								(= register 3)
							)
							(2
								(= register 6)
							)
							(3
								(= register 7)
							)
						)
					)
					(7
						(rose setMotion: PolyPath 46 134 self)
						(switch (Random 1 3)
							(1
								(= register 2)
							)
							(2
								(= register 4)
							)
							(3
								(= register 5)
							)
						)
					)
					(8
						(rose setMotion: PolyPath 302 134 self)
						(if (not (Random 0 1))
							(= register 0)
						else
							(= register 4)
						)
					)
				)
			)
			(2
				(rose loop: 8 cel: register)
				(self init:)
			)
		)
	)
)

(instance getEnemaScr of Script
	(properties)

	(method (doit &tmp [temp0 20])
		(super doit:)
		(if (and local1 (not (motorSfx handle:)))
			(motorSfx number: 325 loop: -1 play:)
		)
	)

	(method (changeState newState &tmp [temp0 40])
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= global170 gCurRoom)
				((ScriptID 0 8) enable:) ; icon5
				(= ticks 240)
			)
			(1
				(rose view: 329 setLoop: 1 cel: 0)
				(gEgo cycleSpeed: 6 moveSpeed: 6 view: 98)
				(= ticks 20)
			)
			(2
				(rose cel: 1)
				(= ticks 120)
			)
			(3
				(gMessager say: 12 0 1 1 self) ; "Here, Rosie, I'd like to give you a little something special. I can see how much you enjoy flowers."
			)
			(4
				(= ticks 60)
			)
			(5
				(rose setCycle: CT 4 1 self)
			)
			(6
				(gEgo put: 16) ; flowers
				(= ticks 120)
			)
			(7
				(gMessager say: 12 0 1 2 self) ; "Oh, thank you, Lawrence! They are most beautiful. I'll put them right over here."
			)
			(8
				(rose setCycle: End self)
			)
			(9
				(= ticks 30)
			)
			(10
				(gEgo normalize: 900 1)
				(localproc_0)
				(rose loop: 8 cel: 0)
				(= cycles 2)
			)
			(11
				(UnLoad 128 329)
				(gEgo setHeading: 180 egoCue)
				(rose setMotion: MoveTo (rose x:) 134 self)
			)
			(12
				(rose setHeading: 90 self)
			)
			(13
				(= cycles 2)
			)
			(14
				(rose setMotion: MoveTo (gEgo x:) 134 self)
			)
			(15
				(gEgo cel: 2)
				(rose setMotion: MoveTo 211 134 self)
			)
			(16
				(gEgo cel: 3)
				(rose setMotion: MoveTo 277 134 self)
			)
			(17
				(rose setMotion: MoveTo 277 156 self)
			)
			(18
				(gGlobalSound2 fade: 0 30 10 1 musicCue)
				(gEgo
					normalize: 900 2
					cycleSpeed: 6
					moveSpeed: 6
					loop: 8
					cel: 4
					heading: 125
				)
				(= ticks 90)
			)
			(19
				(gEgo view: 324 setLoop: 1 cel: 0)
				(UnLoad 128 900)
				(rose setMotion: MoveTo 281 134 self)
			)
			(20
				(UnLoad 128 324)
				(gEgo view: 900 setLoop: -1 loop: 8 cel: 0)
				(rose setMotion: MoveTo 285 113 self)
			)
			(21
				(gEgo cel: 6)
				(rose setHeading: 225 self)
			)
			(22
				(rose loop: 8 cel: 5)
				(= ticks 60)
			)
			(23
				(gMessager say: 12 0 1 3 self) ; "And in return, I'd like to give you a little something special, my nuevo amigo!"
			)
			(24)
			(25
				(UnLoad 132 320)
				(gMessager say: 12 0 1 4 self) ; "Hey, Larry! Finally, you're gonna get lucky! And with this hot Spanish senorita, too!"
			)
			(26
				(gMessager say: 12 0 1 5 self) ; "Please to examine closely the painting on the wall over there. I believe you will surely enjoy that which will follow."
			)
			(27
				(= ticks 60)
			)
			(28
				(gEgo setMotion: PolyPath 81 88 self)
			)
			(29
				(gEgo setMotion: MoveTo 78 89 self)
			)
			(30
				(gEgo setHeading: 360 self)
			)
			(31
				(gEgo view: 328 setLoop: 0 cel: 0 setCycle: 0)
				(UnLoad 128 900)
				(= cycles 2)
			)
			(32
				(gGlobalSound1 mute: 0 8)
				(= cycles 2)
			)
			(33
				(gMessager say: 12 0 1 7 8 self) ; "I will make you experience feelings you never knew before!"
			)
			(34
				(rose setHeading: 360 self)
			)
			(35
				(SetFlag 86)
				(= cycles 2)
				(= register 3)
			)
			(36
				(rose view: 323 setLoop: 0 cel: 0 setCycle: CT 1 1 self)
			)
			(37
				(motorRope hide:)
				(sfx number: 324 loop: 1 play:)
				(motorClock setCycle: End)
				(motor setCycle: End)
				(tank setCycle: End)
				(rose setCycle: End self)
			)
			(38
				(motorRope show:)
				(rose view: 322 loop: 8 cel: 3)
				(switch register
					(1
						(fan setCycle: Fwd)
						(wirlpool init: setScript: (rndScr new:))
						(motorClock setCycle: Fwd)
						(motor setCycle: Fwd)
						(tank cycleSpeed: 1 setCycle: Fwd)
						(motorSfx number: 325 loop: -1 play:)
						(= local1 1)
					)
				)
				(= ticks 90)
			)
			(39
				(if (-- register)
					(-= state 4)
				)
				(= cycles 2)
			)
			(40
				(rose setHeading: 270 self)
			)
			(41
				(= ticks 180)
			)
			(42
				(gGlobalSound1 mute: 0 4 mute: 0 9)
				(= cycles 2)
			)
			(43
				(gMessager say: 12 0 1 9 10 self) ; "You'll feel like a new man!"
			)
			(44
				(rose view: 322 setLoop: -1 setCycle: Walk setHeading: 225 self)
			)
			(45
				(= ticks 30)
			)
			(46
				(rose setMotion: MoveTo 280 119 self)
			)
			(47
				(rose setMotion: PolyPath 156 120 self)
			)
			(48
				(gMessager say: 12 0 1 6 self) ; "(Why am I looking at a painting? Why is she running that Harley with the carb too rich?)"
				(rose setMotion: PolyPath 106 89 self)
			)
			(49)
			(50
				(rose setMotion: MoveTo 106 89 self)
			)
			(51
				(rose setHeading: 45 self)
			)
			(52
				(= cycles 2)
			)
			(53
				(hose dispose:)
				(UnLoad 128 900)
				(UnLoad 128 322)
				(rose view: 321 setLoop: 1 cel: 0)
				(= cycles 2)
			)
			(54
				(gEgo cel: 1)
				(rose setCycle: End self)
			)
			(55
				(= register 4)
				(= ticks 30)
			)
			(56
				(rose view: 321 setLoop: 2 cel: 0)
				(= cycles 2)
			)
			(57
				(rose cel: 0 setCycle: CT 1 1 self)
			)
			(58
				(sfx number: 328 loop: 1 play:)
				(rose setCycle: End self)
			)
			(59
				(if (-- register)
					(-= state 3)
				)
				(= ticks 30)
			)
			(60
				(rose setLoop: 3 cel: 0 setCycle: CT 3 1 self)
			)
			(61
				(sfx number: 329 loop: 1 play:)
				(rose setCycle: End self)
			)
			(62
				(= ticks 30)
			)
			(63
				(rose setLoop: 4 cel: 0)
				(= register 6)
				(= cycles 2)
			)
			(64
				(rose cel: 0 setCycle: CT 1 1 self)
			)
			(65
				(sfx number: 328 loop: 1 play:)
				(rose setCycle: End self)
			)
			(66
				(if (-- register)
					(-= state 3)
				)
				(self cue:)
			)
			(67
				(= ticks 30)
			)
			(68
				(gGlobalSound1 mute: 0 7 mute: 0 6)
				(= cycles 2)
			)
			(69
				(gMessager say: 12 0 1 11 13 self) ; "Are you ready for a good time?"
			)
			(70
				(= ticks 120)
			)
			(71
				(rose setCycle: 0 setLoop: 5 cel: 0 setPri: 7)
				(= cycles 2)
			)
			(72
				(gEgo cel: 0)
				(rose setCycle: CT 10 1 self)
			)
			(73
				(rose setPri: 8 setCycle: End self)
			)
			(74
				(gGlobalSound1 mute: 0 5)
				(= cycles 2)
			)
			(75
				(gNarrator x: 110 y: 20 modeless: 1)
				(vacuum startUpd: cycleSpeed: 1 setCycle: Fwd)
				(bag startUpd: setCycle: Fwd)
				(SetFlag 74)
				(rose view: 325 setPri: 9 setLoop: 0 cel: 0)
				(gMessager say: 12 0 1 14 self) ; "Okay, honey. Drop those pants!"
			)
			(76
				(UnLoad 128 323)
				(gEgo view: 903 setLoop: 0 cel: 0 setCycle: End self)
			)
			(77
				(sfx number: 234 loop: 1 play:)
				(gEgo setLoop: 1 cel: 0 setCycle: End self)
			)
			(78
				(larryClothes
					init:
					x: (+ (gEgo x:) 26)
					y: (gEgo y:)
					addToPic:
				)
				(UnLoad 128 903)
				(gEgo view: 321 setLoop: 0 cel: 0 setCycle: CT 5 1 self)
			)
			(79
				(gEgo setPri: 8 setCycle: End self)
				(sfx number: 814 loop: 1 play:)
			)
			(80
				(= ticks 90)
			)
			(81
				(gMessager say: 12 0 1 15 16 self) ; "Finally, Larry!"
			)
			(82
				(gEgo view: 326 setLoop: 0 cel: 0 setCycle: CT 3 1 self)
			)
			(83
				(gEgo setCycle: CT 9 1 self)
			)
			(84
				(gGlobalSound1 number: 338 loop: 1 play:)
				(= cycles 2)
			)
			(85
				(gEgo setCycle: End self)
			)
			(86
				(gMessager say: 12 0 1 17 self) ; "Whoa! What's that?! Rose, uh, exactly what does "High Colonic" mean?"
			)
			(87
				(gEgo cel: 2 setCycle: Beg self)
			)
			(88
				(Load rsSOUND 326)
				(= ticks 30)
			)
			(89
				(sfx number: 326 loop: 1 play: self)
				(rose cycleSpeed: 10 setCycle: End self)
			)
			(90)
			(91
				(sfx number: 385 loop: 1 play:)
				(Message msgGET 320 12 0 1 18 @temp0) ; "AAAAAEEEEEAAAAA!!!"
				(Print
					font: gUserFont
					addTitle:
						(switch (gGame printLang:)
							(34 {Tu})
							(49 {Du})
							(33 {Tu})
							(else {You})
						)
					modeless: 1
					width: 160
					mode: 1
					addText: @temp0
					x: 110
					y: 20
					init:
				)
				(= register 5)
				(= ticks 60)
			)
			(92
				(UnLoad 128 326)
				(gEgo
					view: 327
					setLoop: 0
					cycleSpeed: 6
					cel: 0
					setCycle: End self
				)
				(switch (++ local2)
					(1
						(sfx number: 327 loop: 1 play:)
					)
					(3
						(sfx number: 385 loop: 1 play:)
					)
					(5
						(sfx number: 327 loop: 1 play:)
					)
					(7
						(sfx number: 385 loop: 1 play:)
					)
				)
			)
			(93
				(= ticks 30)
			)
			(94
				(if (-- register)
					(-= state 3)
				)
				(self cue:)
			)
			(95
				(gEgo cycleSpeed: 8 setCycle: Fwd)
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(= ticks 30)
			)
			(96
				(sfx number: 327 loop: 1 play:)
				(tank setCycle: 0 stopUpd:)
				(motor setCycle: 0 stopUpd:)
				(motorClock setCycle: 0 stopUpd:)
				(bag setCycle: 0 stopUpd:)
				(vacuum setCycle: 0 stopUpd:)
				(= cycles 2)
			)
			(97
				((ScriptID 1805 21) modeless: 1) ; Rose
				(gMessager say: 12 0 1 19 self) ; "Isn't it wonderful? Am I right? Isn't it a feeling you've never felt before?"
			)
			(98
				(tank setCycle: Fwd)
				(motor setCycle: Fwd)
				(motorClock setCycle: Fwd)
				(bag setCycle: Fwd)
				(vacuum setCycle: Fwd)
				(sfx number: 385 loop: 1 play:)
				(= ticks 90)
			)
			(99
				(if (IsFlag 99)
					(sfx number: 631 loop: 1 play:)
				)
				(= ticks 30)
			)
			(100
				(sfx stop:)
				(if (IsFlag 99)
					(sfx2 number: 30 loop: -1 play:)
					(wirlpool
						view: 320
						setScript: 0
						setCycle: 0
						setLoop: 10
						cel: 0
					)
				)
				(= ticks 30)
			)
			(101
				(sfx2 stop:)
				(sfx number: 327 loop: 1 play:)
				(= ticks 90)
			)
			(102
				(= local1 0)
				((ScriptID 1805 21) modeless: 0) ; Rose
				(motorSfx fade:)
				(fan cel: 0 setCycle: 0)
				(wirlpool setScript: 0 setCycle: 0)
				(motorClock setScript: 0 cel: 0 setCycle: 0)
				(motor setScript: 0 cel: 0 setCycle: 0)
				(tank setScript: 0 cel: 0 setCycle: 0)
				(vacuum setScript: 0 setCycle: 0)
				(bag setScript: 0 setCycle: 0)
				(= global170 0)
				((ScriptID 0 8) disable:) ; icon5
				(= cycles 2)
			)
			(103
				(gCast eachElementDo: #hide)
				(SetPort 0)
				(SetPort 0 0 190 320 10 0)
				(DrawPic 98 6)
				(gNarrator x: -1 y: -1 modeless: 0)
				(= seconds 2)
			)
			(104
				(motorSfx number: 0 stop:)
				(= seconds 3)
			)
			(105
				(UnLoad 132 325)
				(gMessager say: 12 0 1 20 self) ; "A Few Hours Later..."
			)
			(106
				(= ticks 90)
			)
			(107
				(gGlobalSound1 number: 320 loop: -1 play:)
				(hose init:)
				(rose view: 329 setLoop: 0 cel: 0 x: 154 y: 120 setCycle: 0)
				(wirlpool view: 320 setLoop: 10 cel: 0)
				(gCast eachElementDo: #show)
				(gEgo view: 98 setCycle: 0)
				(DrawPic 320 7)
				(= cycles 1)
			)
			(108
				(gCurRoom showControls: 1)
				(gGame controlsVisible: 0 drawControls:)
				(ClearFlag 74)
				(= ticks 120)
			)
			(109
				(gMessager say: 12 0 1 21 25 self) ; "Rose, I've never felt more emotions in such a short period of time!"
			)
			(110
				(rose setCycle: End self)
			)
			(111
				(gEgo get: 28) ; orchid
				(gGame changeScore: 15 176)
				(gMessager say: 12 0 1 26 self) ; "Thank you, Larry. Come back soon, so we can do this again, okay?"
			)
			(112
				(rose view: 322 setLoop: 8 cel: 0 setCycle: 0)
				(gEgo x: 183 y: 120 normalize: 900 1)
				(= cycles 2)
			)
			(113
				(gEgo cycleSpeed: 6 moveSpeed: 6 setHeading: 180 self)
			)
			(114
				(rose cel: 4)
				(gEgo setMotion: MoveTo (gEgo x:) 150 self)
				(= cycles 2)
			)
			(115
				(rose cel: 2)
			)
			(116
				(gGlobalSound1 fade: 0 30 5 1)
				(gMessager say: 12 0 1 27 self) ; "You know, I don't feel pooped any more!"
				(gEgo setMotion: MoveTo (gEgo x:) 200 self)
			)
			(117)
			(118
				(ClearFlag 99)
				(gMessager say: 12 0 1 28 self) ; "Yeah, and also you're not so full of sheet!"
			)
			(119
				(= ticks 30)
			)
			(120
				(gCurRoom newRoom: 310)
			)
		)
	)
)

(instance fillLampScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (not (rose mover:))
					(rose setScript: 0)
					(= register 1)
				else
					(= register 0)
				)
				(gEgo setMotion: MoveTo 105 91 self)
			)
			(1
				(gEgo cycleSpeed: 8 moveSpeed: 8 setHeading: 45 self)
			)
			(2
				(= cycles 2)
			)
			(3
				(gEgo
					view: 338
					setLoop: 0
					cel: 0
					x: (+ (gEgo x:) 12)
					setCycle: End self
				)
				(= register 3)
			)
			(4
				(gEgo setLoop: 1 cel: 0 setCycle: End self)
			)
			(5
				(gMessager say: 7 39 0 0 self) ; "You carefully pump a few squirts of lubricant into your whale oil lamp."
			)
			(6
				((gInventory at: 23) ; lamp
					message: 17
					noun: 56
					setCursor: 39 0 0
					view: 39
				)
				(gInventory show:)
				(gEgo x: (- (gEgo x:) 12) normalize: 900 6)
				(= ticks 60)
			)
			(7
				(gEgo setHeading: 225 self)
			)
			(8
				(= cycles 2)
			)
			(9
				(gEgo
					setMotion:
						MoveTo
						(grease approachX:)
						(grease approachY:)
						self
				)
			)
			(10
				(gEgo normalize: 900 5)
				(if register
					(rose setScript: roseScr)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance stenchTimer of Timer
	(properties)

	(method (cue)
		(if (and (not (gCurRoom script:)) (not (gEgo script:)))
			(gMessager say: 0 0 2) ; "Jai! Carrrrrumba! I think you need me!"
			(ClearFlag 55)
		)
	)
)

(instance enterRoomScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= ticks 30)
			)
			(1
				(gEgo setMotion: MoveTo (gEgo x:) 120 self)
			)
			(2
				(gEgo normalize: 900 3 ignoreActors: 0)
				(if (IsFlag 55)
					(stenchTimer setReal: stenchTimer 4)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

