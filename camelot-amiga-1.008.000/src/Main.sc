;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 0)
(include sci.sh)
(use n117)
(use Interface)
(use TalkObj)
(use EgoLooper)
(use bordWindow)
(use Sound)
(use Save)
(use Motion)
(use Game)
(use Inventory)
(use User)
(use Menu)
(use Actor)
(use System)

(public
	ARTHUR 0
	RedrawCast 1
	clr 2
	HandsOff 3
	HandsOn 4
	IsItemAt 5
	PutItem 6
	SetFlag 7
	ClearFlag 8
	IsFlag 9
	SetScore 10
	NotClose 11
	DontHave 12
	proc0_13 13
	Talk 14
	OnButton 15
	MouseClaimed 16
	Face 17
	proc0_18 18
	proc0_19 19
	proc0_20 20
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
	gVersion = {regMusic}
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
	global60
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
	gRmMusic
	; 105
	gRegMusic
	gSFX
	global107
	global108 = 2
	global109
	; 110
	global110
	gTObj
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
	gHorseStopWalk
	gHorseTurnLooper
	; 140
	global140
	global141
	global142
	global143
	global144
	; 145
	global145 = 5
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
	global157 = -1
	global158 = -1
	global159 = -1
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
	gMuleObj
	gHorseObj
	gMadMonk
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
	global201 = 20
	global202
	global203
	global204
	; 205
	global205
	global206
	global207
	global208
	global209
	; 210
	global210
	global211
	global212
	global213
	global214
	; 215
	global215
	global216
	global217
	global218
	global219
	; 220
	global220
	global221
	global222
	global223
	global224
	; 225
	global225
	global226
	global227
	global228
	global229
	; 230
	global230
	global231
	global232
	global233
	global234
	; 235
	global235
	global236
	global237
	global238
	global239
	; 240
	global240
	global241
	global242
	global243
	global244
	; 245
	global245
	global246
	global247
	global248
	global249
	; 250
	global250
	global251
	global252
	global253
	global254
	; 255
	global255
	global256
	global257
	global258
	global259
	; 260
	global260
	global261
	global262
	global263
	global264
	; 265
	global265
	global266
	global267
	global268
	global269
	; 270
	global270
	global271
	global272
	global273
	global274
	; 275
	global275
	global276
	global277
	global278
	global279
	; 280
	global280
	global281
	global282
	global283
	global284
	; 285
	global285
	global286
	global287
	global288
	global289
	; 290
	global290
	global291
	global292
	global293
	global294
	; 295
	global295
	global296
	global297
	global298
	global299
	; 300
	global300
)

(procedure (RedrawCast)
	(Animate (gCast elements:) 0)
)

(procedure (clr)
	(if gModelessDialog
		(gModelessDialog dispose:)
	)
)

(procedure (HandsOff)
	(= global80 1)
	(User canControl: 0 canInput: 0)
	(= global100 gWaitCursor)
	(gGame setCursor: gWaitCursor 1)
	(gEgo setMotion: 0)
)

(procedure (HandsOn)
	(= global80 0)
	(= global100 gNormalCursor)
	(gGame setCursor: gNormalCursor (HaveMouse))
	(User canControl: 1 canInput: 1)
)

(procedure (IsItemAt param1 param2)
	(return
		(== ((gInventory at: param1) owner:) (if (== argc 1) gCurRoomNum else param2))
	)
)

(procedure (PutItem param1 param2)
	((gInventory at: param1) owner: (if (== argc 1) gCurRoomNum else param2))
)

(procedure (SetFlag param1)
	(= [global250 (/ param1 16)]
		(| [global250 (/ param1 16)] (>> $8000 (mod param1 16)))
	)
)

(procedure (ClearFlag param1)
	(= [global250 (/ param1 16)]
		(& [global250 (/ param1 16)] (~ (>> $8000 (mod param1 16))))
	)
)

(procedure (IsFlag param1)
	(return (& [global250 (/ param1 16)] (>> $8000 (mod param1 16))))
)

(procedure (SetScore param1 param2 &tmp temp0 temp1 temp2)
	(= temp0 0)
	(cond
		((not param1)
			(= temp0 1)
		)
		((not (IsFlag param1))
			(SetFlag param1)
			(= temp0 1)
		)
	)
	(for ((= temp1 0)) (< temp1 (- argc 1)) ((+= temp1 2))
		(if temp0
			(= temp2 [param2 (+ temp1 1)])
			(switch [param2 temp1]
				(0
					(+= global210 temp2)
				)
				(1
					(+= global211 temp2)
				)
				(2
					(+= global212 temp2)
				)
			)
		)
	)
)

(procedure (proc0_19 &tmp [temp0 100]))

(procedure (NotClose)
	(Print 0 21) ; "Perhaps you should move closer."
)

(procedure (DontHave)
	(Print 0 22) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
)

(procedure (proc0_13 param1 &tmp temp0 temp1 temp2 temp3 temp4)
	(= temp0 (/ (& param1 $00f0) 16))
	(= temp2 (= temp3 (= temp4 (= temp1 (& param1 $000f)))))
	(switch (& param1 $0f00)
		(256
			(++ temp3)
			(++ temp4)
		)
		(512
			(++ temp2)
			(++ temp3)
		)
		(1024
			(++ temp2)
			(+= temp3 2)
		)
	)
	(c1 loop: temp0 cel: temp1)
	(c2 loop: temp0 cel: temp2)
	(c3 loop: temp0 cel: temp3)
	(c4 loop: temp0 cel: temp4)
	(gAddToPics add: c1 c2 c3 c4)
)

(procedure (Talk)
	(gTObj messages: &rest)
)

(procedure (OnButton param1 param2 param3 param4 param5)
	(if
		(and
			(== (param1 type:) 1)
			(< param2 (param1 x:) param4)
			(< param3 (param1 y:) param5)
		)
		(param1 claimed: 1)
	)
)

(procedure (MouseClaimed param1 param2)
	(if (MousedOn param1 param2 3)
		(param2 claimed: 1)
	)
)

(procedure (Face param1 param2 &tmp temp0)
	(= temp0 (param1 loop:))
	(DirLoop param1 (GetAngle (param1 x:) (param1 y:) (param2 x:) (param2 y:)))
	(if (!= temp0 (param1 loop:))
		(param1 forceUpd:)
		(RedrawCast)
	)
	(param1 setMotion: 0)
)

(procedure (proc0_18)
	(+= global122 global129)
	(+= global121 global130)
	(+= global120 global131)
	(= global129 (= global130 (= global131 0)))
	(= global132 0)
)

(procedure (proc0_20 param1 &tmp temp0)
	(= temp0 (DoSound sndCHECK_DRIVER))
	(return param1)
)

(instance regMusic of Sound
	(properties)
)

(instance rmMusic of Sound
	(properties
		priority 1
	)
)

(instance SFX of Sound
	(properties
		priority 2
	)
)

(instance tObj of TalkObj
	(properties)
)

(instance c1 of PV
	(properties
		view 550
		priority 15
		signal 16384
	)
)

(instance c2 of PV
	(properties
		y 170
		view 550
		priority 15
		signal 16384
	)
)

(instance c3 of PV
	(properties
		x 295
		view 550
		priority 15
		signal 16384
	)
)

(instance c4 of PV
	(properties
		y 170
		x 295
		view 550
		priority 15
		signal 16384
	)
)

(instance muleObj of Act
	(properties
		view 405
	)
)

(instance horseObj of Act
	(properties
		view 401
	)
)

(instance ego of Ego
	(properties)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(super handleEvent: event)
				(!= (event type:) evSAID)
				(IsFlag 75)
			)
			(return)
		)
		(= global140 0)
		(= global141 0)
		(if
			(and
				(= global141 (gInventory saidMe: event))
				(== (= global140 (gInventory indexOf: global141)) 0)
			)
			(= global140 1)
		)
		(event claimed: 0)
		(cond
			((and (IsFlag 3) (Said 'give,sell/shield,blade,excaliber,armor'))
				(Print 0 0) ; "It is vital to your continued existence. Which may not continue much longer with foolish notions like these."
			)
			((and global140 (not (gEgo has: global140)) (Said 'give,sell'))
				(Print 0 1) ; "How can you part with something you do not possess?"
			)
			((and global140 (not (gEgo has: global140)) (Said 'use'))
				(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
			)
		)
	)
)

(instance ARTHUR of Game
	(properties)

	(method (init &tmp temp0 temp1)
		(SysWindow color: 0 back: 15)
		(= global59 bordWindow)
		(super init:)
		(= gVersion {0.000.001})
		(if (!= (= temp1 (FOpen {version} 1)) -1)
			(FGets gVersion 6 temp1)
			(FClose temp1)
		)
		(= gEgo ego)
		(= gTObj tObj)
		(= gMuleObj muleObj)
		(= gHorseObj horseObj)
		((= gRegMusic regMusic) owner: self init:)
		((= gRmMusic rmMusic) owner: self init:)
		((= gSFX SFX) owner: self init:)
		(Animate 0)
		(ScriptID 961) ; StopWalk
		(Load rsFONT 0)
		(Load rsFONT 1)
		(Load rsFONT 4)
		(Load rsFONT 999)
		(Load rsCURSOR 997)
		(Load rsCURSOR 999)
		(User
			alterEgo: gEgo
			prompt: {Your bidding, M'Lord:}
			blocks: 0
			y: 155
		)
		(= gShowStyle 0)
		(= global156 0)
		(= global101 0)
		(MenuBar init: draw: hide:)
		(= global110 -1)
		(gGame setSpeed: 6)
		(HandsOn)
		(DoSound sndVOLUME 12)
		(self setCursor: gNormalCursor (HaveMouse) 300 170)
		(Inv init: add:)
		(Load rsVIEW 750)
		(Load rsPIC 112)
		(Load rsSCRIPT 112)
		((= global166 (ScriptID 120)) init:) ; inv1
		(Load rsSCRIPT 117)
		(Load rsSCRIPT 131)
		(Load rsSCRIPT 122)
		(Load rsSCRIPT 109)
		(= temp0 (if (GameIsRestarting) 1 else 112))
		(self newRoom: temp0)
	)

	(method (doit &tmp temp0 temp1)
		(if (and (GameIsRestarting) (gTObj tS1:))
			(gTObj doTalk:)
		else
			(gTObj doit:)
		)
		(super doit:)
		(cond
			(global109
				(if (== global110 -1)
					(= global110 gSpeed)
				)
				(gGame setSpeed: global109)
			)
			((and (!= global110 -1) (not global109))
				(gGame setSpeed: global110)
				(= global110 -1)
			)
		)
		(cond
			(
				(and
					(!= global100 gNormalCursor)
					(or (User controls:) (User canInput:))
				)
				(= global100 gNormalCursor)
				(gGame setCursor: gNormalCursor (HaveMouse))
			)
			(
				(and
					(== global100 gNormalCursor)
					(not (User controls:))
					(not (User canInput:))
				)
				(= global100 gWaitCursor)
				(gGame setCursor: gWaitCursor 1)
			)
		)
		(if (not (gEgo script:))
			(switch global125
				(1
					(gEgo setScript: (ScriptID 910 0)) ; DrawSword
				)
				(2
					(gEgo setScript: (ScriptID 910 1)) ; SheatheSword
				)
				(3
					(gEgo setScript: (ScriptID 912 1)) ; DoParry
				)
				(0
					(if global124
						(= temp1 (Event new:))
						(if
							(and
								(== (temp1 type:) evNULL)
								(& (temp1 modifiers:) emSHIFT)
								(User controls:)
							)
							(gEgo setScript: (ScriptID 912 1)) ; DoParry
						)
						(temp1 dispose:)
					)
				)
			)
		)
	)

	(method (startRoom param1 &tmp temp0 temp1)
		(DisposeScript 985)
		(DisposeScript 919)
		(DisposeScript 971)
		(DisposeScript 916)
		(DisposeScript 910)
		(DisposeScript 912)
		(DisposeScript 119)
		(DisposeScript 200)
		(DisposeScript 960)
		(if global156
			(global156 dispose:)
			(= global156 0)
		)
		((= global59 bordWindow)
			brLeft: 0
			brRight: 320
			brTop: 0
			brBottom: 120
			color: 15
			back: (if (< (Graph grGET_COLOURS) 16) 0 else 8)
		)
		(= temp1 0)
		(cond
			((or (>= 80 param1 67) (== param1 133) (== param1 92))
				(if (!= global143 2)
					(global166 dispose:)
					(= temp1 139)
				)
			)
			((and (> 90 param1 34) (!= global143 1))
				(= global145 (if (IsFlag 133) 4 else 5))
				(global166 dispose:)
				(= temp1 121)
			)
			((and (not (> 90 param1 34)) (!= global143 0))
				(= global145 5)
				(global166 dispose:)
				(= temp1 120)
			)
		)
		(Load rsSCRIPT param1)
		(if temp1
			(= global166 (ScriptID temp1))
			(global166 init:)
		)
		(= global80 0)
		(if (IsFlag 3)
			(SetMenu 1283 112 1)
		else
			(SetMenu 1283 112 0)
		)
		(if (gEgo has: 3) ; purse
			(SetMenu 1281 112 1)
		else
			(SetMenu 1281 112 0)
		)
		(User canControl: 1 canInput: (if global124 0 else 1))
		(if (!= global110 -1)
			(gGame setSpeed: global110)
			(= global110 -1)
		)
		(= global109 0)
		(= global112 0)
		(= global136 0)
		(MenuBar state: 1)
		(gRegMusic priority: 0)
		(if (== (gRegMusic state:) 0)
			(gRegMusic number: 0)
		)
		(rmMusic number: 0 priority: 1)
		(gSFX number: 0 priority: 2)
		(if (!= global116 1)
			(= temp0 EgoLooper)
		)
		(if (or (>= 90 param1 1) (== param1 103))
			(gEgo
				setLoop: -1
				setPri: -1
				setMotion: 0
				setCycle: Walk
				illegalBits: -32768
				cycleSpeed: 0
				moveSpeed: 0
				setStep: 3 2
				ignoreActors: 0
				looper: 0
			)
		)
		(if (IsFlag 3)
			(SetMenu 1283 112 1)
		)
		(if (gEgo has: 3) ; purse
			(SetMenu 1281 112 1)
		)
		(super startRoom: param1)
		(Load rsFONT 0)
		(Load rsFONT 1)
		(Load rsFONT 4)
		(Load rsVIEW 550)
		(Load rsVIEW (if (IsFlag 133) 508 else 507))
		(Load rsSCRIPT 910)
		(if
			(and
				(== (gEgo looper:) 0)
				(or
					(== (gEgo view:) 3)
					(== (gEgo view:) 0)
					(== (gEgo view:) 2)
				)
			)
			(gEgo looper: EgoLooper)
		)
	)

	(method (newRoom newRoomNumber)
		(if (gSounds contains: gRmMusic)
			(gRmMusic fade:)
		)
		(if (gSounds contains: gSFX)
			(gSFX stop:)
		)
		(clr)
		(gTObj endTalk: actor: 0)
		(super newRoom: newRoomNumber)
	)

	(method (handleEvent event &tmp temp0)
		(if
			(and
				global124
				(== global125 0)
				(== (event type:) evKEYBOARD)
				(== (event message:) KEY_SPACE)
				(not global80)
			)
			(event claimed: 1)
			(gEgo setScript: (ScriptID 912 0)) ; DoUseSword
			(return)
		)
		(if (and (== (event type:) evMOUSEBUTTON) (& (event modifiers:) emSHIFT))
			(if (not (User canInput:))
				(event claimed: 1)
			else
				(gCast eachElementDo: #handleEvent event)
				(if (event claimed:)
					(return)
				)
			)
		)
		(super handleEvent: event)
		(if (event claimed:)
			(return)
		)
		(switch (event type:)
			(evMOUSEBUTTON
				(cond
					((!= (gTObj tCount:) 0)
						(gTObj handleEvent: event)
					)
					((and (User canInput:) gModelessDialog)
						(event claimed: 1)
						(clr)
					)
				)
			)
			(evKEYBOARD
				(switch (event message:)
					(KEY_RETURN
						(cond
							((!= (gTObj tCount:) 0)
								(gTObj handleEvent: event)
							)
							((User canInput:)
								(event claimed: 1)
								(clr)
							)
						)
					)
				)
			)
			(evSAID
				(cond
					((and global141 (Said 'get>'))
						(cond
							(
								(and
									(gEgo has: global140)
									(== (global141 number:) 0)
								)
								(event claimed: 1)
								(Print 0 2) ; "It is in your possession."
							)
							(
								(and
									(!= (global141 owner:) 0)
									(not (IsItemAt global140))
								)
								(event claimed: 1)
								(Print 0 3) ; "That is not here."
							)
							(else
								(event claimed: 0)
							)
						)
					)
					(
						(or
							(Said 'pay')
							(Said 'give,count/coin,copper,dirham,dinar')
							(Said 'open/moneybag')
						)
						(cond
							((not (gEgo has: 3)) ; purse
								(Print 0 4) ; "If you had a purse, you would be able to acquire money to give away."
							)
							((not (DoPurse))
								(Print 800 (Random 29 34))
							)
							(else
								(Print 800 (Random 23 25))
							)
						)
						(proc0_18)
					)
					((or (Said 'give,exit/*>') (Said 'pay>'))
						(cond
							((Said '/dime,(coin<dime)')
								(Print 0 5) ; "Never heard of such a coin. Must be Turkish or some other heathen denomination."
							)
							((Said '/moneybag')
								(cond
									((not (gEgo has: 3)) ; purse
										(Print 0 6) ; "You cannot give away what you do not possess."
									)
									((== global122 global121 global120 0)
										(Print 0 7) ; "It may be empty now, but a man's fortune can change. Best to hold onto it."
									)
									(else
										(Print 0 8) ; "Think carefully before offering to give away all that you have."
									)
								)
							)
							(
								(or
									(and global140 (gEgo has: global140))
									(and (IsFlag 20) (Said '/ass'))
									(and (!= global116 0) (Said '/charger'))
								)
								(event claimed: 1)
								(Print 800 (Random 20 22))
							)
							(else
								(event claimed: 1)
								(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
							)
						)
					)
					(
						(and
							global141
							(== global140 2)
							(gEgo has: 2) ; lodestone
							(Said 'look,use')
						)
						(gGame setScript: (ScriptID 118)) ; Lode
					)
					((and (gEgo has: 4) (Said 'use/rose')) ; rose | apple | green_apple
						(Print 0 9) ; "To use it, you must recite the Message of the Rose."
					)
					((Said 'use/*')
						(if global140
							(Print 0 10) ; "I see no reason to use it now."
						else
							(Print 0 11) ; "You cannot use what you do not possess."
						)
					)
					((Said 'drop,drop,give/*')
						(Print 0 12) ; "You have no reason to do that."
					)
					((Said 'talk[/!*]')
						(Print 0 13) ; "Talk to whom?"
					)
					((Said 'talk/merlin')
						(Print 800 (Random 15 17))
					)
					((or (Said '*/charger') (Said '*//charger'))
						(cond
							((== global116 1)
								(Print 0 14) ; "There is no need."
							)
							((gCast contains: gHorseObj)
								(Print 0 15) ; "Your horse is here."
							)
							(else
								(Print 0 16) ; "Your horse is not here."
							)
						)
					)
					((or (Said 'search,get,find/ass') (Said 'search,look//ass'))
						(cond
							((gCast contains: gMuleObj)
								(Print 0 14) ; "There is no need."
							)
							((>= global202 2)
								(Print 0 17) ; "Mohammed has your mule."
							)
							(else
								(Print 0 18) ; "Nay, you can ill afford the time to do so. You must go on with your mission."
							)
						)
					)
					((or (Said '*/ass') (Said '*//ass'))
						(cond
							((gCast contains: gMuleObj)
								(Print 0 14) ; "There is no need."
							)
							((>= global202 2)
								(Print 0 17) ; "Mohammed has your mule."
							)
							(else
								(Print 0 19) ; "Your mule is not here."
							)
						)
					)
					(else
						((ScriptID 122) handleEvent: event) ; Rm0Saids
						(if (not (event claimed:))
							((ScriptID 109) handleEvent: event) ; Rm0Said2
						)
					)
				)
			)
		)
	)

	(method (replay)
		(MenuBar draw: hide:)
		(DoSound sndSET_SOUND (GetMenu 769 113))
		(super replay:)
	)

	(method (wordFail param1 &tmp [temp0 100])
		(if (IsFlag 75)
			(gCurRoom notify:)
		else
			(Print (Format @temp0 0 20 param1)) ; "The word "%s" sounds familiar, yet I cannot fathom your purpose in it."
		)
	)

	(method (syntaxFail)
		(if (IsFlag 75)
			(gCurRoom notify:)
		else
			(Print 800 (Random 5 6))
		)
	)

	(method (pragmaFail)
		(if (IsFlag 75)
			(gCurRoom notify:)
		else
			(Print 800 (Random 7 9))
		)
	)
)

