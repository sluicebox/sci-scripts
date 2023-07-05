;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 16)
(include sci.sh)
(use Main)
(use ExitButton)
(use Button)
(use Print)
(use Timer)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	aniProp 0
	descView 1
	slicePieButn 2
	lookButn 3
	coverButn 4
	hurryButn 5
	suspectButn 6
	attentionButn 7
	holdButn 8
	clearButn 9
	stopButn 10
	lashButn 11
	controlButn 12
)

(local
	local0
	local1
)

(procedure (localproc_0 param1 param2 param3)
	(if (gCast contains: descView)
		(descView dispose:)
	else
		(descView view: param1 loop: param2 cel: param3)
		(descView init:)
	)
)

(class SwatButn of Button
	(properties)

	(method (reset))
)

(class SwatInterface of Obj
	(properties
		dftMessage 29
		curIcon 0
		curInvSet 0
		curInvItem 0
		numInvPages 0
		curInvPage 0
		curInvLevel 0
		curHandSignal 0
		curDoorEntry 0
		curModeType 1
		allowedToLevel 0
		curSwatButn 0
		curHandSigType 0
		cursorHidden 0
	)

	(method (getCurrentVerb)
		(return
			(cond
				((not curIcon) dftMessage)
				((OneOf curIcon curHandSignal curDoorEntry)
					(curIcon noun:)
				)
				(else
					(curInvItem verb:)
				)
			)
		)
	)

	(method (handleEvent event &tmp temp0 temp1)
		(if (and global102 (& (event type:) evKEYBOARD))
			(switch (event message:)
				($000b
					(if global128
						(proc4_5 1)
					)
				)
				(KEY_CLEAR
					(if (IsFlag 109)
						(lashButn doVerb:)
					)
				)
				(JOY_DOWN
					(if
						(and
							global112
							(global112 dataNumber:)
							(!= (global112 criticalRoom:) gCurRoomNum)
						)
						(global112 endColumn:)
						(gCurRoom criticalAlert:)
					)
				)
				(KEY_CAPITAL
					(if (not (IsFlag 109))
						(SetFlag 12)
						(repeat
							(if
								(==
									(= temp1
										(Print
											addText: {Choose Scenerio:}
											addButton: 2 {S1 Plot 1} 0 20
											addButton: 3 {S1 Plot 2} 50 20
											addButton: 4 {S2 Plot 1} 0 40
											addButton: 5 {S2 Plot 2} 50 40
											addButton: 6 {S3 Plot 1} 0 60
											addButton: 7 {S3 Plot 2} 50 60
											init:
										)
									)
									6
								)
								(SetFlag 19)
							)
							(if (== temp1 -1)
								(= temp1 0)
								(return)
							else
								(SetFlag 109)
								(= global108 temp1)
							)
							(break)
						)
					)
					(event message: KEY_ALT_t)
				)
			)
		)
		(cond
			((and (not (gUser input:)) (not global139))
				(return)
			)
			((& (event type:) evKEYBOARD)
				(event claimed: 1)
				(switch (event message:)
					(KEY_1
						(self newInvLevel: 1 1)
					)
					(KEY_2
						(self newInvLevel: 2 1)
					)
					(KEY_3
						(self newInvLevel: 3 1)
					)
					(else
						(event claimed: 0)
					)
				)
			)
			((& (event type:) evMOUSE)
				(event globalize:)
				(if
					(or
						cursorHidden
						(and (& (event type:) evMOUSERELEASE) (not global139))
					)
					(event claimed: 1)
					(return)
				)
				(if
					(and
						(not global139)
						curInvItem
						(== curIcon curInvItem)
						(gInventoryPlane onMe: event)
						(event localize: gInventoryPlane)
						(not (curInvSet firstTrue: #onMe event))
						(not (event modifiers:))
					)
					(self setInvItem: 0)
					(self swapCursor:)
					(event claimed: 1)
					(return)
				)
				(event globalize:)
				(if
					(and
						(not global139)
						(not (IsFlag 119))
						(& (event modifiers:) $0007) ; emCTRL | emSHIFT
					)
					(self swapCursor:)
					(event claimed: 1)
					(return)
				else
					(event
						type: (| (event type:) evVERB)
						message: (self getCurrentVerb:)
					)
					(cond
						(
							(and
								curInvItem
								(== curIcon curInvItem)
								(curInvItem data:)
								((curInvItem data:) evtHandler:)
							)
							(((curInvItem data:) evtHandler:)
								handleEvent: event
							)
						)
						(
							(and
								curHandSignal
								(== curIcon curHandSignal)
								(gThePlane onMe: event)
								(& (event type:) evMOUSEBUTTON)
							)
							(if
								(= temp0
									(switch (event message:)
										(KEY_MULTIPLY 1)
										(KEY_ADD 2)
										(KEY_SNAPSHOT 3)
										(KEY_SUBTRACT 4)
										(KEY_DECIMAL 5)
										(KEY_DIVIDE 6)
										(KEY_0 7)
										(KEY_1 8)
										(else 0)
									)
								)
								(self showHandAni: temp0)
							)
							(self setHandSignal: 0)
						)
						((& (event type:) evMOUSERELEASE)
							(event claimed: 1)
							(return)
						)
					)
				)
			)
			(else
				(event claimed: 0)
				(return)
			)
		)
	)

	(method (swapCursor)
		(cond
			((and curInvItem (not curIcon))
				(= curModeType 8)
				(= curIcon curInvItem)
			)
			((and curHandSignal (OneOf curIcon 0 curInvItem))
				(= curModeType 0)
				(= curIcon curHandSignal)
			)
			((and curDoorEntry (OneOf curIcon 0 curInvItem curHandSignal))
				(= curModeType 2)
				(= curIcon curDoorEntry)
			)
			(else
				(= curModeType 1)
				(= curIcon 0)
			)
		)
		(= global129 0)
		(self setCursor:)
	)

	(method (setInvItem param1)
		(if (and curInvItem (!= curInvItem param1))
			(curInvItem displayItem:)
		)
		(= curIcon (= curInvItem param1))
		(if curInvItem
			(gTheInvCursor
				view: (curInvItem cView:)
				loop: (curInvItem cLoop:)
				cel: (if (IsFlag 110) 1 else 0)
			)
		)
		(self setCursor:)
	)

	(method (setInvSet param1)
		(if (and argc param1)
			(= curInvSet param1)
		else
			(= curInvSet gInventory)
		)
		(= curInvItem 0)
	)

	(method (nextInvPage param1 &tmp temp0 temp1 [temp2 3] temp5 temp6)
		(if (not param1)
			(return)
		)
		(= temp5 (+ (= temp5 curInvPage) param1))
		(if
			(!=
				(= temp5 (Min numInvPages (Max 0 temp5)))
				curInvPage
			)
			(= curInvPage temp5)
			(= temp0 419)
			(= temp6 (/ (= temp1 (- (* param1 419))) 8))
			(self slidePlaneH: gInventoryPlane temp6 temp1)
		)
	)

	(method (newInvLevel param1 param2 &tmp temp0 temp1 temp2 temp3)
		(if (not param1)
			(return)
		)
		(= temp1 419)
		(= temp0 61)
		(= temp3 curInvLevel)
		(if (and (> argc 1) param2)
			(if (or (not (self checkLevel: param1)) (== param1 temp3))
				(return)
			)
			(= curInvLevel param1)
			(= param1 (- curInvLevel temp3))
		else
			(+= curInvLevel param1)
		)
		(if (>= curInvLevel 4)
			(= curInvLevel 0)
		)
		(if (< curInvLevel 0)
			(= curInvLevel 3)
		)
		(= temp2 (- (* (- curInvLevel temp3) (+ 2 temp0))))
		(if curInvItem
			(curInvItem show:)
		)
		(MovePlaneItems gInventoryPlane 0 temp2 1)
		(if curInvItem
			(curInvItem hide:)
		)
		(if (== temp3 1)
			(titlePlate posn: 0)
			(handSignals posn: 0)
			(doorEntries posn: 0)
			(UpdateScreenItem titlePlate)
			(UpdateScreenItem handSignals)
			(UpdateScreenItem lookButn)
			(UpdateScreenItem attentionButn)
			(UpdateScreenItem coverButn)
			(UpdateScreenItem holdButn)
			(UpdateScreenItem hurryButn)
			(UpdateScreenItem clearButn)
			(UpdateScreenItem suspectButn)
			(UpdateScreenItem stopButn)
			(UpdateScreenItem doorEntries)
			(UpdateScreenItem slicePieButn)
		)
		(self rotateToLevel: param1 temp3 curInvLevel)
		(scrollUpArrow setActive: (self checkLevel: (- curInvLevel 1)))
		(scrollDownArrow setActive: (self checkLevel: (+ curInvLevel 1)))
		(UpdatePlane gInventoryPlane)
	)

	(method (slidePlaneH param1 param2 param3 &tmp temp0)
		(= temp0 0)
		(while (!= temp0 param3)
			(if
				(or
					(and (> param2 0) (> (+ param2 temp0) param3))
					(and (< param2 0) (< (+ param2 temp0) param3))
				)
				(= param2 (- param3 temp0))
			)
			(+= temp0 param2)
			(if curInvItem
				(curInvItem show:)
			)
			(MovePlaneItems param1 param2 0 1)
			(if curInvItem
				(curInvItem hide:)
			)
			(scrollLeftButn x: 0)
			(scrollRightButn x: 396)
			(UpdateScreenItem scrollLeftButn)
			(UpdateScreenItem scrollRightButn)
			(UpdatePlane param1)
			(FrameOut)
		)
	)

	(method (rotateToLevel param1 param2 param3 &tmp temp0)
		(aniProp
			view: 10
			loop: 14
			posn: 0 0
			setPri: 200
			cycleSpeed: 10
			cel:
				(switch param2
					(0
						(if (< param1 0) 11 else 0)
					)
					(1 3)
					(2 6)
					(3 9)
				)
			init: gInventoryCast
			setCycle:
				CT
				(switch param3
					(0
						(if (> param1 0) 11 else 0)
					)
					(1 3)
					(2 6)
					(3 9)
				)
				param1
				aniProp
		)
		(UpdateScreenItem aniProp)
		(FrameOut)
		(= local0 0)
		(while (not local0)
			(= gGameTime (+ gTickOffset (GetTime)))
			(aniProp doit:)
			(if gCuees
				(gCuees eachElementDo: #doit)
			)
			(FrameOut)
		)
		(SetNowSeen lookButn)
		(SetNowSeen attentionButn)
		(SetNowSeen coverButn)
		(SetNowSeen holdButn)
		(SetNowSeen hurryButn)
		(SetNowSeen clearButn)
		(SetNowSeen suspectButn)
		(SetNowSeen stopButn)
		(SetNowSeen slicePieButn)
	)

	(method (showInterface &tmp temp0)
		(if (not (SetFlag 2))
			(interfaceView init: gInterfaceCast)
			(alertSignal init: gInterfaceCast)
			(controlButn init: gInterfaceCast)
			(scrollUpArrow init: gInterfaceCast setActive: (IsFlag 12))
			(scrollDownArrow init: gInterfaceCast setActive: (IsFlag 12))
			(titlePlate init: gInventoryCast)
			(scrollLeftButn init: gInventoryCast)
			(scrollRightButn init: gInventoryCast)
			(handSignals init: gInventoryCast)
			(lookButn init: gInventoryCast)
			(attentionButn init: gInventoryCast)
			(coverButn init: gInventoryCast)
			(holdButn init: gInventoryCast)
			(hurryButn init: gInventoryCast)
			(clearButn init: gInventoryCast)
			(suspectButn init: gInventoryCast)
			(stopButn init: gInventoryCast)
			(doorEntries init: gInventoryCast)
			(slicePieButn init: gInventoryCast)
			(= curSwatButn (informationButn init: gInterfaceCast yourself:))
			(UpdatePlane gInterfacePlane)
		)
		(if
			(!=
				(= temp0
					(switch global108
						(2 assaultButn)
						(3 assaultButn)
						(4 assaultButn)
						(5 assaultButn)
						(6 assaultButn)
						(7 sniperButn)
						(else informationButn)
					)
				)
				curSwatButn
			)
			(if (IsFlag 109)
				(if (gInterfaceCast contains: alertSignal)
					(alertSignal dispose:)
				)
				(lashButn init: gInterfaceCast)
			)
			(if curSwatButn
				(curSwatButn dispose:)
			)
			(= curSwatButn temp0)
			(curSwatButn init: gInterfaceCast)
		)
		(if (and (IsFlag 12) (not (SetFlag 13)))
			(if (gTimers contains: descTimer)
				(descTimer dispose: delete:)
			)
			((ScriptID 19 0) doit:) ; swatInvInit
			(gSwatInterface newInvLevel: 1)
		)
		(cond
			((curSwatButn cycler:)
				(gTheDoits add: curSwatButn)
			)
			((!= (curSwatButn cel:) (curSwatButn lastCel:))
				(= local1 0)
				(switch curSwatButn
					(assaultButn
						(assaultButn view: 10 loop: 19 cel: 0)
					)
					(informationButn
						(informationButn
							view: 10
							setLoop: 17
							setCel: 0
							setActive: 1
						)
					)
					(sniperButn
						(sniperButn view: 10 loop: 20 cel: 0)
					)
				)
			)
		)
		(UpdatePlane gInventoryPlane)
	)

	(method (startAlert param1)
		(gBackMusic stop:)
		(gBackMusic2 stop:)
		(if (not (gTalkers isEmpty:))
			(gTalkers eachElementDo: #dispose)
		)
		(gTimers eachElementDo: #delete)
		(if (or (not argc) param1)
			(gGame setScript: doAlert)
		else
			(alertSound stop: dispose:)
			(gTheDoits delete: alertSignal)
		)
	)

	(method (setHandSignal param1)
		(= curHandSignal (gTheHandSigCursor view: 985 loop: 0 cel: 0 yourself:))
		(switch param1
			(1
				(gTheHandSigCursor noun: 42)
			)
			(2
				(gTheHandSigCursor noun: 43)
			)
			(3
				(gTheHandSigCursor noun: 44)
			)
			(4
				(gTheHandSigCursor noun: 45)
			)
			(5
				(gTheHandSigCursor noun: 46)
			)
			(6
				(gTheHandSigCursor noun: 47)
			)
			(7
				(gTheHandSigCursor noun: 48)
			)
			(8
				(gTheHandSigCursor noun: 49)
			)
			(else
				(= curHandSignal 0)
			)
		)
		(= curIcon curHandSignal)
		(self setCursor:)
	)

	(method (setDoorEntry param1)
		(= curDoorEntry (gTheDoorEntryCursor view: 987 loop: 2 cel: 0 yourself:))
		(switch param1
			(2
				(gTheDoorEntryCursor noun: 55)
			)
			(else
				(= curDoorEntry 0)
			)
		)
		(= curIcon curDoorEntry)
		(self setCursor:)
	)

	(method (setInvPage param1 &tmp temp0)
		(if (== (= temp0 curInvPage) param1)
			(return temp0)
		)
		(MovePlaneItems gInventoryPlane (- (* (- (gSwatInterface curInvPage:)) 419)) 0 1)
		(gSwatInterface curInvPage: param1)
		(titlePlate x: 0)
		(handSignals x: 0)
		(doorEntries x: 0)
		(scrollLeftButn x: 0)
		(scrollRightButn x: 396)
		(UpdateScreenItem titlePlate)
		(UpdateScreenItem handSignals)
		(UpdateScreenItem doorEntries)
		(UpdateScreenItem scrollLeftButn)
		(UpdateScreenItem scrollRightButn)
		(return temp0)
	)

	(method (closeInvWindow &tmp temp0)
		(if
			(and
				(not (IsFlag 12))
				(or
					(!= (gSwatInterface curInvLevel:) 0)
					(!= (gSwatInterface curInvPage:) 0)
				)
			)
			(if curInvItem
				(curInvItem show:)
			)
			(MovePlaneItems
				gInventoryPlane
				(- (* (- (gSwatInterface curInvPage:)) 419))
				(- (* (- 0 (gSwatInterface curInvLevel:)) 63))
				1
			)
			(= temp0 (gSwatInterface curInvLevel:))
			(gSwatInterface curInvLevel: 0 curInvPage: 0)
			(scrollUpArrow setActive: (IsFlag 12))
			(scrollDownArrow setActive: (IsFlag 12))
			(if (gTimers contains: descTimer)
				(descTimer dispose: delete:)
			)
			(= curIcon (= curInvItem (= curHandSignal (= curDoorEntry 0))))
			(titlePlate x: 0)
			(handSignals x: 0)
			(doorEntries x: 0)
			(scrollLeftButn x: 0)
			(scrollRightButn x: 396)
			(UpdateScreenItem titlePlate)
			(UpdateScreenItem handSignals)
			(UpdateScreenItem doorEntries)
			(UpdateScreenItem scrollLeftButn)
			(UpdateScreenItem scrollRightButn)
			(if (gTheDoits contains: curSwatButn)
				(gTheDoits delete: curSwatButn)
			)
			(gInterfaceCast delete: (curSwatButn dispose: yourself:))
			(= global419 global108)
			(= global108 0)
			(= curSwatButn (informationButn init: gInterfaceCast yourself:))
			(ClearFlag 13)
			(ClearFlag 15)
			(ClearFlag 14)
			(= allowedToLevel 0)
			(if (!= temp0 0)
				(gSwatInterface rotateToLevel: -1 temp0 0)
			)
		)
		(if (and (not (IsFlag 109)) (gInterfaceCast contains: lashButn))
			(lashButn dispose:)
			(alertSignal cel: 0 init: gInterfaceCast)
			(UpdateScreenItem alertSignal)
		)
	)

	(method (setCursor &tmp temp0)
		(cond
			((== gCurRoomNum 30) ; prevCareerCallups
				(gWaitCursor view: 995)
			)
			((== gCurRoomNum 100)
				(gWaitCursor view: 994)
			)
			(else
				(gWaitCursor view: 997)
			)
		)
		(if (not (IsFlag 110))
			(gTheInvCursor cel: 0)
		)
		(cond
			(cursorHidden
				(= temp0 gTheInvisCursor)
			)
			((not (gUser input:))
				(= temp0 gWaitCursor)
			)
			(global129
				(= temp0 gTheHotspotCursor)
			)
			((and curInvItem (== curIcon curInvItem))
				(= curModeType 8)
				(= temp0 gTheInvCursor)
			)
			((and curHandSignal (== curIcon curHandSignal))
				(= curModeType 0)
				(= temp0 gTheHandSigCursor)
			)
			((and curDoorEntry (== curIcon curDoorEntry))
				(switch (gTheDoorEntryCursor noun:)
					(55
						(= curModeType 2)
					)
				)
				(= temp0 gTheDoorEntryCursor)
			)
			(else
				(= curModeType 1)
				(= temp0 gNormalCursor)
			)
		)
		(gGame setCursor: temp0 1)
	)

	(method (replaceInvItem)
		(curInvItem show:)
		(= curIcon (= curInvItem 0))
		(self setCursor:)
	)

	(method (checkLevel param1)
		(if (>= param1 4)
			(= param1 0)
		)
		(if (< param1 0)
			(= param1 3)
		)
		(if
			(or
				(IsFlag 15)
				(not (IsFlag 12))
				(and (IsFlag 14) (> param1 allowedToLevel))
			)
			(return 0)
		else
			(return 1)
		)
	)

	(method (showHandAni param1 param2 param3 &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(if (and (> argc 1) param2)
			(= global124 param2)
		)
		(if (or (< argc 3) param3)
			(= local1 0)
			(if (gTimers contains: descTimer)
				(descTimer dispose: delete:)
			)
		)
		(= temp0 (= temp1 (= temp2 (= temp3 (= temp4 0)))))
		(switch param1
			(8
				(= temp0 52)
				(= temp1 0)
				(= temp3 12)
				(= temp4 12)
			)
			(7
				(= temp0 53)
				(= temp1 0)
				(= temp3 12)
				(= temp4 12)
			)
			(5
				(= temp0 54)
				(= temp1 0)
				(= temp3 12)
				(= temp4 12)
			)
			(3
				(= temp0 55)
				(= temp1 0)
				(= temp3 12)
				(= temp4 12)
			)
			(2
				(= temp0 55)
				(= temp1 1)
				(= temp3 12)
				(= temp4 12)
			)
			(6
				(= temp0 55)
				(= temp1 2)
				(= temp3 12)
				(= temp4 12)
			)
			(1
				(= temp0 57)
				(= temp1 0)
				(= temp3 12)
				(= temp4 12)
			)
			(4
				(= temp0 59)
				(= temp1 0)
				(= temp3 12)
				(= temp4 12)
			)
			(else
				(curSwatButn reset:)
				(if local1
					(self cue:)
				)
			)
		)
		(if (and curSwatButn param1)
			(if (not (gTheDoits contains: curSwatButn))
				(gTheDoits add: curSwatButn)
			)
			(= curHandSigType param1)
			(if (not (OneOf (curSwatButn view:) 52 53 54 55 57 59))
				(= local1 0)
				(= temp0 55)
				(= temp1 3)
				(= temp2 0)
				(= temp3 (= temp4 12))
			)
			(curSwatButn
				view: temp0
				loop: temp1
				cel: temp2
				posn: temp3 temp4
				setCycle: End self
				setActive: 0
			)
		)
	)

	(method (cue)
		(switch (++ local1)
			(1
				(self showHandAni: curHandSigType 0 0)
			)
			(2
				(gTheDoits delete: curSwatButn)
				(if (!= gCurRoomNum 6400)
					(descTimer setReal: self 4)
				)
				(if global124
					(global124 cue:)
					(= global124 0)
				)
			)
			(3
				(self showHandAni: 0 0 0)
			)
			(4
				(gTheDoits delete: curSwatButn)
				(curSwatButn setActive: 1)
				(= local1 0)
			)
		)
	)

	(method (hideCursor param1 param2 param3)
		(= cursorHidden (or (not argc) param1))
		(self setCursor:)
		(if (> argc 1)
			(SetCursor param2 param3)
		)
	)

	(method (setMaxInvLevel param1)
		(= allowedToLevel param1)
		(if (IsFlag 12)
			(scrollUpArrow setActive: (self checkLevel: (- curInvLevel 1)))
			(scrollDownArrow setActive: (self checkLevel: (+ curInvLevel 1)))
		)
	)
)

(instance aniProp of Prop
	(properties)

	(method (cue)
		(= local0 1)
		(self dispose:)
	)
)

(instance interfaceView of View
	(properties
		view 10
	)

	(method (onMe)
		(return 0)
	)
)

(instance titlePlate of View
	(properties
		priority 100
		fixPriority 1
		view 10
		loop 14
	)
)

(instance alertSignal of Prop
	(properties
		view 13
		loop 3
	)

	(method (init)
		(self posn: 577 14)
		(super init: &rest)
	)

	(method (onMe)
		(return 0)
	)
)

(instance lashButn of Button
	(properties
		view 10
		loop 5
	)

	(method (init)
		(self posn: 576 13)
		(super init: &rest)
	)

	(method (doVerb)
		(cond
			((== gCurRoomNum 4051) ; s1_405
				(if (not (gCurRoom script:))
					(gCurRoom setScript: (ScriptID 4051 1)) ; doLash
				)
			)
			((== gCurRoomNum 4000) ; s1_4000
				(if (not (gCurRoom script:))
					(gCurRoom setScript: (ScriptID 4000 1)) ; doLash
				)
			)
			((IsFlag 65)
				(gCurRoom lashNotify: 0)
			)
			((== global108 6)
				((ScriptID 75 0) doit:) ; elementLeaderLashInterface
			)
			((== global108 7)
				((ScriptID 69 0) doit:) ; theLashInterface
			)
			(else
				((ScriptID 74 0) doit:) ; theLashInterface
			)
		)
		(DisposeScript 69)
		(DisposeScript 74)
		(DisposeScript 75)
		(DisposeScript 73)
	)
)

(instance controlButn of Button
	(properties
		view 10
		loop 4
	)

	(method (init)
		(self posn: 572 36)
		(super init: &rest)
	)

	(method (doVerb)
		(gGame controlPanel:)
	)
)

(instance scrollLeftButn of Button
	(properties
		view 10
		loop 2
	)

	(method (init)
		(self setPri: 150 posn: 0 63)
		(super init: &rest)
	)

	(method (doVerb)
		(if (IsFlag 12)
			(gSwatInterface nextInvPage: -1)
		)
	)
)

(instance scrollRightButn of Button
	(properties
		x 199
		view 10
		loop 3
	)

	(method (init)
		(self setPri: 150 posn: 396 63)
		(super init: &rest)
	)

	(method (doVerb)
		(if (IsFlag 12)
			(gSwatInterface nextInvPage: 1)
		)
	)
)

(instance scrollDownArrow of Button
	(properties
		x 534
		y 50
		view 10
		loop 6
	)

	(method (doVerb)
		(if (IsFlag 12)
			(gSwatInterface newInvLevel: 1)
		)
	)
)

(instance scrollUpArrow of Button
	(properties
		x 534
		y 12
		view 10
		loop 7
	)

	(method (doVerb)
		(if (IsFlag 12)
			(gSwatInterface newInvLevel: -1)
		)
	)
)

(instance handSignals of View
	(properties
		view 10
		loop 10
	)

	(method (init)
		(self posn: 0 126)
		(super init: &rest)
	)

	(method (posn)
		(super posn: &rest)
		(lookButn posn:)
		(attentionButn posn:)
		(coverButn posn:)
		(holdButn posn:)
		(hurryButn posn:)
		(clearButn posn:)
		(suspectButn posn:)
		(stopButn posn:)
	)
)

(instance lookButn of Button
	(properties
		view 10
		loop 11
		downCel 8
		useRect 1
	)

	(method (init)
		(self posn:)
		(super init: &rest)
	)

	(method (posn)
		(if (not argc)
			(= x (+ (handSignals x:) 4))
			(= y (+ (handSignals y:) 3))
		else
			(super posn: &rest)
		)
	)

	(method (doVerb)
		(gSwatInterface setHandSignal: 1)
	)
)

(instance attentionButn of Button
	(properties
		view 10
		loop 11
		upCel 1
		downCel 8
		useRect 1
	)

	(method (init)
		(self posn:)
		(super init: &rest)
	)

	(method (posn)
		(if (not argc)
			(= x (+ (handSignals x:) 4))
			(= y (+ (handSignals y:) 34))
		else
			(super posn: &rest)
		)
	)

	(method (doVerb)
		(gSwatInterface setHandSignal: 2)
	)
)

(instance coverButn of Button
	(properties
		view 10
		loop 11
		upCel 2
		downCel 8
		useRect 1
	)

	(method (init)
		(self posn:)
		(super init: &rest)
	)

	(method (posn)
		(if (not argc)
			(= x (+ (handSignals x:) 108))
			(= y (+ (handSignals y:) 3))
		else
			(super posn: &rest)
		)
	)

	(method (doVerb)
		(gSwatInterface setHandSignal: 3)
	)
)

(instance holdButn of Button
	(properties
		view 10
		loop 11
		upCel 3
		downCel 8
		useRect 1
	)

	(method (init)
		(self posn:)
		(super init: &rest)
	)

	(method (posn)
		(if (not argc)
			(= x (+ (handSignals x:) 108))
			(= y (+ (handSignals y:) 34))
		else
			(super posn: &rest)
		)
	)

	(method (doVerb)
		(gSwatInterface setHandSignal: 4)
	)
)

(instance hurryButn of Button
	(properties
		view 10
		loop 11
		upCel 4
		downCel 8
		useRect 1
	)

	(method (init)
		(self posn:)
		(super init: &rest)
	)

	(method (posn)
		(if (not argc)
			(= x (+ (handSignals x:) 213))
			(= y (+ (handSignals y:) 3))
		else
			(super posn: &rest)
		)
	)

	(method (doVerb)
		(gSwatInterface setHandSignal: 5)
	)
)

(instance clearButn of Button
	(properties
		view 10
		loop 11
		upCel 5
		downCel 8
		useRect 1
	)

	(method (init)
		(self posn:)
		(super init: &rest)
	)

	(method (posn)
		(if (not argc)
			(= x (+ (handSignals x:) 213))
			(= y (+ (handSignals y:) 34))
		else
			(super posn: &rest)
		)
	)

	(method (doVerb)
		(gSwatInterface setHandSignal: 6)
	)
)

(instance suspectButn of Button
	(properties
		view 10
		loop 11
		upCel 6
		downCel 8
		useRect 1
	)

	(method (init)
		(self posn:)
		(super init: &rest)
	)

	(method (posn)
		(if (not argc)
			(= x (+ (handSignals x:) 318))
			(= y (+ (handSignals y:) 3))
		else
			(super posn: &rest)
		)
	)

	(method (doVerb)
		(gSwatInterface setHandSignal: 7)
	)
)

(instance stopButn of Button
	(properties
		view 10
		loop 11
		upCel 7
		downCel 8
		useRect 1
	)

	(method (init)
		(self posn:)
		(super init: &rest)
	)

	(method (posn)
		(if (not argc)
			(= x (+ (handSignals x:) 318))
			(= y (+ (handSignals y:) 34))
		else
			(super posn: &rest)
		)
	)

	(method (doVerb)
		(gSwatInterface setHandSignal: 8)
	)
)

(instance doorEntries of View
	(properties
		view 10
		loop 14
		cel 9
	)

	(method (init)
		(self posn: 0 189)
		(super init: &rest)
	)

	(method (posn)
		(super posn: &rest)
		(slicePieButn posn:)
	)
)

(instance slicePieButn of Button
	(properties
		view 10
		upLoop 15
		upCel 1
		downLoop 11
		downCel 8
		useRect 1
	)

	(method (init)
		(self posn:)
		(super init: &rest)
	)

	(method (posn)
		(if (not argc)
			(= x (+ (doorEntries x:) 125))
			(= y (+ (doorEntries y:) 19))
		else
			(super posn: &rest)
		)
	)

	(method (doVerb)
		(gSwatInterface setDoorEntry: 2)
	)
)

(instance informationButn of SwatButn
	(properties
		view 10
		loop 17
		upLoop 17
		downLoop 17
	)

	(method (cue)
		(gTheDoits delete: self)
	)

	(method (init)
		(self posn: 10 10)
		(super init: &rest)
	)

	(method (setActive param1)
		(if (or (not argc) param1)
			(self active: 1)
		else
			(self active: 0)
		)
	)

	(method (reset)
		(= view 10)
		(= loop 17)
		(= cel 0)
		(self posn: 10 10)
		(UpdateScreenItem self)
	)

	(method (doVerb &tmp [temp0 4])
		(if (gCast contains: (ScriptID 50 0)) ; PactTimer
			((ScriptID 50 0) pause: 1) ; PactTimer
		)
		(if (gCurRoom inset:)
			((gCurRoom inset:) dispose:)
		)
		(gCurRoom displayTravel:)
	)
)

(instance sniperButn of SwatButn
	(properties
		view 10
		loop 20
	)

	(method (cue)
		(gTheDoits delete: self)
	)

	(method (init)
		(self posn: 10 11)
		(super init: &rest)
	)

	(method (setActive param1)
		(if (or (not argc) param1)
			(self active: 1)
		else
			(self active: 0)
		)
	)

	(method (reset)
		(= view 10)
		(= loop 20)
		(= cel 0)
		(self posn: 10 11)
		(UpdateScreenItem self)
	)

	(method (doVerb)
		(if argc
			(switch global108
				(6
					(localproc_0 1002 0 0)
				)
				(7
					(localproc_0 1002 0 0)
				)
			)
		else
			(switch global108
				(6
					(localproc_0 1001 0 0)
				)
				(7
					(localproc_0 1001 0 0)
				)
			)
		)
	)
)

(instance assaultButn of SwatButn
	(properties
		view 10
		loop 19
	)

	(method (cue)
		(gTheDoits delete: self)
	)

	(method (init)
		(self posn: 12 11)
		(super init: &rest)
	)

	(method (reset)
		(= view 10)
		(= loop 19)
		(= cel 0)
		(self posn: 12 11)
		(UpdateScreenItem self)
	)

	(method (setActive param1)
		(if (or (not argc) param1)
			(self active: 1)
		else
			(self active: 0)
		)
	)

	(method (doVerb)
		(if argc
			(switch global108
				(2
					(localproc_0 4026 0 0)
				)
				(3
					(localproc_0 4026 0 0)
				)
				(4
					(localproc_0 29901 0 0)
				)
				(5
					(localproc_0 29901 0 0)
				)
				(6
					(localproc_0 1002 0 0)
				)
				(7
					(localproc_0 1002 0 0)
				)
			)
		else
			(switch global108
				(2
					(localproc_0 4025 0 0)
				)
				(3
					(localproc_0 4025 0 0)
				)
				(4
					(localproc_0 29900 0 0)
				)
				(5
					(localproc_0 29900 0 0)
				)
				(6
					(localproc_0 1001 0 0)
				)
				(7
					(localproc_0 1001 0 0)
				)
			)
		)
	)
)

(instance alertSound of Sound
	(properties)
)

(instance doAlert of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gTheDoits add: alertSignal)
				(= register 0)
				(= cycles 2)
			)
			(1
				(if (<= (++ register) 8)
					(-- state)
					(if
						(not
							(OneOf
								gCurRoomNum
								8 ; sierraLogo
								10 ; titleScreen
								15 ; mainMenu
								25 ; prevCareerId
								30 ; prevCareerCallups
								20 ; newCareer
								100
								13 ; openToon
								21
								40
								72 ; funeralRoom
							)
						)
						(alertSignal cel: 0 setCycle: End)
					)
					(alertSound number: 4 loop: 1 play: self)
				else
					(= cycles 1)
				)
			)
			(2
				(gSwatInterface startAlert: 0)
				((ScriptID 60) doit:) ; dispatchPlayer
				(self dispose:)
			)
		)
	)
)

(instance descView of View
	(properties
		priority 1000
		fixPriority 1
	)

	(method (init)
		(if (== view -1)
			(return)
		)
		(super init: &rest)
		((gSwatInterface curSwatButn:) setActive: 0)
		(self posn:)
		(descTimer setReal: descTimer 4)
	)

	(method (dispose)
		(if (gTimers contains: descTimer)
			(descTimer dispose: delete:)
		)
		((gSwatInterface curSwatButn:) setActive: 1)
		(= view -1)
		(super dispose: &rest)
	)

	(method (posn &tmp [temp0 3] temp3 temp4)
		(if (== view -1)
			(return)
		)
		(= temp4 (gThePlane bottom:))
		(= temp3 (CelHigh view loop cel))
		(= x 20)
		(= y (- (- temp4 temp3) 20))
		(UpdateScreenItem self)
	)

	(method (onMe)
		(return 0)
	)
)

(instance descTimer of Timer
	(properties)

	(method (cue)
		(if (gCast contains: descView)
			(descView dispose:)
		)
	)
)

