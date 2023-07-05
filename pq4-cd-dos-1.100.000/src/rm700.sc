;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 700)
(include sci.sh)
(use Main)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm700 0
)

(local
	local0
)

(instance rm700 of Room
	(properties
		noun 2
		picture 700
		style 9
	)

	(method (doRemap)
		(gGame doRemap: 2 253 85)
		(gGame doRemap: 2 254 75)
	)

	(method (init)
		(proc0_4 1)
		(= gDay 6)
		(super init: &rest)
		(LoadMany rsVIEW 0 5)
		(self
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 169 131 233 131 232 99 206 99
					yourself:
				)
		)
		(gEgo
			view: 9700
			loop: 0
			cel: 0
			posn: 164 143
			scaleSignal: 1
			scaleX: 152
			scaleY: 152
			fixPriority: 0
			init:
		)
		(dog init:)
		(door init: approachVerbs: 4 63) ; Do, casePryBar
		(dogDoor init:)
		(gate init:)
		(boxes init:)
		(gWalkHandler addToFront: self)
		(self setScript: comeIn)
	)

	(method (handleEvent event)
		(if (& (event type:) evMOVE)
			(if (< (event y:) 100)
				(gEgo setMotion: PolyPath 200 99 self)
				(event claimed: 1)
				(return)
			else
				(event claimed: 0)
				(return)
			)
		else
			(super handleEvent: event)
			(return)
		)
	)

	(method (cue)
		(gMessager say: 3 4 0 1) ; "The gate has been welded shut. The exit is no use."
	)

	(method (doit)
		(super doit:)
		(cond
			(script 0)
			((<= (gEgo y:) 130)
				(if local0
					(= local0 0)
				)
			)
			((and (> (gEgo y:) 130) (not local0))
				(= local0 1)
				(gMessager say: 4 3 0 1) ; "After what you just went through to get here, there's no going back!"
			)
		)
	)

	(method (dispose)
		(gGlobalSound1 client: 0)
		(gWalkHandler delete: self)
		(super dispose:)
	)
)

(instance comeIn of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (not (dog loop:)) (== (dog cel:) 9))
			(dogDoor setCycle: End)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setCycle: End)
				(dog setCycle: End self)
			)
			(1
				(gEgo loop: 1 cel: 0 setCycle: End)
				(dog loop: 1 cel: 0 setCycle: End self)
			)
			(2
				(LoadMany rsVIEW 0 5)
				(dog dispose:)
				(gEgo
					put: 30 ; rope
					view: 0
					loop: 3
					posn: 170 130
					setScaler: Scaler 100 76 130 100
					heading: 0
					normalize: 0 3
				)
				(= cycles 3)
			)
			(3
				(dogDoor setCycle: Beg)
				(= ticks 60)
			)
			(4
				(gGlobalSound0 number: 150 loop: -1 play:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance openDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(LoadMany rsVIEW 9701)
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gEgo
					view: 9701
					loop: 0
					cel: 0
					posn: 191 101
					scaleSignal: 1
					scaleX: 101
					scaleY: 101
					setCycle: End self
				)
			)
			(2
				(gEgo loop: 1 cel: 0 setCycle: CT 7 1 self)
			)
			(3
				(gEgo setCycle: End self)
				(theDoor
					view: 9701
					loop: 2
					cel: 0
					posn: 186 94
					ignoreActors:
					init:
					setCycle: End
				)
				(gGlobalSound1 number: 1015 loop: 1 play:)
			)
			(4
				(gGlobalSound1 stop:)
				(gCurRoom newRoom: 710)
			)
		)
	)
)

(instance knock of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 197 101 self)
			)
			(1
				(gEgo setHeading: 315 self)
			)
			(2
				(gEgo view: 9009 loop: 0 cel: 0 setCycle: End self)
			)
			(3
				(gEgo view: 0 heading: 180 normalize: 0)
				(dogSound number: 995 loop: 1 play:)
				(= ticks 60)
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance talkDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gMessager say: 1 2 0 1 self) ; "Hello! LAPD! Anybody home?! Open the door! Hello!"
			)
			(2
				(dogSound number: 995 loop: 1 play: self)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance dog of Prop
	(properties
		x 201
		y 119
		view 700
		signal 16385
	)
)

(instance door of Feature
	(properties
		noun 1
		approachX 200
		approachY 100
		x 194
		y 23
	)

	(method (init)
		(super init:)
		(= onMeCheck
			((Polygon new:)
				type: PBarredAccess
				init: 176 10 189 22 189 89 167 94 169 10
				yourself:
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(63 ; casePryBar
				(gGame points: 3)
				(gCurRoom setScript: openDoor)
			)
			(2 ; Talk
				(gCurRoom setScript: talkDoor)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance gate of Feature
	(properties
		noun 3
		x 220
		y 62
	)

	(method (init)
		(super init:)
		(= onMeCheck
			((Polygon new:)
				type: PBarredAccess
				init: 206 94 207 61 209 58 212 53 221 47 230 47 237 49 243 55 248 62 248 94
				yourself:
			)
		)
		(gWalkHandler addToFront: self)
	)

	(method (handleEvent event)
		(if (and (& (event type:) evMOVE) (self onMe: event))
			(gMessager say: 3 4 0 1) ; "The gate has been welded shut. The exit is no use."
			(event claimed: 1)
			(return)
		else
			(super handleEvent: event)
			(return)
		)
	)

	(method (dispose)
		(gWalkHandler delete: self)
		(super dispose:)
	)
)

(instance boxes of Feature
	(properties
		noun 4
		x 189
		y 189
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 66 84 88 77 88 107 93 108 106 108 107 97 116 89 120 88 118 85 137 85 146 76 148 78 155 69 159 68 164 76 164 84 165 117 189 117 199 121 202 123 202 127 215 127 221 120 225 122 229 127 222 134 222 142 227 142 231 144 232 137 239 136 262 136 267 142 267 147 62 147 62 127 63 122 64 112
					yourself:
				)
		)
	)
)

(instance dogDoor of Prop
	(properties
		noun 5
		x 179
		y 87
		view 701
		signal 16385
	)
)

(instance theDoor of Prop
	(properties)
)

(instance dogSound of Sound
	(properties)
)

