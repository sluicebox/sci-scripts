;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 700)
(include sci.sh)
(use Main)
(use LarryRoom)
(use PolyFeature)
(use Scaler)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	rm700 0
)

(local
	local0
)

(instance rm700 of LarryRoom
	(properties
		noun 1
		picture 700
		horizon 0
		west 710
	)

	(method (init)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 0 139 319 139 319 97 297 97 275 79 247 79 247 73 280 73 299 91 319 91 319 73 235 49 229 45 212 47 202 45 146 45 130 43 82 63 73 70 26 49 0 49
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 159 100 213 84 261 92 276 109 226 128 197 128 154 116
					yourself:
				)
		)
		(super init: &rest)
		(gEgo normalize: 900 2 setScale: Scaler 100 80 121 47 init:)
		(switch gPrevRoomNum
			(570
				(self setScript: fromKitchenScr)
			)
			(else
				(self setScript: fromBalconyScr)
			)
		)
		(if (!= gPrevRoomNum 710)
			(gGlobalSound1 number: 700 loop: -1 play: 50 fade: 127 10 10 0)
		)
		(dumbWaiter init:)
		(elevatorDoor init: approachVerbs: 4) ; Do
		(elevatorButton init: approachVerbs: 4) ; Do
		(priFixPoly init:)
		(plant1 init:)
		(table1 init:)
		(door init:)
		(table2 init:)
		(screen init:)
		(lamp init:)
	)

	(method (doit)
		(super doit: &rest)
		(cond
			(script 0)
			((gEgo inRect: 0 47 34 52)
				(self setScript: toBalconyScr 0 1)
			)
			((AvoidPath (gEgo x:) (gEgo y:) priFixPoly)
				(if (not local0)
					(= local0 1)
					(gEgo setPri: 1)
				)
			)
			(local0
				(gEgo setPri: -1)
				(= local0 0)
			)
		)
	)

	(method (edgeToRoom param1)
		(if (== param1 4)
			(self setScript: toBalconyScr)
		)
		(return 0)
	)

	(method (newRoom newRoomNumber)
		(priFixPoly dispose:)
		(if (!= newRoomNumber 710)
			(gGlobalSound1 fade:)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance fromBalconyScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo posn: -8 80 setMotion: MoveTo 10 80 self)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance toBalconyScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if register
					(gEgo setMotion: MoveTo -8 42 self)
				else
					(gEgo setMotion: MoveTo -8 (gEgo y:) self)
				)
			)
			(1
				(gGame handsOn:)
				(gCurRoom newRoom: 710)
			)
		)
	)
)

(instance fromKitchenScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(dumbWaiter setPri: 2)
				(gEgo
					setSpeed: 8
					setScale: 0
					setCycle: 0
					posn: 134 47
					view: 700
					loop: 2
					cel: 0
				)
				(= cycles 2)
			)
			(1
				(= ticks 60)
			)
			(2
				(dumbWaiter setCycle: End self)
				(gGlobalSound2 number: 573 loop: 1 play:)
			)
			(3
				(= ticks 20)
			)
			(4
				(dumbWaiter setPri: -1)
				(gEgo setCycle: End self)
			)
			(5
				(gGlobalSound2 number: 574 loop: 1 play:)
				(dumbWaiter setCycle: Beg)
				(gEgo normalize: 900 8 cel: 2 setScale: Scaler 100 80 121 47)
				(= cycles 2)
			)
			(6
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance toKitchenScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setHeading: 45 self)
			)
			(1
				(gGlobalSound2 number: 573 loop: 1 play:)
				(dumbWaiter setCycle: End self)
			)
			(2
				(= ticks 30)
			)
			(3
				(gEgo
					setSpeed: 8
					setScale: 0
					view: 700
					loop: 3
					cel: 0
					setCycle: End self
				)
			)
			(4
				(gGlobalSound2 number: 574 loop: 1 play:)
				(dumbWaiter setPri: 2 setCycle: Beg self)
			)
			(5
				(= ticks 30)
			)
			(6
				(gCurRoom newRoom: 570)
			)
		)
	)
)

(instance intoElevatorScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setHeading: 0 self)
			)
			(1
				(gEgo
					view: 901
					loop: 6
					cel: 0
					setSpeed: 8
					setCycle: End self
				)
			)
			(2
				(gGlobalSound2 number: 572 loop: 1 play: self)
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(gEgo normalize: 900 8 1 cel: 3)
				(= ticks 20)
			)
			(5
				(gEgo setMotion: MoveTo 184 45 self)
			)
			(6
				(gEgo setHeading: 0 self)
			)
			(7
				(= ticks 120)
			)
			(8
				(gGlobalSound2 number: 602 loop: 1 play:)
				(= ticks 120)
			)
			(9
				(gGlobalSound2 number: 600 loop: 1 play:)
				(elevatorDoor setCycle: End self)
			)
			(10
				(gEgo setMotion: MoveTo 186 39 self)
			)
			(11
				(gEgo setHeading: 180 self)
			)
			(12
				(= ticks 60)
			)
			(13
				(gGlobalSound2 number: 601 loop: 1 play:)
				(elevatorDoor setCycle: Beg self)
			)
			(14
				(= ticks 60)
			)
			(15
				(gCurRoom newRoom: 600)
			)
		)
	)
)

(instance plant1 of Feature
	(properties
		noun 10
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 43 31 44 9 57 9 56 38 44 38
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance table1 of Feature
	(properties
		noun 3
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 76 60 80 18 91 6 115 16 128 32 119 43
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance tryDoorScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 2)
			)
			(1
				(gEgo
					view: 901
					loop: 6
					cel: 0
					setSpeed: 8
					setCycle: End self
				)
			)
			(2
				(gGlobalSound2 number: 1034 loop: 1 play: self)
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(gEgo normalize: 900 8 1 cel: 3)
				(= cycles 2)
			)
			(5
				(gMessager say: 5 4 0 0 self) ; "You try the knob and find it locked."
			)
			(6
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance door of Feature
	(properties
		x 227
		y 45
		noun 5
		approachX 227
		approachY 47
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 215 45 217 2 234 3 239 49
					yourself:
				)
			approachVerbs: 4 ; Do
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gCurRoom setScript: tryDoorScr)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance table2 of Feature
	(properties
		noun 6
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					init: 165 93 208 82 203 78 214 67 220 76 218 80 243 84 264 92 262 112 231 123 194 125 162 118
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance balcony of Feature ; UNUSED
	(properties
		x 18
		y 34
	)

	(method (init)
		(super init: &rest)
		(self
			approachVerbs: 4 ; Do
			setOnMeCheck:
				2
				((Polygon new:) type: PTotalAccess init: 0 0 29 0 29 25 0 31 yourself:)
			approachX: x
			approachY: y
		)
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gCurRoom newRoom: 710)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance elevatorButton of Feature
	(properties
		x 203
		y 41
		nsTop 25
		nsLeft 199
		nsBottom 34
		nsRight 205
		approachX 203
		approachY 45
	)

	(method (doVerb theVerb)
		(elevatorDoor doVerb: theVerb)
	)
)

(instance elevatorDoor of Actor
	(properties
		x 184
		y 42
		noun 4
		approachX 203
		approachY 45
		view 700
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(self setScript: intoElevatorScr)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance screen of PolyFeature
	(properties
		noun 8
	)

	(method (init)
		(self
			addPolygon:
				((Polygon new:)
					init: 252 26 282 26 302 40 319 39 319 94 299 94 275 76 251 76 251 27
					yourself:
				)
				((Polygon new:)
					init: 0 92 17 92 35 106 56 106 51 140 0 140
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance dumbWaiter of Prop
	(properties
		x 137
		y 33
		noun 7
		approachX 134
		approachY 47
		view 700
		loop 1
		cycleSpeed 12
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 4) ; Do
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(self setScript: toKitchenScr)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance lamp of Feature
	(properties
		noun 11
	)

	(method (init)
		(super init: &rest)
		(self
			setOnMeCheck:
				2
				((Polygon new:) init: 215 0 219 35 207 35 212 0 yourself:)
		)
	)
)

(instance priFixPoly of Polygon
	(properties)

	(method (init)
		(super init: 277 76 277 56 319 70 319 94 300 94)
	)
)

