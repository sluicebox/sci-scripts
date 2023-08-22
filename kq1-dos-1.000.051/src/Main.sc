;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 0)
(include sci.sh)
(use Interface)
(use myWindow)
(use TurnLooper)
(use Feature)
(use LoadMany)
(use StopWalk)
(use Follow)
(use Grooper)
(use Sound)
(use Save)
(use Motion)
(use File)
(use Game)
(use Inventory)
(use User)
(use Menu)
(use Actor)
(use System)

(public
	kq1 0
	proc0_1 1
	HandsOff 2
	HandsOn 3
	proc0_4 4
	proc0_6 6
	proc0_7 7
	proc0_8 8
	LogText 9
	SetFlag 10
	ClearFlag 11
	IsFlag 12
	proc0_13 13
	proc0_14 14
	proc0_15 15
	EgoDead 16
	proc0_17 17
	proc0_18 18
	SetScore 19
	UpdateWaterBucket 20
	gameSound 21
	PrintTooBusy 22
	backSound 23
	proc0_24 24
	PlayBackSound 25
	FadeBackSound 26
	UpdatePebbles 27
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
	gVersion
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
	gMyWindow
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
	global104
	; 105
	global105
	global106
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
	global125 = 801
	gMenace
	global127
	gGoat
	global129 = 11
	; 130
	global130
	global131
	global132 = -1
	global133 = -1
	global134 = 2400
	; 135
	global135
	global136
	global137
	global138
	global139
	; 140
	global140
	global141
	global142
	global143
	global144
	; 145
	global145
	global146
	global147
	global148
	global149
	; 150
	global150
	global151
	global152
	global153
	global154
	; 155
	global155
	global156
	global157
	global158
	global159
	; 160
	global160
	global161
	global162
	global163
	global164
	; 165
	global165
	global166
	global167
	global168
	global169
	; 170
	global170
	global171
	global172
	global173
	global174
	; 175
	global175
	global176
	global177
	global178
	global179
	; 180
	global180
	global181
	global182
	global183
	global184
	; 185
	global185
	global186
	global187
	global188
	global189
	; 190
	global190
	global191
	global192
	global193
	global194
	; 195
	global195
	global196
	global197
	global198
	global199
	; 200
	global200
)

(procedure (proc0_1 &tmp temp0 temp1)
	(= temp1 (IsFlag 0))
	(= temp0
		(cond
			((IsFlag 1)
				(if temp1 39 else 37)
			)
			(temp1 7)
			(else 2)
		)
	)
	(gEgo
		view:
			(cond
				((IsFlag 1)
					(if temp1 38 else 36)
				)
				(temp1 4)
				(else 0)
			)
		setLoop: -1
		setPri: -1
		setMotion: 0
		setStep: (if temp1 2 else 3) 2
		looper: Grooper
		illegalBits: -32768
		cycleSpeed: 0
		moveSpeed: 0
		ignoreActors: 0
		setCycle: StopWalk temp0
	)
	(Load rsVIEW temp0)
)

(procedure (HandsOff)
	(User canControl: 0 canInput: 0)
	(gEgo setMotion: 0)
	(gGame setCursor: 997 1)
	(MenuBar state: 0)
	(= global103 1)
)

(procedure (HandsOn)
	(User canControl: 1 canInput: 1)
	(gGame setCursor: 999 (HaveMouse))
	(MenuBar state: 1)
	(= global103 0)
)

(procedure (proc0_14 param1 param2 param3 param4 param5)
	(return
		(and
			(== (param1 type:) 1)
			(& (param1 modifiers:) $0003)
			(< param2 (param1 x:) param4)
			(< param3 (param1 y:) param5)
		)
	)
)

(procedure (proc0_7)
	(Animate (gCast elements:) 0)
)

(procedure (proc0_8 param1 param2)
	((gInventory at: param1) owner: (if (== argc 1) gCurRoomNum else param2))
)

(procedure (LogText param1 param2 &tmp [temp0 80])
	(= temp0 0)
	(logFile
		name: @global63
		writeString: (Format @temp0 0 130 gCurRoomNum param2 param1) ; "rm%03d: %s: %s"
		close:
	)
)

(procedure (SetFlag param1)
	(= [global150 (/ param1 16)]
		(| [global150 (/ param1 16)] (>> $8000 (mod param1 16)))
	)
)

(procedure (ClearFlag param1)
	(= [global150 (/ param1 16)]
		(& [global150 (/ param1 16)] (~ (>> $8000 (mod param1 16))))
	)
)

(procedure (IsFlag param1)
	(return (& [global150 (/ param1 16)] (>> $8000 (mod param1 16))))
)

(procedure (proc0_13)
	(cond
		((== global119 gCurRoomNum)
			(gGoat
				view: 166
				setLoop: global122
				setCel: (- (NumCels gGoat) 1)
				posn: global120 global121
				init:
				stopUpd:
			)
		)
		(
			(and
				(== global119 (gCurRoom west:))
				(> global120 315)
				(OneOf global119 1 2 83 10 11 15 16)
				(OneOf gCurRoomNum 1 2 83 10 11 15 16)
			)
			(gGoat
				view: 166
				setLoop: global122
				setCel: (- (NumCels gGoat) 1)
				posn: (- global120 320) global121
				init:
				stopUpd:
			)
		)
		(
			(and
				(== global119 (gCurRoom east:))
				(< global120 5)
				(OneOf global119 1 2 83 10 11 15 16)
				(OneOf gCurRoomNum 1 2 83 10 11 15 16)
			)
			(gGoat
				view: 166
				setLoop: global122
				setCel: (- (NumCels gGoat) 1)
				posn: (+ global120 320) global121
				init:
				stopUpd:
			)
		)
	)
)

(procedure (proc0_4)
	(Print 0 131) ; "It's not quite within reach, Sir Graham."
)

(procedure (proc0_6)
	(Print 0 132) ; "You don't have anything that fits that description in your inventory."
)

(procedure (proc0_15 param1 param2 param3 &tmp temp0 temp1)
	(= temp0 (param1 loop:))
	(if (== argc 2)
		(DirLoop
			param1
			(GetAngle (param1 x:) (param1 y:) (param2 x:) (param2 y:))
		)
		(= temp1 (GetAngle (param1 x:) (param1 y:) (param2 x:) (param2 y:)))
	else
		(DirLoop param1 (GetAngle (param1 x:) (param1 y:) param2 param3))
		(= temp1 (GetAngle (param1 x:) (param1 y:) param2 param3))
	)
	(if (!= temp0 (param1 loop:))
		(param1 setHeading: temp1)
		(param1 forceUpd:)
		(proc0_7)
	)
	(param1 setMotion: 0)
)

(procedure (proc0_17 param1 param2 param3)
	(return
		(cond
			((<= param2 param3) param3)
			((>= param2 param1) param1)
			(else param2)
		)
	)
)

(procedure (proc0_18 param1 param2 param3)
	(return
		(if (<= param3 param2 param1)
			(if (> (- param1 param2) (- param2 param3)) param3 else param1)
		else
			param2
		)
	)
)

(procedure (SetScore param1 param2)
	(if (not (IsFlag param1))
		(SetFlag param1)
		(kq1 changeScore: param2)
	)
)

(procedure (UpdateWaterBucket param1)
	(if param1
		(_Empty_Water_Bucket_
			name: { Full Water Bucket }
			loop: 1
			description:
				{This old wooden bucket is now filled with clear water.}
		)
		(if (not (IsFlag 82))
			(SetScore 63 2)
		)
		(SetFlag 9)
	else
		(_Empty_Water_Bucket_
			name: { Empty Water Bucket }
			loop: 0
			description: {You are holding an empty wooden bucket.}
		)
		(ClearFlag 9)
		(if (not (IsFlag 82))
			(ClearFlag 63)
			(kq1 changeScore: -2)
		)
	)
)

(procedure (PrintTooBusy)
	(if (Random 0 1)
		(Print 0 133) ; "You're too busy."
	else
		(Print 0 134) ; "You're too busy right now."
	)
)

(procedure (EgoDead)
	(HandsOff)
	(backSound fade:)
	(gameSound fade:)
	(Wait 100)
	(gSounds eachElementDo: #stop)
	(backSound
		number:
			(switch (Random 0 2)
				(0 49)
				(1 28)
				(2 3)
			)
		loop: 1
		priority: 15
		init:
		play:
	)
	(gGame setCursor: gNormalCursor 1)
	(repeat
		(switch
			(Print
				&rest
				#width
				250
				#button
				{Restore}
				1
				#button
				{ Restart }
				2
				#button
				{ Quit }
				3
			)
			(1
				(gGame restore:)
			)
			(2
				(gGame restart:)
			)
			(3
				(= gQuit 1)
				(break)
			)
		)
	)
)

(procedure (proc0_24 param1)
	(return (>= global101 (if argc param1 else 2)))
)

(procedure (PlayBackSound param1)
	(if (!= param1 (backSound number:))
		(if (== param1 98)
			(backSound loop: 1 priority: 14)
		else
			(backSound loop: -1)
		)
		(backSound number: param1 play:)
	)
)

(procedure (FadeBackSound)
	(if (!= 98 (backSound number:))
		(backSound fade:)
	)
)

(procedure (UpdatePebbles)
	(switch (-= global140 1)
		(0
			((gInventory at: 9) owner: 4) ; Pebbles
		)
		(1
			(_Pebbles_ name: { Pebble })
		)
		(else
			(_Pebbles_ name: { Pebbles })
		)
	)
)

(instance gameSound of Sound
	(properties
		number 1
		priority 5
	)
)

(instance backSound of Sound
	(properties
		number 1
	)
)

(instance version of File
	(properties)
)

(instance kq1 of Game
	(properties)

	(method (init &tmp [temp0 11])
		(= gVersion {0.000.001})
		(if (!= (version open: 1) 0)
			(version read: gVersion 9 close:)
		)
		(= gMyWindow myWindow)
		(super init:)
		(= gEgo ego)
		(= gGoat goat)
		(= gMenace menace)
		(backSound owner: self init:)
		(User alterEgo: gEgo blocks: 0 x: -1 y: 16)
		(= gShowStyle 100)
		(= global118 1)
		(= global104 (Graph grGET_COLOURS))
		(gGame setSpeed: 5)
		(= gPossibleScore 158)
		(MenuBar init: hide:)
		(SL code: statusCode disable:)
		(HandsOn)
		(StopWalk init:)
		(TurnLooper init:)
		(= gUserFont 300)
		(gInventory
			add:
				_Dagger_
				_Chest_
				_Carrot_
				_Key_
				_Note_
				_Magic_Ring_
				_Four_leaf_Clover_
				_Ceramic_Bowl_
				_Empty_Water_Bucket_
				_Pebbles_
				_Leather_Slingshot_
				_Pouch_
				_Sceptre_
				_Cheese_
				_Magic_Mirror_
				_Gold_Egg_
				_Magic_Shield_
				_Fiddle_
				_Walnut_
				_Mushroom_
				_Beans_
		)
		(Feature shiftClick: -32767 longRangeDist: 500)
		(SetFlag 40)
		(= global102 86)
		(if (GameIsRestarting)
			(MenuBar draw:)
			(SL enable:)
			(= global102 1)
			(gGame newRoom: 777) ; speedChecker
		else
			(MenuBar state: 1)
			(gGame newRoom: 777) ; speedChecker
		)
	)

	(method (replay)
		(MenuBar draw:)
		(SL enable:)
		(SetMenu 1282 110 (if (DoSound sndSET_SOUND) {Turn Off} else {Turn On}))
		(super replay:)
	)

	(method (doit &tmp temp0)
		(= temp0 (HaveMouse))
		(if
			(and
				(== (backSound number:) 98)
				(== (backSound signal:) -1)
				(not (IsFlag 51))
			)
			(SetFlag 51)
		)
		(if (and global124 (not (-- global124)))
			(Print 0 0) ; "Ye best be careful, young Graham. The mystic protective spell of mine has weakened and departed."
		)
		(if (and (IsFlag 1) global134 (not (-- global134)))
			(ClearFlag 1)
			(if
				(and
					(== gCurRoomNum 1)
					(not
						(and
							(gEgo has: 16) ; Magic_Shield
							(gEgo has: 14) ; Magic_Mirror
							(gEgo has: 1) ; Chest
						)
					)
				)
				(Print 0 1) ; "The spell to make you invisible has expired and you are once again visible to dangerous creatures but, the ring has now disappeared. The guards appear surprised at your sudden appearance."
			else
				(Print 0 2) ; "The spell to make you invisible has expired and you are once again visible to dangerous creatures but, the ring has now disappeared."
			)
			(gEgo put: 5) ; Magic_Ring
			(proc0_1)
		)
		(if (not global108)
			(cond
				(global107
					(= temp0 0)
				)
				((== (User controls:) 0)
					(= temp0 1)
					(= global106 gWaitCursor)
				)
				(else
					(= temp0 (HaveMouse))
					(= global106 gNormalCursor)
				)
			)
			(if (!= gTheCursor global106)
				(self setCursor: global106 temp0)
			)
		)
		(super doit:)
	)

	(method (startRoom roomNum)
		(LoadMany
			0
			985
			982
			972
			988
			980
			978
			977
			975
			974
			971
			970
			969
			973
			966
			965
			964
			962
			956
			976
			959
			955
			949
			991
			986
			983
			611
			600
			608
			779
			784
			782
			781
			780
			615
			898
			899
		)
		(if gDebugOn
			(= gDebugOn 0)
			(SetDebug)
		)
		(if
			(and
				(u> (MemoryInfo 1) (+ 20 (MemoryInfo 0))) ; FreeHeap, LargestPtr
				global118
				(Print 0 3 #button {Debug} 1) ; "Memory fragmented."
			)
			(SetDebug)
		)
		(super startRoom: roomNum)
		(if (and (== gPrevRoomNum 0) (not (IsFlag 40)))
			(MenuBar draw:)
			(SL enable:)
		)
		(gCurRoom picAngle: 50)
		(if (and (IsFlag 2) (not (>= 79 gCurRoomNum 49)))
			(gCurRoom setRegions: 600) ; rgGoat
		else
			(if global119
				(proc0_13)
			)
			(if
				(and
					(OneOf
						gCurRoomNum
						3
						4
						5
						6
						7
						8
						9
						12
						14
						15
						16
						17
						18
						19
						20
						23
						24
						26
						30
						31
						32
						33
						34
						36
						37
						38
						42
						45
						47
						56
						57
						59
						60
						61
						62
						70
						71
						72
						82
					)
					(>= global101 1)
				)
				(gCurRoom setLocales: 611)
			)
		)
		(if (OneOf gCurRoomNum 24 31 38)
			(cond
				((gEgo has: 20) ; Beans
					(gCurRoom setRegions: 606) ; beanRg
				)
				((== global131 gCurRoomNum)
					(gCurRoom setRegions: 607) ; stalkRg
				)
			)
		)
		(if (OneOf gCurRoomNum 56 57 58 59 60 61 62 72 82)
			(gCurRoom setRegions: 610) ; rgClouds
		)
		(if global124
			(gCurRoom setRegions: 616) ; rgHalo
		)
		(gameSound loop: 0)
		(cond
			(
				(and
					(gEgo has: 14) ; Magic_Mirror
					(gEgo has: 1) ; Chest
					(gEgo has: 16) ; Magic_Shield
					(not (IsFlag 51))
					(or (< gCurRoomNum 70) (== gCurRoomNum 83))
					(!= gCurRoomNum 53)
				)
				(PlayBackSound 98)
			)
			((OneOf gCurRoomNum 50 66 67 68 69 73 74 75 76 77 78)
				(PlayBackSound 31)
			)
			((OneOf gCurRoomNum 63)
				(PlayBackSound 73)
			)
			(
				(OneOf
					gCurRoomNum
					3
					9
					10
					11
					12
					13
					15
					16
					19
					21
					22
					24
					27
					28
					29
					30
					31
					35
					36
					38
					40
					44
					45
					46
					48
					95
				)
				(PlayBackSound 2)
			)
			((OneOf gCurRoomNum 1 2 25 26 39 41 42 83)
				(PlayBackSound 52)
			)
			((OneOf gCurRoomNum 7 32 33 34 47)
				(PlayBackSound 12)
			)
			((OneOf gCurRoomNum 4 5 6 8 17 18 20 23 37 43)
				(PlayBackSound 68)
			)
		)
		(self dispose:)
	)

	(method (handleEvent event &tmp temp0 [temp1 3] temp4 temp5 temp6 [temp7 50])
		(if (and (== (event type:) evMOUSEBUTTON) (& (event modifiers:) emSHIFT))
			(if (not (User canInput:))
				(event claimed: 1)
			else
				(gCast eachElementDo: #handleEvent event)
				(gAddToPics eachElementDo: #handleEvent event)
				(gFeatures eachElementDo: #handleEvent event)
			)
		)
		(if (== (event type:) evSAID)
			(gAddToPics eachElementDo: #handleEvent event)
		)
		(if (event claimed:)
			(return)
		)
		(super handleEvent: event)
		(if
			(or
				(== (event type:) evMOUSEBUTTON)
				(and (== (event type:) evKEYBOARD) (== (event message:) KEY_RETURN))
			)
			(if gModelessDialog
				(event claimed: 0)
				(gModelessDialog dispose:)
			else
				(event claimed: 0)
			)
		)
		(switch (event type:)
			(evSAID
				(cond
					((Said 'look,look[<up][/sky]')
						(cond
							((OneOf gCurRoomNum 70 71 global131)
								(Print 0 4) ; "You see the thick green tendrils of the beanstalk stretching even further to the sky above you."
							)
							(
								(OneOf
									gCurRoomNum
									49
									50
									51
									52
									53
									54
									55
									65
									66
									67
									68
									69
									73
									74
									75
									76
									77
									78
									79
									90
								)
								(Print 0 5) ; "The sky isn't visible from here."
							)
							(else
								(Print 0 6) ; "Above you, you can see the blue sky of Daventry. It's partly cloudy, with a high in the mid seventies."
							)
						)
					)
					((Said 'look,look<in/mirror')
						(if (or (gEgo has: 14) (== gCurRoomNum 51)) ; Magic_Mirror
							(Print 0 7) ; "As you gaze into the magic mirror, you see a reflection of yourself as King of this land of Daventry."
						else
							(Print 0 8) ; "You don't have the magic mirror."
						)
					)
					((Said '/goat>')
						(cond
							((Said 'look,look')
								(if (gCast contains: gGoat)
									(Print 0 9) ; "The goat doesn't seem to be interested in you."
								else
									(Print 0 10) ; "There is no goat here."
								)
							)
							((Said 'talk,talk')
								(if
									(or
										(== global119 gCurRoomNum)
										(gCast contains: gGoat)
									)
									(Print 0 11) ; "The goat is not much for conversation."
								else
									(Print 0 10) ; "There is no goat here."
								)
							)
							((Said 'get,get')
								(if
									(or
										(== global119 gCurRoomNum)
										(gCast contains: gGoat)
									)
									(Print 0 12) ; "The goat is too heavy to carry around."
								else
									(Print 0 10) ; "There is no goat here."
								)
							)
						)
					)
					((Said 'drop/pebble/shot')
						(Print 0 13) ; "Just type "USE THE SLINGSHOT"."
					)
					((Said 'drop>')
						(if
							(and
								(= temp0 (gInventory firstTrue: #saidMe))
								(temp0 ownedBy: gEgo)
							)
							(Print 0 14) ; "You shouldn't drop that, Sir Graham.  You may need it."
						else
							(event claimed: 0)
						)
					)
					((Said '/fish>')
						(if (OneOf gCurRoomNum 4 5 6 8 17 18 20 23 37 43)
							(cond
								((Said 'eat,eat')
									(Print 0 15) ; "You don't care for sushi, Sir Graham."
								)
								((Said 'kill')
									(Print 0 16) ; "You won't need a dead fish on your quest."
								)
							)
						else
							(Print 0 17) ; "You don't see any fish here."
							(event claimed: 1)
						)
					)
					((Said '/nut>')
						(cond
							((Said 'get,get')
								(if (gEgo has: 18) ; Walnut
									(Print 0 18) ; "You already have it."
								else
									(event claimed: 0)
								)
							)
							((not (gEgo has: 18)) ; Walnut
								(proc0_6) ; "You don't have anything that fits that description in your inventory."
								(event claimed: 1)
							)
							((Said 'open,open')
								(cond
									((gCurRoom script:)
										(PrintTooBusy)
									)
									((IsFlag 67)
										(Print 0 19) ; "You have already opened the walnut."
									)
									(else
										(Print 0 20) ; "When you open the walnut, you discover the nut inside is pure gold!"
										(SetScore 67 3)
										(_Walnut_
											name: { Gold Walnut }
											loop: 1
											description:
												{When you open the walnut, you discover the nut inside is pure gold!}
										)
									)
								)
							)
							((Said 'eat,eat')
								(if (IsFlag 67)
									(Print 0 21) ; "Don't do that! This walnut is not edible since it is pure gold."
								else
									(Print 0 22) ; "Ouch! It would be much easier if you opened the walnut first."
								)
							)
							((Said 'bite')
								(if (gEgo has: 18) ; Walnut
									(Print 0 23) ; "You'd break your teeth on this walnut! Then you'd REALLY need a gold crown!"
								else
									(Print 0 24) ; "You don't have a walnut to bite."
								)
							)
							((Said 'look,look')
								(_Walnut_ showSelf:)
								(event claimed: 1)
							)
						)
					)
					((Said '/ring>')
						(cond
							((not (gEgo has: 5)) ; Magic_Ring
								(proc0_6) ; "You don't have anything that fits that description in your inventory."
								(event claimed: 1)
							)
							((or (Said 'wear') (Said 'drop<on'))
								(cond
									((IsFlag 17)
										(Print 0 25) ; "The ring is already on your finger."
									)
									(
										(or
											(IsFlag 48)
											(OneOf (gEgo view:) 8 19)
										)
										(Print 0 26) ; "You can't do that without letting go, which would be a terrible mistake."
									)
									(else
										(Print 0 27) ; "You place the shimmering ring upon your finger."
										(SetFlag 17)
									)
								)
							)
							((Said 'rub')
								(cond
									(
										(or
											(IsFlag 48)
											(OneOf (gEgo view:) 8 19)
										)
										(Print 0 26) ; "You can't do that without letting go, which would be a terrible mistake."
									)
									((IsFlag 1)
										(Print 0 28) ; "You are already invisible"
									)
									((not global134)
										(Print 0 29) ; "Nothing happens."
									)
									(
										(==
											(gEgo view:)
											(if (IsFlag 0) 23 else 16)
										)
										(Print 0 30) ; "You'll have to stand up if you want to invoke the ring's power."
									)
									((> global130 0)
										(Print 0 31) ; "For the full effect of the ring, you will need to step out of the water."
									)
									((IsFlag 17)
										(Print 0 32) ; "As you rub the shimmering ring, you turn invisible!"
										(cond
											(
												(and
													(IsFlag 2)
													(OneOf
														gCurRoomNum
														25
														39
														41
													)
												)
												(event claimed: 1)
												(gGoat setMotion: 0)
											)
											((IsFlag 2)
												(Print 0 33) ; "The goat doesn't seem to see you anymore."
												(ClearFlag 2)
												(gGoat setMotion: 0)
											)
										)
										(SetFlag 1)
										(proc0_1)
									)
									(else
										(Print 0 34) ; "The magic ring is still in your pocket. You can't rub it there."
									)
								)
							)
							((or (Said 'remove') (Said 'get<off'))
								(cond
									(
										(==
											(gEgo view:)
											(if (IsFlag 0) 23 else 16)
										)
										(PrintTooBusy)
									)
									((not (IsFlag 17))
										(Print 0 35) ; "You aren't wearing the ring, Sir Graham."
									)
									((== (gEgo view:) 8)
										(Print 0 36) ; "You're using your hands to hang on for dear life!"
									)
									(else
										(Print 0 37) ; "You remove the shimmering ring from your finger."
										(if
											(and
												(gCast contains: gGoat)
												(gEgo has: 2) ; Carrot
											)
											(gGoat
												setMotion: Follow gEgo 60
											)
											(SetFlag 2)
										)
										(ClearFlag 17)
										(ClearFlag 1)
										(if
											(and
												(!= (gEgo view:) 61)
												(!= (gEgo view:) 249)
												(!= (gEgo view:) 13)
												(!= (gEgo view:) 14)
												(!= (gEgo view:) 6)
											)
											(proc0_1)
										)
									)
								)
							)
							((Said 'get,get')
								(if (gEgo has: 5) ; Magic_Ring
									(Print 0 18) ; "You already have it."
								else
									(event claimed: 0)
								)
							)
							((Said 'look,look')
								(_Magic_Ring_ showSelf:)
							)
						)
					)
					((Said '/egg>')
						(if (gEgo has: 15) ; Gold_Egg
							(cond
								((Said 'eat,eat')
									(Print 0 38) ; "This egg will be tough to crack."
								)
								((Said 'open,open')
									(Print 0 39) ; "Oddly enough, this egg has no shell. It's 24-karat gold, through and through."
								)
								((Said 'crack')
									(Print 0 40) ; "You would need more than your bare hands to crack a solid gold egg...and anyway, there's nothing inside it except more gold."
								)
								((Said 'look,look')
									(_Gold_Egg_ showSelf:)
									(event claimed: 1)
								)
							)
						else
							(proc0_6) ; "You don't have anything that fits that description in your inventory."
							(event claimed: 1)
						)
					)
					((Said 'smell,smell/soup')
						(cond
							((or (not (gEgo has: 7)) (not (IsFlag 112))) ; Ceramic_Bowl
								(proc0_6) ; "You don't have anything that fits that description in your inventory."
								(event claimed: 1)
							)
							((IsFlag 34)
								(Print 0 41) ; "You have already eaten the stew."
							)
							(else
								(Print 0 42) ; "Mmm! You can detect the aromas of delicious carrots (from the King's garden), potatoes, green peppers, celery, onions, and fresh dragon meat...along with a hint of imported spice."
							)
						)
					)
					((Said 'eat,eat>')
						(cond
							(global130
								(event claimed: 1)
								(switch (Random 0 2)
									(0
										(Print 0 43) ; "You can't eat while swimming"
									)
									(1
										(Print 0 44) ; "It's not a good idea to eat while you're swimming. Even knights can get muscle cramps!"
									)
									(2
										(Print 0 45) ; "You can't do that and swim at the same time!"
									)
								)
							)
							((IsFlag 1)
								(Print 0 46) ; "You can't find your mouth while you're invisible!"
								(event claimed: 1)
							)
							((gCurRoom script:)
								(PrintTooBusy)
								(event claimed: 1)
							)
							((Said '/soup')
								(cond
									(
										(or
											(not (gEgo has: 7)) ; Ceramic_Bowl
											(not (IsFlag 112))
										)
										(proc0_6) ; "You don't have anything that fits that description in your inventory."
										(event claimed: 1)
									)
									((IsFlag 34)
										(Print 0 41) ; "You have already eaten the stew."
									)
									(else
										(Print 0 47) ; "You eat every bite of the delicious stew."
										(_Ceramic_Bowl_
											loop: 0
											description:
												{This large ceramic bowl is now empty.}
										)
										(ClearFlag 112)
										(kq1 changeScore: -2)
									)
								)
							)
							((Said '/mushroom')
								(cond
									((gEgo has: 19) ; Mushroom
										(gCurRoom setScript: (ScriptID 779 0)) ; shrinkEgo
									)
									((IsFlag 104)
										(Print 0 48) ; "You've already eaten the mushroom, Sir Graham."
									)
									(else
										(proc0_6) ; "You don't have anything that fits that description in your inventory."
										(event claimed: 1)
									)
								)
							)
							((Said '/carrot')
								(cond
									((IsFlag 2)
										(Print 0 49) ; "Seeing how much the goat likes that carrot, eating it may be hazardous to your health."
									)
									((not (gEgo has: 2)) ; Carrot
										(if (IsFlag 10)
											(Print 0 50) ; "You already ate the carrot."
										else
											(proc0_6) ; "You don't have anything that fits that description in your inventory."
										)
									)
									(else
										(Print 0 51) ; "Mmmm! There's nothing like a crisp, fresh carrot."
										(SetFlag 10)
										(gCurRoom setScript: (ScriptID 781 0)) ; eatIt
										(ClearFlag 64)
										(proc0_8 2 15)
										(if (not (IsFlag 5))
											(gGame changeScore: -2)
										)
									)
								)
							)
							((Said '/bean')
								(if (not (gEgo has: 20)) ; Beans
									(if (IsFlag 35)
										(Print 0 52) ; "You already ate the beans."
									else
										(proc0_6) ; "You don't have anything that fits that description in your inventory."
									)
								else
									(Print 0 53) ; "The magic beans tingle as they go down. Now, why did you do that?"
									(SetFlag 35)
									(gCurRoom setScript: (ScriptID 781 0)) ; eatIt
									(proc0_8 20 0)
									(gGame changeScore: -4)
								)
							)
							((Said '/cheese')
								(if (gEgo has: 13) ; Cheese
									(Print 0 54) ; "Mmmm! That Swiss cheese was as delicious as it looked."
									(gCurRoom setScript: (ScriptID 781 0)) ; eatIt
									(gEgo put: 13) ; Cheese
									(gGame changeScore: -2)
								else
									(proc0_6) ; "You don't have anything that fits that description in your inventory."
								)
							)
							((Said '/*')
								(Print 0 55) ; "Just the thought of eating that would make braver knights lose their appetites!"
								(event claimed: 1)
							)
							(else
								(Print 0 56) ; "Is there anything in particular you'd like to eat?"
								(event claimed: 1)
							)
						)
					)
					((and (not (OneOf gCurRoomNum 63 80 27 22)) (Said '/bird'))
						(Print 0 57) ; "There are no birds here."
					)
					((Said 'stand')
						(if (OneOf (gEgo view:) 0 2 4 7 36 37 38 39)
							(Print 0 58) ; "You are standing."
						else
							(Print 0 59) ; "You can't stand now."
						)
					)
					((Said 'swim')
						(Print 0 60) ; "You'll need to be in the water before you can swim!"
					)
					((Said 'dive')
						(Print 0 61) ; "You'll need to be swimming before you can dive into the water!"
					)
					((Said 'climb,climb<in')
						(Print 0 62) ; "There's nothing inside there you'll need."
					)
					((Said 'climb,climb')
						(cond
							((== (gEgo view:) 14)
								(Print 0 63) ; "The deep water makes it impossible for you to climb out."
							)
							((== gCurRoomNum 73)
								(Print 0 64) ; "The walls are too damp and sheer. There's no way to climb out of that hole."
							)
							(else
								(Print 0 65) ; "There is nothing up there you'll need."
							)
						)
					)
					((Said 'bury/bean')
						(if (not (gEgo has: 20)) ; Beans
							(proc0_6) ; "You don't have anything that fits that description in your inventory."
						else
							(Print 0 66) ; "You can't plant them there. They need special soil."
						)
					)
					(
						(or
							(Said 'open,open/bag[<leather]')
							(Said 'look,look<in/bag[<leather]')
							(Said 'look,look/diamond')
							(Said 'look,look/content')
						)
						(cond
							((gCurRoom script:)
								(PrintTooBusy)
							)
							((not (gEgo has: 11)) ; Pouch
								(proc0_6) ; "You don't have anything that fits that description in your inventory."
							)
							(else
								(SetScore 62 3)
								(Print 0 67) ; "Cautiously, you open the pouch and see many sparkling and flashing diamonds! Quickly, you close it again so as not to lose any."
							)
						)
					)
					((or (Said 'fill[/bowl]') (Said 'say<fill'))
						(cond
							((gCurRoom script:)
								(PrintTooBusy)
							)
							((IsFlag 112)
								(Print 0 68) ; "You have already filled the bowl."
							)
							((not (gEgo has: 7)) ; Ceramic_Bowl
								(event claimed: 0)
								(if (Said '/bowl')
									(proc0_6) ; "You don't have anything that fits that description in your inventory."
								else
									(Print 0 69) ; "What would you like to fill?"
									(event claimed: 1)
								)
							)
							(else
								(gameSound number: 69 loop: 1 init: play:)
								(Print 0 70) ; "To your astonishment, something begins to bubble up from the bottom of the bowl. Within moments, the bowl is filled with a hot, savory stew."
								(_Ceramic_Bowl_
									loop: 1
									description:
										{This large ceramic bowl is now filled with a savory beef stew.}
									said: '/bowl,soup'
								)
								(SetScore 112 2)
							)
						)
					)
					((Said 'open,open/chest')
						(if (gEgo has: 1) ; Chest
							(if (IsFlag 26)
								(Print 0 71) ; "You open the chest and admire the gold coins for a moment. You then close the chest."
							else
								(Print 0 72) ; "You are dazzled by the countless supply of gold coins spilling from the magic chest. You quickly close the chest."
								(SetFlag 26)
							)
						else
							(proc0_6) ; "You don't have anything that fits that description in your inventory."
						)
					)
					((Said 'fiddle,play/fiddle,jig')
						(cond
							(
								(or
									(not (OneOf (gEgo view:) 0 2 7 4))
									(gCurRoom script:)
								)
								(PrintTooBusy)
							)
							((IsFlag 1)
								(Print 0 73) ; "You try, but being invisible makes it impossible."
							)
							((not (gEgo has: 17)) ; Fiddle
								(proc0_6) ; "You don't have anything that fits that description in your inventory."
							)
							(else
								(gCurRoom setScript: (ScriptID 782 0)) ; fiddler
							)
						)
					)
					((Said 'throw/dagger,dagger')
						(cond
							((not (gEgo has: 0)) ; Dagger
								(if (IsFlag 90)
									(Print 0 74) ; "You had the dagger and lost it. Sorry."
								else
									(proc0_6) ; "You don't have anything that fits that description in your inventory."
								)
							)
							((gCurRoom script:)
								(PrintTooBusy)
							)
							((IsFlag 1)
								(Print 0 73) ; "You try, but being invisible makes it impossible."
							)
							(global130
								(Print 0 75) ; "Though you're an extremely able and talented knight, throwing a dagger and swimming at the same time is quite beyond your abilities."
							)
							(else
								(gCurRoom setScript: (ScriptID 780 0)) ; throwDag
							)
						)
					)
					((Said 'use,throw,shoot/shot')
						(cond
							((not (gEgo has: 10)) ; Leather_Slingshot
								(proc0_6) ; "You don't have anything that fits that description in your inventory."
							)
							((not (gEgo has: 9)) ; Pebbles
								(Print 0 76) ; "You don't have any rocks for the slingshot."
							)
							((gCurRoom script:)
								(PrintTooBusy)
							)
							((IsFlag 1)
								(Print 0 77) ; "You can't aim something you can't see."
							)
							((> global130 1)
								(Print 0 78) ; "Safety dictates that you should not use the slingshot while in the water."
							)
							(else
								(gCurRoom setScript: (ScriptID 784 0)) ; slingr
							)
						)
					)
					((Said 'throw/boulder,pebble')
						(if (and (gEgo has: 9) global140) ; Pebbles
							(UpdatePebbles)
							(if (== global140 0)
								(Print 0 79) ; "You throw your last pebble."
							else
								(Print 0 80) ; "You throw one of your pebbles."
							)
						else
							(proc0_6) ; "You don't have anything that fits that description in your inventory."
						)
					)
					((Said 'throw/water')
						(cond
							((and (gEgo has: 8) (IsFlag 9)) ; Empty_Water_Bucket
								(Print 0 81) ; "You might have something very clever in mind, but it's not going to work. Leave the water in the bucket for now."
							)
							((== (gEgo view:) 14)
								(Print 0 82) ; "No matter how fast you throw the water, it won't be quick enough to keep you from drowning!"
							)
							((== (gEgo view:) 13)
								(Print 0 83) ; "That's hard to do while you are swimming."
							)
							(global130
								(Print 0 84) ; "The water is fine where it is."
							)
							(else
								(Print 0 85) ; "You don't have any water to throw."
							)
						)
					)
					((or (Said 'get,get/drink') (Said 'drink[/water]'))
						(cond
							((== (gEgo view:) 14)
								(Print 0 86) ; "No matter how quickly you drink this water, there's still enough for you to drown in."
							)
							((== (gEgo view:) 13)
								(Print 0 87) ; "You open your mouth while swimming and quench your thirst."
							)
							(global130
								(Print 0 88) ; "You have to scoop the water with your hands, but you manage to satisfy your thirst."
							)
							((and (gEgo has: 8) (IsFlag 9)) ; Empty_Water_Bucket
								(Print 0 89) ; "You drain the bucket of water to quench your thirst."
								(UpdateWaterBucket 0)
							)
							(else
								(Print 0 90) ; "You are not close enough to the water."
							)
						)
					)
					((Said 'read,look,look/bowl')
						(if (gEgo has: 7) ; Ceramic_Bowl
							(_Ceramic_Bowl_ showSelf:)
						else
							(proc0_6) ; "You don't have anything that fits that description in your inventory."
						)
					)
					((Said 'read,look,look/note')
						(if (gEgo has: 4) ; Note
							(_Note_ showSelf:)
						else
							(proc0_6) ; "You don't have anything that fits that description in your inventory."
						)
					)
					(
						(and
							(Said 'look,look>')
							(= temp0 (gInventory firstTrue: #saidMe))
						)
						(if (temp0 ownedBy: gEgo)
							(temp0 showSelf:)
						else
							(proc0_6) ; "You don't have anything that fits that description in your inventory."
						)
					)
					((Said 'get,get/gold,coin[<gold]')
						(cond
							((gEgo has: 1) ; Chest
								(Print 0 91) ; "You are already carrying an endless supply of gold coins in the magic chest."
							)
							((and (gEgo has: 18) (IsFlag 67)) ; Walnut
								(Print 0 92) ; "You are already carrying a golden walnut."
							)
							((gEgo has: 15) ; Gold_Egg
								(Print 0 93) ; "You are already carrying a golden egg."
							)
							(else
								(Print 0 94) ; "Where? There is no gold here."
							)
						)
					)
					((and (== global119 gCurRoomNum) (Said 'get,get/dagger'))
						(Print 0 95) ; "At the thought of removing the knife from the dead goat, you are filled with remorse."
					)
					((Said 'get,get>')
						(cond
							(
								(and
									(= temp0 (gInventory firstTrue: #saidMe))
									(temp0 ownedBy: gEgo)
								)
								(Print 0 18) ; "You already have it."
							)
							((Said '/*')
								(Print 0 96) ; "You won't be needing that on your quest, Sir Graham."
							)
							(else
								(Print 0 97) ; "You can't do that."
								(event claimed: 1)
							)
						)
					)
					((Said 'look,look/beanstalk')
						(Print 0 98) ; "There isn't a beanstalk here to look at."
					)
					((Said 'look,look/edge')
						(if (gEgo has: 0) ; Dagger
							(Print 0 99) ; "The edge of the dagger has been honed to razor sharpness."
						else
							(Print 0 100) ; "There are no edges of special interest here."
						)
					)
					((Said 'look,look')
						(Print 0 101) ; "You see nothing special, Sir Graham."
					)
					((Said 'why')
						(Print 0 102) ; "If you have to ask why, you'll never understand."
					)
					((Said 'because')
						(Print 0 103) ; "Because why?"
					)
					((Said 'fuck[<*]')
						(event claimed: 1)
					)
					((Said 'excuse/me')
						(Print 0 104) ; "Why?"
					)
					((Said 'what')
						(Print 0 105) ; "What indeed."
					)
					((Said 'how')
						(Print 0 106) ; "That's for me to know and Sir Graham to find out."
					)
					((Said 'who')
						(Print 0 107) ; "Who do you think?"
					)
					((Said 'when')
						(Print 0 108) ; "When you figure out the puzzle!"
					)
					((Said 'use')
						(Print 0 109) ; "You cannot do that, Sir Graham."
					)
					((Said 'smell,smell')
						(Print 0 110) ; "You smell nothing unusual."
					)
					((Said 'throw,give')
						(Print 0 111) ; "Keep it to yourself."
					)
					((Said 'pull')
						(Print 0 112) ; "You can't."
					)
					((Said 'talk,talk/*')
						(Print 0 113) ; "That's strange... you don't get an answer."
					)
					((Said 'talk,talk')
						(Print 0 114) ; "Talking to yourself is a sure sign that the hot Daventry sun is taking its toll on you."
					)
				)
			)
			(evMOUSEBUTTON
				(if (and global118 (User controls:))
					(= temp4 (event x:))
					(= temp5 (event y:))
					(if
						(not
							(or
								(& (= temp6 (event modifiers:)) emSHIFT)
								(& temp6 emCTRL)
							)
						)
						(event claimed: 1)
						((User alterEgo:) setMotion: MoveTo temp4 temp5)
					)
				)
			)
		)
	)

	(method (wordFail param1 param2 &tmp [temp0 100])
		(if (and (== gCurRoomNum 40) (IsFlag 37))
			(gCurRoom notify: param1)
		else
			(Printf 0 115 param1) ; "Sir Graham, please try to find another word for "%s.""
			(LogText (Format @temp0 0 116 param1 param2) {Unknown word}) ; "%s" in "%s"
		)
	)

	(method (syntaxFail param1)
		(Print 0 117) ; "Please try to rephrase that thought, Sir Graham."
		(LogText param1 {Couldn't parse})
	)

	(method (pragmaFail param1)
		(Print 0 118) ; "Please try something else, Sir Graham."
		(LogText param1 {No response})
	)
)

(instance statusCode of Code
	(properties)

	(method (doit param1)
		(Format param1 0 119 gScore gPossibleScore 0 120 {King's Quest I} 0 120) ; "Score: %d of %d%13s%s%1s"
	)
)

(instance ego of Ego
	(properties)
)

(instance goat of Actor
	(properties
		view 165
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if (and (not (event claimed:)) (== (event type:) evSAID))
			(if (Said 'look,look/goat')
				(self doVerb: 1)
			)
			(if (Said 'get,get/goat')
				(event claimed: 0)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(cond
					(global119
						(Print 0 121) ; "You see a useless dead goat lying lifeless on the ground."
					)
					((== view 166)
						(Print 0 122) ; "The goat is grazing nearby."
					)
					((IsFlag 2)
						(Print 0 123) ; "The old goat, trotting briskly, seems happy to be with you."
					)
					((not (IsFlag 36))
						(if (& (gGoat onControl:) $3000)
							(Print 0 124) ; "The goat is wandering this way and that, exploring his little pen."
						else
							(Print 0 125) ; "The goat has wandered off to the other side of his pen."
						)
					)
					(else
						(Print 0 9) ; "The goat doesn't seem to be interested in you."
					)
				)
			)
		)
	)
)

(instance menace of Actor
	(properties)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((& signal $0080)
				(event claimed: 0)
			)
			((super handleEvent: event)
				(return)
			)
		)
	)

	(method (doVerb theVerb)
		(cond
			((== view 130)
				(= description {ogre})
				(super doVerb: theVerb &rest)
			)
			((== view 125)
				(= description {wolf})
				(super doVerb: theVerb &rest)
			)
			((OneOf view 120 121 123 124 126)
				(= description {troll})
				(if (IsFlag 13)
					(Print 0 126) ; "This is the ugliest, meanest, nastiest troll you have ever seen. And he is not about to let anybody cross his bridge."
				else
					(Print 0 127) ; "There is no troll here."
				)
			)
			((OneOf view 115 116 117 118 119)
				(= description {witch})
				(super doVerb: theVerb &rest)
			)
			((OneOf view 135 136)
				(= description {dwarf})
				(super doVerb: theVerb &rest)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance _Dagger_ of InvI
	(properties
		name { Dagger }
		said '/dagger'
		description {This is a fine silver dagger, with a very sharp edge!}
		view 501
	)
)

(instance _Chest_ of InvI
	(properties
		name { Chest }
		said '/chest'
		description {This Magic chest, one of the three lost treasures of Daventry, is always filled with gold coins.}
		owner 58
		view 505
	)
)

(instance _Carrot_ of InvI
	(properties
		name { Carrot }
		said '/carrot'
		description {This looks like an ordinary carrot.}
		view 517
	)
)

(instance _Key_ of InvI
	(properties
		name { Key }
		said '/key'
		description {This is a simple gold key.}
		view 508
	)
)

(instance _Note_ of InvI
	(properties
		name { Note }
		said '/note,message'
		description {There is a message written on the note: "Sometimes it is wise to think backwards."}
		view 513
	)

	(method (showSelf)
		(super showSelf:)
		(SetScore 78 2)
	)
)

(instance _Magic_Ring_ of InvI
	(properties
		name { Magic Ring }
		said '/ring'
		description {Your hand tingles slightly as you look at this jewelled ring.}
		view 516
	)
)

(instance _Four_leaf_Clover_ of InvI
	(properties
		name { Four-leaf Clover }
		said '/clover'
		description {You are holding a large four-leaf clover.}
		view 515
	)
)

(instance _Ceramic_Bowl_ of InvI
	(properties
		name { Ceramic Bowl }
		said '/bowl'
		description {Inscribed on the inside of this empty ceramic bowl is the word "Fill."}
		view 511
	)

	(method (showSelf)
		(super showSelf:)
		(if (not (IsFlag 112))
			(SetScore 93 1)
		)
	)
)

(instance _Empty_Water_Bucket_ of InvI
	(properties
		name { Empty Water Bucket }
		said '/bucket'
		description {You are holding an empty wooden bucket.}
		view 519
	)
)

(instance _Pebbles_ of InvI
	(properties
		name { Pebbles }
		said '/pebble'
		description {You have a pocketful of smooth, rounded pebbles.}
		view 510
	)

	(method (showSelf &tmp [temp0 80])
		(if (== global140 1)
			(Print (Format @temp0 0 128 global140) #icon 510 0 0) ; "You have %d smooth, rounded pebble."
		else
			(Print (Format @temp0 0 129 global140) #icon 510 (- global140 1) 0) ; "You have %d smooth, rounded pebbles."
		)
	)
)

(instance _Leather_Slingshot_ of InvI
	(properties
		name { Leather Slingshot }
		said '/shot,shot'
		description {This is a small but sturdy slingshot.}
		owner 62
		view 520
	)
)

(instance _Pouch_ of InvI
	(properties
		name { Pouch }
		said '/bag'
		description {You are holding a plain leather pouch.}
		view 500
	)
)

(instance _Sceptre_ of InvI
	(properties
		name { Sceptre }
		said '/scepter'
		description {This jewelled sceptre belongs to the King of the Leprechauns.}
		view 504
	)
)

(instance _Cheese_ of InvI
	(properties
		name { Cheese }
		said '/cheese'
		description {This is an extremely fragrant piece of Swiss cheese.}
		view 514
	)
)

(instance _Magic_Mirror_ of InvI
	(properties
		name { Magic Mirror }
		said '/mirror'
		description {This is the magic mirror, one of the three treasures of Daventry.}
		view 503
	)
)

(instance _Gold_Egg_ of InvI
	(properties
		name { Gold Egg }
		said '/egg'
		description {You are holding a lovely golden egg.}
		owner 63
		view 518
	)
)

(instance _Magic_Shield_ of InvI
	(properties
		name { Magic Shield }
		said '/shield'
		description {This is the magic shield, one of the three treasures of Daventry.}
		view 522
	)
)

(instance _Fiddle_ of InvI
	(properties
		name { Fiddle }
		said '/fiddle'
		description {This is the woodcutter's old fiddle.}
		owner 79
		view 506
	)
)

(instance _Walnut_ of InvI
	(properties
		name { Walnut }
		said '/nut'
		description {You are holding an ordinary walnut.}
		view 512
	)
)

(instance _Mushroom_ of InvI
	(properties
		name { Mushroom }
		said '/mushroom'
		description {This is a small, unusual-looking mushroom.}
		view 507
	)
)

(instance _Beans_ of InvI
	(properties
		name { Beans }
		said '/bean'
		description {You are holding a handful of small beans.}
		view 509
	)
)

(instance logFile of File
	(properties)
)

(instance kqWindow of SysWindow ; UNUSED
	(properties
		top 20
	)
)

