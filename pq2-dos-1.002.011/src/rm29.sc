;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 29)
(include sci.sh)
(use Main)
(use Interface)
(use AutoDoor)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm29 0
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
	[local10 4]
	local14
	local15
	local16
	local17
	local18
	local19
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
					(localproc_0 29 44) ; "You're not close enough to your car's door."
				)
				(global133
					(localproc_0 29 45) ; "Your car door is locked"
					(return 0)
				)
				(global135
					(localproc_0 29 46) ; "Close the trunk first."
					(return 0)
				)
				((gEgo has: 10) ; field_kit
					(localproc_0 29 47) ; "You should put your field kit in the trunk first."
					(return 0)
				)
				(else
					(carScript changeState: 4)
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
					(localproc_0 29 44) ; "You're not close enough to your car's door."
				)
				(global136
					(localproc_0 29 45) ; "Your car door is locked"
				)
				(else
					(carScript changeState: 4)
				)
			)
		)
	)
)

(instance unTrunk of Prop
	(properties)
)

(instance rm29 of Rm
	(properties
		picture 29
		style 1
	)

	(method (dispose)
		(carScript dispose:)
		(stopScript dispose:)
		(DisposeScript 301)
		(super dispose:)
	)

	(method (init)
		(super init:)
		(NormalEgo)
		(if (!= global138 1)
			(= local16 1)
		)
		(= local6 (or (== gPrevRoomNum 33) (== gPrevRoomNum 13)))
		(Load rsVIEW 0)
		(Load rsVIEW 20)
		(Load rsVIEW 54)
		(Load rsVIEW 51)
		(Load rsVIEW 265)
		(Load rsVIEW 75)
		(if local6
			(HandsOff)
		else
			(HandsOn)
		)
		(if (== global131 13)
			(= [local10 0] 32)
			(= [local10 1] 182)
			(= [local10 2] 44)
			(= [local10 3] 192)
			(= [local2 0] 27)
			(= [local2 1] 179)
			(= local14 42)
		else
			(= [local10 0] 44)
			(= [local10 1] 186)
			(= [local10 2] 61)
			(= [local10 3] 193)
			(= [local2 0] 43)
			(= [local2 1] 183)
			(= local14 55)
		)
		(= local8 100)
		(= local9 44)
		(= local15 30)
		((View new:) view: 265 loop: 1 cel: 0 posn: 187 40 init: addToPic:)
		((View new:)
			view: 265
			loop: 1
			cel: (if local16 4 else 1)
			posn: 225 86
			init:
			addToPic:
		)
		((View new:) view: 265 loop: 1 cel: 2 posn: 157 86 init: addToPic:)
		((View new:) view: 265 loop: 1 cel: 3 posn: 157 75 init: addToPic:)
		(if (not local16)
			((View new:) view: 54 loop: 0 cel: 2 posn: 76 165 init: addToPic:)
			((View new:) view: 75 loop: 2 cel: 1 posn: 299 165 init: addToPic:)
			((View new:) view: 75 loop: 2 cel: 2 posn: 313 187 init: addToPic:)
		)
		((View new:) view: 265 posn: 28 128 loop: 2 cel: 0 init: addToPic:)
		((Prop new:)
			view: 265
			loop: 3
			posn: 28 103
			init:
			setCycle: Fwd
			cycleSpeed: 1
			startUpd:
		)
		((= local17 (AutoDoor new:))
			entranceTo: 30
			facingLoop: 3
			view: 265
			posn: 186 105
			setPri: 6
			init:
			stopUpd:
		)
		(= local7 (== global130 gCurRoomNum))
		(if (!= gPrevRoomNum local15)
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
			posn: (if (not local7) local8 else local9) 185
			init:
			illegalBits: 0
		)
		(self setLocales: 153)
		(self setScript: rm29Script)
	)
)

(instance rm29Script of Script
	(properties)

	(method (doit)
		(if (or (< (gEgo x:) -5) (> (gEgo x:) 325) (> (gEgo y:) 210))
			(localproc_0 29 0) ; "You see nothing of interest near the restaurant."
			(if (not local16)
				(localproc_0 29 1) ; "You are, however, mighty hungry, and you want to see your girlfriend."
			)
			(if (> (gEgo y:) 210)
				(gEgo setMotion: MoveTo (gEgo x:) 150)
			else
				(gEgo setMotion: MoveTo 150 (gEgo y:))
			)
		)
		(cond
			((and (gEgo inRect: 34 122 56 139) (not local19))
				(localproc_0 29 2) ; "You don't need to enter the construction area."
				(= local19 1)
			)
			((not (gEgo inRect: 34 122 56 139))
				(= local19 0)
			)
		)
		(if local16
			(local17 locked: 1)
		else
			(local17 locked: 0)
		)
		(cond
			((== (local17 doorState:) 2)
				(gCurRoom newRoom: local15)
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
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo view: 0 posn: 0 0 init: setMotion: 0)
				(if (== global131 13)
					((= global112 (Act new:)) view: 20 init:)
				)
				(= [local4 0] 82)
				(= [local4 1] 190)
				(stopScript init:)
				(= global135 0)
				(local0 setMotion: MoveTo local9 185 stopScript)
				(if (!= global130 gCurRoomNum)
					(= global130 gCurRoomNum)
				)
			)
		)
	)

	(method (handleEvent event)
		(switch (event type:)
			(evSAID
				(cond
					((Said 'look>')
						(cond
							((Said '/trunk')
								(if (== global131 13)
									(if
										(and
											(gEgo inRect: 79 174 116 187)
											(gCast contains: unTrunk)
										)
										(gInventory
											carrying:
												{The car's trunk contains:}
											empty: {The car's trunk is empty.}
											showSelf: 13
										)
									else
										(localproc_0 29 3) ; "You're not close enough to an open trunk."
									)
								else
									(localproc_0 29 4) ; "Your car's "hatch-back" hasn't worked since its warranty expired."
								)
							)
							((Said '/building,cafe,arnie')
								(localproc_0 29 5) ; "It's the best restaurant in the county, even though it's not the fanciest or the most expensive."
								(if local16
									(localproc_0 29 6) ; "It looks like it's closed, for some reason."
								)
							)
							((Said '[<around,at][/lot]')
								(localproc_0 29 7) ; "You're parked near the entrance of "Arnie's" restaurant."
								(if local16
									(localproc_0 29 6) ; "It looks like it's closed, for some reason."
								)
							)
							((Said '/chamber')
								(localproc_0 29 8) ; "You're outdoors. You're not in a room."
							)
							((Said '/sign')
								(if (gEgo inRect: 160 105 215 128)
									(localproc_0 29 9) ; "Visa. Mastercard."
									(if local16
										(localproc_0 29 10) ; "Closed."
									else
										(localproc_0 29 11) ; "Open."
									)
								else
									(localproc_0 29 12) ; "The restaurant is called "Arnie's"."
								)
							)
							((Said '[<at,down][/ave]')
								(localproc_0 29 13) ; "Hot asphalt."
							)
							((Said '[<at,up][/air]')
								(localproc_0 29 14) ; "It's a blue sky."
							)
							((Said '/auto')
								(if local16
									(if (== global131 13)
										(localproc_0 29 15) ; "It's your unmarked blue sedan, all alone in the lot."
									else
										(localproc_0 29 16) ; "It's your car, of course, all alone in the lot."
									)
								else
									(localproc_0 29 17) ; "Yep. There are other cars in the lot...all street-legal."
								)
							)
							((Said '/tree,bush')
								(localproc_0 29 18) ; "Green and bushy."
							)
							((Said '/door')
								(if local16
									(localproc_0 29 19) ; "You can't enter the restaurant because the door's locked."
								else
									(localproc_0 29 20) ; "You can enter the restaurant through the door."
								)
							)
							((Said '/construction')
								(localproc_0 29 21) ; "Someone's ALWAYS tearing up the pavement and leaving hazardous holes."
							)
							((Said '/pane')
								(localproc_0 29 22) ; "You look, but can't see anything through the drawn mini blinds."
							)
						)
					)
					((Said 'drive')
						(if local6
							(localproc_0 29 23) ; "Go on! Get out and look around first."
						else
							(localproc_0 29 24) ; "Get in your car first."
						)
					)
					((Said 'read/sign')
						(if (gEgo inRect: 160 105 215 128)
							(localproc_0 29 9) ; "Visa. Mastercard."
							(if local16
								(localproc_0 29 10) ; "Closed."
							else
								(localproc_0 29 11) ; "Open."
							)
						else
							(localproc_0 29 12) ; "The restaurant is called "Arnie's"."
						)
					)
					((Said 'drop,place/briefcase')
						(if (gEgo inRect: 79 174 116 187)
							(if global135
								(if (gEgo has: 10) ; field_kit
									(localproc_0 29 25) ; "You place your field kit inside the trunk."
									(PutItem 10 13) ; field_kit
									(if (IsObject gFKit)
										(gFKit dispose:)
									)
									(= global240 0)
								else
									(localproc_0 29 26) ; "You don't have the field kit."
								)
							else
								(localproc_0 29 27) ; "Open the trunk first."
							)
						else
							(localproc_0 29 28) ; "You're not close enough to your car's trunk."
						)
					)
					((Said 'remove,get/briefcase')
						(if (gEgo inRect: 79 174 116 187)
							(if global135
								(if (IsItemAt 10 13) ; field_kit
									(localproc_0 29 29) ; "You take your field kit from the trunk."
									(gEgo get: 10) ; field_kit
								else
									(localproc_0 29 30) ; "The field kit is not in the trunk."
								)
							else
								(localproc_0 29 27) ; "Open the trunk first."
							)
						else
							(localproc_0 29 28) ; "You're not close enough to your car's trunk."
						)
					)
					((Said 'enter/auto')
						(localproc_1)
					)
					((or (Said 'open/door') (Said 'get<in'))
						(cond
							(local6
								(= global132 1)
							)
							((not (gEgo inRect: 160 105 215 128))
								(localproc_1)
							)
							(local16
								(localproc_0 29 31) ; "Can't you read? The restaurant's closed!"
							)
							(else
								(localproc_0 29 32) ; "Just walk on in!"
							)
						)
					)
					((Said 'exit,get<out/auto')
						(= global132 1)
					)
					((Said 'unlock/door,auto')
						(if
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
										(localproc_0 29 33) ; "OK. It's unlocked."
									else
										(localproc_0 29 34) ; "The door is already unlocked."
									)
								)
								((== global131 13)
									(localproc_0 29 35) ; "You need a key to unlock this door."
								)
							)
							(cond
								((and (== global131 33) (gEgo has: 2)) ; key_ring
									(if global136
										(= global136 0)
										(localproc_0 29 33) ; "OK. It's unlocked."
									else
										(localproc_0 29 34) ; "The door is already unlocked."
									)
								)
								((== global131 33)
									(localproc_0 29 35) ; "You need a key to unlock this door."
								)
							)
						else
							(localproc_0 29 36) ; "You're not close enough."
						)
					)
					((Said 'lock/door,auto')
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
									(localproc_0 29 37) ; "OK. It's locked."
								else
									(localproc_0 29 38) ; "The door is already locked."
								)
							)
							(if (== global131 33)
								(if (not global136)
									(= global136 1)
									(localproc_0 29 37) ; "OK. It's locked."
								else
									(localproc_0 29 38) ; "The door is already locked."
								)
							)
						else
							(localproc_0 29 36) ; "You're not close enough."
						)
					)
					((Said 'open,unlock/trunk')
						(if (== global131 13)
							(if (gEgo inRect: 79 174 116 187)
								(cond
									(global135
										(Print 29 39) ; "It's already open."
									)
									((gEgo has: 3) ; unmarked_car_keys
										(carScript changeState: 7)
									)
									(else
										(localproc_0 29 40) ; "You need a key to open this trunk."
									)
								)
							else
								(proc0_7) ; "You're not close enough."
							)
						else
							(localproc_0 29 4) ; "Your car's "hatch-back" hasn't worked since its warranty expired."
						)
					)
					((Said 'close,lock/trunk')
						(if (== global131 13)
							(if (gEgo inRect: 79 174 116 187)
								(if global135
									(carScript changeState: 9)
									(= global135 0)
								else
									(Print 29 41) ; "It's already closed."
								)
							else
								(proc0_7) ; "You're not close enough."
							)
						else
							(localproc_0 29 4) ; "Your car's "hatch-back" hasn't worked since its warranty expired."
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
					posn: local14 186
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
					setPri: 14
					init:
					setCycle: End self
				)
				(if (== global131 13)
					(global112
						posn: 51 184
						setStep: 1 2
						setLoop: 1
						setCel: 0
						setPri: 13
						ignoreActors: 1
						illegalBits: 0
						startUpd:
						setMotion: MoveTo 55 174
					)
					(= global133 0)
				else
					(= global136 0)
				)
			)
			(1
				(= local6 0)
				(local1 dispose:)
				(self cue:)
			)
			(2
				(HandsOn)
				(if (== global131 13)
					(if local16
						(localproc_0 29 42 83) ; "Gee, Sonny," says Keith. "I guess the restaurant's closed."
					else
						(localproc_0 29 43 83) ; "Go on and eat," says Keith. "Sleep sounds better than food, so I think I'll catch a quick snooze. Don't tell the Captain!"
					)
					(global112 setMotion: MoveTo 52 184 self)
				)
			)
			(3
				(global112 posn: 340 340 ignoreActors: 0)
			)
			(4
				(HandsOff)
				(gEgo stopUpd:)
				(self cue:)
			)
			(5
				(gEgo setPri: 15)
				((= local1 (Prop new:))
					view: 51
					loop: (if (== global131 13) 2 else 0)
					cel: 0
					posn: [local2 0] [local2 1]
					setPri: 14
					init:
					setCycle: End self
				)
			)
			(6
				(gCurRoom newRoom: global131)
			)
			(7
				(= global135 1)
				(unTrunk
					view: 51
					loop: 4
					cel: 0
					posn: [local4 0] [local4 1]
					setPri: 14
					init:
					setCycle: End self
				)
			)
			(8
				(unTrunk stopUpd:)
			)
			(9
				(= global135 0)
				(unTrunk
					view: 51
					loop: 4
					cel: 2
					posn: [local4 0] [local4 1]
					setPri: 14
					startUpd:
					setCycle: CT 0 -1 self
				)
			)
			(10
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

