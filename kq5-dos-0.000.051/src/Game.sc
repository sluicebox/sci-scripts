;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 994)
(include sci.sh)
(use Main)
(use Interface)
(use Count)
(use Sort)
(use RFeature)
(use Sound)
(use Save)
(use Motion)
(use Inventory)
(use User)
(use Menu)
(use System)

(procedure (PromptForDiskChange saveDisk &tmp ret [saveDevice 40] [curDevice 40] [str 40])
	(= ret 1)
	(DeviceInfo diGET_DEVICE gCurSaveDir @saveDevice)
	(DeviceInfo diGET_CURRENT_DEVICE @curDevice)
	(if (and (DeviceInfo diPATHS_EQUAL @saveDevice @curDevice) (DeviceInfo diIS_FLOPPY @curDevice))
		(Format @str 994 3 (if saveDisk {SAVE GAME} else {GAME}) @curDevice) ; "Please insert your %s disk in drive %s."
		(if
			(==
				(= ret
					(if saveDisk
						(Print
							@str
							#font
							0
							#button
							{OK}
							1
							#button
							{Cancel}
							0
							#button
							{Change Directory}
							2
						)
					else
						(Print @str #font 0 #button {OK} 1)
					)
				)
				2
			)
			(= ret (GetDirectory gCurSaveDir))
		)
	)
	(return ret)
)

(instance cast of EventHandler
	(properties)
)

(instance features of EventHandler
	(properties)
)

(instance sFeatures of EventHandler
	(properties)
)

(instance sounds of EventHandler
	(properties)
)

(instance regions of EventHandler
	(properties)
)

(instance locales of EventHandler
	(properties)
)

(instance addToPics_a of EventHandler ; UNUSED
	(properties
		name {addToPics}
	)

	(method (doit)
		(AddToPic elements)
	)
)

(instance controls of Controls
	(properties)
)

(instance timers of Set
	(properties)
)

(instance addToPics_b of EventHandler
	(properties
		name {addToPics}
	)

	(method (doit)
		(self eachElementDo: #perform aTOC)
		(AddToPic elements)
	)
)

(instance aTOC of Code
	(properties)

	(method (doit thePV &tmp dX dY)
		(if (not (| (thePV signal:) $4000))
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
		parseLang 1
		printLang 1
		subtitleLang 0
	)

	(method (play)
		(= gGame self)
		(= gCurSaveDir (GetSaveDir))
		(if (not (GameIsRestarting))
			(GetCWD gCurSaveDir)
		)
		(self setCursor: gWaitCursor 1)
		(self init:)
		(self
			setCursor: gNormalCursor (| (HaveMouse) (!= global70 (gUIcons at: 0)))
		)
		(while (not gQuit)
			(self doit:)
			(= gAniInterval (Wait gSpeed))
		)
	)

	(method (replay &tmp [theStyle 2])
		(if gLastEvent
			(gLastEvent dispose:)
		)
		(if gModelessDialog
			(gModelessDialog dispose:)
		)
		(gCast eachElementDo: #perform RU)
		(gGame setCursor: gWaitCursor 1)
		(DrawPic (gCurRoom curPic:) 5)
		(if (!= global57 -1)
			(DrawPic global57 5 1)
		)
		(if (gCurRoom controls:)
			((gCurRoom controls:) draw:)
		)
		(gAddToPics doit:)
		(= global119 (global65 cursor:))
		(gGame
			setCursor:
				(= global106 global119)
				(|
					(& global71 $0004)
					(| (HaveMouse) (!= global70 (gUIcons at: 0)))
				)
		)
		(SL doit:)
		(DoSound sndRESTORE)
		(Sound pause: 0)
		(DoSound sndMASTER_VOLUME global319)
		(Wait 0)
		(Animate (gCast elements:) 0)
		(while (not gQuit)
			(self doit:)
			(= gAniInterval (Wait gSpeed))
		)
	)

	(method (init &tmp foo)
		(= foo Motion)
		(= foo Sound)
		(= foo RFeature)
		(= foo Polygon)
		(= foo PolyPath)
		(= foo Save)
		(Lock rsVIEW 942 1)
		((= gCast cast) add:)
		((= gFeatures features) add:)
		((= gSortedFeatures sFeatures) add:)
		((= gSounds sounds) add:)
		((= gRegions regions) add:)
		((= gLocales locales) add:)
		((= gAddToPics addToPics_b) add:)
		((= gTimers timers) add:)
		(= gCurSaveDir (GetSaveDir))
		(UIcons init:)
		(Inv init:)
		(User init:)
	)

	(method (doit)
		(gSounds eachElementDo: #check)
		(gTimers eachElementDo: #doit)
		(Animate (gCast elements:) 1)
		(if global58
			(= global58 0)
			(gCast eachElementDo: #motionCue)
		)
		(gRegions eachElementDo: #doit)
		(cond
			(script
				(script doit:)
			)
			((!= gNewRoomNum gCurRoomNum)
				(self newRoom: gNewRoomNum)
			)
			(else
				(User doit:)
			)
		)
		(gTimers eachElementDo: #delete)
		(GameIsRestarting 0)
	)

	(method (showSelf)
		(gRegions showSelf:)
	)

	(method (newRoom newRoomNumber &tmp temp0)
		(= global75 0)
		(gAddToPics dispose:)
		(gFeatures eachElementDo: #dispose release:)
		(gCast eachElementDo: #dispose)
		(gCast eachElementDo: #delete)
		(gTimers eachElementDo: #delete release:)
		(gRegions eachElementDo: #perform DNKR)
		(gRegions release:)
		(gLocales eachElementDo: #dispose release:)
		(Animate 0)
		(= gPrevRoomNum gCurRoomNum)
		(= gCurRoomNum newRoomNumber)
		(= gNewRoomNum newRoomNumber)
		(FlushResources newRoomNumber)
		(self setCursor: gWaitCursor 1)
		(self startRoom: gCurRoomNum checkAni:)
		(SetSynonyms gRegions)
		(while ((= temp0 (Event new: 3)) type:)
			(temp0 dispose:)
		)
		(temp0 dispose:)
		(&= global71 $fff7)
	)

	(method (checkAni &tmp [theExtra 2])
		(Wait 1)
	)

	(method (startRoom roomNum &tmp temp0 temp1 temp2 [temp3 2])
		(if gDebugOn
			(SetDebug)
		)
		(gRegions addToFront: ((= gCurRoom (ScriptID roomNum)) init: yourself:))
		(if (and (!= global65 global70) (== (global70 eMessage:) 0))
			(= temp1 (User canInput:))
			(= temp2 (User controls:))
			(User canInput: 1 controls: 1)
			(= temp0 (Event new: -1))
			(temp0 type: 1 modifiers: 4)
			(proc0_26 0)
			(proc997_0 temp0)
			(User canInput: temp1 controls: temp2)
			(proc0_26 -32768)
		)
	)

	(method (handleEvent event &tmp temp0)
		(event localize:)
		(or
			(gRegions handleEvent: event)
			(gLocales handleEvent: event)
			(and script (script handleEvent: event))
		)
		(event claimed:)
	)

	(method (changeScore delta)
		(+= gScore delta)
		(SL doit:)
	)

	(method (restart &tmp [temp0 3])
		(if gModelessDialog
			(gModelessDialog dispose:)
		)
		(RestartGame)
	)

	(method (save &tmp [comment 20] num oldCur oldPause)
		(Load rsFONT gSmallFont)
		(Load rsCURSOR gWaitCursor)
		(= oldPause (Sound pause: 1))
		(if (PromptForDiskChange 1)
			(if gModelessDialog
				(gModelessDialog dispose:)
			)
			(if (!= (= num (Save doit: @comment)) -1)
				(= oldCur (self setCursor: gWaitCursor 1))
				(if (not (SaveGame name num @comment gVersion))
					(Print 994 0 #font 0 #button {OK} 1) ; "Your save game disk is full. You must either use another disk or save over an existing saved game."
				)
				(self
					setCursor:
						oldCur
						(| (HaveMouse) (!= global70 (gUIcons at: 0)))
				)
			)
			(PromptForDiskChange 0)
		)
		(Sound pause: oldPause)
	)

	(method (restore &tmp [comment 20] num oldCur oldPause)
		(Load rsFONT gSmallFont)
		(= oldCur (self setCursor: gNormalCursor))
		(if (PromptForDiskChange 1)
			(if gModelessDialog
				(gModelessDialog dispose:)
			)
			(if (!= (= num (Restore doit: &rest)) -1)
				(self setCursor: gWaitCursor 1)
				(if (CheckSaveGame name num gVersion)
					(gCast eachElementDo: #dispose)
					(gCast eachElementDo: #delete)
					(RestoreGame name num gVersion)
				else
					(Print 994 1 #font 0 #button {OK} 1) ; "That game was saved under a different interpreter. It cannot be restored."
					(self
						setCursor:
							oldCur
							(| (HaveMouse) (!= global70 (gUIcons at: 0)))
					)
				)
			)
			(PromptForDiskChange 0)
		)
	)

	(method (setSpeed newSpeed &tmp oldSpeed)
		(= oldSpeed gSpeed)
		(= gSpeed newSpeed)
		(return oldSpeed)
	)

	(method (setCursor form force &tmp oldCur)
		(= oldCur gTheCursor)
		(= gTheCursor form)
		(if (== argc 1)
			(SetCursor form)
		else
			(SetCursor form force &rest)
		)
		(return oldCur)
	)

	(method (showMem)
		(Printf ; "Free Heap: %u Bytes Largest ptr: %u Bytes FreeHunk: %u KBytes Largest hunk: %u Bytes"
			994
			2
			(MemoryInfo 1) ; FreeHeap
			(MemoryInfo 0) ; LargestPtr
			(>> (MemoryInfo miFREEHUNK) $0006)
			(MemoryInfo miLARGESTHUNK)
		)
	)

	(method (setScript newScript)
		(if script
			(script dispose:)
		)
		(if (= script newScript)
			(script init: self &rest)
		)
	)

	(method (cue)
		(if script
			(script cue:)
		)
	)
)

(class Rgn of Obj
	(properties
		script 0
		number 0
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
		(if script
			(script handleEvent: event)
		)
		(event claimed:)
	)

	(method (dispose)
		(gRegions delete: self)
		(if (IsObject script)
			(script dispose:)
		)
		(if (IsObject timer)
			(timer dispose:)
		)
		(gSounds eachElementDo: #clean self)
		(DisposeScript number)
	)

	(method (setScript newScript)
		(if (IsObject script)
			(script dispose:)
		)
		(if (= script newScript)
			(script init: self &rest)
		)
	)

	(method (cue)
		(if script
			(script cue:)
		)
	)

	(method (newRoom))
)

(class Rm of Rgn
	(properties
		picture 0
		style 30
		horizon 0
		controls 0
		north 0
		east 0
		south 0
		west 0
		curPic 0
		picAngle 0
		vanishingX 160
		vanishingY -30000
		obstacles 0
	)

	(method (init &tmp temp0 temp1)
		(= number gCurRoomNum)
		(= controls controls)
		(= gPerspective picAngle)
		(if (== style -32768)
			(Graph grFILL_BOX 0 0 190 320 1 0)
			(Graph grUPDATE_BOX 0 0 190 320 1)
		)
		(switch ((= temp1 (User alterEgo:)) edgeHit:)
			(EDGE_TOP
				(temp1 y: (- global61 1))
			)
			(EDGE_LEFT
				(temp1 x: (- global62 (temp1 xStep:)))
			)
			(EDGE_BOTTOM
				(temp1 y: (+ horizon (temp1 yStep:)))
			)
			(EDGE_RIGHT
				(temp1 x: (+ global63 1))
			)
		)
		(temp1 edgeHit: EDGE_NONE)
		(if picture
			(self drawPic: picture)
		)
	)

	(method (doit &tmp nRoom)
		(if script
			(script doit:)
		)
		(if (= nRoom (self edgeToRoom: ((User alterEgo:) edgeHit:)))
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
				(else 0)
			)
		)
	)

	(method (roomToEdge rm)
		(return
			(cond
				((== rm north) 1)
				((== rm south) 3)
				((== rm east) 2)
				((== rm west) 4)
				(else 0)
			)
		)
	)

	(method (dispose)
		(if controls
			(controls dispose:)
		)
		(if obstacles
			(obstacles dispose:)
		)
		(DisposeScript 976)
		(super dispose:)
	)

	(method (handleEvent event)
		(or
			(super handleEvent: event)
			(and controls (controls handleEvent: event))
		)
		(event claimed:)
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

	(method (setLocales locale &tmp i n locID)
		(for ((= i 0)) (< i argc) ((++ i))
			(= n [locale i])
			((= locID (ScriptID n)) number: n)
			(gLocales add: locID)
			(locID init:)
		)
	)

	(method (setFeatures feature &tmp temp0 [temp1 2])
		(for ((= temp0 0)) (< temp0 argc) ((++ temp0))
			(gFeatures add: [feature temp0])
		)
	)

	(method (newRoom newRoomNumber)
		(gRegions delete: self eachElementDo: #newRoom newRoomNumber addToFront: self)
		(= gNewRoomNum newRoomNumber)
		(super newRoom: newRoomNumber)
	)

	(method (drawPic pic theStyle)
		(addToPics_b dispose:)
		(= curPic pic)
		(= global57 -1)
		(DrawPic
			pic
			(cond
				((== argc 2) theStyle)
				((!= style 0) style)
				(else gShowStyle)
			)
		)
	)

	(method (overlay pic theStyle)
		(= global57 pic)
		(DrawPic
			pic
			(cond
				((== argc 2) theStyle)
				((!= style -1) style)
				(else gShowStyle)
			)
			1
		)
	)

	(method (addObstacle obstacle)
		(if (not obstacles)
			(= obstacles (List new:))
		)
		(obstacles add: obstacle &rest)
	)
)

(class Locale of Obj
	(properties
		number 0
	)

	(method (handleEvent event)
		(event claimed:)
	)

	(method (dispose)
		(gLocales delete: self)
		(DisposeScript number)
	)
)

(class SL of Obj
	(properties
		state 0
		code 0
	)

	(method (doit &tmp [theLine 41])
		(if code
			(code doit: @theLine)
			(DrawStatus (if state @theLine else 0))
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

