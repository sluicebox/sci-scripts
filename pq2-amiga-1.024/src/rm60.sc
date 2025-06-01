;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 60)
(include sci.sh)
(use Main)
(use Interface)
(use Avoid)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm60 0
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
	local14
	local15
	local16
	local17
	local18
)

(procedure (localproc_0)
	(vanDoor view: 154 setLoop: 0 setCel: 2 posn: 290 175 ignoreActors: init:)
)

(instance vanDoor of Act
	(properties)
)

(instance bains of Act
	(properties)
)

(instance vanBlock of Blk
	(properties
		top 163
		left 234
		bottom 178
		right 330
	)
)

(instance bainsMusic of Sound
	(properties)
)

(instance carSound of Sound
	(properties)
)

(instance bainsShot of Sound
	(properties
		number 41
		priority 14
	)
)

(instance diverScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((= local14 (Act new:))
					view: 154
					setLoop: 0
					setCel: 0
					setStep: 8
					posn: (if (== global189 4) -66 else 283) 174
					ignoreActors:
					init:
					setCycle: 0
				)
				(gEgo observeBlocks: vanBlock stopUpd:)
				(switch global189
					(4
						(HandsOff)
						(gEgo loop: 2 cel: 3)
						(local14 setMotion: MoveTo 283 174 self)
					)
					(6
						(local14 cel: 1 addToPic:)
						(localproc_0)
						(self cue:)
					)
					(14
						(if (not global192)
							(User canControl: 0)
							(gEgo view: 17)
							(local14 cel: 1 addToPic:)
							(localproc_0)
						else
							(local14 cel: 0 addToPic:)
						)
					)
					(16
						(if (not global192)
							(User canControl: 0)
							(gEgo view: 17)
							(local14 cel: 1 addToPic:)
							(localproc_0)
						else
							(local14 cel: 0 addToPic:)
						)
					)
					(8
						(local14 cel: 1 addToPic:)
						(local13 posn: 223 139 setMotion: Follow gEgo 500)
						(localproc_0)
						(self cue:)
					)
					(else
						(local14 cel: 0 addToPic:)
						(self cue:)
					)
				)
			)
			(1
				(if (< global189 6)
					(= global189 5)
					(= global211 1)
					(= global212 3)
					(local14 loop: 5 cel: 1 stopUpd: addToPic:)
					(HandsOn)
					(localproc_0)
				)
				(local13 setCycle: Walk startUpd: loop: 0)
				(cond
					((== gPrevRoomNum 66)
						(local13 posn: 223 139)
						(= global212 3)
						(diverScript changeState: 27)
					)
					((>= global189 11)
						(local13 posn: -40 77)
					)
					((== global189 8)
						(Print 60 0) ; "I'm waiting, Bonds!"
					)
					(else
						(= global212 3)
						(HandsOff)
						(local13
							loop: 0
							setStep: 3 2
							ignoreActors:
							illegalBits: 0
							posn: 288 162
							setMotion: MoveTo 170 162 self
						)
					)
				)
			)
			(2
				(HandsOn)
				(local13 ignoreActors: 0)
				(vanDoor stopUpd:)
				(local13 setMotion: Follow gEgo 500)
				(if (== global189 5)
					(Print 60 1 #at -1 70 #draw) ; "Officer Moore says..."Well, here I am, Bonds. What can I do for you?""
				)
				(if (< global189 8)
					(= global189 6)
				)
			)
			(3
				(HandsOff)
				(User canInput: 1)
				(= global189 7)
				(Print 60 2 #at -1 70 #draw) ; "I don't like diving alone, and I'm the only diver available," Moore says. "You wouldn't happen to have a scuba certification card, would you?"
				(Print 60 3) ; "You say "Yes, I do.""
				(if (or (not (gEgo has: 7)) (not (IsFlag 33))) ; wallet
					(Print 60 4) ; "You think to yourself: "Now, where did I put that?""
				)
				(= local15 1)
				(= local16 60)
			)
			(4
				(Print 60 5 #at -1 70) ; ""Well? If you have it, show it to me," Officer Moore says impatiently."
				(= local16 60)
			)
			(5
				(= local15 0)
				(Print 60 6) ; "Sorry. I can't take you with me without a diving certificate."
				(self changeState: 8)
			)
			(6
				(= local17 1)
				(Print 60 7 #icon 164 0 0) ; "You show your scuba certification card to the diver."
				(Print 60 8 #at -1 70) ; "OK. Wait here while I change."
				(self changeState: 9)
			)
			(8
				(= local17 0)
				(Print 60 9 #at -1 70) ; "Reluctantly, Officer Moore says to you..."Ok, I don't like it, but I'll go ahead and dive alone. I just hope my supervisor doesn't catch me.""
				(Print 60 8 #at -1 70) ; "OK. Wait here while I change."
				(self cue:)
			)
			(9
				(HandsOff)
				(local13
					setStep: 3 2
					ignoreActors: 0
					observeBlocks: vanBlock
					setAvoider: (Avoid new:)
					setMotion: MoveTo 230 184 self
				)
			)
			(10
				(local13
					illegalBits: 0
					ignoreActors:
					setMotion: MoveTo 289 186 self
				)
			)
			(11
				(vanDoor setMotion: MoveTo 270 175 self)
			)
			(12
				(vanDoor stopUpd:)
				(local13 setMotion: MoveTo 290 182 self)
			)
			(13
				(local13 setLoop: 3)
				(= global189 8)
				(self cue:)
			)
			(14
				(local13 hide:)
				(vanDoor setMotion: MoveTo 290 175)
				(= seconds 5)
			)
			(15
				(vanDoor setMotion: MoveTo 270 175 self)
			)
			(16
				(local13
					view: 22
					posn: 289 184
					loop: 2
					cel: 1
					show:
					setMotion: MoveTo 289 188 self
					ignoreActors: 0
				)
			)
			(17
				(Print 60 10 #time 4) ; "Wow! This guy's a quick-change artist!"
				(vanDoor setMotion: MoveTo 290 175)
				(local13 setLoop: -1 setMotion: MoveTo 220 139 self)
			)
			(18
				(vanDoor stopUpd:)
				(self cue:)
			)
			(19
				(if local17
					(HandsOn)
					(local13 loop: 0 stopUpd:)
					(gEgo loop: 1)
					(Print 60 11 #at -1 50 #draw) ; "Ok, Bonds," says Moore, "the equipment is in the van. Just take what you need."
				else
					(Print 60 12 #at -1 50) ; "Don't leave me here." says the diver, "Just stand by 'till I come out of the river."
					(local13 setMotion: MoveTo 180 85 self)
					(= global157 500)
				)
			)
			(20
				(local13
					view: 98
					cel: 0
					setLoop: 7
					setCycle: End
					posn: 178 63
					setMotion: MoveTo 180 54 self
				)
				(= global189 10)
				(= global192 1)
				(Print 60 13 #at -1 45 #draw) ; "Officer Moore puts his mask and fins on, climbs into the water, and disappears from sight beneath the surface."
				(HandsOn)
			)
			(21
				(local13 stopUpd:)
			)
			(22
				(HandsOff)
				(gEgo
					setLoop: 3
					setMotion: MoveTo 289 187 self
					ignoreActors:
					illegalBits: 0
				)
			)
			(23
				(vanDoor startUpd: setMotion: MoveTo 270 175 self)
			)
			(24
				(gEgo setMotion: MoveTo 289 185 self)
			)
			(25
				(gEgo hide:)
				(vanDoor setMotion: MoveTo 290 175 self)
			)
			(26
				(HandsOn)
				(gCurRoom newRoom: 66)
			)
			(27
				(HandsOff)
				(vanDoor setMotion: MoveTo 270 175 self)
			)
			(28
				(gEgo
					view: 17
					posn: 289 186
					loop: 5
					cel: 1
					show:
					illegalBits: 0
					setMotion: MoveTo 289 188 self
				)
			)
			(29
				(vanDoor setMotion: MoveTo 290 175)
				(gEgo setMotion: MoveTo 220 188 self)
			)
			(30
				(gEgo setMotion: MoveTo 216 150 self)
			)
			(31
				(gEgo setMotion: MoveTo 212 81 self)
				(local13 illegalBits: 0 setMotion: MoveTo 180 78)
			)
			(32
				(Print 60 14 #at -1 45) ; "Officer Moore puts his mask and fins on, climbs into the water, and disappears from sight beneath the surface. You quickly put on your fins and follow him into the swiftly-moving river."
				(local13
					view: 98
					cel: 0
					setLoop: 7
					setCycle: End
					posn: 178 63
					setMotion: MoveTo 180 54
				)
				(gEgo
					view: 98
					posn: 211 70
					cel: 0
					setLoop: 0
					setStep: 1 1
					cycleSpeed: 2
					setMotion: MoveTo 210 66
					setCycle: End self
				)
			)
			(33
				(local13 stopUpd:)
				(gEgo setLoop: 1 setCycle: Fwd)
				(= seconds 2)
			)
			(34
				(gEgo setLoop: 2 setCycle: End self)
			)
			(35
				(gEgo setLoop: 3 setCycle: End self)
			)
			(36
				(if (and (== global191 2200) (IsFlag 7) (IsFlag 6))
					(SetScore 6)
				)
				(gEgo setLoop: 4 setCycle: Fwd)
				(= seconds 2)
			)
			(37
				(gEgo setLoop: 6 setMotion: MoveTo 210 63 setCycle: End self)
			)
			(38
				(gEgo setLoop: 7 setMotion: MoveTo 210 50 setCycle: End self)
			)
			(39
				(HandsOn)
				(gEgo hide: setLoop: -1)
				(gCurRoom newRoom: 63)
			)
			(40
				(= global189 13)
				(local13
					posn: 50 78
					view: 22
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo 100 78 self
				)
			)
			(41
				(= global184 1)
				(Print 60 15) ; "There you are, Sonny! I've found the body. Come with me."
				(local13 setMotion: MoveTo -30 90)
			)
			(42
				(= global192 1)
				(HandsOff)
				(gEgo
					illegalBits: 0
					ignoreActors:
					setMotion:
						MoveTo
						180
						(if (< (gEgo y:) 112)
							112
						else
							(gEgo y:)
						)
						self
				)
			)
			(43
				(if global184
					(Print 60 16) ; "After recovering the body of the jailer, you hurry to change back into street clothes."
				else
					(Print 60 17) ; "Exhausted and frustrated, you hurry to change back into your street clothes."
				)
				(gEgo setMotion: MoveTo 180 188 self)
			)
			(44
				(gEgo setMotion: MoveTo 288 188 self)
			)
			(45
				(gEgo
					setLoop: 3
					setMotion: MoveTo 285 188 self
					ignoreActors:
					illegalBits: 0
				)
			)
			(46
				(vanDoor setMotion: MoveTo 270 175 self)
			)
			(47
				(gEgo setMotion: MoveTo 289 182 self)
			)
			(48
				(gEgo hide:)
				(vanDoor setMotion: MoveTo 290 175 self)
			)
			(49
				(Print 60 18) ; "Back in the van, you change your clothes, and pick up all your things."
				(for ((= local0 0)) (<= local0 37) ((++ local0))
					(if (IsItemAt local0 66)
						(gEgo get: local0)
					)
				)
				(= seconds 6)
			)
			(50
				(gEgo setLoop: -1)
				(vanDoor setMotion: MoveTo 270 175 self)
			)
			(51
				(gEgo
					view: 0
					posn: 289 184
					loop: 5
					cel: 1
					show:
					setMotion: MoveTo 289 188 self
					illegalBits: $8000
					ignoreActors:
				)
			)
			(52
				(HandsOn)
				(vanDoor setMotion: MoveTo 290 175 self)
			)
			(53
				(vanDoor addToPic:)
				(if (not global184)
					(self changeState: 40)
				)
			)
		)
	)
)

(instance rm60 of Rm
	(properties
		picture 60
		style 7
	)

	(method (doit)
		(cond
			((> local16 1)
				(-- local16)
			)
			((== local16 1)
				(= local16 0)
				(switch (diverScript state:)
					(3
						(diverScript changeState: 4)
					)
					(4
						(diverScript changeState: 5)
					)
				)
			)
		)
		(if (and local15 (gEgo has: 7) (IsFlag 33)) ; wallet
			(= local15 0)
			(diverScript changeState: 6)
		)
		(super doit:)
	)

	(method (dispose)
		(diverScript dispose:)
		(bainsScript dispose:)
		(super dispose:)
	)

	(method (init)
		(super init:)
		(self setLocales: 153 155)
		(Load rsVIEW 0)
		(Load rsVIEW 4)
		(Load rsVIEW 6)
		(Load rsVIEW 20)
		(Load rsVIEW 90)
		(if (and (not global183) (== global111 3))
			(Load rsVIEW 53)
			(Load rsVIEW 97)
			(Load rsVIEW 14)
			(Load rsVIEW 15)
			(Load rsVIEW 76)
			(Load rsSOUND 33)
			(Load rsSOUND 41)
			(Load rsSOUND 41)
			(Load rsSOUND 39)
		)
		(Load rsVIEW 154)
		(Load rsVIEW 22)
		(Load rsVIEW 98)
		(Load rsVIEW 17)
		(Load rsVIEW 21)
		((= local13 (Act new:)) view: 21 posn: -100 0 init: stopUpd:)
		(= global211 (!= global100 5))
		(if (and (not global183) (== global111 3))
			(= global212 0)
		else
			(= global212 2)
		)
		(if (< global111 3)
			(= global189 0)
		)
		(NormalEgo)
		(gEgo illegalBits: $c000 init:)
		((= global112 (Act new:)) view: 20 posn: 1000 1000 init: stopUpd:)
		(if (> global189 2)
			(= global187 0)
		)
		((= local3 (Prop new:))
			view: 90
			posn: 74 97
			cel: (if (== global208 1) 4 else 0)
			ignoreActors:
			setPri: -1
			init:
			stopUpd:
		)
		((= local4 (Prop new:))
			view: 90
			posn: 60 131
			cel: (if (== global208 2) 4 else 0)
			ignoreActors:
			setPri: -1
			init:
			stopUpd:
		)
		((= local5 (Prop new:))
			view: 90
			posn: 10 165
			cel: (if (== global208 3) 4 else 0)
			ignoreActors:
			setPri: -1
			init:
			stopUpd:
		)
		(switch gPrevRoomNum
			(66
				(gEgo hide:)
			)
			(61
				(if (not global183)
					(bainsMusic number: 38 loop: -1 play:)
				)
				(gEgo
					posn: 300 (gEgo y:)
					setMotion: MoveTo -10 (gEgo y:)
				)
				(User prevDir: 7)
				(if (and (== global131 13) (== global189 0))
					(global112
						view: 20
						posn: (+ (gEgo x:) 90) (gEgo y:)
						setAvoider: Avoid
						setMotion: Follow gEgo 87
						setCycle: Walk
					)
				)
				(if (and (not global183) (== global111 3))
					(bains
						view: 15
						loop: 0
						cel: 2
						posn: -12 124
						setStep: 12 2
						illegalBits: 0
						setScript: bainsScript
						init:
					)
				)
			)
			(62
				(gEgo
					posn: 20 (gEgo y:)
					setMotion: MoveTo 350 (gEgo y:)
				)
				(User prevDir: 3)
				(if (== global131 13)
					(cond
						(global187
							(if (not global186)
								(SetFlag 55)
							)
							(if (not (IsFlag 55))
								(SetFlag 55)
								(= global189 1)
								(global112
									view: 20
									posn: 138 102
									setCycle: Walk
									setMotion: MoveTo 360 150
								)
								(Print 60 19) ; "You have NEVER seen Keith move this fast!"
							)
						)
						((== global189 0)
							(global112
								view: (if global188 53 else 20)
								posn: 181 115
								setCycle: Walk
								setAvoider: Avoid
								setMotion: Follow gEgo 60
							)
						)
					)
				)
			)
		)
		(self setScript: rm60Script)
	)
)

(instance rm60Script of Script
	(properties)

	(method (doit)
		(cond
			(local18 0)
			((> (gEgo y:) 205)
				(switch (Random 0 2)
					(0
						(Print 60 20) ; "It's a long walk to anywhere, Sonny."
					)
					(1
						(Print 60 21) ; "Even the squirrels around here know not to go into the street."
					)
					(2
						(Print 60 22) ; "A bag lady across the street gives you a dirty look, then hurries on her way."
					)
				)
				(gEgo setMotion: MoveTo (gEgo x:) 176)
			)
			((== (gEgo edgeHit:) EDGE_RIGHT)
				(gContinuousMusic fade:)
				(gCurRoom newRoom: 61)
			)
			((== (gEgo edgeHit:) EDGE_LEFT)
				(gCurRoom newRoom: 62)
			)
			((and (== global189 8) (gEgo inRect: 282 175 299 184))
				(diverScript changeState: 22)
			)
			((== global189 12)
				(diverScript changeState: 40)
			)
			(
				(and
					(>= (gEgo x:) 10)
					(== (gEgo view:) 17)
					(== gPrevRoomNum 62)
					(not global192)
				)
				(diverScript changeState: 42)
			)
			(
				(and
					(not global183)
					(== global111 3)
					(not local6)
					(< (gEgo x:) 240)
				)
				(= global183 1)
				(if (== global131 13)
					(global112 view: 53 setMotion: MoveTo 181 112)
				)
				(bainsScript changeState: 1)
			)
			((and (== global189 3) (< (gEgo y:) 157) (> 257 (gEgo x:) 68))
				(= global189 4)
				(local13 setScript: diverScript)
			)
			(global188
				(global112 view: 53)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (and (>= global189 5) (>= global111 3))
					(local13
						view: (if (>= global189 8) 22 else 21)
						posn: (if (== global189 12) 150 else -100) 126
						setCycle: Walk
						setScript: diverScript
					)
				)
			)
			(1
				(gEgo setMotion: 148 (+ (gEgo y:) 4))
			)
		)
	)

	(method (handleEvent event &tmp temp0)
		(if (event claimed:)
			(return)
		)
		(switch (event type:)
			(evKEYBOARD
				(= temp0 (event message:))
				(if
					(and
						(== (gEgo view:) 17)
						(or (== temp0 KEY_F6) (== temp0 KEY_F8) (== temp0 KEY_F10))
					)
					(Print 60 23) ; "You didn't go scuba diving with your gun."
					(event claimed: 1)
				else
					(event claimed: 0)
				)
			)
			(evSAID
				(cond
					((Said 'check,look/air,gauge,equipment')
						(if (!= (gEgo view:) 17)
							(Print 60 24) ; "You don't have any scuba equipment."
						else
							(Print 60 25) ; "Your tank of air is exhausted, and so are you."
						)
					)
					((Said 'frisk/billfold')
						(event claimed: 0)
					)
					((Said 'show/badge,billfold')
						(if local15
							(Print 60 26) ; "Officer Moore wants to see your diving certificate. Not your badge."
						else
							(Print 60 27) ; "Who are you trying to impress?"
						)
					)
					((Said 'change[/cloth]')
						(Print 60 28) ; "Out here in public? That's illegal!"
					)
					(
						(and
							local15
							(Said 'find,get,show,frisk,look/card,certificate')
						)
						(Print 60 29) ; "You know you've seen it somewhere, but where?"
					)
					((Said 'talk/cop,man,diver,diver')
						(if
							(and
								(gCast contains: local13)
								(< (gEgo distanceTo: local13) 40)
							)
							(Print 60 30) ; "Officer Moore says, "Hi, Sonny.""
						else
							(Print 60 31) ; "He can't hear you."
						)
					)
					((Said 'apprehend,chase/bains')
						(if (and (== global111 3) global183 global188)
							(Print 60 32) ; "I wouldn't advise it, but it's up to you."
						else
							(Print 60 33) ; "That's a fine idea... but how?"
						)
					)
					((or (Said '/police,freeze') (Said 'freeze'))
						(if (and (== global111 3) global183 global188)
							(Print 60 34) ; ""HALT! POLICE!!" you shout."
						else
							(Print 60 35) ; "Who are you talking to?"
						)
					)
					((Said 'look,hit,get,talk/bains,suspect')
						(cond
							(local1
								(Print 60 36) ; "Bains' face is a mask of hatred."
							)
							((and (== global111 3) global183 global188)
								(Print 60 37) ; "Are you serious??? This man is trying to kill you!"
							)
							(else
								(Print 60 33) ; "That's a fine idea... but how?"
							)
						)
					)
					((Said 'look,read/heart,initials')
						(if (gEgo inRect: 0 114 60 145)
							(Print 60 38) ; "The memories return as you read, "M.W + S.B""
							(Print 60 39) ; "You carved those initials one night in high school. Marie wanted to watch the submarine races, but they were called off due to low tide."
						else
							(Print 60 40) ; "You can't read the initials from way over here."
						)
					)
					((or (Said 'open/door,van') (Said 'enter,(get<in)/van,bus'))
						(if (and (> global189 2) (>= global111 3))
							(if (== global189 8)
								(Print 60 41) ; "Just walk up to it."
							else
								(Print 60 42) ; "You have no reason to do that."
							)
						else
							(Print 60 43) ; "That's nowhere to be seen."
						)
					)
					((Said 'get,drive,rob/van,bus')
						(Print 60 44) ; "The van's not yours."
					)
					(
						(Said
							'find,get,frisk,look/clue,blood,mark,footprint,(print<feet)'
						)
						(Print 60 45) ; "You look, but can't find any evidence here."
					)
					((Said 'look>')
						(cond
							((Said '/diver,diver,cop,man')
								(cond
									(
										(and
											(gCast contains: local13)
											(local13 inRect: 0 0 320 190)
										)
										(Print 60 46) ; "Officer Moore is in top physical condition. He's an energetic and happy kind of guy."
									)
									((Said '/man')
										(event claimed: 0)
									)
									(else
										(Print 60 47) ; "He's not here."
									)
								)
							)
							((Said '/auto')
								(if local1
									(Print 60 48) ; "Bains has jumped into his getaway car, and is speeding off."
								else
									(Print 60 49) ; "There are no cars here."
								)
							)
							((Said '/plate')
								(cond
									(local1
										(Print 60 50) ; "All you can make out, as the car whizzes by you, is "C03"."
									)
									((and (>= global189 5) (== global100 5))
										(Print 60 51) ; "The van's license plate is of no interest to you."
									)
									(else
										(Print 60 52) ; "There are no license plates here."
									)
								)
							)
							((Said '/van,bus,pane,door')
								(if (and (> global189 2) (>= global111 3))
									(Print 60 53) ; "This is a 'Special Forces' van, used just for unusual circumstances."
								else
									(Print 60 43) ; "That's nowhere to be seen."
								)
							)
							((Said '<behind/tree')
								(Print 60 54) ; "You look, but find nothing behind the tree."
							)
							((Said '<below/bush')
								(Print 60 55) ; "You look, but find nothing under the bush."
							)
							((Said '/tree')
								(if (gEgo inRect: 0 117 62 147)
									(Print 60 56) ; "You look and see a heart, with initials, carved into the trunk of the tree."
								else
									(Print 60 57) ; "From this distance, it looks like any other oak tree."
								)
							)
							((Said '[<at,around][/(!*,cove,area)]')
								(Print 60 58) ; "This is Cotton Cove. It brings back many memories of your youth."
							)
						)
					)
					((Said '/clue')
						(Print 60 59) ; "You look all around, but find nothing."
					)
					((Said '/bullet')
						(Print 60 60) ; "You look, but don't see any expended shells."
					)
					(
						(or
							(Said 'answer,ask/[diver,man]')
							(Said '[answer,ask]/diver,man')
							(Said 'help,dive,swim,frisk,find')
							(Said '/swim,dive,help')
							(Said 'go,jump/lake,clearwater,water')
							(Said 'let//dive,swim,find,frisk,look,get')
							(Said 'let/look,frisk,find,dive,get,go')
						)
						(if (> global189 5)
							(if (< (gEgo distanceTo: local13) 40)
								(if (== global189 6)
									(diverScript changeState: 3)
								else
									(Print 60 33) ; "That's a fine idea... but how?"
								)
							else
								(Print 60 61) ; "Officer Moore can't hear you. You'd better get closer."
							)
						else
							(Print 60 62) ; "That's a fine idea. But how?"
						)
					)
				)
			)
		)
	)
)

(instance bainsScript of Script
	(properties)

	(method (doit)
		(super doit:)
		(cond
			((> local8 1)
				(-- local8)
			)
			((== local8 1)
				(self cue:)
			)
		)
		(if global205
			(if (== local10 0)
				(if local7
					(Print 60 63 #at -1 24) ; "Although shaking from surprise, confusion, and fear, you somehow manage to return fire!"
				)
				(if (and global183 (or (not global166) (!= global205 4)))
					(Print 60 64 #at -1 20) ; "Unfortunately, however, the flight of your bullet misses its target, and the killer continues his ambush!"
					(= local10 1)
				else
					(= local10 2)
					(= global208
						(cond
							((< (gEgo y:) 114) 1)
							((< (gEgo y:) 148) 2)
							(else 3)
						)
					)
					(self changeState: 4)
				)
			)
			(= global205 0)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(bains stopUpd:)
			)
			(1
				(bainsMusic number: 33 loop: 1 play:)
				(bains
					view: 14
					posn:
						-10
						(cond
							((> 135 (gEgo y:) 112) 119)
							((> (gEgo y:) 134)
								(- (gEgo y:) 8)
							)
							(else 100)
						)
					setCycle: Walk
					setMotion:
						MoveTo
						(cond
							((> 135 (gEgo y:) 112) 52)
							((> (gEgo y:) 134) 46)
							(else 82)
						)
						(cond
							((> 135 (gEgo y:) 112) 119)
							((> (gEgo y:) 134)
								(- (gEgo y:) 4)
							)
							(else 100)
						)
						self
				)
			)
			(2
				(bainsShot play:)
				(bains view: 15 loop: 0 cel: 0 cycleSpeed: 1 setCycle: End)
				(if (== (++ local7) 3)
					(HandsOff)
					(self changeState: 6)
				)
				(= local8 10)
			)
			(3
				(if (not local6)
					(self changeState: 2)
				else
					(= local8 0)
				)
			)
			(4
				(= local6 1)
				(= global186 1200)
				(= global188 1)
				(bains
					view: 14
					loop: 1
					cel: 2
					setCycle: Walk
					setMotion: MoveTo -25 (bains y:)
				)
				(if (== (gEgo view:) 97)
					(self changeState: 8)
				else
					(switch global208
						(1
							(local3 setCycle: End self startUpd:)
						)
						(2
							(local4 setCycle: End self startUpd:)
						)
						(3
							(local5 setCycle: End self startUpd:)
						)
					)
				)
			)
			(5
				(local3 addToPic:)
				(local4 addToPic:)
				(local5 addToPic:)
				(SetFlag 125)
				(cond
					(local7
						(Print 60 65 #at -1 20) ; "Although the flight of your bullet misses its target, it comes close enough to cause the suspect to take leg bail."
					)
					(global183
						(Print 60 66) ; "As Bains comes running towards you, you notice the gun in his hand, analyze the situation quickly, and take action. Although your bullet misses its mark, it comes close enough for the suspect to take leg bail."
					)
					(else
						(EgoDead 60 67) ; "Your nerves on edge, you fired wildly into the bushes. Was it Bains, or a little boy playing? Without knowing, you should not have discharged your weapon. Next time, be sure you are in danger before firing."
					)
				)
				(SetScore 4)
				(bains setScript: carScript)
			)
			(6
				(gEgo
					view: 97
					loop:
						(switch (gEgo loop:)
							(0 4)
							(3 4)
							(1 3)
							(2 3)
						)
					cel: 0
					cycleSpeed: 1
					init:
					setCycle: End self
					setMotion: 0
				)
			)
			(7
				(Print 60 68 #at -1 20) ; "Just before taking a hot round in the chest, you hear Bains yell... "This one's for you, PIG!!!""
				(self changeState: 4)
			)
			(8
				(= seconds 2)
			)
			(9
				(switch local10
					(1
						(EgoDead 60 69) ; "Too bad, so sad, you've been had. But wait! All is not lost. Just restore your game and begin again. Next time though, make sure your gun is properly sighted in and pointed in the right direction."
					)
					(else
						(EgoDead 60 70) ; "Too bad, so sad, you've been had. But wait! All is not lost. Just restore your game and begin again. Next time though, you might try returning gun fire before it's too late."
					)
				)
			)
		)
	)
)

(instance carScript of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and global188 global183)
			(++ local9)
		)
		(if (and global188 (> local9 120))
			(carScript changeState: 1)
		)
		(if
			(and
				(< 10 (- (gEgo x:) (local11 x:)) 64)
				(> 14 (- (local11 y:) (gEgo y:)))
				(> (local11 x:) -64)
				(< (self state:) 5)
			)
			(self changeState: 5)
		)
		(local12 posn: (- (local11 x:) 48) (+ (local11 y:) 6))
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((= local11 (Act new:))
					view: 94
					setStep: 18 10
					setLoop: 1
					setCel: 0
					posn: -66 160
					init:
					illegalBits: 0
					ignoreActors:
					stopUpd:
				)
				((= local12 (Prop new:))
					view: 94
					loop: 2
					cel: 0
					init:
					ignoreActors:
					stopUpd:
				)
			)
			(1
				(carSound number: 39 loop: 1 priority: 12 play:)
				(= local1 1)
				(global112 setMotion: Follow local11 500)
				(= global188 0)
				(local11
					setMotion:
						MoveTo
						(gEgo x:)
						(if (> (gEgo y:) 140)
							(gEgo y:)
						else
							140
						)
						self
					startUpd:
				)
				(local12 setCycle: Fwd startUpd:)
			)
			(2
				(local11
					setMotion:
						MoveTo
						430
						(if (> (gEgo y:) 120)
							(+ (gEgo y:) 35)
						else
							140
						)
						self
				)
			)
			(3
				(if (== global131 13)
					(Print 60 71) ; ""That was BAINS!" shouts Keith."
					(global112 setMotion: MoveTo 187 118 self)
					(= global212 2)
				)
			)
			(4
				(= local1 0)
			)
			(5
				(local11
					setMotion:
						MoveTo
						430
						(if (> (gEgo y:) 120)
							(+ (gEgo y:) 28)
						else
							140
						)
				)
				(if (== global131 13)
					(global112
						illegalBits: $8000
						ignoreActors: 0
						setMotion: Follow gEgo 20
						startUpd:
					)
				)
				((= local2 (Act new:))
					view: 76
					posn: (gEgo x:) (gEgo y:)
					loop: 5
					cel: 0
					setMotion: 0
					cycleSpeed: 2
					init:
					setCycle: End self
				)
				(gEgo dispose:)
				(= local18 1)
			)
			(6
				(HandsOff)
				(local2
					setLoop: 6
					cel: 0
					setMotion: MoveTo (+ (local2 x:) 20) (local2 y:)
					setCycle: End self
				)
			)
			(7
				(local2 setLoop: 7 setCel: 0 stopUpd: addToPic:)
				(= seconds 2)
			)
			(8
				(if (== global131 13)
					(global112 loop: 1)
					(Print 60 72 #draw) ; "Gee, Sonny, did YOU see THAT?!" gasps Keith. "Sonny. Sonny? SONNY!?"
				)
				(= seconds 4)
			)
			(9
				(if (== global131 13)
					(EgoDead 60 73) ; "Don't worry; Keith will explain in his report how he heroically 'watched your back'."
				)
			)
		)
	)
)

