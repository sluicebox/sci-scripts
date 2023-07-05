;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 997)
(include sci.sh)
(use Main)
(use room1)
(use Interface)
(use Gauge)
(use Save)
(use User)

(public
	proc997_1 1
	proc997_2 2
)

(local
	local0
	local1
	[local2 4] = [136 133 129 127]
	local6
	local7
	local8
	local9 = 35
)

(procedure (localproc_0)
	(if global427
		(SetMenu 770 110 {Turn Messages Off})
	else
		(SetMenu 770 110 {Turn Messages On})
	)
)

(procedure (localproc_1)
	(gGame setCursor: 999 1)
	(User controls: 1)
	(= local0 1)
)

(procedure (proc997_1 &tmp temp0 temp1 temp2)
	(if (GetMenu 1025 112)
		(if global510
			(= temp0 (GetMenu 513 112))
			(= temp1 (User controls:))
			(= temp2 gTheCursor)
			(localproc_1)
			(= local0 0)
			(= global59 local1)
			(if (not global502)
				(gTheWalker hide:)
				(if (IsObject gNotice)
					(gNotice hide:)
				)
				(proc0_1)
			)
			(proc0_15 global502 291)
			((ScriptID 231 0) init: gCurRoom) ; inventories
			(if global502
				(global502 draw:)
			else
				(proc1_8)
				(gTheWalker show:)
				(if (IsObject gNotice)
					(gNotice show:)
				)
			)
			(if temp0
				(proc0_8)
			)
			(User controls: temp1)
			(gGame setCursor: temp2 1)
		else
			(Print 997 11 #time (if (< global426 5) 5 else global426)) ; "Another Statistics Screen is not allowed."
		)
	)
)

(procedure (proc997_2 &tmp temp0 temp1 temp2)
	(if (GetMenu 1026 112)
		(if global509
			(= temp0 (GetMenu 513 112))
			(= temp1 (User controls:))
			(= temp2 gTheCursor)
			(localproc_1)
			(= local0 0)
			(= global59 local1)
			(if (not global502)
				(gTheWalker hide:)
				(if (IsObject gNotice)
					(gNotice hide:)
				)
				(proc0_1)
			)
			(proc0_15 global502 291)
			((ScriptID 238 0) init:) ; viewGoals
			(if global502
				(global502 draw:)
			else
				(proc1_8)
				(gTheWalker show:)
				(if (IsObject gNotice)
					(gNotice show:)
				)
			)
			(if temp0
				(proc0_8)
			)
			(User controls: temp1)
			(gGame setCursor: temp2 1)
		else
			(Print 997 12 #time (if (< global426 5) 5 else global426)) ; "Another Goals Screen is not allowed."
		)
	)
)

(class MenuBar of MenuBar
	(properties)

	(method (init)
		(AddMenu { \01 } {About JONES `#0:Help `#1})
		(AddMenu
			{ Game }
			{Save Game`#5:Set Save Directory `^Y:Restore Game`#7:--!:Quit `^Q:Restart `#9}
		)
		(AddMenu
			{ Options }
			{Change Reading Speed `^R:Turn Messages Off `#8:Delete Current Player `^Z:Change Animation Speed `^S:Graphics Detail Level `^T :--!:Change Volume `^V:Turn Music Off `#2:Turn Sound Effects Off `#3}
		)
		(AddMenu { Status } {Statistics`#4:Goals`#6})
		(SetMenu 771 112 0)
		(SetMenu 513 112 0)
		(SetMenu 515 112 0)
		(SetMenu 1025 112 0)
		(SetMenu 1026 112 0)
	)

	(method (handleEvent event &tmp temp0 temp1 [temp2 2] temp4 temp5 temp6 temp7 temp8 temp9)
		(= local1 global59)
		(= global59 gBubbleWindow)
		(= temp7 gTheCursor)
		(= temp5 (User controls:))
		(cond
			(
				(and
					(not (event claimed:))
					global439
					(or (== (event type:) evMOUSERELEASE) (== (event type:) evMOUSEBUTTON))
					(& (event modifiers:) emCTRL)
				)
				(event claimed: 1)
				(if (== (event type:) evMOUSERELEASE)
					(proc997_2)
				)
			)
			(
				(and
					(not (event claimed:))
					global439
					(or (== (event type:) evMOUSERELEASE) (== (event type:) evMOUSEBUTTON))
					(& (event modifiers:) emSHIFT)
				)
				(event claimed: 1)
				(if (== (event type:) evMOUSERELEASE)
					(proc997_1)
				)
			)
			(else
				(switch (= temp1 (super handleEvent: event))
					(257
						(localproc_1)
						(proc0_17 0)
						(Print
							(Format @global100 997 0 gVersion) ; "JONES IN THE FAST LANE Additional Programmers: Sol Ackerman, David Slayback Additional Artists: Mike Milo, Dave Willardson, Calvin Patton, Version %s"
							#font
							4
							#width
							160
							#mode
							1
							#button
							{Next}
							1
						)
						(Print
							(Format @global100 997 1) ; "JONES IN THE FAST LANE Development System: Jeff Stephenson, Robert Heitman, Pablo Ghenis, John Hartin, Dan Foy, Larry Scott, Mark Hood, John Rettig Corey Cole, Eric Hart. Sound Effects: Ken Allen Dialogue: Josh Mandel Sol Ackerman, Warren Schwader"
							#font
							4
							#width
							160
							#mode
							1
							#button
							{OK}
							1
						)
						(proc0_17 global514)
					)
					(258
						(localproc_1)
						(proc0_17 0)
						(Print
							(Format @global100 997 2) ; "JONES IN THE FAST LANE F1 - Help - This screen F2 - Music on/off F3 - Sound Effects on/off F4 - Current Player's Statistics F5 - Saves the current game F6 - View Goals Screens F7 - Restores the saved game F8 - Non-essential messages on/off F9 - Restarts the game F10- About Jones"
							#font
							4
							#width
							170
							#mode
							0
							#button
							{Next}
							1
						)
						(Print
							(Format @global100 997 3) ; "JONES IN THE FAST LANE Ctrl-Q - Quit Ctrl-R - Change Reading Speed Ctrl-S - Change Speed Ctrl-T - Set Graphics Detail Level Ctrl-V - Change Volume Ctrl-Y - Set Save Directory Ctrl-Z - Delete a Player Esc  - Menu Bar/Pauses Game Left Mouse - Select Middle Mouse/CTRL-Left - Goals Right Mouse/SHIFT-Left - Statistics"
							#font
							4
							#width
							160
							#mode
							0
							#button
							{OK}
							1
						)
						(proc0_17 global514)
					)
					(518
						(localproc_1)
						(proc0_17 0)
						(if (Print 997 4 #button {Yes} 1 #button {No} 0) ; "Restarting?"
							(gASoundEffect play: 23)
							(= global528 1)
						else
							(gASoundEffect play: 23)
						)
						(proc0_17 global514)
					)
					(517
						(localproc_1)
						(proc0_17 0)
						(= gQuit (Print 997 5 #button {YES} 1 #button {NO} 0)) ; "Quitting?"
						(gASoundEffect play: 23)
						(proc0_17 global514)
					)
					(513
						(localproc_1)
						(proc0_17 0)
						(if (Print 997 6 #button {YES} 1 #button {NO} 0 #width 180) ; "Saving a game will overwrite a previously saved game. Continue?"
							(Load rsCURSOR 997)
							(gGame save:)
						)
						(proc0_17 global514)
					)
					(514
						(localproc_1)
						(proc990_2 gCurSaveDir)
					)
					(515
						(localproc_1)
						(proc0_17 0)
						(if (Print 997 7 #button {YES} 1 #button {NO} 0 #width 150) ; "Restore a saved game?"
							(= global481 0)
							(= global529 1)
						)
						(proc0_17 global514)
					)
					(769
						(localproc_1)
						(= global426
							(= temp4
								((Gauge new:)
									description: {Change reading speed.}
									text: {Reading Speed}
									minimum: 2
									normal: 5
									maximum: 15
									higher: {More Time}
									lower: {Less Time}
									doit: global426
								)
							)
						)
					)
					(770
						(localproc_1)
						(proc0_17 0)
						(if (= global427 (- 1 global427))
							(Print ; "Non-essential messages ON."
								997
								8
								#time
								(if (< global426 5) 5 else global426)
							)
						else
							(Print ; "Non-essential messages OFF."
								997
								9
								#time
								(if (< global426 5) 5 else global426)
							)
						)
						(proc0_17 global514)
						(localproc_0)
					)
					(771
						(localproc_1)
						(for
							((= temp0 (= temp8 0)))
							(< temp0 ((ScriptID 1 2) size:)) ; players
							((++ temp0))
							
							(if (not (((ScriptID 1 2) at: temp0) finishStatus:)) ; players
								(++ temp8)
							)
						)
						(if (> temp8 1)
							(= local6 global513)
							(= local7 global511)
							(= local8 global512)
							(if global535
								(= global513 (+ 9 (global302 whichBody:)))
								(= global512 [local2 (global302 whichBody:)])
							)
							(= global511 0)
							(if
								(Print ; "Delete this player?"
									997
									10
									#button
									{YES}
									1
									#button
									{NO}
									0
									#icon
									(gTheWalker view:)
									(gTheWalker loop:)
									(gTheWalker cel:)
								)
								(= global513 local6)
								(= global511 local7)
								(= global512 local8)
								(if (== temp8 2)
									(SetMenu 771 112 0)
								)
								(= global521 global302)
								(= global323 60)
								(if (not global502)
									(proc1_9)
								)
							else
								(= global513 local6)
								(= global511 local7)
								(= global512 local8)
							)
						)
					)
					(772
						(localproc_1)
						(= temp4
							((Gauge new:)
								description: {Change animation speed.}
								text: {Game Speed}
								minimum: 1
								normal: 6
								maximum: 6
								higher: {Faster}
								lower: {Slower}
								doit: (- 7 ((ScriptID 1 7) ticksToDo:)) ; marble
							)
						)
						((ScriptID 1 7) ; marble
							ticksToDo: (- 7 temp4)
							moveSpeed: (- 7 temp4)
						)
						(if ((ScriptID 1 7) mover:) ; marble
							(((ScriptID 1 7) mover:) b-moveCnt: 0) ; marble
						)
						(if ((ScriptID 1 7) cycler:) ; marble
							(((ScriptID 1 7) cycler:) ticksToDo: (- 7 temp4)) ; marble
						)
						(= global475 (* (- 7 temp4) 14))
					)
					(775
						(localproc_1)
						(= global520
							((Gauge new:)
								description: {Change sound volume.}
								text: {Sound Volume}
								minimum: 0
								normal: 12
								maximum: 15
								higher: {Louder}
								lower: {Softer}
								doit: global520
							)
						)
						(DoSound sndMASTER_VOLUME global520)
					)
					(776
						(localproc_1)
						(gASong toggle:)
					)
					(777
						(localproc_1)
						(gASoundEffect toggle:)
					)
					(773
						(localproc_1)
						(= temp6
							((Gauge new:)
								description: {Change graphics detail level.}
								text: {Graphic Detail}
								minimum: 1
								normal: 4
								maximum: 4
								higher: {More Detail}
								lower: {Less Detail}
								doit: (- 4 global534)
							)
						)
						(= global534 (- 4 temp6))
					)
					(1025
						(if global439
							(proc997_1)
							(event claimed: 1)
						)
					)
					(1026
						(if global439
							(proc997_2)
							(event claimed: 1)
						)
					)
				)
			)
		)
		(= global59 local1)
		(if local0
			(= local0 0)
			(User controls: temp5)
			(gGame setCursor: temp7 1)
		)
	)
)

