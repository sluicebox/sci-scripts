;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 22)
(include sci.sh)
(use Main)
(use Interface)
(use File)
(use Game)
(use User)
(use System)

(public
	rm22 0
)

(instance rm22 of Locale
	(properties)

	(method (handleEvent event &tmp temp0 [temp1 3] [temp4 30] [temp34 30] [temp64 30])
		(if (or (not (TestFlag 14)) (event claimed:))
			(return)
		)
		(switch (event type:)
			(evKEYBOARD
				(switch (event message:)
					(KEY_ALT_c
						(Show 4)
						(Animate (gCast elements:) 0)
						(while (== evNULL ((= event (Event new:)) type:))
							(event dispose:)
						)
						(event dispose:)
						(Show 1)
						(return)
					)
					(KEY_ALT_d
						(SetDebug)
					)
					(KEY_ALT_i
						(User canInput: 1)
					)
					(KEY_ALT_m
						(gGame showMem:)
					)
					(KEY_ALT_n
						(= temp34 0)
						(= temp64 0)
						(= temp0 1)
						(++ gNoteCounter)
						(while
							(GetInput
								@temp64
								40
								{Press "Enter" or "ESC" when done.}
							)
							(Format @temp4 22 0 (gGame name:) @gInitialsBuffer) ; "Note%s.%s"
							(Format ; ";[%3d %s %6s %3s %3d %2d %3d %3d/%3d]"
								@temp34
								22
								1
								gCurRoomNum
								gVersion
								@gDateBuffer
								@gInitialsBuffer
								gNoteCounter
								temp0
								(gEgo view:)
								(gEgo x:)
								(gEgo y:)
							)
							(gamefile_sh
								name: @temp4
								write: @temp34 @temp64 {\0d\n}
								close:
							)
							(= temp64 0)
							(++ temp0)
						)
					)
					(KEY_ALT_p
						(Show 2)
					)
					(KEY_ALT_r
						(Print (Format @temp4 22 2 gCurRoomNum)) ; "You are currently enthusiastically enjoying room %d."
					)
					(KEY_ALT_v
						(Show 1)
					)
					(KEY_ALT_x
						(= gQuit 1)
					)
					(KEY_ALT_z
						(= gQuit 1)
					)
					(KEY_CAPITAL
						(= temp0 (GetNumber {Teleport to}))
						(if (Load rsSCRIPT temp0)
							(NormalEgo)
							(gCurRoom newRoom: temp0)
						else
							(Print 22 3) ; "What room was that supposed to be?"
							(SetDebug)
						)
					)
					(JOY_DOWN
						(Print
							(Format
								@temp4
								{view %d loop %d cel %d posn %d %d pri %d OnControl $%x Origin on $%x}
								(gEgo view:)
								(gEgo loop:)
								(gEgo cel:)
								(gEgo x:)
								(gEgo y:)
								(gEgo priority:)
								(gEgo onControl:)
								(gEgo onControl: 1)
							)
							#icon
							(gEgo view:)
							(gEgo loop:)
							(gEgo cel:)
						)
					)
					(JOY_UPLEFT
						(gGame showMem:)
					)
				)
			)
			(evSAID
				(if (Said 'tp')
					(= temp0 (GetNumber {Teleport to}))
					(if (Load rsSCRIPT temp0)
						(NormalEgo)
						(gCurRoom newRoom: temp0)
					else
						(Print 22 3) ; "What room was that supposed to be?"
						(SetDebug)
					)
				)
			)
		)
		(if (not (event claimed:))
			(super handleEvent: event)
		)
	)
)

