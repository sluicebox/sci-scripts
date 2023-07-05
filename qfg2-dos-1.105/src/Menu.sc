;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 997)
(include sci.sh)
(use Main)
(use n001)
(use n002)
(use _MapLocation)
(use Interface)
(use n940)
(use Save)
(use User)
(use System)

(public
	soundOnOff 0
	LockoutMenus 1
)

(procedure (soundOnOff)
	(if (GetMenu 774 113)
		(DoSound sndSET_SOUND 0)
		(SetMenu 774 113 0 110 {Turn on})
	else
		(DoSound sndSET_SOUND 1)
		(SetMenu 774 113 1 110 {Turn off})
	)
)

(procedure (menuHandled event)
	(if (> argc 1)
		(Format (User inputLineAddr:) &rest)
	)
	(event claimed: 0 type: 4 message: (User echo:))
)

(procedure (showTime &tmp [str 30])
	(FindTime @str)
	(HighPrint @str)
)

(procedure (useCompass &tmp whichWaysUp)
	(if (gEgo has: 23) ; Compass
		(compassWindow back: (Random 0 15))
		(= whichWaysUp
			(cond
				((== gCurRoomNum 665) ; desert
					(if (>= gDesertRoom 5000) 3 else 1)
				)
				((OneOf gCurRoomNum 703 704) ; alleyRas, alleyRoom
					(gCurRoom facingHeading:)
				)
				((gCurRoom respondsTo: #topExit)
					(gCurRoom topExit:)
				)
				((OneOf gCurRoomNum 270 380 480 530 550) 3)
				(
					(OneOf
						gCurRoomNum
						120 ; rmChanger
						161
						170 ; rmPractice
						190
						199
						260
						360
						370
						400
						410
						490
					)
					4
				)
				((OneOf gCurRoomNum 100 112 118 140 271) 2)
				(else 1)
			)
		)
		(Print 997 0 #icon 711 0 (- whichWaysUp 1) #window compassWindow #at 270 0)
	else
		(HighPrint 997 1) ; "You'll have to buy a compass first."
	)
)

(procedure (LockoutMenus lockEm &tmp newState)
	(= newState (if lockEm 0 else 1))
	(SetMenu 513 112 newState)
	(SetMenu 769 112 newState)
	(SetMenu 770 112 newState)
	(SetMenu 771 112 newState)
	(SetMenu 776 112 newState)
	(SetMenu 777 112 newState)
	(SetMenu 1025 112 newState)
	(SetMenu 1026 112 newState)
	(SetMenu 1027 112 newState)
	(SetMenu 1030 112 newState)
	(SetMenu 1281 112 newState)
	(SetMenu 1282 112 newState)
	(SetMenu 1284 112 newState)
	(SetMenu 1285 112 newState)
	(SetMenu 1286 112 newState)
	(SetMenu 1287 112 newState)
	(SetMenu 1289 112 newState)
	(SetMenu 1290 112 newState)
)

(class MenuBar of MenuBar
	(properties)

	(method (init)
		(AddMenu
			{ \01 }
			{About Quest for Glory II`^g:Help`#1:Silly Clowns`^y=0}
		)
		(AddMenu
			{ File }
			{Save Game`#5:Restore Game`#7:--!:Restart Game`#9:Quit`^q}
		)
		(AddMenu
			{ Game }
			{Faster Animation`+:Normal Animation`=:Slower Animation`-:--!:Sound Volume...`^v:Turn Off Sound`#2=1:--!:Arcade Difficulty`#4:Game Detail`#6:Game Time Scale`#8}
		)
		(AddMenu
			{ Action }
			{Cast Spell`^c:Fight`^f:Escape`^e:--!:Pause Game`^p:Repeat`#3}
		)
		(AddMenu
			{ Information }
			{Inventory`^i:Char Sheet`^s:--!:Time/Day`^d:Ask about`^a:Tell about`^t:Look at`^l:--!:Read Map`^r:Compass Heading`^h}
		)
		(SetMenu 513 109 'save[/game]')
		(SetMenu 514 109 'restore[/game]')
		(SetMenu 516 109 'restart[/game]')
		(SetMenu 1029 109 'pause[/game]')
		(SetMenu 770 109 'normal[/speed]')
		(SetMenu 1281 109 '/inventory')
		(SetMenu 1284 109 'show/date,day,time')
		(SetMenu 1289 109 'use,look,look,read,show/map')
		(SetMenu 1290 109 'use,look,look,read,show/compass,bearing')
	)

	(method (handleEvent event &tmp [temp0 3] temp3 temp4 temp5 temp6 temp7 temp8)
		(switch (super handleEvent: event)
			(257
				(ShowCredits)
			)
			(258
				(ShowHelp)
			)
			(259
				(if
					(= temp3
						(PrintD
							80
							{Silly Clowns}
							81
							{Off}
							81
							{On}
							81
							{Auto}
							116
							gSillyClowns
						)
					)
					(= gSillyClowns (- temp3 2))
				)
			)
			(513
				(if (IsFlag 1)
					(gGame save:)
				)
			)
			(514
				(gGame restore:)
			)
			(516
				(PromptRestart)
			)
			(517
				(PromptQuit)
			)
			(769
				(if (> gSpeed 0)
					(gGame setSpeed: (-- gSpeed))
				)
			)
			(770
				(gGame setSpeed: 6)
			)
			(771
				(if (< gSpeed 16)
					(gGame setSpeed: (++ gSpeed))
				)
			)
			(773
				(= temp4 (+ 1 (DoSound sndMASTER_VOLUME)))
				(if (= temp4 (GetNumber {Volume (1 - 16)?} temp4))
					(DoSound sndMASTER_VOLUME (- temp4 1))
				)
			)
			(774
				(soundOnOff)
			)
			(776
				(if
					(= temp3
						(PrintD
							80
							{Arcade Difficulty Level}
							81
							{Easiest}
							81
							{Normal}
							81
							{Hardest}
							116
							(- gArcadeLevel 1)
						)
					)
					(= gArcadeLevel (- temp3 1))
				)
			)
			(777
				(= temp6 {Low})
				(= temp7 {Medium})
				(= temp8 {High})
				(switch gDftHowFast
					(0
						(= temp6 {Optimal})
					)
					(1
						(= temp7 {Optimal})
					)
					(else
						(= temp8 {Optimal})
					)
				)
				(if (== (= temp3 gHowFast) 3)
					(= temp3 2)
				)
				(if
					(and
						(= temp3
							(PrintD
								80
								{Game Detail Level}
								81
								temp6
								81
								temp7
								81
								temp8
								116
								temp3
							)
						)
						(== (= gHowFast (- temp3 2)) 2)
						(>= gDftHowFast 3)
					)
					(= gHowFast gDftHowFast)
				)
			)
			(778
				(if
					(= temp3
						(PrintD
							80
							{Game Time Scale}
							81
							{Normal}
							81
							{Faster}
							81
							{Fastest}
							116
							(- gTimeScale 1)
						)
					)
					(= gTimeScale (- temp3 1))
				)
			)
			(1025
				(menuHandled event {cast })
			)
			(1026
				(menuHandled event {fight })
			)
			(1027
				(menuHandled event {escape })
			)
			(1029
				(PromptPause)
			)
			(1030
				(menuHandled event)
			)
			(1281
				(cond
					((not (HaveMem 1500))
						(HighPrint 997 2) ; "Sorry, there's not enough room to see that here."
					)
					((not gCantTalk)
						((ScriptID 71 0) init: doit:) ; theInvSheet
					)
				)
			)
			(1282
				(cond
					((not (HaveMem 1500))
						(HighPrint 997 2) ; "Sorry, there's not enough room to see that here."
					)
					((not gCantTalk)
						((ScriptID 70 0) useWindow: 1 showBars: 1 init: doit:) ; theCharSheet
					)
				)
			)
			(1284
				(showTime)
			)
			(1285
				(menuHandled event {ask about })
			)
			(1286
				(menuHandled event {tell about })
			)
			(1287
				(menuHandled event {look at })
			)
			(1289
				(cond
					(gModelessDialog)
					((not (gEgo has: 22)) ; Map
						(HighPrint 997 3) ; "You'll have to buy a map first."
					)
					(
						(not
							(or
								(OneOf gCurRoomNum 300 310 315 335 240 320 330) ; rmSPlazaGates, FPN, FPS, rmSPlazaPalace, rmPalaceGatesE, rmSPlazaFightersE
								(OneOf gCurRoomNum 704 120 199 229 269 271 303) ; alleyRoom, rmChanger
							)
						)
						(HighPrint 997 4) ; "The magic map only works in the streets and plazas of Shapeir."
					)
					(else
						(Map init:)
					)
				)
			)
			(1290
				(useCompass)
			)
		)
	)
)

(instance compassWindow of SysWindow
	(properties)
)

