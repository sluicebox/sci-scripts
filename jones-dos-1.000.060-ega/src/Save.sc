;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 990)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use User)

(public
	proc990_0 0
	proc990_1 1
	proc990_2 2
	proc990_3 3
)

(procedure (proc990_0 &tmp [temp0 2] temp2 temp3 [temp4 112] temp116 temp117)
	(= temp116 (User controls:))
	(= temp117 gTheCursor)
	(gGame setCursor: 999 1)
	(User controls: 1)
	(= temp3 (Sound pause: 1))
	(if (proc990_3 1)
		(if gModelessDialog
			(gModelessDialog dispose:)
		)
		(= temp2 (gGame setCursor: gWaitCursor 1))
		(if (not (SaveGame (gGame name:) 1 (gGame name:) gVersion))
			(Print 990 0 #font 0 #width 250 #button {OK} 1) ; "The disk is full. You must use another disk. Save Aborted."
			(gGame setCursor: temp2 (HaveMouse))
		else
			(gGame setCursor: temp2 (HaveMouse))
			(Print 990 1 #time global426) ; "The game has been saved."
		)
		(proc990_3 0)
	)
	(Sound pause: temp3)
	(gGame setCursor: temp117 1)
	(User controls: temp116)
)

(procedure (proc990_1 &tmp temp0 temp1 [temp2 100] [temp102 12] [temp114 40] [temp154 40] temp194 temp195)
	(= temp194 (User controls:))
	(= temp195 gTheCursor)
	(gGame setCursor: 999 1)
	(User controls: 1)
	(= temp0 (gGame setCursor: gNormalCursor))
	(= temp1 (Sound pause: 1))
	(if (proc990_3 1)
		(if gModelessDialog
			(gModelessDialog dispose:)
		)
		(if (GetSaveFiles (gGame name:) @temp2 @temp102)
			(gGame setCursor: gWaitCursor 1)
			(if (CheckSaveGame (gGame name:) 1 gVersion)
				(if (RestoreGame (gGame name:) 1 gVersion)
					(= global533 0)
				)
			else
				(Print 990 2 #font 0 #button {OK} 1 #width 200) ; "The saved game was saved under a different interpreter. It cannot be restored."
				(gGame setCursor: temp0 (HaveMouse))
			)
		else
			(Print (Format @temp114 990 3 @temp154) #button {OK} 1 #width 150 #font 0) ; "Can't Restore. No previously saved game was found."
		)
		(proc990_3 0)
	)
	(Sound pause: temp1)
	(gGame setCursor: temp195 1)
	(User controls: temp194)
)

(procedure (proc990_2 param1 &tmp temp0 [temp1 33] [temp34 40])
	(repeat
		(if
			(not
				(= temp0
					(Print ; "New save-game directory:"
						990
						4
						#font
						0
						#edit
						(StrCpy @temp1 param1)
						29
						#button
						{OK}
						1
						#button
						{Cancel}
						0
						#width
						200
					)
				)
			)
			(return 0)
		)
		(if (not (StrLen @temp1))
			(GetCWD @temp1)
		)
		(if (ValidPath @temp1)
			(StrCpy param1 @temp1)
			(return 1)
		else
			(Print (Format @temp34 990 5 @temp1) #font 0 #width 200) ; "%s is not a valid directory"
		)
	)
)

(procedure (proc990_3 param1 &tmp temp0 [temp1 40] [temp41 40] [temp81 100])
	(= temp0 1)
	(DeviceInfo diGET_DEVICE gCurSaveDir @temp1)
	(DeviceInfo diGET_CURRENT_DEVICE @temp41)
	(if (and (DeviceInfo diPATHS_EQUAL @temp1 @temp41) (DeviceInfo diIS_FLOPPY @temp41))
		(Format @temp81 990 6 (if param1 {SAVE GAME} else {GAME}) @temp41) ; "Please insert your %s disk in drive %s."
		(if
			(==
				(= temp0
					(if param1
						(Print
							@temp81
							#button
							{OK}
							1
							#button
							{Cancel}
							0
							#button
							{Change Directory}
							2
							#width
							250
							#font
							0
						)
					else
						(Print @temp81 #button {OK} 1 #width 150 #font 0)
					)
				)
				2
			)
			(= temp0 (proc990_2 gCurSaveDir))
		)
	)
	(return temp0)
)

