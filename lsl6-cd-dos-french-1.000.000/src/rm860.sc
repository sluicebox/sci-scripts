;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 860)
(include sci.sh)
(use Main)
(use n079)
(use n082)
(use LarryRoom)
(use Print)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use Timer)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm860 0
)

(local
	local0 = 4
	local1
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
	local12 = -1
	local13
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
			(= gPrevRoomNum 590)
		)
		(if (OneOf 590 620)
			(= picture 98)
		)
		(super init: &rest)
		(if (== global100 860)
			(gEgo get: 8) ; condom
			(gEgo put: 17 590) ; gown
			(= global100 1)
		)
		((ScriptID 825 1) view: 98 dispose:) ; tram
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
				(self setScript: enterFrom230Scr)
			)
			((OneOf gPrevRoomNum 590 620)
				(= local3 1)
				(gGlobalSound1 number: 861 loop: -1 play:)
				(gGlobalSound2 number: 0 stop:)
				(self setScript: shabCartoonScr)
			)
			(else
				(gEgo x: 200 y: 200)
				(self setScript: enterFrom810Scr)
			)
		)
		(if (and (IsFlag 24) (not (IsFlag 275)))
			(theChampagne init: approachVerbs: 4 2 5 6 stopUpd:) ; Do, Talk, Take, Zipper
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
		(if (not local3)
			(path1 init:)
			(path2 init:)
			(path3 init:)
			(shore init:)
			(sky init:)
			(shallowWater init:)
			(deepWater init:)
			(jungle init:)
			(if (or (!= gPrevRoomNum 810) (not (gGlobalSound1 handle:)))
				(gGlobalSound1 number: 860 loop: -1 play:)
			)
			(gEgo init: normalize: 900 setScale: Scaler 100 23 141 66)
			(bird init: hide: setScript: birdScr)
			(wave init: setScript: waveScr)
			(birdSfx number: 812 loop: -1 play:)
		)
		(Load rsVIEW 865)
	)

	(method (doVerb theVerb)
		(if local3
			(if (OneOf theVerb 4 1 2 5 6) ; Do, Look, Talk, Take, Zipper
				(gMessager say: 6 theVerb 2)
			else
				(gMessager say: 6 0 2) ; "Now? At a romantic, moonlit moment like this?"
			)
			(return 1)
		else
			(super doVerb: theVerb)
		)
	)

	(method (doit &tmp [temp0 21])
		(cond
			(script)
			(local3)
			(
				(and
					(== (gEgo view:) 900)
					(AvoidPath
						(gEgo x:)
						(gEgo y:)
						(shallowWater onMeCheck:)
					)
				)
				(gEgo view: 865)
			)
			(
				(and
					(== (gEgo view:) 865)
					(not
						(AvoidPath
							(gEgo x:)
							(gEgo y:)
							(shallowWater onMeCheck:)
						)
					)
				)
				(gEgo view: 900)
			)
			((AvoidPath (gEgo x:) (gEgo y:) (deepWater onMeCheck:))
				(gCurRoom setScript: drownScr)
			)
			((== (gEgo edgeHit:) EDGE_RIGHT)
				(self setScript: exitEastScr)
			)
			((> (gEgo y:) 143)
				(self setScript: exitSouthScr)
			)
		)
		(super doit: &rest)
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
			(= local11
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
			(gGame handsOff:)
			(self setScript: 0)
			(= global170 0)
			((ScriptID 0 8) disable:) ; icon5
			(gEgo put: 8) ; condom
			(gGame changeScore: 13 274)
			(ffTimer setReal: ffTimer 4)
		else
			(ffTimer setCycle: ffTimer 2)
		)
		(gGame setCursor: temp80)
	)

	(method (handleEvent event &tmp [temp0 21])
		(cond
			((gTheIconBar handleEvent: event))
			((event claimed:)
				(return)
			)
			(
				(and
					(or gModelessDialog (not (gGame controlsVisible:)))
					(== (event type:) evKEYBOARD)
					(OneOf (event message:) KEY_F5 KEY_F7)
				)
				(event claimed: 1)
			)
			(else
				(event claimed: 0)
				(return)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(ffTimer dispose: delete:)
		(leMatchTimer dispose: delete:)
		(super newRoom: newRoomNumber)
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

(instance barryVoice of Sound
	(properties
		flags 1
	)
)

(instance oceanSfx of Sound
	(properties
		flags 1
	)
)

(instance sfx of Sound
	(properties
		flags 1
	)
)

(instance fireFx of Sound
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
		view 860
		loop 2
		signal 18448
		scaleSignal 1
		scaleX 69
		scaleY 69
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
			setOnMeCheck:
				2
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
			setOnMeCheck:
				2
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
			setOnMeCheck:
				2
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
			setOnMeCheck:
				2
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
			setOnMeCheck:
				2
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
				(= local4 ((gUser curEvent:) x:))
				(= local5 ((gUser curEvent:) y:))
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
			setOnMeCheck:
				2
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
			setOnMeCheck:
				2
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
			setOnMeCheck:
				2
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
		x -10
		y 11
		noun 11
		view 867
		loop 1
	)
)

(instance fire of Prop
	(properties
		x 136
		y 124
		noun 4
		view 863
		cel 3
		detailLevel 2
	)
)

(instance getLamp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath local4 local5 self)
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
				(gEgo
					view: 864
					loop: 0
					cel: 0
					cycleSpeed: 8
					setCycle: End self
				)
			)
			(5
				(gEgo setLoop: 1 cel: 0 setCycle: End self)
			)
			(6
				(= ticks 30)
			)
			(7
				(gMessager say: 8 4 8 2 self) ; "What's this?!"
			)
			(8
				(gMessager say: 8 4 8 3 self) ; "While your sand castle will win no prizes, your diggings have revealed an ancient whale oil lamp buried in the sand."
			)
			(9
				(gEgo setLoop: 2 cel: 0 get: 23) ; lamp
				(hole init: x: (gEgo x:) y: (gEgo y:))
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
				(gEgo setLoop: 0 cel: 0)
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
				(gEgo setLoop: 1 cel: 15 setCycle: Beg self)
			)
			(16
				(gEgo setLoop: 0 cel: 3 setCycle: Beg self)
			)
			(17
				(gEgo normalize: 900 1 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance theChampagne of View
	(properties
		x 226
		y 127
		noun 2
		sightAngle 10
		approachX 211
		approachY 134
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
							setLoop: 1
							x: 0
							y: register
							setCycle: Fwd
							setMotion: MoveTo 275 register self
						)
					)
					(2
						(bird
							show:
							setLoop: 5
							x: 0
							y: register
							setCycle: Fwd
							setMotion: MoveTo 275 register self
						)
					)
					(3
						(bird
							show:
							setLoop: 2
							setCycle: Fwd
							x: 297
							y: register
							setMotion: MoveTo -10 register self
						)
					)
					(4
						(bird
							show:
							setLoop: 6
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

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 5)
			)
			(1
				(if (not local10)
					(oceanSfx number: 867 loop: 1 play:)
					(wave cel: 0 cycleSpeed: 15 startUpd: setCycle: End self)
				else
					(-- state)
					(= ticks 30)
				)
			)
			(2
				(wave stopUpd:)
				(= seconds 3)
			)
			(3
				(if (not local10)
					(wave startUpd: setCycle: Beg self)
				else
					(-- state)
					(= ticks 30)
				)
			)
			(4
				(wave cel: 0 stopUpd:)
				(self init:)
			)
		)
	)
)

(instance wave of Prop
	(properties
		y 67
		view 867
	)
)

(instance shabCartoonScr of Script
	(properties)

	(method (changeState newState &tmp [temp0 20])
		(switch (= state newState)
			(0
				(Palette palSET_FROM_RESOURCE 862 2)
				(Palette palSET_FLAG 0 255 4)
				(shablee init:)
				(theChampagne init: stopUpd:)
				(fire init: setCycle: Fwd setPri: 1)
				(fireFx number: 868 loop: -1 play:)
				(wave init: setScript: waveScr)
				(gEgo
					normalize: 900 6
					init:
					setScale: 0
					x: 86
					y: 189
					setLoop: 6
					setCycle: Fwd
					setPri: 4
					cycleSpeed: 6
					moveSpeed: 6
				)
				(DrawPic 860 7 1 862)
				(PalVary pvINIT 862 0 64 1)
				(= seconds 3)
			)
			(1
				(gEgo setMotion: MoveTo 138 135 self)
			)
			(2
				(= global170 gCurRoom)
				((ScriptID 0 8) enable:) ; icon5
				(gKeyDownHandler add: gCurRoom)
				(gEgo
					normalize: 900
					loop: 8
					cel: 6
					heading: 45
					cycleSpeed: 6
					moveSpeed: 6
				)
				(= cycles 2)
			)
			(3
				(gEgo setHeading: 90 self)
			)
			(4
				(gNarrator x: 20 y: 30 modeless: 1)
				(gMessager say: 7 1 4 0 self) ; "Shablee looks beautiful here on the beach, in the moonlight, with those waves softly licking the shore."
			)
			(5
				(gEgo setMotion: MoveTo 184 135 self)
			)
			(6
				(= ticks 90)
			)
			(7
				(gEgo view: 98)
				(larry init:)
				(shablee setLoop: 1 cel: 0)
				(= ticks 30)
			)
			(8
				(shablee cel: 1)
				(= ticks 180)
			)
			(9
				(= global166 (ScriptID 0 4)) ; icon1
				(gGame handsOn:)
				((ScriptID 0 3) disable:) ; icon0
				(self dispose:)
			)
		)
	)
)

(instance digScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath local4 local5 self)
			)
			(1
				(gEgo setHeading: 270 self)
			)
			(2
				(= cycles 2)
			)
			(3
				(gEgo
					view: 864
					loop: 0
					cel: 0
					cycleSpeed: 8
					setCycle: End self
				)
			)
			(4
				(gEgo setLoop: 1 cel: 0 setCycle: End self)
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
				(gEgo setLoop: 0 cel: 3 setCycle: Beg self)
			)
			(10
				(UnLoad 128 864)
				(gEgo normalize: 900 1 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance takeChampagneScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
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
				(gEgo
					view: 901
					setLoop: 4
					cel: 0
					cycleSpeed: 8
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
				(gEgo normalize: 900 0 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance ffTimer of Timer
	(properties)

	(method (cue)
		(if local11
			(gCurRoom setScript: exitScr)
		else
			(= global170 gCurRoom)
			((ScriptID 0 8) enable:) ; icon5
		)
	)
)

(instance leMatchTimer of Timer
	(properties)

	(method (cue)
		(if (or (gGame isHandsOff:) gModelessDialog)
			(self setReal: self 2)
		else
			(gMessager say: 13) ; "The forceful trade winds immediately extinguish your match."
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
				(gEgo view: 901 setLoop: 5 cel: 0 setCycle: CT 5 1 self)
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
				(= local10 1)
				(wave stopUpd:)
				(= cycles 2)
			)
			(1
				((ScriptID 1800 1) modeless: 1) ; You
				((ScriptID 1812 10) modeless: 1) ; Shablee
				((ScriptID 1820 31) modeless: 1) ; You
				((ScriptID 1814 26) modeless: 1) ; You
				((ScriptID 1817 28) modeless: 1) ; You
				((ScriptID 1818 29) modeless: 1) ; You
				(if (OneOf local0 6 3)
					(self setScript: makeOut self)
				else
					(gMessager say: 7 2 local0 0 self)
				)
				(if local2
					(= local0
						(switch local0
							(4 5)
							(5 6)
							(6 3)
							(else local0)
						)
					)
					(= local2 (= local1 0))
				else
					(= local1 1)
				)
			)
			(2
				(= local10 0)
				(wave startUpd:)
				((ScriptID 1800 1) modeless: 0) ; You
				((ScriptID 1812 10) modeless: 0) ; Shablee
				((ScriptID 1820 31) modeless: 0) ; You
				((ScriptID 1814 26) modeless: 0) ; You
				((ScriptID 1817 28) modeless: 0) ; You
				((ScriptID 1818 29) modeless: 0) ; You
				(gGame handsOn:)
				(gTheIconBar disable: (ScriptID 0 3)) ; icon0
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
			setOnMeCheck:
				2
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
		x 183
		y 135
		noun 7
		view 862
		cel 1
		priority 3
		signal 18448
	)

	(method (doit &tmp temp0 [temp1 20])
		(if (and (gEgo has: 25) (== ((gInventory at: 25) message:) 43)) ; match, match
			((gInventory at: 25) ; match
				message: 42
				noun: 22
				owner: 510
				view: 40
				setCursor: 40 0 0
				yourself:
			)
			((ScriptID 85 1) dispose:) ; mTimer
			(gEgo put: 25) ; match
			(leMatchTimer setReal: leMatchTimer 2)
		)
		(= temp0 (gGlobalSound1 prevSignal:))
		(if (and (not local8) (not (barryVoice handle:)) temp0)
			(switch temp0
				(10
					(barryVoice number: 862 loop: 1 play:)
				)
				(12
					(barryVoice number: 863 loop: 1 play:)
				)
				(14
					(barryVoice number: 864 loop: 1 play:)
				)
				(16
					(barryVoice number: 865 loop: 1 play:)
				)
			)
			(gGlobalSound1 prevSignal: 0)
		)
		(super doit:)
	)

	(method (doVerb theVerb &tmp temp0)
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

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 864
					setLoop: 3
					cel: 0
					cycleSpeed: 12
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
				(gEgo show: normalize: 900 4 1 x: 68 y: 99)
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

(instance exitScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global170 0)
				((ScriptID 0 8) disable:) ; icon5
				(gGame hideControls:)
				(SetPort 0)
				(SetPort 0 0 190 320 10 0)
				(= cycles 1)
			)
			(1
				(gCast eachElementDo: #hide)
				(Palette palUNSET_FLAG 0 255 4)
				(PalVary pvUNINIT)
				(DrawPic 90 6 1 862)
				(gGlobalSound1 fade:)
				(= ticks 60)
			)
			(2
				(if (> local6 5)
					(sfx number: 326 loop: 1 play:)
					(= ticks 120)
				else
					(= ticks 30)
				)
			)
			(3
				(if (> local6 5)
					(sfx number: 327 loop: 1 play:)
					(= ticks 180)
				else
					(= ticks 30)
				)
			)
			(4
				(Palette palSET_FROM_RESOURCE 999 2)
				(gNarrator x: -1 y: -1 modeless: 0)
				((ScriptID 1800 1) modeless: 0) ; You
				((ScriptID 1812 10) modeless: 0) ; Shablee
				((ScriptID 1820 31) modeless: 0) ; You
				((ScriptID 1814 26) modeless: 0) ; You
				((ScriptID 1817 28) modeless: 0) ; You
				((ScriptID 1818 29) modeless: 0) ; You
				(fireFx stop:)
				(wave setScript: 0)
				(= cycles 2)
			)
			(5
				(= gTextSpeed local12)
				(gMessager say: 7 65 3 6 self) ; "The Next Morning..."
			)
			(6
				(gKeyDownHandler delete: gCurRoom)
				(= seconds 2)
			)
			(7
				(gEgo edgeHit: EDGE_NONE)
				(gCurRoom newRoom: 630)
			)
		)
	)
)

(instance applyCondomScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local8 1)
				(= cycles 2)
			)
			(1
				(gGame changeScore: 13 274)
				(gEgo put: 8) ; condom
				(= ticks 30)
			)
			(2
				(= local8 0)
				(gMessager say: 7 65 3 1 self) ; "I was hoping you brought one of those!"
			)
			(3
				(gMessager say: 7 65 3 2 self) ; "Here. Let me have that."
			)
			(4
				(shablee setLoop: 5 cycleSpeed: 8 cel: 0 setCycle: End self)
			)
			(5
				(shablee setLoop: 6 setCycle: Fwd)
				(= seconds 6)
			)
			(6
				(shablee setLoop: 7 cel: 0 setCycle: 0)
				(= ticks 30)
			)
			(7
				(gMessager say: 7 65 3 3 self) ; "I'm ready when you are!"
			)
			(8
				(shablee setCycle: CT 3 1 self)
				(gGlobalSound1 stop:)
			)
			(9
				(sfx number: 869 loop: 1 play:)
				(shablee setCycle: End self)
			)
			(10
				(= ticks 180)
			)
			(11
				(shablee setLoop: 0 cel: 0)
				(gEgo
					show:
					view: 862
					x: (shablee x:)
					y: (shablee y:)
					setLoop: 8
					setCycle: Fwd
					moveSpeed: 8
					cycleSpeed: 8
					setStep: 1 1
					setMotion: MoveTo 155 (gEgo y:) self
				)
			)
			(12
				(gEgo setCycle: 0 cel: 0 setLoop: 9 setCycle: End self)
			)
			(13
				(gEgo setScript: spitScr)
				(= local10 1)
				(wave stopUpd:)
				(= local12 gTextSpeed)
				(= gTextSpeed 18)
				(= seconds 8)
			)
			(14
				(gMessager say: 7 65 3 5 self) ; "No wonder Shablee knows what a man likes!"
			)
			(15
				(wave startUpd:)
				(= local10 0)
				(gEgo setScript: 0)
				(shablee view: 861 cel: 0 cycleSpeed: 8 setCycle: End self)
			)
			(16
				(= next exitScr)
				(self dispose:)
			)
		)
	)
)

(instance spitScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setLoop: 10 cycleSpeed: 6 cel: 0)
				(= ticks 30)
			)
			(1
				(gEgo cel: 0 setCycle: CT 1 1 self)
			)
			(2
				(sfx number: 871 loop: 1 play:)
				(if (not register)
					(= register 1)
					(gMessager say: 7 65 3 4) ; "(VARIOUS SPITTING SOUNDS) Phhhtuueeey!"
				)
				(= ticks 90)
			)
			(3
				(gEgo setCycle: End self)
			)
			(4
				(sfx number: 870 loop: 1 play:)
				(= state 0)
				(= ticks 60)
			)
		)
	)
)

(instance makeOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(++ local6)
				(= local10 1)
				(wave stopUpd:)
				(= cycles 2)
			)
			(1
				(if (== local0 3)
					(gMessager say: 7 2 local0 1 self) ; "Come here, you beautiful thing!"
				else
					(gMessager say: 7 2 local0 0 self)
				)
			)
			(2
				(= local10 0)
				(wave startUpd:)
				(if (== local6 1)
					(shablee setLoop: 2 cel: 0 cycleSpeed: 8)
					(= local8 1)
					(= ticks 30)
				else
					(+= state 2)
					(self cue:)
				)
			)
			(3
				(shablee cel: 1)
				(= local8 1)
				(= ticks 90)
			)
			(4
				(sfx number: 124 loop: 1 play:)
				(= ticks 20)
			)
			(5
				(if (== local6 1)
					(shablee cel: 0)
					(= ticks 20)
				else
					(shablee setLoop: 3 cel: 0 setCycle: End self)
					(++ state)
				)
			)
			(6
				(= local8 0)
				(shablee setLoop: 1 cel: 1)
				(gGame handsOn:)
				((ScriptID 0 3) disable:) ; icon0
				(self dispose:)
			)
			(7
				(if (and (> local6 2) (== local0 3))
					(shablee setLoop: 4 cycleSpeed: 20 setCycle: Fwd)
					(= seconds 8)
				else
					(= ticks 30)
				)
			)
			(8
				(shablee setLoop: 3 cel: 4 cycleSpeed: 8 setCycle: CT 1 -1 self)
				(= local8 1)
			)
			(9
				(sfx number: 124 loop: 1 play:)
				(= ticks 10)
			)
			(10
				(shablee cel: 0)
				(= ticks 30)
			)
			(11
				(= local8 0)
				(shablee setLoop: 1 cel: 1)
				(= local10 1)
				(wave stopUpd:)
				(= ticks 60)
			)
			(12
				(if (and (> local6 2) (== local0 3))
					(gMessager say: 7 2 local0 2 3 self)
				else
					(= cycles 2)
				)
			)
			(13
				(= local10 0)
				(wave startUpd:)
				(gGame handsOn:)
				((ScriptID 0 3) disable:) ; icon0
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
				(= local10 1)
				(wave stopUpd:)
				(= cycles 2)
			)
			(1
				((ScriptID 1800 1) modeless: 1) ; You
				((ScriptID 1812 10) modeless: 1) ; Shablee
				((ScriptID 1820 31) modeless: 1) ; You
				((ScriptID 1814 26) modeless: 1) ; You
				((ScriptID 1817 28) modeless: 1) ; You
				((ScriptID 1818 29) modeless: 1) ; You
				(switch register
					(6
						(cond
							((!= local0 3)
								(gMessager say: 7 6 local0 0 self)
							)
							((and (== local0 3) (> local6 2))
								(gMessager say: 7 6 3 0 self) ; "I'm ready, baby! I hope you brought a condom."
							)
							(else
								(gMessager say: 7 6 6 0 self) ; "Ah, Larry. Perhaps soon."
							)
						)
					)
					(1
						(gMessager say: 7 1 local0 0 self)
					)
					(4
						(= local2 1)
						(gMessager say: 7 4 local0 0 self)
						(if local1
							(= local0
								(switch local0
									(4 5)
									(5 6)
									(6 3)
									(else local0)
								)
							)
							(= local2 (= local1 0))
						else
							(= local2 1)
						)
					)
					(65
						(if (and (> local6 2) (== local0 3))
							(= next applyCondomScr)
							(self dispose:)
						else
							(gMessager say: 7 65 0 0 self) ; "Not yet, Larry! Once again, you're premature!"
						)
					)
				)
			)
			(2
				(= local10 0)
				(wave startUpd:)
				((ScriptID 1800 1) modeless: 0) ; You
				((ScriptID 1812 10) modeless: 0) ; Shablee
				((ScriptID 1820 31) modeless: 0) ; You
				((ScriptID 1814 26) modeless: 0) ; You
				((ScriptID 1817 28) modeless: 0) ; You
				((ScriptID 1818 29) modeless: 0) ; You
				(gGame handsOn:)
				(gTheIconBar disable: (ScriptID 0 3)) ; icon0
				(self dispose:)
			)
		)
	)
)

