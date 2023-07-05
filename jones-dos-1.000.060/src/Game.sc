;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 994)
(include sci.sh)
(use Main)
(use room1)
(use Interface)
(use KeyMouse)
(use Sound)
(use Save)
(use Motion)
(use User)
(use System)

(instance cast of EventHandler
	(properties)
)

(instance sounds of EventHandler
	(properties)
)

(instance controls of Controls
	(properties)
)

(class SysWindow of Obj
	(properties
		top 0
		left 0
		bottom 0
		right 0
		color 0
		back 7
		priority -1
		window 0
		type 0
		title 0
		hMargin 4
		vMargin 4
		brTop 0
		brLeft 0
		brBottom 190
		brRight 320
		animateObj 0
	)

	(method (open)
		(= window
			(NewWindow top left bottom right title type priority color back)
		)
	)

	(method (dispose)
		(DisposeWindow window)
		(super dispose:)
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
		(self setCursor: gNormalCursor (HaveMouse))
		(while (not gQuit)
			(self doit:)
			(= gAniInterval (Wait gSpeed))
		)
		(gSounds eachElementDo: #stop)
	)

	(method (replay &tmp temp0 temp1)
		(if gLastEvent
			(gLastEvent dispose:)
		)
		(if gModelessDialog
			(gModelessDialog dispose:)
		)
		(gGame setCursor: gWaitCursor 1)
		(gTheWalker hide:)
		(proc0_1)
		(DrawPic (gCurRoom picture:) 5)
		(proc0_1)
		(= temp1 (GetPort))
		(SetPort 0)
		(proc1_8)
		(SetPort temp1)
		(Palette palUNSET_FLAG 8 16 1)
		(Palette palUNSET_FLAG 144 255 1)
		(gGame setCursor: gNormalCursor (HaveMouse))
		(DoSound sndRESTORE)
		(Sound pause: 0)
		(SetPort 0)
		(Display
			(Format @global100 994 0 global372) ; "Week #%2d"
			dsCOLOR
			0
			dsBACKGROUND
			(if global535 86 else 7)
			dsCOORD
			140
			184
			dsFONT
			10
		)
		(SetPort temp1)
		(= global518 1)
		(proc0_1)
		(if global502
			(Graph grFILL_BOX 45 69 162 250 2 0 0)
			(while global502
				(if (not global519)
					(global502 draw:)
				else
					(= global519 0)
				)
				(global502 init:)
			)
			(proc1_8)
			(if (global302 script:)
				((global302 script:) cue:)
			)
			(= gItems 0)
			(Palette palUNSET_FLAG 8 16 1)
			(Palette palUNSET_FLAG 144 255 1)
			(if (< global323 60)
				(gTheWalker show:)
			)
			(proc0_1)
			(KeyMouse curItem: global515)
			(= global446 0)
			(= global479 0)
			(if global447
				(if (== (global302 playing:) 29)
					(SetCursor gTheCursor 1 319 199)
				else
					(SetCursor gTheCursor 1 global449 global450)
				)
				(KeyMouse prevCursorX: global449 prevCursorY: global450)
			)
			(= temp0
				(switch (global302 whichBody:)
					(0 280)
					(1 284)
					(2 290)
					(3 294)
				)
			)
			(if (== (global302 playing:) 29)
				(= temp0 274)
			)
			(gTheWalker
				view:
					(if (not (global302 weeksOfClothing:))
						(+ temp0 3)
					else
						(+ temp0 (- (global302 wearing:) 34))
					)
			)
			(gTheWalker forceUpd:)
			(proc0_1)
			(proc1_9)
			(if global516
				(gDoor setCel: -1 startUpd: setCycle: Beg)
			)
			((global302 consumables:) pack:)
			((global302 durables:) pack:)
			((global302 education:) pack:)
			(if (< global323 60)
				(gASong loop: -1 play: 5)
			)
		else
			(gTheWalker show:)
		)
		(= global518 0)
		(proc0_1)
		(while (not gQuit)
			(self doit:)
			(= gAniInterval (Wait gSpeed))
		)
		(gSounds eachElementDo: #stop)
	)

	(method (init &tmp foo)
		(= foo Motion)
		(= foo Sound)
		(Load rsSCRIPT 990)
		((= gCast cast) add:)
		((= gSounds sounds) add:)
		(= gCurSaveDir (GetSaveDir))
		(User init:)
	)

	(method (doit)
		(gSounds eachElementDo: #check)
		(Animate (gCast elements:) 1)
		(if global58
			(= global58 0)
			(gCast eachElementDo: #motionCue)
		)
		(if script
			(script doit:)
		)
		(if gCurRoom
			(gCurRoom doit:)
		)
		(User doit:)
		(if (!= gNewRoomNum gCurRoomNum)
			(self newRoom: gNewRoomNum)
		)
		(GameIsRestarting 0)
	)

	(method (showSelf))

	(method (newRoom newRoomNumber &tmp [temp0 4] temp4 temp5 temp6)
		(gCast eachElementDo: #dispose)
		(= gPrevRoomNum gCurRoomNum)
		(= gCurRoomNum newRoomNumber)
		(= gNewRoomNum newRoomNumber)
		(FlushResources newRoomNumber)
		(= temp4 (self setCursor: gWaitCursor 1))
		(self startRoom: gCurRoomNum checkAni: setCursor: temp4 (HaveMouse))
		(while ((= temp5 (Event new: 3)) type:)
			(temp5 dispose:)
		)
		(temp5 dispose:)
	)

	(method (checkAni &tmp [theExtra 2]))

	(method (startRoom roomNum &tmp temp0)
		(if gDebugOn
			(SetDebug)
		)
		((= gCurRoom (ScriptID roomNum)) init:)
	)

	(method (handleEvent event &tmp temp0)
		(event localize:)
		(or
			(gCurRoom handleEvent: event)
			(and script (script handleEvent: event))
		)
		(event claimed:)
	)

	(method (changeScore))

	(method (restart)
		(SetPort 0)
		(if global502
			(global502 dispose:)
		)
		(if gModelessDialog
			(gModelessDialog dispose:)
		)
		(RestartGame)
	)

	(method (save)
		(proc990_0)
	)

	(method (restore)
		(proc990_1)
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
			{Heap: %u\nLargest: %u\nHunk: %uK\nLargest: %u}
			(MemoryInfo 1) ; FreeHeap
			(MemoryInfo 0) ; LargestPtr
			(>> (MemoryInfo miFREEHUNK) $0006)
			(MemoryInfo miLARGESTHUNK)
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

(class Rm of Obj
	(properties
		script 0
		number 0
		timer 0
		picture 0
		style -1
		controls 0
	)

	(method (init &tmp how)
		(= number gCurRoomNum)
		((= controls controls) add:)
		(if picture
			(self drawPic: picture)
		)
	)

	(method (doit &tmp nRoom)
		(if script
			(script doit:)
		)
	)

	(method (setScript param1)
		(if (IsObject script)
			(script dispose:)
		)
		(if (= script param1)
			(script init: self &rest)
		)
	)

	(method (cue)
		(if script
			(script cue:)
		)
	)

	(method (dispose)
		(if controls
			(controls dispose:)
		)
		(if (IsObject script)
			(script dispose:)
		)
		(gSounds eachElementDo: #clean self)
		(DisposeScript number)
	)

	(method (handleEvent event)
		(if controls
			(controls handleEvent: event)
		)
		(event claimed:)
	)

	(method (newRoom newRoomNumber)
		(= gNewRoomNum newRoomNumber)
	)

	(method (drawPic pic theStyle &tmp temp0)
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
)

(instance RU of Code ; UNUSED
	(properties)

	(method (doit param1 &tmp temp0)
		(if (param1 underBits:)
			(= temp0 (| (= temp0 (param1 signal:)) $0001))
			(param1 signal: temp0)
		)
	)
)

