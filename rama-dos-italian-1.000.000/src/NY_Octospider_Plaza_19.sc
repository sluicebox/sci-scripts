;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5319)
(include sci.sh)
(use Main)
(use Location)
(use InvInitialize)
(use newYorkRegion)
(use n1111)
(use Polygon)
(use Feature)
(use Sound)
(use Actor)
(use System)

(public
	NY_Octospider_Plaza_19 0
)

(instance NY_Octospider_Plaza_19 of CloseupLocation
	(properties
		heading 45
		picture 5369
	)

	(method (init)
		(super init: picture)
		(self edgeW: 0 edgeE: 0)
		(photo init: global117)
		(lock_45 init:)
		(if (IsFlag 235)
			(clampsOpen_45 init:)
		else
			(clampsClosed_45 init:)
		)
		(if (not (SetFlag 238))
			(proc1111_31 35)
		)
	)
)

(instance clamp of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 164 112 179 112 199 125 199 136 182 148 165 148 147 138 146 125
					yourself:
				)
			setHotspot: 134
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(134
				(unlockClampSound play:)
				(gCurRoom setScript: unClamp)
				(photoUp_45 dispose:)
				(photoDown_45 init:)
				(clampsClosed_45 dispose:)
				(clampsOpen_45 init:)
				(self dispose:)
				(proc201_1 2)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance photo of View
	(properties
		x 297
		y 193
		view 5369
	)

	(method (init)
		(cond
			((not (IsFlag 235))
				(= cel 0)
				(clamp init:)
			)
			((and (IsFlag 235) (== (proc70_9 108) gCurRoomNum))
				(= cel 1)
			)
			(else
				(= cel 2)
			)
		)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 275 199 318 199 323 220 271 220
					yourself:
				)
		)
		(if (== cel 1)
			(self setHotspot: 2)
		)
		(switch cel
			(0
				(photoUp_45 init:)
			)
			(1
				(photoDown_45 init:)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(proc70_1 108 0)
				(= cel 2)
				(photoDown_45 dispose:)
				(UpdateScreenItem self)
				(self deleteHotspot:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance unClamp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(proc1111_7 5369 202 112 0 0 -1 1 self)
			)
			(1
				(SetFlag 235)
				(photo cel: 1 setHotspot: 2)
				(proc70_10 108 gCurRoomNum)
				(UpdateScreenItem photo)
				(proc1111_6)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance photoUp_45 of Feature
	(properties
		noun 7
		x 297
		y 154
		nsBottom 179
		nsLeft 275
		nsRight 319
		nsTop 129
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(144
				(proc1111_31 35)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance clampsClosed_45 of Feature
	(properties
		noun 5
		x 295
		y 186
		nsBottom 199
		nsLeft 271
		nsRight 320
		nsTop 173
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance lock_45 of Feature
	(properties
		noun 6
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 119 119 165 84 187 84 237 119 238 139 192 171 169 171 120 141
					yourself:
				)
		)
	)
)

(instance photoDown_45 of Feature
	(properties
		noun 7
		x 297
		y 212
		nsBottom 225
		nsLeft 271
		nsRight 324
		nsTop 200
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(144
				(proc1111_31 35)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance clampsOpen_45 of Feature
	(properties
		noun 5
		case 2
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 210 181 227 181 229 203 210 206
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 289 155 300 156 300 178 289 177
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 361 180 376 182 380 206 362 202
					yourself:
				)
		)
	)
)

(instance unlockClampSound of Sound
	(properties
		number 5304
		flags 5
	)
)

