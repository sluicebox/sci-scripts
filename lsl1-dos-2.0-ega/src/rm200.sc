;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 200)
(include sci.sh)
(use Main)
(use Interface)
(use eRS)
(use n940)
(use Feature)
(use LoadMany)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm200 0
)

(local
	destination
	lookedCabbie
	paidCabbie
	destCount
	cabFare
	badgerTimer
	letsGo
)

(instance rm200 of LLRoom
	(properties
		picture 200
	)

	(method (init)
		(LoadMany rsVIEW 201 202 203 204)
		(User canControl: 0)
		(gTheIconBar disable: 0)
		(gEgo init: hide: stopUpd:)
		(super init:)
		(gTheMusic2 fade:)
		(gTheMusic number: 206 vol: 127 loop: -1 flags: 1 play:)
		(windshield cycleSpeed: (+ global101 5) init: cel: (Random 0 4))
		(driver cycleSpeed: global101 init:)
		(larry init: stopUpd:)
		(leftLight init: stopUpd:)
		(rightLight init: stopUpd:)
		(meter1 init:)
		(meter2 init:)
		(meter3 init:)
		(meter4 init:)
		(rightTurn cycleSpeed: (+ global101 3) setCycle: Fwd init:)
		(trunk init:)
		(license init:)
		(meter init:)
		(if (gEgo has: 12) ; wine
			(HandsOff)
			(gCurRoom setScript: sWineScript)
		else
			(HandsOff)
			(gCurRoom setScript: sRoomScript)
		)
		(ClearFlag 22) ; fNoFawnInDisco
		(= badgerTimer 400)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 200 0) ; "You wonder if cab companies have full-time employees whose sole job is to make these floors sticky."
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(gTheMusic fade:)
		(super newRoom: newRoomNumber)
	)
)

(instance sRoomScript of Script
	(properties)

	(method (doit)
		(super doit: &rest)
		(if (gEgo mover:)
			(if (< ((gCurRoom script:) state:) 9)
				(Print 200 1) ; "Sorry, Mac, but my meter's runnin'. Where didja wanna go?"
				(gEgo setMotion: 0)
			else
				(if (not paidCabbie)
					(SetFlag 38) ; fStiffedCabbie
					(Print 200 2) ; "Waddaya tryin' to do, peahead! You're not gonna stiff me, and get away with it! Step outside, Deadbeat!!"
				else
					(Points 88 1)
					(Print 200 3) ; "Whew! You're glad to get out of here."
				)
				(gCurRoom newRoom: destination)
			)
		)
		(if (and badgerTimer (== (-- badgerTimer) 1))
			(cond
				((< ((gCurRoom script:) state:) 3)
					(Print 200 4) ; "So, wadda we gonna do, buddy? Ya just gonna sit here all night? Some guys gotta earn a livin', ya know!"
					(= badgerTimer 400)
				)
				((== ((gCurRoom script:) state:) 9)
					(Print 200 5) ; "So? Ya gonna pay up? Or does I have ta get rough wit' cha??"
					(= badgerTimer 400)
				)
				((== ((gCurRoom script:) state:) 10)
					(Print 200 6) ; "So? Ya gonna get outta my cab or not? Thanks for da business, but I didn't want ta make no career outta this!"
					(= badgerTimer 400)
				)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				0
				(driver setCycle: End self)
			)
			(1
				1
				(Print 200 7 #at 85 90 #time 6) ; "The cabbie snarls a "Where to, buddy?" as he starts the meter rolling."
				(meter4 setCycle: Fwd)
				(rightTurn setCycle: 0 setCel: 0 stopUpd:)
				(driver setCycle: Beg driver)
				(= cycles 15)
			)
			(2
				2
				(HandsOn)
				(leftTurn cycleSpeed: (+ global101 3) setCycle: Fwd init:)
				(rightLight setCel: 0 stopUpd:)
				(leftLight setCel: 0 stopUpd:)
				(windshield setCycle: Fwd)
				(leftMirror cycleSpeed: (+ global101 5) setCycle: Fwd init:)
				(rightMirror setCycle: Fwd cycleSpeed: (+ global101 5) init:)
				(= cycles 60)
			)
			(3
				3
				(leftTurn setCycle: 0 setCel: 0 stopUpd:)
				(if (or destCount letsGo)
					(= cycles 1)
				)
			)
			(4
				4
				(User canControl: 0)
				(gTheIconBar disable: 0)
				(if (windshield cycleSpeed:)
					(windshield cycleSpeed: (- (windshield cycleSpeed:) 1))
					(leftMirror cycleSpeed: (- (windshield cycleSpeed:) 1))
					(rightMirror cycleSpeed: (- (windshield cycleSpeed:) 1))
					(gTheMusic3
						send: 9 255 (* 1000 (- 8 (windshield cycleSpeed:)))
					)
					(-- state)
					(= cycles 10)
				else
					(= cycles 1)
				)
			)
			(5
				5
				(if letsGo
					(= cycles 1)
				)
			)
			(6
				6
				(if (!= destination gPrevRoomNum)
					(= seconds (Random 12 18))
				else
					(= seconds 4)
				)
			)
			(7
				7
				(rightTurn setCycle: Fwd)
				(leftLight setCel: 1 stopUpd:)
				(rightLight setCel: 1 stopUpd:)
				(= cycles 1)
			)
			(8
				8
				(if (< (windshield cycleSpeed:) 5)
					(windshield cycleSpeed: (+ (windshield cycleSpeed:) 1))
					(leftMirror cycleSpeed: (+ (windshield cycleSpeed:) 1))
					(rightMirror cycleSpeed: (+ (windshield cycleSpeed:) 1))
					(gTheMusic3
						send: 9 255 (* 1000 (- 8 (windshield cycleSpeed:)))
					)
					(-- state)
					(= cycles 10)
				else
					(= cycles 1)
				)
			)
			(9
				9
				(meter4
					setCycle: 0
					setCel:
						(if (== (meter4 cel:) 9)
							0
						else
							(meter4 cel:)
						)
				)
				(windshield setCycle: 0 stopUpd:)
				(leftMirror setCycle: 0 stopUpd:)
				(rightMirror setCycle: 0 stopUpd:)
				(= badgerTimer 400)
				(User canControl: 1)
				(gTheIconBar enable: 0)
				(Printf 200 8 cabFare) ; "Well, here we are, buddy. That'll be $%d.00."
			)
			(10
				10
				(= badgerTimer 400)
				(Print 200 9) ; "Thanks, buddy. Maybe I'll see ya again sometime!"
			)
		)
	)
)

(instance sWineScript of Script
	(properties)

	(method (changeState newState &tmp carSpeed)
		(switch (= state newState)
			(0
				(driver setCycle: End self)
			)
			(1
				(Print 200 10) ; "The driver looks at you and says, "Hey! What's that you got in your coat there? Is that wine?""
				(Print 200 11) ; "Before you can move, the cabbie grabs your precious box of wine and guzzles it all down! Ohmigawd, Larry, hang on!!"
				(driver cel: 0)
				(rightTurn setCycle: Fwd)
				(windshield setCycle: Fwd)
				(leftMirror cycleSpeed: (+ global101 5) setCycle: Fwd init:)
				(rightMirror cycleSpeed: (+ global101 5) setCycle: Fwd init:)
				(meter4 setCycle: Fwd)
				(= cycles 20)
			)
			(2
				(= carSpeed (Random 0 3))
				(rightLight setCel: 0 stopUpd:)
				(leftLight setCel: 0 stopUpd:)
				(windshield
					x:
						(if (mod register 2)
							(if (Random 0 1) 138 else 178)
						else
							158
						)
					cycleSpeed: carSpeed
				)
				(leftMirror cycleSpeed: carSpeed)
				(rightMirror cycleSpeed: carSpeed)
				(if (== register 5)
					(Print 200 12) ; "Brace yourself, Larry. He's swerving all over the road!"
				)
				(if (< register 10)
					(-- state)
					(++ register)
					(= cycles (Random 5 10))
				else
					(windshield x: 138)
					(= cycles 10)
				)
			)
			(3
				(Print 200 13) ; "It seems a bridge abutment has brought your evening in Lost Wages to a sudden, final, and complete halt!"
				(= seconds 3)
			)
			(4
				(Death 203 6 1)
				(Format @gYourPart 200 14) ; "No air bag, eh?"
				(GameOver 200 15)
			)
		)
	)
)

(instance driver of Prop
	(properties
		x 101
		y 173
		z 100
		description {the driver}
		view 202
		priority 9
		signal 16
	)

	(method (cue)
		(super cue:)
		(self stopUpd:)
	)

	(method (doVerb theVerb invItem &tmp tmpDest)
		(switch theVerb
			(2 ; Look
				(if (not lookedCabbie)
					(= lookedCabbie 1)
					(Print 200 16) ; "You wish you hadn't. Mr. America this guy ain't. His strongest feature is his aroma!"
				else
					(Print 200 17) ; "The cabbie wonders why you keep looking at him, but in the mirror he flashes you a coy little smile and a knowing wink."
					(Print 200 18 #at -1 140) ; "(Your stomach turns, and not from the ride!)"
				)
			)
			(3 ; Do
				(Print 200 19) ; "You can't reach the cabbie from your seat. Why not talk to him?"
			)
			(10 ; Zipper
				(Print 200 20) ; "Yuck! Your stomach turns at the thought."
			)
			(11 ; Taste/Smell
				(Print 200 21) ; "This cab smells terrible!"
			)
			(5 ; Talk
				(cond
					(
						(or
							(== ((gCurRoom script:) state:) 7)
							(== ((gCurRoom script:) state:) 8)
						)
						(Print 200 22) ; "We're there already; just sit tight, willya, Buddy?"
					)
					((== ((gCurRoom script:) state:) 9)
						(Print 200 5) ; "So? Ya gonna pay up? Or does I have ta get rough wit' cha??"
						(= badgerTimer 400)
					)
					((== ((gCurRoom script:) state:) 10)
						(Print 200 6) ; "So? Ya gonna get outta my cab or not? Thanks for da business, but I didn't want ta make no career outta this!"
						(= badgerTimer 400)
					)
					(else
						(switch destCount
							(0
								(if (not (IsFlag 88)) ; pRodeInCab
									(Print 200 23) ; "You ask the cabbie, "Where's the action?""
									(Print 200 24) ; "Lookin' for action, eh? Dis town is really full of it. We gotta disco full of foxes this time of night. Den dere's the casino, next to the all-night weddin' chapel. And we gotta lovely bar, but you've already been dere. Me, I like da convenience store next to da disco, but of course, that's just personal preference."
								)
								(= destination -1)
								(gGame setCursor: 999 1)
								(Animate (gCast elements:) 0)
								(while (< destination 1)
									(= destination
										(PrintD
											{"Where to, Bub?" snorts the cabbie.}
											103
											81
											{ Disco }
											600
											81
											{ Casino }
											300
											81
											{ Wedding Chapel }
											400
											103
											81
											{Convenience Store}
											500
											81
											{Lefty's Bar}
											100
										)
									)
								)
								(gGame
									setCursor: ((gTheIconBar curIcon:) cursor:) 1
								)
								(+= cabFare (+ (Random 0 10) gCabFareMin))
								(if (!= destination gPrevRoomNum)
									(Print 200 25) ; "Ok. You got it, Mac!"
								else
									(Print 200 26) ; "It won't take us long to get back dere, but I'll have to circle 'round da block."
								)
								(if (< gCabFareMin 40)
									(++ gCabFareMin)
								)
								(= letsGo 1)
							)
							(1
								(Print 200 27) ; "Uh, excuse me, Mr. Driver," you say, "but I think I may wish to change my mind about my destination this evening. Would that be all right with you?"
								(gGame setCursor: 999 1)
								(Animate (gCast elements:) 0)
								(= tmpDest
									(PrintD
										{"Yeah, OK, but it'll cos' ja extra!" the cabbie snarls.}
										103
										81
										{ Disco }
										600
										81
										{ Casino }
										300
										81
										{ Wedding Chapel }
										400
										103
										81
										{Convenience Store}
										500
										81
										{Lefty's Bar}
										100
									)
								)
								(gGame
									setCursor: ((gTheIconBar curIcon:) cursor:) 1
								)
								(if (== tmpDest -1)
									(= tmpDest destination)
								)
								(if (== tmpDest destination)
									(Print 200 28) ; "Geez, some guys jes' can't make up der minds!"
								else
									(= destination tmpDest)
									(+= cabFare gCabFareMin)
									(if (== ((gCurRoom script:) state:) 5)
										(sRoomScript start: 6)
										(gCurRoom setScript: sRoomScript)
									)
								)
							)
							(else
								(Print 200 29) ; "Uh, excuse me, Mr. Driver," you say, "but I think I may wish to change my mind yet again about my destination this evening. Would that be too much trouble?"
								(Print 200 30) ; "Nah, ya changed your min' already! I ain' gonna spen' all night driving you in circles! Next time, figgur out where ya wanna go before ya gets in da cab!"
							)
						)
						(if (== (sRoomScript state:) 3)
							(sRoomScript cue:)
						)
						(++ destCount)
					)
				)
			)
			(4 ; Inventory
				(switch invItem
					(0 ; wallet
						(cond
							((== ((gCurRoom script:) state:) 9)
								(if (< gLarryDollars cabFare)
									(Print 200 31) ; "Sheepishly, you apologize to the cabbie for not carrying enough money to pay for the ride."
									(Print 200 32) ; "Waddaya mean, `no money!!'" snarls the driver. "Step outsid'a ma office, chump!"
									(SetFlag 38) ; fStiffedCabbie
									(gCurRoom newRoom: destination)
								else
									(-= gLarryDollars cabFare)
									(= paidCabbie 1)
									(sRoomScript start: 10)
									(gCurRoom setScript: sRoomScript)
								)
							)
							((== ((gCurRoom script:) state:) 10)
								(Print 200 33) ; "I appreciate your offer of a tip, but it's against my personal philosophy to accept gratuities!"
							)
							(else
								(Print 200 34) ; "Why don'cha jes' wait'll we git there, buddy?"
							)
						)
					)
					(1 ; breathSpray
						(Print 200 35) ; "You quietly and carefully spritz a little spray around, vainly trying to kill some of this odor!"
					)
					(3 ; apple
						(Print 200 36) ; ""Nah, fruit gives me gas!" he grunts."
					)
					(2 ; watch
						(Print 200 37) ; "Hey, hurry up," you cry, "can't you see it's getting late?!"
						(Print 200 38) ; ""Time waits for no man!" he replies cryptically."
					)
					(4 ; ring
						(Print 200 39) ; "I got no use for a diamond ring," shouts the cabbie, "especially one wit a stone like dat! Dat sucker sure looks fake to me!"
					)
					(5 ; whiskey
						(Print 200 40) ; "No, thanks, buddy," replies the cabbie, "but have you got any wine?"
					)
					(6 ; remoteControl
						(Print 200 41) ; "What's that, a tricorder?" he asks. "Don't tell me you're one of dem science fiction freaks?"
					)
					(8 ; lubber
						(Print 200 42) ; "Well, ain't chu all growed up!"
					)
					(9 ; candy
						(Print 200 43) ; ""Thanks, buddy," says the cabbie, as he grabs your box of candy and proceeds to gobble down every piece!"
						(gEgo put: 9 0) ; candy
						(Print 200 44 #at -1 140) ; "(Bad move, Larry! You feel certain you're going to meet someone someday who would really enjoy a piece!)"
					)
					(10 ; discoPass
						(Print 200 45) ; ""No, I don't want to go dancin' with you later," says the cabbie."
					)
					(17 ; graffiti
						(Print 200 46) ; "Not HIM again! Geez, does that guy get around. And I DO mean around!"
					)
					(11 ; pocketKnife
						(Print 200 47) ; "The air in here IS thick enough to cut!"
					)
					(13 ; magazine
						(Print 200 48) ; "No, thanks," says the cabbie, "I gotta subscription!"
					)
					(14 ; hammer
						(Print 200 49) ; "Don't hit the cabbie's head with your hammer; you might hurt it."
						(Print 200 50 #at -1 140) ; "(The hammer, that is!)"
					)
					(15 ; pills
						(Print 200 51) ; "Hey, thanks!" he cries. "One of those and I'll be stuck in fifth gear all night."
						(gEgo put: 15 0) ; pills
						(Print 200 52 #at -1 140) ; "(Good idea, Larry! After all you had to go through to get those pills!)"
					)
					(16 ; ribbon
						(Print 200 53) ; "Wat a coinci-dince! I wuz jes talkin' 'bout ribbon like dat with dis stacked babe fare I hadda little while ago. She wuz tellin' me 'bout how she tied up some dumb dweeb and took all his dough. Boy, did we have a good laugh at that one! You shouldda been here!!"
						(Print 200 54 #at -1 140) ; "(Somehow you feel you were!)"
					)
					(else
						(Print 200 55) ; ""Here, take this!" you offer."
						(Print 200 56) ; ""Nah, I got no need for that!" he replies."
					)
				)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance larry of Prop
	(properties
		x 204
		y 86
		z 14
		description {you}
		lookStr {It's not often you get to see the back of your own head, eh, Lar'?}
		view 201
		priority 10
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 200 57) ; "You scratch your head in amazement at the way this cab can still operate with such severe rear wheel camber!"
			)
			(5 ; Talk
				(Print 200 58) ; "Talkin' to yourself, eh?" smirks the cabbie. "A guy in a job like this runs into lots o' weirdos!"
			)
			(else
				(Print 200 59) ; "Leave yourself alone, Larry!"
			)
		)
	)
)

(instance windshield of Prop
	(properties
		x 158
		y 85
		description {the street}
		lookStr {He sure drives fast, doesn't he?}
		view 204
	)
)

(instance leftMirror of Prop
	(properties
		x 52
		y 79
		description {the mirror}
		view 204
		loop 1
		detailLevel 1
	)
)

(instance rightMirror of Prop
	(properties
		x 266
		y 87
		description {the mirror}
		view 204
		loop 2
		cel 2
		detailLevel 1
	)
)

(instance leftLight of View
	(properties
		x 38
		y 114
		description {the light}
		view 203
		cel 1
		priority 14
		signal 16
	)
)

(instance rightLight of View
	(properties
		x 278
		y 108
		description {the light}
		view 203
		loop 1
		cel 1
		priority 14
		signal 16
	)
)

(instance leftTurn of Prop
	(properties
		x 45
		y 129
		description {the turn signal}
		view 203
		loop 2
		priority 14
		signal 16
		detailLevel 1
	)
)

(instance rightTurn of Prop
	(properties
		x 275
		y 128
		description {the turn signal}
		view 203
		loop 3
		cel 1
		priority 14
		signal 16
		detailLevel 1
	)
)

(instance meter1 of Prop
	(properties
		x 162
		y 62
		description {the meter}
		view 203
		loop 5
		priority 14
		signal 16
	)

	(method (doVerb theVerb invItem)
		(meter4 doVerb: theVerb invItem)
	)
)

(instance meter2 of Prop
	(properties
		x 169
		y 62
		description {the meter}
		view 203
		loop 5
		priority 14
		signal 16
	)

	(method (doVerb theVerb invItem)
		(meter4 doVerb: theVerb invItem)
	)
)

(instance meter3 of Prop
	(properties
		x 176
		y 62
		description {the meter}
		view 203
		loop 5
		priority 14
		signal 16
	)

	(method (doit)
		(super doit: &rest)
		(if (== (meter4 cel:) 9)
			(if (== (self cel:) 9)
				(self cel: 0)
				(if (== (meter2 cel:) 9)
					(meter2 cel: 0)
					(if (== (meter1 cel:) 9)
						(meter1 cel: 0)
					else
						(meter1 cel: (+ (meter1 cel:) 1))
					)
				else
					(meter2 cel: (+ (meter2 cel:) 1))
				)
			else
				(self cel: (+ (self cel:) 1))
			)
		)
	)

	(method (doVerb theVerb invItem)
		(meter4 doVerb: theVerb invItem)
	)
)

(instance meter4 of Prop
	(properties
		x 184
		y 63
		description {the meter}
		view 203
		loop 5
		priority 14
		signal 16
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 200 60) ; "It seems to be running a little fast, but then, this is an expensive town!"
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance meter of Feature
	(properties
		x 170
		y 86
		z 27
		nsTop 53
		nsLeft 154
		nsBottom 66
		nsRight 186
		description {the taxicab's fare meter}
		sightAngle 40
		lookStr {It seems to bear no relationship whatsoever to the rate he charges!}
	)
)

(instance license of Feature
	(properties
		x 167
		y 109
		nsTop 95
		nsLeft 140
		nsBottom 123
		nsRight 195
		description {the cab's license plate}
		sightAngle 40
		lookStr {Isn't that unusual? Most taxicabs don't have customized license plates. You wonder if there's any special significance to the driver.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 200 61) ; "You don't really want to steal his license plate!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance trunk of Feature
	(properties
		x 163
		y 100
		nsTop 71
		nsLeft 96
		nsBottom 130
		nsRight 230
		description {the trunk lid}
		sightAngle 40
		lookStr {You wonder what the cabbie has hauled in there over the years!}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 200 62) ; "You don't have the key to the trunk."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

