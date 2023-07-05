;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 735)
(include sci.sh)
(use Main)
(use Inset)
(use Polygon)
(use Feature)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm735 0
)

(local
	local0
	local1
)

(instance rm735 of Room
	(properties
		noun 1
		picture 735
	)

	(method (init)
		(super init: &rest)
		(medCab init:)
		(cups init:)
		(hallway init:)
		(faucets init:)
		(counter init:)
		(mirror init:)
		(sink init:)
		(gEgo
			setScale: 0
			view: 735
			setLoop: 0
			signal: (| (gEgo signal:) $1000)
			posn: 129 158
			init:
		)
		(egoReflect setLoop: 0 signal: (| (egoReflect signal:) $1000) init:)
		(gMouseDownHandler addToFront: self)
		(gWalkHandler addToFront: self)
		(self setScript: comeIn)
	)

	(method (handleEvent event)
		(cond
			((and inset (inset handleEvent: event)) 0)
			((& (event type:) evMOVE)
				(if (< (event x:) 80)
					(self setScript: leaveRoom)
				else
					(gMessager say: 1 3 0 0) ; "There's no place to move, this room is tiny."
				)
				(event claimed: 1)
				(return)
			)
			(
				(and
					(== (gTheIconBar curIcon:) (gTheIconBar at: 1))
					(not (event modifiers:))
					(not inset)
				)
				(cond
					((and (local0 cel:) (> (event x:) 170))
						(local0 setCycle: Beg)
						(local1 setCycle: Beg)
					)
					((and (not (local0 cel:)) (< (event x:) 105))
						(local0 setCycle: End)
						(local1 setCycle: End)
					)
				)
				(event claimed: 0)
				(return)
			)
			(else
				(event claimed: 0)
				(return)
			)
		)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(gWalkHandler delete: self)
		(super dispose:)
	)
)

(instance comeIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setCycle: End self)
				(egoReflect setCycle: End)
			)
			(1
				((= local0 (Actor new:))
					name: {egoHead}
					view: 736
					loop: 1
					cel: 0
					posn: 130 52
					signal: (gEgo signal:)
					init:
					actions: gEgo
					sightAngle: 360
				)
				((= local1 (Actor new:))
					name: {egoHead}
					view: 739
					loop: 1
					cel: 0
					posn: 289 55
					signal: (egoReflect signal:)
					init:
					actions: egoReflect
					sightAngle: 360
				)
				(gEgo view: 736 loop: 0 cel: 0 posn: 129 158)
				(egoReflect view: 739 loop: 0 cel: 0 posn: 259 156)
				(= cycles 1)
			)
			(2
				(gGame handsOn:)
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
				(local0 setCycle: End self)
				(local1 setCycle: End)
			)
			(1
				(local0 actions: 0)
				(local1 actions: 0)
				(gCurRoom newRoom: 750)
			)
		)
	)
)

(instance openCabinet of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(local0 setCycle: End self)
				(local1 setCycle: End)
			)
			(1
				(gGame handsOn:)
				(gCurRoom setInset: medInset self)
			)
			(2
				(gGame handsOff:)
				(gEgo posn: 129 158 view: 736 loop: 0 cel: 0)
				(local0 setCycle: Beg self)
				(local1 setCycle: Beg)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance egoReflect of Prop
	(properties
		noun 4
		sightAngle 360
		x 255
		y 156
		view 738
	)
)

(instance cups of Feature
	(properties
		noun 7
		sightAngle 360
		x 303
		y 157
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 292 40 314 40 314 49 311 46 311 63 292 63
					yourself:
				)
		)
	)
)

(instance hallway of Feature
	(properties
		noun 3
		nsRight 81
		nsBottom 151
		sightAngle 360
		x 48
		y 22
	)
)

(instance faucets of Feature
	(properties
		noun 5
		sightAngle 360
		x 223
		y 130
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 196 121 204 120 206 117 208 115 211 115 214 117 215 120 223 120 223 125 223 129 215 130 213 128 211 128 208 126 203 124 202 124 197 124
					yourself:
				)
		)
	)
)

(instance counter of Feature
	(properties
		noun 8
		sightAngle 360
		x 209
		y 107
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 110 89 179 86 299 118 296 153 172 152 108 113
					yourself:
				)
		)
	)
)

(instance mirror of Feature
	(properties
		noun 4
		sightAngle 360
		x 235
		y 29
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 181 12 257 0 306 0 299 115 181 86
					yourself:
				)
		)
	)
)

(instance sink of Feature
	(properties
		noun 6
		sightAngle 360
		x 185
		y 129
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 142 122 202 117 240 132 172 139
					yourself:
				)
		)
	)
)

(instance medCab of Feature
	(properties
		noun 2
		sightAngle 360
		x 139
		y 12
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 117 3 167 6 169 8 169 68 164 72 115 72 111 70 111 6
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gCurRoom setScript: openCabinet)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance medInset of Inset
	(properties
		picture 740
		disposeNotOnMe 1
		modNum 740
		noun 1
	)

	(method (init)
		(gGame fade: 100 0 10)
		(gTheIconBar disable: 3 7 show: 0)
		(super init: &rest)
		(medCabDoor init:)
		(if
			(and
				(not (gEgo has: 29)) ; hairspray
				(not (gEgo has: 34)) ; torch
				(gPqFlags test: 123)
			)
			(theHairspray init:)
		)
		(FrameOut)
		(gGame fade: 0 100 10)
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 4 1 41) ; Do, Look, lighter
			(if (and (not (gEgo has: 29)) (gPqFlags test: 123)) ; hairspray
				(gMessager say: noun theVerb 2 0 0 modNum)
			else
				(gMessager say: noun theVerb 0 0 0 modNum)
			)
		else
			(super doVerb: theVerb)
		)
	)

	(method (onMe param1)
		(return (and (<= 40 (param1 x:) 281) (<= 0 (param1 y:) 148)))
	)

	(method (doit)
		(if script
			(script doit:)
		)
	)

	(method (dispose)
		(gGame fade: 100 0 10)
		(gTheIconBar enable: 3 7)
		(super dispose:)
		(FrameOut (gCast elements:) 0)
		(gGame fade: 0 100 10)
	)
)

(instance theHairspray of View
	(properties
		noun 2
		modNum 740
		x 109
		y 127
		view 1740
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gGame points: 2)
			(gEgo get: 29) ; hairspray
			(self dispose:)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance medCabDoor of Feature
	(properties
		noun 3
		modNum 740
		x 139
		y 12
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 151 11 176 1 182 1 182 17 180 143 178 145 174 145 151 134
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(medInset dispose:)
		else
			(super doVerb: theVerb)
		)
	)
)

