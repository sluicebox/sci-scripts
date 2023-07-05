;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 997)
(include sci.sh)
(use Main)
(use Interface)
(use User)

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
		(= global74 30)
	)

	(method (handleEvent event &tmp [temp0 2] temp2 [temp3 200] temp203)
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
			(513
				(if (and (= temp2 (StrAt gCurSaveDir 0)) (ValidPath gCurSaveDir))
					(if (and (!= temp2 97) (!= temp2 65))
						(StrAt gCurSaveDir 2 0)
					)
					(gGame save:)
				else
					(if temp2
						(DeviceInfo diGET_CURRENT_DEVICE @temp3)
						(ValidPath @temp3)
					)
					(= temp203 (DButton font:))
					(DButton font: 301)
					(if
						(Print ; "\b1\b7\d7\d2\d9?"
							997
							3
							#mode
							1
							#font
							301
							#button
							{\ca\b2}
							0
							#button
							{\c2\c2\de\b9\d9!!}
							1
						)
						(DButton font: temp203)
						(return)
					)
					(StrAt gCurSaveDir 0 0)
				)
				(DButton font: temp203)
				(TheMenuBar state: 0)
				(gCast eachElementDo: #dispose)
				(for ((= global108 100)) (>= global108 0) ((-= global108 8))
					(Palette palSET_INTENSITY 0 255 global108)
					(Wait 2)
				)
				(Animate (gCast elements:) 0)
				(= global129 0)
				(= global176 1)
				(= global113 100)
				(gCurRoom newRoom: 90) ; intro
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
				(if (== global169 1)
					(if (== (mod global114 2) 0)
						(= global169 (DoAudio audLANGUAGE 81))
					else
						(= global169 (DoAudio audLANGUAGE 181))
					)
				else
					(= global169 (DoAudio audLANGUAGE 1))
				)
			)
		)
	)
)

