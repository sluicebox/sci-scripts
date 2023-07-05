;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 997)
(include sci.sh)
(use Main)
(use n117)
(use Interface)
(use Sound)
(use Save)
(use User)
(use System)

(public
	proc997_1 1
)

(local
	local0
)

(procedure (localproc_0 param1)
	(if (> argc 1)
		(Format (User inputLineAddr:) &rest)
	)
	(param1 claimed: 0 type: 4 message: (User echo:))
)

(procedure (proc997_1)
	(if global124
		(SetMenu 1283 110 {Sheathe sword})
	else
		(SetMenu 1283 110 {Draw sword})
	)
)

(procedure (localproc_1)
	(if (DoSound sndSET_SOUND)
		(SetMenu 769 113 1 110 {Sound off})
	else
		(SetMenu 769 113 0 110 {Sound on})
	)
)

(procedure (localproc_2)
	(= local0 (Sound pause: 1))
)

(class MenuBar of MenuBar
	(properties)

	(method (init)
		(AddMenu { \01 } {About Camelot`^c:Help`#1})
		(AddMenu
			{ File }
			{Save Game`#5:Restore Game`#7:--!:Restart Game`#9:Quit`^q}
		)
		(AddMenu
			{ Game }
			{Music Off`#2=1:Volume...`^v:--!:Pause Game`^p:Repeat`#3}
		)
		(AddMenu
			{ Speed }
			{Set Speed`^s:Faster`+:Normal`=:Slower`-:--!:Arcade Difficulty...}
		)
		(AddMenu { Action } {Open Purse`^O:--!:Draw Sword`#8})
		(AddMenu
			{ Information }
			{Inventory`^I:--!:Ask about`^a:Ask Merlin`^t:Look at`^l:--!:Show Score}
		)
		(SetMenu 513 109 'save[/game]')
		(SetMenu 514 109 'restore[/game]')
		(SetMenu 516 109 'restart[/game]')
		(SetMenu 517 109 'quit[/game]')
		(SetMenu 772 109 'pause[/game]')
		(SetMenu 1537 109 '/inventory')
		(SetMenu 1283 109 'draw,use/blade' 112 0)
		(SetMenu 1281 109 'open,(look<in)/moneybag' 112 0)
		(localproc_1)
	)

	(method (handleEvent event &tmp temp0 temp1 [temp2 201] temp203 temp204 temp205 temp206 temp207 temp208)
		(= local0 0)
		(= temp203 global59)
		(= global59 SysWindow)
		(= temp0 (super handleEvent: event))
		(if
			(or
				(and (== (event type:) evKEYBOARD) (== (event message:) KEY_F2))
				(== temp0 769)
			)
			(DoSound sndSET_SOUND (not (DoSound sndSET_SOUND)))
			(localproc_1)
		)
		(if (== (self state:) 0)
			(= global59 temp203)
			(return)
		)
		(switch temp0
			(257
				(localproc_2)
				(Print
					(Format @temp2 997 0 gVersion) ; "DESIGNED BY: Christy Marx ILLUSTRATED BY: Peter Ledger & Douglas Herring with Kenn Nishiuye, Jennifer Shontz, Andy Hoyos, and Julian Ledger PROGRAMMED BY: David Slayback, Bob Fischbach, Eric Hart with Jerry Shaw and Doug Oldfield MUSIC BY: Mark Seibert Version %s"
					#title
					{  Conquests of Camelot Credits  }
					#mode
					1
					#width
					200
					#font
					gSmallFont
					#at
					-1
					20
				)
				(Print
					(Format @temp2 997 1) ; "PRODUCER Guruka Singh Khalsa DEVELOPMENT SYSTEM BY: Jeff Stephenson, Robert E. Heitman, Pablo Ghenis QUALITY ASSURANCE BY: Mindy Wynn: QA Team Leader Robin Bradley, Oliver Brelsford, Steve Collier, Tate Deloach, Mike Harian, Dennis Jonathan, Dean Larocca, Sharon Simmons"
					#title
					{  Conquests of Camelot Credits  }
					#mode
					1
					#width
					200
					#font
					gSmallFont
					#at
					-1
					20
				)
			)
			(258
				(localproc_2)
				(if (or (== gCurRoomNum 1) (== gCurRoomNum 3) (== gCurRoomNum 103))
					(Print 997 2 #font gSmallFont) ; "Use arrow keys or mouse to move to a location. Press ENTER or double click on the left button to go to the location."
				else
					(Print 997 3 #font gSmallFont) ; "DURING THE GAME: Click at the top of the screen or press ESC to use the menus. Additional shortcuts are shown there.    IN TYPING WINDOWS: Arrows, Home and End move the cursor, or click anywhere with the mouse. Ctrl-C clears the line.    IN DIALOG WINDOWS: Select the outlined item with <Enter> and use Tab and Shift-Tab to move between choices. Or click with the mouse to select an item. ESC always cancels."
				)
			)
			(513
				(= global59 temp203)
				(gGame save:)
				(return)
			)
			(514
				(= global59 temp203)
				(gGame restore:)
				(return)
			)
			(516
				(localproc_2)
				(if (Print 997 4 #button {Restart} 1 #button {Continue} 0) ; "Do you really want to  restart your game?"
					(gGame restart:)
					(return)
				)
			)
			(517
				(localproc_2)
				(= gQuit
					(Print 997 5 #button {Quit} 1 #button {Continue} 0 #icon 999 2 0) ; "You are retiring, M'Lord?"
				)
			)
			(770
				(localproc_2)
				(= temp1 (GetNumber {Volume (1 - 16)?} (+ 1 (DoSound sndVOLUME))))
				(if (>= 16 temp1 1)
					(-- temp1)
					(Sound pause: local0)
					(DoSound sndVOLUME temp1)
				)
			)
			(772
				(localproc_2)
				(Print 997 6 #title {Game paused} #icon 999 1 0) ; "Press <ENTER> or click mouse to continue the game"
			)
			(773
				(event claimed: 0 type: evKEYBOARD message: (User echo:))
			)
			(1025
				(localproc_2)
				(= temp207 gModelessDialog)
				(= temp208 global62)
				(= gModelessDialog (= global62 0))
				(= temp206
					(Print
						{Game speed:}
						#button
						{Fast}
						2
						#button
						{Medium}
						6
						#button
						{Slow}
						10
						#dispose
					)
				)
				(SetPort global62)
				(= temp205
					(cond
						((< gSpeed 4) 1)
						((< gSpeed 8) 2)
						(else 3)
					)
				)
				(= temp1 (temp206 doit: (temp206 at: temp205)))
				(if (IsObject temp1)
					(= temp1 (temp1 value:))
				)
				(temp206 dispose:)
				(if (>= 16 temp1 1)
					(gGame setSpeed: temp1)
				)
				(= gModelessDialog temp207)
				(= global62 temp208)
			)
			(1030
				(localproc_2)
				(= temp207 gModelessDialog)
				(= temp208 global62)
				(= gModelessDialog (= global62 0))
				(= temp206
					(Print 997 7 #button {Hard} 1 #button {Normal} 2 #button {Easy } 3 #dispose) ; "Arcade Difficulty Level:"
				)
				(SetPort global62)
				(= temp205
					(switch global108
						(2 2)
						(3 3)
						(else 1)
					)
				)
				(= temp1 (temp206 doit: (temp206 at: temp205)))
				(if (IsObject temp1)
					(= temp1 (temp1 value:))
				)
				(temp206 dispose:)
				(if temp1
					(= global108 temp1)
				)
				(= gModelessDialog temp207)
				(= global62 temp208)
			)
			(1026
				(if (> gSpeed 1)
					(gGame setSpeed: (-- gSpeed))
				)
			)
			(1027
				(gGame setSpeed: 6)
			)
			(1028
				(if (< gSpeed 16)
					(gGame setSpeed: (++ gSpeed))
				)
			)
			(1281
				(cond
					((not (gEgo has: 3)) ; purse
						(event claimed: 0)
					)
					((not (User canInput:))
						(event claimed: 1)
					)
					((DoPurse)
						(= global59 temp203)
						(RedrawCast)
						(StrCpy (User inputLineAddr:) {Give Money})
						((= temp204 (Event new:)) type: evSAID claimed: 0)
						(Parse (User inputLineAddr:) temp204)
						(User said: temp204)
						(temp204 dispose:)
						(= global59 SysWindow)
					)
				)
			)
			(1283
				(cond
					(
						(or
							(and (not global124) (not (User canInput:)))
							global125
							(not (IsFlag 3))
						)
						(event claimed: 1)
					)
					((and global80 (not (User canControl:)) (User canInput:))
						(= global59 temp203)
						(RedrawCast)
						(event claimed: 0 type: evSAID)
						(Parse {draw sword} event)
						(gCast eachElementDo: #handleEvent event)
						(if (not (event claimed:))
							(gRegions eachElementDo: #handleEvent event)
						)
						(= global59 SysWindow)
					)
					(global124
						(= global125 2)
					)
					(else
						(= global125 1)
					)
				)
			)
			(1537
				(if (User canInput:)
					(localproc_2)
					(gInventory showSelf: gEgo)
				)
			)
			(1539
				(localproc_0 event {ask about })
			)
			(1540
				(localproc_0 event {ask Merlin about })
			)
			(1541
				(localproc_0 event {look at })
			)
			(1543
				(localproc_2)
				(Print
					(Format @temp2 997 8 global210 global211 global212) ; "%3d/368 Skill Points %3d/293 Wisdom Points  %3d/358 Soul Points"
					80
					{Score}
					82
					999
					3
					0
					33
					4
					81
					{OK}
				)
			)
		)
		(= global59 temp203)
		(Sound pause: local0)
	)
)

