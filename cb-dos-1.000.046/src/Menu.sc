;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 997)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Inventory)
(use User)

(public
	proc997_2 2
)

(procedure (proc997_2 param1 &tmp temp0) ; UNUSED
	(= temp0 (GetNumber {Teleport to room:}))
	(param1 newRoom: (if (< temp0 1) 1 else temp0))
)

(procedure (localproc_0)
	(Print 997 7 #font 4 #width 275) ; "Much useful information can be obtained by conversing with the other characters you encounter concerning:   Persons - either living or dead   Character pairings   The Colonel's pets   Objects you see or are carrying Examples:   Ask Lillian about Colonel Dijon.   Tell Ethel about Rudy and Gloria.   Ask Fifi about the dog.   Show the notebook to Clarence.   Give the notebook to Gertrude. Confine your conversation to the topics listed above. DON'T try to converse about general concepts such as:   The Spanish-American War   Real estate development"
)

(class TheMenuBar of MenuBar
	(properties)

	(method (init)
		(= global215 1)
		(AddMenu { \01 } {About Bequest:Help`#1})
		(AddMenu { File } {Save`#5:Restore`#7:-!:Restart`#9:Quit`^q})
		(AddMenu
			{ Action }
			{Pause`^p:Inventory`^i:Retype`#3:Ask about...`^a:Tell about...`^t:Show...`^s:Give...`^g:Look at...`^l}
		)
		(AddMenu { Speed } {Faster`+:Normal`=:Slower`-})
		(AddMenu { Sound } {Volume`^v:-!:Turn Off=1`#2})
		(SetMenu 1283 110 (if (DoSound sndSET_SOUND) {Turn Off} else {Turn On}))
		(SetMenu 258 109 'help[/game]')
		(SetMenu 513 109 'save[/game]')
		(SetMenu 514 109 'restore[/game]')
		(SetMenu 516 109 'restart[/game]')
		(SetMenu 517 109 'quit[/game]')
		(SetMenu 769 109 'pause[/game]')
		(SetMenu 770 109 'inventory')
	)

	(method (handleEvent event &tmp temp0 temp1 [temp2 3] temp5 [temp6 255])
		(= global221 999)
		(gGame setCursor: 999 1)
		(switch (= temp0 (super handleEvent: event))
			(257
				(= temp5 (Sound pause: 1))
				(Print 997 0 #font gSmallFont #at 10 10 #width 290) ; ""The Colonel's Bequest" is different than the so-called "normal" adventure game as it was designed around a story and characters rather than a series of puzzles. You may feel that there is a lack of a "quest." Well, in a way, you're right. There isn't a "quest," as such. Your goal is to get to know the story and the characters; to understand what's going on; and to survive the long night. We feel that "The Colonel's Bequest" is a true interactive STORY rather than a game and every effort was put into giving you the sensation that you are part of the story. "The Colonel's Bequest" will give back what you put into it. If you don't put much effort into playing it you may feel that there isn't much to the game. But you would be wrong! There is a lot to it--but you may have to dig a bit to find it--and to be very observant. "The Colonel's Bequest" will reward those who are determined; who will notice subtleties; who will ask questions; who will probe. Good luck! We truly hope you enjoy it!"
				(Sound pause: temp5)
			)
			(258
				(= temp5 (Sound pause: 1))
				(localproc_0)
				(Sound pause: temp5)
			)
			(513
				(if global190
					(Print 997 1) ; "You cannot save a game right now."
				else
					(gGame save:)
				)
			)
			(514
				(if global190
					(Print 997 2) ; "You cannot restore a game right now."
				else
					(gGame restore:)
				)
			)
			(516
				(= temp5 (Sound pause: 1))
				(if (Print 997 3 #font 0 #button {__Restart__} 1 #button { Continue } 0) ; "Do you wish to start over?"
					(gGame restart:)
				)
				(Sound pause: temp5)
			)
			(517
				(= temp5 (Sound pause: 1))
				(= gQuit
					(Print 997 4 #font 0 #button {____Quit____} 1 #button { Continue } 0) ; "Do you really want to quit?"
				)
				(Sound pause: temp5)
			)
			(769
				(= temp5 (Sound pause: 1))
				(Print 997 5 #font 0 #button {__Continue__} 0) ; "INTERMISSION"
				(Sound pause: temp5)
			)
			(770
				(if (not (HaveMem 2048))
					(Print 997 6) ; "Inventory can not be displayed at this time."
				else
					(= temp5 (Sound pause: 1))
					(Inv showSelf: gEgo)
					(Sound pause: temp5)
				)
			)
			(771
				(event claimed: 0 type: evKEYBOARD message: (User echo:))
			)
			(772
				(event claimed: 0 type: evKEYBOARD message: (User echo:))
				(StrCpy (User inputLineAddr:) {Ask about })
			)
			(773
				(event claimed: 0 type: evKEYBOARD message: (User echo:))
				(StrCpy (User inputLineAddr:) {Tell about })
			)
			(774
				(event claimed: 0 type: evKEYBOARD message: (User echo:))
				(StrCpy (User inputLineAddr:) {Show })
			)
			(775
				(event claimed: 0 type: evKEYBOARD message: (User echo:))
				(StrCpy (User inputLineAddr:) {Give })
			)
			(776
				(event claimed: 0 type: evKEYBOARD message: (User echo:))
				(StrCpy (User inputLineAddr:) {Look at })
			)
			(1025
				(if (> gSpeed 1)
					(gGame setSpeed: (-- gSpeed))
				)
			)
			(1026
				(gGame setSpeed: 6)
			)
			(1027
				(gGame setSpeed: (++ gSpeed))
			)
			(1281
				(if
					(and
						(!= gCurRoomNum 74)
						(!= gCurRoomNum 64)
						(!=
							(= temp1
								(GetNumber {Volume (1 - 16)?} (+ 1 (DoSound sndVOLUME)))
							)
							-1
						)
					)
					(if (< (-- temp1) 0)
						(= temp1 0)
					)
					(if (> temp1 15)
						(= temp1 15)
					)
					(DoSound sndVOLUME temp1)
				)
			)
			(1283
				(if (= temp1 (DoSound sndSET_SOUND))
					(SetMenu 1283 110 {Turn On})
				else
					(SetMenu 1283 110 {Turn Off})
				)
				(DoSound sndSET_SOUND (not temp1))
			)
			(else
				(if global392
					(global392 doit: temp0)
				)
			)
		)
	)
)

