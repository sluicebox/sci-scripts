;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64892)
(include sci.sh)
(use Main)
(use TimePauser)
(use DText)
(use Plane)
(use Print)
(use Game)
(use User)
(use System)

(class NewUser of User
	(properties
		mapKeyToDir 0
	)

	(method (doit)
		(curEvent new:)
		(gOEventHandler handleEvent: curEvent)
	)
)

(class DoitChangedGame of Game
	(properties)

	(method (doit &tmp temp0 temp1)
		(FrameOut)
		(if panelObj
			(= temp0 panelObj)
			(= temp1 panelSelector)
			(= panelObj (= panelSelector 0))
			(Eval temp0 temp1)
		)
		(if (!= gNewRoomNum gCurRoomNum)
			(self newRoom: gNewRoomNum)
		)
		(= gGameTime (+ gTickOffset (GetTime)))
		(gSounds eachElementDo: #check)
		(if (not (TimePauser bIsPaused:))
			(gTimers eachElementDo: #doit)
		)
		(if gAutoRobot
			(gAutoRobot doit:)
		)
		(if (and gCurRoom (gCurRoom inset:))
			(gCast doit:)
		else
			(gPlanes eachElementDo: #doit)
		)
		(if gDoMotionCue
			(= gDoMotionCue 0)
			(gCast eachElementDo: #motionCue)
		)
		(if (and gCuees (not (TimePauser bIsPaused:)))
			(gCuees eachElementDo: #doit)
			(if (gCuees isEmpty:)
				(gCuees dispose:)
				(= gCuees 0)
			)
		)
		(if (and script (not (TimePauser bIsPaused:)))
			(script doit:)
		)
		(if (not (TimePauser bIsPaused:))
			(gRegions eachElementDo: #doit)
		)
		(if (not (TimePauser bIsPaused:))
			(gTheDoits doit:)
		)
		(if (== gNewRoomNum gCurRoomNum)
			(gUser doit:)
		)
		(if (not (TimePauser bIsPaused:))
			(gTimers eachElementDo: #delete)
		)
	)
)

(class NewHandlerList of Set
	(properties)

	(method (handleEvent event param2 param3 &tmp temp0 temp1 temp2 temp3)
		(if (> argc 1)
			(= temp3 param2)
		else
			(= temp3 0)
		)
		(if (> argc 2)
			(= temp2 param3)
		else
			(= temp2 0)
		)
		(if (not temp3)
			(event globalize:)
		)
		(for
			((= temp0 (KList 3 elements))) ; FirstNode
			(and temp0 (not (event claimed:)))
			((= temp0 nextNode))
			
			(= nextNode (KList 6 temp0)) ; NextNode
			(= temp1 (KList 8 temp0)) ; NodeValue
			(if temp3
				(if (temp1 respondsTo: #plane)
					(if ((temp1 plane:) isEnabled:)
						(event localize: (temp1 plane:))
					else
						(continue)
					)
				else
					(event globalize:)
				)
			)
			(if
				(and
					temp2
					(temp1 respondsTo: #onMe)
					(temp1 respondsTo: #noun)
					(temp1 onMe: event)
				)
				(gOEventHandler doToolHelp: temp1 event)
			)
			(if (temp1 handleEvent: event)
				(if temp2
					(gOEventHandler changeCursor: temp1)
				)
				(break)
			)
		)
		(event claimed:)
	)
)

(class EventCode of Obj
	(properties)

	(method (handleEvent))
)

(class NewEventHandler of Obj
	(properties
		nLastCursX 0
		nLastCursY 0
		nToolHelpTime 0
		oCurToolHelp 0
		oCurHelpItem 0
		bTimerStarted 0
		bSortedFeatures 1
		oHandsOffList 0
		oEventHogList 0
		oGlobalHandlers 0
		oKeyHandlers 0
		oDefaultHandlers 0
		oUnderMouseList 0
	)

	(method (registerHandsOffActive param1)
		(if (not oHandsOffList)
			(= oHandsOffList (NewHandlerList new:))
		)
		(oHandsOffList add: param1)
	)

	(method (unregisterHandsOffActive param1)
		(if oHandsOffList
			(oHandsOffList delete: param1)
		)
	)

	(method (registerEventHog param1)
		(if (not oEventHogList)
			(= oEventHogList (NewHandlerList new:))
		)
		(oEventHogList addToFront: param1)
	)

	(method (unregisterEventHog param1)
		(if oEventHogList
			(oEventHogList delete: param1)
		)
	)

	(method (killAllEventHogs &tmp temp0 temp1)
		(while (and oEventHogList (oEventHogList size:))
			(if (== (= temp0 (KList 8 (oEventHogList first:))) temp1) ; NodeValue, UNINIT
				(PrintDebug
					{Warning: %s does not have effective stopHogging method.}
					(temp0 name:)
				)
				(return)
			)
			(if (temp0 respondsTo: #stopHogging)
				(temp0 stopHogging:)
			else
				(PrintDebug
					{Warning: %s does not have stopHogging method.}
					(temp0 name:)
				)
				(return)
			)
			(= temp1 temp0)
		)
	)

	(method (registerGlobalHandler param1)
		(if (not oGlobalHandlers)
			(= oGlobalHandlers (NewHandlerList new:))
		)
		(oGlobalHandlers addToFront: param1)
	)

	(method (unregisterGlobalHandler param1)
		(if oGlobalHandlers
			(oGlobalHandlers delete: param1)
		)
	)

	(method (registerKeyHandler param1)
		(if (not oKeyHandlers)
			(= oKeyHandlers (NewHandlerList new:))
		)
		(oKeyHandlers addToFront: param1)
	)

	(method (unregisterKeyHandler param1)
		(if oKeyHandlers
			(oKeyHandlers delete: param1)
		)
	)

	(method (registerDefaultHandler param1)
		(if (not oDefaultHandlers)
			(= oDefaultHandlers (NewHandlerList new:))
		)
		(oDefaultHandlers addToFront: param1)
	)

	(method (unregisterDefaultHandler param1)
		(if oDefaultHandlers
			(oDefaultHandlers delete: param1)
		)
	)

	(method (dispose)
		(if oHandsOffList
			(oHandsOffList release:)
			(oHandsOffList dispose:)
		)
		(if oEventHogList
			(oEventHogList release:)
			(oEventHogList dispose:)
		)
		(if oGlobalHandlers
			(oGlobalHandlers dispose:)
		)
		(if oDefaultHandlers
			(oDefaultHandlers dispose:)
		)
		(if oKeyHandlers
			(oKeyHandlers dispose:)
		)
		(if oUnderMouseList
			(oUnderMouseList dispose:)
		)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3 temp4)
		(= gMouseX (event x:))
		(= gMouseY (event y:))
		(if
			(and
				(not (gPrints isEmpty:))
				(not (gPrints allTrue: #isModeless 2))
			)
			(gPrints eachElementDo: #doit firstTrue: #handleEvent event)
			(return 1)
		)
		(if (event claimed:)
			(return 1)
		)
		(self doToolHelp: 0 event)
		(if (and oGlobalHandlers (oGlobalHandlers handleEvent: event 0 0))
			(return 1)
		)
		(if
			(and
				(& (event type:) $000c) ; evKEYUP | evKEYBOARD
				oKeyHandlers
				(oKeyHandlers handleEvent: event 0 0)
			)
			(return 1)
		)
		(if (& (event type:) $000c) ; evKEYUP | evKEYBOARD
			(return 0)
		)
		(if (and oEventHogList (oEventHogList handleEvent: event 1 0))
			(return 1)
		)
		(if (not (gUser canControl:))
			(if (and oHandsOffList (oHandsOffList handleEvent: event 1 1))
				(event claimed: 1)
			)
			(if (and (not (gTalkers isEmpty:)) (not (TimePauser bIsPaused:)))
				(gTalkers eachElementDo: #doit firstTrue: #handleEvent event)
			)
			(if (not (event claimed:))
				(self changeCursor: 0)
			)
			(event claimed:)
			(return)
		)
		(if (and gCurRoom (gCurRoom inset:))
			(event localize: (gCast plane:))
			(if (= temp3 (gCast firstTrue: #onMe event))
				(self doToolHelp: temp3 event)
			)
			(if (= temp3 (gFeatures firstTrue: #onMe event))
				(self doToolHelp: temp3 event)
			)
			(self doToolHelp: 0 event)
			(if (= temp3 (gCast firstTrue: #handleEvent event))
				(self changeCursor: temp3)
				(return 1)
			)
			(if (= temp3 (gFeatures firstTrue: #handleEvent event))
				(self changeCursor: temp3)
				(return 1)
			)
			(self changeCursor: 0)
			(return 0)
		)
		(for
			((= temp0 (gPlanes first:)))
			temp0
			((= temp0 (gPlanes next: temp0)))
			
			(= temp1 (KList 8 temp0)) ; NodeValue
			(if (self handlePlaneEvent: temp1 event)
				(return 1)
			)
		)
		(self changeCursor: 0)
		(if (and oDefaultHandlers (oDefaultHandlers handleEvent: event 0 0))
			(return 1)
		)
		(return 0)
	)

	(method (handlePlaneEvent param1 param2 &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(param2 globalize:)
		(if (not (param1 onMe: param2))
			(return 0)
		)
		(if (or (== (param1 priority:) -1) (== (param1 priority:) 510))
			(return 0)
		)
		(param2 localize: param1)
		(= temp2 (param1 casts:))
		(if oUnderMouseList
			(oUnderMouseList release:)
			(oUnderMouseList dispose:)
			(= oUnderMouseList 0)
		)
		(for ((= temp4 (temp2 first:))) temp4 ((= temp4 (temp2 next: temp4)))
			(= temp1 (KList 8 temp4)) ; NodeValue
			(for
				((= temp3 (temp1 first:)))
				temp3
				((= temp3 (temp1 next: temp3)))
				
				(= temp0 (KList 8 temp3)) ; NodeValue
				(if (and (temp0 onMe: param2) bSortedFeatures)
					(self addUnderMouse: temp0)
				else
					(self doToolHelp: temp0 param2)
					(if (temp0 handleEvent: param2)
						(self changeCursor: temp0)
						(return 1)
					)
				)
			)
		)
		(= temp5 (param1 oMyFeatures:))
		(for ((= temp3 (temp5 first:))) temp3 ((= temp3 (temp5 next: temp3)))
			(= temp0 (KList 8 temp3)) ; NodeValue
			(if (and (temp0 onMe: param2) bSortedFeatures)
				(self addUnderMouse: temp0)
			else
				(self doToolHelp: temp0 param2)
				(if (temp0 handleEvent: param2)
					(self changeCursor: temp0)
					(return 1)
				)
			)
		)
		(if (and bSortedFeatures oUnderMouseList)
			(for
				((= temp3 (oUnderMouseList first:)))
				temp3
				((= temp3 (oUnderMouseList next: temp3)))
				
				(= temp0 (KList 8 temp3)) ; NodeValue
				(self doToolHelp: temp0 param2)
				(if (temp0 handleEvent: param2)
					(self changeCursor: temp0)
					(return 1)
				)
			)
		)
		(return 0)
	)

	(method (addUnderMouse param1 &tmp temp0 temp1 temp2)
		(if (not oUnderMouseList)
			(= oUnderMouseList (Set new:))
		)
		(= temp0 (oUnderMouseList first:))
		(= temp1 0)
		(while temp0
			(= temp2 (KList 8 temp0)) ; NodeValue
			(if (> (param1 myPriority:) (temp2 myPriority:))
				(break)
			)
			(= temp1 temp2)
			(= temp0 (oUnderMouseList next: temp0))
		)
		(if temp1
			(oUnderMouseList addAfter: temp1 param1)
		else
			(oUnderMouseList addToFront: param1)
		)
	)

	(method (changeCursor param1 &tmp temp0 temp1)
		(if param1
			(if (and (= temp0 (param1 forceCursor:)) (!= temp0 -1))
				(if (!= gTheCursor temp0)
					(gGame setCursor: temp0)
				)
			else
				(if (>= global101 (global100 size:))
					(Prints {ERROR: no cursor for verb %d} global101)
					(= temp1 (global100 at: 0))
				else
					(= temp1 (global100 at: global101))
				)
				(if (!= gTheCursor gNormalCursor)
					(gGame setCursor: gNormalCursor)
				)
				(if (!= (gTheCursor view:) temp1)
					(gTheCursor setView: temp1)
				)
				(cond
					((== temp0 -1)
						(if (!= (gTheCursor cel:) 0)
							(gTheCursor setCel: 0)
						)
					)
					((!= (gTheCursor cel:) 1)
						(gTheCursor setCel: 1)
					)
				)
			)
		else
			(if (>= global101 (global100 size:))
				(Prints {ERROR: no cursor for verb %d} global101)
				(= temp1 (global100 at: 0))
			else
				(= temp1 (global100 at: global101))
			)
			(if (not (gUser canControl:))
				(if (!= gTheCursor gWaitCursor)
					(gGame setCursor: gWaitCursor)
				)
				(return)
			)
			(if (!= gTheCursor gNormalCursor)
				(gGame setCursor: gNormalCursor)
			)
			(if (!= (gTheCursor view:) temp1)
				(gTheCursor setView: temp1)
			)
			(if (gTheCursor cel:)
				(gTheCursor setCel: 0)
			)
		)
	)

	(method (doToolHelp &tmp [temp0 5]))

	(method (killToolHelp)
		(if oCurHelpItem
			(oCurToolHelp dispose:)
			(= bTimerStarted (= oCurHelpItem (= oCurToolHelp 0)))
		)
	)

	(method (notifyDispose param1)
		(if (== param1 oCurHelpItem)
			(self killToolHelp:)
		)
	)
)

(class ToolHelpView of DText
	(properties
		back 64
		font 0
		skip 255
		borderColor 0
	)
)

(class ToolHelpPlane of Plane
	(properties
		priority 510
		picture -2
		voMyHelp 0
	)

	(method (init param1 param2 param3 &tmp temp0 temp1 temp2 temp3)
		(super init: &rest)
		(= temp0 (Cast new:))
		(self addCast: temp0)
		(= voMyHelp
			((ToolHelpView new:)
				text: (KArray 8 (temp1 data:)) ; ArrayDup, UNINIT
				setSize:
				init: temp0
				yourself:
			)
		)
		(temp1 dispose:) ; UNINIT
		(self setSize:)
		(+= param2 2)
		(+= param3 25)
		(= temp2 (- right left))
		(= temp3 (- bottom top))
		(if (> (+ param2 temp2) gLastScreenX)
			(= param2 (- gLastScreenX temp2))
		)
		(if (> (+ param3 temp3) gLastScreenY)
			(-= param3 (+ 20 temp3))
		)
		(self setRect: param2 param3 (+ param2 temp2) (+ param3 temp2))
		(UpdatePlane self)
	)

	(method (dispose)
		(if voMyHelp
			(voMyHelp dispose:)
			(= voMyHelp 0)
		)
		(super dispose: &rest)
	)
)

