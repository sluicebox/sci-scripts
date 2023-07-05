;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 600)
(include sci.sh)
(use Main)
(use n079)
(use LarryRoom)
(use Inset)
(use PolyPath)
(use Polygon)
(use Feature)
(use Timer)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm600 0
)

(local
	local0
	local1
	local2
	local3 = 5
)

(procedure (localproc_0 param1 param2 param3 param4 param5 param6)
	(cond
		((not (gEgo has: param3))
			(gGame changeScore: param5 param6)
			(gMessager say: param1 param2)
			(gEgo get: param3)
			(if (and (gEgo has: 34) (== param3 37) (IsFlag 82)) ; soap
				(ClearFlag 82)
				(ClearFlag 83)
			)
			(if (and (gEgo has: 37) (== param3 34) (IsFlag 82)) ; toiletpaper
				(ClearFlag 82)
				(ClearFlag 83)
			)
			(if (and (== param3 34) (IsFlag 173))
				((gInventory at: 34) ; soap
					view: 7
					message: 57
					noun: 27
					setCursor: 7 0 0
					show:
				)
				(gInventory show:)
			)
			(++ global184)
		)
		((== param4 2)
			(gNarrator x: -1 y: -1 talkWidth: local2)
			(gMessager say: param1 param2 param4)
			(gNarrator x: 5 y: 50 talkWidth: 130)
		)
		(else
			(gMessager say: param1 param2 param4)
		)
	)
)

(instance rm600 of LarryRoom
	(properties
		noun 12
		picture 600
		horizon 0
		autoLoad 0
	)

	(method (init)
		(if (== global100 2)
			(= local0 5)
		)
		(super init: &rest)
		(elevatorIndicator init: approachVerbs: 4 2 5 6 stopUpd:) ; Do, Talk, Take, Zipper
		(larryDoor init: stopUpd:)
		(elevatorDoors init: approachVerbs: 4 2 5 6 stopUpd:) ; Do, Talk, Take, Zipper
		(gEgo normalize: 900 init:)
		(cond
			((== gPrevRoomNum 700)
				(gGlobalSound1 number: 0 stop:)
				(gGlobalSound2 number: 200 loop: -1 play: 60)
			)
			((or (!= (gGlobalSound2 number:) 200) (not (gGlobalSound2 handle:)))
				(gGlobalSound2 number: 200 loop: -1 play: 127)
			)
			(else
				(gGlobalSound2 pause: 0 setVol: 127)
			)
		)
		(switch gPrevRoomNum
			(620
				(larryDoor view: 600 cel: 7 forceUpd:)
				(gEgo x: 303 y: 97 setLoop: 5)
				(self setScript: enterFrom620Scr)
			)
			(700
				(gEgo
					x: 220
					y: 74
					loop: 8
					cel: 5
					heading: 225
					setPri: 2
					cycleSpeed: 6
					moveSpeed: 6
				)
				(elevatorDoors view: 600 cel: 0 forceUpd:)
				(elevatorIndicator view: 600 cel: 5 startUpd: forceUpd:)
				(self setScript: exitElevatorScr)
			)
			(605
				(gEgo
					posn: (maidCart approachX:) (maidCart approachY:)
					loop: 8
					cel: 2
				)
				(gGame handsOn:)
			)
			(else
				(gEgo posn: 20 94 setPri: 4 setLoop: 4)
				(self setScript: enterFrom200Scr)
			)
		)
		(stairTrigger init:)
		(stairs init: approachVerbs: 4 2 5 6) ; Do, Talk, Take, Zipper
		(lPlant init: approachVerbs: 4 2 5 6) ; Do, Talk, Take, Zipper
		(theWindow init: approachVerbs: 4 2 5 6) ; Do, Talk, Take, Zipper
		(mPlant init: approachVerbs: 4 2 5 6) ; Do, Talk, Take, Zipper
		(rPlant init: approachVerbs: 4 2 5 6) ; Do, Talk, Take, Zipper
		(iceMachine init: approachVerbs: 4 2 5 6 stopUpd:) ; Do, Talk, Take, Zipper
		(iceMachineTimer setReal: iceMachineTimer (Random 30 90))
		(elevatorButton init:)
		(if
			(or
				(IsFlag 83)
				(and (IsFlag 77) (< global184 7) (not (Random 0 2)))
			)
			(maidCart init: addToPic:)
			(backCart init: approachVerbs: 1) ; Look
			(frontCart init: approachVerbs: 1) ; Look
			(self
				addObstacle:
					((Polygon new:)
						type: PContainedAccess
						init: 1 127 0 175 319 175 319 123 291 107 288 106 247 106 223 102 210 83 177 89 168 85 164 89 109 89 118 74 62 93 11 66 16 95 39 86 47 97
						yourself:
					)
			)
		else
			(self
				addObstacle:
					((Polygon new:)
						type: PContainedAccess
						init: 1 127 0 175 319 175 319 123 291 107 288 106 247 106 223 102 210 83 175 74 118 74 62 93 11 66 16 95 39 86 47 97
						yourself:
					)
			)
		)
	)

	(method (doit &tmp temp0 [temp1 20])
		(if (IsFlag 22)
			(if
				(IsObject
					(= temp0 (gFeatures firstTrue: #onMe gMouseX gMouseY))
				)
				(DrawStatus (Format @temp1 {%s} (temp0 name:)) 7 0)
			else
				(DrawStatus {} 0 0)
			)
		)
		(cond
			(script)
			((AvoidPath (gEgo x:) (gEgo y:) stairTrigger)
				(self setScript: downStairsScr)
			)
		)
		(super doit: &rest)
	)

	(method (dispose)
		(stairTrigger dispose:)
		(super dispose:)
	)

	(method (newRoom newRoomNumber)
		(iceMachineTimer dispose: delete:)
		(super newRoom: newRoomNumber)
	)
)

(instance elevatorButton of Feature
	(properties
		x 200
		y 51
		noun 7
		sightAngle 10
		approachX 210
		approachY 83
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 194 45 206 45 206 58 194 58
					yourself:
				)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gCurRoom setScript: pressButtonScr)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance frontCart of Feature
	(properties
		x 163
		y 69
		noun 2
		sightAngle 10
		approachX 168
		approachY 85
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 153 26 172 35 180 36 181 45 187 45 185 52 181 54 170 77 147 86 137 83
					yourself:
				)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 1) ; Look
			(Platform 0 4 3 6)
			(gCurRoom setScript: insetScr 0 1)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance backCart of Feature
	(properties
		x 128
		y 63
		noun 2
		sightAngle 10
		approachX 118
		approachY 74
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 122 40 152 25 140 77 127 83 120 61
					yourself:
				)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 1) ; Look
			(Platform 0 4 3 6)
			(gCurRoom setScript: insetScr 0 2)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance stairs of Feature
	(properties
		noun 14
		sightAngle 10
		approachX 55
		approachY 98
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:) type: PTotalAccess init: 31 41 60 39 58 85 32 95 yourself:)
		)
		(super init:)
	)
)

(instance lPlant of Feature
	(properties
		x 53
		y 13
		noun 11
		sightAngle 10
		approachX 55
		approachY 98
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 83 0 98 15 74 15 73 22 63 38 27 35 27 19 12 17 11 10 16 0
					yourself:
				)
		)
		(super init:)
	)
)

(instance theWindow of Feature
	(properties
		x 148
		y 11
		noun 19
		sightAngle 10
		approachX 118
		approachY 74
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 121 65 112 65 111 0 184 0 183 45 177 45 178 40 181 40 180 35 170 35 158 30 152 25 122 39 119 55
					yourself:
				)
		)
		(super init:)
	)
)

(instance mPlant of Feature
	(properties
		x 210
		y 12
		noun 11
		sightAngle 10
		approachX 210
		approachY 83
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 238 0 240 11 228 16 231 27 216 22 190 31 184 21 190 17 182 10 181 0
					yourself:
				)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (not (-- local0))
					(= global100 2)
					(gEgo get: 22 7) ; roomkey
					(gEgo put: 17 590) ; gown
				else
					(super doVerb: theVerb)
				)
			)
			(1 ; Look
				(if (not (-- local3))
					(= local0 5)
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

(instance elevatorDoors of Prop
	(properties
		x 208
		y 72
		noun 6
		sightAngle 10
		approachX 210
		approachY 83
		view 602
		loop 1
		priority 3
		signal 18448
	)
)

(instance elevatorIndicator of Prop
	(properties
		x 215
		y 29
		noun 5
		sightAngle 10
		approachX 210
		approachY 83
		view 602
		cel 9
		priority 3
		signal 18448
	)

	(method (cue)
		(super cue:)
		(self view: 602 stopUpd:)
	)
)

(instance iceMachine of Prop
	(properties
		x 270
		y 91
		noun 10
		sightAngle 10
		approachX 199
		approachY 104
		view 602
		loop 3
	)

	(method (doVerb theVerb)
		(switch theVerb
			(19 ; champagne
				(gCurRoom setScript: chillChampagneScr 0 0)
			)
			(20 ; champagne [ chilled ]
				(gCurRoom setScript: chillChampagneScr 0 1)
			)
			(36 ; washCloth [ wet ]
				(gCurRoom setScript: chillClothScr)
			)
			(1 ; Look
				(if (== local1 2)
					(gMessager say: 10 1 3) ; "(Let the chips fall where they may!)"
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance rPlant of Feature
	(properties
		x 291
		y 19
		noun 11
		sightAngle 10
		approachX 295
		approachY 107
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 319 0 319 13 314 22 313 38 283 39 267 30 268 17 246 16 261 0
					yourself:
				)
		)
		(super init:)
	)
)

(instance larryDoor of Prop
	(properties
		x 282
		y 90
		noun 4
		sightAngle 10
		approachX 293
		approachY 106
		view 602
		loop 2
		priority 5
		signal 18448
	)

	(method (init)
		(self approachVerbs: 4 7) ; Do, roomkey
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; roomkey
				(gCurRoom setScript: enterLarrysRoomScr 0 0)
			)
			(4 ; Do
				(gCurRoom setScript: enterLarrysRoomScr 0 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance maidCart of View
	(properties
		x 137
		y -20
		z -100
		noun 2
		sightAngle 10
		approachX 150
		approachY 125
		view 607
		priority 5
		signal 18448
	)
)

(instance phonyEgo of View
	(properties
		view 900
		loop 8
		signal 18448
	)
)

(instance stairTrigger of Polygon
	(properties)

	(method (init)
		(super init: 63 82 33 95 22 93 52 80)
	)
)

(instance chillClothScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 227 103 self)
			)
			(1
				((gInventory at: 39) message: 37) ; washcloth
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance enterFrom200Scr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 90)
			)
			(1
				(gGlobalSound2 fade: 127 10 10 0)
				(gEgo setMotion: MoveTo 45 89 self)
			)
			(2
				(gEgo setMotion: MoveTo 61 96 self)
			)
			(3
				(gEgo normalize:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance enterFrom620Scr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 10)
			)
			(1
				(gEgo setMotion: MoveTo 289 109 self)
			)
			(2
				(gEgo setHeading: 45 self)
			)
			(3
				(larryDoor setCycle: Beg self)
			)
			(4
				(sfx number: 1033 loop: 1 play:)
				(larryDoor view: 602 stopUpd:)
				(gEgo setHeading: 180 self)
			)
			(5
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance iceMachineTimer of Timer
	(properties)

	(method (cue)
		(switch (++ local1)
			(1
				(iceShaking number: 605 loop: -1 play:)
				(iceMachine view: 601 setLoop: 0 setCycle: Fwd)
				(self setReal: self 3)
			)
			(2
				(if
					(and
						(not (gCurRoom inset:))
						(not (gCurRoom script:))
						(not gModelessDialog)
						(not (IsFlag 63))
					)
					(SetFlag 63)
					(gMessager say: 10 1 3 0 self) ; "(Let the chips fall where they may!)"
				else
					(self cue:)
				)
			)
			(3
				(iceShaking stop:)
				(sfx number: 604 loop: 1 play:)
				(iceMachine view: 602 setLoop: 3 stopUpd:)
			)
		)
	)
)

(instance insetScr of Script
	(properties)

	(method (dispose)
		(= register 0)
		(gNarrator x: -1 y: -1 talkWidth: local2)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(switch register
					(1
						(gEgo setHeading: 310 self)
					)
					(2
						(gEgo setHeading: 125 self)
					)
				)
			)
			(1
				(= cycles 2)
			)
			(2
				(switch register
					(1
						(phonyEgo
							cel: 7
							x: (gEgo x:)
							y: (gEgo y:)
							priority: (gEgo priority:)
							init:
							addToPic:
						)
					)
					(2
						(phonyEgo
							cel: 4
							x: (gEgo x:)
							y: (gEgo y:)
							priority: (gEgo priority:)
							init:
							addToPic:
						)
					)
				)
				(gEgo view: 98)
				(= local2 (gNarrator talkWidth:))
				((ScriptID 825 1) view: 98 dispose:) ; tram
				(UnLoad 128 82)
				(UnLoad 128 900)
				(UnLoad 130 911)
				(= cycles 2)
			)
			(3
				(SetFlag 86)
				(switch register
					(1
						(gNarrator x: 150 y: 50 talkWidth: 150)
						(gCurRoom setInset: frontInset)
					)
					(2
						(gNarrator x: 5 y: 50 talkWidth: 130)
						(gCurRoom setInset: backInset)
					)
				)
				(= cycles 2)
			)
			(4
				(gMessager say: 2 1 0 0 self) ; "The maid's cart is filled with the usual towels and washcloths, plus lots of other freebies which she places in the guests' bathrooms."
			)
			(5
				(gGame handsOn:)
				((ScriptID 0 11) init: self) ; iconExit
			)
			(6
				(Platform 0 4 2 6)
				((ScriptID 0 11) dispose:) ; iconExit
				(ClearFlag 86)
				((gCurRoom inset:) dispose:)
				(gCurRoom drawPic: 600 100)
				(gEgo view: 900)
				(maidCart init: addToPic:)
				(self dispose:)
			)
		)
	)
)

(instance theFloss of Feature
	(properties
		x 218
		y 54
		noun 8
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 239 60 244 61 248 68 230 71 226 70 225 65
					yourself:
				)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(cond
			((IsFlag 156)
				(gMessager say: 8 5 13) ; "Don't take any more dental floss... just look what you did with the last floss you took!"
			)
			((== theVerb 5) ; Take
				(localproc_0 noun theVerb 15 2 4 232)
			)
			((not (OneOf theVerb 4 1 2 5 6)) ; Do, Look, Talk, Take, Zipper
				(backInset doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance theSeatCovers of Feature
	(properties
		x 242
		y 64
		noun 15
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 216 44 234 48 238 61 221 69 192 60 193 47
					yourself:
				)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 5) ; Take
				(localproc_0 noun theVerb 36 5 2 231)
			)
			((not (OneOf theVerb 4 1 2 5 6)) ; Do, Look, Talk, Take, Zipper
				(backInset doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance theTowels of Feature
	(properties
		x 222
		y 76
		noun 16
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 188 68 225 77 231 96 194 86
					yourself:
				)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 5) ; Take
				(localproc_0 noun theVerb 38 6 3 233)
			)
			((not (OneOf theVerb 4 1 2 5 6)) ; Do, Look, Talk, Take, Zipper
				(backInset doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance theToiletPaper of Feature
	(properties
		y 6
		noun 17
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 82 79 118 70 116 85 80 96
					yourself:
				)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 5) ; Take
				(if (not (gEgo has: 38)) ; towel
					(SetFlag 96)
				)
				(localproc_0 noun theVerb 37 7 2 227)
			)
			((not (OneOf theVerb 4 1 2 5 6)) ; Do, Look, Talk, Take, Zipper
				(frontInset doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance theLotion of Feature
	(properties
		y 6
		noun 3
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 118 52 118 62 109 65 99 59 100 48
					yourself:
				)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 5) ; Take
				(localproc_0 noun theVerb 19 1 2 230)
			)
			((not (OneOf theVerb 4 1 2 5 6)) ; Do, Look, Talk, Take, Zipper
				(frontInset doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance theSoap of Feature
	(properties
		y 6
		noun 13
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 97 57 110 64 94 68 88 59
					yourself:
				)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 5) ; Take
				(localproc_0 noun theVerb 34 4 2 228)
			)
			((not (OneOf theVerb 4 1 2 5 6)) ; Do, Look, Talk, Take, Zipper
				(frontInset doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance theWashCloths of Feature
	(properties
		y 6
		noun 18
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 70 66 71 62 80 58 92 61 94 66 82 70
					yourself:
				)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 5) ; Take
				(cond
					((OneOf global171 9 10)
						(gMessager say: 18 5 14) ; "You don't need another washcloth. After your experience with that fickle Gammie, you may never wash again!"
					)
					((== ((gInventory at: 39) owner:) 560) ; washcloth
						(gMessager say: 18 5 11) ; "You don't need another washcloth. You left yours downstairs in the refrigerator, remember? Go get it."
					)
					((== ((gInventory at: 39) owner:) 530) ; washcloth
						(gMessager say: 18 5 12) ; "You don't need another washcloth. You left yours downstairs, soaking in the salad bar, remember? Go get it."
					)
					(else
						(localproc_0 noun theVerb 39 8 4 229)
					)
				)
			)
			((not (OneOf theVerb 4 1 2 5 6)) ; Do, Look, Talk, Take, Zipper
				(frontInset doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sfx of Sound
	(properties
		flags 1
	)
)

(instance iceShaking of Sound
	(properties
		flags 1
		loop -1
	)
)

(instance downStairsScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 20 94 self setPri: 4 setLoop: 7)
				(gGlobalSound2 fade: 90 10 10 0)
			)
			(1
				(= ticks 30)
			)
			(2
				(if
					(and
						(not (IsFlag 52))
						(or
							(IsFlag 80)
							(and (not (IsFlag 12)) (IsFlag 34))
						)
					)
					(SetFlag 52)
				)
				(if (IsFlag 240)
					(SetFlag 68)
				)
				(gGlobalSound1 number: 0 stop:)
				(ClearFlag 73)
				(gCurRoom newRoom: 200)
			)
		)
	)
)

(instance backInset of Inset
	(properties
		view 606
		x 130
		y 10
		noun 1
	)

	(method (doit)
		(if script
			(script doit:)
		)
	)

	(method (init)
		(super init: &rest)
		(theFloss init:)
		(theSeatCovers init:)
		(theTowels init:)
	)

	(method (dispose)
		(theSeatCovers dispose:)
		(theTowels dispose:)
		(theFloss dispose:)
		(super dispose:)
	)

	(method (doVerb theVerb)
		(if (not (OneOf theVerb 4 1 2 5 6)) ; Do, Look, Talk, Take, Zipper
			(gMessager say: noun 15) ; "No, you can't put your stuff on the maid's cart."
		else
			(super doVerb: theVerb)
		)
	)
)

(instance frontInset of Inset
	(properties
		view 605
		x 3
		y 5
		noun 9
	)

	(method (doit)
		(if script
			(script doit:)
		)
	)

	(method (init)
		(super init: &rest)
		(theToiletPaper init:)
		(theSoap init:)
		(theWashCloths init:)
		(theLotion init:)
	)

	(method (dispose)
		(theToiletPaper dispose:)
		(theSoap dispose:)
		(theWashCloths dispose:)
		(theLotion dispose:)
		(super dispose:)
	)

	(method (doVerb theVerb)
		(if (not (OneOf theVerb 4 1 2 5 6)) ; Do, Look, Talk, Take, Zipper
			(gMessager say: noun 15) ; "No, you can't put your stuff on the maid's cart."
		else
			(super doVerb: theVerb)
		)
	)
)

(instance pressButtonScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 198 86 self)
			)
			(1
				(gEgo setPri: 6 setMotion: MoveTo 189 78 self)
			)
			(2
				(gEgo view: 901 setLoop: 7 cel: 0 setCycle: CT 3 1 self)
			)
			(3
				(= register (gNarrator talkWidth:))
				(gNarrator x: 10 y: 30 talkWidth: 130)
				(= ticks 30)
			)
			(4
				(gMessager say: 7 4 0 0 self) ; "Since this elevator requires a key, pushing on its lock does little good."
			)
			(5
				(gNarrator y: -1)
				(gEgo setCycle: Beg self)
			)
			(6
				(gEgo normalize: 900 3 setHeading: 180 self)
			)
			(7
				(gEgo setMotion: MoveTo 198 86 self)
			)
			(8
				(gNarrator x: -1 y: -1 talkWidth: register)
				(gEgo normalize: 900 2)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance enterLarrysRoomScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (not register)
					(gGame changeScore: 5 234)
				)
				(gEgo setHeading: 360 self)
			)
			(1
				(= ticks 60)
			)
			(2
				(gEgo view: 901 setLoop: 6 cel: 0 setCycle: End self)
			)
			(3
				(if register
					(sfx number: 1034 loop: 1 play: self)
				else
					(+= state 2)
					(= cycles 2)
				)
			)
			(4
				(gMessager say: 4 4 0 0 self) ; "Like every other guest room in the hotel, this door requires a key."
			)
			(5
				(gEgo normalize: 900 3)
				(gGame handsOn:)
				(self dispose:)
			)
			(6
				(sfx number: 603 loop: 1 play:)
				(larryDoor view: 600 cel: 0 setCycle: End self)
			)
			(7
				(gEgo setCycle: Beg self)
			)
			(8
				(gEgo
					view: 900
					setLoop: 6
					setCycle: Fwd
					setMotion: MoveTo 317 82 self
				)
				(gGlobalSound2 fade: 0 10 10 0)
			)
			(9
				(gEgo setCycle: 0 hide:)
				(= ticks 120)
			)
			(10
				(gGlobalSound2 pause: 1)
				(gCurRoom newRoom: 620)
			)
		)
	)
)

(instance chillChampagneScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 225 103 self)
			)
			(1
				(gEgo setHeading: 45 self)
			)
			(2
				(= ticks 90)
			)
			(3
				(gNarrator x: 10 y: 20)
				(if register
					(gMessager say: 20 0 10 0 self) ; "Good idea! Dumping out the icy water into the ice machine's tiny receptacle, you prepare to fill the champagne's ice bucket with fresh cubes."
				else
					(gMessager say: 20 0 9 0 self) ; "Pouring the old melted ice into the little receptacle on the ice machine, you prepare to catch a few new cubes."
				)
			)
			(4
				(gEgo setMotion: PolyPath 199 104 self)
			)
			(5
				(gEgo setHeading: 90 self)
			)
			(6
				(gEgo loop: 8 cel: 0)
				(= cycles 2)
			)
			(7
				(gEgo view: 601 setLoop: 2 cel: 0)
				(= ticks 10)
			)
			(8
				(iceShaking number: 605 loop: -1 play:)
				(iceMachine view: 601 setLoop: 0 setCycle: Fwd)
				(gEgo cel: 1)
				(= seconds 3)
			)
			(9
				(iceMachine view: 601 setLoop: 1 cel: 0 setCycle: Fwd)
				(gEgo cycleSpeed: 8 setCycle: CT 4 1 self)
			)
			(10
				(= ticks 180)
			)
			(11
				(gGame changeScore: 12 235)
				(gEgo normalize: 900 0)
				(iceMachine setLoop: 0 setCycle: End self)
			)
			(12
				(iceShaking stop:)
				(iceMachine view: 602 setLoop: 3 stopUpd:)
				((gInventory at: 7) cue: -32768) ; champagne
				(gNarrator x: -1 y: -1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance exitElevatorScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= register 6)
				(= seconds 2)
			)
			(1
				(if (-- register)
					(-- state)
				)
				(elevatorIndicator cel: register forceUpd:)
				(= ticks 30)
			)
			(2
				(sfx number: 602 loop: 1 play:)
				(= ticks 90)
			)
			(3
				(sfx number: 600 loop: 1 play:)
				(elevatorDoors startUpd: cycleSpeed: 4 setCycle: CT 2 1 self)
			)
			(4
				(gGlobalSound2 fade: 127 10 10 0)
				(elevatorDoors setCycle: End self)
			)
			(5
				(elevatorDoors hide:)
				(gEgo setLoop: 5 setPri: -1 setMotion: MoveTo 206 86 self)
			)
			(6
				(gEgo setHeading: 180)
				(= ticks 30)
			)
			(7
				(elevatorDoors show: setCycle: Beg self)
				(sfx number: 601 loop: 1 play:)
			)
			(8
				(elevatorIndicator
					cycleSpeed: 60
					setCycle: End elevatorIndicator
				)
				(elevatorDoors view: 602 stopUpd:)
				(gEgo normalize: 900 2)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

