;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6107)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use InvInitialize)
(use KeyPadButn)
(use n1111)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	avianSecurity7 0
)

(local
	[local0 6] = [2 1688 1 3138 -1 -1]
	local6
)

(procedure (localproc_0 param1 &tmp temp0 temp1)
	(for ((= temp1 0)) (!= temp0 -1) ((+= temp1 2)) ; UNINIT
		(= temp0 [local0 temp1])
		(if (== [local0 (+ temp1 1)] param1)
			(break)
		)
	)
	(if (OneOf temp0 1 2)
		(if (and (== temp0 1) (IsFlag 122))
			(ledges hide:)
			(ledgesSound play:)
			(ClearFlag 122)
		)
		(if (and (== temp0 2) (not (IsFlag 122)))
			(ledges show:)
			(ledgesSound play:)
			(SetFlag 122)
		)
	)
)

(class LedgeKeyPadButn of KeyPadButn
	(properties)

	(method (init)
		(super init: &rest)
		(self setPri: 500)
		(&= signal $efff)
	)

	(method (onMe param1 &tmp temp0)
		(if
			(and
				(= temp0 (super onMe: param1))
				(proc1111_24 135)
				(& (param1 type:) $0001)
			)
			(proc1111_31 44 16)
		)
		(return (and (or (not (param1 type:)) (IsFlag 135)) temp0))
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(= local6 (& (= local6 (| (<<= local6 $0004) myValue)) $0fff))
				(if (IsFlag 135)
					(localproc_0 local6)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance avianSecurity7 of Location
	(properties)

	(method (init)
		(super init:)
		(Load rsAUDIO 6001)
		(Load rsAUDIO 6002)
		(Load rsAUDIO 6102)
		(= plane global116)
		(self addPicObj: faceS faceN faceS)
	)
)

(instance faceS of CameraAngle
	(properties
		picture 6161
		heading 180
		edgeN 0
		edgeS 0
	)

	(method (init)
		(super init: &rest)
		(if (not (IsFlag 135))
			(idCardSlot init:)
		else
			(keyCard cel: 5 init: global117)
		)
		(ledges init: global117)
		(key1 init: global117)
		(key2 init: global117)
		(key3 init: global117)
		(key4 init: global117)
		(key5 init: global117)
		(key6 init: global117)
		(key7 init: global117)
		(key8 init: global117)
		(key9 init: global117)
		(key10 init: global117)
		(key11 init: global117)
		(key12 init: global117)
		(key13 init: global117)
		(key14 init: global117)
		(key15 init: global117)
		(key0 init: global117)
		(ledgeDisplay_180 init:)
		(cardSlot_180 init:)
	)
)

(instance faceN of CameraAngle
	(properties
		picture 6162
		edgeN 0
		edgeS 0
	)

	(method (init)
		(defaultExit nextRoom: 6106 init:)
		(gCurRoom exitN: defaultExit)
		(super init:)
	)
)

(instance defaultExit of ExitFeature
	(properties)
)

(instance idCardSlot of Feature
	(properties
		nsLeft 329
		nsTop 222
		nsRight 450
		nsBottom 263
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 23)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(23
				(SetFlag 135)
				(self deleteHotspot:)
				(insertMirmId play:)
				(keyCard init: global117 setCycle: End)
				(proc70_3 81)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance keyCard of Prop
	(properties
		x 361
		y 244
		priority 500
		fixPriority 1
		view 6162
		loop 4
	)
)

(instance ledges of View
	(properties
		x 191
		y 24
		view 6162
		loop 2
	)

	(method (init)
		(super init: &rest)
		(self setPri: 500)
		(if (not (IsFlag 122))
			(self hide:)
		)
	)
)

(instance key1 of LedgeKeyPadButn
	(properties
		x 312
		y 42
		view 6162
		myValue 1
		downLoop 1
	)
)

(instance key2 of LedgeKeyPadButn
	(properties
		x 340
		y 42
		view 6162
		cel 1
		myValue 2
		downLoop 1
	)
)

(instance key3 of LedgeKeyPadButn
	(properties
		x 368
		y 42
		view 6162
		cel 2
		myValue 3
		downLoop 1
	)
)

(instance key4 of LedgeKeyPadButn
	(properties
		x 396
		y 42
		view 6162
		cel 3
		myValue 4
		downLoop 1
	)
)

(instance key5 of LedgeKeyPadButn
	(properties
		x 312
		y 73
		view 6162
		cel 4
		myValue 5
		downLoop 1
	)
)

(instance key6 of LedgeKeyPadButn
	(properties
		x 340
		y 73
		view 6162
		cel 5
		myValue 6
		downLoop 1
	)
)

(instance key7 of LedgeKeyPadButn
	(properties
		x 368
		y 73
		view 6162
		cel 6
		myValue 7
		downLoop 1
	)
)

(instance key8 of LedgeKeyPadButn
	(properties
		x 396
		y 73
		view 6162
		cel 7
		myValue 8
		downLoop 1
	)
)

(instance key9 of LedgeKeyPadButn
	(properties
		x 312
		y 103
		view 6162
		cel 8
		myValue 9
		downLoop 1
	)
)

(instance key10 of LedgeKeyPadButn
	(properties
		x 340
		y 103
		view 6162
		cel 9
		myValue 10
		downLoop 1
	)
)

(instance key11 of LedgeKeyPadButn
	(properties
		x 368
		y 103
		view 6162
		cel 10
		myValue 11
		downLoop 1
	)
)

(instance key12 of LedgeKeyPadButn
	(properties
		x 396
		y 103
		view 6162
		cel 11
		myValue 12
		downLoop 1
	)
)

(instance key13 of LedgeKeyPadButn
	(properties
		x 312
		y 134
		view 6162
		cel 12
		myValue 13
		downLoop 1
	)
)

(instance key14 of LedgeKeyPadButn
	(properties
		x 340
		y 134
		view 6162
		cel 13
		myValue 14
		downLoop 1
	)
)

(instance key15 of LedgeKeyPadButn
	(properties
		x 368
		y 134
		view 6162
		cel 14
		myValue 15
		downLoop 1
	)
)

(instance key0 of LedgeKeyPadButn
	(properties
		x 396
		y 134
		view 6162
		cel 15
		downLoop 1
	)
)

(instance ledgesSound of Sound
	(properties
		flags 5
		number 6108
	)
)

(instance insertMirmId of Sound
	(properties
		flags 5
		number 6107
	)
)

(instance ledgeDisplay_180 of Feature
	(properties
		noun 59
		nsLeft 187
		nsTop 9
		nsRight 277
		nsBottom 212
		x 232
		y 110
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance cardSlot_180 of Feature
	(properties
		noun 60
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 335 236 427 235 435 254 336 253
					yourself:
				)
		)
	)
)

