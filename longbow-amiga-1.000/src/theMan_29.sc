;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 29)
(include sci.sh)
(use Main)
(use n013)
(use n121)
(use Wat)
(use verseScript)
(use rhEgo)
(use RTEyeCycle)
(use PChase)
(use PolyPath)
(use Polygon)
(use Feature)
(use MoveFwd)
(use LoadMany)
(use StopWalk)
(use Rev)
(use Sound)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	theMan 0
	theWoman 1
	shooter 2
	womanScript 3
)

(local
	[local0 9] = [-1 {Jack} 19 0 0 0 0 0 0]
	[local9 9] = [-1 {Peasant Woman} 6 0 0 0 0 0 0]
	[local18 9] = [-1 {Roger} 19 0 0 0 0 0 0]
	local27
	local28
	local29
	local30
	local31
	local32
	[local33 8] = [1029 0 1 2 3 1 2 0]
	[local41 5] = [1029 5 1 2 0]
	[local46 4] = [1029 7 1 0]
	[local50 8] = [1029 8 1 2 1 2 1 0]
	[local58 14] = [1029 14 1 2 1 2 1 2 3 2 2 1 2 0]
	[local72 11] = [1029 25 1 2 1 3 2 1 2 2 0]
	[local83 4] = [1029 33 1 0]
	[local87 4] = [1029 36 1 0]
	[local91 4] = [1029 37 1 0]
	[local95 4] = [1029 38 1 0]
	[local99 6] = [1029 61 2 1 2 0]
	[local105 4] = [1029 64 1 0]
	[local109 6] = [1029 51 2 1 2 0]
	[local115 4] = [1029 54 1 0]
	[local119 4] = [1029 56 1 0]
	[local123 7] = [1029 57 2 1 2 3 0]
	[local130 4] = [1029 55 1 0]
	[local134 5] = [1029 65 2 1 0]
	[local139 5] = [1029 41 2 1 0]
	[local144 6] = [1029 43 2 1 3 0]
	[local150 5] = [1029 46 1 2 0]
	[local155 4] = [1029 48 1 0]
	[local159 9] = [1029 67 1 2 1 2 2 3 0]
	[local168 7] = [1029 73 1 2 1 2 0]
	[local175 4] = [1029 78 1 0]
	[local179 7] = [1029 79 1 2 2 1 0]
)

(instance theMan of Actor
	(properties
		x 215
		y 60
		view 112
		loop 2
		cel 1
		signal 30720
	)

	(method (doit)
		(cond
			((or script (gEgo script:) (gCurRoom script:)))
			(
				(and
					(not (& (theMan signal:) $0020))
					(not local30)
					(gEgo mover:)
					(closePoly onMe: gEgo)
				)
				(= local30 1)
				(gEgo setScript: getBack)
			)
		)
		(super doit:)
	)

	(method (doVerb theVerb invItem)
		(if (& (theMan signal:) $0020)
			((ScriptID 120 2) doVerb: theVerb &rest) ; theStreet
		else
			(switch theVerb
				(2 ; Look
					(Say 1029 13) ; "A typically nasty example of his breed."
				)
				(3 ; Do
					(HandsOff)
					(gEgo setMotion: PChase theMan 30)
				)
				(10 ; Longbow
					(gEgo setScript: flunkyKilled)
				)
				(5 ; Talk
					(cond
						((Wat offRoad:)
							(if local32
								(Converse 1 @local83 @local0 2) ; "By the authority of the Sheriff of Nottingham, I order you to lay down your bow and surrender yourself for crimes against the Crown!"
							else
								(= local32 1)
								(Converse 3 @local72 2 2 @local0 3 @local9 2) ; "Why do you hesitate? The way is open."
							)
						)
						((Wat charFirstTalk:)
							(Converse 1 @local83 @local0 2) ; "By the authority of the Sheriff of Nottingham, I order you to lay down your bow and surrender yourself for crimes against the Crown!"
						)
						(else
							(Wat charFirstTalk: 1)
							(Converse 3 @local58 2 2 @local0 3 @local9 2) ; "Let the woman go."
						)
					)
				)
				(4 ; Inventory
					(switch invItem
						(0 ; bucks
							(if (Wat gaveManBucks:)
								(Say 1029 77) ; "I'll not waste my breath offering him money again."
							else
								(Wat gaveManBucks: 1)
								(gEgo setScript: buckTalk)
							)
						)
						(else
							(HandsOff)
							(gEgo setMotion: PChase theMan 30)
						)
					)
				)
			)
		)
	)
)

(instance theWoman of Actor
	(properties
		x 220
		y 69
		view 112
		cel 5
		signal 30720
	)

	(method (init)
		(gSFX number: 126 loop: -1 play:)
		(super init:)
	)

	(method (dispose)
		(gSFX fade: 0 30 8 1)
		(gTheIconBar enable: 0)
		(gCurRoom notify:)
		(self setCycle: 0 setMotion: 0)
		(if (not (& (theMan signal:) $0020))
			(theMan setCycle: 0 setMotion: 0 dispose:)
		)
		(if (gFeatures contains: closePoly)
			(closePoly dispose:)
		)
		(if (Wat whichChar:)
			(Wat weMeetAgain: (+ (Wat weMeetAgain:) 1))
		)
		(if (== (Wat womanStatus:) 3)
			(gEgo setScript: 0)
			(proc125_2)
		)
		(super dispose:)
		(if (not (& (theMan signal:) $0020))
			(theMan delete:)
		else
			(gFeatures delete: theMan)
		)
		(gTheIconBar enable: 5)
	)

	(method (doVerb theVerb invItem)
		(if (& (theWoman signal:) $0020)
			((ScriptID 120 2) doVerb: theVerb &rest) ; theStreet
		else
			(switch theVerb
				(2 ; Look
					(if (== (Wat womanStatus:) 0)
						(Say 1029 34) ; "The poor woman is terrified of what this cur means to do to her."
					else
						(Say 1029 35) ; "It does my heart good to see the joy and gratitude written upon her face."
					)
				)
				(3 ; Do
					(if (== (Wat womanStatus:) 0)
						(HandsOff)
						(gEgo setMotion: PChase theMan 30)
					else
						(Converse 1 @local87 @local9 1) ; "Worry not about helping me. I'm strong enough to go on my own."
					)
				)
				(5 ; Talk
					(if (== (Wat womanStatus:) 0)
						(Converse 1 @local91 @local9 3) ; "Save me, I beg you!"
					else
						(Converse 1 @local95 @local9 1) ; "I shall be forever grateful and bless your name."
					)
				)
				(10 ; Longbow
					(if (!= (Wat womanStatus:) 2)
						(Say 1029 84 1) ; "I've no desire to kill this woman."
					)
				)
				(4 ; Inventory
					(switch invItem
						(0 ; bucks
							(if (== (Wat womanStatus:) 3)
								(cond
									(local27
										(Say 1029 39) ; "I've no need to try that again."
									)
									((gMoney doit:)
										(= local27 1)
										(gEgo setScript: giveWomanBucks)
									)
								)
							else
								(HandsOff)
								(gEgo setMotion: PChase theMan 30)
							)
						)
						(else
							(super doVerb: theVerb &rest)
						)
					)
				)
				(else
					(super doVerb: theVerb &rest)
				)
			)
		)
	)
)

(instance shooter of Prop
	(properties
		view 393
		cel 4
	)
)

(instance closePoly of Feature
	(properties)

	(method (init)
		(= onMeCheck
			((Polygon new:)
				type: PTotalAccess
				init: 164 97 116 60 212 40 269 64 269 89
				yourself:
			)
		)
		(super init:)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)

	(method (doVerb theVerb)
		(cond
			(((ScriptID 120 3) onMe: self) ; eastSide
				((ScriptID 120 3) doVerb: theVerb) ; eastSide
			)
			(((ScriptID 120 4) onMe: self) ; westSide
				((ScriptID 120 4) doVerb: theVerb) ; westSide
			)
			(else
				((ScriptID 120 2) doVerb: theVerb) ; theStreet
			)
		)
	)
)

(instance womanScript of Script
	(properties)

	(method (dispose)
		(gTheIconBar disable: 5)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo actions: egoActions)
				(Wat setScript: 0)
				(closePoly init:)
				(if (Wat weMeetAgain:)
					(client setScript: repeatEncounter)
				else
					(theMan init: setCycle: CT 6 1 self)
				)
			)
			(1
				(theMan cel: 7 stopUpd:)
				(theWoman
					init:
					setCycle: Walk
					setStep: 6 4
					setMotion: MoveTo 212 76 self
				)
				(= ticks 6)
			)
			(2
				(theMan
					view: 752
					loop: 1
					cel: 5
					x: 205
					y: 65
					setPri: 3
					forceUpd:
				)
			)
			(3
				(theWoman loop: 3 cel: 0 setStep: 3 2 posn: 197 73 stopUpd:)
				(= ticks 6)
			)
			(4
				(Converse 3 @local33 2 2 @local0 3 @local9 2 self) ; "Stand fast!"
			)
			(5
				(NormalEgo)
				(gEgo setMotion: 0 setScript: 0 stopUpd:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance repeatEncounter of Script
	(properties)

	(method (dispose)
		(gTheIconBar disable: 5)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(HandsOff)
				(gEgo actions: egoActions)
				(if (> (Wat weMeetAgain:) 1)
					(Converse 1 @local46 2 2 self) ; "Stand fast and--"
				else
					(Converse 2 @local41 2 2 @local0 3 self) ; "We have unfinished business, villain."
				)
			)
			(2
				(if (> (Wat weMeetAgain:) 1)
					(client setScript: lastChance)
				else
					(NormalEgo)
					(HandsOn)
					(self dispose:)
				)
			)
		)
	)
)

(instance lastChance of Script
	(properties)

	(method (dispose)
		(shootSound dispose:)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(shooter setCycle: CT 2 1 self)
			)
			(1
				(shootSound number: 906 play:)
				(shooter setCycle: CT 4 1 self)
				(gEgo view: 792 loop: 0 cel: 0 setCycle: End self)
			)
			(2
				(shootSound number: 907 play:)
				(theMan view: 752 loop: 0 cel: 0 stopUpd:)
				(= ticks 60)
			)
			(3)
			(4
				(Converse 2 @local50 @local18 2 @local0 3 self) ; "It's a good thing I decided to come up the street and meet you. D'you know who that was?"
			)
			(5
				(gSFX stop:)
				(EgoDead)
			)
		)
	)
)

(instance getBack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: 0)
				(Face gEgo theMan self)
			)
			(1
				(gEgo stopUpd:)
				(theMan stopUpd:)
				(if (== (++ local31) 3)
					(client setScript: womanKilled)
				else
					(Converse 2 @local109 2 2 @local0 3 self) ; "Not another step or the woman dies!"
				)
			)
			(2
				(gEgo
					setLoop: (gEgo loop:)
					setCycle: Rev
					setMotion: MoveFwd -25 self
				)
			)
			(3
				(= local30 0)
				(NormalEgo)
				(HandsOn)
				(gTheIconBar disable: 5)
				(self dispose:)
			)
		)
	)
)

(instance womanKilled of Script
	(properties)

	(method (dispose)
		(screamSound dispose:)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo stopUpd:)
				(theMan cycleSpeed: 12 setCycle: CT 2 1 self)
				(theWoman cycleSpeed: 12 setCycle: CT 3 1)
			)
			(1
				(screamSound play:)
				(Converse 1 @local115 @local9 1 self) ; "Aaaaiiiygh!"
			)
			(2
				(theMan setCycle: End)
				(theWoman setCycle: End self)
				(Wat womanStatus: 2)
			)
			(3
				(theWoman addToPic:)
				(SetScore -100)
				(Converse 1 @local130 2 2 self) ; "You dog!"
			)
			(4
				(client setScript: flunkyKilled)
			)
		)
	)
)

(instance flunkyKilled of Script
	(properties)

	(method (dispose)
		(shootSound dispose:)
		(if (& (theWoman signal:) $0020)
			(gSFX fade: 0 30 8 1)
		)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Face gEgo theMan self)
			)
			(1
				(theMan stopUpd:)
				(gGame setSpeed: (/ global141 2))
				(gEgo view: 4 cel: 0 setCycle: End self)
			)
			(2
				(gEgo view: 5 cel: 0 setCycle: End self)
				(theMan cel: 1 forceUpd:)
			)
			(3
				(gEgo stopUpd:)
				(shootSound number: 906 play:)
				(= ticks (/ (gEgo distanceTo: theMan) 4))
			)
			(4
				(theMan loop: 2 cel: 0 x: (+ (theMan x:) 3) setCycle: End self)
				(gSFX stop:)
				(shootSound number: 907 play:)
			)
			(5
				(gGame setSpeed: global141)
				(theMan addToPic:)
				(NormalEgo)
				(= ticks 60)
			)
			(6
				(gSFX
					number: (if (== (Wat womanStatus:) 2) 127 else 128)
					loop: -1
					play:
				)
				(if (== (Wat womanStatus:) 2)
					(SetFlag 75)
					(Converse 1 @local119 2 3 self) ; "He's dead, but what a hollow victory."
				else
					(ClearFlag 75)
					(Wat womanStatus: 1)
					(client setScript: savedTheWoman)
				)
			)
			(7
				(self setScript: (ScriptID 5 1) self) ; blowinIt
			)
			(8
				(gEgo setMotion: MoveTo 140 115 self)
			)
			(9
				(Face gEgo theMan self)
			)
			(10
				(gEgo stopUpd:)
				(self setScript: (ScriptID 125 1) self) ; merryMenEntrance
			)
			(11
				(= local28 1)
				(gGame setSpeed: global141)
				(Face gEgo (ScriptID 19) self) ; John
			)
			(12
				(Converse 3 @local123 2 0 13 2 15 3 self) ; "Master! Did this villain murder the woman?"
			)
			(13
				(Converse 2 @local134 2 2 14 3 self) ; "What shall we do with this worthless carrion?"
			)
			(14
				(gCurRoom drawPic: 803 -32761)
				(NormalEgo)
				(gEgo loop: 4 cel: 0 posn: 160 95)
				(gEgoHead cel: 7 posn: 120 125)
				(gCast eachElementDo: #hide)
				(= ticks 120)
			)
			(15
				(if (and (IsFlag 46) (IsFlag 45))
					(client setScript: 0)
					(gCurRoom newRoom: 160)
				else
					(SetIcon 0)
					((ScriptID 19) dispose:) ; John
					((ScriptID 23) dispose:) ; Tuck
					((ScriptID 20) dispose:) ; Will
					(= local29 1)
					(proc125_2)
					(gCast eachElementDo: #show)
					(gCurRoom drawPic: 120 -32761)
					(proc121_0)
					(= ticks 12)
				)
			)
			(16
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance savedTheWoman of Script
	(properties)

	(method (doit)
		(if (and (theWoman mover:) (not (& ((gTheIconBar at: 0) signal:) $0004)))
			(gTheIconBar disable: 0)
			(User canControl: 0)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(theWoman
					view: 745
					loop: 1
					cel: 0
					posn: (+ (theWoman x:) 12) (+ (theWoman y:) 4)
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(1
				(Converse 2 @local99 3 2 @local9 3 self) ; "Oh, bless you, sir. To whom do I owe my salvation?"
				(SetScore 100)
			)
			(2
				(theWoman stopUpd:)
				(self setScript: (ScriptID 5 1) self) ; blowinIt
			)
			(3
				(gEgo setMotion: MoveTo 140 115 self)
			)
			(4
				(Face gEgo theWoman self)
			)
			(5
				(= ticks 12)
			)
			(6
				(gEgo stopUpd:)
				(self setScript: (ScriptID 125 1) self) ; merryMenEntrance
			)
			(7
				(= local28 1)
				(Face gEgo (ScriptID 20) self) ; Will
			)
			(8
				(gEgo stopUpd:)
				(Converse 2 @local134 2 2 14 3 self) ; "What shall we do with this worthless carrion?"
			)
			(9
				(= ticks 18)
			)
			(10
				(theWoman view: 112 setLoop: 0 posn: 190 105)
				(NormalEgo)
				(gEgo loop: 4 cel: 0 posn: 160 95)
				(gEgoHead posn: 120 125)
				(gCast eachElementDo: #hide)
				(gCurRoom drawPic: 803 -32761)
				(= ticks 120)
			)
			(11
				((ScriptID 19) dispose:) ; John
				((ScriptID 23) dispose:) ; Tuck
				((ScriptID 20) dispose:) ; Will
				(= local29 1)
				(gCast eachElementDo: #show)
				(gCurRoom drawPic: 120 -32761)
				(proc121_0)
				(= ticks 12)
			)
			(12
				(Converse 1 @local105 @local9 3 self) ; "Bless you and all your men! I must go now."
			)
			(13
				(Wat womanStatus: 3)
				(if (>= gHowFast 1)
					(gEgo startUpd: setHeading: 225)
				else
					(gEgo stopUpd:)
				)
				(HandsOn)
				(theWoman
					cycleSpeed: 6
					setCycle: Walk
					ignoreActors:
					illegalBits: 0
					setMotion: MoveTo 28 170 self
				)
			)
			(14
				(HandsOff)
				(theWoman setMotion: MoveTo 20 240 self)
			)
			(15
				(SetFlag 173)
				(if (and (IsFlag 46) (IsFlag 45))
					(gCurRoom newRoom: 160)
				else
					(HandsOff)
					(gTheIconBar disable: 0 5)
					(User canControl: 0)
					(Say 1029 83 self) ; "She hurries down Watling Street as fast as her feet can carry her."
				)
			)
			(16
				(HandsOn)
				(self dispose:)
				(proc125_2)
				(User canControl: 1)
				(gTheIconBar enable: 0)
				(SetIcon 0)
				(theWoman dispose:)
			)
		)
	)
)

(instance buckTalk of TScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Converse 3 @local159 1 2 @local0 3 @local9 2 self) ; "Here, I've silver to offer, if you'll let her go."
			)
			(1
				(Converse 2 @local168 2 2 @local0 3 self) ; "First set her free."
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance giveWomanBucks of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Load rsVIEW 7)
				(theWoman setLoop: 1 setMotion: 0 stopUpd:)
				(HandsOff)
				(Converse 1 @local175 3 0 self) ; "Wait!"
			)
			(1
				(SetScore 50)
				(gEgo
					setMotion:
						MoveTo
						(- (theWoman x:) 23)
						(+ (theWoman y:) 4)
						self
				)
			)
			(2
				(gEgo setHeading: 135 self)
			)
			(3
				(gGame setSpeed: global141)
				(gEgo view: 7 loop: 4 cel: 0 setCycle: CT 3 1 self)
			)
			(4
				(Converse 2 @local179 3 0 @local9 1 self) ; "Accept this gift."
			)
			(5
				(gEgo setCycle: Beg self)
			)
			(6
				(NormalEgo)
				(gEgo
					setMotion: MoveTo (- (gEgo x:) 25) (gEgo y:) self
				)
			)
			(7
				(theWoman
					setLoop: 0
					moveSpeed: 0
					cycleSpeed: 0
					setMotion: MoveTo 20 240 self
				)
			)
			(8
				(if (> (gEgo y:) 188)
					(gEgo setMotion: MoveTo (+ (gEgo x:) 20) 178 self)
				else
					(= cycles 1)
				)
				(HandsOn)
				(gTheIconBar disable: 0 5)
				(User canControl: 0)
			)
			(9
				(if (>= gHowFast 1)
					(gEgo setHeading: 225 self)
				else
					(gEgo stopUpd:)
					(= cycles 4)
				)
			)
			(10
				(Say 1029 83 self) ; "She hurries down Watling Street as fast as her feet can carry her."
			)
			(11
				(if (and (IsFlag 46) (IsFlag 45))
					(gCurRoom newRoom: 160)
				else
					(proc125_2)
					(HandsOn)
					(theWoman dispose:)
				)
			)
		)
	)
)

(instance egoActions of SpecialDoVerb
	(properties)

	(method (doVerb theVerb invItem)
		(return
			(and
				(== theVerb 4) ; Inventory
				(== invItem 1) ; horn
				(if (== (Wat womanStatus:) 0)
					(if (or local29 (Wat blewHorn:))
						(Say 1029 49) ; "I mustn't risk the horn again with the woman's life at stake."
						1
					else
						(gEgo setScript: getYerMen)
					)
				else
					(Say 1029 50) ; "My men are busy with the burial. I'll not disturb them."
					1
				)
			)
		)
	)
)

(instance getYerMen of TScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= register (< gHowFast 1))
				(HandsOff)
				(LoadMany rsVIEW 151 152 160 161 154 155)
				(ScriptID 19) ; John
				(ScriptID 23) ; Tuck
				(ScriptID 20) ; Will
				(theMan stopUpd:)
				(theWoman stopUpd:)
				(self setScript: (ScriptID 5 1) self) ; blowinIt
			)
			(1
				(Wat blewHorn: 1)
				(Converse 2 @local139 2 2 @local0 3 self) ; "Wh-what have you-- what is the meaning of this?"
			)
			(2
				(gEgo setMotion: MoveTo 140 115 self)
			)
			(3
				(Face gEgo theMan self)
			)
			(4
				(gEgo stopUpd:)
				(= ticks 12)
			)
			(5
				(if register
					(gCurRoom drawPic: 803 -32759)
					(gCast eachElementDo: #hide)
					(= ticks 30)
				else
					(gEgo stopUpd:)
					(self setScript: (ScriptID 125 1) self) ; merryMenEntrance
				)
			)
			(6
				(if register
					((ScriptID 20) loop: 2 posn: 185 50 init: stopUpd:) ; Will
					((ScriptID 19) ; John
						loop: 0
						posn: 95 70
						setCycle: StopWalk 152
						init:
					)
					((ScriptID 23) loop: 1 posn: 240 125 init: stopUpd:) ; Tuck
					(gCast eachElementDo: #show)
					(gCurRoom drawPic: 120 -32759)
					(proc121_0)
					(= ticks 12)
				else
					(= ticks 30)
				)
			)
			(7
				(Face gEgo (ScriptID 19)) ; John
				((ScriptID 19) setMotion: PChase gEgo 40 self) ; John
			)
			(8
				(= ticks 30)
			)
			(9
				(= notKilled 1)
				(Converse 3 @local144 1 2 13 3 @local0 2 self) ; "What snake have you caught upon Watling Street, Master?"
			)
			(10
				(Converse 2 @local150 2 2 @local0 3 self) ; "I need no help to deal with you."
			)
			(11
				(Converse 1 @local155 1 0 self) ; "Leave us, lest he do some harm to the woman."
			)
			(12
				(if register
					((ScriptID 19) dispose:) ; John
					((ScriptID 20) dispose:) ; Will
					((ScriptID 23) dispose:) ; Tuck
					(gCurRoom drawPic: 803 -32759)
					(gCast eachElementDo: #hide)
					(= ticks 60)
				else
					(gEgo stopUpd:)
					((ScriptID 19) ; John
						setMotion: PolyPath -25 (- ((ScriptID 19) y:) 15) self ; John
					)
					((ScriptID 20) ; Will
						setMotion: MoveTo 335 (- ((ScriptID 20) y:) 10) self ; Will
					)
					((ScriptID 23) ; Tuck
						setMotion: MoveTo 335 ((ScriptID 23) y:) self ; Tuck
					)
				)
			)
			(13
				(if register
					(gCast eachElementDo: #show)
					(gCurRoom drawPic: 120 -32759)
					(proc121_0)
					(= ticks 12)
				)
			)
			(14
				(= ticks 6)
			)
			(15
				(Face gEgo theMan self)
			)
			(16
				((ScriptID 19) dispose:) ; John
				((ScriptID 20) dispose:) ; Will
				((ScriptID 23) dispose:) ; Tuck
				(= local29 1)
				(theMan startUpd:)
				(theWoman startUpd:)
				(HandsOn)
				(gTheIconBar disable: 5)
				(self dispose:)
			)
		)
	)
)

(instance shootSound of Sound
	(properties
		flags 1
	)
)

(instance screamSound of Sound
	(properties
		flags 1
		number 129
	)
)

