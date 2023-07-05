;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 16)
(include sci.sh)
(use Main)
(use ExitButton)
(use scaryInvInit)
(use Feature)
(use Game)
(use Actor)
(use System)

(public
	skipCartoon 0
	scroller 1
	ScrollFeat 2
	invHole 3
	scrollSlot 4
)

(local
	local0
	local1
	local2
)

(instance setFirstBit of Code
	(properties)

	(method (doit param1 &tmp temp0)
		(if (and (param1 isKindOf: KQInventory) (= temp0 (param1 scratch:)))
			(temp0 _respondVerbs: 1)
		)
	)
)

(class KQRoom of Room
	(properties
		edgeS 136
		eastSide 319
		screen_left -1
		screen_mid -1
		screen_right -1
	)

	(method (newRoom newRoomNumber &tmp temp0)
		(gGame handsOff:)
		(if gCuees
			(gCuees eachElementDo: #cuee 0 eachElementDo: #dispose release:)
		)
		(gKqMusic1 client: 0)
		(gKqSound1 client: 0)
		(super newRoom: newRoomNumber)
	)

	(method (updateExits param1)
		(cond
			((> param1 0)
				((ScriptID 19 0) ; eastFeat
					nsLeft: (- ((ScriptID 19 0) nsLeft:) param1) ; eastFeat
					nsRight: (- ((ScriptID 19 0) nsRight:) (- param1 1)) ; eastFeat
				)
				((ScriptID 19 1) ; westFeat
					nsLeft: (- ((ScriptID 19 1) nsLeft:) param1) ; westFeat
					nsRight: (- ((ScriptID 19 1) nsRight:) param1) ; westFeat
				)
			)
			((< param1 0)
				((ScriptID 19 0) ; eastFeat
					nsLeft: (- ((ScriptID 19 0) nsLeft:) param1) ; eastFeat
					nsRight: (- ((ScriptID 19 0) nsRight:) param1) ; eastFeat
				)
				((ScriptID 19 1) ; westFeat
					nsLeft: (- ((ScriptID 19 1) nsLeft:) (+ param1 2)) ; westFeat
					nsRight: (- ((ScriptID 19 1) nsRight:) param1) ; westFeat
				)
			)
			(else
				((ScriptID 19 0) ; eastFeat
					nsLeft: (- ((ScriptID 19 0) nsLeft:) param1) ; eastFeat
					nsRight: (- ((ScriptID 19 0) nsRight:) param1) ; eastFeat
				)
				((ScriptID 19 1) ; westFeat
					nsLeft: (- ((ScriptID 19 1) nsLeft:) param1) ; westFeat
					nsRight: (- ((ScriptID 19 1) nsRight:) param1) ; westFeat
				)
			)
		)
		(if
			(and
				(not east)
				(<= (gThePlane right:) 325)
				((ScriptID 19 0) scratch:) ; eastFeat
			)
			((ScriptID 19 0) setHotspot: 0) ; eastFeat
		)
		(if (and (not ((ScriptID 19 0) scratch:)) (> (gThePlane right:) 325)) ; eastFeat
			((ScriptID 19 0) setHotspot: 10 10) ; eastFeat, Exit, Exit
		)
		(if (and (not west) (> (gThePlane left:) -5) ((ScriptID 19 1) scratch:)) ; westFeat
			((ScriptID 19 1) setHotspot: 0) ; westFeat
		)
		(if (and (not ((ScriptID 19 1) scratch:)) (< (gThePlane left:) -5)) ; westFeat
			((ScriptID 19 1) setHotspot: 10 10) ; westFeat, Exit, Exit
		)
		(gUser need_update: 1)
	)

	(method (drawPic param1)
		(if (== style -1)
			(= style 15)
		)
		(super drawPic: param1 &rest)
		(self overlay:)
	)

	(method (init)
		(= global331 0)
		(= global311 0)
		(if (not global308)
			(gUser message: (gUser dftMessage:))
		)
		(global124 eachElementDo: #perform setFirstBit)
		(= eastSide 319)
		(super init: &rest)
		(RemapColors 2 244 60) ; ByPercent
		((ScriptID 13 0) ; aEgoTalker
			view: -1
			loop: -1
			mouth_x: -999
			mouth_y: -999
			hide_mouth: 0
		)
		(cond
			((OneOf gCurRoomNum 2600 3150 111 5300 4550)
				(gCurRoom eastSide: 639)
			)
			((OneOf gCurRoomNum 1100 111 2600 1250 3150 5300 4550)
				(gCurRoom eastSide: 959)
			)
		)
		(if (or east (OneOf gCurRoomNum 1100 111 2600 1250 3150 5300 4550))
			((ScriptID 19 0) init:) ; eastFeat
		)
		(if (or west (OneOf gCurRoomNum 1100 111 2600 1250 3150 5300 4550))
			((ScriptID 19 1) init:) ; westFeat
		)
		(if north
			((ScriptID 19 2) init:) ; northFeat
		)
		(if south
			((ScriptID 19 3) init:) ; southFeat
		)
	)

	(method (setRect param1 param2 param3 param4)
		(if (not (IsFlag 97))
			(scroller hide:)
		)
		(gThePlane setRect: param1 param2 param3 param4)
		(cond
			((> (- param4 param2) 201)
				(scroller x: 305)
			)
			((> (- param3 param1) 641)
				(switch param1
					(0
						((ScriptID 19 0) nsLeft: 300 nsRight: 320) ; eastFeat
						((ScriptID 19 1) nsLeft: 0 nsRight: 20) ; westFeat
						(scroller x: 303)
					)
					(-318
						((ScriptID 19 0) nsLeft: 619 nsRight: 639) ; eastFeat
						((ScriptID 19 1) nsLeft: 318 nsRight: 340) ; westFeat
						(scroller x: 266)
					)
					(64897
						((ScriptID 19 0) nsLeft: 940 nsRight: 959) ; eastFeat
						((ScriptID 19 1) nsLeft: 639 nsRight: 660) ; westFeat
						(scroller x: 230)
					)
				)
				(if (not (& (scroller signal:) $0008))
					(UpdateScreenItem scroller)
				)
			)
			(else
				(switch param1
					(0
						((ScriptID 19 0) nsLeft: 300 nsRight: 320) ; eastFeat
						((ScriptID 19 1) nsLeft: 0 nsRight: 20) ; westFeat
						(scroller x: 303)
					)
					(-318
						((ScriptID 19 0) nsLeft: 619 nsRight: 639) ; eastFeat
						((ScriptID 19 1) nsLeft: 318 nsRight: 340) ; westFeat
						(scroller x: 230)
					)
				)
				(if (not (& (scroller signal:) $0008))
					(UpdateScreenItem scroller)
				)
			)
		)
		(UpdatePlane gThePlane)
		(if (!= screen_left -1)
			(AddPicAt gThePlane screen_left 0 0)
		)
		(if (!= screen_mid -1)
			(AddPicAt gThePlane screen_mid 320 0)
		)
		(if (!= screen_right -1)
			(AddPicAt gThePlane screen_right 640 0)
		)
		(self updateExits: 0)
	)

	(method (overlay)
		(if (and (IsFlag 21) (not (IsFlag 1)))
			(SetFlag 1)
			(gThePlane setRect: 0 0 320 136 priority: 4)
			(UpdatePlane gThePlane)
			(theEye init: setHotspot: 9998 10) ; Exit
			(invHole init:)
			(interface1 init: global108)
			(control init: setHotspot: 8 10) ; Do, Exit
			(gInventory eachElementDo: #init global108)
			(UpdatePlane gInterfacePlane)
		)
		(cond
			((OneOf gCurRoomNum 1100 111 2600 1250 3150 5300 4550)
				(ScrollFeat init: global108)
				(scrollSlot init: global108)
				(scroller init: global108)
			)
			((OneOf gPrevRoomNum 1100 111 2600 1250 3150 5300 4550)
				(gThePlane setRect: 0 0 320 136 priority: 4)
				(UpdatePlane gThePlane)
				(global108 delete: ScrollFeat)
				(global108 delete: scroller)
				(ScrollFeat dispose: plane: 0)
				(scroller dispose: plane: 0)
				(scrollSlot dispose: plane: 0)
			)
		)
	)

	(method (doVerb)
		(return 0)
	)

	(method (dispose &tmp [temp0 3])
		(= global331 0)
		(= global311 0)
		(if (not global308)
			(gUser message: (gUser dftMessage:))
		)
		((ScriptID 0 4) release: add: 10 add: 8) ; respondSet
		(if (global123 size:)
			(global123 release:)
		)
		(if (global124 size:)
			(gInventory eachElementDo: #recoverSpot)
		)
		(super dispose:)
	)

	(method (reflectPosn param1 param2)
		(switch param2
			(1
				(param1 y: 135)
			)
			(4
				(param1 x: (- (gCurRoom eastSide:) 20))
			)
			(3
				(param1 y: (+ (gCurRoom horizon:) 4))
			)
			(2
				(param1 x: 20)
			)
		)
	)

	(method (centerScreen param1 param2 param3 &tmp temp0 temp1)
		(if (not (IsFlag 97))
			(if (and (> argc 1) param2)
				(param2 cue:)
			)
			(return)
		)
		(if (== argc 3)
			(= temp0 param3)
		else
			(= temp0 3)
		)
		(if (> (gThePlane left:) param1)
			(= temp0 (- 0 temp0))
		)
		(while 1
			(if (< temp0 0)
				(if (< (= temp1 (+ (gThePlane left:) temp0)) param1)
					(= temp0 (- param1 temp1))
				)
				(if (<= (gThePlane left:) param1)
					(break)
				)
			else
				(if (> (= temp1 (+ (gThePlane left:) temp0)) param1)
					(= temp0 (Abs (- temp1 param1)))
				)
				(if (>= (gThePlane left:) param1)
					(break)
				)
			)
			(gThePlane
				setRect:
					(+ (gThePlane left:) temp0)
					0
					(+ (gThePlane right:) temp0)
					136
			)
			(gCurRoom updateExits: temp0)
			(UpdatePlane gThePlane)
			(scroller
				x:
					(if (OneOf gCurRoomNum 2600 3150 111 5300 4550)
						(leftToEvtDoub doit: (gThePlane left:))
					else
						(leftToEvt doit: (gThePlane left:))
					)
			)
			(if (not (& (scroller signal:) $0008))
				(UpdateScreenItem scroller)
				(FrameOut)
			)
		)
		(if (and (> argc 1) param2)
			(param2 cue:)
		)
	)

	(method (scrolling &tmp temp0 temp1 temp2)
		(cond
			((or (not (IsFlag 97)) (IsFlag 552))
				(cond
					(
						(and
							(> (+ (gEgo x:) (gThePlane left:)) 310)
							(> (gThePlane right:) 325)
							(gEgo mover:)
							(> (gEgo x:) ((gEgo mover:) xLast:))
						)
						(= temp1 315)
						(if (< (= temp2 (- (gThePlane right:) 315)) 325)
							(= temp1 (- (gThePlane right:) 325))
						)
						(= temp0 (- (gThePlane right:) 315))
						(gThePlane
							setRect:
								(- (gThePlane left:) temp1)
								(gThePlane top:)
								(- (gThePlane right:) temp1)
								(gThePlane bottom:)
						)
						(self updateExits: (- 0 temp1))
						(UpdatePlane gThePlane)
						(scroller
							x:
								(if
									(OneOf
										gCurRoomNum
										2600
										3150
										111
										5300
										4550
									)
									(leftToEvtDoub doit: (gThePlane left:))
								else
									(leftToEvt doit: (gThePlane left:))
								)
						)
					)
					(
						(and
							(< (+ (gEgo x:) (gThePlane left:)) 10)
							(< (gThePlane left:) -5)
							(gEgo mover:)
							(< (gEgo x:) ((gEgo mover:) xLast:))
						)
						(= temp1 315)
						(if (> (= temp0 (+ (gThePlane left:) 315)) 0)
							(= temp1 (- 315 temp0))
						)
						(gThePlane
							setRect:
								(+ (gThePlane left:) temp1)
								(gThePlane top:)
								(+ (gThePlane right:) temp1)
								(gThePlane bottom:)
						)
						(self updateExits: temp1)
						(UpdatePlane gThePlane)
						(scroller
							x:
								(if
									(OneOf
										gCurRoomNum
										2600
										3150
										111
										5300
										4550
									)
									(leftToEvtDoub doit: (gThePlane left:))
								else
									(leftToEvt doit: (gThePlane left:))
								)
						)
					)
				)
			)
			(
				(and
					(> (+ (gEgo x:) (gThePlane left:)) 220)
					(> (gThePlane right:) 325)
					(gEgo mover:)
					(> (gEgo x:) ((gEgo mover:) xLast:))
				)
				(gThePlane
					setRect:
						(- (gThePlane left:) (gEgo xStep:))
						(gThePlane top:)
						(- (gThePlane right:) (gEgo xStep:))
						(gThePlane bottom:)
				)
				(self updateExits: (- 0 (gEgo xStep:)))
				(UpdatePlane gThePlane)
				(scroller
					x:
						(if (OneOf gCurRoomNum 2600 3150 111 5300 4550)
							(leftToEvtDoub doit: (gThePlane left:))
						else
							(leftToEvt doit: (gThePlane left:))
						)
				)
				(UpdateScreenItem scroller)
			)
			(
				(and
					(< (+ (gEgo x:) (gThePlane left:)) 100)
					(< (gThePlane left:) -5)
					(gEgo mover:)
					(< (gEgo x:) ((gEgo mover:) xLast:))
				)
				(gThePlane
					setRect:
						(+ (gThePlane left:) (gEgo xStep:))
						(gThePlane top:)
						(+ (gThePlane right:) (gEgo xStep:))
						(gThePlane bottom:)
				)
				(self updateExits: (gEgo xStep:))
				(UpdatePlane gThePlane)
				(scroller
					x:
						(if (OneOf gCurRoomNum 2600 3150 111 5300 4550)
							(leftToEvtDoub doit: (gThePlane left:))
						else
							(leftToEvt doit: (gThePlane left:))
						)
				)
				(UpdateScreenItem scroller)
			)
		)
	)
)

(instance interface1 of View
	(properties
		sightAngle 180
		view 950
	)
)

(instance invHole of Feature
	(properties
		nsLeft 70
		nsTop 15
		nsRight 210
		nsBottom 48
		sightAngle 180
	)

	(method (init)
		(global108 add: self)
		(= plane gInterfacePlane)
	)

	(method (doVerb theVerb &tmp temp0)
		(cond
			((OneOf theVerb 8 10) ; Do, Exit
				(super doVerb: theVerb)
			)
			((= temp0 (gInventory firstTrue: #isMyVerb theVerb))
				(gUser message: 10)
				(temp0 show:)
				(gNormalCursor cel: 0)
				(gGame setCursor: gNormalCursor)
				(= global308 0)
				(return 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance theEye of Feature
	(properties
		nsLeft 229
		nsTop 14
		nsRight 262
		nsBottom 42
		sightAngle 180
	)

	(method (init)
		(global108 addToFront: self)
		(= plane gInterfacePlane)
	)

	(method (handleEvent event)
		(if (self onMe: event)
			(cond
				(
					(and
						(not (gCurRoom inset:))
						(not (== gTheCursor gTheUseObjCursor))
						global308
					)
					(super handleEvent: event)
				)
				((event type:)
					(gGame pragmaFail:)
				)
			)
		)
	)

	(method (doVerb theVerb &tmp temp0)
		(if
			(and
				(not (gCurRoom inset:))
				(!= theVerb 10) ; Exit
				(= temp0 (gInventory firstTrue: #isMyVerb theVerb))
			)
			(gNormalCursor cel: 0)
			(gGame setCursor: gNormalCursor)
			((ScriptID 24) doit: temp0) ; insetCode
			(return 1)
		)
	)
)

(instance skipCartoon of View
	(properties
		sightAngle 180
		x 121
		y 4
		view 950
		loop 2
	)

	(method (init)
		(global108 addToFront: self)
		(super init: global108)
		(UpdateScreenItem self)
		(= local0 0)
		(= local1 (= cel 0))
		(= local2 (GetTime))
	)

	(method (handleEvent event &tmp temp0)
		(event localize: plane)
		(cond
			((not (event type:))
				(cond
					((self onMe: event)
						(if
							(or
								(> (= temp0 (- (GetTime) local2)) 5)
								(not local0)
							)
							(= local2 (GetTime))
							(= local0 1)
							(if (> (++ local1) 4)
								(= local1 0)
							)
							(gNormalCursor view: 999 loop: 0 cel: local1)
							(gGame setCursor: gNormalCursor 1)
						)
					)
					(local0
						(= local0 0)
						(gGame setCursor: gWaitCursor 1)
					)
				)
				(return 0)
			)
			((and (self onMe: event) (not (gCurRoom inset:)))
				(gNormalCursor setCycle: 0 cel: 0 init:)
				(= cel 1)
				(UpdateScreenItem self)
				(FrameOut)
				(SetFlag 539)
				(if (gTalkers size:)
					(gMessager caller: 0 cue: 1)
				)
				(if (gCurRoom script:)
					((gCurRoom script:) changeState: 0)
				)
				(if (gEgo script:)
					(gEgo setMotion: 0)
					((gEgo script:) changeState: 0)
				)
				(event claimed: 1)
				(return)
			)
			(else
				(return 0)
			)
		)
	)

	(method (dispose)
		(global108 delete: self)
		(gNormalCursor cel: 0 init:)
		(if global308
			(gGame setCursor: gTheInvCursor 1)
		else
			(gGame setCursor: gWaitCursor 1)
		)
		(super dispose:)
	)
)

(instance control of Feature
	(properties
		nsLeft 276
		nsTop 13
		nsRight 305
		nsBottom 45
		sightAngle 180
	)

	(method (init)
		(global108 addToFront: self)
		(= plane gInterfacePlane)
	)

	(method (onMe)
		(if (gCurRoom inset:)
			(return 0)
		else
			(return (super onMe: &rest))
		)
	)

	(method (doVerb theVerb &tmp temp0)
		(if
			(and
				(not (gTheDoits contains: (ScriptID 25))) ; chapInset
				(not (gCurRoom inset:))
				(OneOf theVerb 8 10) ; Do, Exit
			)
			(gNormalCursor setCycle: 0 cel: 0)
			(gGame setCursor: gNormalCursor)
			(gCurRoom setInset: (ScriptID 25 0)) ; chapInset
			(return 1)
		else
			(super doVerb: theVerb)
		)
	)
)

(class ScrollFeat of Feature
	(properties
		nsLeft 230
		nsTop 2
		nsRight 303
		nsBottom 11
		sightAngle 180
		activated 0
		theInc 2
		theLeft -320
		leftSlideLimit 226
		rightSlideLimit 300
		egoDistLeft 0
		egoDistRight 0
		scrollDir 0
		maxDelta 640
	)

	(method (init)
		(global108 addToFront: self)
		(= plane gInterfacePlane)
		(if (OneOf gCurRoomNum 2600 3150 111 5300 4550)
			(gCurRoom eastSide: 639)
			(= maxDelta 320)
		else
			(gCurRoom eastSide: 959)
			(= maxDelta 640)
		)
		(if (== gCurRoomNum 1400)
			(= scrollDir 1)
		else
			(= scrollDir 0)
		)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3)
		(if
			(or
				(& (scroller signal:) $0008)
				(not (global108 contains: scroller))
			)
			(return 0)
		)
		(event localize: plane)
		(= temp0 (gThePlane left:))
		(= egoDistLeft (- (gEgo x:) (Abs temp0)))
		(= egoDistRight (- 320 egoDistLeft))
		(-= egoDistLeft 10)
		(-= egoDistRight 10)
		(= leftSlideLimit (- temp0 egoDistLeft))
		(= rightSlideLimit (+ temp0 egoDistRight))
		(if (OneOf gCurRoomNum 2600 3150 111 5300 4550)
			(= leftSlideLimit (leftToEvtDoub doit: leftSlideLimit))
			(= rightSlideLimit (leftToEvtDoub doit: rightSlideLimit))
		else
			(= leftSlideLimit (leftToEvt doit: leftSlideLimit))
			(= rightSlideLimit (leftToEvt doit: rightSlideLimit))
		)
		(cond
			((event claimed:)
				(return 1)
			)
			(
				(and
					(& (event type:) evVERB)
					(or (self onMe: event) (scroller onMe: event))
					(OneOf (event message:) JOY_UPLEFT (gUser dftMessage:))
					(not (gCurRoom inset:))
				)
				(event claimed: 1)
				(while 1
					(= temp1 ((gUser curEvent:) new:))
					(temp1 localize: plane)
					(if (!= (temp1 type:) 2)
						(if (< (= temp2 (temp1 x:)) leftSlideLimit)
							(= temp2 leftSlideLimit)
						)
						(if (> temp2 rightSlideLimit)
							(= temp2 rightSlideLimit)
						)
						(scroller x: temp2)
						(UpdateScreenItem scroller)
						(if (OneOf gCurRoomNum 2600 3150 111 5300 4550)
							(= theLeft (evtToLeftDoub doit: temp2))
						else
							(= theLeft (evtToLeft doit: temp2))
						)
					else
						(break)
					)
					(= theInc (- theLeft (gThePlane left:)))
					(gThePlane
						setRect:
							(+ (gThePlane left:) theInc)
							0
							(+ (gThePlane right:) theInc)
							136
					)
					(gCurRoom updateExits: theInc)
					(UpdatePlane gThePlane)
					(FrameOut)
				)
				(temp1 dispose:)
				(return 1)
			)
		)
		(return 0)
	)

	(method (doVerb)
		(return 1)
	)
)

(instance scroller of View
	(properties
		sightAngle 180
		x 268
		y 6
		view 950
		loop 1
	)

	(method (init)
		(super init: &rest)
		(if (or (not (IsFlag 97)) (IsFlag 552))
			(self hide:)
			(scrollSlot hide:)
		)
		(self setHotspot: 8 10) ; Do, Exit
	)

	(method (posn)
		(if (not (& signal $0008))
			(super posn: &rest)
		)
	)

	(method (show)
		(super show:)
		(scrollSlot show:)
	)

	(method (handleEvent event)
		(if (event type:)
			(ScrollFeat handleEvent: event)
			(event claimed: 1)
			(return)
		else
			(super handleEvent: event)
		)
	)

	(method (hide)
		(scrollSlot hide:)
		(super hide:)
	)
)

(instance scrollSlot of View
	(properties
		sightAngle 180
		x 233
		y 5
		z -1
		view 950
		loop 1
		cel 1
	)

	(method (handleEvent)
		(return 0)
	)
)

(instance evtToLeft of Code
	(properties)

	(method (doit param1)
		(switch param1
			(230
				(return 64897)
			)
			(231
				(return 64906)
			)
			(232
				(return 64915)
			)
			(233
				(return 64924)
			)
			(234
				(return 64933)
			)
			(235
				(return 64942)
			)
			(236
				(return 64951)
			)
			(237
				(return 64960)
			)
			(238
				(return 64969)
			)
			(239
				(return 64978)
			)
			(240
				(return 64987)
			)
			(241
				(return 64996)
			)
			(242
				(return -531)
			)
			(243
				(return -522)
			)
			(244
				(return -513)
			)
			(245
				(return -504)
			)
			(246
				(return -495)
			)
			(247
				(return -486)
			)
			(248
				(return -477)
			)
			(249
				(return -468)
			)
			(250
				(return -459)
			)
			(251
				(return -450)
			)
			(252
				(return -441)
			)
			(253
				(return -432)
			)
			(254
				(return -423)
			)
			(255
				(return -414)
			)
			(256
				(return -405)
			)
			(257
				(return -396)
			)
			(258
				(return -387)
			)
			(259
				(return -378)
			)
			(260
				(return -369)
			)
			(261
				(return -360)
			)
			(262
				(return -351)
			)
			(263
				(return -342)
			)
			(264
				(return -333)
			)
			(265
				(return -324)
			)
			(266
				(return -315)
			)
			(267
				(return -306)
			)
			(268
				(return -297)
			)
			(269
				(return -288)
			)
			(270
				(return -279)
			)
			(271
				(return -270)
			)
			(272
				(return -261)
			)
			(273
				(return -252)
			)
			(274
				(return -243)
			)
			(275
				(return -234)
			)
			(276
				(return -225)
			)
			(277
				(return -216)
			)
			(278
				(return -207)
			)
			(279
				(return -198)
			)
			(280
				(return -189)
			)
			(281
				(return -180)
			)
			(282
				(return -171)
			)
			(283
				(return -162)
			)
			(284
				(return -153)
			)
			(285
				(return -144)
			)
			(286
				(return -135)
			)
			(287
				(return -126)
			)
			(288
				(return -117)
			)
			(289
				(return -108)
			)
			(290
				(return -99)
			)
			(291
				(return -90)
			)
			(292
				(return -81)
			)
			(293
				(return -72)
			)
			(294
				(return -63)
			)
			(295
				(return -54)
			)
			(296
				(return -45)
			)
			(297
				(return -36)
			)
			(298
				(return -27)
			)
			(299
				(return -18)
			)
			(300
				(return -9)
			)
			(301
				(return 0)
			)
			(302
				(return 0)
			)
			(303
				(return 0)
			)
		)
	)
)

(instance leftToEvt of Code
	(properties)

	(method (doit param1)
		(cond
			((<= param1 64897)
				(return 230)
			)
			((<= param1 64906)
				(return 231)
			)
			((<= param1 64915)
				(return 232)
			)
			((<= param1 64924)
				(return 233)
			)
			((<= param1 64933)
				(return 234)
			)
			((<= param1 64942)
				(return 235)
			)
			((<= param1 64951)
				(return 236)
			)
			((<= param1 64960)
				(return 237)
			)
			((<= param1 64969)
				(return 238)
			)
			((<= param1 64978)
				(return 239)
			)
			((<= param1 64987)
				(return 240)
			)
			((<= param1 64996)
				(return 241)
			)
			((<= param1 -531)
				(return 242)
			)
			((<= param1 -522)
				(return 243)
			)
			((<= param1 -513)
				(return 244)
			)
			((<= param1 -504)
				(return 245)
			)
			((<= param1 -495)
				(return 246)
			)
			((<= param1 -486)
				(return 247)
			)
			((<= param1 -477)
				(return 248)
			)
			((<= param1 -468)
				(return 249)
			)
			((<= param1 -459)
				(return 250)
			)
			((<= param1 -450)
				(return 251)
			)
			((<= param1 -441)
				(return 252)
			)
			((<= param1 -432)
				(return 253)
			)
			((<= param1 -423)
				(return 254)
			)
			((<= param1 -414)
				(return 255)
			)
			((<= param1 -405)
				(return 256)
			)
			((<= param1 -396)
				(return 257)
			)
			((<= param1 -387)
				(return 258)
			)
			((<= param1 -378)
				(return 259)
			)
			((<= param1 -369)
				(return 260)
			)
			((<= param1 -360)
				(return 261)
			)
			((<= param1 -351)
				(return 262)
			)
			((<= param1 -342)
				(return 263)
			)
			((<= param1 -333)
				(return 264)
			)
			((<= param1 -324)
				(return 265)
			)
			((<= param1 -315)
				(return 266)
			)
			((<= param1 -306)
				(return 267)
			)
			((<= param1 -297)
				(return 268)
			)
			((<= param1 -288)
				(return 269)
			)
			((<= param1 -279)
				(return 270)
			)
			((<= param1 -270)
				(return 271)
			)
			((<= param1 -261)
				(return 272)
			)
			((<= param1 -252)
				(return 273)
			)
			((<= param1 -243)
				(return 274)
			)
			((<= param1 -234)
				(return 275)
			)
			((<= param1 -225)
				(return 276)
			)
			((<= param1 -216)
				(return 277)
			)
			((<= param1 -207)
				(return 278)
			)
			((<= param1 -198)
				(return 279)
			)
			((<= param1 -189)
				(return 280)
			)
			((<= param1 -180)
				(return 281)
			)
			((<= param1 -171)
				(return 282)
			)
			((<= param1 -162)
				(return 283)
			)
			((<= param1 -153)
				(return 284)
			)
			((<= param1 -144)
				(return 285)
			)
			((<= param1 -135)
				(return 286)
			)
			((<= param1 -126)
				(return 287)
			)
			((<= param1 -117)
				(return 288)
			)
			((<= param1 -108)
				(return 289)
			)
			((<= param1 -99)
				(return 290)
			)
			((<= param1 -90)
				(return 291)
			)
			((<= param1 -81)
				(return 292)
			)
			((<= param1 -72)
				(return 293)
			)
			((<= param1 -63)
				(return 294)
			)
			((<= param1 -54)
				(return 295)
			)
			((<= param1 -45)
				(return 296)
			)
			((<= param1 -36)
				(return 297)
			)
			((<= param1 -27)
				(return 298)
			)
			((<= param1 -18)
				(return 299)
			)
			((<= param1 -9)
				(return 300)
			)
			(else
				(return 302)
			)
		)
	)
)

(instance evtToLeftDoub of Code
	(properties)

	(method (doit param1)
		(switch param1
			(230
				(return -318)
			)
			(231
				(return -318)
			)
			(232
				(return -318)
			)
			(233
				(return -315)
			)
			(234
				(return -312)
			)
			(235
				(return -309)
			)
			(236
				(return -306)
			)
			(237
				(return -303)
			)
			(238
				(return -300)
			)
			(239
				(return -297)
			)
			(240
				(return -294)
			)
			(241
				(return -291)
			)
			(242
				(return -288)
			)
			(243
				(return -285)
			)
			(244
				(return -282)
			)
			(245
				(return -279)
			)
			(246
				(return -276)
			)
			(247
				(return -273)
			)
			(248
				(return -270)
			)
			(249
				(return -264)
			)
			(250
				(return -258)
			)
			(251
				(return -252)
			)
			(252
				(return -246)
			)
			(253
				(return -240)
			)
			(254
				(return -234)
			)
			(255
				(return -228)
			)
			(256
				(return -222)
			)
			(257
				(return -216)
			)
			(258
				(return -210)
			)
			(259
				(return -204)
			)
			(260
				(return -198)
			)
			(261
				(return -192)
			)
			(262
				(return -186)
			)
			(263
				(return -180)
			)
			(264
				(return -174)
			)
			(265
				(return -168)
			)
			(266
				(return -162)
			)
			(267
				(return -156)
			)
			(268
				(return -150)
			)
			(269
				(return -144)
			)
			(270
				(return -138)
			)
			(271
				(return -132)
			)
			(272
				(return -126)
			)
			(273
				(return -120)
			)
			(274
				(return -114)
			)
			(275
				(return -108)
			)
			(276
				(return -102)
			)
			(277
				(return -96)
			)
			(278
				(return -90)
			)
			(279
				(return -84)
			)
			(280
				(return -78)
			)
			(281
				(return -72)
			)
			(282
				(return -66)
			)
			(283
				(return -60)
			)
			(284
				(return -54)
			)
			(285
				(return -48)
			)
			(286
				(return -45)
			)
			(287
				(return -42)
			)
			(288
				(return -39)
			)
			(289
				(return -36)
			)
			(290
				(return -33)
			)
			(291
				(return -30)
			)
			(292
				(return -27)
			)
			(293
				(return -24)
			)
			(294
				(return -21)
			)
			(295
				(return -18)
			)
			(296
				(return -15)
			)
			(297
				(return -12)
			)
			(298
				(return -9)
			)
			(299
				(return -6)
			)
			(300
				(return -3)
			)
			(301
				(return 0)
			)
			(302
				(return 0)
			)
			(303
				(return 0)
			)
		)
	)
)

(instance leftToEvtDoub of Code
	(properties)

	(method (doit param1)
		(cond
			((<= param1 -318)
				(return 230)
			)
			((<= param1 -318)
				(return 231)
			)
			((<= param1 -318)
				(return 232)
			)
			((<= param1 -315)
				(return 233)
			)
			((<= param1 -312)
				(return 234)
			)
			((<= param1 -309)
				(return 235)
			)
			((<= param1 -306)
				(return 236)
			)
			((<= param1 -303)
				(return 237)
			)
			((<= param1 -300)
				(return 238)
			)
			((<= param1 -297)
				(return 239)
			)
			((<= param1 -294)
				(return 240)
			)
			((<= param1 -291)
				(return 241)
			)
			((<= param1 -288)
				(return 242)
			)
			((<= param1 -285)
				(return 243)
			)
			((<= param1 -282)
				(return 244)
			)
			((<= param1 -279)
				(return 245)
			)
			((<= param1 -276)
				(return 246)
			)
			((<= param1 -273)
				(return 247)
			)
			((<= param1 -270)
				(return 248)
			)
			((<= param1 -264)
				(return 249)
			)
			((<= param1 -258)
				(return 250)
			)
			((<= param1 -252)
				(return 251)
			)
			((<= param1 -246)
				(return 252)
			)
			((<= param1 -240)
				(return 253)
			)
			((<= param1 -234)
				(return 254)
			)
			((<= param1 -228)
				(return 255)
			)
			((<= param1 -222)
				(return 256)
			)
			((<= param1 -216)
				(return 257)
			)
			((<= param1 -210)
				(return 258)
			)
			((<= param1 -204)
				(return 259)
			)
			((<= param1 -198)
				(return 260)
			)
			((<= param1 -192)
				(return 261)
			)
			((<= param1 -186)
				(return 262)
			)
			((<= param1 -180)
				(return 263)
			)
			((<= param1 -174)
				(return 264)
			)
			((<= param1 -168)
				(return 265)
			)
			((<= param1 -162)
				(return 266)
			)
			((<= param1 -156)
				(return 267)
			)
			((<= param1 -150)
				(return 268)
			)
			((<= param1 -144)
				(return 269)
			)
			((<= param1 -138)
				(return 270)
			)
			((<= param1 -132)
				(return 271)
			)
			((<= param1 -126)
				(return 272)
			)
			((<= param1 -120)
				(return 273)
			)
			((<= param1 -114)
				(return 274)
			)
			((<= param1 -108)
				(return 275)
			)
			((<= param1 -102)
				(return 276)
			)
			((<= param1 -96)
				(return 277)
			)
			((<= param1 -90)
				(return 278)
			)
			((<= param1 -84)
				(return 279)
			)
			((<= param1 -78)
				(return 280)
			)
			((<= param1 -72)
				(return 281)
			)
			((<= param1 -66)
				(return 282)
			)
			((<= param1 -60)
				(return 283)
			)
			((<= param1 -54)
				(return 284)
			)
			((<= param1 -48)
				(return 285)
			)
			((<= param1 -45)
				(return 286)
			)
			((<= param1 -42)
				(return 287)
			)
			((<= param1 -39)
				(return 288)
			)
			((<= param1 -36)
				(return 289)
			)
			((<= param1 -33)
				(return 290)
			)
			((<= param1 -30)
				(return 291)
			)
			((<= param1 -27)
				(return 292)
			)
			((<= param1 -24)
				(return 293)
			)
			((<= param1 -21)
				(return 294)
			)
			((<= param1 -18)
				(return 295)
			)
			((<= param1 -15)
				(return 296)
			)
			((<= param1 -12)
				(return 297)
			)
			((<= param1 -9)
				(return 298)
			)
			((<= param1 -6)
				(return 299)
			)
			((<= param1 -3)
				(return 300)
			)
			(else
				(return 303)
			)
		)
	)
)

