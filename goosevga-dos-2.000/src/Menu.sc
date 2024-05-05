;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 997)
(include sci.sh)
(use Main)
(use Interface)
(use User)

(local
	local0 = {English}
	[local1 5] = [{ German} {__French} {__Spanish} { Japanese} {ENGLISH}]
)

(procedure (localproc_0 param1 param2 &tmp [temp0 40]) ; UNUSED
	(= temp0 0)
	(if (> argc 1)
		(Format @temp0 997 0 param2) ; "%d"
	)
	(return
		(if (GetInput @temp0 10 param1)
			(ReadNumber @temp0)
		else
			-1
		)
	)
)

(class TheMenuBar of MenuBar
	(properties)

	(method (init)
		(AddMenu { \01 } {About game`^a })
		(AddMenu { File } {Kids`#7 :Disk`#5 })
		(AddMenu
			{ Misc }
			{Sound On`#2=0 :Language`l :Sample`#1 :Replay`#3 :Sync Bias`#4 }
		)
		(= global119 1)
		(= global118 1)
		(= gSyncBias 2)
	)

	(method (handleEvent event &tmp [temp0 203])
		(if
			(or
				(== (event type:) evMOUSEBUTTON)
				(== (event type:) evJOYDOWN)
				(and (== (event type:) evKEYBOARD) (== (event message:) KEY_ESCAPE))
			)
			(return)
		)
		(switch (super handleEvent: event (User blocks:))
			(257
				(Print 997 1 #font 3 #mode 1) ; "Mixed - Up Mother Goose by Roberta Williams VGA/CD enhanced by Scott Murphy Chris Smith Mark Crowe Cheryl Sweeney Terry McHenry Chris Iden Chris Hoyt Todd Powers Roger Hardy Version 1.0A"
				(Print 997 2 #mode 1) ; "Made possible in full by the unselfish caring and dedication of Robert E. "Bit God" Heitman. Truly a programmer for the ages and an all around renaissance man."
			)
			(769
				(if (GetMenu 769 113)
					(DoSound sndSET_SOUND 0)
					(SetMenu 769 113 0 110 {Sound on})
				else
					(DoSound sndSET_SOUND 1)
					(SetMenu 769 113 1 110 {Sound off})
				)
			)
			(770
				(Printf 997 3 (+ local0 (* (proc0_12 1) 9))) ; "%s"
			)
		)
	)
)

