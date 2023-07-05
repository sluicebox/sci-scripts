;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 700)
(include sci.sh)
(use Main)
(use Door)
(use eRS)
(use Inset)
(use PolyPath)
(use Feature)
(use LoadMany)
(use Timer)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm700 0
)

(local
	local0
	[local1 2]
)

(instance rm700 of LBRoom
	(properties
		noun 19
		picture 700
		north 660
		west 710
		vanishingY 38
	)

	(method (init)
		(gCurRoom obstacles: (List new:))
		((ScriptID 2700 0) doit: (gCurRoom obstacles:)) ; poly2700Code
		(gEgo
			init:
			normalize: 831
			setScale: 150
			edgeHit: EDGE_NONE
			posn: 165 124
			setPri: 5
			setHeading: 180
		)
		(LoadMany rsVIEW 701 423 424)
		(LoadMany rsSOUND 16 662 700 49 452 453 455 80 701)
		(super init:)
		(northDoor init:)
		(elevatorShaft init:)
		(backg init:)
		(case1 init:)
		(case2 init:)
		(case3 init:)
		(case4 init:)
		(case5 init:)
		(case6 init:)
		(case7 init:)
		(case8 init:)
		(wall init:)
		(pooh init:)
		(caseDoor init: approachVerbs: 4) ; Do
		(mummyDoor init: approachVerbs: 4 38) ; Do, waterGlass
		(mummyDoorCase init:)
		(snake init: approachVerbs: 4) ; Do
		(mummy init:)
		(gWalkHandler addToFront: mummyDoorCase)
		(northDoor setCycle: End self)
		(sFXDoor number: 46 play:)
		(gAltPolys delete: (northDoor doorPoly:))
	)

	(method (cue)
		(if (== (backg y:) 125)
			(northDoor state: 2 ignoreActors: 1 stopUpd:)
			(gEgo setPri: -1 setMotion: MoveTo (gEgo x:) 129 backg)
		else
			(if (gCurRoom inset:)
				((gCurRoom inset:) dispose:)
			)
			(if (< (gEgo y:) 123)
				(gCurRoom setScript: sCrushLaura)
			else
				(gCurRoom setScript: sKillRileyKill)
			)
		)
	)

	(method (newRoom)
		(rileyTimer dispose: delete:)
		(super newRoom: &rest)
	)

	(method (dispose)
		(gWalkHandler delete: mummyDoorCase)
		(DisposeScript 2700)
		(gGameMusic1 fade:)
		(super dispose:)
	)
)

(instance sGetMummy of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 185 137 self)
			)
			(1
				(gEgo view: 702 setLoop: 0 setCel: 0 setCycle: CT 7 1 self)
			)
			(2
				(mummy hide:)
				(gEgo setCycle: End self)
			)
			(3
				(gEgo get: 35 normalize: 831 loop: 3) ; mummy
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sPutMummy of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 176 137 self)
			)
			(1
				(gEgo view: 702 setLoop: 1 setCel: 0 setCycle: CT 5 1 self)
			)
			(2
				(sFX number: 700 flags: 5 loop: 1 play:)
				(gEgo setCycle: End self)
			)
			(3
				(mummy show: setPri: 7 posn: 174 134 30 setCel: 0 stopUpd:)
				(gEgo put: 35 normalize: 831 loop: 3) ; mummy
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sExitRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 135 133 self)
			)
			(1
				(if (or (gEgo has: 35) (not (== (mummy cel:) 0))) ; mummy
					(rileyTimer delete: dispose:)
					(gCurRoom setScript: sKillRileyKill)
				else
					(= cycles 1)
				)
			)
			(2
				(gEgo setMotion: MoveTo 96 133 self)
			)
			(3
				(gCurRoom newRoom: 710)
				(self dispose:)
			)
		)
	)
)

(instance sUnlockCase of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 135 139 self)
			)
			(1
				(gEgo setHeading: 270 self)
			)
			(2
				(gEgo
					view: 700
					setLoop: 2
					setCel: 0
					setPri: 10
					cycleSpeed: 12
					setCycle: CT 3 1 self
				)
			)
			(3
				(sFX number: 49 loop: 1 flags: 5 play:)
				(gEgo setCycle: End self)
			)
			(4
				(gEgo setCycle: Beg self)
			)
			(5
				(if local0
					(gMessager say: 15 0 1) ; "Quit playing around with the snake! There's a murderer chasing you!"
				else
					(gMessager say: 15 0 2) ; "The snake shifts, just a little, and you hear a click."
					(= local0 1)
				)
				(gEgo normalize: 831 loop: 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sCrushLaura of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(LoadMany rsSOUND 500 490)
				(mummyDoor addToPic:)
				(caseDoor addToPic:)
				(northDoor addToPic:)
				(if
					(and
						(gCast contains: mummy)
						(not (& (mummy signal:) $0008))
					)
					(mummy addToPic:)
				)
				(northDoor ignoreActors: 1)
				(gEgo setPri: 2)
				(riley
					init:
					scaleSignal: 1
					scaleX: 130
					scaleY: 130
					setLoop: 2
					setPri: 5
					setMotion: MoveTo (riley x:) 97
				)
				(backg setLoop: 5 setMotion: MoveTo (backg x:) 97 self)
				(sFX number: 662 flags: 1 loop: -1 play:)
			)
			(1
				(sFX2 number: 500 flags: 1 loop: 1 play:)
				(gEgo
					view: 701
					setLoop: 1
					setCel: 0
					cycleSpeed: 12
					setCycle: End
				)
				(riley setMotion: MoveTo (riley x:) 125)
				(backg setLoop: 5 setMotion: MoveTo (backg x:) 125 self)
			)
			(2
				(gGameMusic1 stop:)
				(sFX stop:)
				(sFX2 stop:)
				(sFX number: 490 loop: 1 flags: 1 play:)
				(backg addToPic:)
				(= ticks 30)
			)
			(3
				(blood
					init:
					posn: (+ (gEgo x:) 13) (+ (gEgo y:) 11)
					setCycle: End self
				)
			)
			(4
				(= ticks 180)
			)
			(5
				(= global145 4) ; "Going down?"
				(gCurRoom newRoom: 99) ; deathRoom
				(self dispose:)
			)
		)
	)
)

(instance sKillRileyKill of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (northDoor cel:)
					(gGameMusic1 number: 3 loop: 1 flags: 1 play:)
				)
				(northDoor ignoreActors: 1)
				(mummyDoor addToPic:)
				(caseDoor addToPic:)
				(if
					(and
						(gCast contains: mummy)
						(not (& (mummy signal:) $0008))
					)
					(mummy addToPic:)
				)
				(riley
					init:
					scaleSignal: 1
					scaleX: 130
					scaleY: 130
					setLoop: 2
					setPri: 5
					setMotion: MoveTo (riley x:) 125
				)
				(backg setLoop: 5 setMotion: MoveTo (backg x:) 125 self)
				(sFX number: 662 flags: 1 loop: -1 play:)
			)
			(1
				(= register 0)
				(sFX stop:)
				(backg addToPic:)
				(if (northDoor cel:)
					(= cycles 1)
				else
					(northDoor setCycle: End self)
					(sFXDoor number: 46 play:)
					(= register 1)
					(gAltPolys delete: (northDoor doorPoly:))
				)
			)
			(2
				(if register
					(gGameMusic1 number: 3 loop: 1 flags: 1 play:)
				)
				(northDoor addToPic:)
				(riley setPri: -1)
				(gEgo setMotion: PolyPath 120 143 self)
			)
			(3
				(gEgo setHeading: 90)
				(riley
					setCycle: Walk
					setScale: 130
					setMotion: MoveTo 145 148 self
				)
			)
			(4
				(riley setHeading: 270 self)
			)
			(5
				(gEgo
					view: 700
					setLoop: 6
					setCel: 0
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(6
				(riley view: 424 setLoop: 1 setCel: 0 setCycle: CT 6 1 self)
			)
			(7
				(sFX number: 80 flags: 5 loop: 1 play:)
				(riley setCycle: End self)
			)
			(8
				(gEgo
					view: 701
					setLoop: 1
					setCel: 0
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(9
				(= ticks 120)
			)
			(10
				(= global145 0) ; "You came in thinking like a journalist, and you left with a skull full of mush."
				(gCurRoom newRoom: 99) ; deathRoom
				(self dispose:)
			)
		)
	)
)

(instance sListen of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gGameMusic2 number: 701 loop: -1 flags: 5 setVol: 63 play:)
				(= cycles 1)
			)
			(1
				(gMessager say: 14 38) ; "You hear a muffled, rhythmic noise from inside the mummy case. The more you listen to it, the more it sounds like a group of male voices singing a chant."
				(= cycles 1)
			)
			(2
				(gGameMusic2 fade:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance backg of Actor
	(properties
		x 166
		y 125
		view 700
		loop 5
		priority 4
		signal 16400
	)

	(method (cue)
		(if (== y 125)
			(self setLoop: 5 setMotion: MoveTo (self x:) 79 self)
			(gGameMusic1 number: 16 flags: 1 loop: -1 play:)
			(sFX number: 662 flags: 1 loop: -1 play:)
		else
			(sFX stop:)
			(rileyTimer setReal: gCurRoom 0 1)
			(gCurRoom timer: rileyTimer)
			(self stopUpd:)
			(gGame handsOn:)
		)
	)
)

(instance riley of Actor
	(properties
		x 167
		y 79
		view 423
		loop 2
		cel 4
		signal 16384
	)
)

(instance rileyTimer of Timer
	(properties)
)

(instance northDoor of Door
	(properties
		x 152
		y 101
		z 21
		noun 1
		approachX 166
		approachY 137
		view 700
		loop 1
		entranceTo 660
		forceClose 0
		moveToX 166
		moveToY 108
	)

	(method (createPoly)
		(super createPoly: 148 117 185 117 186 126 148 126)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (!= (mummy cel:) 0)
					(super doVerb: theVerb)
				)
			)
			(9 ; mummy
				(if (self cel:)
					(super doVerb: theVerb)
				else
					(rileyTimer delete: dispose:)
					(gCurRoom setScript: sPutMummy)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance inPooh of Inset
	(properties
		view 700
		loop 4
		x 204
		y 77
		disposeNotOnMe 1
		noun 18
	)
)

(instance mummyDoor of Prop
	(properties
		x 120
		y 126
		noun 14
		approachX 138
		approachY 139
		view 700
		priority 10
		signal 16401
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((self cel:)
						(sFX number: 453 loop: 1 flags: 5 play:)
						(self setCycle: Beg self)
						(snake init:)
					)
					(local0
						(sFX number: 452 loop: 1 flags: 5 play:)
						(self setCycle: End self)
						(snake dispose:)
					)
					(else
						(gMessager say: 14 4 1) ; "The lid won't open."
					)
				)
			)
			(38 ; waterGlass
				(if (not cel)
					(gCurRoom setScript: sListen)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (cue)
		(if (self cel:)
			(self setPri: 7 stopUpd:)
			(sFX stop:)
		else
			(sFX number: 455 loop: 1 flags: 5 play:)
			(self setPri: 10 stopUpd:)
		)
	)
)

(instance caseDoor of Prop
	(properties
		x 239
		y 128
		noun 8
		approachX 172
		approachY 135
		view 700
		loop 3
		signal 16385
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (self cel:)
					(sFX number: 453 loop: 1 flags: 5 play:)
					(self setCycle: Beg self)
					(-= y 100)
					(-= z 100)
				else
					(sFX number: 452 loop: 1 flags: 5 play:)
					(self setCycle: End self)
					(+= y 100)
					(+= z 100)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (cue)
		(self stopUpd:)
		(if cel
			(sFX stop:)
		else
			(sFX number: 455 loop: 1 flags: 5 play:)
		)
	)
)

(instance blood of Prop
	(properties
		view 701
		loop 2
		cycleSpeed 15
	)
)

(instance mummy of View
	(properties
		x 187
		y 122
		noun 11
		view 702
		loop 2
		cel 1
		priority 10
		signal 16401
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (== (mummy cel:) 0)
					(super doVerb: theVerb)
				else
					(gCurRoom setScript: sGetMummy)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance pooh of Feature
	(properties
		x 228
		y 96
		nsTop 90
		nsLeft 223
		nsBottom 103
		nsRight 234
		sightAngle 40
		approachX 178
		approachY 133
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (caseDoor cel:)
					(gCurRoom setInset: inPooh)
				else
					(caseDoor doVerb: 1)
				)
			)
			(8 ; magnifier
				(if (caseDoor cel:)
					(gCurRoom setInset: inPooh)
				else
					(caseDoor doVerb: 8)
				)
			)
			(4 ; Do
				(if (caseDoor cel:)
					(super doVerb: theVerb)
				else
					(caseDoor doVerb: 4)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance mummyDoorCase of Feature
	(properties
		x 115
		y 100
		noun 16
		nsTop 79
		nsLeft 98
		nsBottom 133
		nsRight 118
		sightAngle 40
		approachX 135
		approachY 133
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Walk
				(if (and local0 (mummyDoor cel:))
					(gCurRoom setScript: sExitRoom)
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

(instance snake of Feature
	(properties
		y 127
		noun 15
		nsTop 75
		nsLeft 117
		nsBottom 86
		nsRight 127
		sightAngle 40
		approachX 139
		approachY 139
	)

	(method (doVerb theVerb)
		(switch theVerb
			(30 ; snakeLasso
				(gCurRoom setScript: sUnlockCase)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance elevatorShaft of Feature
	(properties
		x 167
		y 100
		noun 12
		nsTop 80
		nsLeft 154
		nsBottom 121
		nsRight 180
		sightAngle 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (northDoor cel:)
					(gMessager say: 12 1) ; "The elevator shaft is dark and cold."
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

(instance case1 of Feature
	(properties
		y 1
		noun 2
		onMeCheck 8
	)
)

(instance case2 of Feature
	(properties
		y 1
		noun 3
		onMeCheck 4
	)
)

(instance case3 of Feature
	(properties
		y 1
		noun 4
		onMeCheck 16
	)
)

(instance case4 of Feature
	(properties
		y 1
		noun 5
		onMeCheck 32
	)
)

(instance case5 of Feature
	(properties
		y 1
		noun 6
		onMeCheck 64
	)
)

(instance case6 of Feature
	(properties
		y 1
		noun 7
		onMeCheck 128
	)
)

(instance case7 of Feature
	(properties
		y 1
		noun 20
		onMeCheck 256
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (caseDoor cel:)
					(super doVerb: theVerb)
				else
					(caseDoor doVerb: 1)
				)
			)
			(8 ; magnifier
				(if (caseDoor cel:)
					(super doVerb: theVerb)
				else
					(caseDoor doVerb: 8)
				)
			)
			(4 ; Do
				(if (caseDoor cel:)
					(super doVerb: theVerb)
				else
					(caseDoor doVerb: 4)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance case8 of Feature
	(properties
		y 1
		noun 9
		onMeCheck 512
	)
)

(instance wall of Feature
	(properties
		y 1
		noun 10
		onMeCheck 1024
	)
)

(instance sFX of Sound
	(properties
		flags 1
		loop -1
	)
)

(instance sFX2 of Sound
	(properties
		flags 1
	)
)

(instance sFXDoor of Sound
	(properties
		flags 5
	)
)

