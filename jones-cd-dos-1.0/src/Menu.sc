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
	proc997_3 3
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

(procedure (proc997_3)
	(if global427
		(SetMenu 774 110 {Turn Messages Off})
	else
		(SetMenu 774 110 {Turn Messages On})
	)
)

(procedure (localproc_0)
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
			(localproc_0)
			(= local0 0)
			(= global38 local1)
			(if (not global502)
				(gTheWalker hide:)
				(if (IsObject gNotice)
					(gNotice hide:)
				)
				(proc0_1)
			)
			(proc0_15 global502 294)
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
			(Print 997 16 #time (if (< global426 5) 5 else global426)) ; "Another Statistics Screen is not allowed."
		)
	)
)

(procedure (proc997_2 &tmp temp0 temp1 temp2)
	(if (GetMenu 1026 112)
		(if global509
			(= temp0 (GetMenu 513 112))
			(= temp1 (User controls:))
			(= temp2 gTheCursor)
			(localproc_0)
			(= local0 0)
			(= global38 local1)
			(if (not global502)
				(gTheWalker hide:)
				(if (IsObject gNotice)
					(gNotice hide:)
				)
				(proc0_1)
			)
			(proc0_15 global502 294)
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
			(Print 997 17 #time (if (< global426 5) 5 else global426)) ; "Another Goals Screen is not allowed."
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
			{Delete Current Player `^Z:Change Animation Speed `^S:Graphics Detail Level `^T :--!:Change Volume `^V:Turn Messages Off `#8}
		)
		(AddMenu { Status } {Statistics`#4:Goals`#6})
		(SetMenu 769 112 0)
		(SetMenu 513 112 0)
		(SetMenu 515 112 0)
		(SetMenu 1025 112 0)
		(SetMenu 1026 112 0)
		(proc997_3)
	)

	(method (handleEvent event &tmp temp0 temp1 [temp2 2] temp4 temp5 [temp6 10] temp16 temp17 temp18 temp19)
		(= local1 global38)
		(= global38 gBubbleWindow)
		(= temp17 gTheCursor)
		(= temp5 (User controls:))
		(cond
			(
				(and
					(not (event claimed:))
					global439
					(or (& (event type:) evMOUSERELEASE) (& (event type:) evMOUSEBUTTON))
					(& (event modifiers:) emCTRL)
				)
				(event claimed: 1)
				(if (& (event type:) evMOUSERELEASE)
					(proc997_2)
				)
			)
			(
				(and
					(not (event claimed:))
					global439
					(or (& (event type:) evMOUSERELEASE) (& (event type:) evMOUSEBUTTON))
					(& (event modifiers:) emSHIFT)
				)
				(event claimed: 1)
				(if (& (event type:) evMOUSERELEASE)
					(proc997_1)
				)
			)
			(else
				(switch (= temp1 (super handleEvent: event))
					(257
						(localproc_0)
						(proc0_17 0)
						(Print
							(Format @global100 997 0 @global539) ; "JONES IN THE FAST LANE Version %s"
							#font
							4
							#mode
							1
							#width
							150
						)
						(Print (Format @global100 997 1) #font 4 #mode 1 #width 150) ; "ADDITIONAL ARTISTS: Phyllis Cucchiara Jerry Jessurun Dave Willardson Calvin Patton Richard Powell Jennifer Shontz"
						(Print (Format @global100 997 2) #font 4 #mode 1 #width 150) ; "ADDITIONAL PROGRAMMER: David Slayback  COMPOSER: Ken Allen"
						(Print (Format @global100 997 3) #font 4 #mode 1 #width 150) ; "SYSTEM DEVELOPMENT: Jeff Stephenson Robert E. Heitman Chris Smith Dan Foy Eric Hart J. Mark Hood Mark Wilden"
						(Print (Format @global100 997 4) #font 4 #mode 1 #width 150) ; "SOUND EFFECTS: Ken Allen  DIALOGUE: Josh Mandel Warren Schwader"
						(Print (Format @global100 997 5) #font 4 #mode 1 #width 150) ; "AUDIO TECHNICIAN Orpheus Hanley  QUALITY ASSURANCE: Sharon Smith Sharon Simmons"
						(proc0_17 global514)
					)
					(258
						(localproc_0)
						(proc0_17 0)
						(Print (Format @global100 997 6) #font 4 #width 160 #mode 0) ; "F1 - Help - This screen F4 - Current Player's Stats F5 - Saves the current game F6 - View Goals Screens F7 - Restores the saved game F8 - Non-essential messages F9 - Restarts the game F10- About Jones"
						(Print (Format @global100 997 7) #font 4 #width 160 #mode 0) ; "Ctrl-Q - Quit Ctrl-S - Change Speed Ctrl-T - Graphics Detail Level Ctrl-V - Change Volume Ctrl-Y - Set Save Directory Ctrl-Z - Delete a Player Esc  - Menu Bar/Pauses Game Left Mouse - Select Middle Mouse/CTRL-Left - Goals Right Mouse/SHIFT-Left - Stats"
						(proc0_17 global514)
					)
					(518
						(localproc_0)
						(proc0_17 0)
						(if (Print 997 8 #button {Yes} 1 #button {No} 0) ; "Restarting?"
							(gASoundEffect play: 23)
							(= global528 1)
							(Format @temp6 997 9 global534 global427) ; "%d%d"
							(MemorySegment 0 @temp6 0) ; MS_SAVE_FROM
						else
							(gASoundEffect play: 23)
						)
						(proc0_17 global514)
					)
					(517
						(localproc_0)
						(proc0_17 0)
						(= gQuit (Print 997 10 #button {YES} 1 #button {NO} 0)) ; "Quitting?"
						(gASoundEffect play: 23)
						(proc0_17 global514)
					)
					(513
						(localproc_0)
						(proc0_17 0)
						(if (Print 997 11 #button {YES} 1 #button {NO} 0 #width 180) ; "Saving a game will overwrite a previously saved game. Continue?"
							(Load rsCURSOR 997)
							(gGame save:)
						)
						(proc0_17 global514)
					)
					(514
						(localproc_0)
						(proc990_2 gLocales)
					)
					(515
						(localproc_0)
						(proc0_17 0)
						(if (Print 997 12 #button {YES} 1 #button {NO} 0 #width 150) ; "Restore a saved game?"
							(= global481 0)
							(= global529 1)
						)
						(proc0_17 global514)
					)
					(769
						(localproc_0)
						(for
							((= temp0 (= temp18 0)))
							(< temp0 ((ScriptID 1 2) size:)) ; players
							((++ temp0))
							
							(if (not (((ScriptID 1 2) at: temp0) finStat:)) ; players
								(++ temp18)
							)
						)
						(if (> temp18 1)
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
									13
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
								(if (== temp18 2)
									(SetMenu 769 112 0)
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
					(770
						(localproc_0)
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
					(773
						(localproc_0)
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
					(774
						(localproc_0)
						(proc0_17 0)
						(if (< global427 0)
							(= global427 0)
						)
						(if (> global427 1)
							(= global427 1)
						)
						(if (= global427 (- 1 global427))
							(Print ; "Non-essential messages ON."
								997
								14
								#time
								(if (< global426 5) 5 else global426)
							)
						else
							(Print ; "Non-essential messages OFF."
								997
								15
								#time
								(if (< global426 5) 5 else global426)
							)
						)
						(proc0_17 global514)
						(proc997_3)
					)
					(771
						(localproc_0)
						(if (< (- 4 global534) 0)
							(= global534 3)
						)
						(if (> (- 4 global534) 3)
							(= global534 0)
						)
						(= temp16
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
						(= global534 (- 4 temp16))
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
		(= global38 local1)
		(if local0
			(= local0 0)
			(User controls: temp5)
			(gGame setCursor: temp17 1)
		)
		(DoAudio audRESUME)
	)
)

