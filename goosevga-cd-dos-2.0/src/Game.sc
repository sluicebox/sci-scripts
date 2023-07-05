;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 994)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use User)
(use System)

(procedure (PromptForDiskChange saveDisk &tmp ret [saveDevice 40] [curDevice 40] [str 40])
	(= ret 1)
	(DeviceInfo diGET_DEVICE gCurSaveDir @saveDevice)
	(DeviceInfo diGET_CURRENT_DEVICE @curDevice)
	(if (and (DeviceInfo diPATHS_EQUAL @saveDevice @curDevice) (DeviceInfo diIS_FLOPPY @curDevice))
		(Format @str 994 4 (if saveDisk {SAVE GAME} else {GAME}) @curDevice) ; "Please insert your %s disk in drive %s."
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
			(= ret (proc990_0 gCurSaveDir))
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
		parseLang 1
		printLang 1
		subtitleLang 0
	)

	(method (play)
		(= gGame self)
		(= gCurSaveDir (GetSaveDir))
		(StrCpy gCurSaveDir {a:\5c})
		(self setCursor: gWaitCursor 1)
		(self init:)
		(self setCursor: gNormalCursor (HaveMouse))
		(while (not gQuit)
			(self doit:)
			(= gAniInterval (Wait gSpeed))
		)
	)

	(method (replay &tmp temp0 temp1)
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
		(gGame setCursor: gNormalCursor (HaveMouse))
		(SL doit:)
		(DoSound sndRESTORE)
		(Sound pause: 0)
		(gGame changeScore: 0)
		(gGControls eachElementDo: #draw)
		(Wait 0)
		(Animate (gCast elements:) 0)
		(for ((= temp0 0)) (<= temp0 100) ((+= temp0 10))
			(Palette palSET_INTENSITY 0 255 temp0)
			(Wait 1)
		)
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
		((= gSounds sounds) add:)
		((= gRegions regions) add:)
		((= gLocales locales) add:)
		((= gAddToPics addToPics) add:)
		((= gTimers timers) add:)
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

	(method (newRoom newRoomNumber &tmp [temp0 4] temp4 temp5 temp6 temp7)
		(= global75 0)
		(gAddToPics dispose:)
		(gFeatures eachElementDo: #dispose)
		(gCast eachElementDo: #dispose)
		(if (not global176)
			(= temp7 10)
			(for ((= temp6 100)) (>= temp6 -1) ((-= temp6 temp7))
				(if (== temp6 50)
					(Animate (gCast elements:) 0)
					(= temp7 20)
				)
				(Palette palSET_INTENSITY 64 255 temp6)
				(Wait 1)
			)
			(Palette palSET_INTENSITY 64 255 0)
			(Wait 1)
		)
		(gTimers eachElementDo: #delete)
		(gRegions eachElementDo: #perform DNKR)
		(gRegions release:)
		(gLocales eachElementDo: #dispose)
		(= gPrevRoomNum gCurRoomNum)
		(= gCurRoomNum newRoomNumber)
		(= gNewRoomNum newRoomNumber)
		(FlushResources newRoomNumber)
		(= temp4 (self setCursor: gWaitCursor 1))
		(self startRoom: gCurRoomNum checkAni: setCursor: temp4 (HaveMouse))
		(SetSynonyms gRegions)
		(while ((= temp5 (Event new: 3)) type:)
			(temp5 dispose:)
		)
		(temp5 dispose:)
	)

	(method (checkAni &tmp [theExtra 2])
		(Wait 1)
	)

	(method (startRoom roomNum &tmp temp0 temp1 temp2 temp3)
		(if gDebugOn
			(SetDebug)
		)
		(gRegions addToFront: ((= gCurRoom (ScriptID roomNum)) init: yourself:))
		(if global176
			(return)
		)
		(Animate 0)
		(Wait 0)
		(for ((= temp2 0)) (< temp2 (gCast size:)) ((++ temp2))
			(DrawCel ((gCast at: temp2) view:) 0 0 400 0 0 -1)
		)
		(= temp1 20)
		(for ((= temp0 0)) (<= temp0 100) ((+= temp0 temp1))
			(if (== temp0 40)
				(Animate (gCast elements:) 1)
				(= temp1 10)
			)
			(Palette palSET_INTENSITY 64 255 temp0)
			(Wait 1)
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
		(gCast eachElementDo: #dispose)
		(RestartGame)
	)

	(method (save &tmp [comment 32] num oldCur [oldPause 276])
		(Load rsFONT gSmallFont)
		(Load rsCURSOR gWaitCursor)
		(= oldCur (Sound pause: 1))
		(if (PromptForDiskChange 1)
			(if gModelessDialog
				(gModelessDialog dispose:)
			)
			(if (>= global179 13)
				(Print 994 0 #font 0 #button {OK} 1) ; "You can only save 12 games on a disk. You must use another disk."
			else
				(if (!= global179 -1)
					(= num (self setCursor: gWaitCursor 1))
					(if (not (SaveGame name global179 (+ @global190 4) gVersion))
						(Print 994 1 #font 0 #button {OK} 1) ; "Your save game disk is full. You must use another disk."
					)
					(self setCursor: num (HaveMouse))
				)
				(PromptForDiskChange 0)
			)
		)
		(Sound pause: oldCur)
	)

	(method (restore &tmp [comment 21] num oldCur oldPause)
		(if (PromptForDiskChange 1)
			(if gModelessDialog
				(gModelessDialog dispose:)
			)
			(if (!= global179 0)
				(gCast eachElementDo: #dispose)
				(Load rsFONT gSmallFont)
				(= num (self setCursor: gNormalCursor))
				(= oldCur (Sound pause: 1))
				(self setCursor: gWaitCursor 1)
				(if (CheckSaveGame name global179 gVersion)
					(for ((= oldPause 100)) oldPause ((-= oldPause 10))
						(if (== oldPause 40)
							(Animate (gCast elements:) 1)
						)
						(Palette palSET_INTENSITY 64 255 oldPause)
						(Wait 1)
					)
					(gCast eachElementDo: #dispose)
					(gCast eachElementDo: #delete)
					(RestoreGame name global179 gVersion)
				)
			else
				(Print 994 2 #font 0 #button {OK} 1) ; "You don't have a save game to restore from."
			)
			(PromptForDiskChange 0)
		)
		(Sound pause: oldCur)
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
			3
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
	)

	(method (init &tmp how)
		(= number gCurRoomNum)
		(= controls controls)
		(= gPerspective picAngle)
		(if picture
			(self drawPic: picture)
		)
	)

	(method (reflectPosn theActor theEdge)
		(switch theEdge
			(3
				(theActor y: (- global61 1))
			)
			(2
				(theActor x: (- global62 (theActor xStep:)))
			)
			(1
				(theActor y: (+ horizon (theActor yStep:)))
			)
			(4
				(theActor x: (+ global63 1))
			)
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

