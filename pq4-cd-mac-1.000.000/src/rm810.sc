;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 810)
(include sci.sh)
(use Main)
(use n045)
(use Print)
(use Talker)
(use Scaler)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm810 0
	dannyTalker 1
)

(local
	local0
	local1
)

(instance rm810 of Room
	(properties
		picture 810
		east 820
		south 800
	)

	(method (init)
		(proc45_0)
		(super init: &rest)
		(if (not (gGlobalSound0 handle:))
			(gGlobalSound0 number: 801 loop: -1 play: setVol: 0 fade: 127 2 2 0)
		)
		(leftHouse init:)
		(housePlants init:)
		(centerHouse init:)
		(rightHouse init:)
		(palm init:)
		(leftPlants init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 89 162 160 162 253 129 311 115 290 112 226 124 189 125 126 121 89 112 63 103 35 103 39 116 63 121 102 123 127 129 130 139 116 146
					yourself:
				)
		)
		(gGame handsOn:)
		(door init: approachVerbs: 4) ; Do
		(int init:)
		(dannyD init:)
		(puzzle init: approachVerbs: 1) ; Look
		(if (gPqFlags test: 143)
			(car init:)
		else
			(= local1 1)
		)
		(switch gPrevRoomNum
			(800
				(if (gPqFlags test: 46)
					(gPqFlags clear: 46)
					(gEgo
						setHeading: 0
						x: 40
						y: 103
						setTalker: careyTalker
						setScaler: Scaler 90 65 161 103
						init:
					)
					(gCurRoom setScript: thruDoorScr)
				else
					(gEgo
						setHeading: 65
						posn: 138 151 0
						setTalker: careyTalker
						setScaler: Scaler 90 65 161 103
						normalize: 0
						init:
						setMotion: PolyPath 176 131
					)
				)
			)
			(820
				(gEgo
					setHeading: 225
					posn: 260 122 0
					setScaler: Scaler 90 65 161 103
					normalize: 0
					setTalker: careyTalker
					init:
					setMotion: PolyPath 235 126
				)
			)
		)
	)

	(method (doit)
		(super doit:)
		(cond
			((> (gEgo y:) 152)
				(self newRoom: south)
			)
			((> (gEgo x:) 264)
				(if (gPqFlags test: 0)
					(self newRoom: 820)
				else
					(gEgo x: 264 setMotion: 0)
					(barkSnd play:)
				)
			)
		)
	)
)

(instance car of View
	(properties
		noun 3
		x 317
		y 95
		view 812
	)
)

(instance dot of View
	(properties
		noun 7
		x 205
		y 147
		view 815
		loop 5
	)
)

(instance egoLegs of View
	(properties)
)

(instance leftHouse of Feature
	(properties
		noun 5
		nsLeft 35
		nsTop 91
		nsRight 48
		nsBottom 98
		sightAngle 40
		approachX 41
		approachY 94
		approachDist 0
		x 41
		y 94
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 0 119 0 119 112 95 111 62 100 62 40 28 40 28 93 41 98 41 101 35 102 35 107 41 110 41 115 35 115 35 120 41 123 41 138 8 140 4 136 0 136
					yourself:
				)
		)
	)
)

(instance housePlants of Feature
	(properties
		noun 8
		nsLeft 167
		nsTop 96
		nsRight 177
		nsBottom 101
		sightAngle 40
		approachX 172
		approachY 98
		approachDist 0
		x 172
		y 98
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 121 113 134 101 209 97 211 73 238 72 243 81 228 85 232 95 264 95 247 108 246 118 205 121
					yourself:
				)
		)
	)
)

(instance centerHouse of Feature
	(properties
		noun 5
		nsLeft 167
		nsTop 96
		nsRight 177
		nsBottom 101
		sightAngle 40
		approachX 172
		approachY 98
		approachDist 0
		x 172
		y 98
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 120 0 229 0 229 103 120 112
					yourself:
				)
		)
	)
)

(instance rightHouse of Feature
	(properties
		noun 5
		nsLeft 280
		nsTop 91
		nsRight 291
		nsBottom 101
		sightAngle 40
		approachX 285
		approachY 96
		approachDist 0
		x 285
		y 96
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 230 0 266 0 267 3 265 3 265 27 319 50 316 50 317 97 265 100 230 97
					yourself:
				)
		)
	)
)

(instance palm of Feature
	(properties
		noun 6
		nsLeft 83
		nsTop 129
		nsRight 92
		nsBottom 136
		sightAngle 40
		approachX 87
		approachY 132
		approachDist 0
		x 87
		y 132
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 69 136 73 107 77 0 92 0 95 95 104 133 92 139
					yourself:
				)
		)
	)
)

(instance leftPlants of Feature
	(properties
		noun 8
		nsLeft 40
		nsTop 138
		nsRight 47
		nsBottom 144
		sightAngle 40
		approachX 43
		approachY 141
		approachDist 0
		x 43
		y 141
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 19 137 51 127 64 139 58 150 29 149
					yourself:
				)
		)
	)
)

(instance puzzle of Feature
	(properties
		noun 4
		nsLeft 251
		nsTop 93
		nsRight 311
		nsBottom 135
		sightAngle 40
		approachX 239
		approachY 132
		approachDist 0
		x 251
		y 144
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 248 108 266 95 265 89 271 87 278 95 278 82 288 89 295 80 310 85 319 98 319 153 253 152 242 137 264 128 243 128 247 119
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(65 ; caseGlassJar
				(if (gEgo has: 20) ; shoe
					(super doVerb: theVerb)
				else
					(gMessager say: noun theVerb 8) ; "If you suspect hidden evidence, Detective, you'll need to look closer to confirm and collect."
				)
			)
			(52 ; notebook
				(if (gEgo has: 20) ; shoe
					(gGame points: 2 90)
					(super doVerb: theVerb)
				else
					(gMessager say: noun theVerb 8) ; "What about the flower bed deserves notation?"
				)
			)
			(1 ; Look
				(gCurRoom setInset: (ScriptID 20 0)) ; shoeInset
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance int of View
	(properties
		x 24
		y 36
		view 811
		loop 1
	)

	(method (init)
		(|= signal $4000)
		(super init: &rest)
	)

	(method (onMe)
		(return 0)
	)
)

(instance dannyD of Prop
	(properties
		x 45
		y 96
		priority 1
		view 810
	)

	(method (init)
		(|= signal $4000)
		(super init: &rest)
	)

	(method (onMe)
		(return 0)
	)
)

(instance dannyD2 of Feature
	(properties
		noun 2
		y 150
	)

	(method (init)
		(self
			onMeCheck:
				((Polygon new:)
					type: PContainedAccess
					init: 150 23 155 13 159 11 171 9 183 16 189 24 186 32 189 42 192 43 189 55 220 62 226 70 231 93 218 114 218 135 214 141 220 151 129 151 128 112 116 97 114 85 118 69 123 62 128 60 151 56
					yourself:
				)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(if (> (thruDoorScr state:) 9)
			(return)
		)
		(switch theVerb
			(27 ; badge
				(thruDoorScr seconds: 0 register: 1)
				(gGame points: 2 91)
				(dannyD2F setScript: showBadge)
			)
			(2 ; Talk
				(if (gPqFlags test: 2)
					(if (and (gPqFlags test: 139) (gPqFlags test: 92))
						(thruDoorScr seconds: 0 register: 0)
						(gMessager say: 2 2 2 0 thruDoorScr) ; "Hello. I'd like to see Money. Is he available?"
					else
						(thruDoorScr seconds: 0 register: 1)
						(if (gPqFlags test: 103)
							(gMessager say: 2 2 3 0 thruDoorScr) ; "I'd like to talk to Yo Money. Is he available?"
						else
							(gMessager say: 2 2 6 0 thruDoorScr) ; "Is Yo Money available? I need to speak with him."
						)
					)
				else
					(= local0 1)
					(dannyD2F setScript: talkFirst)
				)
			)
			(31 ; shoe
				(gGame points: 2 92)
				(super doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance dannyD2F of Prop
	(properties
		x 170
		y 58
		priority 3
		view 815
		loop 1
	)

	(method (init)
		(|= signal $5000)
		(super init:)
		(= actions dannyD2)
	)

	(method (dispose)
		(= actions 0)
		(super dispose:)
	)
)

(instance bigEgo of Prop
	(properties
		x 127
		y 161
		view 9815
	)

	(method (init)
		(|= signal $5000)
		(super init:)
		(= actions gEgo)
	)

	(method (dispose)
		(= actions 0)
		(super dispose:)
	)
)

(instance bigEgoHead of Prop
	(properties
		x 125
		y 59
		view 9815
		loop 1
	)

	(method (init)
		(|= signal $5000)
		(super init:)
		(= actions gEgo)
	)

	(method (dispose)
		(= actions 0)
		(super dispose:)
	)
)

(instance door of Prop
	(properties
		noun 1
		approachX 40
		approachY 103
		x 25
		y 36
		priority 97
		fixPriority 1
		view 811
	)

	(method (init)
		(|= signal $4000)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gGame handsOff:)
			(gCurRoom setScript: thruDoorScr)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance talkFirst of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager sayRange: 2 2 1 1 2 self) ; "Hello, I'm Detective Carey, Homicide, LAPD. I'd like to speak with Yo Money. Is he available?"
			)
			(1
				(= ticks 80)
			)
			(2
				(gMessager say: 2 2 1 3 self) ; "No? Then get the hell outta here, man, before I call the real cops."
			)
		)
	)
)

(instance showBadge of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(bigEgo setCycle: End self)
			)
			(1
				(bigEgo view: 9816 cel: 0 setCycle: End self)
			)
			(2
				(if (gPqFlags test: 2)
					(gMessager say: 2 27 6 0 self) ; "Ya shown me that pretty shiny badge before... What is it ya want?"
				else
					(gPqFlags set: 2)
					(if local0
						(gMessager say: 2 2 6 0 thruDoorScr) ; "Is Yo Money available? I need to speak with him."
					else
						(gMessager say: 2 27 0 0 self) ; "Hello, I'm Detective Carey, Homicide LAPD. I'm here to speak with Yo Money. Is he available?"
					)
				)
			)
			(3
				(bigEgo setCycle: Beg self)
			)
			(4
				(bigEgo view: 9815)
				(bigEgo cel: (bigEgo lastCel:) setCycle: Beg self)
			)
			(5
				(gGame handsOn:)
				(gTheIconBar disable: 0)
				(self dispose:)
			)
		)
	)
)

(instance thruDoorScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				0
				(gGame handsOff:)
				(egoLegs
					view: 9008
					setLoop: 1 1
					cel: 0
					scaleSignal: 1
					scaleX: (gEgo scaleX:)
					scaleY: (gEgo scaleY:)
					x: (gEgo x:)
					y: (gEgo y:)
					priority: (gEgo priority:)
					init:
				)
				(gEgo view: 9008 loop: 0 cel: 0)
				(self setScript: knock self)
			)
			(1
				1
				(gEgo setCycle: Beg self)
			)
			(2
				2
				(if local1
					(gMessager say: 7 4 9 0 self) ; "There's no response to your knocking."
				else
					(= ticks 80)
				)
			)
			(3
				3
				(if local1
					(gEgo normalize: 0)
					(egoLegs dispose:)
					(gGame handsOn:)
					(self dispose:)
				else
					(= register 0)
					(sfx number: 32 loop: 1 play:)
					(door setCycle: End self)
					(dannyD setCycle: End self)
				)
			)
			(4 4)
			(5
				5
				(dannyD loop: 1 cel: 0 setCycle: End self)
			)
			(6
				6
				(leftHouse dispose:)
				(housePlants dispose:)
				(centerHouse dispose:)
				(rightHouse dispose:)
				(palm dispose:)
				(leftPlants dispose:)
				(puzzle dispose:)
				(gCast eachElementDo: #dispose release:)
				(gCurRoom drawPic: 0 0 1)
				(FrameOut)
				(gCurRoom drawPic: 815 0 1)
				(gEgo setTalker: careyTalker)
				(dannyD2 init:)
				(dannyD2F init:)
				(bigEgo init:)
				(bigEgoHead init:)
				(doorInset init:)
				(dot init:)
				(proc0_4 1)
				(gGame handsOn:)
				(gTheIconBar disable: 0)
				(= cycles 3)
			)
			(7
				7
				(gMessager say: 2 2 5 0 self) ; "Yeah, what do ya want?"
			)
			(8
				8
				(= seconds 11)
			)
			(9
				9
				(cond
					((or (gTalkers size:) (Print dialog:))
						(-- state)
						(= seconds 2)
					)
					((or register seconds)
						(gGame handsOff:)
						(if (gPqFlags test: 0)
							(gCurRoom newRoom: 830)
						else
							(gCurRoom newRoom: 850)
						)
					)
					(else
						(gCast eachElementDo: #dispose release:)
						(gCurRoom drawPic: 0 0 1)
						(FrameOut)
						(doorInset dispose:)
						(dot dispose:)
						(gCurRoom drawPic: 810 0 1)
						(car init:)
						(leftHouse init:)
						(housePlants init:)
						(centerHouse init:)
						(rightHouse init:)
						(palm init:)
						(leftPlants init:)
						(puzzle init:)
						(door view: 811 loop: 0)
						(door
							cel: (door lastCel:)
							init:
							approachVerbs: 4 ; Do
							setCycle: CT 2 -1 self
						)
						(int view: 811 loop: 1 cel: 0 init:)
						(dannyD view: 810 loop: 0)
						(dannyD cel: (dannyD lastCel:) init: setCycle: Beg)
						(gEgo
							normalize: 0
							setScaler: Scaler 90 65 161 103
							init:
						)
						(proc0_4 0)
						(FrameOut)
					)
				)
			)
			(10
				(sfx number: 33 loop: 1 play:)
				(door setCycle: Beg self)
			)
			(11
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance doorInset of Feature
	(properties
		noun 7
		nsLeft 46
		nsTop 2
		nsRight 275
		nsBottom 151
		x 160
		y 40
	)
)

(instance barkSnd of Sound
	(properties
		number 995
	)
)

(instance careyTalker of Narrator
	(properties
		x 46
		y 100
	)
)

(instance dannyTalker of Narrator
	(properties
		x 80
		y 80
		modeless 2
	)

	(method (startAudio param1)
		(= audModNum (param1 at: 0))
		(= audNoun (param1 at: 1))
		(= audVerb (param1 at: 2))
		(= audCase (param1 at: 3))
		(= audSequence (param1 at: 4))
		(if (ResCheck 146 audModNum audNoun audVerb audCase audSequence) ; CHUNK
			(= ticks (DoAudio audPLAY audModNum audNoun audVerb audCase audSequence))
		)
		(if (== (gCurRoom picture:) 815)
			(dannyTalkerHead
				cel: 0
				init:
				setCycle: RandCycle (* (/ ticks 2) 2) 0 1
				cycleSpeed: 10
			)
		)
	)

	(method (dispose)
		(if (gCast contains: dannyTalkerHead)
			(dannyTalkerHead dispose:)
		)
		(super dispose: &rest)
	)
)

(instance dannyTalkerHead of Prop
	(properties
		x 170
		y 58
		view 815
	)
)

(instance knock of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				0
				(= register 5)
				(gEgo setCycle: CT 4 1 self)
			)
			(1
				(if (<= (++ register) 11)
					(gEgo cel: register)
					(if (OneOf register 5 7 9 11)
						(sfx number: 998 loop: 1 play:)
					)
					(-- state)
				)
				(= ticks 10)
			)
			(2
				(if (>= (-- register) 5)
					(gEgo cel: register)
					(if (OneOf register 10 8 6)
						(sfx number: 998 loop: 1 play:)
					)
					(-- state)
				)
				(= ticks 10)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance sfx of Sound
	(properties)
)

