;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4053)
(include sci.sh)
(use Main)
(use ExitButton)
(use PQRoom)
(use Print)
(use Feature)
(use WalkieTalkie)
(use Timer)
(use Actor)
(use System)

(public
	rm4053 0
)

(local
	local0
)

(instance rm4053 of PQRoom
	(properties
		modNum 405
		picture 405
	)

	(method (init)
		(Load rsVIEW 13)
		(Load rsVIEW 10)
		(if (== (gGame printLang:) 1)
			(Load rsAUDIO 10302)
		)
		(Load rsSCRIPT 31 64956)
		(Load rsHEAP 31 64956)
		(if (and (!= 0 (gBackMusic number:)) (!= 10302 (gBackMusic number:)))
			(gBackMusic fade: 0 2 21 1)
		)
		(SetFlag 65)
		(SetFlag 72)
		(theBoard init:)
		(cond
			((== gPrevRoomNum 4999) ; greaseBoard
				(if (== global108 7)
					(self setScript: backFromBoardSnipe)
				else
					(SetFlag 78)
					(SetFlag 84)
					(SetFlag 19)
					(self setScript: backFromBoard)
				)
			)
			((IsFlag 78)
				(cond
					((and (== global108 6) (IsFlag 84))
						(gCurRoom setScript: rookerGatherAround)
					)
					((and (== global108 6) (not (IsFlag 84)))
						(gCurRoom setScript: firstLeader)
					)
					((and (== global108 7) (IsFlag 83))
						(if (== (gGame printLang:) 1)
							(Lock rsAUDIO 10302 1)
						)
						(gBackMusic number: 10302 setLoop: -1 play:)
						(gCurRoom setScript: consecSniper)
					)
					((and (== global108 7) (not (IsFlag 83)))
						(if (== (gGame printLang:) 1)
							(Lock rsAUDIO 10302 1)
						)
						(gBackMusic number: 10302 setLoop: -1 play:)
						(gCurRoom setScript: firstSniper)
					)
				)
			)
			((== global108 6)
				(gCurRoom setScript: firstLeader)
			)
			((== global108 7)
				(if (== (gGame printLang:) 1)
					(Lock rsAUDIO 10302 1)
				)
				(gBackMusic number: 10302 setLoop: -1 play:)
				(gCurRoom setScript: firstSniper)
			)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (gTimers contains: clickTimer)
			(gCurRoom newRoom: 4999) ; greaseBoard
		else
			(super doVerb: theVerb &rest)
		)
	)

	(method (dispose)
		(ClearFlag 72)
		(proc4_5)
		(interviewTimer dispose: delete:)
		(clickTimer dispose: delete:)
		(super dispose: &rest)
	)
)

(instance firstLeader of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(proc4_6 4054 160 71 0 0 -1 1)
			)
			(1
				(Lock rsAUDIO (gBackMusic number:) 0)
				(gBackMusic number: 10302 loop: -1 play:)
				(if (== (gGame printLang:) 1)
					(Lock rsAUDIO 10302 1)
				)
				(= cycles 1)
			)
			(2
				(proc4_6 4055 160 86 0 0 -1 1)
			)
			(3
				(coco init:)
				(interviewTimer setReal: interviewTimer 5)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance firstSniper of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(proc4_6 40535 159 96)
			)
			(1
				(gCurRoom newRoom: 4999) ; greaseBoard
			)
		)
	)
)

(instance backFromBoardSnipe of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (IsFlag 83)
					(proc4_6 40599 160 94)
				else
					(proc4_6 40598 159 96)
				)
			)
			(1
				(ClearFlag 65)
				(SetFlag 12)
				(gCurRoom newRoom: 1010)
				(self dispose:)
			)
		)
	)
)

(instance consecSniper of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(WalkieTalkie showFrame: 40536 0 160 94)
				(= global128 40536)
				(= cycles 5)
			)
			(1
				(proc4_6 40536 160 94)
			)
			(2
				(gCurRoom newRoom: 4999) ; greaseBoard
				(self dispose:)
			)
		)
	)
)

(instance cocoLeaves of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gGame showCloseUp: 40590 180 66 self)
			)
			(1
				(coco dispose:)
				(proc4_6 4056 160 71 0 0 -1 1)
			)
			(2
				(andy init:)
				(interviewTimer setReal: interviewTimer 5)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance interviewCoco of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(switch (++ global416)
					(1
						(proc4_6 40551 160 86 0 0 -1 1)
					)
					(2
						(proc4_6 40552 160 86 0 0 -1 1)
					)
					(3
						(proc4_6 40553 160 86 0 0 -1 1)
					)
					(4
						(proc4_6 40554 160 86 0 0 -1 1)
					)
					(5
						(proc4_6 40555 160 86 0 0 -1 1)
					)
				)
			)
			(1
				(if (== global416 3)
					(proc4_6 40554 160 86 0 0 -1 1)
					(++ global416)
				else
					(self cue:)
				)
			)
			(2
				(if (== global416 5)
					(andy init:)
					(coco dispose:)
					(proc4_6 4056 160 71 0 0 -1 1)
				else
					(interviewTimer setReal: interviewTimer 5)
					(gGame handsOn:)
					(self dispose:)
				)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance andyOuttaHere of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gGame showCloseUp: 40591 180 66 self 1)
			)
			(1
				(proc4_5)
				(andy dispose:)
				(Palette 2 42 254 100) ; PalIntensity
				(self cue:)
			)
			(2
				(gCurRoom setScript: rookerGatherAround)
			)
		)
	)
)

(instance talkToAndy of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(switch (++ global417)
					(1
						(proc4_6 40561 160 71 0 0 -1 1)
					)
					(2
						(proc4_6 40562 160 71 0 0 -1 1)
					)
					(3
						(= cycles 1)
					)
				)
			)
			(1
				(if (== global417 3)
					(andy dispose:)
					(proc4_6 40563 160 71)
				else
					(interviewTimer setReal: interviewTimer 5)
					(gGame handsOn:)
					(self dispose:)
				)
			)
			(2
				(gCurRoom setScript: rookerGatherAround)
			)
		)
	)
)

(instance rookerGatherAround of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (not (IsFlag 78))
					(Palette 2 42 254 100) ; PalIntensity
					(proc4_6 40564 160 64 0 0 -1 1)
				else
					(self cue:)
				)
			)
			(1
				(if (not (IsFlag 78))
					(Palette 2 42 254 100) ; PalIntensity
					(gGame showCloseUp: 40592 180 66 self 1)
				else
					(self cue:)
				)
			)
			(2
				(if (not (IsFlag 78))
					(Palette 2 42 254 100) ; PalIntensity
				)
				(self cue:)
			)
			(3
				(if (IsFlag 78)
					(proc4_6 40546 160 85 0 0 -1 1)
				else
					(proc4_6 4059 159 85 0 0 -1 1)
				)
			)
			(4
				(clickTimer setReal: clickTimer 4)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance rookerToBoard of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (IsFlag 78)
					(gGame showCloseUp: 40594 180 66 self 1)
				else
					(gGame showCloseUp: 40593 180 66 self 1)
				)
			)
			(1
				(gCurRoom newRoom: 4999) ; greaseBoard
			)
		)
	)
)

(instance backFromBoard of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(proc4_6 40510 160 78)
			)
			(1
				(SetFlag 12)
				(ClearFlag 65)
				(cond
					((and (IsFlag 297) (IsFlag 295) (IsFlag 288))
						(gCurRoom newRoom: 1030)
					)
					((and (IsFlag 297) (IsFlag 295) (not (IsFlag 288)))
						(gCurRoom newRoom: 1510)
					)
					((and (IsFlag 297) (IsFlag 294))
						(gCurRoom newRoom: 1520)
					)
					((and (IsFlag 298) (IsFlag 295))
						(gCurRoom newRoom: 1070)
					)
					((and (IsFlag 298) (IsFlag 294) (IsFlag 288))
						(gCurRoom newRoom: 1100)
					)
					((and (IsFlag 298) (IsFlag 294) (not (IsFlag 288)))
						(gCurRoom newRoom: 1040)
					)
					(else
						(Prints
							{Error: Grease board is confused, it doesn't know where to send you, please report immediately.}
						)
					)
				)
				(self dispose:)
			)
		)
	)
)

(instance rookerVO1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 0 0 38 0 self 405) ; "OK, Pup, I'll get you started. On the board we have a diagram of two buildings. Building one is the main building. Building two is a storage warehouse already cleared this morning by Pauldon's element. It's up to us to clear the main building and secure it. Pup, what did you learn from the Eastman employees about the layout of the main building?"
			)
			(1
				(clickTimer3 setReal: clickTimer3 6)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance rookerVO2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 0 0 49 0 self 405) ; "Go ahead, Pup. Let's hear it. If you have any information, go ahead and mark on the board."
			)
			(1
				(clickTimer3 setReal: clickTimer3 6)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance theBoard of View
	(properties
		modNum 405
		x 441
		y 176
		view 420
	)

	(method (doVerb)
		(cond
			((gFeatures contains: coco)
				(if (gTimers contains: interviewTimer)
					(interviewTimer dispose: delete:)
				)
				(gCurRoom setScript: cocoLeaves)
			)
			((gFeatures contains: andy)
				(if (gTimers contains: interviewTimer)
					(interviewTimer dispose: delete:)
				)
				(gCurRoom setScript: andyOuttaHere)
			)
			(else
				(gCurRoom newRoom: 4999) ; greaseBoard
			)
		)
	)
)

(instance redX of Prop ; UNUSED
	(properties
		x 426
		y 92
		view 4250
		loop 1
	)
)

(instance secondX of Prop ; UNUSED
	(properties
		x 555
		y 257
		view 4250
	)
)

(instance coco of Feature
	(properties
		nsLeft 193
		nsTop 77
		nsRight 331
		nsBottom 256
	)

	(method (doVerb theVerb)
		(switch theVerb
			(29
				(interviewTimer dispose: delete:)
				(gCurRoom setScript: interviewCoco)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance andy of Feature
	(properties
		nsLeft 311
		nsTop 77
		nsRight 410
		nsBottom 256
	)

	(method (doVerb theVerb)
		(switch theVerb
			(29
				(interviewTimer dispose: delete:)
				(gCurRoom setScript: talkToAndy)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance interviewTimer of Timer
	(properties)

	(method (cue)
		(if (gFeatures contains: coco)
			(gCurRoom setScript: cocoLeaves)
		else
			(gCurRoom setScript: andyOuttaHere)
		)
		(self dispose: delete:)
	)
)

(instance clickTimer of Timer
	(properties)

	(method (cue)
		(gGame handsOff:)
		(gCurRoom setScript: rookerToBoard)
		(self dispose: delete:)
	)
)

(instance clickTimer2 of Timer ; UNUSED
	(properties)

	(method (cue)
		(gCurRoom setScript: rookerVO1)
		(self dispose: delete:)
	)
)

(instance clickTimer3 of Timer
	(properties)

	(method (cue)
		(gCurRoom setScript: rookerVO2)
		(self dispose: delete:)
	)
)

