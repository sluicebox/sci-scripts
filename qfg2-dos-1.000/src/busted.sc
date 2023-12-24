;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 141)
(include sci.sh)
(use Main)
(use n001)
(use n002)
(use HandsOffScript)
(use TopWindow)
(use Talker)
(use Interface)
(use MoveFwd)
(use Rev)
(use Timer)
(use Motion)
(use Actor)
(use System)

(public
	busted 0
	outaHere 1
	sneakIn 2
	IssurFlex 3
	thrownOut 4
	Issur 5
	enterScript 6
	bustTimer 7
	pendant 8
	gShield 9
	shrine 10
	rShield 11
	rack 12
	lMace 13
	dblAxe 14
	lAxe 15
	rSword 16
	cleaver 17
	rMace 18
	saber 19
	lSword 20
	mail 21
	plaque 22
)

(local
	[issurGenList 34] = [1 2 0 0 3 0 0 4 5 6 0 7 0 0 0 0 8 0 9 10 11 0 12 0 13 14 0 0 0 0 0 0 15 16]
	[issurSpecList 35] = [26 '//weapon' 27 '//dagger' 28 '//blade' 29 '//wrestle,bet' 30 '//strength' 31 '//muscle' 32 '//defeat' 33 '//eof' 34 '//paladin' 35 '//shield' 36 '//ax' 37 '//anvil' 38 '//mace' 39 '//chainmail' 40 '//fire' 41 '//bellows' 0 0 0]
	stupidQ
	stepBack
)

(instance Issur of Talker
	(properties
		x 114
		y 96
		description {the owner of the Weapon Shop of Issur}
		view 145
		illegalBits 0
		tLoop 3
		talkSpeed 1
		myName '//issur,man,armorer,keeper,clerk'
		title {Issur:}
		back 11
		msgFile 145
	)

	(method (messages)
		(if script
			(self setCycle: 0 setLoop: 3 setCel: 0 setScript: 0)
		)
		(super messages: &rest)
	)

	(method (endTalk)
		(self setCycle: Beg)
		(super endTalk:)
	)

	(method (doit)
		(cond
			((!= gPrevRoomNum 150)
				(if
					(and
						(gEgo inRect: 90 98 140 110)
						(not (gEgo script:))
					)
					(Say self backOff 141 0) ; "Keep your distance!"
					(gEgo setScript: backOff)
				)
			)
			((and (< (gEgo x:) (+ (self x:) 15)) (not stepBack))
				(= stepBack 1)
				(gEgo setScript: getBack)
			)
		)
		(super doit:)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'get,get/blade,weapon,mace,shield,ax,dagger')
				(HighPrint 141 1) ; "You'd better ask Issur about the weapons."
			)
			((Said 'buy>')
				(cond
					((Said '/ax')
						(Say Issur self 145 36) ; "That is sold to someone else. They'll pick it up tomorrow."
					)
					((Said '/mace')
						(Say Issur self 145 38) ; "That is sold to one of the Sultan's guards. He picks it up today."
					)
					((Said '/shield')
						(Say Issur self 145 35) ; "Those are my trophies from Arm Wrestling tournaments in Petalumeir. They are not for sale."
					)
					((Said '/chainmail')
						(Say Issur self 145 39) ; "It is the finest suit of mail in all the realm. Its value is far beyond you."
					)
					((Said '/dagger')
						(self setScript: (ScriptID 140 2) 0 4) ; swordGotten
					)
				)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(HighPrint 141 2) ; "The shop owner glares back at you. He looks strong and decidedly unfriendly."
			)
			(9
				(cond
					(script
						(HighPrint 141 3) ; "He's too busy flexing to talk."
					)
					((TrySkill 13 80) ; communication
						(Say Issur 141 4) ; "That is very interesting."
					)
					(else
						(Say Issur 141 5) ; "You talk much, but say little."
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (init)
		(Load rsTEXT 145)
		(super init:)
	)

	(method (respond event)
		(if (and (not (gEgo inRect: 40 95 180 150)) (!= gPrevRoomNum 150))
			(Face gEgo Issur)
			(Say Issur 141 6) ; "Come over here and face me when you talk to me, wimp."
			(event claimed: 1)
		else
			(if script
				(self setCycle: 0 setLoop: 3 setCel: 0 setScript: 0)
			)
			(super respond: event &rest)
		)
	)

	(method (showText what)
		(switch what
			(0
				(++ stupidQ)
			)
			(1
				(++ stupidQ)
			)
			(else
				(= stupidQ 0)
			)
		)
		(cond
			((== what 41)
				(cond
					((gEgo has: 25) ; Bellows
						(Say Issur 141 7) ; "You have the bellows. What more do you want?"
					)
					((not (IsFlag 22)) ; fBellows
						(Say Issur 141 8) ; "The bellows is a sign of my trade. What about it?"
					)
					((IsFlag 165) ; fIssurMellow
						(SolvePuzzle 609 7)
						(Say Issur 141 9) ; "Hey, what are friends for? Let me get them down for you."
						(Print 141 10) ; "He gets the bellows down for you and you put it away. Good thing your spell lasted long enough."
						((ScriptID 140 1) dispose:) ; emblem
						(gEgo get: 25) ; Bellows
					)
					(else
						(Say Issur 141 11) ; "If you want my bellows for something, you've got to earn it. If you beat me at arm wrestling, you can have it. If I win, you give me 20 dinars."
						(= gWrestlingBet 20)
					)
				)
			)
			((>= stupidQ 4)
				(gEgo setScript: thrownOut)
			)
			((>= stupidQ 3)
				(Say Issur 141 12) ; "No more questions. Buy something or get out!"
			)
			(else
				(super showText: what)
			)
		)
	)

	(method (atSpec which)
		(return [issurSpecList which])
	)

	(method (atGen which)
		(return [issurGenList which])
	)

	(method (calmMe)
		(if (IsFlag 165) ; fIssurMellow
			(HighPrint 141 13) ; "Issur continues to smile at you."
		else
			(SetFlag 165) ; fIssurMellow
			(HighPrint 141 14) ; "Issur seems much more mellow now."
		)
		(return 1)
	)

	(method (dazzleMe)
		(gEgo setScript: thrownOut)
		(return 1)
	)

	(method (hurtMe)
		(gEgo setScript: thrownOut)
		(return 1)
	)
)

(instance busted of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(theGuard init: setCycle: Walk setMotion: MoveTo 290 148 self)
			)
			(1
				(if register
					(EgoDead 1 141 15 #title {Caught red-handed}) ; "The guards in Shapeir are nothing if not efficient. You took too much time, and one of Shapeir's finest caught you in the act of this decidedly unheroic pursuit."
				else
					(EgoDead 1 141 16 #title {Return to the scene of the crime}) ; "The guards seem to have been waiting for you. Someone must have robbed this store recently."
				)
			)
		)
	)
)

(instance outaHere of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (gEgo inRect: 0 128 108 164)
					(gEgo setMotion: MoveTo 123 119 self)
				else
					(self cue:)
				)
			)
			(1
				(gEgo setMotion: MoveTo 277 144 self)
			)
			(2
				(gEgo setMotion: MoveTo 315 155)
				(self dispose:)
			)
		)
	)
)

(instance sneakIn of HandsOffScript
	(properties)

	(method (dispose)
		(super dispose:)
		(gEgo illegalBits: -32764)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 215 104 self)
			)
			(1
				(gEgo setHeading: 0)
				(if (IsFlag 26) ; fWeaponRobbed
					(gEgo setScript: busted 0 0)
				else
					(StartTimer bustTimer 150)
				)
				(self dispose:)
			)
		)
	)
)

(instance IssurFlex of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Issur loop: 0 cel: 0 cycleSpeed: 3 setCycle: End self)
			)
			(1
				(Issur loop: 1 cel: 0 cycleSpeed: 2 setCycle: End self)
			)
			(2
				(Issur loop: 2 cel: 0 setCycle: End self)
			)
			(3
				(Issur loop: 2 setCycle: Beg self)
			)
			(4
				(Issur loop: 1 cel: 5 setCycle: Beg self)
			)
			(5
				(Issur loop: 0 cel: 0 cycleSpeed: 2 setCycle: End self)
			)
			(6
				(self dispose:)
			)
		)
	)
)

(instance shopWindow of TopWindow
	(properties)
)

(instance thrownOut of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 25) ; fIssurMad
				(shopWindow color: 0 back: 11)
				(HighPrint 141 17 35 shopWindow 103) ; "That does it!!"
				(Issur setLoop: 6 cel: 0 setCycle: CT 2 1)
				(Face gEgo Issur)
				(= cycles 10)
			)
			(1
				(gEgo
					view: 0
					illegalBits: -32768
					setLoop: (gEgo loop:)
					moveSpeed: 1
					cycleSpeed: 1
					setCycle: Rev
					setMotion: MoveFwd -25
				)
				(= cycles 8)
			)
			(2
				(cls)
				(Issur setCycle: End)
				(= cycles 12)
			)
			(3
				(gCast eachElementDo: #hide)
				(gCurRoom drawPic: 2)
				(= cycles 2)
			)
			(4
				(gCurRoom newRoom: 330) ; rmSPlazaFightersE
			)
		)
	)
)

(instance theGuard of Actor
	(properties
		x 320
		y 135
		noun '/guard'
		description {the guard}
		lookStr {This is a real guard.}
		view 294
		illegalBits 0
	)
)

(instance backOff of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0)
			(1
				(gEgo
					setHeading:
						(GetAngle
							(Issur x:)
							(Issur y:)
							(gEgo x:)
							(gEgo y:)
						)
						self
				)
			)
			(2
				(gEgo setMotion: MoveFwd 15 self)
			)
			(3
				(Face gEgo Issur)
				(self dispose:)
			)
		)
	)
)

(instance enterScript of HandsOffScript
	(properties)

	(method (dispose)
		(super dispose:)
		(gEgo illegalBits: -32764)
	)

	(method (changeState newState &tmp theMessage)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 176 136 self)
			)
			(1
				(gEgo setHeading: 315 self)
			)
			(2
				(cond
					((== gEnter140 1)
						(Say Issur self 145 16) ; "I am Issur, and this is my weapon shop. I make the best swords and daggers. What do you want?"
					)
					((IsFlag 25) ; fIssurMad
						(Say Issur self 141 18) ; "You back again? I'll let you stay if you want to buy something, but don't push it."
						(ClearFlag 25) ; fIssurMad
					)
					((IsFlag 23) ; fWrestlingWin
						(Say Issur self 141 19) ; "What do you want now?"
					)
					((IsFlag 17) ; fWrestledOnce
						(= theMessage (ChooseFromCycle gEnter140 18 25))
						(Say Issur self 145 theMessage)
					)
					(else
						(Say Issur self 145 17) ; "Hero of the Kattas, huh? Only a Katta would call you a hero."
					)
				)
			)
			(3
				(cond
					((== 1 gEnter140)
						(Issur setScript: IssurFlex)
					)
					((== 0 (mod gEnter140 3))
						(Issur setScript: IssurFlex)
					)
				)
				(self dispose:)
			)
		)
	)
)

(instance getBack of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Say Issur self 141 20) ; "Don't be coming over here!"
			)
			(1
				(gEgo
					setMotion: MoveTo (+ (gEgo x:) 20) (gEgo y:) self
				)
			)
			(2
				(Face gEgo Issur)
				(= stepBack 0)
				(self dispose:)
			)
		)
	)
)

(instance bustTimer of Timer
	(properties)

	(method (cue)
		(if (< ((ScriptID 140 3) cel:) 2) ; door
			(gEgo setScript: busted 0 1)
		)
		(self dispose:)
	)
)

(instance pendant of PicView
	(properties
		x 46
		y 33
		noun '/trophy'
		description {the trophy}
		lookStr {One of the many trophies won at the Desert Wrist-wrestling Championships in Petalumeir.}
		view 140
	)

	(method (init)
		(if (<= 0 gTimeODay 4)
			(= palette 1)
		else
			(= palette 2)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 7)
			(HighPrint 141 21) ; "The trophy seems to be firmly attached to the wall."
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance gShield of PicView
	(properties
		x 15
		y 55
		noun '/shield[<black]'
		description {the Shield of Falworth}
		lookStr {It's the Black Shield of Falworth.  It's been repainted.}
		view 140
		cel 1
	)

	(method (init)
		(if (<= 0 gTimeODay 4)
			(= palette 1)
		else
			(= palette 2)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 7)
			(HighPrint 141 22) ; "The shield seems to be firmly attached to the wall."
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance shrine of PicView
	(properties
		x 96
		y 79
		noun '/shrine,cover[<errand]'
		description {the "Shrine of Hero's Quest"}
		lookStr {It's the cover from the "Shrine of Hero's Quest," gone but not forgotten.}
		view 140
		cel 2
	)

	(method (init)
		(if (<= 0 gTimeODay 4)
			(= palette 1)
		else
			(= palette 2)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 7)
			(HighPrint 141 23) ; "The shrine seems to be firmly attached to the wall."
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance rShield of PicView
	(properties
		x 93
		y 46
		noun '/shield[<banzai,bronze]'
		description {the shield}
		lookStr {It's a burnished bronze banzai shield.}
		view 140
		cel 3
	)

	(method (init)
		(if (<= 0 gTimeODay 4)
			(= palette 1)
		else
			(= palette 2)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 7)
			(HighPrint 141 22) ; "The shield seems to be firmly attached to the wall."
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance rack of PicView
	(properties
		x 191
		y 95
		noun '/rack'
		description {the rack of swords}
		lookStr {The rack is used to organize Issur's many swords.}
		view 140
		cel 4
	)

	(method (init)
		(if (<= 0 gTimeODay 4)
			(= palette 1)
		else
			(= palette 2)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 7)
			(HighPrint 141 24) ; "The rack seems to be firmly attached to the wall."
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance lMace of PicView
	(properties
		x 201
		y 40
		noun '/mace[<big]'
		description {the large mace}
		lookStr {A mace in the face will make you race with haste to the nearest plastic surgeon's place.}
		view 140
		loop 1
	)

	(method (init)
		(if (<= 0 gTimeODay 4)
			(= palette 1)
		else
			(= palette 2)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 7)
			(HighPrint 141 25) ; "The large mace seems to be firmly attached to the wall."
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance dblAxe of PicView
	(properties
		x 174
		y 43
		noun '/ax<double,(bladed<2)'
		description {the two-bladed axe}
		lookStr {The double-bladed axe, a precursor of Gilette blades.}
		view 140
		loop 1
		cel 1
	)

	(method (init)
		(if (<= 0 gTimeODay 4)
			(= palette 1)
		else
			(= palette 2)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 7)
			(HighPrint 141 26) ; "The axe seems to be firmly attached to the wall."
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance lAxe of PicView
	(properties
		x 221
		y 49
		noun '/ax[<bladed<single]'
		description {the single-bladed axe}
		lookStr {You could make short work of the Wood Elemental with this baby.}
		view 140
		loop 1
		cel 2
	)

	(method (init)
		(if (<= 0 gTimeODay 4)
			(= palette 1)
		else
			(= palette 2)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 7)
			(HighPrint 141 26) ; "The axe seems to be firmly attached to the wall."
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance rSword of PicView
	(properties
		x 146
		y 43
		noun '/blade'
		description {the sword}
		lookStr {A sword for the few...the proud...the mercenaries.}
		view 140
		loop 1
		cel 3
	)

	(method (init)
		(if (<= 0 gTimeODay 4)
			(= palette 1)
		else
			(= palette 2)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 7)
			(HighPrint 141 27) ; "The sword seems to be firmly attached to the wall."
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance cleaver of PicView
	(properties
		x 201
		y 61
		noun '/dagger,scimitar,(blade<little)'
		description {the scimitar}
		lookStr {A sword for the wee people.}
		view 140
		loop 1
		cel 4
	)

	(method (init)
		(if (<= 0 gTimeODay 4)
			(= palette 1)
		else
			(= palette 2)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 7)
			(HighPrint 141 28) ; "The scimitar seems to be firmly attached to the wall."
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance rMace of PicView
	(properties
		x 185
		y 68
		noun '/mace[<little]'
		description {the small mace}
		lookStr {A mace in the face will make you race with haste to the nearest plastic surgeon's place.}
		view 140
		loop 2
	)

	(method (init)
		(if (<= 0 gTimeODay 4)
			(= palette 1)
		else
			(= palette 2)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 7)
			(HighPrint 141 29) ; "The mace seems to be firmly attached to the wall."
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance saber of PicView
	(properties
		x 171
		y 69
		noun '/tusk,(blade<ivory)'
		description {the ivory tusk}
		lookStr {Put on layaway by a desert brigand, this appears to be a sword made from the tusk of the fierce desert creature known as a Tisk.  Obtaining a Tisk tusk is a task, because of the risk of getting a Tisk ticked.}
		view 140
		loop 2
		cel 1
	)

	(method (init)
		(if (<= 0 gTimeODay 4)
			(= palette 1)
		else
			(= palette 2)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 7)
			(HighPrint 141 30) ; "The Tisk tusk is firmly attached to the wall with Tisk tusk tacks. Tsk, tsk!"
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance lSword of PicView
	(properties
		x 222
		y 64
		noun '/sheath'
		description {the sheath}
		lookStr {Let's face it...how many swords can one guy own?}
		view 140
		loop 2
		cel 2
	)

	(method (init)
		(if (<= 0 gTimeODay 4)
			(= palette 1)
		else
			(= palette 2)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 7)
			(HighPrint 141 31) ; "The sheath seems to be firmly attached to the wall."
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance mail of PicView
	(properties
		x 132
		y 96
		noun '/chainmail,(shirt,chainmail,coat<chainmail)'
		description {the coat of mail}
		lookStr {The silvery, shimmering coat of costly mail glistens in the glimmering glow of the fire.}
		view 140
		loop 3
	)

	(method (init)
		(if (<= 0 gTimeODay 4)
			(= palette 1)
		else
			(= palette 2)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 7)
			(HighPrint 141 32) ; "The coat of mail is very heavy and too easily recognizable. You decide to leave it alone."
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance plaque of PicView
	(properties
		x 278
		y 79
		noun '/sign'
		description {the sign}
		lookStr {It is the shop's sign which hangs in the plaza.}
		view 140
		loop 2
		cel 4
		priority 15
	)

	(method (init)
		(if (<= 0 gTimeODay 4)
			(= palette 1)
		else
			(= palette 2)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 7)
			(HighPrint 141 33) ; "It seems to be located in the plaza, not in the shop."
		else
			(super doVerb: theVerb &rest)
		)
	)
)

