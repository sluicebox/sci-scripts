;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 33)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm33 0
	proc33_1 1
)

(synonyms
	(get had)
	(drive go)
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
)

(procedure (localproc_0)
	(if (== global100 8)
		(= global158 10)
	)
	(lines startUpd:)
	(extraScene hide:)
	(rightScene show: startUpd:)
	(leftScene show: startUpd:)
	(= local0 1)
	(= global130 33)
	(ClearFlag 40)
)

(procedure (proc33_1)
	(if (and (== local6 local4) (== local7 local5))
		(Print 33 0) ; "OK."
		(gEgo setPri: -1)
		(if (and (IsFlag 165) (== local1 25))
			(= local1 225)
		)
		(gEgo setStep: 3 2)
		(gCurRoom newRoom: local1)
	else
		(Print 33 1) ; "It would probably be a good idea to wait until you've arrived."
	)
)

(instance sonny of View
	(properties)
)

(instance wheel of View
	(properties)
)

(instance hand of View
	(properties)
)

(instance street of Prop
	(properties)
)

(instance lines of Act
	(properties)
)

(instance rightScene of Act
	(properties)
)

(instance leftScene of Act
	(properties)
)

(instance extraScene of View
	(properties)
)

(instance shoulder1 of View
	(properties)
)

(instance shoulder2 of View
	(properties)
)

(instance gloveBox of View
	(properties)
)

(instance gloveBoxDoor of Prop
	(properties)
)

(instance smallFlashLight of View
	(properties)
)

(instance businessCard of View
	(properties)
)

(instance registration of View
	(properties)
)

(instance leftFwd of Fwd ; UNUSED
	(properties)
)

(instance rightFwd of Fwd ; UNUSED
	(properties)
)

(instance lineFwd of Fwd ; UNUSED
	(properties)
)

(instance aTimer of Timer
	(properties)
)

(instance rm33 of Rm
	(properties
		picture 33
		style 0
	)

	(method (dispose)
		(aTimer dispose: delete:)
		(super dispose:)
	)

	(method (init)
		(super init:)
		(HandsOff)
		(User canInput: 1)
		(gCurRoom setLocales: 153)
		(Load rsVIEW 71)
		(Load rsVIEW 200)
		(Load rsVIEW 269)
		(gEgo
			setPri: -1
			setLoop: -1
			setCel: -1
			posn: -100 0
			ignoreActors: 0
			illegalBits: $8000
			init:
		)
		(= global131 33)
		(= local0 0)
		(= global204 0)
		(= local1 gPrevRoomNum)
		(= local6
			(switch gPrevRoomNum
				(14 0)
				(25 60)
				(225 60)
				(29 120)
				(67 180)
				(61 220)
				(22 140)
				(31 40)
				(27 62)
				(1 122)
			)
		)
		(= local7
			(switch gPrevRoomNum
				(14 100)
				(25 120)
				(29 120)
				(67 120)
				(61 0)
				(22 20)
				(31 80)
				(27 60)
				(1 60)
			)
		)
		(switch local6
			(0
				(Load rsVIEW 329)
			)
			(60
				(Load rsVIEW 332)
			)
			(120
				(Load rsVIEW 331)
			)
			(180
				(Load rsVIEW 328)
			)
			(220
				(Load rsVIEW 326)
			)
			(140
				(Load rsVIEW 334)
			)
			(40
				(Load rsVIEW 333)
			)
			(62
				(Load rsVIEW 330)
			)
			(122
				(Load rsVIEW 327)
			)
		)
		(= local5 local7)
		(= local4 local6)
		(if (== global137 1)
			(= local2 1)
			(gloveBoxScript changeState: 0)
		)
		(if (or (== global100 5) (== global100 10))
			(if global159
				(= global159 3)
			)
			(if global158
				(= global158 3)
				(= global159 600)
			)
		)
		(self setScript: rm33Script)
	)
)

(instance rm33Script of Script
	(properties)

	(method (doit)
		(if local0
			(if (not (< global110 30))
				(cond
					((<= (hand y:) 156)
						(hand posn: 145 (+ (hand y:) 1))
					)
					((>= (hand y:) 160)
						(hand posn: 145 (- (hand y:) 1))
					)
					(else
						(hand posn: 145 (+ (hand y:) (Random -2 2)))
					)
				)
			)
			(if (and (or (== global159 1) (== global158 1)) (not local3))
				(= local3 1)
				(self changeState: 1)
			else
				(if (> global159 1)
					(-- global159)
				)
				(if (> global158 1)
					(-- global158)
				)
			)
			(cond
				((> local6 local4)
					(-- local6)
				)
				((< local6 local4)
					(++ local6)
				)
				((> local7 local5)
					(-- local7)
				)
				((< local7 local5)
					(++ local7)
				)
				((and local0 (not local3))
					(if (and (IsFlag 165) (== local1 25))
						(= local1 225)
					)
					(gEgo setStep: 3 2)
					(gCurRoom newRoom: local1)
				)
			)
		else
			(lines stopUpd:)
			(rightScene stopUpd:)
			(leftScene stopUpd:)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(PutItem 34) ; car_registration
				(sonny
					view: 71
					posn: 83 104
					loop: 0
					cel: 0
					setPri: 12
					init:
					addToPic:
				)
				(wheel
					view: 71
					posn: 130 135
					loop: 0
					cel: 2
					setPri: 12
					init:
					addToPic:
				)
				(shoulder1
					view: 71
					posn: 126 139
					loop: 0
					cel: 4
					setPri: 12
					init:
					addToPic:
				)
				(shoulder2
					view: 71
					posn: 133 167
					loop: 0
					cel: 4
					setPri: 12
					init:
					addToPic:
				)
				(street
					view: 71
					posn: 155 111
					setPri: 1
					setLoop: 5
					cel: 0
					init:
					addToPic:
				)
				(lines
					view: 71
					posn: 149 114
					setPri: 2
					setLoop: 4
					setCycle: Fwd
					illegalBits: 0
					init:
					stopUpd:
				)
				(leftScene
					view: 200
					posn: 102 103
					setPri: 0
					setLoop: 0
					cel: 1
					setCycle: Fwd
					illegalBits: 0
					init:
					stopUpd:
					hide:
				)
				(rightScene
					view: 200
					posn: 218 103
					setPri: 0
					setLoop: 1
					setCycle: Fwd
					illegalBits: 0
					init:
					stopUpd:
					hide:
				)
				(hand view: 71 posn: 145 159 setPri: 12 loop: 0 init: cel: 3)
				(if (< global110 30)
					(hand stopUpd:)
				)
				(extraScene
					view:
						(switch local6
							(0 329)
							(60 332)
							(120 331)
							(180 328)
							(220 326)
							(140 334)
							(40 333)
							(62 330)
							(122 327)
						)
					setLoop: 0
					setCel: 0
					posn: 175 112
					setPri: 3
					setLoop: 0
					init:
					stopUpd:
				)
			)
			(1
				(= seconds 5)
			)
			(2
				((= local8 (Prop new:))
					view: 163
					posn: 148 69
					setPri: 13
					init:
					setCycle: Fwd
				)
				(= seconds 3)
			)
			(3
				(Print 33 2 #at -1 120) ; "Suddenly, in your rear-view mirror, you notice the flashing lights of a police cruiser."
				(Print 33 3 #at -1 120) ; ""What did I do now?" you think to yourself, as you pull over to the curb."
				(leftScene cycleSpeed: 1 setMotion: MoveTo 98 104)
				(rightScene cycleSpeed: 1 setMotion: MoveTo 212 102)
				(lines cycleSpeed: 1 setMotion: MoveTo 140 114)
				(= seconds 2)
			)
			(4
				(lines cycleSpeed: 2)
				(leftScene cycleSpeed: 2)
				(rightScene cycleSpeed: 2)
				(= seconds 3)
			)
			(5
				(lines addToPic:)
				(leftScene addToPic:)
				(rightScene addToPic:)
				(= local0 0)
				(= seconds 4)
			)
			(6
				(Print 33 4 #at -1 120) ; "You don't recognize the young traffic cop who approaches your window."
				(= seconds 3)
			)
			(7
				(Print 33 5 #at -1 120) ; "Officer Bonds," he says nervously, "Captain Hall wants to see you."
				(Print 33 6) ; "uh..." he continues, "the APB says that it's URGENT! You're to report to him IMMEDIATELY... uh, OK?"
				(NormalEgo)
				(gCurRoom newRoom: 300)
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
					(Print 33 7) ; "You don't need your gun in the car."
					(event claimed: 1)
				else
					(event claimed: 0)
				)
			)
			(evSAID
				(cond
					((Said 'extender/dispatch')
						(Print 33 8) ; "You don't have a police radio in your personal car."
					)
					((Said 'look/ignition')
						(if (IsItemAt 2 0) ; key_ring
							(Print 33 9) ; "Your keys are in the ignition."
						else
							(Print 33 10) ; "There's nothing special about your car's ignition system."
						)
					)
					((Said 'look/speedometer,speed')
						(if local0
							(Print 33 11) ; "Your speedometer indicates you're within the local 35 mph speed limit."
						else
							(Print 33 12) ; "You're getting nowhere fast."
						)
					)
					((Said 'look/pane')
						(Print 33 13) ; "Outside the car's window, you see..."
						(switch local6
							(0
								(Print 33 14) ; "... the newly built Lytton Airport parking lot and terminal building."
							)
							(60
								(Print 33 15) ; "... the Snuggler's Inn. Sleezy and cheap, it's a motel for the down-and-out."
							)
							(120
								(Print 33 16) ; "Arnie's restaurant. Their food is good, and the service is adequate."
							)
							(180
								(Print 33 17) ; "Oak Tree Mall. This is Lytton's major shopping area."
							)
							(220
								(Print 33 18) ; "Cotton Cove. It's a poorly-kept-up park. It holds many fond memories from your youth."
							)
							(140
								(Print 33 19) ; "... the underground parking structure of the new Lytton Justice Building. The city jail's entrance is nearby."
							)
							(40
								(Print 33 20) ; "... a typical American neighborhood. You're parked in front of Marie Wilkan's house."
							)
							(62
								(Print 33 21) ; "... the warehouse district. A lot goes down around here, free from prying eyes."
							)
							(122
								(Print 33 22) ; "... the Lytton Police Station and parking lot. The detective's entrance is nearby."
							)
							(else
								(Print 33 23) ; "... the streets of Lytton as they fly by."
							)
						)
					)
					((Said 'look/japanesemiller')
						(if local3
							(Print 33 24) ; "You see flashing lights behind you."
						else
							(switch (Random 0 2)
								(0
									(Print 33 25) ; "You're getting paranoid. Don't worry... nobody's following you."
								)
								(1
									(Print 33 26) ; "Don't be so vain!"
								)
								(2
									(Print 33 27) ; "You look in the mirror and think to yourself... "You good looking devil you!""
								)
							)
						)
					)
					((Said 'look/dash')
						(Print 33 28) ; "Your car's dashboard looks like any other economy car's."
						(if (IsItemAt 2 0) ; key_ring
							(Print 33 29) ; "In the ignition, you see keys on a ring."
						)
					)
					((Said 'look/key,ring')
						(if (IsItemAt 2 0) ; key_ring
							(Print 33 29) ; "In the ignition, you see keys on a ring."
						else
							(event claimed: 0)
						)
					)
					((Said 'look/tire[<steering,investigate]')
						(Print 33 30) ; "The brown "rubber" of the steering wheel is very stylishly molded."
					)
					(
						(or
							(Said 'japaneselookback[/!*]')
							(Said 'look/back,(bench<back)[/!*]')
						)
						(Print 33 31) ; "You see an adventure gamer looking over your shoulder."
					)
					((Said 'look/air,tree,home,talk,cloud')
						(Print 33 32) ; "You look, but the view isn't that good from here."
					)
					((Said 'adjust[/!*]')
						(Print 33 33) ; "OK."
					)
					((or (Said '/extender') (Said 'extender<use[/!*]'))
						(Print 33 34) ; "Click..."
						(Print 33 35) ; "Nothing. The radio's warranty has expired. But that's ok - it sounded terrible anyway."
					)
					(
						(or
							(Said
								'wear,close,use,buckle,(drop,japaneseput<on)/belt,belt'
							)
							(Said 'buckle[/!*]')
						)
						(Print 33 36) ; "Good idea. Safety first."
					)
					(
						(Said
							'look,(turn<on),japaneseturnon/heat,air,conditioner,fan'
						)
						(Print 33 37) ; "The car's "automatic climate control system" is on the fritz."
					)
					((Said '/tray,ashtray')
						(Print 33 38) ; "Since you don't smoke, you use the ashtray for change. However, it's empty at the moment."
					)
					((Said '/visor')
						(Print 33 39) ; "The visors are made of cheap plastic. Fortunately, the sun isn't in your eyes right now."
					)
					(
						(or
							(Said 'start[/auto,ignition,engine]')
							(Said 'turn/key')
							(Said '(turn<on),japaneseturnon/engine,auto')
							(Said 'drop,japaneseput/key/ignition')
						)
						(PutItem 2 0) ; key_ring
						(Print 33 40) ; "The little gutless-wonder of an engine is running."
					)
					(
						(or
							(Said 'stop,japanesestop[/auto,engine]')
							(Said '(turn<off),japaneseturnoff/engine,auto')
							(Said 'switch<off/engine,auto')
						)
						(if local0
							(Print 33 41) ; "It would probably be a good idea to wait until you've arrived."
						else
							(Print 33 42) ; "The car's engine is off."
						)
					)
					((Said 'open/box,compartment')
						(if (== global137 1)
							(Print 33 43) ; "The glove box is already open."
						else
							(= global137 1)
							(= local2 0)
							(gloveBoxScript changeState: 0)
						)
					)
					((Said 'close/box,compartment')
						(if (== global137 0)
							(Print 33 44) ; "The glove box is already closed."
						else
							(= global137 0)
							(gloveBoxScript changeState: 2)
						)
					)
					((Said 'look/box,compartment')
						(if (gCast contains: gloveBox)
							(gInventory
								carrying:
									{In the glove compartment you see:}
								showSelf: 33
							)
						else
							(Print 33 45) ; "Open the glove box first."
						)
					)
					((Said 'get,japaneseopen/key,ring')
						(cond
							((not (IsItemAt 2 0)) ; key_ring
								(Print 33 46) ; "There are no keys here."
							)
							((not local0)
								(gEgo get: 2) ; key_ring
								(Print 33 47) ; "You take the keys from the ignition."
								(SetScore 1 102)
							)
							(else
								(Print 33 41) ; "It would probably be a good idea to wait until you've arrived."
							)
						)
					)
					((Said 'get,japaneseopen/card')
						(cond
							((gEgo has: 37) ; your_LPD_business_card
								(proc0_8) ; "You already took it."
							)
							((and global137 (IsItemAt 37)) ; your_LPD_business_card
								(gEgo get: 37) ; your_LPD_business_card
								(businessCard dispose:)
								(Print 33 48 #draw) ; "OK"
								(SetScore 1 103)
							)
							(else
								(Print 33 49) ; "You see no card here."
							)
						)
					)
					((Said 'drop,japaneseput,replace,japanesereplace/card')
						(cond
							((not (gEgo has: 37)) ; your_LPD_business_card
								(proc0_9) ; "You don't have it."
							)
							((not global137)
								(Print 33 50) ; "Open the glove box first."
							)
							(else
								(Print 33 48 #draw) ; "OK"
								(gEgo put: 37 33) ; your_LPD_business_card
								(businessCard
									view: 269
									posn: 192 132
									setPri: 15
									loop: 0
									cel: 2
									init:
									stopUpd:
								)
							)
						)
					)
					((Said 'look,get/japanesehair,registration')
						(if (== global137 0)
							(Print 33 51) ; "There is no paper here."
						else
							(registration startUpd: hide:)
							(Print 33 52 #mode 1 #draw) ; "This is the vehicle's registration. Careful examination reveals that this car belongs to Sonny Bonds. Why... that's YOU!"
							(Print 33 53) ; "The registration should stay in the car, so you return it to the glove box."
							(registration show: stopUpd:)
						)
					)
					(
						(Said
							'look/building,ave,air,cloud,sun,barn,home,talk,airplane,airport,lot,fence,cove,inn,bush,tree,garage,sign,mall,store,cafe,warehouse'
						)
						(Print 33 54) ; "You can't see much from inside the car."
					)
					((Said 'look[<at,around,in][/auto]')
						(Print 33 55) ; "You're behind the wheel of your personal car. Marie talked you into trading in your sports car for this... "sensible" compact model."
					)
					((Said 'beep,press/horn')
						(Print 33 56) ; "beeep beeep"
					)
					((Said 'drive/auto')
						(Print 33 57) ; "To drive somewhere, type: "drive to (destination)""
					)
					((Said 'drive,drive>')
						(if (and (== global100 3) (IsFlag 152))
							(= global100 4)
						)
						(if (and (== global100 12) (not (IsFlag 165)))
							(if (Said '/inn,(ave<3<753)')
								(event claimed: 0)
							else
								(SetFlag 165)
							)
						)
						(PutItem 2 0) ; key_ring
						(cond
							(
								(or
									(Said '/((home,talk)<barn),office,homicide')
									(Said '/barn[<police,japanesepict]')
								)
								(cond
									((!= local1 1)
										(= local1 1)
										(= local4 122)
										(= local5 60)
										(localproc_0)
									)
									(local0
										(Print 33 58) ; "You're already going there."
									)
									(else
										(Print 33 59) ; "You're already there."
									)
								)
							)
							((Said '/jail')
								(cond
									((!= local1 22)
										(= local1 22)
										(= local4 140)
										(= local5 20)
										(localproc_0)
									)
									(local0
										(Print 33 58) ; "You're already going there."
									)
									(else
										(Print 33 59) ; "You're already there."
									)
								)
							)
							((Said '/cove')
								(cond
									((!= local1 61)
										(= local1 61)
										(= local4 220)
										(= local5 0)
										(localproc_0)
									)
									(local0
										(Print 33 58) ; "You're already going there."
									)
									(else
										(Print 33 59) ; "You're already there."
									)
								)
							)
							((Said '/airport')
								(cond
									((!= local1 14)
										(= local1 14)
										(= local4 0)
										(= local5 100)
										(localproc_0)
									)
									(local0
										(Print 33 58) ; "You're already going there."
									)
									(else
										(Print 33 59) ; "You're already there."
									)
								)
							)
							((Said '/inn')
								(cond
									((!= local1 25)
										(= local1 25)
										(= local4 60)
										(= local5 120)
										(localproc_0)
									)
									(local0
										(Print 33 58) ; "You're already going there."
									)
									(else
										(Print 33 59) ; "You're already there."
									)
								)
							)
							(
								(or
									(Said '/cheeks')
									(Said '/(home,talk)<cheeks')
									(Said
										'/(ave<peach<lonny<222),(peach<lonny<222)'
									)
								)
								(cond
									((!= local1 31)
										(= local1 31)
										(= local4 40)
										(= local5 80)
										(localproc_0)
									)
									(local0
										(Print 33 58) ; "You're already going there."
									)
									(else
										(Print 33 59) ; "You're already there."
									)
								)
							)
							((Said '/cafe,arnie,date,chow')
								(cond
									((!= local1 29)
										(= local1 29)
										(= local4 120)
										(= local5 120)
										(localproc_0)
									)
									(local0
										(Print 33 58) ; "You're already going there."
									)
									(else
										(Print 33 59) ; "You're already there."
									)
								)
							)
							(
								(or
									(Said
										'/warehouse,(district<warehouse),187,area>'
									)
									(Said
										'/(ave<rose<lonny<160),(rose<lonny<160)'
									)
								)
								(cond
									(
										(and
											(or
												(Said '/area,187')
												(Said '187<drive,drive')
											)
											(!= global100 10)
										)
										(Print 33 60) ; "Murder? What murder?"
									)
									((!= local1 27)
										(= local1 27)
										(= local4 62)
										(= local5 60)
										(localproc_0)
									)
									(local0
										(Print 33 58) ; "You're already going there."
									)
									(else
										(Print 33 59) ; "You're already there."
									)
								)
							)
							((Said '/center,mall,(tree<fig)')
								(cond
									((!= local1 67)
										(= local1 67)
										(= local4 180)
										(= local5 120)
										(localproc_0)
									)
									(local0
										(Print 33 58) ; "You're already going there."
									)
									(else
										(Print 33 59) ; "You're already there."
									)
								)
							)
							((Said '/ave<fig<5556')
								(Print 33 61) ; "You have hotter leads to follow."
								(User canInput: 1)
							)
							(
								(or
									(Said '/castle')
									(Said '/willie<drunk')
									(Said '/chamber<blue')
									(Said '/delphoria')
								)
								(Print 33 62) ; "Lytton has seen many businesses fail in the last year... and that was one of them."
							)
							((Said '/steelton,houston,coarsegold')
								(User canInput: 1)
								(Print 33 63) ; "That's a great place, but it's too far to drive there right now."
							)
							((Said '/*')
								(User canInput: 1)
								(Print 33 64) ; "You don't need to drive there."
							)
							(else
								(event claimed: 1)
								(Print 33 65) ; "A good detective always knows where he's going."
							)
						)
					)
					(
						(or
							(Said
								'exit,japaneseclimbdown,(get<out),exit[/auto]'
							)
							(Said 'open/door,japanesedoor')
						)
						(proc33_1)
					)
				)
			)
		)
	)
)

(instance gloveBoxScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gloveBox
					view: 269
					loop: 0
					cel: 0
					posn: 201 151
					setPri: 14
					init:
					ignoreActors:
					stopUpd:
				)
				(gloveBoxDoor
					view: 269
					loop: 1
					cel: (if (not local2) 0 else 1)
					posn: 197 144
					setPri: 15
					init:
					ignoreActors:
				)
				(registration
					view: 269
					loop: 0
					cel: 1
					posn: 198 135
					setPri: 15
					init:
					ignoreActors:
					stopUpd:
				)
				(if (IsItemAt 37 33) ; your_LPD_business_card
					(businessCard
						view: 269
						posn: 192 132
						setPri: 15
						loop: 0
						cel: 2
						init:
						stopUpd:
					)
				)
				(if (not local2)
					(aTimer setReal: self 2)
				)
			)
			(1
				(gloveBoxDoor setCel: 1)
			)
			(2
				(gloveBoxDoor setCel: 0)
				(aTimer setReal: self 2)
			)
			(3
				(if (!= (gCast indexOf: businessCard) -1)
					(businessCard dispose:)
				)
				(registration dispose:)
				(if (!= (gCast indexOf: smallFlashLight) -1)
					(smallFlashLight dispose:)
				)
				(gloveBox dispose:)
				(gloveBoxDoor dispose:)
			)
		)
	)
)

