;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 260)
(include sci.sh)
(use Main)
(use OccasionalCycle)
(use eRS)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use Door)
(use LoadMany)
(use Motion)
(use Actor)
(use System)

(public
	rm260 0
)

(instance rm260 of FPRoom
	(properties
		noun 16
		picture 260
		horizon 40
		north 320
		east 270
		west 250
	)

	(method (init)
		(LoadMany rsSOUND 260 2942)
		(LoadMany rsVIEW 260 263 269)
		(switch gPrevRoomNum
			(west
				(= style 12)
				(gGame handsOn:)
			)
			(east
				(= style 11)
				(if (< (gEgo y:) 100)
					(gEgo y: 100)
				)
				(gGame handsOn:)
			)
			(570
				(gEgo posn: 176 79)
				(= style 9)
				(self setScript: sTimeToConfront)
			)
			(680
				(gGame handsOn:)
			)
			(north
				(= style 100)
				(gEgo x: 100 y: 45)
				(gGame handsOn:)
			)
			(else
				(= style 100)
				(gEgo x: 160 y: 160)
				(gGame handsOn:)
			)
		)
		(gEgo init: setScale: Scaler 100 50 175 95 normalize:)
		(super init:)
		(if (< gCurPuzzle 14)
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 0 0 319 0 319 99 278 108 221 97 184 81 144 72 84 33 84 7 48 7 49 43 113 93 0 91
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 0 181 251 179 301 141 319 135 319 189 0 189
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 0 96 22 96 22 117 0 117
						yourself:
					)
			)
			(if (not (OneOf gCurPuzzle 9 8 7 25))
				(if (!= gCurPuzzle 2)
					(penelope
						init:
						stopUpd:
						setScale: -1 gEgo
						approachVerbs: 4 2 ; Do, Talk
						setCycle: Walk
						hide:
						setScript: sWander
					)
					(UnLoad 128 269)
					(if (== gPrevRoomNum 270)
						(gGameMusic2 fade: 127 10 16 0)
					else
						(gGameMusic2 number: 260 loop: -1 play:)
					)
				)
				(if (> (gGame detailLevel:) 2)
					(craps1 init: approachVerbs: 4 2 setScript: sThrowDice) ; Do, Talk
					(craps2 init: approachVerbs: 4 2) ; Do, Talk
					(jumper
						setCycle: OccasionalCycle 1 30 120 8 15
						init:
						approachVerbs: 2 ; Talk
					)
				)
				(if (> (gGame detailLevel:) 2)
					(swinger
						init:
						setCycle: Fwd
						setPri: 6
						setScript: sStartKidsSample
					)
				else
					(swinger init: setCel: 1 setPri: 6 stopUpd:)
				)
				(seeSawKid setCycle: OccasionalCycle 1 10 20 10 20 init:)
			else
				(swing
					init:
					cel: 3
					setPri: 8
					stopUpd:
					ignoreActors:
					approachVerbs: 4 ; Do
				)
				(seesaw
					init:
					setPri: 5
					stopUpd:
					ignoreActors:
					approachVerbs: 4 41 ; Do, Baking_Soda
				)
			)
			(gGame handsOn:)
		else
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 0 0 319 0 319 99 278 108 221 97 204 67 211 39 234 49 234 33 206 33 201 66 176 63 144 72 84 33 84 7 48 7 49 43 113 93 0 96
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 0 181 251 179 301 141 319 135 319 189 0 189
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 0 104 23 104 23 121 0 121
						yourself:
					)
			)
			(swing
				init:
				cel: 3
				setPri: 8
				stopUpd:
				ignoreActors:
				approachVerbs: 4 ; Do
			)
			(seesaw init: setPri: 5 stopUpd: ignoreActors: approachVerbs: 4 41) ; Do, Baking_Soda
			(burnedShell
				setPri: 5
				ignoreActors:
				init:
				stopUpd:
				approachVerbs: 4 ; Do
			)
		)
		(if
			(and
				(not (gEgo has: 28)) ; Ladder
				(not (IsFlag 2))
				(not (IsFlag 16))
				(< gCurPuzzle 14)
				(not (OneOf gCurPuzzle 9 8 7))
			)
			(slider
				init:
				approachVerbs: 4 2 ; Do, Talk
				ignoreActors:
				ignoreHorizon:
				setScript: sSlideDown
			)
		)
		(if
			(and
				(not (gEgo has: 28)) ; Ladder
				(not (IsFlag 2))
				(not (IsFlag 16))
				(< gCurPuzzle 14)
			)
			(ladder init: stopUpd: ignoreActors: approachVerbs: 4) ; Do
		)
		(schoolDoor init: stopUpd:)
		(assayOffice init: approachVerbs: 4 setOnMeCheck: 1 1024) ; Do
		(school init: approachVerbs: 4 setOnMeCheck: 1 32) ; Do
		(buildings init: approachVerbs: 4 setOnMeCheck: 1 256) ; Do
		(street init: approachVerbs: 4 setOnMeCheck: 1 2) ; Do
		(slide init: approachVerbs: 4 setOnMeCheck: 1 4) ; Do
		(seesawBase init: approachVerbs: 4 setOnMeCheck: 1 8) ; Do
		(tree init: approachVerbs: 4 setOnMeCheck: 1 16) ; Do
		(windowPanes init: approachVerbs: 4 setOnMeCheck: 1 64) ; Do
		(roof init: approachVerbs: 4 setOnMeCheck: 1 128) ; Do
		(clutter init: approachVerbs: 4 setOnMeCheck: 1 512) ; Do
		(if (IsFlag 52)
			(dummyCredits init: setScript: (ScriptID 32 0)) ; sOpeningCredits
		)
	)

	(method (cue)
		(super cue:)
		(seesaw setScript: sPlayContinuously)
	)

	(method (dispose)
		(if (== (gGameMusic1 number:) 2942)
			(gGameMusic1 number: 2943 loop: 1 play:)
		)
		(if (== gNewRoomNum 270)
			(gGameMusic2 fade: 20 10 16 0)
		else
			(gGameMusic2 fade:)
		)
		(DisposeScript 32)
		(super dispose:)
	)
)

(instance sStartKidsSample of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 5)
			)
			(1
				(gGameMusic1 number: 2941 loop: 1 play: gCurRoom)
				(self dispose:)
			)
		)
	)
)

(instance sPlayContinuously of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (== (gGameMusic1 number:) 2942) (== (gGameMusic1 prevSignal:) -1))
			(gGameMusic1 number: 2942 flags: 1 loop: 1 play: self)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGameMusic1 number: 2942 flags: 1 loop: 1 play: self)
			)
			(1
				(gGameMusic1 prevSignal: 0)
				(self changeState: 0)
			)
		)
	)
)

(instance sThrowDice of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setLoop: 7 cel: 0 setCycle: End self)
			)
			(1
				(= ticks 30)
			)
			(2
				(client cel: 9 stopUpd:)
				(craps2 setLoop: 10 cel: 0 setCycle: End self)
			)
			(3
				(craps2 setLoop: 9 cel: 0 setCycle: End self)
			)
			(4
				(= ticks 30)
			)
			(5
				(craps2 cel: 9 stopUpd:)
				(client setLoop: 8 cel: 0 setCycle: End self)
			)
			(6
				(self changeState: 0)
			)
		)
	)
)

(instance sWander of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 20 30))
			)
			(1
				(schoolDoor setCycle: End self)
				(schoolDoorSound number: (schoolDoor openSnd:) play:)
			)
			(2
				(penelope show: setMotion: MoveTo 189 74 self)
			)
			(3
				(schoolDoor setCycle: Beg self)
				(schoolDoorSound number: (schoolDoor closeSnd:) play:)
			)
			(4
				(penelope stopUpd:)
				(schoolDoor stopUpd:)
				(= seconds (Random 6 10))
			)
			(5
				(penelope setMotion: MoveTo 197 67 self)
			)
			(6
				(schoolDoor setCycle: End self)
				(schoolDoorSound number: (schoolDoor openSnd:) play:)
			)
			(7
				(penelope setMotion: MoveTo 217 55 self)
			)
			(8
				(penelope setHeading: 180 stopUpd: hide:)
				(schoolDoor setCycle: Beg self)
				(schoolDoorSound number: (schoolDoor closeSnd:) play:)
			)
			(9
				(schoolDoor stopUpd:)
				(schoolDoor caller: 0)
				(UnLoad 128 269)
				(self changeState: 0)
			)
		)
	)
)

(instance sSlideDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setLoop: 3 posn: 154 27)
				(= cycles 5)
			)
			(1
				(client setMotion: MoveTo 147 44 self)
			)
			(2
				(client setMotion: MoveTo 143 44 self)
			)
			(3
				(client setLoop: 4 posn: 143 63 setCycle: End self)
			)
			(4
				(= ticks 30)
			)
			(5
				(if (not (gEgo has: 28)) ; Ladder
					(client
						setLoop: 5
						posn: 143 67
						setMotion: MoveTo 167 62
						setCycle: End self
					)
				else
					(client stopUpd:)
					(self dispose:)
				)
			)
			(6
				(client setLoop: 6 posn: 167 64 setCycle: End self)
			)
			(7
				(self changeState: 0)
			)
		)
	)
)

(instance sTimeToConfront of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(gMessager say: 22 0 0 0 self) ; "Freddy dragged his bleedin' self over to the Schoolhouse...the anger and hurt wuz jus' rippin' at his gut like a swarm of botflies on roadkill, only worse 'cuz Freddy, unlike roadkill, wuz still alive."
			)
			(2
				(gEgo setSpeed: 7 setMotion: PolyPath 197 67 self)
			)
			(3
				(schoolDoor setCycle: End self)
				(schoolDoorSound number: (schoolDoor openSnd:) play:)
			)
			(4
				(gEgo setMotion: MoveTo 217 55 self)
			)
			(5
				(gCurRoom newRoom: 720)
				(self dispose:)
			)
		)
	)
)

(instance seesaw of Prop
	(properties
		x 252
		y 81
		noun 4
		approachX 216
		approachY 108
		view 260
		loop 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (OneOf gCurPuzzle 9 8 7)
					(gMessager say: noun theVerb 3) ; "You're going to play on the seesaw, when the whole town is about to be gassed?"
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance swing of Prop
	(properties
		x 300
		y 60
		z 40
		noun 3
		approachX 271
		approachY 74
		view 260
		loop 4
		signal 4096
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (OneOf gCurPuzzle 9 8 7)
					(gMessager say: noun theVerb 3) ; "Yes, the swing would let you get up a few feet in the atmosphere and perhaps escape the horrible fumes, but it wouldn't last long."
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance schoolDoor of Door
	(properties
		x 210
		y 60
		noun 2
		approachX 199
		approachY 70
		view 260
		locked 1
		openSnd 2146
		closeSnd 2147
		openVerb 4
		moveToX 227
		moveToY 39
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gMessager say: noun theVerb) ; "Penelope keeps this door locked all the time, to keep the kids in and the rabble out."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance craps1 of Actor
	(properties
		x 253
		y 74
		noun 20
		approachX 201
		approachY 89
		view 263
		loop 7
		detailLevel 2
	)
)

(instance craps2 of Actor
	(properties
		x 276
		y 74
		noun 21
		approachX 201
		approachY 89
		view 263
		loop 9
		cel 9
		signal 16384
		detailLevel 2
	)
)

(instance seeSawKid of Prop
	(properties
		x 248
		y 85
		noun 4
		view 263
		cel 1
		signal 4096
		cycleSpeed 10
		detailLevel 2
	)

	(method (doit)
		(super doit:)
		(if (or (== cel 0) (== cel (self lastCel:)))
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (< gCurPuzzle 14)
					(gMessager say: noun theVerb 1) ; "You can't play now."
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance swinger of Prop
	(properties
		x 300
		y 20
		noun 3
		view 263
		loop 1
		cel 7
		cycleSpeed 10
		detailLevel 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (< gCurPuzzle 14)
					(gMessager say: noun theVerb 1) ; "The swing is in use."
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance jumper of Prop
	(properties
		x 298
		y 97
		noun 19
		view 263
		loop 2
		cel 2
		detailLevel 2
	)
)

(instance slider of Actor
	(properties
		x 154
		y 27
		noun 18
		approachX 167
		approachY 78
		view 263
		loop 3
	)
)

(instance penelope of Actor
	(properties
		x 217
		y 59
		noun 17
		approachX 175
		approachY 74
		view 269
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(2 ; Talk
				(cond
					((== (script state:) 4)
						(cond
							((and (== gAct 1) (not (IsFlag 84)))
								(= temp0 10)
								(SetFlag 84)
							)
							((== gAct 1)
								(= temp0 9)
							)
							((and (== gCurPuzzle 13) (not (IsFlag 84)))
								(= temp0 15)
								(SetFlag 84)
							)
							((== gCurPuzzle 13)
								(= temp0 16)
							)
							((and (== gCurPuzzle 12) (not (IsFlag 84)))
								(= temp0 13)
								(SetFlag 84)
							)
							((== gCurPuzzle 12)
								(= temp0 14)
							)
							((and (== gCurPuzzle 10) (not (IsFlag 84)))
								(= temp0 12)
								(SetFlag 84)
							)
							((== gCurPuzzle 10)
								(= temp0 11)
							)
						)
						(gMessager say: noun theVerb temp0)
					)
					(loop
						(gMessager say: noun 2 19) ; "Penelope..."
					)
					(else
						(gMessager say: noun 2 18) ; "Oh, Penelope..."
					)
				)
			)
			(else
				(cond
					((== (script state:) 4)
						(super doVerb: theVerb &rest)
					)
					(loop
						(gMessager say: noun 2 19) ; "Penelope..."
					)
					(else
						(gMessager say: noun 2 18) ; "Oh, Penelope..."
					)
				)
			)
		)
	)
)

(instance dummyCredits of Prop
	(properties
		x -10
		y -10
		view 996
	)
)

(instance burnedShell of View
	(properties
		x 1
		y 2
		noun 11
		approachX 84
		approachY 98
		approachDist 76
		view 265
	)
)

(instance ladder of View
	(properties
		x 169
		y 48
		noun 1
		approachX 166
		approachY 75
		view 260
		loop 3
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (OneOf (slider loop:) 3 4)
					(gEgo get: -1 28) ; Ladder
					(gGame points: 1)
					(self dispose:)
					(gMessager say: noun theVerb) ; "The ladder, held in place by a couple of old loose screws, easily comes away from the rest of the slide assembly. You somehow cram it into your pocket along with the rest of the junk you've got stockpiled in there."
				else
					(gMessager say: noun theVerb 1) ; "Someone's using the ladder this very moment."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance assayOffice of Feature
	(properties
		x 38
		y 44
		noun 11
		sightAngle 40
		approachX 84
		approachY 98
		approachDist 76
	)

	(method (doVerb theVerb &tmp temp0)
		(if (< gCurPuzzle 14)
			(= temp0 5)
		else
			(= temp0 6)
		)
		(if (OneOf theVerb 1 4) ; Look, Do
			(gMessager say: noun theVerb temp0)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance school of Feature
	(properties
		x 247
		y 28
		noun 12
		sightAngle 40
		approachX 200
		approachY 84
		approachDist 80
	)
)

(instance buildings of Feature
	(properties
		x 130
		y 21
		noun 13
		sightAngle 40
		approachX 112
		approachY 61
		approachDist 49
	)
)

(instance street of Feature
	(properties
		x 130
		y 21
		noun 5
		sightAngle 40
		approachX 112
		approachY 61
		approachDist 49
	)
)

(instance slide of Feature
	(properties
		x 130
		y 21
		noun 6
		sightAngle 40
		approachX 112
		approachY 61
		approachDist 49
	)
)

(instance seesawBase of Feature
	(properties
		x 130
		y 21
		noun 4
		sightAngle 40
		approachX 216
		approachY 108
		approachDist 49
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((OneOf gCurPuzzle 9 8 7)
						(gMessager say: noun theVerb 3) ; "You're going to play on the seesaw, when the whole town is about to be gassed?"
					)
					((< gCurPuzzle 14)
						(gMessager say: noun theVerb 1) ; "You can't play now."
					)
					(else
						(super doVerb: theVerb &rest)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance tree of Feature
	(properties
		x 130
		y 21
		noun 7
		sightAngle 40
		approachX 216
		approachY 108
		approachDist 49
	)
)

(instance windowPanes of Feature
	(properties
		x 130
		y 21
		noun 8
		sightAngle 40
		approachX 200
		approachY 84
		approachDist 49
	)
)

(instance roof of Feature
	(properties
		x 130
		y 21
		noun 9
		sightAngle 40
		approachX 200
		approachY 84
		approachDist 49
	)
)

(instance clutter of Feature
	(properties
		x 130
		y 21
		noun 10
		sightAngle 40
		approachX 160
		approachY 138
		approachDist 49
	)
)

(instance schoolDoorSound of FPSound
	(properties
		flags 1
	)
)

