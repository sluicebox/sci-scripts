;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 18)
(include sci.sh)
(use Main)
(use Interface)
(use Avoid)
(use Sound)
(use Motion)
(use Game)
(use Inventory)
(use Actor)
(use System)

(public
	Room18 0
)

(synonyms
	(kiss kiss embrace)
	(ghoul ghoul ghoul man ghoul ghoul)
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

(instance zTheme of Sound
	(properties
		number 20
		priority 1
		loop -1
	)
)

(instance doorSound of Sound
	(properties
		number 300
		priority 3
	)
)

(instance door of Prop
	(properties)

	(method (cue)
		(self ignoreActors:)
		(gCurRoom newRoom: 69)
	)
)

(instance Room18 of Rm
	(properties
		picture 18
		horizon 85
		north 12
		south 24
		west 17
	)

	(method (init)
		(= gIndoors 0)
		(Load rsVIEW 47)
		(gEgo edgeHit: 0 observeControl: 16384)
		(= global186 0)
		(super init:)
		(if gNight
			(gCurRoom overlay: 118)
		)
		(self setRegions: 510 511) ; cemReg, mountReg
		(if gNight
			(Load rsVIEW 261)
			(Load rsVIEW 267)
			(Load rsVIEW 269)
			(Load rsVIEW 36)
			(Load rsVIEW 46)
			(Load rsVIEW 45)
			(Load rsVIEW 21)
			(= local2 (Act new:))
			(= local0 (Act new:))
			(= local1 (Act new:))
			(local2
				view: 260
				loop: 0
				cel: 0
				xStep: 2
				yStep: 1
				posn: 25 156
				setScript: z1Actions
				init:
				hide:
			)
			(local0
				view: 266
				loop: 0
				cel: 0
				xStep: 2
				yStep: 1
				posn: 109 131
				setScript: z4Actions
				init:
				hide:
			)
			(local1
				view: 268
				loop: 0
				cel: 0
				xStep: 2
				yStep: 1
				posn: 220 165
				setScript: z5Actions
				init:
				hide:
			)
		)
		(if (== global174 2)
			(gEgo ignoreControl: 16384)
			(door
				posn: 273 148
				view: 611
				loop: 0
				cel: 4
				setPri: 0
				ignoreActors:
				init:
				stopUpd:
			)
		else
			(door
				posn: 273 148
				view: 611
				loop: 0
				cel: 0
				setPri: 0
				init:
				stopUpd:
			)
		)
		(switch gPrevRoomNum
			(west
				(gEgo posn: 2 (gEgo y:))
			)
			(north
				(gEgo x: 45 y: (+ horizon (gEgo yStep:) 1))
			)
			(south
				(gEgo posn: 172 188)
			)
			(69
				(gEgo x: 266 y: 153 xStep: 3 yStep: 2 ignoreControl: 16384)
				(door
					posn: 273 148
					view: 611
					loop: 0
					cel: 4
					setPri: 0
					ignoreActors:
					init:
					stopUpd:
				)
			)
			(0
				(gEgo x: 180 y: 188)
			)
		)
		(= global105 0)
		(gEgo view: 2 init:)
		(for ((= local6 1)) (<= local6 gShovelCount) ((++ local6))
			(if (== [global138 (= local5 (* (- local6 1) 3))] gCurRoomNum)
				((View new:)
					view: 528
					loop: 0
					cel: 6
					posn: [global138 (+ local5 1)] [global138 (+ local5 2)]
					ignoreActors:
					setPri: 0
					addToPic:
					ignoreActors:
				)
			)
		)
	)

	(method (doit)
		(super doit:)
		(if (& (gEgo onControl: 0) $4000)
			(gCurRoom newRoom: 69)
		)
	)

	(method (newRoom newRoomNumber)
		(HandsOn)
		(= global189 0)
		(if (== (gEgo view:) 2)
			(super newRoom: newRoomNumber)
		)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return 1)
		)
		(if (== (event type:) evSAID)
			(cond
				((Said 'climb/boulder')
					(Print 18 0) ; "You're not interested in climbing rocks."
				)
				((Said 'open,enter/crypt')
					(if (== global174 2)
						(Print 18 1) ; "The door is open; just enter it."
					else
						(Print 18 2) ; "Try opening the crypt door."
					)
				)
				((Said 'look>')
					(cond
						((Said '/boulder')
							(Print 18 3) ; "There are rocks here and there."
						)
						((Said '/grass')
							(Print 18 4) ; "Tufts of grass and weeds sprout around the old tombstones."
						)
						((Said '/crypt')
							(Print 18 5) ; "The stone crypt is built into the mountainside!"
						)
						((Said '/cliff')
							(Print 18 6) ; "A stone crypt is built into the mountainside."
						)
						((Said '/gravestone')
							(Print 18 7) ; "Each tombstone has an epitaph written on it."
						)
						((Said '/monument,lion')
							(Print 18 8) ; "An interesting statue of a lion is mounted above the crypt door."
						)
						((Said '/door')
							(if (== (door cel:) 0)
								(Print 18 9) ; "The crypt door is closed."
							else
								(Print 18 10) ; "The crypt door is open."
							)
						)
						((Said '/hole')
							(for
								((= local7 1))
								(<= local7 gShovelCount)
								((++ local7))
								
								(if
									(and
										(==
											[global138
												(= local5 (* (- local7 1) 3))
											]
											18
										)
										(<
											(egoDist
												doit:
													[global138 (+ local5 1)]
													[global138 (+ local5 2)]
											)
											20
										)
									)
									(= local8 1)
								)
							)
							(if (>= gShovelCount 0)
								(if local8
									(Print 18 11) ; "The hole is empty."
								else
									(Print 800 1) ; "You're not close enough."
								)
							else
								(Print 18 12) ; "You don't see it here."
							)
							(= local8 0)
						)
						((Said '[<around][/room]')
							(Print 18 13) ; "This is a scary old cemetery! Many of the tombstones are crumbling or falling over, and the entire place is overgrown with weeds. A mountain range looms to the east, and all around a forest encroaches."
							(Print 18 14) ; "How odd! You see a crypt door built right into the mountainside!"
						)
					)
				)
			)
			(cond
				((Said '/door>')
					(cond
						((Said 'break')
							(Print 18 15) ; "You could never do that."
						)
						((Said 'bang')
							(if (gEgo inRect: 262 149 292 157)
								(Print 18 16) ; "You pound on the door and hear your knocks echo from within. There is no answer."
							else
								(Print 800 1) ; "You're not close enough."
							)
						)
						((Said 'open')
							(if (gEgo inRect: 262 149 292 157)
								(cond
									((== global174 1)
										(doorSound play: door)
										(gEgo
											setMotion: 0
											ignoreControl: 16384
										)
										(HandsOff)
										(= global174 2)
										(= global205 1)
										(door setCycle: End door)
									)
									((== global174 0)
										(Print 18 17) ; "The door is locked."
									)
									(else
										(Print 18 18) ; "The crypt door is already open."
									)
								)
							else
								(Print 800 1) ; "You're not close enough."
							)
						)
						((Said 'close')
							(if (== (door cel:) 0)
								(Print 18 19) ; "The door is closed."
							else
								(Print 18 20) ; "Ok."
								(door setCycle: Beg)
								(gEgo observeControl: 16384)
								(= global174 1)
								(doorSound play:)
							)
						)
						((Said 'latch')
							(if ((Inv at: 20) ownedBy: gEgo) ; Skeleton_Key
								(if (gEgo inRect: 262 149 292 157)
									(cond
										((== global174 1)
											(if
												(and
													((Inv at: 4) ownedBy: 69) ; Pandora_s_Box
													(== gAct 99)
												)
												(Print 18 21 #draw) ; "You place the skeleton key in the lock of the crypt door. Click. It locked! You kick the key through a crack under the door. Now no one will ever accidentally release the evils of Pandora's box into the world!"
												(gGame changeScore: 2)
												(gEgo put: 20 18) ; Skeleton_Key
												(= global174 0)
												(gEgo observeControl: 16384)
											else
												(Print 18 22) ; "Ok. You lock the door."
												(= global174 0)
											)
										)
										((== global174 2)
											(Print 18 23) ; "First you need to close the door."
										)
										((== global174 0)
											(Print 18 24) ; "The door is already locked."
										)
									)
								else
									(Print 800 1) ; "You're not close enough."
								)
							else
								(Print 18 25) ; "You don't have the right key to lock this door."
							)
						)
						((Said 'unlatch')
							(if (gEgo inRect: 262 149 292 157)
								(cond
									((== global174 0)
										(if ((Inv at: 20) ownedBy: gEgo) ; Skeleton_Key
											(Print 18 26) ; "You place the skeleton key in the lock of the crypt door. Slowly, you turn it. Click. It unlocked!"
											(if (not global187)
												(gGame changeScore: 3)
												(++ global187)
											)
											(= global174 1)
										else
											(Print 18 27) ; "You don't have the key to unlock this door."
										)
									)
									((== global174 2)
										(Print 18 28) ; "The door is already open."
									)
									((== global174 1)
										(Print 18 29) ; "The door is already unlocked."
									)
								)
							else
								(Print 800 1) ; "You're not close enough."
							)
						)
					)
				)
				((Said 'read,look/epitaph,gravestone,boulder')
					(cond
						((& (gEgo onControl: 0) $0004)
							(Print 18 30 #mode 1 #at -1 15 #width 290) ; "Betty Cowden 1650 to 1669 Here lieth the body of Betty Cowden Who would live longer but she couden; Sorrow and grief made her decay When she lost her lover at sea one day."
						)
						((& (gEgo onControl: 0) $0080)
							(Print 18 31 #mode 1 #at -1 15 #width 290) ; "Whoe'er you are, tread softly, I entreat you, For if he chance to wake, be sure he'll eat you."
						)
						((& (gEgo onControl: 0) $0008)
							(Print 18 32 #mode 1 #at -1 15 #width 290) ; "At length, my friends, the feast of life is o'er, I've eat sufficient, and I'll drink no more; My night is come, I've spent a jovial day, 'Tis time to part, but oh!--what is to pay?"
						)
						((& (gEgo onControl: 0) $0020)
							(Print 18 33 #mode 1 #at -1 15 #width 290) ; "1546 Reader, here lies--but forbear To read more without a tear, One--I cannot speak the rest, You may weep. I'll smite my breast, Grief preventing, and this stone, Too small to be written on. Only this--a little boy, Willy--in Abram's bosom's laid."
						)
						((& (gEgo onControl: 0) $1000)
							(Print 18 34 #mode 1 #at -1 15 #width 290) ; "Rebecca Freeland 1598 She drank good ale, good punch and wine And lived to the age of 99."
						)
						((& (gEgo onControl: 0) $0002)
							(Print 18 35 #mode 1 #at -1 15 #width 290) ; "1634 to 1672 She done her best."
						)
						((& (gEgo onControl: 0) $0010)
							(Print 18 36 #mode 1 #at -1 15 #width 290) ; "Here lies a poor woman who was always tired, She lived in a house where help wasn't hired: Her last words on earth were: "Dear friends, I am going To where there's no cooking, or washing, or sewing, For everything there is exact to my wishes, For where they don't eat there's no washing of dishes, I'll be where loud anthems will always be ringing, But having no voice I'll be quit of the singing, Don't mourn for me now, don't mourn for me never, I am going to do nothing for ever and ever.""
						)
						((& (gEgo onControl: 0) $0100)
							(Print 18 37 #mode 1 #at -1 15 #width 290) ; "Dentist Brown Stranger! Approach this spot with gravity! John Brown is filling his last cavity."
						)
						(else
							(Print 800 1) ; "You're not close enough."
						)
					)
				)
				((Said 'dig[/hole,grave]')
					(if (and (gEgo has: 15) (== 0 ((Inv at: 15) loop:))) ; Shovel, Shovel
						(if (> global134 0)
							(if (& (gEgo onControl: 0) $7fff)
								(gEgo setScript: digging)
								(digging changeState: 1)
							else
								(Print 18 38) ; "Try somewhere else. The ground is too hard here."
							)
						else
							(Print 18 39) ; "You don't know what to dig for...yet."
						)
					else
						(Print 18 40) ; "You have nothing to dig with."
					)
				)
			)
		)
	)
)

(instance z4Actions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 4)
			)
			(1
				(= global189 1)
				(zTheme loop: -1 play:)
				(++ global186)
				(local0 show: setCycle: End self)
				((View new:)
					view: 266
					posn: (local0 x:) (local0 y:)
					ignoreActors:
					addToPic:
				)
			)
			(2
				(if (== global105 0)
					(local0
						view: 267
						setCycle: Walk
						setAvoider: (Avoid new:)
						setMotion: Chase gEgo 12 self
					)
				else
					(local0
						view: 267
						setCycle: Walk
						setAvoider: (Avoid new:)
						setMotion: Wander 50
					)
				)
			)
			(3
				(cond
					((gEgo has: 7) ; Obsidian_Scarab
						(self changeState: 4)
					)
					((== global105 0)
						(self changeState: 10)
					)
				)
			)
			(4
				(local0 view: 266 cel: 11 setCycle: Beg self)
				(Print 18 41) ; "The terrifying zombie senses your obsidian scarab. It immediately retreats and goes back to whence it came."
				(if (== (-- global186) 0)
					(zTheme loop: 1 changeState:)
				)
			)
			(5
				(local0 ignoreActors: addToPic:)
			)
			(10
				(HandsOff)
				(= global105 17)
				(zTheme dispose: number: 21 play:)
				(gEgo view: 36 cel: 0 setCycle: End self)
				(if (and (gCast contains: local2) (== (local2 mover:) Chase))
					(local2 setMotion: Wander)
				)
				(if (and (gCast contains: local1) (== (local1 mover:) Chase))
					(local1 setMotion: Wander)
				)
				(if (gCast contains: local2)
					(local2 setMotion: Wander)
				)
				(local0 setMotion: Wander)
			)
			(11
				(gEgo view: 46 cel: 0 setCycle: End self)
			)
			(12
				(= global120 (Print 18 42 #at -1 10 #dispose)) ; "To wander forever is now your fate."
				(gEgo view: 45 setCycle: Walk setMotion: Wander)
				(= seconds 12)
			)
			(13
				(cls)
				(zTheme stop:)
				(= gDeathFlag 1)
			)
		)
	)
)

(instance z5Actions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 8)
			)
			(1
				(++ global186)
				(if (== (zTheme state:) 0)
					(zTheme loop: -1 play:)
				)
				(if (== (zTheme loop:) 1)
					(zTheme loop: -1 changeState:)
				)
				(local1 show: setCycle: End self)
				((View new:)
					view: 268
					cel: 0
					posn: (local1 x:) (local1 y:)
					ignoreActors:
					addToPic:
				)
			)
			(2
				(if (== global105 0)
					(local1
						view: 269
						setCycle: Walk
						setAvoider: (Avoid new:)
						setMotion: Chase gEgo 12 self
					)
				else
					(local1
						view: 269
						setCycle: Walk
						setAvoider: (Avoid new:)
						setMotion: Wander 50 self
					)
				)
			)
			(3
				(cond
					((gEgo has: 7) ; Obsidian_Scarab
						(self changeState: 4)
					)
					((== global105 0)
						(self changeState: 10)
					)
				)
			)
			(4
				(Print 18 41) ; "The terrifying zombie senses your obsidian scarab. It immediately retreats and goes back to whence it came."
				(if (== (-- global186) 0)
					(zTheme loop: 1 changeState:)
				)
				(local1 view: 268 cel: 11 setCycle: Beg self)
			)
			(5
				(local1 ignoreActors: addToPic:)
			)
			(10
				(HandsOff)
				(= global105 17)
				(zTheme dispose: number: 21 play:)
				(gEgo view: 36 cel: 0 setMotion: 0 setCycle: End self)
				(local1 setMotion: Wander)
				(if (and (gCast contains: local2) (== (local2 mover:) Chase))
					(local2 setMotion: Wander)
				)
				(if (and (gCast contains: local1) (== (local0 mover:) Chase))
					(local0 setMotion: Wander)
				)
			)
			(11
				(gEgo view: 46 cel: 0 setCycle: End self)
			)
			(12
				(= global120 (Print 18 42 #at -1 10 #dispose)) ; "To wander forever is now your fate."
				(gEgo view: 45 setCycle: Walk setMotion: Wander)
				(= seconds 12)
			)
			(13
				(cls)
				(zTheme stop:)
				(= gDeathFlag 1)
			)
		)
	)
)

(instance z1Actions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 10)
			)
			(1
				(if (== (zTheme state:) 0)
					(zTheme loop: -1 play:)
				)
				(if (== (zTheme loop:) 1)
					(zTheme loop: -1 changeState:)
				)
				(++ global186)
				(= global189 1)
				(local2 show: setCycle: End self)
				((View new:)
					view: 260
					posn: (local2 x:) (local2 y:)
					ignoreActors:
					addToPic:
				)
			)
			(2
				(if (== global105 0)
					(local2
						view: 261
						setCycle: Walk
						setAvoider: (Avoid new:)
						setMotion: Chase gEgo 12 self
					)
				else
					(local2
						view: 261
						setCycle: Walk
						setAvoider: (Avoid new:)
						setMotion: Wander 50
					)
				)
			)
			(3
				(cond
					((gEgo has: 7) ; Obsidian_Scarab
						(self changeState: 4)
					)
					((== global105 0)
						(self changeState: 10)
					)
				)
			)
			(4
				(Print 18 41) ; "The terrifying zombie senses your obsidian scarab. It immediately retreats and goes back to whence it came."
				(if (== (-- global186) 0)
					(zTheme loop: 1 changeState:)
				)
				(local2 setMotion: 0 view: 260 cel: 11 setCycle: Beg self)
			)
			(5
				(local2 ignoreActors: addToPic:)
			)
			(10
				(HandsOff)
				(= global105 17)
				(zTheme dispose: number: 21 play:)
				(gEgo view: 36 cel: 0 setMotion: 0 setCycle: End self)
				(local2 setMotion: Wander)
				(if (and (gCast contains: local1) (== (local1 mover:) Chase))
					(local1 setMotion: Wander)
				)
				(if (and (gCast contains: local0) (== (local0 mover:) Chase))
					(local0 setMotion: Wander)
				)
			)
			(11
				(gEgo view: 46 cel: 0 setCycle: End self)
			)
			(12
				(= global120 (Print 18 42 #at -1 10 #dispose)) ; "To wander forever is now your fate."
				(gEgo view: 45 setCycle: Walk setMotion: Wander)
				(= seconds 12)
			)
			(13
				(cls)
				(zTheme stop:)
				(= gDeathFlag 1)
			)
		)
	)
)

(instance holeActions of Script
	(properties)

	(method (cue &tmp temp0)
		(= temp0 (local3 cel:))
		(++ temp0)
		(if (>= state 0)
			(local3 cel: temp0)
		else
			(++ state)
		)
	)
)

(instance digging of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(HandsOff)
				(gEgo
					view: 47
					loop: (& (gEgo loop:) $0001)
					cel: 0
					setCycle: End self
				)
				(= local3 (Prop new:))
				(local3
					posn:
						(if (== (gEgo loop:) 1)
							(- (gEgo x:) 16)
						else
							(+ (gEgo x:) 16)
						)
						(+ (gEgo y:) 4)
					view: 528
					cel: 0
					setPri: 0
					ignoreActors:
					init:
				)
			)
			(2
				(gEgo cel: 0 setCycle: End self)
			)
			(3
				(if (>= gShovelCount 5)
					(Print 18 43) ; "Oh, oh! You've broken your shovel!"
					(gEgo view: 2 setCycle: Walk)
					((Inv at: 15) loop: 1) ; Shovel
					(self changeState: 0)
					(HandsOn)
				else
					(gEgo cel: 0 setCycle: End self)
				)
			)
			(4
				(gEgo cel: 0 setCycle: End self)
			)
			(5
				(holeActions cue:)
				(if (< (local3 cel:) 6)
					(self changeState: 2)
				else
					(self changeState: 6)
				)
			)
			(6
				(= local5 (* (- (++ gShovelCount) 1) 3))
				(= [global138 local5] gCurRoomNum)
				(= [global138 (+ local5 1)] (local3 x:))
				(= [global138 (+ local5 2)] (local3 y:))
				(gEgo view: 2 setCycle: Walk)
				(HandsOn)
				(cond
					(
						(and
							(& (gEgo onControl: 0) $0020)
							(== global134 5)
							((Inv at: 30) ownedBy: 88) ; Toy_Horse
						)
						(local3 setLoop: 1 cel: 4)
						(Print 18 44 #draw) ; "You dig a small hole at the little boy ghost's grave. Aha! You have uncovered a toy horse!"
						(gEgo setScript: getItems)
						(gEgo get: 30) ; Toy_Horse
						(getItems changeState: 1)
						(gGame changeScore: 3)
					)
					(
						(and
							(& (gEgo onControl: 0) $0004)
							(== global134 3)
							((Inv at: 28) ownedBy: 88) ; Locket
						)
						(local3 setLoop: 1 cel: 0)
						(Print 18 45 #draw) ; "You carefully dig a small hole at the sad lady ghost's grave. Yea! You have found a lovely locket!"
						(gEgo setScript: getItems)
						(getItems changeState: 1)
						(gEgo get: 28) ; Locket
						(gGame changeScore: 3)
					)
					(else
						(Print 18 46) ; "You dig a small hole...but don't find anything of interest."
					)
				)
				(HandsOn)
			)
		)
	)
)

(instance getItems of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(HandsOff)
				(gEgo view: 21 cel: 0 setCycle: End self)
			)
			(2
				(local3 setLoop: 0 cel: 6)
				(= global182 1)
				(gEgo setCycle: Beg self)
			)
			(3
				(gEgo view: 2 setCycle: Walk)
				(Print 18 47) ; "You bend down, pick it up, and carry it with you."
				(HandsOn)
			)
		)
	)
)

(instance egoDist of Code
	(properties)

	(method (doit param1 param2 &tmp temp0)
		(= temp0
			(Sqrt
				(+
					(*
						(Abs (- (gEgo param2:) param2))
						(Abs (- (gEgo param2:) param2))
					)
					(*
						(Abs (- (gEgo param1:) param1))
						(Abs (- (gEgo param1:) param1))
					)
				)
			)
		)
	)
)

