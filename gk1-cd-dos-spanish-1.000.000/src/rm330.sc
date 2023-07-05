;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 330)
(include sci.sh)
(use Main)
(use n013)
(use Scaler)
(use Osc)
(use PolyPath)
(use Polygon)
(use Feature)
(use StopWalk)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm330 0
)

(local
	local0
	local1
	local2 = 5
	local3
	local4
	local5 = 2
	local6 = 4
	local7
	local8
)

(instance rm330 of Room
	(properties
		noun 1
		picture 330
		style 14
		exitStyle 13
	)

	(method (init)
		(super init:)
		(Load rsMESSAGE 330)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 0 145 110 146 46 135 75 130 90 122 158 103 168 93 190 97 253 97 253 96 192 96 192 89 166 91 166 93 150 104 53 125 0 136
					yourself:
				)
		)
		(gEgo
			view: 900
			setCel: 0
			setLoop: 0
			setCycle: StopWalk -1
			signal: (| (gEgo signal:) $1000)
			init:
			state: 2
			ignoreActors: 1
			scaleSignal: (| (gEgo scaleSignal:) $0004)
			setScaler: Scaler 100 56 130 107
			posn: 25 134
		)
		(bullBoard init:)
		(smallDoor init:)
		(exitSign init:)
		(podium init:)
		(projectorDoors init:)
		(screen init:)
		(seats init:)
		(speaker init:)
		(stage init:)
		(doors init:)
		(gGkMusic1
			number: 330
			setLoop: -1
			play:
			setVol: 0
			fade: (gGkMusic1 musicVolume:) 25 10 0
		)
		(cond
			((== gPrevRoomNum 331)
				(gEgo
					view: 3350
					setLoop: 0
					setCel: 11
					setCycle: 0
					posn: 80 131
				)
				(UpdateScreenItem gEgo)
				(hartrige init: setScript: hartLeaveRoom)
				(UpdateScreenItem hartrige)
				(femaleStudent init:)
				(maleStudent init:)
				(gCurRoom setScript: maleStudentLeave)
				(gEgo setScript: femaleStudentLeave)
				(= local4 1)
			)
			((== gPrevRoomNum 340)
				(gEgo posn: 181 91 show:)
			)
			((not (IsFlag 46))
				(hartrige init:)
				(gEgo setScript: attendLecture)
			)
			(else
				(gCurRoom setScript: egoEnters)
			)
		)
		(gWalkHandler add: self)
		(gWalkHandler add: projectorDoors)
	)

	(method (dispose)
		(gGkMusic1 fade:)
		(if (and (IsFlag 224) (!= gNewRoomNum 340))
			(SetFlag 32)
		)
		(gEgo scaleSignal: (& $fffb (gEgo scaleSignal:)) setScale: 0)
		(gWalkHandler delete: self)
		(gWalkHandler delete: projectorDoors)
		(DisposeScript 64935)
		(DisposeScript 64939)
		(if (== gNewRoomNum 331)
			(PalVary 3) ; PalVaryKill
		)
		(super dispose:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(13 ; Walk
				(if local4
					(gEgo setScript: standUp)
					(return 1)
				else
					(super doVerb: theVerb)
				)
			)
			(6 ; Open
				(if local4
					(gEgo setScript: standUp)
					(return 1)
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

(instance egoEnters of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gGkSound1 number: 232 loop: 1 play:)
				(hartDoor init: setCel: 0 setCycle: End self)
			)
			(1
				(hartDoor dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sitDown of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 68 131 self)
			)
			(1
				(gEgo
					view: 335
					setCel: 0
					setLoop: 0
					posn: 80 131
					setCycle: End self
				)
			)
			(2
				(gGame handsOn:)
				(= local4 1)
				(self dispose:)
			)
		)
	)
)

(instance standUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setCycle: Beg self)
			)
			(1
				(gGame handsOn:)
				(= local4 0)
				(gEgo
					normalize: 6 900
					posn: 68 131
					setScaler: Scaler 100 56 130 107
					ignoreActors: 1
				)
				(self dispose:)
			)
		)
	)
)

(instance hartrigeDoStuff of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(hartrige
					view: 330
					setCel: 0
					setLoop: (Random 1 4)
					setCycle: End self
				)
			)
			(1
				(= seconds (Random 4 6))
			)
			(2
				(if local5
					(-- local5)
					(self changeState: 0)
				else
					(hartrige view: 331 setCel: 0 setLoop: 0 setCycle: End self)
				)
			)
			(3
				(hartrige
					view: 332
					setCel: 0
					setLoop: 0
					posn: 220 92
					xStep: 1
					setCycle: Walk
					setMotion: MoveTo 253 92 self
				)
			)
			(4
				(hartrige view: 333 setCel: 0 setLoop: 0 setCycle: End self)
			)
			(5
				(hartrige view: 334 setCel: 0 setLoop: 2 setCycle: End self)
			)
			(6
				(hartrige
					view: 332
					setCel: 0
					setLoop: 0
					posn: 248 92
					xStep: 1
					setCycle: Walk
					setMotion: MoveTo 220 92 self
				)
			)
			(7
				(hartrige
					view: 331
					setCel: 0
					setLoop: 1
					posn: 209 92
					setCycle: End self
				)
			)
			(8
				(= local5 4)
				(self init:)
			)
		)
	)
)

(instance attendLecture of Script
	(properties)

	(method (handleEvent event)
		(super handleEvent: event &rest)
		(if (and (== (event type:) evKEYBOARD) (== (event message:) KEY_SPACE) (SkipSceneDialog))
			(gMessager caller: 0)
			(gMessager killed: 1)
			(if (gEgo cycler:)
				(gEgo setCycle: 0)
				(gEgo setMotion: 0)
			)
			(self changeState: 99)
			(return 1)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gKeyDownHandler add: self)
				(PalVary 8 330) ; PalVaryNewSource
				(gGame handsOff:)
				(gGkSound1 number: 232 loop: 1 play:)
				(gEgo
					view: 335
					setCel: 0
					setLoop: 1
					posn: 24 130
					cycleSpeed: 10
					setCycle: End self
				)
				(gEgo getPoints: -999 2)
				(= local4 1)
				(hartrige setCycle: End)
				(slides init: setCel: local7 setScript: changeTheSlide)
				(guy1 init: setScript: randAudienceMovements)
				(Load rsPALETTE 3301)
				(leftLightPiece init:)
				(middleLightPiece init:)
				(rightLightPiece init:)
				(darkScreen init:)
			)
			(1
				(gEgo
					view: 3352
					setLoop: 0 1
					setCel: 1
					setCycle: Walk
					setSpeed: 6
					setMotion: MoveTo 68 131 self
				)
			)
			(2
				(gEgo
					view: 335
					setCel: 0
					setLoop: 0 1
					posn: 80 131
					setCycle: End self
				)
				(gMessager sayRange: 12 0 1 1 2 self) ; "It looks like the lecture is just starting. Gabriel decides to record the session."
			)
			(3)
			(4
				(++ local7)
				(changeTheSlide cue:)
				(hartrige loop: 1 cel: 0 setCycle: End self)
			)
			(5
				(gMessager say: 12 0 1 3 self) ; "The word Voudoun may sound familiar to you. What is known in the States as 'Voodoo' is actually an amalgamation of African religious systems, Voudoun, and European religions, primarily Catholicism."
			)
			(6
				(Load rsVIEW 330)
				(Load rsVIEW 331)
				(Load rsVIEW 333)
				(Load rsVIEW 332)
				(hartrige setScript: hartrigeDoStuff)
				(= cycles 1)
			)
			(7
				(if (OneOf local6 9 10 15 17 18 21 22 23 24 26 27 29 30)
					(++ local7)
				)
				(if (not (== local8 local7))
					(changeTheSlide cue:)
					(= ticks 120)
				else
					(= cycles 1)
				)
			)
			(8
				(gMessager say: 12 0 1 local6 self)
			)
			(9
				(if (>= local6 34)
					(self cue:)
				else
					(++ local6)
					(self changeState: (- (self state:) 2))
				)
			)
			(10
				(SetFlag 46)
				(SetFlag 45)
				(gGame handsOn:)
				(hartrigeDoStuff dispose:)
				(gKeyDownHandler delete: self)
				(gCurRoom exitStyle: 0)
				(gCurRoom newRoom: 331)
			)
			(99
				(if (gTalkers size:)
					(gMessager cue: 1)
				)
				(gKeyDownHandler delete: self)
				(for ((= local0 100)) (>= local0 0) ((-= local0 1))
					(Palette 2 0 255 local0) ; PalIntensity
				)
				(= cycles 1)
			)
			(100
				(SetFlag 45)
				(SetFlag 46)
				(hartrigeDoStuff dispose:)
				(changeTheSlide dispose:)
				(randAudienceMovements dispose:)
				(hartrige dispose:)
				(slides dispose:)
				(guy1 dispose:)
				(guy2 dispose:)
				(guy3 dispose:)
				(guy4 dispose:)
				(guy5 dispose:)
				(leftLightPiece dispose:)
				(middleLightPiece dispose:)
				(rightLightPiece dispose:)
				(darkScreen dispose:)
				(= cycles 2)
			)
			(101
				(gEgo
					view: 3350
					setLoop: 0 1
					setCel: 11
					setCycle: 0
					posn: 80 131
				)
				(= cycles 2)
			)
			(102
				(PalVary 3) ; PalVaryKill
				(for ((= local0 0)) (<= local0 100) ((+= local0 1))
					(Palette 2 0 255 local0) ; PalIntensity
				)
				(= cycles 1)
			)
			(103
				(self dispose:)
				(gGame handsOn:)
			)
		)
	)
)

(instance goToTheOffice of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if local4
					(self setScript: standUp self)
				else
					(self cue:)
				)
			)
			(1
				(gGame handsOff:)
				(if (<= (gEgo y:) 108)
					(= local3 1)
					(gEgo setMotion: PolyPath 165 91 self)
				else
					(gEgo setMotion: PolyPath 153 111 self)
				)
			)
			(2
				(if local3
					(self cue:)
				else
					(gEgo
						view: 3391
						setCel: 0
						setLoop: 0
						posn: 165 91
						setScale: 0
						setCycle: End self
					)
				)
			)
			(3
				(gEgo
					view: 3391
					setCel: 0
					setLoop: 1
					posn: 165 91
					setScale: 0
					setCycle: End self
				)
			)
			(4
				(if (>= gDay 6)
					(gMessager say: 3 6 12 0 self) ; "The door to Hartridge's office is locked."
				else
					(gGkSound1 number: 373 setLoop: 1 play:)
					(gEgo setCel: 0 setLoop: 2 setCycle: End self)
				)
			)
			(5
				(if (>= gDay 6)
					(gEgo normalize: 7 900 setScaler: Scaler 100 56 130 107)
					(gGame handsOn:)
				else
					(gCurRoom newRoom: 340)
				)
			)
		)
	)
)

(instance changeTheSlide of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0)
			(1
				(slides hide:)
				(PalVary 8 3301) ; PalVaryNewSource
				(gGkSound1 number: 331 setLoop: 1 play:)
				(= seconds 2)
			)
			(2
				(slides setCel: local7 show:)
				(PalVary 8 330) ; PalVaryNewSource
				(= local8 local7)
				(= cycles 1)
			)
			(3
				(self changeState: 0)
			)
		)
	)
)

(instance randAudienceMovements of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(guy2 init:)
				(guy3 init:)
				(guy4 init:)
				(guy5 init:)
				(self cue:)
			)
			(1
				(switch (= local1 (Random 0 4))
					(0
						(guy1 setCycle: Osc 1 self)
					)
					(1
						(guy2 setCycle: Osc 1 self)
					)
					(2
						(guy3 setCycle: Osc 1 self)
					)
					(3
						(guy4 setCycle: Osc 1 self)
					)
					(4
						(guy5 setCycle: Osc 1 self)
					)
				)
			)
			(2
				(= seconds 3)
			)
			(3
				(self changeState: 1)
			)
		)
	)
)

(instance maleStudentLeave of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(maleStudent setCycle: End self)
				(gMessager say: 12 0 2 10) ; "(JUST WAKING UP. STILL SHOOK)Oh, my God. Sorry."
			)
			(1
				(gGkSound1 number: 232 loop: 1 play:)
				(maleStudent
					setCel: 0
					setLoop: 1
					posn: 9 127
					setCycle: End self
				)
			)
			(2
				(maleStudent dispose:)
				(hartDoor init: setCycle: End self)
			)
			(3
				(hartDoor dispose:)
				(self dispose:)
			)
		)
	)
)

(instance femaleStudentLeave of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(femaleStudent
					setLoop: 0 1
					setCycle: Walk
					setMotion: MoveTo 18 132 self
				)
			)
			(1
				(gGkSound1 number: 232 loop: 1 play:)
				(femaleStudent
					setScale: 0
					setCel: 0
					setLoop: 1
					posn: 9 127
					setCycle: End self
				)
			)
			(2
				(femaleStudent dispose:)
				(hartDoor setCel: 0 init: setCycle: End self)
			)
			(3
				(hartDoor dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance hartLeaveRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(hartrige view: 337 setCycle: End self)
			)
			(1
				(hartrige
					setCel: 0
					setLoop: 1 1
					posn: 204 91
					setPri: 4
					setCycle: Walk
					setMotion: MoveTo 170 91 self
				)
			)
			(2
				(gGkSound1 number: 373 setLoop: 1 play:)
				(hartrige setCel: 0 setLoop: 2 posn: 165 91 setCycle: End self)
			)
			(3
				(gGkSound1 number: 374 setLoop: 1 play:)
				(hartrige dispose:)
				(self dispose:)
			)
		)
	)
)

(instance leaveRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if local4
					(self setScript: standUp self)
				else
					(self cue:)
				)
			)
			(1
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 28 134 self)
			)
			(2
				(gGkSound1 number: 232 loop: 1 play:)
				(gEgo
					setScale: 0
					view: 3351
					setCel: 0
					setLoop: 0
					posn: 10 127
					setCycle: End self
				)
			)
			(3
				(if (and (IsFlag 224) (not (IsFlag 32)))
					(hartDoor init: setCycle: End self)
				else
					(self cue:)
				)
			)
			(4
				(if (and (IsFlag 224) (not (IsFlag 32)))
					(gMessager say: 2 6 4 0 self) ; "Before leaving the university, Gabriel notifies campus security about Hartridge's body."
				else
					(self cue:)
				)
			)
			(5
				(gCurRoom newRoom: 205)
			)
		)
	)
)

(instance lookAtBoard of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if local4
					(self setScript: standUp self)
				else
					(self cue:)
				)
			)
			(1
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 53 127 self)
			)
			(2
				(Face gEgo bullBoard self)
			)
			(3
				(gMessager say: 6 7 0 0 self) ; "Gabriel scans the bulletin board:"
			)
			(4
				(gMessager say: 6 7 local2 0 self)
				(if (== local2 11)
					(= local2 5)
				else
					(++ local2)
				)
			)
			(5
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance hartrige of Actor
	(properties
		x 209
		y 92
		view 330
	)
)

(instance femaleStudent of Actor
	(properties
		x 105
		y 118
		view 3362
		signal 16417
	)

	(method (init)
		(self setScaler: Scaler 100 56 130 107)
		(super init:)
	)
)

(instance guy1 of Prop
	(properties
		x 126
		y 110
		view 336
	)
)

(instance guy2 of Prop
	(properties
		x 161
		y 130
		view 336
		loop 1
	)
)

(instance guy3 of Prop
	(properties
		x 115
		y 121
		view 336
		loop 2
	)
)

(instance guy4 of Prop
	(properties
		x 203
		y 129
		view 336
		loop 3
	)
)

(instance guy5 of Prop
	(properties
		x 135
		y 126
		view 336
		loop 4
	)
)

(instance slides of Prop
	(properties
		x 265
		y 52
		view 339
	)
)

(instance maleStudent of Prop
	(properties
		x 7
		y 127
		view 3361
	)
)

(instance hartDoor of Prop
	(properties
		x 9
		y 127
		view 3363
		signal 16417
	)
)

(instance leftLightPiece of View
	(properties
		x 78
		y 57
		view 338
	)
)

(instance middleLightPiece of View
	(properties
		x 116
		y 59
		view 338
		cel 1
	)
)

(instance rightLightPiece of View
	(properties
		x 155
		y 59
		view 338
		cel 2
	)
)

(instance darkScreen of View
	(properties
		x 197
		y 22
		view 339
		loop 1
	)
)

(instance bullBoard of Feature
	(properties
		noun 6
		sightAngle 20
		x 49
		y 78
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 29 62 64 62 63 97 29 99 yourself:)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Look
				(gEgo setScript: lookAtBoard)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance smallDoor of Feature
	(properties
		noun 3
		sightAngle 20
		x 166
		y 68
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 160 59 174 58 174 90 161 91
					yourself:
				)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6 ; Open
				(gEgo setScript: goToTheOffice)
			)
			(8 ; Operate
				(gEgo setScript: goToTheOffice)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance exitSign of Feature
	(properties
		noun 11
		sightAngle 20
		x 6
		y 51
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 0 44 13 45 13 55 0 55 yourself:)
		)
		(super init:)
	)
)

(instance podium of Feature
	(properties
		noun 4
		sightAngle 20
		x 97
		y 205
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 200 75 216 75 215 95 200 95
					yourself:
				)
		)
		(super init:)
	)
)

(instance projectorDoors of Feature
	(properties
		noun 9
		sightAngle 20
		x 310
		y 142
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 259 145 260 75 319 75 319 145
					yourself:
				)
		)
		(super init:)
	)
)

(instance screen of Feature
	(properties
		noun 8
		sightAngle 20
		x 260
		y 29
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 197 21 319 21 319 81 198 81
					yourself:
				)
		)
		(super init:)
	)
)

(instance seats of Feature
	(properties
		noun 7
		sightAngle 20
		x 219
		y 111
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 148 100 198 104 260 104 259 126 158 122 70 114
					yourself:
				)
		)
		(super init:)
	)
)

(instance speaker of Feature
	(properties
		noun 5
		sightAngle 20
		x 141
		y 41
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 133 33 145 33 145 51 133 51
					yourself:
				)
		)
		(super init:)
	)
)

(instance stage of Feature
	(properties
		noun 10
		sightAngle 20
		x 235
		y 96
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 183 90 259 91 259 105 167 102
					yourself:
				)
		)
		(super init:)
	)
)

(instance doors of Feature
	(properties
		noun 2
		nsTop 64
		nsRight 17
		nsBottom 126
		sightAngle 20
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6 ; Open
				(gEgo setScript: leaveRoom)
			)
			(8 ; Operate
				(gEgo setScript: leaveRoom)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

