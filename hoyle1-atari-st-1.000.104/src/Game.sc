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

(procedure (localproc_0 &tmp [temp0 121])) ; UNUSED

(instance cast of Set
	(properties)
)

(instance sounds of Set
	(properties)
)

(class Game of Obj
	(properties)

	(method (play)
		(= gGame self)
		(= gNormalCursor 999)
		(= gWaitCursor 997)
		(= gUserFont (= gBigFont 1))
		(= gSmallFont 4)
		(self setCursor: gWaitCursor 1 init: setCursor: gNormalCursor (HaveMouse))
		(while (not gQuit)
			(self doit:)
			(if gSpeed
				(Wait gSpeed)
			)
		)
	)

	(method (init &tmp foo)
		(= foo Motion)
		(= foo Sound)
		((= gCast cast) add:)
		((= gSounds sounds) add:)
	)

	(method (doit)
		(gSounds eachElementDo: #check)
		(Animate (gCast elements:) 1)
		(if global58
			(= global58 0)
			(gCast eachElementDo: #motionCue)
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

	(method (newRoom newRoomNumber &tmp [temp0 4] temp4 temp5)
		(gCast eachElementDo: #dispose eachElementDo: #delete)
		(if gCurRoom
			(gCurRoom dispose:)
		)
		(Animate 0)
		(= gPrevRoomNum gCurRoomNum)
		(= gCurRoomNum (= gNewRoomNum newRoomNumber))
		(FlushResources newRoomNumber)
		(= temp4 (self setCursor: gWaitCursor 1))
		(self startRoom: gCurRoomNum setCursor: temp4 (HaveMouse))
		(while ((= temp5 (Event new: evMOUSE)) type:)
			(temp5 dispose:)
		)
		(temp5 dispose:)
	)

	(method (checkAni &tmp theExtra))

	(method (startRoom roomNum)
		(if gDebugOn
			(SetDebug)
		)
		((= gCurRoom (ScriptID roomNum)) init:)
	)

	(method (handleEvent event)
		(gCurRoom handleEvent: event)
	)

	(method (changeScore))

	(method (restart)
		(if gModelessDialog
			(gModelessDialog dispose:)
		)
		(RestartGame)
	)

	(method (restore))

	(method (setSpeed &tmp temp0))

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
		(Print
			(Format
				@global520
				{Free Heap: %u Bytes\nLargest ptr: %u Bytes\nFreeHunk: %u KBytes\nLargest hunk: %u Bytes}
				(MemoryInfo 1) ; FreeHeap
				(MemoryInfo 0) ; LargestPtr
				(>> (MemoryInfo miFREEHUNK) $0006)
				(MemoryInfo miLARGESTHUNK)
			)
		)
	)
)

(class Rm of Obj
	(properties
		picture 0
		style -1
		number 0
		horizon 0
		curPic 0
	)

	(method (init &tmp how)
		(= number gCurRoomNum)
		(if picture
			(self drawPic: picture)
		)
		(super init:)
	)

	(method (dispose)
		(gSounds eachElementDo: #clean self)
		(DisposeScript gCurRoomNum)
	)

	(method (newRoom newRoomNumber)
		(= gNewRoomNum newRoomNumber)
	)

	(method (drawPic pic theStyle)
		(DrawPic
			(= curPic pic)
			(cond
				((== argc 2) theStyle)
				((!= style -1) style)
				(else gShowStyle)
			)
		)
	)
)

