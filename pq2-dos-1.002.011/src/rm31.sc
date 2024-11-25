;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 31)
(include sci.sh)
(use Main)
(use Interface)
(use AutoDoor)
(use Avoid)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm31 0
)

(local
	local0
	local1
	[local2 2]
	[local4 2]
	local6
	local7
	local8
	local9
	[local10 8]
	local18
	local19
	local20
	local21
	local22
	local23
	local24
	local25
)

(procedure (localproc_0)
	(Print &rest #at -1 15)
)

(procedure (localproc_1)
	(switch global131
		(13
			(cond
				(
					(not
						(gEgo
							inRect:
								[local10 0]
								[local10 1]
								[local10 2]
								[local10 3]
						)
					)
					(localproc_0 31 76) ; "You're not close enough to the door."
				)
				(global133
					(localproc_0 31 77) ; "Your car door is locked"
					(return 0)
				)
				(global135
					(localproc_0 31 78) ; "Close the trunk first."
					(return 0)
				)
				((gEgo has: 10) ; field_kit
					(localproc_0 31 79) ; "You should put your field kit in the trunk first."
					(return 0)
				)
				(else
					(carScript changeState: 5)
					(return 1)
				)
			)
		)
		(33
			(cond
				(
					(not
						(gEgo
							inRect:
								[local10 0]
								[local10 1]
								[local10 2]
								[local10 3]
						)
					)
					(localproc_0 31 76) ; "You're not close enough to the door."
				)
				(global136
					(localproc_0 31 77) ; "Your car door is locked"
				)
				(else
					(carScript changeState: 5)
				)
			)
		)
	)
)

(instance unTrunk of Prop
	(properties)
)

(instance rm31 of Rm
	(properties
		picture 31
		style 0
	)

	(method (dispose)
		(carScript dispose:)
		(stopScript dispose:)
		(DisposeScript 301)
		(super dispose:)
	)

	(method (init)
		(super init:)
		(= gPerspective 70)
		(if (gEgo has: 36) ; note_from_Marie_s_door
			(= local22 1)
		)
		(if (= local6 (or (== gPrevRoomNum 33) (== gPrevRoomNum 13)))
			(HandsOff)
		else
			(HandsOn)
		)
		(Load rsVIEW 54)
		(Load rsVIEW 51)
		(Load rsVIEW 270)
		(Load rsVIEW 0)
		(if (== gPrevRoomNum 33)
			(Load rsVIEW 20)
		)
		(if (== global131 13)
			(= [local10 0] 19)
			(= [local10 1] 156)
			(= [local10 2] 31)
			(= [local10 3] 164)
			(= [local2 0] 13)
			(= [local2 1] 152)
			(= local18 22)
		else
			(= [local10 0] 32)
			(= [local10 1] 158)
			(= [local10 2] 47)
			(= [local10 3] 165)
			(= [local2 0] 29)
			(= [local2 1] 155)
			(= local18 41)
		)
		(= local8 120)
		(= local9 30)
		(= local19 32)
		(= local21 0)
		((= local20 (AutoDoor new:))
			entranceTo: 32
			facingLoop: -1
			view: 270
			posn: 145 105
			locked: 1
			init:
			stopUpd:
		)
		(= local7 (and (== global130 gCurRoomNum) (!= gPrevRoomNum local19)))
		(if (!= gPrevRoomNum local19)
			(= local6 1)
			(HandsOff)
		else
			(= local6 0)
			(HandsOn)
		)
		((= local0 (Act new:))
			view: 54
			setStep: 3 3
			setLoop: 0
			setCel: (if (== global131 13) 1 else 5)
			setCycle: 0
			setMotion: 0
			posn:
				(if (and (!= local19 gPrevRoomNum) (not local7)) local8 else local9)
				(if (and (!= local19 gPrevRoomNum) (not local7)) 162 else 157)
			init:
			illegalBits: 0
		)
		(self setLocales: 153)
		(self setScript: rm31Script)
	)
)

(instance rm31Script of Script
	(properties)

	(method (doit)
		(cond
			(
				(and
					(>= global100 8)
					(== (gEgo onControl: 1) 16384)
					(not local22)
				)
				(= local22 1)
				(localproc_0 31 0) ; "There is a note pinned to the door."
			)
			((== (local20 doorState:) 2)
				(= gPerspective 0)
				(gCurRoom newRoom: local19)
			)
			((and (== global132 local6 1) (not (gCast contains: local0)))
				(= global132 0)
				(carScript changeState: 0)
			)
			((== global132 (not local6) 1)
				(= global132 0)
				(localproc_1)
			)
		)
		(if (and (>= global100 8) (== global131 13) (not local25))
			(cond
				((< (gEgo x:) 95)
					(if local24
						(= local24 0)
						(global112 setMotion: Follow gEgo 500)
					)
				)
				((not local24)
					(= local24 1)
					(global112 setMotion: Follow gEgo 34)
				)
			)
		)
		(if (and (not local6) (or (<= (gEgo x:) -30) (>= (gEgo x:) 380)))
			(rm31Script changeState: 1)
		)
		(if (and (>= (gEgo y:) 233) (not local6) (< (rm31Script state:) 2))
			(rm31Script changeState: 2)
		)
		(if (and (== (rm31Script state:) 2) (>= (gEgo y:) 240))
			(rm31Script changeState: 3)
		)
		(if (<= (gEgo y:) 108)
			(gEgo y: 110)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					view: 0
					posn:
						(if (== gPrevRoomNum local19) 148 else 340)
						(if (== gPrevRoomNum local19) 118 else 340)
					init:
					setMotion: 0
				)
				(if (== global131 13)
					(if (== gPrevRoomNum local19)
						(if (< global100 8)
							(= local25 1)
							((= global112 (Act new:))
								view: 20
								posn: 340 340
								init:
								setMotion: 0
							)
							(localproc_0 31 1) ; "From inside the car, Keith yells: "C'mon, Sonny! We've got things to do!""
						else
							((= global112 (Act new:))
								view: 20
								posn: 148 112
								setCycle: Walk
								setAvoider: (Avoid new:)
								init:
								setMotion: 0
							)
						)
					else
						((= global112 (Act new:))
							view: 20
							posn: (gEgo x:) (- (gEgo y:) 25)
							setCycle: Walk
							setAvoider: (Avoid new:)
							init:
							setMotion: 0
						)
					)
				)
				(= [local4 0] 68)
				(= [local4 1] 162)
				(if (and (== global131 13) (== gPrevRoomNum local19) global135)
					(unTrunk
						view: 51
						loop: 4
						cel: 2
						posn: [local4 0] [local4 1]
						setPri: 11
						init:
					)
				)
				(if (!= gPrevRoomNum local19)
					(stopScript init:)
					(= global135 0)
					(local0 setMotion: MoveTo local9 157 stopScript)
				else
					(local0 stopUpd: addToPic:)
				)
				(cond
					((!= global130 gCurRoomNum)
						(= global130 gCurRoomNum)
					)
					(local6
						(= global132 1)
					)
				)
			)
			(1
				(Print 31 2) ; "G-R-R-R-R-R-ROWF !"
				(localproc_0 31 3) ; "As Marie's next-door neighbor, a little old lady from Pasadena, rounds the corner with her brood of prize pit bulls, you decide to stay near Marie's house."
				(gEgo setMotion: MoveTo 150 (gEgo y:))
			)
			(2
				(if (and (== global131 13) (>= global100 8))
					(Print 31 4 #draw) ; "Keith yells... "Sonny watch out !!!!""
				else
					(localproc_0 31 5) ; "You shouldn't be wasting your time walking around."
				)
			)
			(3
				(Print 31 6 #time 5) ; "SCREEEEECH..."
				(Print 31 7 #dispose) ; "T*H*U*M*P !!!"
				(ShakeScreen 5)
				(clr)
				(EgoDead
					{In the days that followed, it was most folks' opinion that Sonny Bonds was overly distracted by continuous and lengthy sessions playing a recently released computer game called POLICE QUEST II. This must be why he didn't see the Mack truck driven by the little old lady who lived in the house next to Marie.}
				)
			)
		)
	)

	(method (handleEvent event)
		(switch (event type:)
			(evSAID
				(cond
					((Said 'open,read,look[<in]/note,newspaper')
						(= local23 1)
						(if local22
							(if (not (gEgo has: 36)) ; note_from_Marie_s_door
								(localproc_0 31 8) ; "Take it off the door first."
							else
								(localproc_0 31 9 25 3) ; "The note says..."
								(Print 31 10 #at -1 15 #icon 136 0 0) ; "Dear Sonny, Gone shopping.    Love, Marie"
							)
						else
							(localproc_0 31 11) ; "What note? Where?"
						)
					)
					((Said 'look>')
						(cond
							((Said '/trunk')
								(if (== global131 13)
									(if
										(and
											(gEgo inRect: 73 143 101 159)
											(gCast contains: unTrunk)
										)
										(gInventory
											carrying:
												{The car's trunk contains:}
											empty: {The car's trunk is empty.}
											showSelf: 13
										)
									else
										(localproc_0 31 12) ; "You're not close enough to an open trunk."
									)
								else
									(localproc_0 31 13) ; "Your car's "hatchback" hasn't worked since its warranty expired."
								)
							)
							((Said '[<at,around][/!*,home,building]')
								(localproc_0 31 14) ; "The "Princessette", constructed by Oscar Cano, Inc. This tract was completed back in January 1978, three days before the Dallas Cowboys defeated the Denver Broncos by a score of 27-10 in Super Bowl XII."
							)
							((Said '/chamber')
								(localproc_0 31 15) ; "The rooms are in the house. You're outside."
							)
							((Said '/tree,bush,lawn,grass,flower')
								(localproc_0 31 16) ; "Marie keeps everything well manicured, pruned, and free of weeds."
							)
							((Said '/ave,sidewalk,driveway')
								(localproc_0 31 17) ; "Nothing of interest there."
							)
							((or (Said '<up,down') (Said '/air,dirt,roof'))
								(localproc_0 31 18) ; "Your mind is wandering. You're getting off track."
							)
							((Said '/fence')
								(localproc_0 31 19) ; "The fence encloses the back yard."
							)
							((Said '/note,newspaper')
								(if local22
									(cond
										((not (gEgo has: 36)) ; note_from_Marie_s_door
											(localproc_0 31 8) ; "Take it off the door first."
										)
										(local23
											(localproc_0 31 9 25 3) ; "The note says..."
											(Print ; "Dear Sonny, Gone shopping.    Love, Marie"
												31
												10
												#at
												-1
												15
												#icon
												136
												0
												0
											)
										)
										(else
											(Print ; "You look at a folded piece of paper with your name..."Sonny"...on the front."
												31
												20
												#at
												-1
												15
												#icon
												136
												0
												1
											)
										)
									)
								else
									(localproc_0 31 11) ; "What note? Where?"
								)
							)
							((Said '/wall')
								(localproc_0 31 21) ; "The stucco's in pretty good shape, and so is the paint."
							)
							((Said '/auto')
								(cond
									((== global131 13)
										(localproc_0 31 22) ; "It's your late-model, unmarked patrol car."
									)
									((== global131 33)
										(localproc_0 31 23) ; "It's your car. You'd know it anywhere."
									)
								)
							)
							((Said '/friend')
								(if (== global131 13)
									(if (== (global112 x:) 340)
										(if (< (gEgo x:) 101)
											(localproc_0 31 24) ; "He looks back at you from inside the car."
										else
											(localproc_0 31 25) ; "You can't see him from where you're standing. The sunlight is reflecting off the car windows."
										)
									else
										(localproc_0 31 26) ; "Keith is slouching along behind you."
									)
								else
									(localproc_0 31 27) ; "He's not here."
								)
							)
							((Said '/pane')
								(if (== (gEgo onControl: 1) 8192)
									(localproc_0 31 28) ; "You peer through the window pane but are unable to see anything."
								else
									(localproc_0 31 29) ; "You can't see from here. Go closer to the window."
								)
							)
							((Said '/door<garage')
								(if (> (gEgo x:) 160)
									(localproc_0 31 30) ; "You see nothing unusual about the garage."
								else
									(localproc_0 31 31) ; "You should be closer to get a good look."
								)
							)
							((Said '/door<front,home')
								(if (and (>= global100 8) (not local22))
									(localproc_0 31 0) ; "There is a note pinned to the door."
									(= local22 1)
								else
									(localproc_0 31 32) ; "There's nothing special about the door."
								)
							)
							((Said '/door')
								(cond
									((gEgo inRect: 173 112 305 127)
										(localproc_0 31 30) ; "You see nothing unusual about the garage."
									)
									((gEgo inRect: 122 106 165 124)
										(if (and (>= global100 8) (not local22))
											(localproc_0 31 0) ; "There is a note pinned to the door."
											(= local22 1)
										else
											(localproc_0 31 32) ; "There's nothing special about the door."
										)
									)
									((gEgo inRect: 0 135 101 185)
										(localproc_0 31 33) ; "Your car door looks fine."
									)
									(else
										(localproc_0 31 31) ; "You should be closer to get a good look."
									)
								)
							)
							((Said '/garage')
								(localproc_0 31 30) ; "You see nothing unusual about the garage."
							)
						)
					)
					((Said 'drive')
						(if local6
							(localproc_0 31 34) ; "Go on! Get out and look around first."
						else
							(localproc_0 31 35) ; "Get in your car first."
						)
					)
					((Said 'get/key')
						(if (gEgo inRect: 122 106 165 124)
							(if (== (gEgo onControl: 1) 16384)
								(if (not local21)
									(localproc_0 31 36) ; "You take the spare key from above the door, unlock the door, and replace the key."
									(localproc_0 31 37) ; "You enter Marie's house."
									(= local21 1)
								)
								(local20 locked: 0)
							else
								(localproc_0 31 38) ; "You can't quite reach it."
							)
						else
							(localproc_0 31 39) ; "You already have plenty of keys."
						)
					)
					((Said 'talk/friend')
						(if (== global131 13)
							(if (== (global112 x:) 340)
								(if (< (gEgo x:) 101)
									(localproc_0 31 40) ; "From inside the car, Keith says: "Go on and look around, partner. I'll keep an eye on things out here.""
								else
									(localproc_0 31 41) ; "He can't hear you from inside the car."
								)
							else
								(localproc_0 31 42) ; "Keith is strangely silent at the moment."
							)
						else
							(localproc_0 31 27) ; "He's not here."
						)
					)
					((Said 'get/note')
						(if local22
							(if (not (gEgo has: 36)) ; note_from_Marie_s_door
								(Print 31 43 #at -1 15 #icon 136 0 1) ; "You take the note off the door."
								(gEgo get: 36) ; note_from_Marie_s_door
							else
								(localproc_0 31 44) ; "You already have the note."
							)
						else
							(localproc_0 31 11) ; "What note? Where?"
						)
					)
					((Said 'drop,place/briefcase')
						(if (gEgo inRect: 73 143 101 159)
							(if global135
								(if (gEgo has: 10) ; field_kit
									(localproc_0 31 45) ; "You place your field kit inside the trunk."
									(PutItem 10 13) ; field_kit
									(if (IsObject gFKit)
										(gFKit dispose:)
									)
									(= global240 0)
								else
									(localproc_0 31 46) ; "You don't have the field kit."
								)
							else
								(localproc_0 31 47) ; "Open the trunk first."
							)
						else
							(localproc_0 31 48) ; "You're not close enough to your car's trunk."
						)
					)
					((Said 'remove,get/briefcase')
						(if (gEgo inRect: 73 143 101 159)
							(if global135
								(if (IsItemAt 10 13) ; field_kit
									(localproc_0 31 49) ; "You take your field kit from the trunk."
									(gEgo get: 10) ; field_kit
								else
									(localproc_0 31 50) ; "The field kit is not in the trunk."
								)
							else
								(localproc_0 31 47) ; "Open the trunk first."
							)
						else
							(localproc_0 31 48) ; "You're not close enough to your car's trunk."
						)
					)
					((Said 'climb/fence')
						(if (== (gEgo onControl: 1) 4096)
							(localproc_0 31 51) ; "The door would be easier."
						else
							(localproc_0 31 52) ; "You aren't close enough to the fence."
						)
					)
					((Said 'break/pane')
						(localproc_0 31 53) ; "Marie is sweet but high-spirited. Breaking her window would definitely put you in deep trouble."
					)
					((or (Said '/police') (Said 'open/police'))
						(if (== (gEgo onControl: 1) 16384)
							(localproc_0 31 54) ; "You shout..."POLICE!", but silence is all you hear in return."
						else
							(localproc_0 31 55) ; "You are not close enough to the door."
						)
					)
					((Said '/bains')
						(if (== (gEgo onControl: 1) 16384)
							(localproc_0 31 56) ; "No answer."
						else
							(localproc_0 31 55) ; "You are not close enough to the door."
						)
					)
					((Said '/cheeks')
						(if (== (gEgo onControl: 1) 16384)
							(localproc_0 31 57) ; "You listen after you call Marie's name, but not a sound can you detect from inside the house."
						else
							(localproc_0 31 55) ; "You are not close enough to the door."
						)
					)
					((Said 'knock/door')
						(if (== (gEgo onControl: 1) 16384)
							(localproc_0 31 58) ; "You listen, but no sound can be detected from inside the house."
						else
							(localproc_0 31 55) ; "You are not close enough to the door."
						)
					)
					((or (Said 'open/door') (Said 'get<in'))
						(cond
							((== (gEgo onControl: 1) 16384)
								(if (not local21)
									(localproc_0 31 59) ; "The door is locked."
									(localproc_0 31 60) ; "Fortunately, you know that there is a spare key hidden above the door. You get the key, unlock the door, and replace the key."
									(= local21 1)
								)
								(local20 locked: 0)
							)
							((gEgo inRect: 173 112 305 127)
								(localproc_0 31 61) ; "The garage door is locked."
							)
							(local6
								(= global132 1)
							)
							(else
								(localproc_1)
							)
						)
					)
					((Said 'enter,get<in/auto')
						(localproc_1)
					)
					((Said 'exit,get<out/auto')
						(= global132 1)
					)
					((Said 'unlock/door')
						(cond
							((== (gEgo onControl: 1) 16384)
								(localproc_0 31 59) ; "The door is locked."
								(localproc_0 31 62) ; "Fortunately, you know that there is a spare key hidden above the door. You get the key and unlock the door."
								(local20 locked: 0)
							)
							((gEgo inRect: 173 112 305 127)
								(localproc_0 31 63) ; "You can't. It takes an automatic garage door opener, and you don't have one."
							)
							(
								(gEgo
									inRect:
										[local10 0]
										[local10 1]
										[local10 2]
										[local10 3]
								)
								(cond
									((and (== global131 13) (gEgo has: 3)) ; unmarked_car_keys
										(if global133
											(= global133 0)
											(localproc_0 31 64) ; "OK. It's unlocked."
										else
											(localproc_0 31 65) ; "The door is already unlocked."
										)
									)
									((== global131 13)
										(localproc_0 31 66) ; "You need a key to unlock this door."
									)
								)
								(cond
									((and (== global131 33) (gEgo has: 2)) ; key_ring
										(if global136
											(= global136 0)
											(localproc_0 31 64) ; "OK. It's unlocked."
										else
											(localproc_0 31 65) ; "The door is already unlocked."
										)
									)
									((== global131 33)
										(localproc_0 31 66) ; "You need a key to unlock this door."
									)
								)
							)
							(else
								(localproc_0 31 67) ; "You're not close enough."
							)
						)
					)
					((Said 'lock/door')
						(if
							(gEgo
								inRect:
									[local10 0]
									[local10 1]
									[local10 2]
									[local10 3]
							)
							(if (== global131 13)
								(if (not global133)
									(= global133 1)
									(localproc_0 31 68) ; "OK. It's locked."
								else
									(localproc_0 31 69) ; "The door is already locked."
								)
							)
							(if (== global131 33)
								(if (not global136)
									(= global136 1)
									(localproc_0 31 68) ; "OK. It's locked."
								else
									(localproc_0 31 69) ; "The door is already locked."
								)
							)
						else
							(localproc_0 31 67) ; "You're not close enough."
						)
					)
					((Said 'open,unlock/trunk')
						(if (== global131 13)
							(if (gEgo inRect: 73 143 101 159)
								(cond
									(global135
										(Print 31 70) ; "It's already open."
									)
									((gEgo has: 3) ; unmarked_car_keys
										(carScript changeState: 10)
									)
									(else
										(localproc_0 31 71) ; "You need a key to open this trunk."
									)
								)
							else
								(proc0_7) ; "You're not close enough."
							)
						else
							(localproc_0 31 13) ; "Your car's "hatchback" hasn't worked since its warranty expired."
						)
					)
					((Said 'close,lock/trunk')
						(if (== global131 13)
							(if (gEgo inRect: 73 143 101 159)
								(if global135
									(carScript changeState: 12)
									(= global135 0)
								else
									(Print 31 72) ; "It's already closed."
								)
							else
								(proc0_7) ; "You're not close enough."
							)
						else
							(localproc_0 31 13) ; "Your car's "hatchback" hasn't worked since its warranty expired."
						)
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
					posn: local18 159
					setPri: -1
					loop: 1
					cel: 0
					setCycle: Walk
					startUpd:
				)
				((= local1 (Prop new:))
					view: 51
					loop: (if (== global131 13) 2 else 0)
					cel: 0
					posn: [local2 0] [local2 1]
					setPri: 12
					init:
					setCycle: End self
				)
				(if (== global131 13)
					(= local25 1)
					(global112
						posn: 35 156
						setStep: 1 2
						setLoop: 1
						setCel: 0
						setPri: 9
						ignoreActors: 1
						illegalBits: 0
						startUpd:
						setMotion: MoveTo 38 146
					)
				)
			)
			(1
				(= local6 0)
				(if (== global131 13)
					(= global133 0)
				else
					(= global136 0)
				)
				(local1 dispose:)
				(self cue:)
			)
			(2
				(HandsOn)
				(if (and (== global131 13) (>= global100 8))
					(global112
						setStep: 3 2
						setCycle: Walk
						setLoop: -1
						setPri: 8
						ignoreActors: 0
						illegalBits: $8000
						setMotion: MoveTo 38 146 self
					)
				else
					(self cue:)
				)
			)
			(3
				(cond
					((and (== global131 13) (>= global100 8))
						(= local25 0)
						(global112 setPri: -1)
						(localproc_0 31 73) ; "Let's go, Sonny."
						(global112 setMotion: Follow gEgo 500)
					)
					((== global131 13)
						(localproc_0 31 74 83) ; "Keith grunts, "I'll wait for you here.""
						(global112
							ignoreActors: 1
							illegalBits: 0
							setMotion: MoveTo 35 155 self
						)
					)
				)
			)
			(4
				(global112 posn: 340 340 ignoreActors: 0)
			)
			(5
				(HandsOff)
				(gEgo stopUpd:)
				(if (and (== global131 13) (< (global112 x:) 300))
					(= local25 1)
					(localproc_0 31 75) ; "Keith yells: "I'm coming, Sonny!""
					(if (> (global112 y:) 150)
						(global112
							ignoreActors:
							illegalBits: 0
							setMotion: MoveTo 96 157 self
						)
					else
						(self cue:)
					)
				else
					(self changeState: 8)
				)
			)
			(6
				(global112
					ignoreActors:
					illegalBits: 0
					setMotion: MoveTo 96 136 self
				)
			)
			(7
				(global112 setPri: 10 setMotion: MoveTo 41 148 self)
			)
			(8
				(gEgo setPri: 12)
				((= local1 (Prop new:))
					view: 51
					loop: (if (== global131 13) 2 else 0)
					cel: 0
					posn: [local2 0] [local2 1]
					setPri: 11
					init:
					setCycle: End self
				)
				(if (== global131 13)
					(global112
						ignoreActors: 1
						illegalBits: 0
						setLoop: 1
						setStep: 1 2
						setMotion: MoveTo 42 153
					)
				)
			)
			(9
				(= gPerspective 0)
				(gCurRoom newRoom: global131)
			)
			(10
				(= global135 1)
				(unTrunk
					view: 51
					loop: 4
					cel: 0
					posn: [local4 0] [local4 1]
					setPri: 11
					init:
					setCycle: End self
				)
			)
			(11
				(unTrunk stopUpd:)
			)
			(12
				(= global135 0)
				(unTrunk
					view: 51
					loop: 4
					cel: 2
					posn: [local4 0] [local4 1]
					setPri: 11
					startUpd:
					setCycle: CT 0 -1 self
				)
			)
			(13
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
				(local0 stopUpd: addToPic:)
			)
		)
	)
)

