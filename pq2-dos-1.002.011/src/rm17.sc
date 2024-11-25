;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 17)
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
	rm17 0
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
	(Print &rest #at -1 15)
)

(instance rm17 of Rm
	(properties
		picture 17
		style 0
	)

	(method (dispose)
		(scruffyScript dispose:)
		(agentScript dispose:)
		(super dispose:)
	)

	(method (init)
		(super init:)
		(= gPerspective 70)
		(User canInput: 1 canControl: 1)
		(= global212 3)
		(= global211 1)
		(Load rsVIEW 1)
		(Load rsVIEW 20)
		(Load rsVIEW 78)
		(Load rsVIEW 77)
		((= local5 (Act new:))
			view: 78
			setLoop: 1
			init:
			illegalBits: 0
			setScript: scruffyScript
		)
		((View new:)
			view: 78
			loop: 0
			cel: 2
			posn: 196 96
			init:
			setPri: 6
			addToPic:
		)
		((View new:)
			view: 78
			loop: 0
			cel: 3
			posn: 178 96
			init:
			setPri: 6
			addToPic:
		)
		((= local0 (Prop new:))
			view: 78
			loop: 3
			posn: 80 125
			setPri: 5
			setCycle: Fwd
			cycleSpeed: 1
			ignoreActors:
			init:
		)
		((= local1 (Prop new:))
			view: 78
			loop: 4
			posn: 54 139
			setPri: 9
			setCycle: Rev
			cycleSpeed: 1
			init:
			ignoreActors:
		)
		((View new:)
			view: 78
			loop: 0
			cel: 0
			posn: 118 89
			setPri: 7
			init:
			addToPic:
		)
		((View new:)
			view: 78
			loop: 0
			cel: 1
			posn: 159 112
			setPri: 8
			init:
			addToPic:
		)
		((View new:)
			view: 78
			loop: 0
			cel: 4
			posn: 167 93
			init:
			setPri: 7
			addToPic:
		)
		((View new:)
			view: 78
			loop: 0
			cel: 5
			posn: 197 93
			init:
			setPri: 7
			addToPic:
		)
		((View new:) view: 78 loop: 0 cel: 6 posn: 158 119 init: addToPic:)
		((View new:) view: 77 loop: 8 cel: 0 posn: 267 116 init: addToPic:)
		((View new:) view: 77 loop: 8 cel: 1 posn: 282 115 init: addToPic:)
		(self setLocales: 153)
		(self setScript: rm17Script)
	)
)

(instance rm17Script of Script
	(properties)

	(method (doit)
		(cond
			((>= (gEgo x:) 320)
				(= gPerspective 0)
				(gCurRoom newRoom: 16)
			)
			((and (< (gEgo x:) 31) (> (gEgo y:) 150))
				(localproc_0 17 0) ; "There's nothing to be seen back here."
				(gEgo setMotion: MoveTo 150 (gEgo y:))
			)
			((> (gEgo y:) 180)
				(localproc_0 17 0) ; "There's nothing to be seen back here."
				(gEgo setMotion: MoveTo (gEgo x:) 150)
			)
			((and local11 (not local9) (== (gEgo onControl: 1) 8192))
				(localproc_0 17 1) ; "When you were a kid, it was fun to go up the down escalator, but now you realize that it could be dangerous, so you back off."
				(= local9 1)
				(gEgo cel: 6)
			)
			((and local9 (!= (gEgo onControl: 1) 8192))
				(= local9 0)
			)
			((and (== (gEgo onControl: 1) 16384) local11)
				(= local10 1)
				(self changeState: 5)
			)
		)
		(cond
			((gEgo inRect: 134 116 185 124)
				(if (!= local4 1)
					(= local4 1)
				)
			)
			((gEgo inRect: 185 116 226 124)
				(if (!= local4 2)
					(= local4 2)
				)
			)
			(else
				(= local4 0)
			)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SL enable:)
				(if (== gPrevRoomNum 16)
					(User prevDir: 7)
					(gEgo
						view: (if global204 7 else 1)
						posn: 318 145
						init:
						setMotion: MoveTo 50 145
					)
					(= local11 1)
					(if (IsFlag 40)
						((= global112 (Act new:))
							view: 20
							loop: 0
							cel: 7
							posn: (+ (gEgo x:) 42) (gEgo y:)
							setAvoider: (Avoid new:)
							setCycle: Walk
							illegalBits: $9000
							init:
							setMotion: Follow gEgo 40
						)
					)
				else
					(HandsOff)
					(gEgo
						view: (if global204 7 else 1)
						setLoop: 0
						cel: 7
						posn: 20 98
						init:
						illegalBits: 0
						setPri: 10
						setMotion: MoveTo 50 134 self
						setCycle: 0
						ignoreActors: 1
					)
				)
			)
			(1
				(gEgo
					setLoop: -1
					setCel: -1
					setCycle: Walk
					setMotion: MoveTo 85 134 self
				)
			)
			(2
				(gEgo
					ignoreActors: 0
					illegalBits: $8000
					setPri: -1
					setMotion: MoveTo 700 134
				)
				(= local11 1)
				(HandsOn)
				(User prevDir: 3)
				(if (IsFlag 40)
					((= global112 (Act new:))
						view: 20
						setLoop: 0
						cel: 7
						posn: 20 98
						init:
						illegalBits: 0
						setPri: 10
						setMotion: MoveTo 50 134 self
						setCycle: 0
					)
				)
			)
			(3
				(if local10
					(global112
						setLoop: -1
						setCel: -1
						setCycle: Walk
						setPri: -1
						illegalBits: $8000
						setMotion: Follow gEgo 30
					)
				else
					(global112
						setLoop: -1
						setCel: -1
						setCycle: Walk
						setMotion: MoveTo 135 135 self
					)
				)
			)
			(4
				(global112 illegalBits: $9000 setMotion: Follow gEgo 40)
			)
			(5
				(HandsOff)
				(gEgo
					setStep: 4 4
					setPri: 8
					illegalBits: 0
					setLoop: 1
					setCel: 7
					setMotion: MoveTo 16 85 self
				)
			)
			(6
				(= gPerspective 0)
				(gCurRoom newRoom: 20)
				(gContinuousMusic fade:)
			)
		)
	)

	(method (handleEvent event)
		(switch (event type:)
			(evSAID
				(cond
					((Said 'show/mugshot,painting,(shot<mug)')
						(agentScript changeState: 2)
					)
					((Said 'look,read/sign')
						(localproc_0 17 2) ; "In big letters, the rental agency's name is 'SIVA'."
					)
					((Said 'look>')
						(cond
							((Said '/flyer,ad,schedule,law')
								(localproc_0 17 3) ; "The usual advertisement posters, rate schedules, and rules and regulations. Nothing special."
							)
							((Said '/escalator')
								(localproc_0 17 4) ; "Nothing unusual about it. You ride up one side, and down the other."
							)
							((Said '/stair')
								(localproc_0 17 5) ; "That's an escalator."
							)
							((or (Said '<up') (Said '/ceiling,light'))
								(localproc_0 17 6) ; "No problem with the lights."
							)
							((or (Said '<down') (Said '/floor'))
								(localproc_0 17 7) ; "You think to yourself, "Nice floor.""
							)
							((Said '/pane')
								(if (== (gEgo loop:) 2)
									(localproc_0 17 8) ; "Through the window and across the street, the parking lot seems to go on forever."
								else
									(localproc_0 17 9) ; "You see an airliner parked in the passenger loading zone."
								)
							)
							((Said '/rope')
								(localproc_0 17 10) ; "It's a velveteen braided rope similar to the ones found in some movie theaters."
							)
							((Said '[<at,around][/!*,chamber,building]')
								(localproc_0 17 11) ; "Looking around you see see a car rental agency near the escalator."
							)
							((Said '/man,person')
								(cond
									((<= (local5 distanceTo: gEgo) 50)
										(localproc_0 17 12) ; "He sure is scruffy-looking for a businessman."
									)
									((== local4 1)
										(localproc_0 17 13) ; "The customer sure is a well-tailored fellow....Why, isn't that Donald Trump?!?"
									)
									((== local4 0)
										(localproc_0 17 14) ; "You look at nothing in particular."
									)
									((gEgo inRect: 143 117 185 124)
										(localproc_0 17 13) ; "The customer sure is a well-tailored fellow....Why, isn't that Donald Trump?!?"
									)
									(else
										(localproc_0 17 15) ; "The car rental agent kind of looks like your ex-girlfriend's husband."
									)
								)
							)
							((Said '/agency,auto,rental,counter')
								(localproc_0 17 16) ; "There are two agents behind the counter at the Siva Car Rental agency."
							)
							((Said '/agent')
								(cond
									((== local4 1)
										(localproc_0 17 17) ; "The girl who works at at the car rental counter is pleasingly plump."
									)
									((== local4 2)
										(localproc_0 17 15) ; "The car rental agent kind of looks like your ex-girlfriend's husband."
									)
									(else
										(localproc_0 17 16) ; "There are two agents behind the counter at the Siva Car Rental agency."
									)
								)
							)
							((Said '/woman,woman')
								(if (< (gEgo y:) 137)
									(localproc_0 17 17) ; "The girl who works at at the car rental counter is pleasingly plump."
								else
									(localproc_0 17 14) ; "You look at nothing in particular."
								)
							)
							((Said '/passenger,customer[<rental]')
								(if (< (gEgo y:) 137)
									(localproc_0 17 13) ; "The customer sure is a well-tailored fellow....Why, isn't that Donald Trump?!?"
								else
									(localproc_0 17 14) ; "You look at nothing in particular."
								)
							)
							(
								(or
									(Said '/list[<customer,rental,auto]')
									(Said '/agreement[<rental]')
									(Said '/rental')
								)
								(if (gEgo inRect: 124 116 218 124)
									(agentScript changeState: 1)
								else
									(localproc_0 17 14) ; "You look at nothing in particular."
								)
							)
						)
					)
					((Said 'ask/auto')
						(localproc_0 17 18) ; "There are lots of cars outside."
					)
					(
						(or
							(Said
								'show,get,see,ask/list[<customer,rental,auto]'
							)
							(Said '[show,get,see,ask]/list,agreement,rental')
							(Said 'show,get,see,ask/me/list,rental,agreement')
							(Said 'talk,ask/agent/customer,rental,list,auto')
						)
						(if (gEgo inRect: 124 116 218 124)
							(agentScript changeState: 1)
						else
							(localproc_0 17 19) ; "No one can hear you from where you're standing."
						)
					)
					((Said 'talk>')
						(cond
							((or (Said '/agent[<rental]') (Said '/woman,woman'))
								(cond
									((== local4 0)
										(localproc_0 17 19) ; "No one can hear you from where you're standing."
									)
									((and (not local2) (not local3))
										(agentScript changeState: 0)
									)
									(else
										(localproc_0 17 20) ; ""Is there anything in particular you wanted to talk about?" the rental agent says."
									)
								)
							)
							((Said '/man,men')
								(cond
									(
										(or
											(gEgo inRect: 143 117 185 124)
											(== local4 1)
										)
										(localproc_0 17 21) ; "The suave-looking customer says, "Have you seen what I've done with Manhattan Island? It's pure quality...pure quality!""
									)
									((== local4 2)
										(if (and (not local2) (not local3))
											(agentScript changeState: 0)
										else
											(localproc_0 17 20) ; ""Is there anything in particular you wanted to talk about?" the rental agent says."
										)
									)
									(
										(and
											(< (gEgo y:) 134)
											(> (gEgo x:) 226)
										)
										(localproc_0 17 22) ; "These guys don't seem to be listening."
									)
									((<= (local5 distanceTo: gEgo) 50)
										(localproc_0 17 23) ; ""Mmpf..spst..lousy connecting flights..spfts..call my boss.. grmbl..spft" the scruffy-looking man mutters under his breath."
									)
									(else
										(localproc_0 17 19) ; "No one can hear you from where you're standing."
									)
								)
							)
							((Said '/passenger,customer[<rental]')
								(if (gEgo inRect: 143 117 185 124)
									(localproc_0 17 21) ; "The suave-looking customer says, "Have you seen what I've done with Manhattan Island? It's pure quality...pure quality!""
								else
									(localproc_0 17 19) ; "No one can hear you from where you're standing."
								)
							)
						)
					)
					((Said 'show,flash/badge')
						(if (gEgo has: 7) ; wallet
							(if (gEgo inRect: 124 116 218 124)
								(= local2 1)
							)
							(cond
								((== local4 1)
									(localproc_0 17 24) ; "You show your badge to the car rental agent, and she says... "Yes sir, Officer Bonds! What can I do for you?""
								)
								((== local4 2)
									(localproc_0 17 25) ; "You show your badge to the car rental agent, and he says... "Yes sir, Officer Bonds! What can I do for you?""
								)
								((<= (local5 distanceTo: gEgo) 50)
									(localproc_0 17 26) ; "So you're a cop....ask me if I care! I'm too tired to care!"
								)
								(else
									(localproc_0 17 27) ; "No one can see your shield from where you're standing."
								)
							)
						else
							(localproc_0 17 28) ; "You don't have your identification with you."
						)
					)
					((Said 'arrest/agent,man,woman,customer,passenger,woman')
						(localproc_0 17 29) ; "You're losing it, friend. Better back off."
					)
					(
						(Said
							'frisk,arrest/agent,man,woman,woman,customer,passenger'
						)
						(localproc_0 17 30) ; "You have no reason to do that. Try to conduct yourself in a professional manner."
					)
					(
						(Said
							'kill,fire,hit/agent,man,customer,passenger,woman,woman'
						)
						(localproc_0 17 31) ; "That's a good way for you to wind up making license plates."
					)
					((Said 'rent[/auto,bus,bicycle]')
						(localproc_0 17 32) ; "Why in the world would you want to do that?? Your own car is outside."
					)
					((Said 'yes')
						(localproc_0 17 33) ; "You're very agreeable."
					)
					((Said 'no')
						(localproc_0 17 34) ; "Probably not, huh."
					)
					((Said 'thank[/you,man,woman,agent]')
						(if (gEgo inRect: 124 116 218 124)
							(agentScript changeState: 3)
						else
							(localproc_0 17 19) ; "No one can hear you from where you're standing."
						)
					)
					((Said '[*]/bains')
						(localproc_0 17 35) ; "Just thinking about Bains makes your blood boil."
					)
				)
			)
		)
	)
)

(instance scruffyScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (< global110 30)
					(client setScript: 0)
					(return)
				)
				(= cycles (Random 100 300))
			)
			(1
				(if (== gPrevRoomNum 16)
					(local5
						posn: 26 102
						setPri: 10
						cel: 3
						setCycle: 0
						setMotion: MoveTo 50 134 self
						setAvoider: (Avoid new:)
						ignoreActors: 1
					)
				else
					(local5
						posn: -15 168
						setCycle: Walk
						setAvoider: (Avoid new:)
					)
					(self changeState: 3)
				)
			)
			(2
				(local5
					setCycle: Walk
					setMotion: MoveTo 82 134 self
					ignoreActors: 0
				)
			)
			(3
				(local5
					setPri: -1
					setMotion: MoveTo 362 178 self
					ignoreActors: 0
				)
			)
			(4
				(local5 stopUpd:)
				(= cycles (Random 100 300))
			)
			(5
				(local5 setLoop: 2 setMotion: MoveTo -15 168 self)
			)
			(6
				(local5 setLoop: 1)
				(self changeState: 3)
			)
		)
	)
)

(instance agentScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(switch (Random 0 5)
					(0
						(localproc_0 17 36) ; ""How may I help you?" asks the agent."
					)
					(1
						(localproc_0 17 37) ; ""We have wheels and we make deals," cracks the agent."
					)
					(2
						(localproc_0 17 38) ; ""We live up to our name!" says the agent in all seriousness."
					)
					(3
						(localproc_0 17 39) ; "The agent tells you: "We handle everything from bicycles to Mack trucks.""
					)
					(4
						(localproc_0 17 40) ; ""We have the lowest prices in town. Of course, wheels are extra!" cracks the agent."
					)
					(5
						(localproc_0 17 41) ; "The agent pipes up, "At Siva rent-a-car, we try softer!""
					)
				)
			)
			(1
				(= local3 1)
				(if local2
					(if (== local4 2)
						(if local7
							(localproc_0 17 42) ; "The agent says, "I already showed you my list of rental customers, but if you insist.....""
						else
							(localproc_0 17 43) ; "Here you are, sir. Be my guest."
						)
						(= local7 1)
						(localproc_0 17 44) ; "The Siva representative hands you his car rental agreements."
						(localproc_0 17 45) ; "You carefully look over each car rental agreement, but you find nothing of interest."
					else
						(if local8
							(localproc_0 17 42) ; "The agent says, "I already showed you my list of rental customers, but if you insist.....""
						else
							(localproc_0 17 43) ; "Here you are, sir. Be my guest."
						)
						(= local8 1)
						(localproc_0 17 46) ; "Flashing a smile, the agent gives you her list of car rentals."
						(if (>= global100 6)
							(agentScript changeState: 4)
						else
							(localproc_0 17 45) ; "You carefully look over each car rental agreement, but you find nothing of interest."
						)
					)
				else
					(localproc_0 17 47) ; "Who do you think you are?" asks the agent. "We don't go around showing our rental agreements to people!"
				)
			)
			(2
				(cond
					(local2
						(cond
							((gEgo has: 12) ; new_mug_shot
								(switch local4
									(1
										(if (>= global100 6)
											(localproc_0 17 48 82 112) ; "The agent looks at the mug shot and says..."Matter of fact, I do remember renting a car to this guy.""
											(SetScore 1 83)
										else
											(localproc_0 17 49 82 112) ; "You show the mug shot of Bains, and the agent says..."Nope, never seen the man before.""
										)
									)
									(2
										(localproc_0 17 49 82 112) ; "You show the mug shot of Bains, and the agent says..."Nope, never seen the man before.""
									)
								)
							)
							((gEgo has: 23) ; old_mug_shot
								(localproc_0 17 49 82 123) ; "You show the mug shot of Bains, and the agent says..."Nope, never seen the man before.""
							)
							(else
								(localproc_0 17 50) ; "You don't have a mug shot of Bains to show."
							)
						)
					)
					((or (gEgo has: 12) (gEgo has: 23)) ; new_mug_shot, old_mug_shot
						(localproc_0 ; "The Siva rental agent says softly, "That's very nice, sir. Would you like to see a picture of my son?.""
							17
							51
							82
							(if (gEgo has: 12) 112 else 123) ; new_mug_shot
						)
					)
					(else
						(localproc_0 17 50) ; "You don't have a mug shot of Bains to show."
					)
				)
			)
			(3
				(if local2
					(localproc_0 17 52) ; "Anytime, Officer. Glad to help."
				else
					(localproc_0 17 53) ; "You're welcome, and remember: Siva tries softer!"
				)
			)
			(4
				(SetScore 3 84)
				(localproc_0 17 54 25 8) ; "Looking at the rental agreements, you come across a familiar name...."Luis Pate.""
				(localproc_0 17 55 25 8) ; "You think to yourself: "That punk has rented a car using the jailer's ID. I'd better jot down the information.""
				(localproc_0 17 56 25 8) ; "You write down the vehicle information: 1988 green "CMG" sedan. License #C43256."
				(self cue:)
			)
			(5
				(if (!= (gContinuousMusic state:) 3)
					(gContinuousMusic number: 29 loop: -1 play:)
				)
			)
		)
	)
)

