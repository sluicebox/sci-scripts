;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 500)
(include sci.sh)
(use Main)
(use SQRoom)
(use Styler)
(use Inset)
(use Polygon)
(use Feature)
(use Rev)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm500 0
)

(local
	local0
	local1 = 1
)

(procedure (localproc_0 param1 param2)
	(if param1
		(if (> param1 0)
			(dirLight setCel: 1)
		else
			(dirLight setCel: 2)
		)
		(movement cycleSpeed: param2 setCycle: (if (> param1 0) Fwd else Rev))
		(PalCycle 0 128 132 param1 param2) ; Start
	else
		(dirLight setCel: 0)
		(movement setCycle: 0)
		(PalCycle 4) ; Off
	)
)

(instance rm500 of SQRoom
	(properties
		noun 1
		picture 500
	)

	(method (init)
		(gEgo init: normalize: 2)
		(super init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 119 100 119 104 201 104 201 100
					yourself:
				)
		)
		(if (not (and (== gPrevRoomNum 520) (== global120 1)))
			(gGSound1 number: 500 loop: -1 play:)
		)
		(switch gPrevRoomNum
			(480
				(= local0 0)
				(gEgo posn: 91 99)
			)
			(510
				(= local0 2)
				(gEgo posn: 228 103)
			)
			(520
				(= local0 1)
				(if (== global120 1)
					(gEgo view: 502 loop: 0 cel: 0 posn: 183 102)
				else
					(gEgo posn: 228 103)
				)
			)
			(else
				(= local0 0)
				(gEgo posn: 131 104)
			)
		)
		(if (and (== gPrevRoomNum 520) (== global120 1))
			(Load 140 508 509) ; WAVE
		)
		(elevatorButtons init: approachVerbs: 4 1) ; Do, Look
		(littleBox init: approachVerbs: 4) ; Do
		(wires init:)
		(platform init:)
		(shaftTube1 init:)
		(shaftTube2 init:)
		(stuffOnTop init:)
		(ceiling init:)
		(insideElevator init:)
		(shuttlePort init:)
		(roomPort init:)
		(leftLights init:)
		(rightLights init:)
		(hydrolics init:)
		(leftExit init:)
		(rightExit init:)
		(locationName init: setCel: local0)
		(dirLight init:)
		(cond
			(
				(or
					(and (== gPrevRoomNum 520) (== global120 1))
					(and (== local0 0) (== global120 1))
				)
				(hatchClosed init:)
				(shaftClosed init:)
			)
			((!= local0 0)
				(hatchClosed init:)
				(shaftOpen init:)
			)
			(else
				(hatchOpen init:)
				(shaftClosed init:)
			)
		)
		(movement init:)
		(switch gPrevRoomNum
			(480
				(gCurRoom setScript: sEnterFromHatch)
			)
			(510
				(gCurRoom setScript: sEnterFromShaft)
			)
			(520
				(if (== global120 1)
					(gCurRoom setScript: sEndChapter1)
				else
					(gCurRoom setScript: sEnterFromShaft)
				)
			)
			(else
				(gGame handsOn:)
			)
		)
	)

	(method (cue)
		(= local1 1)
	)

	(method (doit)
		(super doit:)
		(cond
			(script)
			((and (gFeatures contains: hatchOpen) (leftExit onMe: gEgo))
				(gCurRoom setScript: sExitLeft)
			)
			((and (gFeatures contains: shaftOpen) (rightExit onMe: gEgo))
				(gCurRoom setScript: sExitRight)
			)
		)
	)

	(method (dispose)
		(gGSound1 fade:)
		(super dispose:)
	)
)

(instance sUseShaft of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(sfxButton play: self)
			)
			(1
				(inButtonCloseup dispose:)
				(cond
					(
						(or
							(and (== local0 0) (== global120 1))
							(and (== global120 2) (== local0 1))
						)
						0
					)
					((== local0 0)
						(hatchOpen dispose:)
						(hatchClosed init:)
					)
					(else
						(shaftOpen dispose:)
						(shaftClosed init:)
					)
				)
				(gEgo posn: (- (gEgo x:) 12) (gEgo y:) setHeading: 180)
				(gGSound2 number: 507 setVol: 127 loop: -1 play:)
				(locationName hide:)
				(if (> register 0)
					(localproc_0 1 10)
				else
					(localproc_0 -1 10)
				)
				(= ticks 45)
			)
			(2
				(if (> register 0)
					(localproc_0 1 8)
				else
					(localproc_0 -1 8)
				)
				(= ticks 45)
			)
			(3
				(if (> register 0)
					(localproc_0 1 5)
				else
					(localproc_0 -1 5)
				)
				(= ticks 90)
			)
			(4
				(if (> register 0)
					(localproc_0 1 2)
				else
					(localproc_0 -1 2)
				)
				(= ticks (* 180 (Abs register)))
			)
			(5
				(if (> register 0)
					(localproc_0 1 5)
				else
					(localproc_0 -1 5)
				)
				(= ticks 80)
			)
			(6
				(if (> register 0)
					(localproc_0 1 8)
				else
					(localproc_0 -1 8)
				)
				(= ticks 35)
			)
			(7
				(if (> register 0)
					(localproc_0 1 10)
				else
					(localproc_0 -1 10)
				)
				(= ticks 35)
			)
			(8
				(localproc_0 0)
				(gGSound2 stop:)
				(+= local0 register)
				(locationName setCel: local0 show:)
				(cond
					(
						(or
							(and (== local0 0) (== global120 1))
							(and (== global120 2) (== local0 1))
						)
						(if (gFeatures contains: hatchOpen)
							(hatchOpen dispose:)
							(hatchClosed init:)
						)
						(if (gFeatures contains: shaftOpen)
							(shaftOpen dispose:)
							(shaftClosed init:)
						)
					)
					((== local0 0)
						(if (gCast contains: hatchClosed)
							(hatchClosed dispose:)
							(hatchOpen init:)
						)
						(if (gFeatures contains: shaftOpen)
							(shaftOpen dispose:)
							(shaftClosed init:)
						)
					)
					(else
						(if (gCast contains: shaftClosed)
							(shaftClosed dispose:)
							(shaftOpen init:)
						)
						(if (gFeatures contains: hatchOpen)
							(hatchOpen dispose:)
							(hatchClosed init:)
						)
					)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sExitLeft of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 91 99 self)
			)
			(1
				(= global148 500)
				(gCurRoom newRoom: 480)
				(self dispose:)
			)
		)
	)
)

(instance sExitRight of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 228 103 self)
			)
			(1
				(switch local0
					(1
						(gCurRoom newRoom: 520)
					)
					(2
						(gCurRoom newRoom: 510)
					)
				)
				(self dispose:)
			)
		)
	)
)

(instance sEnterFromHatch of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 120 102 self)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sEnterFromShaft of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 199 101 self)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sEndChapter1 of Script
	(properties)

	(method (doit)
		(super doit:)
		(if
			(and
				(gTalkers isEmpty:)
				local1
				(== (gEgo loop:) 2)
				(OneOf (gEgo cel:) 0 2)
			)
			(= local1 0)
			(sFXPound play: gCurRoom)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 3)
			)
			(1
				(= ticks 120)
			)
			(2
				(gMessager say: 0 0 4 1 self) ; "Just as you crash to the floor of the Turboshaft, the HydroRiser piston gives way and the door slams shut -- with Stellar still trapped inside."
				(gEgo setSpeed: 9 setCycle: End)
			)
			(3
				(gEgo loop: 1 cel: 0 setCycle: End self)
			)
			(4
				(gEgo
					loop: 2
					cel: 0
					posn: 193 100
					setSpeed: 12
					setCycle: Fwd
				)
				(= ticks 120)
			)
			(5
				(gMessager say: 0 0 4 2 self) ; "You claw and pull at the seams of the bulkhead door, but to no avail. Just then, you hear and feel an explosion which seems to have come from behind the door."
			)
			(6
				(= local1 0)
				(gGSound2 number: 508 loop: 1 play: self)
				(ShakePlane gThePlane 2 12 4)
			)
			(7
				(= local1 1)
				(= ticks 120)
			)
			(8
				(gMessager say: 0 0 4 3 self) ; "The door is sealed tight. You can hear no other noise after the ear-ringing from the blast subsides."
				(gEgo setCycle: End)
			)
			(9
				(gEgo
					view: 503
					loop: 0
					cel: 0
					setSpeed: 8
					setCycle: End self
				)
			)
			(10
				(gMessager sayRange: 0 0 4 4 5 self) ; "My God! I can't believe this. It can't be happening!"
			)
			(11
				(gEgo loop: 1 cel: 0 setCycle: End)
				(gMessager say: 0 0 4 6 self) ; "S T E L L A R !!!"
			)
			(12
				(= global120 2)
				(Styler changeDivisions: 1400)
				(gCurRoom newRoom: 410)
				(self dispose:)
			)
		)
	)
)

(instance movement of Prop
	(properties
		x 43
		y 3
		view 504
	)
)

(instance hatchClosed of View
	(properties
		noun 15
		case 1
		x 103
		y 36
		view 500
		loop 3
	)
)

(instance locationName of View
	(properties
		noun 14
		x 135
		y 39
		view 500
	)
)

(instance shaftClosed of View
	(properties
		noun 16
		case 1
		x 210
		y 35
		view 500
		loop 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (and (== global120 2) (== local0 1))
					(gMessager say: noun theVerb 5) ; "Apparently, the door's been sealed off since the explosion."
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

(instance dirLight of View
	(properties
		noun 17
		x 158
		y 55
		view 500
		loop 1
	)
)

(instance leftExit of Feature
	(properties)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PNearestAccess
					init: 115 107 115 96 119 96 119 107
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance rightExit of Feature
	(properties)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PNearestAccess
					init: 200 96 200 107 204 107 204 96
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance elevatorButtons of Feature
	(properties
		noun 18
		nsLeft 154
		nsTop 62
		nsRight 166
		nsBottom 78
		sightAngle 40
		approachX 159
		approachY 100
		x 161
		y 70
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setInset: inButtonCloseup)
			)
			(1 ; Look
				(gCurRoom setInset: inButtonCloseup)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance littleBox of Feature
	(properties
		noun 2
		nsLeft 154
		nsTop 82
		nsRight 159
		nsBottom 88
		sightAngle 40
		approachX 159
		approachY 100
		x 157
		y 85
	)
)

(instance wires of Feature
	(properties
		noun 4
		nsLeft 142
		nsTop 113
		nsRight 179
		nsBottom 137
		sightAngle 40
		x 162
		y 122
	)
)

(instance platform of Feature
	(properties
		noun 5
		sightAngle 40
		x 161
		y 102
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 99 106 112 98 208 98 221 106
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance shaftTube1 of Feature
	(properties
		noun 6
		nsLeft 82
		nsRight 90
		nsBottom 138
		sightAngle 40
		x 87
		y 68
	)
)

(instance shaftTube2 of Feature
	(properties
		noun 6
		nsLeft 231
		nsRight 237
		nsBottom 138
		sightAngle 40
		x 234
		y 68
	)
)

(instance stuffOnTop of Feature
	(properties
		noun 7
		sightAngle 40
		x 162
		y 16
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 102 28 102 21 107 21 109 12 130 12 130 7 143 7 145 9 175 9 175 0 190 0 191 10 212 10 212 20 219 20 219 28
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance ceiling of Feature
	(properties
		noun 8
		sightAngle 40
		x 159
		y 32
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 102 29 218 29 207 35 112 35
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance insideElevator of Feature
	(properties
		noun 9
		nsLeft 111
		nsTop 36
		nsRight 209
		nsBottom 97
		sightAngle 40
		x 160
		y 30
	)
)

(instance shuttlePort of Feature
	(properties
		noun 10
		sightAngle 40
		x 86
		y 60
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 97 101 78 101 73 88 71 73 71 57 74 40 78 32 97 32
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance roomPort of Feature
	(properties
		noun 11
		nsLeft 224
		nsTop 32
		nsRight 242
		nsBottom 103
		sightAngle 40
		x 234
		y 60
	)
)

(instance leftLights of Feature
	(properties
		noun 12
		nsLeft 39
		nsRight 55
		nsBottom 138
		sightAngle 40
		x 48
		y 70
	)
)

(instance rightLights of Feature
	(properties
		noun 12
		nsLeft 262
		nsRight 278
		nsBottom 138
		sightAngle 40
		x 270
		y 70
	)
)

(instance hydrolics of Feature
	(properties
		noun 13
		sightAngle 40
		x 160
		y 133
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 91 118 103 118 103 121 122 117 123 114 121 109 202 109 202 112 197 113 197 117 217 121 218 118 229 118 229 125 219 125 196 122 196 124 225 132 234 132 234 137 221 137 183 126 183 112 137 112 137 127 98 137 86 137 86 132 95 132 125 124 124 122 100 126 91 125
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance hatchOpen of Feature
	(properties
		noun 15
		case 2
		sightAngle 40
		approachX 121
		approachY 101
		x 106
		y 67
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PNearestAccess
					init: 102 61 103 45 106 36 108 35 109 38 112 47 112 75 111 90 107 99 104 92 102 79
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance shaftOpen of Feature
	(properties
		noun 16
		case 2
		sightAngle 40
		approachX 202
		approachY 101
		x 215
		y 67
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PNearestAccess
					init: 210 37 218 33 218 103 210 98
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance inButtonCloseup of Inset
	(properties
		view 501
		x 100
		y 20
		disposeNotOnMe 1
	)

	(method (init)
		(super init: &rest)
		(bayButton init:)
		(quartersButton init:)
		(labAButton init:)
		(labBButton init:)
	)
)

(instance bayButton of Feature
	(properties
		noun 19
		nsLeft 18
		nsTop 25
		nsRight 30
		nsBottom 34
		sightAngle 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(switch local0
					(0
						(sfxButton play:)
					)
					(1
						(gCurRoom setScript: sUseShaft 0 -1)
					)
					(2
						(gCurRoom setScript: sUseShaft 0 -2)
					)
					(3
						(gCurRoom setScript: sUseShaft 0 -3)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance quartersButton of Feature
	(properties
		noun 20
		nsLeft 18
		nsTop 41
		nsRight 30
		nsBottom 50
		sightAngle 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(switch local0
					(0
						(gCurRoom setScript: sUseShaft 0 1)
					)
					(1
						(sfxButton play:)
					)
					(2
						(gCurRoom setScript: sUseShaft 0 -1)
					)
					(3
						(gCurRoom setScript: sUseShaft 0 -2)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance labAButton of Feature
	(properties
		noun 21
		nsLeft 18
		nsTop 58
		nsRight 30
		nsBottom 67
		sightAngle 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(switch local0
					(0
						(gCurRoom setScript: sUseShaft 0 2)
					)
					(1
						(gCurRoom setScript: sUseShaft 0 1)
					)
					(2
						(sfxButton play:)
					)
					(3
						(gCurRoom setScript: sUseShaft 0 -1)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance labBButton of Feature
	(properties
		noun 22
		nsLeft 18
		nsTop 74
		nsRight 30
		nsBottom 83
		sightAngle 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gMessager say: noun 4 3) ; "You press the Lab B button, but the Ascend-O-Pad doesn't move. Apparently you need some sort of clearance to get to Lab B."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sFXPound of Sound
	(properties
		number 509
	)
)

(instance sfxButton of Sound
	(properties
		number 355
	)
)

