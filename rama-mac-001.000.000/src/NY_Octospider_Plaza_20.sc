;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5320)
(include sci.sh)
(use Main)
(use Location)
(use InvInitialize)
(use newYorkRegion)
(use n1111)
(use VMDMovie)
(use Polygon)
(use Feature)
(use Sound)
(use Actor)
(use System)

(public
	NY_Octospider_Plaza_20 0
)

(instance NY_Octospider_Plaza_20 of CloseupLocation
	(properties
		picture 5361
		heading 135
	)

	(method (init)
		(proc201_1 1)
		(super init: picture)
		(self edgeW: 0 edgeE: 0)
		(prism init: global117)
		(rotationTabs init: global117)
		(prismFeat init:)
		(lock_45 init:)
		(if (IsFlag 237)
			(clampsOpen_45 init:)
		else
			(clampsClosed_45 init:)
		)
	)
)

(instance turnBase of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= temp0
					(switch global194
						(0 5370)
						(1 5371)
						(2 5372)
						(3 5373)
						(4 5374)
						(5 5375)
						(6 5376)
					)
				)
				(proc1111_7 temp0 195 103 0 0 -1 1 self)
			)
			(1
				(cond
					(register
						(if (> (++ global194) 6)
							(= global194 0)
						)
					)
					((< (-- global194) 0)
						(= global194 6)
					)
				)
				(prism cel: global194)
				(rotationTabs cel: global194)
				(UpdateScreenItem prism)
				(UpdateScreenItem rotationTabs)
				(proc1111_6)
				(= cycles 1)
			)
			(2
				(= register 0)
				(gGame handsOn:)
				(self dispose:)
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
				(proc1111_7 53612 221 97 0 0 300 1 self)
			)
			(1
				(rotationTabs dispose:)
				(prism setLoop: 2 cel: 0 x: 221 y: 222 init: global117)
				(UpdateScreenItem prism)
				(SetFlag 237)
				(proc1111_6)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance rotationTabs of View
	(properties)

	(method (init)
		(if (IsFlag 237)
			(return)
		)
		(self view: 5361 loop: 1 cel: global194 x: 195 y: 254)
		(super init: &rest)
		(self setHotspot: 2)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(gTheCursor setTempCursor: (ScriptID 0 3)) ; ramanFingerCursor
			)
			(2
				(gCurRoom setScript: turnBase 0 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance prismFeat of Feature
	(properties)

	(method (init)
		(if (IsFlag 237)
			(return)
		)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 298 107 321 107 321 171 298 171
					yourself:
				)
			setHotspot: 136
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(136
				(proc201_1 1)
				(switch global194
					(0
						(shineOnC play:)
					)
					(1
						(shineOnD play:)
					)
					(2
						(shineOnE play:)
					)
					(3
						(shineOnG play:)
					)
					(4
						(shineOnF play:)
					)
					(5
						(shineOnH play:)
					)
					(6
						(shineOnI play:)
					)
				)
				(if (== global194 0)
					(SetFlag 237)
					(clampsOpen_45 init:)
					(clampsClosed_45 dispose:)
					(prism_45 dispose:)
					(prismDown_45 init:)
					(gCurRoom setScript: unClamp)
					(self dispose:)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance prism of Prop
	(properties
		x 221
		y 97
		view 5361
	)

	(method (init)
		(cond
			((not (IsFlag 237))
				(self x: 195 y: 254 loop: 0 cel: global194)
			)
			((== (proc70_9 113) gCurRoomNum)
				(self x: 221 y: 222 loop: 2 cel: 0)
			)
			(else
				(self x: 221 y: 222 loop: 2 cel: 1)
			)
		)
		(super init: &rest)
		(if (and (IsFlag 237) (== (proc70_9 113) gCurRoomNum))
			(self setHotspot: 2)
		)
		(cond
			((== loop 0)
				(prism_45 init:)
			)
			((and (== loop 1) (not cel))
				(prismDown_45 init:)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(proc70_1 113 0)
				(= cel 1)
				(prismDown_45 dispose:)
				(self deleteHotspot:)
				(UpdateScreenItem self)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance rotateSnd of Sound ; UNUSED
	(properties
		flags 5
		number 5301
	)
)

(instance clampSnd of Sound ; UNUSED
	(properties
		flags 5
		number 5300
	)
)

(instance shineOnC of VMDMovie
	(properties
		movieName 53613
		frameRate 15
	)
)

(instance shineOnD of VMDMovie
	(properties
		movieName 53614
		frameRate 15
	)
)

(instance shineOnE of VMDMovie
	(properties
		movieName 53615
		frameRate 15
	)
)

(instance shineOnF of VMDMovie
	(properties
		movieName 53617
		frameRate 15
	)
)

(instance shineOnG of VMDMovie
	(properties
		movieName 53616
		frameRate 15
	)
)

(instance shineOnH of VMDMovie
	(properties
		movieName 53618
		frameRate 15
	)
)

(instance shineOnI of VMDMovie
	(properties
		movieName 53619
		frameRate 15
	)
)

(instance prism_45 of Feature
	(properties
		noun 3
		nsLeft 295
		nsTop 110
		nsRight 320
		nsBottom 163
		x 307
		y 136
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance clampsClosed_45 of Feature
	(properties
		noun 5
		nsLeft 282
		nsTop 162
		nsRight 331
		nsBottom 192
		x 306
		y 177
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
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
					init: 242 169 262 170 262 194 244 197
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 299 150 313 150 315 172 301 172
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 351 169 368 169 375 192 354 192
					yourself:
				)
		)
	)
)

(instance prismDown_45 of Feature
	(properties
		noun 3
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 304 172 349 189 357 202 342 208 299 190
					yourself:
				)
		)
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
					init: 135 116 180 85 199 84 248 117 249 138 206 168 183 168 136 140
					yourself:
				)
		)
	)
)

