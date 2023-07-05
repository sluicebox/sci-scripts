;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 50200)
(include sci.sh)
(use Main)
(use oHandsOnWhenCued)
(use TPSound)
(use foEExit)
(use Plane)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	roAirDuct1 0
)

(local
	nCurY
	bShownMenuBonk
	menuTrigger
	headOffset
	nBoogleDist = 100
	bTrigger1
	bTrigger2
	bPlayedLeftSound = 1
	bPlayedRightSound
)

(procedure (CrawlTorin nX oCueParm &tmp oCuee)
	(if (> argc 1)
		(= oCuee oCueParm)
	else
		(= oCuee 0)
	)
	(if (== nX (aoTorinCrawls x:))
		(return)
	)
	(if (> nX (aoTorinCrawls x:))
		(oTorinCycle cycleDir: -1)
	else
		(oTorinCycle cycleDir: 1)
	)
	(aoTorinCrawls setMotion: MoveTo nX nCurY oCuee)
	((ScriptID 64018 0) setMotion: MoveTo (+ nX nBoogleDist) nCurY) ; oBoogle
)

(instance foExit1L of ExitFeature
	(properties)

	(method (init)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 4)) ; oWestCursor
		(self setRect: 0 230 40 287)
	)

	(method (doVerb)
		(gCurRoom setScript: soCrawlOutL1)
	)
)

(instance foExit2L of ExitFeature
	(properties)

	(method (init)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 4)) ; oWestCursor
		(self setRect: 0 97 40 165)
	)

	(method (doVerb)
		(gCurRoom setScript: soCrawlOutL2)
	)
)

(instance foExit2R of ExitFeature
	(properties)

	(method (init)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 3)) ; oEastCursor
		(self setRect: 591 97 631 165)
	)

	(method (doVerb)
		(gCurRoom setScript: soCrawlOutR2)
	)
)

(instance foExit3L of ExitFeature
	(properties)

	(method (init)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 4)) ; oWestCursor
		(self setRect: 0 0 40 71)
	)

	(method (doVerb)
		(gCurRoom setScript: soCrawlOutL3)
	)
)

(instance foExit3R of ExitFeature
	(properties)

	(method (init)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 3)) ; oEastCursor
		(self setRect: 591 0 631 71)
	)

	(method (doVerb)
		(gCurRoom setScript: soCrawlOutR3)
	)
)

(instance oTorinCycle of Walk
	(properties)
)

(class foCrawlFeature of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self setRect: 0 0 632 316)
		(self myPriority: -1)
	)

	(method (handleEvent event)
		(if (and (== (event type:) evMOUSEBUTTON) (self onMe: event))
			(CrawlTorin (event x:))
			(event claimed: 1)
			(return 1)
		)
		(return 0)
	)
)

(instance foCrawlFeature1 of foCrawlFeature
	(properties)
)

(instance foCrawlFeature2 of foCrawlFeature
	(properties)
)

(instance foCrawlFeature3 of foCrawlFeature
	(properties)
)

(instance oCrawlLeft of TPSound
	(properties)
)

(instance oCrawlRight of TPSound
	(properties)
)

(instance aoTorinCrawls of Actor
	(properties
		view 50201
		xStep 10
	)

	(method (init)
		(super init: &rest)
		(self setSpeed: (gEgo cycleSpeed:))
		(self setCycle: oTorinCycle)
		(self setPri: 20)
		((ScriptID 64018 0) ; oBoogle
			posn: (+ (aoTorinCrawls x:) nBoogleDist) nCurY
			normalize:
			setPri: 20
			init: plane
			hide:
			show:
			setWander: 0
		)
	)

	(method (setHeading head)
		(= heading head)
	)

	(method (cantBeHere)
		(return 0)
	)

	(method (doit &tmp celTmp)
		(super doit: &rest)
		(self setSpeed: (gEgo cycleSpeed:))
		((ScriptID 64018 0) setSpeed: cycleSpeed) ; oBoogle
		((ScriptID 64018 0) xStep: xStep) ; oBoogle
		(if (and (not (self isStopped:)) (== cel 0) (not bPlayedLeftSound))
			(= bPlayedLeftSound 1)
			(= bPlayedRightSound 0)
			(oCrawlLeft playSound: 50204)
		)
		(if (and (not (self isStopped:)) (== cel 5) (not bPlayedRightSound))
			(= bPlayedLeftSound 0)
			(= bPlayedRightSound 1)
			(oCrawlRight playSound: 50205)
		)
		(if
			(and
				(== (gCurRoom plane:) oDuctPlane3)
				(<= (- x headOffset) menuTrigger)
				(not bShownMenuBonk)
			)
			(= bShownMenuBonk 1)
			(self setMotion: 0)
			(self setCel: 2)
			(self setScript: soMenuBonk)
		)
		(if (and (<= x 322) (== (gCurRoom plane:) gThePlane) (not bTrigger1))
			(= bTrigger1 1)
			(= nBoogleDist -100)
			((ScriptID 64018 0) posn: (+ x -100) nCurY) ; oBoogle
			(if mover
				(CrawlTorin (mover x:) (mover caller:))
			)
		)
		(if (and (<= x 127) (== (gCurRoom plane:) oDuctPlane2) (not bTrigger2))
			(= bTrigger2 1)
			(= nBoogleDist 100)
			((ScriptID 64018 0) posn: (+ x 100) nCurY) ; oBoogle
			(if mover
				(CrawlTorin (mover x:) (mover caller:))
			)
		)
	)
)

(instance soMenuBonk of Script
	(properties)

	(method (changeState newState &tmp oEvent)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((ScriptID 64018 0) setMotion: 0) ; oBoogle
				((ScriptID 64000 0) enable:) ; oMainMenu
				(goSound1 playSound: 50201)
				((ScriptID 64000 0) show:) ; oMainMenu
				((ScriptID 64000 2) hilite:) ; moHelp
				(= ticks 10)
			)
			(1
				(gMessager say: 2 0 0 1 self) ; "Ungh! Uh, can you get that?"
			)
			(2
				(gGame setCursor: (ScriptID 64006 0)) ; oSysCursor
				(while (!= ((= oEvent (Event new:)) type:) evMOUSEBUTTON)
					(oEvent dispose:)
				)
				(oEvent dispose:)
				(gGame setCursor: gWaitCursor)
				((ScriptID 64000 0) disable:) ; oMainMenu
				((ScriptID 64000 0) hide:) ; oMainMenu
				(FrameOut)
				(gMessager say: 2 0 0 2 self) ; "Thank you!"
			)
			(3
				(gCurRoom setScript: soCrawlOutL3)
			)
		)
	)
)

(instance soCrawlInR1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(aoTorinCrawls posn: 650 nCurY init:)
				(CrawlTorin 540 self)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soCrawlOutL1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(CrawlTorin -40 self)
			)
			(1
				(aoTorinCrawls dispose:)
				((ScriptID 64018 0) dispose:) ; oBoogle
				(gCurRoom addRoomPlane: oDuctPlane2)
				(aoTorinCrawls posn: 660 nCurY init: setCycle: oTorinCycle)
				(CrawlTorin 600 self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soCrawlOutL2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(CrawlTorin -40 self)
			)
			(1
				(aoTorinCrawls dispose:)
				((ScriptID 64018 0) dispose:) ; oBoogle
				(gCurRoom addRoomPlane: oDuctPlane3)
				(aoTorinCrawls posn: 660 nCurY init: setCycle: oTorinCycle)
				(CrawlTorin 600 self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soCrawlOutR2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(CrawlTorin 660 self)
			)
			(1
				(aoTorinCrawls dispose:)
				((ScriptID 64018 0) dispose:) ; oBoogle
				(gCurRoom deleteRoomPlane: oDuctPlane2)
				(= nCurY 292)
				(aoTorinCrawls posn: -40 292 init: setCycle: oTorinCycle)
				(CrawlTorin 20 self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soCrawlOutL3 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(CrawlTorin -40 self)
			)
			(1
				(aoTorinCrawls dispose:)
				((ScriptID 64018 0) dispose:) ; oBoogle
				(gCurRoom newRoom: 50300) ; roAirDuctEnd
				(self dispose:)
			)
		)
	)
)

(instance soCrawlOutR3 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(CrawlTorin 660 self)
			)
			(1
				(aoTorinCrawls dispose:)
				(gCurRoom deleteRoomPlane: oDuctPlane3)
				(= nCurY 166)
				(aoTorinCrawls posn: -40 166 init: setCycle: oTorinCycle)
				(CrawlTorin 20 self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance oDuctPlane2 of Plane
	(properties
		picture 50201
		priority 20
	)

	(method (init)
		(super
			init:
				(gThePlane left:)
				(gThePlane top:)
				(gThePlane right:)
				(gThePlane bottom:)
		)
		(= nCurY 166)
		(foCrawlFeature2 init:)
		(foExit2L init:)
		(foExit2R init:)
	)
)

(instance oDuctPlane3 of Plane
	(properties
		picture 50202
		priority 20
	)

	(method (init)
		(super
			init:
				(gThePlane left:)
				(gThePlane top:)
				(gThePlane right:)
				(gThePlane bottom:)
		)
		(= nCurY 70)
		(foCrawlFeature3 init:)
		(foExit3L init:)
		(foExit3R init:)
	)
)

(instance roAirDuct1 of TPRoom
	(properties
		picture 50200
	)

	(method (init)
		(super init: &rest)
		(= menuTrigger ((ScriptID 64000 0) getWidth:)) ; oMainMenu
		(aoTorinCrawls posn: 300 200 cel: 2 init:)
		(SetNowSeen aoTorinCrawls)
		(= headOffset (- (aoTorinCrawls x:) (aoTorinCrawls nsLeft:)))
		(aoTorinCrawls cel: 0 dispose:)
		(goMusic1 setMusic: 50100)
		(foExit1L init:)
		(foCrawlFeature1 init:)
		(gGame handsOn:)
		(= nCurY 292)
		(gCurRoom setScript: soCrawlInR1)
	)

	(method (gimme)
		(= bShownMenuBonk 0)
		(= bTrigger1 0)
		(= bTrigger2 0)
	)
)

