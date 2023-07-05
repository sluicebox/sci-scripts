;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 994)
(include sci.sh)
(use Main)
(use Print)
(use Polygon)
(use Sound)
(use Save)
(use Motion)
(use Inventory)
(use User)
(use System)

(procedure (PromptForDiskChange saveDisk &tmp ret [saveDevice 40] [curDevice 40] str [buf1 40] [buf2 10] [buf3 5])
	(= str (Memory memALLOC_CRIT 150))
	(= ret 1)
	(DeviceInfo diGET_DEVICE gCurSaveDir @saveDevice)
	(DeviceInfo diGET_CURRENT_DEVICE @curDevice)
	(if
		(and
			(DeviceInfo diIS_FLOPPY @curDevice)
			(or
				(DeviceInfo diPATHS_EQUAL @saveDevice @curDevice)
				(not (DeviceInfo 6 (gGame name:))) ; SaveDirMounted
			)
		)
		(Message msgGET 994 6 0 0 1 @buf1) ; "Insert the %s disk in drive %s."
		(Message msgGET 994 7 0 0 1 @buf2) ; "SAVE GAME"
		(Message msgGET 994 8 0 0 1 @buf3) ; "GAME"
		(Format str @buf1 (if saveDisk @buf2 else @buf3) @saveDevice)
		(Load rsFONT gUserFont)
		(DeviceInfo 4) ; CloseDevice
		(Message msgGET 994 2 0 0 1 @buf1) ; "OK"
		(Message msgGET 994 4 0 0 1 @buf2) ; "Cancel"
		(Message msgGET 994 5 0 0 1 @buf3) ; "Change Directory"
		(if
			(==
				(= ret
					(if saveDisk
						(Print
							font: 0
							addText: str
							addButton: 1 @buf1 0 40
							addButton: 0 @buf2 30 40
							addButton: 2 @buf3
							init:
						)
					else
						(Print
							font: 0
							addText: str
							addButton: 1 @buf1 0 40
							init:
						)
					)
				)
				2
			)
			(= ret (GetDirectory gCurSaveDir))
		)
	)
	(Memory memFREE str)
	(return ret)
)

(instance cast of EventHandler
	(properties)
)

(instance features of EventHandler
	(properties)
)

(instance theDoits of EventHandler
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

(instance addToPics of EventHandler
	(properties)

	(method (doit)
		(self eachElementDo: #perform aTOC)
		(AddToPic elements)
	)
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

(class Cue of Obj
	(properties
		cuee 0
		cuer 0
		register 0
	)

	(method (doit)
		(gSet delete: self)
		(if (gSet isEmpty:)
			(gSet dispose:)
			(= gSet 0)
		)
		(cuee cue: register cuer)
		(self dispose:)
	)
)

(instance aTOC of Code
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
							(- (CoordPri 1 (CoordPri (thePV y:))) dY)
							(+ (thePV brRight:) dX)
							(- (CoordPri 1 (CoordPri (thePV y:))) dY)
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
		(= gCurSaveDir (GetSaveDir))
		(self setCursor: gWaitCursor 1 init:)
		(self setCursor: gNormalCursor 1)
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
			(gCast eachElementDo: #checkDetail)
		)
		(return _detailLevel)
	)

	(method (replay &tmp theStyle)
		(if gLastEvent
			(gLastEvent dispose:)
		)
		(if gModelessDialog
			(gModelessDialog dispose:)
		)
		(gCast eachElementDo: #perform RU)
		(gGame setCursor: gWaitCursor 1)
		(= theStyle
			(if (not (OneOf (gCurRoom style:) -1 11 12 13 14))
				(gCurRoom style:)
			else
				100
			)
		)
		(DrawPic (gCurRoom curPic:) theStyle 1)
		(if (!= gOverlays -1)
			(DrawPic gOverlays 100 0)
		)
		(gAddToPics doit:)
		(cond
			((and (not (gUser canControl:)) (not (gUser canInput:)))
				(gGame setCursor: gWaitCursor)
			)
			((and gTheIconBar (gTheIconBar curIcon:))
				(gGame setCursor: ((gTheIconBar curIcon:) cursor:))
			)
			(else
				(gGame setCursor: gNormalCursor)
			)
		)
		(SL doit:)
		(DoSound sndRESTORE)
		(gSounds pause: 0)
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
		((= gAddToPics addToPics) add:)
		((= gTimers timers) add:)
		((= gTheDoits theDoits) add:)
		((= gMouseDownHandler mouseDownHandler) add:)
		((= gKeyDownHandler keyDownHandler) add:)
		((= gDirectionHandler directionHandler) add:)
		((= gWalkHandler walkHandler) add:)
		(= gFastCast 0)
		(= gCurSaveDir (GetSaveDir))
		(Inv init:)
		(if (not gUser)
			(= gUser User)
		)
		(gUser init:)
	)

	(method (doit &tmp event pO pS)
		(if panelObj
			(= pO panelObj)
			(= pS panelSelector)
			(= panelObj (= panelSelector 0))
			(Eval pO pS)
		)
		(= gGameTime (+ gTickOffset (GetTime)))
		(if gFastCast
			(while gFastCast
				(gFastCast eachElementDo: #doit)
				(if (and ((= event (Event new:)) type:) gFastCast)
					(gFastCast firstTrue: #handleEvent event)
				)
				(event dispose:)
				(= gGameTime (+ gTickOffset (GetTime)))
				(gSounds eachElementDo: #check)
			)
		)
		(if gPrints
			(gPrints eachElementDo: #doit)
			(if (not gModelessDialog)
				(if (and ((= event (Event new:)) type:) gPrints)
					(gPrints firstTrue: #handleEvent event)
				)
				(event dispose:)
				(= gGameTime (+ gTickOffset (GetTime)))
				(return)
			)
		)
		(gSounds eachElementDo: #check)
		(gTimers eachElementDo: #doit)
		(if (and gModelessDialog (gModelessDialog check:))
			(gModelessDialog dispose:)
		)
		(Animate (gCast elements:) 1)
		(if gDoMotionCue
			(= gDoMotionCue 0)
			(gCast eachElementDo: #motionCue)
		)
		(if gSet
			(gSet eachElementDo: #doit)
		)
		(if script
			(script doit:)
		)
		(gRegions eachElementDo: #doit)
		(if gFastCast
			(return)
		)
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

	(method (newRoom newRoomNumber &tmp [temp0 5] temp5)
		(gAddToPics eachElementDo: #dispose eachElementDo: #delete release:)
		(gFeatures eachElementDo: #perform fDC release:)
		(gCast eachElementDo: #dispose eachElementDo: #delete)
		(gTimers eachElementDo: #delete)
		(gRegions eachElementDo: #perform DNKR release:)
		(gTheDoits release:)
		(Animate 0)
		(= gPrevRoomNum gCurRoomNum)
		(= gCurRoomNum newRoomNumber)
		(= gNewRoomNum newRoomNumber)
		(FlushResources newRoomNumber)
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
		(if gModelessDialog
			(gModelessDialog dispose:)
		)
		(RestartGame)
	)

	(method (save &tmp [comment 20] num oldCur [buf1 100] [buf2 5] [str 100])
		(if (not (ValidPath gCurSaveDir))
			(Message msgGET 994 9 0 0 1 @buf1) ; "%s is not a valid directory."
			(Format @str @buf1 gCurSaveDir)
			(Print font: 0 addText: @str init:)
			(GetDirectory gCurSaveDir)
		)
		(Load rsFONT gSmallFont)
		(ScriptID 990)
		(= oldCur (self setCursor: gNormalCursor))
		(gSounds pause: 1)
		(if (PromptForDiskChange 1)
			(if gModelessDialog
				(gModelessDialog dispose:)
			)
			(if (!= (= num (Save doit: @comment)) -1)
				(= oldCur (self setCursor: gWaitCursor 1))
				(if (not (SaveGame name num @comment gVersion))
					(Message msgGET 994 1 0 0 1 @buf1) ; "Your save game disk is full. You must either use another disk or save over an existing saved game."
					(Message msgGET 994 2 0 0 1 @buf2) ; "OK"
					(Print
						font: 0
						addText: @buf1
						addButton: 1 @buf2 0 40
						init:
					)
				)
				(self setCursor: oldCur (HaveMouse))
			)
			(PromptForDiskChange 0)
		)
		(gSounds pause: 0)
	)

	(method (restore &tmp [comment 20] num oldCur [buf1 100] [buf2 5] [str 100])
		(if (not (ValidPath gCurSaveDir))
			(Message msgGET 994 9 0 0 1 @buf1) ; "%s is not a valid directory."
			(Format @str @buf1 gCurSaveDir)
			(Print font: 0 addText: @str init:)
			(GetDirectory gCurSaveDir)
		)
		(Load rsFONT gSmallFont)
		(ScriptID 990)
		(= oldCur (self setCursor: gNormalCursor))
		(gSounds pause: 1)
		(if (PromptForDiskChange 1)
			(if gModelessDialog
				(gModelessDialog dispose:)
			)
			(if (!= (= num (Restore doit: &rest)) -1)
				(self setCursor: gWaitCursor 1)
				(if (CheckSaveGame name num gVersion)
					(RestoreGame name num gVersion)
				else
					(Message msgGET 994 3 0 0 1 @buf1) ; "That game was saved under a different interpreter. It cannot be restored."
					(Message msgGET 994 2 0 0 1 @buf2) ; "OK"
					(Print
						font: 0
						addText: @buf1
						addButton: 1 @buf2 0 40
						init:
					)
					(self setCursor: oldCur (HaveMouse))
				)
			)
			(PromptForDiskChange 0)
		)
		(gSounds pause: 0)
	)

	(method (setCursor form showIt theX theY hotX hotY &tmp oldCur)
		(= oldCur gTheCursor)
		(if (IsObject form)
			(= gTheCursor form)
			(form init:)
		else
			(SetCursor form 0 0)
		)
		(if (> argc 1)
			(SetCursor showIt)
			(if (> argc 2)
				(SetCursor theX theY)
				(if (> argc 4)
					(SetCursor form 0 0 hotX hotY)
				)
			)
		)
		(return oldCur)
	)

	(method (showMem &tmp [buffer 100])
		(Format
			@buffer
			{Free Heap: %u Bytes\nLargest ptr: %u Bytes\nFreeHunk: %u KBytes\nLargest hunk: %u Bytes}
			(MemoryInfo 1) ; FreeHeap
			(MemoryInfo 0) ; LargestPtr
			(>> (MemoryInfo miFREEHUNK) $0006)
			(MemoryInfo miLARGESTHUNK)
		)
		(Print addText: @buffer init:)
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
			(if (IsObject gEgo)
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
			((& (event type:) $0040) 0) ; direction
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
		(return
			(if (Message msgGET modNum noun theVerb 0 1)
				(gMessager say: noun theVerb 0 0 0 modNum)
				1
			else
				0
			)
		)
	)

	(method (dispose)
		(gRegions delete: self)
		(if (IsObject script)
			(script dispose:)
		)
		(if (IsObject timer)
			(timer dispose: delete:)
		)
		(gSounds eachElementDo: #clean self)
		(DisposeScript number)
	)

	(method (setScript newScript)
		(if (IsObject script)
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

(class Rm of Rgn
	(properties
		picture 0
		style -1
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
	)

	(method (init)
		(= number gCurRoomNum)
		(= gPerspective picAngle)
		(if picture
			(self drawPic: picture)
		)
		(self reflectPosn: (gUser alterEgo:) ((gUser alterEgo:) edgeHit:))
		((gUser alterEgo:) edgeHit: EDGE_NONE)
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
		(super dispose:)
	)

	(method (handleEvent event)
		(or (and inset (inset handleEvent: event)) (super handleEvent: event))
		(event claimed:)
	)

	(method (setInset theInset who reg)
		(if inset
			(inset dispose:)
		)
		(if (and argc theInset)
			(theInset
				init:
					(if (>= argc 2) who else 0)
					self
					(if (>= argc 3) reg else 0)
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
		(if (not (IsObject obstacles))
			(= obstacles (List new:))
		)
		(obstacles add: obstacle &rest)
	)

	(method (newRoom newRoomNumber)
		(gRegions delete: self eachElementDo: #newRoom newRoomNumber addToFront: self)
		(= gNewRoomNum newRoomNumber)
		(super newRoom: newRoomNumber)
	)

	(method (drawPic pic theStyle)
		(if gAddToPics
			(gAddToPics eachElementDo: #dispose release:)
		)
		(= curPic pic)
		(= gOverlays -1)
		(DrawPic
			pic
			(cond
				((== argc 2) theStyle)
				((!= style -1) style)
				(else 100)
			)
			1
		)
	)

	(method (overlay pic theStyle)
		(= gOverlays pic)
		(DrawPic
			pic
			(cond
				((== argc 2) theStyle)
				((!= style -1) style)
				(else 100)
			)
			0
		)
	)
)

(class SL of Obj
	(properties
		state 0
		code 0
	)

	(method (doit &tmp theLine)
		(if code
			(= theLine (Memory memALLOC_CRIT 150))
			(code doit: theLine)
			(DrawStatus (if state theLine else 0))
			(Memory memFREE theLine)
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

(instance RU of Code
	(properties)

	(method (doit param1 &tmp temp0)
		(if (param1 underBits:)
			(= temp0 (& (= temp0 (| (= temp0 (param1 signal:)) $0001)) $fffb))
			(param1 underBits: 0 signal: temp0)
		)
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

(instance fDC of Code
	(properties)

	(method (doit theFeature)
		(if (theFeature respondsTo: #delete)
			(theFeature signal: (& (theFeature signal:) $ffdf) dispose: delete:)
		else
			(theFeature dispose:)
		)
	)
)

