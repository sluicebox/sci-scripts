;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64994)
(include sci.sh)
(use Main)
(use Styler)
(use Plane)
(use Str)
(use Print)
(use Polygon)
(use Cursor)
(use Sound)
(use Save)
(use Motion)
(use User)
(use System)

(instance cast of Cast
	(properties)
)

(instance features of EventHandler
	(properties)
)

(instance theDoits of EventHandler
	(properties)
)

(instance prints of EventHandler
	(properties)
)

(instance planes of Set
	(properties)

	(method (eachElementDo action &tmp node aCastList obj)
		(for ((= node (KList 3 elements))) node ((= node nextNode)) ; FirstNode
			(= nextNode (KList 6 node)) ; NextNode
			(= aCastList ((KList 8 node) casts:)) ; NodeValue
			(for
				((= node (KList 3 (aCastList elements:)))) ; FirstNode
				node
				((= node (aCastList nextNode:)))
				
				(aCastList nextNode: (KList 6 node)) ; NextNode
				(= obj (KList 8 node)) ; NodeValue
				(obj eachElementDo: action &rest)
			)
		)
	)
)

(instance talkers of EventHandler
	(properties)
)

(class Sounds of EventHandler
	(properties)

	(method (pause tOrF)
		(self eachElementDo: #perform mayPause (if argc tOrF else 1))
	)
)

(instance mayPause of Code
	(properties)

	(method (doit theSound tOrF)
		(if (not (& (theSound flags:) $0001))
			(theSound pause: tOrF)
		)
	)
)

(instance regions of EventHandler
	(properties)
)

(instance timers of Set
	(properties)
)

(instance mouseDownHandler of EventHandler
	(properties)
)

(instance keyDownHandler of EventHandler
	(properties)
)

(instance directionHandler of EventHandler
	(properties)
)

(instance walkHandler of EventHandler
	(properties)
)

(instance extMouseHandler of EventHandler
	(properties)
)

(instance aTOC of Code ; UNUSED
	(properties)

	(method (doit thePV &tmp dX dY)
		(if (not (& (thePV signal:) $4000))
			(= dX (+ (gEgo xStep:) (/ (CelWide (gEgo view:) 2 0) 2)))
			(= dY (* (gEgo yStep:) 2))
			(gCurRoom
				addObstacle:
					((Polygon new:)
						init:
							(- (thePV brLeft:) dX)
							(+ (thePV brRight:) dX)
							(+ (thePV brRight:) dX)
							(+ (thePV y:) dY)
							(- (thePV brLeft:) dX)
							(+ (thePV y:) dY)
						yourself:
					)
			)
		)
	)
)

(instance theWaitCursor of Cursor
	(properties
		view 997
	)
)

(instance theNormalCursor of Cursor
	(properties
		view 999
	)
)

(class Game of Obj
	(properties
		script 0
		printLang 1
		_detailLevel 3
		panelObj 0
		panelSelector 0
		handsOffCode 0
		handsOnCode 0
	)

	(method (play)
		(= gGame self)
		(= gCurSaveDir (Str new:))
		(= gSysLogPath (Str new:))
		(gCurSaveDir data: (Save 2)) ; GetSaveDir
		(= gNormalCursor theNormalCursor)
		(= gWaitCursor theWaitCursor)
		(self setCursor: gWaitCursor init:)
		(while (not gQuit)
			(self doit:)
		)
	)

	(method (quitGame tOrF)
		(if (or (not argc) tOrF)
			(= gQuit 1)
		)
	)

	(method (masterVolume newVol)
		(if argc
			(DoSound sndMASTER_VOLUME newVol)
		else
			(DoSound sndMASTER_VOLUME)
		)
	)

	(method (detailLevel theLevel)
		(if argc
			(= _detailLevel theLevel)
			(gPlanes eachElementDo: #checkDetail _detailLevel)
		)
		(return _detailLevel)
	)

	(method (replay &tmp theStyle aPlane aList obj node1 node2 node3)
		(for
			((= node1 (KList 3 (gPlanes elements:)))) ; FirstNode
			node1
			((= node1 (gPlanes nextNode:)))
			
			(gPlanes nextNode: (KList 6 node1)) ; NextNode
			(= aPlane (KList 8 node1)) ; NodeValue
			(AddPlane aPlane)
			(for
				((= node2 (KList 3 ((aPlane casts:) elements:)))) ; FirstNode
				node2
				((= node2 ((aPlane casts:) nextNode:)))
				
				((aPlane casts:) nextNode: (KList 6 node2)) ; NextNode
				(= aList (KList 8 node2)) ; NodeValue
				(for
					((= node3 (KList 3 (aList elements:)))) ; FirstNode
					node3
					((= node3 (aList nextNode:)))
					
					(aList nextNode: (KList 6 node3)) ; NextNode
					(= obj (KList 8 node3)) ; NodeValue
					(if (& (obj -info-:) $0010)
						(AddScreenItem obj)
					)
				)
			)
		)
		(if gLastEvent
			(gLastEvent dispose:)
		)
		(gGame setCursor: gWaitCursor 1)
		(= theStyle
			(if (not (OneOf (gCurRoom style:) -1 16 17 18 19))
				(gCurRoom style:)
			else
				0
			)
		)
		(cond
			((and (not (gUser canControl:)) (not (gUser canInput:)))
				(gGame setCursor: gWaitCursor)
			)
			((and gTheIconBar (gTheIconBar curIcon:))
				(gGame setCursor: (gTheIconBar getCursor:))
			)
			(else
				(gGame setCursor: gNormalCursor)
			)
		)
		(SL doit:)
		(DoSound sndRESTORE)
		(Sound pause: 0)
		(= gTickOffset (- gGameTime (GetTime)))
		(while (not gQuit)
			(self doit:)
		)
	)

	(method (init)
		Motion
		Sound
		(= gLastScreenX (- gScreenWidth 1))
		(= gLastScreenY (- gScreenHeight 1))
		((= gCast cast) add:)
		((= gFeatures features) add:)
		((= gSounds Sounds) add:)
		((= gRegions regions) add:)
		((= gTimers timers) add:)
		((= gTheDoits theDoits) add:)
		((= gPrints prints) add:)
		((= gPlanes planes) add:)
		((= gTalkers talkers) add:)
		((= gMouseDownHandler mouseDownHandler) add:)
		((= gKeyDownHandler keyDownHandler) add:)
		((= gDirectionHandler directionHandler) add:)
		((= gWalkHandler walkHandler) add:)
		((= gExtMouseHandler extMouseHandler) add:)
		(Save 2 (gCurSaveDir data:)) ; GetSaveDir
		(if (not gUser)
			(= gUser User)
		)
		(gUser init:)
		((= gThePlane (Plane new:))
			priority: 2
			init: 0 0 gLastScreenX gLastScreenY
			addCast: gCast
		)
		(gCast plane: gThePlane)
		(Styler init:)
		(self setCursor: gNormalCursor 1)
	)

	(method (doit &tmp event pO pS)
		(if panelObj
			(= pO panelObj)
			(= pS panelSelector)
			(= panelObj (= panelSelector 0))
			(Eval pO pS)
		)
		(= gGameTime (+ gTickOffset (GetTime)))
		(gSounds eachElementDo: #check)
		(gTimers eachElementDo: #doit)
		(if gAutoRobot
			(gAutoRobot doit:)
		)
		(if gPanels
			(gPanels eachElementDo: #doit)
		)
		(gCast doit:)
		(FrameOut)
		(if (== gNewRoomNum gCurRoomNum)
			(gUser doit:)
		)
		(if gCuees
			(gCuees eachElementDo: #doit)
			(if (gCuees isEmpty:)
				(gCuees dispose:)
				(= gCuees 0)
			)
		)
		(if script
			(script doit:)
		)
		(gRegions eachElementDo: #doit)
		(gTheDoits doit:)
		(if (!= gNewRoomNum gCurRoomNum)
			(self newRoom: gNewRoomNum)
		)
		(gTimers eachElementDo: #delete)
		(Save 8 0) ; GameIsRestarting
	)

	(method (newRoom newRoomNumber &tmp [temp0 5] temp5 temp6)
		(if (gTalkers size:)
			(gMessager cue: 1)
		)
		(if (and gCurRoom (!= (= temp6 (gCurRoom exitStyle:)) -1))
			(Styler
				plane: (gCurRoom plane:)
				back:
					(cond
						((& temp6 $0100) 0)
						((& temp6 $0200) 7)
						(else 0)
					)
				style: (& temp6 $00ff)
				doit:
			)
			(FrameOut)
			(Styler back: -1)
		)
		(PalCycle 4) ; Off
		(RemapColors 0) ; Off
		(gFeatures eachElementDo: #dispose release:)
		(gCast eachElementDo: #dispose)
		(gTimers eachElementDo: #delete)
		(gRegions eachElementDo: #perform DNKR release:)
		(gTheDoits release:)
		(= gPrevRoomNum gCurRoomNum)
		(= gCurRoomNum newRoomNumber)
		(= gNewRoomNum newRoomNumber)
		(NewRoom gNewRoomNum)
		(self startRoom: gCurRoomNum)
		(while ((= temp5 (Event new: 3)) type:)
			(temp5 dispose:)
		)
		(temp5 dispose:)
	)

	(method (startRoom roomNum)
		(if gDebugOn
			(SetDebug)
		)
		(gRegions addToFront: (= gCurRoom (ScriptID roomNum)))
		(Purge (gCurRoom purge:))
		(gCurRoom init:)
	)

	(method (handleEvent event)
		(cond
			((event claimed:) 1)
			((and script (script handleEvent: event)) 1)
			((& (event type:) evVERB)
				(self pragmaFail:)
			)
		)
		(event claimed:)
	)

	(method (changeScore delta)
		(+= gScore delta)
		(SL doit:)
	)

	(method (restart)
		(Save 9) ; Restart
	)

	(method (save &tmp comment num oldCur buf1 buf2 str)
		(= comment (Str new:))
		(if (not (FileIO 19 (KString 9 gCurSaveDir))) ; ValidPath, StrGetData
			(= str (Str new:))
			(= buf1 (Str new:))
			(Message msgGET 64994 9 0 0 1 (buf1 data:)) ; "%s is not a valid directory."
			(str format: buf1 gCurSaveDir)
			(Print
				font: 999
				fore: 0
				back: (Palette 3 127 127 127) ; PalMatch
				addText: str
				addButtonBM: -1 0 0 1 {OK} 0 30
				init:
			)
			(GetDirectory gCurSaveDir)
			(str dispose:)
			(buf1 dispose:)
		)
		(Load rsFONT gSmallFont)
		(ScriptID 64990)
		(= oldCur (self setCursor: gNormalCursor))
		(Sound pause: 1)
		(switch (= num (Save doit: comment))
			(-1)
			(-2
				(= buf1 (Str new:))
				(= buf2 (Str new:))
				(Message msgGET 64994 11 0 0 1 (buf1 data:)) ; "An error occurred while attempting to read the save game catalog file. The saved games in this directory are no longer usable."
				(Message msgGET 64994 2 0 0 1 (buf2 data:)) ; "OK"
				(if
					(Print
						font: 999
						fore: 0
						back: (Palette 3 127 127 127) ; PalMatch
						addText: buf1
						addButtonBM: 64990 0 0 0 buf2 0 40
						addButtonBM: 64990 2 0 1 {Change Dir} 55 40
						init:
					)
					(GetDirectory gCurSaveDir)
				)
				(buf1 dispose:)
				(buf2 dispose:)
			)
			(else
				(if gNumCD
					(self getDisc: gNumCD)
				)
				(= oldCur (self setCursor: gWaitCursor 1))
				(if (not (Save 0 name num (comment data:) (KString 9 gVersion))) ; SaveGame, StrGetData
					(= buf1 (Str new:))
					(= buf2 (Str new:))
					(Message msgGET 64994 10 0 0 1 (buf1 data:)) ; "An error occurred while attempting to save your game. Try saving to another directory or saving over an existing saved game."
					(Message msgGET 64994 2 0 0 1 (buf2 data:)) ; "OK"
					(Print
						font: 999
						fore: 0
						back: (Palette 3 127 127 127) ; PalMatch
						addText: buf1
						addButtonBM: -1 0 0 1 buf2 0 40
						init:
					)
					(buf1 dispose:)
					(buf2 dispose:)
				)
				(self setCursor: oldCur (HaveMouse))
			)
		)
		(Sound pause: 0)
		(comment dispose:)
	)

	(method (restore &tmp num oldCur buf1 buf2 str aPlane aList obj bit node1 node2 node3)
		(= buf1 (Str new:))
		(= buf2 (Str new:))
		(= str (Str new:))
		(if (not (FileIO 19 (KString 9 gCurSaveDir))) ; ValidPath, StrGetData
			(Message msgGET 64994 9 0 0 1 (buf1 data:)) ; "%s is not a valid directory."
			(str format: buf1 gCurSaveDir)
			(Print
				font: 999
				fore: 0
				back: (Palette 3 127 127 127) ; PalMatch
				addText: str
				addButtonBM: -1 0 0 1 {OK} 0 30
				init:
			)
			(GetDirectory gCurSaveDir)
		)
		(Load rsFONT gSmallFont)
		(ScriptID 64990)
		(= oldCur (self setCursor: gNormalCursor))
		(Sound pause: 1)
		(if (!= (= num (Restore doit: &rest)) -1)
			(for
				((= node1 (KList 3 (gPlanes elements:)))) ; FirstNode
				node1
				((= node1 (gPlanes nextNode:)))
				
				(gPlanes nextNode: (KList 6 node1)) ; NextNode
				(= aPlane (KList 8 node1)) ; NodeValue
				(for
					((= node2 (KList 3 ((aPlane casts:) elements:)))) ; FirstNode
					node2
					((= node2 ((aPlane casts:) nextNode:)))
					
					((aPlane casts:) nextNode: (KList 6 node2)) ; NextNode
					(= aList (KList 8 node2)) ; NodeValue
					(for
						((= node3 (KList 3 (aList elements:)))) ; FirstNode
						node3
						((= node3 (aList nextNode:)))
						
						(aList nextNode: (KList 6 node3)) ; NextNode
						(= obj (KList 8 node3)) ; NodeValue
						(if (= bit (& (obj -info-:) $0010))
							(DeleteScreenItem obj)
							(obj -info-: (| (obj -info-:) bit))
						)
					)
				)
				(DeletePlane aPlane)
			)
			(self setCursor: gWaitCursor 1)
			(if (Save 3 name num (KString 9 gVersion)) ; CheckSaveGame, StrGetData
				(self getDisc: (CD 1)) ; GetSaveCD
				(Save 1 name num gVersion) ; RestoreGame
			else
				(for
					((= node1 (KList 3 (gPlanes elements:)))) ; FirstNode
					node1
					((= node1 (gPlanes nextNode:)))
					
					(gPlanes nextNode: (KList 6 node1)) ; NextNode
					(= aPlane (KList 8 node1)) ; NodeValue
					(AddPlane aPlane)
					(for
						((= node2 (KList 3 ((aPlane casts:) elements:)))) ; FirstNode
						node2
						((= node2 ((aPlane casts:) nextNode:)))
						
						((aPlane casts:) nextNode: (KList 6 node2)) ; NextNode
						(= aList (KList 8 node2)) ; NodeValue
						(for
							((= node3 (KList 3 (aList elements:)))) ; FirstNode
							node3
							((= node3 (aList nextNode:)))
							
							(aList nextNode: (KList 6 node3)) ; NextNode
							(= obj (KList 8 node3)) ; NodeValue
							(if (& (obj -info-:) $0010)
								(AddScreenItem obj)
							)
						)
					)
				)
				(Message msgGET 64994 3 0 0 1 (buf1 data:)) ; "That game was saved under a different game or interpreter version. It cannot be restored."
				(Message msgGET 64994 2 0 0 1 (buf2 data:)) ; "OK"
				(Print
					font: 999
					fore: 0
					back: (Palette 3 127 127 127) ; PalMatch
					addText: (buf1 data:)
					addButtonBM: -1 0 0 1 (buf2 data:) 0 40
					init:
				)
				(self setCursor: oldCur (HaveMouse))
			)
		)
		(Sound pause: 0)
		(buf1 dispose:)
		(buf2 dispose:)
		(str dispose:)
	)

	(method (setCursor form showIt theX theY hotX hotY &tmp oldCur)
		(= oldCur gTheCursor)
		(= gTheCursor form)
		(form init:)
		(if (> argc 1)
			(if showIt
				(gTheCursor show:)
			else
				(gTheCursor hide:)
			)
			(if (> argc 2)
				(SetCursor theX theY)
				(if (> argc 4)
					(SetCursor form 0 0 hotX hotY)
				)
			)
		)
		(return oldCur)
	)

	(method (showMem &tmp buffer)
		(= buffer (Str new:))
		(buffer format: {Free Memory: %u kBytes} (MemoryInfo 0))
		(Print addText: buffer init:)
		(buffer dispose:)
	)

	(method (pragmaFail))

	(method (notify))

	(method (setScript newScript)
		(if script
			(script dispose:)
		)
		(if (and argc newScript)
			(newScript init: self &rest)
		)
	)

	(method (cue)
		(if script
			(script cue: &rest)
		)
	)

	(method (handsOff)
		(if handsOffCode
			(handsOffCode doit: &rest)
		else
			(User canControl: 0 canInput: 0)
			(if gEgo
				(gEgo setMotion: 0)
			)
		)
	)

	(method (handsOn)
		(if handsOnCode
			(handsOnCode doit: &rest)
		else
			(User canControl: 1 canInput: 1)
		)
	)

	(method (getDisc n &tmp ret)
		(= gNumCD n)
		(while (and (!= -1 (= ret (CD 0 n))) (!= ret n)) ; Check
			(Printf {Please insert CD #%d then hit any key.} n)
		)
		(return ret)
	)
)

(class Rgn of Obj
	(properties
		script 0
		number 0
		modNum -1
		noun 0
		case 0
		timer 0
		keep 0
		initialized 0
	)

	(method (init)
		(if (not initialized)
			(= initialized 1)
			(if (not (gRegions contains: self))
				(gRegions addToEnd: self)
			)
			(super init:)
		)
	)

	(method (doit)
		(if script
			(script doit:)
		)
	)

	(method (handleEvent event)
		(cond
			((event claimed:) 1)
			((& (event type:) $0010) 0) ; direction
			(
				(not
					(and
						script
						(or (script handleEvent: event) 1)
						(event claimed:)
					)
				)
				(event claimed: (self doVerb: (event message:)))
			)
		)
		(event claimed:)
	)

	(method (doVerb theVerb &tmp who)
		(if (and (== modNum -1) (== (= modNum (gCurRoom modNum:)) -1))
			(= modNum gCurRoomNum)
		)
		(return
			(if (Message msgGET modNum noun theVerb case 1)
				(gMessager say: noun theVerb case 0 0 modNum)
				1
			else
				0
			)
		)
	)

	(method (dispose)
		(gRegions delete: self)
		(if script
			(script dispose:)
		)
		(if timer
			(timer dispose: delete:)
		)
		(gSounds eachElementDo: #clean self)
		(DisposeScript number)
	)

	(method (setScript newScript)
		(if script
			(script dispose:)
		)
		(if (and argc newScript)
			(newScript init: self &rest)
		)
	)

	(method (cue)
		(if script
			(script cue:)
		)
	)

	(method (newRoom))

	(method (notify))
)

(class Room of Rgn
	(properties
		picture -1
		plane 0
		style -1
		exitStyle -1
		horizon 0
		controls 0
		north 0
		east 0
		south 0
		west 0
		curPic 0
		purge 500
		picAngle 0
		vanishingX 160
		vanishingY 0
		obstacles 0
		inset 0
		edgeN 40
		edgeE 319
		edgeW 0
		edgeS 189
	)

	(method (init)
		(= number gCurRoomNum)
		(= gPerspective picAngle)
		(if (not plane)
			(= plane gThePlane)
		)
		(self drawPic: picture)
		(self reflectPosn: (gUser alterEgo:) ((gUser alterEgo:) edgeHit:))
		((gUser alterEgo:) edgeHit: EDGE_NONE)
	)

	(method (reflectPosn theActor theEdge)
		(switch theEdge
			(1
				(theActor y: (- (gCurRoom edgeS:) 1))
			)
			(4
				(theActor x: (- (gCurRoom edgeE:) (theActor xStep:)))
			)
			(3
				(theActor y: (+ horizon (theActor yStep:)))
			)
			(2
				(theActor x: (+ (gCurRoom edgeW:) 1))
			)
		)
	)

	(method (doit &tmp nRoom)
		(if script
			(script doit:)
		)
		(if (= nRoom (self edgeToRoom: ((gUser alterEgo:) edgeHit:)))
			(self newRoom: nRoom)
		)
	)

	(method (edgeToRoom edge)
		(return
			(switch edge
				(1 north)
				(2 east)
				(3 south)
				(4 west)
			)
		)
	)

	(method (roomToEdge rm)
		(return
			(switch rm
				(north 1)
				(south 3)
				(east 2)
				(west 4)
			)
		)
	)

	(method (dispose)
		(if obstacles
			(obstacles dispose:)
		)
		(if (!= plane gThePlane)
			(plane dispose:)
			(= plane 0)
		)
		(super dispose:)
	)

	(method (handleEvent event)
		(or (and inset (inset handleEvent: event)) (super handleEvent: event))
		(event claimed:)
	)

	(method (setInset theInset who reg delayDraw)
		(if inset
			(inset dispose:)
			(= inset 0)
		)
		(if (and argc theInset)
			(theInset
				init:
					(if (>= argc 2) who else 0)
					self
					(if (>= argc 3) reg else 0)
					(if (>= argc 4) delayDraw else 0)
			)
		)
	)

	(method (setRegions region &tmp i n regID)
		(for ((= i 0)) (< i argc) ((++ i))
			(= n [region i])
			(= regID (ScriptID n))
			(regID number: n)
			(gRegions add: regID)
			(if (not (regID initialized:))
				(regID init:)
			)
		)
	)

	(method (addObstacle obstacle)
		(if (not obstacles)
			(= obstacles (List new:))
		)
		(obstacles add: obstacle &rest)
	)

	(method (newRoom newRoomNumber)
		(gRegions delete: self eachElementDo: #newRoom newRoomNumber addToFront: self)
		(= gNewRoomNum newRoomNumber)
		(super newRoom: newRoomNumber)
	)

	(method (drawPic pic theStyle setProps)
		(if (not plane)
			((= plane (Plane new:)) init:)
		)
		(if (and (> argc 2) setProps)
			(if (!= pic -1)
				(= picture (= curPic pic))
			)
			(if (!= theStyle -1)
				(= style theStyle)
			)
		)
		(plane
			drawPic:
				pic
				(cond
					((== style -1) 0)
					((> argc 1) theStyle)
					(else style)
				)
		)
	)

	(method (overlay))
)

(class SL of Obj
	(properties
		state 0
		code 0
	)

	(method (doit &tmp theLine)
		(if code
			(= theLine (Str newWith: 150 {}))
			(code doit: theLine)
			(theLine dispose:)
		)
	)

	(method (enable)
		(= state 1)
		(self doit:)
	)

	(method (disable)
		(= state 0)
		(self doit:)
	)
)

(instance DNKR of Code
	(properties)

	(method (doit param1)
		(if (not (param1 keep:))
			(param1 dispose:)
		)
	)
)

