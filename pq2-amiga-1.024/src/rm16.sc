;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 16)
(include sci.sh)
(use Main)
(use Interface)
(use Avoid)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm16 0
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
)

(procedure (localproc_0)
	(if (not local16)
		(= local16 1)
		(gContinuousMusic fade:)
	)
)

(procedure (localproc_1)
	(Print &rest #at -1 15)
)

(instance agent of Act
	(properties)
)

(instance rm16 of Rm
	(properties
		picture 16
		style 1
		picAngle 70
	)

	(method (dispose)
		(moveScript dispose:)
		(agentScript dispose:)
		(egoOnThePhoneScript dispose:)
		(keithJoinsEgoScript dispose:)
		(getTheTicketScript dispose:)
		(super dispose:)
	)

	(method (init)
		(Load rsVIEW 0)
		(Load rsVIEW 1)
		(Load rsVIEW 20)
		(Load rsVIEW 77)
		(if (>= global100 6)
			(Load rsVIEW 667)
		)
		(super init:)
		(HandsOn)
		(= gPerspective 70)
		(if (and (>= global100 6) (< global100 8))
			(SetFlag 118)
		)
		(= global212 3)
		(= global211 1)
		(self setLocales: 153)
		(gEgo view: (if global204 7 else 1) init:)
		(agent
			view: 77
			loop: 2
			posn: 230 110
			setPri: 8
			init:
			ignoreActors:
			illegalBits: 0
			setCycle: Fwd
			cycleSpeed:
			stopUpd:
		)
		(switch gPrevRoomNum
			(12 ; phone
				(= local4 0)
				(agent setLoop: 3 setCel: 0 posn: 244 1119)
				(gEgo
					view: 667
					loop: 1
					illegalBits: $8000
					posn: 253 139
					cycleSpeed: 1
				)
				(HandsOff)
				(egoOnThePhoneScript changeState: 6)
			)
			(17
				(gEgo
					posn: 67 113
					view: (if global204 6 else 0)
					setMotion: MoveTo 310 113
					setPri: -1
				)
			)
			(18
				(gEgo
					posn: 285 (gEgo y:)
					setMotion: MoveTo 10 (gEgo y:)
				)
			)
			(19
				(gEgo posn: 20 132 setMotion: MoveTo 100 132)
			)
			(else
				(gEgo posn: 151 188 setMotion: MoveTo 151 114)
				(if (>= global100 6)
					(gContinuousMusic number: 16 loop: -1 play:)
				)
			)
		)
		(if (IsFlag 40)
			((= global112 (Act new:))
				view: 20
				init:
				setMotion: Follow gEgo 25
				setAvoider: (Avoid new:)
				setCycle: Walk
			)
			(switch gPrevRoomNum
				(18
					(global112 posn: (+ (gEgo x:) 20) (gEgo y:))
				)
				(19
					(global112 posn: 91 146)
				)
				(17
					(global112 posn: 50 112)
				)
				(else
					(global112 posn: (+ (gEgo x:) 10) (+ (gEgo y:) 20))
				)
			)
		)
		(gAddToPics
			add:
				pictureOnWall
				sittingPerson
				counterPerson
				talking1
				talking2
				talking3
		)
		(gAddToPics
			add:
				standing1
				standing2
				standing3
				standing4
				standing5
				case
				SIGN
				poster1
				poster2
				agent2
		)
		(gAddToPics doit:)
		(= local5 1)
	)

	(method (doit)
		(cond
			((gEgo inRect: 175 112 225 130)
				(if (!= local4 1)
					(= local4 1)
				)
			)
			((gEgo inRect: 195 130 225 139)
				(if (!= local4 2)
					(= local4 2)
				)
			)
			((gEgo inRect: 225 139 265 145)
				(if (!= local4 3)
					(= local4 3)
				)
			)
			((gEgo inRect: 30 114 83 143)
				(if (!= local4 4)
					(= local4 4)
				)
			)
			((gEgo inRect: 63 130 116 184)
				(if (!= local4 5)
					(= local4 5)
				)
			)
			(else
				(= local4 0)
			)
		)
		(if (and (>= global100 6) (< global100 8) local8)
			(= local8 0)
			(SetFlag 40)
			((= global112 (Act new:))
				view: 20
				setCycle: Walk
				setAvoider: (Avoid new:)
				init:
				setScript: keithJoinsEgoScript
			)
		)
		(if
			(and
				(IsFlag 40)
				(<= (global112 distanceTo: gEgo) 25)
				(not (IsFlag 126))
				(gEgo has: 31) ; jailer_s_revolver
				(== gPrevRoomNum 19)
			)
			(SetFlag 126)
			(localproc_1 16 0) ; "You tell Keith that you've found the kidnapped jailer's revolver in the restroom toilet."
			(localproc_1 16 1) ; "Keith congratulates you on your find and suggests that you take it back to the station and book it as evidence."
		)
		(if (and local1 (gEgo inRect: 225 139 265 145))
			(egoOnThePhoneScript changeState: 0)
		)
		(if (and (>= global100 6) (!= global100 13) (IsFlag 34))
			(= local13 1)
		)
		(if (== global100 13)
			(= local14 1)
		)
		(if (> local2 1)
			(-- local2)
		)
		(if (and (== local2 1) (not local15))
			(= local2 0)
			(moveScript cue:)
		)
		(if (> local3 0)
			(-- local3)
		)
		(cond
			((and (>= (gEgo y:) 189) (<= 124 (gEgo x:) 178))
				(gContinuousMusic fade:)
				(= gPerspective 0)
				(gCurRoom newRoom: 15)
			)
			((and (< (gEgo y:) 115) (< (gEgo x:) 65))
				(if (== (gContinuousMusic number:) 16)
					(gContinuousMusic fade:)
				)
				(= gPerspective 0)
				(gCurRoom newRoom: 17)
			)
			((> (gEgo x:) 305)
				(if (== (gContinuousMusic number:) 16)
					(gContinuousMusic fade:)
				)
				(= gPerspective 0)
				(gCurRoom newRoom: 18)
			)
			((and (< (gEgo x:) 17) (< 128 (gEgo y:) 145))
				(if (IsFlag 40)
					(localproc_1 16 2) ; "As you walk into the Men's Room, Keith says: "I'll wait for you out here.""
				)
				(if (== (gContinuousMusic number:) 16)
					(gContinuousMusic fade:)
				)
				(= gPerspective 0)
				(gCurRoom newRoom: 19)
			)
		)
		(if (and (== local4 2) (not local5))
			(= local5 1)
			(moveScript changeState: 5)
		)
		(if (and (== local4 3) (not local5))
			(= local5 1)
			(moveScript changeState: 7)
		)
		(if (and (!= local4 2) (!= local4 3) local5)
			(if (not local7)
				(moveScript changeState: 0)
				(= local5 0)
			else
				(moveScript changeState: 2)
				(= local5 0)
			)
		)
		(cond
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

	(method (handleEvent event)
		(switch (event type:)
			(evSAID
				(cond
					((Said 'show/shot,mugshot,painting')
						(localproc_0)
						(cond
							(
								(and
									(not (gEgo has: 12)) ; new_mug_shot
									(not (gEgo has: 23)) ; old_mug_shot
								)
								(localproc_1 16 3) ; "You don't have a mug shot of Bains to show."
							)
							(
								(or
									(== local4 5)
									(== local4 4)
									(and
										(or (== local4 3) (== local4 2))
										(not (IsFlag 39))
									)
									(and (== local4 1) (not (IsFlag 38)))
								)
								(if (gEgo has: 12) ; new_mug_shot
									(switch (Random 1 4)
										(1
											(localproc_1 16 4 82 112) ; "Why, that looks just like my Cousin Rufus (minus the corncob pipe, of course). But why are you showing it to me?"
										)
										(2
											(localproc_1 16 5 82 112) ; "Is that your brother? He looks sorta like you. Wait a minute, let me get my glasses....."
										)
										(3
											(localproc_1 16 6 82 112) ; "I'm afraid I don't have the time or the inclination to look at pictures from your family album."
										)
										(4
											(localproc_1 16 7 82 112) ; "Get lost, creep, and take your pictures with you."
										)
									)
								else
									(switch (Random 1 4)
										(1
											(localproc_1 16 4 82 123) ; "Why, that looks just like my Cousin Rufus (minus the corncob pipe, of course). But why are you showing it to me?"
										)
										(2
											(localproc_1 16 5 82 123) ; "Is that your brother? He looks sorta like you. Wait a minute, let me get my glasses....."
										)
										(3
											(localproc_1 16 6 82 123) ; "I'm afraid I don't have the time or the inclination to look at pictures from your family album."
										)
										(4
											(localproc_1 16 7 82 123) ; "Get lost, creep, and take your pictures with you."
										)
									)
								)
							)
							(
								(and
									(== local4 1)
									(gEgo has: 12) ; new_mug_shot
									(IsFlag 38)
									(>= global100 6)
								)
								(localproc_1 16 8 82 112) ; "Why, yes..." says the agent. "I remember this guy. He bought a ticket from us recently. He seemed nervous or something."
								(SetScore 1 81)
							)
							(
								(and
									(or
										(== local4 2)
										(== local4 3)
										(== local4 1)
									)
									(or (IsFlag 39) (IsFlag 38))
								)
								(if (gEgo has: 12) ; new_mug_shot
									(localproc_1 16 9 82 112) ; "I'm sorry, Officer, but the face doesn't ring a bell at all. I wish I could be of more assistance."
								else
									(localproc_1 16 9 82 123) ; "I'm sorry, Officer, but the face doesn't ring a bell at all. I wish I could be of more assistance."
								)
							)
							(else
								(localproc_1 16 10) ; "Nobody can see the mug shot from where you're standing."
							)
						)
					)
					((Said '[look]/computer,computer,show,info[<flight]')
						(cond
							(
								(or
									(and
										(< (gEgo y:) 114)
										(> (gEgo x:) 160)
									)
									(and
										(>= (gEgo y:) 114)
										(> (gEgo x:) 210)
									)
								)
								(localproc_1 16 11) ; "You can't see the flight info from where you are."
							)
							((not (== (gEgo loop:) 0))
								(localproc_1 16 12) ; "You're not looking at the monitors."
							)
							(else
								(switch (Random 1 4)
									(1
										(localproc_1 16 13) ; "You see from the display that the next flight departs in 2 minutes, headed for Beirut."
									)
									(2
										(localproc_1 16 14) ; "You see from the display that there will be a flight to Houston shortly."
									)
									(3
										(localproc_1 16 15) ; "You see from the display that the vacation special to Coarsegold departs in seven or eight months."
									)
									(4
										(localproc_1 16 16) ; "You see from the display that there are several flights to Steelton today."
									)
								)
							)
						)
					)
					((Said 'look>')
						(cond
							((Said '/bathroom,(chamber<rest)')
								(localproc_1 16 17) ; "Go on in and look around."
							)
							(
								(Said
									'[<at,around][/chamber,airport,terminal,building,lobby]'
								)
								(localproc_1 16 18) ; "You are inside the new Lytton Airport terminal building. People from all walks of life and all parts of the globe walk by. The little town of Lytton has entered the 20th century. You feel proud that your efforts have helped, even in a small way, to make Lytton a busy, prosperous city."
							)
							((Said '[<at,up][/ceiling]')
								(localproc_1 16 19) ; "If you've seen one ceiling, you've seen 'em all."
							)
							((Said '[<at,down][/floor,dirt,tile]')
								(localproc_1 16 20) ; "The floor tile's shine is marred only by the smeared trail of some child's lost chocolate bar."
							)
							((Said '/pane')
								(cond
									((== (gEgo loop:) 2)
										(localproc_1 16 21) ; "You look back out at the sidewalk in front of the airport entrance."
									)
									((== (gEgo loop:) 3)
										(localproc_1 16 22) ; "The runway's out there."
									)
									(else
										(localproc_1 16 23) ; "You're not looking at the window."
									)
								)
							)
							((Said '/flyer,ad')
								(cond
									(
										(or
											(and
												(< (gEgo y:) 114)
												(> (gEgo x:) 160)
											)
											(and
												(>= (gEgo y:) 114)
												(> (gEgo x:) 210)
											)
											(< (gEgo x:) 110)
										)
										(localproc_1 16 24) ; "You can't see it from where you are."
									)
									((not (== (gEgo loop:) 0))
										(localproc_1 16 25) ; "You're not looking at the posters."
									)
									(else
										(localproc_1 16 26) ; "The posters say: "Visit beautiful COARSEGOLD!""
									)
								)
							)
							((Said '/briefcase,bag,baggage')
								(if (== local4 4)
									(localproc_1 16 27) ; "The briefcase appears to belong to the gentleman sitting down."
								else
									(localproc_1 16 28) ; "You're not close enough."
								)
							)
							((Said '/counter,iguana')
								(localproc_1 16 29) ; "There are two agents behind the Iguana Airlines ticket counter."
							)
							((Said '/man,woman,men,women,crowd,passenger')
								(switch local4
									(1
										(localproc_1 16 30) ; "The ticket agent returns your gaze. The lady traveler waits impatiently."
									)
									(3
										(localproc_1 16 31) ; "The agent meets your steady gaze with a smile."
									)
									(2
										(localproc_1 16 31) ; "The agent meets your steady gaze with a smile."
									)
									(4
										(localproc_1 16 32) ; "The man sitting down looks terminally bored."
									)
									(else
										(localproc_1 16 33) ; "Just normal-looking airline passengers...."
									)
								)
							)
							((Said '/agent')
								(if
									(or
										(== local4 2)
										(== local4 3)
										(== local4 1)
									)
									(localproc_1 16 31) ; "The agent meets your steady gaze with a smile."
								else
									(localproc_1 16 28) ; "You're not close enough."
								)
							)
							((Said '<below/bench')
								(if (== local4 4)
									(localproc_1 16 34) ; "The gentleman says "Hey, fella! What're you trying to do?""
								else
									(localproc_1 16 28) ; "You're not close enough."
								)
							)
							((Said '/bench')
								(if (== local4 4)
									(localproc_1 16 35) ; "There are lounge chairs for the convenience of weary travelers. There is an ashtray next to them."
								else
									(localproc_1 16 28) ; "You're not close enough."
								)
							)
							((Said '/wall')
								(localproc_1 16 36) ; "On the wall hangs an abstract painting."
							)
							((Said '/counter')
								(localproc_1 16 37) ; "There are two ticket agents behind the ticket counter."
							)
							((Said '/painting')
								(localproc_1 16 38) ; "This abstract painting, entitled "After the Dust Settles", was created by "Vu", our very favorite computer artist."
							)
							((Said '/ass,cigarette')
								(if (== local4 4)
									(localproc_1 16 39) ; "Nasty-looking things. Some of 'em have lipstick on them."
								else
									(localproc_1 16 28) ; "You're not close enough."
								)
							)
							((Said '/rope')
								(localproc_1 16 40) ; "It's a velveteen braided rope similar to the ones found in some movie theaters."
							)
							((Said '/ashtray,(tray<ash)')
								(if (== local4 4)
									(localproc_1 16 41) ; "You look, and all you see are nasty old butts."
								else
									(localproc_1 16 28) ; "You're not close enough."
								)
							)
							((Said '/list,flight')
								(cond
									(
										(or
											(== local4 0)
											(== local4 4)
											(== local4 5)
										)
										(localproc_1 16 42) ; "No one near you has any of that information."
									)
									(
										(or
											(and (== local4 1) (IsFlag 38))
											(and
												(or (== local4 2) (== local4 3))
												(IsFlag 39)
											)
										)
										(agentScript changeState: 1)
									)
									(else
										(localproc_1 16 43) ; "I'm sorry sir," explains the ticket agent, "but the passenger list is confidential information."
									)
								)
							)
						)
					)
					((Said 'kiss')
						(localproc_1 16 44) ; "Not one of your best ideas, Sonny."
					)
					((Said '/hello')
						(localproc_1 16 45) ; "Hi there!"
					)
					((Said '/bye')
						(localproc_1 16 46) ; "So long!"
					)
					((Said 'yes')
						(localproc_1 16 47) ; "Yes...what??"
					)
					((Said 'no')
						(localproc_1 16 48) ; "No...what??"
					)
					((Said 'frisk,kill,hit,fire')
						(localproc_1 16 49) ; "That would be an entirely unprofessional and inappropriate action at this moment."
					)
					((Said 'get,eat,pick[<up]/candy,bar')
						(localproc_1 16 50) ; "The one on the floor?? Y-E-C-C-C-H-H-H-H!!"
					)
					((Said 'give,get/briefcase')
						(cond
							((== ((gInventory at: 10) owner:) 16) ; field_kit
								(localproc_1 16 51) ; "It's on its way to the plane."
							)
							((gEgo has: 10) ; field_kit
								(localproc_1 16 52) ; "You have it."
							)
							(else
								(localproc_1 16 53) ; "You can't get it here."
							)
						)
					)
					((Said 'get,pick[<up]/baggage,briefcase,bag')
						(if (gEgo inRect: 30 114 83 143)
							(localproc_1 16 54) ; "Hey, buddy!! What do you think you're doing??"
						else
							(localproc_1 16 55) ; "That's uncalled for."
						)
					)
					((Said 'sat[<down]')
						(localproc_1 16 56) ; "You're not weary or tired enough to sit down."
					)
					((Said 'get/bench')
						(if (== local4 4)
							(localproc_1 16 34) ; "The gentleman says "Hey, fella! What're you trying to do?""
						else
							(localproc_1 16 57) ; "What for?"
						)
					)
					((Said 'hoist,move/bench')
						(if (== local4 4)
							(localproc_1 16 34) ; "The gentleman says "Hey, fella! What're you trying to do?""
						else
							(localproc_1 16 57) ; "What for?"
						)
					)
					((Said 'get/painting')
						(localproc_1 16 58) ; "You're a homicide detective....not an art collector."
					)
					((Said 'eat,cigarette,get/ass,cigarette')
						(if (== local4 4)
							(localproc_1 16 59) ; "Not very sanitary."
						else
							(localproc_1 16 60) ; "Huh?"
						)
					)
					((Said 'talk>')
						(cond
							((Said '/man,person')
								(switch local4
									(1
										(localproc_0)
										(localproc_1 16 61) ; "It sure looks like you're trying to talk to the woman ticket agent."
									)
									(2
										(localproc_0)
										(localproc_1 16 62) ; "The agent looks at you, pauses, and looks down at some paperwork."
									)
									(3
										(localproc_0)
										(localproc_1 16 62) ; "The agent looks at you, pauses, and looks down at some paperwork."
									)
									(0
										(localproc_1 16 63) ; "Nobody can hear you from over there."
									)
									(else
										(switch (Random 1 3)
											(1
												(localproc_1 16 64) ; "This person seems to have just arrived from France. You hear, "Je ne parle pas anglais.""
											)
											(2
												(localproc_1 16 65) ; "No one seems to be listening to you."
											)
											(3
												(localproc_1 16 66) ; "Excuse me, but don't you have a flight to catch?"
											)
										)
									)
								)
							)
							((Said '/customer,passenger')
								(if (== local4 1)
									(localproc_1 16 67) ; "She glares at you, obviously upset, but says nothing."
								else
									(localproc_1 16 68) ; "She can't hear you."
								)
							)
							((Said '/men,crowd')
								(if (gEgo inRect: 63 130 116 184)
									(localproc_1 16 69) ; "They're doing their best to ignore you."
								else
									(localproc_1 16 70) ; "The men in the center of the lobby are talking among themselves."
								)
							)
							((Said '/woman')
								(cond
									((== local4 0)
										(if
											(or
												(and
													(> (gEgo x:) 225)
													(< (gEgo y:) 114)
												)
												(< (gEgo y:) 141)
											)
											(localproc_1 16 63) ; "Nobody can hear you from over there."
										else
											(switch (Random 1 3)
												(1
													(localproc_1 16 64) ; "This person seems to have just arrived from France. You hear, "Je ne parle pas anglais.""
												)
												(2
													(localproc_1 16 65) ; "No one seems to be listening to you."
												)
												(3
													(localproc_1 16 66) ; "Excuse me, but don't you have a flight to catch?"
												)
											)
										)
									)
									((not (IsFlag 38))
										(localproc_0)
										(localproc_1 16 71) ; "The agent says, "Please, wait your turn!""
									)
									((== local4 1)
										(localproc_0)
										(localproc_1 16 72) ; "The agent says, "Yes, officer, what do you want?""
									)
									(else
										(localproc_0)
										(localproc_1 16 73) ; ""May I help you, sir?" asks the ticket agent."
									)
								)
							)
							((Said '/agent')
								(switch local4
									(1
										(if (IsFlag 38)
											(localproc_1 16 72) ; "The agent says, "Yes, officer, what do you want?""
										else
											(localproc_0)
											(localproc_1 16 74) ; "The ticket agent snaps at you, "Wait your turn, Mister! This lady was ahead of you.""
										)
									)
									(2
										(localproc_0)
										(localproc_1 16 62) ; "The agent looks at you, pauses, and looks down at some paperwork."
									)
									(3
										(localproc_0)
										(localproc_1 16 62) ; "The agent looks at you, pauses, and looks down at some paperwork."
									)
									(0
										(localproc_1 16 75) ; "The ticket agents can't hear you from over there."
									)
									(5
										(localproc_1 16 75) ; "The ticket agents can't hear you from over there."
									)
									(4
										(localproc_1 16 75) ; "The ticket agents can't hear you from over there."
									)
								)
							)
						)
					)
					((Said 'flash,show/badge')
						(cond
							((not (gEgo has: 7)) ; wallet
								(localproc_1 16 76) ; "You don't have your identification with you."
							)
							((or (== local4 4) (== local4 5))
								(localproc_1 16 77) ; "What is this....a shakedown?"
							)
							((== local4 1)
								(localproc_0)
								(SetFlag 38)
								(agentScript changeState: 0)
							)
							((or (== local4 2) (== local4 3))
								(localproc_0)
								(SetFlag 39)
								(agentScript changeState: 0)
							)
							(else
								(localproc_1 16 78) ; "Nobody can see your badge from over there, and besides, what's your purpose?"
							)
						)
					)
					((Said '[*]/bains')
						(localproc_1 16 79) ; "Who's Bains??"
					)
					(
						(or
							(Said 'ask/departure,flight')
							(Said 'is<when/flight<next/houston')
							(Said 'fly,go/houston')
							(Said '/flight,departure<next')
						)
						(if
							(and
								(IsFlag 34)
								(or (== local4 1) (== local4 2) (== local4 3))
							)
							(agentScript changeState: 4)
						else
							(switch (Random 1 4)
								(1
									(localproc_1 16 13) ; "You see from the display that the next flight departs in 2 minutes, headed for Beirut."
								)
								(2
									(localproc_1 16 14) ; "You see from the display that there will be a flight to Houston shortly."
								)
								(3
									(localproc_1 16 15) ; "You see from the display that the vacation special to Coarsegold departs in seven or eight months."
								)
								(4
									(localproc_1 16 16) ; "You see from the display that there are several flights to Steelton today."
								)
							)
						)
					)
					((or (Said '[get,buy]/ticket') (Said 'give/me/ticket'))
						(event claimed: 0)
						(= local3 100)
						(cond
							((or (== local4 0) (== local4 4) (== local4 5))
								(event claimed: 1)
								(switch (Random 1 4)
									(1
										(localproc_1 16 13) ; "You see from the display that the next flight departs in 2 minutes, headed for Beirut."
									)
									(2
										(localproc_1 16 14) ; "You see from the display that there will be a flight to Houston shortly."
									)
									(3
										(localproc_1 16 15) ; "You see from the display that the vacation special to Coarsegold departs in seven or eight months."
									)
									(4
										(localproc_1 16 16) ; "You see from the display that there are several flights to Steelton today."
									)
								)
							)
							((and (== local4 1) (not (IsFlag 38)))
								(localproc_0)
								(event claimed: 1)
								(localproc_1 16 74) ; "The ticket agent snaps at you, "Wait your turn, Mister! This lady was ahead of you.""
							)
							((gEgo inRect: 225 139 265 145)
								(event claimed: 1)
								(localproc_0)
								(localproc_1 16 80) ; "Would you please step around to the front of the counter, Sir?"
							)
							((Said '//houston')
								(= local9 1)
								(agentScript changeState: 5)
							)
							((Said '//steelton')
								(= local10 1)
								(agentScript changeState: 6)
							)
							((Said '//beirut')
								(= local11 1)
								(localproc_1 16 81) ; "After asking for a flight to Beirut, you think..."Hey, Sonny, are you out of your ever-lovin' mind??? That's no place to visit right now!""
							)
							((Said '//coarsegold')
								(= local12 1)
								(localproc_1 16 82) ; "Your ticket to Coarsegold will be $195.00, please."
								(agentScript changeState: 7)
							)
							((Said '//*')
								(localproc_1 16 83) ; "I'm sorry Sir. We don't have any flights to that location."
							)
							(else
								(event claimed: 1)
								(localproc_1 16 84) ; "Would you please be more specific, Sir?"
							)
						)
					)
					(
						(and
							(> local3 0)
							(or
								(gEgo inRect: 175 112 225 130)
								(gEgo inRect: 195 130 225 139)
								(gEgo inRect: 225 139 265 145)
							)
							(cond
								((Said '/houston')
									(= local9 1)
									(agentScript changeState: 5)
								)
								((Said '/steelton')
									(= local10 1)
									(agentScript changeState: 6)
								)
								((Said '/beirut')
									(= local11 1)
									(localproc_1 16 81) ; "After asking for a flight to Beirut, you think..."Hey, Sonny, are you out of your ever-lovin' mind??? That's no place to visit right now!""
								)
								((Said '/coarsegold')
									(= local12 1)
									(localproc_1 16 82) ; "Your ticket to Coarsegold will be $195.00, please."
									(agentScript changeState: 7)
								)
								((Said '/america')
									(localproc_1 16 83) ; "I'm sorry Sir. We don't have any flights to that location."
								)
							)
						))
					(
						(or
							(Said 'ask/ticket')
							(Said 'ask/[agent,man,woman]/ticket')
						)
						(localproc_0)
						(localproc_1 16 84) ; "Would you please be more specific, Sir?"
					)
					((Said 'pay[/agent,man,woman,ticket,flight]')
						(localproc_1 16 85) ; "With what? Good looks?"
					)
					(
						(or
							(Said 'ask,dial,use,get,pick[<up]/phone')
							(Said 'ask,make/call,phone')
						)
						(cond
							((gEgo inRect: 175 112 225 130)
								(localproc_0)
								(if (IsFlag 38)
									(localproc_1 16 86) ; "I'm awfully busy, Officer. Would you see the next agent please?"
								else
									(localproc_1 16 87) ; "I'm sorry, Sir. The telephone is for our use only."
								)
							)
							((gEgo inRect: 195 130 225 139)
								(localproc_0)
								(if (IsFlag 39)
									(= local1 1)
									(localproc_1 16 88) ; "Would you step around to the side of the counter, Officer?"
								else
									(localproc_1 16 87) ; "I'm sorry, Sir. The telephone is for our use only."
								)
							)
							((gEgo inRect: 225 139 265 145)
								(localproc_0)
								(if (IsFlag 39)
									(localproc_1 16 89) ; "Certainly, Officer!"
									(egoOnThePhoneScript changeState: 0)
								else
									(localproc_1 16 87) ; "I'm sorry, Sir. The telephone is for our use only."
								)
							)
							(else
								(localproc_1 16 90) ; "There doesn't seem to be a pay phone. Perhaps one of the ticket agents will let you use their phone."
							)
						)
					)
					(
						(and
							(or
								(Said 'ask,get,give,look,see,show>')
								(Said 'have<do>')
							)
							(or
								(Said '/flight,list,passenger,info')
								(Said '//flight,list,passenger,info')
							)
						)
						(cond
							((or (== local4 0) (== local4 4) (== local4 5))
								(event claimed: 1)
								(localproc_1 16 42) ; "No one near you has any of that information."
							)
							(
								(or
									(and (== local4 1) (IsFlag 38))
									(and
										(or (== local4 2) (== local4 3))
										(IsFlag 39)
									)
								)
								(agentScript changeState: 1)
								(event claimed: 1)
							)
							(else
								(localproc_1 16 43) ; "I'm sorry sir," explains the ticket agent, "but the passenger list is confidential information."
								(event claimed: 1)
							)
						)
					)
				)
			)
		)
	)
)

(instance moveScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(agent
					startUpd:
					setLoop: 3
					setCel: -1
					setMotion: MoveTo (Random 245 260) 110 self
				)
			)
			(1
				(agent setLoop: 4 setCel: 0 stopUpd:)
				(= local2 (Random 80 150))
			)
			(2
				(agent
					startUpd:
					setLoop: 2
					setCel: -1
					setMotion: MoveTo 230 110 self
				)
			)
			(3
				(agent stopUpd:)
				(= local2 (Random 80 150))
			)
			(4
				(self changeState: 0)
			)
			(5
				(agent startUpd: setLoop: 2 setMotion: MoveTo 230 110 self)
			)
			(6
				(moveScript changeState: 9)
			)
			(7
				(agent
					startUpd:
					setLoop: (if (< (gEgo x:) (agent x:)) 2 else 3)
					setMotion: MoveTo (gEgo x:) 110 self
				)
			)
			(8
				(agent setLoop: 4 setCel: 0)
				(= local7 1)
				(self cue:)
			)
			(9
				(agent stopUpd:)
				(cond
					((== gPrevRoomNum 12) ; phone
						(= local6 1)
					)
					((not local6)
						(localproc_1 16 73 83) ; ""May I help you, sir?" asks the ticket agent."
						(localproc_0)
						(= local6 1)
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
				(localproc_1 16 72) ; "The agent says, "Yes, officer, what do you want?""
			)
			(1
				(localproc_1 16 91) ; "The ticket agent hands you a list of flights and passengers and says, "Here you are, officer.""
				(switch local4
					(2
						(localproc_1 16 92) ; "You carefully look over the list but nothing rings a bell."
					)
					(3
						(localproc_1 16 92) ; "You carefully look over the list but nothing rings a bell."
					)
					(1
						(if (or (< global100 6) (== global100 13) (IsFlag 34))
							(localproc_1 16 92) ; "You carefully look over the list but nothing rings a bell."
						else
							(SetScore 3 82)
							(localproc_1 16 93) ; "Carefully scanning the passenger list, a name catches your eye. "Luis Pate.""
							(localproc_1 16 94) ; "You blurt out to the agent, "Luis Pate....that's the jailer's name! Bains is using the jailer's ID!""
							(localproc_1 16 95) ; "The destination listed is Houston."
							(self cue:)
						)
					)
				)
			)
			(2
				(if (!= (gContinuousMusic state:) 3)
					(gContinuousMusic number: 29 loop: -1 play:)
				)
				(localproc_1 16 96 83) ; "The ticket agent advises you that the Houston flight departed approximately 20 minutes ago."
				(SetFlag 34)
				(self cue:)
			)
			(3
				(if (== global131 13)
					(= local8 1)
				)
			)
			(4
				(localproc_1 16 97 25 4) ; "The agent informs you..."I'm sorry, but there are no more Houston flights today.""
				(localproc_1 16 98) ; "However," she continues, "there is a connecting flight to Denver leaving shortly."
			)
			(5
				(cond
					((and (gEgo has: 16) (== global195 0)) ; plane_ticket
						(localproc_1 16 99) ; "You already have your ticket to Houston."
					)
					((IsFlag 166)
						(localproc_1 16 100) ; "You already tried to go to Houston. The Captain would not authorize another flight."
					)
					((IsFlag 36)
						(if (not (gEgo has: 16)) ; plane_ticket
							(localproc_1 16 101) ; "Yes, Sir," the agent says, "we have been given authorization by the Police Department to get both of you onto the connecting flight for Houston."
							(localproc_1 16 102) ; "Here are your tickets, gentlemen. The flight will be boarding at Gate 12, up the escalator and to your right."
						else
							(localproc_1 16 103) ; "You trade in your unused ticket to Steelton for a ticket to Houston."
						)
						(= local9 0)
						(gEgo get: 16) ; plane_ticket
						(= global195 0)
						(ClearFlag 36)
						(HandsOn)
					)
					(else
						(localproc_1 16 104) ; "Your ticket to Houston will be $195.00, please."
						(localproc_1 16 105) ; "You look at the folding cash in your money clip, and you know beyond the shadow of a doubt that you'll never board that flight for Houston if you have to pay for it yourself."
						(HandsOn)
						(if
							(and
								(gCast contains: global112)
								(not (IsFlag 36))
								local13
							)
							(global112 setScript: getTheTicketScript)
						)
					)
				)
			)
			(6
				(cond
					((== global195 1)
						(localproc_1 16 106) ; "You already have your ticket to Steelton."
					)
					((IsFlag 37)
						(if (not (gEgo has: 16)) ; plane_ticket
							(localproc_1 16 107) ; "Yes, Sir," the agent says, "we have been given authorization by the Police Department to get both of you onto the next flight for Steelton."
							(localproc_1 16 102) ; "Here are your tickets, gentlemen. The flight will be boarding at Gate 12, up the escalator and to your right."
							(if (gEgo has: 10) ; field_kit
								(localproc_1 16 108) ; ""You check your field kit onto the Steelton flight."
							)
						else
							(localproc_1 16 109) ; "You trade in your unused ticket to Houston for a ticket to Steelton."
						)
						(= local10 0)
						(SetScore 3 155)
						(gEgo get: 16) ; plane_ticket
						(= global195 1)
						(if (IsObject gFKit)
							(gFKit dispose:)
							(= global240 0)
						)
						(gEgo put: 10 16) ; field_kit
						(HandsOn)
					)
					(else
						(localproc_1 16 110) ; "Your ticket to Steelton will be $160.00, please."
						(localproc_1 16 111) ; "You look at the folding cash in your money clip, and you know beyond the shadow of a doubt that you'll never board that flight for Steelton if you have to pay for it yourself."
						(HandsOn)
						(if
							(and
								(gCast contains: global112)
								(not (IsFlag 37))
								local14
							)
							(global112 setScript: getTheTicketScript)
						)
					)
				)
			)
			(7
				(localproc_1 16 112) ; "You dig into your money clip, but you can't come up with enough for the ticket. "Oh, well," you think, "It's not the right season to visit Coarsegold anyway!""
			)
		)
	)
)

(instance keithJoinsEgoScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(global112 posn: 165 209 setMotion: MoveTo 168 180 self)
			)
			(1
				(localproc_1 16 113 83 25 3) ; "Here comes Keith."
				(global112 setMotion: MoveTo 168 151 self)
			)
			(2
				(global112 loop: 0 cel: 2)
				(if (< (gEgo y:) 115)
					(gEgo setMotion: MoveTo 155 114 self)
				else
					(self cue:)
				)
			)
			(3
				(gEgo
					setMotion: MoveTo (+ (global112 x:) 20) (global112 y:) self
				)
			)
			(4
				(gEgo loop: 1)
				(switch global169
					(1
						(= global169 3)
						(localproc_1 16 114 83) ; "Keith says, "Well, old buddy...while you were in here wondering what to do, I managed to find Bains stolen car out there in the parking lot.""
						(localproc_1 16 115) ; "I've already notified dispatch, and they've towed it on down to the impound lot."
						(localproc_1 16 116) ; "Anyway, what have you found out?"
					)
					(2
						(localproc_1 16 117 83) ; "Keith says, "Well, old buddy...while you were in here wondering what to do, I managed to notify dispatch, and they've towed that stolen car on down to the impound lot.""
						(localproc_1 16 116) ; "Anyway, what have you found out?"
					)
					(3
						(localproc_1 16 118 83) ; "Keith says, "Well old buddy...I couldn't find anything else out there. They've towed the stolen car away. Anything happening in here?""
					)
				)
				(= global169 0)
				(self cue:)
			)
			(5
				(localproc_1 16 119 83) ; "You tell Keith that you found Luis Pate's name on a list of passengers for a Houston flight."
				(localproc_1 16 120) ; "It HAS to be Bains that bought that ticket!" you tell Keith. "He must've used Pate's identification."
				(global112 setMotion: Follow gEgo 25)
				(HandsOn)
			)
		)
	)
)

(instance getTheTicketScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(localproc_1 16 121) ; "Keith jumps in, saying "Hey, Sonny, put your wallet away! Let me call Captain Hall for authorization to purchase tickets.""
				(= local15 1)
				(global112 setMotion: 0)
				(self cue:)
			)
			(1
				(if (< (global112 y:) (+ (gEgo y:) 5))
					(global112
						setMotion:
							MoveTo
							(- (gEgo x:) 20)
							(+ (gEgo y:) 5)
							self
					)
				else
					(self cue:)
				)
			)
			(2
				(global112 setMotion: MoveTo 258 142 self)
			)
			(3
				(global112 loop: 3)
				(agent
					setLoop: 3
					setCel: 0
					setMotion: MoveTo 244 119 self
					illegalBits: 0
				)
			)
			(4
				(localproc_1 16 122 25 7 83) ; "Keith shows his badge to the ticket agent and requests permission to use the desk phone."
				(self cue:)
			)
			(5
				(global112 hide:)
				(agent setCel: -1 hide:)
				((= local0 (Prop new:))
					view: 667
					loop: 0
					posn: 253 138
					init:
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(6
				(localproc_1 16 123 25 10 83) ; "As Keith calls to arrange for the purchase of your tickets, your mind works furiously as you try to put together all the pieces of information you've gathered in the course of your investigation."
				(self cue:)
			)
			(7
				(local0 setCycle: Beg self)
			)
			(8
				(local0 dispose:)
				(global112 show:)
				(agent show:)
				(self cue:)
			)
			(9
				(agent setMotion: MoveTo 244 110)
				(global112 setMotion: Follow gEgo 25)
				(if (or local14 local13)
					(localproc_1 16 124 83) ; "Hey, man," Keith tells you, "it's all set. Fletch has a purchase order for our tickets, and he's getting it cleared with the ticket agent right now."
					(cond
						(local9
							(SetFlag 36)
							(= local9 0)
						)
						(local10
							(SetFlag 37)
							(= local10 0)
							(if (not (IsFlag 94))
								(localproc_1 16 125) ; "And Sonny," Keith says, "the Captain suggests that you call Steelton Police and have them warn Colby that Bains is loose."
							)
						)
					)
				else
					(localproc_1 16 126) ; "Hey, man," Keith tells you, "Fletch said that we don't have near enough evidence booked to justify authorization from him to go flying off anywhere."
					(localproc_1 16 127) ; "I guess we'll just have to continue our investigation right here in Lytton."
				)
				(HandsOn)
				(self cue:)
			)
			(10
				(= local15 0)
				(moveScript changeState: 2)
			)
		)
	)
)

(instance egoOnThePhoneScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (IsFlag 40)
					(if (global112 inRect: 225 139 280 145)
						(HandsOff)
						(global112
							setMotion:
								MoveTo
								(if (> (gEgo x:) (global112 x:))
									210
								else
									290
								)
								(global112 y:)
								self
						)
					else
						(self cue:)
					)
				else
					(self cue:)
				)
			)
			(1
				(HandsOn)
				(gEgo setMotion: MoveTo 258 139 self)
			)
			(2
				(= local1 0)
				(gEgo loop: 3)
				(agent
					setLoop: 3
					setCel: 0
					setMotion: MoveTo 244 119 self
					illegalBits: 0
				)
			)
			(3
				(localproc_1 16 128 25 3 83) ; "You pick up the phone."
				(self cue:)
			)
			(4
				(HandsOff)
				(agent setCel: -1 hide:)
				(gEgo
					view: 667
					loop: 1
					posn: 253 139
					init:
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(5
				(= gPerspective 0)
				(gCurRoom newRoom: 12) ; phone
			)
			(6
				(gEgo setCycle: Beg self)
			)
			(7
				(HandsOn)
				(NormalEgo)
				(gEgo view: 1 loop: 1 posn: 260 139)
				(agent setLoop: 3 setCel: 0 posn: 244 119)
			)
		)
	)
)

(instance pictureOnWall of PV
	(properties
		y 88
		x 44
		view 77
		loop 7
		cel 2
		priority 8
		signal 16384
	)
)

(instance sittingPerson of PV
	(properties
		y 125
		x 55
		view 77
		loop 5
		priority 8
		signal 16384
	)
)

(instance counterPerson of PV
	(properties
		y 124
		x 179
		view 77
		loop 5
		cel 1
		priority 8
	)
)

(instance talking1 of PV
	(properties
		y 150
		x 78
		view 77
		loop 5
		cel 2
		priority 11
	)
)

(instance talking2 of PV
	(properties
		y 151
		x 101
		view 77
		loop 5
		cel 3
		priority 11
	)
)

(instance talking3 of PV
	(properties
		y 153
		x 91
		view 77
		loop 5
		cel 4
		priority 11
	)
)

(instance standing1 of PV
	(properties
		y 98
		x 145
		view 77
		loop 6
		cel 4
		priority 5
	)
)

(instance standing2 of PV
	(properties
		y 103
		x 240
		view 77
		loop 6
		cel 1
		priority 5
		signal 16384
	)
)

(instance standing3 of PV
	(properties
		y 104
		x 171
		view 77
		loop 6
		cel 2
		priority 5
	)
)

(instance standing4 of PV
	(properties
		y 106
		x 164
		view 77
		loop 6
		priority 5
	)
)

(instance standing5 of PV
	(properties
		y 100
		x 154
		view 77
		loop 6
		cel 3
		priority 5
	)
)

(instance case of PV
	(properties
		y 129
		x 61
		view 77
		loop 7
		cel 1
		priority 9
	)
)

(instance SIGN of PV
	(properties
		y 70
		x 29
		view 77
		loop 7
		priority 9
	)
)

(instance poster1 of PV
	(properties
		y 117
		x 190
		view 77
		loop 7
		cel 3
		priority 8
		signal 16384
	)
)

(instance poster2 of PV
	(properties
		y 126
		x 212
		view 77
		loop 7
		cel 4
		priority 9
		signal 16384
	)
)

(instance agent2 of PV
	(properties
		y 103
		x 211
		view 77
		loop 4
		cel 1
		priority 8
	)
)

