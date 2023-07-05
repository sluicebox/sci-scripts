;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9400)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use P2Feature)
(use ExitFeature)
(use P2Fidget)
(use BorderWindow)
(use Cycle)
(use Jump)
(use System)

(public
	humanThresholdRm 0
)

(instance humanThresholdRm of P2Room
	(properties
		picture 940
	)

	(method (init)
		(if (== gPrevRoomNum 999) ; poorSadDeadCrazyAlienSucker
			(= picture 920)
			(super init: &rest)
			(hecMom init:)
			(hecMomButton init:)
			(zapS init:)
		else
			(southExit init: 0 300 160 406)
			(gP2SongPlyr start: 9400)
			(buttonF init: 214 174 318 223)
			(curtis init:)
			(ballP init: setCycle: Fwd)
			(super init: &rest)
		)
	)

	(method (dispose)
		(zapS dispose:)
		(super dispose: &rest)
	)
)

(instance buttonF of P2Feature
	(properties
		doneFlag 742
	)

	(method (init)
		(= whoDoit buttonAloneCode)
		(super init: &rest)
	)
)

(instance buttonAloneCode of Code
	(properties)

	(method (doit)
		(gP2SongPlyr fadeOut: 0)
		(proc63002_7 6610)
		(gP2SongPlyr start: 6630)
		(southExit dispose:)
		(paul init:)
		(curtis view: 19404 posn: 233 338)
	)
)

(instance southExit of ExitFeature
	(properties
		nextRoom 9500
		exitDir 5
	)
)

(instance curtis of P2Fidget
	(properties
		x 62
		y 338
		view 19402
		cycleSpeed 4
		initStart 1
		initFinish 2
		cycleStart 2
		cycleFinish 4
	)
)

(instance paul of P2Fidget
	(properties
		x 73
		y 350
		view 19405
		cycleSpeed 4
		initStart 0
		initFinish 0
		cycleStart 2
		cycleFinish 4
	)

	(method (init)
		(super init: &rest)
		(paulFeat init:)
	)
)

(instance paulFeat of P2Feature
	(properties
		priority 100
	)

	(method (init)
		(super init: 70 35 180 330)
		(= whoDoit onPaul)
	)

	(method (handleEvent event)
		(if (and (super handleEvent: event) (IsFlag 744))
			(self dispose:)
		)
		(event claimed:)
	)
)

(instance onPaul of Code
	(properties)

	(method (doit)
		(if (IsFlag 743)
			(= global211 1)
			(= global212 0)
			(proc63002_7 6630)
			(SetFlag 744)
			(paul dispose:)
			(gCurRoom drawPic: 920)
			(curtis dispose:)
			(ballP dispose:)
			(hec init: setCycle: Fwd)
			(hecButton init:)
			(gP2SongPlyr start: 6630)
		else
			(= global211 (= global212 1))
			(proc63002_7 6620)
			(SetFlag 743)
		)
	)
)

(instance ballP of Prop
	(properties
		x 437
		y 122
		view 19407
	)
)

(instance hec of Prop
	(properties
		x 174
		y 319
		view 19202
	)

	(method (init)
		(super init: &rest)
		(hecFeat init: 400 20 490 317)
	)
)

(instance hecFeat of P2Feature
	(properties)

	(method (init)
		(super init: &rest)
		(= whoDoit onHec)
	)
)

(instance onHec of Code
	(properties)

	(method (doit)
		(if (IsFlag 745)
			(gP2SongPlyr fadeOut: 0)
			(proc63002_7 6650)
			(hec dispose:)
			(if (not (IsFlag 768))
				(hecButton dispose:)
			)
			(hecMom init:)
			(hecMomButton init:)
			(gP2SongPlyr start: 6650)
			(zapS init:)
		else
			(gP2SongPlyr fadeOut: 0)
			(proc63002_7 6640)
			(gP2SongPlyr start: 6640)
			(SetFlag 745)
			(hecFeat doneFlag: 746)
		)
	)
)

(instance hecButton of P2Feature
	(properties
		scene 6611
		doneFlag 768
	)

	(method (init)
		(super init: 282 147 347 187)
	)
)

(instance hecMom of P2Fidget
	(properties
		x 185
		y 100
		view 19200
		initStart 0
		initFinish 0
		cycleStart 0
		cycleFinish 0
	)

	(method (init)
		(super init: &rest)
	)
)

(instance hecMomButton of P2Feature
	(properties)

	(method (init)
		(super init: 282 147 347 187)
		(= whoDoit momCode)
	)
)

(instance momCode of Code
	(properties)

	(method (doit &tmp temp0)
		(zapS dispose:)
		(gP2SongPlyr fadeOut: 0)
		(= global209 6670)
		(for ((= temp0 0)) (<= temp0 38) ((++ temp0))
			(gEgo put: temp0)
		)
		(gCurRoom newRoom: 42020)
	)
)

(instance zapS of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 6)
			)
			(1
				(= global209 6660)
				(gCurRoom newRoom: 999) ; poorSadDeadCrazyAlienSucker
			)
		)
	)
)

