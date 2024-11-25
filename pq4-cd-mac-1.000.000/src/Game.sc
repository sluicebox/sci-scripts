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

(procedure (localproc_0 param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6) ; UNUSED
	(= temp1 (Str new: 80))
	(= temp2 (Str new: 80))
	(= temp3 (Str new: 150))
	(= temp4 (Str new: 80))
	(= temp5 (Str new: 20))
	(= temp6 (Str new: 10))
	(= temp0 1)
	(DeviceInfo diGET_DEVICE (KString 9 gCurSaveDir) (temp1 data:)) ; StrGetData
	(DeviceInfo diGET_CURRENT_DEVICE (temp2 data:))
	(if
		(and
			(DeviceInfo diIS_FLOPPY (temp2 data:))
			(or
				(DeviceInfo diPATHS_EQUAL (temp1 data:) (temp2 data:))
				(not (DeviceInfo 6 (gGame name:))) ; SaveDirMounted
			)
		)
		(Message msgGET 64994 6 0 0 1 (temp4 data:))
		(Message msgGET 64994 7 0 0 1 (temp5 data:))
		(Message msgGET 64994 8 0 0 1 (temp6 data:))
		(temp3 format: temp4 (if param1 temp5 else temp6) temp1)
		(Load rsFONT gUserFont)
		(DeviceInfo 4) ; CloseDevice
		(Message msgGET 64994 2 0 0 1 (temp4 data:))
		(Message msgGET 64994 4 0 0 1 (temp5 data:))
		(Message msgGET 64994 5 0 0 1 (temp6 data:))
		(if
			(==
				(= temp0
					(if param1
						(Print
							font: 0
							addText: temp3
							addButton: 1 temp4 0 40
							addButton: 0 temp5 30 40
							addButton: 2 temp6
							init:
						)
					else
						(Print
							font: 0
							addText: temp3
							addButton: 1 temp4 0 40
							init:
						)
					)
				)
				2
			)
			(= temp0 (GetDirectory gCurSaveDir))
		)
	)
	(temp1 dispose:)
	(temp2 dispose:)
	(temp3 dispose:)
	(temp4 dispose:)
	(temp5 dispose:)
	(temp6 dispose:)
	(return temp0)
)

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
		(for ((= node (FirstNode elements))) node ((= node nextNode))
			(= nextNode (NextNode node))
			(= aCastList ((NodeValue node) casts:))
			(for
				((= node (FirstNode (aCastList elements:))))
				node
				((= node (aCastList nextNode:)))
				
				(aCastList nextNode: (NextNode node))
				(= obj (NodeValue node))
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

(class Cue of Obj
	(properties
		cuee 0
		cuer 0
		register 0
	)

	(method (doit)
		(gCuees delete: self)
		(cuee cue: register cuer)
		(self dispose:)
	)
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
		(gCurSaveDir data: (GetSaveDir))
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

	(method (replay &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7)
		(for
			((= temp4 (FirstNode (gPlanes elements:))))
			temp4
			((= temp4 (gPlanes nextNode:)))
			
			(gPlanes nextNode: (NextNode temp4))
			(= temp1 (NodeValue temp4))
			(AddPlane temp1)
			(for
				((= temp5 (FirstNode ((temp1 casts:) elements:))))
				temp5
				((= temp5 ((temp1 casts:) nextNode:)))
				
				((temp1 casts:) nextNode: (NextNode temp5))
				(= temp2 (NodeValue temp5))
				(for
					((= temp6 (FirstNode (temp2 elements:))))
					temp6
					((= temp6 (temp2 nextNode:)))
					
					(temp2 nextNode: (NextNode temp6))
					(= temp3 (NodeValue temp6))
					(if (& (temp3 -info-:) $0010)
						(AddScreenItem temp3)
					)
				)
			)
		)
		(if gLastEvent
			(gLastEvent dispose:)
		)
		(gGame setCursor: gWaitCursor 1)
		(= temp0
			(if (not (OneOf (gCurRoom style:) -1 15 16 17 18))
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
		(gSounds eachElementDo: #pause 0)
		(= gTickOffset (- gGameTime (GetTime)))
		(while (not gQuit)
			(self doit:)
		)
	)

	(method (init)
		Motion
		Sound
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
		(GetSaveDir (gCurSaveDir data:))
		(if (not gUser)
			(= gUser User)
		)
		(gUser init:)
		((= gThePlane (Plane new:))
			priority: 2
			init: 0 10 319 199
			addCast: gCast
		)
		(gCast plane: gThePlane)
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
		(gCast doit:)
		(FrameOut)
		(if gDoMotionCue
			(= gDoMotionCue 0)
			(gCast eachElementDo: #motionCue)
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
		(if (== gNewRoomNum gCurRoomNum)
			(gUser doit:)
		)
		(gTheDoits doit:)
		(if (!= gNewRoomNum gCurRoomNum)
			(self newRoom: gNewRoomNum)
		)
		(gTimers eachElementDo: #delete)
		(GameIsRestarting 0)
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
						(else
							(Styler back:)
						)
					)
				style: (& temp6 $00ff)
				doit:
			)
		)
		(PalCycle 4) ; Off
		(gFeatures eachElementDo: #dispose release:)
		(gCast eachElementDo: #dispose)
		(gTimers eachElementDo: #delete)
		(gRegions eachElementDo: #perform DNKR release:)
		(gTheDoits release:)
		(Platform 0 1)
		(= gPrevRoomNum gCurRoomNum)
		(= gCurRoomNum newRoomNumber)
		(= gNewRoomNum newRoomNumber)
		(self startRoom: gCurRoomNum)
		(while ((= temp5 (Event new: evMOUSE)) type:)
			(temp5 dispose:)
		)
		(temp5 dispose:)
	)

	(method (startRoom roomNum)
		(if gDebugOn
			(SetDebug)
		)
		(gRegions addToFront: (= gCurRoom (ScriptID roomNum)))
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
		(RestartGame)
	)

	(method (save &tmp comment num oldCur buf1 buf2 str)
		(= comment (Str new:))
		(= buf1 (Str new:))
		(= buf2 (Str new:))
		(= str (Str new:))
		(= oldCur (self setCursor: gNormalCursor))
		(SaveGame name num (comment data:) (KString 9 gVersion)) ; UNINIT, StrGetData
		(self setCursor: oldCur (HaveMouse))
		(comment dispose:)
		(buf1 dispose:)
		(buf2 dispose:)
		(str dispose:)
	)

	(method (restore &tmp temp0 temp1 temp2 temp3 temp4 [temp5 7])
		(= temp2 (Str new:))
		(= temp3 (Str new:))
		(= temp4 (Str new:))
		(RestoreGame name temp0 gVersion) ; UNINIT
	)

	(method (setCursor form showIt theX theY hotX hotY &tmp oldCur)
		(= oldCur gTheCursor)
		(= gTheCursor form)
		(form init:)
		(cond
			((> argc 1)
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
			((and oldCur (oldCur hidden:))
				(oldCur hidden: 0)
				(gTheCursor hide:)
			)
		)
		(return oldCur)
	)

	(method (showMem &tmp buffer)
		(= buffer (Str new:))
		(buffer format: {Largest hunk: %u Bytes} (MemoryInfo 0))
		(Print addText: buffer init:)
		(buffer dispose:)
	)

	(method (pragmaFail))

	(method (notify))

	(method (setScript newScript)
		(if script
			(script dispose:)
		)
		(if newScript
			(newScript init: self &rest)
		)
	)

	(method (cue)
		(if script
			(script cue:)
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
		(if (== modNum -1)
			(= modNum gCurRoomNum)
		)
		(cond
			((Message msgSIZE modNum noun theVerb case 1)
				(gMessager say: noun theVerb case 0 0 modNum)
			)
			((Message msgSIZE modNum 0 theVerb case 1)
				(gMessager say: 0 theVerb case 0 0 modNum)
			)
			((Message msgSIZE modNum 0 theVerb 0 1)
				(gMessager say: 0 theVerb case 0 0 modNum)
			)
			(else
				(gMessager say: 0 theVerb 0 0 0 0)
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
		(if newScript
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
		picAngle 0
		vanishingX 160
		vanishingY 0
		obstacles 0
		inset 0
		purge 500
	)

	(method (doRemap)
		(gGame doRemap: 2 244 75)
		(gGame doRemap: 2 243 80)
	)

	(method (init)
		(= number gCurRoomNum)
		(= gPerspective picAngle)
		(if (not plane)
			(= plane gThePlane)
		)
	)

	(method (reflectPosn theActor theEdge)
		(switch theEdge
			(1
				(theActor y: 188)
			)
			(4
				(theActor x: (- 319 (theActor xStep:)))
			)
			(3
				(theActor y: (+ horizon (theActor yStep:)))
			)
			(2
				(theActor x: 1)
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

	(method (setInset param1 param2 param3)
		(if inset
			(inset dispose:)
		)
		(if (and argc param1)
			(param1
				init:
					(if (>= argc 2) param2 else 0)
					self
					(if (>= argc 3) param3 else 0)
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

	(method (drawPic pic theStyle setProps &tmp temp0)
		(= temp0 -1)
		(if (not plane)
			((= plane (Plane new:)) init:)
		)
		(if (> argc 1)
			(if (!= theStyle -1)
				(= temp0 theStyle)
			else
				(= temp0 style)
			)
			(if (and (> argc 2) setProps)
				(if (!= pic -1)
					(= picture (= curPic pic))
				)
				(if (!= theStyle -1)
					(= style theStyle)
				)
			)
		else
			(= temp0 style)
		)
		(if (== temp0 -1)
			(= temp0 0)
		)
		(plane drawPic: pic temp0 &rest)
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

