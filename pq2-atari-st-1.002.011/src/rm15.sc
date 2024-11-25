;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 15)
(include sci.sh)
(use Main)
(use Interface)
(use AutoDoor)
(use Wander)
(use Avoid)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm15 0
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
	local19
)

(procedure (localproc_0)
	(if (> (gEgo y:) 150)
		(Print &rest #at -1 15)
	else
		(Print &rest #at -1 120)
	)
)

(instance flowerSounds of Sound
	(properties
		number 20
	)
)

(instance egoSquashed of Sound
	(properties
		number 23
	)
)

(instance taxi of View
	(properties)
)

(instance flowerGirl of Act
	(properties)
)

(instance lightPole of Prop
	(properties)
)

(instance rm15 of Rm
	(properties
		picture 15
		style 0
	)

	(method (dispose)
		(flowerScript dispose:)
		(DisposeScript 301)
		(super dispose:)
	)

	(method (init)
		(Load rsVIEW 1)
		(Load rsVIEW 76)
		(if (or (gEgo has: 11) (< global100 8)) ; potted_plant
			(Load rsVIEW 43)
		)
		(super init:)
		(= gPerspective 70)
		(= local19 0)
		(HandsOn)
		(= global212 3)
		((View new:) view: 76 loop: 3 cel: 0 posn: 120 52 init: addToPic:)
		((View new:) view: 76 loop: 0 cel: 0 posn: 263 122 init: addToPic:)
		((View new:) view: 76 loop: 0 cel: 1 posn: 297 123 init: addToPic:)
		((View new:) view: 76 loop: 0 cel: 2 posn: 273 124 init: addToPic:)
		((View new:) view: 76 loop: 0 cel: 3 posn: 251 124 init: addToPic:)
		((View new:)
			view: 76
			loop: 0
			cel: 4
			posn: (if (== (Random 1 2) 1) 250 else 272) 124
			init:
			addToPic:
		)
		((View new:) view: 76 loop: 4 cel: 0 posn: 38 140 init: addToPic:)
		(lightPole
			view: 76
			loop: 0
			cel: 6
			posn: 73 128
			init:
			stopUpd:
			setScript: lightScript
		)
		((= local1 (AutoDoor new:))
			view: 76
			loop: 1
			posn: 117 108
			entranceTo: 16
			facingLoop: 3
			cycleSpeed: 1
			init:
			stopUpd:
		)
		(= local3 2)
		(= local4 15)
		(= local5 7)
		(self setLocales: 153)
		(self setScript: rm15Script)
	)

	(method (doit)
		(local1 doit:)
		(if (gCast contains: global112)
			(global112 setMotion: Follow gEgo 25)
		)
		(cond
			(local19 0)
			((> (gEgo x:) 325)
				(localproc_0 15 0) ; "Although it occurs to you that you could easily walk around the airport, you decide to stick to the business at hand."
				(gEgo setMotion: MoveTo 300 (gEgo y:))
			)
			((< (gEgo x:) -5)
				(localproc_0 15 0) ; "Although it occurs to you that you could easily walk around the airport, you decide to stick to the business at hand."
				(gEgo setMotion: MoveTo 20 (gEgo y:))
			)
		)
		(cond
			((<= (gEgo y:) 124)
				(if (!= (mod (gEgo view:) 2) 0)
					(gEgo view: (- (gEgo view:) 1))
				)
			)
			((!= (mod (gEgo view:) 2) 1)
				(gEgo view: (+ (gEgo view:) 1))
			)
		)
		(if
			(and
				(not local8)
				(not local12)
				(not (gEgo has: 11)) ; potted_plant
				(< global100 8)
				(or
					(== gPrevRoomNum 16)
					(and (== gPrevRoomNum 14) (< (gEgo y:) 140))
				)
			)
			(flowerScript changeState: 0)
		)
		(if
			(and
				local10
				(or (== (flowerScript state:) 0) (== (flowerScript state:) 1))
			)
			(cond
				((> (gEgo x:) 245)
					(= local18 1)
					(flowerGirl setMotion: 0)
				)
				(local18
					(= local18 0)
					(flowerGirl setMotion: Follow gEgo 25)
				)
			)
		)
		(if
			(and
				(not local10)
				(not local11)
				local8
				(<= (flowerGirl distanceTo: gEgo) 25)
			)
			(= local10 1)
			(= local9 0)
			(flowerScript changeState: 1)
		)
		(if (and local8 (> (gEgo y:) 145))
			(flowerGirl stopUpd:)
		else
			(flowerGirl startUpd:)
		)
		(cond
			((not local16)
				(if (and (not local6) (> 176 (gEgo y:) 142))
					(= local16 1)
					(if (<= (gEgo y:) 150)
						(= local17 2)
					else
						(= local17 -2)
					)
					(egoSquashed play:)
					(taxi posn: 450 (+ (gEgo y:) 2))
				)
			)
			((< (taxi x:) -35)
				(if (< (rm15Script state:) 1)
					(= local16 0)
				)
			)
			(else
				(taxi
					posn:
						(- (taxi x:) 50)
						(if (> 173 (gEgo y:) 142)
							(+ (gEgo y:) 2)
						else
							(taxi y:)
						)
					setPri: (+ (gEgo priority:) local17)
				)
				(if (> (taxi priority:) 14)
					(taxi priority: 15)
				)
				(if (< (taxi priority:) 10)
					(taxi priority: 10)
				)
			)
		)
		(cond
			((< (gEgo x:) -20)
				(gEgo x: -20)
			)
			(
				(and
					(< -25 (- (taxi x:) (gEgo x:)) 65)
					(> 9 (- (taxi y:) (gEgo y:)) -6)
					(< (rm15Script state:) 1)
					(> 176 (gEgo y:) 138)
					(not local6)
				)
				(rm15Script changeState: 1)
			)
			((== (local1 doorState:) 2)
				(= gPerspective 0)
				(gCurRoom newRoom: 16)
			)
			((> (gEgo y:) 210)
				(= global108 (gEgo x:))
				(= global212 2)
				(= gPerspective 0)
				(gCurRoom newRoom: 14)
			)
		)
		(super doit:)
	)
)

(instance rm15Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SL enable:)
				(if (== gPrevRoomNum 14)
					(cond
						((< global108 58)
							(gEgo
								view: (if global204 7 else 1)
								posn: -10 189
								setCycle: Walk
								init:
								setMotion: MoveTo 25 189
							)
						)
						((> global108 161)
							(gEgo
								view: (if global204 7 else 1)
								posn: 327 189
								setCycle: Walk
								init:
								setMotion: MoveTo 275 189
							)
						)
						(else
							(gEgo
								view: (if global204 7 else 1)
								posn: (* (- global108 57) 3) 195
								setCycle: Walk
								init:
								setMotion: MoveTo (* (- global108 57) 3) 189
							)
						)
					)
				else
					(gEgo
						view: (if global204 6 else 0)
						posn: 115 117
						setCycle: Walk
						init:
						illegalBits: $8000
						setMotion: MoveTo 115 122
					)
				)
				(if (IsFlag 40)
					((= global112 (Act new:))
						view: 20
						init:
						setCycle: Walk
						setAvoider: (Avoid new:)
						setMotion: Follow gEgo 25
					)
					(if (== gPrevRoomNum 16)
						(global112 posn: 103 113 loop: 2)
					else
						(global112 posn: (+ (gEgo x:) 20) 200)
					)
				)
				(taxi
					view: 76
					loop: 2
					cel: 0
					posn:
						450
						(if (< (gEgo y:) 176)
							(gEgo y:)
						else
							176
						)
					init:
					ignoreActors:
				)
			)
			(1
				(HandsOff)
				((= local2 (Act new:))
					view: 76
					posn:
						(if (> (gEgo x:) 325)
							322
						else
							(gEgo x:)
						)
						(gEgo y:)
					loop: 5
					cel: 0
					setMotion: 0
					cycleSpeed: 2
					init:
					setCycle: End self
				)
				(gEgo dispose:)
				(= local15 0)
				(= local19 1)
			)
			(2
				(local2
					setLoop: 6
					cel: 0
					setMotion: MoveTo (- (local2 x:) 20) (local2 y:)
					setCycle: End self
				)
			)
			(3
				(local2 setLoop: 7 setCel: 0 stopUpd: addToPic:)
				(= cycles 12)
				(User canInput: 0)
			)
			(4
				(if (IsFlag 40)
					(global112 loop: 1)
					(localproc_0 15 1 83) ; "Gee, that taxi cab was SPEEDING! You'd better get up and give him a ticket, Sonny. Sonny? SONNY!?"
				)
				(= cycles 12)
			)
			(5
				(Print 15 2 #width 26 #at 221 62 #time 3) ; "My, My!"
				(Print 15 3 #width 50 #at 252 60 #time 4) ; "Didja see that?"
				(if local7
					(EgoDead
						{You took too much time getting across the street. Too bad...so sad...you've been had!}
					)
				else
					(EgoDead
						{You forgot to look both ways and wait for the light. Didn't your mother tell you about that?}
					)
				)
			)
		)
	)

	(method (handleEvent event)
		(switch (event type:)
			(evSAID
				(cond
					((or (Said 'give/newspaper') (Said 'ask,get/newspaper'))
						(if (gEgo inRect: 206 110 305 145)
							(localproc_0 15 4) ; "They won't let you have it."
						else
							(localproc_0 15 5) ; "Get closer."
						)
					)
					((Said 'look>')
						(cond
							((Said '/ave,sidewalk,bridge,(walk<side)')
								(localproc_0 15 6) ; "A crosswalk is painted on the street near the front entrance of the airport."
							)
							((Said '/box')
								(localproc_0 15 7) ; "The box is equipped with a button....that's all."
							)
							((Said '/pane')
								(localproc_0 15 8) ; "Because of the reflective coating on the windows, you can't see through them."
							)
							((Said '/men,man,person,crowd')
								(Print 15 9 #at -1 15) ; "At the moment, a couple of people are sitting on a bench in front of the building entrance. One of them is reading the Lytton Tribune. The other one, too cheap to buy his own paper, is reading over his shoulder."
							)
							((Said '/bench')
								(localproc_0 15 10) ; "It's a concrete bus stop bench with advertising on it."
							)
							((Said '/advertise,ad')
								(localproc_0 15 11) ; "The people are sitting in front of the advertising on the bench."
							)
							((Said '/way<both')
								(localproc_0 15 12) ; "OK."
							)
							((Said '/awning')
								(localproc_0 15 13) ; "It shelters the entrance and provides some decoration."
							)
							((Said '<below/auto')
								(localproc_0 15 14) ; "There's nothing down there."
							)
							((Said '/auto')
								(if (gEgo inRect: 80 108 120 150)
									(localproc_0 15 15) ; "Looking at the license, you can see that the registration's expired."
								else
									(localproc_0 15 16) ; "It's blue, just like yours!"
								)
							)
							((Said '/door')
								(localproc_0 15 17) ; "It's one of those automatic sliding doors."
							)
							((Said '/sign')
								(localproc_0 15 18 25 4) ; "The sign above the entrance says...in HUGE letters..."LYTTON AIRPORT.""
								(localproc_0 15 19) ; "The sign above the bench tells you which buses stop here."
							)
							((or (Said '/air') (Said '<up'))
								(localproc_0 15 20) ; "You look up as yet another airliner roars above your head."
							)
							((or (Said '/dirt') (Said '<down'))
								(localproc_0 15 21) ; "Your shoes need polishing."
							)
							((Said '[<at,around][/building,airport,terminal]')
								(Print 15 22 #at -1 15) ; "The new Lytton Airport is an awe-inspiring sight. Jets and small private aircraft take off and land with dizzying frequency. You are impressed!!"
							)
							((Said '/pole,light[<traffic]')
								(if (> (gEgo y:) 150)
									(localproc_0 15 23) ; "You see a "signal control box" attached to the light pole."
								else
									(localproc_0 15 24) ; "You see a "signal control box" attached to the traffic light."
								)
							)
							((Said '/button')
								(if (== (gEgo onControl: 1) 2048)
									(localproc_0 15 25) ; "The button on the post is labeled: 'WALK'."
								else
									(localproc_0 15 26) ; "There is a button on the post."
								)
							)
							((Said '/flower,basket')
								(cond
									(local10
										(Print 15 27 #at -1 15) ; "I have some lovely flowers...." the flower girl says. "Single roses, a bouquet of carnations....even some easy-to-care-for potted plants. You'll get a big kiss if you give these to your girl!"
									)
									(local9
										(localproc_0 15 28) ; "Someone is coming to show you flowers."
									)
									(local11
										(localproc_0 15 29) ; "She's off to find another customer."
									)
									(else
										(event claimed: 0)
									)
								)
							)
							((Said '/woman,wanda')
								(cond
									((or local10 local9)
										(localproc_0 15 30) ; "She's large and lovely!"
									)
									(local11
										(localproc_0 15 29) ; "She's off to find another customer."
									)
									(else
										(localproc_0 15 31) ; "She's not here."
									)
								)
							)
						)
					)
					((Said 'show/shot,mugshot,painting')
						(if (or (gEgo has: 12) (gEgo has: 23)) ; new_mug_shot, old_mug_shot
							(if (or (gEgo inRect: 206 110 305 145) local10)
								(localproc_0 15 32) ; "Nope. Never saw the guy."
							else
								(localproc_0 15 33) ; "No one can see the mug shot."
							)
						)
					)
					(
						(or
							(Said 'show,see,ask,talk/flower,rose,bouquet,plant')
							(Said
								'show,ask,talk[/woman,me]/flower,rose,bouquet,plant'
							)
							(Said '(have<do)<what')
						)
						(cond
							((not local8)
								(localproc_0 15 34) ; "What flowers? Where?"
							)
							(local9
								(localproc_0 15 28) ; "Someone is coming to show you flowers."
							)
							(local11
								(localproc_0 15 29) ; "She's off to find another customer."
							)
							(else
								(Print 15 27 #at -1 15) ; "I have some lovely flowers...." the flower girl says. "Single roses, a bouquet of carnations....even some easy-to-care-for potted plants. You'll get a big kiss if you give these to your girl!"
							)
						)
					)
					((Said 'give/flower,rose,bouquet,carnation,plant')
						(cond
							(local8
								(localproc_0 15 35) ; "She won't just GIVE flowers to you. You have to BUY them."
							)
							(local11
								(localproc_0 15 29) ; "She's off to find another customer."
							)
							(else
								(localproc_0 15 36) ; "You can't get flowers right now."
							)
						)
					)
					((Said 'smell/flower,rose,carnation,bouquet,plant')
						(if (gEgo has: 11) ; potted_plant
							(localproc_0 15 37) ; "Just like perfume."
						else
							(localproc_0 15 38) ; "You should buy one so that you can smell it."
						)
					)
					((Said 'polish')
						(localproc_0 15 39) ; "Not NOW!"
					)
					((Said 'show/badge')
						(cond
							((gEgo inRect: 206 110 305 145)
								(localproc_0 15 40) ; "Simultaneously, both men say: "HE did it!""
							)
							(local10
								(localproc_0 15 41) ; "She says, "Well...I bet even cops like flowers!""
							)
							(else
								(localproc_0 15 42) ; "Nobody's close enough to see your badge."
							)
						)
					)
					(
						(or
							(Said 'stay')
							(Said 'come<back')
							(Said 'dont')
							(Said 'stop')
						)
						(cond
							(local13
								(localproc_0 15 43) ; "You've done it now, Sonny! She's not coming back."
							)
							(local11
								(localproc_0 15 29) ; "She's off to find another customer."
							)
							(else
								(localproc_0 15 44) ; "Huh?"
							)
						)
					)
					((Said 'give,write/ticket')
						(localproc_0 15 45) ; "You're a Homicide Detective, not a meter maid."
					)
					((Said 'cross/ave')
						(localproc_0 15 46) ; "Here we go."
						(gEgo setMotion: MoveTo 165 150)
					)
					((Said 'get,call,hail/cab')
						(localproc_0 15 47) ; "There's never one around when you need one."
					)
					((Said '/bus')
						(localproc_0 15 48) ; "Not a one in sight."
					)
					((Said 'sat[<down]')
						(localproc_0 15 49) ; "You have better things to do, and besides, those guys on the bench seem to want it all to themselves."
					)
					((Said 'get,drive/auto')
						(localproc_0 15 50) ; "What kind of cop are you?? That's NOT your car!!"
					)
					((Said 'frisk/auto')
						(localproc_0 15 51) ; "C'mon, Sonny! Expired registration is no reason to seek a search warrant!"
					)
					((Said 'open/door[<auto]')
						(if (< (gEgo x:) 100)
							(localproc_0 15 50) ; "What kind of cop are you?? That's NOT your car!!"
						else
							(localproc_0 15 52) ; "The airport door is automatic. Just step in."
						)
					)
					((Said 'open/trunk')
						(if (< (gEgo x:) 100)
							(localproc_0 15 50) ; "What kind of cop are you?? That's NOT your car!!"
						else
							(localproc_0 15 44) ; "Huh?"
						)
					)
					((Said 'break/pane')
						(localproc_0 15 53) ; "And you'll be breaking the law!"
					)
					((Said 'get,buy/flower')
						(if local10
							(localproc_0 15 54) ; "Great!" she says. "Which ones do you want?"
						else
							(localproc_0 15 55) ; "There are none available at this moment."
						)
					)
					((or (Said '[buy,get]/yellow') (Said '/1,flower<yellow'))
						(if local10
							(localproc_0 15 56) ; "I'm sorry, sir. The yellow flowers have wilted. Perhaps you'd like something else."
						else
							(localproc_0 15 44) ; "Huh?"
						)
					)
					((or (Said '[buy,get]/red') (Said '/1,flower<red'))
						(if local10
							(localproc_0 15 57) ; "Which ones? I have roses and carnations."
						else
							(localproc_0 15 44) ; "Huh?"
						)
					)
					((Said '[buy,get]/rose')
						(cond
							((not (gEgo has: 11)) ; potted_plant
								(if local10
									(if (gEgo has: 4) ; money_clip
										(if (> global107 local3)
											(-= global107 local3)
											(localproc_0 15 58) ; "Thank you, sir." she says. "It's a beautiful rose! That will be $2.00 please."
											(localproc_0 15 59) ; "You pay the young lady and send her on her way."
											(SetScore 2 80)
											(gEgo get: 11) ; potted_plant
											((gInventory at: 11) cel: 1) ; potted_plant
											(flowerScript changeState: 2)
										else
											(localproc_0 15 60) ; "Have you checked your money clip lately? You can't afford this!"
										)
									else
										(localproc_0 15 61) ; "Where's your money?"
									)
								else
									(localproc_0 15 55) ; "There are none available at this moment."
								)
							)
							(local10
								(localproc_0 15 62) ; "I'm sorry, sir." she says. "That was my last one. Is there something else you'd like?"
							)
							(else
								(localproc_0 15 63) ; "You already bought it."
							)
						)
					)
					((Said '[buy,get]/bouquet,carnation')
						(cond
							((not (gEgo has: 11)) ; potted_plant
								(if local10
									(if (> global107 local4)
										(-= global107 local4)
										(localproc_0 15 64) ; "Thank you, sir." she says. "It's a beautiful bouquet! That will be $15.00 please."
										(localproc_0 15 59) ; "You pay the young lady and send her on her way."
										(SetScore 2 80)
										(gEgo get: 11) ; potted_plant
										((gInventory at: 11) cel: 2) ; potted_plant
										(flowerScript changeState: 2)
									else
										(localproc_0 15 60) ; "Have you checked your money clip lately? You can't afford this!"
									)
								else
									(localproc_0 15 55) ; "There are none available at this moment."
								)
							)
							(local10
								(localproc_0 15 62) ; "I'm sorry, sir." she says. "That was my last one. Is there something else you'd like?"
							)
							(else
								(localproc_0 15 63) ; "You already bought it."
							)
						)
					)
					((Said '[buy,get]/plant')
						(cond
							((not (gEgo has: 11)) ; potted_plant
								(if local10
									(if (> global107 local5)
										(-= global107 local5)
										(localproc_0 15 65) ; "Thank you, sir." she says. "It's a beautiful plant! That will be $7.00 please."
										(localproc_0 15 59) ; "You pay the young lady and send her on her way."
										(SetScore 2 80)
										(gEgo get: 11) ; potted_plant
										((gInventory at: 11) cel: 0) ; potted_plant
										(flowerScript changeState: 2)
									else
										(localproc_0 15 60) ; "Have you checked your money clip lately? You can't afford this!"
									)
								else
									(localproc_0 15 55) ; "There are none available at this moment."
								)
							)
							(local10
								(localproc_0 15 62) ; "I'm sorry, sir." she says. "That was my last one. Is there something else you'd like?"
							)
							(else
								(localproc_0 15 63) ; "You already bought it."
							)
						)
					)
					((Said 'use,press/button')
						(if (== (gEgo onControl: 1) 2048)
							(localproc_0 15 66) ; "You push the button activating the traffic control light. You can now safely cross the street."
							(= local6 1)
							(lightScript changeState: 1)
							(if (> (gEgo y:) 170)
								(SetScore 1 78)
							else
								(SetScore 1 79)
							)
						else
							(localproc_0 15 67) ; "You're not close enough to the button."
						)
					)
					((Said 'talk/man,men,person,crowd')
						(if (gEgo inRect: 206 110 305 145)
							(localproc_0 15 68) ; "The man reading the paper says, "Get outta here, pal! I'm trying to find out if my horse won.""
							(localproc_0 15 69) ; "The other guy says "Yeah! Me too!""
						else
							(localproc_0 15 70) ; "You can't be heard over the airport noise."
						)
					)
					((Said 'talk/woman,woman,wanda[<flower]')
						(cond
							((not local8)
								(localproc_0 15 71) ; "What girl? Where?"
							)
							(local9
								(localproc_0 15 70) ; "You can't be heard over the airport noise."
							)
							(local11
								(localproc_0 15 29) ; "She's off to find another customer."
							)
							(else
								(Print 15 27 #at -1 15) ; "I have some lovely flowers...." the flower girl says. "Single roses, a bouquet of carnations....even some easy-to-care-for potted plants. You'll get a big kiss if you give these to your girl!"
							)
						)
					)
					(
						(or
							(Said 'much<how[/flower]')
							(Said 'are/flower')
							(Said 'give,tell,ask[/me,woman,wanda]/cost')
							(Said 'give,tell,ask/cost')
						)
						(if local10
							(localproc_0 15 72) ; "The girl says, "The single roses are $2.00, the bouquets are $15.00, and the beautiful potted plants are only $7.00.""
						else
							(localproc_0 15 73) ; "You can't buy anything right now."
						)
					)
					((Said 'pay')
						(if local10
							(if (gEgo has: 11) ; potted_plant
								(localproc_0 15 74) ; "You've already bought something. You'd better watch your cash flow situation."
							else
								(localproc_0 15 75) ; "Choose a posie to purchase."
							)
						else
							(localproc_0 15 76) ; "There's nothing to pay for right now."
						)
					)
					((Said 'yes')
						(if local10
							(localproc_0 15 54) ; "Great!" she says. "Which ones do you want?"
						else
							(localproc_0 15 77) ; "OK, yes...what??"
						)
					)
					((Said 'no')
						(if local10
							(localproc_0 15 78 25 4) ; "Okay. Maybe some other time, sugar."
							(localproc_0 15 79) ; "The young lady thanks you as she walks away. You then hear her mumble under her breath. "Cheapskate.""
							(flowerScript changeState: 2)
						else
							(localproc_0 15 80) ; "No...what??"
						)
					)
					((Said 'ask/name[<woman]')
						(cond
							(local10
								(localproc_0 15 81) ; "Around here," she says, "they call me Wired Wanda."
							)
							(local11
								(localproc_0 15 29) ; "She's off to find another customer."
							)
							(local9
								(localproc_0 15 82) ; "Wait a minute!"
							)
							(else
								(localproc_0 15 31) ; "She's not here."
							)
						)
					)
					((Said 'kiss/woman,wanda')
						(cond
							(local10
								(localproc_0 15 83) ; "Embarrassed, she turns three shades of red and says..."No, thank you.""
							)
							(local9
								(localproc_0 15 84) ; "Boy! You just can't wait, can you?"
							)
							(local11
								(localproc_0 15 85) ; "Too late!"
							)
							(else
								(localproc_0 15 86) ; "Too bad! She's not here."
							)
						)
					)
					(
						(or
							(Said 'fuck,eat,blow/woman,wanda')
							(Said 'feel/boob,cunt')
						)
						(cond
							(local10
								(localproc_0 15 87) ; "Obviously upset she says..."Listen super stud! Any more talk like that and you'll be eating rose stems.""
								(= local13 1)
								(flowerScript changeState: 2)
							)
							(local9
								(localproc_0 15 84) ; "Boy! You just can't wait, can you?"
							)
							(local11
								(localproc_0 15 85) ; "Too late!"
							)
							(else
								(localproc_0 15 86) ; "Too bad! She's not here."
							)
						)
					)
					((Said 'frisk/woman,wanda')
						(cond
							(local10
								(localproc_0 15 88) ; "You could get slapped that way."
							)
							(local9
								(localproc_0 15 84) ; "Boy! You just can't wait, can you?"
							)
							(local11
								(localproc_0 15 85) ; "Too late!"
							)
							(else
								(localproc_0 15 86) ; "Too bad! She's not here."
							)
						)
					)
					((Said 'arrest/woman,wanda')
						(cond
							(local10
								(localproc_0 15 89) ; "For selling flowers?"
							)
							(local9
								(localproc_0 15 84) ; "Boy! You just can't wait, can you?"
							)
							(local11
								(localproc_0 15 85) ; "Too late!"
							)
							(else
								(localproc_0 15 86) ; "Too bad! She's not here."
							)
						)
					)
				)
			)
		)
	)
)

(instance lightScript of Script
	(properties)

	(method (doit)
		(cond
			((> local0 1)
				(-- local0)
			)
			((== local0 1)
				(if (gCast contains: global112)
					(if (not (> 176 (global112 y:) 133))
						(self changeState: 2)
					)
				else
					(self changeState: 2)
				)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(lightPole setCel: 5)
				(= local0 100)
			)
			(2
				(= local6 0)
				(= local0 0)
				(lightPole setCel: 6)
				(if (> 176 (gEgo y:) 142)
					(Print 15 90 #time 2) ; "WATCH OUT, SONNY!!!"
					(= local7 1)
				)
			)
		)
	)
)

(instance flowerScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(flowerGirl
					view: 43
					posn: -15 120
					init:
					setCycle: Walk
					setAvoider: (Avoid new:)
					setMotion: Chase gEgo 25
					illegalBits: $8400
					startUpd:
				)
				(flowerSounds play:)
				(= local8 1)
				(= local9 1)
			)
			(1
				(localproc_0 15 91) ; "Hey, big fella! Why don't you buy some flowers for your girlfriend?"
			)
			(2
				(= local11 1)
				(= local10 0)
				(flowerGirl setMotion: MoveTo -15 120 self)
			)
			(3
				(flowerGirl stopUpd:)
				(= local12 1)
				(= local8 0)
				(= local11 0)
			)
		)
	)
)

