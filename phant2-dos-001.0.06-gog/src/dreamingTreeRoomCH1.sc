;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7001)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use P2Feature)
(use P2View)
(use ExitFeature)
(use P2Fidget)
(use PolyEdit)
(use System)

(public
	dreamingTreeRoomCH1 0
)

(local
	local0
)

(instance dreamingTreeRoomCH1 of P2Room
	(properties
		picture 300
	)

	(method (init)
		(= global241 100)
		(ClearFlag 1001)
		(if (not (IsFlag 45))
			(SetFlag 1001)
			(gP2SongPlyr start: 910)
			(= picture 421)
			(= south 900)
		)
		(if (and (IsFlag 70) (not (SetFlag 113)))
			(= global209 8880)
		)
		(if
			(and
				(IsFlag 45)
				(not (proc63002_3 70 100))
				(not global209)
				(not (SetFlag 1006))
			)
			(= global209 8510)
		)
		(super init: &rest)
		(if (IsFlag 45)
			(gP2SongPlyr fadeIn: 7000 100)
			(curtis init: setPri: 1)
			(menuFeature init:)
			(oJossMax init: setPri: 3)
			(oTrevMax init: setPri: 3)
			(overlayCode doit:)
			(cond
				((or (== gPrevRoomNum 4101) (IsFlag 100)) ; trevorsCubicleRoomCH1
					(menuFeature isHot: 0)
					(SetFlag 100)
					(maxProp init: responder: withTrevMaxFeature setPri: 1)
					(withTrevMaxFeature init: maxProp)
					(trevProp init: setPri: 2)
					(cond
						((firstTrevFeature init: trevProp)
							(firstTrevFeature whoDoit: firstTC)
							(trevProp responder: firstTrevFeature)
						)
						((secondTrevFeature init: trevProp)
							(secondTrevFeature whoDoit: secondTC)
							(trevProp responder: secondTrevFeature)
						)
						(else
							(lastTrevFeature init: trevProp)
							(trevProp responder: lastTrevFeature)
						)
					)
				)
				((IsFlag 70)
					(menuFeature isHot: 0)
					(if (IsFlag 105)
						(maxProp init: responder: withJossMaxFeature setPri: 1)
						(withJossMaxFeature init: maxProp)
					)
					(shakes init:)
					(jossCheckFeature
						init:
						isHot: (if (IsFlag 108) 1 else 0)
					)
					(jossProp init: setPri: 2)
					(cond
						((firstJossFeature init: jossProp)
							(firstJossFeature whoDoit: firstJC)
							(jossProp responder: firstJossFeature)
						)
						((secondJossFeature init: jossProp)
							(secondJossFeature whoDoit: secondJC)
							(jossProp responder: secondJossFeature)
						)
						((thirdJossFeature init: jossProp)
							(thirdJossFeature whoDoit: thirdJC)
							(jossProp responder: thirdJossFeature)
						)
						(else
							(fourthJossFeature init: jossProp whoDoit: fourthJC)
							(jossProp responder: fourthJossFeature)
						)
					)
				)
				(else
					(SetFlag 1001)
					(doorFeature
						init:
							(proc63002_10 339 132 339 18 367 12 403 40 403 132)
					)
					(chair init:)
					(maxProp init: setPri: 1)
					(if (firstMaxFeature init: maxProp)
						(maxProp responder: firstMaxFeature)
					else
						(secondMaxFeature init: maxProp)
						(maxProp responder: secondMaxFeature)
					)
				)
			)
		)
		(gGame handsOn: 1)
	)

	(method (newRoom newRoomNumber)
		(if (!= newRoomNumber 7010) ; dreamingTreeRoomSR1
			(ClearFlag 100)
		)
		(super newRoom: newRoomNumber &rest)
	)

	(method (dispose)
		(super dispose: &rest)
	)
)

(instance menuFeature of P2View
	(properties
		priority 3
		x 395
		y 233
		view 300
		loop 2
		nextRoom 7010
	)
)

(instance withTrevMaxFeature of P2Feature
	(properties
		scene 8830
		doneFlag 102
	)

	(method (dispose)
		(if target
			(target responder: 0)
			(= target 0)
		)
		(super dispose:)
	)
)

(instance firstTrevFeature of P2Feature
	(properties
		scene 8690
		doneFlag 103
	)

	(method (dispose)
		(if target
			(target responder: 0)
			(= target 0)
		)
		(super dispose:)
	)
)

(instance firstTC of Code
	(properties)

	(method (doit)
		(secondTrevFeature init: trevProp whoDoit: secondTC)
		(trevProp responder: secondTrevFeature)
	)
)

(instance secondTrevFeature of P2Feature
	(properties
		scene 8900
		doneFlag 104
	)

	(method (dispose)
		(if target
			(target responder: 0)
			(= target 0)
		)
		(super dispose:)
	)
)

(instance secondTC of Code
	(properties)

	(method (doit)
		(lastTrevFeature init: trevProp)
		(trevProp responder: lastTrevFeature)
	)
)

(instance lastTrevFeature of P2Feature
	(properties
		nextRoom 3011
	)

	(method (handleEvent)
		(if (super handleEvent: &rest)
			(= global209 8920)
		)
	)

	(method (dispose)
		(if target
			(target responder: 0)
			(= target 0)
		)
		(super dispose:)
	)
)

(instance withJossMaxFeature of P2Feature
	(properties
		scene 8550
		doneFlag 101
	)

	(method (dispose)
		(if target
			(target responder: 0)
			(= target 0)
		)
		(super dispose:)
	)
)

(instance firstJossFeature of P2Feature
	(properties
		scene 8680
		doneFlag 105
	)

	(method (dispose)
		(if target
			(target responder: 0)
			(= target 0)
		)
		(super dispose:)
	)
)

(instance firstJC of Code
	(properties)

	(method (doit)
		(maxProp init: responder: withJossMaxFeature setPri: 1)
		(withJossMaxFeature init: maxProp)
		(shakes init:)
		(secondJossFeature init: jossProp whoDoit: secondJC)
		(jossProp responder: secondJossFeature)
		(withJossMaxFeature init: maxProp)
		(maxProp responder: withJossMaxFeature)
	)
)

(instance secondJossFeature of P2Feature
	(properties
		scene 8700
		doneFlag 106
	)

	(method (dispose)
		(if target
			(target responder: 0)
			(= target 0)
		)
		(super dispose:)
	)
)

(instance secondJC of Code
	(properties)

	(method (doit)
		(shakes set: 300 1 1 1 posn: 326 181)
		(thirdJossFeature init: jossProp whoDoit: thirdJC)
		(jossProp responder: thirdJossFeature)
		(jossCheckFeature init: isHot: 0)
	)
)

(instance thirdJossFeature of P2Feature
	(properties
		scene 8710
		sceneScored 1
		doneFlag 107
	)

	(method (dispose)
		(if target
			(target responder: 0)
			(= target 0)
		)
		(super dispose:)
	)
)

(instance thirdJC of Code
	(properties)

	(method (doit)
		(fourthJossFeature init: jossProp whoDoit: fourthJC)
		(jossProp responder: fourthJossFeature)
	)
)

(instance fourthJossFeature of P2Feature
	(properties
		scene 8720
		doneFlag 108
	)

	(method (dispose)
		(if target
			(target responder: 0)
			(= target 0)
		)
		(super dispose:)
	)
)

(instance fourthJC of Code
	(properties)

	(method (doit)
		(if (not (SetFlag 101))
			(withJossMaxFeature dispose:)
		)
		(jossCheckFeature isHot: 1)
	)
)

(instance jossCheckFeature of P2View
	(properties
		priority 4
		x 382
		y 218
		view 300
		doneFlag 15
		invItem 8
		nextRoom 2131
	)

	(method (init)
		(super init: &rest)
		(self addVerb: 5 delVerb: 4)
		(= whoDoit takeDatGirlieHomeStudMeister)
	)
)

(instance takeDatGirlieHomeStudMeister of Code
	(properties)

	(method (doit)
		(= global211 (not (= global212 0)))
		(= global209 8740)
	)
)

(instance shakes of P2View
	(properties
		priority 2
		x 320
		y 174
		view 300
		loop 1
	)

	(method (init)
		(if (IsFlag 106)
			(= cel 1)
			(= x 326)
			(= y 181)
		)
		(super init: &rest)
		(self isHot: 0)
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

(instance firstMaxFeature of P2Feature
	(properties
		scene 8530
		doneFlag 21
	)

	(method (dispose)
		(if target
			(target responder: 0)
			(= target 0)
		)
		(super dispose:)
	)
)

(instance secondMaxFeature of P2Feature
	(properties
		scene 8540
		readyFlag 110
	)

	(method (handleEvent)
		(if (super handleEvent: &rest)
			(self dispose:)
		)
	)

	(method (dispose)
		(if target
			(target responder: 0)
			(= target 0)
		)
		(super dispose:)
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
		(target setPri: 2 update:)
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

	(method (init)
		(super init: &rest)
		(|= local0 $0001)
		(overlayCode doit:)
	)

	(method (dispose)
		(&= local0 $fffe)
		(overlayCode doit:)
		(if responder
			(responder target: 0)
			(= responder 0)
		)
		(super dispose: &rest)
	)
)

(instance trevProp of P2Fidget
	(properties
		x 150
		y 338
		view 13001
		initStart 7
		cycleStart 7
	)

	(method (init)
		(super init: &rest)
		(|= local0 $0004)
		(overlayCode doit:)
	)

	(method (dispose)
		(&= local0 $fffb)
		(overlayCode doit:)
		(if responder
			(responder target: 0)
			(= responder 0)
		)
		(super dispose: &rest)
	)
)

(instance curtis of P2Fidget
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

	(method (dispose)
		(if responder
			(responder target: 0)
			(= responder 0)
		)
		(super dispose: &rest)
	)
)

(instance jossProp of P2Fidget
	(properties
		x 141
		y 338
		view 13004
		initStart 7
		cycleStart 7
	)

	(method (init)
		(super init: &rest)
		(|= local0 $0002)
		(overlayCode doit:)
	)

	(method (dispose)
		(&= local0 $fffd)
		(overlayCode doit:)
		(if responder
			(responder target: 0)
			(= responder 0)
		)
		(super dispose: &rest)
	)
)

(instance oTrevMax of View
	(properties
		x 273
		y 245
		view 301
	)
)

(instance oJossMax of View
	(properties
		x 272
		y 257
		view 301
		loop 4
	)
)

(instance overlayCode of Code
	(properties)

	(method (doit)
		(if (and (& local0 $0001) (& local0 $0004))
			(oTrevMax show:)
		else
			(oTrevMax hide:)
		)
		(if (and (& local0 $0001) (& local0 $0002))
			(oJossMax show:)
		else
			(oJossMax hide:)
		)
	)
)

