;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6322)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use P2Feature)
(use P2Fidget)
(use Cycle)
(use Jump)
(use System)

(public
	blBoothCH2SR2 0
)

(instance blBoothCH2SR2 of P2Room
	(properties
		picture 480
	)

	(method (init)
		(super init: &rest)
		(curtis init:)
		(therese init:)
		(curtis setPri: 20)
		(therese setPri: 10)
		(curtis setCycle: curtisCycle 10 1)
		(piercerFeature init:)
		(piercerFidget init:)
		(gGame handsOn: 1)
	)
)

(instance piercerFeature of P2Feature
	(properties)

	(method (init)
		(= whoDoit piercerCode)
		(super init: 453 12 510 183)
	)
)

(instance piercerCode of Code
	(properties)

	(method (doit)
		(SetFlag 262)
		(getPiercedCode doit: 7930)
	)
)

(instance getPiercedCode of Code
	(properties)

	(method (doit param1)
		(if (== global207 1)
			(SetFlag 265)
			(gSceneList add: param1 7965)
		else
			(SetFlag 203)
			(gSceneList add: param1 7960)
		)
		(gCurRoom newRoom: 2032) ; bedRoomCH2SR3
	)
)

(instance therese of Prop
	(properties
		x 117
		y 338
		view 14801
		cycleSpeed 5
	)
)

(instance curtis of Prop
	(properties
		x 207
		y 338
		view 14800
		cycleSpeed 7
	)
)

(instance piercerFidget of P2Fidget
	(properties
		x 442
		y 222
		view 14805
		initStart 0
		initFinish 0
		cycleStart 3
		cycleFinish 4
	)

	(method (init)
		(super init: &rest)
		(self setPri: 10)
	)
)

(instance timeElapsedCode of Code
	(properties)

	(method (doit)
		(SetFlag 263)
		(getPiercedCode doit: 7940)
	)
)

(instance thereseCycle of End
	(properties)

	(method (cycleDone)
		(super cycleDone: &rest)
		(Send new: timeElapsedCode 9)
	)
)

(instance curtisCycle of CT
	(properties)

	(method (nextCel &tmp temp0 temp1)
		(= temp1 (client cel:))
		(= temp0 (super nextCel:))
		(= completed 0)
		(if (== temp0 endCel)
			(switch cycleDir
				(1
					(= endCel 0)
					(= cycleDir -1)
				)
				(-1
					(= completed 1)
				)
			)
		)
		(return temp0)
	)

	(method (cycleDone)
		(super cycleDone: &rest)
		(curtis setPri: 10)
		(therese setPri: 20)
		(curtis setLoop: 1)
		(therese setCycle: thereseCycle (therese lastCel:) 1)
	)
)

