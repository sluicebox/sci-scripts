;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7002)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use P2Feature)
(use P2View)
(use ExitFeature)
(use P2Fidget)
(use PolyEdit)

(public
	dreamingTreeRoomCH2 0
)

(local
	[local0 2] = [20 20]
)

(instance dreamingTreeRoomCH2 of P2Room
	(properties
		picture 300
	)

	(method (init)
		(ClearFlag 1001)
		(if (IsFlag 264)
			(if (== gPrevRoomNum 3372) ; mainOfficeRoomCH2SR7
				(SetFlag 228)
				(= picture 420)
				(jocilyn init: setPri: 3)
				(therese init: setPri: 2)
				(curtis init: setPri: 1)
				(jossF init: jocilyn)
				(thereseF init: therese)
			else
				(gP2SongPlyr fadeIn: 7000)
				(SetFlag 1001)
				(curtisAlone init: setPri: 2)
				(maxProp init: setPri: 1)
				(or (firstMax init: maxProp) (secondMax init: maxProp))
				(chair init:)
				(doorFeature
					init: (proc63002_10 339 132 339 18 367 12 403 40 403 132)
				)
				(menuFeature init:)
			)
		else
			(SetFlag 1001)
			(gP2SongPlyr start: 910)
			(= picture 421)
			(= south 900)
		)
		(super init: &rest)
		(gGame handsOn: 1)
	)

	(method (newRoom newRoomNumber)
		(super newRoom: newRoomNumber)
		(if (== newRoomNumber 2112) ; livingRoomCH2SR1
			(SetFlag 1001)
		)
	)
)

(instance jocilyn of P2Fidget
	(properties
		x 265
		y 340
		view 14201
		initStart 2
		initFinish 4
		cycleStart 20
		cycleFinish 40
	)

	(method (dispose)
		(super dispose:)
		(jossChair init:)
	)
)

(instance jossChair of View
	(properties
		x 266
		y 245
		view 420
	)
)

(instance therese of P2Fidget
	(properties
		x 99
		y 339
		view 14202
		initStart 1
		initFinish 3
		cycleStart 20
		cycleFinish 40
	)
)

(instance curtis of P2Fidget
	(properties
		x 379
		y 220
		view 14200
		initStart 0
		initFinish 2
		cycleStart 20
		cycleFinish 40
	)
)

(instance jossF of P2Feature
	(properties
		scene 8970
	)

	(method (handleEvent)
		(if (super handleEvent: &rest)
			(if (== scene 8990)
				(if (== (thereseF scene:) 9070)
					(thereseF scene: 9020)
				)
			else
				(= scene 8990)
				(= doneFlag 245)
			)
		)
	)
)

(instance thereseF of ExitFeature
	(properties
		scene 9000
	)

	(method (handleEvent)
		(if (super handleEvent: &rest)
			(cond
				((== scene 9000)
					(= scene (if (IsFlag 245) 9020 else 9070))
				)
				((== scene 9020)
					(= scene 0)
					(= doneFlag 221)
					(= exitScene 9060)
					(= nextRoom 2112)
				)
				((== scene 9070)
					(= scene 0)
					(= doneFlag 221)
					(= exitScene 9060)
					(= nextRoom 2112)
					(jossF dispose:)
				)
				(else 0)
			)
		)
	)

	(method (dispose)
		(= target 0)
		(super dispose:)
	)
)

(instance curtisAlone of P2Fidget
	(properties
		x 386
		y 339
		view 13000
		initStart 7
		cycleStart 10
		cycleFinish 20
	)

	(method (init)
		(super init: &rest)
		(if (Random 0 1)
			(= view 13006)
			(self posn: 383 339)
		)
	)
)

(instance maxProp of P2Fidget
	(properties
		x 261
		y 316
		view 13005
		initStart 7
		cycleStart 10
		cycleFinish 13
	)
)

(instance firstMax of P2Feature
	(properties
		scene 9080
		doneFlag 246
	)

	(method (handleEvent)
		(if (super handleEvent: &rest)
			(secondMax init: maxProp)
		)
	)

	(method (dispose)
		(= responder (= target 0))
		(super dispose: &rest)
	)
)

(instance secondMax of P2Feature
	(properties
		scene 9110
		doneFlag 247
	)

	(method (dispose)
		(= responder (= target 0))
		(super dispose: &rest)
	)
)

(instance menuFeature of P2View
	(properties
		priority 8
		x 395
		y 233
		view 300
		loop 2
		nextRoom 7010
	)

	(method (init)
		(super init: &rest)
		(if target
			(target setPri: 8)
		)
	)
)

(instance curtis2 of P2Fidget ; UNUSED
	(properties
		x 386
		y 339
		view 13000
		initStart 7
		cycleStart 10
		cycleFinish 20
	)

	(method (init)
		(super init: &rest)
		(if (Random 0 1)
			(= view 13006)
			(self posn: 383 339)
		)
	)
)

(instance doorFeature of ExitFeature
	(properties
		nextRoom 900
		exitDir 0
	)

	(method (handleEvent)
		(if (super handleEvent: &rest)
			(SetFlag 110)
		)
	)
)

(instance chair of P2View
	(properties
		x 180
		y 223
		view 300
		loop 3
	)

	(method (init)
		(super init: &rest)
		(self isHot: 0)
		(target setPri: 3 update:)
	)
)

