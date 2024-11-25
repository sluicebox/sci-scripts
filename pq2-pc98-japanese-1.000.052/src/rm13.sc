;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm13 0
	proc13_1 1
)

(synonyms
	(console dash)
	(drive go)
)

(local
	[local0 200]
	local200
	local201
	local202
	local203
	local204
	local205
	local206
	local207
	local208
	local209
	local210
	local211
	local212
	local213
	local214
	local215
	local216
	local217
	local218
	local219
	local220
	local221
	local222
)

(procedure (proc13_1)
	(if (and (== local210 local208) (== local211 local209))
		(NormalEgo)
		(Print 13 0) ; "OK, we're getting out."
		(if (and (== local204 25) (IsFlag 165))
			(= local204 225)
		)
		(NormalEgo)
		(gCurRoom newRoom: local204)
	else
		(Print 13 1) ; "Wait until the car has stopped moving."
	)
)

(procedure (localproc_0)
	(lines startUpd:)
	(extraScene hide:)
	(rightScene startUpd:)
	(leftScene startUpd:)
	(= local203 1)
	(= global130 13)
	(SetFlag 40)
	(= local217 300)
	(= local218 20)
)

(procedure (localproc_1)
	(= local219 0)
	(= local213 0)
	(DrawCel 180 4 0 4 145 15)
)

(procedure (localproc_2 param1)
	(localproc_1)
	(= local219 10)
	(= local213 1)
	(Print &rest)
)

(instance hand of View
	(properties)
)

(instance cig of Prop
	(properties)
)

(instance puff of Prop
	(properties)
)

(instance rightScene of Prop
	(properties)
)

(instance leftScene of Prop
	(properties)
)

(instance extraScene of Prop
	(properties)
)

(instance lines of Prop
	(properties)
)

(instance scanner of Prop
	(properties)
)

(instance sonny of PV
	(properties
		y 105
		x 63
		view 71
		priority 13
	)
)

(instance keithBud of PV
	(properties
		y 107
		x 247
		view 71
		cel 1
		priority 13
	)
)

(instance sShoulder of PV
	(properties
		y 141
		x 99
		view 71
		cel 4
		priority 13
	)
)

(instance kShoulder of PV
	(properties
		y 137
		x 208
		view 71
		cel 5
		priority 13
	)
)

(instance wheel of PV
	(properties
		y 130
		x 113
		view 71
		cel 2
		priority 12
	)
)

(instance street of PV
	(properties
		y 101
		x 154
		view 71
		loop 5
		priority 1
	)
)

(instance rm13 of Rm
	(properties
		picture 13
		style 0
	)

	(method (init)
		(HandsOff)
		(User canInput: 1)
		(Load rsVIEW 71)
		(Load rsVIEW 200)
		(Load rsVIEW 180)
		(Load rsSOUND 5)
		(= local214 1)
		(= global131 13)
		(= local203 0)
		(= global204 0)
		(= local204 gPrevRoomNum)
		(= local210
			(switch gPrevRoomNum
				(14 0)
				(25 40)
				(225 40)
				(29 80)
				(67 100)
				(61 122)
				(22 90)
				(31 30)
				(27 62)
				(1 110)
			)
		)
		(= local209
			(= local211
				(switch gPrevRoomNum
					(14 62)
					(25 100)
					(29 100)
					(67 100)
					(61 12)
					(22 10)
					(31 60)
					(27 50)
					(1 40)
				)
			)
		)
		(= local208 local210)
		(= local205
			(switch local210
				(0 329)
				(40 332)
				(80 331)
				(100 328)
				(122 326)
				(90 334)
				(30 333)
				(62 330)
				(110 327)
			)
		)
		(Load rsVIEW local205)
		(= local217 300)
		(gEgo
			setPri: 0
			setLoop: -1
			setCel: -1
			posn: -100 0
			setMotion: 0
			ignoreActors: 0
			illegalBits: $8000
			init:
		)
		(hand view: 71 posn: 129 149 loop: 0 cel: 3 setPri: 13 init: stopUpd:)
		(lines
			view: 71
			posn: 149 101
			setPri: 2
			setLoop: 4
			setCycle: Fwd
			init:
			stopUpd:
		)
		(leftScene
			view: 200
			posn: 114 93
			setPri: 0
			setLoop: 0
			cel: 1
			setCycle: Fwd
			init:
			stopUpd:
		)
		(rightScene
			view: 200
			posn: 201 93
			setPri: 0
			setLoop: 1
			setCycle: Fwd
			init:
			stopUpd:
		)
		(extraScene
			view: local205
			setLoop: 0
			setCel: 0
			posn: 155 100
			setPri: 3
			setLoop: 0
			init:
			stopUpd:
		)
		(SL enable:)
		(super init:)
		(self setScript: rm13Script)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if (event claimed:)
			(return)
		else
			(switch (event type:)
				(evMOUSEBUTTON
					(if local213
						(event claimed: 1)
						(localproc_1)
						(if (not local214)
							(sequencer cue:)
						)
					else
						(event claimed: 0)
					)
				)
			)
		)
	)
)

(instance rm13Script of Script
	(properties)

	(method (doit)
		(if local200
			(Print 13 2) ; "globalStr overflow!"
		)
		(cond
			((and local213 (== local219 1))
				(localproc_1)
				(if (not local214)
					(sequencer cue:)
				)
			)
			((and local213 (> local219 0))
				(-- local219)
			)
		)
		(if (and (or (== global159 1) (== global158 1)) (not local216))
			(= local216 1)
			(User canInput: 0)
			(sequencer changeState: 105)
		)
		(if (> local222 1)
			(-- local222)
		)
		(if (== local222 1)
			(= local222 0)
			(self changeState: 1)
		)
		(if local203
			(if (> global110 20)
				(cond
					((<= (hand y:) 148)
						(hand posn: 129 (+ (hand y:) 1))
					)
					((>= (hand y:) 154)
						(hand posn: 129 (- (hand y:) 1))
					)
					(else
						(hand posn: 129 (+ (hand y:) (Random -2 2)))
					)
				)
			)
			(if (not local213)
				(if (> local218 1)
					(-- local218)
				)
				(cond
					((> local210 local208)
						(-- local210)
					)
					((< local210 local208)
						(++ local210)
					)
					((> local211 local209)
						(-- local211)
					)
					(else
						(if local202
							(EgoDead 13 3)
						)
						(if (< local211 local209)
							(++ local211)
						else
							(User canInput: 0)
							(if local203
								(if (not local220)
									(sequencer changeState: 91)
									(= local220 1)
								)
								(if local214
									(if (and (== local204 25) (IsFlag 165))
										(= local204 225)
									)
									(if
										(and
											(== local204 61)
											(not (IsFlag 19))
											(== global100 5)
										)
										(sequencer changeState: 8)
									)
									(NormalEgo)
									(gContinuousMusic loop: 1 fade:)
									(NormalEgo)
									(gCurRoom newRoom: local204)
								)
							)
						)
					)
				)
			)
		else
			(lines stopUpd:)
			(rightScene stopUpd:)
			(leftScene stopUpd:)
			(if (> local217 0)
				(-- local217)
			)
			(if (and (== local217 1) (not local213))
				(= local217 200)
				(cond
					((IsFlag 1)
						(localproc_2 1 13 4) ; "What do you want me to tell dispatch, Sonny?"
					)
					((Random 0 1)
						(localproc_2 1 13 5) ; "Keith blurts out... "Stop daydreaming and drive somewhere, partner!""
					)
					(else
						(localproc_2 1 13 6) ; "Keith pipes up, "Well, buddy-boy, let's get this show on the road!""
					)
				)
			)
		)
		(if (== local218 1)
			(= local218 0)
			(cond
				((and (not (IsFlag 15)) (== global100 1))
					(if (== local204 22)
						(sequencer changeState: 1)
					else
						(= local218 15)
					)
				)
				((and (not (IsFlag 16)) (== global100 2))
					(sequencer changeState: 74)
					(= local218 20)
				)
				((and (IsFlag 16) (not (IsFlag 17)))
					(sequencer changeState: 5)
				)
				((and (not local201) (== global100 4))
					(sequencer changeState: 79)
					(= local218 25)
				)
				((and (not (IsFlag 21)) (== global100 6))
					(sequencer changeState: 36)
				)
				((and (not (IsFlag 22)) (== global100 6) (== gPrevRoomNum 14))
					(sequencer changeState: 53)
					(= local218 25)
				)
				((and (IsFlag 22) (gEgo has: 11) (not (IsFlag 23))) ; potted_plant
					(sequencer changeState: 54)
				)
				((and (not (IsFlag 24)) (== global100 10))
					(sequencer changeState: 57)
				)
				((and (not (IsFlag 27)) global127 (== gPrevRoomNum 31))
					(sequencer changeState: 63)
				)
				((and (not (IsFlag 28)) (IsFlag 52))
					(sequencer changeState: 68)
				)
			)
			(if (not local218)
				(if (not (> 20 (- local211 local209) -20))
					(= local211 (+ local209 16))
				)
				(if (not (> 20 (- local210 local208) -20))
					(= local210 (+ local208 16))
				)
			)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gAddToPics
					add: sonny keithBud sShoulder kShoulder wheel street
					doit:
				)
				(scanner
					view: 71
					posn: 159 141
					cycleSpeed: 1
					setCycle: Fwd
					setLoop: 6
					setPri: 13
					init:
					setScript: sequencer
				)
				(if (< global110 30)
					(scanner stopUpd: setScript: 0)
				)
				(cig
					view: 71
					posn: 215 81
					setLoop: 2
					cycleSpeed: 1
					setCycle: Fwd
					setPri: 12
					init:
				)
				(puff
					view: 71
					posn: 205 97
					cycleSpeed: 2
					setCycle: Fwd
					setLoop: 3
					setPri: 13
					init:
				)
				(if (< global110 30)
					(cig stopUpd:)
					(puff posn: 1000 1000 stopUpd:)
				)
				(self cue:)
			)
			(1
				(if (< global110 30)
					(self cue:)
				else
					(puff setCycle: End self)
				)
			)
			(2
				(= local222 (Random 20 70))
			)
		)
	)

	(method (handleEvent event &tmp temp0)
		(if (event claimed:)
			(return)
		)
		(switch (event type:)
			(evKEYBOARD
				(if
					(or
						(== (= temp0 (event message:)) KEY_F6)
						(== temp0 KEY_F8)
						(== temp0 KEY_F10)
					)
					(Print 13 7) ; "You don't need your gun in the car. Keith's friendly."
					(event claimed: 1)
				else
					(event claimed: 0)
				)
				(if (== temp0 KEY_RETURN)
					(if local213
						(event claimed: 1)
						(localproc_1)
						(if (not local214)
							(sequencer cue:)
						)
					else
						(event claimed: 0)
					)
				)
				(event claimed: (not local214))
			)
			(evSAID
				(cond
					((Said '/too<me')
						(Print 13 8) ; "Keith nods."
					)
					(
						(or
							(Said 'talk[/friend,man]')
							(Said 'stop,japanesestop/friend,man,cigarette')
							(Said '/cigarette')
						)
						(sequencer changeState: 113)
					)
					((Said 'check,frisk,look/gauge<gas,gas')
						(Print 13 9) ; "The needle is stuck on 'F'."
					)
					((Said 'look,read/memo,list')
						(Print 13 10) ; "The grocery list is Keith's. It has only one item: "cigarettes"."
					)
					(
						(Said
							'(turn[<on]),japaneseturnon,start[/key,auto,ignition,engine]'
						)
						(Print 13 11) ; "The old V8 engine is running a little rough."
					)
					(
						(Said
							'stop,((switch,turn)<off),japaneseturnoff[/engine,auto]'
						)
						(if (== local208 local210)
							(Print 13 12) ; "The car's engine is off."
						else
							(Print 13 13) ; "It would probably be a good idea to wait until you've arrived."
						)
					)
					((Said '/box,compartment')
						(Print 13 14) ; "Keith keeps a carton of cigarettes in the glovebox. He doesn't like anyone messing with his 'stash'."
					)
					((Said '/siren,(3<code)')
						(Print 13 15) ; "You don't need the siren right now."
					)
					((Said '/lamp,light[<read]')
						(Print 13 16) ; "The light is for night work."
					)
					((Said 'look,japaneselookback>')
						(cond
							((Said '/speedometer,speed')
								(if local203
									(Print 13 17) ; "Your speedometer indicates you're within the local 35 mph speed limit."
								else
									(Print 13 18) ; "You're getting nowhere fast."
								)
							)
							(
								(or
									(Said 'japaneselookback')
									(Said '/back,(bench<back)')
								)
								(Print 13 19) ; "You see an adventure gamer looking over your shoulder."
							)
							((Said '/light[<read]')
								(Print 13 20) ; "The light is for night work, and has a shade to avoid detection during stake-outs."
							)
							((Said '/tray,ashtray')
								(Print 13 21) ; "The ash tray is full of Keith's smelly old butts. You really should clean it out, but not right now."
							)
							((Said '/pane')
								(Print 13 22) ; "Outside the car's window, you see..."
								(if local203
									(Print 13 23) ; "... the streets of Lytton as they fly by."
								else
									(switch local210
										(0
											(Print 13 24) ; "... the newly built Lytton Airport parking lot and terminal building."
										)
										(40
											(Print 13 25) ; "Snuggler's Inn. Sleazy and cheap, it's a motel for the down-and-out."
										)
										(80
											(Print 13 26) ; "Arnie's restaurant. Their food is good, and the service is adequate."
										)
										(100
											(Print 13 27) ; "Oak Tree Mall. This is Lytton's major shopping area."
										)
										(122
											(Print 13 28) ; "Cotton Cove. It's a poorly-kept-up park. It holds many fond memories from your youth."
										)
										(90
											(Print 13 29) ; "... the underground parking structure of the new Lytton Justice Building. The city jail's entrance is nearby."
										)
										(30
											(Print 13 30) ; "... a typical American neighborhood. You're parked in front of Marie Wilkan's house."
										)
										(62
											(Print 13 31) ; "... the warehouse district. A lot goes down around here, free from prying eyes."
										)
										(110
											(Print 13 32) ; "... the Lytton Police Station and parking lot. The detective's entrance is nearby."
										)
										(else
											(Print 13 33) ; "nothing mutch."
										)
									)
								)
							)
							((Said '/japanesemiller')
								(Print 13 34) ; "That's good driving practice. Tail-gaters can be dangerous."
							)
							((Said '/console')
								(Print 13 35) ; "The dashboard is cluttered with various necessary items: police radio, note pad, reading light, and Keith's pack of cigarettes."
							)
							((Said '/extender,scanner')
								(Print 13 36) ; "The police radio scans the emergency frequencies, constantly in search of new developments."
							)
							((Said '/memo,clipboard')
								(Print 13 37) ; "The note on the dashboard is from three days ago. It's an old grocery list."
							)
							((Said '/cigarette,pack')
								(Print 13 38) ; "You read: "SURGEON GENERAL'S WARNING: Smoking Causes Lung Cancer, Heart Disease, Emphysema, And May Complicate Pregnancy.""
							)
							(
								(Said
									'/building,ave,air,cloud,sun,barn,home,talk,airplane,airport,lot,fence,cove,inn,bush,tree,garage,sign,mall,store,cafe,warehouse'
								)
								(Print 13 39) ; "You can't see much from inside the car."
							)
							(
								(Said
									'[<at,around][/auto,up,door,japanesedoor,bonds,down,ceiling,floor,bench]'
								)
								(Print 13 40) ; "You're behind the wheel of an unmarked police cruiser. Your partner, Keith, is puffing away on a cigarette."
							)
						)
					)
					(
						(or
							(Said
								'wear,close,use,(drop<on),japaneseput,buckle/belt,belt'
							)
							(Said 'buckle')
						)
						(Print 13 41) ; "Good idea. Safety first."
					)
					((Said 'turn/extender,scanner')
						(Print 13 42) ; "Keith keeps the police scanner on at all times."
					)
					((Said 'listen,ask/extender,scanner')
						(Print 13 43) ; "You listen intently to the radio traffic. It takes practice to pick out the important calls."
					)
					(
						(or
							(Said 'talk,use,call/extender')
							(Said 'extender,call,finding,notify>')
							(Said 'ask/warrant,dispatch>')
							(Said 'ask/backup,japanesebackup,swat,team>')
						)
						(cond
							((and (not (IsFlag 27)) global127)
								(sequencer changeState: 63)
							)
							(global186
								(= global186 0)
								(sequencer changeState: 12)
							)
							(
								(and
									global184
									(== global100 5)
									(not (IsFlag 54))
								)
								(SetScore 2 54)
								(sequencer changeState: 99)
							)
							((and global183 (not (IsFlag 111)))
								(SetFlag 111)
								(localproc_2 1 13 44) ; "I'm sure Officer Gelepsi has radioed the shooting in already."
							)
							(
								(and
									(or
										(Said '/warrant')
										(Said '/dispatch/warrant')
										(Said '/dispatch[/!*]')
										(Said '[/!*]')
									)
									(IsFlag 1)
									(== local210 40)
								)
								(ClearFlag 1)
								(SetScore 2)
								(= global170 200)
								(sequencer changeState: 101)
							)
							(
								(and
									(or
										(Said '/dispatch[/!*]')
										(Said
											'/backup,japanesebackup,swat,team'
										)
										(Said
											'/dispatch/backup,japanesebackup,swat,team'
										)
									)
									(IsFlag 2)
									(== local210 40)
								)
								(ClearFlag 2)
								(SetScore 2)
								(= global171 200)
								(sequencer changeState: 103)
							)
							((IsFlag 50)
								(sequencer changeState: 93)
							)
							((IsFlag 51)
								(sequencer changeState: 96)
							)
							((== global169 2)
								(= global169 3)
								(SetScore 2 159)
								(sequencer changeState: 46)
							)
							((and (IsFlag 49) (== global100 6))
								(ClearFlag 49)
								(SetScore 1)
								(sequencer changeState: 50)
							)
							(
								(and
									(IsFlag 84)
									(== global100 6)
									(not (IsFlag 158))
								)
								(SetScore 2 158)
								(localproc_2 1 13 45) ; "After requesting an APB on Bains' rental car, Keith says, "We'll get him now, Sonny!""
							)
							(
								(and
									(not local206)
									(or
										(and (== global100 2) (== gPrevRoomNum 22))
										(and (== global100 3) (== gPrevRoomNum 67))
										(and (== global100 5) (== gPrevRoomNum 61))
										(and (== global100 12) (== gPrevRoomNum 25))
										(and (== global100 10) (== gPrevRoomNum 27))
									)
								)
								(localproc_2 1 13 46) ; "Keith informs dispatch of your current 10-20 and situation."
								(= local206 1)
							)
							(else
								(localproc_2 1 13 47) ; "Keith looks confused. "But, we don't have anything new to report, Sonny.""
							)
						)
						(event claimed: 1)
					)
					((Said 'drive/auto')
						(Print 13 48) ; "To drive somewhere, type: "drive to (destination)""
					)
					((Said 'drive,drive>')
						(if (not (gEgo has: 3)) ; unmarked_car_keys
							(Print 13 49) ; "You need the correct key to operate this car."
							(event claimed: 1)
						else
							(if (and (== global100 3) (IsFlag 152))
								(= global100 4)
							)
							(if (and (== global100 12) (not (IsFlag 165)))
								(if (Said '/inn')
									(event claimed: 0)
								else
									(SetFlag 165)
								)
							)
							(User canInput: 0)
							(cond
								(
									(or
										(Said '/peach,cheeks')
										(Said '/(home,talk)<cheeks')
										(Said
											'/(ave<peach<lonny<222),(peach<lonny<222)'
										)
									)
									(if (!= local204 31)
										(= local204 31)
										(sequencer changeState: 85)
										(= local208 30)
										(= local209 60)
									else
										(if local203
											(Print 13 50) ; "You're already going there."
										else
											(Print 13 51) ; "You're already there."
										)
										(User canInput: 1)
									)
								)
								(
									(or
										(Said '/((home,talk)<barn)')
										(Said
											'/office,homicide,police,barn,lpd'
										)
										(Said '/barn,department,japanesedep')
									)
									(if (!= local204 1)
										(= local204 1)
										(sequencer changeState: 85)
										(= local208 110)
										(= local209 40)
									else
										(if local203
											(Print 13 50) ; "You're already going there."
										else
											(Print 13 51) ; "You're already there."
										)
										(User canInput: 1)
									)
								)
								(
									(or
										(Said '/jail,courthouse')
										(Said '/center<enforcement<law')
									)
									(if (!= local204 22)
										(= local204 22)
										(sequencer changeState: 85)
										(= local208 90)
										(= local209 10)
									else
										(if local203
											(Print 13 50) ; "You're already going there."
										else
											(Print 13 51) ; "You're already there."
										)
										(User canInput: 1)
									)
								)
								((Said '/cove')
									(if (!= local204 61)
										(= local204 61)
										(sequencer changeState: 85)
										(= local208 122)
										(= local209 12)
									else
										(if local203
											(Print 13 50) ; "You're already going there."
										else
											(Print 13 51) ; "You're already there."
										)
										(User canInput: 1)
									)
								)
								((Said '/airport')
									(if (!= local204 14)
										(= local204 14)
										(sequencer changeState: 85)
										(= local208 0)
										(= local209 62)
									else
										(if local203
											(Print 13 50) ; "You're already going there."
										else
											(Print 13 51) ; "You're already there."
										)
										(User canInput: 1)
									)
								)
								(
									(or
										(Said '/inn,(ave<3<753),(3<753)')
										(Said '/753<3')
										(Said '/753/3')
										(Said '/3/753')
									)
									(if (!= local204 25)
										(= local204 25)
										(sequencer changeState: 85)
										(= local208 40)
										(= local209 100)
									else
										(if local203
											(Print 13 50) ; "You're already going there."
										else
											(Print 13 51) ; "You're already there."
										)
										(User canInput: 1)
									)
								)
								((Said '/cafe,arnie,date,chow')
									(if (!= local204 29)
										(= local204 29)
										(sequencer changeState: 85)
										(= local208 80)
										(= local209 100)
									else
										(if local203
											(Print 13 50) ; "You're already going there."
										else
											(Print 13 51) ; "You're already there."
										)
										(User canInput: 1)
									)
								)
								(
									(or
										(Said '/rose')
										(Said
											'/warehouse,(district<warehouse),187,area>'
										)
										(Said
											'/(ave<rose<lonny<160),(rose<lonny<160)>'
										)
									)
									(cond
										(
											(and
												(or
													(Said '/187,area')
													(Said '187<drive')
												)
												(!= global100 10)
											)
											(localproc_2 1 13 52) ; "Keith looks even more confused than usual and says, "There aren't any murders pending, Sonny.""
											(User canInput: 1)
										)
										((!= local204 27)
											(event claimed: 1)
											(= local204 27)
											(sequencer changeState: 85)
											(= local208 62)
											(= local209 50)
										)
										(else
											(if local203
												(Print 13 50) ; "You're already going there."
											else
												(Print 13 51) ; "You're already there."
											)
											(event claimed: 1)
											(User canInput: 1)
										)
									)
								)
								((Said '/center,mall,(tree<fig)')
									(if (!= local204 67)
										(= local204 67)
										(sequencer changeState: 85)
										(= local208 100)
										(= local209 100)
									else
										(if local203
											(Print 13 50) ; "You're already going there."
										else
											(Print 13 51) ; "You're already there."
										)
										(User canInput: 1)
									)
								)
								((Said '/ave<fig<5556')
									(Print 13 53) ; "You have hotter leads to follow."
									(User canInput: 1)
								)
								(
									(Said
										'/(castle<caffeine),(willie<drunk),(chamber<blue),delphoria'
									)
									(Print 13 54) ; "Lytton has seen many businesses fail in the last year... and that was one of them."
									(User canInput: 1)
								)
								((Said '/steelton,houston,coarsegold')
									(Print 13 55) ; "That's a great place, but it's too far to drive there right now."
									(User canInput: 1)
								)
								((Said '[/!*]')
									(Print 13 56) ; "Where to?"
									(User canInput: 1)
								)
								((Said '/*')
									(Print 13 57) ; "You don't need to drive there."
									(User canInput: 1)
								)
							)
						)
						(= local202 (and (== gPrevRoomNum 14) (>= global169 2)))
					)
					((Said 'chase[/bains]')
						(if global186
							(= local204 14)
							(sequencer changeState: 11)
							(= local208 0)
							(= local209 62)
						else
							(localproc_2 1 13 58) ; "Keith looks at you skeptically. "How are we going to do THAT, partner? Do YOU see that rat somewhere around here?""
						)
					)
					(
						(or
							(Said 'stop,japanesestop<chase/bains')
							(Said 'stop,japanesestop,(call<off)/chase,chase')
						)
						(if local215
							(= local204 61)
							(sequencer changeState: 34)
							(= local208 122)
							(= local209 12)
						)
					)
					(
						(or
							(Said
								'exit,japaneseclimbdown,(get<out),exit[/auto]'
							)
							(Said 'open/door,japanesedoor')
						)
						(proc13_1)
					)
					(
						(or
							(Said 'give,feed/flower/cheeks')
							(Said 'give,feed/cheeks')
						)
						(if (== (sequencer state:) 55)
							(sequencer changeState: 56)
						else
							(event claimed: 0)
						)
					)
				)
			)
		)
	)
)

(instance sequencer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local214 1)
			)
			(1
				(= local214 0)
				(SetFlag 15)
				(localproc_2 1 13 59) ; "While driving to jail, Keith comments to you... "Sonny, this escape has got to be a real nightmare for you.""
			)
			(2
				(localproc_2 1 13 60) ; "On the other hand," he continues, "it must be a super nightmare for that poor correctional officer."
			)
			(3
				(localproc_2 1 13 61) ; "Well, partner," Keith says, "I guess this means the s#!* has hit the fan."
			)
			(4
				(localproc_2 1 13 62) ; "I sure hope Bains lets that correctional officer go unhurt."
				(= local214 1)
			)
			(5
				(= local214 0)
				(SetFlag 17)
				(= global100 3)
				(= global158 300)
				(= global138 2)
				(localproc_2 1 13 63) ; "Ole Oak Tree Mall! Boy, do I know that place well. My wife spends half my paycheck there."
			)
			(6
				(localproc_2 1 13 64) ; "Mercy, mercy! We almost had that bulldog for a hood ornament."
			)
			(7
				(localproc_2 1 13 65) ; "Keith comments... "Can you believe the cars they give us to drive these days? I think I can get better acceleration from my ten-speed bike.""
				(= local214 1)
			)
			(8
				(= local214 0)
				(SetFlag 19)
				(localproc_2 1 13 66) ; "Ok Sonny, I'll give you two-to-one odds for fifty cents that the jogger's a dude... yes or no?"
				(if
					(Print
						13
						67
						#at
						-1
						138
						#button
						{You're ON!}
						1
						#button
						{No way.}
						0
					)
					(= local213 0)
					(SetFlag 114)
					(sequencer changeState: 9)
				else
					(= local213 0)
					(sequencer changeState: 10)
				)
			)
			(9
				(localproc_2 1 13 68) ; "Keith says... "You're on, buddy.""
				(= local214 1)
			)
			(10
				(localproc_2 1 13 69) ; ""You little wimp!" Keith grunts, disgustedly."
				(= local214 1)
			)
			(11
				(User canInput: 0)
				(SetFlag 20)
				(= local215 1)
				(localproc_0)
				(gContinuousMusic number: 5 loop: -1 play:)
				(self cue:)
			)
			(12
				(= local214 0)
				(SetFlag 20)
				(SetScore 2 164)
				(localproc_2 1 13 70) ; "With excitement in his voice, Keith speaks into the mike... "Dispatch... 53mary2 with emergency traffic!""
			)
			(13
				(localproc_2 0 13 71) ; "Dispatch booms back... "All units hold your traffic... I have emergency traffic from 53mary2...""
			)
			(14
				(localproc_2 0 13 72) ; "Dispatch continues... "53mary2, go ahead with your emergency traffic.""
			)
			(15
				(localproc_2 1 13 73) ; "Screaming into the mike Keith says... "Dispatch... 53mary2. We have just been ambushed at Cotton Cove by suspect Bains...""
			)
			(16
				(localproc_2 1 13 74) ; "Continuing... "Suspect last seen northbound on Clearwater Drive at a high rate of speed... Be advised, we do not have him in sight...""
			)
			(17
				(localproc_2 0 13 75) ; "Dispatch acknowledges your traffic. "53mary2... 10-4... Do you have a description of the suspect vehicle?...""
			)
			(18
				(localproc_2 0 13 76) ; "...and advise injury status from ambush."
			)
			(19
				(localproc_2 1 13 77) ; "Almost out of breath, Keith answers... "Dispatch... 53mary2... negative injury to personnel...""
			)
			(20
				(localproc_2 1 13 78) ; "...suspect vehicle matches description of vehicle stolen from Oak Tree Mall."
			)
			(21
				(localproc_2 0 13 79) ; "10-4... Attention all units... per 53mary2... be on the lookout for a stolen 1986 compact black station wagon..."
			)
			(22
				(localproc_2 0 13 80) ; "Suspect vehicle last seen northbound on Clearwater Drive at a high rate of speed..."
			)
			(23
				(localproc_2 0 13 81) ; "Break."
			)
			(24
				(localproc_2 0 13 82) ; "Suspect vehicle has partial plate #C035... Be advised - the driver, Jessie Bains, just ambushed mary2 at Cotton Cove."
			)
			(25
				(localproc_2 0 13 83) ; "The mary unit has lost sight of vehicle... caution... suspect is armed and dangerous... all units acknowledge."
			)
			(26
				(if local215
					(localproc_2 1 13 84) ; "As other units acknowledge the emergency traffic, Keith says, "We might as well back out of it, Sonny. Looks like we lost the &!*@#*$!""
				else
					(localproc_2 1 13 85) ; "As other units acknowledge the emergency traffic, Keith says, "We might as well stay here, Sonny. Looks like the &!*@#*$! is loooong gone.""
					(= local214 1)
				)
			)
			(27
				(localproc_2 2 13 86) ; "Captain Fletcher Hall comes on the air, car-to-car... "53mary2... 53mary1 bye.""
			)
			(28
				(localproc_2 1 13 87) ; "Breathing normally, Keith presses the mike button and answers... "Go ahead, Captain. This is 53mary2.""
			)
			(29
				(localproc_2 2 13 88) ; "10-4. Have you overtaken the suspect vehicle, or do you have him in sight?"
			)
			(30
				(localproc_2 1 13 89) ; ""Negative," Keith answers."
			)
			(31
				(= global100 5)
				(= global158 300)
				(= global138 2)
				(localproc_2 2 13 90) ; "10-4... 10-22 the pursuit. Return to Cotton Cove and complete the investigation there. Every other unit will continue the search... 10-4?"
			)
			(32
				(localproc_2 1 13 91) ; "Keith speaks up..."10-4, Captain...""
			)
			(33
				(localproc_2 1 13 92) ; "Well," Keith says..."you heard the man."
				(User canInput: 1)
				(= local214 1)
			)
			(34
				(= local214 0)
				(= local215 0)
				(localproc_2 1 13 93) ; "Keith nods. "I'll notify Dispatch.""
			)
			(35
				(Format @local0 13 94) ; "Dispatch," Keith says, more calmly now, "53mary2... we are 10-22 on pursuit of Bains' vehicle. 10-97 to%"
				(StrCat
					@local0
					(switch local204
						(14 { Lytton Airport})
						(25 { 753 Third Street})
						(29 { Arnie's restaurant})
						(67 { Oak Tree Mall})
						(61 { Cotton Cove})
						(22 { Lytton City Jail})
						(31 { 222 West Peach Street})
						(27 { 160 West Rose})
						(1 { the office})
					)
				)
				(StrCat @local0 {."})
				(localproc_2 1 @local0)
				(= local214 1)
			)
			(36
				(= local214 0)
				(SetFlag 21)
				(Format @local0 13 95) ; "As you drive toward%"
				(StrCat
					@local0
					(switch local204
						(14 { Lytton Airport})
						(25 { 753 Third Street})
						(29 { Arnie's restaurant})
						(67 { Oak Tree Mall})
						(61 { Cotton Cove})
						(22 { Lytton City Jail})
						(31 { 222 West Peach Street})
						(27 { 160 West Rose})
						(1 { the office})
					)
				)
				(StrCat
					@local0
					{, Dispatch brings the radio alive with information from a unit in pursuit.}
				)
				(localproc_2 0 @local0)
			)
			(37
				(localproc_2 0 13 96) ; "Attention all units...be advised 53-10 is in pursuit of fugitive suspect Bains..."
			)
			(38
				(localproc_2 0 13 97) ; "...The current 10-20 is northbound on Second Street in the vicinity of the airport."
			)
			(39
				(localproc_2 0 13 98) ; "53-10 is requesting assistance and advises that he's losing suspect in heavy traffic... any unit responding acknowledge..."
			)
			(40
				(localproc_2 1 13 99) ; "Just then, Keith jumps into the middle of things... "Dispatch, 53Mary2...be advised we are responding to 53-10's 10-20, code 2.""
			)
			(41
				(localproc_2 0 13 100) ; "Dispatch confirms your traffic as you respond toward the pursuit. "Copy, 53Mary2.""
			)
			(42
				(localproc_2 3 13 101) ; "As you continue to respond, 53-10 comes on the air again... "Dispatch, 53-10... I... I lost suspect in heavy traffic.""
			)
			(43
				(localproc_2 0 13 102) ; "53-10, 10-4." Dispatch answers... "Confirm last known 10-20 of suspect vehicle..."
			)
			(44
				(localproc_2 3 13 103) ; "You listen attentively as the 53-10 unit answers... "Suspect vehicle last seen in vicinity of airport.""
			)
			(45
				(localproc_2 1 13 104) ; "I can't believe it!" Keith shouts, "How could he lose him?"
				(= local214 1)
			)
			(46
				(= local214 0)
				(localproc_2 1 13 105) ; "Dispatch, 53Mary2... request a check be made on license number C035609."
			)
			(47
				(localproc_2 0 13 106) ; "53Mary2... be advised your plate number matches that of the vehicle stolen from the mall."
			)
			(48
				(localproc_2 0 13 107) ; "Continuing... "VIN number, S1234T10 should match...""
			)
			(49
				(localproc_2 0 13 108) ; "Attention all units," she says, "10-22 looking for suspect vehicle... 53Mary2 has it located."
				(if (not (IsFlag 49))
					(= local214 1)
				)
			)
			(50
				(= local214 0)
				(localproc_2 1 13 109) ; "Dispatch, 53Mary2... request a check be made on hand gun, serial number SW5557763."
			)
			(51
				(localproc_2 0 13 110) ; "53Mary2... be advised your number comes back to a 4-inch K-38 Smith and Wesson, registered to Luis Pate.."
			)
			(52
				(localproc_2 1 13 111) ; "Well, Sonny, I guess we should get back and book this evidence."
				(= local214 1)
			)
			(53
				(SetFlag 22)
				(localproc_2 1 13 112) ; "On your way back to the office, Keith says... "Man, that punk Bains is a slick rat, isn't he?""
			)
			(54
				(SetFlag 23)
				(= local214 0)
				(localproc_2 1 13 113) ; "Keith sniffs the air and says, "Gracious me, buddy boy! You've got the car smelling like a rose garden.""
			)
			(55
				(localproc_2 1 13 114) ; ""Whatcha gonna do with that foilage?" Keith asks."
				(= local214 1)
			)
			(56
				(localproc_2 1 13 115) ; "Keith comments..."I thought you two were getting a little serious. I guess I was right.""
			)
			(57
				(SetFlag 24)
				(localproc_2 1 13 116) ; "Boy!" Keith comments. "After yesterday, I was hoping for a slow day."
			)
			(58
				(= local207 0)
				(= local214 0)
				(SetFlag 25)
				(localproc_2 1 13 117) ; "I'll advise Dispatch," Keith says, grabbing the mike... "Dispatch... 53Mary2... we're responding to 753 Third Street for follow up."
			)
			(59
				(if (not local207)
					(gContinuousMusic number: 5 loop: -1 play:)
				)
				(localproc_2 0 13 118) ; "Dispatch responds..."10-4... 53Mary2 rolling to 753 Third St for 187 follow up.""
				(localproc_0)
			)
			(60
				(localproc_2 1 13 119) ; ""I think we may be getting somewhere, partner," Keith says."
			)
			(61
				(localproc_2 1 13 120) ; "We'd better watch our butts when we get there."
			)
			(62
				(localproc_2 1 13 121) ; "I hope this lead isn't a dead end."
				(= local214 1)
				(User canInput: 1)
			)
			(63
				(User canInput: 0)
				(= local214 0)
				(SetFlag 27)
				(localproc_2 1 13 122) ; "Keith keys the mike and informs Dispatch of the bad news."
			)
			(64
				(if (== local204 1)
					(localproc_2 1 13 123) ; "Dispatch... 53Mary2... We are 10-8 in route to office. Be advised we have found signs of struggle."
				else
					(self cue:)
				)
			)
			(65
				(localproc_2 1 13 124) ; "It appears the occupant of the house, one Marie Wilkans has been kidnapped. Please advise the Captain."
			)
			(66
				(localproc_2 0 13 125) ; "53Mary2..We copied the possible 207 kidnap, and will 10-5 the information to 53Mary1."
			)
			(67
				(localproc_2 1 13 126) ; "Keith manages an encouraging smile. "We'll get her back, Sonny.""
				(= local214 1)
				(User canInput: 1)
			)
			(68
				(= local214 0)
				(SetFlag 28)
				(localproc_2 1 13 127) ; "Dispatch... 53Mary2... we are 10-6, enroute to airport."
			)
			(69
				(localproc_2 1 13 128) ; "53Mary2 10-4. Copied 10-6 enroute to airport."
			)
			(70
				(localproc_2 1 13 129) ; "Well, ole buddy, ole pal!" Keith says..." Here's hoping we make it back alive."
			)
			(71
				(localproc_2 1 13 130) ; "I don't care what you say." Keith says..."I'm having another cigarette before I board that plane."
			)
			(72
				(localproc_2 1 13 131) ; "Dispatch... 53Mary2." Keith says.. "We are 10-7 at the airport and will see you when we get home."
			)
			(73
				(self changeState: 67)
			)
			(74
				(= local214 0)
				(SetFlag 16)
				(localproc_2 0 13 132) ; "You listen as the radio comes alive with your call number... "53mary2, Dispatch... we have further traffic for you.""
			)
			(75
				(localproc_2 1 13 133) ; "Keith grabs the mike and answers... "Dispatch... 53mary2. Go ahead with your traffic.""
			)
			(76
				(localproc_2 0 13 134) ; "53mary2, 10-4" dispatch continues... "Traffic Officer Haines has located a vehicle belonging to the correctional officer at Oak Tree Mall."
			)
			(77
				(localproc_2 0 13 135) ; "Continuing, "Per Captain Hall, respond to that 10-20 and 11-98 with Officer Haines... Dispatch clear.""
			)
			(78
				(localproc_2 1 13 136) ; "After acknowledging the radio call, Keith mumbles to you, "Well, you heard it, big boy. Let's roll!""
				(= local214 1)
			)
			(79
				(= local214 0)
				(localproc_2 0 13 137) ; "As you drive along, mulling over your thoughts, a call from Dispatch breaks the silence... "53mary2...Dispatch...""
				(= local201 1)
			)
			(80
				(localproc_2 1 13 138) ; "Keith keys the mike... "Dispatch... 53mary2. Go ahead...""
			)
			(81
				(localproc_2 0 13 139) ; "Respond to Cotton Cove... see the jogger standing by at the phone booth."
			)
			(82
				(= global100 5)
				(= global158 300)
				(= global138 2)
				(localproc_2 0 13 140) ; "Dispatch continues... "Jogger has info of possible foul play... Be advised I have one traffic unit responding.""
			)
			(83
				(localproc_2 1 13 141) ; "Keith keys the mike... "Dispatch...53mary2 copied.""
				(= local214 1)
			)
			(85
				(if (== global169 3)
					(= global169 0)
				)
				(ClearFlag 51)
				(ClearFlag 50)
				(SetFlag 111)
				(if (and (== gPrevRoomNum 61) (== global100 5) (!= local204 61))
					(= global100 6)
					(= global169 1)
					(= global158 0)
				)
				(if (and (== gPrevRoomNum 27) (== global100 10) (!= global158 1))
					(= global100 11)
				)
				(cond
					(
						(and
							(not (IsFlag 25))
							(== global100 11)
							(gEgo has: 24) ; envelope_corner
							(== local204 25)
						)
						(sequencer changeState: 58)
					)
					(local215
						(self changeState: 34)
					)
					((and (== local210 local208) (== local211 local209))
						(self cue:)
					)
					(else
						(self changeState: 89)
					)
				)
			)
			(86
				(= local214 0)
				(switch local204
					(14
						(localproc_2 1 13 142) ; "Great," Keith mutters, "Let's go watch jets take off and land."
					)
					(25
						(localproc_2 1 13 143) ; "Say, that's Snuggler's Inn. It's a nice motel... uh... I've never actually BEEN there of course..."
					)
					(29
						(localproc_2 1 13 144) ; ""Finally, something to eat!" grunts Keith."
					)
					(67
						(localproc_2 1 13 145) ; ""Shopping early for Christmas?" Keith jokes."
					)
					(61
						(localproc_2 1 13 146) ; ""Maybe we should bring a picnic lunch?" Keith suggests sarcastically."
					)
					(22
						(localproc_2 1 13 147) ; "Yeah," grunts Keith. "Let's see if they've managed to keep any bad guys in."
					)
					(31
						(if (not (gEgo has: 29)) ; lipstick
							(localproc_2 1 13 148) ; "Hey, are you sure you two wouldn't rather be alone?"
						else
							(localproc_2 1 13 149) ; "I'm sure there's nothing to worry about, Sonny. But let's not waste any time!"
						)
					)
					(1
						(localproc_2 1 13 150) ; "Keith frowns. "OK," he says, "I have mucho paper work to finish.""
					)
					(27
						(localproc_2 1 13 151) ; "Keith pipes up: "Let's go roust some bag ladies, eh Sonny?""
					)
				)
			)
			(87
				(Format @local0 13 152) ; "Keith grabs the mike and calls dispatch... "Dispatch... 53mary2 is 10-8 from%"
				(StrCat
					@local0
					(switch local210
						(0 { Lytton Airport})
						(40 { 753 Third Street})
						(80 { Arnie's restaurant})
						(100 { Oak Tree Mall})
						(122 { Cotton Cove})
						(90 { Lytton City Jail})
						(30 { 222 West Peach Street})
						(62 { 160 West Rose})
						(110 { the office})
					)
				)
				(StrCat @local0 {."})
				(localproc_2 1 @local0)
			)
			(88
				(Format @local0 13 153) ; "Dispatch comes on the air and responds... "53mary2... 10-4. Dispatch copies 10-8 from%"
				(StrCat
					@local0
					(switch local210
						(0 { Lytton Airport})
						(40 { 753 Third Street})
						(80 { Arnie's restaurant})
						(100 { Oak Tree Mall})
						(122 { Cotton Cove})
						(90 { Lytton City Jail})
						(30 { 222 West Peach Street})
						(62 { 160 West Rose})
						(110 { the office})
					)
				)
				(StrCat
					@local0
					{."}
				)
				(localproc_2 0 @local0)
				(gContinuousMusic number: 5 loop: -1 play:)
				(= local207 1)
				(localproc_0)
			)
			(89
				(if (not local207)
					(gContinuousMusic number: 5 loop: -1 play:)
				)
				(= local207 0)
				(= local214 0)
				(Format @local0 13 154) ; "Keith keys the mike... "Dispatch... 53mary2. Be advised we are enroute to%"
				(StrCat
					@local0
					(switch local204
						(14 { Lytton Airport})
						(25 { 753 Third Street})
						(29 { Arnie's restaurant})
						(67 { Oak Tree Mall})
						(61 { Cotton Cove})
						(22 { Lytton City Jail})
						(31 { 222 West Peach Street})
						(27 { 160 West Rose})
						(1 { the office})
					)
				)
				(StrCat
					@local0
					{."}
				)
				(localproc_2 1 @local0)
			)
			(90
				(Format @local0 13 155) ; "Dispatch answers... "53mary2... 10-4. We copy you are enroute to%"
				(StrCat
					@local0
					(switch local208
						(0 { Lytton Airport})
						(40 { 753 Third Street})
						(80 { Arnie's restaurant})
						(100 { Oak Tree Mall})
						(122 { Cotton Cove})
						(90 { Lytton City Jail})
						(30 { 222 West Peach Street})
						(62 { 160 West Rose})
						(110 { the office})
					)
				)
				(StrCat
					@local0
					{."}
				)
				(localproc_2 0 @local0)
				(User canInput: 1)
				(= local214 1)
			)
			(91
				(= local214 0)
				(if
					(or
						(and
							(== local204 67)
							(or (< global100 2) (>= global100 4))
						)
						(and
							(== local204 61)
							(or (< global100 4) (== global100 6))
						)
						(and (== local204 31) (< global100 8))
						(== local204 1)
					)
					(Format @local0 13 156) ; "Dispatch... 53Mary2 10-7 at%"
				else
					(Format @local0 13 157) ; "Keith contacts dispatch... "Dispatch... 53mary2 10-97%"
				)
				(StrCat
					@local0
					(switch local204
						(14 { Lytton Airport})
						(25 { 753 Third Street})
						(29 { Arnie's restaurant})
						(67 { Oak Tree Mall})
						(61 { Cotton Cove})
						(22 { Lytton City Jail})
						(31 { 222 West Peach Street})
						(27 { 160 West Rose})
						(1 { the office})
					)
				)
				(if
					(or
						(and
							(== local204 67)
							(or (< global100 2) (>= global100 4))
						)
						(and
							(== local204 61)
							(or (< global100 4) (== global100 6))
						)
						(and (== local204 31) (< global100 8))
						(== local204 1)
					)
					(StrCat @local0 {."})
				else
					(StrCat @local0 {."})
				)
				(localproc_2 1 @local0)
			)
			(92
				(Format @local0 13 158) ; "Dispatch responds... "53mary2... 10-4. Dispatch copies 10-97%"
				(StrCat
					@local0
					(switch local204
						(14 { Lytton Airport})
						(25 { 753 Third Street})
						(29 { Arnie's restaurant})
						(67 { Oak Tree Mall})
						(61 { Cotton Cove})
						(22 { Lytton City Jail})
						(31 { 222 West Peach Street})
						(27 { 160 West Rose})
						(1 { the office})
					)
				)
				(StrCat @local0 {."})
				(localproc_2 0 @local0)
				(= local214 1)
			)
			(93
				(= local214 0)
				(ClearFlag 50)
				(SetScore 1)
				(localproc_2 1 13 159) ; "Keith keys the mike. "Dispatch... 53Mary2. Be advised that suspect Bains may be in possession of the correctional officer's gun.""
			)
			(94
				(localproc_2 0 13 160) ; "10-4, 53Mary2." Dispatch crackles back. "Attention all units..."
			)
			(95
				(localproc_2 0 13 161) ; "Update on jail break...per 53mary2, Jessie Bains may now be armed with the correctional officer's gun...approach with caution."
				(if (not (IsFlag 51))
					(= local214 1)
				)
			)
			(96
				(= local214 0)
				(SetScore 2)
				(ClearFlag 51)
				(localproc_2 1 13 162) ; "Keith advises dispatch of the stolen car information and requests notification to all units."
			)
			(97
				(localproc_2 0 13 163) ; "53mary2... 10-4."
			)
			(98
				(localproc_2 0 13 164) ; "Attention all units!" Dispatch transmits... "Be on the lookout for one black 1986 4-door mid-size station wagon stolen from Oak Tree Mall. A partial plate of C035 was given."
				(= local214 1)
			)
			(99
				(= local214 0)
				(localproc_2 1 13 165) ; "Keith grabs the mike... "Dispatch.. 53Mary2 requesting the coroner at our 10-20...""
			)
			(100
				(localproc_2 0 13 166) ; "Dispatch answers, "10-4, 53Mary2. Be advised... the coroner will be dispatched to your 10-20 when available.""
				(= local214 1)
			)
			(101
				(= local214 0)
				(localproc_2 1 13 167) ; "Dispatch.. 53Mary2 requesting one search warrant for room #108, at our 10-20."
			)
			(102
				(localproc_2 0 13 168) ; "10-4, 53Mary2. Be advised... a search warrant will be obtained and delivered to your 10-20."
				(= local214 1)
			)
			(103
				(= local214 0)
				(localproc_2 1 13 169) ; "Keith grabs the mike... "Dispatch.. 53Mary2 requesting backup at our 10-20...""
			)
			(104
				(localproc_2 0 13 170) ; "Dispatch answers... "10-4, 53Mary2. Be advised...a support team has been dispatched to your 10-20.""
				(= local214 1)
			)
			(105
				(= seconds 3)
			)
			(106
				(User canInput: 0)
				(= local214 0)
				(localproc_2 0 13 171) ; "53Mary2," you hear the radio crackle. I have traffic for you from 53Mary1."
			)
			(107
				(localproc_2 1 13 133) ; "Keith grabs the mike and answers... "Dispatch... 53mary2. Go ahead with your traffic.""
			)
			(108
				(localproc_2 2 13 172) ; ""Where are you, Bonds!?" You cringe at Captain Fletcher Hall's angry tone of voice."
			)
			(109
				(if (== global100 10)
					(= global159 1)
					(= global158 0)
				)
				(if global159
					(gContinuousMusic loop: 1 fade:)
					(NormalEgo)
					(gCurRoom newRoom: 300)
				else
					(= global159 600)
					(if (!= global100 0 8)
						(localproc_2 2 13 173) ; "You haven't followed your orders. Get back here NOW!!"
					else
						(localproc_2 2 13 174) ; "You can't just go wherever, whenever you please. Get back here NOW!"
					)
				)
			)
			(110
				(localproc_2 1 13 175) ; "After acknowledging the transmission, Keith says, "Wow, Sonny. I've never heard Fletch so mad at you before.""
			)
			(111
				(if (!= global100 0 8)
					(localproc_2 1 13 176) ; "We'd better show some results soon, or he'll have our badges!"
				else
					(localproc_2 1 13 177) ; "You'd better get back and report in, Sonny."
				)
			)
			(112
				(= local214 1)
				(if (and (!= global100 8) (!= global100 0))
					(= global159 300)
				)
				(NormalEgo)
				(gContinuousMusic loop: 1 fade:)
				(gCurRoom newRoom: 300)
			)
			(113
				(= local214 0)
				(switch (Random 0 1)
					(0
						(localproc_2 1 13 178) ; "Keith, as usual, takes in a big puff before responding."
					)
					(1
						(localproc_2 1 13 179) ; "Keith takes another deep draft from his cigarette..."
					)
				)
			)
			(114
				(switch (Random 0 3)
					(0
						(localproc_2 1 13 180) ; "You don't care if I smoke in the car, do you partner?"
					)
					(1
						(localproc_2 1 13 181) ; "Did I ever tell you... my wife thinks I smoke too much, but you don't... DO you?"
					)
					(2
						(localproc_2 1 13 182) ; "You know, Sonny, some crazies are trying to ban smoking, but it doesn't bother you, does it?"
					)
					(3
						(localproc_2 1 13 183) ; "You're always bugging me about my smoking, Sonny, but I know you're not serious, are you?"
					)
				)
				(if
					(Print
						13
						67
						#button
						{YES!!}
						0
						#button
						{no}
						1
						#at
						-1
						138
					)
					(localproc_2 1 13 184) ; "Thanks, partner."
					(= local214 1)
				else
					(= local219 1)
				)
			)
			(115
				(switch (Random 0 15)
					(0
						(localproc_2 1 13 185) ; "You're not one of those commie-neo-fascists who want to ban smoking, ARE you, Sonny?!"
					)
					(1
						(localproc_2 1 13 186) ; "I can't BELIEVE you can even SMELL my smoke WAY over THERE!!"
					)
					(2
						(localproc_2 1 13 187) ; "How 'bout if I just open the window? I'll do that for you..."
					)
					(3
						(localproc_2 1 13 188) ; "Hey! I don't complain about YOUR habits, DO I?"
					)
					(4
						(localproc_2 1 13 189) ; "I can quit... ANYtime. Just... well... not in the middle of a mess like this!"
					)
					(5
						(localproc_2 1 13 190) ; "OK, Sonny. You've convinced me. I'll quit smoking, RIGHT after we catch Bains. Yessir. AB-SO-LUTE-LY!"
					)
					(6
						(localproc_2 1 13 191) ; "You know, they've never ACTUALLY, SCIENTIFICALLY proven that cigarette smoking causes cancer in people named Keith (Ha Ha)."
					)
					(7
						(localproc_2 1 13 192) ; "How about if I just smoke this one. Then I'll stop for the WHOLE DAY! OK? Thanks, partner. I owe you one."
					)
					(8
						(localproc_2 1 13 193) ; "No foolin'? I never knew my smoking REALLY bothered you! I thought you were just kidding me. You're a real kidder, Sonny, and a GREAT partner, too."
					)
					(9
						(localproc_2 1 13 194) ; "I'd quit smoking, but I've invested SO much into cigarettes over the years, I'd hate to see it all go up in smoke! (ha ha ha)"
					)
					(10
						(localproc_2 1 13 195) ; "Well, I never thought I'd see the day when Sonny Bonds would infringe upon the CONSTITUTIONAL rights of his very own PARTNER!"
					)
					(11
						(localproc_2 1 13 196) ; "Smoking helps me think. Sherlock Holmes wouldn't have been able to deduce Watson's hat size without his pipe!"
					)
					(12
						(localproc_2 1 13 197) ; "I'll just inhale all the smoke and keep it in my lungs. OK? OK!"
					)
					(13
						(Format @local0 13 198) ; ""I don't know what you're complaining about! I filter the smoke with my lungs first, you know."%"
					)
					(14
						(Format @local0 13 199) ; ""How many times have I saved your life, huh partner? And now... now, when I need a little consideration from you, you turn on me."%"
					)
					(15
						(Format @local0 13 200) ; ""Well, if I didn't smoke, we'd BOTH be nervous wrecks! One of us has to keep his mental faculties sharp."%"
					)
				)
				(= local214 1)
			)
		)
	)
)

