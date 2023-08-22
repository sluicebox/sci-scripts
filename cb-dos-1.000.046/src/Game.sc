;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 994)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Save)
(use Motion)
(use Inventory)
(use User)
(use System)

(procedure (PromptForDiskChange saveDisk &tmp ret [saveDevice 40] [curDevice 40] [str 40])
	(= ret 1)
	(DeviceInfo diGET_DEVICE gCurSaveDir @saveDevice)
	(DeviceInfo diGET_CURRENT_DEVICE @curDevice)
	(if (and (DeviceInfo diPATHS_EQUAL @saveDevice @curDevice) (DeviceInfo diIS_FLOPPY @curDevice))
		(Format @str 994 8 (if saveDisk {SAVE GAME} else {GAME}) @curDevice) ; "Please insert your %s disk in drive %s."
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

	(method (delete theElement)
		(super delete: theElement)
		(if (and global54 (theElement isKindOf: Unknown_Class_2))
			(theElement release: dispose:)
		)
	)
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

(instance addToPics of EventHandler
	(properties)

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

(class Game of Obj
	(properties
		script 0
	)

	(method (play)
		(= gGame self)
		(= gCurSaveDir (GetSaveDir))
		(if (not (GameIsRestarting))
			(GetCWD gCurSaveDir)
		)
		(self setCursor: gWaitCursor 1 320 200)
		(self init:)
		(self setCursor: gNormalCursor (HaveMouse))
		(while (not gQuit)
			(self doit:)
			(= gAniInterval (Wait gSpeed))
		)
	)

	(method (replay)
		(if gLastEvent
			(gLastEvent dispose:)
		)
		(gSortedFeatures release:)
		(if gModelessDialog
			(gModelessDialog dispose:)
		)
		(gCast eachElementDo: #perform RU)
		(gGame setCursor: gWaitCursor 1)
		(DrawPic (gCurRoom curPic:) 100 1 global61)
		(if (!= global57 -1)
			(DrawPic global57 100 0 global61)
		)
		(if (gCurRoom controls:)
			((gCurRoom controls:) draw:)
		)
		(gAddToPics doit:)
		(gGame setCursor: gNormalCursor (HaveMouse))
		(DoSound sndRESUME)
		(Sound pause: 0)
		(while (not gQuit)
			(self doit:)
			(= gAniInterval (Wait gSpeed))
		)
	)

	(method (init &tmp foo)
		(= foo Motion)
		(= foo Sound)
		((= gCast cast) add:)
		((= gFeatures features) add:)
		((= gSortedFeatures sFeatures) add:)
		((= gSounds sounds) add:)
		((= gRegions regions) add:)
		((= gLocales locales) add:)
		((= gAddToPics addToPics) add:)
		((= gTimers timers) add:)
		(= gCurSaveDir (GetSaveDir))
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
		(if script
			(script doit:)
		)
		(gRegions eachElementDo: #doit)
		(User doit:)
		(if (!= gNewRoomNum gCurRoomNum)
			(self newRoom: gNewRoomNum)
		)
		(gTimers eachElementDo: #delete)
		(GameIsRestarting 0)
	)

	(method (showSelf)
		(gRegions showSelf:)
	)

	(method (newRoom newRoomNumber &tmp [temp0 3] temp3 temp4)
		(gAddToPics dispose:)
		(gFeatures eachElementDo: #dispose release:)
		(gCast eachElementDo: #dispose eachElementDo: #delete)
		(gTimers eachElementDo: #delete)
		(gRegions eachElementDo: #perform DNKR release:)
		(gLocales eachElementDo: #dispose release:)
		(Animate 0)
		(= gPrevRoomNum gCurRoomNum)
		(= gCurRoomNum newRoomNumber)
		(= gNewRoomNum newRoomNumber)
		(FlushResources newRoomNumber)
		(= temp3 (self setCursor: gWaitCursor 1))
		(self startRoom: gCurRoomNum checkAni: setCursor: temp3 (HaveMouse))
		(SetSynonyms gRegions)
		(while ((= temp4 (Event new: 3)) type:)
			(temp4 dispose:)
		)
		(temp4 dispose:)
	)

	(method (checkAni &tmp theExtra)
		(Animate (gCast elements:) 0)
		(Wait 0)
		(Animate (gCast elements:) 0)
		(while (> (Wait 0) gAniThreshold)
			(breakif (== (= theExtra (gCast firstTrue: #isExtra)) 0))
			(theExtra addToPic:)
			(Animate (gCast elements:) 0)
			(gCast eachElementDo: #delete)
		)
	)

	(method (startRoom roomNum)
		(if gDebugOn
			(SetDebug)
		)
		(gRegions addToFront: ((= gCurRoom (ScriptID roomNum)) init: yourself:))
		(if (== (gEgo view:) 0)
			(gEgo view: 11)
		)
	)

	(method (handleEvent event)
		(or
			(gRegions handleEvent: event)
			(gLocales handleEvent: event)
			(and script (script handleEvent: event))
		)
		(event claimed:)
	)

	(method (changeScore delta)
		(+= gScore delta)
	)

	(method (restart)
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
				(self setCursor: oldCur (HaveMouse))
			)
			(PromptForDiskChange 0)
		)
		(Sound pause: oldPause)
	)

	(method (restore &tmp [comment 20] num oldCur oldPause)
		(Load rsFONT gSmallFont)
		(= oldCur (self setCursor: gNormalCursor))
		(= oldPause (Sound pause: 1))
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
					(self setCursor: oldCur (HaveMouse))
				)
			)
			(PromptForDiskChange 0)
		)
		(Sound pause: oldPause)
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
			(SetCursor form force)
		)
		(return oldCur)
	)

	(method (showMem)
		(Printf
			{Free Heap: %u Bytes\nLargest ptr: %u Bytes\nFreeHunk: %u KBytes\nLargest hunk: %u Bytes}
			(MemoryInfo 1) ; FreeHeap
			(MemoryInfo 0) ; LargestPtr
			(>> (MemoryInfo miFREEHUNK) $0006)
			(MemoryInfo miLARGESTHUNK)
		)
	)

	(method (wordFail word &tmp [str 100])
		(Print (Format @str 994 2 word)) ; "This game does not understand "%s.""
		(return 0)
	)

	(method (syntaxFail)
		(Print 994 3) ; "Try that one again. It didn't make much sense."
	)

	(method (semanticFail)
		(Print 994 4) ; "That sentence doesn't make sense."
	)

	(method (pragmaFail)
		(switch (Random 1 3)
			(1
				(Print 994 5) ; "That is not understood."
			)
			(2
				(Print 994 6) ; "That is not clear."
			)
			(3
				(Print 994 7) ; "Try another way to say that."
			)
		)
	)

	(method (notify))

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
		vanishingY -30000
		vertAngle 0
	)

	(method (init &tmp temp0 temp1)
		(= number gCurRoomNum)
		(= controls controls)
		(= gPerspective picAngle)
		(if picture
			(self drawPic: picture)
		)
		(switch ((= temp1 (User alterEgo:)) edgeHit:)
			(EDGE_TOP
				(temp1 y: 188)
			)
			(EDGE_LEFT
				(temp1 x: (- 319 (temp1 xStep:)))
			)
			(EDGE_BOTTOM
				(temp1 y: (+ horizon (temp1 yStep:)))
			)
			(EDGE_RIGHT
				(temp1 x: 1)
			)
		)
		(temp1 edgeHit: EDGE_NONE)
	)

	(method (doit &tmp nRoom)
		(if script
			(script doit:)
		)
		(if
			(= nRoom
				(switch ((User alterEgo:) edgeHit:)
					(EDGE_TOP north)
					(EDGE_RIGHT east)
					(EDGE_BOTTOM south)
					(EDGE_LEFT west)
				)
			)
			(self newRoom: nRoom)
		)
	)

	(method (dispose)
		(if controls
			(controls dispose:)
		)
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
		(addToPics dispose:)
		(= curPic pic)
		(= global57 -1)
		(DrawPic
			pic
			(cond
				((== argc 2) theStyle)
				((!= style -1) style)
				(else gShowStyle)
			)
			1
			global61
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
			global61
		)
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

