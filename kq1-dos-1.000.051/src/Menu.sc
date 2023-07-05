;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 997)
(include sci.sh)
(use Main)
(use Interface)
(use StopWalk)
(use DCIcon)
(use Gauge)
(use Motion)
(use User)
(use System)

(procedure (localproc_0 param1)
	(if (> argc 1)
		(Format (User inputLineAddr:) &rest)
	)
	(param1 claimed: 0 type: 4 message: (User echo:))
)

(class MenuBar of MenuBar
	(properties)

	(method (init)
		(AddMenu { \01 } { About KQI`^a: Help`#1 })
		(AddMenu
			{ File }
			{ Save Game`#5: Restore Game`#7: --!: Restart Game`#9: Quit`^q }
		)
		(AddMenu
			{ Action }
			{ Duck`#4: Jump`#6: --!: Pause Game`^p: Inventory`^I: Retype`#3 }
		)
		(AddMenu { Speed } { Change...`^s: --!: Faster`+: Normal`=: Slower`- })
		(AddMenu
			{ Sound }
			(if (DoSound sndSET_SOUND)
				{ Volume...`^v: Turn sound Off`#2=1 }
			else
				{ Volume...`^v: Turn sound On`#2=0 }
			)
		)
		(SetMenu 258 109 'aid[<!*][/!*]')
		(SetMenu 513 109 'save[/game]')
		(SetMenu 514 109 'restore[/game]')
		(SetMenu 516 109 'restart[/game]')
		(SetMenu 517 109 'quit[/game]')
		(SetMenu 772 109 'pause[/game]')
		(SetMenu 769 109 'duck')
		(SetMenu 770 109 'jump[<!*][/!*]')
		(SetMenu 773 109 'inventory')
		(SetMenu 1028 109 'normal')
	)

	(method (handleEvent event &tmp temp0 temp1 temp2 [temp3 300])
		(switch (super handleEvent: event (User blocks:))
			(257
				(Print
					(Format @temp3 997 0 gVersion) ; "King's Quest I SCI Designed by: Roberta Williams Version %s Copyright 1990 Sierra On-Line, Inc."
					#mode
					1
					#width
					180
					#font
					gSmallFont
					#at
					-1
					20
				)
				(Print
					(Format @temp3 997 1) ; "King's Quest I SCI Illustrated by: JEFF CROWE, CINDY WALKER and JENNIFER SHONTZ Programmed by: JERRY SHAW, GARY KAMIGAWACHI RANDY MACNEILL, RAOUL SAID, CHAD BYE, OLIVER BRELSFORD and MARK WILDEN Original Music by: KEN ALLEN"
					#mode
					1
					#width
					180
					#font
					gSmallFont
					#at
					-1
					20
				)
				(Print
					(Format @temp3 997 2) ; "King's Quest I SCI Development System by: JEFF STEPHENSON, ROBERT E. HEITMAN, PABLO GHENIS, JOHN HARTIN, DAN FOY, LARRY SCOTT, JOHN RETTIG, CORINNA ABDUL, COREY COLE, MARK HOOD and ERIC HART Quality Assurance by: CHRIS CARR and the rest of the gang."
					#mode
					1
					#width
					180
					#font
					gSmallFont
					#at
					-1
					20
				)
			)
			(258
				(Print 997 3 #font gSmallFont) ; "DURING THE GAME: ESC opens and closes the menus,  which show additional shortcuts. IN DIALOG WINDOWS: Your current choice is outlined. Tab and Shift-Tab move between  choices. ESC always cancels. IN TYPING WINDOWS: Arrows, Home, and End move the  cursor. Ctrl-C clears the line."
			)
			(513
				(gGame save:)
			)
			(514
				(gGame restore:)
			)
			(516
				(if
					(Print ; "Shall we really begin the adventure from the very beginning?"
						997
						4
						#title
						{Restart}
						#font
						0
						#icon
						movingIcon
						#button
						{Restart}
						1
						#button
						{Oops}
						0
					)
					(gGame restart:)
				)
			)
			(517
				(= gQuit
					(Print ; "Dost thou truly wish to cease our adventuring?"
						997
						5
						#title
						{Quit}
						#font
						0
						#icon
						movingIcon
						#button
						{Quit}
						1
						#button
						{Oops}
						0
					)
				)
			)
			(769
				(cond
					(global130
						(Print 997 6) ; "You are unable to duck here."
					)
					((GetMenu 769 113)
						((gCurRoom script:) cue:)
					)
					((gCurRoom script:)
						(PrintTooBusy)
					)
					((IsFlag 1)
						(Print 997 7) ; "You have no reason to duck - nobody can see you while you're invisible."
					)
					(else
						(gCurRoom setScript: duckScript)
					)
				)
			)
			(770
				(cond
					((or (== gCurRoomNum 12) (== gCurRoomNum 49))
						(event claimed: 0 type: evSAID)
						(Parse {jump} event)
						(gCurRoom handleEvent: event)
						(if (not (event claimed:))
							(gCurRoom setScript: jumpEgo)
							(event claimed: 1)
						)
					)
					(global130
						(Print 997 8) ; "You can't jump here."
					)
					((gCurRoom script:)
						(PrintTooBusy)
					)
					(else
						(gCurRoom setScript: jumpEgo)
					)
				)
			)
			(772
				(Print ; "Very well, I shall wait until you are ready to resume our adventure again."
					997
					9
					#title
					{This game is paused.}
					#font
					0
					#icon
					movingIcon
					#button
					{Let's continue.}
					1
				)
			)
			(773
				(if (u< (MemoryInfo 0) 1550) ; LargestPtr
					(Print 997 10) ; "This is not a good time to rummage through your belongings. Try again a little later."
				else
					(gInventory showSelf: gEgo)
				)
			)
			(774
				(localproc_0 event)
			)
			(1025
				(= temp1 6)
				(if (!= (= temp1 (GetNumber {Speed (1 - 16)?} gSpeed)) -1)
					(gGame setSpeed: (proc0_17 16 temp1 1))
				)
			)
			(1027
				(if (> gSpeed 1)
					(gGame setSpeed: (-- gSpeed))
				)
			)
			(1028
				(gGame
					setSpeed:
						(switch global101
							(0 1)
							(1 3)
							(else 5)
						)
				)
			)
			(1029
				(if (< gSpeed 16)
					(gGame setSpeed: (++ gSpeed))
				)
			)
			(1281
				(= temp1
					((Gauge new:)
						description:
							{Use the mouse or right and left arrow keys to set the sound volume.}
						text: {Sound Volume}
						minimum: 0
						normal: 12
						maximum: 15
						higher: {Louder}
						lower: {Softer}
						doit: (DoSound sndVOLUME)
					)
				)
				(DoSound sndVOLUME temp1)
				(DisposeScript 987)
			)
			(1282
				(if (GetMenu 1282 113)
					(DoSound sndSET_SOUND 0)
					(SetMenu 1282 113 0 110 { Turn sound On})
				else
					(DoSound sndSET_SOUND 1)
					(SetMenu 1282 113 1 110 { Turn sound Off})
				)
			)
		)
	)
)

(instance movingIcon of DCIcon
	(properties
		view 699
		loop 2
	)

	(method (init)
		(super init:)
		(self cycleSpeed: (if (> global101 2) 10 else 6))
	)
)

(instance duckScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(User canControl: 0)
				(gEgo
					view: (if (IsFlag 0) 23 else 16)
					cel: 0
					setCycle: End
					setMotion: 0
				)
				(SetMenu 769 113 1 110 { Stand} 109 'stand')
			)
			(1
				(gEgo setCycle: Beg self)
			)
			(2
				(gEgo
					view:
						(cond
							((IsFlag 1)
								(if (IsFlag 0) 38 else 36)
							)
							((IsFlag 0) 4)
							(else 0)
						)
					setCycle:
						StopWalk
						(cond
							((IsFlag 1)
								(if (IsFlag 0) 39 else 37)
							)
							((IsFlag 0) 7)
							(else 2)
						)
					setMotion: 0
				)
				(User canControl: 1)
				(SetMenu 769 113 0 110 { Duck} 109 'duck')
				(self dispose:)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((super handleEvent: event))
			((== (event type:) evSAID)
				(cond
					((Said 'stand,(get,get<up)')
						(self changeState: 1)
					)
					((Said 'duck')
						(Print 997 11) ; "You are ducking."
					)
					((Said 'look,look')
						(event claimed: 0)
					)
					((Said 'talk,talk')
						(event claimed: 0)
					)
					(else
						(Print 997 12) ; "You'll have to try that when you're on your feet."
						(event claimed: 1)
					)
				)
			)
		)
	)
)

(instance jumpEgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (IsFlag 17)
					(if (IsFlag 1)
						(Print 997 13) ; "As you jump, the ring slips off your finger, and you are visible again."
					else
						(Print 997 14) ; "As you jump, the ring slips off your finger."
					)
					(ClearFlag 1)
					(ClearFlag 17)
					(proc0_8 5)
				)
				(gEgo
					view: (if (IsFlag 0) 17 else 15)
					setLoop: 0
					cel: 0
					setCycle: End self
				)
			)
			(1
				(gEgo setCycle: Beg self)
			)
			(2
				(gEgo
					view:
						(cond
							((IsFlag 1)
								(if (IsFlag 0) 38 else 36)
							)
							((IsFlag 0) 4)
							(else 0)
						)
					setCycle:
						StopWalk
						(cond
							((IsFlag 1)
								(if (IsFlag 0) 39 else 37)
							)
							((IsFlag 0) 7)
							(else 2)
						)
					setMotion: 0
					setLoop: -1
					loop: 2
				)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

