;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 101)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm101 0
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
)

(procedure (localproc_0)
	(Print &rest #at -1 24)
)

(instance rm101 of Rm
	(properties
		picture 101
		style 0
	)

	(method (dispose)
		(toTheParkScript dispose:)
		(super dispose:)
	)

	(method (init)
		(HandsOn)
		(User canInput: 1 canControl: 1)
		(= global212 3)
		(= global211 1)
		(Load rsVIEW 272)
		(Load rsVIEW 20)
		(Load rsVIEW 45)
		(super init:)
		((View new:)
			view: 272
			posn: 227 139
			loop: 0
			cel: 1
			setPri: 10
			init:
			ignoreActors:
			addToPic:
		)
		((View new:)
			view: 272
			posn: 205 142
			loop: 0
			cel: 0
			setPri: 10
			init:
			ignoreActors:
			addToPic:
		)
		((View new:)
			view: 272
			posn: 74 129
			loop: 1
			cel: 1
			setPri: 9
			init:
			ignoreActors:
			addToPic:
		)
		((View new:)
			view: 272
			posn: 103 129
			loop: 1
			cel: 0
			setPri: 9
			init:
			ignoreActors:
			addToPic:
		)
		((View new:)
			view: 272
			posn: 50 145
			loop: 1
			cel: 0
			setPri: 11
			init:
			ignoreActors:
			addToPic:
		)
		((View new:)
			view: 272
			posn: 73 94
			setPri: 0
			loop: 2
			cel: 2
			init:
			ignoreActors:
			addToPic:
		)
		((View new:)
			view: 272
			posn: 272 113
			setPri: 0
			loop: 2
			cel: 3
			init:
			ignoreActors:
			addToPic:
		)
		((View new:)
			view: 272
			posn: 51 131
			setPri: 1
			loop: 3
			cel: 1
			init:
			ignoreActors:
			addToPic:
		)
		((View new:)
			view: 272
			posn: 72 146
			setPri: 15
			loop: 3
			cel: 0
			init:
			ignoreActors:
			addToPic:
		)
		((View new:)
			view: 272
			posn: 48 92
			setPri: 0
			loop: 2
			cel: 4
			init:
			ignoreActors:
			addToPic:
		)
		((View new:)
			view: 272
			posn: 33 92
			setPri: 0
			loop: 2
			cel: 5
			init:
			ignoreActors:
			addToPic:
		)
		((View new:)
			view: 272
			posn: 34 108
			setPri: 0
			loop: 2
			cel: 6
			init:
			ignoreActors:
			addToPic:
		)
		((View new:)
			view: 272
			posn: 133 146
			setPri: 15
			loop: 2
			cel: 0
			init:
			ignoreActors:
			addToPic:
		)
		((View new:)
			view: 272
			posn: 219 94
			setPri: 0
			loop: 2
			cel: 7
			init:
			ignoreActors:
			addToPic:
		)
		((View new:)
			view: 272
			posn: 117 96
			setPri: 0
			loop: 2
			cel: 7
			init:
			ignoreActors:
			addToPic:
		)
		((View new:)
			view: 272
			posn: 131 89
			setPri: 0
			loop: 2
			cel: 4
			init:
			ignoreActors:
			addToPic:
		)
		((View new:)
			view: 272
			posn: 218 109
			setPri: 0
			loop: 2
			cel: 5
			init:
			ignoreActors:
			addToPic:
		)
		((View new:)
			view: 272
			posn: 20 179
			setPri: 0
			loop: 2
			cel: 5
			init:
			ignoreActors:
			addToPic:
		)
		((= local1 (Prop new:))
			view: 272
			posn: 137 124
			setPri: 15
			loop: 2
			cel: 1
			init:
			ignoreActors:
		)
		((= local2 (Prop new:))
			view: 272
			posn: 131 123
			setPri: 15
			loop: 2
			cel: 1
			init:
			ignoreActors:
		)
		((= local3 (Prop new:))
			view: 272
			posn: 148 137
			setPri: 6
			loop: 4
			cel: 0
			ignoreActors:
			init:
		)
		((= global112 (Act new:))
			view: 20
			posn: 10 135
			loop: 0
			setCycle: Walk
			setPri: 9
			setMotion: Follow gEgo 15
			init:
			illegalBits: $c000
		)
		((= local0 (Act new:))
			view: 45
			posn: 245 141
			setCycle: Walk
			init:
			stopUpd:
		)
		(NormalEgo)
		(gEgo
			view: 1
			posn: 20 137
			loop: 0
			setPri: 9
			setLoop: -1
			init:
			illegalBits: $c000
		)
		(self setScript: rm101Script)
	)

	(method (doit)
		(cond
			((> local15 1)
				(-- local15)
			)
			((== local15 1)
				(= local15 0)
				(tryAgain cue:)
			)
		)
		(if (and (gEgo inRect: 135 135 153 139) (not local13))
			(theDoor changeState: 1)
		)
		(if (and (not local13) (gEgo inRect: 110 129 130 139))
			(if (not local4)
				(gEgo illegalBits: 0)
				(global112 illegalBits: 0)
				(LtSpeech changeState: 0)
			else
				(tryAgain changeState: 1)
			)
		)
		(cond
			((and (< (gEgo x:) 20) local4 (not local5))
				(= local5 1)
				(gEgo illegalBits: $8000)
				(global112 illegalBits: $8000)
				(self setScript: toTheParkScript)
			)
			((and (< (gEgo x:) 20) (not local4) (not local14))
				(= local14 1)
				(localproc_0 101 0) ; "Keith says "Sonny, where are you going? Aren't we going to talk to the Lieutenant?""
			)
		)
		(if (and (> (gEgo x:) 20) local14)
			(= local14 0)
		)
		(super doit:)
	)
)

(instance rm101Script of Script
	(properties)

	(method (handleEvent event)
		(if (event claimed:)
			(return 1)
		)
		(if (== (event type:) evSAID)
			(cond
				((Said 'look>')
					(cond
						((Said '/wall')
							(localproc_0 101 1) ; "The walls are sheetrock, painted white. The room is really bright. There is a map of Steelton with pushpins sticking into it."
						)
						((Said '/pushpin,pin[<press]')
							(localproc_0 101 2) ; "You know...little plastic things with pointy tips."
						)
						((Said '/map')
							(localproc_0 101 3) ; "It's manufactured by the Lytton Map Co."
						)
						((or (Said '/ceiling') (Said '<up'))
							(localproc_0 101 4) ; "Lift-out acoustic ceiling tiles... what did you expect?"
						)
						((or (Said '/floor,dirt') (Said '<down'))
							(localproc_0 101 5) ; "The janitorial crew must be pretty good. The floor tile is highly polished."
						)
						((Said '/man')
							(if (< (gEgo x:) 137)
								(localproc_0 101 6) ; "The man looks like he is trying hastily to get something done."
							else
								(localproc_0 101 7) ; "The lieutenant looks like he earned the name "Wild Willy"."
							)
						)
						((Said '/lieutenant,willie,cole,miller')
							(if (< (gEgo x:) 137)
								(localproc_0 101 8) ; "He's in his office."
							else
								(localproc_0 101 7) ; "The lieutenant looks like he earned the name "Wild Willy"."
							)
						)
						((Said '/woman,woman')
							(if (< (gEgo x:) 137)
								(localproc_0 101 9) ; "The woman looks like she is busy reading some forms."
							else
								(localproc_0 101 10) ; "There are no women in here, unless Willy's got one hidden somewhere (it's possible!)."
							)
						)
						((Said '/extender')
							(if (> (gEgo x:) 137)
								(localproc_0 101 11) ; "They're two way walkie-talkies that could allow you to communicate with your partner, Keith."
							else
								(localproc_0 101 12) ; "There are no radios in the front office."
							)
						)
						((Said '/desk')
							(cond
								((> (gEgo x:) 137)
									(localproc_0 101 13) ; "It's relatively uncluttered when compared to Captain Hall's desk."
								)
								(
									(or
										(gEgo inRect: 60 133 80 139)
										(== (gEgo loop:) 2)
									)
									(localproc_0 101 14) ; "The woman's desk looks almost too neat and tidy."
								)
								(
									(or
										(gEgo inRect: 30 133 60 139)
										(== (gEgo loop:) 3)
									)
									(localproc_0 101 15) ; "The man's desk is covered with papers. There appear to be doodles all over them."
								)
							)
						)
						((Said '/table')
							(if (> (gEgo x:) 137)
								(localproc_0 101 16) ; "On the table, you see a pair of two-way radios."
							else
								(localproc_0 101 17) ; "There are no tables in here....just desks."
							)
						)
						((Said '[<at,around][/!*,chamber,office]')
							(localproc_0 101 18) ; "The offices here at Steelton PD are very similar to those back home in Lytton."
						)
						((Said '/file,cabinet')
							(if (> (gEgo x:) 137)
								(localproc_0 101 19) ; "It's the lieutenant's private file cabinet."
							else
								(localproc_0 101 20) ; "There are, of course, file cabinets in the outer office. They're uniformly gray and nondescript."
							)
						)
					)
				)
				((Said 'talk>')
					(cond
						((Said '/woman,woman')
							(cond
								(
									(and
										(not local4)
										(== local6 0)
										(< (gEgo x:) 137)
									)
									(localproc_0 101 21) ; "Hi! You must be Mr. Bonds and Mr. Robinson. The Lieutenant is waiting for you. Please go on in."
									(= local6 1)
								)
								(
									(and
										(not local4)
										(== local6 1)
										(< (gEgo x:) 137)
									)
									(localproc_0 101 22) ; "The Lieutenant is waiting for you, sir."
									(= local6 2)
								)
								((and (== local6 2) (< (gEgo x:) 137))
									(localproc_0 101 23) ; "Have a nice day sir."
								)
								((and local4 (< (gEgo x:) 137))
									(localproc_0 101 24) ; "How are you today, sir? I'm pleased to meet you, but if you don't mind, I have to get back to work."
								)
								(else
									(localproc_0 101 25) ; "Try talking to the Lieutenant."
								)
							)
						)
						((Said '/lieutenant,willie,cole,miller')
							(cond
								((< (gEgo x:) 137)
									(if (not local4)
										(localproc_0 101 22) ; "The Lieutenant is waiting for you, sir."
									else
										(localproc_0 101 26) ; "Officer Pitman is waiting for you."
									)
								)
								((not local9)
									(cond
										((not local8)
											(localproc_0 101 27) ; "Go on, boys. Catch that ride to the park."
											(= local8 1)
										)
										(local8
											(localproc_0 101 28) ; "C'mon, guys. I've told you all I know. I've got work to do now."
											(= local9 1)
										)
									)
								)
								(else
									(localproc_0 101 29) ; "Can't you take a hint? GET OUTTA HERE!!!!"
								)
							)
						)
						((Said '/man')
							(cond
								((< (gEgo x:) 137)
									(if (not local4)
										(cond
											((== local6 0)
												(localproc_0 101 24) ; "How are you today, sir? I'm pleased to meet you, but if you don't mind, I have to get back to work."
												(= local6 1)
											)
											((== local6 1)
												(localproc_0 101 22) ; "The Lieutenant is waiting for you, sir."
												(= local6 2)
											)
											((== local6 2)
												(localproc_0 101 23) ; "Have a nice day sir."
											)
										)
									else
										(localproc_0 101 26) ; "Officer Pitman is waiting for you."
									)
								)
								((not local9)
									(cond
										((not local8)
											(localproc_0 101 27) ; "Go on, boys. Catch that ride to the park."
											(= local8 1)
										)
										(local8
											(localproc_0 101 30) ; "C'mon, guys. I've told you all I know. I've got work to do, now."
											(= local9 1)
										)
									)
								)
								(else
									(localproc_0 101 29) ; "Can't you take a hint? GET OUTTA HERE!!!!"
								)
							)
						)
					)
				)
				((Said '/no')
					(localproc_0 101 31) ; "C'mon. Don't be negative!"
				)
				((Said 'yes')
					(localproc_0 101 32) ; "That's the spirit!"
				)
				((Said 'open/file,cabinet')
					(if (> (gEgo x:) 137)
						(localproc_0 101 33) ; "Nope! Only "Wild Willy" has rights to the file cabinet."
					else
						(localproc_0 101 34) ; "You don't need to go snooping around in someone else's files."
					)
				)
				((or (Said 'knock') (Said 'open/door'))
					(if (not local4)
						(Print 101 35) ; "You're not close enough."
					else
						(Print 101 36) ; "Its already open."
					)
				)
				((or (Said 'use,dial/phone,phone') (Said 'place,make/call'))
					(localproc_0 101 37) ; "Who ya gonna call...Crimebusters?"
				)
				((Said 'get,get/extender,walkie,talkie')
					(cond
						(
							(and
								(gEgo inRect: 130 135 160 150)
								(== (gEgo loop:) 2)
								(not (gEgo has: 30)) ; walkie_talkie
							)
							(if (not local11)
								(SetScore 3)
								(localproc_0 101 38 83) ; "You pick up the two-way radios, handing one of them to your partner, and the lieutenant says..."
								(local0 loop: 1)
								(localproc_0 101 39 83) ; "Oh yes, I set those radios out for you boys. I thought they might come in handy while you're looking around the park."
								(local0 loop: 0)
								(local1 dispose:)
								(local2 dispose:)
								(gEgo get: 30) ; walkie_talkie
							else
								(SetScore 3)
								(localproc_0 101 40 83) ; "You pick up the two-way radios from the table. They might come in handy while you and Keith are looking around the park."
								(local1 dispose:)
								(local2 dispose:)
								(gEgo get: 30) ; walkie_talkie
							)
						)
						((gEgo has: 30) ; walkie_talkie
							(localproc_0 101 41) ; "You already have it."
						)
						(else
							(localproc_0 101 35) ; "You're not close enough."
						)
					)
				)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 40 137 self)
			)
			(1
				(localproc_0 101 42 83) ; "Wow!" Keith says. "That sure was fun, wasn't it, Sonny?"
			)
		)
	)
)

(instance LtSpeech of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local13 1)
				(local0 loop: 1)
				(HandsOff)
				(self cue:)
			)
			(1
				(localproc_0 101 43 83) ; "The Lieutenant says "C'mon in....the door's open.""
				(local3 setCycle: End self)
			)
			(2
				(gEgo setMotion: MoveTo 180 139 self)
				(global112 setMotion: MoveTo 165 136 ignoreActors:)
			)
			(3
				(gEgo setLoop: 2 setCel: 1)
				(global112 setLoop: 2 setCel: 1 ignoreActors:)
				(self cue:)
			)
			(4
				(local0 setMotion: MoveTo 245 146 self)
			)
			(5
				(local0 setMotion: MoveTo 170 146 self)
			)
			(6
				(local0 setLoop: 3 setCel: 0)
				(localproc_0 101 44 83) ; "Wild Willy walks over, shakes your hand and says..."
				(localproc_0 101 45 83) ; "Detectives Bonds and Robinson: Welcome to Steelton!"
				(localproc_0 101 46 83) ; "Well! you dudes are chasing one fine, upstanding citizen." Continuing, he says..."It seems this punk Bains has already started his handiwork here, too."
				(localproc_0 101 47 83) ; ""You know the 'phone tap' subject Don Colby?" He asks. Without waiting for a reply, he goes on to say...."
				(localproc_0 101 48 83) ; "I hate to tell you boys this, but after putting a tap on Colby's phone, I sent an unmarked unit over to check on him, and..."
				(localproc_0 101 49 83) ; "My man found him deader than a doornail with a .32 cal hole in his head."
				(localproc_0 101 50 83) ; "We did manage to connect", Willy tells you, "on one threatening call from Bains. I don't think it will help but..."
				(localproc_0 101 51 83) ; ""The call was traced to a pay phone in our local 'Burt Park.'"
				(localproc_0 101 52 83) ; "I sent a man over there to have a look around," he says, "but nothing was found."
				(localproc_0 101 53 83) ; "You boys will probably want to go over there and look around." Willy grunts.."But I think you'll be spinning your wheels."
				(localproc_0 101 54 83) ; "Wild Willy says..."I think Officer Pitman is waiting in the hall. He can drive you over to the park.""
				(localproc_0 101 55 83) ; "Good luck, boys!"
				(= local4 1)
				(self cue:)
			)
			(7
				(= local13 0)
				(local0 setLoop: -1 setCel: -1)
				(gEgo setPri: -1 setLoop: -1 setCel: -1 illegalBits: $e000)
				(global112 setPri: -1 setLoop: 2 setCel: -1 illegalBits: $c000)
				(HandsOn)
				(local0 setMotion: MoveTo 265 146 self)
			)
			(8
				(local0 stopUpd:)
			)
		)
	)
)

(instance tryAgain of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(= local13 1)
				(HandsOff)
				(global112 stopUpd:)
				(localproc_0 101 56) ; "Keith says, "Did you forget something, Sonny? I'll wait here for you.""
				(self cue:)
			)
			(2
				(gEgo
					setPri: 9
					illegalBits: 0
					setMotion: MoveTo 180 138 self
				)
			)
			(3
				(self cue:)
			)
			(4
				(local0 setLoop: 1)
				(if (gEgo has: 30) ; walkie_talkie
					(localproc_0 101 57) ; "The Lieutenant says "What's up, Bonds...did you forget something?""
				else
					(localproc_0 101 58 83) ; "Wild Willy says, "Oh, yeah, Bonds! Forgot the radios, didn't you? Go ahead and grab 'em. I've got some map work to do.""
				)
				(gEgo illegalBits: $c000 setLoop: -1 setCel: -1 setPri: -1)
				(HandsOn)
				(= local10 0)
				(= local13 0)
				(= local11 1)
				(= local15 20)
			)
			(5
				(local0 setLoop: 0)
			)
		)
	)
)

(instance theDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(HandsOff)
				(= local13 1)
				(if local11
					(gEgo
						setPri: 9
						illegalBits: 0
						setMotion: MoveTo 109 136 self
					)
				else
					(gEgo setPri: 9 illegalBits: 0 setMotion: MoveTo 109 136)
					(global112
						setPri: 9
						setLoop: -1
						illegalBits: 0
						ignoreActors:
						setMotion: MoveTo 75 134 self
					)
				)
			)
			(2
				(gEgo setPri: -1 setLoop: -1 setCel: -1 illegalBits: $c000)
				(= local13 0)
				(HandsOn)
				(if (not local11)
					(global112
						illegalBits: $c000
						setMotion: Follow gEgo 20
						ignoreActors: 0
					)
				else
					(global112 startUpd:)
				)
			)
		)
	)
)

(instance toTheParkScript of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gCast eachElementDo: #dispose)
				(gCurRoom drawPic: 104 7)
				(= cycles 2)
			)
			(1
				(Display 101 59 dsFONT 0 dsWIDTH 290 dsCOORD 15 43 dsCOLOR 15) ; "You and Keith are driven to 'Burt Park' by Jarvis Pitman, a twenty-year veteran who looks ten years younger than his real age. He regales you with stories of his escapades as a young patrolman. By the time you reach the park, you are beginning to wish he had retired last year. Sure enough, Officer Pitman climbs out of the patrol car and heads into the park with you, talking all the way."
				(repeat
					(= temp0 (Event new: evMOUSEKEYBOARD))
					(breakif (& (temp0 type:) $0005))
					(temp0 dispose:)
				)
				(temp0 dispose:)
				(self cue:)
			)
			(2
				(gCurRoom newRoom: 78)
			)
		)
	)
)

