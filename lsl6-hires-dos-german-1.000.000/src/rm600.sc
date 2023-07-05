;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 600)
(include sci.sh)
(use Main)
(use fileScr)
(use LarryRoom)
(use Print)
(use Inset)
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
	rm600 0
)

(local
	local0
	local1
	local2 = 5
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
			(gMessager say: param1 param2 param4)
		)
		(else
			(gMessager say: param1 param2 param4)
		)
	)
)

(procedure (localproc_1)
	(return
		(or
			(gEgo mover:)
			(gTalkers size:)
			(gCurRoom script:)
			(gEgo script:)
			(!= (gEgo view:) 900)
			(gGame script:)
			(Print dialog:)
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
		(if global100
			(= local0 2)
		else
			(= local0 4)
		)
		(super init: &rest)
		(elevatorIndicator init: approachVerbs: 4 2 5 6) ; Do, Talk, Take, Zipper
		(larryDoor init:)
		(elevatorDoors init: approachVerbs: 4 2 5 6) ; Do, Talk, Take, Zipper
		(gEgo normalize: 900 setScaler: Scaler 100 85 95 78 init:)
		(cond
			((== gPrevRoomNum 700)
				(gGlobalSound1 number: 0 stop:)
				(gGlobalSound2 number: 200 loop: -1 play: setVol: 60)
			)
			((or (!= (gGlobalSound2 number:) 200) (not (gGlobalSound2 handle:)))
				(gGlobalSound2 number: 200 loop: -1 play: setVol: 127)
			)
			(else
				(gGlobalSound2 pause: 0 setVol: 127)
			)
		)
		(switch gPrevRoomNum
			(620
				(larryDoor view: 600 cel: 7)
				(gEgo x: 303 y: 97 setLoop: 5)
				(self setScript: enterFrom620Scr)
			)
			(700
				(gEgo
					x: 223
					y: 73
					loop: 8
					cel: 5
					heading: 225
					setPri: 30
					cycleSpeed: 6
					moveSpeed: 6
				)
				(elevatorDoors view: 600 cel: 0)
				(elevatorIndicator view: 600 cel: 5)
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
				(gEgo posn: 4 103 setPri: 80 setLoop: 4)
				(self setScript: enterFrom200Scr)
			)
		)
		(stairTrigger init:)
		(stairs init: approachVerbs: 4 2 5 6) ; Do, Talk, Take, Zipper
		(lPlant init: approachVerbs: 4 2 5 6) ; Do, Talk, Take, Zipper
		(theWindow init: approachVerbs: 4 2 5 6) ; Do, Talk, Take, Zipper
		(mPlant init: approachVerbs: 4 2 5 6) ; Do, Talk, Take, Zipper
		(rPlant init: approachVerbs: 4 2 5 6) ; Do, Talk, Take, Zipper
		(iceMachine init: approachVerbs: 4 2 5 6) ; Do, Talk, Take, Zipper
		(iceMachineTimer setReal: iceMachineTimer (Random 30 90))
		(elevatorButton init:)
		(if
			(or
				global189
				(IsFlag 83)
				(and (IsFlag 77) (< global184 7) (not (Random 0 2)))
			)
			(maidCart init:)
			(= global189 0)
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

	(method (doit &tmp temp0)
		(cond
			(script)
			((stairTrigger onMe: (gEgo x:) (gEgo y:))
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
		noun 7
		sightAngle 10
		approachX 210
		approachY 83
		x 200
		y 51
	)

	(method (init)
		(self
			setPolygon:
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

(instance stairs of Feature
	(properties
		noun 14
		sightAngle 10
		approachX 55
		approachY 98
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 31 41 60 39 58 85 32 95 yourself:)
		)
		(super init:)
	)
)

(instance lPlant of Feature
	(properties
		noun 11
		sightAngle 10
		approachX 55
		approachY 98
		x 53
		y 13
	)

	(method (init)
		(self
			setPolygon:
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
		noun 19
		sightAngle 10
		approachX 118
		approachY 74
		x 148
		y 11
	)

	(method (init)
		(self
			setPolygon:
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
		noun 11
		sightAngle 10
		approachX 210
		approachY 83
		x 210
		y 12
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 238 0 240 11 228 16 231 27 216 22 190 31 184 21 190 17 182 10 181 0
					yourself:
				)
		)
		(super init:)
	)

	(method (doVerb theVerb &tmp temp0)
		(if (and (== theVerb 4) (not (-- local0))) ; Do
			(gEgo get: 22 7) ; roomkey
			((gInventory at: 17) owner: 590) ; gown
			(ClearFlag 24)
			(SetFlag 240)
			(SetFlag 68)
			(while (== (= temp0 (Random 1 61)) 9)
			)
			(DoAudio audPLAY 611 1 4 temp0 1)
			(Print
				width: 160
				font: gUserFont
				addTitle: {Carlos, are you cheating again?}
				addText: 1 4 temp0 1 50 1 611
				fore: 67
				addText: {Shablee has the gown and you can get condom.} 50 17
				fore: 0
				addIcon: 1592 1 0 0 0
				init:
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance elevatorDoors of Prop
	(properties
		noun 6
		sightAngle 10
		approachX 210
		approachY 83
		x 207
		y 70
		priority 70
		fixPriority 1
		view 602
		loop 1
	)
)

(instance elevatorIndicator of Prop
	(properties
		noun 5
		sightAngle 10
		approachX 210
		approachY 83
		x 217
		y 31
		priority 90
		fixPriority 1
		view 602
		cel 9
		signal 26657
	)
)

(instance iceMachine of Prop
	(properties
		noun 10
		sightAngle 10
		approachX 199
		approachY 104
		x 269
		y 90
		priority 90
		fixPriority 1
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
		noun 11
		sightAngle 10
		approachX 295
		approachY 107
		x 291
		y 19
	)

	(method (init)
		(self
			setPolygon:
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
		noun 4
		sightAngle 10
		approachX 293
		approachY 106
		x 283
		y 91
		priority 91
		fixPriority 1
		view 602
		loop 2
		signal 26657
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
		noun 2
		sightAngle 10
		approachX 150
		approachY 125
		x 169
		y 82
		priority 80
		fixPriority 1
		view 607
		signal 26657
	)

	(method (doVerb theVerb)
		(cond
			((!= theVerb 1) ; Look
				(super doVerb: theVerb)
			)
			((> gMouseX 153)
				(gCurRoom setScript: insetScr 0 1)
			)
			(else
				(gCurRoom setScript: insetScr 0 2)
			)
		)
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
				(gEgo normalize: 900 0 1)
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
				(sfx number: 33 loop: 1 play:)
				(larryDoor view: 602)
				(gEgo setHeading: 180 self)
			)
			(5
				(gEgo normalize: 900 2 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance iceMachineTimer of Timer
	(properties)

	(method (cue)
		(if
			(and
				(not (localproc_1))
				(not (or (gTalkers size:) (Print dialog:)))
			)
			(switch (++ local1)
				(1
					(iceShaking number: 605 loop: -1 play:)
					(iceMachine view: 601 setLoop: 0 setCycle: Fwd)
					(self setReal: self 3)
				)
				(2
					(if (and (not (proc79_14)) (not (IsFlag 63)))
						(gGame handsOff:)
						(gEgo ignoreActors: 1)
						(Face gEgo iceMachine self)
					else
						(= local1 4)
						(self cue:)
					)
				)
				(3
					(self setReal: self 2)
				)
				(4
					(SetFlag 63)
					(gMessager say: 10 1 3 0 self) ; "(Let the chips fall where they may!)"
				)
				(5
					(gEgo ignoreActors: 0)
					(iceShaking stop:)
					(sfx number: 604 loop: 1 play:)
					(iceMachine view: 602 setLoop: 3 setCycle: 0)
					(gGame handsOn:)
				)
			)
		else
			(self setReal: self 3)
		)
	)
)

(instance theToiletPaper of Feature
	(properties
		noun 17
		y 6
	)

	(method (init)
		(self
			setPolygon:
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
		noun 3
		y 6
	)

	(method (init)
		(self
			setPolygon:
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

(instance sfx of Sound
	(properties
		flags 5
	)
)

(instance iceShaking of Sound
	(properties
		flags 5
		loop -1
	)
)

(instance downStairsScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 20 94 self setPri: 80 setLoop: 7)
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
		x 144
		y 0
		noun 1
	)

	(method (init)
		(self picture: -2 priority: 200)
		(super init: &rest)
		(theFloss init:)
		(theSeatCovers init:)
		(theTowels init:)
		(UpdatePlane plane)
		(FrameOut)
	)

	(method (dispose)
		(theSeatCovers dispose:)
		(theTowels dispose:)
		(theFloss dispose:)
		(super dispose:)
	)

	(method (doVerb theVerb)
		(cond
			((not (OneOf theVerb 4 1 2 5 6)) ; Do, Look, Talk, Take, Zipper
				(gMessager say: noun 15) ; "No, you can't put your stuff on the maid's cart."
			)
			(((theTowels onMeCheck:) onMe: gMouseX gMouseY)
				(theTowels doVerb: theVerb)
			)
			(((theSeatCovers onMeCheck:) onMe: gMouseX gMouseY)
				(theSeatCovers doVerb: theVerb)
			)
			(((theFloss onMeCheck:) onMe: gMouseX gMouseY)
				(theFloss doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance frontInset of Inset
	(properties
		view 605
		x 0
		y 2
		noun 9
	)

	(method (init)
		(self priority: 200 picture: -2)
		(super init: &rest)
		(theToiletPaper init:)
		(theSoap init:)
		(theWashCloths init:)
		(theLotion init:)
		(UpdatePlane plane)
		(FrameOut)
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
				(gEgo setMotion: MoveTo 189 78 self)
			)
			(2
				(gEgo view: 901 setLoop: 7 setCel: 0 setCycle: CT 3 1 self)
			)
			(3
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
				(gEgo normalize: 900 3 1 setHeading: 180 self)
			)
			(7
				(gEgo setMotion: MoveTo 198 86 self)
			)
			(8
				(gEgo normalize: 900 2 1)
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
					(sfx number: 34 loop: 1 play: self)
				else
					(+= state 2)
					(= cycles 2)
				)
			)
			(4
				(gMessager say: 4 4 0 0 self) ; "Like every other guest room in the hotel, this door requires a key."
			)
			(5
				(gEgo normalize: 900 3 1)
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
					setMotion: MoveTo 318 104 self
				)
				(gGlobalSound2 fade: 0 10 10 0)
			)
			(9
				(gEgo setCycle: 0 hide:)
				(= ticks 120)
			)
			(10
				(gGlobalSound2 pause: 1)
				(= cycles 2)
			)
			(11
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
				(gEgo view: 603 setLoop: 0 cel: 0)
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
				(gEgo normalize: 900 0 1)
				(iceMachine setLoop: 0 setCycle: End self)
			)
			(12
				(iceShaking stop:)
				(iceMachine view: 602 setLoop: 3)
				((gInventory at: 7) cue: 32768) ; champagne
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
				(elevatorIndicator cel: register)
				(= ticks 30)
			)
			(2
				(sfx number: 602 loop: 1 play:)
				(= ticks 90)
			)
			(3
				(sfx number: 600 loop: 1 play:)
				(elevatorDoors cycleSpeed: 4 setCycle: CT 2 1 self)
			)
			(4
				(gGlobalSound2 fade: 127 10 10 0)
				(elevatorDoors setCycle: End self)
			)
			(5
				(gEgo setLoop: 5 setPri: -1 setMotion: MoveTo 206 86 self)
			)
			(6
				(gEgo setHeading: 180)
				(= ticks 30)
			)
			(7
				(elevatorDoors setCycle: Beg self)
				(sfx number: 601 loop: 1 play:)
			)
			(8
				(elevatorIndicator
					cycleSpeed: 60
					setCycle: End elevatorIndicator
				)
				(elevatorDoors view: 602)
				(gEgo normalize: 900 2 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance theFloss of Feature
	(properties
		noun 8
		x 258
		y 80
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 240 74 267 69 276 80 241 86
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
		noun 15
		x 223
		y 74
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 205 59 206 78 240 87 239 74 254 71 252 58
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
		noun 16
		x 224
		y 98
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 190 78 200 101 240 116 235 86
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

(instance theSoap of Feature
	(properties
		noun 13
		y 6
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 83 57 105 64 83 68 83 59
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
		noun 18
		y 6
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 65 66 66 62 75 58 82 61 82 66 77 70
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

(instance insetScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(switch register
					(1
						(gEgo setMotion: PolyPath 168 85 self)
					)
					(2
						(gEgo setMotion: PolyPath 116 76 self)
					)
				)
			)
			(1
				(switch register
					(1
						(gEgo setHeading: 310 self)
					)
					(2
						(gEgo setHeading: 125 self)
					)
				)
			)
			(2
				(= cycles 2)
			)
			(3
				(SetFlag 86)
				(gGraphMenuBar state: (| (gGraphMenuBar state:) $0004))
				(switch register
					(1
						(gCurRoom setInset: frontInset)
					)
					(2
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
				(ClearFlag 86)
				(gGraphMenuBar state: (& (gGraphMenuBar state:) $fffb))
				((gCurRoom inset:) dispose:)
				(gCurRoom drawPic: 600 0)
				(maidCart init:)
				((ScriptID 0 11) dispose:) ; iconExit
				(= register 0)
				(self dispose:)
			)
		)
	)
)

