;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 225)
(include sci.sh)
(use Main)
(use Interface)
(use Avoid)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm225 0
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
	local12
	local13
	[local14 4]
	[local18 4]
	[local22 2]
	[local24 2]
)

(procedure (localproc_0)
	(switch global131
		(13
			(cond
				(
					(not
						(gEgo
							inRect:
								[local14 0]
								[local14 1]
								[local14 2]
								[local14 3]
						)
					)
					(Print 225 0) ; "You're not close enough to your car's door."
				)
				((== global133 1)
					(Print 225 1) ; "Your car door is locked"
					(return 0)
				)
				(global135
					(Print 225 2) ; "Close the trunk first."
					(return 0)
				)
				((gEgo has: 10) ; field_kit
					(Print 225 3) ; "You should put your field kit in the trunk first."
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
								[local14 0]
								[local14 1]
								[local14 2]
								[local14 3]
						)
					)
					(Print 225 0) ; "You're not close enough to your car's door."
				)
				((== global136 1)
					(Print 225 1) ; "Your car door is locked"
				)
				(else
					(carScript changeState: 4)
				)
			)
		)
	)
)

(instance rm225 of Rm
	(properties
		picture 25
		style 0
	)

	(method (dispose)
		(carScript dispose:)
		(super dispose:)
	)

	(method (init)
		(super init:)
		(HandsOff)
		(= local2 (or (== gPrevRoomNum 33) (== gPrevRoomNum 13)))
		(= [local24 0] 142)
		(= [local24 1] 193)
		(if local2
			(HandsOff)
			(= global135 0)
		else
			(HandsOn)
			(if global135
				((= local13 (Prop new:))
					view: 51
					loop: 5
					cel: 2
					posn: [local24 0] [local24 1]
					setPri: 15
					init:
				)
			)
		)
		(Load rsVIEW 0)
		(Load rsVIEW 20)
		(Load rsVIEW 54)
		(Load rsVIEW 51)
		(Load rsVIEW 251)
		(Load rsVIEW 50)
		(Load rsVIEW 999)
		(Load rsVIEW 123)
		(Load rsVIEW 112)
		(if (== global131 13)
			(= local11 180)
			(= local12 189)
			(= [local14 0] 160)
			(= [local14 1] 140)
			(= [local14 2] 180)
			(= [local14 3] 193)
			(= [local22 0] 198)
			(= [local22 1] 184)
			(= [local18 0] 106)
			(= [local18 1] 174)
			(= [local18 2] 140)
			(= [local18 3] 189)
			(= local6 161)
		else
			(= local11 192)
			(= local12 189)
			(= [local14 0] 160)
			(= [local14 1] 165)
			(= [local14 2] 185)
			(= [local14 3] 179)
			(= [local22 0] (- local11 1))
			(= [local22 1] (- local12 2))
			(= local6 175)
		)
		(= local9 0)
		(= local4 (- local11 30))
		(= local5 local11)
		(= local7 26)
		(= local10 0)
		(= local3 (and (== global130 gCurRoomNum) (!= gPrevRoomNum local7)))
		(self setScript: rm225Script)
	)
)

(instance rm225Script of Script
	(properties)

	(method (doit)
		(cond
			((== global132 local2 1)
				(if (not (gCast contains: local0))
					(= global132 0)
					(carScript changeState: 0)
				)
			)
			((== global132 (not local2) 1)
				(= global132 0)
				(localproc_0)
			)
		)
		(if
			(or
				(gEgo inRect: 152 77 176 109)
				(gEgo inRect: 159 109 184 140)
			)
			(gEgo setPri: 10 illegalBits: 8192)
			(if (== global131 13)
				(global112 stopUpd:)
			)
		else
			(if (< (gEgo y:) 83)
				(gEgo setPri: 7)
				(if (== global131 13)
					(global112 stopUpd:)
				)
			else
				(gEgo setPri: -1)
				(if (== global131 13)
					(global112 startUpd:)
				)
			)
			(gEgo xStep: 3 yStep: 2 illegalBits: -32768)
		)
		(if
			(and
				(<= (gEgo y:) 130)
				(or (< (gEgo x:) 0) (> (gEgo x:) 320))
			)
			(gEgo y: 132)
		)
		(if
			(and
				(== local2 0)
				(or
					(<= (gEgo x:) -30)
					(>= (gEgo x:) 380)
					(>= (gEgo y:) 230)
				)
			)
			(rm225Script changeState: 2)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((= local0 (Act new:))
					view: 54
					setLoop: 1
					setCel: (if (== global131 13) 1 else 5)
					setStep: 3 3
					setCycle: 0
					setMotion: 0
					posn:
						(if
							(and
								(or (== gPrevRoomNum 13) (== gPrevRoomNum 33))
								(not local3)
							)
							local4
						else
							local5
						)
						local12
					init:
					illegalBits: 0
				)
				((View new:)
					view: 251
					loop: 6
					cel: 0
					setPri: 3
					posn: 104 111
					init:
					addToPic:
					stopUpd:
				)
				((View new:)
					view: 251
					setLoop: 9
					setCel: 5
					setPri: 9
					posn: 261 156
					init:
					addToPic:
				)
				((View new:)
					view: 251
					setLoop: 2
					setCel: 0
					setPri: 7
					posn: 104 73
					init:
					addToPic:
				)
				((View new:)
					view: 251
					setLoop: 0
					setCel: 2
					setPri: 10
					posn: 167 139
					ignoreActors:
					init:
					addToPic:
				)
				((View new:)
					view: 251
					setLoop: 0
					setCel: 0
					setPri: 0
					posn: 67 8
					init:
					ignoreActors:
					addToPic:
				)
				(if (IsFlag 14)
					((View new:)
						view: 251
						setLoop: 9
						setCel: 0
						posn: 228 128
						setPri: 9
						init:
						ignoreActors:
						addToPic:
					)
				)
				((View new:)
					view: 251
					setLoop: 9
					setCel: 2
					posn: 270 164
					setPri: 12
					init:
					ignoreActors:
					addToPic:
				)
				((View new:)
					view: 251
					setLoop: 9
					setCel: 2
					posn: 205 166
					setPri: 11
					init:
					ignoreActors: 0
					addToPic:
				)
				((View new:)
					view: 251
					setLoop: 9
					setCel: 2
					posn: 189 137
					setPri: 9
					init:
					ignoreActors:
					addToPic:
				)
				((View new:)
					view: 251
					setLoop: 9
					setCel: 3
					posn: 238 159
					setPri: 12
					init:
					ignoreActors: 0
					addToPic:
				)
				((View new:)
					view: 251
					setLoop: 9
					setCel: 4
					posn: 196 149
					setPri: 10
					init:
					ignoreActors: 0
					addToPic:
				)
				((View new:)
					view: 50
					setLoop: 2
					setCel: 0
					posn: 227 155
					setPri: 10
					init:
					ignoreActors:
					addToPic:
				)
				(gEgo
					view: 0
					posn:
						(if (== gPrevRoomNum local7) 240 else 340)
						(if (== gPrevRoomNum local7) 190 else 300)
					init:
					setMotion: 0
				)
				(if (== global131 13)
					((= global112 (Act new:))
						view: 20
						posn: 190 195
						setCycle: Walk
						setAvoider: (Avoid new:)
						illegalBits: -32768
					)
				)
				(cond
					((!= global130 gCurRoomNum)
						(= global130 gCurRoomNum)
						(= global132 1)
					)
					((== local2 1)
						(= global132 1)
					)
				)
				(if (!= gPrevRoomNum local7)
					(local0 setMotion: MoveTo local5 local12 self)
				else
					(self cue:)
				)
			)
			(1
				(local0 addToPic: ignoreActors: 0 stopUpd:)
			)
			((and 2 (not local2))
				(Print 225 4) ; "You will need your car in order to leave the area."
				(cond
					((<= (gEgo x:) 0)
						(gEgo setMotion: MoveTo 10 (gEgo y:))
					)
					((>= (gEgo x:) 320)
						(gEgo setMotion: MoveTo 300 (gEgo y:))
					)
					((>= (gEgo y:) 230)
						(gEgo setMotion: MoveTo (gEgo x:) 200)
					)
				)
			)
			(3
				(switch (Random 0 2)
					(0
						(Print 225 5) ; "The motel manager is fuming when he says... "You dudes aren't gonna get away with this! You're gonna pay for that damage!!""
					)
					(1
						(Print 225 6) ; "I'm telling you!" says the manager, "This just hasn't been my year."
					)
					(2
						(Print 225 7) ; "You guys did a bang-up job of ruining my day!" the manager says. "Now how about getting lost?"
					)
				)
			)
		)
	)

	(method (handleEvent event)
		(switch (event type:)
			(evSAID
				(if (== (gEgo onControl: 1) 4096)
					(cond
						((or (Said '/hello') (Said 'talk[/man,manager]'))
							(rm225Script changeState: 3)
						)
						((Said 'show[/badge,badge]')
							(if (gEgo has: 7) ; wallet
								(Print 225 8 #icon 999 0 0) ; "Yes Officer," he says... "what can I do for you ?"
								(= global175 1)
							else
								(Print 225 9) ; "You don't have your wallet."
							)
						)
						((Said 'rent/chamber')
							(switch (Random 0 2)
								(0
									(Print 225 10) ; "GET SERIOUS, MAC!" says the manager... "After the mess you made, you guys ain't renting nothing!"
								)
								(1
									(Print 225 11) ; "Slightly upset, the manager says..."I only have four words for you jerks!...#$%* the b%& o&%!!!""
								)
								(2
									(Print 225 12) ; "The manager quickly says... "Why, so you can blow up another one?""
								)
							)
						)
						((Said 'show[/painting,mugshot]')
							(cond
								((gEgo has: 12) ; new_mug_shot
									(Print 225 13 #icon 112) ; "Well" the manager says, "the photograph is vaguely familiar...I believe his name was William Cole."
									(if (== global131 13)
										(Print 225 14) ; "Ah ha!" says Keith, "Bains is using the name Cole."
									)
								)
								((gEgo has: 23) ; old_mug_shot
									(Print 225 15 #icon 123) ; "Well" the manager says, "I don't remember seeing him."
								)
								(else
									(Print 225 16) ; "You don't have it."
								)
							)
						)
						((Said '[ask]/list')
							(Print 225 17) ; "The manager says, "Who are you looking for now?""
						)
						((Said '[ask]/bains')
							(Print 225 18) ; "Scanning his guest book, he shakes his head and says... "No, sorry. I don't have anyone listed by that name.""
						)
						((Said '[ask]/bill,cole,cole')
							(Print 225 19) ; "Scanning his guest book, he shakes his head and says... "Yes, here we are: William Cole, room #108.""
						)
						((Said '[ask,get]/key')
							(Print 225 20) ; "You must rent a room to get a key to the room, sir."
						)
						((Said 'arrest/man')
							(Print 225 21) ; "You could, but what has he done?"
						)
					)
				)
				(cond
					((Said 'look>')
						(cond
							((Said '[<at,around][/!*,building,chamber]')
								(Print 225 22) ; "Snuggler's Inn."
							)
							((Said '/pane')
								(cond
									((== (gEgo onControl: 1) 16384)
										(Print 225 23) ; "Someone's going to call the cops if you keep looking into the windows like that."
									)
									((== (gEgo onControl: 1) 4096)
										(Print 225 24) ; "You see a man inside."
									)
									(else
										(Print 225 25) ; "You are not close enough to the window."
									)
								)
							)
							((Said '/door')
								(cond
									(
										(or
											(== (gEgo onControl: 1) 1024)
											(== (gEgo onControl: 1) 512)
											(== (gEgo onControl: 1) 2048)
										)
										(Print 225 26) ; "There's nothing special about this door."
									)
									((== (gEgo onControl: 1) 256)
										(Print 225 27) ; "This is room #108."
									)
									(
										(gEgo
											inRect:
												[local14 0]
												[local14 1]
												[local14 2]
												[local14 3]
										)
										(Print 225 26) ; "There's nothing special about this door."
									)
									(else
										(Print 225 28) ; "You aren't close enough to the door."
									)
								)
							)
							((Said '/briefcase')
								(if (gEgo has: 10) ; field_kit
									(Print 225 29) ; "You don't need to look at it now. What are you doing with it, anyway!"
								else
									(Print 225 16) ; "You don't have it."
								)
							)
							((Said '/trunk')
								(if (== global131 13)
									(if
										(and
											(gEgo
												inRect:
													[local18 0]
													[local18 1]
													[local18 2]
													[local18 3]
											)
											(gCast contains: local13)
										)
										(gInventory
											carrying:
												{The car's trunk contains:}
											empty: {The car's trunk is empty.}
											showSelf: 13
										)
									else
										(Print 225 30) ; "You're not close enough to an open trunk."
									)
								else
									(Print 225 31) ; "Your car's "hatch-back" hasn't worked since its warranty expired."
								)
							)
						)
					)
					((or (Said 'break/door') (Said 'hit/door'))
						(if
							(or
								(== (gEgo onControl: 1) 1024)
								(== (gEgo onControl: 1) 512)
								(== (gEgo onControl: 1) 2048)
							)
							(Print 225 32) ; "Being a macho type, you kick in the door, making a fool out of yourself."
						else
							(Print 225 28) ; "You aren't close enough to the door."
						)
					)
					((or (Said '/hello') (Said 'talk[/man,cop]'))
						(if (gEgo inRect: 180 148 288 171)
							(Print 225 33) ; "Sonny says... " How are you doing ? ""
							(if (== global131 13)
								(Print 225 34) ; "The officer says... "Hi, guys. Sorry, you can't go inside now.""
							else
								(Print 225 35) ; "The officer says... "Hi, Sonny. Sorry, you can't go inside now.""
							)
						else
							(Print 225 36) ; "You aren't close enough to talk."
						)
					)
					((or (Said 'use/key') (Said 'open/door'))
						(cond
							(
								(or
									(== (gEgo onControl: 1) 1024)
									(== (gEgo onControl: 1) 2048)
									(== (gEgo onControl: 1) 256)
									(== (gEgo onControl: 1) 512)
								)
								(Print 225 37) ; "You can't do that. You don't have a key to this room"
							)
							(
								(gEgo
									inRect:
										[local14 0]
										[local14 1]
										[local14 2]
										[local14 3]
								)
								(localproc_0)
							)
							((gEgo inRect: 180 187 200 197)
								(Print 225 38) ; "You don't need to open this door."
							)
							(else
								(Print 225 28) ; "You aren't close enough to the door."
							)
						)
					)
					((or (Said 'get/out') (Said 'exit/chamber'))
						(if (== local10 1)
							(rm225Script changeState: 6)
							(= local10 0)
						else
							(Print 225 39) ; "What do you mean "get out"? You aren't in a motel room."
						)
					)
					((Said 'enter/auto')
						(localproc_0)
					)
					((Said 'exit/auto')
						(= global132 1)
					)
					((Said 'unlock/door')
						(if
							(or
								(gEgo
									inRect:
										[local14 0]
										[local14 1]
										[local14 2]
										[local14 3]
								)
								(gEgo inRect: 180 187 200 197)
							)
							(cond
								((and (== global131 13) (gEgo has: 3)) ; unmarked_car_keys
									(if (== global133 1)
										(= global133 0)
										(Print 225 40) ; "OK. It's unlocked."
									else
										(Print 225 41) ; "The door is already unlocked."
									)
								)
								((== global131 13)
									(Print 225 42) ; "You need a key to unlock this door."
								)
							)
							(cond
								((and (== global131 33) (gEgo has: 2)) ; key_ring
									(if (== global136 1)
										(= global136 0)
										(Print 225 40) ; "OK. It's unlocked."
									else
										(Print 225 41) ; "The door is already unlocked."
									)
								)
								((== global131 33)
									(Print 225 42) ; "You need a key to unlock this door."
								)
							)
						else
							(Print 225 43) ; "You're not close enough."
						)
					)
					((Said 'lock/door')
						(if
							(or
								(gEgo
									inRect:
										[local14 0]
										[local14 1]
										[local14 2]
										[local14 3]
								)
								(gEgo inRect: 180 187 200 197)
							)
							(if (== global131 13)
								(if (== global133 0)
									(= global133 1)
									(Print 225 44) ; "OK. It's locked."
								else
									(Print 225 45) ; "The door is already locked."
								)
							)
							(if (== global131 33)
								(if (== global136 0)
									(= global136 1)
									(Print 225 44) ; "OK. It's locked."
								else
									(Print 225 45) ; "The door is already locked."
								)
							)
						else
							(Print 225 43) ; "You're not close enough."
						)
					)
					((or (Said 'knock') (Said 'knock/door'))
						(if
							(or
								(== (gEgo onControl: 1) 1024)
								(== (gEgo onControl: 1) 512)
								(== (gEgo onControl: 1) 2048)
								(== (gEgo onControl: 1) 256)
							)
							(Print 225 46) ; "You knock, but no one responds."
						else
							(Print 225 47) ; "You aren't close enough."
						)
					)
					((Said 'open/police')
						(if
							(or
								(== (gEgo onControl: 1) 1024)
								(== (gEgo onControl: 1) 512)
								(== (gEgo onControl: 1) 256)
								(== (gEgo onControl: 1) 2048)
							)
							(Print 225 48) ; "In a commanding voice you yell, "Open up in the name of the police!""
							(Print 225 49) ; "You listen carefully but are unable to hear anything."
						else
							(Print 225 28) ; "You aren't close enough to the door."
						)
					)
					((Said 'show[/badge,badge]')
						(if (gEgo inRect: 180 148 288 171)
							(if (gEgo has: 7) ; wallet
								(Print 225 50 #icon 999 0 0) ; "Yes, what can I do for you ?"
							else
								(Print 225 51) ; "You don't have your identification."
							)
						else
							(Print 225 52) ; "You aren't close enough to anybody to show your identification."
						)
					)
					((Said 'open,unlock/trunk')
						(if (== global131 13)
							(if
								(gEgo
									inRect:
										[local18 0]
										[local18 1]
										[local18 2]
										[local18 3]
								)
								(cond
									(global135
										(Print 225 53) ; "It's already open."
									)
									((gEgo has: 3) ; unmarked_car_keys
										(carScript changeState: 9)
									)
									(else
										(Print 225 54) ; "You need a key to open this trunk."
									)
								)
							else
								(proc0_7) ; "You're not close enough."
							)
						else
							(Print 225 31) ; "Your car's "hatch-back" hasn't worked since its warranty expired."
						)
					)
					((Said 'close,lock/trunk')
						(if (== global131 13)
							(if
								(gEgo
									inRect:
										[local18 0]
										[local18 1]
										[local18 2]
										[local18 3]
								)
								(if global135
									(carScript changeState: 11)
								else
									(Print 225 55) ; "It's already closed."
								)
							else
								(proc0_7) ; "You're not close enough."
							)
						else
							(Print 225 31) ; "Your car's "hatch-back" hasn't worked since its warranty expired."
						)
					)
					((Said 'drop,place/briefcase')
						(if
							(gEgo
								inRect:
									[local18 0]
									[local18 1]
									[local18 2]
									[local18 3]
							)
							(if global135
								(if (gEgo has: 10) ; field_kit
									(Print 225 56) ; "You place your field kit inside the trunk."
									(PutItem 10 13) ; field_kit
								else
									(Print 225 57) ; "You don't have the field kit."
								)
							else
								(Print 225 58) ; "Open the trunk first."
							)
						else
							(Print 225 59) ; "You're not close enough to your car's trunk."
						)
					)
					((Said 'remove,get/briefcase')
						(if
							(gEgo
								inRect:
									[local18 0]
									[local18 1]
									[local18 2]
									[local18 3]
							)
							(if global135
								(if (IsItemAt 10 13) ; field_kit
									(Print 225 60) ; "You take your field kit from the trunk."
									(gEgo get: 10) ; field_kit
								else
									(Print 225 61) ; "The field kit is not in the trunk."
								)
							else
								(Print 225 58) ; "Open the trunk first."
							)
						else
							(Print 225 59) ; "You're not close enough to your car's trunk."
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
				(gEgo
					posn: local6 178
					loop: 0
					cel: 0
					setCycle: Walk
					setPri: 13
					startUpd:
				)
				(if (== global131 13)
					((= local1 (Prop new:))
						view: 51
						loop: 3
						cel: 0
						posn: [local22 0] [local22 1]
						setPri: 15
						init:
						setCycle: End
					)
				)
				(self cue:)
			)
			(1
				(= local2 0)
				(if (== global131 13)
					(= global133 0)
				else
					(= global136 0)
				)
				(if (== global131 13)
					(local1 dispose:)
					(global112
						posn: 200 196
						setStep: 1 2
						setLoop: 0
						setCel: 0
						setPri: 15
						ignoreActors: 1
						illegalBits: 0
						init:
					)
					(self cue:)
				)
				(HandsOn)
			)
			(2
				(if (== global131 13)
					(global112
						setStep: 3 2
						setCycle: Walk
						setLoop: -1
						setPri: -1
						ignoreActors: 0
						illegalBits: -32768
						setMotion: MoveTo 180 197 self
					)
				)
			)
			(3
				(global112 setMotion: Follow gEgo 500)
				(Print 225 62 #draw) ; "What're we doing here, Sonny?"
			)
			(4
				(HandsOff)
				(if (== global131 13)
					(Print 225 63) ; "Keith yells: "Geez, Sonny! Hold on a second, will ya?""
					(cond
						((> (global112 y:) 189)
							(global112
								ignoreActors:
								illegalBits: -32768
								setMotion: MoveTo 185 (global112 y:) self
							)
						)
						((< (global112 x:) 110)
							(global112
								ignoreActors:
								illegalBits: -32768
								setMotion: MoveTo 110 (global112 y:) self
							)
						)
						(else
							(global112
								ignoreActors:
								illegalBits: -32768
								setMotion: MoveTo 105 (global112 y:) self
							)
						)
					)
				else
					(self changeState: 7)
				)
			)
			(5
				(cond
					((== (global112 x:) 110)
						(global112
							ignoreActors:
							illegalBits: -32768
							setMotion: MoveTo 110 195 self
						)
					)
					((== (global112 x:) 105)
						(global112
							ignoreActors:
							illegalBits: -32768
							setMotion: MoveTo 105 195 self
						)
					)
					(else
						(self cue:)
					)
				)
			)
			(6
				(global112 setMotion: MoveTo 190 195 self)
			)
			(7
				(gEgo setPri: 12)
				(if (== global131 13)
					((= local1 (Prop new:))
						view: 51
						loop: (if (== global131 13) 3 else 0)
						cel: 0
						posn: [local22 0] [local22 1]
						setPri: 15
						init:
						setCycle: End
					)
					(global112
						ignoreActors: 1
						illegalBits: 0
						setLoop: 0
						setStep: 1 2
						setPri: 15
						setMotion: MoveTo 190 195
					)
				)
				(self cue:)
			)
			(8
				(= gNewRoomNum global131)
			)
			(9
				((= local13 (Prop new:))
					view: 51
					loop: 5
					cel: 0
					posn: [local24 0] [local24 1]
					setPri: 15
					init:
					setCycle: End self
				)
			)
			(10
				(= global135 1)
				(local13 stopUpd:)
			)
			(11
				(local13 startUpd: setCycle: Beg self)
			)
			(12
				(= global135 0)
				(local13 dispose:)
			)
		)
	)
)

(instance stopScript of Script ; UNUSED
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
				(local0 ignoreActors: 0 stopUpd: addToPic:)
			)
		)
	)
)

