;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 18)
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
	rm18 0
)

(local
	local0
	local1
	local2
	local3
	local4
)

(procedure (localproc_0)
	(Print &rest #at -1 15)
)

(instance rm18 of Rm
	(properties
		picture 18
		style 1
	)

	(method (dispose)
		(agentScript dispose:)
		(super dispose:)
	)

	(method (init)
		(super init:)
		(= gPerspective 70)
		(= global212 3)
		(= global211 1)
		(User canInput: 1)
		(Load rsVIEW 1)
		(Load rsVIEW 79)
		((= local0 (Prop new:))
			view: 79
			posn: 126 98
			setLoop: 1
			cel: 0
			setPri: 8
			init:
			stopUpd:
		)
		((= local1 (View new:))
			view: 79
			posn: 101 103
			loop: 3
			cel: 1
			setPri: 9
			init:
			stopUpd:
			addToPic:
		)
		((View new:)
			view: 79
			posn: 3 96
			loop: 0
			cel: 0
			setPri: 10
			init:
			stopUpd:
			addToPic:
		)
		((View new:)
			view: 79
			posn: 286 87
			loop: 0
			cel: 1
			setPri: 5
			init:
			stopUpd:
			addToPic:
		)
		((View new:)
			view: 79
			posn: 142 64
			loop: 0
			cel: 2
			setPri: 15
			init:
			stopUpd:
			addToPic:
		)
		((View new:)
			view: 79
			posn: 68 128
			loop: 0
			cel: 3
			setPri: 10
			init:
			stopUpd:
			addToPic:
		)
		((View new:)
			view: 79
			posn: 126 126
			loop: 0
			cel: 4
			init:
			ignoreActors:
			setPri: 9
			stopUpd:
			addToPic:
		)
		((View new:)
			view: 79
			posn: 130 126
			loop: 0
			cel: 5
			init:
			ignoreActors:
			setPri: 8
			stopUpd:
			addToPic:
		)
		(self setLocales: 153)
		(self setScript: rm18Script)
	)
)

(instance rm18Script of Script
	(properties)

	(method (doit)
		(cond
			(
				(or
					(and (< (gEgo x:) 2) (> (gEgo y:) 125))
					(and (< (gEgo y:) 125) (< (gEgo x:) 100))
				)
				(= gPerspective 0)
				(gCurRoom newRoom: 16)
			)
			((<= (gEgo y:) 120)
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
				(SL enable:)
				(gEgo
					view: (if global204 7 else 1)
					xStep: 3
					yStep: 2
					posn: (if (< (gEgo y:) 135) 105 else 4) (gEgo y:)
					setMotion: MoveTo 350 (gEgo y:)
					init:
				)
				(if (IsFlag 40)
					((= global112 (Act new:))
						view: 20
						xStep: 3
						yStep: 2
						posn: (- (gEgo x:) 26) (gEgo y:)
						setCycle: Walk
						setAvoider: (Avoid new:)
						setMotion: Follow gEgo 24
						init:
					)
				)
			)
		)
	)

	(method (handleEvent event)
		(switch (event type:)
			(evSAID
				(cond
					((Said 'show/mugshot,painting,(shot<mug)')
						(if (gEgo inRect: 76 113 173 141)
							(agentScript changeState: 3)
						else
							(localproc_0 18 0) ; "Get closer to the rental agents so that they can see the mug shot."
						)
					)
					((Said 'look>')
						(cond
							((Said '[<at,around][/!*,chamber,building]')
								(localproc_0 18 1) ; "Looking around, you see a car rental agency and not much else."
							)
							((Said '/sign,flyer,ad')
								(if (> (gEgo x:) 95)
									(switch (Random 1 3)
										(1
											(localproc_0 18 2) ; "The car rental agency's name is "Top Hat.""
										)
										(2
											(localproc_0 18 3) ; "CPA stands for "Cheap Prices Available.""
										)
										(3
											(localproc_0 18 4) ; "The fine print says: "Our rental cars are for the birds...they're CHEEP!""
										)
									)
								else
									(localproc_0 18 2) ; "The car rental agency's name is "Top Hat.""
								)
							)
							((or (Said '<up') (Said '/ceiling'))
								(localproc_0 18 5) ; "Nice ceiling."
							)
							((or (Said '<down') (Said '/floor'))
								(localproc_0 18 6) ; "Nice floor."
							)
							((Said '/counter,agency')
								(localproc_0 18 7) ; "There are two turtle-looking agents behind the rental agency counter."
							)
							((Said '/hat')
								(localproc_0 18 8) ; "Top hats, of course!"
							)
							((Said '/turtle')
								(localproc_0 18 9) ; "There aren't any real turtles in here."
							)
							((Said '/pane')
								(if (== (gEgo loop:) 2)
									(localproc_0 18 10) ; "Turn around."
								else
									(localproc_0 18 11) ; "Through the window you see the airport tarmac."
								)
							)
							((Said '/bench')
								(localproc_0 18 12) ; "Just a chair."
							)
							((Said '/rope')
								(localproc_0 18 13) ; "It's a velveteen braided rope similar to the ones found in some movie theaters."
							)
							((Said '/painting')
								(localproc_0 18 14) ; "Another pointlessly pointillistic painting."
							)
							((Said '/agent,man,woman')
								(localproc_0 18 15) ; "Dressed in a silly-looking green tux, the Top Hat car rental agent looks back with a blank stare."
							)
							((Said '/list,rental[<customer]')
								(if (gEgo inRect: 76 113 173 141)
									(agentScript changeState: 1)
								else
									(localproc_0 18 16) ; "No one can hear you from where you're standing."
								)
							)
						)
					)
					((Said 'ask/auto')
						(localproc_0 18 17) ; "There are lots of cars outside."
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
						(if (gEgo inRect: 76 113 173 141)
							(agentScript changeState: 1)
						else
							(localproc_0 18 16) ; "No one can hear you from where you're standing."
						)
					)
					((Said 'talk/agent,man,woman')
						(if (gEgo inRect: 76 113 173 141)
							(agentScript changeState: 0)
						else
							(localproc_0 18 16) ; "No one can hear you from where you're standing."
						)
					)
					((Said 'read/sign,flyer,ad')
						(switch (Random 1 3)
							(1
								(localproc_0 18 2) ; "The car rental agency's name is "Top Hat.""
							)
							(2
								(localproc_0 18 3) ; "CPA stands for "Cheap Prices Available.""
							)
							(3
								(localproc_0 18 4) ; "The fine print says: "Our rental cars are for the birds...they're CHEEP!""
							)
						)
					)
					((Said 'show/badge')
						(if (gEgo inRect: 76 113 173 141)
							(agentScript changeState: 2)
						else
							(localproc_0 18 18) ; "No one can see your shield from where you're standing."
						)
					)
					((Said 'get/list[<rental,customer]')
						(localproc_0 18 19) ; "That isn't necessary."
					)
					((Said 'arrest/agent,man,woman,woman')
						(localproc_0 18 20) ; "Without justification, Bonds, that would be kidnapping!"
					)
					((Said 'arrest/agent,man,woman,woman')
						(localproc_0 18 21) ; "You have absolutely no reason to cuff the person."
					)
					((Said 'fire,kill,hit/agent,man,woman,woman')
						(localproc_0 18 22) ; "That's a good way for you to wind up making license plates."
					)
					((Said 'rent[/auto]')
						(localproc_0 18 23) ; "Your own car is outside."
					)
					((Said 'get/hat')
						(localproc_0 18 24) ; "You won't need a top hat where you're going."
					)
					((Said 'thank[/you,man,woman,woman,agent]')
						(if (gEgo inRect: 76 113 173 141)
							(agentScript changeState: 4)
						else
							(localproc_0 18 16) ; "No one can hear you from where you're standing."
						)
					)
				)
			)
		)
	)
)

(instance agentScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(switch (Random 0 3)
					(0
						(localproc_0 18 25) ; ""Can I help you?" asks the agent."
					)
					(1
						(localproc_0 18 26) ; "The agent looks at you and says..."Dependable transportation is our business.""
					)
					(2
						(localproc_0 18 27) ; ""Rest assured, you're in good hands with Top Hat," cracks the agent."
					)
					(3
						(localproc_0 18 28) ; "At Top Hat, our cars may be sssslllooooowww, but they're TOPS!"
					)
				)
			)
			(1
				(= local4 1)
				(if local2
					(localproc_0 18 29) ; "Yes sir, Officer. Here are all of the car rental agreements for the last week."
					(localproc_0 18 30) ; "The Top Hat representative slowly hands you the car rental agreements."
					(localproc_0 18 31) ; "You carefully look over each car rental agreement. Unable to find anything helpful, you return them to the agent."
				else
					(localproc_0 18 32) ; "What?" snaps the agent. "I'm not going to show our rental agreements to you. They're confidential!"
				)
			)
			(2
				(= local2 1)
				(switch (Random 0 1)
					(0
						(localproc_0 18 33) ; "You flash your badge at the Top Hat agent and he says... "Oh No! Is my boss in trouble again?""
					)
					(1
						(localproc_0 18 34) ; "You whip out your badge..."
						(localproc_0 18 35) ; "What did I do?" asks the agent. "The last wrong thing I remember doing was running a stop sign, and that was six years ago."
					)
				)
				(if local4
					(localproc_0 18 30) ; "The Top Hat representative slowly hands you the car rental agreements."
					(localproc_0 18 31) ; "You carefully look over each car rental agreement. Unable to find anything helpful, you return them to the agent."
				)
			)
			(3
				(= local3 1)
				(cond
					(local2
						(cond
							((gEgo has: 12) ; new_mug_shot
								(switch (Random 0 1)
									(0
										(localproc_0 18 36 82 112) ; "The agent looks at the mug shot and says..."What a mean- looking fellow. Fortunately, I've never seen him before.""
									)
									(1
										(localproc_0 18 37 82 112) ; "You show the mug shot of Bains..."Nope, I've never seen the man before, but he sure looks like he ought to be locked up.""
									)
								)
							)
							((gEgo has: 23) ; old_mug_shot
								(switch (Random 0 1)
									(0
										(localproc_0 18 36 82 123) ; "The agent looks at the mug shot and says..."What a mean- looking fellow. Fortunately, I've never seen him before.""
									)
									(1
										(localproc_0 18 37 82 123) ; "You show the mug shot of Bains..."Nope, I've never seen the man before, but he sure looks like he ought to be locked up.""
									)
								)
							)
							(else
								(localproc_0 18 38) ; "You don't have a mug shot of Bains to show."
							)
						)
					)
					((or (gEgo has: 12) (gEgo has: 23)) ; new_mug_shot, old_mug_shot
						(localproc_0 ; "The rental agent takes a good look at the picture, and slowly responds..."Yeah, buddy, you've got a fine looking wife there. She needs a shave, though.""
							18
							39
							82
							(if (gEgo has: 12) 112 else 123) ; new_mug_shot
						)
					)
					(else
						(localproc_0 18 38) ; "You don't have a mug shot of Bains to show."
					)
				)
			)
			(4
				(if local2
					(localproc_0 18 40) ; "Anytime, Officer."
					(if local3
						(localproc_0 18 41) ; "Sure hope you get this guy. He looks BAD!"
					)
				else
					(localproc_0 18 42) ; "You're welcome. Come again to... Top Hat!"
				)
			)
		)
	)
)

