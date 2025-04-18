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
(use Actor)
(use System)

(procedure (PromptForDiskChange saveDisk &tmp ret [saveDevice 40] [curDevice 40] [str 40])
	(= ret 1)
	(DeviceInfo diGET_DEVICE gCurSaveDir @saveDevice)
	(DeviceInfo diGET_CURRENT_DEVICE @curDevice)
	(if (and (DeviceInfo diPATHS_EQUAL @saveDevice @curDevice) (DeviceInfo diIS_FLOPPY @curDevice))
		(Format @str 994 6 (if saveDisk {SAVE GAME} else {GAME}) @curDevice) ; "Please insert your %s disk in drive %s."
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

(instance cast of Set
	(properties)
)

(instance features of Set
	(properties)
)

(instance sounds of Set
	(properties)
)

(instance regions of Set
	(properties)
)

(instance locales of Set
	(properties)
)

(instance addToPics of Set
	(properties)
)

(instance controls of Controls
	(properties)
)

(instance timers of Set
	(properties)
)

(instance ego of Ego
	(properties)
)

(class Game of Obj
	(properties
		script 0
	)

	(method (play)
		(= gGame self)
		(= gNormalCursor 999)
		(= gWaitCursor 997)
		(= gUserFont 1)
		(= gBigFont 1)
		(= gSmallFont 4)
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
		(if gModelessDialog
			(gModelessDialog dispose:)
		)
		(gCast eachElementDo: #perform RU)
		(gGame setCursor: gWaitCursor 1)
		(DrawPic (gCurRoom curPic:) 5)
		(if (gCurRoom controls:)
			((gCurRoom controls:) draw:)
		)
		(gAddToPics eachElementDo: #init dispose:)
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
		(= gSpeed 6)
		(= gAniThreshold 10)
		(= gEgo ego)
		((= gCast cast) add:)
		(= global54 gCast)
		((= gFeatures features) add:)
		(= gSortedFeatures gFeatures)
		((= gSounds sounds) add:)
		((= gRegions regions) add:)
		((= gLocales locales) add:)
		((= gAddToPics addToPics) add:)
		((= gTimers timers) add:)
		(= gCurSaveDir (GetSaveDir))
		(Inv init:)
		(User alterEgo: gEgo)
	)

	(method (doit)
		(gSounds eachElementDo: #check)
		(gTimers eachElementDo: #doit)
		(Animate (gCast elements:) 1)
		(if global55
			(gCast eachElementDo: #delete)
			(= global55 0)
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

	(method (newRoom newRoomNumber &tmp [temp0 4] temp4 temp5)
		(= gPerspective 0)
		(= global56 1)
		(gAddToPics dispose:)
		(gCast eachElementDo: #dispose)
		(gCast eachElementDo: #delete)
		(gTimers eachElementDo: #delete)
		(gRegions eachElementDo: #perform DNKR)
		(gLocales eachElementDo: #dispose)
		(gFeatures eachElementDo: #dispose)
		(Animate 0)
		(= gPrevRoomNum gCurRoomNum)
		(= gCurRoomNum newRoomNumber)
		(= gNewRoomNum newRoomNumber)
		(FlushResources newRoomNumber)
		(= temp4 (self setCursor: gWaitCursor 1))
		(self startRoom: gCurRoomNum checkAni: setCursor: temp4 (HaveMouse))
		(SetSynonyms gRegions)
		(while ((= temp5 (Event new: evMOUSE)) type:)
			(temp5 dispose:)
		)
		(temp5 dispose:)
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
	)

	(method (handleEvent event)
		(gRegions eachElementDo: #handleEvent event)
		(gLocales eachElementDo: #handleEvent event)
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
		(Printf 994 2 word) ; "I don't understand "%s"."
		(return 0)
	)

	(method (syntaxFail)
		(Print 994 3) ; "That doesn't appear to be a proper sentence."
	)

	(method (semanticFail)
		(Print 994 4) ; "That sentence doesn't make sense."
	)

	(method (pragmaFail)
		(Print 994 5) ; "You've left me responseless."
	)

	(method (notify))

	(method (setScript newScript)
		(if script
			(script dispose:)
		)
		(if (= script newScript)
			(script init: self)
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
		(if script
			(script dispose:)
		)
		(if (= script newScript)
			(script init: self)
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
	)

	(method (init &tmp how)
		(= number gCurRoomNum)
		(= controls controls)
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
		(gEgo edgeHit: EDGE_NONE)
	)

	(method (doit)
		(if script
			(script doit:)
		)
		(switch ((User alterEgo:) edgeHit:)
			(EDGE_TOP
				(if north
					(self newRoom: north)
				)
			)
			(EDGE_RIGHT
				(if east
					(self newRoom: east)
				)
			)
			(EDGE_BOTTOM
				(if south
					(self newRoom: south)
				)
			)
			(EDGE_LEFT
				(if west
					(self newRoom: west)
				)
			)
		)
	)

	(method (dispose)
		(if controls
			(controls dispose:)
		)
		(super dispose:)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if controls
			(controls handleEvent: event)
		)
	)

	(method (setRegions region &tmp i n regID)
		(for ((= i 0)) (< i argc) ((++ i))
			(= n [region i])
			(= regID (ScriptID n))
			(regID number: n)
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
		(DrawPic
			curPic
			(cond
				((== argc 2) theStyle)
				((!= style -1) style)
				(else gShowStyle)
			)
		)
	)
)

(class Locale of Obj
	(properties
		number 0
	)

	(method (handleEvent))

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

