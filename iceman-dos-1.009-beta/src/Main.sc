;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 0)
(include sci.sh)
(use Interface)
(use Grooper)
(use MDH)
(use Sound)
(use Save)
(use File)
(use Game)
(use Inventory)
(use User)
(use Menu)
(use System)

(public
	iceMan 0
	HandsOff 1
	HandsOn 2
	proc0_3 3
	proc0_4 4
	proc0_5 5
	proc0_30 30
	proc0_31 31
	proc0_32 32
	proc0_33 33
	proc0_34 34
	proc0_35 35
	proc0_36 36
	proc0_37 37
	proc0_38 38
	proc0_39 39
	proc0_40 40
	proc0_41 41
	proc0_42 42
)

(local
	; 0
	gEgo
	gGame
	gCurRoom
	gSpeed = 6
	gQuit
	; 5
	gCast
	gRegions
	gTimers
	gSounds
	gInventory
	; 10
	gAddToPics
	gCurRoomNum
	gPrevRoomNum
	gNewRoomNum
	gDebugOn
	; 15
	gScore
	gPossibleScore
	gShowStyle = 7
	gAniInterval
	gTheCursor
	; 20
	gNormalCursor = 999
	gWaitCursor = 997
	gUserFont = 1
	gSmallFont = 4
	gLastEvent
	; 25
	gModelessDialog
	gBigFont = 1
	gVolume = 12
	gVersion = {iceKeyDownHandler}
	gLocales
	; 30
	gCurSaveDir
	global31
	global32
	global33
	global34
	; 35
	global35
	global36
	global37
	global38
	global39
	; 40
	global40
	global41
	global42
	global43
	global44
	; 45
	global45
	global46
	global47
	global48
	global49
	; 50
	gAniThreshold = 10
	gPerspective
	gFeatures
	gSortedFeatures
	global54
	; 55
	global55
	global56
	global57 = -1
	global58
	global59
	; 60
	global60 = 3
	global61
	global62
	global63
	global64
	; 65
	global65
	global66
	global67
	global68
	global69
	; 70
	global70
	global71
	global72
	global73
	global74
	; 75
	global75
	global76
	global77
	global78
	global79
	; 80
	global80
	global81
	global82
	global83
	global84
	; 85
	global85
	global86
	global87
	global88
	global89
	; 90
	global90
	global91
	global92
	global93
	global94
	; 95
	global95
	global96
	global97
	global98
	global99
	; 100
	global100
	global101
	global102
	global103
	gIceKeyDownHandler
	; 105
	gIceMouseDownHandler
	gIceDirectionHandler
	global107
	global108
	global109
	; 110
	global110
	global111
	global112
	global113
	global114
	; 115
	global115
	global116
	global117
	global118
	global119
	; 120
	global120
	global121
	global122
	global123
	global124
	; 125
	global125
	global126
	global127
	global128
	global129
	; 130
	global130
	global131
	global132
	global133
	global134
	; 135
	global135
	global136
	global137
	gIceGlobalSound
	global139
	; 140
	global140
	global141 = 1
	global142
)

(procedure (HandsOff)
	(User canControl: 0 canInput: 0)
	(gEgo setMotion: 0)
	(gGame setCursor: gWaitCursor 1)
)

(procedure (HandsOn)
	(User canControl: 1 canInput: 1)
	(gEgo setMotion: 0)
	(gGame setCursor: gNormalCursor (HaveMouse))
)

(procedure (proc0_3)
	(if gModelessDialog
		(gModelessDialog dispose:)
	)
)

(procedure (localproc_0 param1 param2 &tmp [temp0 50])
	(gamefile_sh
		name: @global70
		write: (Format @temp0 0 13 gCurRoomNum param2 param1) ; "BAD_SAID~rm%03d: %s: %s"
		close:
	)
	(DisposeScript 993)
)

(procedure (proc0_4 param1)
	(return (> (MemoryInfo 0) param1)) ; LargestPtr
)

(procedure (proc0_30)
	(Print 0 14 #time 2) ; "Ok."
)

(procedure (proc0_31)
	(Print 0 15) ; "It is."
)

(procedure (proc0_32) ; UNUSED
	(Print 0 16) ; "You are."
)

(procedure (proc0_33)
	(Print 0 17) ; "Not now!"
)

(procedure (proc0_34)
	(Print 0 18) ; "You're not close enough."
)

(procedure (proc0_35)
	(Print 0 19) ; "You already took that."
)

(procedure (proc0_36)
	(Print 0 20) ; "You see nothing special."
)

(procedure (proc0_37)
	(Print 0 21) ; "You can't do that."
)

(procedure (proc0_38)
	(Print 0 22) ; "You don't have that."
)

(procedure (proc0_39)
	(Print 0 23) ; "You don't need to do that."
)

(procedure (proc0_40)
	(Print 0 24) ; "You don't see that."
)

(procedure (proc0_41)
	(Print 0 25) ; "That is not a good idea."
)

(procedure (proc0_42)
	(Print 0 26) ; "You can't do that after all."
)

(procedure (proc0_5 param1)
	(return
		(if (or (< global139 4) (== global139 12))
			(+ param1 200)
		else
			param1
		)
	)
)

(instance iceKeyDownHandler of EventHandler
	(properties)
)

(instance iceDirectionHandler of EventHandler
	(properties)
)

(instance iceMouseDownHandler of MDH
	(properties)
)

(instance iceMouseSays of Code
	(properties)

	(method (doit param1 param2)
		(Parse {look} param2)
	)
)

(instance iceMan of Game
	(properties)

	(method (init &tmp temp0)
		(= global59 iceWindow)
		(super init:)
		(= global140 (Graph grGET_COLOURS))
		(= global139 (DoSound sndCHECK_DRIVER))
		(= gVersion {x.yyy})
		((= gIceGlobalSound iceGlobalSound) init: owner: self)
		((= gIceKeyDownHandler iceKeyDownHandler) add:)
		((= gIceMouseDownHandler iceMouseDownHandler)
			add: gCast gFeatures
			shiftParser: iceMouseSays
		)
		((= gIceDirectionHandler iceDirectionHandler) add:)
		(User alterEgo: (= gEgo ego))
		(= gPossibleScore 300)
		(MenuBar init: draw:)
		(SL code: statusCode enable:)
		(gInventory add: Envelope Microfilm ID_Card)
		(self setCursor: gTheCursor 1 310 180)
		(self newRoom: 99) ; speedTest
	)

	(method (wordFail param1 param2 &tmp [temp0 40])
		(localproc_0 (Format @temp0 0 0 param1 param2) {Unknown word}) ; "%s" in "%s"
		(super wordFail: param1 param2 &rest)
	)

	(method (syntaxFail param1)
		(localproc_0 param1 {Couldn't parse})
		(super syntaxFail: param1 &rest)
	)

	(method (pragmaFail param1)
		(localproc_0 param1 {No response})
		(Print 0 1) ; "Try stating that a different way."
	)

	(method (newRoom)
		(super newRoom: &rest)
		(if (or (User canInput:) (User controls:))
			(self setCursor: gNormalCursor (HaveMouse))
		else
			(self setCursor: gWaitCursor 1)
		)
	)

	(method (startRoom roomNum)
		(gEgo observeControl: -32768)
		((ScriptID 818) doit: roomNum) ; disposeCode
		(if gDebugOn
			(SetDebug)
		)
		((ScriptID 819) doit: roomNum) ; preloadCode
		(super startRoom: roomNum &rest)
		(if
			(and
				(gCast contains: gEgo)
				(not (gEgo looper:))
				(not (OneOf roomNum 8 15 16 27 39 40)) ; HutSwimRm, tahitiOcean2, beachSwimRm, controlPanel, diceRm, chartRm
			)
			(gEgo setLoop: Grooper)
		)
		(if (and (gCast contains: gEgo) (not (gEgo view:)))
			(gEgo view: 200)
		)
	)

	(method (handleEvent event &tmp temp0 [temp1 3])
		(switch (event type:)
			(evKEYBOARD
				(if (and (not (event claimed:)) (== (event message:) KEY_ALT_n))
					(if (proc0_4 1536)
						((ScriptID 950) doit: @global70) ; sysLogger
					else
						(Print 0 2) ; "Not Enough Memory!!"
					)
					(event claimed: 1)
				else
					(gIceKeyDownHandler handleEvent: event)
				)
			)
			(evMOUSEBUTTON
				(gIceMouseDownHandler handleEvent: event)
			)
			($0040 ; direction
				(gIceDirectionHandler handleEvent: event)
			)
			(evSAID
				(cond
					((super handleEvent: event))
					((Said 'quit[<!*][/!*][/!*]')
						(= gQuit 1)
					)
					((Said 'yell')
						(Print 0 3) ; "Talk in a normal voice, please."
					)
					((Said 'break')
						(proc0_39) ; "You don't need to do that."
					)
					((Said 'eat>')
						(cond
							((Said '/*')
								(proc0_41) ; "That is not a good idea."
							)
							((Said '[/!*]')
								(Print 0 4) ; "You're not hungry right now."
							)
						)
					)
					((Said 'examine>')
						(if (Said '[/!*]')
							(Print 0 5) ; "Search what?"
						else
							(event claimed: 1)
							(proc0_36) ; "You see nothing special."
						)
					)
					((Said 'look<up,down')
						(proc0_36) ; "You see nothing special."
					)
					((Said 'walk')
						(Print 0 6) ; "Go ahead."
					)
					((Said 'talk')
						(Print 0 7) ; "Nobody hears you."
					)
					((Said 'whistle')
						(Print 0 8) ; "Happily you whistle a stupid little tune."
					)
					((and (Said '/*>') (= temp0 (gInventory saidMe:)))
						(event claimed: 0)
						(cond
							((temp0 ownedBy: gEgo)
								(cond
									(
										(or
											(Said 'look[<at]')
											(and 1 (Said 'open'))
										)
										(temp0 showSelf:)
									)
									((Said '*')
										(proc0_37) ; "You can't do that."
									)
								)
							)
							((temp0 ownedBy: gCurRoomNum)
								(if (Said 'get')
									(proc0_37) ; "You can't do that."
								else
									(proc0_38) ; "You don't have that."
								)
							)
							(else
								(proc0_40) ; "You don't see that."
							)
						)
						(event claimed: 1)
					)
					((Said 'get,give')
						(proc0_37) ; "You can't do that."
					)
					((Said 'look[<at]')
						(proc0_36) ; "You see nothing special."
					)
				)
				(if (and (not (event claimed:)) (>= argc 2))
					(proc0_42) ; "You can't do that after all."
				)
			)
		)
	)
)

(instance statusCode of Code
	(properties)

	(method (doit param1)
		(Format param1 0 9 gScore gPossibleScore) ; "Score: %d of %d           ICEMAN"
	)
)

(instance ego of Ego
	(properties)

	(method (handleEvent event)
		(cond
			((super handleEvent: event &rest))
			((Said 'look//*<for')
				(Print 0 10) ; "Seek and ye might find."
			)
		)
	)
)

(instance Envelope of InvI
	(properties
		said '/envelope'
		view 321
		value 1
	)
)

(instance Microfilm of InvI
	(properties
		said '/film'
		view 313
		loop 1
		value 1
	)
)

(instance ID_Card of InvI
	(properties
		name {ID Card}
		said '/id'
		view 300
		value 1
	)

	(method (showSelf)
		(if (== view 372)
			(Print 0 11 #icon view loop cel) ; "A phony Tunisian ID card."
		else
			(Print 0 12 #icon view loop cel) ; "Your Navy ID card."
		)
	)
)

(instance iceWindow of SysWindow
	(properties
		top 20
	)
)

(instance iceGlobalSound of Sound
	(properties
		number 1
	)
)

