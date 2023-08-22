;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 860)
(include sci.sh)
(use Main)
(use fileScr)
(use n082)
(use LarryRoom)
(use Array)
(use Print)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm860 0
)

(local
	local0
	local1 = 4
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9
	local10
	local11
	local12
	local13
	local14
	local15
)

(instance rm860 of LarryRoom
	(properties
		noun 6
		picture 860
		horizon 0
		autoLoad 0
	)

	(method (init)
		(if (== global100 860)
			(= local1 3)
			(= local7 3)
			(= gPrevRoomNum 590)
			(gEgo get: 8) ; condom
			(gEgo put: 17 590) ; gown
			(= global100 1)
		)
		(if (OneOf gPrevRoomNum 590 620)
			(= style 9)
		)
		(super init: &rest)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 253 145 319 111 319 105 295 115 262 108 243 108 243 100 226 100 226 90 252 90 252 79 225 65 107 65 0 65 0 145
					yourself:
				)
		)
		(cond
			((== gPrevRoomNum 230)
				(gEgo x: 343 y: 106 setHeading: 225)
				(gCurRoom setScript: enterFrom230Scr)
			)
			((OneOf gPrevRoomNum 590 620)
				(SetFlag 24)
				(SetFlag 110)
				(= local4 1)
				(gGlobalSound1 number: 861 loop: -1 play:)
				(gGlobalSound2 number: 0 stop:)
				(gCurRoom setScript: shabCartoonScr)
			)
			(else
				(gEgo x: 200 y: 200)
				(gCurRoom setScript: enterFrom810Scr)
			)
		)
		(if (and (IsFlag 24) (not (IsFlag 275)))
			(theChampagne init: approachVerbs: 4 2 5 6) ; Do, Talk, Take, Zipper
			(gCurRoom
				addObstacle:
					(= local9
						((Polygon new:)
							type: PBarredAccess
							init: 240 125 240 136 214 136 214 125
							yourself:
						)
					)
			)
		)
		(if (not local4)
			(path1 init:)
			(path2 init:)
			(path3 init:)
			(shore init:)
			(sky init:)
			(shallowWater init:)
			(deepWater init:)
			(jungle init:)
			(if (or (OneOf gPrevRoomNum 810 230) (not (gGlobalSound1 handle:)))
				(gGlobalSound1 number: 860 loop: -1 play:)
			)
			(gEgo init: normalize: 900 setScaler: Scaler 100 23 141 66)
			(bird init: hide: setScript: birdScr)
			(wave init: setScript: waveScr)
			(birdSfx number: 812 loop: -1 play:)
		)
		(Load rsVIEW 865)
	)

	(method (doVerb theVerb)
		(cond
			((or (gTalkers size:) (Print dialog:)))
			((and (OneOf theVerb 4 1 2 5 6) local4) ; Do, Look, Talk, Take, Zipper
				(gMessager say: 6 theVerb 2)
				(return 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (doit)
		(cond
			(script)
			(local4)
			(
				(and
					(== (gEgo view:) 900)
					(shallowWater onMe: (gEgo x:) (gEgo y:))
				)
				(gEgo view: 865)
			)
			(
				(and
					(== (gEgo view:) 865)
					(not (shallowWater onMe: (gEgo x:) (gEgo y:)))
				)
				(gEgo view: 900)
			)
			((deepWater onMe: (gEgo x:) (gEgo y:))
				(gCurRoom setScript: drownScr)
			)
			((== (gEgo edgeHit:) EDGE_RIGHT)
				(gCurRoom setScript: exitEastScr)
			)
			((> (gEgo y:) 143)
				(gCurRoom setScript: exitSouthScr)
			)
		)
		(super doit: &rest)
	)

	(method (cue)
		(if (gTalkers size:)
			(gMessager cue: 1)
		)
		(= local10 1)
		(= global215 (ByteArray new: 40))
		(= global214 (ByteArray new: 40))
		(Message msgGET 861 0 8 0 1 (global215 data:)) ; "Do you really want to Fast Forward and miss all the disgusting parts?"
		(Message msgGET 861 0 8 0 2 (global214 data:)) ; "I'm Feeling Nauseous!"
		(= global213 gTheCursor)
		(gGame setCursor: gNormalCursor)
		(SetCursor 170 65)
		(if
			(Print
				width: 150
				font: gUserFont
				addTitle: (global214 data:)
				addText: (global215 data:) 50 0
				addIcon: 1911 0 0 0 0
				addButton: 0 2 8 0 1 50 33 861 ; "Oops"
				addButton: 1 1 8 0 1 125 33 861 ; "Yes"
				init:
			)
			(gCurRoom setScript: 0)
			(gEgo put: 8 setScript: 0) ; condom
			(gGame handsOff: changeScore: 13 274 setCursor: gWaitCursor 1)
			(gCurRoom setScript: exitScr)
		else
			(Platform 0 2 1)
			(= local10 0)
			(= global170 gCurRoom)
			(gTheIconBar enableIcon: (ScriptID 0 8) show:) ; icon5
			(gGame setCursor: global213)
		)
		(global214 dispose:)
		(= global214 0)
		(global215 dispose:)
		(= global215 0)
	)

	(method (notify param1 &tmp temp0)
		(if argc
			(= temp0 param1)
		else
			(= temp0 0)
		)
		(if (or temp0 (and (not local15) (not script)))
			(gEgo put: 25) ; match
			((gInventory at: 25) ; match
				message: 42
				noun: 22
				owner: 510
				view: 40
				setCursor: 40 0 0
				yourself:
			)
			(gMessager say: 13 0 0 0 param1) ; "The forceful trade winds immediately extinguish your match."
		else
			(= local15 1)
		)
	)

	(method (dispose)
		(gKeyDownHandler delete: gCurRoom)
		(ClearFlag 110)
		(super dispose:)
	)
)

(instance enterFrom230Scr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 10)
			)
			(1
				(gEgo setMotion: MoveTo 280 122 self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance enterFrom810Scr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 10)
			)
			(1
				(gEgo setMotion: MoveTo 200 139 self)
			)
			(2
				(gEgo setMotion: PolyPath 200 135 self)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance exitSouthScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo (gEgo x:) 200 self)
			)
			(1
				(gGlobalSound1 fade:)
				(gCurRoom newRoom: 810)
			)
		)
	)
)

(instance exitEastScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 325 (gEgo y:) self)
			)
			(1
				(gGlobalSound1 fade:)
				(gCurRoom newRoom: 230)
			)
		)
	)
)

(instance oceanSfx of Sound ; UNUSED
	(properties
		flags 1
	)
)

(instance sfx of Sound
	(properties
		flags 1
	)
)

(instance fireFx of Sound ; UNUSED
	(properties
		flags 1
		loop -1
	)
)

(instance birdSfx of Sound
	(properties
		flags 1
	)
)

(instance hole of View
	(properties
		x 130
		y 99
		scaleX 69
		scaleY 69
		fixPriority 1
		view 860
		loop 2
		scaleSignal 1
	)
)

(instance jungle of Feature
	(properties
		noun 3
		approachX 211
		approachY 134
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 114 53 124 44 143 39 152 42 158 33 165 34 163 39 174 40 181 35 181 30 193 32 191 38 207 40 218 36 215 32 230 28 252 43 234 22 211 14 214 3 226 1 245 11 250 5 230 0 319 0 319 94 306 106 289 110 266 102 252 103 248 97 232 95 253 72 231 62 145 62 94 65 65 66 64 57 71 54
					yourself:
				)
		)
		(super init:)
	)
)

(instance path1 of Feature
	(properties
		noun 5
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 261 101 289 109 287 129 271 140 261 140
					yourself:
				)
		)
		(super init:)
	)
)

(instance path2 of Feature
	(properties
		noun 5
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 295 108 312 101 309 116 295 128
					yourself:
				)
		)
		(super init:)
	)
)

(instance path3 of Feature
	(properties
		noun 5
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 316 115 316 99 319 98 319 112
					yourself:
				)
		)
		(super init:)
	)
)

(instance shore of Feature
	(properties
		noun 8
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 140 110 139 104 53 105 38 98 64 89 207 87 216 84 130 81 202 77 186 71 198 68 92 66 116 63 226 64 248 70 247 77 227 98 246 98 250 103 262 103 262 139 0 139 0 129
					yourself:
				)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 4) ; Do
				(= local5 ((gUser curEvent:) x:))
				(= local6 ((gUser curEvent:) y:))
				(if (== ((gInventory at: 23) owner:) 0) ; lamp
					(gCurRoom setScript: getLamp)
				else
					(gCurRoom setScript: digScr)
				)
			)
			((OneOf theVerb 4 1) ; Do, Look
				(gMessager
					say:
						noun
						theVerb
						(if (== ((gInventory at: 23) owner:) 0) 8 else 7) ; lamp
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sky of Feature
	(properties
		noun 9
		approachX 211
		approachY 134
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 234 0 249 4 248 8 241 9 225 2 214 4 211 9 211 11 217 17 232 19 231 27 212 31 217 36 195 37 185 26 170 39 161 30 152 41 146 38 115 44 113 52 70 54 64 57 0 57 0 0
					yourself:
				)
		)
		(super init:)
	)
)

(instance deepWater of Feature
	(properties
		noun 10
		approachX 78
		approachY 92
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 0 59 63 59 63 68 0 87 yourself:)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(35 ; washcloth
				(gCurRoom setScript: wetCloth)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance shallowWater of Feature
	(properties
		noun 10
		approachX 78
		approachY 92
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 87 57 69 142 69 136 74 62 82 24 98 60 116 0 125
					yourself:
				)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(35 ; washcloth
				(gCurRoom setScript: wetCloth)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance bird of Actor
	(properties
		noun 11
		x -10
		y 11
		view 867
		loop 1
	)
)

(instance fire of Prop
	(properties
		noun 4
		x 136
		y 124
		view 863
		cel 3
		detailLevel 2
	)
)

(instance getLamp of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local12 (gEgo cycleSpeed:))
				(gEgo setMotion: PolyPath local5 local6 self)
			)
			(1
				(gEgo setHeading: 270 self)
			)
			(2
				(= cycles 2)
			)
			(3
				(gMessager say: 8 4 8 1 self) ; "(TO SELF) (Since nobody's watching, I could build a sand castle... right here.)"
			)
			(4
				(if (> gHowFast 3)
					(= temp0 8)
				else
					(= temp0 4)
				)
				(gEgo
					view: 864
					loop: 0
					cel: 0
					cycleSpeed: temp0
					setCycle: End self
				)
			)
			(5
				(gEgo setLoop: 1 1 cel: 0 setCycle: End self)
			)
			(6
				(= ticks 30)
				(hole
					init:
					x: (- (gEgo x:) 25)
					y: (gEgo y:)
					ignoreActors: 1
					setPri: (- (gEgo priority:) 1)
				)
			)
			(7
				(gMessager say: 8 4 8 2 self) ; "What's this?!"
			)
			(8
				(gMessager say: 8 4 8 3 self) ; "While your sand castle will win no prizes, your diggings have revealed an ancient whale oil lamp buried in the sand."
			)
			(9
				(gEgo setLoop: 2 1 cel: 0 get: 23) ; lamp
				(gGame changeScore: 14 276)
				(= ticks 60)
			)
			(10
				(gEgo setCycle: End self)
			)
			(11
				(= ticks 60)
			)
			(12
				(gEgo setLoop: 0 1 cel: 0)
				(= ticks 30)
			)
			(13
				(gEgo setCycle: End self)
			)
			(14
				(gMessager say: 8 4 8 4 self) ; "I'd better cover this up before anyone sees how dorky it looks!"
			)
			(15
				(hole dispose:)
				(gEgo setLoop: 1 1 cel: 15 setCycle: Beg self)
			)
			(16
				(gEgo setLoop: 0 1 cel: 3 setCycle: Beg self)
			)
			(17
				(gEgo cycleSpeed: local13 normalize: 900 1 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance theChampagne of View
	(properties
		noun 2
		sightAngle 10
		approachX 211
		approachY 134
		x 226
		y 127
		view 860
	)

	(method (doVerb theVerb)
		(cond
			((and (OneOf theVerb 5 1 4) (gCast contains: shablee)) ; Take, Look, Do
				(gMessager say: 2 0 1) ; "Shablee's here, in the moonlight, beside a warm campfire, sitting on her blanket, alone on the beach, in a romantic mood... and you're thinking about drinking?!"
			)
			((== theVerb 5) ; Take
				(gCurRoom setScript: takeChampagneScr)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance birdScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 10 20))
			)
			(1
				(= register (Random 8 40))
				(switch (Random 1 2)
					(1
						(bird
							show:
							setLoop: 1 1
							x: 0
							y: register
							setCycle: Fwd
							setMotion: MoveTo 275 register self
						)
					)
					(2
						(bird
							show:
							setLoop: 5 1
							x: 0
							y: register
							setCycle: Fwd
							setMotion: MoveTo 275 register self
						)
					)
					(3
						(bird
							show:
							setLoop: 2 1
							setCycle: Fwd
							x: 297
							y: register
							setMotion: MoveTo -10 register self
						)
					)
					(4
						(bird
							show:
							setLoop: 6 1
							setCycle: Fwd
							x: 297
							y: register
							setMotion: MoveTo -10 register self
						)
					)
				)
			)
			(2
				(bird hide:)
				(= seconds (Random 10 20))
			)
			(3
				(self init:)
			)
		)
	)
)

(instance waveScr of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= seconds 5)
			)
			(1
				(if (> gHowFast 3)
					(= temp0 15)
				else
					(= temp0 10)
				)
				(wave setCel: 0 cycleSpeed: temp0 setCycle: End self)
			)
			(2
				(= seconds 3)
			)
			(3
				(wave setCycle: Beg self)
			)
			(4
				(wave setCel: 0)
				(self changeState: 0)
			)
		)
	)
)

(instance wave of Prop
	(properties
		y 68
		view 867
	)
)

(instance digScr of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath local5 local6 self)
			)
			(1
				(gEgo setHeading: 270 self)
			)
			(2
				(= cycles 2)
			)
			(3
				(if (> gHowFast 3)
					(= temp0 8)
				else
					(= temp0 4)
				)
				(gEgo
					view: 864
					loop: 0
					cel: 0
					cycleSpeed: temp0
					setCycle: End self
				)
			)
			(4
				(gEgo setLoop: 1 1 cel: 0 setCycle: End self)
			)
			(5
				(gMessager say: 8 4 7 1 self) ; "You let the soft sand filter through your fingers."
			)
			(6
				(= ticks 60)
			)
			(7
				(gMessager say: 8 4 7 2 self) ; "OW! Yipes! Hot! Hot! Hot!"
			)
			(8
				(gEgo setCycle: Beg self)
			)
			(9
				(gEgo setLoop: 0 1 cel: 3 setCycle: Beg self)
			)
			(10
				(UnLoad 128 864)
				(gEgo cycleSpeed: local13 normalize: 900 1 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance takeChampagneScr of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local13 (gEgo cycleSpeed:))
				(if (!= (gEgo heading:) 90)
					(gEgo setHeading: 90 self)
				else
					(= cycles 2)
				)
			)
			(1
				(= cycles 2)
			)
			(2
				(if (> gHowFast 3)
					(= temp0 8)
				else
					(= temp0 4)
				)
				(gEgo
					view: 901
					setLoop: 4 1
					cel: 0
					cycleSpeed: temp0
					setCycle: CT 2 1 self
				)
			)
			(3
				(gMessager say: 2 5 0 0 self) ; "Like you always say, a little warm champagne never hurt anyone!"
			)
			(4
				(gGame changeScore: 6 275)
				(gEgo get: 7) ; champagne
				(theChampagne dispose:)
				((gCurRoom obstacles:) delete: local9)
				(local9 dispose:)
				(= cycles 2)
			)
			(5
				(gEgo setCycle: Beg self)
			)
			(6
				(gEgo cycleSpeed: local13 normalize: 900 0 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance wetCloth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 50 92 self)
			)
			(1
				(gEgo setHeading: 270 self)
			)
			(2
				(= cycles 2)
			)
			(3
				(gEgo view: 901 setLoop: 5 1 cel: 0 setCycle: CT 5 1 self)
			)
			(4
				(= ticks 60)
			)
			(5
				(gGame changeScore: 6 250)
				(= global185 1)
				((gInventory at: 39) cue:) ; washcloth
				(gMessager say: 2 35 0 0 self 85) ; "You wet the washcloth in the water."
			)
			(6
				(= ticks 60)
			)
			(7
				(gEgo setCycle: End self)
			)
			(8
				(gEgo normalize: 900 1 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance talkShabScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 2)
			)
			(1
				(if (OneOf local1 6 3)
					(self setScript: makeOutScr self)
				else
					(gMessager say: 7 2 local1 0 self)
				)
				(if local3
					(= local1
						(switch local1
							(4 5)
							(5 6)
							(6 3)
							(else local1)
						)
					)
					(= local3 (= local2 0))
				else
					(= local2 1)
				)
			)
			(2
				(gGame handsOn:)
				(gTheIconBar disableIcon: (ScriptID 0 3) show:) ; icon0
				(self dispose:)
			)
		)
	)
)

(instance larry of Feature
	(properties
		y 136
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 173 116 166 111 165 106 171 98 181 99 184 107 182 110 186 113 181 119 181 123 191 122 193 130 197 136 185 138 170 138 165 134
					yourself:
				)
		)
		(super init:)
	)

	(method (doVerb)
		(gMessager say: 6 5 2) ; "At this moment, there is only one thing here you are interested in--  Shablee!"
		(return 1)
	)
)

(instance shablee of Prop
	(properties
		noun 7
		x 183
		y 135
		view 862
		cel 1
	)

	(method (doit &tmp temp0)
		(= temp0 (gGlobalSound1 prevSignal:))
		(super doit:)
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 2) ; Talk
				(gCurRoom setScript: talkShabScr)
			)
			((OneOf theVerb 6 1 4 65) ; Zipper, Look, Do, condom
				(gCurRoom setScript: doVerbScr 0 theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance drownScr of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local13 (gEgo cycleSpeed:))
				(if (> gHowFast 3)
					(= temp0 12)
				else
					(= temp0 10)
				)
				(gEgo
					view: 864
					setLoop: 3 1
					cel: 0
					cycleSpeed: temp0
					setCycle: End self
				)
				(gGlobalSound1 fade:)
			)
			(1
				(gEgo view: 98)
				(= ticks 180)
			)
			(2
				(UnLoad 128 82)
				(UnLoad 128 900)
				(UnLoad 128 867)
				(UnLoad 128 860)
				(UnLoad 128 971)
				(UnLoad 128 864)
				(wave view: 98)
				(= cycles 1)
			)
			(3
				(EgoDead 12 self)
				(gEgo
					show:
					cycleSpeed: local12
					normalize: 900 4 1
					x: 68
					y: 99
				)
				(wave view: 867)
			)
			(4
				(gGlobalSound1 play:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance makeOutScr of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(++ local7)
				(if (== local1 3)
					(gMessager say: 7 2 local1 1 self) ; "Come here, you beautiful thing!"
				else
					(gMessager say: 7 2 local1 0 self)
				)
			)
			(1
				(if (> gHowFast 3)
					(= temp0 8)
				else
					(= temp0 6)
				)
				(if (== local7 1)
					(shablee setLoop: 2 1 cel: 0 cycleSpeed: temp0)
					(= ticks 30)
				else
					(+= state 2)
					(self cue:)
				)
			)
			(2
				(shablee cel: 1)
				(= ticks 90)
			)
			(3
				(sfx number: 1124 loop: 1 play:)
				(= ticks 20)
			)
			(4
				(if (== local7 1)
					(shablee cel: 0)
					(= ticks 20)
				else
					(shablee setLoop: 3 1 cel: 0 setCycle: End self)
					(++ state)
				)
			)
			(5
				(shablee setLoop: 1 1 cel: 1)
				(gGame handsOn:)
				(gTheIconBar disableIcon: (ScriptID 0 3) show:) ; icon0
				(self dispose:)
			)
			(6
				(if (and (> local7 1) (== local1 3))
					(if (> gHowFast 3)
						(= temp0 15)
					else
						(= temp0 10)
					)
					(shablee setLoop: 4 1 cycleSpeed: temp0 setCycle: Fwd)
					(= seconds 8)
				else
					(= ticks 30)
				)
			)
			(7
				(if (> gHowFast 3)
					(= temp0 8)
				else
					(= temp0 6)
				)
				(shablee
					setLoop: 3 1
					cel: 4
					cycleSpeed: temp0
					setCycle: CT 1 -1 self
				)
			)
			(8
				(sfx number: 1124 loop: 1 play:)
				(= ticks 10)
			)
			(9
				(shablee cel: 0)
				(= ticks 30)
			)
			(10
				(shablee setLoop: 1 1 cel: 1)
				(= ticks 60)
			)
			(11
				(if (and (> local7 1) (== local1 3))
					(gMessager sayRange: 7 2 local1 2 3 self)
				else
					(= cycles 2)
				)
			)
			(12
				(gGame handsOn:)
				(gTheIconBar disableIcon: (ScriptID 0 3) show:) ; icon0
				(self dispose:)
			)
		)
	)
)

(instance doVerbScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 2)
			)
			(1
				(switch register
					(6
						(cond
							((!= local1 3)
								(gMessager say: 7 6 local1 0 self)
							)
							((and (== local1 3) (> local7 2))
								(gMessager say: 7 6 3 0 self) ; "I'm ready, baby! I hope you brought a condom."
							)
							(else
								(gMessager say: 7 6 6 0 self) ; "Ah, Larry. Perhaps soon."
							)
						)
					)
					(1
						(gMessager say: 7 1 local1 0 self)
					)
					(4
						(= local3 1)
						(gMessager say: 7 4 local1 0 self)
						(if local2
							(= local1
								(switch local1
									(4 5)
									(5 6)
									(6 3)
									(else local1)
								)
							)
							(= local3 (= local2 0))
						else
							(= local3 1)
						)
					)
					(65
						(if (and (> local7 2) (== local1 3))
							(= next applyCondomScr)
							(self dispose:)
						else
							(gMessager say: 7 65 0 0 self) ; "Not yet, Larry! Once again, you're premature!"
						)
					)
				)
			)
			(2
				(gGame handsOn:)
				(gTheIconBar disableIcon: (ScriptID 0 3) show:) ; icon0
				(self dispose:)
			)
		)
	)
)

(instance applyCondomScr of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(proc79_11 326 327 871 870 869)
				(= cycles 2)
			)
			(1
				(gGame changeScore: 13 274)
				(= ticks 30)
			)
			(2
				(gMessager say: 7 65 3 1 self) ; "I was hoping you brought one of those!"
			)
			(3
				(gMessager say: 7 65 3 2 self) ; "Here. Let me have that."
			)
			(4
				(gEgo put: 8) ; condom
				(if (> gHowFast 3)
					(= temp0 8)
				else
					(= temp0 4)
				)
				(shablee
					setLoop: 5 1
					cycleSpeed: temp0
					setCel: 0
					setCycle: End self
				)
			)
			(5
				(shablee setLoop: 6 1 setCycle: Fwd)
				(= seconds 6)
			)
			(6
				(shablee setLoop: 7 1 cel: 0 setCycle: 0)
				(= ticks 30)
			)
			(7
				(gMessager say: 7 65 3 3 self) ; "I'm ready when you are!"
			)
			(8
				(gGlobalSound1 stop:)
				(if (< gHowFast 4)
					(wave dispose:)
				)
				(shablee setCycle: CT 3 1 self)
			)
			(9
				(sfx number: 869 loop: 1 play:)
				(shablee setCycle: End self)
			)
			(10
				(UpdateScreenItem ((ScriptID 92 3) view: 1903 loop: 0 cel: 0)) ; larryTBust
				(= ticks 180)
			)
			(11
				(shablee setLoop: 0 1 cel: 0)
				(if (> gHowFast 3)
					(= temp1 8)
				else
					(= temp1 4)
				)
				(gEgo
					show:
					view: 862
					x: (shablee x:)
					y: (shablee y:)
					setLoop: 8 1
					setCycle: Fwd
					moveSpeed: temp1
					cycleSpeed: temp1
					setStep: 1 1
					setMotion: MoveTo 155 (gEgo y:) self
				)
			)
			(12
				(gEgo setCycle: 0 cel: 0 setLoop: 9 1 setCycle: End self)
			)
			(13
				(wave setScript: 0)
				(gEgo setScript: spitScr self)
			)
			(14
				(= local14 1)
				(= ticks 30)
			)
			(15
				(gMessager say: 7 65 3 5 self) ; "No wonder Shablee knows what a man likes!"
			)
			(16
				(gEgo setScript: 0)
				(shablee view: 861 cel: 0 cycleSpeed: 10 setCycle: End self)
			)
			(17
				(= next exitScr)
				(self dispose:)
			)
		)
	)
)

(instance spitScr of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(if (> gHowFast 3)
					(= temp0 6)
				else
					(= temp0 4)
				)
				(gEgo setLoop: 10 1 cycleSpeed: temp0 cel: 0)
				(= ticks 30)
			)
			(1
				(gEgo cel: 0 setCycle: CT 1 1 self)
			)
			(2
				(if (not register)
					(= register 1)
					(gEgo setCycle: End)
					(gMessager say: 7 65 3 4) ; "(VARIOUS SPITTING SOUNDS) Phhhtuueeey!"
					(= ticks 300)
				else
					(if
						(and
							(not local14)
							(not (or (gTalkers size:) (Print dialog:)))
						)
						(UpdateScreenItem ((ScriptID 92 3) view: 1903)) ; larryTBust
						(sfx number: 871 loop: 1 play:)
					)
					(= ticks 120)
				)
			)
			(3
				(gEgo cel: 1 setCycle: End self)
			)
			(4
				(if
					(and
						(not local14)
						(not (or (gTalkers size:) (Print dialog:)))
					)
					(UpdateScreenItem
						((ScriptID 92 3) view: 1906 loop: 0 cel: 0) ; larryTBust
					)
					(sfx number: 870 loop: 1 play:)
				)
				(if (> (++ local0) 3)
					(self dispose:)
				else
					(= state 0)
					(= ticks 30)
				)
			)
		)
	)
)

(instance shabCartoonScr of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= local13 global167)
				(PalVary 8 862) ; PalVaryNewSource
				(shablee init: setLoop: 0 1 ignoreActors: 1)
				(theChampagne init:)
				(fire init: setCycle: Fwd setPri: 50)
				(wave init: setScript: waveScr)
				(if (> gHowFast 3)
					(= temp0 4)
				else
					(= temp0 6)
				)
				(gEgo
					normalize: 900 6
					init:
					setScale: 0
					x: 86
					y: 189
					setLoop: 6 1
					setCycle: Fwd
					setSpeed: temp0
				)
				(PalVary 0 862 0 64 1) ; PalVaryStart
				(proc79_8 10)
				(= seconds 3)
			)
			(1
				(gEgo
					setPri: (- (shablee priority:) 10)
					fixPriority: 1
					setMotion: MoveTo 138 135 self
				)
			)
			(2
				(gEgo normalize: 900 loop: 8 cel: 6 heading: 45)
				(= cycles 2)
			)
			(3
				(gEgo setHeading: 90 self)
			)
			(4
				(= cycles 2)
			)
			(5
				(gMessager say: 7 1 4 0 self) ; "Shablee looks beautiful here on the beach, in the moonlight, with those waves softly licking the shore."
			)
			(6
				(gEgo
					setPri: (+ (shablee priority:) 1)
					setMotion: MoveTo 184 135 self
				)
			)
			(7
				(= ticks 90)
			)
			(8
				(gEgo view: 98)
				(larry init:)
				(shablee setLoop: 1 1 cel: 0)
				(= ticks 30)
			)
			(9
				(shablee cel: 1)
				(if local15
					(= local15 0)
					(gCurRoom notify: self)
				else
					(= ticks 30)
				)
			)
			(10
				(= global170 gCurRoom)
				(gTheIconBar enableIcon: (ScriptID 0 8) show:) ; icon5
				(gKeyDownHandler add: gCurRoom)
				(gEgo setSpeed: local13)
				(= global166 (ScriptID 0 4)) ; icon1
				(gGame handsOn:)
				(gTheIconBar disableIcon: (ScriptID 0 3) show:) ; icon0
				(self dispose:)
			)
		)
	)
)

(instance exitScr of Script
	(properties)

	(method (dispose)
		(sfx number: 0 dispose:)
		(proc79_12 326 327 871 870 869)
		(super dispose:)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(if (gGlobalSound1 handle:)
					(gGlobalSound1 fade:)
				)
				(= temp0 (& (= temp0 10) $00ff))
				(SetShowStyle temp0 (gCurRoom plane:) 1 255 200 0 0)
				(= global170 0)
				(gTheIconBar disableIcon: (ScriptID 0 8) show:) ; icon5
				(gCast eachElementDo: #hide)
				(= ticks 90)
			)
			(1
				(sfx number: 326 loop: 1 play:)
				(= ticks 60)
			)
			(2
				(UpdateScreenItem ((ScriptID 92 3) view: 1903)) ; larryTBust
				(= ticks 20)
			)
			(3
				(sfx number: 327 loop: 1 play:)
				(= ticks 180)
			)
			(4
				(gKeyDownHandler delete: gCurRoom)
				(gGame hideControls:)
				(= ticks 90)
			)
			(5
				(Print font: gUserFont addText: 7 65 3 6 modeless: 2 init:) ; "The Next Morning..."
				(= seconds 5)
			)
			(6
				(if (Print dialog:)
					((Print dialog:) dispose:)
				)
				(Print modeless: 0)
				(gEgo edgeHit: EDGE_NONE)
				(PalVary 3) ; PalVaryKill
				(Palette 1 999 2) ; PalLoad
				(gCurRoom newRoom: 630)
			)
		)
	)
)

