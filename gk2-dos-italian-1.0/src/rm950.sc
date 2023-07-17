;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 950)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use FidgetScript)
(use Scaler)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	rm950 0
)

(local
	local0
	local1
	local2
)

(instance rm950 of ExitRoom ; "Neuschwanstein: Living Room"
	(properties
		noun 22
		picture 9501
	)

	(method (init)
		(gEgo
			posn: 367 307
			heading: (if (OneOf gPrevRoomNum 920 921) 135 else 315) ; bed2
			sel_737:
			setScaler: Scaler 94 37 375 250
			init:
		)
		(if (== gChapter 4)
			(tourTapeButton init:)
		)
		(super init: &rest)
		(if (== gChapter 6)
			(cond
				((and (IsFlag 787) (not (IsFlag 732)))
					(= local0 1)
				)
				((and (IsFlag 732) (not (IsFlag 733)) (IsFlag 805))
					(ClearFlag 787)
					(ClearFlag 732)
					(SetFlag 733)
					(SetFlag 786)
				)
				((IsFlag 732)
					(guard2 view: 20778 posn: 246 278 cel: 0)
					(SetFlag 786)
				)
			)
		else
			(painting init:)
			(self setScript: guardRotates)
		)
		(if (IsFlag 786)
			(guard2 init: setScript: FidgetScript)
		)
		(if (not (IsFlag 732))
			(self setScript: guardRotates)
		)
		(fTableLinen init:)
		(chairTable init:)
		(door init:)
		(exitSE init:)
	)

	(method (newRoom newRoomNumber)
		(if (and local0 (!= newRoomNumber 9510)) ; neuLRChair
			(SetFlag 732)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance guardRotates of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOn:)
				(= seconds (Random 15 22))
			)
			(1
				(gGame handsOff:)
				(cond
					((= register (gCast contains: guard2))
						(ClearFlag 786)
						(guard2 setScript: 0 setCycle: Beg self)
					)
					((not local2)
						(SetFlag 786)
						(PlayRobot 20950 205 118 self)
					)
					(else
						(-- state)
						(= seconds 2)
					)
				)
			)
			(2
				(if (not local1)
					(= state -1)
				)
				(if register
					(if (not local2)
						(guard2 dispose:)
						(PlayRobot 22950 205 118 self)
					else
						(= state 1)
						(= seconds 2)
					)
				else
					(= ticks 1)
					(guard2 init: setScript: FidgetScript)
				)
			)
			(3
				(gEgo setHeading: 135 self)
			)
			(4
				(gCurRoom newRoom: 9502) ; neuLRStool
			)
		)
	)
)

(instance fTableLinen of GKFeature
	(properties
		noun 16
		modNum 950
	)

	(method (handleEvent event)
		(if (self onMe: event)
			(= global141 self)
		)
		(super handleEvent: event)
	)

	(method (init)
		(super init: &rest)
		(self
			createPoly:
				77
				219
				206
				210
				241
				219
				244
				261
				151
				277
				151
				304
				130
				328
				127
				293
				64
				292
				85
				273
				78
				268
		)
		(if (IsFlag 732)
			(= noun 15)
		)
	)
)

(instance chairTable of GKFeature
	(properties
		x 271
		y 202
		BAD_SELECTOR 9510
	)

	(method (handleEvent event)
		(if (and (self onMe: event) (IsFlag 732))
			(= global141 self)
		)
		(super handleEvent: event &rest)
	)

	(method (init)
		(if (IsFlag 732)
			(= noun 15)
			(= BAD_SELECTOR 0)
		)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 248 166 240 217 245 256 300 256 302 172 272 149
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (and (== theVerb 100) (not (IsFlag 787))) ; invBottleOfWater
			(= theVerb 62) ; Do
		)
		(super doVerb: theVerb)
	)
)

(instance door of ExitFeature
	(properties
		x 228
		y 163
		BAD_SELECTOR 920
		BAD_SELECTOR 7
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 219 109 204 123 205 209 240 217 252 157 253 129 242 111
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance exitSE of ExitFeature
	(properties
		nsLeft 576
		nsTop 15
		nsRight 640
		nsBottom 334
		x 640
		y 320
		BAD_SELECTOR 9502
		BAD_SELECTOR 3
	)

	(method (handleEvent event)
		(if
			(and
				(self onMe: event)
				(IsFlag 786)
				(not (IsFlag 731))
				(not local1)
			)
			(= local1 1)
			(guardRotates changeState: 1)
		else
			(super handleEvent: event)
		)
	)
)

(instance painting of GKFeature
	(properties
		x 90
		y 95
		BAD_SELECTOR 9540
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 180 51 177 173 0 175 0 16
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance guard2 of Prop
	(properties
		modNum 910
		sightAngle 360
		x 403
		y 295
		view 21950
	)

	(method (doVerb theVerb)
		(= noun
			(cond
				((== gChapter 4)
					(if (== theVerb 62) ; Do
						1
					else
						(= theVerb 0)
						2
					)
				)
				((IsFlag 732)
					(= theVerb 62) ; Do
					(= modNum 950)
					17
				)
				((== theVerb 31) ; invDove
					(= modNum 910)
					19
				)
				(else
					(= modNum 910)
					(= theVerb 62) ; Do
					18
				)
			)
		)
		(super doVerb: theVerb)
	)
)

(instance tourTapeButton of Prop
	(properties
		noun 1
		sightAngle 360
		x 10
		y 290
		view 141
	)

	(method (cue)
		(= local2 0)
		(gGame changeScore: 991)
	)

	(method (doVerb theVerb &tmp temp0)
		(if (== theVerb 62) ; Do
			(= local2 1)
			(= temp0 (if (IsFlag 586) 4 else 5))
			(gMessager sayRange: noun theVerb 0 1 temp0 self) ; "This is the king's living room. The walls are decorated with scenes from the "Lohengrin" saga. The king first saw Wagner's opera "Lohengrin" when he was 16, and it so affected him that he considered it a form of enlightenment."
			(SetFlag 586)
		else
			(super doVerb: theVerb)
		)
	)
)

