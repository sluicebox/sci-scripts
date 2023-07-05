;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2)
(include sci.sh)
(use Main)
(use Interface)
(use AutoDoor)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm2 0
)

(synonyms
	(man cop)
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
	(Print &rest #at -1 30)
)

(procedure (localproc_1)
	(if (gEgo has: 28) ; vial_of_blood
		(if (IsFlag 144)
			(ClearFlag 144)
			(localproc_2 28 146 2 87)
			(gEgo get: 28) ; vial_of_blood
		)
		(if (IsFlag 143)
			(ClearFlag 143)
			(localproc_2 28 147 2 88)
			(gEgo get: 28) ; vial_of_blood
		)
		(if (IsFlag 113)
			(ClearFlag 113)
			(localproc_2 28 148 2 89)
			(gEgo get: 28) ; vial_of_blood
		)
		(if (gEgo has: 28) ; vial_of_blood
			(PutItem 28) ; vial_of_blood
		)
	)
)

(procedure (localproc_2 param1 param2)
	(if (gEgo has: param1)
		(if local7
			(SetFlag 125)
		)
		(= local7 1)
		(switch param1
			(13
				(if (IsFlag 136)
					(= global100 13)
				)
			)
			(35
				(if (IsFlag 135)
					(= global100 13)
				)
			)
		)
		(SetScore 1)
		(SetFlag param2)
		(gEgo put: param1 2)
		(localproc_0 &rest)
		(return 1)
	else
		(return 0)
	)
)

(instance rm2 of Rm
	(properties
		picture 2
		style 8
	)

	(method (dispose)
		(bigJonScript dispose:)
		(mrGScript dispose:)
		(DisposeScript 301)
		(super dispose:)
	)

	(method (init)
		(super init:)
		(Load rsVIEW 1)
		(Load rsVIEW 0)
		(Load rsVIEW 56)
		(Load rsVIEW 57)
		(self setLocales: 153)
		(HandsOn)
		(= global212 3)
		((View new:)
			view: 56
			loop: 3
			cel: 0
			posn: 291 97
			setPri: 9
			init:
			addToPic:
		)
		((= local2 (AutoDoor new:))
			doorControl: 4096
			entranceTo: 6
			facingLoop: 3
			view: 56
			loop: 2
			posn: 246 103
			setPri: 6
			init:
			stopUpd:
		)
		((= local5 (AutoDoor new:))
			doorControl: 8192
			entranceTo: 4
			facingLoop: 1
			view: 56
			loop: 0
			posn: 77 113
			setPri: 6
			init:
			stopUpd:
		)
		((= local3 (AutoDoor new:))
			doorControl: 2048
			entranceTo: 5
			facingLoop: 3
			view: 56
			loop: 2
			posn: 122 105
			setPri: 2
			init:
			stopUpd:
		)
		((= local4 (AutoDoor new:))
			doorControl: 16384
			entranceTo: 3
			facingLoop: 1
			view: 56
			loop: 1
			posn: 46 121
			setPri: 7
			init:
			stopUpd:
		)
		((= local0 (Act new:))
			view: 57
			illegalBits: 0
			posn: 212 93
			setPri: 5
			setCycle: Walk
			cycleSpeed: 2
			init:
			setScript: bigJonScript
		)
		(if
			(and
				(< global100 6)
				(or
					(and (== gPrevRoomNum 1) (IsFlag 10))
					(and (!= gPrevRoomNum 1) (== (Random 0 2) 1))
				)
			)
			(SetFlag 10)
			((= local1 (Act new:))
				view: 48
				posn: 191 109
				loop: 3
				cel: 4
				setCycle: Walk
				setMotion: 0
				init:
				stopUpd:
				setScript: mrGScript
			)
			(local0 posn: 182 93 loop: 2)
			(bigJonScript changeState: 1)
		else
			(ClearFlag 10)
		)
		(self setScript: rm2Script)
	)
)

(instance rm2Script of Script
	(properties)

	(method (doit)
		(cond
			((== (local2 doorState:) 2)
				(gEgo heading: 0 setMotion: MoveTo 180 10)
				(gCurRoom newRoom: 6)
			)
			((== (local5 doorState:) 2)
				(gEgo heading: 0 setMotion: MoveTo 180 10)
				(gCurRoom newRoom: 4)
			)
			((== (local3 doorState:) 2)
				(gEgo heading: 0 setMotion: MoveTo 180 10)
				(gCurRoom newRoom: 5)
			)
			((== (local4 doorState:) 2)
				(gEgo heading: 0 setMotion: MoveTo 180 10)
				(gCurRoom newRoom: 3)
			)
			((>= (gEgo y:) 165)
				(= global160 1)
				(gCurRoom newRoom: 1)
			)
			((gEgo inRect: 272 106 290 125)
				(gCurRoom newRoom: 10)
			)
			((<= (gEgo y:) 126)
				(if (!= (mod (gEgo view:) 2) 0)
					(gEgo view: (- (gEgo view:) 1))
				)
			)
			((!= (mod (gEgo view:) 2) 1)
				(gEgo view: (+ (gEgo view:) 1))
			)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo view: (if (not global204) 1 else 7) init:)
				(switch gPrevRoomNum
					(3
						(gEgo
							posn: 63 117
							heading: 90
							setMotion: MoveTo 400 117
						)
						(User prevDir: 3)
					)
					(4
						(gEgo
							view: (if (not global204) 0 else 6)
							posn: 87 111
							heading: 90
							setMotion: MoveTo 400 111
						)
						(User prevDir: 3)
					)
					(5
						(gEgo
							view: (if (not global204) 0 else 6)
							posn: 120 114
							heading: 180
							setMotion: MoveTo 120 300
						)
						(User prevDir: 5)
					)
					(6
						(gEgo
							posn: 246 111
							heading: 180
							setMotion: MoveTo 246 300
						)
						(User prevDir: 5)
					)
					(10
						(gEgo
							view: (if (not global204) 0 else 6)
							posn: 270 112
							heading: 270
							setMotion: MoveTo 0 112
						)
						(User prevDir: 7)
					)
					(1
						(gEgo
							posn: 162 162
							heading: 180
							setMotion: MoveTo 162 10
						)
						(User prevDir: 1)
					)
					(else
						(gEgo posn: 160 140 setMotion: 0)
					)
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
							((Said '<in/bin,locker')
								(cond
									((not (gEgo inRect: 250 105 280 122))
										(proc0_7) ; "You're not close enough."
									)
									((not (IsFlag 11))
										(Print 2 0) ; "It's closed."
									)
									((IsItemAt 10) ; field_kit
										(Print 2 1) ; "Your bin has a field kit in it."
									)
									(else
										(Print 2 2) ; "Your bin is empty."
									)
								)
							)
							((Said '/door')
								(cond
									(
										(and
											(gEgo inRect: 110 108 142 155)
											(== (gEgo loop:) 3)
										)
										(Print 2 3) ; "This is the Locker room door."
									)
									(
										(or
											(and
												(gEgo inRect: 42 117 200 130)
												(== (gEgo loop:) 1)
											)
											(and
												(gEgo inRect: 30 0 65 200)
												(== (gEgo loop:) 3)
											)
										)
										(Print 2 4) ; "This is the Narcotics office door."
									)
									(
										(or
											(and
												(gEgo inRect: 70 108 200 118)
												(== (gEgo loop:) 1)
											)
											(and
												(gEgo inRect: 64 0 90 200)
												(== (gEgo loop:) 3)
											)
										)
										(Print 2 5) ; "This is the Homicide office door."
									)
									(
										(and
											(gEgo inRect: 223 105 280 130)
											(== (gEgo loop:) 3)
										)
										(Print 2 6) ; "This is the Burglary office door."
									)
									(else
										(Print 2 7) ; "You are not near and/or facing a door."
									)
								)
							)
							((Said '/counter,bin,locker')
								(cond
									((gEgo inRect: 250 105 280 122)
										(Print 2 8) ; "Built into the back of the counter are locked storage bins. One of them has your name on it."
									)
									((< (gEgo x:) 172)
										(Print 2 9) ; "You're too far away to see any details."
									)
									((> (gEgo y:) 122)
										(Print 2 10) ; "The counter once held a nice coffee maker until it took the full impact of an accidentally discharged Colt 45 automatic."
									)
									(else
										(Print 2 8) ; "Built into the back of the counter are locked storage bins. One of them has your name on it."
									)
								)
							)
							(
								(and
									(gCast contains: local1)
									(Said '/gelepsi,man')
								)
								(Print 2 11) ; "You watch as Traffic Officer Mario Gelepsi books evidence."
							)
							((Said 'look/man,john')
								(if
									(and
										(not (gCast contains: local1))
										(<= (bigJonScript state:) 1)
									)
									(Print 2 12) ; "He is not here."
								else
									(Print 2 13) ; "Big John is a small, middle-aged man who is content with his job. You have no idea why his name is BIG John."
								)
							)
							((Said '/pane')
								(Print 2 14) ; "All property and evidence going through this window is controlled by John B. Willis, otherwise known as "Big John"."
							)
							((Said '/wall')
								(Print 2 15) ; "You see two pictures on the wall."
							)
							((Said '/painting')
								(Print 2 16) ; "One is of former Police Chief Whipplestick, and the other of current Police Chief Eric 'Click' Heitman."
							)
							((Said '[<around,at][/(!*,chamber,hall)]')
								(Print 2 17) ; "You are in Lytton's newly remodeled police station. This is the hall. There are several doors, a counter, and an evidence window."
							)
						)
					)
					((Said 'unlock/door')
						(Print 2 18) ; "The doors aren't locked."
					)
					((Said 'close/door')
						(Print 2 19) ; "You don't need to."
					)
					((Said 'open,unlock/bin,locker')
						(cond
							((not (gEgo inRect: 250 105 280 122))
								(proc0_7) ; "You're not close enough."
							)
							((IsFlag 11)
								(Print 2 20) ; "It's already open."
							)
							((not (gEgo has: 2)) ; key_ring
								(Print 2 21) ; "You don't have the key."
							)
							((IsItemAt 10) ; field_kit
								(SetFlag 11)
								(Print 2 22) ; "You unlock and open the bin. You see your field kit."
							)
							(else
								(SetFlag 11)
								(Print 2 23) ; "You unlock and open the bin. It's empty."
							)
						)
					)
					((Said 'close,lock/bin,locker')
						(cond
							((not (gEgo inRect: 250 105 280 122))
								(proc0_7) ; "You're not close enough."
							)
							((not (IsFlag 11))
								(Print 2 24) ; "It's already locked."
							)
							((gEgo has: 2) ; key_ring
								(Print 2 25) ; "You close and lock the storage bin."
								(ClearFlag 11)
							)
							(else
								(Print 2 21) ; "You don't have the key."
							)
						)
					)
					((Said 'get/briefcase')
						(cond
							((not (gEgo inRect: 250 105 280 122))
								(proc0_7) ; "You're not close enough."
							)
							((not (IsFlag 11))
								(Print 2 26) ; "The bin isn't open."
							)
							((gEgo has: 10) ; field_kit
								(proc0_8) ; "You already took it."
							)
							((not (IsItemAt 10)) ; field_kit
								(Print 2 27) ; "The field kit isn't here."
							)
							(else
								(Print 2 28) ; "You remove the field kit from the storage bin."
								(gEgo get: 10) ; field_kit
								(SetScore 2 63)
							)
						)
					)
					((Said 'drop/briefcase')
						(cond
							((not (gEgo inRect: 250 105 280 122))
								(event claimed: 1)
								(proc0_7) ; "You're not close enough."
							)
							((not (IsFlag 11))
								(event claimed: 1)
								(Print 2 26) ; "The bin isn't open."
							)
							((gEgo has: 10) ; field_kit
								(Print 2 29) ; "You place the field kit into the storage bin."
								(if (IsObject gFKit)
									(gFKit dispose:)
								)
								(PutItem 10) ; field_kit
							)
							(else
								(Print 2 30) ; "You don't have it."
							)
						)
					)
				)
			)
		)
	)
)

(instance bigJonScript of Script
	(properties)

	(method (doit)
		(cond
			((IsFlag 10) 0)
			((gEgo inRect: 165 105 200 112)
				(if (< state 2)
					(self changeState: 2)
				)
			)
			((> state 1)
				(self changeState: 0)
			)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local6 0)
				(local0 setLoop: -1 setCel: -1 setMotion: MoveTo 218 93 self)
			)
			(1
				(local0 stopUpd:)
			)
			(2
				(= seconds (Random 1 4))
			)
			(3
				(local0 setMotion: MoveTo 182 93 self)
			)
			(4
				(local0 setLoop: 2 setCel: 0)
				(RedrawCast)
				(cond
					((gCast contains: local1)
						(localproc_0 2 31) ; "Wait your turn, Bonds."
					)
					((or (<= global100 1) local8)
						(switch (Random 0 3)
							(0
								(localproc_0 2 32 25 10) ; "Big John says, "What can I do for you today?""
							)
							(1
								(localproc_0 2 33 25 10) ; "Hello, Sonny!" big John says. "How can I help you?"
							)
							(2
								(localproc_0 2 34 25 10) ; ""Can I be of assistance to you?" bellows big John."
							)
							(3
								(localproc_0 2 35 25 10) ; "Big John says, "Can I help you, Sonny?""
							)
						)
						(= local6 1)
					)
					(else
						(= local8 1)
						(switch (Random 0 3)
							(0
								(localproc_0 2 36) ; "Big John says, "I hear Bains has escaped. I wonder where he'll go.""
								(= local6 0)
							)
							(1
								(localproc_0 2 37) ; "Hey, Sonny, are you scared of meeting Bains?"
								(= local6 5)
							)
							(2
								(localproc_0 2 38) ; "Have you made any progress on the Bains case?"
								(= local6 6)
							)
						)
					)
				)
			)
			(5
				(localproc_0 2 39 25 10) ; ""What do you have to book?" Big John asks."
				(= local6 2)
			)
			(6
				(localproc_0 2 40 25 10) ; "Big John asks impatiently, "Hey, Sonny. Do you have something to book?""
				(= local6 3)
			)
			(7
				(localproc_0 2 41 25 10) ; "Big John shouts, "Come on, Bonds! I'm busy. Do you have evidence to book or not?!""
				(= local6 3)
			)
			(8
				(localproc_0 2 42 25 10) ; "In an impatient tone of voice, big John grunts..."
				(localproc_0 2 43 25 10) ; "Sonny! I don't have time to stand here and shoot the breeze with you. I have a lot of work to do, so please excuse me."
				(= local6 0)
				(= seconds 2)
			)
			(9
				(= local7 0)
				(localproc_2 31 127 2 44)
				(localproc_2 22 128 2 45)
				(localproc_2 19 129 2 46)
				(localproc_2 14 130 2 47)
				(localproc_2 17 132 2 48)
				(localproc_2 20 133 2 49)
				(localproc_2 21 145 2 50)
				(localproc_2 26 134 2 51)
				(localproc_2 18 139 2 52)
				(localproc_2 13 135 2 53)
				(localproc_2 35 136 2 54)
				(localproc_2 25 137 2 55)
				(localproc_2 24 138 2 56)
				(localproc_1)
				(if local7
					(switch (Random 0 2)
						(0
							(localproc_0 2 57) ; "Big John says, "You seem to be making progress.""
						)
						(1
							(localproc_0 2 58) ; ""I hope you nail Bains soon," says Big John."
						)
						(2
							(localproc_0 2 59) ; ""My, my, we've been BUSY, haven't we?" Big John says, smiling."
						)
					)
				else
					(localproc_0 2 60) ; "It doesn't seem you have any evidence to book right now."
				)
			)
		)
	)

	(method (handleEvent event &tmp temp0)
		(if (or (event claimed:) (!= (event type:) evSAID))
			(return)
		)
		(cond
			((Said 'give,book,(turn<in),submit>')
				(= local7 0)
				(cond
					((gCast contains: local1)
						(event claimed: 1)
						(localproc_0 2 31) ; "Wait your turn, Bonds."
					)
					((< state 4)
						(event claimed: 1)
						(Print 2 61) ; "Wait until he's at the window."
					)
					((Said '/!*')
						(Print 2 62) ; "Book what?"
					)
					((Said '/clue')
						(localproc_0 2 63) ; "OK," says John, "What do you have?"
						(self changeState: 9)
					)
					((and (gEgo has: 31) (Said '/9mm')) ; jailer_s_revolver
						(localproc_2 31 127 2 44)
					)
					((and (gEgo has: 35) (Said '/card[<business]')) ; Colby_s_business_card
						(localproc_2 35 136 2 54)
					)
					((not (= temp0 (gInventory saidMe: event)))
						(event claimed: 1)
						(proc0_9) ; "You don't have it."
					)
					((not (gEgo has: (gInventory indexOf: temp0)))
						(proc0_9) ; "You don't have it."
					)
					(else
						(switch (gInventory indexOf: temp0)
							(31
								(localproc_2 31 127 2 44)
							)
							(22
								(localproc_2 22 128 2 45)
							)
							(19
								(localproc_2 19 129 2 46)
							)
							(14
								(localproc_2 14 130 2 47)
							)
							(28
								(localproc_1)
							)
							(17
								(localproc_2 17 132 2 48)
							)
							(20
								(localproc_2 20 133 2 49)
							)
							(21
								(localproc_2 21 145 2 50)
							)
							(26
								(localproc_2 26 134 2 51)
							)
							(18
								(localproc_2 18 139 2 52)
							)
							(13
								(localproc_2 13 135 2 53)
							)
							(35
								(localproc_2 35 136 2 54)
							)
							(25
								(localproc_2 25 137 2 55)
							)
							(24
								(localproc_2 24 138 2 56)
							)
							(else
								(Print 2 64) ; "That is not something you need to book."
							)
						)
					)
				)
			)
			((or (Said '/hello') (Said 'talk/john,man,man'))
				(cond
					((gCast contains: local1)
						(localproc_0 2 31) ; "Wait your turn, Bonds."
					)
					((not (gEgo inRect: 165 105 200 112))
						(Print 2 65) ; "Get closer to talk to him."
					)
					((<= (bigJonScript state:) 1)
						(Print 2 12) ; "He is not here."
					)
					((<= (bigJonScript state:) 3)
						(Print 2 66) ; "Wait until he is at the window."
					)
					((< (bigJonScript state:) 8)
						(self cue:)
					)
					(else
						(self changeState: 5)
					)
				)
			)
			(
				(or
					(Said 'ask/briefcase,bin,locker')
					(Said 'ask/john/briefcase,bin')
				)
				(cond
					((not (gEgo inRect: 165 105 200 112))
						(Print 2 65) ; "Get closer to talk to him."
					)
					((<= (bigJonScript state:) 1)
						(Print 2 12) ; "He is not here."
					)
					((== (bigJonScript state:) 3)
						(Print 2 66) ; "Wait until he is at the window."
					)
					(else
						(localproc_0 2 67) ; "Big John looks surprised. "They keep the field kits in the bins right there behind the counter, where they've always been, Bonds," he says."
					)
				)
			)
			(
				(or
					(Said 'ask/clue,finding')
					(Said 'ask/john/clue,finding')
					(Said 'get/finding')
				)
				(cond
					((gCast contains: local1)
						(localproc_0 2 31) ; "Wait your turn, Bonds."
					)
					((not (gEgo inRect: 165 105 200 112))
						(Print 2 65) ; "Get closer to talk to him."
					)
					((<= (bigJonScript state:) 1)
						(Print 2 12) ; "He is not here."
					)
					((== (bigJonScript state:) 3)
						(Print 2 66) ; "Wait until he is at the window."
					)
					(else
						(localproc_0 2 68) ; "Big John says, "The results will be placed in your message basket tomorrow.""
					)
				)
			)
			((Said 'yes')
				(switch local6
					(1
						(localproc_0 2 69) ; "What do you want to book?"
						(= local6 2)
					)
					(2
						(localproc_0 2 70) ; "Give me the evidence you want to book."
					)
					(3
						(localproc_0 2 70) ; "Give me the evidence you want to book."
					)
					(5
						(localproc_0 2 71) ; "I would be too."
					)
					(6
						(localproc_0 2 72) ; "That's good. I hope he's found and put away for a long time."
					)
					(else
						(Print 2 73) ; "Huh?"
					)
				)
				(= local6 0)
			)
			((Said 'no')
				(switch local6
					(1
						(localproc_0 2 74) ; "Ok, then leave me alone."
					)
					(2
						(localproc_0 2 75) ; "What are you talking about Sonny?"
					)
					(3
						(localproc_0 2 74) ; "Ok, then leave me alone."
					)
					(5
						(localproc_0 2 76) ; "Boy, Sonny, you must be really brave."
					)
					(6
						(localproc_0 2 77) ; "Well, I hope you find something on Bains because who knows what he'll do."
					)
					(else
						(Print 2 73) ; "Huh?"
					)
				)
				(= local6 0)
			)
			((Said '/none')
				(switch local6
					(2
						(localproc_0 2 78) ; "Ok, then quit bothering me!"
					)
					(else
						(Print 2 73) ; "Huh?"
					)
				)
				(= local6 0)
			)
		)
	)
)

(instance mrGScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(local1 stopUpd:)
			)
			(1
				(Print 2 79 #at -1 118) ; "In his heavy Italian accent, Officer Gelepsi says..."
				(switch (Random 0 2)
					(0
						(Print 2 80 #at -1 118) ; "I'da like'a to talk, but I'ma... how do you say... booke' de evidence'"
					)
					(1
						(Print 2 81 #at -1 118) ; "Sonny, I jus' don'a hav'a time to talk."
					)
					(2
						(Print 2 82 #at -1 118) ; "Cant'a you see I'ma busy?"
					)
				)
			)
			(2
				(Print 2 79) ; "In his heavy Italian accent, Officer Gelepsi says..."
				(switch (Random 0 2)
					(0
						(Print 2 83 #at -1 118) ; "Look, Mista detective: GET LOST!"
					)
					(1
						(Print 2 84 #at -1 118) ; "Stop buggin' me, hot-shot! I MEAN it!!"
					)
					(2
						(Print 2 85 #at -1 118) ; "GO 'WAY! I don' wanna talk to you no more!"
					)
				)
			)
			(3
				(Print 2 86 #at -1 118) ; "In a heated tone of voice Gelepsi says... "Hey, you cock'a de roach'a! Don'a you unnastand'a de english???""
			)
		)
	)

	(method (handleEvent event)
		(switch (event type:)
			(evSAID
				(if (or (Said 'talk/gelepsi,man,man') (Said '/hello'))
					(switch (mrGScript state:)
						(0
							(self cue:)
						)
						(1
							(if (== (Random 0 3) 1)
								(self cue:)
							else
								(self changeState: 1)
							)
						)
						(2
							(if (== (Random 0 2) 1)
								(self cue:)
							else
								(self changeState: 2)
							)
						)
						(3
							(self changeState: 3)
						)
					)
				)
			)
		)
	)
)

