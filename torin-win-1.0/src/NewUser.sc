;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64892)
(include sci.sh)
(use Main)
(use TimePauser)
(use DText)
(use Plane)
(use Str)
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

	(method (doit)
		(FrameOut)
		(if (!= gNewRoomNum gCurRoomNum)
			(self newRoom: gNewRoomNum)
		)
		(= gGameTime (+ gTickOffset (GetTime)))
		(gSounds eachElementDo: #check)
		(gTimers eachElementDo: #doit)
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
		(gTimers eachElementDo: #delete)
		(Save 8 0) ; GameIsRestarting
	)
)

(class NewHandlerList of Set
	(properties)

	(method (handleEvent event bLocalize bCursor &tmp node oTemp bDoCursor bDoLocalize)
		(if (> argc 1)
			(= bDoLocalize bLocalize)
		else
			(= bDoLocalize 0)
		)
		(if (> argc 2)
			(= bDoCursor bCursor)
		else
			(= bDoCursor 0)
		)
		(if (not bDoLocalize)
			(event globalize:)
		)
		(for
			((= node (KList 3 elements))) ; FirstNode
			(and node (not (event claimed:)))
			((= node nextNode))
			
			(= nextNode (KList 6 node)) ; NextNode
			(= oTemp (KList 8 node)) ; NodeValue
			(if bDoLocalize
				(if (oTemp respondsTo: #plane)
					(if ((oTemp plane:) isEnabled:)
						(event localize: (oTemp plane:))
					else
						(continue)
					)
				else
					(event globalize:)
				)
			)
			(if
				(and
					bDoCursor
					(oTemp respondsTo: #onMe)
					(oTemp respondsTo: #noun)
					(oTemp onMe: event)
				)
				(gOEventHandler doToolHelp: oTemp event)
			)
			(if (oTemp handleEvent: event)
				(if bDoCursor
					(gOEventHandler changeCursor: oTemp)
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

	(method (registerHandsOffActive oFeature)
		(if (not oHandsOffList)
			(= oHandsOffList (NewHandlerList new:))
		)
		(oHandsOffList add: oFeature)
	)

	(method (unregisterHandsOffActive oFeature)
		(if oHandsOffList
			(oHandsOffList delete: oFeature)
		)
	)

	(method (registerEventHog oFeature)
		(if (not oEventHogList)
			(= oEventHogList (NewHandlerList new:))
		)
		(oEventHogList addToFront: oFeature)
	)

	(method (unregisterEventHog oFeature)
		(if oEventHogList
			(oEventHogList delete: oFeature)
		)
	)

	(method (killAllEventHogs &tmp oHog oPrevHog)
		(while (and oEventHogList (oEventHogList size:))
			(if (== (= oHog (KList 8 (oEventHogList first:))) oPrevHog) ; NodeValue, UNINIT
				(return)
			)
			(if (oHog respondsTo: #stopHogging)
				(oHog stopHogging:)
			else
				(return)
			)
			(= oPrevHog oHog)
		)
	)

	(method (registerGlobalHandler oFeature)
		(if (not oGlobalHandlers)
			(= oGlobalHandlers (NewHandlerList new:))
		)
		(oGlobalHandlers addToFront: oFeature)
	)

	(method (unregisterGlobalHandler oFeature)
		(if oGlobalHandlers
			(oGlobalHandlers delete: oFeature)
		)
	)

	(method (registerKeyHandler oFeature)
		(if (not oKeyHandlers)
			(= oKeyHandlers (NewHandlerList new:))
		)
		(oKeyHandlers addToFront: oFeature)
	)

	(method (unregisterKeyHandler oFeature)
		(if oKeyHandlers
			(oKeyHandlers delete: oFeature)
		)
	)

	(method (registerDefaultHandler oFeature)
		(if (not oDefaultHandlers)
			(= oDefaultHandlers (NewHandlerList new:))
		)
		(oDefaultHandlers addToFront: oFeature)
	)

	(method (unregisterDefaultHandler oFeature)
		(if oDefaultHandlers
			(oDefaultHandlers delete: oFeature)
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

	(method (handleEvent event &tmp curPlaneNode oPlane oCastList oTemp oEventHog)
		(= gMouseX (event x:))
		(= gMouseY (event y:))
		(if (and (not (gPrints isEmpty:)) (not (gPrints allTrue: 434 2)))
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
			(if (= oTemp (gCast firstTrue: #onMe event))
				(self doToolHelp: oTemp event)
			)
			(if (= oTemp (gFeatures firstTrue: #onMe event))
				(self doToolHelp: oTemp event)
			)
			(self doToolHelp: 0 event)
			(if (= oTemp (gCast firstTrue: #handleEvent event))
				(self changeCursor: oTemp)
				(return 1)
			)
			(if (= oTemp (gFeatures firstTrue: #handleEvent event))
				(self changeCursor: oTemp)
				(return 1)
			)
			(self changeCursor: 0)
			(return 0)
		)
		(for
			((= curPlaneNode (gPlanes first:)))
			curPlaneNode
			((= curPlaneNode (gPlanes next: curPlaneNode)))
			
			(= oPlane (KList 8 curPlaneNode)) ; NodeValue
			(if (self handlePlaneEvent: oPlane event)
				(return 1)
			)
		)
		(self changeCursor: 0)
		(if (and oDefaultHandlers (oDefaultHandlers handleEvent: event 0 0))
			(return 1)
		)
		(return 0)
	)

	(method (handlePlaneEvent oPlane oEvent &tmp oTemp oCast oCastList node nodeCast oListTmp)
		(oEvent globalize:)
		(if (not (oPlane onMe: oEvent))
			(return 0)
		)
		(if (or (== (oPlane priority:) -1) (== (oPlane priority:) 510))
			(return 0)
		)
		(oEvent localize: oPlane)
		(= oCastList (oPlane casts:))
		(if oUnderMouseList
			(oUnderMouseList release:)
			(oUnderMouseList dispose:)
			(= oUnderMouseList 0)
		)
		(for ((= nodeCast (oCastList first:))) nodeCast ((= nodeCast (oCastList next: nodeCast)))
			(= oCast (KList 8 nodeCast)) ; NodeValue
			(for
				((= node (oCast first:)))
				node
				((= node (oCast next: node)))
				
				(= oTemp (KList 8 node)) ; NodeValue
				(if (and (oTemp onMe: oEvent) bSortedFeatures)
					(self addUnderMouse: oTemp)
				else
					(self doToolHelp: oTemp oEvent)
					(if (oTemp handleEvent: oEvent)
						(self changeCursor: oTemp)
						(return 1)
					)
				)
			)
		)
		(= oListTmp (oPlane oMyFeatures:))
		(for ((= node (oListTmp first:))) node ((= node (oListTmp next: node)))
			(= oTemp (KList 8 node)) ; NodeValue
			(if (and (oTemp onMe: oEvent) bSortedFeatures)
				(self addUnderMouse: oTemp)
			else
				(self doToolHelp: oTemp oEvent)
				(if (oTemp handleEvent: oEvent)
					(self changeCursor: oTemp)
					(return 1)
				)
			)
		)
		(if (and bSortedFeatures oUnderMouseList)
			(for
				((= node (oUnderMouseList first:)))
				node
				((= node (oUnderMouseList next: node)))
				
				(= oTemp (KList 8 node)) ; NodeValue
				(self doToolHelp: oTemp oEvent)
				(if (oTemp handleEvent: oEvent)
					(self changeCursor: oTemp)
					(return 1)
				)
			)
		)
		(return 0)
	)

	(method (addUnderMouse oFeature &tmp node oLast oTemp)
		(if (not oUnderMouseList)
			(= oUnderMouseList (Set new:))
		)
		(= node (oUnderMouseList first:))
		(= oLast 0)
		(while node
			(= oTemp (KList 8 node)) ; NodeValue
			(if (> (oFeature myPriority:) (oTemp myPriority:))
				(break)
			)
			(= oLast oTemp)
			(= node (oUnderMouseList next: node))
		)
		(if oLast
			(oUnderMouseList addAfter: oLast oFeature)
		else
			(oUnderMouseList addToFront: oFeature)
		)
	)

	(method (changeCursor oClaimer &tmp oCursor vCursor)
		(if oClaimer
			(if (and (= oCursor (oClaimer forceCursor:)) (!= oCursor -1))
				(if (!= gTheCursor oCursor)
					(gGame setCursor: oCursor)
				)
			else
				(if (>= global101 (global100 size:))
					(= vCursor (global100 at: 0))
				else
					(= vCursor (global100 at: global101))
				)
				(if (!= gTheCursor gNormalCursor)
					(gGame setCursor: gNormalCursor)
				)
				(if (!= (gTheCursor view:) vCursor)
					(gTheCursor setView: vCursor)
				)
				(cond
					((== oCursor -1)
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
				(= vCursor (global100 at: 0))
			else
				(= vCursor (global100 at: global101))
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
			(if (!= (gTheCursor view:) vCursor)
				(gTheCursor setView: vCursor)
			)
			(if (gTheCursor cel:)
				(gTheCursor setCel: 0)
			)
		)
	)

	(method (doToolHelp oFeature oEvent &tmp [temp0 3] temp3 temp4)
		(if (or (not global111) (not (gUser canControl:)))
			(self killToolHelp:)
			(return)
		)
		(if (and oEvent (== (oEvent type:) 1))
			(self killToolHelp:)
			(return)
		)
		(= temp3 (Clone oEvent))
		(if (and oCurHelpItem oEvent)
			(temp3 localize: (oCurHelpItem plane:))
			(if (oCurHelpItem onMe: temp3)
				(temp3 dispose:)
				(return)
			)
		)
		(if oCurHelpItem
			(self killToolHelp:)
			(temp3 dispose:)
			(return)
		)
		(if
			(or
				(not oFeature)
				(not oEvent)
				(not gCurRoom)
				(== (oEvent plane:) (gCurRoom plane:))
			)
			(temp3 dispose:)
			(return)
		)
		(temp3 globalize:)
		(= temp4 (oFeature noun:))
		(if (and (not oCurHelpItem) temp4 (Message msgGET 5 temp4 6 0 1))
			(if
				(or
					(not bTimerStarted)
					(!= (temp3 x:) nLastCursX)
					(!= (temp3 y:) nLastCursY)
				)
				(= bTimerStarted 1)
				(= nToolHelpTime (+ gGameTime global112))
				(= nLastCursX (temp3 x:))
				(= nLastCursY (temp3 y:))
			)
			(if (>= gGameTime nToolHelpTime)
				(= bTimerStarted 0)
				(= oCurToolHelp
					((ToolHelpPlane new:)
						init: temp4 (temp3 x:) (temp3 y:)
						yourself:
					)
				)
				(= oCurHelpItem oFeature)
			)
		)
		(temp3 dispose:)
	)

	(method (killToolHelp)
		(if oCurHelpItem
			(oCurToolHelp dispose:)
			(= bTimerStarted (= oCurHelpItem (= oCurToolHelp 0)))
		)
	)

	(method (notifyDispose foObject)
		(if (== foObject oCurHelpItem)
			(self killToolHelp:)
		)
	)
)

(class ToolHelpView of DText
	(properties
		fore 234
		back 64
		skip 255
		font 0
		borderColor 234
	)
)

(class ToolHelpPlane of Plane
	(properties
		picture -2
		priority 510
		voMyHelp 0
	)

	(method (init nNoun nX nY &tmp oCast oStr nWidth nHeight)
		(super init: &rest)
		(= oCast (Cast new:))
		(self addCast: oCast)
		(= oStr (Str newWith: 400 {}))
		(Message msgGET 5 nNoun 6 0 1 (oStr data:))
		(= voMyHelp
			((ToolHelpView new:)
				text: (KString 8 (oStr data:)) ; StrDup
				setSize:
				init: oCast
				yourself:
			)
		)
		(oStr dispose:)
		(self setSize:)
		(+= nX 2)
		(+= nY 25)
		(= nWidth (- right left))
		(= nHeight (- bottom top))
		(if (> (+ nX nWidth) gLastScreenX)
			(= nX (- gLastScreenX nWidth))
		)
		(if (> (+ nY nHeight) gLastScreenY)
			(-= nY (+ 20 nHeight))
		)
		(self setRect: nX nY (+ nX nWidth) (+ nY nWidth))
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

