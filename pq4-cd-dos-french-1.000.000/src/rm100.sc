;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 100)
(include sci.sh)
(use Main)
(use Talker)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm100 0
	scribbleScript 1
	coronerTalker 2
	crimTalker 3
	underTapeScript 4
	toObjectScript 5
	jackTalker 6
	spiffTalker 7
	careyTalker 8
	coronerTalker 9
	grafWall 10
	dumpster 11
	dumpsterLid 12
	cop1Talker 13
	cop2Talker 14
)

(local
	local0
	local1
	[local2 2]
	local4
)

(instance rm100 of Room
	(properties
		picture 100
	)

	(method (doRemap)
		(gGame doRemap: 2 253 90)
		(gGame doRemap: 2 254 75)
	)

	(method (init)
		(if (== gDay 1)
			(PalVary 8 100) ; PalVaryNewSource
		)
		(gTheIconBar enable:)
		(proc0_4 (if (== gDay 2) 0 else 1))
		(cond
			((== gDay 1)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PContainedAccess
							init: 224 145 224 132 240 120 243 114 243 104 247 94 239 93 224 95 188 106 164 113 139 121 128 125 89 132 78 145 98 145
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 174 115 223 120 223 126 218 127 198 127 136 129 155 119
							yourself:
						)
				)
			)
			((> gDay 1)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PContainedAccess
							init: 0 148 1 153 278 156 246 145 223 118 224 105 230 97 244 88 239 88 224 95 188 106 136 126 85 135 47 143 23 143 1 143
							yourself:
						)
				)
			)
		)
		(if (and (== gDay 1) (OneOf gPrevRoomNum 23 3 6 17 3)) ; titleScreen, speedRoom, MapRoom, titleScreen
			(gGame handsOn:)
			(gTheIconBar enable:)
			(gEgo get: 10 11 13 18 32 33 36 43 16) ; wallet
		)
		(self
			style:
				(switch gPrevRoomNum
					(17 9) ; MapRoom
					(3 9) ; titleScreen
					(else 0)
				)
		)
		(super init: &rest)
		(switch gPrevRoomNum
			(17 ; MapRoom
				(if (== gDay 1)
					(gEgo setHeading: 315 posn: 195 131 normalize: 0)
				else
					(gEgo setHeading: 44 x: 95 y: 150 normalize: 0)
				)
			)
			(6 ; speedRoom
				(gEgo
					setHeading: (if (== gDay 1) 269 else 44)
					x: (if (== gDay 1) 188 else 95)
					y: (if (== gDay 1) 131 else 150)
					normalize: 0
				)
			)
			(150
				(gEgo setHeading: 180 posn: 244 88 normalize: 0)
				(self setScript: northEnterScript)
			)
			(180
				(gEgo setHeading: 270 posn: 250 155 normalize: 0)
				(if (and (== gDay 2) (== global142 1))
					(= global142 2)
					(exSpiff
						setCycle: Walk
						setScript: spiffOutScript
						setLoop: 0
						init:
						signal: (| (exSpiff signal:) $0800)
					)
				)
				(self setScript: eastEnterScript)
			)
			(110
				(gEgo setHeading: 90 posn: -30 145 normalize: 0)
				(self setScript: westEnterScript)
			)
			(else
				(gEgo setHeading: 269 posn: 195 131 normalize: 0)
			)
		)
		(if (== gDay 1)
			(gEgo setScaler: Scaler 81 17 140 89)
		else
			(gEgo setScaler: Scaler 90 17 151 89)
		)
		(gEgo
			setTalker: careyTalker
			setScript: (if (== gDay 1) egoScript else 0)
		)
		(gEgo init:)
		(if
			(or
				(not (gGlobalSound0 handle:))
				(!= (gGlobalSound0 number:) 110)
				(< (gGlobalSound0 vol:) 127)
				(and (== gDay 2) (OneOf gPrevRoomNum 17 6)) ; MapRoom, speedRoom
			)
			(gGlobalSound1 number: 0 stop:)
			(gGlobalSound0 number: 110 loop: -1 play: setVol: 127)
		)
		(switch gDay
			(1
				(dumpster
					view: 13
					posn: 116 81
					heading: 89
					approachX: 162
					approachY: 116
					approachDist: 30
					init:
				)
				(dumpsterLid init: signal: (| (dumpsterLid signal:) $5000))
				((ScriptID 101 0) doit:) ; initCode
			)
			(else
				(gEgo get: 16) ; badge
				(dumpster
					view: 14
					x: 229
					y: 115
					z: 26
					heading: 269
					approachX: 215
					approachY: 115
					approachDist: 30
					init:
					setPri: 113
				)
				(if (< gDay 5)
					(outline init: ignoreActors: 1)
				)
				(if (and (!= gPrevRoomNum 110) (!= gPrevRoomNum 150) (!= gPrevRoomNum 180))
					(gGame handsOn:)
				)
			)
		)
		(if (< gDay 3)
			(car init:)
			(carWindow init:)
		)
		(if (== gDay 2)
			(rightTape init: signal: (| (dumpsterLid signal:) $5000))
			(leftTape init: signal: (| (dumpsterLid signal:) $5000))
		)
		(redFence init:)
		(rightTrash init:)
		(storeSign init:)
		(grafWall init:)
		(tire init:)
		(leftTrash init:)
		(storeFront init:)
		(otherBldgs init:)
		(pole init:)
		(tree init:)
		(billboard init:)
		(sky init:)
	)

	(method (doit)
		(super doit:)
		(cond
			((self script:) 0)
			(
				(and
					(== gDay 1)
					(!= ((ScriptID 101 8) view:) 1011) ; cop1
					(gEgo inRect: 200 140 296 160)
				)
				(gEgo x: 199 setMotion: 0)
				(gMessager say: 0 0 34 0) ; "There's work to be done, Carey. Get to it!"
			)
			(
				(and
					(== gDay 1)
					(== ((ScriptID 101 8) view:) 1011) ; cop1
					(gEgo inRect: 219 140 296 160)
				)
				(gEgo x: 216 setMotion: 0)
				(gMessager say: 0 0 34 0) ; "There's work to be done, Carey. Get to it!"
			)
			((and (== gDay 1) (gEgo inRect: 2 120 65 160))
				(gEgo x: 66 setMotion: 0)
				(gMessager say: 0 0 34 0) ; "There's work to be done, Carey. Get to it!"
			)
			(
				(and
					(== gDay 1)
					(== local0 0)
					(gEgo inRect: 0 135 320 143)
				)
				(= local0 (if (< (gEgo y:) 138) 1 else 2))
				(self setScript: underTapeScript)
			)
			((== gDay 1) 0)
			((< (gEgo y:) 91)
				(gCurRoom newRoom: 150)
			)
			((< (gEgo x:) 15)
				(gCurRoom newRoom: 110)
			)
			((gEgo inRect: 214 141 245 170)
				(gCurRoom setScript: eastExitScript)
			)
		)
	)

	(method (dispose)
		(if (== gDay 1)
			(= script 0)
			(gSounds eachElementDo: #clean 101)
			(DisposeScript 101)
		)
		(PalVary 3) ; PalVaryKill
		(super dispose:)
	)

	(method (newRoom newRoomNumber)
		(if (OneOf newRoomNumber 500 17 540) ; MapRoom
			(gEgo get: 16) ; badge
		)
		(super newRoom: newRoomNumber)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (== gDay 1)
					(gMessager say: 0 4 16 0) ; "The ground is devoid of tracks or marks."
				else
					(gMessager say: 0 4 17 0) ; "The alley is paved with gravel and dirt."
				)
			)
			(1 ; Look
				(if (== gDay 1)
					(gMessager say: 0 1 16 0) ; "The back alley to the Lucky Mini Mart... It doesn't look so lucky now."
				else
					(gMessager say: 0 1 17 0) ; "The alley echos with violence and desolation."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance egoScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0)
		)
	)

	(method (handleEvent event)
		(if
			(and
				(& (event type:) evVERB)
				(& (event type:) evMOVE)
				(> (gEgo y:) 138)
				(< (event y:) 138)
				(not (gCurRoom script:))
			)
			(event claimed: 1)
			(gCurRoom setScript: underTapeScript)
		else
			(event claimed: 0)
			(super handleEvent: event)
		)
		(event claimed:)
	)
)

(instance westEnterScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 30 145 self)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance northEnterScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if
					(or
						(< (gGlobalSound0 vol:) 127)
						(not (gGlobalSound0 handle:))
						(!= (gGlobalSound0 number:) 110)
					)
					(gGlobalSound1 number: 0 stop:)
					(gGlobalSound0 number: 110 loop: -1 play: setVol: 127)
				)
				(gEgo setMotion: MoveTo 231 95 self)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance eastEnterScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if
					(or
						(< (gGlobalSound0 vol:) 127)
						(not (gGlobalSound0 handle:))
						(!= (gGlobalSound0 number:) 110)
					)
					(gGlobalSound1 number: 0 stop:)
					(gGlobalSound0 number: 110 loop: -1 play: setVol: 127)
				)
				(gEgo setMotion: MoveTo 196 149 self)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance exSpiff of Actor
	(properties
		x 53
		y 151
		view 1017
	)
)

(instance spiffOutScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(exSpiff setMotion: MoveTo -20 151 self)
			)
			(1
				(exSpiff dispose:)
			)
		)
	)
)

(instance eastExitScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 224 155 self)
			)
			(1
				(gEgo setMotion: MoveTo 340 155 self)
			)
			(2
				(gGlobalSound0 number: 0 stop:)
				(= cycles 2)
			)
			(3
				(gCurRoom newRoom: 180)
			)
		)
	)
)

(instance careyTalker of Narrator
	(properties
		x 90
		y 10
		modeless 2
	)
)

(instance spiffTalker of Narrator
	(properties
		x 140
		y 10
		modeless 2
	)
)

(instance jackTalker of Narrator
	(properties
		x 140
		y 10
		modeless 2
	)
)

(instance crimTalker of Narrator
	(properties
		x 5
		y 10
		modeless 2
	)
)

(instance cop1Talker of Narrator
	(properties
		x 140
		y 10
		modeless 2
	)
)

(instance cop2Talker of Narrator
	(properties
		x 5
		y 10
		modeless 2
	)
)

(instance coronerTalker of Narrator
	(properties
		x 5
		y 10
		modeless 2
	)
)

(instance dumpster of View
	(properties
		noun 26
		sightAngle 45
		priority 1
		fixPriority 1
		signal 20480
	)

	(method (doVerb theVerb)
		(if (== gDay 1)
			(switch theVerb
				(4 ; Do
					(if (not (dumpsterLid cel:))
						(gCurRoom setScript: toObjectScript 0 2)
					else
						(gMessager say: 27 4 37 0) ; "Disturbing evidence now can result in a mistrial later. Let SID or the Coroner's assistant handle all evidence."
					)
				)
				(1 ; Look
					(if (not (dumpsterLid cel:))
						(super doVerb: theVerb)
					else
						(gCurRoom setScript: toObjectScript 0 2)
					)
				)
				(52 ; notebook
					(if (dumpsterLid cel:)
						(if (gPqPointFlags test: 7)
							(gMessager say: 0 52 32 0) ; "This information is already recorded."
						else
							(gCurRoom setScript: scribbleScript 0 2)
						)
					else
						(gMessager say: noun 52 28 0) ; "What is it you wish to record?"
					)
				)
				(13 ; caseBaggies
					(if (dumpsterLid cel:)
						(gMessager say: 26 13 38 0) ; "That baggie will do nothing for the removal of the boy's body."
					else
						(super doVerb: theVerb)
					)
				)
				(38 ; caseChalk
					(if (gPqFlags test: 8)
						(gMessager say: 26 38 38 0) ; "Chalking the dumpster is unnecessary, Carey."
					else
						(gMessager say: 26 38 28 0) ; "What is the purpose of that, Detective?"
					)
				)
				(73 ; crimeSceneReport
					(if (dumpsterLid cel:)
						(gMessager say: 26 73 38 0) ; "Don't throw that Crime Scene log away! You'll need it later."
					else
						(super doVerb: theVerb)
					)
				)
				(37 ; ???
					(if (dumpsterLid cel:)
						(super doVerb: theVerb)
					else
						(gMessager say: 26 37 28 0) ; "The lid is heavy, but possible to lift without prying it open."
					)
				)
				(65 ; caseGlassJar
					(if (dumpsterLid cel:)
						(gMessager say: 26 65 38 0) ; "Any fluids to be taken from the boy will be extracted at the morgue."
					else
						(super doVerb: theVerb)
					)
				)
				(64 ; caseGloves
					(if (dumpsterLid cel:)
						(gMessager say: 26 64 38 0) ; "Leave the removal of the boy's body to the Coroner's office."
					else
						(super doVerb: theVerb)
					)
				)
				(47 ; handcuffs
					(if (dumpsterLid cel:)
						(gMessager say: 26 47 38 0) ; "Your gesture has no meaning, Detective."
					else
						(super doVerb: theVerb)
					)
				)
				(63 ; casePryBar
					(if (dumpsterLid cel:)
						(gMessager say: noun theVerb 38 0) ; "The dumpster is open, Detective. It doesn't need prying."
					else
						(gMessager say: noun theVerb 28 0) ; "The dumpster isn't locked. Try opening it the conventional way."
					)
				)
				(2 ; Talk
					(if (dumpsterLid cel:)
						(gMessager say: 26 2 38 0) ; "Who would riddle a young boy's body with bullets and throw it into a dumpster? What kind of world are we living in?"
					else
						(gMessager say: 26 2 28 0) ; "Talking to the dumpster reeks of stress-related emotions."
					)
				)
				(else
					(super doVerb: theVerb)
				)
			)
		else
			(switch theVerb
				(4 ; Do
					(gMessager say: 26 4 23 0) ; "The dumpster now sports a lock. It can't be opened."
				)
				(else
					(super doVerb: theVerb &rest)
				)
			)
		)
	)
)

(instance dumpsterLid of Prop
	(properties
		noun 26
		x 116
		y 99
		view 99
	)

	(method (doVerb)
		(dumpster doVerb: &rest)
	)
)

(instance toObjectScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (> (gEgo y:) 138)
					(self setScript: underTapeScript self)
				else
					(= cycles 2)
				)
			)
			(1
				(switch register
					(0
						(gEgo
							setMotion:
								PolyPath
								((ScriptID 101 5) approachX:) ; body
								((ScriptID 101 5) approachY:) ; body
								self
						)
					)
					(1
						(gEgo
							setMotion:
								PolyPath
								(grafWall approachX:)
								(grafWall approachY:)
								self
						)
					)
					(2
						(gEgo
							setMotion:
								PolyPath
								(dumpster approachX:)
								(dumpster approachY:)
								self
						)
					)
				)
			)
			(2
				(switch register
					(0
						(gEgo setHeading: 315 self)
					)
					(1
						(= cycles 2)
					)
					(2
						(Face gEgo dumpster self)
					)
				)
			)
			(3
				(= cycles 2)
			)
			(4
				(if (and (== register 2) (not (dumpsterLid cel:)))
					((ScriptID 101 6) number: 996 loop: 1 play:) ; rmSFX
					(= global143 1)
					(dumpsterLid setCycle: End self)
				else
					(= cycles 2)
				)
			)
			(5
				(switch register
					(0
						(gCurRoom setInset: (ScriptID 101 4) self) ; bodyInset
					)
					(1
						(= cycles 2)
					)
					(2
						(gCurRoom setInset: (ScriptID 101 2) self) ; washInset
					)
				)
			)
			(6
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance redFence of Feature
	(properties
		noun 11
		sightAngle 45
		x 290
		y 112
	)

	(method (init)
		(self createPoly: 268 78 292 69 319 69 319 152 290 152 267 114 269 78)
		(super init:)
	)
)

(instance rightTrash of Feature
	(properties
		noun 12
		sightAngle 90
		approachX 146
		approachY 141
		approachDist 25
		x 216
		y 141
	)

	(method (init)
		(self createPoly: 199 135 230 135 230 149 201 149 200 136)
		(super init:)
	)
)

(instance storeSign of Feature
	(properties
		noun 13
		sightAngle 45
		x 53
		y 33
	)

	(method (init)
		(self createPoly: 26 10 42 10 76 21 76 55 26 46)
		(super init:)
	)
)

(instance grafWall of Feature
	(properties
		noun 14
		sightAngle 45
		approachX 101
		approachY 130
		x 73
		y 115
	)

	(method (init)
		(self
			createPoly: 13 47 27 47 114 62 113 111 104 106 99 110 97 115 12 132
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(38 ; caseChalk
				(if (== gDay 1)
					(gMessager say: 14 38 35 0) ; "Avoid adding to the neighborhood graffiti."
				else
					(super doVerb: theVerb)
				)
			)
			(52 ; notebook
				(if (not (gPqPointFlags test: 0))
					(gGame points: 3 0)
					(gPqPointFlags set: 0)
					(gCurRoom setScript: scribbleScript 0 1)
				else
					(gMessager say: 0 52 32 0) ; "This information is already recorded."
				)
			)
			(4 ; Do
				(if (not local1)
					(gCurRoom setScript: touchPaintScript)
				else
					(gMessager say: 0 27 32 0) ; "Identifying yourself again is unnecessary."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance touchPaintScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (and (== gDay 1) (> (gEgo y:) 138))
					(self setScript: underTapeScript self)
				else
					(= cycles 2)
				)
			)
			(1
				(= cycles 2)
			)
			(2
				(gEgo
					setMotion:
						PolyPath
						(grafWall approachX:)
						(grafWall approachY:)
						self
				)
			)
			(3
				(gEgo setHeading: 314 self)
			)
			(4
				(= ticks 30)
			)
			(5
				(gEgo view: 9910 loop: 0 cel: 0 setCycle: CT 3 1 self)
			)
			(6
				(= ticks 90)
			)
			(7
				(gMessager say: 14 4 (if (== gDay 1) 35 else 17) 0 self)
			)
			(8
				(gEgo setCycle: Beg self)
			)
			(9
				(gEgo normalize: 0)
				(gEgo setHeading: 314)
				(= cycles 2)
			)
			(10
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance tire of Feature
	(properties
		noun 15
		sightAngle 45
		approachX 143
		approachY 121
		approachDist 25
		x 114
		y 119
	)

	(method (init)
		(self createPoly: 102 111 108 108 116 118 105 120)
		(super init:)
	)
)

(instance leftTrash of Feature
	(properties
		noun 16
		sightAngle 45
		approachX 75
		approachY 139
		approachDist 25
		x 53
		y 129
	)

	(method (init)
		(self createPoly: 19 137 28 131 76 128 74 135 22 143)
		(super init:)
	)
)

(instance storeFront of Feature
	(properties
		noun 17
		sightAngle 45
		x 7
		y 104
	)

	(method (init)
		(self createPoly: 0 46 12 47 11 142 0 142)
		(super init:)
	)
)

(instance otherBldgs of Feature
	(properties
		noun 18
		sightAngle 45
		x 179
		y 74
	)

	(method (init)
		(self
			createPoly: 78 25 114 46 153 45 235 63 235 89 115 110 116 61 78 55
		)
		(super init:)
	)
)

(instance pole of Feature
	(properties
		noun 19
		sightAngle 45
		x 262
		y 112
	)

	(method (init)
		(self createPoly: 258 11 266 11 268 152 263 152 262 150 262 115 256 114)
		(super init:)
	)
)

(instance tree of Feature
	(properties
		noun 20
		sightAngle 45
		x 301
		y 43
	)

	(method (init)
		(self createPoly: 268 17 284 21 305 10 319 10 319 67 291 68 270 74)
		(super init:)
	)
)

(instance car of View
	(properties
		noun 30
		y 130
		priority 199
		fixPriority 1
		view 16
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gMessager say: 30 4 15 0) ; "Your car trunk is locked."
			)
			(46 ; keys
				(gCurRoom setScript: toTrunkScript)
			)
			(1 ; Look
				(if (and (>= local4 1) (<= (Random 1 100) 25))
					(gMessager say: 30 1 2 0) ; "It's your car, Carey, a 1993 T-bird."
				else
					(gMessager say: 30 1 0 0) ; "It's your car, Carey, a 1993 T-bird."
					(++ local4)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance sky of Feature
	(properties
		noun 44
		nsRight 319
		nsBottom 67
		sightAngle 360
		x 160
		y 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (== gDay 1)
					(gMessager say: 44 1 35) ; "The sun will soon be rising."
				else
					(gMessager say: 44 1 17) ; "Another smoggy day in Los Angeles."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance carWindow of Feature
	(properties
		noun 37
		nsTop 109
		nsRight 33
		nsBottom 132
		sightAngle 40
		x 16
		y 131
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 30 1 0 0) ; "It's your car, Carey, a 1993 T-bird."
			)
			(4 ; Do
				(cond
					((!= gDay 1)
						(gCurRoom setScript: leaveDay2Script)
					)
					((not (gPqPointFlags test: 24))
						(gMessager say: 30 4 0 0) ; "Finish what you start, Carey. It's not time to leave!"
					)
					((< (gEgo y:) 138)
						(gCurRoom setScript: toTrunkScript)
					)
					(else
						(gCurRoom newRoom: 17) ; MapRoom
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance billboard of Feature
	(properties
		noun 41
		nsLeft 243
		nsTop 63
		nsRight 255
		nsBottom 72
		sightAngle 40
		x 248
		y 68
	)
)

(instance leaveDay2Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 58 152 self)
			)
			(1
				(gCurRoom newRoom: 17) ; MapRoom
			)
		)
	)
)

(instance zipScript of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= ticks 10)
			)
			(1
				(= gDay 2)
				(gCurRoom newRoom: 500)
			)
		)
	)
)

(instance scribbleScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (> (gEgo y:) 138)
					(self setScript: underTapeScript self)
				else
					(= cycles 2)
				)
			)
			(1
				(switch register
					(0
						(gEgo
							setMotion:
								PolyPath
								((ScriptID 101 5) approachX:) ; body
								((ScriptID 101 5) approachY:) ; body
								self
						)
					)
					(1
						(gEgo
							setMotion:
								PolyPath
								(grafWall approachX:)
								(grafWall approachY:)
								self
						)
						(if (not global140)
							(= global140 1)
						)
					)
					(2
						(gEgo
							setMotion:
								PolyPath
								(dumpster approachX:)
								(dumpster approachY:)
								self
						)
						(if (not global152)
							(= global152 1)
						)
					)
				)
			)
			(2
				(if (or (== register 0) (== register 2))
					(gEgo setHeading: 315 self)
				else
					(= cycles 2)
				)
			)
			(3
				(gGame handsOff:)
				(gEgo
					setScaler: 0
					setScaler: Scaler 79 17 140 89
					view: 9017
					setLoop: 0
					setCel: 0
					setCycle: End self
				)
			)
			(4
				(switch register
					(0
						(gGame points: 3 1)
						(gPqPointFlags set: 1)
						(gMessager say: 25 52 0 0 self) ; "Noting physical evidence of the deceased is necessary but most unpleasant."
					)
					(1
						(gMessager say: 14 52 0 0 self) ; "Graffiti is often left behind by gangs. Recording the symbol could prove useful."
					)
					(2
						(gGame points: 2 7)
						(gPqPointFlags set: 7)
						(gMessager say: 27 52 0 0 self) ; "Recording information at the crime scene ensures accurate reports later."
					)
				)
			)
			(5
				(gEgo view: 9017 setLoop: 0 setCel: 13 setCycle: Beg self)
			)
			(6
				(gEgo
					normalize: 0
					setScaler: 0
					setScaler: Scaler 81 17 140 89
					setHeading: 315
				)
				(gGame handsOn:)
				(gUser canControl: 1 canInput: 1)
				(self dispose:)
			)
		)
	)
)

(instance toTrunkScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local0 1)
				(if (and (< (gEgo y:) 138) (== gDay 1))
					(self setScript: underTapeScript self)
				else
					(= cycles 2)
				)
			)
			(1
				(gEgo setMotion: PolyPath 90 152 self)
			)
			(2
				(gEgo normalize: 0)
				(= cycles 2)
			)
			(3
				(gGame handsOn:)
				(gGame points: 2 107)
				(gCurRoom setInset: (ScriptID 28) self) ; trunkInset
			)
			(4
				(gGame handsOff:)
				(if (== gDay 1)
					(PalVary 8 100) ; PalVaryNewSource
				)
				(= cycles 2)
			)
			(5
				(gEgo setHeading: 45 self)
			)
			(6
				(= local0 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance underTapeScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (not local0)
					(if (< (gEgo y:) 138)
						(= local0 1)
					else
						(= local0 2)
					)
				)
				(= cycles 2)
			)
			(1
				(if (== local0 1)
					(gEgo
						setMotion:
							PolyPath
							(cond
								((< (gEgo x:) 110) 110)
								((> (gEgo x:) 180) 180)
								(else
									(gEgo x:)
								)
							)
							135
							self
					)
				else
					(gEgo
						setMotion:
							PolyPath
							(cond
								((< (gEgo x:) 110) 110)
								((> (gEgo x:) 180) 180)
								(else
									(gEgo x:)
								)
							)
							148
							self
					)
				)
			)
			(2
				((gCurRoom obstacles:) dispose:)
				(gCurRoom obstacles: 0)
				(gEgo
					setScaler: 0
					view: (if (== local0 1) 9101 else 9100)
					setLoop: 0
					cel: 0
					x:
						(if (== local0 1)
							(- (gEgo x:) 30)
						else
							(+ (gEgo x:) 2)
						)
					y: 152
					setPri: (if (== local0 1) 138 else 140)
					setCycle: CT 5 1 self
				)
			)
			(3
				(gEgo
					setPri: (if (== local0 1) -1 else 138)
					setCycle: End self
				)
			)
			(4
				(if (== local0 1)
					(gEgo
						scaleSignal: 1
						scaleX: 116
						scaleY: 116
						x: (+ (gEgo x:) 16)
						y: 147
						normalize: 0 2
					)
					(gEgo setMotion: MoveTo (gEgo x:) 151 self)
					(= cycles 2)
				else
					(gEgo heading: 0)
					(gEgo
						setScaler: Scaler 81 17 140 89
						x: (+ (gEgo x:) 37)
						y: 137
						normalize: 0 3
					)
					(gEgo setMotion: MoveTo (gEgo x:) 132 self)
				)
			)
			(5
				(if (== local0 1)
					(if (== ((ScriptID 101 8) view:) 1011) ; cop1
						(gCurRoom
							addObstacle:
								((Polygon new:)
									type: PContainedAccess
									init: 25 152 217 152 218 145 217 131 96 130 89 140
									yourself:
								)
								((Polygon new:)
									type: PBarredAccess
									init: 171 116 223 120 223 126 218 127 198 127 142 127 155 119
									yourself:
								)
						)
					else
						(gCurRoom
							addObstacle:
								((Polygon new:)
									type: PContainedAccess
									init: 25 152 189 152 192 146 185 130 96 130 89 140
									yourself:
								)
								((Polygon new:)
									type: PBarredAccess
									init: 171 116 223 120 223 126 218 127 198 127 142 127 155 119
									yourself:
								)
						)
					)
				else
					(gCurRoom
						addObstacle:
							((Polygon new:)
								type: PContainedAccess
								init: 224 145 224 132 240 120 243 114 243 104 247 94 239 93 224 95 188 106 164 113 139 121 128 125 89 132 78 145 98 145
								yourself:
							)
							((Polygon new:)
								type: PBarredAccess
								init: 174 115 223 120 223 126 218 127 198 127 136 129 155 119
								yourself:
							)
					)
				)
				(= cycles 2)
			)
			(6
				(= local0 0)
				(if (== client gCurRoom)
					(gGame handsOn:)
				)
				(self dispose:)
			)
		)
	)
)

(instance outline of View
	(properties
		noun 40
		x 183
		y 130
		priority 1
		fixPriority 1
		view 98
	)
)

(instance leftTape of View
	(properties
		noun 45
		x 81
		y 131
		view 9
	)
)

(instance rightTape of View
	(properties
		noun 45
		x 225
		y 133
		view 9
		cel 1
	)
)

