;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 220)
(include sci.sh)
(use Main)
(use SQRoom)
(use ExitFeature)
(use SQNarrator)
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
	rm220 0
	Singent 1
	Nigel 2
)

(local
	local0
	[local1 2]
	local3
	local4
)

(instance rm220 of SQRoom
	(properties
		noun 1
		picture 220
	)

	(method (init)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 84 93 12 137 223 137 123 94 110 94 102 89
					yourself:
				)
		)
		(Load rsPALETTE 0)
		(Load rsVIEW 222 223 224 226 227 229)
		(Load 140 225 241 242) ; WAVE
		(exit240 init: gTheExitCursor approachVerbs: 9) ; ExitUp
		(super init:)
		(gEgo
			posn: 102 85
			normalize: 2
			setScaler: Scaler 100 41 138 87
			init:
		)
		(elevDoor init: approachVerbs: 4) ; Do
		(elevLights init:)
		(cageDoor init:)
		(flickerLight init: setScript: sFlickeringLight)
		(mousie
			init:
			posn: 230 137
			setLoop: 0 1
			setCycle: Fwd
			moveSpeed: 12
			cycleSpeed: 10
			setScaler: Scaler 100 41 138 87
			setMotion: PolyPath 191 115
		)
		(keySlot init: approachVerbs: 71) ; Hotel_Keycard
		(door init:)
		(carpet init:)
		(doorLeft init:)
		(rDoorMid init:)
		(rDoorNear init:)
		(rightDoorFar init:)
		(lLightNear init:)
		(rLightFar init:)
		(chineseSign init:)
		(plant init:)
		(brokenSlot init: approachVerbs: 64 63 71) ; Buckazoids, Cheat_Sheet, Hotel_Keycard
		(rSlot init: approachVerbs: 64 63 71) ; Buckazoids, Cheat_Sheet, Hotel_Keycard
		(rSlotNear init: approachVerbs: 64 63 71) ; Buckazoids, Cheat_Sheet, Hotel_Keycard
		(leftSlotFar init: approachVerbs: 64 63 71) ; Buckazoids, Cheat_Sheet, Hotel_Keycard
		(tyrell init:)
		(win init:)
		(rogRoomDoor init:)
		(burntMark init:)
		(elevSwitch init: approachVerbs: 4) ; Do
		(cond
			((not (IsFlag 152))
				(SetFlag 152)
				(verminator init:)
				(self setScript: sFirstMouseChase)
			)
			((and (not (IsFlag 151)) (IsFlag 152))
				(blanketPartyTimer setReal: blanketPartyTimer 180)
				(self setScript: sRogerEnters)
			)
			(else
				(self setScript: sRogerEnters)
			)
		)
	)

	(method (doit &tmp temp0)
		(cond
			((<= (= temp0 (GetDistance (gEgo x:) (gEgo y:) 102 82)) 5)
				(PalVary 0 225 0 (- 100 (* temp0 20)) 64 79) ; PalVaryStart
			)
			((<= (= temp0 (GetDistance (gEgo x:) (gEgo y:) 44 121)) 25)
				(PalVary 0 225 0 (- 100 (* temp0 4)) 64 79) ; PalVaryStart
			)
			((<= (= temp0 (GetDistance (gEgo x:) (gEgo y:) 152 106)) 25)
				(PalVary 0 225 0 (- 100 (* temp0 4)) 64 79) ; PalVaryStart
			)
			((<= (= temp0 (GetDistance (gEgo x:) (gEgo y:) 199 127)) 25)
				(PalVary 0 225 0 (- 100 (* temp0 4)) 64 79) ; PalVaryStart
			)
			((<= (= temp0 (GetDistance (gEgo x:) (gEgo y:) 80 95)) 5)
				(if (== (flickerLight cel:) 0)
					(PalVary 0 225 0 (- 100 (* temp0 20)) 64 79) ; PalVaryStart
				)
				(if (not (== (flickerLight cel:) 0))
					(PalVary 1 0) ; PalVaryReverse
				)
			)
		)
		(if (== local4 1)
			(PalVary 3) ; PalVaryKill
			(PalVary 0 0 0) ; PalVaryStart
		)
		(super doit:)
	)

	(method (dispose)
		(PalVary 3) ; PalVaryKill
		(gEgo setScale: 0)
		(super dispose:)
	)
)

(instance sRogerEnters of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 3)
			)
			(1
				(elevLights cycleSpeed: 12 cel: 8 setCycle: End self)
			)
			(2
				(arrow init: cel: 1 setCycle: Beg)
				(arrow hide:)
				(sound2 number: 241 loop: 0 play: 32 0)
				(elevDoor view: 220 loop: 3 cel: 0 setCycle: End self)
			)
			(3
				(sound2 play: 32 0)
				(cageDoor view: 220 loop: 2 cel: 0 setCycle: End self)
			)
			(4
				(gEgo setMotion: PolyPath 102 100 self)
			)
			(5
				(sound2 play: 32 0)
				(cageDoor view: 220 loop: 2 cel: 9 setCycle: Beg self)
			)
			(6
				(sound2 play: 32 0)
				(elevDoor view: 220 loop: 3 cel: 6 setCycle: Beg self)
			)
			(7
				(arrow show: cel: 0 cycleSpeed: 12 setCycle: End)
				(elevLights cel: 13 setCycle: Beg self)
			)
			(8
				(arrow hide:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sThugsComeIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(elevLights cel: 0 cycleSpeed: 12 setCycle: End self)
				(arrow show: cel: 1 setCycle: Beg)
				(nigel init:)
				(singent init:)
			)
			(1
				(arrow hide:)
				(sound2 number: 241 loop: 0 play: 32 0)
				(elevDoor view: 220 loop: 3 cel: 0 setCycle: End self)
			)
			(2
				(gGSound1 number: 223 play:)
				(gEgo setMotion: MoveTo 125 130 self)
				(sound2 number: 241 loop: 0 play: 32 0)
				(cageDoor view: 220 loop: 2 cel: 0 setCycle: End self)
			)
			(3)
			(4
				(nigel hide:)
				(singent hide:)
				(stuck init: setCycle: End self)
			)
			(5
				(stuck dispose:)
				(= cycles 1)
			)
			(6
				(gEgo setHeading: 360)
				(nigel
					posn: 110 95
					setCycle: Walk
					setLoop: 2 1
					moveSpeed: 6
					show:
					setMotion: MoveTo (+ (gEgo x:) 35) (gEgo y:) self
				)
				(singent
					posn: 95 90
					setCycle: Walk
					setLoop: 2 1
					moveSpeed: 9
					show:
					setMotion: MoveTo (+ (gEgo x:) 10) (- (gEgo y:) 10)
				)
			)
			(7
				(nigel view: 224 setLoop: 1 1 cycleSpeed: 12 setCycle: End self)
			)
			(8
				(singent view: 224 setLoop: 0 1)
				(= cycles 1)
			)
			(9
				(sound2 number: 242 loop: 0 play: 32 0)
				(cageDoor view: 220 loop: 2 cel: 9 setCycle: Beg)
				(gEgo view: 222 setLoop: 2 1 cel: 0 setCycle: End self)
			)
			(10
				(gEgo normalize: 0)
				(gMessager sayRange: 4 0 0 1 2 self) ; "Hey there, Pal. Got a second? Me and my friend here was wondering something."
			)
			(11
				(gEgo normalize: 0 setHeading: 90)
				(gMessager sayRange: 4 0 0 3 5 self) ; "Well, we was wondering if you'd have any objection to us pounding you senseless."
			)
			(12
				(gEgo
					view: 222
					setLoop: 3 1
					cel: 0
					setSpeed: 10
					setCycle: End self
				)
				(sound2 number: 242 loop: 0 play: 32 0)
				(elevDoor view: 220 loop: 3 cel: 6 setCycle: Beg self)
			)
			(13
				(nigel view: 224 setLoop: 3 1 cel: 0 setCycle: End self)
				(arrow show: cel: 0 cycleSpeed: 12 setCycle: End)
				(elevLights cel: 13 setCycle: Beg)
			)
			(14
				(= local4 1)
				(= ticks 60)
			)
			(15
				(arrow hide:)
				(SetFlag 151)
				(gCurRoom newRoom: 260)
				(self dispose:)
			)
		)
	)
)

(instance sOpenSesame of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(blanketPartyTimer client: 0 delete: dispose:)
				(= local3 1)
				(nigel init:)
				(singent init:)
				(elevLights cel: 0 cycleSpeed: 12 setCycle: End)
				(arrow show: cel: 1 setCycle: Beg)
				(gEgo
					view: 222
					loop: 0
					cel: 0
					cycleSpeed: 12
					setCycle: CT 3 1 self
				)
			)
			(1
				(arrow hide:)
				(gGame points: 3 471)
				(gEgo cel: 4 setCycle: End self)
				(sound1 number: 225 loop: 0 play: 127 0)
				(sound2 number: 241 loop: 0 play: 32 0)
				(elevDoor view: 220 loop: 3 cel: 0 setCycle: End)
			)
			(2
				(gGSound1 number: 223 play:)
				(door setCycle: End)
				(gEgo setLoop: 1 1 cel: 0 setCycle: End)
				(sound2 number: 241 loop: 0 play: 32 0)
				(cageDoor view: 220 loop: 2 cel: 0 setCycle: End self)
				(gMessager say: 3 71 1 0 self) ; "Just as you are about to insert the keycard so you can go inside and check out your new digs, you notice those two goony-looking dudes from the lobby walking in your direction at a rather deliberate pace. Perhaps they're going to welcome you to the place or show you where the ice machine is."
			)
			(3)
			(4
				(nigel hide:)
				(singent hide:)
				(stuck init: setCycle: End self)
			)
			(5
				(gEgo setLoop: 2 1 cel: 0 setCycle: End)
				(stuck dispose:)
				(nigel
					show:
					setLoop: 2 1
					setCycle: Walk
					moveSpeed: 6
					setMotion: MoveTo (+ (gEgo x:) 35) (gEgo y:) self
				)
				(singent
					show:
					view: 227
					setLoop: 2 1
					setCycle: Walk
					moveSpeed: 9
					setMotion:
						MoveTo
						(+ (gEgo x:) 10)
						(- (gEgo y:) 10)
						self
				)
			)
			(6
				(nigel view: 224 setLoop: 1 1 cycleSpeed: 12 setCycle: End)
			)
			(7
				(singent view: 224 setLoop: 0 1)
				(= cycles 1)
			)
			(8
				(sound2 number: 242 loop: 0 play: 32 0)
				(cageDoor view: 220 loop: 2 cel: 9 setCycle: Beg)
				(gEgo normalize: 0)
				(gMessager sayRange: 4 0 0 1 2 self) ; "Hey there, Pal. Got a second? Me and my friend here was wondering something."
			)
			(9
				(gEgo normalize: 0 setHeading: 90)
				(gMessager sayRange: 4 0 0 3 5 self) ; "Well, we was wondering if you'd have any objection to us pounding you senseless."
			)
			(10
				(gEgo
					view: 222
					setLoop: 3 1
					cel: 0
					setSpeed: 10
					setCycle: End self
				)
				(sound2 number: 242 loop: 0 play: 32 0)
				(elevDoor view: 220 loop: 3 cel: 6 setCycle: Beg self)
			)
			(11
				(nigel view: 224 setLoop: 3 1 cel: 0 setCycle: End self)
				(arrow show: cel: 0 cycleSpeed: 12 setCycle: End)
				(elevLights cel: 13 setCycle: Beg)
			)
			(12
				(arrow hide:)
				(= local4 1)
				(= ticks 60)
			)
			(13
				(SetFlag 151)
				(gCurRoom newRoom: 260)
				(self dispose:)
			)
		)
	)
)

(instance sFirstMouseChase of Script
	(properties)

	(method (init)
		(super init: &rest)
		(= register 0)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 3)
			)
			(1
				(elevLights cycleSpeed: 12 cel: 6 setCycle: End)
				(verminator cycleSpeed: 12 setCycle: CT 3 1 self)
			)
			(2
				(sound1 number: 224 loop: 0 play: 64 0)
				(verminator cel: 3 setCycle: End self)
			)
			(3
				(arrow init: cel: 1 setCycle: Beg)
				(verminator view: 2290 loop: 3 cel: 0 setCycle: CT 13 1 self)
			)
			(4
				(sound1 number: 224 loop: 0 play: 127 0)
				(verminator cel: 13 setCycle: CT 14 1 self)
				(mousie view: 2292 loop: 0 cel: 0 setCycle: End)
			)
			(5
				(arrow hide:)
				(sound2 number: 241 loop: 0 play: 32 0)
				(elevDoor view: 220 loop: 3 cel: 0 setCycle: End)
				(verminator cel: 15 setCycle: End self)
			)
			(6
				(cageDoor view: 220 loop: 2 cel: 0 setCycle: End)
				(sound2 play: 32 0)
				(mousie hide:)
				(= cycles 1)
			)
			(7
				(verminator
					view: 229
					loop: 0
					cel: 11
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(8
				(gEgo setMotion: PolyPath 102 100)
				(verminator view: 2290 cel: 0 setCycle: CT 2 1 self)
				(mousie
					show:
					view: 2291
					posn: 133 94
					setLoop: 3
					setCycle: Fwd
					setScaler: Scaler 100 41 138 87
					setScript: sMousie
					setMotion: PolyPath 230 137
				)
			)
			(9
				(sound1 number: 224 loop: 0 play:)
				(verminator cel: 2 setCycle: End self)
			)
			(10
				(verminator view: 2290 loop: 0 cel: 2 setCycle: Beg self)
			)
			(11
				(verminator
					view: 2290
					setLoop: 0 1
					cel: 0
					moveSpeed: 1
					setMotion: MoveTo 101 115 self
				)
			)
			(12
				(gGame handsOn:)
				(verminator dispose:)
				(sound2 play: 32 0)
				(cageDoor view: 220 loop: 2 cel: 9 setCycle: Beg self)
			)
			(13
				(sound2 play: 32 0)
				(arrow show:)
				(elevDoor view: 220 loop: 3 cel: 6 setCycle: Beg self)
			)
			(14
				(blanketPartyTimer setReal: blanketPartyTimer 180)
				(arrow cel: 0 cycleSpeed: 12 setCycle: End)
				(elevLights cel: 13 setCycle: Beg self)
			)
			(15
				(arrow hide:)
				(self dispose:)
			)
		)
	)
)

(instance sMousie of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== local0 3)
					(= local0 0)
					(mousie
						setLoop: 0 1
						setCycle: Fwd
						setMotion: PolyPath 133 94
					)
				else
					(= local0 3)
					(mousie
						setLoop: 3 1
						setCycle: Fwd
						setMotion: PolyPath 230 137
					)
				)
				(= ticks (RandomNumber 30 240))
			)
			(1
				(self changeState: 0)
			)
		)
	)
)

(instance sFlickeringLight of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(flickerLight cel: 0 setCycle: End self)
			)
			(1
				(flickerLight cel: 3 setCycle: Beg)
				(= ticks (RandomNumber 1 180))
			)
			(2
				(self changeState: 0)
			)
		)
	)
)

(instance sRogerExits of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 240
					loop: 0
					cel: 0
					ignoreActors: 1
					setCycle: End self
				)
			)
			(1
				(arrowSnd play:)
				(arrow init:)
				(gEgo cel: 4 setCycle: Beg)
				(sound2 number: 241 play: 32 0)
				(elevDoor cel: 0 setCycle: End self)
			)
			(2
				(sound2 number: 241 play: 32 0)
				(cageDoor cel: 0 setCycle: End self)
			)
			(3
				(gEgo
					normalize: 3
					ignoreActors: 1
					setMotion: MoveTo 102 85 self
				)
			)
			(4
				(gEgo setHeading: 180 self)
			)
			(5
				(sound2 number: 242 play: 32 0)
				(cageDoor cel: 9 setCycle: Beg self)
			)
			(6
				(sound2 play: 32 0)
				(elevDoor cel: 6 setCycle: Beg self)
			)
			(7
				(elevLights cel: 13 setCycle: Beg)
				(= ticks (Random 20 50))
			)
			(8
				(blanketPartyTimer client: 0 delete: dispose:)
				(gEgo ignoreActors: 0)
				(gCurRoom newRoom: 240)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance stuck of Prop
	(properties
		x 102
		y 92
		view 223
	)
)

(instance elevDoor of Prop
	(properties
		noun 6
		approachX 101
		approachY 88
		x 111
		y 87
		view 220
		loop 3
	)

	(method (init)
		(self setPri: 88 ignoreActors: 1)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gMessager say: 10 4) ; "The elevator's already here. Walk your lazy can over and climb in if you want to use it."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance cageDoor of Prop
	(properties
		noun 5
		x 116
		y 87
		view 220
		loop 2
	)

	(method (init)
		(self ignoreActors: 1)
		(super init: &rest)
	)
)

(instance arrow of Prop
	(properties
		x 86
		y 75
		view 220
		cel 1
	)
)

(instance elevLights of Prop
	(properties
		noun 12
		x 103
		y 49
		view 220
		loop 1
	)

	(method (init)
		(self setPri: 90)
		(super init: &rest)
	)
)

(instance nigel of Actor
	(properties
		x 103
		y 86
		view 226
		loop 2
	)

	(method (init)
		(self setScaler: Scaler 100 41 138 87 ignoreActors: 1)
		(super init: &rest)
	)
)

(instance singent of Actor
	(properties
		x 99
		y 86
		view 227
		loop 2
	)

	(method (init)
		(self setScaler: Scaler 100 41 138 87 ignoreActors: 1)
		(super init: &rest)
	)
)

(instance verminator of Actor
	(properties
		x 101
		y 88
		view 2290
		loop 2
	)

	(method (init)
		(self setPri: 95 ignoreActors: 1)
		(super init: &rest)
	)
)

(instance mousie of Actor
	(properties
		view 2291
	)

	(method (init)
		(self ignoreActors: 1)
		(super init: &rest)
	)
)

(instance flickerLight of Prop
	(properties
		x 69
		y 96
		view 228
	)

	(method (init)
		(self ignoreActors: 1 setPri: 93)
		(super init: &rest)
	)
)

(instance door of Prop
	(properties
		y 67
		view 221
	)

	(method (init)
		(self ignoreActors: 1)
		(super init: &rest)
	)
)

(instance keySlot of Feature
	(properties
		noun 3
		sightAngle 40
		approachX 41
		approachY 125
		x 25
		y 94
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 22 91 29 89 29 98 22 100
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(71 ; Hotel_Keycard
				(if (IsFlag 151)
					(gMessager say: 3 71 2) ; "Uncool. This card has apparently expired. You never did get to see the room you paid for. Oh well, chances are you really didn't miss anything."
				else
					(gEgo setScript: sOpenSesame)
				)
			)
			(else
				(super doVerb: &rest)
			)
		)
	)
)

(instance brokenSlot of Feature
	(properties
		noun 11
		sightAngle 40
		approachX 177
		approachY 110
		x 198
		y 95
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 195 90 196 98 202 100 201 92
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance carpet of Feature
	(properties
		noun 16
		sightAngle 40
		x 123
		y 113
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 139 87 86 116 86 118 91 124 91 246 140
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance doorLeft of Feature
	(properties
		noun 7
		sightAngle 40
		x 54
		y 84
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 54 61 47 76 47 108 62 99 62 61
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance rightDoorFar of Feature
	(properties
		noun 7
		sightAngle 40
		x 143
		y 79
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 137 71 137 96 147 99 149 60 145 60
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance rDoorMid of Feature
	(properties
		noun 7
		sightAngle 40
		x 183
		y 88
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 185 60 173 76 173 108 194 117 194 60
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance rDoorNear of Feature
	(properties
		noun 7
		sightAngle 40
		x 253
		y 98
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 253 59 238 80 239 136 259 137 268 137 268 60
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance lLightNear of Feature
	(properties
		noun 15
		sightAngle 40
		x 39
		y 25
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 37 19 32 21 30 27 42 32 48 30
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance rLightFar of Feature
	(properties
		noun 15
		sightAngle 40
		x 155
		y 36
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 161 37 154 40 149 38 157 32
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance rLightNear of Feature ; UNUSED
	(properties
		noun 15
		sightAngle 40
		x 210
		y 22
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 222 23 203 29 199 25 205 15 216 15
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance chineseSign of Feature
	(properties
		noun 14
		sightAngle 40
		x 80
		y 6
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 73 0 87 0 87 7 81 12 73 11
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance plant of Feature
	(properties
		noun 17
		sightAngle 40
		x 121
		y 81
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 115 82 117 90 124 90 128 82 122 72
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance tyrell of Feature
	(properties
		noun 13
		sightAngle 40
		x 124
		y 4
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 112 0 119 9 137 9 137 0 yourself:)
		)
		(super init: &rest)
	)
)

(instance rSlot of Feature
	(properties
		noun 2
		sightAngle 40
		approachX 138
		approachY 100
		x 152
		y 85
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 149 82 155 82 154 88 151 87
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance leftSlotFar of Feature
	(properties
		noun 2
		sightAngle 275
		approachX 65
		approachY 106
		x 67
		y 83
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 64 81 69 80 70 85 64 87 yourself:)
		)
		(super init: &rest)
	)
)

(instance rSlotNear of Feature
	(properties
		noun 2
		sightAngle 40
		approachX 223
		approachY 137
		x 274
		y 111
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 271 104 280 106 280 119 269 115
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance rogRoomDoor of Feature
	(properties
		noun 7
		sightAngle 40
		x 9
		y 96
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 3 59 19 59 19 125 14 125 0 134 0 67
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance win of Feature
	(properties
		noun 9
		sightAngle 40
		x 104
		z 15
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 72 0 72 30 136 30 135 0 yourself:)
		)
		(super init: &rest)
	)
)

(instance burntMark of Feature
	(properties
		noun 18
		sightAngle 40
		x 224
		y 107
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 228 81 214 98 215 107 219 118 233 133 234 92
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance elevSwitch of Feature
	(properties
		noun 10
		sightAngle 0
		approachX 101
		approachY 88
		x 85
		y 89
		z 20
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 83 65 87 65 87 73 83 73 yourself:)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (not (gCurRoom script:))
					(elevDoor setScript: sRogerExits)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance exit240 of ExitFeature
	(properties
		sightAngle 40
		approachX 101
		approachY 88
		x 102
		y 86
		nextRoom 240
		message 9
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 89 54 89 87 115 87 115 54
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(9 ; ExitUp
				(if (not (gCurRoom script:))
					(elevDoor setScript: sRogerExits)
				)
			)
			(4 ; Do
				(gMessager say: 10 4) ; "The elevator's already here. Walk your lazy can over and climb in if you want to use it."
			)
		)
	)
)

(instance Nigel of SmallTalker
	(properties
		talkView 225
		talkLoop 1
	)

	(method (init)
		(= client nigel)
		(super init:)
	)
)

(instance Singent of SmallTalker
	(properties
		talkView 224
	)

	(method (init)
		(= client singent)
		(super init:)
	)
)

(instance blanketPartyTimer of Timer
	(properties)

	(method (cue)
		(gCurRoom setScript: sThugsComeIn)
		(self client: 0 delete: dispose:)
	)
)

(instance sound1 of Sound
	(properties
		flags 1
	)
)

(instance sound2 of Sound
	(properties
		flags 1
	)
)

(instance arrowSnd of Sound
	(properties
		flags 1
		number 243
	)
)

