;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 61)
(include sci.sh)
(use Main)
(use Interface)
(use Avoid)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm61 0
)

(synonyms
	(woman her shelly witness woman jogger)
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
	local9
	local10
	local11
)

(procedure (localproc_0)
	(Print &rest #at -1 18)
)

(procedure (localproc_1)
	(Print &rest #at -1 156)
)

(procedure (localproc_2)
	(switch global131
		(13
			(if (not (gEgo inRect: 144 188 166 197))
				(Print 61 115) ; "You're not close enough to your car's door."
			else
				(if (and (== global100 5) (not global183))
					(gEgo setMotion: MoveTo 125 188)
					(return (Print 61 116)) ; "Hey, Sonny!" Keith shouts, "We can't leave yet. We haven't checked everything out."
				)
				(cond
					(global133
						(Print 61 117) ; "Your car door is locked"
						(return 0)
					)
					(global135
						(Print 61 118) ; "Close the trunk first."
						(return 0)
					)
					((gEgo has: 10) ; field_kit
						(Print 61 119) ; "You should put your field kit in the trunk first."
						(return 0)
					)
					(else
						(carScript changeState: 7)
						(return 1)
					)
				)
			)
		)
		(33
			(cond
				((not (gEgo inRect: 144 188 166 197))
					(Print 61 115) ; "You're not close enough to your car's door."
				)
				((== global136 1)
					(Print 61 117) ; "Your car door is locked"
				)
				(else
					(carScript changeState: 7)
				)
			)
		)
	)
)

(instance unTrunk of Prop
	(properties)
)

(instance carDoor of Prop
	(properties)
)

(instance gelepsi of Act
	(properties)
)

(instance barbie of Act
	(properties)
)

(instance ourCar of Act
	(properties)
)

(instance grass1 of View
	(properties)
)

(instance grass2 of View
	(properties)
)

(instance grass3 of View
	(properties)
)

(instance grass4 of View
	(properties)
)

(instance ourCarBlock of Blk
	(properties
		top 194
		left 107
		bottom 207
		right 207
	)
)

(instance bwCarBlock of Blk
	(properties
		top 164
		left 105
		bottom 172
		right 201
	)
)

(instance vanBlock of Blk
	(properties
		top 164
		bottom 178
		right 30
	)
)

(instance rm61 of Rm
	(properties
		picture 61
		style 6
	)

	(method (dispose)
		(carScript dispose:)
		(stopScript dispose:)
		(gelepsiScript dispose:)
		(barbieScript dispose:)
		(keithScript dispose:)
		(super dispose:)
	)

	(method (init)
		(Load rsVIEW 0)
		(Load rsVIEW 20)
		(Load rsVIEW 253)
		(Load rsVIEW 54)
		(Load rsVIEW 51)
		(super init:)
		(= global211 (!= global100 5))
		(if (== global100 5)
			(= global212 3)
		)
		(= local0 (not (= local3 (== gPrevRoomNum 60))))
		(= local1 (if (== global130 gCurRoomNum) local0))
		(if (>= 6 global100 5)
			(= global138 0)
			(= global158 0)
			(= global159 0)
		)
		(if (== global189 3)
			(= global189 1)
		)
		(= local11 20)
		(if local3
			(HandsOn)
			(= local4 global111)
		else
			(HandsOff)
			(cond
				(local1
					(if (and (== global111 3) (IsFlag 20))
						(= local4 4)
						(= global211 1)
						(ClearFlag 20)
					else
						(= local4 global111)
					)
					(= global186 0)
				)
				((< global100 5)
					(= local4 0)
				)
				((== global100 5)
					(cond
						((> 90 global158 1)
							(= local4 2)
							(= global158 0)
						)
						((IsFlag 20)
							(= local4 4)
							(ClearFlag 20)
							(= global186 0)
						)
						(else
							(= local4 3)
							(= global158 0)
						)
					)
				)
				((>= global100 6)
					(= local4 1)
				)
			)
			(= global111 local4)
		)
		(if global183
			(= global188 0)
		)
		(self setLocales: 155)
		(grass1 view: 253 loop: 0 cel: 3 posn: 213 132 stopUpd: addToPic:)
		(grass2 view: 253 loop: 0 cel: 2 posn: 231 75 stopUpd: addToPic:)
		(grass3 view: 253 loop: 0 cel: 1 posn: 153 76 stopUpd: addToPic:)
		(grass4 view: 253 loop: 0 cel: 3 posn: 67 114 stopUpd: addToPic:)
		(if (== gPrevRoomNum 60)
			(gEgo observeBlocks: ourCarBlock)
		)
		(if (>= local4 3)
			(gEgo observeBlocks: bwCarBlock)
			((View new:) view: 54 loop: 1 cel: 3 posn: 159 175 init: addToPic:)
			(gelepsi
				view: 48
				loop: 2
				posn: 190 120
				setStep: 3 4
				init:
				setCycle: Walk
				illegalBits: 0
				setScript: gelepsiScript
			)
			(if (!= global189 0)
				(= global185 1)
			)
			(if (and (not global185) (not global187))
				(barbie
					view: 11
					loop: 2
					posn: 219 136
					init:
					setCycle: Walk
					setAvoider: (Avoid new:)
					setMotion: Follow gEgo 500
					illegalBits: 0
					setScript: barbieScript
				)
				(if (< global110 30)
					(barbie setMotion: 0 stopUpd:)
				)
			)
		)
		(ourCar
			view: 54
			setStep: 1
			setLoop: 1
			setCel: (if (== global131 13) 1 else 5)
			setCycle: 0
			setMotion: 0
			posn: (if (and (not local3) (not local1)) 150 else 164) 205
			init:
			setPri: 15
			ignoreActors:
		)
		(= local2 (and (gCast contains: gelepsi) (== gPrevRoomNum 13)))
		(if (and (>= local4 3) (>= global189 5))
			((View new:) view: 154 loop: 0 cel: 0 posn: -20 181 init: addToPic:)
			(gEgo observeBlocks: vanBlock)
		)
		(self setScript: rm61Script)
	)
)

(instance rm61Script of Script
	(properties)

	(method (doit)
		(if local2
			(if (< (gEgo distanceTo: gelepsi) 50)
				(gelepsi setLoop: 1)
			else
				(gelepsi setLoop: -1)
			)
		)
		(if (> local11 1)
			(-- local11)
		)
		(cond
			((and (== global132 local0 1) (not (gCast contains: ourCar)))
				(= global132 0)
				(carScript changeState: 0)
			)
			((== (gEgo edgeHit:) EDGE_LEFT)
				(= global205 0)
				(gCurRoom newRoom: 60)
			)
			((== global132 (not local0) 1)
				(= global132 0)
				(localproc_2)
			)
		)
		(cond
			((and (> (gEgo y:) 205) (not local0))
				(switch (Random 0 2)
					(0
						(Print 61 0) ; "It's a long walk to anywhere, Sonny."
					)
					(1
						(Print 61 1) ; "Even the squirrels around here know not to go into the street."
					)
					(2
						(Print 61 2) ; "A bag lady across the street gives you a dirty look, then hurries on her way."
					)
				)
				(gEgo setMotion: MoveTo (gEgo x:) 176)
			)
			((and (== (gEgo edgeHit:) EDGE_RIGHT) (== local11 1))
				(gEgo x: 340)
				(if local6
					(Print 61 3) ; "She said upriver, not downriver."
				else
					(switch (Random 0 2)
						(0
							(Print 61 4) ; "There's nothing back this way except a smelly old swamp."
						)
						(1
							(Print 61 5) ; "The fishing's better over here, Sonny. Come back!"
						)
						(2
							(Print 61 6) ; "Judging from the stench, you think you may have discovered a toxic waste dump."
						)
					)
				)
				(= local11 50)
			)
		)
		(if (< (gEgo y:) 72)
			(gEgo y: 72)
		)
		(if (and (== global189 3) (not (gEgo inRect: 0 148 34 182)))
			(Print 61 7) ; "There's the diving team, Sonny," Keith points out. "You go ahead. We'll stand by the radio in case they spot Bains."
			(= global189 5)
			(gEgo observeBlocks: vanBlock)
			((Act new:)
				view: 154
				loop: 0
				cel: 0
				posn: -55 174
				init:
				setMotion: MoveTo -20 181
			)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					view: 0
					posn: 28 (gEgo y:)
					illegalBits: $8000
					ignoreActors: 0
					setPri: -1
					setLoop: -1
					init:
					setMotion: 0
				)
				(if local3
					(gEgo setMotion: MoveTo 50 (gEgo y:))
				else
					(gEgo posn: 200 240)
				)
				(if (== global131 13)
					((= global112 (Act new:))
						view: 20
						cel: 0
						posn: -100 400
						setAvoider: (Avoid new:)
						setScript: keithScript
						init:
					)
				)
				(if (and (== global131 13) local3)
					(global112
						cel: 0
						posn: 6 (+ (gEgo y:) 5)
						setMotion: Follow gEgo 30
					)
					(if global135
						(unTrunk
							view: 51
							loop: 5
							cel: 2
							posn: 126 209
							setPri: 15
							init:
						)
					)
				)
				(if
					(and
						(>= local4 3)
						(not local0)
						(or global187 (!= global189 0))
					)
					(global112 posn: 157 158 loop: 1 cel: 0 stopUpd:)
					(gelepsi posn: 133 162 loop: 0 cel: 4 stopUpd:)
				)
				(if (not local3)
					(stopScript init:)
					(ourCar setMotion: MoveTo 164 205 stopScript)
				else
					(ourCar addToPic:)
				)
				(cond
					((!= global130 gCurRoomNum)
						(= global130 gCurRoomNum)
					)
					((== local0 1)
						(= global132 1)
					)
				)
			)
		)
	)

	(method (handleEvent event)
		(switch (event type:)
			(evSAID
				(cond
					((Said 'show/badge')
						(Print 61 8) ; "You flash your badge, impressing no one."
					)
					((Said 'look<through/fence,hole')
						(if (gEgo inRect: 169 125 320 200)
							(Print 61 9) ; "Through the hole in the fence, you see a swampy area."
						else
							(Print 61 10) ; "You're too far away to see any details."
						)
					)
					((Said 'look/fence')
						(if (gEgo inRect: 169 125 320 200)
							(Print 61 11) ; "The weathered old fence has been here for some time. Many kids have carved their initials in it. Yours are there, somewhere."
						else
							(Print 61 10) ; "You're too far away to see any details."
						)
					)
					((Said 'read,look/fence,initials')
						(Print 61 12) ; "You read: "J.S. + D.C." "B.H. + J.C." "B.F. + S.C." "C.C. + R.L." "J.W. + D.W.""
					)
					((Said 'look>')
						(cond
							((Said '/briefcase')
								(Print 61 13) ; "You don't need to use your field kit here."
							)
							((Said '/auto')
								(if (gEgo inRect: 72 142 360 240)
									(switch (Random 0 2)
										(0
											(Print 61 14) ; "You notice that the car has four tires."
										)
										(1
											(Print 61 15) ; "Hmmm," you think to yourself, "that car needs to be washed."
										)
										(2
											(Print 61 16) ; "Looking at the car, you remember that it's time to change your oil."
										)
									)
								else
									(Print 61 10) ; "You're too far away to see any details."
								)
							)
							((Said '/van,bus')
								(if (and (> global189 2) (>= global111 3))
									(Print 61 17) ; "This is a 'Special Forces' van, used just for unusual circumstances."
								else
									(Print 61 18) ; "That's nowhere to be seen."
								)
							)
							((Said '/trunk<tree')
								(Print 61 19) ; "The tree's trunk holds up the rest of the tree."
							)
							((Said '/trunk')
								(if (== global131 13)
									(if
										(and
											(gEgo inRect: 93 193 129 208)
											(gCast contains: unTrunk)
										)
										(gInventory
											carrying:
												{The car's trunk contains }
											empty: {The car's trunk is empty.}
											showSelf: 13
										)
									else
										(Print 61 20) ; "You're not close enough to an open trunk."
									)
								else
									(Print 61 21) ; "Your car's "hatch-back" hasn't worked since its warranty expired."
								)
							)
							((Said '<below/board,plank,wood')
								(if (gEgo inRect: 110 130 190 160)
									(Print 61 22) ; "Dead grass and bugs; believe me - those are the only things under there."
								else
									(Print 61 23) ; "You're too far away to move it."
								)
							)
							((Said '<below/rock')
								(if (gEgo inRect: 0 110 120 160)
									(Print 61 22) ; "Dead grass and bugs; believe me - those are the only things under there."
								else
									(Print 61 23) ; "You're too far away to move it."
								)
							)
							((Said '<below/bush')
								(Print 61 24) ; "You don't see anything but dirt under there."
							)
							((Said '/rock')
								(if (gEgo inRect: 12 88 132 120)
									(Print 61 25) ; "They appear to be igneous rocks. Very grey, too."
								else
									(Print 61 10) ; "You're too far away to see any details."
								)
							)
							((Said '/board,plank,wood')
								(if (gEgo inRect: 120 145 196 170)
									(Print 61 26) ; "The board is in a severe state of decay."
								else
									(Print 61 10) ; "You're too far away to see any details."
								)
							)
							((or (Said '/phone') (Said '/booth[<phone]'))
								(if (gEgo inRect: 208 102 273 138)
									(Print 61 27) ; "This telephone is for the convenience of the public. From the looks of it, it has been well used and abused."
								else
									(Print 61 10) ; "You're too far away to see any details."
								)
							)
							((Said '/shit,waste,garbage')
								(if (== (gEgo edgeHit:) EDGE_RIGHT)
									(Print 61 28) ; "It's not a pretty sight. The garbage-filled swamp should be cleaned up."
								else
									(Print 61 29) ; "You can't see much of the swamp from here."
								)
							)
							((Said '/cop,gelepsi,cop')
								(if (gCast contains: gelepsi)
									(Print 61 30) ; "Officer Mario Gelepsi is a large, handsome man with a friendly smile... when he's not angry."
								else
									(Print 61 31) ; "There are no uniformed officers in the area."
								)
							)
							((Said '/woman')
								(if (gCast contains: barbie)
									(Print 61 32) ; "The young jogger is actually shaking with fear."
								else
									(Print 61 33) ; "She's not anywhere in sight."
								)
							)
							((Said '[<at,around][/(!*,cove,area)]')
								(Print 61 34) ; "This is Cotton Cove. It brings back many memories of your youth."
								(event claimed: 1)
							)
						)
					)
					((Said 'smell/garbage,shit,waste')
						(Print 61 35) ; "Yes, you can smell the swamp."
					)
					((Said 'drop,place,replace/briefcase')
						(if (gEgo inRect: 93 193 129 208)
							(if global135
								(if (gEgo has: 10) ; field_kit
									(Print 61 36) ; "You place your field kit inside the trunk."
									(PutItem 10 13) ; field_kit
									(= global240 0)
									(if (IsObject gFKit)
										(gFKit dispose:)
									)
								else
									(Print 61 37) ; "You don't have the field kit."
								)
							else
								(Print 61 38) ; "Open the trunk first."
							)
						else
							(Print 61 39) ; "You're not close enough to your car's trunk."
						)
					)
					((Said 'remove,get/briefcase')
						(if (gEgo inRect: 93 193 129 208)
							(if global135
								(if (== ((gInventory at: 10) owner:) 13) ; field_kit
									(Print 61 40) ; "You take your field kit from the trunk."
									(gEgo get: 10) ; field_kit
								else
									(Print 61 41) ; "The field kit is not in the trunk."
								)
							else
								(Print 61 38) ; "Open the trunk first."
							)
						else
							(Print 61 39) ; "You're not close enough to your car's trunk."
						)
					)
					((Said 'yes')
						(Print 61 42) ; "How about that?"
					)
					((Said 'no')
						(Print 61 43) ; "It's no help being negative."
					)
					(
						(or
							(Said 'use,dial/phone')
							(Said 'drop/dime,cash[/phone]')
						)
						(if (gEgo inRect: 240 122 246 126)
							(HandsOff)
							(Print 61 44 #at 120 50 #time 5) ; "You find two dimes in the phone's change box and deposit them into the phone."
							(Print 61 45 #at 120 50 #time 8) ; "A strange clicking sound is followed by a low buzz. You suspect something is wrong."
							(Print 61 46 #at 120 50 #time 8) ; ""Puleeez deposit twenty cents, sir," the operator whines."
							(HandsOn)
						else
							(Print 61 47) ; "To reach out and touch someone, you must first be close enough to reach out and touch the phone."
						)
					)
					(
						(Said
							'enter,walk,go,crawl[<through]/hole,fence[/hole,fence]'
						)
						(Print 61 48) ; "You can't get through."
					)
					((Said 'hoist,move,get/board,plank,wood')
						(if (gEgo inRect: 120 145 196 170)
							(Print 61 22) ; "Dead grass and bugs; believe me - those are the only things under there."
						else
							(Print 61 23) ; "You're too far away to move it."
						)
					)
					((or (Said 'enter/auto') (Said 'open/door') (Said 'get<in'))
						(localproc_2)
					)
					((Said 'exit/auto')
						(= global132 1)
					)
					((Said 'unlock/door')
						(if (gEgo inRect: 144 188 166 197)
							(cond
								((and (== global131 13) (gEgo has: 3)) ; unmarked_car_keys
									(if (== global133 1)
										(= global133 0)
										(Print 61 49) ; "OK. It's unlocked."
									else
										(Print 61 50) ; "The door is already unlocked."
									)
								)
								((== global131 13)
									(Print 61 51) ; "You need a key to unlock this door."
								)
							)
							(cond
								((and (== global131 33) (gEgo has: 2)) ; key_ring
									(if (== global136 1)
										(= global136 0)
										(Print 61 49) ; "OK. It's unlocked."
									else
										(Print 61 50) ; "The door is already unlocked."
									)
								)
								((== global131 33)
									(Print 61 51) ; "You need a key to unlock this door."
								)
							)
						else
							(proc0_7) ; "You're not close enough."
						)
					)
					((Said 'lock/door')
						(if (gEgo inRect: 144 188 166 197)
							(if (== global131 13)
								(if (== global133 0)
									(= global133 1)
									(Print 61 52) ; "OK. It's locked."
								else
									(Print 61 53) ; "The door is already locked."
								)
							)
							(if (== global131 33)
								(if (== global136 0)
									(= global136 1)
									(Print 61 52) ; "OK. It's locked."
								else
									(Print 61 53) ; "The door is already locked."
								)
							)
						else
							(proc0_7) ; "You're not close enough."
						)
					)
					((Said 'open,unlock/trunk')
						(if (== global131 13)
							(if (gEgo inRect: 93 193 129 208)
								(cond
									(global135
										(Print 61 54) ; "It's already open."
									)
									((gEgo has: 3) ; unmarked_car_keys
										(carScript changeState: 13)
									)
									(else
										(Print 61 55) ; "You need a key to open this trunk."
									)
								)
							else
								(proc0_7) ; "You're not close enough."
							)
						else
							(Print 61 21) ; "Your car's "hatch-back" hasn't worked since its warranty expired."
						)
					)
					((Said 'close,lock/trunk')
						(if (== global131 13)
							(if (gEgo inRect: 93 193 129 208)
								(if global135
									(carScript changeState: 15)
									(= global135 0)
								else
									(Print 61 56) ; "It's already closed."
								)
							else
								(proc0_7) ; "You're not close enough."
							)
						else
							(Print 61 21) ; "Your car's "hatch-back" hasn't worked since its warranty expired."
						)
					)
					((Said 'calm,calm[/woman]')
						(if (gCast contains: barbie)
							(Print 61 57) ; "You try to calm the witness, but she's just too excited."
						else
							(Print 61 58) ; "She's no where around."
						)
					)
					((Said 'call/coroner')
						(cond
							((not (gCast contains: gelepsi))
								(Print 61 59) ; "There is no reason to call the coroner."
							)
							((and global184 (not (IsFlag 54)))
								(Print 61 60) ; ""Ok'a, Sonny, I'lla call the coroner for you," responds officer Gelepsi."
								(SetScore 3 54)
							)
							((< (gEgo distanceTo: gelepsi) 35)
								(Print 61 61) ; "I like talkin', Sonny," grunts Officer Gelepsi, "but shouldn't you be getting on with the investigation?"
							)
							(else
								(Print 61 62) ; "Officer Gelepsi is a little hard of hearing. Better get closer."
							)
						)
					)
					((Said 'talk>')
						(cond
							((Said '/cop,gelepsi,cop')
								(if (gCast contains: gelepsi)
									(if (< (gEgo distanceTo: gelepsi) 25)
										(if (== global131 13)
											(cond
												(
													(<
														(global112
															distanceTo: gelepsi
														)
														30
													)
													(if global183
														(Print 61 63) ; "Officer Gelepsi and Keith are busy discussing the details of the shoot-out."
													else
														(Print 61 64) ; "Officer Gelepsi is busy talking to Keith. Listening, you hear some good gossip, but nothing relating to the task at hand."
													)
												)
												(
													(and
														global184
														(not (IsFlag 54))
													)
													(Print 61 60) ; ""Ok'a, Sonny, I'lla call the coroner for you," responds officer Gelepsi."
													(SetScore 3 54)
												)
												(else
													(Print 61 61) ; "I like talkin', Sonny," grunts Officer Gelepsi, "but shouldn't you be getting on with the investigation?"
												)
											)
										else
											(Print 61 65) ; ""Hey, Sonny, where's your partner? And what are you doing driving your personal car?" Officer Gelepsi asks."
										)
									else
										(Print 61 62) ; "Officer Gelepsi is a little hard of hearing. Better get closer."
									)
								else
									(Print 61 31) ; "There are no uniformed officers in the area."
								)
							)
							((Said '/friend')
								(if (gCast contains: global112)
									(if (< (gEgo distanceTo: global112) 45)
										(Print 61 66) ; "Keith says "I'm with ya, Sonny.""
									else
										(Print 61 67) ; "Get closer."
									)
								else
									(Print 61 68) ; "Keith is not here."
								)
							)
							((Said '/woman')
								(if
									(and
										(gCast contains: barbie)
										(< (gEgo distanceTo: barbie) 38)
									)
									(if local5
										(localproc_1 61 69) ; "(You could talk all day, but she's a witness - so ASK her something!)"
									else
										(= local5 1)
										(Print 61 70) ; "Oh, Officer! It was terrible. There was... oh... BLOOD and... and... drag marks to the river!"
									)
								else
									(Print 61 71) ; "She can't hear you."
								)
							)
							(else
								(Print 61 72) ; "Who are you talking to?"
								(event claimed: 1)
							)
						)
					)
					((Said 'close/door[<booth]')
						(Print 61 73) ; "The phone booth's door is broken and can't be closed."
					)
					((Said '/briefcase')
						(Print 61 13) ; "You don't need to use your field kit here."
					)
					((gCast contains: barbie)
						(cond
							((Said '[say]/hello')
								(if (> (gEgo distanceTo: barbie) 38)
									(Print 61 74) ; "You can't seem to attract her attention from this distance."
								else
									(barbieScript changeState: 1)
								)
							)
							((Said 'feel,fuck,kiss,eat/woman')
								(if (> (gEgo distanceTo: barbie) 38)
									(Print 61 74) ; "You can't seem to attract her attention from this distance."
								else
									(barbieScript changeState: 4)
								)
							)
							((Said 'interrogate,ask>')
								(cond
									((> (gEgo distanceTo: barbie) 38)
										(event claimed: 1)
										(Print 61 75) ; "You're too far away for her to hear you."
									)
									((Said '/badge,license[<woman]')
										(barbieScript changeState: 3)
									)
									(
										(or
											(Said '/number[<phone]')
											(Said '/date')
											(Said '//date')
										)
										(Print 61 76) ; "You're kinda cute, but I don't date cops."
									)
									((Said '/name[<woman]')
										(barbieScript changeState: 2)
									)
									((Said '/address[<woman]')
										(barbieScript changeState: 3)
									)
									(
										(or
											(Said '/blood,mark,clue,location')
											(Said '/woman')
											(Said '<where')
										)
										(if local6
											(Print 61 77) ; ""I've told you all I know, Officer," she stammers."
										else
											(= local6 1)
											(SetScore 2)
											(barbieScript changeState: 5)
											(localproc_0 61 78) ; "The girl tells you the location..."Just walk upriver about a hundred yards or so. It's right next to the water!""
										)
									)
									(else
										(Print 61 79) ; ""I saw blood... and drag marks..." she cries."
										(event claimed: 1)
									)
								)
							)
							((Said 'show[/clue,(print<feet),blood,me]')
								(if (> (gEgo distanceTo: barbie) 28)
									(Print 61 74) ; "You can't seem to attract her attention from this distance."
								else
									(barbieScript changeState: 6)
								)
							)
						)
					)
					((Said 'ask/')
						(Print 61 80) ; "You listen carefully, but nobody answers you."
					)
				)
			)
		)
	)
)

(instance carScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					setStep: 1 2
					posn: 157 202
					setPri: 14
					setLoop: 0
					setCycle: 0
					ignoreActors: 1
					illegalBits: 0
					setMotion: MoveTo 155 185 self
				)
				(if (== global131 13)
					(global112
						posn: 167 206
						loop: 0
						cel: 0
						setPri: 15
						startUpd:
					)
					(carDoor
						view: 51
						loop: 3
						cel: 0
						posn: 182 197
						setPri: 15
						init:
						setCycle: End
					)
				)
			)
			(1
				(= local0 0)
				(if (== global131 13)
					(= global133 0)
				else
					(= global136 0)
				)
				(gEgo
					setStep: 3 2
					setCycle: Walk
					setLoop: -1
					setPri: -1
					ignoreActors: 0
					illegalBits: $c000
				)
				(if (>= local4 3)
					(gEgo observeBlocks: ourCarBlock bwCarBlock)
				else
					(gEgo observeBlocks: ourCarBlock)
				)
				(if (== global131 13)
					(self cue:)
				else
					(HandsOn)
				)
			)
			(2
				(carDoor dispose:)
				(global112 setMotion: MoveTo 98 198 self)
			)
			(3
				(global112 setPri: -1 setMotion: MoveTo 92 185 self)
				(HandsOn)
			)
			(4
				(global112 loop: 2 cel: 0 setMotion: MoveTo 88 154 self)
				(switch local4
					(1
						(Print 61 81 #draw) ; "What are we doing back here, Sonny?"
					)
					(2
						(Print 61 82 #at -1 60 #draw) ; "Keith looks at you accusingly; "We're too late, Sonny! I told you we should've come here right away. Captain Fletcher is gonna chew us out now!""
					)
					(0
						(Print 61 83 #at -1 60 #draw) ; "What are we doing here?" Keith asks. "Are we going to meet someone?"
					)
				)
			)
			(5
				(global112 setMotion: MoveTo 124 148 self)
			)
			(6
				(global112 stopUpd:)
			)
			(7
				(HandsOff)
				(gEgo stopUpd: ignoreBlocks: ourCarBlock)
				(if (== global131 13)
					(if global186
						(Print 61 84) ; "Keith says..."I don't think we can catch him Sonny! He's probably long gone.""
					else
						(Print 61 85) ; "Keith yells: "Wait up, Sonny! What's the rush, anyway?""
					)
					(global112 ignoreActors: illegalBits: 0)
					(cond
						((< (global112 y:) 168)
							(global112 setMotion: MoveTo 90 150 self)
						)
						((< (global112 y:) 196)
							(global112 setMotion: MoveTo 82 196 self)
						)
						(else
							(self cue:)
						)
					)
				else
					(self changeState: 11)
				)
			)
			(8
				(global112
					ignoreActors:
					illegalBits: 0
					setPri: 15
					setMotion: MoveTo 108 207 self
				)
			)
			(9
				(if (gCast contains: gelepsi)
					(cond
						(global186
							(Print 61 86) ; "Keith tells Officer Gelepsi..."Mario, stand by and secure this area until we return!.""
						)
						(global184
							(Print 61 87) ; "I'lla stick 'round here an'a clean things up," Mario tells you. "See you'a later."
						)
						(else
							(Print 61 87) ; "I'lla stick 'round here an'a clean things up," Mario tells you. "See you'a later."
						)
					)
				)
				(global112 setMotion: MoveTo 170 207 self)
			)
			(10
				(carDoor
					view: 51
					loop: 3
					cel: 0
					posn: 182 197
					setPri: 15
					init:
					setCycle: End self
				)
			)
			(11
				(gEgo
					ignoreActors: 1
					illegalBits: 0
					setPri: 14
					setLoop: 0
					setCycle: 0
					setStep: 1 2
					setMotion: MoveTo 157 202 self
				)
			)
			(12
				(gCurRoom newRoom: global131)
			)
			(13
				(= global135 1)
				(unTrunk
					view: 51
					loop: 5
					cel: 0
					posn: 126 209
					setPri: 15
					init:
					setCycle: End self
				)
			)
			(14
				(unTrunk stopUpd:)
			)
			(15
				(unTrunk
					view: 51
					loop: 5
					cel: 2
					posn: 126 209
					setPri: 1
					startUpd:
					setCycle: CT 0 -1 self
				)
			)
			(16
				(unTrunk dispose:)
			)
		)
	)
)

(instance stopScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo stopUpd:)
				(if (== global131 13)
					(global112 stopUpd:)
				)
			)
			(1
				(= global132 1)
				(HandsOn)
				(ourCar addToPic:)
			)
		)
	)
)

(instance gelepsiScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if local3
					(self cue:)
				else
					(= seconds 3)
				)
			)
			(1
				(if local3
					(gelepsi posn: 188 128 setMotion: MoveTo 170 128 self)
				else
					(gelepsi setMotion: MoveTo 150 146 self)
				)
			)
			(2
				(if (< global110 30)
					(gelepsi setMotion: 0 stopUpd:)
				)
				(if local3
					(if (and global183 (not (IsFlag 30)))
						(SetFlag 30)
						(if (gCast contains: barbie)
							(barbieScript changeState: 7)
						)
						(Print 61 88) ; ""M-my gosh'a, S-S-Sonny! I heard'a the GUNSHOTS!" stammers Officer Gelepsi."
					else
						(Print 61 89 #at 40 24) ; ""What's up, Sonny? I think'a you'a doin' fine." says Officer Gelepsi."
					)
				else
					(gelepsi setMotion: MoveTo 150 150 self)
				)
			)
			(3
				(gEgo loop: 1)
				(gelepsi loop: 2 setStep: 3 4 setMotion: Follow gEgo 500)
				(if (< global110 30)
					(gelepsi setMotion: 0 stopUpd:)
				)
				(cond
					((== local4 3)
						(if (IsFlag 53)
							(Print 61 90) ; ""What'sa up, guys?" Mario asks."
						else
							(if (IsFlag 114)
								(++ global107)
								(localproc_0 61 91) ; "As the car pulls up, Keith winces..."Oh no! I can see from here it's a gal... You got me again, partner. Here's your buck.""
							else
								(localproc_0 61 92) ; "As the car pulls up, Keith says..."Well Sonny, you should have taken the bet. I can see from here it's a gal.""
							)
							(Print 61 93 #at -1 24 #draw) ; "Hi'ya Sonny," Officer Gelepsi says, "The lady over there isa pretty shook up over what she'sa found. You'da better have a talk with her."
							(SetFlag 53)
							(= seconds 2)
						)
					)
					((and (== local4 4) (not local1))
						(= global186 0)
						(localproc_0 61 94) ; "I wasa listening ona the radio, Sonny," Officer Gelepsi grunts. "Too bad you lost that cocka-de-roacha."
					)
					((== local4 4)
						(localproc_0 61 95) ; "Officer Gelepsi says, "Donn'a worry, Sonny. They'lla catch that cocka-de-roacha.""
					)
				)
			)
			(4
				(localproc_0 61 96) ; "Officer Gelepsi continues... "I'lla stick around for awhile, just in case you need me.""
			)
			(5
				(gelepsi setMotion: MoveTo 192 149)
			)
		)
	)
)

(instance barbieScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0 0)
			(1
				(if local7
					(localproc_0 61 97) ; "Hello AGAIN! You sure are friendly."
				else
					(localproc_0 61 98) ; "Hello"
					(= local7 1)
				)
			)
			(2
				(if local8
					(localproc_0 61 99) ; "You have a short memory. Maybe you'd better write this down."
				else
					(= local8 1)
				)
				(localproc_0 61 100) ; "Shelly Wingate"
			)
			(3
				(if local9
					(localproc_0 61 99) ; "You have a short memory. Maybe you'd better write this down."
				else
					(= local9 1)
				)
				(localproc_0 61 101) ; "108 Tenth Street"
			)
			(4
				(if local10
					(Print 61 102) ; "All right, buster, THAT does it! I'm leaving. YOU find that stuff WITHOUT ME!"
					(self changeState: 7)
				else
					(= local10 1)
					(switch (Random 1 4)
						(1
							(Print 61 103) ; "I've always heard such nice things about policemen. But now I see where the nick-name 'pig' comes from."
						)
						(2
							(Print 61 104) ; "Why you filthy little sniveling creep!"
						)
						(3
							(Print 61 105) ; "If I weren't a LADY, I'd...!"
						)
						(4
							(Print 61 106) ; "Why you slimy little SQUID!"
						)
					)
				)
			)
			(5
				(localproc_0 61 107) ; "In an excited voice the woman says... "I was jogging along the river's edge, and...and I came across something that looked like blood...""
				(localproc_0 61 108) ; "Continuing, she says, "I stopped to look, and right next to the blood, I saw marks that looked like something had been dragged into the river. And... and footprints -- I saw footprints!""
				(localproc_0 61 109) ; "You attempt to interrupt, but she keeps rolling it out as she says... "I got scared when I heard the brush crack, so I ran down here and called the Police.""
				(localproc_0 61 110) ; "The jogger says... "Officer, please go look! I hope nothing bad has happened.""
			)
			(6
				(localproc_0 61 111) ; "The girl answers..."Not me! I'm not going back there!" she says, "I'll tell you where it is, but I'm not going!""
				(localproc_0 61 78) ; "The girl tells you the location..."Just walk upriver about a hundred yards or so. It's right next to the water!""
				(= local6 1)
			)
			(7
				(HandsOff)
				(= global185 1)
				(barbie view: 16 setStep: 7 3 setMotion: MoveTo 105 130 self)
			)
			(8
				(barbie setMotion: MoveTo 73 172 self)
			)
			(9
				(if global183
					(localproc_0 61 112) ; "The jogger, frightened by the gunfire, runs away."
				)
				(User canControl: 1)
				(barbie setPri: 15 setMotion: MoveTo 86 198 self)
			)
			(10
				(barbie setMotion: MoveTo 96 220 self)
			)
			(11
				(HandsOn)
				(barbie dispose:)
			)
		)
	)
)

(instance keithScript of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and global187 (> (gEgo x:) 40))
			(= global187 0)
			(self changeState: 3)
		)
		(cond
			((and (== global189 0) (< (gEgo x:) 30) (!= (self state:) 1))
				(self changeState: 1)
			)
			((and (>= (gEgo x:) 30) (== (self state:) 1))
				(self changeState: 2)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(global112 setCycle: Walk)
			)
			(1
				(global112 setMotion: Follow gEgo 50)
				(if (and (not local1) (== gPrevRoomNum 13))
					(Print 61 113 #draw) ; "Keith says... "I'm right behind you partner.""
				)
			)
			(2
				(global112 setMotion: 0 stopUpd:)
			)
			(3
				(if (< global189 3)
					(Print 61 114) ; ""We've radioed for the diver, Sonny, and he'll be here shortly," Keith volunteers."
				)
			)
		)
	)
)

