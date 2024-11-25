;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 27)
(include sci.sh)
(use Main)
(use Interface)
(use Avoid)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm27 0
)

(synonyms
	(cop police)
	(body roberts)
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
)

(procedure (localproc_0)
	(if (gEgo has: 10) ; field_kit
		(return 1)
	else
		(Print 27 0) ; "You have to have your field kit to do that."
		(return 0)
	)
)

(procedure (localproc_1)
	(if (and (gEgo inRect: 226 148 236 154) (== local9 1))
		(Print 27 22) ; "Keith is working inside the car. Don't bother him, it's refreshing to see him work."
	else
		(switch global131
			(13
				(cond
					((not (gEgo inRect: 268 152 290 161))
						(Print 27 103) ; "You're not close enough to your car's door."
					)
					((== global133 1)
						(Print 27 104) ; "Your car door is locked"
						(return 0)
					)
					(global135
						(Print 27 105) ; "Close the trunk first."
						(return 0)
					)
					((gEgo has: 10) ; field_kit
						(Print 27 106) ; "You should put your field kit in the trunk first."
						(return 0)
					)
					(else
						(carScript changeState: 8)
						(return 1)
					)
				)
			)
			(33
				(cond
					((not (gEgo inRect: 268 152 290 161))
						(Print 27 103) ; "You're not close enough to your car's door."
					)
					((== global136 1)
						(Print 27 104) ; "Your car door is locked"
					)
					(else
						(carScript changeState: 8)
					)
				)
			)
		)
	)
)

(instance qDoor of Prop
	(properties)
)

(instance unTrunk of Prop
	(properties)
)

(instance quincyCarBlock of Blk
	(properties
		top 154
		left 172
		bottom 188
		right 201
	)
)

(instance ourCarBlock of Blk
	(properties
		top 158
		left 233
		bottom 171
		right 321
	)
)

(instance bwCarBlock of Blk
	(properties
		top 137
		left 36
		bottom 147
		right 150
	)
)

(instance rm27 of Rm
	(properties
		picture 27
		style 8
	)

	(method (dispose)
		(carScript dispose:)
		(stopScript dispose:)
		(mrGScript dispose:)
		(quincyScript dispose:)
		(egoScript dispose:)
		(super dispose:)
	)

	(method (doit)
		(super doit:)
		(quincyScript doit:)
		(if (> local13 0)
			(-- local13)
		)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if (event claimed:)
			(return)
		)
		(switch (event type:)
			(evSAID
				(if (== local9 1)
					(if (gEgo inRect: 169 133 200 151)
						(cond
							((Said 'drink/blood')
								(Print 27 1) ; "Hooo BOY! Where are you from, Transylvania?"
							)
							(
								(or
									(Said 'get,remove,pick/sample,blood')
									(Said 'use/dropper,vial')
									(Said 'drop/blood/vial')
								)
								(if (localproc_0)
									(if (IsFlag 143)
										(Print 27 2) ; "You have already collected a sample of this blood."
									else
										(global119 startUpd: setPri: 0)
										(global118 startUpd: setPri: 0)
										(SetScore 1)
										(Print 27 3 #draw) ; "You use an eyedropper to draw up some of the victim's blood."
										(gEgo get: 28) ; vial_of_blood
										(SetFlag 143)
										(global119 setPri: 13 stopUpd:)
										(Print 27 4 #draw) ; "You return the eye dropper to the kit, and add the vial of blood to your inventory of evidence."
									)
								)
							)
							(
								(or
									(Said 'make,get/print<feet')
									(Said 'use<(cast,plaster)')
									(Said
										'make/plaster,cast,footprint,footprint'
									)
									(Said 'get,cast/print,footprint')
								)
								(if (localproc_0)
									(Print 27 5) ; "You see no footprints worth casting."
								)
							)
							((or (Said 'use/camera') (Said 'get/painting'))
								(if (localproc_0)
									(global124 forceUpd: setPri: 0)
									(SetScore 1 116)
									(Print 27 6 #draw) ; "You take pictures of the murder scene, and return the camera to the kit."
									(global124 setPri: 14)
								)
							)
							(
								(and
									(or
										(Said 'use,get,remove/baggie')
										(Said 'get/hair,dirt')
									)
									(localproc_0)
								)
								(Print 27 7) ; "Looking around carefully, you decide there's nothing worth using your last plastic baggy on."
							)
						)
					)
					(cond
						((Said 'talk>')
							(cond
								((Said '/friend')
									(if (== local9 1)
										(Print 27 8) ; ""I haven't found any clues, Sonny," Keith says."
									else
										(event claimed: 0)
									)
								)
								((Said '/gelepsi,cop,cop,man')
									(if (== local9 1)
										(if (Random 0 1)
											(Print 27 9) ; "Mario frowns. "Two'a murders in'a two days'a. I don'a like it, Sonny.""
										else
											(Print 27 10) ; ""How'a you doin'a, Sonny? I sure hope you find'a the clues." Mario offers."
										)
									else
										(event claimed: 0)
									)
								)
								((Said '/coroner,man')
									(cond
										(local10
											(Print 27 11) ; "You ask the coroner to send you a report as soon as it is available."
										)
										((> 3 global182 1)
											(if (IsFlag 9)
												(Print 27 12) ; "I'll send you a report, Sonny!"
											else
												(Print 27 13) ; "The coroner says, "I'll remove the body as soon as you're finished with it, Bonds.""
											)
										)
										(else
											(event claimed: 0)
										)
									)
								)
								((Said '/man')
									(Print 27 14) ; "Who are you talking to?"
								)
							)
						)
						((Said 'read,look/note,threat,letter')
							(if (gEgo has: 6) ; death_threat
								((gInventory at: 6) showSelf:) ; death_threat
							else
								(proc0_9) ; "You don't have it."
							)
						)
						((Said 'look,frisk>')
							(cond
								((Said '/man')
									(Print 27 15) ; "Which man are you looking for?"
								)
								((Said '/woman')
									(Print 27 16) ; "The only lady around here is the bag lady across the street."
								)
								((Said '/coroner')
									(if (> 3 global182 1)
										(Print 27 17) ; "The coroner's name is Felix (Pee Wee) Herman. He's known for his twisted sense of humor."
									else
										(Print 27 18) ; "The coroner isn't here."
									)
								)
								((Said '/gelepsi,cop')
									(if (== local9 1)
										(Print 27 19) ; "Officer Mario Gelepsi is a large man with a wide, friendly smile, but his smile is missing today."
									else
										(Print 27 20) ; "Officer Gelepsi is not here."
									)
								)
								((or (Said '<below/auto') (Said 'blood'))
									(Print 27 21) ; "There is a pool of blood beneath the trunk of the green car."
								)
								((Said 'frisk,(look<in)/auto')
									(if
										(and
											(== global131 13)
											(< (global112 y:) 160)
										)
										(Print 27 22) ; "Keith is working inside the car. Don't bother him, it's refreshing to see him work."
									else
										(Print 27 23) ; "Keith has already searched the car completely, and found nothing of interest."
									)
								)
								((Said '/auto<coroner,white')
									(if (> 3 global182 0)
										(Print 27 24) ; "There's nothing special about the coroner's car."
									else
										(Print 27 25) ; "The coroner's car isn't here."
									)
								)
								((Said '/auto<cop,marked')
									(Print 27 26) ; "It's just your standard police cruiser."
								)
								((Said '/auto<blue,unmarked')
									(Print 27 27) ; "It's just an old, repainted, police cruiser."
								)
								((Said '/auto')
									(if (== local9 1)
										(Print 27 28) ; "The victim's car offers no obvious clues. You suspect that the murder was committed elsewhere."
									else
										(Print 27 29) ; "You see nothing special about the car."
									)
									(event claimed: 1)
								)
								((or (Said '/trunk,license') (Said '<in'))
									(if (gEgo inRect: 170 133 196 149)
										(gCurRoom newRoom: 28)
									else
										(event claimed: 0)
									)
								)
								((Said '/body')
									(cond
										((IsFlag 9)
											(Print 27 30) ; "The body is no longer in the trunk."
										)
										((gEgo inRect: 170 133 196 149)
											(gCurRoom newRoom: 28)
										)
										(else
											(event claimed: 0)
										)
									)
								)
								(else
									(event claimed: 0)
								)
							)
						)
					)
				)
				(cond
					((or (Said 'yes') (Said 'show'))
						(if (> local13 0)
							(= local13 0)
							(Print 27 31) ; "That'sa great!" Mario beams. "I hope it helps catcha the murderer."
						else
							(event claimed: 0)
						)
					)
					((Said 'no')
						(if (> local13 0)
							(= local13 0)
							(Print 27 32) ; "That'sa too bad," says Mario. "I hope you catcha the murderer somehow!"
						else
							(Print 27 33) ; "A more positive attitude would help."
						)
					)
					((Said 'look/trunk')
						(if
							(and
								(== global131 13)
								(gEgo inRect: 207 156 258 178)
								(gCast contains: unTrunk)
							)
							(gInventory
								carrying: {The car's trunk contains:}
								empty: {The car's trunk is empty.}
								showSelf: 13
							)
						else
							(Print 27 34) ; "You're not close enough to an open trunk."
						)
					)
					((Said 'look/building,warehouse')
						(Print 27 35) ; "The buildings are old, rusted, metal warehouses."
					)
					((Said 'look/fence')
						(Print 27 36) ; "The chain link fence encloses "Vu's Warehouse.""
					)
					((Said 'look/hole,gap,rip')
						(Print 27 37) ; "The hole was created when Vu backed his car into it."
					)
					((Said 'look/blood')
						(if (== local9 1)
							(Print 27 38) ; "There's blood under the car."
						else
							(Print 27 39) ; "What blood?"
						)
					)
					((Said 'look/body')
						(if (or (IsFlag 9) (!= local9 1))
							(Print 27 40) ; "No body is around."
						else
							(Print 27 41) ; "You're not close enough."
						)
					)
					((Said 'look,read/sign')
						(Print 27 42) ; "The sign says: "NO PARKING From 8pm to 6am""
					)
					(
						(Said
							'look[<at,around][/!*,chamber,area,area,ave,district]'
						)
						(if (== local9 1)
							(Print 27 43) ; "Looking over the scene, in this run-down area of Lytton, you see Officer Mario Gelepsi and a car with its trunk open."
						else
							(event claimed: 1)
							(Print 27 44) ; "This is the old warehouse district. The down and out frequent these dirty streets. Small-time hoods and drug dealers often use the nearby "dives" to conduct their "business"."
						)
					)
					((Said '/hello[/!*]')
						(if
							(or
								(gCast contains: global112)
								(gCast contains: local1)
								(gCast contains: local0)
							)
							(Print 27 45) ; "Hi, Sonny."
						else
							(Print 27 46) ; "A bum across the street shouts back: "H'lo!""
						)
					)
					((or (Said 'climb<in/trunk') (Said 'get<in/trunk'))
						(if (== local9 1)
							(Print 27 47) ; "You don't need to jump into the trunk to conduct your investigation."
						else
							(Print 27 48) ; "Don't do that."
						)
					)
					((Said 'look/registration')
						(if (== local9 1)
							(Print 27 49) ; "Mario already checked and found the car to be registered in the name of Woody Roberts."
						else
							(Print 27 50) ; "You don't need to do that."
						)
					)
					((Said 'climb,go<through/hole,fence')
						(Print 27 51) ; "You'd rip your clothes if you tried that."
					)
					((Said 'climb')
						(Print 27 52) ; "Don't climb that. You'd look silly."
					)
					((or (Said '/extender') (Said 'extender/'))
						(Print 27 53) ; "Use the car radio for that."
					)
					((Said 'drop,place/briefcase')
						(if (gEgo inRect: 207 156 258 178)
							(if global135
								(if (localproc_0)
									(Print 27 54) ; "You place your field kit inside the trunk."
									(PutItem 10 13) ; field_kit
									(if (IsObject gFKit)
										(gFKit dispose:)
									)
									(= global240 0)
								else
									(Print 27 55) ; "You don't have the field kit."
								)
							else
								(Print 27 56) ; "Open the trunk first."
							)
						else
							(Print 27 57) ; "You're not close enough to your car's trunk."
						)
					)
					((Said 'remove,get/briefcase')
						(if (gEgo inRect: 207 156 258 178)
							(if global135
								(if (IsItemAt 10 13) ; field_kit
									(Print 27 58) ; "You take your field kit from the trunk."
									(gEgo get: 10) ; field_kit
								else
									(Print 27 59) ; "The field kit is not in the trunk."
								)
							else
								(Print 27 56) ; "Open the trunk first."
							)
						else
							(Print 27 57) ; "You're not close enough to your car's trunk."
						)
					)
					((Said 'enter,walk,go,crawl/hole')
						(Print 27 60) ; "You're too big."
					)
					((Said 'climb,jump/fence')
						(Print 27 61) ; "The action is on your side of the fence."
					)
					((Said 'remove,get,move,hoist/body,man')
						(cond
							((!= local9 1)
								(Print 27 62) ; "What body?"
							)
							((== global182 0)
								(Print 27 63) ; "That's a job for the coroner. You'd better wait."
							)
							((!= global182 2)
								(Print 27 64) ; "The body's already been removed from the trunk."
							)
							((not (gEgo inRect: 170 133 196 149))
								(Print 27 65) ; "Your not close enough."
							)
							(else
								(quincyScript changeState: 9)
							)
						)
					)
					((or (Said 'open/door') (Said 'get<in'))
						(if local6
							(= global132 1)
						else
							(localproc_1)
						)
					)
					((Said 'enter/auto')
						(localproc_1)
					)
					((Said 'unlock/door')
						(if (gEgo inRect: 268 152 290 161)
							(cond
								((and (== global131 13) (gEgo has: 3)) ; unmarked_car_keys
									(if (== global133 1)
										(= global133 0)
										(Print 27 66) ; "OK. It's unlocked."
									else
										(Print 27 67) ; "The door is already unlocked."
									)
								)
								((== global131 13)
									(Print 27 68) ; "You need a key to unlock this door."
								)
							)
							(cond
								((and (== global131 33) (gEgo has: 2)) ; key_ring
									(if (== global136 1)
										(= global136 0)
										(Print 27 66) ; "OK. It's unlocked."
									else
										(Print 27 67) ; "The door is already unlocked."
									)
								)
								((== global131 33)
									(Print 27 68) ; "You need a key to unlock this door."
								)
							)
						else
							(proc0_7) ; "You're not close enough."
						)
					)
					((Said 'lock/door')
						(if (gEgo inRect: 268 152 290 161)
							(if (== global131 13)
								(if (== global133 0)
									(= global133 1)
									(Print 27 69) ; "OK. It's locked."
								else
									(Print 27 70) ; "The door is already locked."
								)
							)
							(if (== global131 33)
								(if (== global136 0)
									(= global136 1)
									(Print 27 69) ; "OK. It's locked."
								else
									(Print 27 70) ; "The door is already locked."
								)
							)
						else
							(proc0_7) ; "You're not close enough."
						)
					)
					((Said 'open,unlock/trunk')
						(cond
							((gEgo inRect: 170 133 196 149)
								(Print 27 71) ; "The trunk of the green car is already open."
							)
							((== global131 13)
								(if (gEgo inRect: 207 156 258 178)
									(cond
										(global135
											(Print 27 72) ; "The trunk's already open."
										)
										((gEgo has: 3) ; unmarked_car_keys
											(carScript changeState: 15)
											(= global135 1)
										)
										(else
											(Print 27 73) ; "You need a key to open this trunk."
										)
									)
								else
									(proc0_7) ; "You're not close enough."
								)
							)
							(else
								(Print 27 74) ; "Your car's "hatch-back" hasn't worked since its warranty expired."
							)
						)
					)
					((Said 'close,lock/trunk')
						(cond
							((gEgo inRect: 170 133 184 149)
								(Print 27 75) ; "After carefull consideration, you wisely decide not to close the trunk. It would make your investigation more difficult."
							)
							((== global131 13)
								(if (gEgo inRect: 207 156 258 178)
									(if global135
										(carScript changeState: 17)
										(= global135 0)
									else
										(Print 27 76) ; "It's already closed."
									)
								else
									(proc0_7) ; "You're not close enough."
								)
							)
							(else
								(Print 27 74) ; "Your car's "hatch-back" hasn't worked since its warranty expired."
							)
						)
					)
				)
			)
		)
	)

	(method (init)
		(super init:)
		(Load rsVIEW 0)
		(Load rsVIEW 20)
		(Load rsVIEW 253)
		(Load rsVIEW 54)
		(Load rsVIEW 51)
		(self setLocales: 153)
		(NormalEgo)
		(if (== global131 33)
			(ourCarBlock left: 250)
		)
		(= local6 (not (= local8 (== gPrevRoomNum 28))))
		(if local8
			(gEgo observeBlocks: ourCarBlock)
			(HandsOn)
		else
			(HandsOff)
		)
		(if (and local8 (= global131 13) global135)
			(unTrunk
				view: 51
				loop: 5
				cel: 2
				posn: 250 172
				setPri: 13
				ignoreActors:
				init:
			)
		)
		(= local11 3)
		(cond
			(local8
				(= local9 1)
			)
			((and (== global100 10) (> 90 global158 1))
				(= local9 3)
				(= global158 1)
				(= global182 3)
			)
			((and (== global100 10) (or (>= global158 90) (== global158 0)))
				(= local9 1)
			)
			((< global100 10)
				(= local9 0)
			)
			((>= global100 11)
				(= local9 2)
				(= global182 3)
			)
		)
		(= global212
			(cond
				((== local9 1) 3)
				((== global131 13) 2)
				(else 1)
			)
		)
		(if (and (== global100 10) (!= local9 3))
			(= global158 0)
			(= global159 0)
			(= global138 0)
		)
		((View new:) view: 253 loop: 0 cel: 0 posn: 242 140 init: addToPic:)
		((View new:) view: 253 loop: 0 cel: 0 posn: 10 140 init: addToPic:)
		((View new:) view: 253 loop: 0 cel: 3 posn: 28 138 init: addToPic:)
		((View new:) view: 253 loop: 0 cel: 3 posn: 277 143 init: addToPic:)
		((View new:) view: 253 loop: 0 cel: 3 posn: 10 149 init: addToPic:)
		((View new:) view: 253 loop: 0 cel: 1 posn: 221 140 init: addToPic:)
		((View new:) view: 253 loop: 0 cel: 1 posn: 109 130 init: addToPic:)
		((View new:) view: 253 loop: 0 cel: 3 posn: 194 130 init: addToPic:)
		((View new:) view: 253 loop: 0 cel: 2 posn: 241 133 init: addToPic:)
		((View new:) view: 253 loop: 0 cel: 3 posn: 17 130 init: addToPic:)
		((View new:) view: 253 loop: 0 cel: 3 posn: 292 133 init: addToPic:)
		(if (== local9 1)
			((View new:)
				view: 54
				loop: 0
				cel: 3
				posn: 95 148
				init:
				ignoreActors:
				addToPic:
			)
			(gEgo observeBlocks: bwCarBlock)
			(if (< 0 global182 3)
				(gEgo observeBlocks: quincyCarBlock)
			)
			((View new:) view: 86 loop: 0 cel: 0 posn: 233 147 init: addToPic:)
			((= local0 (Act new:))
				view: 48
				posn: 178 136
				setStep: 3 4
				init:
				setCycle: Walk
				illegalBits: 0
				setScript: mrGScript
			)
		)
		((= local1 (Act new:))
			view: 10
			posn: (if (> 3 global182 1) 223 else -100) 150
			loop: 1
			init:
			setCycle: Walk
			illegalBits: 0
			stopUpd:
		)
		((= local2 (Act new:))
			view: 162
			posn:
				188
				(switch global182
					(1 264)
					(2 187)
					(else 264)
				)
			setLoop: 0
			init:
		)
		(= local7
			(if (== global130 gCurRoomNum)
				(not local8)
			)
		)
		(if (not local8)
			(= local6 1)
		else
			(= local6 0)
		)
		((= local4 (Act new:))
			view: 54
			setStep: 1
			setLoop: 1
			setCel: (if (== global131 13) 1 else 5)
			setCycle: 0
			setMotion: 0
			posn: (if (and (not local8) (not local7)) 272 else 288) 169
			init:
			ignoreActors:
		)
		(self setScript: rm27Script)
	)
)

(instance rm27Script of Script
	(properties)

	(method (doit)
		(cond
			((and global132 local6 (not (gCast contains: local4)))
				(= global132 0)
				(carScript changeState: 0)
			)
			((== global132 (not local6) 1)
				(= global132 0)
				(localproc_1)
			)
		)
		(if (and (not (gEgo onControl:)) (not local6))
			(Print 27 77) ; "You will need your car in order to leave the area."
			(cond
				((<= (gEgo x:) 0)
					(gEgo setMotion: MoveTo 5 (gEgo y:))
				)
				((>= (gEgo x:) 320)
					(gEgo setMotion: MoveTo 315 (gEgo y:))
				)
				((>= (gEgo y:) 180)
					(gEgo setMotion: MoveTo (gEgo x:) 177)
				)
			)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					view: 0
					posn: (if local8 174 else 30) (if local8 145 else -20)
					init:
					setMotion: 0
				)
				(if (== global131 13)
					((= global112 (Act new:))
						view: 20
						posn: -100 0
						setCycle: Walk
						setMotion: 0
						illegalBits: 0
						setAvoider: (Avoid new:)
						init:
					)
				)
				(if (and (== global131 13) local8)
					(global112
						setPri: 9
						setLoop: 2
						ignoreActors:
						posn: 239 156
						stopUpd:
					)
				)
				(if (not local8)
					(= global135 0)
					(stopScript init:)
					(local4 setMotion: MoveTo 288 169 stopScript)
					(= global132 1)
				else
					(local4 addToPic:)
				)
				(if (!= global130 gCurRoomNum)
					(= global130 gCurRoomNum)
				)
				(if (and local8 (== global182 0))
					(= global182 1)
					(if (IsFlag 153)
						(Print 27 78 #draw #at -1 50) ; ""Here comes the 'meat wagon' Sonny," Keith announces from inside the car."
					)
					(local1 setScript: quincyScript)
				)
				(if (and local8 (IsFlag 43))
					(ClearFlag 43)
					(quincyScript changeState: 9)
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
					posn: 281 168
					setPri: 12
					setLoop: 0
					setCycle: 0
					ignoreActors: 1
					illegalBits: 0
					setMotion: MoveTo 277 154 self
				)
				(if (== global131 13)
					(global112 loop: 0 cel: 1 posn: 291 170 startUpd:)
					((= local5 (Prop new:))
						view: 51
						loop: 3
						cel: 0
						posn: 306 163
						setPri: 13
						init:
						setCycle: End
					)
				)
			)
			(1
				(gEgo observeBlocks: ourCarBlock)
				(= local6 0)
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
					illegalBits: $8000
				)
				(HandsOn)
				(cond
					((and (== global131 13) (!= local9 1))
						(self cue:)
					)
					((== global131 13)
						(if (< global110 30)
							(global112 stopUpd:)
						else
							(global112 setMotion: Follow gEgo 500)
						)
					)
				)
			)
			(2
				(local5 dispose:)
				(global112 setMotion: MoveTo 221 170 self)
			)
			(3
				(global112 setMotion: MoveTo 170 141 self)
			)
			(4
				(global112 setMotion: MoveTo 170 133 self)
			)
			(5
				(switch local9
					(1
						(Print 27 79 #at -1 22) ; ""Ugh!" grunts Keith, as he walks past the body."
						(Print 27 80 #at -1 22) ; "I'll search the car, Sonny. YOU can examine the trunk."
						(global112
							ignoreActors:
							illegalBits: 0
							setMotion: MoveTo 235 131 self
						)
					)
					(2
						(Print 27 81 #at -1 22) ; "What are we doing back here, Sonny?"
					)
					(3
						(Print 27 82 #at -1 22) ; "Keith looks at you accusingly; "They've already cleaned up the murder scene! I told you we should've come here right away. We're going to catch it from Fletch now!""
					)
					(0
						(Print 27 83 #at -1 160 #draw) ; "What are we doing here?" Keith asks. "Are we going to meet someone?"
					)
				)
			)
			(6
				(global112 setPri: 9 setMotion: MoveTo 239 156 self)
			)
			(7
				(global112 ignoreActors: stopUpd:)
			)
			(8
				(HandsOff)
				(gEgo stopUpd: ignoreBlocks: ourCarBlock)
				(if (and (== global131 13) (< (global112 y:) 158))
					(Print 27 84) ; "Keith yells: "Wait up, Sonny! Don't leave me here!""
					(global112
						ignoreActors:
						illegalBits: 0
						setLoop: -1
						posn: (global112 x:) 130
						setMotion: MoveTo 239 132 self
					)
				else
					(self changeState: 13)
				)
			)
			(9
				(global112 setPri: -1 setMotion: MoveTo 294 132 self)
			)
			(10
				(global112 setMotion: MoveTo 332 170 self)
			)
			(11
				(global112 setMotion: MoveTo 294 171 self)
			)
			(12
				((= local5 (Prop new:))
					view: 51
					loop: 3
					cel: 0
					posn: 306 163
					setPri: 13
					init:
					setCycle: End self
				)
			)
			(13
				(if (== global131 13)
					(global112 loop: 0)
				)
				(gEgo
					ignoreActors: 1
					illegalBits: 0
					setPri: 12
					setLoop: 0
					setCycle: 0
					setStep: 1 2
					setMotion: MoveTo 281 166 self
				)
			)
			(14
				(gCurRoom newRoom: global131)
			)
			(15
				(= global135 1)
				(unTrunk
					view: 51
					loop: 5
					cel: 0
					posn: 250 172
					setPri: 13
					init:
					ignoreActors:
					setCycle: End self
				)
			)
			(16
				(unTrunk stopUpd:)
			)
			(17
				(= global135 0)
				(unTrunk
					view: 51
					loop: 5
					cel: 2
					posn: 250 172
					setPri: 13
					startUpd:
					setCycle: CT 0 -1 self
				)
			)
			(18
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
				(local4 ignoreActors: 0 addToPic:)
				(HandsOn)
			)
		)
	)
)

(instance mrGScript of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (== (self state:) 2) (not local6) (< global100 11))
			(self changeState: 3)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (or local8 (IsFlag 42))
					(local0 posn: 88 150 setMotion: MoveTo 110 149 self)
				else
					(local0 setMotion: MoveTo 178 147 self)
				)
			)
			(1
				(local0 stopUpd:)
				(cond
					(local8
						(cond
							((IsFlag 9)
								(Print 27 85 #at 40 24) ; ""Did'a you find something, Sonny?" Mario asks."
								(= local13 1000)
							)
							((not (IsFlag 44))
								(Print 27 86 #at 40 24) ; "Pretty gruesome, eh, Sonny?" groans Mario. "How'a one person can'a do that to another is really... you know'a... sick!"
								(SetFlag 44)
							)
						)
					)
					((IsFlag 42)
						(Print 27 87) ; ""Hello again, guys," shouts Officer Gelepsi."
					)
					(else
						(SetFlag 42)
						(local0 setMotion: MoveTo 186 149 self)
					)
				)
			)
			(2
				(local0 setMotion: MoveTo 210 149)
			)
			(3
				(HandsOff)
				(gEgo loop: 1 stopUpd:)
				(Print 27 88 #at -1 24 #draw) ; "In his heavy Italian accent, Officer Gelepsi says... "Well! It'sa bout'a time, Sonny!""
				(= seconds 2)
			)
			(4
				(Print 27 89 #at -1 24) ; ""I found'a this car with'a blood dripping from'a the trunk" he says..."
				(= seconds 2)
			)
			(5
				(local0 setMotion: MoveTo 192 149 self)
			)
			(6
				(Print 27 90 #at -1 24) ; "Continuing, he says "The door was un'alocked, with'a the keys innaside.""
				(carScript changeState: 2)
				(= seconds 1)
			)
			(7
				(Print 27 91 #at -1 14) ; "You listen intently as he explains, "I took'a the keys and opened the trunk. That'sa when I found the man with the hole'a inna his head.""
				(= seconds 1)
			)
			(8
				(local0 setMotion: MoveTo 90 152 self)
			)
			(9
				(local0 setLoop: 0 stopUpd:)
				(Print 27 92 #at -1 60) ; "Continuing..."Thisa car isa registered to Woody Roberts.""
				(Print 27 93 #at 88 144 #draw) ; "Gelepsi finishes, "I called'a the coroner. Now YOU canna take over this'a mess, Sonny. ""
				(gEgo setMotion: 0 startUpd:)
				(HandsOn)
			)
		)
	)
)

(instance quincyScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (gEgo inRect: 168 151 206 250)
					(Print 27 94) ; "Remembering the coroner's poor eyesight, you decide to move out of his car's way."
					(gEgo setMotion: MoveTo 158 155 self)
				else
					(self cue:)
				)
			)
			(1
				(if (== global182 1)
					(= global182 2)
					(gEgo observeBlocks: quincyCarBlock stopUpd:)
					(local2 setMotion: MoveTo 188 187 self)
				)
			)
			(2
				(local2 stopUpd:)
				(qDoor
					view: 162
					posn: 214 165
					loop: 2
					cel: 0
					setPri: 14
					setCycle: End self
					init:
				)
			)
			(3
				(local1
					posn: 217 170
					ignoreActors:
					startUpd:
					setLoop: 2
					setCycle: 0
				)
				(= seconds 1)
			)
			(4
				(qDoor setCycle: Beg)
				(local1
					setLoop: -1
					setCycle: Walk
					setStep: 3 2
					setMotion: MoveTo 222 150 self
				)
			)
			(5
				(= global181 0)
				(local1 loop: 1 ignoreActors: 0)
				(Print 27 95 #at -1 60 #draw) ; "Where is this body?" asks the coroner. "I don't see no body! (haw haw)"
				(= seconds 2)
			)
			(6
				(Print 27 96 #at -1 50) ; "Let me guess: the trunk! Of course, where else WOULD it be?"
				(if (gEgo inRect: 190 147 223 153)
					(gEgo setMotion: MoveTo 190 152)
				)
				(local1 setMotion: MoveTo 196 152 self)
			)
			(7
				(gEgo loop: 0)
				(= global181 1)
				(local1 setMotion: MoveTo 196 149 self)
			)
			(8
				(Print 27 97 #at -1 50) ; "Yes-sir-ree-Bob!" remarks the coroner. "Definitely looks like an execution."
				(gEgo setMotion: 0 startUpd:)
				(HandsOn)
			)
			(9
				(HandsOff)
				(SetScore 2)
				(Print 27 98) ; ""I'll take care of the body now, Bonds.", says the coroner."
				(Print 27 99) ; "Would you help me, Officer Gelepsi?" asks the coroner. "This fella is pretty heavy. He's on a diet now, though (haw haw)."
				(local0 ignoreActors: setMotion: MoveTo 186 149 self)
				(egoScript changeState: 0)
			)
			(10
				((= local3 (Prop new:))
					view: 162
					loop: 1
					cel: 0
					posn: 190 136
					setPri: 15
					setCycle: End
					init:
					ignoreActors:
				)
				(local0 setMotion: MoveTo 178 145)
				(local1 ignoreActors: setMotion: MoveTo 180 152)
				(= seconds 2)
			)
			(11
				(local0 setMotion: MoveTo 181 150)
				(local1 setMotion: MoveTo 182 155)
				(= seconds 2)
			)
			(12
				(Print 27 100 #at -1 67 #width 118) ; "Officer Gelepsi and the coroner struggle to carry the victim into the back of the coroner's vehicle."
				(= local10 1)
				(local0 setMotion: MoveTo 88 150)
				(local1 setMotion: MoveTo 210 150 self)
				(SetFlag 9)
			)
			(13
				(local3 setCel: 0)
				(local1 setMotion: MoveTo 218 170 self)
			)
			(14
				(Print 27 101) ; ""Bye, Sonny! I gotta dig up a date for tonight (haw!)," the cheerful coroner yells over his shoulder."
				(= global182 3)
				(= local10 0)
				(qDoor
					view: 162
					posn: 214 165
					loop: 2
					cel: 0
					setPri: 14
					setCycle: End self
					init:
				)
			)
			(15
				(qDoor setCycle: Beg)
				(local1 hide:)
				(if (gEgo inRect: 162 187 212 240)
					(Print 27 102) ; "The coroner has work to do - and since you don't want to end up on his table next to Woody, you decide to MOVE!"
					(HandsOff)
					(gEgo setMotion: MoveTo 10 180 self)
				else
					(= cycles 10)
				)
			)
			(16
				(gEgo setMotion: 0 startUpd:)
				(HandsOn)
				(local2 setMotion: MoveTo 188 390)
				(local0 setLoop: 0 ignoreActors: 0 stopUpd:)
				(qDoor dispose:)
				(local3 dispose:)
				(gEgo ignoreBlocks: quincyCarBlock)
			)
		)
	)
)

(instance egoScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 176 133 self)
			)
			(1
				(gEgo setMotion: MoveTo 188 133 self)
			)
			(2
				(gEgo loop: 2 stopUpd:)
			)
		)
	)
)

