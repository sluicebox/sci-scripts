;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 54)
(include sci.sh)
(use Main)
(use n117)
(use eRoom)
(use Interface)
(use Follow)
(use Chase)
(use Save)
(use Motion)
(use Actor)
(use System)

(public
	Rm54 0
)

(synonyms
	(coin dinar dirham copper)
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
)

(instance conWindow of SysWindow
	(properties
		color 15
		back 5
		title {Yasser}
		brLeft 50
		brBottom 100
		brRight 250
	)
)

(instance conMan of Act
	(properties
		y 125
		x 194
		view 375
		loop 5
		illegalBits 0
	)

	(method (doit)
		(if
			(and
				(or (< (gEgo x:) 210) (< (gEgo y:) 145))
				(not script)
				(not (gCurRoom comingIn:))
			)
			(self setScript: haltEgo)
		)
		(super doit:)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(cond
			((Said 'smell')
				(Print 54 0) ; "He smells as though he has been sleeping in a pen of goats. It is a good thing that you are standing upwind."
			)
			((Said 'get,capture/man,arab,keep,gatekeeper,bandit,con,con')
				(if script
					(Talk 54 1) ; "I warn you, I am an official of the city! Pay me an entrance fee or go away."
				else
					(NotClose) ; "Perhaps you should move closer."
				)
			)
			(
				(or
					(Said 'greet')
					(Said 'talk,ask[/man,arab,con,gatekeeper,keep,bandit,con]')
				)
				(cond
					(script
						(Talk 54 2) ; "Come, come, I do not have all day. You must pay me a fee to enter the Jaffa Gate. Whatever you can afford."
					)
					((not local3)
						(Print 54 3) ; "He did not seem to hear you. Perhaps you are too far away."
					)
					(else
						(self setScript: haltEgo)
					)
				)
			)
			((Said 'kill,stab[/con,man,gatekeeper,keep,arab]')
				(if local3
					(= global125 1)
				else
					(NotClose) ; "Perhaps you should move closer."
				)
			)
			((Said 'hit,press,shove,move,remove[/con,man,gatekeeper,keep,arab]')
				(if local3
					(Talk 54 4) ; "If you lay hands upon me, I will call for the city guards and they will chop you into little pieces."
				else
					(NotClose) ; "Perhaps you should move closer."
				)
			)
			((Said 'fuck,(curse[<at])[/con,man,gatekeeper,keep,arab,you]')
				(if local3
					(Talk 54 5) ; "May the fleas of a thousand camels infest your tent!"
				else
					(Print 54 6) ; "He does not seem to hear you."
				)
			)
			(
				(or
					(Said 'look/con,arab,man,gatekeeper,keep')
					(Said 'tell,ask/merlin,me/con,arab,man,gatekeeper,keep')
					(MouseClaimed self event)
				)
				(Print 54 7) ; "He is dirty, has a disreputable look, and his clothes are old, threadbare, and smell of goats."
			)
		)
	)
)

(instance conMouth of Prop
	(properties
		z 43
		view 375
		loop 7
	)

	(method (doit)
		(self x: (conMan x:) y: (conMan y:))
		(super doit:)
	)
)

(instance Rm54 of eRoom
	(properties
		picture 54
		style 0
	)

	(method (dispose)
		(SetFlag 86)
		(super dispose:)
	)

	(method (init)
		(if (not (IsFlag 86))
			(Load rsVIEW 70)
			(Load rsVIEW 346)
			(Load rsSCRIPT 138)
		)
		(if (not (IsFlag 87))
			(Load rsVIEW 375)
			(Load rsSCRIPT 972)
		)
		(if (and (IsFlag 162) (== gPrevRoomNum 53))
			(Load rsVIEW 154)
		)
		(Load rsSCRIPT 207)
		(super init:)
		(self setRegions: 123) ; wallRegion
		(gEgo view: 0 init:)
		(gTObj tWindow: conWindow actor: conMouth tLoop: 7 cSpeed: 2)
		(= global112 3)
		(if (== gCurRoomNum global206)
			(SetFlag 20)
			(= global206 0)
			(gMuleObj loop: 0 posn: 90 140)
		)
		(switch gPrevRoomNum
			(55
				(self enterRoom: 145 235 145 185)
				(if (IsFlag 20)
					(self muleEnterRoom: 175 220 175 186 3)
				)
			)
			(56
				(self enterRoom: 109 119 109 140)
				(if (IsFlag 20)
					(gMuleObj illegalBits: 0 ignoreActors: 1)
					(self muleEnterRoom: 130 116 130 132 2)
				)
			)
			(57
				(self enterRoom: 130 119 130 140)
				(if (IsFlag 20)
					(gMuleObj ignoreActors: 1 illegalBits: 0)
					(self muleEnterRoom: 109 116 109 132 2)
				)
			)
			(else
				(if (IsFlag 162)
					(gEgo setScript: (ScriptID 207 1)) ; walkThruGates
					(self goingOut: 1)
				else
					(self enterRoom: 320 155 285 155)
					(if (not (IsFlag 87))
						(= local1 1)
					)
					(if (and (IsFlag 20) (!= gCurRoomNum global206))
						(self muleEnterRoom: 320 145 290 145 0)
					)
				)
			)
		)
		(if (and (<= 56 gPrevRoomNum 57) (== global202 3))
			(gCurRoom setScript: (ScriptID 207 0)) ; closeGates
		)
		(proc0_13 65)
		(gAddToPics doit:)
		(if (not (IsFlag 87))
			(conMan init:)
			(conMouth init:)
		)
		(if (not (IsFlag 86))
			(self setScript: (ScriptID 138 0)) ; headEmUp_MoveEmOut
		)
	)

	(method (doit)
		(if (and (not (self goingOut:)) (not (self comingIn:)))
			(cond
				(local1
					(= local1 0)
					(gMuleObj setScript: 0)
				)
				((> (gEgo x:) 310)
					(self leaveRoom: 53 320 (gEgo y:))
				)
				((== (gEgo onControl: 1) 16384)
					(gEgo illegalBits: 0 ignoreActors: 1)
					(self leaveRoom: 56 (gEgo x:) 120)
				)
				((== (gEgo onControl: 1) 8192)
					(gEgo illegalBits: 0 ignoreActors: 1)
					(self
						leaveRoom:
							(if global202 57 else 56)
							(- (gEgo x:) 5)
							120
					)
				)
				((and (== (gEgo onControl: 1) 4096) (not local0))
					(= local0 1)
					(Print 54 8) ; "A thicket of bushes blocks the path to the north."
				)
				((and local0 (> (gEgo x:) 95))
					(= local0 0)
				)
				((> (gEgo y:) 185)
					(self leaveRoom: 55 (gEgo x:) 235)
				)
				((== (gMuleObj illegalBits:) 0)
					(gMuleObj illegalBits: $8006 ignoreActors: 0)
				)
			)
		)
		(super doit:)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(cond
			(
				(or
					(event claimed:)
					(and
						(!= (event type:) evSAID)
						(not
							(and
								(== (event type:) evMOUSEBUTTON)
								(& (event modifiers:) emSHIFT)
							)
						)
					)
				)
				(return)
			)
			((Said 'talk/man,arab,keep,gatekeeper,bandit,con,con')
				(Print 54 9) ; "He is gone, good riddance."
			)
			((Said 'get,capture/man,arab,keep,gatekeeper,bandit,con,con')
				(Print 54 10) ; "He will know the escape routes of this city. I doubt that you will have a chance to catch up with him."
			)
			((Said 'give,bargain,sell/lodestone,moneybag')
				(Print 54 11) ; "Arthur! Will you PLEASE show some caution with the few possessions you have left."
			)
			((Said 'buy,bargain,get/lamb')
				(Print 54 12) ; "Ridiculous! The last thing on earth you need is a brainless sheep."
			)
			((Said 'give,bargain,sell/ass,animal')
				(Print 54 13) ; "Perhaps one of the merchants inside would be interested."
			)
			(
				(or
					(Said 'talk/merlin')
					(Said 'ask/advice')
					(Said 'ask[/merlin]/advice')
				)
				(Print 54 14) ; "This is the Jaffa Gate. What are you waiting for? Enter."
			)
			(
				(or
					(== (event type:) evMOUSEBUTTON)
					(Said 'look,(are<where)>')
					(Said 'ask[/merlin]/*>')
				)
				(cond
					((or (Said '/merchant') (Said '//merchant'))
						(Print 54 15) ; "I suppose there are plenty of merchants in the bazaar."
					)
					(
						(or
							(Said '/bandit,con,con,scoundrel')
							(Said '//bandit,con,con,scoundrel')
						)
						(if (IsFlag 87)
							(Print 54 16) ; "Aye, he was a fraud if I ever saw one."
						else
							(Print 54 17) ; "Aye, Arthur, you must be wary of thieves."
						)
					)
					(
						(or
							(Said '/sign,bolt,business,bolt')
							(Said '//sign,bolt,business,bolt')
						)
						(Print 54 18) ; "There is a shop selling cloth inside the bazaar."
					)
					(
						(or
							(Said '/con,arab,man,gatekeeper,keep')
							(Said '//con,arab,man,gatekeeper,keep')
						)
						(Print 54 19) ; "He is gone, and good riddance."
					)
					(
						(or
							(Said '/girl,woman,herder')
							(Said '//girl,woman,herder')
							(Said '/lamb,flock,animal')
							(Said '//lamb,flock,animal')
						)
						(Print 54 20) ; "The woman and her sheep are gone."
					)
					(
						(or
							(Said 'look[<at,around][/!*][/!*]')
							(Said 'look/room[/!*]')
							(Said '/city,jerusalem,bazaar,street,gutter')
							(Said '//city,jerusalem,bazaar,gutter,street')
							(OnButton event 95 38 145 116)
						)
						(Print 54 21) ; "This must be the Jaffa Gate. There is a glimpse of the local bazaar inside, with an open gutter that runs down the center of the street."
						(if
							(and
								(not (IsFlag 87))
								(== (conMan script:) haltEgo)
							)
							(Print 54 22) ; "Not to mention this bothersome man who is determined to have words with you."
						)
					)
					(
						(or
							(Said '/door,gate,arch')
							(Said '//door,gate,arch')
							(OnButton event 85 6 222 124)
						)
						(Print 54 23) ; "It is the Jaffa Gate and the way is open."
					)
					(
						(or
							(Said '/bush')
							(Said '//bush')
							(OnButton event 9 94 33 134)
						)
						(Print 54 8) ; "A thicket of bushes blocks the path to the north."
					)
					((OnButton event 9 135 128 183)
						(Print 54 24) ; "These spiny plants are Aloe Vera."
					)
					((or (Said 'look<down') (OnButton event 195 162 309 183))
						(Print 54 25) ; "It is a long way to the bottom of the hill!"
					)
					(
						(or
							(OnButton event 34 115 80 127)
							(OnButton event 194 114 242 129)
							(OnButton event 243 116 310 141)
						)
						(Print 54 26) ; "Aye, they are rocks. There is a lot of rock in this country."
					)
					((OnButton event 6 6 310 123)
						(Print 54 27) ; "The walls of Jerusalem are made of huge blocks of a buff-colored stone."
					)
				)
			)
		)
	)
)

(instance haltEgo of Script
	(properties)

	(method (doit)
		(cond
			((and local4 (gEgo mover:))
				(= local4 0)
				(= local5 1)
				(client
					setLoop: -1
					cycleSpeed: 0
					setCycle: Walk
					setMotion: Follow gEgo 500
				)
			)
			(
				(and
					local5
					(or
						(< (gEgo y:) (- (client y:) 10))
						(and
							(< (gEgo x:) (- (client x:) 30))
							(< (gEgo y:) (+ (client y:) 10))
						)
						(and
							(< (gEgo y:) (client y:))
							(< (gEgo x:) (+ (client x:) 15))
						)
						(and (== gPrevRoomNum 55) (< (gEgo y:) (client y:)))
					)
				)
				(= local5 0)
				(gEgo setMotion: 0)
				(self setScript: headHimOff)
			)
			((> local3 0)
				(-- local3)
			)
			((== local3 0)
				(= local3 300)
				(if (== (conMan loop:) 2)
					(conMouth show:)
				else
					(conMouth hide:)
				)
				(if (not (gTObj tCount:))
					(Talk 54 28) ; "You must pay me a fee to enter the Jaffa Gate. Whatever you can afford, but you must pay."
				)
			)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gTObj noWidth: 1)
				(Talk 54 29) ; "Hey, you!"
				(if (> (gEgo x:) 230)
					(gEgo setMotion: MoveTo 230 (gEgo y:))
				)
				(conMan
					setLoop: -1
					setCycle: Walk
					setMotion: Chase gEgo 25 self
				)
			)
			(1
				(conMan
					setMotion:
						MoveTo
						(- (gEgo x:) 16)
						(- (gEgo y:) 5)
						self
				)
			)
			(2
				(Face gEgo conMan)
				(conMan
					setLoop: 6
					cel: 0
					cycleSpeed: 1
					setCycle: End
					setMotion: 0
				)
				(DisposeScript 972)
				(= cycles 10)
			)
			(3
				(= local4 1)
				(conMan setCel: 1)
				(= local3 300)
				(gTObj noWidth: 0 talkCue: self)
				(Talk 54 28) ; "You must pay me a fee to enter the Jaffa Gate. Whatever you can afford, but you must pay."
			)
			(4
				(HandsOn)
			)
		)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(cond
			((Said 'greet')
				(Talk 54 30) ; "Yes, yes, welcome to Jerusalem. Now pay me the fee to enter and let us be done with it."
			)
			((Said 'smell')
				(if (IsFlag 86)
					(Print 54 31) ; "There is a rather interesting smell of frying food drifting out of the Jaffa Gate."
				else
					(Print 54 32) ; "Without the smell of goat interfering, there is a rather interesting smell of frying food drifting out of the Jaffa Gate."
				)
			)
			((Said 'give,bargain,sell/ass,animal')
				(Talk 54 33) ; "Ah, uh, no, a mule is too difficult to deal with. Just money will do."
			)
			((Said 'get/coin')
				(Talk 54 34) ; "No, no, YOU must pay ME to enter the gate."
			)
			((Said 'pay,give[/fee,coin,coin,coin,coin]')
				(if (DoPurse)
					(= global132 0)
					(event claimed: 1)
					(SetScore 293 1 -2)
					(client setScript: getTheHellOuttaDodge)
				else
					(return)
				)
			)
			((Said 'give,bargain,sell[/*]')
				(Talk 54 35) ; "No, no, you must give me money, not sell me something."
			)
			(
				(or
					(Said 'talk,ask[/man,con,bandit,con,arab,keep,gatekeeper]>')
					(Said 'tell[/me]>')
					(Said 'are<where>')
					(Said 'get/clue>')
				)
				(cond
					((or (Said '/fee,tithe,coin') (Said '//fee,tithe,coin'))
						(Talk 54 36) ; "We are reasonable here. Whatever you can afford. Come on, I do not have all day."
					)
					(
						(or
							(Said '/bandit,con,scoundrel,con')
							(Said '//bandit,con,scoundrel,con')
						)
						(Talk 54 37) ; "Ahm...uhmm...I know nothing of any thief!"
					)
				)
			)
			((Said 'draw/blade')
				(clr)
				(Print 54 38) ; "Yasser likes not the flash of your steel."
				(= local7 1)
				(SetScore 294 1 1)
				(client setScript: getTheHellOuttaDodge)
			)
		)
	)
)

(instance headHimOff of Script
	(properties)

	(method (doit)
		(if (and local6 (< (gEgo y:) (+ (conMan y:) 25)))
			(cond
				(
					(and
						(> (gEgo distanceTo: conMan) 20)
						(== (conMan loop:) 6)
						(!= (conMan cel:) 0)
					)
					(conMan cel: 0)
				)
				((>= (- (gEgo x:) (conMan x:)) 15)
					(cond
						((conMan mover:) 0)
						((== (conMan x:) 165)
							(conMan loop: 6 cel: 0)
						)
						((>= (gEgo x:) 165)
							(conMan setMotion: MoveTo 165 125)
						)
						(else
							(conMan setMotion: MoveTo (gEgo x:) 125)
						)
					)
				)
				((>= (- (conMan x:) (gEgo x:)) 15)
					(cond
						((conMan mover:) 0)
						((== (conMan x:) 101)
							(conMan loop: 6 cel: 0)
						)
						((<= (gEgo x:) 101)
							(conMan setMotion: MoveTo 101 125)
						)
						(else
							(conMan setMotion: MoveTo (gEgo x:) 125)
						)
					)
				)
				((not (conMan mover:))
					(conMan loop: 6 cel: 0)
				)
			)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(conMan
					ignoreActors: 1
					setLoop: 4
					setCel: -1
					cycleSpeed: 0
					setStep: 6 4
					setCycle: Walk
					setMotion: MoveTo 165 125 self
				)
			)
			(1
				(conMan setLoop: -1)
				(self cue:)
			)
			(2
				(conMan loop: 6 cel: 0 setStep: 3 2 ignoreActors: 0)
				(conMouth show:)
				(= local6 1)
				(gEgo illegalBits: $e000)
			)
		)
	)
)

(instance getTheHellOuttaDodge of Script
	(properties)

	(method (doit)
		(if (and local7 (not global124) (<= (conMan y:) 104) (== state 6))
			(self cue:)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if local7
					(self changeState: 5)
				else
					(gEgo illegalBits: 0 ignoreActors: 1)
					(conMouth dispose:)
					(if (> (gEgo x:) 252)
						(gEgo setMotion: MoveTo 252 (gEgo y:) self)
					else
						(self cue:)
					)
				)
			)
			(1
				(gEgo
					setMotion: MoveTo (- (conMan x:) 12) (+ (conMan y:) 3) self
				)
			)
			(2
				(gEgo setLoop: 3)
				(= cycles 3)
			)
			(3
				(gEgo view: 70 loop: 1 cel: 0 setCycle: End self)
			)
			(4
				(gEgo setCycle: Beg self)
			)
			(5
				(if (not local7)
					(gEgo view: 0 loop: 3)
				)
				(conMan
					setLoop: 4
					setCel: -1
					setPri: 6
					setStep: 6 4
					cycleSpeed: 0
					setCycle: Walk
				)
				(if (< (conMan y:) 135)
					(conMan setMotion: MoveTo 87 105 self)
				else
					(conMan setMotion: MoveTo 135 125 self)
				)
			)
			(6
				(if local7
					(Print 54 39) ; "That has set the fraud to his heels. But you had best put up your sword for now. There may be more guards like those at the Zion gate."
					(= global125 2)
					(conMan setMotion: MoveTo 87 104)
				else
					(Print 54 40) ; "By my beard, Arthur, I believe he was a fraud."
					(conMan setMotion: MoveTo 87 104 self)
				)
			)
			(7
				(gMuleObj illegalBits: $8006 setScript: (ScriptID 123 1)) ; muleFollow
				(= local6 0)
				(gEgo
					illegalBits: $8000
					ignoreActors: 0
					setCycle: Walk
					setLoop: -1
				)
				(HandsOn)
				(SetFlag 87)
				(client dispose:)
			)
		)
	)
)

