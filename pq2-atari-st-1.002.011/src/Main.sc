;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 0)
(include sci.sh)
(use Interface)
(use Avoid)
(use Sound)
(use Motion)
(use Game)
(use Inventory)
(use User)
(use Menu)
(use System)

(public
	PQ 0
	EgoDead 2
	Notify 3
	HaveMem 4
	RedrawCast 5
	clr 6
	proc0_7 7
	proc0_8 8
	proc0_9 9
	proc0_10 10
	HandsOff 11
	HandsOn 12
	proc0_13 13
	IsItemAt 14
	PutItem 15
	SetFlag 16
	ClearFlag 17
	IsFlag 18
	proc0_19 19
	NormalEgo 20
	SetScore 22
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
	gVersion = {diverClock}
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
	gSysWindow
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
	gRatObj
	gLightObj
	; 115
	global115
	gFKit
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
	global201
	global202
	global203
	global204
	; 205
	global205
	gContinuousMusic
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
)

(procedure (EgoDead)
	(HandsOff)
	(Wait 0)
	(Wait 150)
	(gSounds eachElementDo: #dispose)
	(music number: 2 play:)
	(repeat
		(switch
			(Print
				&rest
				#title
				{Jim shakes his head and says...}
				#width
				184
				#icon
				555
				0
				0
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

(procedure (Notify param1) ; UNUSED
	((ScriptID param1) notify: &rest)
)

(procedure (HaveMem param1)
	(return (> (MemoryInfo 0) param1)) ; LargestPtr
)

(procedure (RedrawCast)
	(Animate (gCast elements:) 0)
)

(procedure (clr)
	(if gModelessDialog
		(gModelessDialog dispose:)
	)
)

(procedure (proc0_7)
	(Print 0 32) ; "You're not close enough."
)

(procedure (proc0_8)
	(Print 0 33) ; "You already took it."
)

(procedure (proc0_10)
	(Print 0 34) ; "You can't do that now."
)

(procedure (proc0_9)
	(Print 0 35) ; "You don't have it."
)

(procedure (proc0_13)
	(Print 0 36) ; "You don't have your gun."
)

(procedure (HandsOff)
	(cond
		((== argc 1)
			(= global243 1)
		)
		(global243
			(= global244 1)
		)
	)
	(= global106 1)
	(User canControl: 0 canInput: 0)
	(gEgo setMotion: 0)
)

(procedure (HandsOn)
	(if (not global244)
		(= global106 0)
		(User canControl: 1 canInput: 1)
	)
	(if (== argc 1)
		(= global243 0)
		(= global244 0)
	)
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
	(|= [global250 (/ param1 16)] (>> $8000 (mod param1 16)))
)

(procedure (ClearFlag param1)
	(&= [global250 (/ param1 16)] (~ (>> $8000 (mod param1 16))))
)

(procedure (IsFlag param1)
	(return (& [global250 (/ param1 16)] (>> $8000 (mod param1 16))))
)

(procedure (proc0_19 param1 param2 param3)
	(switch argc
		(2
			(param1 setScript: param2)
		)
		(3
			(param1 script: param2)
			(param2 client: param1)
			(param2 changeState: param3)
		)
	)
	(while (param1 script:)
		(Animate (gCast elements:) 1)
		(if global58
			(= global58 0)
			(gCast eachElementDo: #motionCue)
		)
		(Wait 5)
	)
)

(procedure (NormalEgo)
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
	)
)

(procedure (SetScore param1 param2)
	(if (and (== argc 2) (IsFlag param2))
		(return)
	)
	(gGame changeScore: param1)
	(if (IsFlag 125)
		(ClearFlag 125)
	else
		(music number: 6 play:)
	)
	(if (== argc 2)
		(SetFlag param2)
	)
)

(instance diverClock of TO
	(properties)
)

(instance continuousMusic of Sound
	(properties)
)

(instance music of Sound
	(properties
		priority 10
	)
)

(instance statusCode of Code
	(properties)

	(method (doit param1)
		(Format param1 0 0 gScore gPossibleScore) ; "Score: %d of %d        Police Quest \06"
	)
)

(instance ego of Ego
	(properties)
)

(instance PQ of Game
	(properties)

	(method (init &tmp [temp0 21])
		(= gSysWindow (SysWindow new:))
		(super init:)
		(= global101 0)
		(= gEgo ego)
		(User alterEgo: gEgo blocks: 0 y: 155)
		(MenuBar init:)
		(SL code: statusCode)
		(= gPossibleScore 300)
		(= global158 700)
		(= global103
			(switch (Random 1 2)
				(1
					(Random 8 18)
				)
				(2
					(- 0 (Random 8 18))
				)
			)
		)
		(= global104
			(switch (Random 1 2)
				(1
					(Random 6 14)
				)
				(2
					(- 0 (Random 6 14))
				)
			)
		)
		(= global107 36)
		(= [global215 1] 7)
		(= [global215 2] 7)
		(= global133 1)
		(= global134 1)
		(= global136 1)
		(= global131 33)
		(= global156 -1)
		(= global190 (Random 1 3))
		(SetFlag 12)
		(= gVersion {1.002.011})
		(Inv
			add:
				hand_gun
				extra_ammo_clips
				key_ring
				unmarked_car_keys
				money_clip
				thank_you_letter
				death_threat
				wallet
				handcuffs
				wire_clippers
				field_kit
				potted_plant
				new_mug_shot
				hit_list
				makeshift_knife
				ear_protectors
				plane_ticket
				plaster_cast
				lost_badge
				thumbprint
				bullets
				empty_holster
				fingerprint
				old_mug_shot
				envelope_corner
				envelope
				jail_clothes
				motel_key
				vial_of_blood
				lipstick
				walkie_talkie
				jailer_s_revolver
				gas_mask
				bomb_instructions
				car_registration
				Colby_s_business_card
				note_from_Marie_s_door
				your_LPD_business_card
		)
		(gEgo get: 4) ; money_clip
		(HandsOn)
		(= gShowStyle 0)
		(DoSound sndVOLUME 15)
		(= gContinuousMusic continuousMusic)
		(gContinuousMusic owner: self number: 6 init:)
		(music owner: self number: 6 init:)
		(if (GameIsRestarting)
			(SetFlag 167)
			(self newRoom: 99)
		else
			(self newRoom: 99)
		)
	)

	(method (replay)
		(MenuBar draw:)
		(SL enable:)
		(if (DoSound sndSET_SOUND)
			(SetMenu 1282 113 0 110 {Turn Off})
		else
			(SetMenu 113 1 110 {Turn On})
		)
		(super replay:)
	)

	(method (wordFail param1 &tmp [temp0 40])
		(Printf 0 1 param1) ; "You will not need to use the word "%s" in this game."
	)

	(method (syntaxFail)
		(Print 0 2 #icon 555 1 0) ; "Please try a different way of saying that."
	)

	(method (pragmaFail &tmp [temp0 100])
		(Print 0 3) ; "I'm not sure what you want me to do."
	)

	(method (doit)
		(super doit:)
		(diverClock doit:)
		(= global241 (GetTime 1)) ; SysTime12
		(if (!= global242 global241)
			(= global242 global241)
			(if (> global158 1)
				(-- global158)
			)
			(if (> global159 1)
				(-- global159)
			)
		)
		(if (> global157 1)
			(-- global157)
		)
		(if (> global170 1)
			(-- global170)
		)
		(if (> global171 1)
			(-- global171)
		)
		(if (> global186 0)
			(-- global186)
		)
		(if (== global189 1)
			(diverClock set: 600)
			(= global189 2)
		)
		(if (and (== global189 2) (< (diverClock timeLeft:) 1))
			(= global189 3)
		)
		(if (== global189 10)
			(diverClock set: 500)
			(= global189 11)
		)
		(if (and (== global189 11) (< (diverClock timeLeft:) 1))
			(= global184 1)
			(= global189 12)
		)
	)

	(method (startRoom roomNum &tmp temp0 temp1 temp2 [temp3 50])
		(while ((= temp2 (Event new:)) type:)
			(temp2 dispose:)
		)
		(temp2 dispose:)
		(DisposeScript 301)
		(DisposeScript 976)
		(if (and (!= roomNum 13) (!= roomNum 33))
			(= temp1 Avoid)
		else
			(DisposeScript 985)
		)
		(if
			(and
				global101
				(u> (MemoryInfo 1) (+ 20 (MemoryInfo 0))) ; FreeHeap, LargestPtr
				(Print 0 4 #button {Debug} 1) ; "Memory fragmented."
			)
			(SetDebug)
		)
		(= global211 1)
		(= global212 2)
		(if
			(and
				(!= roomNum 1)
				(!= roomNum 13)
				(!= roomNum 14)
				(!= roomNum 22)
				(!= roomNum 25)
				(!= roomNum 225)
				(!= roomNum 27)
				(!= roomNum 29)
				(!= roomNum 31)
				(!= roomNum 33)
				(!= roomNum 61)
				(!= roomNum 67)
			)
			(SetMenu 777 112 0)
		else
			(SetMenu 777 112 1)
		)
		(= global132 0)
		(if (and (< global186 250) global188)
			(= global188 2)
		)
		(super startRoom: roomNum)
		(if
			(and
				global204
				(!= (gEgo view:) 7)
				(!= (gEgo view:) 306)
				(!= (gEgo view:) 6)
			)
			(= global204 0)
		)
		(if global214
			(= global214 0)
			(HandsOn 1)
			(switch (gEgo view:)
				(4
					(gEgo view: 0)
				)
				(5
					(gEgo view: 1)
				)
			)
		)
		(if (and (!= roomNum 13) (!= roomNum 33))
			(gCurRoom setLocales: 150)
		)
		(if global101
			(gCurRoom setLocales: 801)
		)
		(Load rsSOUND 6)
	)

	(method (handleEvent event &tmp temp0 [temp1 53])
		(super handleEvent: event)
		(if (event claimed:)
			(return)
		)
		(switch (event type:)
			(evSAID
				(cond
					((and (Said 'kiss/angel>') (Said '/death'))
						(event claimed: 1)
						(if (^= global101 $0001)
							(gCurRoom setLocales: 801)
						)
					)
					((Said 'frisk,(look<in,through)/billfold')
						(if (not (gEgo has: 7)) ; wallet
							(proc0_9) ; "You don't have it."
						else
							(Print 800 50) ; "In the back of your wallet you find your scuba diving certificate."
							(SetScore 2 58)
							(SetFlag 33)
						)
					)
					((Said 'open/billfold')
						(if (gEgo has: 7) ; wallet
							((gInventory at: 7) showSelf:) ; wallet
						else
							(proc0_9) ; "You don't have it."
						)
					)
					(
						(or
							(Said 'kiss,fuck,shit,cunt,cocksucker,leak')
							(Said '/fuck,shit,cunt,cocksucker,leak')
							(Said 'eat/shit,and,die')
						)
						(Print 800 (Random 0 7))
					)
					((Said 'read/instruction,newspaper')
						(if (gEgo has: 33) ; bomb_instructions
							(Print 800 53 #font gSmallFont) ; "KUDOFI'S DO-IT-YOURSELF BOMB  Connect yellow wire for timer.  Connect white for backup battery.  Disconnect yellow wire.  Connect purple wire and blue wire  for main battery.  Set timer.  Connect yellow wire.  Bomb is now armed. Do not move or  touch wires! WARNING: Only connect same color wires.  Connecting wires in any other order  may result in immediate detonation."
						else
							(proc0_9) ; "You don't have it."
						)
					)
					(
						(Said
							'look,compare,check/handwriting,note,handwriting[<hand]'
						)
						(if (gEgo has: 36) ; note_from_Marie_s_door
							(SetScore 3 90)
							(Print 0 5 #at -1 15 #icon 136 0 0) ; "Looking closer at the note, you think..."This is definitely NOT Marie's handwriting!!""
						else
							(proc0_9) ; "You don't have it."
						)
					)
					((Said 'yell')
						(Print 0 6) ; "Talk in a normal voice, please."
					)
					((Said 'talk>')
						(cond
							((Said '/friend')
								(cond
									((== gCurRoomNum 13)
										(Print 800 (Random 10 15))
									)
									(
										(or
											(not (gCast contains: global112))
											(not
												(global112
													inRect: -10 -10 340 240
												)
											)
										)
										(Print 0 7) ; "Keith is not here."
									)
									((> (gEgo distanceTo: global112) 30)
										(Print 0 8) ; "Keith is not close enough to talk to."
									)
									(else
										(Print 800 (Random 10 15))
									)
								)
							)
							((Said '/!*')
								(Print 0 9) ; "To whom?"
							)
							(else
								(event claimed: 1)
								(Print 0 10) ; "You don't need to."
							)
						)
					)
					((or (Said '[say]/hello') (Said 'smile,wave'))
						(Print 0 11) ; "Hi."
					)
					((Said '[say]/bye')
						(Print 0 12) ; "`Bye."
					)
					((Said 'open/door')
						(proc0_10) ; "You can't do that now."
					)
					(
						(or
							(Said 'use,remove/powder,brush')
							(Said 'drop,apply,use/powder,dust')
							(Said 'dust,powder[/*]')
							(Said 'get,remove,hoist/fingerprint,print[<finger]')
							(Said 'open,use,look/briefcase')
						)
						(if (== global100 14)
							(Print 0 13) ; "In the confusion, your kit was checked on another plane, and you don't have it."
						else
							(Print 0 14) ; "You have no reason to do that."
						)
					)
					((Said 'get/*')
						(event claimed: 0)
						(if
							(and
								(= temp0 (gInventory saidMe: event))
								(== (temp0 owner:) gEgo)
							)
							(proc0_8) ; "You already took it."
						else
							(event claimed: 1)
							(Print 0 15) ; "You can't get that."
						)
					)
					((Said 'use/*')
						(Print 0 16) ; "What use do you intend?"
					)
					((Said 'drop,drop/*')
						(Print 0 14) ; "You have no reason to do that."
					)
					((Said 'ask>')
						(cond
							((Said '/!*')
								(Print 0 17) ; "Ask whom?"
							)
							((Said '//!*')
								(Print 0 18) ; "About what?"
							)
						)
					)
					((Said 'eat/9mm')
						(Print 0 19) ; "Come on Sonny. Don't give up so easy!"
					)
					((Said 'eat')
						(Print 0 20) ; "You're not hungry right now."
					)
					((Said 'turn/card')
						(cond
							((not (gEgo has: 37)) ; your_LPD_business_card
								(proc0_9) ; "You don't have it."
							)
							((your_LPD_business_card cel:)
								(your_LPD_business_card cel: 0 showSelf:)
							)
							(else
								(your_LPD_business_card cel: 1 showSelf:)
							)
						)
					)
					((or (Said 'thank') (Said '/thanks'))
						(Print 0 21) ; "You're welcome!"
					)
					((Said '/oop,oop')
						(Print 0 22) ; "That's OK."
					)
					((Said 'yes,no')
						(Print 0 23) ; "No one responds."
					)
					((Said 'sat')
						(Print 0 10) ; "You don't need to."
					)
					((Said 'hit,kill,fire,hit')
						(Print 0 24) ; "Don't be so violent, Sonny."
					)
					((Said 'cigarette')
						(Print 800 51) ; "Smoking is a nasty habit, but Keith just can't seem to quit."
					)
					((Said 'give[/*]')
						(Print 0 14) ; "You have no reason to do that."
					)
					((Said 'frisk>')
						(if (Said '/!*')
							(Print 0 25) ; "Search what?"
						else
							(event claimed: 1)
							(Print 0 26) ; "You don't find anything interesting."
						)
					)
					((Said 'look,read>')
						(cond
							((or (Said '/pocket<coat') (Said '/coat<pocket'))
								(event claimed: 0)
							)
							((Said '/pocket')
								(Print 0 27) ; "It's empty."
							)
							((Said '/certificate')
								(if (IsFlag 33)
									(Print 800 49 #icon 164 0 0) ; "Your scuba diving certificate."
								else
									(Print 800 52) ; "You remember seeing it somewhere, but you don't remember where it is."
								)
							)
							((or (Said '<back/card') (Said '/back/card'))
								(if (gEgo has: 37) ; your_LPD_business_card
									(your_LPD_business_card cel: 1 showSelf:)
								else
									(proc0_9) ; "You don't have it."
								)
							)
							((or (Said '<front/card') (Said '/front/card'))
								(if (gEgo has: 37) ; your_LPD_business_card
									(your_LPD_business_card cel: 0 showSelf:)
								else
									(proc0_9) ; "You don't have it."
								)
							)
							((Said '/friend')
								(if
									(or
										(and
											(gCast contains: global112)
											(<
												(gEgo distanceTo: global112)
												150
											)
										)
										(== gCurRoomNum 13)
									)
									(Print 800 (Random 20 24))
								else
									(Print 0 7) ; "Keith is not here."
								)
							)
							(
								(or
									(Said
										'/bains,john,dooley,lloyd,gelepsi,captain,hall,james,pierson'
									)
									(Said
										'/simpson,bob,adams,cole,jerome,ken,ken,saxton,luis'
									)
									(Said
										'/roberts,calvin,calvin,willis,jerk,diver,chuck,colby,miller'
									)
								)
								(Print 0 28) ; "You don't see him here."
							)
							((Said '/kim,holt,gomez,cheeks,cheeks,holt')
								(Print 0 29) ; "You don't see her here."
							)
							((Said '/boob')
								(if
									(or
										(== gCurRoomNum 3)
										(== gCurRoomNum 6)
										(== gCurRoomNum 61)
										(== gCurRoomNum 30)
										(== gCurRoomNum 40)
									)
									(Print 0 30) ; "Not bad!"
								else
									(Print 0 31) ; "You don't see that here."
								)
							)
							((Said '/clock,wrist,time')
								(Print 800 9) ; "It appears that Mickey's little battery has given its last burp."
							)
							((= temp0 (gInventory saidMe: event))
								(if (gEgo has: (gInventory indexOf: temp0))
									(temp0 showSelf:)
								else
									(proc0_9) ; "You don't have it."
								)
							)
							(else
								(event claimed: 1)
								(Print 800 (Random 30 32))
							)
						)
					)
				)
			)
		)
	)
)

(class Iitem of InvI
	(properties)

	(method (showSelf)
		(Print 899 (- view 100) #title name #icon view 0 cel)
	)
)

(instance hand_gun of Iitem
	(properties
		name {hand gun}
		said '/9mm[<hand]'
		owner 5
		view 100
	)
)

(instance extra_ammo_clips of Iitem
	(properties
		name {extra ammo clips}
		said '/ammo,(clip[<ammo])'
		owner 5
		view 101
	)

	(method (ownedBy param1)
		(switch global207
			(0
				(= cel (+ 2 (> [global215 1] 0) (> [global215 2] 0)))
			)
			(1
				(= cel (> [global215 2] 0))
			)
			(else
				(= cel (> [global215 1] 0))
			)
		)
		(super ownedBy: param1)
	)
)

(instance key_ring of Iitem
	(properties
		name {key ring}
		said '/ring<key'
		view 102
	)

	(method (saidMe param1)
		(if (and (gEgo has: 3) (Said '/key')) ; unmarked_car_keys
			(param1 claimed: 0)
			(return 0)
		else
			(return (or (Said '/key') (Said said)))
		)
	)
)

(instance unmarked_car_keys of Iitem
	(properties
		name {unmarked car keys}
		said '/key[<auto]'
		owner 4
		view 103
	)
)

(instance money_clip of InvI
	(properties
		name {money clip}
		said '/coat,(pocket<coat),cash,(clip[<cash])'
		view 104
	)

	(method (showSelf &tmp [temp0 40])
		(Print
			(Format @temp0 0 37 global107) ; "You have $%u cash in your money clip."
			#title
			name
			#icon
			view
			0
			(if (== global107 0) 1 else 0)
		)
	)
)

(instance thank_you_letter of Iitem
	(properties
		name {thank you letter}
		said '/letter[<you<thank]'
		owner 12
		view 105
	)
)

(instance death_threat of Iitem
	(properties
		name {death threat}
		said '/threat,note<death'
		owner 28
		view 106
	)
)

(instance wallet of Iitem
	(properties
		said '/billfold,badge,(card<badge)'
		owner 12
		view 107
	)

	(method (saidMe param1)
		(if (and (gEgo has: 18) (Said '/badge')) ; lost_badge
			(param1 claimed: 0)
			(return 0)
		else
			(return (Said said))
		)
	)
)

(instance handcuffs of Iitem
	(properties
		said '/arrest'
		owner 5
		view 108
	)
)

(instance wire_clippers of Iitem
	(properties
		name {wire clippers}
		said '/clipper,clipper'
		view 109
	)
)

(instance field_kit of Iitem
	(properties
		name {field kit}
		said '/briefcase[<field]'
		owner 2
		view 110
	)
)

(instance potted_plant of Iitem
	(properties
		name {potted plant}
		said '/flower,rose,plant,bouquet'
		owner 15
		view 111
	)

	(method (ownedBy param1)
		(switch cel
			(0
				(= name {potted plant})
			)
			(1
				(= name {rose})
			)
			(2
				(= name {bouquet})
			)
		)
		(super ownedBy: param1)
	)

	(method (showSelf &tmp [temp0 40])
		(Print
			(Format ; "A %s you bought at Lytton airport."
				@temp0
				0
				38
				(switch cel
					(0 {potted plant})
					(1 {single long-stemmed rose})
					(2 {bouquet})
				)
			)
			#title
			name
			#icon
			view
			loop
			cel
		)
	)
)

(instance new_mug_shot of Iitem
	(properties
		name {new mug shot}
		said '/mugshot,(shot<mug)'
		owner 23
		view 112
	)

	(method (saidMe param1)
		(cond
			((!= owner gEgo)
				(return 0)
			)
			((or (Said '/mugshot<old') (Said '/shot<mug<old'))
				(param1 claimed: 0)
				(return 0)
			)
			(else
				(return (Said said))
			)
		)
	)
)

(instance hit_list of Iitem
	(properties
		name {hit list}
		said '/list[<body,hit]'
		owner 32
		view 113
	)
)

(instance makeshift_knife of Iitem
	(properties
		name {makeshift knife}
		said '/knife'
		owner 64
		view 114
	)
)

(instance ear_protectors of Iitem
	(properties
		name {ear protectors}
		said '/ep[<ear]'
		owner 10
		view 115
	)
)

(instance plane_ticket of InvI
	(properties
		name {plane ticket}
		said '/ticket[<airplane]'
		view 116
	)

	(method (showSelf &tmp [temp0 40])
		(Print
			(Format @temp0 0 39 (if (== global195 1) {Steelton} else {Houston})) ; "An airplane ticket to %s."
			#title
			name
			#icon
			view
			0
			0
		)
	)
)

(instance plaster_cast of Iitem
	(properties
		name {plaster cast}
		said '/cast,(print<feet)'
		view 117
	)
)

(instance lost_badge of Iitem
	(properties
		name {lost badge}
		said '/badge'
		owner 63
		view 118
	)
)

(instance thumbprint of Iitem
	(properties
		said '/thumb,(print<thumb)'
		view 119
	)
)

(instance bullets of Iitem
	(properties
		said '/bullet'
		owner 68
		view 120
	)
)

(instance empty_holster of Iitem
	(properties
		name {empty holster}
		said '/gunbelt'
		owner 68
		view 121
	)
)

(instance fingerprint of Iitem
	(properties
		said '/(print<finger),fingerprint'
		view 122
	)
)

(instance old_mug_shot of Iitem
	(properties
		name {old mug shot}
		said '/mugshot,(shot<mug)'
		owner 7
		view 123
	)
)

(instance envelope_corner of Iitem
	(properties
		name {envelope corner}
		said '/corner[<envelope]'
		owner 28
		view 124
	)
)

(instance envelope of Iitem
	(properties
		said '/envelope'
		owner 26
		view 125
	)
)

(instance jail_clothes of Iitem
	(properties
		name {jail clothes}
		said '/cloth'
		owner 62
		view 126
	)
)

(instance motel_key of Iitem
	(properties
		name {motel key}
		said '/key<inn'
		owner 25
		view 127
	)
)

(instance vial_of_blood of Iitem
	(properties
		name {vial of blood}
		said '/vial,blood,sample[<blood]'
		owner 26
		view 128
	)
)

(instance lipstick of Iitem
	(properties
		said '/television,(baton<lip),lipstick'
		owner 26
		view 129
	)
)

(instance walkie_talkie of Iitem
	(properties
		name {walkie talkie}
		said '/(talkie[<walkie]),extender'
		owner 101
		view 130
	)
)

(instance jailer_s_revolver of Iitem
	(properties
		name {jailer's revolver}
		said '/revolver,(9mm<jailer)'
		owner 19
		view 131
	)
)

(instance gas_mask of Iitem
	(properties
		name {gas mask}
		said '/mask[<gas]'
		owner 126
		view 132
	)
)

(instance bomb_instructions of Iitem
	(properties
		name {bomb instructions}
		said '/instruction[<bomb]'
		view 133
	)
)

(instance car_registration of Iitem
	(properties
		name {car registration}
		said '/registration'
		view 134
	)
)

(instance Colby_s_business_card of Iitem
	(properties
		name {Colby's business card}
		said '/(card<business<colby),(card<colby)'
		owner 26
		view 135
	)

	(method (saidMe param1)
		(if (and (gEgo has: 37) (Said '/card[<!*]')) ; your_LPD_business_card
			(param1 claimed: 0)
			(return 0)
		else
			(return (or (Said '/card[<!*]') (Said said)))
		)
	)
)

(instance note_from_Marie_s_door of Iitem
	(properties
		name {note from Marie's door}
		said '/note[<door]'
		owner 31
		view 136
	)
)

(instance your_LPD_business_card of Iitem
	(properties
		name {your LPD business card}
		said '/card[<business]'
		owner 33
		view 137
	)
)

