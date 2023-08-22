;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 994)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Save)
(use Motion)
(use User)
(use System)

(procedure (PromptForDiskChange saveDisk &tmp ret [saveDevice 40] [curDevice 40] [str 40])
	(= ret 1)
	(DeviceInfo diGET_DEVICE gCurSaveDir @saveDevice)
	(DeviceInfo diGET_CURRENT_DEVICE @curDevice)
	(if (and (DeviceInfo diPATHS_EQUAL @saveDevice @curDevice) (DeviceInfo diIS_FLOPPY @curDevice))
		(Format @str 994 2 (if saveDisk {SAVE GAME} else {GAME}) @curDevice) ; "Please insert your %s disk in drive %s."
		(DeviceInfo 4) ; CloseDevice
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
		(if (and global54 (theElement isKindOf: Collect))
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

(instance addToPics of EventHandler
	(properties)

	(method (doit)
		(AddToPic elements)
	)
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
		(self setCursor: gWaitCursor 1)
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
		(gCast eachElementDo: #perform RU)
		(gGame setCursor: gWaitCursor 1)
		(DrawPic (gCurRoom curPic:) 100 1 global61)
		(if (!= global57 -1)
			(DrawPic global57 100 0 global61)
		)
		(gAddToPics doit:)
		(gGame setCursor: gNormalCursor (HaveMouse))
		(SL doit:)
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
		(= foo Save)
		((= gCast cast) add:)
		((= gFeatures features) add:)
		((= gSortedFeatures sFeatures) add:)
		((= gSounds sounds) add:)
		((= gRegions regions) add:)
		((= gAddToPics addToPics) add:)
		(= gCurSaveDir (GetSaveDir))
		(User init:)
	)

	(method (doit)
		(gSounds eachElementDo: #check)
		(if gModelessDialog
			(gModelessDialog check:)
		)
		(Animate (gCast elements:) 1)
		(if global58
			(= global58 0)
			(gCast eachElementDo: #motionCue)
		)
		(if script
			(script doit:)
		)
		(gRegions eachElementDo: #doit)
		(if (== gNewRoomNum gCurRoomNum)
			(User doit:)
		)
		(if (!= gNewRoomNum gCurRoomNum)
			(self newRoom: gNewRoomNum)
		)
		(GameIsRestarting 0)
	)

	(method (showSelf)
		(gRegions showSelf:)
	)

	(method (newRoom newRoomNumber &tmp [temp0 4] temp4 temp5)
		(gAddToPics dispose:)
		(gFeatures eachElementDo: #dispose release:)
		(gCast eachElementDo: #dispose eachElementDo: #delete)
		(gRegions eachElementDo: #dispose release:)
		(Animate 0)
		(= gPrevRoomNum gCurRoomNum)
		(= gCurRoomNum newRoomNumber)
		(= gNewRoomNum newRoomNumber)
		(FlushResources newRoomNumber)
		(= temp4 (self setCursor: gWaitCursor 1))
		(self startRoom: gCurRoomNum setCursor: temp4 (HaveMouse))
		(SetSynonyms gRegions)
		(while ((= temp5 (Event new: 3)) type:)
			(temp5 dispose:)
		)
		(temp5 dispose:)
	)

	(method (checkAni &tmp theExtra))

	(method (startRoom roomNum)
		(if gDebugOn
			(SetDebug)
		)
		(gRegions addToFront: (= gCurRoom (ScriptID roomNum)))
		(gCurRoom init:)
	)

	(method (handleEvent event)
		(or
			(gRegions handleEvent: event)
			(and script (script handleEvent: event))
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

	(method (save &tmp [comment 20] num oldCur oldPause)
		(Load rsFONT gSmallFont)
		(Load rsCURSOR gWaitCursor)
		(= oldPause (Sound pause: 1))
		(if (PromptForDiskChange 1)
			(if (!= (= num (Save doit: @comment)) -1)
				(= oldCur (self setCursor: gWaitCursor 1))
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
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
			(if (!= (= num (Restore doit: &rest)) -1)
				(self setCursor: gWaitCursor 1)
				(if (CheckSaveGame name num gVersion)
					(if gModelessDialog
						(gModelessDialog dispose:)
					)
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

	(method (setCursor form &tmp oldCur)
		(= oldCur gTheCursor)
		(= gTheCursor form)
		(SetCursor form &rest)
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

	(method (wordFail &tmp [temp0 100]))

	(method (syntaxFail))

	(method (semanticFail))

	(method (pragmaFail))

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
	)

	(method (init)
		(if (not (gRegions contains: self))
			(gRegions addToEnd: self)
		)
		(super init:)
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
		curPic 0
		north 0
		south 0
		east 0
		west 0
		picAngle 0
		vanishingX 160
		vanishingY -30000
	)

	(method (init &tmp how)
		(= number gCurRoomNum)
		(= gPerspective picAngle)
		(if picture
			(self drawPic: picture)
		)
		(switch ((User alterEgo:) edgeHit:)
			(EDGE_TOP
				((User alterEgo:) y: 188)
			)
			(EDGE_LEFT
				((User alterEgo:) x: (- 319 ((User alterEgo:) xStep:)))
			)
			(EDGE_BOTTOM
				((User alterEgo:) y: (+ horizon ((User alterEgo:) yStep:)))
			)
			(EDGE_RIGHT
				((User alterEgo:) x: 1)
			)
		)
		((User alterEgo:) edgeHit: EDGE_NONE)
	)

	(method (doit)
		(if script
			(script doit:)
		)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(event claimed:)
	)

	(method (setRegions region &tmp i n regID)
		(for ((= i 0)) (< i argc) ((++ i))
			(= n [region i])
			(= regID (ScriptID n))
			(regID number: n)
			(gRegions add: regID)
			(regID init:)
		)
	)

	(method (setLocales &tmp [temp0 3]))

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
			0
			global61
		)
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

